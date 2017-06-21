package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 老人用户绑定专业服务商
 * @author Administrator
 *
 */
@Entity
@Table(name = "m_user_venders", catalog = "")
public class MUserVender implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4823534222948064478L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "site_id")
	private Long siteId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_sex")
	private short userSex;
	@Column(name = "user_idCard")
	private String userIdCard;
	@Column(name = "community_name")
	private String communityName;
	@Column(name = "vender_id")
	private int venderId;
	@Column(name = "allocation")
	private int allocation;//分配服务商员工（0，未分配；1，已分配）
	@Column(name = "created_by", length = 20)
	private String createdBy;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "changed_by", length = 20)
	private String changedBy;
	@Column(name = "changed_at")	
	private Date changedAt;
	@Column(name = "available")
	private boolean available;
	public MUserVender(){
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public short getUserSex() {
		return userSex;
	}
	public void setUserSex(short userSex) {
		this.userSex = userSex;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getVenderId() {
		return venderId;
	}
	public void setVenderId(int venderId) {
		this.venderId = venderId;
	}
	public int getAllocation() {
		return allocation;
	}
	public void setAllocation(int allocation) {
		this.allocation = allocation;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public Date getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MUserVender [id=" + id + ", userId=" + userId + ", siteId="
				+ siteId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userIdCard=" + userIdCard + ", communityName="
				+ communityName + ", venderId=" + venderId + ", allocation="
				+ allocation + ", createdBy=" + createdBy + ", createdAt="
				+ createdAt + ", changedBy=" + changedBy + ", changedAt="
				+ changedAt + ", available=" + available + "]";
	}
	
	
	
}
