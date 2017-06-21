package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * HVisitCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_visit_category")
public class HVisitCategory implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：巡诊分类管理
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private short version;
	private String name;
	private Integer parentId;
	private boolean available;
	private String createdBy;
	private Date changedAt;
	private String changedBy;
	private Date createdAt;
	@SuppressWarnings("unused")
	private HVisitCategory hVisitCategory;
	// Constructors

	/** default constructor */
	public HVisitCategory() {
	}

	/** full constructor */
	public HVisitCategory(String name, boolean available,
			String createdBy, Date changedAt, String changedBy, Date createdAt,HVisitCategory hVisitCategory) {
		this.name = name;
		//this.parentId = parentId;
		this.available = available;
		this.createdBy = createdBy;
		this.changedAt = changedAt;
		this.changedBy = changedBy;
		this.createdAt = createdAt;
		this.hVisitCategory=hVisitCategory;
	}
	/*public HVisitCategory(Integer id) {
		this.id=id;
	}*/


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
	public short getVersion() {
		return this.version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "available", nullable = false)
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "changed_at", nullable = false, length = 0)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "changed_by", nullable = false, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "created_at", nullable = false, length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}