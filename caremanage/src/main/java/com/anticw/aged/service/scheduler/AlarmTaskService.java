package com.anticw.aged.service.scheduler;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAlarmThreshold;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.mongo.MAlarmExecuteTime;
import com.anticw.aged.bean.mongo.MetaData;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.data.AlarmDao;
import com.anticw.aged.dao.data.AlarmExecuteTimeDao;
import com.anticw.aged.dao.professional.vender.AlarmThresholdDao;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.professional.MetaService;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.service.professional.data.base.AbstractDataService;
import com.anticw.aged.service.professional.data.server.MetaDataService;
import com.anticw.aged.vo.professional.meta.DataModuleItemVO;
import com.anticw.aged.vo.professional.meta.MetaVO;
import com.anticw.aged.vo.professional.service.ServiceVO;

/**
 * 报警服务类
 * <P>File name : AlarmService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-13 </P>
 */
@Service
public class AlarmTaskService {
	
	/**
	 * 报警文字描述
	 */
	private static String ALARM_LOWER_DESC = "下限";
	
	/**
	 * 报警文字描述
	 */
	private static String ALARM_UPPER_DESC = "上限";

	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	private SpecService specService;
	
	/**
	 * 元服务业务逻辑处理类
	 */
	@Autowired
	private MetaService metaService;

	/**
	 * 警报数据持久层对象
	 */
	@Autowired
	private AlarmDao alarmDao;
	
	/**
	 * 警报任务执行时间持久层对象
	 */
	@Autowired
	private AlarmExecuteTimeDao alarmExecuteTimeDao;
	
	/**
	 * 警报阈值持久层类
	 */
	@Autowired
	private AlarmThresholdDao alarmThresholdDao;
	
	/**
	 * 专业服务数据业务逻辑处理类
	 */
	@Autowired
	private MetaDataService metaDataService;
	
//	//setters
//	public void setSpecService(SpecService specService) {
//		this.specService = specService;
//	}
//
//	public void setMetaService(MetaService metaService) {
//		this.metaService = metaService;
//	}
//
//	public void setAlarmDao(AlarmDao alarmDao) {
//		this.alarmDao = alarmDao;
//	}
//
//	public void setAlarmThresholdDao(AlarmThresholdDao alarmThresholdDao) {
//		this.alarmThresholdDao = alarmThresholdDao;
//	}
//
//	public void setMetaDataService(MetaDataService metaDataService) {
//		this.metaDataService = metaDataService;
//	}
//
//	public void setAlarmExecuteTimeDao(AlarmExecuteTimeDao alarmExecuteTimeDao) {
//		this.alarmExecuteTimeDao = alarmExecuteTimeDao;
//	}
//	
//	@Override
//	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//		try {
//			alarmCatchTask();
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
//	}
	
	/*
	 根据老人信息遍历整个数据表结构 
	 然后将老人的信息和报警信息进行整合
	 增加定时任务将数据通过定时的方式倒入到正表中 
	 */
	public void alarmCatchTask() throws BusinessException {	
		
		//开始和结束时间
		Date start = new Date();
		Date end = new Date();
		
		//获取上次任务执行时间
		MAlarmExecuteTime lastExecuteTime = alarmExecuteTimeDao.get();
		if(lastExecuteTime == null) {
			lastExecuteTime = alarmExecuteTimeDao.firstInitAlarmExecuteTime();
		}
		start = lastExecuteTime.getLastExecuteTime();
			
		//获取全部订单
		List<MOrder> orders = specService.getAllOrderByStatus(ProfessionalConstants.ORDER_STATUS_OPENED);
		
		//遍历用户订单列表、根据用户的订单信息，来判断该服务下的数据是否超出了警报阈值的设置
		for(Iterator<MOrder> iter = orders.iterator(); iter.hasNext();) {
			
			//订单信息
			MOrder order = iter.next();
			
			//根据订单进行报警处理
			try{
				alarmByOrder(order, start, end);
			}catch(BusinessException e) {
				e.printStackTrace();
				continue;
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		
		//更新上次定时任务的执行时间
		MAlarmExecuteTime alarmExecuteTime = new MAlarmExecuteTime();
		alarmExecuteTime.setLastExecuteTime(end);
		alarmExecuteTimeDao.update(lastExecuteTime, alarmExecuteTime);
	}
	
	/**
	 * 报警
	 * @param order
	 * @throws BusinessException
	 */
	private void alarmByOrder(MOrder order, Date start, Date end) throws BusinessException {
		
		//获取订单对应的服务信息
		ServiceVO service = specService.get(order.getmMetaService().getId());
		
		//获取元服务id集合
		List<Integer> metaServiceIds = service.getMetaIds();
		
		//遍历元服务Id集合根据元服务处理警报信息
		for(Iterator<Integer> iter = metaServiceIds.iterator(); iter.hasNext();) {
			
			//元服务Id
			Integer metaServiceId = iter.next();
			
			//获取元服务信息
			MetaVO metaVo = metaService.get(metaServiceId);
			
			//设备绑定Id
			String orderDeviceId = null;
			
			//设备绑定集合
			Set<MOrderDevice> orderDevices = order.getOrderDevices();
			for(Iterator<MOrderDevice> _iter = orderDevices.iterator(); _iter.hasNext();) {
				MOrderDevice orderDevice = _iter.next();
				if(orderDevice.getMetaServiceId().compareTo(metaServiceId) == 0) {
					orderDeviceId = orderDevice.getDeviceBindId();
				}
			}
			
			//根据元服务处理警报信息
			alarmByMetaService(order, orderDeviceId, service, metaVo, start, end);
		}	
	}
	
	/**
	 * 报警
	 * @param order
	 * @param orderDeviceId
	 * @param service
	 * @param meta
	 * @throws BusinessException
	 */
	private void alarmByMetaService(MOrder order, String orderDeviceId, ServiceVO service, MetaVO meta, Date start, Date end) throws BusinessException {
		
		//itemName 和 itemDesc映射便于之后的vo赋值
		Map<String, String> itemDescMap = new HashMap<String, String>();
		for(Iterator<DataModuleItemVO> iter = meta.getDataModule().getItems().iterator(); iter.hasNext();) {
			DataModuleItemVO vo = iter.next();
			itemDescMap.put(vo.getName(), vo.getDesc());
		}
		
		//获取指定用户指定元服务的警报阈值设置
		List<MAlarmThreshold> alarmThresholds = this.alarmThresholdDao.getByUserAndMeta(order.getUserId(), meta.getId());
		
		//获取数据业务逻辑处理对象
		AbstractDataService<? extends MetaData> metaDataService = this.metaDataService.getDataService(meta.getDataModule().getTableName());
		
		//遍历警报阈值开始处理报警信息
		for(Iterator<MAlarmThreshold> iter = alarmThresholds.iterator(); iter.hasNext();) {
			
			//警报
			MAlarmThreshold alarmThreshold = iter.next();
			
			//不报警不需要继续
			if(alarmThreshold == null || !alarmThreshold.getIsAlarm()) {
				continue;
			}
			
			//警报值和数据上传时间
			Float value = 0f;
			Date uploadTime = null;
			
			//从数据库中查询该段时间内该数据的最大值
			List<MetaData> metaDatas = this.metaDataService.getMetaDatas(meta.getDataModule().getTableName(), alarmThreshold.getItemName(), alarmThreshold.getDeviceBindId(), start, end);
			if(metaDatas == null || metaDatas.isEmpty()) {
				continue;
			}
			
			//根据警报阈值项的设定逐一初始化数据
			for(Iterator<MetaData> _iter = metaDatas.iterator(); _iter.hasNext();) {
				
				MetaData metaData = _iter.next();
				
				//属性值
				Object _value = null;
				
				//通过该属性的get方法获取值
				try {
					Method method = metaDataService.getEntityClass().getDeclaredMethod(getMethodName(alarmThreshold.getItemName()));
					_value = method.invoke(metaData);
					value = (Float)_value;
					
					Method _method = metaDataService.getEntityClass().getSuperclass().getDeclaredMethod(getMethodName("uploadTime"));
					uploadTime = (Date)_method.invoke(metaData);
				
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				//检测是否达到报警标准
				if(value.intValue() < alarmThreshold.getAlarmLower().intValue() || value.intValue() > alarmThreshold.getAlarmUpper().intValue()) {
					
					//下限&上限
					String content = "";
					if(value.intValue() < alarmThreshold.getAlarmLower().intValue()) {
						content = ALARM_LOWER_DESC;
					}
					if(value.intValue() > alarmThreshold.getAlarmUpper().intValue()) {
						content = ALARM_UPPER_DESC;
					}
					
					//警报数据
					//MAlarm curAlarm = this.alarmDao.getAlarm(order.getUserId(), order.getServiceId(), alarmThreshold.getItemName());
					MAlarm curAlarm = null;
					
					//if(curAlarm == null || curAlarm.getStatus() == ProfessionalConstants.ALARM_STATUS_SOLVED) {//如果还不存在报警记录直接存储
						curAlarm = new MAlarm();
						curAlarm.setUserId(order.getUserId());
						curAlarm.setUserName(order.getUserName());
						curAlarm.setContect("");
						curAlarm.setContent(value.toString());
						curAlarm.setDataItemName(alarmThreshold.getItemName());
						curAlarm.setDateItemDesc(itemDescMap.get(alarmThreshold.getItemName()) + content);
						curAlarm.setAlarmValue(value);
						curAlarm.setServiceId(order.getmMetaService().getId());
						curAlarm.setAlarmTime(uploadTime);
						//curAlarm.setResponseTime();
						curAlarm.setStatus(ProfessionalConstants.ALARM_STATUS_UNSOLVED);
						curAlarm.setCreatedBy("");
						this.alarmDao.save(curAlarm);
						
					/*}else{
						
						if(curAlarm.getDateItemDesc().contains(ALARM_LOWER_DESC)) {
							if(curAlarm.getAlarmValue().intValue() > value) {
								MAlarm nAlarm = new MAlarm();
								nAlarm.setUserId(curAlarm.getUserId());
								nAlarm.setUserName(curAlarm.getUserName());
								nAlarm.setContect(curAlarm.getContect());
								nAlarm.setVenderId(curAlarm.getVenderId());
								nAlarm.setVenderName(curAlarm.getVenderName());
								nAlarm.setContent(curAlarm.getContent());
								nAlarm.setDataItemName(curAlarm.getDataItemName());
								nAlarm.setDateItemDesc(curAlarm.getDateItemDesc());
								nAlarm.setAlarmValue(value);
								nAlarm.setServiceId(curAlarm.getServiceId());
								nAlarm.setServiceName(curAlarm.getServiceName());
								nAlarm.setAlarmTime(uploadTime);
								//nAlarm.setResponseTime();
								nAlarm.setStatus(ProfessionalConstants.ALARM_STATUS_UNSOLVED);
								nAlarm.setCreatedBy("");
								this.alarmDao.update(curAlarm, nAlarm);
							}
						}else if(curAlarm.getDateItemDesc().contains(ALARM_UPPER_DESC)) {
							if(curAlarm.getAlarmValue().intValue() < value) {
								MAlarm nAlarm = new MAlarm();
								nAlarm.setUserId(curAlarm.getUserId());
								nAlarm.setUserName(curAlarm.getUserName());
								nAlarm.setContect(curAlarm.getContect());
								nAlarm.setVenderId(curAlarm.getVenderId());
								nAlarm.setVenderName(curAlarm.getVenderName());
								nAlarm.setContent(curAlarm.getContent());
								nAlarm.setDataItemName(curAlarm.getDataItemName());
								nAlarm.setDateItemDesc(curAlarm.getDateItemDesc());
								nAlarm.setAlarmValue(value);
								nAlarm.setServiceId(curAlarm.getServiceId());
								nAlarm.setServiceName(curAlarm.getServiceName());
								nAlarm.setAlarmTime(uploadTime);
								//nAlarm.setResponseTime();
								nAlarm.setStatus(ProfessionalConstants.ALARM_STATUS_UNSOLVED);
								nAlarm.setCreatedBy("");
								this.alarmDao.update(curAlarm, nAlarm);
							}
						}*/
					//}
				}
			}
		}
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
}
