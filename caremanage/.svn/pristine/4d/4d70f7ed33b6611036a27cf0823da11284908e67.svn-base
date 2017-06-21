package com.anticw.aged.service.professional.data.server;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.data.AlarmDao;

/**
 * 报警服务类
 * <P>File name : AlarmService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-13 </P>
 */
@Service
public class AlarmService {

	/**
	 * 警报数据持久层对象
	 */
	@Autowired
	private AlarmDao alarmDao;
	
	/**
	 * 处理警报
	 * @param userName
	 * @param id
	 * @param suggestion
	 */
	public void dealAlarm(String userName, String id, String suggestion) {
		
		//获取警报信息
		MAlarm alarm = alarmDao.getAlarm(id);
		if(alarm == null) {
			return;
		}
		
		//更新警报状态
		alarm.setStatus(ProfessionalConstants.ALARM_STATUS_SOLVED);
		alarm.setCreatedBy(userName);
		alarm.setResponseTime(new Date());
		alarm.setSuggestion(suggestion);
		
		//持久化
		alarmDao.update(alarm);
	}
	
	public void save(MAlarm alarm){
		alarmDao.save(alarm);
	}
}
