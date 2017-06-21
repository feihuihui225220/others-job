package com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

   /**
    * n_album 相册
    * Mon Sep 07 09:36:42 CST 2015   baishuangdong
    */ 

@Entity
@Table(name = "n_album")
public class NAlbum{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "album_name", nullable = false)
	private String albumName;
	
	@Column(name = "album_desc", nullable = true)
	private String albumDesc;
	
	@Column(name = "album_url", nullable = true)
	private String albumUrl;
	
	@Column(name = "activity_id", nullable = true)
	private int activityId;

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

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumDesc() {
		return albumDesc;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
	 
}

