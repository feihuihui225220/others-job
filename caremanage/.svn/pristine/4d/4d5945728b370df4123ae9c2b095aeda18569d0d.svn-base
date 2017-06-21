package com.anticw.aged.dao.professional.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAlarmThreshold;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Component
public class AlarmthresholdDao extends HibernateEntityDao<MAlarmThreshold>{

	/**
	 * 获取对应的警报值
	 * @param BindId
	 * @return
	 */
	public List<Object[]> getlist(String BindId){
		String sql="SELECT m_alarm_threshold.`item_name`,m_alarm_threshold.`alarm_lower`,m_alarm_threshold.`alarm_upper`,m_alarm_threshold.meta_service_id "
				+ "FROM m_alarm_threshold WHERE "
				+ "m_alarm_threshold.`device_bind_id`='"+BindId
				+ "' AND m_alarm_threshold.`vender_id`='-1'  "
						+ "AND m_alarm_threshold.`is_alarm`=1 "
						+ "GROUP BY m_alarm_threshold.`item_name` ";
		return super.findBySQLQuery(sql);
	}
	
	
}
