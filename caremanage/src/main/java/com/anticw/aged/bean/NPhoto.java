package  com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


   /**
    * n_photo  照片集
    * Mon Sep 07 09:38:35 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_photo")
public class NPhoto{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "photo_name",nullable = true)
	private String photoName;
	
	@Column(name = "photo_desc",nullable = true)
	private String photoDesc;
	
	@Column(name = "photo_url",nullable = false)
	private String photoUrl;
	
	@Column(name = "album_id",nullable = false)
	private int albumId;
	
	@Column(name = "avaliable", nullable = false)
	private boolean avaliable;
	
	@Column(name = "created_by", nullable = false, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = true, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = true)
	private Date changedAt;
	
	@Column(name = "version", nullable = false)
	private short version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoDesc() {
		return photoDesc;
	}

	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
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

	@Override
	public String toString() {
		return "NPhoto [photoName=" + photoName + ", photoDesc=" + photoDesc
				+ ", photoUrl=" + photoUrl + ", albumId=" + albumId
				+ ", avaliable=" + avaliable + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", changedBy=" + changedBy
				+ ", changedAt=" + changedAt + ", version=" + version + "]";
	}
    
	 
}

