package com.anticw.aged.service.professional.data.server;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MAlarmThreshold;
import com.anticw.aged.bean.MDataModuleItem;
import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.mongo.MetaData;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.data.AlarmDao;
import com.anticw.aged.dao.professional.mdatamodule.MDataModuleItemDao;
import com.anticw.aged.dao.professional.vender.AlarmThresholdDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.professional.MetaService;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.service.professional.data.base.AbstractDataService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.SpringContextHolder;
import com.anticw.aged.utils.StringConvertUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.data.CommonDataVO;
import com.anticw.aged.vo.professional.data.MetaConfigVO;
import com.anticw.aged.vo.professional.data.MyServiceDataVO;
import com.anticw.aged.vo.professional.meta.DataModuleItemVO;
import com.anticw.aged.vo.professional.meta.DataModuleVO;
import com.anticw.aged.vo.professional.service.OrderServiceVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.professional.vender.InputInfoVO;

/**
 * 元服务数据采集服务类
 * <P>File name : MetaDataService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Service
public class MetaDataService implements InitializingBean {

	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	protected SpecService specService;
	
	/**
	 * 元服务业务逻辑处理类
	 */
	@Autowired
	protected MetaService metaService;

	/**
	 * 元服务配置
	 */
	private MetaConfiguration metaConfiguration;

	/**
	 * 警报持久化对象
	 */
	@Autowired
	private AlarmDao alarmDao;
	
	 

	/**
	 * 初始化元服务配置
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-12 </P>
	 * @throws Exception
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		metaConfiguration = new MetaConfiguration();
	}

	
	public List<MyServiceDataVO> getListDatas(Map<Integer, MOrder> orders,
			DateParamVO dateCond, PageParamVO page) throws BusinessException {

		// 我的服务数据集合
		List<MyServiceDataVO> datas = new ArrayList<MyServiceDataVO>();
		
		// 遍历用户开通的所有专业服务然后获取每一个的采集数据
		for (Iterator<Entry<Integer, MOrder>> iter = orders.entrySet()
				.iterator(); iter.hasNext();) {

			// Entry
			Entry<Integer, MOrder> entry = iter.next();

			// 订单信息
			MOrder order = entry.getValue();
			
			
			// 获取设备信息 该处目前也考虑多个元服务多个元数据模块的情况
			MyServiceDataVO myServiceDataVo = new MyServiceDataVO();
			if(order.getmMetaService().getId()!=30){
				Set<MOrderDevice> orderDevices = order.getOrderDevices();

			// 根据元服务获取到的数据集合
				List<CommonDataVO> commonDatas = new ArrayList<CommonDataVO>();

			// 遍历订购设备信息列表
				for (Iterator<MOrderDevice> _iter = orderDevices.iterator(); _iter
						.hasNext();) {
	
					// 订购的设备信息
					MOrderDevice orderDevice = _iter.next();
	
					// 查询采集数据
					CommonDataVO data = getMetaDatas(orderDevice, dateCond, page);
	
					// 加入集合
					commonDatas.add(data);
				}
			// 专业服务数据title 和 结果 包含所有的元服务
				List<String> allTitles = new ArrayList<String>();
				List<List<Object>> allValues = new ArrayList<List<Object>>();
			
			// 将同一个专业服务下不同的元服务的数据合并到一个结果集中
			for (Iterator<CommonDataVO> _iter = commonDatas.iterator(); _iter
					.hasNext();) {

				// 某个元服务对应的数据结果
				CommonDataVO commonDataVo = _iter.next();

				// 将元服务对应的数据加入到
				if (commonDataVo.getTitles() != null) {
					allTitles.addAll(commonDataVo.getTitles());
				}

				if (commonDataVo.getValues() != null) {

					//
					List<Object> values = null;
					if (allValues.isEmpty()) {
						values = new ArrayList<Object>();
						allValues.add(values);
					} else {
						values = allValues.get(0);
					}
					// 合并结果集
					values.addAll(commonDataVo.getValues());
				}
				
			}

			// 构建返回值
				
				//myServiceDataVo.setStype(order.getmService().getStype());
				myServiceDataVo.setServiceId(order.getmMetaService().getId());
				myServiceDataVo.setServiceName(order.getmMetaService().getName());
				myServiceDataVo.setType(order.getmMetaService().getType());
				// 赋值给返回值vo
				myServiceDataVo.setData(new CommonDataVO(1, 1, 1, allTitles,
						allValues));
			}else{
				myServiceDataVo.setServiceId(order.getmMetaService().getId());
				myServiceDataVo.setServiceName(order.getmMetaService().getName());
				myServiceDataVo.setType(order.getmMetaService().getType());
			}
				// 加入集合
			datas.add(myServiceDataVo);
			
		}
		return datas;
	}

	
	
	
	/**
	 * 获取我的服务采集数据
	 * MetaDataService.getMyServiceDatas()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param serviceIds
	 * @return
	 */
	public List<MyServiceDataVO> getMyServiceDatas(Map<Integer, MOrder> orders,
			DateParamVO dateCond, PageParamVO page) throws BusinessException {

		// 我的服务数据集合
		List<MyServiceDataVO> datas = new ArrayList<MyServiceDataVO>();
		
		// 遍历用户开通的所有专业服务然后获取每一个的采集数据
		for (Iterator<Entry<Integer, MOrder>> iter = orders.entrySet()
				.iterator(); iter.hasNext();) {

			// Entry
			Entry<Integer, MOrder> entry = iter.next();

			// 订单信息
			MOrder order = entry.getValue();
			
			
			// 获取设备信息 该处目前也考虑多个元服务多个元数据模块的情况
			MyServiceDataVO myServiceDataVo = new MyServiceDataVO();
			if(order.getmMetaService().getId()!=30){
				Set<MOrderDevice> orderDevices = order.getOrderDevices();

			// 根据元服务获取到的数据集合
				List<CommonDataVO> commonDatas = new ArrayList<CommonDataVO>();

			// 遍历订购设备信息列表
				for (Iterator<MOrderDevice> _iter = orderDevices.iterator(); _iter
						.hasNext();) {
	
					// 订购的设备信息
					MOrderDevice orderDevice = _iter.next();
	
					// 查询采集数据
					CommonDataVO data = getMetaDatas(orderDevice, dateCond, page);
	
					// 加入集合
					commonDatas.add(data);
				}
			// 专业服务数据title 和 结果 包含所有的元服务
				List<String> allTitles = new ArrayList<String>();
				List<List<Object>> allValues = new ArrayList<List<Object>>();
			
			// 将同一个专业服务下不同的元服务的数据合并到一个结果集中
			for (Iterator<CommonDataVO> _iter = commonDatas.iterator(); _iter
					.hasNext();) {

				// 某个元服务对应的数据结果
				CommonDataVO commonDataVo = _iter.next();

				// 将元服务对应的数据加入到
				if (commonDataVo.getTitles() != null) {
					allTitles.addAll(commonDataVo.getTitles());
				}

				if (commonDataVo.getValues() != null) {

					//
					List<Object> values = null;
					if (allValues.isEmpty()) {
						values = new ArrayList<Object>();
						allValues.add(values);
					} else {
						values = allValues.get(0);
					}
					// 合并结果集
					values.addAll(commonDataVo.getValues().get(0));
				}
				
			}

			// 构建返回值
				
				//myServiceDataVo.setStype(order.getmService().getStype());
				myServiceDataVo.setServiceId(order.getmMetaService().getId());
				myServiceDataVo.setServiceName(order.getmMetaService().getName());
				myServiceDataVo.setType(order.getmMetaService().getType());
				// 赋值给返回值vo
				myServiceDataVo.setData(new CommonDataVO(1, 1, 1, allTitles,
						allValues));
			}else{
				myServiceDataVo.setServiceId(order.getmMetaService().getId());
				myServiceDataVo.setServiceName(order.getmMetaService().getName());
				myServiceDataVo.setType(order.getmMetaService().getType());
			}
				// 加入集合
			datas.add(myServiceDataVo);
			
		}
		return datas;
	}
	
	/**
	 * 获取一个服务的数据
	 * @return
	 * @throws BusinessException 
	 */
	public MyServiceDataVO getMyserviceData(MOrder order,DateParamVO dateCond, PageParamVO page) throws BusinessException{
		// 获取设备信息 该处目前也考虑多个元服务多个元数据模块的情况
		Set<MOrderDevice> orderDevices = order.getOrderDevices();

		// 根据元服务获取到的数据集合
		List<CommonDataVO> commonDatas = new ArrayList<CommonDataVO>();

		// 遍历订购设备信息列表
		for (Iterator<MOrderDevice> _iter = orderDevices.iterator(); _iter
				.hasNext();) {

			// 订购的设备信息
			MOrderDevice orderDevice = _iter.next();

			// 查询采集数据
			CommonDataVO data = getMetaDatas(orderDevice, dateCond, page);

			// 加入集合
			commonDatas.add(data);
		}
		// 专业服务数据title 和 结果 包含所有的元服务
		List<String> allTitles = new ArrayList<String>();
		List<List<Object>> allValues = new ArrayList<List<Object>>();

		// 将同一个专业服务下不同的元服务的数据合并到一个结果集中
		for (Iterator<CommonDataVO> _iter = commonDatas.iterator(); _iter
				.hasNext();) {

			// 某个元服务对应的数据结果
			CommonDataVO commonDataVo = _iter.next();

			// 将元服务对应的数据加入到
			if (commonDataVo.getTitles() != null) {
				allTitles.addAll(commonDataVo.getTitles());
			}

			if (commonDataVo.getValues() != null) {
				allValues.addAll(commonDataVo.getValues());
			}
		}

		// 构建返回值
		MyServiceDataVO myServiceDataVo = new MyServiceDataVO();
		myServiceDataVo.setServiceId(order.getmMetaService().getId());
		Collections.reverse(allValues);
		// 赋值给返回值vo
		myServiceDataVo.setData(new CommonDataVO( page.getPage(),  page.getNum(), 1, allTitles,
				allValues));
		return myServiceDataVo;
	}
	/**
	 * 按天查询
	 * @param order
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws BusinessException
	 */
	public List<MyServiceDataVO> getMyserviceDataByDay(MOrder order,DateParamVO dateCond, PageParamVO page) throws BusinessException{
		List<MyServiceDataVO> datas = new ArrayList<MyServiceDataVO>();
		List<Date> dateSlice = DateUtil.getDateSlice(dateCond.getStart(),dateCond.getEnd());
		for(Date date:dateSlice){
			//按照每天进行查询
			DateParamVO dateparam = new DateParamVO(DateUtil.convertDate(date),DateUtil.addDays(DateUtil.convertDate(date), 1));
			MyServiceDataVO serviceData = this.getMyserviceData(order, dateparam, page);
			serviceData.setDate(date);
			datas.add(serviceData);
		}
		return datas;
	}

	/** 
	 * 手机端获取已订购的专业服务列表。
	 * <BR>
	 * 暂时只考虑一个元服务的专业服务，以后支持多个元服务时要考虑返回详情里的设备类型名称怎么定。
	 * </BR>
	 * @name MetaDataService.getMyOrderServiceList()
	 * @author zhoupeipei
	 * @Date 2014-10-22 下午9:59:34
	 * @param orders
	 * @return     
	 */
	public List<OrderServiceVO> getMyOrderServiceList(
			Map<Integer, MOrder> orders) {
		// 已开通服务列表
		List<OrderServiceVO> myServices = new ArrayList<OrderServiceVO>();

		for (Iterator<Entry<Integer, MOrder>> iter = orders.entrySet()
				.iterator(); iter.hasNext();) {

			// Entry
			Entry<Integer, MOrder> entry = iter.next();

			// 订单信息
			MOrder order = entry.getValue();

			// 构建返回值
			OrderServiceVO serviceVo = new OrderServiceVO();
			serviceVo.setServiceId(order.getmMetaService().getId());
			serviceVo.setStartTime(order.getStartTime());
			serviceVo.setEndTime(order.getEndTime());

			// 获取设备信息 该处目前也考虑多个元服务多个元数据模块的情况
			Set<MOrderDevice> orderDevices = order.getOrderDevices();

			// 遍历订购设备信息列表
			for (Iterator<MOrderDevice> odIter = orderDevices.iterator(); odIter.hasNext(); ) {

				// TODO：目前对于一个专业服务下包含两个或以上个元服务的情况暂不支持
				// if(i > 0) {
				// break;
				// }

				// 订购的设备信息
				MOrderDevice orderDevice = odIter.next();
				String orderDeviceTypeName = serviceVo.getDeviceTypeName() == null? "" : serviceVo.getDeviceTypeName() + "," ;
				if(orderDeviceTypeName.contains(orderDevice.getDeviceName())){
					continue;
				}else{
					serviceVo.setDeviceTypeName(orderDeviceTypeName + orderDevice.getDeviceTypeName() );
				}

			}
			// 加入集合
			myServices.add(serviceVo);
		}
		return myServices;
	}

	/**
	 * 获取指定专业服务的数据采集信息
	 * MetaDataService.getMetaDatas()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param serviceId
	 * @param deviceBindId
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws BusinessException
	 */
	public CommonDataVO getMetaDatas(MOrderDevice orderDevice,
			DateParamVO dateCond, PageParamVO page) throws BusinessException {

		// 获取指定专业服务下的元服务信息
		DataModuleVO dataModuleVo = this.metaService.getDataModule(orderDevice
				.getMetaServiceId());

		// 数据处理的service
		AbstractDataService<? extends MetaData> dataService = getDataService(dataModuleVo
				.getTableName());

		// 获取数据并返回
		return getMetaDatas(dataService, dataModuleVo,
				orderDevice.getDeviceBindId(), dateCond.getStart(),
				dateCond.getEnd(), page.getPage(), page.getNum());
	}

	/**
	 * 获取带有上传时间的数据采集信息，无论是否显示
	 * @author L
	 * @param orderDevice
	 * @param dateCond
	 * @param page
	 * @return
	 * @throws BusinessException
	 */
	public CommonDataVO getMetaDatasWithUpLoadTime(MOrderDevice orderDevice,
			DateParamVO dateCond, PageParamVO page) throws BusinessException {

		// 获取指定专业服务下的元服务信息
		DataModuleVO dataModuleVo = this.metaService.getDataModule(orderDevice
				.getMetaServiceId());
		// 设置显示上传时间
		for (DataModuleItemVO moduleItem : dataModuleVo.getItems()) {
			if (ProfessionalConstants.ALARM_EXCLUDE_ITEM_NAME[0]
					.equals(moduleItem.getName())) {
				moduleItem.setIsShow(ProfessionalConstants.AVAILABLE);
			}
		};
		// 数据处理的service
		AbstractDataService<? extends MetaData> dataService = getDataService(dataModuleVo
				.getTableName());

		// 获取数据并返回
		return getMetaDatas(dataService, dataModuleVo,
				orderDevice.getDeviceBindId(), dateCond.getStart(),
				dateCond.getEnd(), page.getPage(), page.getNum());
	}
	/**
	 * 报告中获取元服务的报表数据
	 * @author dx
	 * @param service
	 * @param dataModule
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @return JSONObject
	 * @throws BusinessException
	 */
	public  @ResponseBody JSONObject getMetaDataTime(MOrderDevice orderDevice,
			DateParamVO dateCond) throws BusinessException {
		
		// 获取指定专业服务下的元服务信息
		DataModuleVO dataModuleVo = this.metaService.getDataModule(orderDevice
				.getMetaServiceId());
		// 设置显示上传时间
		for (DataModuleItemVO moduleItem : dataModuleVo.getItems()) {
			if (ProfessionalConstants.ALARM_EXCLUDE_ITEM_NAME[0]
					.equals(moduleItem.getName())) {
				moduleItem.setIsShow(ProfessionalConstants.AVAILABLE);
			}
		};
		
		// 数据处理的service
		AbstractDataService<? extends MetaData> dataService = getDataService(dataModuleVo
				.getTableName());
		
		// 获取数据并返回
		return getMeta(dataService, dataModuleVo,
				orderDevice.getDeviceBindId(), dateCond.getStart(),
				dateCond.getEnd());
	}
	private @ResponseBody JSONObject getMeta(
			AbstractDataService<? extends MetaData> service,
			DataModuleVO dataModule, String deviceBindId, Date start, Date end
			) throws BusinessException {

		// 查询结果集
		//Page<? extends MetaData> _page = service.query(deviceBindId, start,end);
		List<? extends MetaData> metaData=service.querySel(deviceBindId, start,end);
		// 报表标题 -- 中文 用于显示报表的标题
		List<String> titles_cn = new ArrayList<String>();
		JSONObject titles_obj=new JSONObject();
		titles_obj.put("titles_cn", titles_cn);
		// 报表数据项名称
		List<String> itemNames = new ArrayList<String>();
		
		// 获取数据项
		List<DataModuleItemVO> dataItems = dataModule.getItems();

		// 获取需要展示的报表项目
		for (Iterator<DataModuleItemVO> iter = dataItems.iterator(); iter
				.hasNext();) {

			// 数据项
			DataModuleItemVO item = iter.next();

			// 如果字段需要显示则加入到展示项目列表中
			if (item.getIsShow()) {
				titles_cn.add(item.getDesc());
				itemNames.add(item.getName());
			}
		}
		// 报表的数据项目集合(行记录集合)
		List<List<Object>> reportDatas = new ArrayList<List<Object>>();
		
		// 遍历从数据库中获取到的结果集根据报表展示项设备进行数据装载
		for (Iterator<? extends MetaData> iter = metaData.iterator(); iter
				.hasNext();) {

			// DB中的一条数据
			Object obj = iter.next();

			// 该行记录的集合
			List<Object> _values = new ArrayList<Object>();

			// 根据报表的展示项逐一获取每一项的数值
			for (String itemName : itemNames) {

				// 属性值
				Object _value = null;

				// 通过该属性的get方法获取值
				Method method = null;
				try {
					method = service.getEntityClass().getDeclaredMethod(
							getMethodName(itemName));
				} catch (Exception e) {
					// e.printStackTrace();
				}

				// 从父类中获取改方法
				if (method == null) {
					try {
						method = service.getEntityClass().getSuperclass()
								.getDeclaredMethod(getMethodName(itemName));
						
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
				// 从父类中获取改方法
				if (method == null) {
					try {
						method = service.getEntityClass().getSuperclass().getSuperclass()
								.getDeclaredMethod(getMethodName(itemName));
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}

				// 取值
				if (method != null) {
					try {
						_value = method.invoke(obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 加入到
				_values.add(_value == null ? 0 : _value);
			}

			// 一条报表记录
			reportDatas.add(_values);
		}
		JSONArray arry=new JSONArray();
		for(int i=0;i<reportDatas.size();i++){
			JSONObject reportDatas_json=new JSONObject();
			reportDatas_json.put("num", reportDatas.get(i));
			arry.add(i, reportDatas_json);
		}
		JSONObject json_servicesSet=new JSONObject();
		json_servicesSet.put("module", dataModule.getName());
		json_servicesSet.put("arry", arry);
		json_servicesSet.put("titles_obj",titles_obj);
		
		return json_servicesSet;
	}
	/**
	 * 根据日期获取警报信息
	 * MetaDataService.getMetaDatas()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<MetaData> getMetaDatas(String tableName, String itemName,
			String deviceBindId, Date start, Date end) throws BusinessException {

		// 获取数据业务逻辑处理对象
		AbstractDataService<? extends MetaData> metaDataService = getDataService(tableName);

		// 根据日期获取数据
		return (List<MetaData>) metaDataService.query(deviceBindId, itemName,
				start, end);
	}

	/**
	 * 获取警报信息的服务分类
	 * MetaDataService.getServiceVos()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public List<ServiceVO> getServiceVos(Long userId) throws BusinessException {
		List<ServiceVO> vos = new ArrayList<ServiceVO>();
		Map<Integer, MOrder> userOrders = specService
				.getUserOrdersAndHandleExpire(userId,
						ProfessionalConstants.ORDER_STATUS_OPENED);
		for (Iterator<MOrder> iter = userOrders.values().iterator(); iter
				.hasNext();) {
			MOrder order = iter.next();
			ServiceVO vo = new ServiceVO();
			vo.setId(order.getmMetaService().getId());
			vos.add(vo);
		}
		return vos;
	}

	/**
	 * 获取警报数据信息
	 * MetaDataService.getAlarms()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @param serviceId
	 * @param status  -1获取全部状态警报
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAlarm> getAlarms(Long userIds, String userName,
			Integer serviceId, Short status, DateParamVO dateCond,
			PageParamVO pageCond) throws BusinessException {

		// 总数
		/*long totalCount = alarmDao.getAlarmsCount(userIds, userName, serviceId,
				status, dateCond.getStart(), dateCond.getEnd());
*/
		// 获取警报信息
		List<MAlarm> alarms = alarmDao.getAlarms(userIds, userName, serviceId,
				status, dateCond.getStart(), dateCond.getEnd(),
				pageCond.getPage(), pageCond.getNum());

		Page<MAlarm> page = new Page<MAlarm>();
		page.setPageNo(pageCond.getPage());
		page.setPageSize(pageCond.getNum());
		page.setResult(alarms);
	//	page.setTotalCount((int) totalCount);

		return page;
	}
	/**
	 * @author DX 2016/5/27
	 * @param venderId
	 * @param serviceId
	 * @param status
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAlarm> getAlarms(List<Integer> venderIds,Integer serviceId, Short status, DateParamVO dateCond,
			PageParamVO pageCond) throws BusinessException {
		long totalCount = alarmDao.getAlarmsCount(venderIds,serviceId,
				status, dateCond.getStart(), dateCond.getEnd());
		// 获取警报信息
		List<MAlarm> alarms = alarmDao.getAlarms(venderIds,serviceId,
				status, dateCond.getStart(), dateCond.getEnd(),
				pageCond.getPage(), pageCond.getNum());
		
		Page<MAlarm> page = new Page<MAlarm>();
		page.setPageNo(pageCond.getPage());
		page.setPageSize(pageCond.getNum());
		page.setResult(alarms);
		page.setTotalCount((int) totalCount);
		return page;
	}

	/**
	 * 获取警报数据信息
	 * MetaDataService.getAlarms()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-21 </P>
	 * @param userIds
	 * @param serviceId
	 * @param status
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	// public List<MAlarm> getAlarms(List<Long> userIds, Integer serviceId,
	// Short status, DateParamVO dateCond, PageParamVO pageCond) throws
	// BusinessException {
	// return alarmDao.getAlarms(userIds, serviceId, status,
	// dateCond.getStart(), dateCond.getEnd(), pageCond.getPage(),
	// pageCond.getNum());
	// return new ArrayList<MAlarm>();
	// }

	/**
	 * 获取元服务的报表数据
	 * MetaDataService.getMetaDatas()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param service
	 * @param dataModule
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 * @throws BusinessException
	 */
	private CommonDataVO getMetaDatas(
			AbstractDataService<? extends MetaData> service,
			DataModuleVO dataModule, String deviceBindId, Date start, Date end,
			int page, int num) throws BusinessException {

		// 查询结果集
		Page<? extends MetaData> _page = service.query(deviceBindId, start,
				end, page, num);

		// 如果没有检索到记录直接返回空
		if (_page.getTotalCount() == 0 || _page.getResult() == null) {
			return new CommonDataVO(page, num);
		}

		// 报表标题 -- 中文 用于显示报表的标题
		List<String> titles_cn = new ArrayList<String>();

		// 报表数据项名称
		List<String> itemNames = new ArrayList<String>();

		// 获取数据项
		List<DataModuleItemVO> dataItems = dataModule.getItems();

		// 获取需要展示的报表项目
		for (Iterator<DataModuleItemVO> iter = dataItems.iterator(); iter
				.hasNext();) {
			///////----------------------------
			// 数据项
			DataModuleItemVO item = iter.next();
			if (ProfessionalConstants.ALARM_EXCLUDE_ITEM_NAME[0]
					.equals(item.getName())) {
				item.setIsShow(ProfessionalConstants.AVAILABLE);
			}
			// 如果字段需要显示则加入到展示项目列表中
			if (item.getIsShow()) {
				titles_cn.add(item.getDesc());
				itemNames.add(item.getName());
			}
		}

		// 从数据库获取到的结果集合
		List<? extends MetaData> _datas = _page.getResult();

		// 报表的数据项目集合(行记录集合)
		List<List<Object>> reportDatas = new ArrayList<List<Object>>();

		// 遍历从数据库中获取到的结果集根据报表展示项设备进行数据装载
		for (Iterator<? extends MetaData> iter = _datas.iterator(); iter
				.hasNext();) {

			// DB中的一条数据
			Object obj = iter.next();

			// 该行记录的集合
			List<Object> _values = new ArrayList<Object>();

			// 根据报表的展示项逐一获取每一项的数值
			for (String itemName : itemNames) {

				// 属性值
				Object _value = null;

				// 通过该属性的get方法获取值
				Method method = null;
				try {
					method = service.getEntityClass().getDeclaredMethod(
							getMethodName(itemName));
				} catch (Exception e) {
					// e.printStackTrace();
				}

				// 从父类中获取改方法
				if (method == null) {
					try {
						method = service.getEntityClass().getSuperclass()
								.getDeclaredMethod(getMethodName(itemName));
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
				// 从父类中获取改方法
				if (method == null) {
					try {
						method = service.getEntityClass().getSuperclass().getSuperclass()
								.getDeclaredMethod(getMethodName(itemName));
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}

				// 取值
				if (method != null) {
					try {
						_value = method.invoke(obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				// 加入到
				_values.add(_value == null ? 0 : _value);
			}

			// 一条报表记录
			reportDatas.add(_values);
		}

		// 分页后的数据集
		return new CommonDataVO(page, num, _page.getTotalCount(),
				dataModule.getName(), titles_cn, reportDatas);
	}

	/**
	 * 获取处理指定数据模块数据的service
	 * @param tableName
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public AbstractDataService<? extends MetaData> getDataService(
			String tableName) throws BusinessException {

		// 获取元服务的配置信息
		MetaConfigVO metaConfigVo = metaConfiguration.getConfig(tableName);
		if (metaConfigVo == null) {
			throw new BusinessException(
					ExceptionCode.META_DATA_CONFIG_NOT_FOUND);
		}

		// 加载处理报表数据的service类
		Class<?> clazz = null;
		try {
			clazz = Class.forName(metaConfigVo.getClassFullQuanlifiedName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new BusinessException(
					ExceptionCode.META_DATA_CONFIG_NOT_FOUND);
		}
		SpringContextHolder.getBean(metaConfigVo.getBeanName(), clazz);
		// 从spring容器中获取已初始化的service类
		return (AbstractDataService<? extends MetaData>) SpringContextHolder
				.getBean(metaConfigVo.getBeanName(), clazz);
	}

	/**
	 * 获取指定属性的get方法名称
	 * MetaDataService.getMethodName()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param name
	 * @return
	 */
	private String getMethodName(String name) {
		return "get" + convStr(name);
	}

	/**
	 * 首字母大写 
	 * MetaDataService.convStr()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param oldStr
	 * @return
	 */
	private String convStr(String oldStr) {
		return oldStr.substring(0, 1).toUpperCase() + oldStr.substring(1);
	}

	/** 
	 * 处理警报
	 * @name MetaDataService.dealWithAlarm()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午6:05:26
	 * @param id
	 * @param name
	 * @param sugestion     
	 */
	public MAlarm dealWithAlarm(String id, String name, String suggestion)
			throws BusinessException {
		MAlarm mAlarm = alarmDao.getAlarm(id);
		if (mAlarm == null) {
			return null;
		}
		mAlarm.setSuggestion(suggestion);
		mAlarm.setCreatedBy(name);
		mAlarm.setResponseTime(new Date());
		mAlarm.setStatus(ProfessionalConstants.ALARM_STATUS_SOLVED);
		alarmDao.update(mAlarm);
		// mAlarm = alarmDao.getAlarm(id);
		return mAlarm;
	}
	public void saveWithAlarm(MAlarm mAlarm){
		alarmDao.save(mAlarm);
		
	}
	@Autowired 
	private AlarmThresholdDao alarmThresholdDao;
	@Autowired 
	private MDataModuleItemDao mDataModuleItemDao;
	/**
	 * 保存页面输入专业服务信息
	 * @author L
	 * @param inputVo
	 * @param serviceId
	 * @param userId
	 * @throws BusinessException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public void saveInputData(InputInfoVO inputVo, Long userId) throws BusinessException, InstantiationException, IllegalAccessException{
		/*//获取设备信息
		
		//获取警报信息根据userId
		inputVo.getDataModules().get(0).getMetaServiceId();
		Map<String, Float> map=new HashMap<String, Float>();
		//遍历页面取到的值
		for(DataModuleVO v:inputVo.getDataModules()){
			//获取页面输入的值及对应的属性名
			for(DataModuleItemVO d:v.getItems()){
				if(d.getName().equals("uploadTime")){}else{
					map.put(d.getName(),Float.parseFloat(d.getInputParam()));
				}
			}
			//判断警报信息是否为空
			if(alarmThresholdDao.getByUserAndServiceId(userId,v.getMetaServiceId())!=null){
				//获取用户警报阀值
				MAlarmThreshold  m=alarmThresholdDao.getByUserAndServiceId(userId,v.getMetaServiceId());
				//根据元服务Id获取元服务 
				MMetaService mese=metaService.getMMetaServices(m.getMetaServiceId());
				//根据item_name获取item_desc+"上限"or"下限"
				MDataModuleItem  mDataModuleItem=mDataModuleItemDao.getByNameAndMName(m.getItemName());
				//将页面取到的值同警报上限下限比较
				if(m.getAlarmLower()>map.get(m.getItemName())){
					MAlarm ms= new MAlarm();
					ms.setUserId(userId);
					ms.setUserName(r.getName());
					if(r.getMobilePhone()!=null){
						ms.setContect(r.getMobilePhone());
					}
					ms.setVenderId(39);
					ms.setVenderName(mVender.getName());
					ms.setContent(map.get(m.getItemName()).toString());
					ms.setDataItemName(m.getItemName());
					ms.setDateItemDesc(mDataModuleItem.getItemDesc()+"上限");
					ms.setAlarmValue(m.getAlarmLower());
					ms.setServiceId(v.getMetaServiceId());
					ms.setServiceName(mese.getName());
					ms.setAlarmTime(new Date());
					ms.setStatus((short) 1);
					saveWithAlarm(ms);
				}
				if(m.getAlarmUpper()<map.get(m.getItemName())){
					MAlarm ms= new MAlarm();
					ms.setUserId(userId);
					if(r.getMobilePhone()!=null){
						ms.setContect(r.getMobilePhone());
					}
					ms.setUserName(r.getName());
					ms.setVenderId(39);
					ms.setVenderName(mVender.getName());
					ms.setContent(map.get(m.getItemName()).toString());
					ms.setDataItemName(m.getItemName());
					ms.setDateItemDesc(mDataModuleItem.getItemDesc()+"上限");
					ms.setAlarmValue(m.getAlarmUpper());
					ms.setServiceId(v.getMetaServiceId());
					ms.setServiceName(mese.getName());
					ms.setAlarmTime(new Date());
					ms.setStatus((short) 0);
					saveWithAlarm(ms);
				}
			}
		}*/
		List<MOrder> order = specService.getOrderByUSID(userId);
		Set<MOrderDevice> devices = new HashSet<MOrderDevice>();
		if(order!=null){
			for(MOrder m:order){
				devices.addAll(m.getOrderDevices());
			}
		}
		//保存原服务录入信息
		List<DataModuleVO> dataModules=new ArrayList<DataModuleVO>();
		metaData:
		for(DataModuleVO item:inputVo.getDataModules()){
			if(item.getTableName()==null){
				continue;
			}
			AbstractDataService<? extends MetaData> dataService = getDataService(item.getTableName());
			Class<? extends MetaData> clazz = dataService.getEntityClass();
			MetaData entity = clazz.newInstance();
			//设置deviceId属性
			if(devices!=null){
				for(MOrderDevice device:devices){
					if(device.getDeviceName()==null||"智能床垫".equals(device.getDeviceName())||"智能安全床垫（台湾）".equals(device.getDeviceName())||"脑电波检测仪".equals(device.getDeviceName())){
						continue;
					}
					if(device.getMetaServiceId()==item.getMetaServiceId()){
						Method _method=null;
						try {
							_method = clazz.getMethod("setDeviceId", String.class);
							_method.invoke(entity, device.getDeviceBindId());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
					}
				}
			}
			for(DataModuleItemVO moduleItem:item.getItems()){
				if(moduleItem.getName()==null||moduleItem.getName()==""){
					continue;
				}
				//如果有空信息不保存
				if(moduleItem.getInputParam()==null||"".equals(moduleItem.getInputParam()))
					continue metaData;
				//设置属性信息
				dataModules.add(item);
				Field field = null;
				
				try {
					field = clazz.getDeclaredField(moduleItem.getName());
				} catch (NoSuchFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(field==null){
					
					try {
						field = clazz.getSuperclass().getDeclaredField(moduleItem.getName());
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				field.setAccessible(true);
				Object inputValue = null;
				try {
					inputValue = StringConvertUtil.convert(field.getType(), moduleItem.getInputParam());
				} catch (Exception e) {
					System.out.println(moduleItem.getInputParam());
				}
				field.set(entity, inputValue);
			}
			dataService.save(entity);	
		}
	}
//****************************************调用InputInfoVO读入上传的数据******************************************************
	//
	public void Alarmthreshold(InputInfoVO inputVo, Long userId,MVender mVender,RUser r) throws BusinessException, InstantiationException, IllegalAccessException{
		//获取设备信息
		
		//获取警报信息根据userId
		inputVo.getDataModules().get(0).getMetaServiceId();
		Map<String, Float> map=new HashMap<String, Float>();
		//遍历页面取到的值
		for(DataModuleVO v:inputVo.getDataModules()){
			//获取页面输入的值及对应的属性名
			if(v.getItems()==null){
				continue;
			}
			for(DataModuleItemVO d:v.getItems()){
				if(d.getName().equals("uploadTime")){}else{
					map.put(d.getName(),Float.parseFloat(d.getInputParam()));
				}
			}
			//判断警报信息是否为空
			if(alarmThresholdDao.getByUserAndServiceId(userId,v.getMetaServiceId())!=null){
				//获取用户警报阀值
				MAlarmThreshold  m=alarmThresholdDao.getByUserAndServiceId(userId,v.getMetaServiceId());
				//根据元服务Id获取元服务 
				MMetaService mese=metaService.getMMetaServices(m.getMetaServiceId());
				//根据item_name获取item_desc+"上限"or"下限"
				MDataModuleItem  mDataModuleItem=mDataModuleItemDao.getByNameAndMName(m.getItemName());
				//将页面取到的值同警报上限下限比较
				if(m.getAlarmLower()>map.get(m.getItemName())){
					MAlarm ms= new MAlarm();
					ms.setUserId(userId);
					ms.setUserName(r.getName());
					if(r.getMobilePhone()!=null){
						ms.setContect(r.getMobilePhone());
					}
					ms.setVenderId(39);
					ms.setVenderName(mVender.getName());
					ms.setContent(map.get(m.getItemName()).toString());
					ms.setDataItemName(m.getItemName());
					ms.setDateItemDesc(mDataModuleItem.getItemDesc()+"上限");
					ms.setAlarmValue(m.getAlarmLower());
					ms.setServiceId(v.getMetaServiceId());
					ms.setServiceName(mese.getName());
					ms.setAlarmTime(new Date());
					ms.setStatus((short) 1);
					saveWithAlarm(ms);
				}
				if(m.getAlarmUpper()<map.get(m.getItemName())){
					MAlarm ms= new MAlarm();
					ms.setUserId(userId);
					if(r.getMobilePhone()!=null){
						ms.setContect(r.getMobilePhone());
					}
					ms.setUserName(r.getName());
					ms.setVenderId(39);
					ms.setVenderName(mVender.getName());
					ms.setContent(map.get(m.getItemName()).toString());
					ms.setDataItemName(m.getItemName());
					ms.setDateItemDesc(mDataModuleItem.getItemDesc()+"上限");
					ms.setAlarmValue(m.getAlarmUpper());
					ms.setServiceId(v.getMetaServiceId());
					ms.setServiceName(mese.getName());
					ms.setAlarmTime(new Date());
					ms.setStatus((short) 0);
					saveWithAlarm(ms);
				}
			}
		}
	}
}
