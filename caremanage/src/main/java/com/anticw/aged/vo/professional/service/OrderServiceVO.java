package com.anticw.aged.vo.professional.service;

import java.util.Date;

/**
 * 订购服务信息
 * <P>File name : OrderServiceVo.java </P>
 * <P>Author : zhoupeipei </P> 
 * <P>Date : 2015年1月22日 </P>
 */
public class OrderServiceVO {
	/**
	 * 服务Id
	 */
	private Integer serviceId;
	
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	/**
	 * 开始时间
	 */
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 设备类型名称（多个设备类型名称逗号分割）
	 */
	private String deviceTypeName;

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
	 * @return Date 取得域 startTime 的方法。
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime 对域 startTime 的设置方法.
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return Date 取得域 endTime 的方法。
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime 对域 endTime 的设置方法.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return String 取得域 deviceTypeName 的方法。
	 */
	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	/**
	 * @param deviceTypeName 对域 deviceTypeName 的设置方法.
	 */
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}
	
	

}
