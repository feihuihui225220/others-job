package com.anticw.aged.vo.professional.service;
/**
 * 
 * @author DX 
 * 获取选中订单的设备id
 *
 */
public class DeviceBindVO {

	private long userId;
	private String deviceBindId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getDeviceBindId() {
		return deviceBindId;
	}
	public void setDeviceBindId(String deviceBindId) {
		this.deviceBindId = deviceBindId;
	}
	
	
}
