package com.anticw.aged.controller.professional.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NTrainStaff;
import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.bean.NVolunteerTrain;
import com.anticw.aged.bean.NVolunteerTrainRecord;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.service.professional.activity.LogSheetSrevice;
import com.anticw.aged.service.professional.activity.NActivityPlanService;
import com.anticw.aged.service.professional.activity.NVolunteerServiceRecordService;
import com.anticw.aged.service.professional.activity.NVolunteerTrainRecordService;
import com.anticw.aged.service.professional.activity.NVolunteerTrainService;
import com.anticw.aged.service.professional.activity.VolunteerService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.NVolunteerTrainVO;
import com.anticw.aged.vo.professional.activity.VolunteerTrainingRecordVo;
import com.anticw.aged.vo.professional.activity.VolunteerVO;
import com.anticw.aged.vo.professional.activity.VolunteerVOTwo;
import com.anticw.aged.vo.professional.vender.MVenderSiteVO1;

/**
 * Created by WSS on 2015/9/10.<br>
 */
@Controller
@RequestMapping("/professional/volunteer/*")
public class VolunteerCtl {
	@Autowired
	VolunteerService volunteerService;
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private NVolunteerTrainService nVolunteerTrainService;
	@Autowired
	private NVolunteerTrainRecordService nVolunteerTrainRecordService;
	@Autowired
	private LogSheetSrevice logSheetSrevice;
	@Autowired
	private NVolunteerServiceRecordService nVolunteerServiceRecordService;
	@Autowired
	private ActivityManagerService activityManagerService;
	@Autowired
	private VenderService venderService;
	@Autowired
	private PermissionService permissionService;

	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private NActivityPlanService nActivityPlanService;

	@RequestMapping("index")
	public ModelAndView toIndex(HttpServletRequest req, HttpSession session,
			PageParamVO page, Integer communityId, Integer site,
			Integer inceont, Integer inceonttwo) {
		ModelAndView mav = new ModelAndView(
				"/professional/activity/volunteer/index");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// List<OCountry>
		// oCountry=oCountryService.getCountryByIds(userVo.getCommunityId());
		// 判断是服务商还是员工

		if (communityId == null || communityId == 0) {
			communityId = inceont;
		}
		if (site == null || site == 0) {
			site = inceonttwo;
		}
		String name = userVo.getName();
		if (userVo.getVenderId() != null) {
			AUser aUser = activityManagerService.findName(name,
					userVo.getVenderId());
			if (aUser.getSuper_() == true) {
				if (communityId == null || communityId == 0) {
					Page<VolunteerVO> volunteerVOs = volunteerService
							.seeNVolunteer(page.getPage(), page.getNum(),
									Long.toString(userVo.getId()), site);
					mav.addObject("page", volunteerVOs);
				} else {
					Page<VolunteerVO> volunteerVOs = volunteerService
							.seeNVolunteers(page.getPage(), page.getNum(),
									Long.toString(userVo.getId()), communityId,
									site);
					mav.addObject("page", volunteerVOs);
				}
			} else {
				MVender m = activityManagerService.getMvender(userVo
						.getVenderId());
				if (communityId == null || communityId == 0) {
					Page<VolunteerVO> volunteerVOs = volunteerService
							.seeNVolunteers(page.getPage(), page.getNum(), m
									.getUserId().toString(), userVo
									.getCommunityId(), site);
					mav.addObject("page", volunteerVOs);
				} else {
					Page<VolunteerVO> volunteerVOs = volunteerService
							.seeNVolunteers(page.getPage(), page.getNum(), m
									.getUserId().toString(), communityId, site);
					mav.addObject("page", volunteerVOs);
				}
			}
		}
		List<MVenderSite> mVenderSite = mVenderSiteService
				.fingByVenderId(userVo.getVenderId());
		mav.addObject("mVenderSite", mVenderSite);
		mav.addObject("communityId", communityId);
		mav.addObject("site", site);
		// mav.addObject("oCountry", oCountry);
		return mav;
	}

	/*
	 * @RequestMapping("list") public ModelAndView volunteerList(HttpSession
	 * session,PageParamVO page,int communityId) { // 从session中获取用户信息
	 * ModelAndView mav = new
	 * ModelAndView("/professional/activity/volunteer/list"); UserVO userVo =
	 * (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
	 * List<OCountry>
	 * oCountry=oCountryService.getCountryByIds(userVo.getCommunityId());
	 * //判断是服务商还是员工 String name=userVo.getName(); long userId=userVo.getId();
	 * if(userVo.getVenderId()!=null){ AUser
	 * aUser=activityManagerService.findName(name,userVo.getVenderId());
	 * if(aUser.getSuper_()==true){ if(communityId==0){ Page<NVolunteer>
	 * volunteerVOs =
	 * volunteerService.seeNVolunteer(page.getPage(),page.getNum()
	 * ,Long.toString(userVo.getId())); mav.addObject("page", volunteerVOs);
	 * }else{ Page<NVolunteer> volunteerVOs =
	 * volunteerService.seeNVolunteers(page
	 * .getPage(),page.getNum(),Long.toString(userVo.getId()),communityId);
	 * mav.addObject("page", volunteerVOs); } }else{ MVender
	 * m=activityManagerService.getMvender(userVo.getVenderId());
	 * if(communityId==0){ Page<NVolunteer> volunteerVOs =
	 * volunteerService.seeNVolunteers
	 * (page.getPage(),page.getNum(),m.getUserId()
	 * .toString(),userVo.getCommunityId()); mav.addObject("page",
	 * volunteerVOs); }else{ Page<NVolunteer> volunteerVOs =
	 * volunteerService.seeNVolunteers
	 * (page.getPage(),page.getNum(),m.getUserId().toString(),communityId);
	 * mav.addObject("page", volunteerVOs); } } } mav.addObject("communityId",
	 * communityId); mav.addObject("oCountry", oCountry); return mav; }
	 */
	/**
	 * 跳转页面,修改
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("toUpdate")
	public ModelAndView volunteerListById(HttpSession session,
			@RequestParam("volunteerId") int volunteerId)
			throws IllegalAccessException, InvocationTargetException {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<VolunteerVO> volunteerVOs = volunteerService.ListById(volunteerId);
		ModelAndView mav = new ModelAndView(
				"/professional/activity/volunteer/update");
		List<OCountry> oCuntry = oCountryService.getParentById(userVo
				.getCommunityId());
		mav.addObject("oCuntry", oCuntry);

		mav.addObject("list_vo", volunteerVOs);
		return mav;
	}

	/**
	 * 跳转页面，删除
	 */
	@RequestMapping("toDelete")
	public String deleteById(HttpSession session,
			@RequestParam("volunteerId") int volunteerId) {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		long userId = userVo.getId();
		volunteerService.deleteById(volunteerId, userId);
		return "redirect:/professional/volunteer/index?communityId=" + 0;
	}

	/**
	 * do修改
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("update")
	public String updateVolunteer(HttpSession session,
			VolunteerVOTwo volunteerVO) throws IllegalAccessException,
			InvocationTargetException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		long userId = userVo.getId();

		volunteerService.updateById(volunteerVO, userId);

		return "redirect:/professional/volunteer/index?communityId=" + 0;
	}

	/*
	 * @RequestMapping("gotoAdd") public ModelAndView
	 * gotoAddVolunteer(HttpSession session) { UserVO userVo =
	 * (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
	 * List<OCountry>
	 * oCuntry=oCountryService.getParentById(userVo.getCommunityId());
	 * ModelAndView mv=new ModelAndView("/professional/activity/volunteer/add");
	 * mv.addObject("oCuntry", oCuntry); return mv; }
	 */
	/**
	 * 加载所有的培训信息
	 * 
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("see_train")
	public ModelAndView addTrain(HttpSession session, PageParamVO page,
			Integer inceont, Integer inceonttwo) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/see_train");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// List<OCountry>
		// oCountry=oCountryService.getCountryByIds(userVo.getCommunityId());

		List<MVenderSite> mVenderSite = mVenderSiteService
				.fingByVenderId(userVo.getVenderId());

		String name;
		AUser aUser = activityManagerService.findName(userVo.getName(),
				userVo.getVenderId());
		if (aUser.getSuper_() == true) {
			name = aUser.getName();
			Page<NVolunteerTrain> vc = nVolunteerTrainService.getList(
					page.getPage(), page.getNum(), name, inceont, inceonttwo);
			mv.addObject("page", vc);
		} else {
			// 员工自带站点
			String siteIds = aUser.getSiteIds();
			MVender m = activityManagerService.getMvender(userVo.getVenderId());
			name = m.getContact();
			Page<NVolunteerTrainVO> vcs = nVolunteerTrainService.getList(
					page.getPage(), page.getNum(), name, inceont, siteIds,
					inceonttwo);
			mv.addObject("page", vcs);
		}
		mv.addObject("communityId", inceont);
		mv.addObject("site", inceonttwo);

		// 获取专业服务商人员分配添加人 如果添加人是超管，那么NVolunteerTrain加载应该是服务上添加+员工添加
		// mv.addObject("oCountry", oCountry);
		mv.addObject("mVenderSite", mVenderSite);

		return mv;
	}

	/**
	 * 查询培训详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("details")
	public ModelAndView details(int id) {
		NVolunteerTrain nVolunteerTrain = nVolunteerTrainService
				.getNVolunteerTrain(id);
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/details_train");
		mv.addObject("nVolunteerTrain", nVolunteerTrain);
		return mv;
	}

	/**
	 * 跳转到修改培训内容页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("redact")
	public ModelAndView redact(int id) {
		NVolunteerTrain nVolunteerTrain = nVolunteerTrainService
				.getNVolunteerTrain(id);
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/redact_train");
		mv.addObject("nVolunteerTrain", nVolunteerTrain);
		return mv;
	}

	/**
	 * 删除培训内容
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delete_train")
	public String deleteTrain(int id) {
		nVolunteerTrainService.deleteNVolunteerTrain(id);
		// 删除旗下签到记录
		List<NVolunteerTrainRecord> li = nVolunteerTrainRecordService
				.getList(id);
		for (NVolunteerTrainRecord n : li) {
			nVolunteerTrainRecordService.delete(n);
		}
		return "redirect:/professional/volunteer/see_train";
	}

	/**
	 * 修改培训内容
	 * 
	 * @param nVolunteerTrain
	 * @return
	 */
	@RequestMapping("update_train")
	public String updateTrain(HttpSession session,
			NVolunteerTrain nVolunteerTrain, String start, String end) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		Date sta = DateUtil.parseStrToDateTimem(start);
		Date ed = DateUtil.parseStrToDateTimem(end);
		nVolunteerTrain.setTraindate(sta);
		nVolunteerTrain.setEndTime(ed);
		Float f = Math
				.abs((float) (ed.getTime() - sta.getTime()) / 1000 / 60 / 60);
		nVolunteerTrain.setTrainTimes(f);
		Date d = new Date();
		NVolunteerTrain nv = nVolunteerTrainService
				.getNVolunteerTrain(nVolunteerTrain.getId());
		List<NTrainStaff> nTrainStaff = nVolunteerTrainService
				.getTrainStaff(nVolunteerTrain.getId());
		nVolunteerTrainService.deletenTrainStaff(nTrainStaff);
		add(nVolunteerTrain, userVo, nVolunteerTrain.getId());
		nv.setAvaliable(true);
		nv.setChangedAt(d);
		nv.setCommunityIds(nVolunteerTrain.getCommunityIds());
		nv.setSiteIds(nVolunteerTrain.getSiteIds());
		nv.setChangedBy(userVo.getName());
		nv.setTheme(nVolunteerTrain.getTheme());
		nv.setTrainContent(nVolunteerTrain.getTrainContent());
		nv.setTraindate(nVolunteerTrain.getTraindate());
		nv.setTrainPlace(nVolunteerTrain.getTrainPlace());
		nv.setTrainTimes(nVolunteerTrain.getTrainTimes());
		nv.setVersion((short) (nv.getVersion() + 1));
		nv.setEndTime(nVolunteerTrain.getEndTime());
		nVolunteerTrainService.updateNVolunteerTrain(nv);
		return "redirect:/professional/volunteer/see_train";
	}

	@RequestMapping("add")
	public String addVolunteer(HttpSession session, VolunteerVO volunteerVO)
			throws IllegalAccessException, InvocationTargetException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String name = userVo.getName();
		long userId = userVo.getId();
		if (userVo.getVenderId() != null) {
			AUser aUser = activityManagerService.findName(name,
					userVo.getVenderId());
			if (aUser.getSuper_() == true) {
				volunteerService.addVolunteer(volunteerVO, userId);
			} else {
				MVender m = activityManagerService.getMvender(userVo
						.getVenderId());
				volunteerService.addVolunteer(volunteerVO, m.getUserId());
			}
		}
		@SuppressWarnings("unused")
		int communityId = Integer.parseInt(volunteerVO.getCommunity());
		return "redirect:/professional/volunteer/index";
	}

	@RequestMapping("service")
	public ModelAndView toService(HttpSession session,
			@RequestParam("volunteerId") int volunteerId, String date)
			throws IllegalAccessException, InvocationTargetException {
		// 从session中获取用户信息
		ModelAndView mav = new ModelAndView(
				"/professional/activity/volunteer/record_service");
		NVolunteer nv = volunteerService.findById(volunteerId);
		List<VolunteerVO> volunteerVOs = volunteerService.ListById(volunteerId);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<String> name = new ArrayList<String>();
		if (userVo.isSuper_() != true) {
			name.add(venderService.getVender(userVo.getVenderId()).getContact());
			name.add(userVo.getName());
		} else {
			List<AUser> auser = permissionService.getNormalUsers(userVo
					.getVenderId());
			for (AUser a : auser) {
				name.add(a.getName());
			}
		}
		// String name=userVo.getName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date1 = null;
		if (date != null) {
			try {
				date1 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (date == null) {
			date1 = new Date();
		}
		Date start = DateUtil.getFirstDayInMonth(date1);
		Date end = DateUtil.getLastDayInMonth(date1);
		VolunteerTrainingRecordVo volunteerTrainingRecordVo = logSheetSrevice
				.getListPlan(name, start, end, volunteerId);
		int num = volunteerTrainingRecordVo.getSignIn().size();

		// 获取培训时长和活动时长
		List<String> tarinId = nVolunteerTrainRecordService
				.getListgetListvolunteer(volunteerId);
		float trainTimes = 0;
		String tarinIds = StringUtils.join(tarinId.toArray(), ",");
		if (tarinIds != "") {
			List<NVolunteerTrain> nVolunteerTrain = nVolunteerTrainService
					.getListNVolunteerTrains(tarinIds, start, end);
			for (NVolunteerTrain n : nVolunteerTrain) {
				trainTimes += n.getTrainTimes();
			}
		}

		List<Integer> activityId = nVolunteerServiceRecordService
				.getListNVolunteerService(volunteerId);
		String activityIds = StringUtils.join(activityId.toArray(), ",");
		float activeTime = 0;
		if (tarinIds != "") {
			List<Float> f = activityManagerService.findNActivityPlan(
					activityIds, start, end);
			for (float fi : f) {
				activeTime += fi;
			}
		}
		float sumTime = trainTimes + activeTime;
		mav.addObject("list_vo", volunteerVOs);
		mav.addObject("num", num);
		mav.addObject("sumTime", sumTime);
		mav.addObject("trainTimes", trainTimes);
		mav.addObject("activeTime", activeTime);
		mav.addObject("month", DateUtil.parseDateToString(date1, "M"));
		if (nv.getSiteId() != null) {
			mav.addObject("siteName",
					mVenderSiteService.fingById(nv.getSiteId()).getSiteName());
		}
		mav.addObject("volunteerTrainingRecordVo", volunteerTrainingRecordVo);
		return mav;
	}

	@RequestMapping("train")
	public ModelAndView toTrain() {
		return new ModelAndView("/professional/activity/volunteer/record_train");
	}

	/**
	 * 进入志愿者培训签到
	 * 
	 * @return
	 */
	@RequestMapping("train_add_volunteer")
	public ModelAndView toVolunteerAdd(HttpSession session, int id,
			String communityIds, String siteIds) {
		ModelAndView mav = new ModelAndView(
				"/professional/activity/volunteer/train_add_volunteer");
		// 目前获取所有的志愿者改为只能获取自己的
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// List<OCountry>
		// oCountry=oCountryService.getCountryByIds(userVo.getCommunityId());
		// 未签到
		List<VolunteerVO> volunteerVOs = new ArrayList<VolunteerVO>();
		// 已签到
		List<VolunteerVO> volunteerVO = new ArrayList<VolunteerVO>();
		// 判断是服务商还是员工
		NVolunteerTrain nVolunteerTrain = nVolunteerTrainService
				.getNVolunteerTrain(id);
		String communityIdss = nVolunteerTrain.getCommunityIds();
		String siteIdss = nVolunteerTrain.getSiteIds();
		if (communityIdss != null) {
			communityIdss = communityIdss.substring(1, communityIdss.length());
		}
		if (siteIdss != null) {
			siteIdss = siteIdss.substring(1, siteIdss.length());
		}

		if (siteIds == null || siteIds == "") {
			siteIds = siteIdss;
		}
		String name = userVo.getName();

		if (userVo.getVenderId() != null) {
			AUser aUser = activityManagerService.findName(name,
					userVo.getVenderId());
			if (aUser.getSuper_() == true) {
				if (communityIds == null || communityIds == "") {
					communityIds = communityIdss;
				}
				List<OCountry> oCountry = oCountryService
						.getCountryByIds(communityIdss);
				mav.addObject("oCountry", oCountry);
				// 是服务商，根据服务商加载出所有的志愿者，包括员工添加的志愿者
				volunteerVOs = volunteerService.selectByTrainRecordId(id,
						communityIds, siteIdss);
				volunteerVO = volunteerService.selectTrainRecordId(id,
						communityIds, siteIdss);
				List<MVenderSite> mVenderSite = mVenderSiteService
						.findByIds(siteIdss);
				mav.addObject("mVenderSite", mVenderSite);
			} else {
				// 获取到当前的培训信息
				NVolunteerTrain nvt = nVolunteerTrainService
						.getNVolunteerTrain(id);
				String commtis = null;
				String site_main = null;
				// 获取培训中的站点Id
				String n_site = nvt.getSiteIds();
				// 获取志愿者站点ids
				String m_site = aUser.getSiteIds();
				// 员工所能查看的站点信息
				site_main = selectId(m_site, n_site);

				// 根据站点Id获取社区id
				List<MVenderSite> _mVenderSite = mVenderSiteService
						.findByIds(site_main);
				mav.addObject("mVenderSite", _mVenderSite);
				for (MVenderSite m : _mVenderSite) {
					commtis += m.getCommunityIds();
					commtis += ",";
				}
				String commtismain = nvt.getCommunityIds();
				commtis = commits(commtis, commtismain);
				if (communityIds == null || communityIds == "") {
					communityIds = commtis;
				}
				List<OCountry> oCountry = oCountryService
						.getCountryByIds(commtis);
				mav.addObject("oCountry", oCountry);
				if (communityIds != null && communityIds != "") {
					volunteerVOs = volunteerService.selectByTrainRecordId(id,
							communityIds, siteIdss);
					volunteerVO = volunteerService.selectTrainRecordId(id,
							communityIds, siteIdss);
				}
			}

		}
		mav.addObject("nVolunteer", volunteerVO);
		mav.addObject("list_vo", volunteerVOs);
		mav.addObject("trainId", id);
		return mav;
	}

	public static <T> String selectId(String t1, String t2) {
		t2 = t2.substring(1, t2.length());
		String[] ts = t2.split(",");
		String[] ts1 = t1.split(",");
		List<String> list1 = Arrays.asList(ts1);
		String site = "";
		for (String t : ts) {
			if (list1.contains(t)) {
				site += t;
				site += ",";
			}
		}
		if (site != "") {
			site = site.substring(0, site.length() - 1);
		}
		return site;
	}

	public static <T> String commits(String t1, String t2) {
		t1 = t1.substring(5, t1.length() - 1);
		t2 = t2.substring(1, t2.length());
		String[] ts = t2.split(",");
		String[] ts1 = t1.split(",");
		List<String> list1 = Arrays.asList(ts1);
		String site = "";
		for (String t : ts) {
			if (list1.contains(t)) {
				site += t;
				site += ",";
			}
		}
		if (site != "") {
			site = site.substring(0, site.length() - 1);
		}
		return site;
	}

	/**
	 * 去添加培训记录页面
	 * 
	 * @return
	 */
	@RequestMapping("train_add_one")
	public ModelAndView toTrainAdd() {
		ModelAndView mav = new ModelAndView(
				"/professional/activity/volunteer/train_add_one");
		return mav;
	}

	/**
	 * 添加培训记录
	 * 
	 * @return
	 */

	@RequestMapping("add_train_one")
	public String trainAdd(HttpSession session,
			NVolunteerTrain nVolunteerTrain, String start, String end) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		nVolunteerTrain.setCreatedBy(userVo.getName());
		nVolunteerTrain.setCreatedAt(new Date());
		nVolunteerTrain.setVersion((short) 0);
		nVolunteerTrain.setAvaliable(true);
		Date sta = DateUtil.parseStrToDateTimem(start);
		Date ed = DateUtil.parseStrToDateTimem(end);
		nVolunteerTrain.setTraindate(sta);
		nVolunteerTrain.setEndTime(ed);
		Float f = Math
				.abs((float) (ed.getTime() - sta.getTime()) / 1000 / 60 / 60);
		nVolunteerTrain.setTrainTimes(f);
		Integer trainId = nVolunteerTrainService
				.addNVolunteerTrain(nVolunteerTrain);

		add(nVolunteerTrain, userVo, trainId);
		return "redirect:/professional/volunteer/see_train";
	}

	private void add(NVolunteerTrain nVolunteerTrain, UserVO userVo,
			Integer trainId) {
		String stites = nVolunteerTrain.getSiteIds();
		stites = stites.substring(1, stites.length());
		String[] site = stites.split(",");
		for (String s : site) {
			NTrainStaff ns = new NTrainStaff();
			ns.setCreateAt(new Date());
			ns.setCreateBy(userVo.getName());
			ns.setSiteId(Long.parseLong(s));
			ns.setTrainId(trainId);
			nVolunteerTrainService.addnTrainStaff(ns);
		}
	}

	/**
	 * 添加培训签到志愿者
	 * 
	 * @param session
	 * @param trainId
	 * @param id
	 * @return
	 */
	@RequestMapping("add_nVolunteer")
	public String nVolunteerAdd(HttpSession session, int trainId, int[] nid) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String name = "";
		AUser aUser = activityManagerService.findName(userVo.getName(),
				userVo.getVenderId());
		if (aUser.getSuper_() == true) {
			name = aUser.getName();
		} else {
			MVender m = activityManagerService.getMvender(userVo.getVenderId());
			name = m.getContact();
		}
		Date createdAt = new Date();
		for (int ids : nid) {
			NVolunteerTrainRecord nv = new NVolunteerTrainRecord();
			nv.setVolunteerId(ids);
			nv.setTrainId(trainId);
			nv.setCreatedBy(name);
			nv.setCreatedAt(createdAt);
			nv.setVersion((short) 0);
			nv.setAvaliable(true);
			nVolunteerTrainRecordService.addNVolunteerTrainRecord(nv);
		}
		return "redirect:/professional/volunteer/train_add_volunteer?id="
				+ trainId;
	}

	/**
	 * 查看签到志愿者
	 * 
	 * @return
	 */
	@RequestMapping("see_nVolunteer")
	public ModelAndView seeNVolunteer(HttpSession session, int trainId) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/see_nVolunteer_train");
		if (nVolunteerTrainRecordService.getList(trainId).size() != 0) {
			List<NVolunteerTrainRecord> nv = nVolunteerTrainRecordService
					.getList(trainId);
			String Ids = "";
			for (NVolunteerTrainRecord n : nv) {
				Ids += n.getVolunteerId();
				Ids += ",";
			}
			Ids = Ids.substring(0, Ids.length() - 1);
			List<NVolunteer> nVolunteer = volunteerService.findNVolunters(Ids);
			mv.addObject("nVolunteer", nVolunteer);
		}
		mv.addObject("trainId", trainId);
		return mv;
	}

	@RequestMapping("delete_nVolunteer_train")
	public String deleteNVolunteerTrain(HttpSession session, int volunteerId,
			int trainId) {
		NVolunteerTrainRecord nv = nVolunteerTrainRecordService
				.getNVolunteerTrainRecor(volunteerId, trainId);
		nVolunteerTrainRecordService.deleteNVolunteerTrainRecord(nv.getId());
		return "redirect:/professional/volunteer/train_add_volunteer?id="
				+ trainId;
	}

	@RequestMapping("record_train")
	public ModelAndView getRecordTrain(HttpSession session, String date) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/record_train");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String name;
		String venderId;
		AUser aUser = activityManagerService.findName(userVo.getName(),
				userVo.getVenderId());
		if (aUser.getSuper_() == true) {
			name = aUser.getName();
			venderId = aUser.getId() + "";
		} else {
			MVender m = activityManagerService.getMvender(userVo.getVenderId());
			name = m.getContact();
			venderId = m.getUserId() + "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date1 = null;
		if (date != null) {
			try {
				date1 = sdf.parse(date);
				mv.addObject("when", date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (date == null) {
			date1 = new Date();
		}
		Date start = DateUtil.getFirstDayInMonth(date1);
		Date end = DateUtil.getLastDayInMonth(date1);

		List<VolunteerTrainingRecordVo> volunteerTrainingRecordVo = logSheetSrevice
				.getList(name, start, end, venderId);
		List<Date> dates = logSheetSrevice.getListDate(name, start, end);
		// 当月累计培训次数

		int num = dates.size();
		mv.addObject("volunteerTrainingRecordVo", volunteerTrainingRecordVo);
		mv.addObject("dates", dates);
		mv.addObject("num", num);
		return mv;
	}

	@RequestMapping("add_content")
	public void getAddContent(HttpServletRequest request,
			HttpServletResponse response, int volunteerId, Date addTime,
			String content) throws UnsupportedEncodingException {
		PrintWriter out = null;

		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nVolunteerServiceRecordService.nVolunteerServiceRecord(volunteerId,
				addTime) != null) {
			NVolunteerServiceRecord nv = nVolunteerServiceRecordService
					.nVolunteerServiceRecord(volunteerId, addTime);
			nv.setServiceItem(content);
			nVolunteerServiceRecordService.update(nv);
			out.print("保存成功");
		} else {
			out.print("未签到");
		}
	}

	/**
	 * 查看一条培训中 社区和站点
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("volunteerTraining_update")
	public @ResponseBody JSONObject get(Integer id) {
		JSONObject json = new JSONObject();
		NVolunteerTrain nv = nVolunteerTrainService.getNVolunteerTrain(id);
		String site = nv.getSiteIds();
		String communtyIds = nv.getCommunityIds();
		site = site.substring(1, site.length());
		communtyIds = communtyIds.substring(1, communtyIds.length());
		List<OCountry> oCountry = oCountryService.getCountryByIds(communtyIds);
		List<MVenderSite> mVenderSite = mVenderSiteService.findByIds(site);
		List<MVenderSiteVO1> vo = new ArrayList<MVenderSiteVO1>();
		if (mVenderSite.size() != 0) {
			for (MVenderSite ms : mVenderSite) {
				MVenderSiteVO1 v = new MVenderSiteVO1();
				v.setId((int) ms.getId());
				v.setSiteName(ms.getSiteName());
				vo.add(v);
			}
			json.put("mVenderSite", vo);
		}
		json.put("oCountry", oCountry);
		return json;
	}


	/**
	 * 跳转至志愿者填写量表页面
	 * 
	 * @return
	 */
	@RequestMapping("toLogin")
	public ModelAndView toLogin() {
		return new ModelAndView(
				"/professional/activity/volunteer/toLogin");
	}
	
	/**
	 * 跳转至志愿者填写量表页面
	 * 
	 * @return
	 */
	@RequestMapping("nVolunteerAssess")
	public ModelAndView toVolunteerAssess(String data, Integer volunteerId) {
		Date d = null;
		if (data == null || data == "") {
			d = new Date();
		} else {
			d = DateUtil.parseStrToDate(data);
		}
		DateParamVO dv = new DateParamVO(DateUtil.getFirstDayInMonth(d),
				DateUtil.getLastDayInMonth(d));
		List<NActivityPlan> plans=nActivityPlanService.getNActivityPlan(dv, volunteerId);
		Map<String,Integer> map=new HashMap<String, Integer>();
		for(NActivityPlan p:plans){
			map.put(DateUtil.formatDate(p.getPubdate(), "dd"), p.getId());
		}
		ModelAndView mv=new ModelAndView("/professional/activity/volunteer/volunteerAssessData");
		mv.addObject("plans", map);
		mv.addObject("volunteerId", volunteerId);
		mv.addObject("mon", DateUtil.parseDateToString(new Date(), "M"));
		return mv;
	}
	@RequestMapping("tonext")
	public @ResponseBody JSONObject totonext(String data, Integer volunteerId) {
		Date d = null;
		if (data == null || data == "") {
			d = new Date();
		} else {
			d = DateUtil.parseStrToDate(data);
		}
		DateParamVO dv = new DateParamVO(DateUtil.getFirstDayInMonth(d),
				DateUtil.getLastDayInMonth(d));
		List<NActivityPlan> plans=nActivityPlanService.getNActivityPlan(dv, volunteerId);
		Map<String,Integer> map=new HashMap<String, Integer>();
		for(NActivityPlan p:plans){
			map.put(DateUtil.formatDate(p.getPubdate(), "dd"), p.getId());
		}
		ModelAndView mv=new ModelAndView("/professional/activity/volunteer/volunteerAssessData");
		mv.addObject("plans", map);
		mv.addObject("volunteerId", volunteerId);
		JSONObject json=new JSONObject();
		json.put("plans", map);
		json.put("volunteerId", volunteerId);
		return json;
	}

	@RequestMapping("tonVolunteerAssess")
	public ModelAndView toVolunteerAssess_(Integer palnId, Integer volunteerId) {
		ModelAndView mv=new ModelAndView("/professional/activity/volunteer/volunteerAssess");
		mv.addObject("palnId", palnId);
		mv.addObject("volunteerId", volunteerId);
		NActivityPlan plan = nActivityPlanService.get(palnId);
		String siteId = plan.getSiteIds();
		NActivityPlan np = nActivityPlanService.getNext(plan.getId(),Integer.parseInt(siteId));
		mv.addObject("nextNActivityPlan", np);
		return mv;
	}
	
	/**
	 * 查询一条志愿者表中的 志愿者
	 * @param id
	 * @return
	 */
	@RequestMapping("findById")
	public @ResponseBody String get(int id) {
		NVolunteer nv = volunteerService.findById(id);
		if (nv != null) {
			String volunteerId = "id";
			NActivityPlan list = nActivityPlanService
					.findrByVolunteerId(volunteerId);
			if (list != null) {
				return list.getId() + "";
			} else {
				return "-1";
			}
		}
		return "0";
	}
	
	
}
