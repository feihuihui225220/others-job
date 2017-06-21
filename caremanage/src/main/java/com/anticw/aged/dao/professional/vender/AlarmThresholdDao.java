package com.anticw.aged.dao.professional.vender;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAlarmThreshold;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 用户警报阈值持久化对象
 * <P>File name : AlarmThresholdDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
@Repository
public class AlarmThresholdDao extends HibernateEntityDao<MAlarmThreshold> {

	/**
	 * 获取指定服务下指定报警项目的数据
	 * AlarmThresholdDao.get()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param serviceId
	 * @param itemName
	 * @return
	 */
	public MAlarmThreshold get(Long userId, Integer metaServiceId, String itemName) {
		List<MAlarmThreshold> alarmThresholds = find("from MAlarmThreshold m where m.userId= ? and m.metaServiceId = ? and m.itemName = ?", new Object[]{userId, metaServiceId, itemName});
		if(alarmThresholds != null && !alarmThresholds.isEmpty()) {
			return alarmThresholds.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取指定用户指定服务的警报信息
	 * AlarmThresholdDao.getByUserAndService()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @param serviceId
	 * @return
	 */
	public List<MAlarmThreshold> getByUserAndService(Long userId, Integer metaServiceId) {
		return find("from MAlarmThreshold m where m.userId= ? and m.metaServiceId = ?", new Object[]{userId, metaServiceId});
	}
	
	/**
	 * 获取指定用户指定元服务的警报设置
	 * @param userId
	 * @param metaServiceId
	 * @return
	 */
	public List<MAlarmThreshold> getByUserAndMeta(Long userId, Integer metaServiceId) {
		return find("from MAlarmThreshold m where m.userId = ? and m.metaServiceId = ?", new Object[]{userId, metaServiceId});
	}
	
	public MAlarmThreshold getByUserAndServiceId(Long userId,Integer metaServiceId) {
		List<MAlarmThreshold> li=super.find("from MAlarmThreshold m where m.userId = ? and m.metaServiceId = ? and m.isAlarm=1", new Object[]{userId, metaServiceId});
		if(li.size()!=0){
			return li.get(0);
		}else{
			return null;
		}
	}
	
}
