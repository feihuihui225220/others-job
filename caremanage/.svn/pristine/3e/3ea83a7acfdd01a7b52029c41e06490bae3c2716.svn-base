package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

/**
 * ZGuidePhone entity. @author MyEclipse Persistence Tools
 * VIP引导页
 */
@Entity
@Table(name = "z_guide_photo")
public class ZGuidePhoto{

	// Fields

	private Integer id;
	private String photoName;
	private String photoDesc;
	private Integer sort;
	private String photoUrl;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Short version;

	// Constructors

	/** default constructor */
	public ZGuidePhoto() {
	}

	/** full constructor */
	public ZGuidePhoto(String photoName, String photoDesc, Integer sort,
			String photoUrl, Boolean available, String createdBy,
			Date createdAt, String changedBy, Date changedAt,
			Short version) {
		this.photoName = photoName;
		this.photoDesc = photoDesc;
		this.sort = sort;
		this.photoUrl = photoUrl;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
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

	@Column(name = "photo_name", length = 50)
	public String getPhotoName() {
		return this.photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name = "photo_desc")
	public String getPhotoDesc() {
		return this.photoDesc;
	}

	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "photo_url")
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Version
	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

}