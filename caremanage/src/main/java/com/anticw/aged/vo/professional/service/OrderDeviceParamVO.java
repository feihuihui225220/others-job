package com.anticw.aged.vo.professional.service;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 订单专业服务的设备参数
 * <P>File name : OrderDeviceParamVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-7 </P>
 */
public class OrderDeviceParamVO implements BaseVO {

	/**
	 * 元服务Id
	 */
	private Integer metaServiceId;
	
	/**
	 * 设备类型Id
	 */
	private Integer deviceTypeId;
	
	/**
	 * 设备类型名称
	 */
	private String deviceTypeName;
	
	/**
	 * 设备Id
	 */
	private Integer deviceId;
	
	/**
	 * 设备绑定Id
	 */
	private String deviceBindId;

	/**
	 * @return Integer 取得域 deviceId 的方法。
	 */
	public Integer getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId 对域 deviceId 的设置方法.
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return String 取得域 deviceBindId 的方法。
	 */
	public String getDeviceBindId() {
		return deviceBindId;
	}

	/**
	 * @param deviceBindId 对域 deviceBindId 的设置方法.
	 */
	public void setDeviceBindId(String deviceBindId) {
		this.deviceBindId = deviceBindId;
	}

	/**
	 * @return Integer 取得域 deviceTypeId 的方法。
	 */
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	/**
	 * @param deviceTypeId 对域 deviceTypeId 的设置方法.
	 */
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
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

	/**
	 * @return Integer 取得域 metaServiceId 的方法。
	 */
	public Integer getMetaServiceId() {
		return metaServiceId;
	}

	/**
	 * @param metaServiceId 对域 metaServiceId 的设置方法.
	 */
	public void setMetaServiceId(Integer metaServiceId) {
		this.metaServiceId = metaServiceId;
	}

	/**
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-7 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		return true;
	}
}
