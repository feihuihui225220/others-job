package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author DX-2016/9/26 治疗组表单
 *
 */
@Entity
@Table(name = "h_treat_user")
public class HTreatUser {

	private Integer id;
	private Integer groupId;
	private Long userId;
	private Integer state;
	private String desired;
	private Integer treatId;
	private String conclusion;
	private String createBy;
	private Date createAt;
	private String changedBy;
	private Date changedAt;

	/** default constructor */
	public HTreatUser() {

	}

	/** full constructor */
	public HTreatUser(Integer groupId, Long userId, Integer state,
			String desired, Integer treatId, String conclusion,
			String createBy, Date createAt, String changedBy, Date changedAt) {
		super();
		this.groupId = groupId;
		this.userId = userId;
		this.state = state;
		this.desired = desired;
		this.treatId = treatId;
		this.conclusion = conclusion;
		this.createBy = createBy;
		this.createAt = createAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "group_id")
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "desired")
	public String getDesired() {
		return desired;
	}

	public void setDesired(String desired) {
		this.desired = desired;
	}

	@Column(name = "treat_id")
	public Integer getTreatId() {
		return treatId;
	}

	public void setTreatId(Integer treatId) {
		this.treatId = treatId;
	}

	@Column(name = "conclusion")
	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	@Column(name = "create_By")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_at")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "changed_by")
	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at")
	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

}
