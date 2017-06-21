package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NVolunteerAssess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "n_volunteer_assess")
public class NVolunteerAssess implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 696762502691390584L;
	// Fields

	private long id;
	private Integer volunteer;
	private Integer activityId;
	private Short nSuper;
	private String detail;
	private Date createTime;
	private boolean available;

	// Constructors

	/** default constructor */
	public NVolunteerAssess() {
	}

	/** full constructor */
	public NVolunteerAssess(Integer volunteer, Integer activityId,
			String detail, Date createTime, boolean available) {
		this.volunteer = volunteer;
		this.activityId = activityId;
		this.detail = detail;
		this.createTime = createTime;
		this.available = available;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "volunteer")
	public Integer getVolunteer() {
		return this.volunteer;
	}

	public void setVolunteer(Integer volunteer) {
		this.volunteer = volunteer;
	}

	@Column(name = "activity_id")
	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@Column(name = "detail", length = 65535)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "available")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Column(name = "n_super")
	public Short getnSuper() {
		return nSuper;
	}

	public void setnSuper(Short nSuper) {
		this.nSuper = nSuper;
	}

	
	
}