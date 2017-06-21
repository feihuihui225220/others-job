package com.anticw.aged.bean.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 警报任务执行时间
 * @author zhouyanxin
 */
@Document(collection="m_alarmExecuteTime")
public class MAlarmExecuteTime {

	/**
	 * id
	 */
	@Id
    private String id;
	
	/**
	 * 上次执行时间
	 */
	private Date lastExecuteTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastExecuteTime() {
		return lastExecuteTime;
	}

	public void setLastExecuteTime(Date lastExecuteTime) {
		this.lastExecuteTime = lastExecuteTime;
	}
}
