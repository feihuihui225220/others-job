package com.anticw.aged.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HGroupUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_group_user")
public class HGroupUser implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-18
	 * 功能：TODO 用户-巡诊组 分配表
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private RUser user;
	private Long groupId;
	private String groupDoctor;
	private String groupNurse;
	private String doctor;
	private String applyDoctor;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;
	private Boolean available;

	// Constructors

	/** default constructor */
	public HGroupUser() {
	}

	/** full constructor */
	public HGroupUser(RUser user, Long groupId, String groupDoctor,
			String groupNurse, String doctor, String applyDoctor,
			Timestamp createTime, String createBy, Timestamp changeTime,
			String changeBy, Boolean available) {
		super();
		this.user = user;
		this.groupId = groupId;
		this.groupDoctor = groupDoctor;
		this.groupNurse = groupNurse;
		this.doctor = doctor;
		this.applyDoctor = applyDoctor;
		this.createTime = createTime;
		this.createBy = createBy;
		this.changeTime = changeTime;
		this.changeBy = changeBy;
		this.available = available;
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

	
	@OneToOne  
    @JoinColumn(name="user_id")  
	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.user = user;
	}

	@Column(name = "group_id")
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_doctor", length = 32)
	public String getGroupDoctor() {
		return this.groupDoctor;
	}

	public void setGroupDoctor(String groupDoctor) {
		this.groupDoctor = groupDoctor;
	}

	@Column(name = "group_nurse", length = 32)
	public String getGroupNurse() {
		return this.groupNurse;
	}

	public void setGroupNurse(String groupNurse) {
		this.groupNurse = groupNurse;
	}

	@Column(name = "doctor", length = 32)
	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Column(name = "apply_doctor", length = 32)
	public String getApplyDoctor() {
		return this.applyDoctor;
	}

	public void setApplyDoctor(String applyDoctor) {
		this.applyDoctor = applyDoctor;
	}


	@Column(name = "create_by", length = 32)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	@Column(name = "change_by", length = 32)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

}