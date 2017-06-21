package com.anticw.aged.controller.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MPosition;
import com.anticw.aged.bean.OMessage;
import com.anticw.aged.bean.ZNotice;
import com.anticw.aged.bean.ZStepCount;
import com.anticw.aged.bean.mongo.BedMovement;
import com.anticw.aged.bean.mongo.BloodGlucose;
import com.anticw.aged.bean.mongo.Electrocardio;
import com.anticw.aged.bean.mongo.Fat;
import com.anticw.aged.bean.mongo.Fridge;
import com.anticw.aged.bean.mongo.Lamp;
import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.mongo.Oxygen;
import com.anticw.aged.bean.mongo.Pressure;
import com.anticw.aged.bean.mongo.Television;
import com.anticw.aged.bean.mongo.Toilet;
import com.anticw.aged.bean.mongo.Weight;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.icare.ZNoticeService;
import com.anticw.aged.service.message.OMessageService;
import com.anticw.aged.service.position.PositionService;
import com.anticw.aged.service.position.ZStepCountService;
import com.anticw.aged.service.professional.data.base.BedMovementService;
import com.anticw.aged.service.professional.data.base.BloodGlucoseService;
import com.anticw.aged.service.professional.data.base.ElectrocardioService;
import com.anticw.aged.service.professional.data.base.FatService;
import com.anticw.aged.service.professional.data.base.FridgeService;
import com.anticw.aged.service.professional.data.base.LampService;
import com.anticw.aged.service.professional.data.base.OxygenService;
import com.anticw.aged.service.professional.data.base.PressureService;
import com.anticw.aged.service.professional.data.base.TelevisionService;
import com.anticw.aged.service.professional.data.base.ToiletService;
import com.anticw.aged.service.professional.data.base.WeightService;
import com.anticw.aged.service.professional.data.server.AlarmService;
import com.anticw.aged.utils.ConfigUtil;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.PostUrlUtil;
import com.anticw.aged.utils.Task;
import com.anticw.aged.vo.professional.upload.BedUploadVo;
import com.anticw.aged.vo.professional.upload.BloodPressureUploadVo;

import cn.emay.sdk.service.SMSService;

/**
 * 接收设备上传信息 同步各个设备的数据，益体康的血压，血氧，血脂，血糖，心电数据
 * 
 * @author L
 *
 */
@Controller
@RequestMapping("data/receive")
public class DataReceiveCtl {
	private static Logger logger = LoggerFactory.getLogger(Task.class);
	@Autowired
	private BedMovementService bedMovementService;
	@Autowired
	private PressureService pressureService;
	@Autowired
	private OxygenService oxygenService;
	@Autowired
	private BloodGlucoseService bloodGlucoseService;
	@Autowired
	private FatService fatService;
	@Autowired
	private ElectrocardioService electrocardioService;
	@Autowired
	private WeightService weightService;
	@Autowired
	private ToiletService toiletService;
	@Autowired
	private TelevisionService televisionService;
	@Autowired
	private LampService lampService;
	@Autowired
	private FridgeService fridgeService;
	@Autowired
	private SMSService sMSService;
	@Autowired
	private OMessageService oMessageService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private ZStepCountService zStepCountService;
	private final static String url = "http://icare.le-ho.cn/icare/notice/addSmartWatch";

	/**
	 * 接收床垫信息
	 * 
	 * @param uploadVo
	 * @return
	 */
	@RequestMapping("bed")
	public @ResponseBody BedMovement ReceiveBedData(BedUploadVo uploadVo) {

		BedMovement bedMovement = new BedMovement();
		try {
			BeanUtils.copyProperties(bedMovement, uploadVo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bedMovement.setDeviceId(uploadVo.getBed_id());
		bedMovement.setUploadTime(new Date());
		bedMovementService.save(bedMovement);
		return bedMovement;
	}

	/**
	 * 接收马桶信息
	 * 
	 * @param uploadVo
	 * @return
	 */
	@RequestMapping("toilet")
	public @ResponseBody String toilet(Toilet toilet) {
		int count = 0;
		if (toilet.getUser_id() != null) {
			toilet.setUploadTime(new Date());
			toilet.setDeviceId(toilet.getUser_id());
			toiletService.save(toilet);
			count++;
		}

		if (count > 0) {
			if ("in".equals(toilet.getAtitle())) {
				new toil().start();

				deviceId = toilet.getDeviceId();
				uploadTime = toilet.getUploadTime();
			}
			return "success";
		} else {
			return "fail";
		}
	}

	private static String deviceId = "";
	private static Date uploadTime = null;

	class toil extends Thread {
		public void run() {
			String deviceId_ = deviceId;
			Date uploadTime_ = uploadTime;
			try {
				TimeUnit.SECONDS.sleep(60 * 40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object[] object = toiletService.getUserId_(deviceId_);
			if (object == null || object[1] == null || object[1] == "") {
				return;
			}
			List<Toilet> toil = toiletService.getAlarmss(deviceId_);
			if (toil.size() == 0) {
				// 发送短信
				sMSService.sendSmartDevice(object[1].toString(), object[0].toString(), "去卫生间已经超过40分钟，请多关注");
				OMessage o = newMessage(object);
				oMessageService.insertOMessage(o);
			} else {
				if (toil.get(0).getUploadTime().getTime() - uploadTime_.getTime() > 1000 * 60 * 40) {
					// 发送短信
					sMSService.sendSmartDevice(object[1].toString(), object[0].toString(), "去卫生间已经超过40分钟，请多关注");
					OMessage o = newMessage(object);
					oMessageService.insertOMessage(o);
				}
			}
		}

		private OMessage newMessage(Object[] object) {
			OMessage o = new OMessage();
			o.setPhone(object[1].toString());
			o.setCreatedTime(new Date());
			o.setComeFrom(4);
			o.setContent(object[0].toString() + "去卫生间已经超过40分钟，请多关注");
			return o;
		}
	}

	/**
	 * 接收灯的接口
	 * 
	 * @param lamp
	 * @return
	 */
	@RequestMapping("lamp")
	public @ResponseBody String addLamp(Lamp lamp) {
		int count = 0;
		lamp.setUploadTime(new Date());
		lampService.save(lamp);
		count++;
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * 接收电视的接口
	 * 
	 * @param Television
	 * @return
	 */
	@RequestMapping("television")
	public @ResponseBody String addTelevision(Television television) {
		int count = 0;
		television.setUploadTime(new Date());
		televisionService.save(television);
		count++;
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * 接收冰箱数据的接口
	 * 
	 * @param fridge
	 * @return
	 */
	@RequestMapping("fridge")
	public @ResponseBody String addTelevision(Fridge fridge) {
		int count = 0;
		fridge.setUploadTime(new Date());
		fridgeService.save(fridge);
		count++;
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * 报警文字描述
	 */
	private static String ALARM_LOWER_DESC = "出现异常";

	/**
	 * 报警文字描述
	 *//*
		 * private static String ALARM_UPPER_DESC = "上限";
		 */

	@Autowired
	private AlarmService activeService;

	/**
	 * 
	 * @param pressure
	 * @return
	 */
	@RequestMapping("pressure")
	public @ResponseBody String toilet(BloodPressureUploadVo bloodPressureUploadVo) {
		int count = 0;
		Pressure bloodPressure = new Pressure();
		bloodPressure.setDeviceId(bloodPressureUploadVo.getUser_id());
		bloodPressure.setHighPressure(bloodPressureUploadVo.getH());
		bloodPressure.setLowPressure(bloodPressureUploadVo.getL());
		bloodPressure.setPulse(bloodPressureUploadVo.getP());
		bloodPressure.setKey(bloodPressureUploadVo.getKey());
		bloodPressure.setBPM(bloodPressureUploadVo.getBPM());
		bloodPressure.setI1(bloodPressureUploadVo.getI1());
		bloodPressure.setI2(bloodPressureUploadVo.getI2());
		bloodPressure.setI3(bloodPressureUploadVo.getI3());
		bloodPressure.setVn(bloodPressureUploadVo.getVn());
		bloodPressure.setUploadTime(new Date());
		pressureService.save(bloodPressure);
		try {
			pressureAnalysis(bloodPressure);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	public void pressureAnalysis(Pressure pressure) {

		Object[] users = pressureService.getUserId(pressure.getDeviceId(), "血压计");
		if (users == null /* || users[1] == null || users[1] == "" */) {
			return;
		}
		// highPressure lowPressure pulse
		List<Object[]> objets = pressureService.getlist(pressure.getDeviceId());

		if (objets.size() == 0) {
			objets = pressureService.getPressurep("m_pressure");
			if (objets.size() == 0) {
				return;
			}

		}
		Field[] field = pressure.getClass().getDeclaredFields();
		System.out.println(field.length);// 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			try {
				String name = field[j].getName(); // 获取属性的名字
				for (Object[] o : objets) {
					if (o[0].toString().equals(name)) {
						String type = field[j].getGenericType().toString(); // 获取属性的类型
						name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造
						if (type.equals("class java.lang.Float")) {
							Method m = pressure.getClass().getMethod("get" + name);
							Float value = (Float) m.invoke(pressure);
							if (value != null && o[1] != null && o[2] != null) {
								String s1 = o[2].toString();// 上标
								float f1 = Float.valueOf(s1);
								MAlarm curAlarm = new MAlarm();
								if (users[1] != null) {
									curAlarm.setUserName(users[1].toString());
								}
								String itemDesc = pressureService.getByItemName(name);
								if (value > f1 | value < f1) {
									curAlarm.setDateItemDesc("您的" + itemDesc + ALARM_LOWER_DESC);
								}
								curAlarm.setUserId(Long.valueOf(users[0].toString()));
								curAlarm.setContect("");
								curAlarm.setContent(value.toString());
								curAlarm.setDataItemName(o[0].toString());
								curAlarm.setAlarmValue(value);
								curAlarm.setServiceId(Integer.valueOf(o[3].toString()));
								curAlarm.setAlarmTime(uploadTime);
								// curAlarm.setResponseTime();
								curAlarm.setStatus((short) 0);
								curAlarm.setCreatedBy("");
								this.activeService.save(curAlarm);
								break;
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 接收益体康设备采集的数据
	 * 
	 * @param bPressureUploadVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("bloodpressure")
	public @ResponseBody Object syncedPressureData(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String jsonString = request.getParameter("datas");
		int count = 0;
		HttpStatus status = null;
		JSONArray array = JSONArray.parseArray(jsonString);
		logger.info("上传条数=======" + array.size() + array.toJSONString().toString() + "上传记录");
		if (array != null) {
			for (int i = 0; i < array.size(); i++) {
				String apptype = array.getJSONObject(i).getString("apptype");
				String idcard = array.getJSONObject(i).getString("datakey").substring(46, 54);
				/*
				 * DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
				 * Date date =
				 * fmt.parse(array.getJSONObject(i).getString("adddate"));
				 */
				// 保存血压数据，并存入原有的血压表中
				if ("BloodPressureV1".equals(apptype)) {
					Float highPressure = array.getJSONObject(i).getFloat("systolicpressure");
					Float lowPressure = array.getJSONObject(i).getFloat("diastolicpressure");
					Pressure bloodPressure = new Pressure();
					bloodPressure.setDeviceId(idcard);
					bloodPressure.setHighPressure(highPressure);
					bloodPressure.setLowPressure(lowPressure);
					bloodPressure.setAvgPressure((highPressure + lowPressure) / 2);
					bloodPressure.setPulse(array.getJSONObject(i).getFloat("pulse"));
					bloodPressure.setDvaluePressure(highPressure - lowPressure);
					bloodPressure.setUploadTime(new Date());
					try {
						BeanUtils.copyProperties(bloodPressure, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					pressureService.save(bloodPressure);
					try {
						pressureAnalysis(bloodPressure);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				// 保存血氧数据，并存入原有的血压表中
				if ("Spo2DataV1".equals(apptype)) {
					Oxygen oxygen = new Oxygen();
					oxygen.setDeviceId(idcard);
					oxygen.setUploadTime(new Date());
					oxygen.setSpo2(array.getJSONObject(i).getFloat("oxygen"));
					try {
						BeanUtils.copyProperties(oxygen, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					oxygenService.save(oxygen);

				}
				// 保存血糖数据
				if ("BGDataV1".equals(apptype)) {
					BloodGlucose bloodGlucose = new BloodGlucose();
					bloodGlucose.setDeviceId(idcard);
					bloodGlucose.setUploadTime(new Date());
					bloodGlucose.setBloodGlucose(array.getJSONObject(i).getFloat("bloodsugar"));
					try {
						BeanUtils.copyProperties(bloodGlucose, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					bloodGlucoseService.save(bloodGlucose);

				}
				// 保存脂肪数据，并存入新建的心电表中
				if ("FatDataV1".equals(apptype)) {
					Fat fat = new Fat();
					fat.setDeviceId(idcard);
					fat.setUploadTime(new Date());
					fat.setBt(array.getJSONObject(i).getString("bodytype"));
					try {
						BeanUtils.copyProperties(fat, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					fatService.save(fat);

				}
				// 保存心电数据，并存入新建的心电表中
				if ("EcgStructV1".equals(apptype)) {
					Electrocardio electrocardio = new Electrocardio();
					electrocardio.setDeviceId(idcard);
					electrocardio.setUploadTime(new Date());
					try {
						BeanUtils.copyProperties(electrocardio, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					electrocardioService.save(electrocardio);

				}
				// 保存体重数据，并存入原有的血压表中
				if ("WeightDataV1".equals(apptype)) {
					Weight weight = new Weight();
					weight.setDeviceId(idcard);
					weight.setUploadTime(new Date());
					weight.setWeight(array.getJSONObject(i).getFloat("weight"));
					try {
						BeanUtils.copyProperties(weight, array.getJSONObject(i));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					weightService.save(weight);

				}
				count++;
			}
			if (array.size() == count) {
				status = HttpStatus.OK;
				response.getWriter().print(true);
			} else {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				response.getWriter().print(false);
			}
		}
		return status;
	}

	/**
	 * <p>
	 * 此款腕表推送过来数据共有21种类型 前十八种推送数据类型一致 统一解析
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("smartwatch")
	public @ResponseBody void smartWatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 将资料解码
		String jsonString = sb.toString();
		jsonString = URLDecoder.decode(jsonString, "UTF-8");
		JSONObject json = JSONObject.parseObject(jsonString);
		// 根据设备id获取userId
		/*
		 * {”event”:xxx,”md5”:CJCKCJDWWINRDLIQ,dateTime”:”YYYY-DD-MM
		 * hh24:mm:ss”, ”result”:{"lat":30.266458,"lon":120.162332,"road":
		 * " 浙江省,杭州市,下城区,武林街道,凤起路"}}
		 */
		String event = json.getString("event");
		JSONObject result = json.getJSONObject("result");
		String md5 = json.getString("md5");
		Long userId = 0L;
		try {
			userId = positionService.getByDeviceId(md5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String lat = result.getString("lat");
		String lon = result.getString("lon");
		Integer battery = result.getInteger("battery");
		MPosition m = new MPosition();
		m.setAvailable(true);
		m.setCreateTime(json.getDate("dateTime"));
		m.setLatitude(lat);
		m.setLongitude(lon);
		m.setUserId(userId);
		m.setType(2);
		positionService.insertPosition(m);

		JSONObject data = null;
		if ("LATEST_STEP".equals(event)) {// 计步
			data = result.getJSONObject("data");
			String count = data.getString("count");
			ZStepCount zStepCount = new ZStepCount();
			zStepCount.setUserId(userId);
			zStepCount.setCount(Integer.parseInt(count));
			zStepCountService.update(zStepCount);
		} else if ("LATEST_BLOOD_PRESSURE".equals(event)) { // 血压
			data = result.getJSONObject("data");
			String diastolicPressure = data.getString("diastolic_pressure");
			String systolicPressure = data.getString("systolic_pressure");

			Pressure bloodPressure = new Pressure();
			bloodPressure.setDeviceId(md5);
			bloodPressure.setHighPressure(Float.parseFloat(systolicPressure));
			bloodPressure.setLowPressure(Float.parseFloat(diastolicPressure));
			bloodPressure
					.setAvgPressure((Float.parseFloat(systolicPressure) + Float.parseFloat(diastolicPressure)) / 2);
			bloodPressure.setDvaluePressure(Float.parseFloat(systolicPressure) - Float.parseFloat(diastolicPressure));
			bloodPressure.setUploadTime(json.getDate("dateTime"));
			pressureService.save(bloodPressure);

		} else if ("LATEST_HEART_RATE".equals(event)) { // 心率
			data = result.getJSONObject("data");
			String stepNumber = data.getString("heartRate");
			Pressure bloodPressure = new Pressure();
			bloodPressure.setDeviceId(md5);
			bloodPressure.setPulse(Float.parseFloat(stepNumber));
			bloodPressure.setUploadTime(json.getDate("dateTime"));
			pressureService.save(bloodPressure);

		} else if ("LOW_BATTERY".equals(event)) {
			String userContact = zStepCountService.getById(userId);
			this.add(userContact, "您的腕表电量已不足百分之" + battery + ",请及时充电！");
		} else if ("DEVICE_OFFLINE".equals(event)) {
			String userContact = zStepCountService.getById(userId);
			this.add(userContact,"腕表离线超过1小时，请多关注！");
		}else if("SOS_ALARM".equals(event)) {
			String userContact = zStepCountService.getById(userId);
			String date=DateUtil.getCurrentFormatDateTime();
			String road = result.getString("road");
			this.add(userContact, "腕表在"+date+"拨打sos紧急救援电话,所在位置为"+road);
		}

		if (battery <= 40) {
			String userContact = zStepCountService.getById(userId);
			this.add(userContact, "您的腕表电量已不足百分之" + battery + ",请及时充电！");
		}
	}

	/**
	 * 精准定位
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("orientation")
	public @ResponseBody String orientation(Long userId) {
		String bind = positionService.getByUserId(userId);
		String tokenUrl = ConfigUtil.getInstance().getProperty("login");
		String apiKey = ConfigUtil.getInstance().getProperty("apiKey");
		StringBuffer key = new StringBuffer();
		String msg = "";
		try {
			key.append("apiKey=").append(URLEncoder.encode(apiKey, "UTF-8"));
			String token = PostUrlUtil.getToken(tokenUrl, key.toString());
			String url = ConfigUtil.getInstance().getProperty("stepCalculation");
			StringBuffer sb = new StringBuffer();
			sb.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
					.append(URLEncoder.encode(bind, "UTF-8"));
			msg = PostUrlUtil.getPost(url, sb.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;

	}
	@Autowired
	private ZNoticeService zNoticeService;
	
	public void add(String userContact,String content){
		ZNotice zNotice=new ZNotice();
		zNotice.setAvailable(true);
		zNotice.setIsvalidity(false);
		zNotice.setType(2);
		zNotice.setUserContact(userContact);
		zNotice.setContent(content);
		zNotice.setCreateTime(new Date());
		zNoticeService.add(zNotice);
		
	}

}
