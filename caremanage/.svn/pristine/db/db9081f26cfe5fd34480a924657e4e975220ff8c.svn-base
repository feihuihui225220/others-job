package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_group")
public class HGroup implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-16
	 * 功能：巡诊组
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private String userName;
	private String doctor;
	private String nurse;
	private String community;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;
	private boolean available;

	// Constructors

	/** default constructor */
	public HGroup() {
	}

	/** full constructor */
	public HGroup(String doctor, String nurse, String community,
			Date createTime, String createBy, Date changeTime, String changeBy,
			boolean available) {
		this.doctor = doctor;
		this.nurse = nurse;
		this.community = community;
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

	@Column(name = "doctor", length = 64)
	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Column(name = "nurse", length = 64)
	public String getNurse() {
		return this.nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	@Column(name = "community", length = 128)
	public String getCommunity() {
		return this.community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_by", length = 32)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_by", length = 32)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}