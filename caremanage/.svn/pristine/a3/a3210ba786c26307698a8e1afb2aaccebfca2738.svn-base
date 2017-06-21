package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

/**
 * MDevice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_device", catalog = "")
public class MDevice implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String name;
	private String vender;
	private String number;
	private String useDesc;
	private String functionDesc;
	private String deviceTypeIds;
	private Integer price;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;

	// Constructors

	/** default constructor */
	public MDevice() {
	}

	/** full constructor */
	public MDevice(Integer id, Short version, String name, String vender,
			String number, String useDesc, String functionDesc,
			String deviceTypeIds, Integer price, Boolean available,
			String createdBy, Date createdAt, String changedBy, Date changedAt) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.vender = vender;
		this.number = number;
		this.useDesc = useDesc;
		this.functionDesc = functionDesc;
		this.deviceTypeIds = deviceTypeIds;
		this.price = price;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
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

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "name", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "vender", nullable = false, length = 60)
	public String getVender() {
		return this.vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	@Column(name = "number", nullable = false, length = 60)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "use_desc", nullable = false, length = 65535)
	public String getUseDesc() {
		return this.useDesc;
	}

	public void setUseDesc(String useDesc) {
		this.useDesc = useDesc;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "function_desc", nullable = false, length = 65535)
	public String getFunctionDesc() {
		return this.functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	@Column(name = "device_type_ids", nullable = false, length = 500)
	public String getDeviceTypeIds() {
		return this.deviceTypeIds;
	}

	public void setDeviceTypeIds(String deviceTypeIds) {
		this.deviceTypeIds = deviceTypeIds;
	}

	@Column(name = "price", nullable = false)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
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

}