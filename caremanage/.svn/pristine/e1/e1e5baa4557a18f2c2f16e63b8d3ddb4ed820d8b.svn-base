package com.anticw.aged.controller.director;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.RUserDefault;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.assess.RUserDefaultService;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.director.GroupService;
import com.anticw.aged.service.director.HGroupUserService;
import com.anticw.aged.service.huiZheng.HConsultationService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.data.server.MetaDataService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.HConsultationVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.assess.AssessRecordVo;
import com.anticw.aged.vo.professional.data.MyServiceDataVO;
import com.anticw.aged.vo.professional.service.ServiceBriefVO;
import com.anticw.aged.vo.professional.vender.VenderDistrVO;

/**
 * 
 * @author DX-2016-09-12 医院主任信息维护
 *
 */
@Controller
public class DirectorManagemenCtl {

	/**
	 * 专业服务
	 */
	@Autowired
	private SpecService specService;
	/**
	 * 用户信息管理
	 */
	@Autowired
	private RUserService rUserService;
	/**
	 * 获取采集数据的服务类
	 */
	@Autowired
	private MetaDataService dataService;
	/**
	 * r_user_default
	 */
	@Autowired
	private RUserDefaultService rUserDefaultService;

	@Autowired
	private HConsultationService hConsultationService;

	@Autowired
	private VenderService venderService;

	@Autowired
	private CategoryItemService categoryItemService;
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private HGroupUserService hGroupUserService;
	@Autowired
	private AssessService assessService;
	@Autowired
	private SpringDataPool springDataPool;

	/**
	 * 跳转用户主页
	 * 
	 * @return
	 */
	@RequestMapping("/director/userlist")
	public ModelAndView getUserlist(HttpSession session, PageParamVO page,
			RUser user,Integer xun) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = null;
		if (!userVo.isSuper_()) {
			return new ModelAndView(new RedirectView(
					"/director/dirAssociate/plan"));
		}
		/* user.setCreatedBy(userVo.getName()); */
		Page<RUser> ruser = rUserService.getUserlist(page, user);
		mv = new ModelAndView("/director/userlist");
		mv.addObject("page", ruser);
		mv.addObject("user", user);
		return mv;
	}

	/**
	 * 查看用户开通的智能健康设备信息
	 * 
	 * @param session
	 * @param userId
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/director/health")
	public ModelAndView getVenderDistrList(HttpSession session, Long userId,
			DateParamVO dateCond, PageParamVO page) throws Exception {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("director/health");
		// 从session中获取userId
		if (userId == null) {
			// 从session中获取用户信息
			userId = userVo.getId();
		}

		// 获取用户的订单信息
		Map<Integer, MOrder> orders = specService.getUserOrdersAndHandleExpire(
				userId, ProfessionalConstants.ORDER_STATUS_OPENED);
		RUser ruser = rUserService.findById(userId);

		// 未传递日期参数 －－ 老年人获取我的服务数据 默认取3天之内的最新数据
		if (dateCond.getStart() == null || dateCond.getEnd() == null) {
			Date date = new Date();
			dateCond.setEnd(DateUtil.getLastDayInMonth(date));
			dateCond.setStart(DateUtil.getFirstDayInMonth(date));

		}

		// 获取我的服务数据
		List<MyServiceDataVO> datas = dataService.getListDatas(orders,
				dateCond, page);

		mv.addObject("length", datas.size());
		mv.addObject("datas", datas);
		mv.addObject("userId", userId);
		mv.addObject("user", ruser);
		mv.addObject("page", page);
		mv.addObject("dateCond", dateCond);
		return mv;
	}

	/**
	 * 健康数据
	 * 
	 * @param session
	 * @param userId
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/director/service/list")
	public ModelAndView goServiceListPage(HttpSession session, Long userId)
			throws Exception {
		// 当前用户信息
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 用户类型
		ModelAndView mv = null;
		if (userVO.getCateEnum().getType() == UserCategoryEnum.PRO.getType()) {
			return new ModelAndView(new RedirectView(
					"/professional/service/myservices?userId=" + userId));
		} else {
			 userVO.getCateEnum().getType();
			// List<MMetaService>
			// mMetaService=specService.getMMetaServiceList();

			List<ServiceBriefVO> vos = null;
			// 获取用户专业服务分配信息
			VenderDistrVO distrVo = null;
			vos = specService.getSpecServiceList(userId, true);
			mv = new ModelAndView("director/health/health");
			// /mv.addObject("mMetaService", mMetaService);
			mv.addObject("specList", vos);
			mv.addObject("userId", userId);
			mv.addObject("distrVo", distrVo);
			return mv;
		}
	}

	/**
	 * 单项显示图片或者表格
	 * 
	 * @param userId
	 * @param serviceId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/director/service/history")
	public ModelAndView toHistoryDataPage(Long userId, Integer serviceId,
			Short type, DateParamVO dateCond) throws Exception {
		ModelAndView mv = null;
		// 此处为脑电波的元服务Id[根据数据库serviceId更改],服务器数据库为30
		if (type == 2) {
			mv = new ModelAndView("director/health/healthtTypeTwo");
			RUser ruser = rUserService.findById(userId);
			mv.addObject("IdCardNo", ruser.getIdCardNo());
			mv.addObject("userId", userId);
			mv.addObject("start", new Date());
			mv.addObject("end", DateUtil.minusDays(new Date(), 3));
			mv.addObject("type", type);
			mv.addObject("serviceId", serviceId);
		} else if (type == 3) {
			mv = new ModelAndView("director/health/healthtTypeThree");
			// mv = new ModelAndView("professional/data/spec/mattress_OneWeek");
			if (dateCond.getStart() == null
					|| DateUtil.compareDate(new Date(), dateCond.getStart()) < 0) {
				String ed = DateUtil.getCurrentFormatDate() + " 23:59:59";
				String sd = DateUtil.getCurrentFormatDate() + " 00:00:00";
				dateCond.setStart(DateUtil.parseStrToDateTime(sd));
				dateCond.setEnd(DateUtil.parseStrToDateTime(ed));

				mv.addObject("qianqi",
						DateUtil.getDateStart(DateUtil.parseStrToDateTime(sd)));
				mv.addObject("qianmo",
						DateUtil.getDateStart(DateUtil.parseStrToDateTime(ed)));
				mv.addObject("houqi",
						DateUtil.getDateEnd(DateUtil.parseStrToDateTime(sd)));
				mv.addObject("houmo",
						DateUtil.getDateEnd(DateUtil.parseStrToDateTime(ed)));
			} else {
				String ed = DateUtil.getCurrentFormatDate(dateCond.getStart())
						+ " 23:59:59";
				String sd = DateUtil.getCurrentFormatDate(dateCond.getStart())
						+ " 00:00:00";
				dateCond.setStart(DateUtil.parseStrToDateTime(sd));
				dateCond.setEnd(DateUtil.parseStrToDateTime(ed));
				mv.addObject("qianqi",
						DateUtil.getDateStart(dateCond.getStart()));
				mv.addObject("qianmo", DateUtil.getDateStart(dateCond.getEnd()));
				mv.addObject("houqi", DateUtil.getDateEnd(dateCond.getEnd()));
				mv.addObject("houmo", DateUtil.getDateEnd(dateCond.getStart()));
			}
			mv.addObject("newDate",
					DateUtil.getCurrentFormatDate(dateCond.getStart()));
			MOrder order = specService.getOrderByUSID(userId, serviceId);
			MyServiceDataVO mvs = dataService.getMyserviceData(order, dateCond,
					new PageParamVO(1, 1000000));
			List<List<Object>> list = new ArrayList<List<Object>>();
			List<List<Object>> list1 = mvs.getData().getValues();
			List<List<Object>> pant = new ArrayList<List<Object>>();
			Object o1 = null;
			if (list1.size() != 0) {
				for (int i = 0; i < list1.size(); i++) {
					List<Object> li = new ArrayList<Object>();
					li.add(list1.get(i).get(0));
					li.add(list1.get(i).get(2));
					pant.add(li);
					List<Object> ob = new ArrayList<Object>();
					// 开始时间
					if (o1 == null) {
						o1 = list1.get(0).get(0);
					}
					// 状态变化的情况下
					if (i + 1 < list1.size()
							&& !list1.get(i).get(1)
									.equals(list1.get(i + 1).get(1))) {
						// 结束时间
						ob.add(o1);
						ob.add(list1.get(i + 1).get(0));
						ob.add(list1.get(i).get(1));
						o1 = list1.get(i + 1).get(0);
						list.add(ob);
					}
					// 状态没有变化？？

				}
				List<Object> ob1 = new ArrayList<Object>();
				if (list1.get(0).get(1).equals(list1.get(list.size()).get(1))) {
					o1 = list1.get(0).get(0);
					ob1.add(o1);
					ob1.add(list1.get(list1.size() - 1).get(0));
					ob1.add(list1.get(list1.size() - 1).get(1));
					list.add(ob1);
				}
				if (list.size() > 2
						&& !list.get(list.size() - 1).get(1)
								.equals(list1.get(list1.size() - 1).get(0))) {
					List<Object> ob = new ArrayList<Object>();
					ob.add(list.get(list.size() - 1).get(1));
					ob.add(list1.get(list1.size() - 1).get(0));
					ob.add(list1.get(list1.size() - 1).get(1));
					list.add(ob);
				}
			}
			mv.addObject("pant", pant);
			mv.addObject("beds", list);
			mv.addObject("userId", userId);
			mv.addObject("serviceId", serviceId);
			mv.addObject("type", type);
			return mv;
		} else {
			mv = new ModelAndView("director/health/healths");
			Set<MOrderDevice> orderDevices = null;
			// 根据订单Id获取详情
			MOrder order = specService.getOrderByUSID(userId, serviceId);
			if (order != null) {
				orderDevices = order.getOrderDevices();
			}
			mv.addObject("stype", (int) type);
			mv.addObject("orderDevices", orderDevices);
			mv.addObject("userId", userId);
			mv.addObject("serviceId", serviceId);
		}

		return mv;
	}

	@RequestMapping("/director/user")
	public ModelAndView getUser(HttpSession session, Long userId)
			throws IllegalAccessException, InvocationTargetException {
		ModelAndView mv = new ModelAndView("director/users/userInfos");
		RUser user = rUserService.findById(userId);
		com.anticw.aged.vo.director.DirectorUserVO dirUser = new com.anticw.aged.vo.director.DirectorUserVO();
		BeanUtils.copyProperties(dirUser, user);
		dirUser.setMedicalHistory(user.getrUserDefault().getMedicalHistory());
		dirUser.setAllergy(user.getrUserDefault().getAllergy());
		session.setAttribute("dirUser", dirUser);
		StringBuffer sb = new StringBuffer();
		mv.addObject("user", user);
		if (user.getNation() != null) {
			// 根据ID查询字典表中的民族
			mv.addObject("category",
					categoryItemService.findCategoryName(user.getNation()));
		}
		if (user.getCommunityId() != ' ' || user.getCommunityId() != null) {
			String name = oCountryService.getCountryById(user.getCommunityId())
					.getName();
			/*
			 * String
			 * fullName=oCountryService.getParentByIds(user.getCommunityId
			 * ().toString()).get(0).getFullName();
			 */
			mv.addObject("fullName", name);
		}
		if (user.getrUserDefault() != null) {
			if (user.getrUserDefault().getAllergy() != null) {
				sb.append(user.getrUserDefault().getAllergy());
				sb.append(",");
			}
			if (user.getrUserDefault().getEating() != null) {
				sb.append(user.getrUserDefault().getEating());
				sb.append(",");
			}
			if (user.getrUserDefault().getCostType() != null) {
				sb.append(user.getrUserDefault().getCostType());
				sb.append(",");
			}
			if (user.getrUserDefault().getTrouble() != null) {
				sb.append(user.getrUserDefault().getTrouble());
			}
			if (sb.toString() != null) {
				mv.addObject("array", sb.toString());
			}
		}
		return mv;
	}

	/**
	 * 
	 * @param user
	 * @param userId
	 * @param rUserDefault
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/director/getRUserById")
	public ModelAndView getRUserById(HttpSession session, Long userId)
			throws IllegalAccessException, InvocationTargetException {

		ModelAndView mv = new ModelAndView("director/users/usermodify");
		RUser user = rUserService.findById(userId);
		List<OCountry> ocount = springDataPool.getPCountryList(user
				.getCommunityId());
		OCountry commit = springDataPool.getCountry(user.getCommunityId());
		OCountry street = springDataPool.getCountry(commit.getParentId());
		OCountry city = springDataPool.getCountry(street.getParentId());
		List<OCountry> occom = springDataPool.getPCountryList(commit
				.getParentId());
		List<OCountry> ocstreet = springDataPool.getPCountryList(street
				.getParentId());

		com.anticw.aged.vo.director.DirectorUserVO dirUser = new com.anticw.aged.vo.director.DirectorUserVO();
		BeanUtils.copyProperties(dirUser, user);
		session.setAttribute("dirUser", dirUser);
		StringBuffer sb = new StringBuffer();
		mv.addObject("user", user);
		if (user.getNation() != null) {
			// 根据ID查询字典表中的民族
			List<OCategoryItem> listCategory = categoryItemService
					.findCategoryName(user.getNation());
			mv.addObject("categorys", categoryItemService
					.findCategory(listCategory.get(0).getCategoryId()));
		} else {
			// 109是所有民族的分类
			mv.addObject("categorys", categoryItemService.findCategory(109));
		}
		// 查询所有社区
		mv.addObject("country", oCountryService.getCountryAll());
		if (user.getCommunityId() != ' ' || user.getCommunityId() != null) {
			String name = oCountryService.getCountryById(user.getCommunityId())
					.getName();
			String fullName = oCountryService
					.getParentByIds(user.getCommunityId().toString()).get(0)
					.getFullName();
			mv.addObject("fullName", name);
		}

		if (user.getrUserDefault() != null) {
			if (user.getrUserDefault().getAllergy() != null) {
				sb.append(user.getrUserDefault().getAllergy());
				sb.append(",");
			}
			if (user.getrUserDefault().getEating() != null) {
				sb.append(user.getrUserDefault().getEating());
				sb.append(",");
			}
			if (user.getrUserDefault().getCostType() != null) {
				sb.append(user.getrUserDefault().getCostType());
				sb.append(",");
			}
			if (user.getrUserDefault().getTrouble() != null) {
				sb.append(user.getrUserDefault().getTrouble());
			}
			if (sb.toString() != null) {
				mv.addObject("array", sb.toString());
			}
		}
		mv.addObject("city", city);
		mv.addObject("street", street);
		mv.addObject("occom", occom);
		mv.addObject("ocstreet", ocstreet);
		return mv;
	}

	@Autowired
	private RUserService userService;

	@RequestMapping("/director/addRUser")
	public ModelAndView addUser(RUser user, HttpSession session,
			RUserDefault rUserDefault, String nameL, String mobilePhoneL) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView(new RedirectView(
				"/director/userlist"));
		user.setCreatedBy(userVo.getName());
		user.setChangedBy(userVo.getName());
		long uid = rUserService.simplenessUser(user);
		RUserDefault userDefaults=new RUserDefault();
		userDefaults.setrUser(user);
		if(!userVo.isSuper_()){
			//添加医生和护士信息到
			//根据创建人的ID查询hgroup表中的护士和医生
			AUser aUser=venderService.getAUserByName(user.getCreatedBy());
			HGroup group=groupService.findByUserId(aUser.getId()).get(0);
			userDefaults.setDoctor(group.getDoctor());
			userDefaults.setNurse(group.getNurse());
		}
		userDefaults.setCreateBy(userVo.getName());
		userDefaults.setCreateTime(new Date());
		rUserDefaultService.saveRUserDefault(userDefaults);
		// 添加数据到h_group_user表中
		if (!userVo.isSuper_()) {
			hGroupUserService.save(session, uid);
		}
		return mv;
	}

	@Autowired
	private FileHandle fileHandle;

	@RequestMapping("/director/modifyRUser")
	public ModelAndView modifyRUser(RUser user, HttpSession session,
			@RequestParam(value = "pic", required = false) MultipartFile pic,
			RUserDefault rUserDefault, String nameL, String mobilePhoneL,Integer type)
			throws Exception {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		Date date = new Date();
		RUser ruser = rUserService.findById(user.getId());
		if (!pic.isEmpty()) {
			String url = fileHandle.uploadPics(pic);
			ruser.setHead(url);
		}
		ruser.setAddr(user.getAddr());
		//ruser.setState(1);
		ruser.setAge(user.getAge());
		ruser.setName(user.getName());
		ruser.setGender(user.getGender());
		ruser.setNation(user.getNation());
		ruser.setCommunityId(user.getCommunityId());
		ruser.setMarry(user.getMarry());
		ruser.setJobCond(user.getJobCond());
		ruser.setEducation(user.getEducation());
		ruser.setContactPhone(user.getContactPhone());
		ruser.setMobilePhone(user.getMobilePhone());
		ruser.setChangedAt(date);
		ruser.setChangedBy(userVo.getName());
		ruser.setIdCardNo(user.getIdCardNo());
		rUserService.update_shenhe(ruser);
		// 根据ruser的Id去r_contact表中查询
		if(!("").equals(nameL)&&!("").equals(mobilePhoneL)){
			//根据ruser的Id去r_contact表中查询
			if(ruser.getrContact()==null){
				userService.addRcontacts(ruser,nameL,mobilePhoneL);
			}else{
				/***************************存在问题********************************/
				if(ruser.getrContact().get(0).getName()!=nameL||ruser.getrContact().get(0).getMobilePhone()!=mobilePhoneL){
				RContact contact=userService.rContactsById(ruser.getrContact().get(0).getId());
				contact.setName(nameL);
				contact.setMobilePhone(mobilePhoneL);
				userService.modifyRcontacts(contact);
				}
			}
		}
		if (ruser.getrUserDefault() != null) {
			// y
			Integer id = ruser.getrUserDefault().getId();
			RUserDefault userDefault = rUserDefaultService
					.findRUserDefalutById(id);
			userDefault.setDrinking(rUserDefault.getDrinking());
			userDefault.setEating(rUserDefault.getEating());
			userDefault.setFamily(rUserDefault.getFamily());
			userDefault.setHeight(rUserDefault.getHeight());
			userDefault.setWeight(rUserDefault.getWeight());
			userDefault.setCostType(rUserDefault.getCostType());
			userDefault.setSmoking(rUserDefault.getSmoking());
			userDefault.setAllergy(rUserDefault.getAllergy());
			userDefault.setTrouble(rUserDefault.getTrouble());
			userDefault.setMedicalHistory(rUserDefault.getMedicalHistory());
			userDefault.setPositionHospital(rUserDefault.getPositionHospital());
			userDefault.setChangeBy(userVo.getName());
			userDefault.setChangeTime(date);
			userDefault.setrUser(ruser);

			rUserDefaultService.update_shenhe(userDefault);
		}
		ModelAndView mv;
		if(type!=null){
			 mv = new ModelAndView("redirect:/director/user?userId="
					+ user.getId());
		}else{
			mv = new ModelAndView(
					"redirect:/director/toassess?userId=" + user.getId());
		}
		return mv;
	}

	@RequestMapping("/director/managementconsultation")
	public ModelAndView consultation(HttpSession session, DateParamVO dateCond,
			Integer statas, Integer desc, PageParamVO page) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (dateCond.getEnd() == null || dateCond.getStart() == null) {
			Date date = new Date();
			dateCond.setStart(DateUtil.getFirstDayInMonth(date));
			dateCond.setEnd(DateUtil.getLastDayInMonth(date));
		}
		if (statas != null && statas.equals(99)) {
			statas = null;
		}
		ModelAndView mv = new ModelAndView("/director/consu/consultation");
		Page<HConsultation> pages = hConsultationService.pageHConsultation(
				dateCond, userVo.getId(), statas, desc, page);
		mv.addObject("page", pages);
		mv.addObject("dateCond", dateCond);
		mv.addObject("desc", desc);
		if (statas == null) {
			statas = 99;
		}
		mv.addObject("status", statas);
		return mv;
	}

	@RequestMapping("/director/hconsultation")
	public ModelAndView consultation(Integer id, Long userId)
			throws BusinessException {
		/*
		 * HConsultation h=hConsultationService.getHConsultation(id); AUser
		 * user=venderService.getAUser(h.getGroupId());
		 */
		ModelAndView mv = new ModelAndView(new RedirectView(
				"/director/hconsultationajax?id=" + id + "&userId=" + userId));
		/*
		 * mv.addObject("ruser", user.getName()); mv.addObject("HConsultation",
		 * h);
		 */
		return mv;
	}

	@RequestMapping("/director/hconsultationajax")
	public ModelAndView listResult(Long userId, PageParamVO page,
			DateParamVO dateCond, Integer desc, Integer id)
			throws IllegalAccessException, InvocationTargetException {
		HConsultation h = hConsultationService.getHConsultation(id);
		ModelAndView mv = new ModelAndView("/director/consu/hconsultation");
		if (dateCond.getEnd() == null || dateCond.getStart() == null) {
			Date date = new Date();
			dateCond.setStart(DateUtil.getFirstDayInMonth(date));
			dateCond.setEnd(DateUtil.getLastDayInMonth(date));
		}
		page.setPage(50);
		Page<HConsultationVO> vos = hConsultationService.listResult(userId,
				page, dateCond, desc);
		// 根据用户ID查询巡诊组
		HGroup group = groupService.findByUserId(h.getGroupId()).get(0);
		if (group != null) {
			mv.addObject("xunZuName", group.getUserName());
		}
		/* mv.addObject("createBy", group.getUserName()); */
		mv.addObject("HConsultation", h);
		mv.addObject("vos", vos.getResult());
		mv.addObject("page", vos.getPageNo());
		mv.addObject("num", vos.getPageSize());
		mv.addObject("userId", userId);
		mv.addObject("cid", id);
		return mv;

	}

	@RequestMapping("/director/updateTrxt")
	public @ResponseBody String listResult(Integer id, String ultimateness)
			throws IllegalAccessException, InvocationTargetException {
		HConsultation h = hConsultationService.findById(id);
		h.setUltimateness(ultimateness);
		h.setState("2");
		hConsultationService.update(h);
		return "添加成功!";
	}

	@RequestMapping("/director/modifyHConsulation")
	public String modifyHConsulation(HttpSession session, HConsultation hc,
			String applyTime) throws ParseException {
		HConsultation hcs = hConsultationService.findById(hc.getId());
		Date date = DateUtil.parseStrToDateTimem(applyTime);
		hcs.setApplyTime(date);
		hcs.setAddress(hc.getAddress());
		hcs.setDepartment(hc.getDepartment());
		hcs.setChangeTime(new Date());
		hcs.setContent(hc.getContent());
		hcs.setState("1");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		hcs.setChangeBy(userVo.getName());
		hConsultationService.modifyHConsultation(hcs);
		return "redirect:/director/managementconsultation";
	}

	@RequestMapping("/director/toassess")
	public ModelAndView toassess(Long userId) {
		ModelAndView mv = new ModelAndView("/director/assess_record_qa");
		mv.addObject("userId", userId);
		return mv;
	}

	@RequestMapping("/director/assess/record/commit")
	public ModelAndView commitAssess(HttpSession session, AssessRecordVo record)
			throws Exception {
		// 当前用户信息
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 当前用户名
		String userName = userVO.getName();
		RUser ruser = rUserService.findById(record.getUserId());
		if(ruser.getState()==null||ruser.getState()==0){
			ruser.setState(1);
			rUserService.update(ruser);
		}
		assessService.addAssessRecord(record, userName);
		ModelAndView mv = new ModelAndView("redirect:/director/user?userId="
				+ record.getUserId());
		return mv;
	}
}
