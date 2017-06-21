package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "m_order_device")
public class MOrderDevice {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	//@Column(name = "order_id", nullable = false)
	//private Long orderId;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
	private MOrder order;
	
	@Column(name = "meta_service_id", nullable = false)
	private Integer metaServiceId;
	
	@OneToOne
	@JoinColumn(name="meta_service_id",insertable=false,updatable=false)
	private MMetaService mMetaService;
	
	@Column(name = "device_type_id", nullable = false)
	private Integer deviceTypeId;
	
	@Column(name = "device_type_name", nullable = false, length = 60)
	private String deviceTypeName;
	
	@Column(name = "device_id", nullable = false)
	private Integer deviceId;
	
	@Column(name = "device_name", nullable = false, length = 60)
	private String deviceName;
	
	@Column(name = "device_bind_id", nullable = false, length = 60)
	private String deviceBindId;
	
	@Column(name = "price", nullable = false)
	private Integer price;

	/**
	 * @return Long 取得域 id 的方法。
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Long 取得域 orderId 的方法。
	 */
	//public Long getOrderId() {
	//	return orderId;
	//}

	/**
	 * @param orderId 对域 orderId 的设置方法.
	 */
	//public void setOrderId(Long orderId) {
	//	this.orderId = orderId;
	//}

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
	 * @return String 取得域 deviceName 的方法。
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName 对域 deviceName 的设置方法.
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}


	/**
	 * @return MOrder 取得域 order 的方法。
	 */
	public MOrder getOrder() {
		return order;
	}
	
	/**
	 * 
	 * @returnprice
	 */
	public Integer getPrice() {
		return price;
	}


	/**
	 * @param order 对域 order 的设置方法.
	 */
	public void setOrder(MOrder order) {
		this.order = order;
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
	 * @return the mMetaService
	 */
	public MMetaService getmMetaService() {
		return mMetaService;
	}

	/**
	 * @param mMetaService the mMetaService to set
	 */
	public void setmMetaService(MMetaService mMetaService) {
		this.mMetaService = mMetaService;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
