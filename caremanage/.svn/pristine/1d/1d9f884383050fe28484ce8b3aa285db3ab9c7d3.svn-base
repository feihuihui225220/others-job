package com.anticw.aged.controller.professional.activity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NCheckList;
import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.NServiceRecord;
import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.bean.NactivityProgramOfEvents;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.controller.community.user.UserManageCtl;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.service.professional.activity.NProgramService;
import com.anticw.aged.service.professional.activity.NServiceRecordService;
import com.anticw.aged.service.professional.activity.NVolunteerServiceRecordService;
import com.anticw.aged.service.professional.activity.NactivityProgramOfEventsService;
import com.anticw.aged.service.professional.activity.VolunteerService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.NActivityPlanVO1;
import com.anticw.aged.vo.professional.activity.NNActivityPlanListVO;
import com.anticw.aged.vo.professional.activity.NProgramVOMain;
import com.anticw.aged.vo.professional.activity.NProgrqamVO1;
import com.anticw.aged.vo.professional.activity.NactivityProgramOfEventsVo;
import com.anticw.aged.vo.professional.activity.StatisticsVO;
import com.anticw.aged.vo.professional.activity.VolunteerVO;
import com.anticw.aged.vo.professional.vender.MVenderSiteVO1;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.user.RUserVO;

@RequestMapping("/professional/activity/")
@Controller
public class ActivityManagerCtl {
	private static Logger logger = LoggerFactory.getLogger(UserManageCtl.class);
	@Autowired
	private ActivityManagerService activityManagerService;
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private VenderService venderService;
	@Autowired
	private FileHandle fileHandle;
	@Autowired
	private NServiceRecordService nServiceRecordService;
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private NactivityProgramOfEventsService nactivityProgramOfEventsService;
	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private NProgramService nProgramService;
	@Autowired
	private UserDao userDao;

	@RequestMapping("list")
	public String findListValue(HttpSession session, PageParamVO pageVO,
			HttpServletRequest request, NActivityPlan nActivityPlan,
			DateParamVO dateCond) throws IllegalAccessException,
			InvocationTargetException {
		logger.debug("into method activity list.");
		request.setAttribute("siteIds", nActivityPlan.getSiteIds());
		request.setAttribute("dateCond", dateCond);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<MVenderSite> site = null;
		try {
			site = mVenderSiteService.fingByVenderId(userVo.getVenderId());
			request.setAttribute("site", site);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String siteIds = "";
		int i = 0;
		if(nActivityPlan.getSiteIds()==null){
			for (MVenderSite s : site) {
				if (i != 0) {
					siteIds += ",";
				}
				siteIds += s.getId();
				i++;
			}
		}else{
			siteIds=nActivityPlan.getSiteIds();
		}
		/*String name;
		AUser aUser = activityManagerService.findName(userVo.getName(),
				userVo.getVenderId());
		if (aUser.getSuper_() == true) {
			name = aUser.getName();
		} else {
			MVender m = activityManagerService.getMvender(userVo.getVenderId());
			name = m.getContact();
		}*/
		Page<NActivityPlanVO1> page = null;

		page = activityManagerService.findNActivityPlan(pageVO.getPage(),
				pageVO.getNum(), nActivityPlan, dateCond, userVo.getVenderId(),
				siteIds);

		request.setAttribute("page", page);
		return "/professional/activity/activityPlan/planList";

	}

	@RequestMapping("mission")
	public String findList(HttpSession session, PageParamVO pageVO,
			HttpServletRequest request, NActivityPlan nActivityPlan,
			DateParamVO dateCond) throws IllegalAccessException,
			InvocationTargetException {
		request.setAttribute("siteIds", nActivityPlan.getSiteIds());
		request.setAttribute("dateCond", dateCond);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<MVenderSite> site = mVenderSiteService.fingByVenderId(userVo
				.getVenderId());
		request.setAttribute("site", site);
		@SuppressWarnings("unused")
		String name;

		MVender m = activityManagerService.getMvender(userVo.getVenderId());
		AUser auer = userDao.get((int) userVo.getId());
		name = m.getContact();
		Page<NActivityPlanVO1> page = null;
		String siteIds = auer.getSiteIds();
		int i = 0;
		if(nActivityPlan.getSiteIds()==null){
			for (MVenderSite s : site) {
				if (i != 0) {
					siteIds += ",";
				}
				siteIds += s.getId();
				i++;
			}
		}else{
			siteIds=nActivityPlan.getSiteIds();
		}
		page = activityManagerService.findNActivityPlanNo(pageVO.getPage(),
				pageVO.getNum(), dateCond, userVo.getVenderId(),
				siteIds, (int) userVo.getId());
		request.setAttribute("page", page);
		return "/professional/activity/activityPlan/planListSuperNo";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("statistics")
	public ModelAndView selectCount(HttpSession session, DateParamVO dateCond) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/statient");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (dateCond.getStart() == null) {
			dateCond.setStart(DateUtil.parseStrToDate("2016-07-21"));
			dateCond.setEnd(DateUtil.getEnd(new Date()));
		}
		List<StatisticsVO> vos = activityManagerService.getSum(
				(int) userVo.getId(), dateCond);
		int sumz = vos.size();
		int plansumz = 0;// 活动总次数
		int plansumw = 0;// 活动未排课数量
		int classsumw = 0;// 排课总次数
		double classTime = 0;// 排课课程时长
		double planTime = 0;// 本活动课程总时长
		for (StatisticsVO v : vos) {
			plansumz += Integer.parseInt(v.getSumz());
			planTime += Double.parseDouble(v.getSTime());
			classTime += Double.parseDouble(v.getWTime());
			classsumw += Integer.parseInt(v.getWPlan());
			plansumw += Integer.parseInt(v.getSumw());

		}
		mv.addObject("dateCond", dateCond);
		mv.addObject("sumz", sumz);
		mv.addObject("plansumz", plansumz);
		mv.addObject("plansumw", plansumw);
		mv.addObject("classsumw", classsumw);
		mv.addObject("classTime", classTime);
		mv.addObject("planTime", planTime);
		Map<String, List<Integer>> map = activityManagerService.getDateSumPlan(
				session, (int) userVo.getId(), dateCond);
		mv.addObject("StatisticsVO", vos);
		mv.addObject("map", map);
		mv.addObject("date", (Set<String>) session.getAttribute("setDate"));
		return mv;
	}

	/**
	 * 去添加节目页面
	 * 
	 * @param request
	 * @param session
	 * @param type
	 * @param seek
	 * @param planId
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("missionTOAdd")
	public String findList(HttpServletRequest request, HttpSession session,
			Integer type, String seek, Integer planId,PageParamVO page)
			throws IllegalAccessException, InvocationTargetException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (type == null) {
			type = 0;
		}
		Page<NProgram> nProgram1 = activityManagerService.findMission(type,
				seek, planId, (int) userVo.getId(),page.getPage(),page.getNum());
		NProgramVOMain vo = null;
		List<NProgramVOMain> nProgram = new ArrayList<NProgramVOMain>();
		Page<NProgramVOMain> nProgram_=new Page<NProgramVOMain>();
		if(nProgram1!=null){
		for (NProgram n : nProgram1.getResult()) {
			vo = new NProgramVOMain();
			BeanUtils.copyProperties(vo, n);
			int count = activityManagerService.getCount(n.getId());
			vo.setCount(count);
			nProgram.add(vo);
		}
		nProgram_.setResult(nProgram);
		nProgram_.setPageSize(nProgram1.getPageSize());
		nProgram_.setPageNo(nProgram1.getPageNo());
		nProgram_.setTotalCount(nProgram1.getTotalCount());
		}
		List<Object[]> mns = activityManagerService.getlIst(planId,
				(int) userVo.getId());
		Object[] mn = null;
		if (mns.size() != 0) {
			mn = mns.get(0);
		}
		long times = activityManagerService.getTime(planId,
				(int) userVo.getId());
		request.setAttribute("times", times);
		request.setAttribute("page", nProgram_);
		request.setAttribute("planId", planId);
		request.setAttribute("NactivityProgramOfEvent", mn);
		request.setAttribute("type", type);
		request.setAttribute("seek", seek);
		return "/professional/activity/activityPlan/missionAdd";
	}

	/**
	 * 添加节目专业老师
	 * 
	 * @param vo
	 * @param progranId
	 * @param planId
	 * @return
	 */
	@RequestMapping("missionAdd")
	// 父节点 节目id
	public String saveMission(HttpSession session,
			NactivityProgramOfEventsVo vo, Integer progranId, Integer planId) {
		NActivityPlan nActivityPlan = activityManagerService
				.findOneAvailData(planId);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		for (NactivityProgramOfEvents n : vo.getProgram()) {
			n.setParentNode(progranId);
			n.setnActivityPlan(nActivityPlan);
			n.setTeacherId((int) userVo.getId());
			nactivityProgramOfEventsService.saveNactivityProgramOfEvents(n);
		}
		return "redirect:/professional/activity/missionTOAdd?planId=" + planId;
	}

	@RequestMapping(value = "listjson")
	public @ResponseBody JSONObject findListValue() throws Exception {
		List<NActivityPlan> lnap = activityManagerService.findListValue();
		JSONObject jsons = new JSONObject();
		jsons.put("activityList", lnap);
		return jsons;
	}

	/**
	 * 跳转到添加
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(HttpSession session)
			throws IllegalAccessException, InvocationTargetException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<MVenderSite> mVenderSite = mVenderSiteService
				.fingByVenderId(userVo.getVenderId());
		List<MVenderSiteVO1> voList = new ArrayList<MVenderSiteVO1>();
		MVenderSiteVO1 vo = null;
		for (MVenderSite m : mVenderSite) {
			vo = new MVenderSiteVO1();
			BeanUtils.copyProperties(vo, m);
			voList.add(vo);
		}
		NNActivityPlanListVO nNActivityPlanListVO = new NNActivityPlanListVO();
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/planAdd");
		mv.addObject("mVenderSite", voList);
		mv.addObject("nNActivityPlanListVO", nNActivityPlanListVO);
		return mv;
	}

	/**
	 * 添加活动计划
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("addone")
	public @ResponseBody List<MVenderSiteVO1> insertActivityPlan(
			HttpSession session, NActivityPlan activityPlan,
			DateParamVO dateCond) throws IllegalAccessException,
			InvocationTargetException {
		int week = DateUtil.getweek(dateCond.getStart(), dateCond.getEnd());
		session.setAttribute("activityPlan1", activityPlan);
		session.setAttribute("dateCond", dateCond);
		List<MVenderSite> mVenderSite = mVenderSiteService
				.findByIds(activityPlan.getSiteIds());
		List<MVenderSiteVO1> voList = new ArrayList<MVenderSiteVO1>();
		MVenderSiteVO1 vo = null;
		for (MVenderSite m : mVenderSite) {
			vo = new MVenderSiteVO1();
			BeanUtils.copyProperties(vo, m);
			vo.setWeek(week);
			voList.add(vo);
		}
		if(DateUtil.getTotalDay(dateCond.getStart(), dateCond.getEnd())<7){
			if(voList.size()!=0){
				voList.get(0).setWeeks(DateUtil.getWeeks(dateCond));
			}
		}
		return voList;
	}

	@RequestMapping("addTwo")
	public @ResponseBody List<NProgrqamVO1> insertt(HttpSession session,
			String week) throws IllegalAccessException,
			InvocationTargetException, ParseException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<NProgram> nProgram = nProgramService.ListNPrograms(userVo
				.getName());
		List<NProgrqamVO1> npList = new ArrayList<NProgrqamVO1>();
		NProgrqamVO1 npr = null;
		for (NProgram n : nProgram) {
			npr = new NProgrqamVO1();
			BeanUtils.copyProperties(npr, n);
			npList.add(npr);
		}
		String[] siteArr = week.split(";");
		DateParamVO dateCond = (DateParamVO) session.getAttribute("dateCond");
		Map<Integer, List<String>> map = DateUtil.geda(dateCond.getStart(),
				dateCond.getEnd());
		Map<Integer, Map<Integer, String[]>> weeks = new HashMap<Integer, Map<Integer, String[]>>();
		for (int i = 0; i < siteArr.length; i++) {
			String[] week1 = siteArr[i].split(",");
			Integer siteId = Integer.parseInt(week1[0]);
			Map<Integer, String[]> m = new HashMap<Integer, String[]>();
			for (Integer key : map.keySet()) {
				String[] _weeks = DateUtil.getDates(map.get(key).get(0), map
						.get(key).get(1), week1[1].toString());
				m.put(key, _weeks);
			}
			weeks.put(siteId, m);
		}
		session.setAttribute("weeks", weeks);
		return npList;
	}

	@RequestMapping("addthree")
	public String insert(HttpSession session,
			NNActivityPlanListVO nNActivityPlanListVO) {

		activityManagerService.insert(session, nNActivityPlanListVO);
		return "redirect:/professional/activity/list";
	}

	/**
	 * 编辑活动计划
	 */
	@RequestMapping("edit")
	public String editActivityPlan(HttpSession session,
			NActivityPlan activityPlan, HttpServletRequest request) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		long userId = userVo.getId();
		activityPlan.setCreatedBy(Long.toString(userId));
		activityManagerService.editActivityPlan(activityPlan);
		return "/professional/activity/activityPlan/plan";
	}

	/**
	 * 删除计划
	 */
	@RequestMapping("delete")
	public @ResponseBody String deleteActivityPlan(Integer id,
			HttpServletRequest request) {
		activityManagerService.delActivityPlanById(id);
		return "success";
	}

	@RequestMapping(value = "activityPlanjson")
	public @ResponseBody JSONObject activityPlanjson(
			HttpServletResponse response, Integer id) {
		NActivityPlan nt = activityManagerService.findOneAvailData(id);
		JSONObject jsons = new JSONObject();
		jsons.put("activity", nt);
		if (nt.getVolunteerId() != null && nt.getVolunteerId() != "") {
			List<NVolunteer> nVolunteer = activityManagerService
					.findNVolunters(nt.getVolunteerId());
			List<String> nVolunteers = new ArrayList<String>();
			for (NVolunteer n : nVolunteer) {
				nVolunteers.add(n.getName());
			}
			jsons.put("nVolunteer", nVolunteers);
		}
		if (nt.getEmployeeId() != null && nt.getEmployeeId() != "") {
			List<String> employee = new ArrayList<String>();
			List<AUser> employees = activityManagerService.getAUser(nt
					.getEmployeeId());
			for (AUser n : employees) {
				employee.add(n.getName());
			}
			jsons.put("employees", employee);
		}
		return jsons;
	}

	/**
	 * 活动管理/活动计划页面/微信接口
	 */
	@RequestMapping("plandetail")
	public @ResponseBody JSONObject activityPlanJson(Integer id) {

		JSONObject json = new JSONObject();
		NActivityPlan nt = activityManagerService.findOneAvailData(id);

		json.put("activity", nt);

		if (nt.getVolunteerId() != null && nt.getVolunteerId() != "") {
			List<NVolunteer> nVolunteer = activityManagerService
					.findNVolunters(nt.getVolunteerId());
			List<String> npro = new ArrayList<String>();
			for (NVolunteer n : nVolunteer) {
				npro.add(n.getName());
			}
			json.put("nVolunteer", npro);
		}
		if (nt.getEmployeeId() != null && nt.getEmployeeId() != "") {
			List<AUser> employees = activityManagerService.getAUser(nt
					.getEmployeeId());
			List<String> npro = new ArrayList<String>();
			for (AUser e : employees) {
				npro.add(e.getName());
			}
			json.put("employees", npro);
		}
		return json;
	}

	/**
	 * 活动管理/跳转老年人签到
	 * 
	 * @author dx
	 * @param session
	 * @param id
	 * @param request
	 * @param pageVO
	 * @param name
	 * @param idCard
	 * @param status
	 * @return
	 */
	@RequestMapping("activity_aged")
	public ModelAndView activityAged(HttpSession session, Integer id,
			HttpServletRequest request, String name, String idCard,
			Short status, PageParamVO pageVO, Integer communityId,
			String siteId, Date pubdate) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/aged_registration");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (status == null) {
			status = -1;
		}
		Page<VenderServUserVO> page = venderService.getVenderSevUsersPages(
				userVo.isSuper_(), (int) userVo.getId(), userVo.getName(),
				idCard, userVo.getVenderId(), status, pageVO.getPage(),
				pageVO.getNum(), communityId, id, name, siteId);
		List<NCheckList> nCheckLists = activityManagerService
				.getListNCheckList(id, pubdate);
		if (nCheckLists.size() != 0) {
			mv.addObject("Signin", "Signin");
		}
		mv.addObject("name", name);
		mv.addObject("pubdate", pubdate);
		mv.addObject("idCard", idCard);
		mv.addObject("communityId", communityId);
		mv.addObject("siteId", siteId);
		mv.addObject("page", page);
		mv.addObject("activityId", id);
		return mv;
	}

	@RequestMapping("whole")
	public ModelAndView whole(HttpSession session, HttpServletRequest request,
			String name, String idCard, Short status, int activityId) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (userVo.isSuper_() == true) {
			ModelAndView mv = new ModelAndView(new RedirectView(
					"/professional/activity/activity_aged?id=" + activityId
							+ " &communityId=0"));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView(
					"/professional/activity/activityPlan/whole_sign");
			if (status == null) {
				status = -1;
			}
			List<VenderServUserVO> list = venderService.getSevUser(activityId,
					userVo.getName(), userVo.getId(), userVo.getVenderId());
			mv.addObject("user", list);
			mv.addObject("length", list.size());
			mv.addObject("activityId", activityId);
			return mv;
		}

	}

	/**
	 * 添加活动中签到的老年人
	 * 
	 * @param session
	 * @param activityId
	 * @param userId
	 * @param request
	 * @param pageVO
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("add_aged")
	public void addAged(HttpSession session, int activityId, String ids,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// ModelAndView mv = new
		// ModelAndView("/professional/activity/activityPlan/aged_fillCheck");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String createdBy = userVo.getName();
		NActivityPlan nt = activityManagerService.findOneAvailData(activityId);
		Date pubdate = nt.getPubdate();
		Date createdAt = new Date();
		String[] sourceStrArray = ids.split(",");
		for (String userid : sourceStrArray) {
			int userId = Integer.parseInt(userid);
			NCheckList nCherkList = new NCheckList();
			nCherkList.setActivityId(activityId);
			nCherkList.setAvaliable(true);
			nCherkList.setCreatedBy(createdBy);
			nCherkList.setCreatedAt(createdAt);
			nCherkList.setPubdate(pubdate);
			nCherkList.setUserId(userId);
			nCherkList.setVersion((short) 0);
			activityManagerService.addNCherk(nCherkList);
		}

		PrintWriter out = response.getWriter();
		out.print("签到成功！");
		;
	}

	/**
	 * 老人签到后展示页面
	 * 
	 * @param session
	 * @param id
	 * @param pubdate
	 * @param request
	 * @return
	 */
	@RequestMapping("activity_yiqian")
	public ModelAndView addYiQian(HttpSession session, int id, Date pubdate,
			HttpServletRequest request, PageParamVO pageVO) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/aged_fillCheck");
		if (userVo.isSuper_()) {
			String userIds = "";
			List<NCheckList> nCheckLists = activityManagerService
					.getListNCheckList(id, pubdate);
			for (NCheckList n : nCheckLists) {
				userIds += n.getUserId();
				userIds += ",";
			}
			userIds = userIds.substring(0, userIds.length() - 1);
			Page<RUser> page = activityManagerService.getPage(userIds, pageVO);
			mv.addObject("page", page);
		} else {
			List<RUser> page = venderService.getStaff(id, userVo.getId());
			mv.addObject("page", page);
		}

		mv.addObject("pubdate", pubdate);
		mv.addObject("activityId", id);

		return mv;

	}
	
	@RequestMapping("yiqian_remove")
	@ResponseBody
	public String removeYiQian(int userId,int activityId){
		try {
			activityManagerService.removeId(userId,activityId);
			return "删除成功！";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "删除失败！";
		}
	}

	@Autowired
	private NVolunteerServiceRecordService nVolunteerServiceRecordService;

	/**
	 * 活动管理/跳转志愿者签到
	 * 
	 * @author dx
	 * @param id
	 * @return
	 */
	@RequestMapping("activity_voluntary")
	public ModelAndView activityVoluntary(Integer id, Date pubdate) {

		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/activity_voluntary");
		mv.addObject("activityId", id);
		mv.addObject("pubdate", pubdate);
		NActivityPlan nt = activityManagerService.findOneAvailData(id);
		List<Integer> ids = nVolunteerServiceRecordService.getList(id);
		if (ids.size() > 0) {
			mv.addObject("seccess", "seccess");
		}
		String result = nt.getVolunteerId();
		if (result == null || result == "") {
			return mv;
		}
		List<String> inputCollection = Arrays.asList(result.split(","));
		List<Integer> outputCollection = new ArrayList<Integer>();
		CollectionUtils.collect(inputCollection, new Transformer() {
			public Object transform(Object input) {
				return new Integer((String) input);
			}
		}, outputCollection);
		outputCollection.removeAll(ids);
		if (outputCollection.size() == 0) {
			return mv;
		}
		List<NVolunteer> nVolunteer = activityManagerService
				.findNVolunters(StringUtils.join(outputCollection.toArray(),
						","));
		List<NVolunteer> nVolunteer1 = new ArrayList<NVolunteer>();

		for (NVolunteer n : nVolunteer) {
			int communityId = Integer.parseInt(n.getCommunity());
			OCountry o = activityManagerService.getOCountry(communityId);
			n.setCommunity(o.getName());
			nVolunteer1.add(n);
		}
		mv.addObject("ids", ids);
		mv.addObject("nVolunteer", nVolunteer1);
		return mv;
	}

	/**
	 * 添加活动记录
	 * 
	 * @param id
	 * @param pubdate
	 * @return
	 */
	@RequestMapping("activity_serve")
	public ModelAndView activityServe(Integer id, Date pubdate) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/activity_serve");
		mv.addObject("activityId", id);
		mv.addObject("pubdate", pubdate);
		if (nServiceRecordService.findListNServiceRecord(id) != null) {
			List<NServiceRecord> nServiceRecord = nServiceRecordService
					.findListNServiceRecord(id);
			mv.addObject("nServiceRecord", nServiceRecord);
		}
		nServiceRecordService.findListNServiceRecord(id);
		return mv;
	}

	/**
	 * 志愿者签到
	 * 
	 * @param session
	 * @param activityId
	 * @param volunteerId
	 * @param pubdate
	 * @return
	 */
	@RequestMapping("add_voluntary")
	public String activityVoluntary(HttpSession session, int activityId,
			int[] volunteerId, Date pubdate) {

		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String createdBy = userVo.getName();
		NVolunteerServiceRecord nv = new NVolunteerServiceRecord();
		for (int volunteerid : volunteerId) {
			nv.setAvaliable(true);
			nv.setCreatedAt(pubdate);
			nv.setCreatedBy(createdBy);
			nv.setVersion((short) 0);
			nv.setVolunteerId(volunteerid);
			nv.setActivityId(activityId);
			activityManagerService.addNVolunteerServiceRecord(nv);
		}

		return "redirect:/professional/activity/activity_voluntary?id="
				+ activityId + "&pubdate="
				+ DateUtil.getCurrentFormatDate(pubdate);
	}

	/**
	 * 查看签到的志愿者
	 * 
	 * @param activityId
	 * @param pubdate
	 * @return
	 */
	@RequestMapping("see_voluntary")
	public ModelAndView getList(int activityId, Date pubdate) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/activity_show");
		String volunteerIds = "";
		List<NVolunteerServiceRecord> nvServiceRecords = activityManagerService
				.setListNVolunteerServiceRecord(activityId, pubdate);
		for (NVolunteerServiceRecord n : nvServiceRecords) {
			volunteerIds += n.getVolunteerId();
			volunteerIds += ",";
		}
		volunteerIds = volunteerIds.substring(0, volunteerIds.length() - 1);
		List<NVolunteer> nVolunteer = activityManagerService
				.findNVolunters(volunteerIds);
		List<NVolunteer> nVolunteer1 = new ArrayList<NVolunteer>();
		for (NVolunteer n : nVolunteer) {
			int communityId = Integer.parseInt(n.getCommunity());
			OCountry o = activityManagerService.getOCountry(communityId);
			n.setCommunity(o.getName());
			nVolunteer1.add(n);
		}
		mv.addObject("nVolunteer", nVolunteer1);
		return mv;
	}

	/**
	 * 添加活动记录
	 * 
	 * @param session
	 * @param nServiceRecord
	 * @param request
	 * @param pic
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("addword")
	public String insertAlbum(HttpSession session,
			NServiceRecord nServiceRecord, HttpServletRequest request,
			@RequestParam(value = "pic", required = false) MultipartFile pic)
			throws IOException {
		Date createdAt = new Date();
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String createdBy = userVo.getName();
		String fileUrl = fileHandle.uploadWord(pic);
		nServiceRecord.setFileUrl(fileUrl);
		nServiceRecord.setVersion((short) 0);
		nServiceRecord.setAvaliable(true);
		nServiceRecord.setCreatedAt(createdAt);
		nServiceRecord.setCreatedBy(createdBy);
		nServiceRecordService.addNServiceRecord(nServiceRecord);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String pubdate = sdf.format(nServiceRecord.getPubdate());
		return "redirect:/professional/activity/activity_serve?id="
				+ nServiceRecord.getActivityId() + " &pubdate=" + pubdate;
	}

	@RequestMapping("deleteWord")
	public String deleteWord(int id, int activityId, Date pubdate) {
		NServiceRecord nServiceRecord = nServiceRecordService
				.findNServiceRecord(id);
		fileHandle.removeWord(nServiceRecord.getFileUrl());
		nServiceRecordService.deleteNServiceRecord(id);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String pubdate1 = sdf.format(pubdate);
		return "redirect:/professional/activity/activity_serve?id="
				+ activityId + " &pubdate=" + pubdate1;
	}

	// 下载
	@RequestMapping("download")
	protected void down(HttpServletRequest request,
			HttpServletResponse response, int id, int activityId, Date pubdate) {
		NServiceRecord nServiceRecord = nServiceRecordService
				.findNServiceRecord(id);
		String path = this.getClass().getClassLoader().getResource("/")
				.toString().replace("/classes/", "/").substring(6)
				+ "file/word/" + nServiceRecord.getFileUrl();
		try {
			File file = new File(path);
			String filename = file.getName();
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping("update")
	public ModelAndView toUpdate(int id, HttpSession session)
			throws IllegalAccessException, InvocationTargetException {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/planUpdate");
		NActivityPlanVO1 vo = activityManagerService.toUpdate(id);
		// 查找已签到的志愿者服务记录 查找已签到的老人
		// nVolunteerServiceRecordService.getList(vo.getVolunteerId());
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
		List<Integer> volunterId = nVolunteerServiceRecordService.getList(id);
		if (volunterId.size() != 0) {
			List<VolunteerVO> nVolunteer = activityManagerService
					.findNVoluntersVO(StringUtils.join(volunterId.toArray(),
							","));
			mv.addObject("nVolunteer", nVolunteer);
		}

		List<Integer> nCheckLists = activityManagerService.getListUerId(id);
		if (nCheckLists.size() != 0) {
			List<RUserVO> list = activityManagerService.getlist(StringUtils
					.join(nCheckLists.toArray(), ","));
			mv.addObject("rUser", list);
		}

		mv.addObject("nActivityPlan", vo);
		return mv;
	}

	@RequestMapping("tiaozhuan")
	public ModelAndView tiaozhuan(int id, HttpSession session)
			throws IllegalAccessException, InvocationTargetException {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<VolunteerVO> nVolunteer = volunteerService.AllListVolunteer(userVo
				.getId() + "");
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/planUpdateTWO");
		NActivityPlanVO1 vo = activityManagerService.toUpdate(id);
		if (vo.getEmployeeId() != null && vo.getEmployeeId() != "") {
			List<AUser> user = activityManagerService.getUser(vo
					.getEmployeeId());
			mv.addObject("user", user);
		}
		List<OCountry>  ocountrys=oCountryService.getCounNVolunteer();
		mv.addObject("ocountrys", ocountrys);
		mv.addObject("nActivityPlan", vo);
		mv.addObject("nVolunteer", nVolunteer);
		return mv;
	}
	
	/**
	 * 获取社区下的志愿者
	 * @param communityId
	 * @return
	 */
	@RequestMapping("VolunteerVO")
	@ResponseBody
	public List<VolunteerVO> getVolunteerVO(int communityId){
		return volunteerService.getCommunity(communityId);
	}

	/**
	 * 添加额外的员工
	 * 
	 * @param session
	 * @param name
	 * @return
	 */
	@RequestMapping("yuangong")
	public @ResponseBody List<AUser> getUser(HttpSession session, String name) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		return userDao.getUser(name, userVo.getVenderId());
	}

	/**
	 * 删除活动
	 * 
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("delplan")
	public @ResponseBody String delete(HttpSession session, long id) {
		nactivityProgramOfEventsService.remove(id);
		return "success";
	}

	/**
	 * 修改活动
	 * 
	 * @param nActivityPlan
	 * @param session
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("updateNActivityPlanVO")
	public String updateNActivityPlanVO(NActivityPlan nActivityPlan,
			HttpSession session) throws IllegalAccessException,
			InvocationTargetException {

		activityManagerService.updateNActivityPlanVO(session, nActivityPlan);
		return "redirect:/professional/activity/update?id="
				+ nActivityPlan.getId();

	}

	/**
	 * 获取当前时间（一天） 本服务商下所有的活动
	 * 
	 * @param pubdate
	 * @return
	 */
	@RequestMapping("DateList")
	public ModelAndView DateList(Date pubdate, HttpSession session) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/activityPlan/prent");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		List<NActivityPlanVO1> vo1 = null;
		try {
			vo1 = activityManagerService.findNActivityPlan(
					userVo.getVenderId(), pubdate);
			mv.addObject("NActivityPlan", vo1);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

}
