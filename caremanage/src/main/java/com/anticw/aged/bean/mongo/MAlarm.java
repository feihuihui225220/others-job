package com.anticw.aged.bean.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 报警数据
 * <P>File name : MAlarm.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Document(collection="m_alarm")
public class MAlarm {
	
	/**
	 * id
	 */
	@Id
    private String id;

	/**
	 * 用户Id
	 */
	private Long userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 联系方式
	 */
	private String contect;
	
	/**
	 * 服务商Id
	 */
	private Integer venderId;
	
	/**
	 * 服务商名称
	 */
	private String venderName;
	
	/**
	 * 警报内容
	 */
	private String content;
	
	/**
	 * 数据项
	 */
	private String dataItemName;
	
	/**
	 * 警报类别
	 */
	private String dateItemDesc;
	
	/**
	 * 警报值
	 */
	private Float alarmValue;
	
	/**
	 * 服务Id
	 */
	private Integer serviceId;
	
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	/**
	 * 报警时间
	 */
	private Date alarmTime;
	
	/**
	 * 响应时间
	 */
	private Date responseTime;
	
	/**
	 * 处理状态
	 */
	private Short status;
	
	/**
	 * 处理人员
	 */
	private String createdBy;
	
	/**  
	 * 处理意见
	 */
	private String suggestion;
	
	/**  
	 * return String 获取域suggestion的方法。
	 */
	public String getSuggestion() {
		return suggestion;
	}
	
	/**  
	 * param String 设置域suggestion的方法。  
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	

	/**  
	 * return String 获取域id的方法。
	 */
	public String getId() {
		return id;
	}
	
	/**  
	 * param String 设置域id的方法。  
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return Long 取得域 userId 的方法。
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return String 取得域 userName 的方法。
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 对域 userName 的设置方法.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return String 取得域 contect 的方法。
	 */
	public String getContect() {
		return contect;
	}

	/**
	 * @param contect 对域 contect 的设置方法.
	 */
	public void setContect(String contect) {
		this.contect = contect;
	}

	/**
	 * @return Integer 取得域 venderId 的方法。
	 */
	public Integer getVenderId() {
		return venderId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	/**
	 * @return String 取得域 venderName 的方法。
	 */
	public String getVenderName() {
		return venderName;
	}

	/**
	 * @param venderName 对域 venderName 的设置方法.
	 */
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	/**
	 * @return String 取得域 content 的方法。
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content 对域 content 的设置方法.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return String 取得域 dataItemName 的方法。
	 */
	public String getDataItemName() {
		return dataItemName;
	}

	/**
	 * @param dataItemName 对域 dataItemName 的设置方法.
	 */
	public void setDataItemName(String dataItemName) {
		this.dataItemName = dataItemName;
	}

	/**
	 * @return String 取得域 dateItemDesc 的方法。
	 */
	public String getDateItemDesc() {
		return dateItemDesc;
	}

	/**
	 * @param dateItemDesc 对域 dateItemDesc 的设置方法.
	 */
	public void setDateItemDesc(String dateItemDesc) {
		this.dateItemDesc = dateItemDesc;
	}

	/**
	 * @return Integer 取得域 serviceId 的方法。
	 */
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId 对域 serviceId 的设置方法.
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return String 取得域 serviceName 的方法。
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName 对域 serviceName 的设置方法.
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return Date 取得域 alarmTime 的方法。
	 */
	public Date getAlarmTime() {
		return alarmTime;
	}

	/**
	 * @param alarmTime 对域 alarmTime 的设置方法.
	 */
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	/**
	 * @return Date 取得域 responseTime 的方法。
	 */
	public Date getResponseTime() {
		return responseTime;
	}

	/**
	 * @param responseTime 对域 responseTime 的设置方法.
	 */
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * @return Short 取得域 status 的方法。
	 */
	public Short getStatus() {
		return status;
	}

	/**
	 * @param status 对域 status 的设置方法.
	 */
	public void setStatus(Short status) {
		this.status = status;
	}

	/**
	 * @return String 取得域 createdBy 的方法。
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy 对域 createdBy 的设置方法.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Float getAlarmValue() {
		return alarmValue;
	}

	public void setAlarmValue(Float alarmValue) {
		this.alarmValue = alarmValue;
	}
}
