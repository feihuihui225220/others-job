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
 * ZPhoto entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_photo")
public class ZPhoto {

	// Fields

	private Long id;
	private Long userId;
	private Short version;
	private String photoName;
	private String photoDesc;
	private Integer comeFrom;
	private String photoUrl;
	private Boolean avaliable;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;

	// Constructors

	/** default constructor */
	public ZPhoto() {
	}

	/** full constructor */
	public ZPhoto(Long id, Long userId, Short version, String photoName,
			String photoDesc, Integer comeFrom, String photoUrl,
			Boolean avaliable, String createdBy, Date createdAt,
			String changedBy, Date changedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.version = version;
		this.photoName = photoName;
		this.photoDesc = photoDesc;
		this.comeFrom = comeFrom;
		this.photoUrl = photoUrl;
		this.avaliable = avaliable;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
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
	
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Version
	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
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

	@Column(name = "come_from")
	public Integer getComeFrom() {
		return this.comeFrom;
	}

	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}

	@Column(name = "photo_url")
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Column(name = "avaliable")
	public Boolean getAvaliable() {
		return this.avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", length = 0)
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

	@Column(name = "changed_at", length = 0)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

}