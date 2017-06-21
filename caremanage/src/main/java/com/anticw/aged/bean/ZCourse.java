package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_course")
public class ZCourse {

	// Fields

	private Integer courseId;
	private long userId;
	private Integer programId;
	private Date customAt;
	private Date startAt;
	private Date endAt;
	private Date createAt;
	private String createBy;
	private Date changeAt;
	private String changeBy;
	private boolean available;

	// Constructors

	/** default constructor */
	public ZCourse() {
	}

	/** full constructor */
	public ZCourse(long userId, Integer programId, Date customAt, Date startAt,
			Date endAt, Date createAt, String createBy, Date changeAt,
			String changeBy, boolean available) {
		this.userId = userId;
		this.programId = programId;
		this.customAt = customAt;
		this.startAt = startAt;
		this.endAt = endAt;
		this.createAt = createAt;
		this.createBy = createBy;
		this.changeAt = changeAt;
		this.changeBy = changeBy;
		this.available = available;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "program_id")
	public Integer getProgramId() {
		return this.programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	@Column(name = "custom_at", length = 19)
	public Date getCustomAt() {
		return this.customAt;
	}

	public void setCustomAt(Date customAt) {
		this.customAt = customAt;
	}

	@Column(name = "start_at", length = 19)
	public Date getStartAt() {
		return this.startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	@Column(name = "end_at", length = 19)
	public Date getEndAt() {
		return this.endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "create_by", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_at", length = 19)
	public Date getChangeAt() {
		return this.changeAt;
	}

	public void setChangeAt(Date changeAt) {
		this.changeAt = changeAt;
	}

	@Column(name = "change_by", length = 50)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "available")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}