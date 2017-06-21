package com.anticw.aged.dao.data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.mongo.MAlarmExecuteTime;
import com.anticw.aged.dao.utils.MongoBaseDao;

/**
 * 警报执行时间持久化类
 * @author zhouyanxin
 */
@Repository
public class AlarmExecuteTimeDao extends MongoBaseDao {

	/**
	 * collectionName
	 */
	private static final String COLLECTION_NAME = "m_alarmExecuteTime";
	
	/**
	 * 获取警报执行时间
	 * @return
	 */
	public MAlarmExecuteTime get() {
		
		List<MAlarmExecuteTime> times = super.findAll(MAlarmExecuteTime.class, COLLECTION_NAME);
		if(times != null && !times.isEmpty()) {
			return times.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 首次时间初始化
	 * @return
	 */
	public MAlarmExecuteTime firstInitAlarmExecuteTime() {
		
		//一小时以前
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR_OF_DAY, -1);
		
		MAlarmExecuteTime time = new MAlarmExecuteTime();
		time.setLastExecuteTime(c.getTime());
		super.save(time);
		return get();
	}
	
	/**
	 * 更新
	 * @param o
	 * @param n
	 */
	public void update(MAlarmExecuteTime o, MAlarmExecuteTime n) {
		super.update(o, n);
	}
}
