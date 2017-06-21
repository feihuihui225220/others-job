package com.anticw.aged.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * ZActive entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_active")
public class ZActive {

	// Fields

	private Long id;
	private Long userId;
	private String activeName;
	private String activeTime;
	private String activeDesc;
	private String activeLxr;
	private String activePhone;
	private String createBy;
	private Date createAt;
	private String changgeBy;
	private Date changgeAt;
	private Boolean avaliable;
	private String activePoster;
	private String activerReadings;
	private Integer state;
	private Date startTime;
	private Date endTime;
	// Constructors
	@Column(name = "state", length = 10)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/** default constructor */
	public ZActive() {
	}

	/** full constructor */
	public ZActive(Long userId, String activeName, String activeTime,
			String activeDesc, String activeLxr, String activePhone,
			String createBy, Timestamp createAt, String changgeBy,
			Timestamp changgeAt, Boolean avaliable, String activePoster,
			String activerReadings, Integer state,Date startTime,Date endTime) {
		this.userId = userId;
		this.activeName = activeName;
		this.activeTime = activeTime;
		this.activeDesc = activeDesc;
		this.activeLxr = activeLxr;
		this.activePhone = activePhone;
		this.createBy = createBy;
		this.createAt = createAt;
		this.changgeBy = changgeBy;
		this.changgeAt = changgeAt;
		this.avaliable = avaliable;
		this.activePoster = activePoster;
		this.activerReadings = activerReadings;
		this.state = state;
		this.startTime=startTime;
		this.endTime=endTime;
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
	@Column(name = "start_time")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Column(name = "end_time")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "user_id", length = 20)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "active_name", length = 50)
	public String getActiveName() {
		return this.activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	@Column(name = "active_time", length = 50)
	public String getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	
	@Basic(fetch = FetchType.LAZY)   
	@Type(type="text")  
	@Column(name = "active_desc")
	public String getActiveDesc() {
		return this.activeDesc;
	}

	public void setActiveDesc(String activeDesc) {
		this.activeDesc = activeDesc;
	}

	@Column(name = "active_lxr", length = 50)
	public String getActiveLxr() {
		return this.activeLxr;
	}

	public void setActiveLxr(String activeLxr) {
		this.activeLxr = activeLxr;
	}

	@Column(name = "active_phone", length = 11)
	public String getActivePhone() {
		return this.activePhone;
	}

	public void setActivePhone(String activePhone) {
		this.activePhone = activePhone;
	}

	@Column(name = "create_by", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "changge_by", length = 50)
	public String getChanggeBy() {
		return this.changgeBy;
	}

	public void setChanggeBy(String changgeBy) {
		this.changgeBy = changgeBy;
	}

	@Column(name = "changge_at", length = 19)
	public Date getChanggeAt() {
		return this.changgeAt;
	}

	public void setChanggeAt(Date changgeAt) {
		this.changgeAt = changgeAt;
	}

	@Column(name = "avaliable")
	public Boolean getAvaliable() {
		return this.avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Column(name = "active_poster")
	public String getActivePoster() {
		return this.activePoster;
	}

	public void setActivePoster(String activePoster) {
		this.activePoster = activePoster;
	}

	@Column(name = "activer_readings")
	public String getActiverReadings() {
		return this.activerReadings;
	}

	public void setActiverReadings(String activerReadings) {
		this.activerReadings = activerReadings;
	}

}