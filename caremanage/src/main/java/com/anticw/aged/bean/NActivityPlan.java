package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * n_activity_plan 活动计划 Mon Sep 07 09:39:16 CST 2015 baishuangdong
 */

@Entity
@Table(name = "n_activity_plan")
public class NActivityPlan {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "plan_name")
	private String planName;

	@Column(name = "plan_desc")
	private String planDesc;

	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "volunteer_id")
	private String volunteerId;

	@Column(name = "pubdate")
	private Date pubdate;

	@Column(name = "avaliable")
	private boolean avaliable;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "changed_by")
	private String changedBy;

	@Column(name = "changed_at")
	private Date changedAt;

	@Column(name = "version")
	private short version;

	@Column(name = "remark")
	private String remark;

	@Column(name = "plan_age")
	private String planAge;

	@Column(name = "plan_time")
	private String planTime;

	@Column(name = "plan_min")
	private Float planMin;

	@Column(name = "plan_place")
	private String planPlace;

	@Column(name = "siteIds")
	private String siteIds;

	@Column(name = "vender_id")
	private Integer venderId;

	@OneToMany(mappedBy = "nActivityPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<NactivityProgramOfEvents> nactivityProgramOfEvents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
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

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public String getPlanAge() {
		return planAge;
	}

	public void setPlanAge(String planAge) {
		this.planAge = planAge;
	}

	public String getPlanPlace() {
		return planPlace;
	}

	public void setPlanPlace(String planPlace) {
		this.planPlace = planPlace;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public Float getPlanMin() {
		return planMin;
	}

	public void setPlanMin(Float planMin) {
		this.planMin = planMin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(String siteIds) {

		this.siteIds = siteIds;
	}

	public Set<NactivityProgramOfEvents> getNactivityProgramOfEvents() {
		return nactivityProgramOfEvents;
	}

	public void setNactivityProgramOfEvents(
			Set<NactivityProgramOfEvents> nactivityProgramOfEvents) {
		this.nactivityProgramOfEvents = nactivityProgramOfEvents;
	}

	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	@Override
	public String toString() {
		return "NActivityPlan [id=" + id + ", planName=" + planName
				+ ", planDesc=" + planDesc + ", employeeId=" + employeeId
				+ ", volunteerId=" + volunteerId + ", pubdate=" + pubdate
				+ ", avaliable=" + avaliable + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", changedBy=" + changedBy
				+ ", changedAt=" + changedAt + ", version=" + version
				+ ", remark=" + remark + ", planAge=" + planAge + ", planTime="
				+ planTime + ", planMin=" + planMin + ", planPlace="
				+ planPlace + ", siteIds=" + siteIds + ", venderId=" + venderId
				+ ", nactivityProgramOfEvents=" + nactivityProgramOfEvents
				+ "]";
	}
	
	

}
