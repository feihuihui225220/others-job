/*package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.anticw.aged.bean.utils.PropertyValueConstants;

*//**
 * RCert entity. @author MyEclipse Persistence Tools
 *//*
@Entity
@Table(name = "r_cert")
public class RCert implements java.io.Serializable {

	private static final long serialVersionUID = 7636826064099720977L;
	// Fields
	private Long id;
	private RUser user;
	private Integer categoryId;
	private String number;
	private String directory;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Short version;

	// Constructors

	*//** default constructor *//*
	public RCert() {
	}

	*//**
	 * @param user
	 * @param categoryId
	 * @param number
	 * @param directory
	 * @param opUser
	 *//*
	public RCert(RUser user, Integer categoryId, String number, String directory, String opUser) {
		super();
		this.user = user;
		this.categoryId = categoryId;
		this.number = number;
		this.directory = directory;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date date = new Date();
		this.createdAt = date;
		this.changedBy = opUser;
		this.changedAt = date;
		this.version = 0;
	}



	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
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
	
	@ManyToOne(optional=true)
	@JoinColumn(name="user_id")
	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.user = user;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "number", length = 40)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "directory")
	public String getDirectory() {
		return this.directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
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

}*/