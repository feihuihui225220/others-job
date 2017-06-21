package com.anticw.aged.controller.professional;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MAssessGds;
import com.anticw.aged.bean.MAssessRecord;
import com.anticw.aged.bean.MMessage;
import com.anticw.aged.bean.MPlan;
import com.anticw.aged.bean.MPlanCategory;
import com.anticw.aged.bean.MReport;
import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.MVenderEvaluation;
import com.anticw.aged.bean.MVenderService;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RReport;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.PlanCategoryService;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.service.professional.MAssessGdsService;
import com.anticw.aged.service.professional.MPlanService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.RReportSrevice;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.service.professional.data.server.MetaDataService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.service.user.OCategoryItemService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.care.MPlanCategoryVO;
import com.anticw.aged.vo.care.ReportVo;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.NActivityPlanVO1;
import com.anticw.aged.vo.professional.assess.AssessRecordDetailVo;
import com.anticw.aged.vo.professional.assess.AssessRecordVo;
import com.anticw.aged.vo.professional.assess.AssessVO;
import com.anticw.aged.vo.professional.assess.ConclusionVO;
import com.anticw.aged.vo.professional.meta.DataModuleVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.professional.vender.InputInfoVO;
import com.anticw.aged.vo.professional.vender.MPlanVO;
import com.anticw.aged.vo.professional.vender.MVenderSiteVO;
import com.anticw.aged.vo.professional.vender.MVenderUsersVO;
import com.anticw.aged.vo.professional.vender.RUserVo;
import com.anticw.aged.vo.professional.vender.VenderDistrVO;
import com.anticw.aged.vo.professional.vender.VenderEvaVO;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.professional.vender.VenderVO;
import com.anticw.aged.vo.professional.vender.alarm.AlarmSetVO;
import com.anticw.aged.vo.professional.vender.state.MobileStateVo;
import com.anticw.aged.vo.professional.vender.state.StateParamVO;
import com.anticw.aged.vo.professional.vender.state.StateQueryResultVO;
import com.anticw.aged.vo.professional.vender.state.StateVO;

/**
 * 专业服务商请求处理 包含专业服务商相关的各种操作： 状态维护、实时消息、服务计划、服务报告
 * <P>
 * File name : VenderCtl.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-10-5
 * </P>
 */
@Controller
public class VenderCtl {

	private static Logger logger = LoggerFactory.getLogger(VenderCtl.class);

	@Autowired
	private MVenderSiteService mVenderSiteService;
	
	@Autowired
	private MAssessGdsService mAssessGdsService; 
	/**
	 * 用于处理日期格式的绑定 VenderCtl.initBinder()<BR>
	 */
	// @InitBinder
	// protected void initBinder(HttpServletRequest request,
	// ServletRequestDataBinder binder) throws Exception {
	// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	// CustomDateEditor editor = new CustomDateEditor(df, false);
	// binder.registerCustomEditor(Date.class, editor);
	// }

	/************************************************************************ 专业服务商管理 *********************************************************************/

	/**
	 * 专业服务商
	 */
	@Autowired
	private VenderService venderService;
	/**
	 * 老人基本信息
	 */
	@Autowired
	private RUserService rUserService;
	/**
	 * 计划任务
	 */
	@Autowired
	private MPlanService mPlanService;
	/**
	 * 专业服务计划分类
	 */
	@Autowired
	private PlanCategoryService planCategoryService;
	/**
	 * 获取社区信息
	 */
	@Autowired
	private OCountryService oCountryService;
	/**
	 * 加载内容项
	 */
	@Autowired
	private OCategoryItemService oCategoryItemService;

	/**
	 * 获取专业服务商列表 VenderCtl.listVenders()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param session
	 * @param venderName
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/list")
	public ModelAndView listVenders(HttpSession session, String venderName,
			PageParamVO pageCond) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String name = userVo.getName();
		/*
		 * // 创建该服务商的name String cmName = null; if (userVo.isSuper_()) { cmName
		 * = userVo.getName(); } else { // 该处需要获取父级Id cmName =
		 * userVo.getParentName(); }
		 */
		// String communityIds = userVo.getCommunityId();
		// 获取服务商列表
		Page<VenderVO> venders = venderService.listVendersByCreatedBy(name,
				venderName, pageCond);

		ModelAndView mv = new ModelAndView("/professional/vender/cm/list");
		mv.addObject("page", venders);
		mv.addObject("pageCond", pageCond);
		mv.addObject("venderName", venderName);
		return mv;
	}

	/**
	 * 跳转至添加专业服务商页面 VenderCtl.toAddVenderPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/add")
	public ModelAndView toAddVenderPage(HttpSession session, String idCardNo)
			throws Exception {
		// 专业服务列表 用于选择资质
		@SuppressWarnings("unused")
		List<ServiceVO> services = this.specService.getServicesBrief();
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv;
		if (venderService.getAUserID(idCardNo) != null) {
			MVender m = new MVender();
			AUser a = venderService.getAUserID(idCardNo);
			MVender mven = venderService.getVender(a.getVenderId());
			// m.setCategoryId(mven.getCategoryId());
			m.setCmName(userVo.getName());
			m.setUserId(mven.getUserId());
			m.setName(mven.getName());
			m.setStar(mven.getStar());
			m.setContactPhone(mven.getContactPhone());
			m.setContactAddr(mven.getContactAddr());
			m.setContact(mven.getContact());
			m.setIntroduction(mven.getIntroduction());
			m.setCommunityIds(mven.getCommunityIds());
			m.setCreatedBy(userVo.getName());
			m.setCreatedAt(new Date());
			m.setChangedBy(userVo.getName());
			m.setChangedAt(new Date());
			venderService.save(m);
			mv = new ModelAndView(new RedirectView("/professional/vender/list"));
		} else {
			mv = new ModelAndView("/professional/vender/cm/add");
		}
		// 专业服务分类信息 用于选择服务分类
		// List<OCategoryItem> catItems =
		// categoryItemService.findListValue(CategoryEnum.PROSER.getIndex());
		// mv.addObject("services", services);
		// mv.addObject("catItems", catItems);
		return mv;
	}

	/**
	 * 跳转至专业服务商详情页 VenderCtl.toVenderDetailPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/detail")
	public ModelAndView toVenderDetailPage(Integer venderId) throws Exception {
		VenderVO venderVO = venderService.getVenderVo(venderId);
		ModelAndView mv = new ModelAndView("/professional/vender/cm/detail");
		mv.addObject("venderVO", venderVO);
		return mv;

	}

	/**
	 * 保存或更新服务商信息 VenderCtl.addVender()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param session
	 * @param venderVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/commit")
	public ModelAndView addVender(HttpSession session, VenderVO venderVo)
			throws Exception {

		// 自检
		venderVo.selfValidate();

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 创建该服务商的name
		String cmName = null;
		if (userVo.isSuper_()) {
			cmName = userVo.getName();
		} else {
			// 该处需要获取父级Id
			cmName = userVo.getParentName();
		}

		// 增加服务商
		venderService.addVender(cmName, venderVo, userVo.getName(),
				userVo.getCommunityId());

		return listVenders(session, null, new PageParamVO());
	}

	/**
	 * 标签 -- 服务商详情页 VenderCtl.toTabDetail()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/detail")
	public ModelAndView toTabDetail(Integer venderId) throws Exception {
		VenderVO venderVO = venderService.getVenderVo(venderId);
		ModelAndView mv = new ModelAndView("/professional/vender/cm/tab_detail");
		mv.addObject("venderVO", venderVO);
		return mv;
	}

	/**
	 * 标签 -- 服务商修改页面 VenderCtl.toTabModifyPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/modify")
	public ModelAndView toTabModifyPage(Integer venderId) throws Exception {
		VenderVO venderVO = venderService.getVenderVo(venderId);
		ModelAndView mv = new ModelAndView("/professional/vender/cm/tab_modify");
		mv.addObject("venderVO", venderVO);
		return mv;
	}

	/**
	 * 提交对服务商的信息修改 VenderCtl.commitModify()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param session
	 * @param venderVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/modify/commit")
	public ModelAndView commitModify(HttpSession session, VenderVO venderVo)
			throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 修改信息
		venderService.commitModify(venderVo, userVo.getName());

		return toTabDetail(venderVo.getId());
	}

	/**
	 * 跳转至评价页面 VenderCtl.toTabEva()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/eva")
	public ModelAndView toTabEva(Integer venderId) throws Exception {
		// 默认 返回当月首页数据
		DateParamVO dateCond = new DateParamVO(
				DateUtil.getFirstDayInMonth(new Date()),
				DateUtil.getLastDayInMonth(new Date()));
		PageParamVO pageCond = new PageParamVO();
		Page<MVenderEvaluation> venderEvaluations = venderService
				.queryVenderEvaluations(venderId, dateCond, pageCond);
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_evaluation");
		mv.addObject("venderId", venderId);
		mv.addObject("page", venderEvaluations);
		mv.addObject("pageCond", pageCond);
		mv.addObject("dateCond", dateCond);
		return mv;
	}

	/**
	 * 评价查询 VenderCtl.queryVenderEva()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/eva/query")
	public ModelAndView queryVenderEva(Integer venderId, DateParamVO dateCond,
			PageParamVO pageCond) throws Exception {
		Page<MVenderEvaluation> venderEvaluations = venderService
				.queryVenderEvaluations(venderId, dateCond, pageCond);
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_evaluation");
		mv.addObject("page", venderEvaluations);
		mv.addObject("pageCond", pageCond);
		mv.addObject("dateCond", dateCond);
		mv.addObject("venderId", venderId);
		return mv;
	}

	/**
	 * 评价详情页 VenderCtl.toVenderEvaDetail()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param evaId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/eva/{venderId}/{evaId}")
	public ModelAndView toVenderEvaDetail(@PathVariable Integer venderId,
			@PathVariable Integer evaId) throws Exception {
		MVenderEvaluation venderEvaluation = venderService
				.queryVenderEvaluation(venderId, evaId);
		VenderVO venderVO = venderService.getVenderVo(venderId);
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_eva_detail");
		mv.addObject("venderEvaluation", venderEvaluation);
		mv.addObject("venderName", venderVO.getName());
		mv.addObject("star", venderVO.getStar());
		return mv;
	}

	/**
	 * 跳转至评价增加页面 VenderCtl.toVenderEvaPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/eva/add")
	public ModelAndView toVenderEvaAddPage(Integer venderId) throws Exception {
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_eva_input");
		mv.addObject("venderId", venderId);
		return mv;
	}

	/**
	 * 统计数据或提交评价 VenderCtl.addVenderEva()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param type
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/eva/commit")
	public ModelAndView addVenderEva(HttpSession session, Integer type,
			VenderEvaVO vo) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 统计或提交数据
		venderService.calcOrAddVenderEva(type, vo, userVo.getName());

		// 根据类型进行跳转
		if (type == 0) {
			ModelAndView mv = new ModelAndView(
					"/professional/vender/cm/tab_eva_input");
			mv.addObject("venderId", vo.getVenderId());
			mv.addObject("venderEvaVO", vo);
			mv.addObject("type", "3");
			return mv;
		} else {
			return queryVenderEva(vo.getVenderId(),
					new DateParamVO(vo.getStartTime(), vo.getEndTime()),
					new PageParamVO());
		}
	}

	@Autowired
	private MUserVenderService mUserVenderService;

	/**
	 * 服务用户列表
	 * 
	 * @author guoyongxiang Date: 2014-10-18 下午4:56:00
	 * @param session
	 * @param pageVO
	 * @param name
	 * @param idCard
	 * @param status
	 * @return
	 */
	/* @RequestMapping("/professional/vender/sevUsers")
	public ModelAndView venderSevUserPage(HttpSession session,
			PageParamVO pageVO, MUserVender mUserVender, MVenderSiteVO m) {
		logger.debug("into method venderSevUserPage.");
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<OCountry> oCountry = oCountryService.getCountryByIds(userVO
				.getCommunityId());
		ModelAndView mv;

		if (!userVO.isSuper_()) {
			Map<Integer, String> oCountry1 = new HashMap<Integer, String>();
			Map<String, Integer> oCountry2 = new HashMap<String, Integer>();
			for (OCountry o : oCountry) {
				oCountry1.put(o.getId(), o.getName());
				oCountry2.put(o.getName(), o.getId());
			}
			mv = new ModelAndView("/professional/vender/sevUsersStaff");
			if (mUserVender.getCommunityName() != null
					&& mUserVender.getCommunityName() != "") {
				mUserVender.setCommunityName(oCountry2.get(
						mUserVender.getCommunityName()).toString());
			}
			Page<MVenderUsersVO> page = mUserVenderService
					.getNormalUsersByPage(userVO.getId(), pageVO.getPage(),
							pageVO.getNum(), mUserVender, m.getSiteId());
			String Ids = venderService.getAUser((int) userVO.getId())
					.getSiteIds();
			mv.addObject("mVenderSite", mVenderSiteService.findByIds(Ids));
			mv.addObject("oCountry1", oCountry1);
			mv.addObject("page", page);
		} else {
			mv = new ModelAndView("/professional/vender/sevUsers");
			if (mUserVender.getCommunityName() != null
					&& mUserVender.getCommunityName() != "") {
				mv.addObject("communityName", mUserVender.getCommunityName());
			}

			mv.addObject("allocation", mUserVender.getAllocation());
			Page<VenderServUserVO> page = mUserVenderService
					.getNormalUsersByPage(userVO.getVenderId(),
							pageVO.getPage(), pageVO.getNum(), mUserVender,
							userVO.getName());

			mv.addObject("page", page);
			mv.addObject("mVenderSite",
					mVenderSiteService.fingByVenderId(userVO.getVenderId()));
		}

		mv.addObject("siteId", m.getSiteId());
		mv.addObject("oCountry", oCountry);
		return mv;
	}  */
	/**
	 * 目前正式库不用
	 *
	 * 服务用户列表
	 * @author guoyongxiang Date: 2014-10-18 下午4:56:00
	 * @param session
	 * @param pageVO
	 * @param name
	 * @param idCard
	 * @param status
	 * @return
	 */
	@RequestMapping("/professional/vender/sevUsers")
	public ModelAndView venderSevUserPage(HttpSession session,
			PageParamVO pageVO, MUserVender mUserVender, MVenderSiteVO m,String siteIds) {
		logger.debug("into method venderSevUserPage.");
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<OCountry> oCountry = oCountryService.getCountryByIds(userVO
				.getCommunityId());
		ModelAndView mv;

		if (!userVO.isSuper_()) {
			Map<Integer, String> oCountry1 = new HashMap<Integer, String>();
			Map<String, Integer> oCountry2 = new HashMap<String, Integer>();
			for (OCountry o : oCountry) {
				oCountry1.put(o.getId(), o.getName());
				oCountry2.put(o.getName(), o.getId());
			}
			mv = new ModelAndView("/professional/vender/sevUsersStaff");
			if (mUserVender.getCommunityName() != null
					&& mUserVender.getCommunityName() != "") {
				mUserVender.setCommunityName(oCountry2.get(
						mUserVender.getCommunityName()).toString());
			}
			Page<MVenderUsersVO> page = mUserVenderService
					.getNormalUsersByPage(userVO.getId(), pageVO.getPage(),
							pageVO.getNum(), mUserVender, m.getSiteId());
			String Ids = venderService.getAUser((int) userVO.getId())
					.getSiteIds();
			mv.addObject("mVenderSite", mVenderSiteService.findByIds(Ids));
			mv.addObject("oCountry1", oCountry1);
			mv.addObject("page", page);
		} else {
			mv = new ModelAndView("/professional/vender/sevUsers");
			if (mUserVender.getCommunityName() != null
					&& mUserVender.getCommunityName() != "") {
				mv.addObject("communityName", mUserVender.getCommunityName());
			}

			mv.addObject("allocation", mUserVender.getAllocation());
			Page<VenderServUserVO> page = mUserVenderService
					.getMUserVenderPage(userVO.getVenderId(),
							pageVO.getPage(), pageVO.getNum(), mUserVender,
							userVO.getName(),siteIds);

			mv.addObject("page", page);
			mv.addObject("mVenderSite",
					mVenderSiteService.fingByVenderId(userVO.getVenderId()));
		}

		mv.addObject("siteId", siteIds);
		mv.addObject("oCountry", oCountry);
		mv.addObject("allocation", mUserVender.getAllocation());
		return mv;
	}
	
	/**
	 * 服务用户列表
	 * 
	 * @author guoyongxiang Date: 2014-10-19 下午8:39:31
	 * @param session
	 * @param name
	 * @param idCard
	 * @param callback
	 * @return
	 */
	@RequestMapping("/professional/vender/mobile/sevUsers")
	public @ResponseBody String venderSevUser(HttpSession session, String name,
			String idCard, String callback) {
		logger.debug("into method venderSevUser.");
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<VenderServUserVO> voList = null;
		try {
			voList = this.venderService.getSevUsers(userVO.isSuper_(),
					(int) userVO.getId(), name, idCard,
					userVO.getCommunityId(), userVO.getVenderId(),
					ProfessionalConstants.VENDER_USER_DIS_ALL);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户列表失败 manager=" + userVO.getName() + ",name="
					+ name + ",idCard=" + idCard, e);
			return PublicService.returnJSONP(ExceptionCode.FAILED, callback);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, voList,
				callback);
	}

	@Autowired
	private RUserService userService;

	/**
	 * 去添加普通用户 dx
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/addUser")
	public ModelAndView getModelAndView(HttpSession session, RUser r)
			throws Exception {
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("/professional/addUser/addUser");
		if (userVO.getCateEnum() == UserCategoryEnum.PRO) {
			List<MVenderSite> mVenderSiteList = mVenderSiteService
					.fingByVenderId(userVO.getVenderId());
			mv.addObject("mVenderSiteList", mVenderSiteList);
			if (r.getId() != null) {
				MUserVender m = mUserVenderService.getMUserVender(r.getId(),
						userVO.getVenderId());
				mv.addObject("mUserVender", m);
			}
		}
		if (r.getId() != null) {
			RUser user = userService.findById(r.getId());
			mv.addObject("user", user);
		}
		mv.addObject("categorys", springDataPool.getOCategory());
		
		return mv;
	}

	/**
	 * 获取该服务商服务的用户列表 VenderCtl.listVenderUsers()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/users")
	public ModelAndView listVenderUsers(HttpSession session, Integer venderId,
			PageParamVO pageCond) throws Exception {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		MUserVender mUserVender = new MUserVender();
		Page<VenderServUserVO> page = mUserVenderService.getNormalUsersByPage(
				venderId, pageCond.getPage(), pageCond.getNum(), mUserVender,
				userVo.getName());
		ModelAndView mv = new ModelAndView("/professional/vender/cm/tab_users");
		mv.addObject("page", page);
		mv.addObject("venderId", venderId);
		mv.addObject("pageCond", pageCond);
		return mv;
	}

	/**
	 * 获取服务列表页面 VenderCtl.listVenderServiceItems()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/service")
	public ModelAndView listVenderServiceItems(Integer venderId)
			throws Exception {
		List<MVenderService> services = venderService
				.getVenderServices(venderId);
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_servitems");
		mv.addObject("services", services);
		mv.addObject("venderId", venderId);
		return mv;
	}

	/**
	 * 跳转至服务添加页面 VenderCtl.toAddVenderServicePage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/service/add")
	public ModelAndView toAddVenderServicePage(Integer venderId)
			throws Exception {
		List<ServiceVO> services = venderService.getUnCheckServices(venderId);
		ModelAndView mv = new ModelAndView(
				"/professional/vender/cm/tab_servitems_input");
		mv.addObject("services", services);
		mv.addObject("venderId", venderId);
		return mv;
	}

	/**
	 * 添加服务项目 VenderCtl.toAddVenderServicePage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-16
	 * </P>
	 * 
	 * @param request
	 * @param venderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/tab/service/commit")
	public ModelAndView toAddVenderServicePage(HttpServletRequest request,
			Integer venderId) throws Exception {
		String[] serviceIds = request.getParameterValues("serviceId");
		if (serviceIds != null && serviceIds.length > 0) {
			venderService.addServices(venderId, serviceIds);
		}
		return listVenderServiceItems(venderId);
	}

	@RequestMapping("/professional/vender/tab/service/remove")
	public ModelAndView removeServiceItem(Integer venderId, Integer serviceId)
			throws Exception {
		venderService.removeServices(venderId, serviceId);
		return listVenderServiceItems(venderId);
	}

	// @RequestMapping("/professional/vender/tab/users")
	// public ModelAndView toTabSevUsers() throws Exception {
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/cm/tab_servusers");
	// return mv;
	// }
	//
	// @RequestMapping("/professional/vender/tab/services")
	// public ModelAndView toTabSevItems() throws Exception {
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/cm/tab_servitems");
	// return mv;
	// }
	//
	//
	//
	//
	//
	// @RequestMapping("/professional/vender/users")
	// public ModelAndView queryVenderServerUsers(Integer venderId, String
	// userName, String idCard, Short status, PageParamVO pageCond) throws
	// Exception {
	// Page<VenderServUserVO> page =
	// venderService.queryVenderServerUsers(venderId, userName, idCard, status,
	// pageCond);
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/venderEvaInput");
	// mv.addObject("page", page);
	// mv.addObject("venderId", venderId);
	// mv.addObject("userName", userName);
	// mv.addObject("idCard", idCard);
	// mv.addObject("status", status);
	// mv.addObject("pageCond", pageCond);
	// return mv;
	// }
	//
	// @RequestMapping("/professional/vender/users/distr")
	// public ModelAndView toDistrUserPage(Integer venderId, Long userId) throws
	// Exception {
	//
	// //从session中获取用户Id
	// String userName = "leo";
	//
	// List<VenderDistrVO> distrVos = venderService.getDistrUsers(venderId,
	// userId, userName)
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/venderEvaInput");
	// mv.addObject("distrVos", distrVos);
	// return mv;
	// }
	//
	// @RequestMapping("/professional/vender/users/distr/commit")
	// public ModelAndView distrUser(VenderDistrVO vo) throws Exception {
	// venderService.distrUser(vo);
	// 要回到那里呢？
	// return null;
	// }
	//
	// @RequestMapping("/professional/vender/service")
	// public ModelAndView toVenderServicePage(Integer venderId) throws
	// Exception {
	// List<MVenderService> services =
	// venderService.getVenderServices(venderId);
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/venderEvaInput");
	// mv.addObject("services", services);
	// return mv;
	// }
	//
	// @RequestMapping("/professional/vender/service/remove")
	// public ModelAndView deleteVenderService(Integer venderId, Integer id)
	// throws Exception {
	// venderService.deleteVenderService(id);
	// return toAddVenderServicePage(venderId);
	// }
	//
	// @RequestMapping("/professional/vender/service/add")
	// public ModelAndView toAddVenderServicePage(Integer venderId) throws
	// Exception {
	// List<ServiceVO> services = venderService.getUnCheckServices(venderId);
	// ModelAndView mv = new
	// ModelAndView("/professional/vender/venderEvaInput");
	// mv.addObject("services", services);
	// return mv;
	// }
	//
	// @RequestMapping("/professional/vender/service/commit")
	// public ModelAndView addVenderService(Integer venderId, Integer serviceId)
	// throws Exception {
	// venderService.addVenderService(venderId, serviceId);
	// return toVenderServicePage(venderId);
	// }

	/************************************************************************ 专业服务商各标签页跳转 **************************************************************/

	/**
	 * 分类信息内存池
	 */
	@Autowired
	private SpringDataPool springDataPool;

	/**
	 * 专业服务商用户详情页面
	 * 
	 * @author guoyongxiang Date: 2014-10-12 下午7:01:51
	 * @param id
	 * @return
	 */
	@RequestMapping("/professional/vender/user/detail/{id}")
	public ModelAndView getDetail(@PathVariable Long id, HttpSession session)
			throws Exception {
		RUser user = venderService.getUser(id);
		OCountry ocountry = null;
		try {
			ocountry = venderService.getCountry(user.getCommunityId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ocountry==null){
			ocountry=new OCountry();
			ocountry.setName("未知社区");
		}
		// 查询状态信息
		StateQueryResultVO resultVo = venderService.query(new DateParamVO(),
				id, new PageParamVO(0, 1));
		List<String[]> status = resultVo.getResults().getResult();
		ModelAndView mv = new ModelAndView("/professional/vender/userDetail");
		mv.addObject("stauts_m", resultVo.getStatus_m());
		mv.addObject("user", user);
		mv.addObject("ocountry", ocountry);
		mv.addObject("categoryItems", springDataPool.getOCategoryItem());
		mv.addObject("status", status.isEmpty() ? status : status.get(0));
		return mv;
	}

	@Autowired
	private MUserVenderService muserVenderService;

	@RequestMapping("/professional/vender/user/delete/{id}")
	public ModelAndView getDelete(@PathVariable Long id, HttpSession session)
			throws Exception {
		RUser r = venderService.getUser(id);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (r.getCreatedBy().equals(userVo.getName())) {
			if (muserVenderService.getListMUser(id) != null) {
				List<MUserVender> muserVender = muserVenderService
						.getListMUser(id);
				for (MUserVender m : muserVender) {
					muserVenderService.delete(m);
				}
			}
			venderService.remove(id);
		}

		return new ModelAndView(new RedirectView("/care/user/list"));
	}

	@RequestMapping("/professional/vender/user/detail_from/{id}")
	public ModelAndView getUserDetail(@PathVariable Long id) throws Exception {
		RUser user = venderService.getUser(id);
		OCountry ocountry = venderService.getCountry(user.getCommunityId());

		// 查询状态信息
		StateQueryResultVO resultVo = venderService.query(new DateParamVO(),
				id, new PageParamVO(0, 1));
		List<String[]> status = resultVo.getResults().getResult();

		ModelAndView mv = new ModelAndView(
				"/professional/vender/userDetail_from");
		mv.addObject("user", user);
		mv.addObject("ocountry", ocountry);
		mv.addObject("categoryItems", springDataPool.getOCategoryItem());
		mv.addObject("status", status.isEmpty() ? status : status.get(0));
		return mv;
	}

	/**
	 * 跳转至专业服务商 -- 专业服务标签 -- 点击专业服务后的页面 VenderCtl.goUserSpecDetailPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-13
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/service/user/set")
	public ModelAndView goUserSpecDetailPage(Long userId, Integer serviceId,
			DateParamVO dateCond, Long orderId, Integer stype) throws Exception {
		ModelAndView mv = new ModelAndView("/professional/vender/userSpecSet");
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("orderId", orderId);
		mv.addObject("stype", stype);
		return mv;
	}

	/**
	 * 添加报告 dx
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/baogao")
	public ModelAndView getRUser(Long userId) throws Exception {
		ModelAndView mv = new ModelAndView("/professional/vender/bao_gao_list");
		mv.addObject("userId", userId);
		return mv;
	}

	/**
	 * 跳转至专业服务商 -- 专业服务标签 -- 点击专业服务
	 * 
	 * VenderCtl.goHistoryPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-13
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/service/user/history")
	public ModelAndView goHistoryPage(Long userId, Integer serviceId)
			throws Exception {
		DateParamVO dateCond = new DateParamVO();
		dateCond.setStart(DateUtil.getFirstDayInMonth(new Date()));
		dateCond.setEnd(DateUtil.getLastDayInMonth(new Date()));
		ModelAndView mv = new ModelAndView("/professional/vender/data_history");
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("dateCond", dateCond);
		return mv;
	}

	/*********************************************************************** 分配人员 *****************************************************************************/
	/**
	 * 专业服务商分配人员--获取员工列表
	 * 
	 * @name VenderCtl.DistrUser()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午12:34:55
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/distr/user/list")
	public ModelAndView DistrUser(HttpSession session, Long userId)
			throws Exception {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		int userCategory = userVo.getCateEnum().getType();

		List<VenderDistrVO> venderDistrVOs = new ArrayList<VenderDistrVO>();
		if (userCategory == UserCategoryEnum.PRO.getType()) {
			venderDistrVOs = venderService.getVenderUsers(userVo);
		} else {
			// 没权限
		}

		ModelAndView mv = new ModelAndView("/professional/vender/distrUser");
		mv.addObject("distrUsers", venderDistrVOs);
		mv.addObject("userId", userId);
		return mv;
	}

	/**
	 * 专业服务上人员列表
	 * 
	 * @name VenderCtl.distrUSers()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午3:47:32
	 * @param session
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/vender/distr/users")
	public @ResponseBody JSONObject distrUSers(HttpSession session, Long userId) {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		int userCategory = userVo.getCateEnum().getType();

		List<VenderDistrVO> venderDistrVOs = new ArrayList<VenderDistrVO>();

		try {
			if (userCategory == UserCategoryEnum.PRO.getType()) {
				venderDistrVOs = venderService.getVenderUsers(userVo);
				for (VenderDistrVO vo : venderDistrVOs) {
					vo.setUserId(userId);
				}
			} else {
				// 没权限
			}
		} catch (Exception e) {
			return null;
		}
		JSONObject json = new JSONObject();
		json.put("venderDistrVOs", venderDistrVOs);
		//根据用户的ID查询所在的服务商下 查m_vender_users表
		RUser rUser=userService.findById(userId);
		Long adminId=null;
		try {
			adminId=mUserVenderService.getVenderUsersById(rUser,userVo.getVenderId());		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(adminId!=null){
			
			json.put("adminIds",adminId);
		}
		return json;
	}
	/**
	 * 专业服务商超管分配用户--提交
	 * 
	 * @name VenderCtl.DistrUserCommit()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午12:51:23
	 * @param session
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/vender/distr/user/commit")
	public ModelAndView DistrUserCommit(HttpSession session, Long userId,
			Long adminId) throws Exception {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		MUserVender m = muserVenderService.getMUserVender(userId,
				userVo.getVenderId());
		m.setAllocation(1);
		int userCategory = userVo.getCateEnum().getType();

		if (userCategory != UserCategoryEnum.PRO.getType()) {
			throw new BusinessException(ExceptionCode.PERMISSION_NOT);
		} else {
			RUser r = venderService.getUser(userId);
			VenderDistrVO vo = new VenderDistrVO();
			vo.setAdminId(adminId);
			vo.setUserId(userId);
			vo.setVenderId(userVo.getVenderId());
			vo.setDistrBy(userVo.getName());
			// 分配用户
			venderService.distrUser(vo, r);
			muserVenderService.update(m);
			// 没权限
			// 获取用户分配信息
			return new ModelAndView(new RedirectView(
					"/professional/setup?userId=" + userId));
		}
	}

	/************************************************************************ 评估 ********************************************************************************/

	/**
	 * 评估相关业务逻辑处理类
	 */
	@Autowired
	private AssessService assessService;

	/**
	 * 老年人获取用户评估记录 AssessCtl.getAssessRecords()<BR>
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/vender/assess")
	public ModelAndView getAssessRecords(HttpSession session, Long userId,
			DateParamVO dateCond, PageParamVO pageCond) throws Exception {
		// 默认取当月数据
		if (dateCond.getStart() == null && dateCond.getEnd() == null) {
			dateCond.setStart(DateUtil.getFirstDayInMonth(new Date()));
			dateCond.setEnd(DateUtil.getLastDayInMonth(new Date()));
		}

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		int userCategory = userVo.getCateEnum().getType();

		if (userCategory == UserCategoryEnum.USER.getType()) {
			// 获取用户id
			userId = userVo.getId();

		}
		// 评估列表

		Page<MAssessRecord> records = assessService.getAssessRecords(userId,
				dateCond, pageCond);
		ModelAndView mv = new ModelAndView(
				"professional/vender/tab_assessRecord");
		mv.addObject("page", records);
		mv.addObject("pageCond", pageCond);
		mv.addObject("dateCond", dateCond);
		if (userCategory != UserCategoryEnum.USER.getType()
				|| userCategory != UserCategoryEnum.PRO.getType()) {
			mv.addObject("userId", userId);
		}
		// 提供给游戏平台数据
		RUser r = venderService.getUser(userId);
		mv.addObject("idCo", r.getIdCardNo());
		mv.addObject("age", r.getAge());
		mv.addObject("name", r.getName());
		mv.addObject("commitName", oCountryService.getCountryById(r.getCommunityId()).getName());
		Integer education = r.getEducation();
		/*case 1:education='小学及以下'case 2:education='初中';case 3: education='高中、中专及职高';case 4: 	education='大专及本科';case 5: education='硕、博研究生';*/
		if (education == 200 || education == 0201 || education == 261) {
			mv.addObject("education", 1);
		} else if (education == 198) {
			mv.addObject("education", 2);
		} else if (education == 199 || education == 203) {
			mv.addObject("education", 3);
		} else if (education == 202 || education == 204) {
			mv.addObject("education", 4);
		} else if (education == 223 || education == 260) {
			mv.addObject("education", 5);
		}else{
			mv.addObject("education", 2);
		}
		mv.addObject("sex", r.getGender()==1?"man":"woman");
		return mv;
	}

	@RequestMapping(value = "/professional/vender/assess/user")
	public ModelAndView getAssesss(HttpSession session, Long userId,
			DateParamVO dateCond, PageParamVO pageCond) throws Exception {
		// 默认取当月数据
		if (dateCond.getStart() == null && dateCond.getEnd() == null) {
			dateCond.setStart(DateUtil.getFirstDayInMonth(new Date()));
			dateCond.setEnd(DateUtil.getLastDayInMonth(new Date()));
		}

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		int userCategory = userVo.getCateEnum().getType();

		if (userCategory == UserCategoryEnum.USER.getType()) {
			// 获取用户id
			userId = userVo.getId();
		}
		// 评估列表
		Page<MAssessRecord> records = assessService.getAssessRecords(userId,
				dateCond, pageCond);
		ModelAndView mv = new ModelAndView(
				"professional/vender/tab_assessRecord");
		mv.addObject("page", records);
		mv.addObject("pageCond", pageCond);
		mv.addObject("dateCond", dateCond);
		if (userCategory != UserCategoryEnum.USER.getType()
				|| userCategory != UserCategoryEnum.PRO.getType()) {
			mv.addObject("userId", userId);
		}
		return mv;
	}

	/**
	 * 报告获取老年人评估信息
	 * 
	 * @author dx
	 * @param request
	 * @param response
	 * @param id
	 * @param dateCond
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/vender/assesses")
	public @ResponseBody JSONObject getAssess(HttpServletRequest request,
			HttpServletResponse response, long id, DateParamVO dateCond)
			throws Exception {
		// 评估列表
		List<MAssessRecord> mAssessRecord = assessService.getAssessRecord(id,
				dateCond);
		JSONObject data = new JSONObject();
		data.put("mAssessRecord", mAssessRecord);
		return data;
	}

	/**
	 * 查看评估记录答案
	 * 
	 * @author L
	 * @param recordId
	 * @return
	 */
	@RequestMapping("/professional/vender/assess/detail")
	public ModelAndView assessRecordDetail(Long recordId) {
		List<AssessRecordDetailVo> list = assessService
				.getAssessRecordDetailByRecordId(recordId);
		ModelAndView mv = new ModelAndView(
				"professional/vender/assess_record_detail");
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 报告获取对应的报告信息
	 * 
	 * @author dx
	 * @param id
	 * @param Ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/vender/assesses/detail")
	public @ResponseBody JSONArray assessesRecordDetail(String Ids)
			throws Exception {
		String ids = Ids.substring(0, Ids.length() - 1);
		JSONArray json = assessService.getAssessRecord(ids);
		return json;
	}

	/**
	 * wss 获取评估选项对应建议（结论） 结论
	 */
	@RequestMapping("/professional/vender/assess/conclusion")
	public @ResponseBody JSONObject getConclusionJson() {
		List<ConclusionVO> conclusionVOs = assessService.getConclusion();// 地址
		JSONObject json = new JSONObject();
		json.put("conclusions", conclusionVOs);
		return json;
	}

	/**
	 * 专业服务评估量表列表。
	 * 
	 * @name SpecCtl.toAssessForRecord()
	 * @author zhoupeipei
	 * @Date 2014-10-16 下午11:28:02
	 * @param serviceId
	 * @param pageParamVo
	 * @return
	 */
	@RequestMapping(value = "/professional/vender/service/assess")
	public ModelAndView toAssessForRecord(HttpSession session, Integer type,
			Long userId, Integer serviceId, PageParamVO pageParamVo)
			throws Exception {
		List<AssessVO> assessTables = new ArrayList<AssessVO>();
		assessTables = assessService.getAllAssess(type);

		ModelAndView mv = null;

		if (type != null && type == 2) {
			mv = new ModelAndView("professional/vender/site/assessRecord");
		} else {
			mv = new ModelAndView("professional/vender/set_assessRecord");
		}

		mv.addObject("assesses", assessTables);
		mv.addObject("page", pageParamVo);
		mv.addObject("serviceId", serviceId);
		mv.addObject("userId", userId);
		return mv;
	}

	/**
	 * 开始评估--获取评估量表详细信息
	 * 
	 * @name VenderCtl.toRecordAssess()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午6:01:28
	 */
	@RequestMapping("/professional/assess/recordInfo")
	public @ResponseBody String toRecordAssess(Long userId, Integer serviceId,
			Integer assessId, String callback,HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			AssessVO assessVo = assessService.getAssessVoList(assessId);
			return PublicService.returnJSONP(ExceptionCode.SUCCESS, assessVo,
					callback);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, null,
					callback);
		}
	}

	/**
	 * 跳转答题页面
	 * 
	 * @name VenderCtl.toRecord()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午7:32:50
	 */
	@RequestMapping("/professional/assess/record")
	public ModelAndView toRecord(Long userId, Integer assessId)
			throws Exception {
		AssessVO assessVO = assessService.getAssess(assessId);

		ModelAndView mv;
		if (assessVO.getType() == ProfessionalConstants.ASSESS_TYPE_SCORE) {
			mv = new ModelAndView("/professional/vender/assess_record_qa");

		} else if (assessVO.getType() == ProfessionalConstants.ASSESS_TYPE_SITE) {
			mv = new ModelAndView("/professional/vender/site/assess_record");

		} else {
			if (assessId == 118) {
				// 此量表需计算最终结果
				mv = new ModelAndView(
						"/professional/vender/assess_record_exception");
			} else {
				mv = new ModelAndView("/professional/vender/assess_record_cb");
			}
		}

		// 主表
		AssessRecordVo assessRecordVo = new AssessRecordVo();
		assessRecordVo.setAssessId(assessId);
		assessRecordVo.setAssessName(assessVO.getName());
		assessRecordVo.setUserId(userId);
		assessRecordVo.setType(assessVO.getType());

		mv.addObject("userId", userId);
		mv.addObject("record", assessRecordVo);
		return mv;
	}

	/**
	 * 提交评估结果
	 * 
	 * @name VenderCtl.assessRecordCommit()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午6:05:00
	 */
	@RequestMapping("/professional/assess/record/commit")
	public ModelAndView assessRecordCommit(HttpSession session,
			AssessRecordVo record) throws Exception {

		// 当前用户信息
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 当前用户名
		String userName = userVO.getName();
		assessService.addAssessRecord(record, userName);

		return getUserDetail(record.getUserId());
	}
	
	@RequestMapping("/professional/assess/site/commit")
	public ModelAndView assessSiteCommit(HttpSession session,
			AssessRecordVo record) throws Exception {
		// 当前用户信息
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 当前用户名
		MVenderSite m=mVenderSiteService.fingById(record.getUserId());
		String userName = userVO.getName();
		m.setAssessResult(record.getConContent());
		m.setEndTime(new Date());
		mVenderSiteService.update(m);
		assessService.addAssessRecord(record, userName);
		ModelAndView mv = new ModelAndView(new RedirectView("/professional/vender/service/assess?userId="+record.getUserId()+"&type=2"));
		return mv;

	}
	/**
	 * 外部问卷接入
	 * @param userId
	 * @param serviceId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/assess/waibu/commit")
	public @ResponseBody String commitW(AssessRecordVo record,HttpServletResponse response) throws Exception{
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		if(record.getUserId()!=null){
			assessService.addAssessRecord(record, "questionnaire");
		}
		return "success";
	}

	/************************************************************************ 状态维护 ****************************************************************************/

	/**
	 * 跳转至状态页面，默认返回指定老人一个月内状态信息首页数据 VenderCtl.goStatePage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/state")
	public ModelAndView goStatePage(Long userId, PageParamVO pageParamVO)
			throws Exception {
		// 默认时间查询范围为当月
		Date start = DateUtil.getFirstDayInMonth(new Date());
		Date end = DateUtil.getLastDayInMonth(new Date());
		DateParamVO dateCond = new DateParamVO(start, end);
		// 查询结果
		StateQueryResultVO resultVo = venderService.query(dateCond, userId,
				pageParamVO);
		ModelAndView mv = new ModelAndView("/professional/vender/state");
		mv.addObject("states", resultVo);
		mv.addObject("page", resultVo.getResults());
		mv.addObject("dateCond", dateCond);
		mv.addObject("pageCond", pageParamVO);
		mv.addObject("userId", userId);
		return mv;
	}

	@RequestMapping(value = "/professional/state/condition")
	public ModelAndView gocondition(HttpSession session, PageParamVO pageParamVO)
			throws Exception {
		// 默认时间查询范围为当月
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		Date start = DateUtil.getFirstDayInMonth(new Date());
		Date end = DateUtil.getLastDayInMonth(new Date());
		DateParamVO dateCond = new DateParamVO(start, end);
		// 查询结果
		StateQueryResultVO resultVo = venderService.query(dateCond,
				userVo.getId(), pageParamVO);
		ModelAndView mv = new ModelAndView("/user/state");
		mv.addObject("states", resultVo);
		mv.addObject("page", resultVo.getResults());
		mv.addObject("dateCond", dateCond);
		mv.addObject("pageCond", pageParamVO);
		mv.addObject("userId", userVo.getId());
		return mv;
	}

	/**
	 * 查询指定老人指定日期区间的状态信息 VenderCtl.queryState()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @param dateCond
	 * @param userId
	 *            老人id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/state/query")
	public ModelAndView queryState(DateParamVO dateCond, Long userId,
			PageParamVO pageParamVO) throws Exception {

		// 查询结果
		StateQueryResultVO resultVo = venderService.query(dateCond, userId,
				pageParamVO);

		ModelAndView mv = new ModelAndView("/professional/vender/state");
		mv.addObject("states", resultVo);
		mv.addObject("page", resultVo.getResults());
		mv.addObject("userId", userId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("pageCond", pageParamVO);
		return mv;
	}

	/**
	 * 增加状态信息 VenderCtl.goStateSavePage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 */
	@RequestMapping(value = "/professional/state/add")
	public ModelAndView goStateSavePage(Long userId, PageParamVO pageParamVO)
			throws Exception {

		// 获取全部状态分类信息
		Collection<StateVO> states = venderService.getAllStates();

		ModelAndView mv = new ModelAndView("/professional/vender/stateInput");
		mv.addObject("states", states);
		mv.addObject("userId", userId);
		mv.addObject("page", pageParamVO);
		return mv;
	}

	/**
	 * 移动获取全部状态信息分类
	 * 
	 * @name VenderCtl.mobileGetStateInfo()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午12:18:35
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/mobile/state/info")
	public @ResponseBody String mobileGetStateInfo(String callback)
			throws Exception {
		// 获取全部状态分类信息
		Collection<StateVO> states = null;
		try {
			states = venderService.getAllStates();
		} catch (BusinessException e) {
			return PublicService.returnJSONP(e.getCode(), states, callback);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, states,
					callback);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, states,
				callback);
	}

	/**
	 * 移动端获取老年人状态信息
	 * 
	 * @name VenderCtl.mobileMyStates()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午12:26:28
	 * @param session
	 * @param userId
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/mobile/user/states")
	public @ResponseBody String mobileMyStates(HttpSession session,
			Long userId, String callback) throws Exception {
		// 查询结果
		List<List<MobileStateVo>> states = null;
		try {
			states = venderService.queryStateForMobile(userId);

		} catch (BusinessException be) {
			return PublicService.returnJSONP(be.getCode(), states, callback);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, states,
					callback);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, states,
				callback);
	}

	/**
	 * 移动端提交状态
	 * 
	 * @name VenderCtl.mobileSaveState()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午2:37:04
	 * @param session
	 * @param states
	 * @param userId
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/mobile/state/commit")
	public @ResponseBody String mobileSaveState(HttpSession session,
			String states, Long userId, String callback) throws Exception {
		try {
			StateParamVO stateParamVO = JSON.toJavaObject(
					JSON.parseObject(states), StateParamVO.class);
			// 从session中获取用户信息
			UserVO userVo = (UserVO) session
					.getAttribute(PropertyValueConstants.SESSION_USER);

			// 获取用户信息
			String userName = userVo.getName();

			// 获取服务商Id
			Integer venderId = userVo.getVenderId();

			// TODO:用户权限验证
			venderService.saveState(stateParamVO, userId, venderId, userName);
		} catch (BusinessException ex) {
			return PublicService.returnJSONP(ex.getCode(), null, callback);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, null,
					callback);
		}
		return mobileMyStates(session, userId, callback);

	}

	/**
	 * 保存状态信息 VenderCtl.saveState()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @param states
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/state/commit")
	public ModelAndView saveState(HttpSession session, StateParamVO states,
			Long userId, DateParamVO dateCond, PageParamVO pageParamVO)
			throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取用户信息
		String userName = userVo.getName();

		// 获取服务商Id
		Integer venderId = userVo.getVenderId();

		// TODO:用户权限验证
		venderService.saveState(states, userId, venderId, userName);
		return goStatePage(userId, pageParamVO);
	}

	/************************************************************************ 实时消息 ****************************************************************************/

	/**
	 * 跳转至实时消息列表页面，默认返回全部消息的首页数据 VenderCtl.msg()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param userId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/msg")
	public ModelAndView msg(HttpSession session, Long userId,
			Integer serviceId, PageParamVO pageParamVo) throws Exception {
		// 初始化查询时间范围为当月
		Date start = DateUtil.getFirstDayInMonth(new Date());
		Date end = DateUtil.getLastDayInMonth(new Date());
		DateParamVO dateCond = new DateParamVO(start, end);

		Page<MMessage> messages = new Page<MMessage>();
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 获取用户权限
		int userCategory = userVo.getCateEnum().getType();

		if (userCategory == UserCategoryEnum.USER.getType()) {
			userId = userVo.getId();
			messages = venderService.getMessages(userId, pageParamVo);
		} else {
			// 获取消息信息
			messages = venderService.getServiceMessages(userId, serviceId,
					pageParamVo);
		}

		ModelAndView mv = new ModelAndView("/professional/vender/messages");
		mv.addObject("page", messages);
		mv.addObject("serviceId", serviceId);
		mv.addObject("userId", userId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("pageCond", pageParamVo);
		return mv;
	}

	/**
	 * 服务商增加实时消息 VenderCtl.addMsg()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param userId
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/msg/commit")
	public ModelAndView addMsg(HttpSession session, Integer serviceId,
			String serviceName, Long userId, String message,
			PageParamVO pageParamVo) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取服务商用户信息
		String userName = userVo.getName();

		// 获取服务商Id
		Integer venderId = userVo.getVenderId();

		ServiceVO serviceVO = specService.get(serviceId);
		serviceName = serviceVO.getName();

		// 当前用户没有服务商信息或拿不到专业服务信息，不允许添加
		if (venderId == null || serviceVO == null) {
			throw new BusinessException(ExceptionCode.ADD_REPORT_PERMIT_NOT);
		}

		// 保存消息
		venderService.saveMsg(venderId, serviceId, serviceName, userId,
				message, userName);

		return msg(session, userId, serviceId, pageParamVo);
	}

	/**
	 * 查询实时消息 VenderCtl.queryMsg()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param dateCond
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/msg/query")
	public ModelAndView queryMsg(HttpSession session, DateParamVO dateCond,
			PageParamVO pageParamVo) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 从session中获取用户的类型并返回 用于区分显示哪些字段
		int userCategory = userVo.getCateEnum().getType();
		// 从session中获取用户Id(获取老年人的Id)
		Long userId = userVo.getId();

		// 获取消息信息
		Page<MMessage> messages = venderService.getMessages(userId, dateCond,
				pageParamVo);

		ModelAndView mv = new ModelAndView("/professional/vender/messages");
		mv.addObject("page", messages);
		mv.addObject("userCategory", userCategory);
		mv.addObject("dateCond", dateCond);
		mv.addObject("pageCond", pageParamVo);
		return mv;
	}

	/************************************************************************ 服务报告 ****************************************************************************/

	/**
	 * 获取服务报告 VenderCtl.report()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param userId
	 * @param dateCond
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/report/query")
	public ModelAndView report(Long userId, Integer serviceId,
			DateParamVO dateCond, PageParamVO pageParamVo) throws Exception {
		Page<MReport> reports;
		if (serviceId == null) {
			// 获取消息信息
			reports = venderService.getReports(userId, dateCond, pageParamVo);
		} else {
			reports = venderService.queryByService(serviceId, userId, dateCond,
					pageParamVo);
		}

		ModelAndView mv = new ModelAndView(
				"/professional/vender/set_serviceReport");
		mv.addObject("page", reports);
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("dateCond", dateCond);
		return mv;
	}

	/**
	 * 添加服务报告 VenderCtl.addReport()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param serviceId
	 * @param userId
	 * @param content
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/report/commit")
	public ModelAndView addReport(HttpSession session, Long userId,
			Integer serviceId, String content, DateParamVO dateCond,
			PageParamVO pageParamVo) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取用户信息
		String userName = userVo.getName();

		// 获取服务商Id
		Integer venderId = userVo.getVenderId();

		ServiceVO serviceVO = specService.get(serviceId);
		String serviceName = serviceVO.getName();

		// 当前用户没有服务商信息或拿不到专业服务信息，不允许添加
		if (venderId == null || serviceVO == null) {
			throw new BusinessException(ExceptionCode.ADD_REPORT_PERMIT_NOT);
		}

		// 保存消息
		venderService.saveReport(venderId, serviceId, serviceName, userId,
				content, userName);

		return report(userId, serviceId, dateCond, pageParamVo);
	}

	/**
	 * 跳转添加服务报告页面
	 * 
	 * @name VenderCtl.toReportAdd()
	 * @author zhoupeipei
	 * @Date 2014-10-17 上午3:06:45
	 * @param serviceId
	 * @param serviceName
	 * @param userId
	 * @param content
	 * @param dateCond
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/report/add")
	public ModelAndView toReportAdd(Long userId, Integer serviceId,
			DateParamVO dateCond) throws Exception {
		ModelAndView mv = new ModelAndView("/professional/vender/reportInput");
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("dateCond", dateCond);
		return mv;
	}

	/**
	 * author wss 报告列表
	 */
	@RequestMapping(value = "/professional/bao_gao_list")
	public ModelAndView goBaoGaoPage(HttpSession session, Long userId,
			Integer serviceId, Long orderId, String date) throws Exception {
		// TODO 报告
		ModelAndView mv = null;

		mv = new ModelAndView("/professional/vender/bao_gao_list");
		mv.addObject("userId", userId);
		return mv;
	}

	/**
	 * 微信获取老人信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/listjson")
	public @ResponseBody JSONObject findListValue(Long userId) throws Exception {
		RUser rUser = rUserService.findById(userId);
		RUserVo ruser = new RUserVo();
		ruser.setAge(rUser.getAge());
		ruser.setBirthday(rUser.getBirthday());
		ruser.setGender(rUser.getGender());
		ruser.setIdCardNo(rUser.getIdCardNo());
		ruser.setMobilePhone(rUser.getMobilePhone());
		ruser.setName(rUser.getName());
		JSONObject jsons = new JSONObject();
		jsons.put("rUser", ruser);
		return jsons;
	}

	/**
	 * author dx 添加报告
	 */
	@RequestMapping(value = "/professional/bao_gao_add")
	public ModelAndView addBaoGaoPage(HttpSession session, Long userId,
			Integer serviceId, Long orderId, String date) throws Exception {
		// 默认时间查询范围为当月
		Date start = DateUtil.getFirstDayInMonth(new Date());
		Date end = DateUtil.getLastDayInMonth(new Date());
		DateParamVO dateCond = new DateParamVO(start, end);
		// TODO 报告
		ModelAndView mv = null;
		// 根据userId加载出用户信息
		RUser rUser = rUserService.findById(userId);
		// 根据社区Id加载社区信息
		OCountry oCountry = oCountryService.getCountryById(rUser
				.getCommunityId());
		mv = new ModelAndView("/professional/vender/bao_gao_add");
		mv.addObject("dateCond", dateCond);
		mv.addObject("rUser", rUser);
		mv.addObject("oCountry", oCountry);
		mv.addObject("lifeCond",
				oCategoryItemService.getItemName(rUser.getLifeCond())
						.getItemName());
		mv.addObject("hrtype",
				oCategoryItemService.getItemName(rUser.getHrType())
						.getItemName());
		mv.addObject("marry", oCategoryItemService
				.getItemName(rUser.getMarry()).getItemName());
		mv.addObject("political",
				oCategoryItemService.getItemName(rUser.getPolitical())
						.getItemName());
		mv.addObject("jobCond",
				oCategoryItemService.getItemName(rUser.getJobCond())
						.getItemName());
		mv.addObject("medical",
				oCategoryItemService.getItemName(rUser.getMedical())
						.getItemName());
		mv.addObject("religion",
				oCategoryItemService.getItemName(rUser.getReligion())
						.getItemName());
		mv.addObject("nation",
				oCategoryItemService.getItemName(rUser.getNation())
						.getItemName());
		mv.addObject("income",
				oCategoryItemService.getItemName(rUser.getIncome())
						.getItemName());
		mv.addObject("education",
				oCategoryItemService.getItemName(rUser.getEducation())
						.getItemName());
		MAssessGds gds=mAssessGdsService.getUserId(rUser.getId());
		if(gds!=null){
			mv.addObject("gds", gds.getAssessHtml());
			if(gds.getBrief()!=null){
				mv.addObject("brief", gds.getBrief());
			}
		}
		return mv;
	}

	
	/************************************************************************ 服务计划 ****************************************************************************/
	@Autowired
	private ActivityManagerService activityManagerService;
	@RequestMapping(value = "/professional/plan")
	public ModelAndView goPlanPage(HttpSession session, Long userId,
			   String date) throws Exception {
		UserVO userVo = null;
		List<NActivityPlanVO1> mPlanList = null;
		ModelAndView mv = null;
		String url = null;
		if (userId != null) {
			url = "/professional/vender/plan";
		} else {
			userVo = (UserVO) session
					.getAttribute(PropertyValueConstants.SESSION_USER);
			url = "/professional/vender/planIndex";
			userId = userVo.getId();
		}
		if (date == null) {
			date = DateUtil.formatDate(new Date(), "yyyy-MM-dd");
		} 
		Integer communtiyId= userService.findById(userId).getCommunityId();
		List<String> s=	mVenderSiteService.fingByCommity(communtiyId);
		String sites="";
		if(s.size()!=0){
			sites=StringUtils.join(s.toArray(),",");
		}
		//mPlanList = mPlanService.getUserPlanByDate(userId, date);
		mPlanList=activityManagerService.findSite(sites);
		// }

		mv = new ModelAndView(url);
		mv.addObject("mPlanList", mPlanList);
		mv.addObject("userId", userId);
		//mv.addObject("orderId", orderId);
		//mv.addObject("serviceId", serviceId);
		return mv;
	}

	/**
	 * 将计划信息加载到报告
	 * 
	 * @author dx
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/report")
	public @ResponseBody JSONObject goPlan(long id, String start, String end)
			throws Exception {
		List<MPlan> mplan = mPlanService.getByDate(id, start, end);
		List<ReportVo> report = new ArrayList<ReportVo>();
		ReportVo vo = new ReportVo();
		for (MPlan m : mplan) {
			vo.setContent(m.getmPlanCategory().getName());
			vo.setName(m.getmPlanCategory().getParentPlanCategory().getName());
			vo.setRemark(m.getRemark());
			vo.setServiceTime(m.getServiceTime());
			report.add(vo);
		}
		JSONObject mjson = new JSONObject();
		mjson.put("report", report);
		return mjson;
	}

	/**
	 * 
	 * @param session
	 * @param communityId
	 * @param callback
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("/professional/getPlad")
	public @ResponseBody JSONObject getUserPlanByDate(HttpSession session,
			Long userId, String date) throws IllegalAccessException, InvocationTargetException {
		UserVO userVo = null;
		List<NActivityPlanVO1>  mPlanList = null;
		if (userId == null) {
			userVo = (UserVO) session
					.getAttribute(PropertyValueConstants.SESSION_USER);
			userId = userVo.getId();
		}
		Integer communtiyId= userService.findById(userId).getCommunityId();
		List<String> s=	mVenderSiteService.fingByCommity(communtiyId);
		String sites="";
		if(s.size()!=0){
			sites=StringUtils.join(s.toArray(),",");
		}
		//mPlanList = mPlanService.getUserPlanByDate(userId, date);
		mPlanList=activityManagerService.findSite(sites,date);
		JSONObject mjson = new JSONObject();
		mjson.put("mPlanVo", mPlanList);
		return mjson;
	}

	/**
	 * 去添加计划页面
	 * 
	 * @param userId
	 * @param serviceId
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/goToAddPlan")
	public ModelAndView goToAddPlan(Long userId, String ckDate)
			throws Exception {
		// List<MPlan> mPlanList=mPlanService.getUserPlan(userId);
		ModelAndView mv = new ModelAndView("/professional/vender/mplanAdd");
		List<MPlanCategory> mPlanCategory = planCategoryService.list(0);
		List<MPlanCategory> sub = null;
		if (mPlanCategory != null) {
			sub = planCategoryService.list(mPlanCategory.get(0).getId());
		}
		mv.addObject("mPlanCategory", mPlanCategory);
		mv.addObject("sub", sub);
		mv.addObject("userId", userId);
		mv.addObject("date", ckDate);
		// mv.addObject("mPlanList", mPlanList);
		return mv;
	}

	/**
	 * 根据计划分类ID获取计划分类内容
	 * 
	 * @param response
	 * @param pid
	 * @param callback
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/professional/getAPlanContent/{pid}")
	public @ResponseBody JSONObject getCountrys(HttpServletResponse response,
			@PathVariable Integer pid, String callback) throws IOException {
		try {
			List<MPlanCategory> result = planCategoryService.list(pid);
			List<MPlanCategoryVO> mPlanVOList = null;
			JSONObject json = new JSONObject();
			if (result != null) {
				mPlanVOList = new ArrayList<MPlanCategoryVO>();
				MPlanCategoryVO mPlanCategoryVO = null;
				for (MPlanCategory tmp : result) {
					mPlanCategoryVO = new MPlanCategoryVO();
					mPlanCategoryVO.setId(tmp.getId());
					mPlanCategoryVO.setName(tmp.getName());
					mPlanVOList.add(mPlanCategoryVO);
				}
			}
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加计划
	 * 
	 * @param session
	 * @param mPlanVO
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/professional/addPlan")
	public ModelAndView saveOrUpdate(HttpSession session, MPlanVO mPlanVO)
			throws BusinessException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		MPlan mPlan = new MPlan();
		String serviceTime = mPlanVO.getServiceTime();
		int size = mPlanService.getUserPlanByDate(mPlanVO.getUserId(),
				serviceTime).size();
		if (size == 0) {
			mPlan.setmPlanCategory(this.planCategoryService
					.getMPlanCategoryById(mPlanVO.getCategoryId()));
			// mPlan.setmVender(venderService.getVender(mPlanVO.getmVenderId()));
			mPlan.setServiceTime(DateUtil.parseStrToCustomPatternDate(
					serviceTime, "yyyy-MM-dd HH:mm"));
			mPlan.setUserId(mPlanVO.getUserId());
			mPlan.setRemark(mPlanVO.getRemark());
			mPlan.setCreatedAt(new Date());
			mPlan.setChangedBy(userVo.getName());
			mPlanService.saveOrUpdate(mPlan);
		}
		ModelAndView mv = new ModelAndView(new RedirectView(
				"/professional/plan?userId=" + mPlanVO.getUserId()));
		mv.addObject("msg", "success");
		// mv.addObject("serviceId", mPlanVO.getOrdreId());
		return mv;
	}

	/************************************************************************ 警报阈值 ****************************************************************************/

	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	private SpecService specService;

	/**
	 * 阈值设置页面 VenderCtl.goAlarmSetupPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param serviceId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/alarm/setup")
	public ModelAndView goAlarmSetupPage(HttpSession session,
			Integer serviceId, Long userId, boolean success) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取服务商Id
		Integer venderId = userVo.getVenderId();

		// 获取指定专业服务下的全部数据模块
		List<DataModuleVO> dataModules = specService.getDataModules(userId);

		// 填充当前报警设置
		venderService.fillWithCurAlarmSet(serviceId, userId, dataModules);

		ModelAndView mv = new ModelAndView("/professional/vender/set_alarm");
		mv.addObject("dataModules", dataModules);
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("venderId", venderId);
		mv.addObject("success", success);
		return mv;
	}

	/**
	 * 提交阈值设置 VenderCtl.alarmSetup()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param serviceId
	 * @param userId
	 * @param alarmSetVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/alarm/setup/commit")
	public ModelAndView alarmSetup(HttpSession session, Integer serviceId,
			Long userId, AlarmSetVO alarmSetVo) throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取用户信息
		String userName = userVo.getName();

		// 获取服务商Id
		Integer venderId = userVo.getVenderId();

		// 自检
		alarmSetVo.selfValidate();

		// 设置警报阈值
		this.venderService.alarmSetup(userId, venderId, alarmSetVo, userName);

		return goAlarmSetupPage(session, serviceId, userId, true);
	}

	/********************************************************* 信息录入 ********************************************/

	@Autowired
	private MetaDataService metaDateService;

	/**
	 * 录入专业服务信息
	 * 
	 * @param session
	 * @param serviceId
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/professional/input")
	public ModelAndView inputMserviceInfo(HttpSession session, Long userId,
			boolean success) throws BusinessException {
		// 从session中获取用户信息
		// UserVO userVo = (UserVO)
		// session.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取服务商Id
		// Integer venderId = userVo.getVenderId();

		// 获取指定专业服务下的全部数据模块
		List<DataModuleVO> dataModules = specService.getDataModules(userId);

		Date currentDate = new Date();

		ModelAndView mv = new ModelAndView("/professional/vender/input_info");
		mv.addObject("dataModules", dataModules);
		mv.addObject("userId", userId);
		mv.addObject("success", success);
		mv.addObject("currentDate", currentDate);
		return mv;
	}

	/**
	 * 提交专业服务信息
	 * 
	 * @param session
	 * @param inputVo
	 * @param serviceId
	 * @param userId
	 * @return
	 * @throws BusinessException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@RequestMapping("/professional/input/submit")
	public ModelAndView submitInputMserviceInfo(HttpSession session,
			InputInfoVO inputVo, Long userId) throws BusinessException,
			InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		MVender m = venderService.getVender(userVo.getVenderId());
		metaDateService.saveInputData(inputVo, userId);
		metaDateService.Alarmthreshold(inputVo, userId, m,
				rUserService.findById(userId));
		return inputMserviceInfo(session, userId, true);
	}

	@RequestMapping("professional/site/communtiy")
	public @ResponseBody JSONObject commountiy(long id) {
		MVenderSite mVenderSite = mVenderSiteService.fingById(id);
		JSONObject json = new JSONObject();
		if (mVenderSite.getCommunityIds() != null
				&& mVenderSite.getCommunityIds() != "") {
			String communtiy = mVenderSite.getCommunityIds();
			communtiy = communtiy.substring(1, communtiy.length());
			List<OCountry> oCountry = oCountryService
					.getCountryByIds(communtiy);
			json.put("oCountry", oCountry);
		}

		return json;
	}
	@Autowired
	private RReportSrevice reportSrevice;
	@Autowired
	private FileHandle fileHandle;
	/**
	 * 上传报告
	 * @param reportName
	 * @param userId
	 * @param session
	 * @param file
	 * @return
	 */
	@RequestMapping("/professional/vender/saveShangchuanBaoGao")
	public ModelAndView saveBaoGao(String reportName,long userId,HttpSession session,
			@RequestParam(value="file", required=false)MultipartFile file
			){
		ModelAndView mv =null;
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		RReport report=new RReport();
		report.setrUserId(userId);
		report.setReportName(reportName);
		report.setReportType("专业服务商");
		report.setReportSource("北科乐活堂");
		 Date date = new Date();
		report.setDateTime(Long.toString(date.getTime()));
		report.setOperate((short)1);
		// 处理文件上传
		if(file!=null){
				String albumName;
			try {
				albumName = fileHandle.uploadPics(file);
				report.setUrl(albumName);
			} catch (IOException e) {
							// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		report.setPrincipal(userVo.getName());
		try {
			reportSrevice.setRReport(report);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mv=new ModelAndView(new RedirectView("/professional/vender/baogao?userId="+userId));
		return mv;
	}
}