package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author dx  2015.10.14 培训记录表
 *
 */
@Entity
@Table(name = "n_volunteer_train")
public class NVolunteerTrain {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "theme", nullable = true)
	private String theme;
	
	@Column(name = "train_content", nullable = true)
	private String trainContent;
	
	@Column(name = "train_place",  nullable = true)
	private String trainPlace;
	
	@Column(name = "train_times",  nullable = true)
	private Float trainTimes;
	
	@Column(name = "site_ids",  nullable = true)
	private String siteIds;
	
	@Column(name = "community_ids",  nullable = true)
	private String communityIds;
	
	@Temporal(TemporalType.TIMESTAMP)//日期类型(DATA,TIME,TIMESTAMP)  
	@Column(name = "end_time",  nullable = true)
	private Date endTime;
	
	@Temporal(TemporalType.TIMESTAMP)//日期类型(DATA,TIME,TIMESTAMP)  
	@Column(name = "train_date",  nullable = true)
	private Date traindate;
	
	@Column(name = "avaliable", nullable = true)
	private boolean avaliable;
	
	@Column(name = "created_by", nullable = true, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = true)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = true, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = true)
	private Date changedAt;
	
	@Column(name = "version", nullable = true)
	private short version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public String getTrainPlace() {
		return trainPlace;
	}

	public void setTrainPlace(String trainPlace) {
		this.trainPlace = trainPlace;
	}

	public Float getTrainTimes() {
		return trainTimes;
	}

	public void setTrainTimes(Float trainTimes) {
		this.trainTimes = trainTimes;
	}

	public Date getTraindate() {
		return traindate;
	}

	public void setTraindate(Date traindate) {
		this.traindate = traindate;
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

	public String getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(String siteIds) {
		this.siteIds = siteIds;
	}

	public String getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
}
