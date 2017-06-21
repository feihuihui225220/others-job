package com.anticw.aged.controller.professional;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MAssessConclusion;
import com.anticw.aged.bean.MAssessQuestion;
import com.anticw.aged.bean.MAssessTable;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.icare.combo.ComboService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.icare.MassessTableVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.assess.AssessCluVO;
import com.anticw.aged.vo.professional.assess.AssessQuestionVO;
import com.anticw.aged.vo.professional.assess.AssessVO;

/**
 * 评估量表相关请求控制器
 * <P>
 * File name : AssessCtl.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-9-21
 * </P>
 */
@Controller
public class AssessCtl {

	/**
	 * 评估量表业务逻辑处理类
	 */
	@Autowired
	private AssessService assessService;

	@Autowired
	private CategoryItemService categoryItemService;

	@Autowired
	private ComboService comboService;
	/*********************************************************** 评估量表维护 *****************************************************************/

	/**
	 * 获取评估量表列表 AssessCtl.assessList()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-9-21
	 * </P>
	 * 
	 * @param page
	 * @param num
	 * @return
	 */
	@RequestMapping(value = "/professional/assess")
	public ModelAndView assessList(PageParamVO pageParamVo, Integer itemId, String name, DateParamVO daVo)
			throws Exception {
		List<OCategoryItem> cit = categoryItemService.findListValue(124);
		Page<MassessTableVO> vo = assessService.lists(pageParamVo.getPage(), pageParamVo.getNum(), itemId, name, daVo);
		ModelAndView mv = new ModelAndView("professional/assess/assess");
		mv.addObject("page", vo);
		mv.addObject("cit", cit);
		mv.addObject("daVo", daVo);
		mv.addObject("name", name);
		mv.addObject("itemId", itemId);
		return mv;
	}

	/**
	 * 跳转至添加页面 AssessCtl.goAssessAddPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/add")
	public ModelAndView goAssessAddPage(PageParamVO pageParamVo) throws Exception {
		ModelAndView mv = new ModelAndView("professional/assess/assessInput");
		List<OCategoryItem> cit = categoryItemService.findListValue(124);
		mv.addObject("cit", cit);
		mv.addObject("page", pageParamVo);
		return mv;
	}

	/**
	 * 跳转至修改页面 AssessCtl.goAssessModifyPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/modify")
	public ModelAndView goAssessModifyPage(Integer assessId, PageParamVO pageParamVo) throws Exception {

		// 获取评估量表信息
		AssessVO vo = assessService.getAssess(assessId);
		List<OCategoryItem> cit = categoryItemService.findListValue(124);
		ModelAndView mv = new ModelAndView("professional/assess/assessInput");
		mv.addObject("cit", cit);
		mv.addObject("assess", vo);
		mv.addObject("page", pageParamVo);
		return mv;
	}

	/**
	 * 添加或修改评估量表 AssessCtl.addOrModifyAssess()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/commit")
	public ModelAndView addOrModifyAssess(HttpSession session, AssessVO vo, PageParamVO pageParamVo) throws Exception {

		// 自检
		vo.selfValidate();

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 增加或修改评估量表
		if (vo.getId() == null || vo.getId() == 0) {// 新增
			assessService.addAssess(vo, userName);
		} else {// 修改
			assessService.modifyAssess(vo, userName);
		}

		return assessList(pageParamVo, null, null, new DateParamVO());
	}

	/**
	 * 删除评估量表 AssessCtl.deleteAssess()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/delete")
	public ModelAndView deleteAssess(HttpSession session, Integer assessId, PageParamVO pageParamVo) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 删除评估量表
		assessService.deleteAssess(assessId, userName);

		return assessList(pageParamVo, null, null, new DateParamVO());
	}

	/**
	 * 发布评估量表 AssessCtl.publishAssess()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/publish")
	public ModelAndView publishAssess(HttpSession session, Integer assessId, PageParamVO pageParamVo) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 发布评估量表
		assessService.publishAssess(assessId, userName);

		return assessList(pageParamVo, null, null, new DateParamVO());
	}

	@RequestMapping(value = "/professional/assess/srecommend")
	public ModelAndView publishsetRecommend(HttpSession session, Integer assessId, PageParamVO pageParamVo,
			Integer recommend) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		if (recommend == 1)
			assessService.abRecommend(assessId, userName);
		else
			assessService.publishRecommend(assessId, userName);

		return assessList(pageParamVo, null, null, new DateParamVO());
	}

	/**
	 * 删除发布状态
	 * 
	 * @param session
	 * @param assessId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/abolish")
	public ModelAndView abolish(HttpSession session, Integer assessId, PageParamVO pageParamVo) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 发布评估量表
		assessService.abolish(assessId, userName);

		return assessList(pageParamVo, null, null, new DateParamVO());
	}

	/*********************************************************** 评估量表问题及答案维护 *****************************************************************/

	/**
	 * 获取评估量表问题列表 AssessCtl.assessQaList()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/qa")
	public ModelAndView assessQaList(Integer assessId, Short type, PageParamVO pageParamVo) throws Exception {

		// modelAndView
		ModelAndView mv = null;

		// 根据评估表类型获取不同的数据
		if (type == ProfessionalConstants.ASSESS_TYPE_SCORE || type == ProfessionalConstants.ASSESS_TYPE_SITE) {
			Page<MAssessQuestion> vo = assessService.listForAssessQa(assessId, pageParamVo);
			mv = new ModelAndView("professional/assess/assessQa");
			mv.addObject("type", type);
			mv.addObject("page", vo);
			mv.addObject("assessId", assessId);
		} else {
			Page<MAssessTable> vo = assessService.listForAssessComb(assessId, pageParamVo);
			mv = new ModelAndView("professional/assess/assessCb");
			mv.addObject("type", type);
			mv.addObject("page", vo);
			mv.addObject("assessId", assessId);
		}

		return mv;
	}

	/**
	 * 跳转至评估量表问题答案添加页面 AssessCtl.goAssessQaAdd()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/qa/add")
	public ModelAndView goAssessQaAdd(Integer assessId, Short type, PageParamVO pageParamVo) throws Exception {

		// modelAndView
		ModelAndView mv = null;

		// 根据评估表类型跳转至不同页面
		if (type == ProfessionalConstants.ASSESS_TYPE_SCORE || type == ProfessionalConstants.ASSESS_TYPE_SITE) {
			mv = new ModelAndView("professional/assess/assessQaInput");
			mv.addObject("type", type);
			mv.addObject("page", pageParamVo);
			mv.addObject("assessId", assessId);
		} else {

			// 获取还未选择的分数型评估量表
			List<AssessVO> vo = assessService.getQaAssessForCluAssess(assessId);

			mv = new ModelAndView("professional/assess/assessCbInput");
			mv.addObject("type", type);
			mv.addObject("assesses", vo);
			mv.addObject("page", pageParamVo);
			mv.addObject("assessId", assessId);
		}

		return mv;
	}

	/**
	 * 跳转至评估量表问题答案修改页面 AssessCtl.goAssessQaModify()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessId
	 * @param assessQaId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/qa/modify")
	public ModelAndView goAssessQaModify(Short type, Integer assessId, Integer assessQaId, PageParamVO pageParamVo)
			throws Exception {
		AssessQuestionVO vo = assessService.getAssessQa(assessId, assessQaId);
		ModelAndView mv = new ModelAndView("professional/assess/assessQaInput");
		mv.addObject("assessQa", vo);
		mv.addObject("page", pageParamVo);
		mv.addObject("assessId", assessId);
		mv.addObject("type", type);
		return mv;
	}

	/**
	 * 添加评估量表问题及答案 AssessCtl.addOrUpdateAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/qa/commit")
	public ModelAndView addOrUpdateAssessQa(HttpSession session,
			@RequestParam(value = "file", required = false) MultipartFile file, Short type, AssessQuestionVO vo,
			PageParamVO pageParamVo) throws Exception {

		// 自检
		vo.selfValidate();

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 根据评估表类型进行分别处理
		if (type == ProfessionalConstants.ASSESS_TYPE_SCORE || type == ProfessionalConstants.ASSESS_TYPE_SITE) {

			// 增加或修改评估量表问题及答案
			if (vo.getId() == null || vo.getId() == 0) {// 增加
				assessService.addAssessQa(file, vo, userName);
			} else {// 修改
				assessService.modifyAssessQa(file, vo, userName);
			}

		} else {

			// 增加组合表下的分数表
			if (vo.getAssessIds() != null && !vo.getAssessIds().isEmpty()) {
				assessService.addAssessComb(vo.getAssessId(), vo.getAssessIds());
			}
		}

		return assessQaList(vo.getAssessId(), type, pageParamVo);
	}

	/**
	 * 删除评估量表问题 AssessCtl.deleteAssessQa()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessQaId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/qa/delete")
	public ModelAndView deleteAssessQa(HttpSession session, Integer assessId, Integer assessQaId, Short type,
			PageParamVO pageParamVo) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 根据评估量表类型进行删除操作
		if (type == ProfessionalConstants.ASSESS_TYPE_SCORE) {

			// 删除评估量表问题及答案
			assessService.deleteAssessQa(assessQaId, userName);

		} else {

			// 删除组合表中某一个分数表的Id
			assessService.deleteAssessComb(assessId, assessQaId, "leo");
		}

		return assessQaList(assessId, type, pageParamVo);
	}

	/*********************************************************** 评估量表结论维护 *****************************************************************/

	/**
	 * 获取评估量表问题列表 AssessCtl.assessCluList()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/clu")
	public ModelAndView assessCluList(Integer assessId, Short type, PageParamVO pageParamVo) throws Exception {
		Page<MAssessConclusion> vo = assessService.assessCluList(assessId, pageParamVo);
		ModelAndView mv = new ModelAndView("professional/assess/assessClu");
		mv.addObject("assessId", assessId);
		mv.addObject("page", vo);
		mv.addObject("type", type);
		return mv;
	}

	/**
	 * 跳转至评估结论新增页 AssessCtl.goAssessCluAdd()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/clu/add")
	public ModelAndView goAssessCluAdd(Integer assessId, Short type, PageParamVO pageParamVo) throws Exception {
		ModelAndView mv = new ModelAndView("professional/assess/assessCluInput");
		mv.addObject("zCombo", comboService.getZComboAll());
		mv.addObject("type", type);
		mv.addObject("page", pageParamVo);
		AssessVO vo = assessService.getAssess(assessId);
		mv.addObject("assessId", assessId);
		mv.addObject("vo", vo);
		return mv;
	}

	/**
	 * 跳转至评估结论修改页 AssessCtl.goAssessCluModify()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-3
	 * </P>
	 * 
	 * @param assessId
	 * @param assessCluId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/clu/modify")
	public ModelAndView goAssessCluModify(Short type, Integer assessId, Integer assessCluId, PageParamVO pageParamVo)
			throws Exception {
		AssessCluVO vo = assessService.getAssessClu(type, assessId, assessCluId);
		ModelAndView mv = new ModelAndView("professional/assess/assessCluInput");
		mv.addObject("zCombo", comboService.getZComboAll());
		mv.addObject("assessClu", vo);
		mv.addObject("page", pageParamVo);
		mv.addObject("id", assessCluId);
		mv.addObject("assessId", assessId);
		mv.addObject("type", type);
		return mv;
	}

	/**
	 * 添加或修改评估量表问题及答案 AssessCtl.addOrUpdateAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-1
	 * </P>
	 * 
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/clu/commit")
	public ModelAndView addOrUpdateAssessClu(HttpSession session, AssessCluVO vo, Short type, PageParamVO pageParamVo)
			throws Exception {
		// 自检
		vo.selfValidate();

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		// 增加或修改评估量表问题及答案
		if (vo.getId() == null || vo.getId() == 0) {
			assessService.addAssessClu(type, vo, userName);
		} else {
			assessService.modifyAssessClu(type, vo, userName);
		}
		return assessCluList(vo.getAssessId(), type, pageParamVo);
	}

	/**
	 * 删除评估量表问题 AssessCtl.deleteAssessClu()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-2
	 * </P>
	 * 
	 * @param assessQaId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/assess/clu/delete")
	public ModelAndView deleteAssessClu(HttpSession session, Short type, Integer assessId, Integer assessCluId,
			PageParamVO pageParamVo) throws Exception {

		// 获取用户信息
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();

		// 删除评估量表问题及答案
		assessService.deleteAssessClu(assessCluId, userName);

		return assessCluList(assessId, type, pageParamVo);
	}

}
