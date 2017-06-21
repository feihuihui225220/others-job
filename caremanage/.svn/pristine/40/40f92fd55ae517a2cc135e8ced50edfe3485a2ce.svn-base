package com.anticw.aged.bean.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * 每张数据表都含有的公共属性
 * <P>File name : BaseItems.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
//@Document
public class MetaData {
	
	/**
	 * 主键
	 */
	@Id
	private String id;

	/**
	 * 设备绑定Id
	 */
	private String deviceId;
	
	/**
	 * 数据上传时间
	 */
	private Date uploadTime;

	/**
	 * @return String 取得域 deviceId 的方法。
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId 对域 deviceId 的设置方法.
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return Date 取得域 uploadTime 的方法。
	 */
	public Date getUploadTime() {
		return uploadTime;
	}

	/**
	 * @param uploadTime 对域 uploadTime 的设置方法.
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * @return String 取得域 id 的方法。
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(String id) {
		this.id = id;
	}
}
