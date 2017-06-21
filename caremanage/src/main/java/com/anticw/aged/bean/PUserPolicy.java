package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * PUserPolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_user_policy")
public class PUserPolicy implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private Integer userId;
	private Integer policyId;
	private Integer communityId;
	private Integer state;
	private Date handleTime;
	private Date receiveTime;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
    
	private RUser user;
	private PPolicy policy;
	
	public PUserPolicy() {
		 
	}
    
	
	public PUserPolicy(Short version, Integer userId, Integer policyId,
			Integer communityId, Integer state, Date handleTime,
			Date receiveTime, Boolean available, String createdBy,
			Date createdAt, String changedBy, Date changedAt) {
	
		this.version = version;
		this.userId = userId;
		this.policyId = policyId;
		this.communityId = communityId;
		this.state = state;
		this.handleTime = handleTime;
		this.receiveTime = receiveTime;
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
	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "policy_id")
	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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
	@Column(name = "handle_time")
	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	@Column(name = "receive_time")
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	@Column(name = "community_id")
	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	@OneToOne
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	public RUser getUser() {
		return user;
	}


	public void setUser(RUser user) {
		this.user = user;
	}

	@OneToOne
	@JoinColumn(name="policy_id",insertable=false,updatable=false)
	public PPolicy getPolicy() {
		return policy;
	}


	public void setPolicy(PPolicy policy) {
		this.policy = policy;
	}
	
 
}