package com.anticw.aged.service.professional.activity;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NCheckList;
import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.bean.NactivityProgramOfEvents;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.community.country.OCountryDao;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.professional.activity.ActivityManagerDao;
import com.anticw.aged.dao.professional.activity.NCherkListDao;
import com.anticw.aged.dao.professional.activity.NProgramDao;
import com.anticw.aged.dao.professional.activity.NVenderMaterialDao;
import com.anticw.aged.dao.professional.activity.NVolunteerServiceRecordDao;
import com.anticw.aged.dao.professional.activity.NactivityProgramOfEventsDao;
import com.anticw.aged.dao.professional.activity.VolunteerDao;
import com.anticw.aged.dao.professional.vender.MVenderSiteDao;
import com.anticw.aged.dao.professional.vender.VenderDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.ActivityPlanSchemeVo;
import com.anticw.aged.vo.professional.activity.CourseVO;
import com.anticw.aged.vo.professional.activity.DateSumPlan;
import com.anticw.aged.vo.professional.activity.NActivityPlanVO;
import com.anticw.aged.vo.professional.activity.NActivityPlanVO1;
import com.anticw.aged.vo.professional.activity.NNActivityPlanListVO;
import com.anticw.aged.vo.professional.activity.ProgramOfVO;
import com.anticw.aged.vo.professional.activity.StatisticsVO;
import com.anticw.aged.vo.professional.activity.VolunteerTrainingRecordVo;
import com.anticw.aged.vo.professional.activity.VolunteerVO;
import com.anticw.aged.vo.user.RUserVO;

@Service
public class ActivityManagerService {

	@Autowired
	private ActivityManagerDao activityPlanDao;
	@Autowired
	private VolunteerDao volunteerDao;
	@Autowired
	private NProgramDao nProgramDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private VenderDao venderDao;
	@Autowired
	private NCherkListDao nCherkListDao;
	@Autowired
	private RUserDao rUserDao;
	@Autowired
	private NVolunteerServiceRecordDao nVolunteerServiceRecordDao;
	@Autowired
	private OCountryDao oCountryDao;
	@Autowired
	private NactivityProgramOfEventsDao nactivityProgramOfEventsDao;
	@Autowired
	private MVenderSiteDao mVenderSiteDao;
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private MVenderSiteService mVenderSiteService;

	public OCountry getOCountry(int id) {
		return oCountryDao.getOCountry(id);
	}

	public int getCount(int progranId) {
		return nactivityProgramOfEventsDao.getCount(progranId);
	}

	public List<StatisticsVO> getSum(int teacherId, DateParamVO dateParamVO) {
		return nactivityProgramOfEventsDao.getSum(teacherId, dateParamVO);
	}

	public Map<String, List<Integer>> getDateSumPlan(HttpSession session,
			int teacherId, DateParamVO dateParamVO) {
		List<DateSumPlan> lis = nactivityProgramOfEventsDao.getDateSumPlan(
				teacherId, dateParamVO);
		Set<Date> set = new HashSet<Date>();
		Set<String> setStr = new HashSet<String>();
		Set<String> siteName = new HashSet<String>();
		for (DateSumPlan d : lis) {
			set.add(d.getPubdate());
			setStr.add(DateUtil.getCurrentFormatDate(d.getPubdate()));
			siteName.add(d.getSiteName());
		}
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for (String sum : siteName) {
			List<Integer> li = new ArrayList<Integer>();
			for (Date d : set) {
				for (int i = 0; i < lis.size(); i++) {
					DateSumPlan dd = lis.get(i);
					if (dd.getSiteName() == sum && dd.getPubdate() == d) {
						li.add(dd.getSum());
					} else if (dd.getSiteName() == sum && dd.getPubdate() != d) {
						li.add(0);
					}
				}

			}
			map.put(sum.toString(), li);
		}
		session.setAttribute("setDate", setStr);
		return map;

	}

	public List<RUserVO> getlist(String Ids) throws IllegalAccessException,
			InvocationTargetException {
		List<RUser> ruser = rUserDao.getlist(Ids);
		List<RUserVO> vos = new ArrayList<RUserVO>();
		OCountry o = null;
		for (RUser r : ruser) {
			RUserVO vo = new RUserVO();
			BeanUtils.copyProperties(vo, r);
			o = oCountryDao.getOCountry(r.getCommunityId());
			vo.setComminityName(o.getName());
			vos.add(vo);
		}
		return vos;
	}

	public Page<RUser> getPage(String Ids, PageParamVO pageVO) {
		return rUserDao.getPage(Ids, pageVO);
	}

	// 根据创建者查询所有的节目
	public List<NActivityPlan> getNActivityPlan(String createby, Date start1,
			Date end1) {
		return activityPlanDao.findListValue(createby, start1, end1);
	}

	// 添加老人签到
	public void addNCherk(NCheckList nCherkList) {
		nCherkListDao.addNCherk(nCherkList);
	}
	
	public void removeId(int userId,int activityId){
		NCheckList ck=	nCherkListDao.getListNCheckList(activityId, userId);
		nCherkListDao.remove(ck);
	}

	public MVender getMvender(int id) {
		return venderDao.getMvender(id);
	}

	// 查看老人已参加所有的活动
	public List<NCheckList> getListNCheckList(int userId) {
		return nCherkListDao.getListNCheckList(userId);
	}

	public void addNVolunteerServiceRecord(
			NVolunteerServiceRecord nVolunteerServiceRecord) {
		nVolunteerServiceRecordDao
				.addNVolunteerServiceRecord(nVolunteerServiceRecord);
	}

	// 查询志愿者签到情况
	public List<NVolunteerServiceRecord> setListNVolunteerServiceRecord(
			int activityId, Date pubdate) {
		return nVolunteerServiceRecordDao.setListNVolunteerServiceRecord(
				activityId, pubdate);
	}

	// 查询条数老年人签到
	public int getCount(int activityId, Date pubdate) {
		return nCherkListDao.getCount(activityId, pubdate);

	}

	public List<NCheckList> getListN(int activityId) {
		return nCherkListDao.getListN(activityId);
	}

	public List<Integer> getListUerId(int activityId) {
		return nCherkListDao.getListUerId(activityId);
	}

	public AUser findName(String name, int venderId) {
		return userDao.findName(name, venderId);
	}

	public AUser findByName(String name) {
		return userDao.findByName(name);
	}

	// 查询当前计划签到人数
	public List<NCheckList> getListNCheckList(int activityId, Date pubdate) {
		return nCherkListDao.getListNCheckList(activityId, pubdate);
	}

	public int insertActivityPlan(NActivityPlan activityPlan) {
		return activityPlanDao.insertActivityPlan(activityPlan);
	}

	public NActivityPlan insert(NActivityPlan activityPlan) {
		return activityPlanDao.insert(activityPlan);
	}

	public List<NActivityPlan> findListValue(String name) {
		return activityPlanDao.findListValue(name);
	}

	public List<NActivityPlan> findListValue() {
		return activityPlanDao.findListValue();
	}

	public List<AUser> getUser(String Ids) {
		return userDao.getUser(Ids);
	}

	public NActivityPlan findOneAvailData(Integer id) {
		return activityPlanDao.findOneAvailData(id);
	}

	public List<NActivityPlan> findOneDateData() {
		return activityPlanDao.findOneDateData();
	}

	// ///////////////////////////////////////
	public List<NActivityPlanVO1> findSite(String sites)
			throws IllegalAccessException, InvocationTargetException {
		List<NActivityPlan> np = activityPlanDao.findSite(sites);
		if(np==null){
			return null;
		}
		return getlistnact(np);
	}

	public List<NActivityPlanVO1> findSite(String sites, String date)
			throws IllegalAccessException, InvocationTargetException {
		List<NActivityPlan> np = activityPlanDao.findSite(sites, date);
		return getlistnact(np);
	}

	public void editActivityPlan(NActivityPlan activityPlan) {
		activityPlanDao.editActivityPlan(activityPlan);
	}

	public void delActivityPlanById(Integer id) {
		activityPlanDao.delActivityPlanById(id);
	}

	public Page<NActivityPlanVO1> findNActivityPlan(int pageNo, int pageSize,
			NActivityPlan nActivityPlan, DateParamVO dateCond,
			Integer venderId, String siteIds) throws IllegalAccessException,
			InvocationTargetException {
		String hql = " and venderId=" + venderId;
		if (siteIds != null && siteIds != "") {
			hql += " and siteIds in(" + siteIds + ") ";
		}
		Page<NActivityPlan> page = activityPlanDao.findNActivityPlan(pageNo,
				pageSize, dateCond, hql);
		List<NActivityPlan> np = page.getResult();
		List<NActivityPlanVO1> vo1 = getListVO1(np);
		Page<NActivityPlanVO1> pa = new Page<NActivityPlanVO1>();
		pa.setResult(vo1);
		pa.setPageNo(page.getPageNo());
		pa.setPageSize(page.getPageSize());
		pa.setTotalCount(page.getTotalCount());
		return pa;
	}

	/**
	 * 专业老师
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param nActivityPlan
	 * @param dateCond
	 * @param venderId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Page<NActivityPlanVO1> findNActivityPlanNo(int pageNo, int pageSize,
			DateParamVO dateCond, Integer venderId, String siteIds,
			int teacherId) throws IllegalAccessException,
			InvocationTargetException {
		String hql = " and venderId=" + venderId;
		hql += " and siteIds in(" + siteIds + ") ";
		Page<NActivityPlan> page = activityPlanDao.findNActivityPlan(pageNo,
				pageSize, dateCond, hql);
		List<NActivityPlan> np = page.getResult();
		List<NActivityPlanVO1> vo1 = getListVOYuan(np, teacherId);
		Page<NActivityPlanVO1> pa = new Page<NActivityPlanVO1>();
		pa.setResult(vo1);
		pa.setPageNo(page.getPageNo());
		pa.setPageSize(page.getPageSize());
		pa.setTotalCount(page.getTotalCount());
		return pa;
	}

	@Autowired
	private NVenderMaterialDao nVenderMaterialDao;

	public Page<NProgram> findMission(Integer type, String seek,
			Integer planId, Integer teacherId,Integer pagesize,Integer num) {
		Page<NProgram> nProgram = null;
		if (type < 3) {// 现有印象标签排课
			List<String> keyword = nactivityProgramOfEventsDao.getList(planId,
					teacherId);
			String keywords = StringUtils.join(keyword.toArray(), ",");
			if (type == 0) {
				seek = keywords;
			}
			
			nProgram=nProgramDao.PageNPrograms(seek, teacherId, type, pagesize, num);
		//	nProgram = nProgramDao.ListNPrograms(seek, teacherId, type);
		} else {
			nProgram = nVenderMaterialDao.selectPage(seek, pagesize, num);
			/*Iterator<NProgram> itre = nProgram.iterator();
			while (itre.hasNext()) {
				if (itre.next().getSubjectTeacher() == null|| itre.next().getSubjectTeacher() == "")
					continue;
				NProgram integer = itre.next();
				if (!integer.getSubjectTeacher().matches(teacherId.toString())) {
					itre.remove();   //注意这个地方
		        	 
				}

			}
*/
		}

		return nProgram;
	}

	public List<Object[]> getlIst(Integer planId, int teacherId) {
		return nactivityProgramOfEventsDao.getLists(planId, teacherId);
	}

	public Long getTime(Integer planId, int teacherId) {
		return nactivityProgramOfEventsDao.getTime(planId, teacherId);
	}

	@Autowired
	private NVolunteerServiceRecordService nVolunteerServiceRecordService;

	// //////////////////////////////////////////////////////////////////////
	public List<NActivityPlanVO1> findNActivityPlan(Integer venderId,
			Date pubdate) throws IllegalAccessException,
			InvocationTargetException {
		List<NActivityPlan> np = activityPlanDao.findNActivityPlan(venderId,
				pubdate);
		return getlistnact(np);
	}

	private List<NActivityPlanVO1> getlistnact(List<NActivityPlan> np)
			throws IllegalAccessException, InvocationTargetException {
		List<NActivityPlanVO1> vo1 = getListVO1(np);
		@SuppressWarnings("unused")
		NActivityPlanVO1 voq;
		for (NActivityPlanVO1 vo : vo1) {
			voq = new NActivityPlanVO1();
			int nactivityId = vo.getId();
			String userIds = StringUtils.join(getListUerId(nactivityId)
					.toArray(), ",");
			if (userIds != null && userIds != "") {
				vo.setRuser(getlist(userIds));
			}
			if (vo.getEmployeeId() != null && vo.getEmployeeId() != "") {
				List<String> em = userDao.getUserName(vo.getEmployeeId());
				Set<String> set = new HashSet<String>(em);
				vo.setEmployee(set);
			}
			String volunteerIds = StringUtils.join(
					nVolunteerServiceRecordService.getList(nactivityId)
							.toArray(), ",");
			if (volunteerIds != null && volunteerIds != "") {
				vo.setVolunteerVO(findNVoluntersVO(volunteerIds));
			}
		}

		return vo1;
	}

	public List<Float> findNActivityPlan(String activityIds, Date sDate,
			Date eDate) {
		return activityPlanDao.findNActivityPlan(activityIds, sDate, eDate);
	}

	private List<NActivityPlanVO1> getListVO1(List<NActivityPlan> np)
			throws IllegalAccessException, InvocationTargetException {
		List<NActivityPlanVO1> vo1 = new ArrayList<NActivityPlanVO1>();
		NActivityPlanVO1 vo = null;
		ProgramOfVO na1 = null;
		Set<ProgramOfVO> set = null;

		for (NActivityPlan n : np) {
			vo = new NActivityPlanVO1();
			String siteName = mVenderSiteDao
					.get(Long.parseLong(n.getSiteIds())).getSiteName();
			BeanUtils.copyProperties(vo, n);
			vo.setSiteIdName(siteName);
			Set<NactivityProgramOfEvents> nactivityProgramOfEvents = n
					.getNactivityProgramOfEvents();
			set = new HashSet<ProgramOfVO>();

			for (NactivityProgramOfEvents na : nactivityProgramOfEvents) {
				na1 = new ProgramOfVO();
				NProgram npro = nProgramDao.get(na.getProgranId());
				if(npro==null){
					continue;
				}
				BeanUtils.copyProperties(na1, na);
				String name = userDao.get(na.getTeacherId()).getName();
				na1.setTeacher(name);
				na1.setProgranName(npro.getProgramName());
				set.add(na1);
			}
			vo.setProgramOfVO(set);
			vo1.add(vo);
		}
		return vo1;
	}

	private List<NActivityPlanVO1> getListVOYuan(List<NActivityPlan> np,
			int teacherId) throws IllegalAccessException,
			InvocationTargetException {
		List<NActivityPlanVO1> vo1 = new ArrayList<NActivityPlanVO1>();
		NActivityPlanVO1 vo = null;
		ProgramOfVO na1 = null;
		Set<ProgramOfVO> set = null;

		for (NActivityPlan n : np) {
			vo = new NActivityPlanVO1();
			String siteName = mVenderSiteDao
					.get(Long.parseLong(n.getSiteIds())).getSiteName();
			BeanUtils.copyProperties(vo, n);
			vo.setSiteIdName(siteName);
			Set<NactivityProgramOfEvents> nactivityProgramOfEvents = n
					.getNactivityProgramOfEvents();
			set = new HashSet<ProgramOfVO>();
			int i = 0;
			for (NactivityProgramOfEvents na : nactivityProgramOfEvents) {
				na1 = new ProgramOfVO();
				if (na.getTeacherId() == teacherId) {
					i = 1;
				}
				NProgram npro = nProgramDao.get(na.getProgranId());
				String name = userDao.get(na.getTeacherId()).getName();
				BeanUtils.copyProperties(na1, na);
				na1.setProgranName(npro.getProgramName());
				na1.setTeacher(name);
				set.add(na1);
			}
			vo.setProgramOfVO(set);
			if (i == 1) {
				vo1.add(vo);
			}
		}
		return vo1;
	}

	public NActivityPlanVO1 toUpdate(int id) throws IllegalAccessException,
			InvocationTargetException {
		NActivityPlanVO1 vo = new NActivityPlanVO1();
		NActivityPlan plan = activityPlanDao.get(id);
		String siteName = mVenderSiteDao.get(Long.parseLong(plan.getSiteIds()))
				.getSiteName();
		String employeeIds = plan.getEmployeeId();
		List<String> employee = userDao.getUserName(employeeIds);
		Set<String> set1 = new HashSet<String>(employee);
		set1.contains(employee);
		vo.setEmployee(set1);
		BeanUtils.copyProperties(vo, plan);
		vo.setSiteIdName(siteName);
		Set<NactivityProgramOfEvents> nactivityProgramOfEvents = plan
				.getNactivityProgramOfEvents();
		Set<ProgramOfVO> set = new HashSet<ProgramOfVO>();
		ProgramOfVO na1 = null;
		for (NactivityProgramOfEvents na : nactivityProgramOfEvents) {
			na1 = new ProgramOfVO();
			NProgram npro = nProgramDao.get(na.getProgranId());
			String name = userDao.get(na.getTeacherId()).getName();
			BeanUtils.copyProperties(na1, na);
			na1.setProgranName(npro.getProgramName());
			na1.setTeacher(name);
			na1.setCourseContent(npro.getProgramContent());
			set.add(na1);
		}
		vo.setProgramOfVO(set);
		return vo;
	}

	@Autowired
	private LogSheetSrevice logSheetSrevice;

	public List<VolunteerTrainingRecordVo> getListPlan(List<String> name,
			Date start, Date end, String ids) {
		List<VolunteerTrainingRecordVo> vos = new ArrayList<VolunteerTrainingRecordVo>();
		String _id[] = ids.split(",");
		for (int i = 0; i < _id.length; i++) {
			VolunteerTrainingRecordVo vo = logSheetSrevice.getListPlan(name,
					start, end, Integer.parseInt(_id[i]));
			vos.add(vo);
		}
		return vos;
	}

	// 添加志愿者等信息
	public void updateNActivityPlanVO(HttpSession session,
			NActivityPlan nActivityPlan) {
		NActivityPlan plan = activityPlanDao.get(nActivityPlan.getId());
		plan.setPlanDesc(nActivityPlan.getPlanDesc());// 活动描述
		plan.setEmployeeId(nActivityPlan.getEmployeeId());// 员工
		plan.setPlanAge(nActivityPlan.getPlanAge());// 被服务人员信息
		plan.setPlanName(nActivityPlan.getPlanName());// 活动名称
		plan.setPlanPlace(nActivityPlan.getPlanPlace());// 活动地址
		plan.setVolunteerId(nActivityPlan.getVolunteerId());// 志愿者id
		activityPlanDao.update(plan);
	}

	public void insert(HttpSession session,
			NNActivityPlanListVO nNActivityPlanListVO) {
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		NActivityPlan activityPlan = (NActivityPlan) session
				.getAttribute("activityPlan1");
		List<NActivityPlanVO> vos = nNActivityPlanListVO.getnActivityPlanVO();
		@SuppressWarnings("unchecked")
		Map<Integer, Map<Integer, String[]>> weeks = (Map<Integer, Map<Integer, String[]>>) session
				.getAttribute("weeks");
		Date date = new Date();
		NActivityPlan plan;
		NactivityProgramOfEvents events;

		for (NActivityPlanVO vo : vos) {
			Map<Integer, String[]> week = weeks.get(vo.getSiteId());
			String weekDate[] = week.get(vo.getWeeksId());
			for (int i = 0; i < weekDate.length; i++) {
				plan = new NActivityPlan();
				plan.setAvaliable(true);
				plan.setChangedAt(date);
				plan.setChangedBy(userVo.getName());
				plan.setCreatedAt(date);
				plan.setCreatedBy(userVo.getName());
				plan.setPlanMin(activityPlan.getPlanMin());
				MVenderSite mVenderSite = mVenderSiteDao.get((long) vo
						.getSiteId());
				plan.setPlanName(mVenderSite.getSiteName() + "活动");// 根据站点名称添加
				plan.setVenderId(userVo.getVenderId());
				plan.setPubdate(DateUtil.parseStrToDate(weekDate[i]));
				plan.setPlanTime(activityPlan.getPlanTime());
				plan.setSiteIds(vo.getSiteId().toString());
				plan.setRemark(activityPlan.getRemark());
				plan = this.insert(plan);
				for (CourseVO v1 : vo.getCoursevo()) {
					events = new NactivityProgramOfEvents();
					events.setDuration(v1.getMin());
					Object progranId = Integer.parseInt(v1.getCourseType());
					events.setProgranId((Integer) progranId);
					if (!"-请选择-".equals(v1.getKeyword())) {
						events.setKeyword(v1.getKeyword());
					}
					events.setTeacherId(Integer.parseInt(v1.getEmployeeId()));
					events.setnActivityPlan(plan);
					events.setParentNode(0);
					nactivityProgramOfEventsDao.save(events);
				}
			}
		}
	}

	/**
	 * 根据ids获取员工，节目，志愿者
	 * 
	 * @param ids
	 * @return
	 */
	public List<AUser> getAUser(String ids) {
		return userDao.getAUser(ids);
	}

	public List<NProgram> findNPrograms(String ids) {
		return nProgramDao.findNPrograms(ids);
	}

	/**
	 * 获取签到的志愿者信息
	 * 
	 * @param ids
	 * @return
	 */
	public List<NVolunteer> findNVolunters(String ids) {
		return volunteerDao.findNVolunters(ids);
	}

	public List<VolunteerVO> findNVoluntersVO(String ids)
			throws IllegalAccessException, InvocationTargetException {
		List<NVolunteer> nv = volunteerDao.findNVolunters(ids);
		List<VolunteerVO> vos = new ArrayList<VolunteerVO>();
		VolunteerVO vo = new VolunteerVO();
		for (NVolunteer n : nv) {
			BeanUtils.copyProperties(vo, n);
			if (n.getSiteId() != null) {
				vo.setSiteId(n.getSiteId());
				vo.setSiteNmae(mVenderSiteService.fingById(n.getSiteId())
						.getSiteName());
			}
			if (n.getCommunity() != null) {
				vo.setCommunity(n.getCommunity());
				String name = oCountryService.getCountryById(
						Integer.parseInt(n.getCommunity())).getName();
				vo.setCommunityNmae(name);
			}
			vos.add(vo);
		}
		return vos;
	}

	/**
	 * 获取本次志愿者的签到人数
	 * 
	 * @param activityId
	 * @param pubdate
	 * @return
	 */
	public int getNVolunteerServiceRecordCount(int activityId, Date pubdate) {
		return nVolunteerServiceRecordDao.getNVolunteerServiceRecordCount(
				activityId, pubdate);
	}

	public List<AUser> getVenderAdmins(String createBy) {
		return userDao.getVenderAdmins(createBy);
	}

	public List<ActivityPlanSchemeVo> listScheme(Integer id) {
		return activityPlanDao.listScheme(id);
	}

	@SuppressWarnings("rawtypes")
	public List getList(long userId, String year) {
		return nCherkListDao.getList(userId, year);
	}
}
