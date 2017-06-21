package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MDataModuleItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_alarm_threshold")
public class MAlarmThreshold {

	private Long id;
	private Long userId;
	private Integer metaServiceId;
	private String deviceBindId;
	private Integer venderId;
	private String itemName;
	private Boolean isAlarm;
	private Float alarmLower;
	private Float alarmUpper;
	private Date createdAt;
	private String createdBy;
	private Short version;
	
	public MAlarmThreshold() {
		
	}
	
	/**
	 * @return Long 取得域 id 的方法。
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	/**
	 * @return Long 取得域 userId 的方法。
	 */
	@Column(name = "user_id", nullable = true)
	public Long getUserId() {
		return userId;
	}
	/**
	 * @return Integer 取得域 verderId 的方法。
	 */
	@Column(name = "vender_id")
	public Integer getVenderId() {
		return venderId;
	}
	/**
	 * @return String 取得域 itemName 的方法。
	 */
	@Column(name = "item_name", nullable = true, length = 20)
	public String getItemName() {
		return itemName;
	}
	/**
	 * @return Integer 取得域 alarmLower 的方法。
	 */
	@Column(name = "alarm_lower", nullable = true, precision = 10, scale = 3)
	public Float getAlarmLower() {
		return alarmLower;
	}
	/**
	 * @return Float 取得域 alarmUpper 的方法。
	 */
	@Column(name = "alarm_upper", nullable = true, precision = 10, scale = 3)
	public Float getAlarmUpper() {
		return alarmUpper;
	}
	/**
	 * @return Date 取得域 createdAt 的方法。
	 */
	@Column(name = "created_at", nullable = true)
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return String 取得域 createdBy 的方法。
	 */
	@Column(name = "created_by", nullable = true)
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @return Short 取得域 version 的方法。
	 */
	@Column(name = "version")
	public Short getVersion() {
		return version;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}


	/**
	 * @param itemName 对域 itemName 的设置方法.
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @param alarmLower 对域 alarmLower 的设置方法.
	 */
	public void setAlarmLower(Float alarmLower) {
		this.alarmLower = alarmLower;
	}

	/**
	 * @param alarmUpper 对域 alarmUpper 的设置方法.
	 */
	public void setAlarmUpper(Float alarmUpper) {
		this.alarmUpper = alarmUpper;
	}

	/**
	 * @param createdAt 对域 createdAt 的设置方法.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @param createdBy 对域 createdBy 的设置方法.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param version 对域 version 的设置方法.
	 */
	public void setVersion(Short version) {
		this.version = version;
	}

	/**
	 * @return Boolean 取得域 isAlarm 的方法。
	 */
	@Column(name = "is_alarm", nullable = true)
	public Boolean getIsAlarm() {
		return isAlarm;
	}

	/**
	 * @param isAlarm 对域 isAlarm 的设置方法.
	 */
	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	/**
	 * @return Integer 取得域 metaServiceId 的方法。
	 */
	@Column(name = "meta_service_id", nullable = true)
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
	 * @return String 取得域 deviceBindId 的方法。
	 */
	@Column(name = "device_bind_id", nullable = true, length = 60)
	public String getDeviceBindId() {
		return deviceBindId;
	}

	/**
	 * @param deviceBindId 对域 deviceBindId 的设置方法.
	 */
	public void setDeviceBindId(String deviceBindId) {
		this.deviceBindId = deviceBindId;
	}
}
