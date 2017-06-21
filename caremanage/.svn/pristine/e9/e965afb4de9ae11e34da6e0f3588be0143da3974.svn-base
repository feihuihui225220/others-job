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
 * MService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_service", catalog = "")
public class MService implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String name;
	private String metaServiceIds;
	private Integer price;
	private String qualification;
	private String picture;
	private Integer categoryId;
	private String assessTableIds;
	private String serviceContent;
	private String qualityStandard;
	private Boolean available;
	/**
	 * 页面展现方式标识
	 */
	private Integer stype;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;

	// Constructors

	/** default constructor */
	public MService() {
	}

	/** minimal constructor */
	public MService(Integer id, String metaServiceIds, Integer price, String qualification, String assessTableIds, String serviceContent,
			String qualityStandard, Boolean available, String createdBy, Date createdAt, String changedBy, Date changedAt) {
		this.id = id;
		this.metaServiceIds = metaServiceIds;
		this.price = price;
		this.qualification = qualification;
		this.assessTableIds = assessTableIds;
		this.serviceContent = serviceContent;
		this.qualityStandard = qualityStandard;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
	}

	/** full constructor */
	public MService(Integer id, String name, String metaServiceIds, Integer price, String qualification, String picture, Integer categoryId,
			String assessTableIds, String serviceContent, String qualityStandard, Boolean available, String createdBy, Date createdAt,
			String changedBy, Date changedAt) {
		this.id = id;
		this.name = name;
		this.metaServiceIds = metaServiceIds;
		this.price = price;
		this.qualification = qualification;
		this.picture = picture;
		this.categoryId = categoryId;
		this.assessTableIds = assessTableIds;
		this.serviceContent = serviceContent;
		this.qualityStandard = qualityStandard;
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

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "meta_service_ids", nullable = false)
	public String getMetaServiceIds() {
		return this.metaServiceIds;
	}

	public void setMetaServiceIds(String metaServiceIds) {
		this.metaServiceIds = metaServiceIds;
	}

	@Column(name = "price", nullable = false)
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "qualification", nullable = false, length = 40)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name = "picture", length = 500)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "assess_table_ids")
	public String getAssessTableIds() {
		return this.assessTableIds;
	}

	public void setAssessTableIds(String assessTableIds) {
		this.assessTableIds = assessTableIds;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "service_content", nullable = false, length = 65535)
	public String getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "quality_standard", nullable = false, length = 65535)
	public String getQualityStandard() {
		return this.qualityStandard;
	}

	public void setQualityStandard(String qualityStandard) {
		this.qualityStandard = qualityStandard;
	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

	/**
	 * @return the stype
	 */
	@Column(name = "stype", nullable = true)
	public Integer getStype() {
		return stype;
	}

	/**
	 * @param stype the stype to set
	 */
	public void setStype(Integer stype) {
		this.stype = stype;
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