package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * MMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_message")
public class MMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Short version;
	private Integer serviceId;
	private String serviceName;
	private Long userId;
	private Integer vendorId;
	private String message;
	private Date createdAt;
	private String createdBy;

	// Constructors

	/** default constructor */
	public MMessage() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "vendor_id", nullable = false)
	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "message", nullable = false)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return Integer 取得域 serviceId 的方法。
	 */
	@Column(name = "service_id", nullable = false)
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
	@Column(name = "service_name", nullable = false, length = 40)
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName 对域 serviceName 的设置方法.
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
}