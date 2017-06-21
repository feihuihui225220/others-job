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
 * MAssessTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_table")
public class MAssessTable implements java.io.Serializable {

	/**
	 * 字段或域定义：<code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6888928449600736791L;
	
	private Integer id;
	private Integer itemId;
	private Short version;
	private String name;
	private Short type;
	private String descr;
	private String combIds;
	private Boolean publishStatus;
	private Boolean available;
	private Boolean recommend;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Boolean is_need_handle;
	// Constructors

	/** default constructor */
	public MAssessTable() {
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

	@Column(name = "item_id")
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "descr")
	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Column(name = "comb_ids")
	public String getCombIds() {
		return this.combIds;
	}

	public void setCombIds(String combIds) {
		this.combIds = combIds;
	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Column(name = "is_need_handle", nullable = true)
	public Boolean getIs_need_handle() {
		return is_need_handle;
	}

	public void setIs_need_handle(Boolean is_need_handle) {
		this.is_need_handle = is_need_handle;
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
	 * @return Short 取得域 publishStatus 的方法。
	 */
	@Column(name = "publish_status", nullable = false)
	public Boolean getPublishStatus() {
		return publishStatus;
	}

	/**
	 * @param publishStatus 对域 publishStatus 的设置方法.
	 */
	public void setPublishStatus(Boolean publishStatus) {
		this.publishStatus = publishStatus;
	}

	@Column(name = "recommend")
	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}
	
	
	
}