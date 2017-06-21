package com.anticw.aged.controller.professional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.MetaService;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.data.server.AlarmService;
import com.anticw.aged.service.professional.data.server.MetaDataService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.data.CommonDataVO;
import com.anticw.aged.vo.professional.data.MyServiceDataVO;
import com.anticw.aged.vo.professional.meta.MeataServiceVo;
import com.anticw.aged.vo.professional.service.OrderServiceVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.user.DatatableVO;

/**
 * 获取元服务采集数据的请求控制器
 * <P>
 * File name : DataCtl.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-10-12
 * </P>
 */
@Controller
public class DataCtl {

	/**
	 * 获取采集数据的服务类
	 */
	@Autowired
	private MetaDataService dataService;

	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	private SpecService specService;

	/**
	 * 专业服务商
	 */
	@Autowired
	private VenderService venderService;

	/**
	 * 用户业务
	 */
	@Autowired
	private RUserService rUserService;

	/**
	 * 警报服务
	 */
	@Autowired
	private AlarmService alarmService;

	@Autowired
	private SpringDataPool pool;

	@Autowired
	private MetaService metaService;

	@Autowired
	private VenderService mVenderService;

	/**
	 * 获取我的服务采集数据 DataCtl.getServiceData()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-12
	 * </P>
	 * 
	 * @param userId
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/myservices")
	public ModelAndView getMyServiceData(HttpSession session, Long userId, DateParamVO dateCond, PageParamVO page)
			throws Exception {

		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 从session中获取userId
		if (userId == null) {
			// 从session中获取用户信息
			userId = userVo.getId();
		}

		// 获取用户的订单信息
		Map<Integer, MOrder> orders = specService.getUserOrdersAndHandleExpire(userId,
				ProfessionalConstants.ORDER_STATUS_OPENED);
		RUser ruser = rUserService.findById(userId);
		// 未传递分页参数 －－ 老年人获取我的服务数据 默认取一页一条数据

		// 未传递日期参数 －－ 老年人获取我的服务数据 默认取3天之内的最新数据
		if (dateCond == null || dateCond.getStart() == null || dateCond.getEnd() == null) {
			dateCond = new DateParamVO();
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.set(Calendar.HOUR_OF_DAY, 24);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			dateCond.setEnd(c.getTime());
			c.roll(Calendar.DAY_OF_YEAR, -30);
			dateCond.setStart(c.getTime());
		}
		// 我的服务中只获取最新的一条数据

		ModelAndView mv = null;
		if (userVo.getCateEnum().getType() == UserCategoryEnum.PRO.getType()) {
			mv = new ModelAndView("professional/vender/cmadd/my_service");
		} else {
			mv = new ModelAndView("professional/data/my_service");
		}
		// 获取我的服务数据
		List<MyServiceDataVO> datas = dataService.getMyServiceDatas(orders, dateCond, page);
		mv.addObject("length", datas.size());
		mv.addObject("datas", datas);
		mv.addObject("userId", userId);
		mv.addObject("user", ruser);
		mv.addObject("IdCardNo", ruser.getIdCardNo());
		return mv;
	}

	@RequestMapping("/professional/mobile/user/service")
	public @ResponseBody String mobileMyServices(HttpSession session, String callback) throws Exception {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 老人id
		Long userId = userVo.getId();
		// 获取用户的订单信息
		Map<Integer, MOrder> orders = specService.getUserOrdersAndHandleExpire(userId,
				ProfessionalConstants.ORDER_STATUS_OPENED);
		try {
			List<OrderServiceVO> datas = dataService.getMyOrderServiceList(orders);
			String result = PublicService.returnJSONP(ExceptionCode.SUCCESS, datas, callback);
			return result == null ? null : result.replaceAll(" 00:00:00", "");
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, null, callback);
		}
	}

	/**
	 * 去历史数据页面、根据不同数据模块展示 DataCtl.toHistoryDataPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-17
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	// --------------------------要用----------------------------------------

	@RequestMapping(value = "/professional/service/history")
	public ModelAndView toHistoryDataPage(Long userId, Integer serviceId, Short type, DateParamVO dateCond)
			throws Exception {
		ModelAndView mv = null;
		// 此处为脑电波的元服务Id[根据数据库serviceId更改],服务器数据库为30
		if (type == 2) {
			mv = new ModelAndView("professional/data/my_history_eeg");
			RUser ruser = rUserService.findById(userId);
			mv.addObject("IdCardNo", ruser.getIdCardNo());
			mv.addObject("userId", userId);
			mv.addObject("start", new Date());
			mv.addObject("end", DateUtil.minusDays(new Date(), 3));
			mv.addObject("type", type);
			mv.addObject("serviceId", serviceId);
		} else if (type == 3) {
			mv = new ModelAndView("professional/data/spec/mattress");
			// mv = new ModelAndView("professional/data/spec/mattress_OneWeek");
			if (dateCond.getStart() == null || DateUtil.compareDate(new Date(), dateCond.getStart()) < 0) {
				String ed = DateUtil.getCurrentFormatDate() + " 23:59:59";
				String sd = DateUtil.getCurrentFormatDate() + " 00:00:00";
				dateCond.setStart(DateUtil.parseStrToDateTime(sd));
				dateCond.setEnd(DateUtil.parseStrToDateTime(ed));

				mv.addObject("qianqi", DateUtil.getDateStart(DateUtil.parseStrToDateTime(sd)));
				mv.addObject("qianmo", DateUtil.getDateStart(DateUtil.parseStrToDateTime(ed)));
				mv.addObject("houqi", DateUtil.getDateEnd(DateUtil.parseStrToDateTime(sd)));
				mv.addObject("houmo", DateUtil.getDateEnd(DateUtil.parseStrToDateTime(ed)));
			} else {
				String ed = DateUtil.getCurrentFormatDate(dateCond.getStart()) + " 23:59:59";
				String sd = DateUtil.getCurrentFormatDate(dateCond.getStart()) + " 00:00:00";
				dateCond.setStart(DateUtil.parseStrToDateTime(sd));
				dateCond.setEnd(DateUtil.parseStrToDateTime(ed));
				mv.addObject("qianqi", DateUtil.getDateStart(dateCond.getStart()));
				mv.addObject("qianmo", DateUtil.getDateStart(dateCond.getEnd()));
				mv.addObject("houqi", DateUtil.getDateEnd(dateCond.getEnd()));
				mv.addObject("houmo", DateUtil.getDateEnd(dateCond.getStart()));
			}
			mv.addObject("newDate", DateUtil.getCurrentFormatDate(dateCond.getStart()));
			MOrder order = specService.getOrderByUSID(userId, serviceId);
			MyServiceDataVO mvs = dataService.getMyserviceData(order, dateCond, new PageParamVO(1, 1000000));
			List<List<Object>> list = new ArrayList<List<Object>>();
			List<List<Object>> list1 = mvs.getData().getValues();
			List<List<Object>> pant = new ArrayList<List<Object>>();
			Object o1 = null;
			if (list1.size() != 0 && list1.size() > 1) {
				for (int i = 0; i < list1.size(); i++) {
					List<Object> li = new ArrayList<Object>();
					li.add(list1.get(i).get(1));
					li.add(list1.get(i).get(2));
					pant.add(li);
					List<Object> ob = new ArrayList<Object>();
					// 开始时间
					if (o1 == null) {
						o1 = list1.get(0).get(2);
					}
					// 状态变化的情况下
					if (i + 1 < list1.size() && !list1.get(i).get(0).equals(list1.get(i + 1).get(0))) {
						// 结束时间
						ob.add(o1);
						ob.add(list1.get(i + 1).get(2));
						ob.add(list1.get(i).get(0));
						o1 = list1.get(i + 1).get(2);
						list.add(ob);
					}
					// 状态没有变化？？

				}
				List<Object> ob1 = new ArrayList<Object>();
				if (list.size() <= 1 && list1.get(0).get(0).equals(list1.get(list.size()).get(0))) {
					o1 = list1.get(0).get(2);
					ob1.add(o1);
					ob1.add(list1.get(list1.size() - 1).get(2));
					ob1.add(list1.get(list1.size() - 1).get(0));
					list.add(ob1);
				}
				if (list.size() > 2 && !list.get(list.size() - 1).get(0).equals(list1.get(list1.size() - 1).get(0))) {
					List<Object> ob = new ArrayList<Object>();
					ob.add(list.get(list.size() - 1).get(0));
					ob.add(list1.get(list1.size() - 1).get(2));
					ob.add(list1.get(list1.size() - 1).get(0));
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
			mv = new ModelAndView("professional/data/my_history");
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

	@RequestMapping(value = "/professional/service/eeg")
	public ModelAndView toHistoryDataPage(DatatableVO vo) throws Exception {
		ModelAndView mv = new ModelAndView("professional/data/eeg_specifics");
		mv.addObject("vo", vo);
		return mv;
	}
	// -----------------==========根据专业服务加载元服务========-----------------------

	@RequestMapping(value = "/professional/service/unit")
	public @ResponseBody JSONObject mMetaService(Long userId, int serviceId) throws Exception {
		Map<Integer, MOrder> orderMap = specService.getUserOrder(userId, serviceId);
		MOrder order = orderMap.get(serviceId);
		Set<MOrderDevice> orderDevices = null;
		if (order != null) {
			orderDevices = order.getOrderDevices();
		}
		List<MeataServiceVo> meataService = new ArrayList<MeataServiceVo>();
		for (MOrderDevice mOrderDevice : orderDevices) {
			MeataServiceVo meataServiceVo = new MeataServiceVo();
			meataServiceVo.setDeviceBindId(mOrderDevice.getDeviceBindId());
			meataServiceVo.setMetaServiceId(mOrderDevice.getMetaServiceId());
			MMetaService mMetaService = metaService.getMMetaServices(mOrderDevice.getMetaServiceId());
			meataServiceVo.setMetaServicename(mMetaService.getName());
			meataService.add(meataServiceVo);
		}
		JSONObject jsons = new JSONObject();
		jsons.put("mMetaService", meataService);
		return jsons;
	}

	/**
	 * 不同专业服务展示页面
	 * 
	 * @author L
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/service/diverseShow")
	public ModelAndView diverseShow(Integer stype, Long userId, Integer serviceId, DateParamVO dateCond)
			throws Exception {
		if (stype != 1 || pool.getSpecShowType(stype) == null) {
			int type = stype;
			return toHistoryDataPage(userId, serviceId, (short) type, dateCond);
		}

		if (stype == 1) {
			return bedinfo(stype, userId, serviceId, dateCond);
		}
		throw new BusinessException(ExceptionCode.MSERVICESHOWTYPEERROR);
	}

	/**
	 * 台湾智能床垫展示
	 * 
	 * @param stype
	 * @return
	 * @throws BusinessException
	 */
	private ModelAndView bedinfo(Integer stype, Long userId, Integer serviceId, DateParamVO dateCond)
			throws BusinessException {
		// professional/data/spec/bed
		ModelAndView mv = new ModelAndView(pool.getSpecShowType(stype).getPage());
		bed(stype, userId, serviceId, dateCond, mv);
		return mv;
	}

	private void bed(Integer stype, Long userId, Integer serviceId, DateParamVO dateCond, ModelAndView mv)
			throws BusinessException {
		MOrder order = specService.getOrderByUSID(userId, serviceId);
		// 设置date条件
		if (dateCond.getStart() == null || DateUtil.compareDate(new Date(), dateCond.getStart()) < 0) {
			dateCond.setStart(DateUtil.getMondayInWeek(new Date()));
		}
		if (dateCond.getEnd() == null) {
			dateCond.setEnd(DateUtil.getSundayInWeek(new Date()));
		}
		if (DateUtil.compareDate(new Date(), dateCond.getEnd()) < 0) {
			dateCond.setEnd(DateUtil.convertDate(new Date()));
		}
		List<MyServiceDataVO> datas = dataService.getMyserviceDataByDay(order, dateCond, new PageParamVO(1, 1000000));
		// 设置百分比参数，页面时间展示
		for (MyServiceDataVO datavo : datas) {
			for (List<Object> item : datavo.getData().getValues()) {
				float current = DateUtil.getTotalTime(datavo.getDate(), (Date) item.get(0));
				item.add(current / (float) 86400000);
			}
		}
		// 设置date参数
		DateParamVO preweek = new DateParamVO(DateUtil.getMondayInWeek(DateUtil.addDays(dateCond.getStart(), -7)),
				DateUtil.getSundayInWeek(DateUtil.addDays(dateCond.getStart(), -7)));
		DateParamVO nextweek = new DateParamVO(DateUtil.getMondayInWeek(DateUtil.addDays(dateCond.getStart(), 7)),
				DateUtil.getSundayInWeek(DateUtil.addDays(dateCond.getStart(), 7)));
		mv.addObject("datas", datas);
		mv.addObject("preweek", preweek);
		mv.addObject("nextweek", nextweek);
		mv.addObject("datecond", dateCond);
		mv.addObject("stype", stype);
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
	}

	/**
	 * 历史数据图表展示页
	 * 
	 * @author L 2014-12-16
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/professional/service/show")
	public ModelAndView historyShow(MOrderDevice orderDevice, DateParamVO dateCond, PageParamVO page)
			throws BusinessException {
		if (dateCond.getStart() == null) {
			dateCond.setStart(DateUtil.getFirstDayInMonth(new Date()));
		}
		if (dateCond.getEnd() == null) {
			dateCond.setEnd(DateUtil.getLastDayInMonth(new Date()));
		}
		CommonDataVO data = dataService.getMetaDatasWithUpLoadTime(orderDevice, dateCond, page);
		ModelAndView mv = new ModelAndView("professional/data/show_history");
		mv.addObject("device", orderDevice);
		mv.addObject("data", data);
		mv.addObject("dateCond", dateCond);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * @author dx 获取报告中服务项（报表和列表）
	 * @param str
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/service/showservice")
	public @ResponseBody JSONObject SreviceShow(String str) throws Exception {
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String[] s = str.split(";");
		JSONArray json_num = new JSONArray();
		for (int i = 0; i < s.length; i++) {
			String ids = s[i];
			String[] num = ids.split(",");
			JSONObject jsonObject = new JSONObject();
			MOrderDevice orderDevice = new MOrderDevice();
			DateParamVO dateCond = new DateParamVO();
			orderDevice.setMetaServiceId(Integer.parseInt(num[0]));
			orderDevice.setDeviceBindId(num[1]);
			dateCond.setStart(formatter.parse(num[2]));
			dateCond.setEnd(formatter.parse(num[3]));
			jsonObject = dataService.getMetaDataTime(orderDevice, dateCond);
			json_num.add(i, jsonObject);
		}
		JSONObject object = new JSONObject();
		object.put("servicesSet", json_num);
		return object;
	}

	/**
	 * 查询历史数据 DataCtl.queryHistoryData()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-17
	 * </P>
	 * 
	 * @param userId
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/history/query")
	public ModelAndView queryHistoryData(Long userId, Integer serviceId, DateParamVO dateCond, PageParamVO page)
			throws Exception {

		// 获取用户的订单信息
		Map<Integer, MOrder> orders = specService.getUserOrder(userId, serviceId);

		// 获取历史数据
		List<MyServiceDataVO> datas = dataService.getMyServiceDatas(orders, dateCond, page);

		ModelAndView mv = new ModelAndView("professional/data/my_history");
		mv.addObject("userId", userId);
		mv.addObject("serviceId", serviceId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("page", page);
		mv.addObject("datas", datas);
		return mv;

	}

	/**
	 * 跳转至警报页面 DataCtl.toAlarmPage()<BR>
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
	@RequestMapping(value = "/professional/alarm")
	public ModelAndView toAlarmPage(HttpSession session, Long userId, PageParamVO pageParamVO) throws Exception {

		// 默认返回当月第一页警报数据
		Date start = DateUtil.getFirstDayInMonth(new Date());
		Date end = DateUtil.getLastDayInMonth(new Date());
		DateParamVO dateCond = new DateParamVO(start, end);

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);

		List<Integer> venderIds = new ArrayList<Integer>();
		// 目前的需求专业服务商页面查看警报数据是按单个人处理的
		getVenderIds(userVo, venderIds);
		Page<MAlarm> alarms = null;
		// 获取警报记录
		if (venderIds.size() != 0) {
			alarms = dataService.getAlarms(venderIds, -1, (short) -1, dateCond, pageParamVO);
		} else {
			alarms = dataService.getAlarms(userVo.getId(), null, -1, (short) -1, dateCond, pageParamVO);
		}

		// 获取专业服务信息
		List<MMetaService> services = metaService.listAll();
		// 获取全部元服务

		ModelAndView mv = new ModelAndView("professional/vender/alarm");
		mv.addObject("page", alarms);
		if (userVo.getCateEnum() == UserCategoryEnum.PRO) {
			mv.addObject("venderId", userVo.getVenderId());
		}

		mv.addObject("userId", userId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("services", services);
		mv.addObject("pageCond", pageParamVO);
		return mv;
	}

	private void getVenderIds(UserVO userVo, List<Integer> venderIds) {
		if (userVo.getCateEnum() == UserCategoryEnum.CM) {
			List<MVender> mVender = mVenderService.venders(userVo.getName());
			for (MVender m : mVender) {
				venderIds.add(m.getId());
			}
		} else if (userVo.getCateEnum() == UserCategoryEnum.PRO) {
			venderIds.add(userVo.getVenderId());
		}
	}

	/**
	 * 查询警报数据 DataCtl.queryAlarm()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-13
	 * </P>
	 * 
	 * @param userId
	 * @param serviceId
	 * @param status
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/alarm/query")
	public ModelAndView queryAlarm(HttpSession session, Long userId, String userName, Integer serviceId, Short status,
			DateParamVO dateCond, PageParamVO pageCond) throws Exception {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 从session中获取用户的类型并返回 用于区分显示哪些字段
		int userCategory = userVo.getCateEnum().getType();
		// 用户Id集合
		// List<Long> userIds = getUserIds(userVo);
		List<Integer> venderIds = new ArrayList<Integer>();
		// 目前的需求专业服务商页面查看警报数据是按单个人处理的
		getVenderIds(userVo, venderIds);

		ModelAndView mv = new ModelAndView("professional/vender/alarm");
		// 获取警报信息
		Page<MAlarm> alarms = new Page<MAlarm>();

		if (venderIds.size() != 0) {
			alarms = dataService.getAlarms(venderIds, serviceId, status, dateCond, pageCond);
		} else {
			alarms = dataService.getAlarms(userVo.getId(), userName, serviceId, status, dateCond, pageCond);
		}

		// 获取专业服务信息
		List<MMetaService> services = metaService.listAll();
		mv.addObject("userId", userId);
		mv.addObject("dateCond", dateCond);
		mv.addObject("services", services);
		mv.addObject("page", alarms);

		mv.addObject("serviceId", serviceId);
		mv.addObject("userName", userName);
		mv.addObject("status", status);
		mv.addObject("userCategory", userCategory);
		return mv;
	}

	/**
	 * 专业服务商处理警报
	 * 
	 * @param session
	 * @param userId
	 * @param id
	 * @param suggestion
	 * @return
	 */
	@RequestMapping(value = "/professional/alarm/deal")
	public ModelAndView dealAlarm(HttpSession session, String id, String suggestion, Long userId, String userName,
			Integer serviceId, Short status, DateParamVO dateCond, PageParamVO pageCond) throws Exception {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		alarmService.dealAlarm(userVo.getName(), id, suggestion);
		return queryAlarm(session, userId, userName, serviceId, status, dateCond, pageCond);
	}

	/**
	 * 移动端处理警报
	 * 
	 * @name DataCtl.mobileDealWithAlarm()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午6:18:52
	 * @param session
	 * @param id
	 * @param suggestion
	 * @param callback
	 * @return
	 */
	@RequestMapping(value = "/professional/mobile/alarm/dealWith")
	public @ResponseBody String mobileDealWithAlarm(HttpSession session, String id, String suggestion,
			String callback) {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		MAlarm mAlarm = null;
		try {
			mAlarm = dataService.dealWithAlarm(id, userVo.getName(), suggestion);
		} catch (BusinessException be) {
			return PublicService.returnJSONP(be.getCode(), mAlarm, callback);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, mAlarm, callback);
		}

		return PublicService.returnJSONP(ExceptionCode.SUCCESS, mAlarm, callback);
	}

	@Autowired
	private MUserVenderService mUserVenderService;

	/**
	 * 根据当前登录的用户获取用户Id或者获取该用户所管辖的用户Id
	 * 
	 * @param userVo
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<Long> getUserIds(UserVO userVo) {

		// 用户Id
		Long userId = null;
		// 从session中获取用户的类型并返回 用于区分显示哪些字段
		int userCategory = userVo.getCateEnum().getType();
		// 普通用户直接获取用户id
		if (userCategory == UserCategoryEnum.USER.getType()) {
			userId = userVo.getId();
		}

		// 非普通用户登录需要获取该用户所管辖的普通用户id集合
		List<Long> userIds = new ArrayList<Long>();

		// 根据当前操作用户的
		if (userId != null) {
			userIds.add(userId);
		} else if (userCategory == UserCategoryEnum.PRO.getType()) {
			// 专业服务上查询管辖范围内老人的警报信息
			List<VenderServUserVO> userList = null;
			if (userVo.isSuper_() == true) {
				userList = venderService.getSevUsers(userVo.isSuper_(), (int) userVo.getId(), null, null,
						userVo.getCommunityId(), userVo.getVenderId(), ProfessionalConstants.VENDER_USER_DIS_ALL);

			} else {
				userList = mUserVenderService.getNormalUser(userVo.getId(), userVo.getVenderId());
			}
			if (userList != null && !userList.isEmpty()) {
				for (VenderServUserVO uVO : userList) {
					userIds.add(uVO.getUserId());
				}
			}

		} else if (userCategory == UserCategoryEnum.CM.getType()) {
			// careManager 查询管辖范围内老人警报信息
			List<RUser> userList = rUserService.list(null, userVo.getCommunityId());
			if (userList != null && !userList.isEmpty()) {
				for (RUser user : userList) {
					userIds.add(user.getId());
				}
			}
		}

		return userIds;
	}

	/**
	 * 获取服务列表
	 * 
	 * @param userVo
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<ServiceVO> getServices(UserVO userVo) {
		List<ServiceVO> services = new ArrayList<ServiceVO>();
		try {
			services = specService.getServicesBrief();
		} catch (Exception e) {
			e.printStackTrace();
			return services;
		}
		return services;
		/*
		 * int userCategory = userVo.getCateEnum().getType(); if(userCategory ==
		 * UserCategoryEnum.USER.getType()){ } else if(userCategory ==
		 * UserCategoryEnum.PRO.getType()){ } else if(userCategory ==
		 * UserCategoryEnum.CM.getType()){ }
		 */
	}

	@Autowired
	private SpringDataPool springDataPool;

	@RequestMapping(value = "/community/getCountry/{pid}")
	public @ResponseBody JSONObject mMetaService(@PathVariable Integer pid) throws Exception {
		JSONObject data = new JSONObject();
		List<OCountry> countrys = this.springDataPool.getPCountryList(pid);
		data.put("countrys", countrys);
		return data;
	}

	@Autowired
	private OCountryService oCountryService;

	@RequestMapping(value = "/community/getCountryList")
	public @ResponseBody JSONObject mMetaServiceList(String ids) throws Exception {
		JSONObject data = new JSONObject();
		List<OCountry> countrys = oCountryService.getCountryByIds(ids);
		data.put("countrys", countrys);
		return data;
	}

	@RequestMapping(value = "/community/oCountry")
	public @ResponseBody JSONObject oCountry(Integer id) throws Exception {
		JSONObject data = new JSONObject();
		OCountry countrys = oCountryService.getCountryById(id);
		data.put("countrys", countrys);
		return data;
	}
}
