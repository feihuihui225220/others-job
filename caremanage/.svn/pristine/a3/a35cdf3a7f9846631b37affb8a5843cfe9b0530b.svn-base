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
 * ACommunityUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_community_user")
public class ACommunityUser implements java.io.Serializable {

	private static final long serialVersionUID = -7703119122691828292L;
	// Fields
	private Integer id;
	private Short version;
	private String name;
	private String password;
	private Short gender;
	private String contactPhone;
	private String mobilePhone;
	private String email;
	private Integer countryId;
	private String address;
	private Boolean available;
	private Date changedAt;
	private String changedBy;
	private Date createdAt;
	private String createdBy;

	// Constructors
	
	public ACommunityUser(Short version, String name, String password,
			Short gender, String contactPhone, String mobilePhone,
			String email, Integer countryId, String address, Boolean available,
			Date changedAt, String changedBy, Date createdAt, String createdBy) {
		this.version = version;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.contactPhone = contactPhone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.countryId = countryId;
		this.address = address;
		this.available = available;
		this.changedAt = changedAt;
		this.changedBy = changedBy;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}
	public ACommunityUser() {
		 
	}
	/** default constructor */
 
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender", nullable = false)
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "contact_phone", length = 20)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "mobile_phone", length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "available", columnDefinition = "BIT", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "changed_at", nullable = false, length = 19)
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
	@Column(name = "country_id")
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	

}