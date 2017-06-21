package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

/**
 * MMetaService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_meta_service", catalog = "")
public class MMetaService implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Short version;
	//private Integer deviceTypeId;
	//private Integer dataModuleId;
	private int price;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private MDeviceType deviceType;
	private MDataModule dataModule;
	private Short type;
	// Constructors

	/** default constructor */
	public MMetaService() {
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	



	/**
	 * @return String 取得域 name 的方法。
	 */
	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return name;
	}

	/**
	 * @param name 对域 name 的设置方法.
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "price")
	public int getPrice() {
		return price;
	}

	/**
	 * 服务费用
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

//	@Column(name = "device_type_id", nullable = false)
//	public Integer getDeviceTypeId() {
//		return this.deviceTypeId;
//	}
//
//	public void setDeviceTypeId(Integer deviceTypeId) {
//		this.deviceTypeId = deviceTypeId;
//	}
	
	
	
	/**
	 * @param deviceType 对域 deviceType 的设置方法.
	 */
	public void setDeviceType(MDeviceType deviceType) {
		this.deviceType = deviceType;
	}


	/**
	 * @return MDeviceType 取得域 deviceType 的方法。
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_type_id")
	@Where(clause="available=1")
	public MDeviceType getDeviceType() {
		return deviceType;
	}	
	
//	@Column(name = "data_module_id", nullable = false)
//	public Integer getDataModuleId() {
//		return this.dataModuleId;
//	}
//
//	public void setDataModuleId(Integer dataModuleId) {
//		this.dataModuleId = dataModuleId;
//	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = false, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = false, length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @param dataModule 对域 dataModule 的设置方法.
	 */
	public void setDataModule(MDataModule dataModule) {
		this.dataModule = dataModule;
	}
	
	/**
	 * @return MDataModule 取得域 dataModule 的方法。
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_module_id")
	@Where(clause="available=1")
	public MDataModule getDataModule() {
		return dataModule;
	}

	@Column(name = "type")
	public Short getType() {
		return type;
	}


	public void setType(Short type) {
		this.type = type;
	}
	
}