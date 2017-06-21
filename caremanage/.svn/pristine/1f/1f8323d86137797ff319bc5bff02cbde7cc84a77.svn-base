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

@Entity
@Table(name = "m_vender_users")
public class MVenderUsers {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "vender_id", nullable = false)
	private Integer venderId;
	
	@Column(name = "admin_id", nullable = false)
	private Long adminId;
	
	/**
	 * 修改为一对一...ruser
	 */
	
	//@Column(name = "user_id", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private RUser rUser;
	
	@Column(name = "created_by", nullable = false, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = false, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = false)
	private Date changedAt;
	
	@Column(name = "version", nullable = false)
	private Short version;
	
	
	public MVenderUsers() {
	}

	public MVenderUsers(Integer venderId, long adminId, RUser rUser,
			String createdBy, Date createdAt, String changedBy, Date changedAt,
			Short version) {
		super();
		this.venderId = venderId;
		this.adminId = adminId;
		this.rUser = rUser;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
	}

	/**
	 * @return Long 取得域 id 的方法。
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Integer 取得域 venderId 的方法。
	 */
	public Integer getVenderId() {
		return venderId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	/**
	 * @return Integer 取得域 adminId 的方法。
	 */
	public long getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId 对域 adminId 的设置方法.
	 */
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return Long 取得域 userId 的方法。
	 */
	/*public Long getUserId() {
		return userId;
	}

	*//**
	 * @param userId 对域 userId 的设置方法.
	 *//*
	public void setUserId(Long userId) {
		this.userId = userId;
	}*/

	/**
	 * @return String 取得域 createdBy 的方法。
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy 对域 createdBy 的设置方法.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return Date 取得域 createdAt 的方法。
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt 对域 createdAt 的设置方法.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return String 取得域 changedBy 的方法。
	 */
	public String getChangedBy() {
		return changedBy;
	}

	/**
	 * @param changedBy 对域 changedBy 的设置方法.
	 */
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * @return Date 取得域 changedAt 的方法。
	 */
	public Date getChangedAt() {
		return changedAt;
	}

	/**
	 * @param changedAt 对域 changedAt 的设置方法.
	 */
	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @return Short 取得域 version 的方法。
	 */
	public Short getVersion() {
		return version;
	}

	/**
	 * @param version 对域 version 的设置方法.
	 */
	public void setVersion(Short version) {
		this.version = version;
	}

	public RUser getrUser() {
		return rUser;
	}

	public void setrUser(RUser rUser) {
		this.rUser = rUser;
	}
	
	
}
