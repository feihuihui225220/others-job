package com.anticw.aged.service.professional.data.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MDataModuleItem;
import com.anticw.aged.bean.mongo.Pressure;
import com.anticw.aged.dao.data.MPressureDao;
import com.anticw.aged.dao.data.ZProductNormDao;
import com.anticw.aged.dao.professional.mdatamodule.MDataModuleItemDao;
import com.anticw.aged.dao.professional.service.AlarmthresholdDao;
import com.anticw.aged.dao.professional.service.OrderDao;

/**
 * 血压管理服务数据获取服务类
 * <P>File name : PressureService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Service
public class PressureService extends AbstractDataService<Pressure> {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private MPressureDao mPressureDao;
	@Autowired
	private AlarmthresholdDao alarmthresholdDao;
	@Autowired
	private ZProductNormDao zProductNormDao;
	
	@Autowired
	private MDataModuleItemDao mDataModuleItemDao; 
	
	/**
	 * 重写获取class方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getEntityClass()
	 */
	public Class<Pressure> getEntityClass() {
		return Pressure.class;
	}

	/**
	 * 重写获取表名方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-12 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getCollectionName()
	 */
	protected String getCollectionName() {
		return Constants.COLLECTION_PRESSURE;
	}
	
	/**
	 * 获取订单信息
	 * @param deviceBindId
	 * @param deviceTypeName
	 * @return
	 */
	public Object[] getUserId(String  deviceBindId,String deviceTypeName){
		return orderDao.getUserId(deviceBindId, deviceTypeName);
	}
	/**
	 * 最新一条信息
	 * @param deviceId
	 * @return
	 */
	public Pressure getPressure(String deviceId){
		return mPressureDao.getPressure(deviceId);
	}
	/**
	 * 个人警报
	 * @param deviceBindId
	 * @param deviceTypeName
	 * @return
	 */
	public List<Object[]> getlist(String BindId){
		return alarmthresholdDao.getlist(BindId);
	}
	/**
	 * 公共警报
	 * @param tableName
	 * @return
	 */
	public List<Object[]>  getPressurep(String tableName){
		return zProductNormDao.getPressure(tableName);
	}
	
	/**
	 * 获取设备字段对应的解释
	 * @param itemName
	 * @return
	 */
	public String getByItemName(String itemName){
		return mDataModuleItemDao.getByItemName(itemName);
	}
	
}
