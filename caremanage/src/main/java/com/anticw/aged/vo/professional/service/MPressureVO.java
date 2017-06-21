package com.anticw.aged.vo.professional.service;
/**
 * 
 * @author DX-血压
 *
 */

public class MPressureVO {

	private Long  userId;
	private String deviceId;
	private Float  highPressures;//收缩压 起始一条
	private Float  lowPressures;//舒张压
	private Float  highPressuree;//收缩压 最后一条
	private Float  lowPressuree;//舒张压
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Float getHighPressures() {
		return highPressures;
	}
	public void setHighPressures(Float highPressures) {
		this.highPressures = highPressures;
	}
	public Float getLowPressures() {
		return lowPressures;
	}
	public void setLowPressures(Float lowPressures) {
		this.lowPressures = lowPressures;
	}
	public Float getHighPressuree() {
		return highPressuree;
	}
	public void setHighPressuree(Float highPressuree) {
		this.highPressuree = highPressuree;
	}
	public Float getLowPressuree() {
		return lowPressuree;
	}
	public void setLowPressuree(Float lowPressuree) {
		this.lowPressuree = lowPressuree;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
