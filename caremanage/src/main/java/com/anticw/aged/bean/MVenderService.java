package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_vender_service")
public class MVenderService {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "vender_id", nullable = false)
	private Integer venderId;
	
	@Column(name = "service_id", nullable = false)
	private Integer serviceId;

	@Transient
	private String serviceName;
	
	/**
	 * @return Long 取得域 id 的方法。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Integer id) {
		this.id = id;
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
}
