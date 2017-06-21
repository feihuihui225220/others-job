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

@Entity
@Table(name = "m_vender")
public class MVender {

	// Fields
	private Integer id;
	private String cmName;
	private String name;
	private Integer categoryId;
	private Short star;
	private Integer userId;
	private String contactPhone;
	private String contactAddr;
	private String contact;
	private String qualification;
	private String introduction;
	private String communityIds;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Short version;
	private Float longitude;
	private Float latitude;
	// Constructors

	/** default constructor */
	public MVender() {
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
	@Column(name = "version", nullable = true)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "name", nullable = true, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "contact_phone", length = 20)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "contact_addr", length = 60)
	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	@Column(name = "contact", nullable = true, length = 20)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "qualification", nullable = true)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "text")
	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "created_by", nullable = true, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = true, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = true, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = true, length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @return Integer 取得域 categoryId 的方法。
	 */
	@Column(name = "category_id", nullable = true)
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            对域 categoryId 的设置方法.
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return Short 取得域 star 的方法。
	 */
	@Column(name = "star", nullable = true)
	public Short getStar() {
		return star;
	}

	/**
	 * @param star
	 *            对域 start 的设置方法.
	 */
	public void setStar(Short star) {
		this.star = star;
	}

	/**
	 * @return Integer 取得域 userId 的方法。
	 */
	@Column(name = "user_id", nullable = true)
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            对域 userId 的设置方法.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return String 取得域 cmName 的方法。
	 */
	@Column(name = "cm_name", nullable = true, length = 40)
	public String getCmName() {
		return cmName;
	}

	/**
	 * @param cmName 对域 cmName 的设置方法.
	 */
	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	/**
	 * @return the communityIds
	 */
	@Column(name = "community_ids")
	public String getCommunityIds() {
		return communityIds;
	}

	/**
	 * @param communityIds the communityIds to set
	 */
	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}
	
	/**
	 * @return the longitude
	 */
	@Column(name = "longitude")
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	@Column(name = "latitude")
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "MVender [cmName=" + cmName + ", name=" + name + ", categoryId="
				+ categoryId + ", star=" + star + ", userId=" + userId
				+ ", contactPhone=" + contactPhone + ", contactAddr="
				+ contactAddr + ", contact=" + contact + ", qualification="
				+ qualification + ", introduction=" + introduction
				+ ", communityIds=" + communityIds + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", changedBy=" + changedBy
				+ ", changedAt=" + changedAt + ", version=" + version
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
}
