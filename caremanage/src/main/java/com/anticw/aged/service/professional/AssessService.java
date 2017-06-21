package com.anticw.aged.service.professional;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MAssessAnswer;
import com.anticw.aged.bean.MAssessConclusion;
import com.anticw.aged.bean.MAssessQuestion;
import com.anticw.aged.bean.MAssessRecord;
import com.anticw.aged.bean.MAssessRecordDetail;
import com.anticw.aged.bean.MAssessTable;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.professional.assess.AssessAnswerDao;
import com.anticw.aged.dao.professional.assess.AssessConclusionDao;
import com.anticw.aged.dao.professional.assess.AssessDao;
import com.anticw.aged.dao.professional.assess.AssessQuestionDao;
import com.anticw.aged.dao.professional.assess.AssessRecordDao;
import com.anticw.aged.dao.professional.assess.AssessRecordDetailDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.service.user.OCategoryItemService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.icare.MassessTableVO;
import com.anticw.aged.vo.professional.assess.AssessAnswerVO;
import com.anticw.aged.vo.professional.assess.AssessCluVO;
import com.anticw.aged.vo.professional.assess.AssessQuestionVO;
import com.anticw.aged.vo.professional.assess.AssessRecordAnswerVo;
import com.anticw.aged.vo.professional.assess.AssessRecordDetailVo;
import com.anticw.aged.vo.professional.assess.AssessRecordVo;
import com.anticw.aged.vo.professional.assess.AssessVO;
import com.anticw.aged.vo.professional.assess.AssesssRecordAnswerVo;
import com.anticw.aged.vo.professional.assess.AssesssRecordDetailVo;
import com.anticw.aged.vo.professional.assess.ConclusionVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.user.AssessUserVO;

/**
 * 评估量表业务逻辑处理类
 * <P>
 * File name : AssessService.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-10-1
 * </P>
 */
@Service
@Component
public class AssessService {

	/**
	 * 评估量表数据访问对象
	 */
	@Autowired
	private AssessDao assessDao;
	/**
	 * 获取答案建议
	 */
	@Autowired
	private AssessAnswerDao assessAnswerDao;
	/**
	 * 评估量表问题数据库访问对象
	 */
	@Autowired
	private AssessQuestionDao assessQuestionDao;

	/**
	 * 评估量表评价数据库访问对象
	 */
	@Autowired
	private AssessConclusionDao assessConclusionDao;

	/**
	 * 评估量表记录持久化对象
	 */
	@Autowired
	private AssessRecordDao assessRecordDao;

	/**
	 * 附件管理
	 */
	@Autowired
	private AttchmentHandle attchment;
	
	@Autowired
	private  OCategoryItemService oCategoryItemService;

	/**
	 * 评估答案存储持久化类
	 */
	@Autowired
	private AssessRecordDetailDao assessRecordDetailDao;

	/*********************************************************** 评估量表维护 *****************************************************************/

	/**
	 * 获取指定分页的记录数 AssessService.list()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param pageParamVo
	 * @return
	 */
	public Page<MAssessTable> listForAssess(PageParamVO... pageParamVo)
			throws BusinessException {
		if (pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		return assessDao
				.list(pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	
	/**
	 * 获取指定分页的记录页，包含指定索引页面
	 * @author DX 
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessTable> list(int page,int num,Integer itemId,String name,DateParamVO daVo) {
		return assessDao
				.list(page, num, itemId, name,daVo);
	}
	public Page<MassessTableVO> lists(int page,int num,Integer itemId,String name,DateParamVO daVo) throws IllegalAccessException, InvocationTargetException {
		Page<MAssessTable> pages= assessDao.list(page, num, itemId, name,daVo);
		List<MAssessTable> table=pages.getResult();
		List<MassessTableVO> vos=new ArrayList<MassessTableVO>();
		Page<MassessTableVO> pav=new Page<MassessTableVO>();
		MassessTableVO vo=null;
		for(MAssessTable t:table){
			vo=new MassessTableVO();
			BeanUtils.copyProperties(vo, t);
			if(t.getItemId()!=null){
				OCategoryItem o=oCategoryItemService.getItemName(t.getItemId());
				if(o!=null){
					vo.setItemName(o.getItemName());
				}
			}
			if(t.getRecommend()!=null){
				vo.setRecommend(t.getRecommend());
			}else{
				vo.setRecommend(false);
			}
			vos.add(vo);
		}
		pav.setResult(vos);
		pav.setPageNo(pages.getPageNo());
		pav.setPageSize(pages.getPageSize());
		return pav;
	}
	

	/**
	 * 获取评估量表信息 AssessService.getAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
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
		return assessVo;
	}

	/**
	 * 增加评估量表 AssessService.addAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @param userName
	 * @param pageParamVo
	 */
	public void addAssess(AssessVO vo, String userName,
			PageParamVO... pageParamVo) throws BusinessException {

		// 构建评估量表对象
		MAssessTable assess = new MAssessTable();
		assess.setType(vo.getType());
		assess.setName(vo.getName());
		assess.setDescr(vo.getDescr());
		assess.setCombIds("");
		assess.setPublishStatus(ProfessionalConstants.ASSESS_UNPUBLISH);
		assess.setAvailable(ProfessionalConstants.AVAILABLE);
		assess.setCreatedAt(new Date());
		assess.setCreatedBy(userName);
		assess.setChangedAt(new Date());
		assess.setChangedBy(userName);
		assess.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		assess.setRecommend(false);
		if(vo.getItemId()!=null&&vo.getItemId()!=-1){
			assess.setItemId(vo.getItemId());
		}
		// 保存对象
		assessDao.save(assess);
	}

	/**
	 * 编辑评估量表 AssessService.modifyAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @param userName
	 * @param pageParamVo
	 */
	public void modifyAssess(AssessVO vo, String userName,
			PageParamVO... pageParamVo) throws BusinessException {

		// 构建评估量表对象
		MAssessTable assess = assessDao.get(vo.getId());
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 不可以修改评类型
		if (!assess.getType().equals(vo.getType())) {
			throw new BusinessException(ExceptionCode.ASSESS_TYPE_UNABLE_MODIFY);
		}

		// 修改属性
		assess.setType(vo.getType());
		assess.setName(vo.getName());
		assess.setDescr(vo.getDescr());
		assess.setChangedAt(new Date());
		assess.setChangedBy(userName);
		if(vo.getItemId()!=null&&vo.getItemId()!=-1){
			assess.setItemId(vo.getItemId());
		}
		// 保存对象
		assessDao.update(assess);
	}

	/**
	 * 删除评估量表信息 删除一个分数型的评估量表要级联删除其下的问题、答案，结论信息； 删除一个组合型的评估量表要级联删除其下的结论信息；
	 * 删除一个分数型的评估量要检测所有引用它的组合型的评估量表并且做级联删除
	 * 由于时间紧迫，目前该方法逐级删除，使用spring进行事物控制，该方法需要后续优化 AssessService.deleteAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param assessId
	 * @throws BusinessException
	 */
	public void deleteAssess(int assessId, String userName)
			throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 逻辑删除
		assess.setAvailable(ProfessionalConstants.UNAVAILABLE);
		assess.setChangedBy(userName);
		assess.setChangedAt(new Date());
		assessDao.update(assess);

		// 如果是分数表的话需要级联删除问题和答案
		if (assess.getType() == ProfessionalConstants.ASSESS_TYPE_SCORE) {

			// 级联删除问题和答案
			List<MAssessQuestion> questions = assessQuestionDao.list(assessId);
			for (Iterator<MAssessQuestion> iter = questions.iterator(); iter
					.hasNext();) {
				MAssessQuestion question = iter.next();
				deleteAssessQa(question.getId(), userName);
			}

			// 删除的是分数表需要检测是否有组合表在引用它
			List<MAssessTable> assesses = assessDao
					.getAssessByType(ProfessionalConstants.ASSESS_TYPE_COMB);
			for (Iterator<MAssessTable> iter = assesses.iterator(); iter
					.hasNext();) {
				MAssessTable _assess = iter.next();
				deleteAssessComb(_assess.getId(), assessId, userName);
			}
		}

		// 删除结论
		List<MAssessConclusion> conclusion = assessConclusionDao.list(assessId);
		for (Iterator<MAssessConclusion> iter = conclusion.iterator(); iter
				.hasNext();) {
			MAssessConclusion clusion = iter.next();
			deleteAssessClu(clusion.getId(), userName);
		}
	}

	/**
	 * 发布评估量表 AssessService.publishAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param assessId
	 * @param userName
	 * @throws BusinessException
	 */
	public void publishAssess(int assessId, String userName)
			throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		if (assess.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			// 组合表没有试题不允许发布
			List<MAssessTable> qaTables = getAssesses(assessId);
			if (qaTables == null || qaTables.isEmpty()) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		} else {
			// 分数表没有试题不允许发布
			List<MAssessQuestion> qaList = assessQuestionDao.list(assessId);
			if ((qaList == null || qaList.isEmpty())) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		}

		// 没有结论不允许发布
		List<MAssessConclusion> cluList = assessConclusionDao.list(assessId);
		if (cluList == null || cluList.isEmpty()) {
			throw new BusinessException(
					ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_CLU);
		}

		// 更新发布状态
		assess.setPublishStatus(ProfessionalConstants.ASSESS_PUBLISH);
		assess.setChangedBy(userName);
		assess.setChangedAt(new Date());
		assessDao.update(assess);
	}
	
	/**
	 * 去除发布状态
	 * 
	 * @param assessId
	 * @param userName
	 * @throws BusinessException
	 */
	public void abolish(int assessId, String userName) throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		// 更新发布状态
		assess.setPublishStatus(ProfessionalConstants.ASSESS_UNPUBLISH);
		assess.setChangedBy(userName);
		assess.setChangedAt(new Date());
		assessDao.update(assess);
	}

	/*********************************************************** 评估量表问题及答案维护 *****************************************************************/

	/**
	 * 获取评估量表问题列表(分数题) AssessService.listForAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param assessId
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessQuestion> listForAssessQa(int assessId,
			PageParamVO... pageParamVo) throws BusinessException {
		if (pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		return assessQuestionDao.list(assessId, pageParamVo[0].getPage(),
				pageParamVo[0].getNum());
	}

	/**
	 * 获取评估量表问题列表(组合题) AssessService.listForAssessComb()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
	 * </P>
	 * 
	 * @param assessId
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessTable> listForAssessComb(int assessId,
			PageParamVO... pageParamVo) throws BusinessException {

		if (pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}

		// 获取评估量表信息
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 获取组合表下分数表的字符串
		String assessIdStr = assess.getCombIds();
		String[] assessIds = assessIdStr.split(",");

		return assessDao.list(pageParamVo[0].getPage(),
				pageParamVo[0].getNum(), assessIds);
	}

	/**
	 * 获取组合型评估量表下的分数表 AssessService.getAssesses()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
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
		List<MAssessTable> list= new ArrayList<MAssessTable>();
		for (int i = 0; i < assessIds.length; i++) {
			Integer id = Integer.valueOf(assessIds[i]);
			list.add(assessDao.getById(id));
		}
		return list;
	}

	/**
	 * 获取指定评估量表的问题及答案信息 AssessService.getAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
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
	 * 添加评估量表问题答案 AssessService.addAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @throws BusinessException
	 * @throws IOException
	 */
	public void addAssessQa(MultipartFile file, AssessQuestionVO vo,
			String userName) throws BusinessException, IOException {

		// 上传文件
		MultipartFile[] files = new MultipartFile[] { file };
		String[] fileUrl = attchment.upload(4, files);

		// 评估量表问题对象
		MAssessQuestion assessQuestion = new MAssessQuestion();
		assessQuestion.setAssessId(vo.getAssessId());
		assessQuestion.setContent(vo.getContent());
		if (fileUrl != null && fileUrl.length != 0) {
			assessQuestion.setPicture(fileUrl[0]);
		}
		assessQuestion.setAvailable(ProfessionalConstants.AVAILABLE);
		assessQuestion.setCreatedAt(new Date());
		assessQuestion.setCreatedBy(userName);
		assessQuestion.setChangedAt(new Date());
		assessQuestion.setChangedBy(userName);
		assessQuestion.setVersion(ProfessionalConstants.DEFAULT_VERSION);

		if (vo.getAssessType() == null) {
			vo.setAssessType(true);
		} else if (vo.getAssessType()) {
			vo.setAssessType(false);
		}
		assessQuestion.setAssessType(vo.getAssessType());

		// 评估量表答案对象
		Set<MAssessAnswer> anwsers = new HashSet<MAssessAnswer>();
		assessQuestion.setAssessAnswers(anwsers);

		// 循环赋值构建答案对象
		for (Iterator<AssessAnswerVO> iter = vo.getAnswers().iterator(); iter
				.hasNext();) {
			AssessAnswerVO _vo = iter.next();
			MAssessAnswer answer = new MAssessAnswer();
			answer.setConclusion(_vo.getAconclusion());
			answer.setCode(_vo.getCode());
			answer.setContent(_vo.getContent());
			answer.setScore(_vo.getScore());
			answer.setCreatedAt(new Date());
			answer.setCreatedBy(userName);
			answer.setChangedAt(new Date());
			answer.setChangedBy(userName);
			answer.setAvailable(ProfessionalConstants.AVAILABLE);
			answer.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			answer.setAssessQuestion(assessQuestion);
			anwsers.add(answer);
		}

		assessQuestionDao.save(assessQuestion);
	}

	/**
	 * 修改评估量表问题及答案 AssessService.modifyAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param file
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 * @throws IOException
	 */
	public void modifyAssessQa(MultipartFile file, AssessQuestionVO vo,
			String userName) throws BusinessException, IOException {

		// 获取评估量表信息
		MAssessQuestion assessQuestion = assessQuestionDao.get(vo.getId());

		// 问题不存在
		if (assessQuestion == null
				|| assessQuestion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_QA_NOT_FOUND);
		}

		// 上传文件
		MultipartFile[] files = new MultipartFile[] { file };
		String[] fileUrl = attchment.upload(4, files);
		if (fileUrl == null || fileUrl.length == 0) {
			fileUrl = new String[] { assessQuestion.getPicture() };
		}

		// 修改评估量表问题对象
		assessQuestion.setAssessId(vo.getAssessId());
		assessQuestion.setContent(vo.getContent());
		assessQuestion.setPicture(fileUrl[0]);
		assessQuestion.setChangedAt(new Date());
		assessQuestion.setChangedBy(userName);

		// 获取评估量表答案对象
		Set<MAssessAnswer> orignAnswers = assessQuestion.getAssessAnswers();

		// 原答案集合
		Map<Integer, MAssessAnswer> orignMap = new HashMap<Integer, MAssessAnswer>();
		for (Iterator<MAssessAnswer> iter = orignAnswers.iterator(); iter
				.hasNext();) {
			MAssessAnswer orignAnswer = iter.next();
			orignMap.put(orignAnswer.getId(), orignAnswer);
		}

		// 新提交的评估量表答案数据
		List<AssessAnswerVO> newAnswers = vo.getAnswers();

		// 新答案集合
		Map<Integer, AssessAnswerVO> newMap = new HashMap<Integer, AssessAnswerVO>();
		for (Iterator<AssessAnswerVO> iter = newAnswers.iterator(); iter
				.hasNext();) {
			AssessAnswerVO newAnswer = iter.next();
			newMap.put(newAnswer.getId(), newAnswer);
		}

		// 处理删除掉的商品
		for (Iterator<MAssessAnswer> iter = orignAnswers.iterator(); iter
				.hasNext();) {
			MAssessAnswer orignAnswer = iter.next();
			if (newMap.get(orignAnswer.getId()) == null) {
				orignAnswer.setAvailable(ProfessionalConstants.UNAVAILABLE);
				orignAnswer.setChangedAt(new Date());
				orignAnswer.setChangedBy(userName);
				// orignAnswer.setAssessQuestion(assessQuestion);
			}
		}

		// 构建新的待保存信息或者更新量表信息
		for (Iterator<AssessAnswerVO> iter = newAnswers.iterator(); iter
				.hasNext();) {

			// 新答案
			AssessAnswerVO newAnswer = iter.next();

			// 评估量表问题及答案对象(可能是新增也可能是修改)
			MAssessAnswer _answer = null;

			// 如果新的对象不包含对象标识信息则是新插入的数据，否则是可能产生修改的对象
			if (newAnswer.getId() == null || newAnswer.getId() == 0) {// 新插入数据
				_answer = new MAssessAnswer();
				_answer.setCode(newAnswer.getCode());
				_answer.setContent(newAnswer.getContent());
				_answer.setScore(newAnswer.getScore());
				_answer.setCreatedAt(new Date());
				_answer.setCreatedBy(userName);
				_answer.setChangedAt(new Date());
				_answer.setChangedBy(userName);
				_answer.setAvailable(ProfessionalConstants.AVAILABLE);
				_answer.setVersion(ProfessionalConstants.DEFAULT_VERSION);
				_answer.setAssessQuestion(assessQuestion);
				_answer.setConclusion(newAnswer.getAconclusion());
				orignAnswers.add(_answer);
			} else {// 可能产生修改的对象
				_answer = orignMap.get(newAnswer.getId());
				_answer.setCode(newAnswer.getCode());
				_answer.setContent(newAnswer.getContent());
				_answer.setScore(newAnswer.getScore());
				_answer.setChangedAt(new Date());
				_answer.setChangedBy(userName);
				_answer.setAssessQuestion(assessQuestion);
				_answer.setConclusion(newAnswer.getAconclusion());
			}
			// 只对修改数据保存至map
			newMap.put(newAnswer.getId(), newAnswer);
		}

		// 如果原有的答案对象在新的答案集合中不存在则认为进行了删除操作
		// for (Iterator<MAssessAnswer> iter = orignAnswers.iterator();
		// iter.hasNext();) {
		// MAssessAnswer orignAnswer = iter.next();
		// if (newMap.get(orignAnswer.getId()) == null) {
		// orignAnswer.setAvailable(ProfessionalConstants.UNAVAILABLE);
		// orignAnswer.setAssessQuestion(assessQuestion);
		// }
		// }

		// 更新数据
		assessQuestionDao.saveOrUpdate(assessQuestion);
	}

	/**
	 * 删除评估量表问题 AssessService.deleteAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessQaId
	 * @param userName
	 * @throws BusinessException
	 */
	public void deleteAssessQa(int assessQaId, String userName)
			throws BusinessException {

		// 获取评估量表信息
		MAssessQuestion assessQuestion = assessQuestionDao.get(assessQaId);

		// 问题不存在
		if (assessQuestion == null
				|| assessQuestion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_QA_NOT_FOUND);
		}

		// 问题设置无效
		assessQuestion.setAvailable(ProfessionalConstants.UNAVAILABLE);
		assessQuestion.setChangedBy(userName);
		assessQuestion.setChangedAt(new Date());

		// 级联删除问题
		Set<MAssessAnswer> answers = assessQuestion.getAssessAnswers();
		for (Iterator<MAssessAnswer> iter = answers.iterator(); iter.hasNext();) {
			MAssessAnswer answer = iter.next();
			answer.setAvailable(ProfessionalConstants.UNAVAILABLE);
		}

		// 更新数据
		assessQuestionDao.saveOrUpdate(assessQuestion);
	}

	/**
	 * 增加组合表的分数表Id AssessService.addAssessComb()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
	 * </P>
	 * 
	 * @param assessId
	 * @param assessIds
	 * @throws BusinessException
	 */
	public void addAssessComb(int assessId, List<Integer> assessIds)
			throws BusinessException {

		// 获取评估量表信息
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 获取组合表下分数表的字符串
		String assessIdStr = assess.getCombIds();

		// 拼接分数表的Id
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < assessIds.size(); i++) {
			sb.append(assessIds.get(i));
			if (i < assessIds.size() - 1) {
				sb.append(",");
			}
		}

		// 获得最终字符串
		if (!StringUtils.isEmpty(assessIdStr)) {
			assessIdStr = assessIdStr + "," + sb.toString();
		} else {
			assessIdStr = sb.toString();
		}

		// 更新数据
		assess.setCombIds(assessIdStr);
		assessDao.update(assess);
	}

	/**
	 * 删除组合表下的评估量表 AssessService.deleteAssessComb()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
	 * </P>
	 * 
	 * @param assessId
	 * @param subAssesId
	 * @param userName
	 * @throws BusinessException
	 */
	public void deleteAssessComb(int assessId, int subAssesId, String userName)
			throws BusinessException {

		// 获取评估量表信息
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		// 获取组合表下分数表的字符串
		String assessIdStr = assess.getCombIds();
		if (StringUtils.isEmpty(assessIdStr)) {
			return;
		}

		// 分数表Id数组
		String[] assessIds = assessIdStr.split(",");

		// 删除指定分数表后的集合
		List<String> _assessIds = new ArrayList<String>();

		// 填充-assessIds集合
		for (String _assessId : assessIds) {
			if (Integer.parseInt(_assessId) != subAssesId) {
				_assessIds.add(_assessId);
			}
		}

		// 拼接分数表的Id
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < _assessIds.size(); i++) {
			sb.append(_assessIds.get(i));
			if (i < _assessIds.size() - 1) {
				sb.append(",");
			}
		}

		// 更新数据
		assess.setCombIds(sb.toString());
		assessDao.update(assess);
	}

	/*********************************************************** 评估量表问题及答案维护 *****************************************************************/

	/**
	 * 获取评估量表结论列表 AssessService.assessCluList()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessId
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessConclusion> assessCluList(int assessId,
			PageParamVO... pageParamVo) throws BusinessException {
		if (pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		return assessConclusionDao.list(assessId, pageParamVo[0].getPage(),
				pageParamVo[0].getNum());
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
		if(assessConclusion.getComboIds()!=null){
			vo.setComboId(Integer.parseInt(assessConclusion.getComboIds()));
		}

		return vo;
	}

	/**
	 * 新增评估量表结论 AssessService.addAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param type
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	public Integer addAssessClu(short type, AssessCluVO vo, String userName)
			throws BusinessException {
		MAssessConclusion assessConclusion = new MAssessConclusion();
		assessConclusion.setAssessId(vo.getAssessId());
		assessConclusion.setStandard(vo.getStandard());
		assessConclusion.setContent(vo.getContent());
		assessConclusion.setCreatedAt(new Date());
		assessConclusion.setCreatedBy(userName);
		assessConclusion.setChangedAt(new Date());
		assessConclusion.setChangedBy(userName);
		assessConclusion.setAvailable(ProfessionalConstants.AVAILABLE);
		assessConclusion.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		if(vo.getComboId()!=null){
			assessConclusion.setComboIds(vo.getComboId().toString());
		}
		assessConclusionDao.save(assessConclusion);
		return assessConclusion.getId();
	}

	/**
	 * 更新评估量表结论 AssessService.modifyAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	public void modifyAssessClu(short type, AssessCluVO vo, String userName)
			throws BusinessException {

		// 获取评估量表结论信息
		MAssessConclusion assessConclusion = assessConclusionDao
				.get(vo.getId());

		// 判断结论数据是否存在
		if (assessConclusion == null
				|| assessConclusion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_CLU_NOT_FOUND);
		}

		// 更新数据
		assessConclusion.setStandard(vo.getStandard());
		assessConclusion.setContent(vo.getContent());
		assessConclusion.setChangedAt(new Date());
		assessConclusion.setChangedBy(userName);
		if(vo.getComboId()!=-1){
			assessConclusion.setComboIds(vo.getComboId()+"");
		}
		assessConclusionDao.saveOrUpdate(assessConclusion);
	}

	/**
	 * 删除评估量表数据 AssessService.deleteAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessCluId
	 * @param userName
	 * @throws BusinessException
	 */
	public void deleteAssessClu(int assessCluId, String userName)
			throws BusinessException {

		// 获取评估量表结论信息
		MAssessConclusion assessConclusion = assessConclusionDao
				.get(assessCluId);

		// 判断结论数据是否存在
		if (assessConclusion == null
				|| assessConclusion.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_CLU_NOT_FOUND);
		}

		// 更新数据
		assessConclusion.setAvailable(ProfessionalConstants.UNAVAILABLE);
		assessConclusion.setChangedAt(new Date());
		assessConclusion.setChangedBy(userName);
		assessConclusionDao.saveOrUpdate(assessConclusion);
	}

	/*********************************************************** 评估结果 ****************************************************************************/

	/**
	 * 获取评估结果 AssessService.getAssessRecords()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-13
	 * </P>
	 * 
	 * @param userId
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessRecord> getAssessRecords(Long userId,
			DateParamVO dateCond, PageParamVO pageCond)
			throws BusinessException {
		return assessRecordDao.gets(userId, dateCond.getStart(),
				dateCond.getEnd(), pageCond.getPage(), pageCond.getNum());
	}

	public List<MAssessRecord> getAssessRecord(Long userId, DateParamVO dateCond)
			throws BusinessException {
		return assessRecordDao.get(userId, dateCond.getStart(),
				dateCond.getEnd());
	}

	/**
	 * 添加评估结果。
	 * 
	 * @name AssessService.addAssessRecord()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午6:27:26
	 * @param assessRecordVo
	 * @param adminName
	 * @throws BusinessException
	 */
	public void addAssessRecord(AssessRecordVo assessRecordVo, String adminName)
			throws BusinessException {
		MAssessRecord assessRecord = new MAssessRecord();
		assessRecord.setAssessId(assessRecordVo.getAssessId());
		assessRecord.setAssessName(assessRecordVo.getAssessName());
		assessRecord.setConId(assessRecordVo.getConId());

		assessRecord.setConContent(assessRecordVo.getConContent());

		assessRecord.setUserId(assessRecordVo.getUserId());
		assessRecord.setCreatedAt(new Date());
		assessRecord.setCreatedBy(adminName);
		Long id = (Long) assessRecordDao.save(assessRecord);
		MAssessRecordDetail assessRecordDetail = new MAssessRecordDetail();
		assessRecordDetail.setRecordId(id);
		assessRecordDetail.setRecordDetail(assessRecordVo.getDetails());
		assessRecordDetailDao.save(assessRecordDetail);
	}

	/*********************************************************** 向其他模块开放的接口 *****************************************************************/

	/**
	 * 获取组合表可选择的分数表
	 * 
	 * @name AssessService.getQaAssessForCluAssess()
	 * @author zhoupeipei
	 * @Date 2014-10-20 下午10:40:01
	 * @param assessId
	 * @return
	 */
	public List<AssessVO> getQaAssessForCluAssess(int assessId) {
		MAssessTable mAssessTable = assessDao.get(assessId);
		List<AssessVO> assessVos = getAssessListByTypeAndStatus(
				ProfessionalConstants.ASSESS_PUBLISH,
				ProfessionalConstants.ASSESS_TYPE_SCORE);
		for (Iterator<AssessVO> iter = assessVos.iterator(); iter.hasNext();) {
			AssessVO qaAssess = iter.next();
			// 过滤掉组合表中已选择的分数表
			if (mAssessTable.getCombIds().indexOf(qaAssess.getId().toString()) != -1) {
				iter.remove();
			}
		}
		return assessVos;
	}

	/**
	 * 获取指定状态指定类型的评估量表
	 * 
	 * @name AssessService.getAssessListByTypeAndStatus()
	 * @author zhoupeipei
	 * @Date 2014-10-20 下午10:09:54
	 * @param status
	 * @param type
	 * @return
	 */
	public List<AssessVO> getAssessListByTypeAndStatus(boolean status,
			short type) {
		List<MAssessTable> tables = assessDao.list(status, type);
		// 返回值
		List<AssessVO> assessVos = new ArrayList<AssessVO>();

		// 获取全部评估量表
		if (tables == null || tables.isEmpty()) {
			return assessVos;
		}

		for (Iterator<MAssessTable> iter = tables.iterator(); iter.hasNext();) {
			MAssessTable assess = iter.next();
			AssessVO assessVo = new AssessVO();
			assessVo.setId(assess.getId());
			assessVo.setName(assess.getName());
			assessVo.setDescr(assess.getDescr());
			assessVos.add(assessVo);
		}
		return assessVos;
	}

	/**
	 * 获取全部评估量表 AssessService.getAllAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<AssessVO> getAllAssess(Integer type) throws BusinessException {

		// 返回值
		List<AssessVO> assessVos = new ArrayList<AssessVO>();
		List<MAssessTable> assesses = null;
		// 获取全部评估量表
		if (type != null && type == 2) {
			assesses = assessDao.getAllAssessType();
		} else {
			assesses = assessDao.getAllAssess();
		}

		if (assesses == null || assesses.isEmpty()) {
			return assessVos;
		}

		for (Iterator<MAssessTable> iter = assesses.iterator(); iter.hasNext();) {
			MAssessTable assess = iter.next();
			AssessVO assessVo = new AssessVO();
			assessVo.setId(assess.getId());
			assessVo.setName(assess.getName());
			assessVo.setDescr(assess.getDescr());
			assessVo.setType(assess.getType());
			assessVos.add(assessVo);
		}

		return assessVos;
	}

	/**
	 * 获取指定服务的评估量表
	 * 
	 * @name AssessService.getAssessByIds()
	 * @author zhoupeipei
	 * @Date 2014-10-16 下午11:07:24
	 * @param service
	 * @return
	 */
	public List<AssessVO> getAssessByIds(ServiceVO service) {
		// 返回值
		List<AssessVO> assessVos = new ArrayList<AssessVO>();

		if (service == null || service.getAssessIds() == null
				|| service.getAssessIds().isEmpty()) {
			return assessVos;
		}

		// 专业服务评估量表id列表
		List<Integer> assessIds = service.getAssessIds();
		String[] ids = new String[assessIds.size()];
		for (int i = 0; i < assessIds.size(); i++) {
			ids[i] = assessIds.get(i).toString();
		}
		List<MAssessTable> assesses = assessDao.getAssesses(ids);
		if (assesses == null || assesses.isEmpty()) {
			return assessVos;
		}

		for (Iterator<MAssessTable> iter = assesses.iterator(); iter.hasNext();) {
			MAssessTable assess = iter.next();
			AssessVO assessVo = new AssessVO();
			assessVo.setId(assess.getId());
			assessVo.setName(assess.getName());
			assessVo.setDescr(assess.getDescr());
			assessVo.setType(assess.getType());
			assessVos.add(assessVo);
		}

		return assessVos;
	}

	/**
	 * 获取评估量表评估数据信息,组合型评估量表返回组合的分数表详情
	 * 
	 * @name AssessService.getAssessRecordVoList()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午4:56:03
	 * @param assessId
	 * @return
	 * @throws BusinessException
	 */
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

		// 主表为组合型添加分数评估表详情
		if (assessVO.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			// 添加组合题结论
			addAssessQaAndClu(assessVO);
			assessVO.setAssessVOs(assessVos);
		} else {
			assessVO = assessVos.get(0);
		}

		return assessVO;
	}

	/**
	 * 添加评估量表详情--问题以及评论
	 * 
	 * @name AssessService.addAssessQaAndClu()
	 * @author zhoupeipei
	 * @Date 2014-10-20 下午9:49:20
	 * @param assessVO
	 * @throws BusinessException
	 */
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
			cluVOs.add(cluVO);
		}

		assessVO.setCluList(cluVOs);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List List1(List<AssessUserVO> vo1) {
		List li = new ArrayList();
		for (int j = 0; j < vo1.size(); j++) {
			List<AssessRecordAnswerVo> result = new ArrayList<AssessRecordAnswerVo>();
			JSONArray array = JSONObject.parseArray(vo1.get(j)
					.getRecordDetail());
			for(int a=0;a<array.size();a++){
			AssessRecordDetailVo assessRecordDetailVo = new AssessRecordDetailVo();
			JSONObject json = array.getJSONObject(a);
			assessRecordDetailVo.setConclusion(json.getString("conclusion"));
			JSONArray jsonArray = json.getJSONArray("result");
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject answerJson = jsonArray.getJSONObject(i);
					AssessRecordAnswerVo answerVo = new AssessRecordAnswerVo();
					answerVo.setQuestionName(answerJson.getString("question_name"));
					answerVo.setQuestionId(answerJson.getInteger("question_id"));
					answerVo.setAnswerName(answerJson.getString("answer_name"));
					answerVo.setAnswerId(answerJson.getString("answer_id"));
					answerVo.setCode(answerJson.getString("code"));
					answerVo.setScore(answerJson.getInteger("score"));
					result.add(answerVo);
				}
			assessRecordDetailVo.setResult(result);
			li.add(assessRecordDetailVo);
			}
		}
		return li;

	}

	/**
	 * 根据评估记录id获取评估答案
	 * 
	 * @param recordId
	 * @return
	 */
	public List<AssessRecordDetailVo> getAssessRecordDetailByRecordId(
			Long recordId) {
		MAssessRecordDetail detail = assessRecordDetailDao
				.getByRecordId(recordId);
		List<AssessRecordDetailVo> list = new ArrayList<AssessRecordDetailVo>();
		if (detail != null) {
			if (detail.getRecordDetail() == null
					|| "".equals(detail.getRecordDetail().trim())) {
			} else {
				JSONArray array = JSONObject.parseArray(detail
						.getRecordDetail());
				for (int j = 0; j < array.size(); j++) {
					List<AssessRecordAnswerVo> result = new ArrayList<AssessRecordAnswerVo>();
					AssessRecordDetailVo assessRecordDetailVo = new AssessRecordDetailVo();
					JSONObject json = array.getJSONObject(j);
					assessRecordDetailVo.setConclusion(json
							.getString("conclusion"));
					JSONArray jsonArray = json.getJSONArray("result");
					for (int i = 0; i < jsonArray.size(); i++) {
						JSONObject answerJson = jsonArray.getJSONObject(i);
						AssessRecordAnswerVo answerVo = new AssessRecordAnswerVo();
						answerVo.setQuestionName(answerJson
								.getString("question_name"));
						answerVo.setQuestionId(answerJson
								.getInteger("question_id"));
						answerVo.setAnswerName(answerJson
								.getString("answer_name"));
						answerVo.setAnswerId(answerJson.getString("answer_id"));
						answerVo.setCode(answerJson.getString("code"));
						answerVo.setScore(answerJson.getInteger("score"));
						result.add(answerVo);
					}
					assessRecordDetailVo.setResult(result);
					list.add(assessRecordDetailVo);
				}

			}
		}
		return list;

	}
	
	public  AssessRecordDetailVo getAssessRecordDetailBydetail(String detail){
		JSONArray array = JSONObject.parseArray(detail );
		AssessRecordDetailVo assessRecordDetailVo = new AssessRecordDetailVo();
		for (int j = 0; j < array.size(); j++) {
			List<AssessRecordAnswerVo> result = new ArrayList<AssessRecordAnswerVo>();
			JSONObject json = array.getJSONObject(j);
			assessRecordDetailVo.setConclusion(json
					.getString("conclusion"));
			JSONArray jsonArray = json.getJSONArray("result");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject answerJson = jsonArray.getJSONObject(i);
				AssessRecordAnswerVo answerVo = new AssessRecordAnswerVo();
				answerVo.setQuestionName(answerJson
						.getString("question_name"));
				answerVo.setQuestionId(answerJson
						.getInteger("question_id"));
				answerVo.setAnswerName(answerJson
						.getString("answer_name"));
				answerVo.setAnswerId(answerJson.getString("answer_id"));
				answerVo.setCode(answerJson.getString("code"));
				answerVo.setScore(answerJson.getInteger("score"));
				result.add(answerVo);
			}
			assessRecordDetailVo.setResult(result);
		}
		return assessRecordDetailVo;
	}
	
	
	
	/**
	 * 获取结论
	 * @param detail
	 * @return
	 */
	@SuppressWarnings("unused")
	public String getAssessRecordDetails(String detail) {
		JSONArray array = JSONObject.parseArray(detail );
		String s = null;
		for (int j = 0; j < array.size(); j++) {
			JSONObject json = array.getJSONObject(j);
			 s = json.getString("conclusion");
			break;
		}
		return s;
	}

	/**
	 * 根据选择获取报告详情
	 * 
	 * @param Ids
	 * @return
	 */
	public @ResponseBody JSONArray getAssessRecord(String Ids) {
		List<MAssessRecordDetail> mAssessRecordDetail = assessRecordDetailDao
				.getRecord(Ids);
		JSONArray jsonss = new JSONArray();
		for (MAssessRecordDetail detail : mAssessRecordDetail) {
			List<AssesssRecordDetailVo> list = new ArrayList<AssesssRecordDetailVo>();
			if (detail != null) {
				if (detail.getRecordDetail() == null
						|| "".equals(detail.getRecordDetail().trim())) {
				} else {
					JSONArray array = JSONObject.parseArray(detail
							.getRecordDetail());
					for (int j = 0; j < array.size(); j++) {
						List<AssesssRecordAnswerVo> result = new ArrayList<AssesssRecordAnswerVo>();
						AssesssRecordDetailVo assessRecordDetailVo = new AssesssRecordDetailVo();
						JSONObject json = array.getJSONObject(j);
						assessRecordDetailVo.setConclusion(json
								.getString("conclusion"));
						assessRecordDetailVo.setRecordId(detail.getRecordId());
						JSONArray jsonArray = json.getJSONArray("result");
						if(json.getString("assessName")!=null&&!"".equals(json.getString("assessName").trim())){
							assessRecordDetailVo.setAssessName(json.getString("assessName"));
						}
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject answerJson = jsonArray.getJSONObject(i);
							AssesssRecordAnswerVo answerVo = new AssesssRecordAnswerVo();
							answerVo.setQuestionName(answerJson
									.getString("question_name"));
							answerVo.setQuestionId(answerJson
									.getInteger("question_id"));
							answerVo.setAnswerName(answerJson
									.getString("answer_name"));
							answerVo.setAnswerId(answerJson
									.getString("answer_id"));
							answerVo.setCode(answerJson.getString("code"));
							answerVo.setScore(answerJson.getInteger("score"));
							if (answerJson.getString("answer_id") != null) {
								try {
									answerVo.setaConclusion(assessAnswerDao
											.getAssessAnswer(
													Integer.parseInt(answerJson
															.getString("answer_id")))
											.getConclusion());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							result.add(answerVo);
						}
						assessRecordDetailVo.setResult(result);
						list.add(assessRecordDetailVo);
					}
				}
			}
			JSONObject jsons = new JSONObject();
			jsons.put("list", list);
			jsonss.add(jsons);
		}
		return jsonss;
	}

	/**
	 * 根据评估记录id获取评估答案
	 */
	public List<ConclusionVO> getConclusion() {
		return assessRecordDetailDao.getConclusion();

	}

	@SuppressWarnings("rawtypes")
	public List getList(long userId, String year) {
		return assessRecordDao.getList(userId, year);
	}

	/**
	 * 获取指定评估量表的全部结论数据
	 * 
	 * @param assessId
	 * @return
	 */
	public List<MAssessConclusion> list(int assessId) {
		return assessConclusionDao.list(assessId);
	}
	
	/**
	 * 取消推荐
	 * @param assessId
	 * @param userName
	 * @throws BusinessException
	 */
	public void abRecommend(int assessId, String userName)
			throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		if (assess.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			// 组合表没有试题不允许发布
			List<MAssessTable> qaTables = getAssesses(assessId);
			if (qaTables == null || qaTables.isEmpty()) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		} else {
			// 分数表没有试题不允许发布
			List<MAssessQuestion> qaList = assessQuestionDao.list(assessId);
			if ((qaList == null || qaList.isEmpty())) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		}

		// 没有结论不允许发布
		List<MAssessConclusion> cluList = assessConclusionDao.list(assessId);
		if (cluList == null || cluList.isEmpty()) {
			throw new BusinessException(
					ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_CLU);
		}

		// 更新推荐状态
		assess.setRecommend(ProfessionalConstants.ASSESS_UNPUBLISH);
		assess.setChangedBy(userName);
		assess.setChangedAt(new Date());
		assessDao.update(assess);
	}
	
	
	/**
	 * 推荐量表
	 * @param assessId
	 * @param userName
	 * @throws BusinessException
	 */
	public void publishRecommend(int assessId, String userName)
			throws BusinessException {

		// 获取评估量表
		MAssessTable assess = assessDao.get(assessId);
		if (assess == null
				|| assess.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}

		if (assess.getType() == ProfessionalConstants.ASSESS_TYPE_COMB) {
			// 组合表没有试题不允许发布
			List<MAssessTable> qaTables = getAssesses(assessId);
			if (qaTables == null || qaTables.isEmpty()) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		} else {
			// 分数表没有试题不允许发布
			List<MAssessQuestion> qaList = assessQuestionDao.list(assessId);
			if ((qaList == null || qaList.isEmpty())) {
				throw new BusinessException(
						ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_QA);
			}
		}

		// 没有结论不允许发布
		List<MAssessConclusion> cluList = assessConclusionDao.list(assessId);
		if (cluList == null || cluList.isEmpty()) {
			throw new BusinessException(
					ExceptionCode.ASSESS_CAN_NOT_PUBLISHED_NO_CLU);
		}

		// 更新推荐状态
		assess.setRecommend(ProfessionalConstants.ASSESS_PUBLISH);
		assess.setChangedBy(userName);
		assess.setChangedAt(new Date());
		assessDao.update(assess);
	}
	
	/**
	 * 管家中获取类型下所有有效且被推荐的量表
	 * @param itemId
	 * @return
	 */
	public List<MAssessTable>  getList(Integer itemId){
		return assessDao.getList(itemId);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List List1(AssessUserVO vo1) {
		List li = new ArrayList();
			List<AssessRecordAnswerVo> result = new ArrayList<AssessRecordAnswerVo>();
			JSONArray array = JSONObject.parseArray(vo1.getRecordDetail());
			for(int a=0;a<array.size();a++){
			AssessRecordDetailVo assessRecordDetailVo = new AssessRecordDetailVo();
			JSONObject json = array.getJSONObject(a);
			assessRecordDetailVo.setConclusion(json.getString("conclusion"));
			JSONArray jsonArray = json.getJSONArray("result");
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject answerJson = jsonArray.getJSONObject(i);
					AssessRecordAnswerVo answerVo = new AssessRecordAnswerVo();
					answerVo.setQuestionName(answerJson.getString("question_name"));
					answerVo.setQuestionId(answerJson.getInteger("question_id"));
					answerVo.setAnswerName(answerJson.getString("answer_name"));
					answerVo.setAnswerId(answerJson.getString("answer_id"));
					answerVo.setCode(answerJson.getString("code"));
					answerVo.setScore(answerJson.getInteger("score"));
					result.add(answerVo);
				}
			assessRecordDetailVo.setResult(result);
			li.add(assessRecordDetailVo);
		}
		return li;

	}
}
