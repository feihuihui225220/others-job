package com.anticw.aged.service.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessAnswer;
import com.anticw.aged.bean.MAssessConclusion;
import com.anticw.aged.bean.MAssessQuestion;
import com.anticw.aged.bean.MAssessTable;
import com.anticw.aged.bean.ZFitness;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.icare.combo.ZFitnessDao;
import com.anticw.aged.dao.professional.assess.AssessConclusionDao;
import com.anticw.aged.dao.professional.assess.AssessDao;
import com.anticw.aged.dao.professional.assess.AssessQuestionDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.icare.ZComboVO1;
import com.anticw.aged.vo.icare.ZFitnessVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.assess.AssessAnswerVO;
import com.anticw.aged.vo.professional.assess.AssessCluVO;
import com.anticw.aged.vo.professional.assess.AssessQuestionVO;
import com.anticw.aged.vo.professional.assess.AssessVO;

/**
 * 
 * @author DX-2016/12/15
 *
 */
@Service
public class ZFitnessService {

	@Autowired
	private ZFitnessDao zFitnessDao;
	
	@Autowired
	private AssessDao assessDao;
	
	@Autowired
	private AssessQuestionDao assessQuestionDao;
	
	@Autowired
	private AssessConclusionDao assessConclusionDao;
	
	@Autowired
	private FileHandle fileHandle;

	/**
	 * 添加体适能表
	 * <p>
	 * 微信端展示
	 * </p>
	 * 
	 * @param z
	 */
	public void save(ZFitness z, HttpSession session) {
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		z.setCreateBy(userVO.getName());
		z.setChangeBy(userVO.getName());
		Date d = new Date();
		z.setCreateAt(d);
		z.setChangeAt(d);
		z.setAvailable((short) 1);
		zFitnessDao.save(z);
	}
	/**
	 * 修改
	 * @param z
	 */
	public void update(ZFitness z) {
		ZFitness z1 = getById(z.getFId());
		if (z.getFName() != null) {
			z1.setFName(z.getFName());
		}
		if (z.getImgUrl() != null&& z.getImgUrl() !="") {
			z1.setImgUrl(z.getImgUrl());
		}
		if (z.getVideoUrl() != null&& z.getVideoUrl() !="") {
			try {
				fileHandle.removeVideo(z1.getVideoUrl());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			z1.setVideoUrl(z.getVideoUrl());
		}
		if (z.getMonad() != null) {
			z1.setMonad(z.getMonad());
		}
		z1.setChangeAt(new Date());
		zFitnessDao.update(z1);
	}
	/**
	 * 删除
	 * @param fId
	 * @return
	 */
	public Integer remove(Integer fId) {
		ZFitness z = getById(fId);
		int parentId=z.getParentId();
		z.setAvailable((short) 0);
		zFitnessDao.update(z);
		return parentId;
	}
	/**
	 * 根据Id获取
	 * @param fId
	 * @return
	 */
	public ZFitness getById(Integer fId) {
		return zFitnessDao.get(fId);
	}
	/**
	 * 获取所有类型+试题
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public List<ZFitnessVO> getList() throws IllegalAccessException,
			InvocationTargetException {
		List<ZFitness> zf = zFitnessDao.getList();
		List<ZFitnessVO> vos = new ArrayList<ZFitnessVO>();
		ZFitnessVO vo;
		for (ZFitness z : zf) {
			vo = new ZFitnessVO();
			BeanUtils.copyProperties(vo, z);
			List<ZFitness> zf1 = zFitnessDao.getChildList(z.getFId());
			vo.setChildZFitness(zf1);
			vos.add(vo);
		}
		return vos;
	}
	public List<ZFitness> getListz() throws IllegalAccessException,
	InvocationTargetException {
		List<ZFitness> zf = zFitnessDao.getList();
		return zf;
	}
	
	/**
	 * 获取类型下对应的试题
	 * @param parentId
	 * @return
	 */
	public List<ZFitness>getChildList(Integer parentId){
		return zFitnessDao.getChildList(parentId);
	}
	
	/*************************************评估量表报告************************************/
	public AssessVO getAssessVoList(int assessId) throws BusinessException {
		// 主表对象
		AssessVO assessVO = getAssess(assessId);

		// 分数型评估量表vo列表
		List<AssessVO> assessVos = new ArrayList<AssessVO>();

		// 分数型评估量表
		List<MAssessTable> assessTables = new ArrayList<MAssessTable>();
		if (assessVO.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			assessTables = getAssesses(assessId);
		} else {
			assessTables.add(assessDao.get(assessId));
		}

		// 构造评估量表问题答案以及评论vo信息
		for (Iterator<MAssessTable> iter = assessTables.iterator(); iter
				.hasNext();) {
			MAssessTable assess = iter.next();
			AssessVO aVo = getAssess(assess.getId());
			addAssessQaAndClu(aVo);
			assessVos.add(aVo);
		}

	/*	// 主表为组合型添加分数评估表详情
		if (assessVO.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			// 添加组合题结论
			addAssessQaAndClu(assessVO);
			assessVO.setAssessVOs(assessVos);
		} else {
			assessVO = assessVos.get(0);
		}
*/
		return assessVO;
	}
	
	/**
	 * 获取评估量表信息 AssessService.getAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * </P>
	 * 
	 * @param assessId
	 * @return
	 * @throws BusinessException
	 */
	public AssessVO getAssess(int assessId) throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 构建页面显示所需属性
		AssessVO assessVo = new AssessVO();
		assessVo.setId(assess.getId());
		assessVo.setType(assess.getType());
		assessVo.setName(assess.getName());
		assessVo.setDescr(assess.getDescr());
		if(assess.getItemId()!=null){
			assessVo.setItemId(assess.getItemId());
		}
		addAssessQaAndClu(assessVo);
		return assessVo;
	}
	
	
	/**
	 * 获取组合型评估量表下的分数表 AssessService.getAssesses()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * </P>
	 * 
	 * @param assessId
	 * @return
	 * @throws BusinessException
	 */
	public List<MAssessTable> getAssesses(int assessId)
			throws BusinessException {

		// 获取评估量表信息
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 获取组合表下分数表的字符串
		String assessIdStr = assess.getCombIds();
		String[] assessIds = assessIdStr.split(",");
		
		return assessDao.getAssesses(assessIds);
	}
	
	@Autowired
	private ComboService comboService;
	private void addAssessQaAndClu(AssessVO assessVO) throws BusinessException {

		List<AssessQuestionVO> qaVos = new ArrayList<AssessQuestionVO>();
		List<AssessCluVO> cluVOs = new ArrayList<AssessCluVO>();

		// 获取评估表全部问题
		List<MAssessQuestion> qas = assessQuestionDao.list(assessVO.getId());
		for (MAssessQuestion qa : qas) {
			AssessQuestionVO qaVo = getAssessQa(assessVO.getId(), qa.getId());
			qaVos.add(qaVo);
		}
		assessVO.setQaList(qaVos);

		List<MAssessConclusion> clus = assessConclusionDao.list(assessVO
				.getId());
		for (MAssessConclusion clu : clus) {
			AssessCluVO cluVO = getAssessClu(assessVO.getType(),
					assessVO.getId(), clu.getId());
			if(clu.getComboIds()!=null&&clu.getComboIds()!=""){
				try {
					ZComboVO1	z=comboService.getVO1(Integer.parseInt(clu.getComboIds()));
					cluVO.setComboId(z.getComboId());
					cluVO.setComboName(z.getComboName());
					if(z.getImgUrl()!=null&&z.getImgUrl()!=""){
						cluVO.setComboImgUrl(z.getImgUrl());
					}
				} catch (NumberFormatException | IllegalAccessException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			cluVOs.add(cluVO);
		}
		 
		assessVO.setCluList(cluVOs);

	}
	
	/**
	 * 获取指定评估量表的问题及答案信息 AssessService.getAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * </P>
	 * 
	 * @param assessId
	 * @param assessQaId
	 * @return
	 * @throws BusinessException
	 */
	public AssessQuestionVO getAssessQa(int assessId, int assessQaId)
			throws BusinessException {

		// 获取评估量表信息
		MAssessQuestion assessQuestion = assessQuestionDao.get(assessQaId);

		// 问题不存在
		if (assessQuestion == null
				|| assessQuestion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_QA_NOT_FOUND);
		}

		// 答案集合
		List<AssessAnswerVO> answers = new ArrayList<AssessAnswerVO>();

		// 问题及答案对象
		AssessQuestionVO assessQuestionVo = new AssessQuestionVO();
		assessQuestionVo.setId(assessQuestion.getId());
		assessQuestionVo.setAssessId(assessQuestion.getAssessId());
		assessQuestionVo.setContent(assessQuestion.getContent());
		assessQuestionVo.setAnswers(answers);
		assessQuestionVo.setPicture(assessQuestion.getPicture());
		// 添加问题样式
		assessQuestionVo.setAssessType(assessQuestion.getAssessType());
		for (Iterator<MAssessAnswer> iter = assessQuestion.getAssessAnswers()
				.iterator(); iter.hasNext();) {
			MAssessAnswer answer = iter.next();
			AssessAnswerVO assessAnswerVo = new AssessAnswerVO();
			assessAnswerVo.setId(answer.getId());
			assessAnswerVo.setCode(answer.getCode());
			assessAnswerVo.setContent(answer.getContent());
			assessAnswerVo.setScore(answer.getScore());
			assessAnswerVo.setAconclusion(answer.getConclusion());

			answers.add(assessAnswerVo);
		}

		return assessQuestionVo;
	}

	/**
	 * 获取评估量表结论数据 AssessService.getAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
	 * </P>
	 * 
	 * @param assessId
	 * @param assessCluId
	 * @return
	 * @throws BusinessException
	 */
	public AssessCluVO getAssessClu(short type, int assessId, int assessCluId)
			throws BusinessException {

		// 获取评估量表结论信息
		MAssessConclusion assessConclusion = assessConclusionDao
				.get(assessCluId);

		// 判断结论数据是否存在
		if (assessConclusion == null
				|| assessConclusion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_CLU_NOT_FOUND);
		}

		// 构建评估结论对象
		AssessCluVO vo = new AssessCluVO();
		vo.setId(assessConclusion.getId());
		vo.setAssessId(assessConclusion.getAssessId());
		vo.setType(type);
		vo.setStandard(assessConclusion.getStandard());
		vo.setContent(assessConclusion.getContent());
		if (type == ProfessionalConstants.ASSESS_TYPE_SCORE
				|| type == ProfessionalConstants.ASSESS_TYPE_SITE) {
			String[] standards = assessConclusion.getStandard().split("-");
			vo.setLowerLimit(Integer.valueOf(standards[0]));
			vo.setUpperLimit(Integer.valueOf(standards[1]));
		}

		return vo;
	}
}
