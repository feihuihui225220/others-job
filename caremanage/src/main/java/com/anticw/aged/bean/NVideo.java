package com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


   /**
    * n_video 视频
    * Mon Sep 07 09:40:35 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_video")
public class NVideo{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
 
	@Column(name = "program_id" )
	private int programId;
	
	@Column(name = "file_name" )
	private String fileName;
	
	@Column(name = "file_url" )
	private String fileUrl;
	
	@Column(name = "create_id" )
	private int createId;
	
	@Column(name = "img_url" )
	private String imgUrl;
	
	@Column(name = "avaliable" )
	private boolean avaliable;
	
	@Column(name = "created_by" , length = 40)
	private String createdBy;
	
	@Column(name = "created_at" )
	private Date createdAt;
	
	@Column(name = "changed_by" , length = 40)
	private String changedBy;
	
	@Column(name = "changed_at" )
	private Date changedAt;
	
	@Column(name = "version" )
	private short version;

	@Column(name="descript")
	private String descript;
	
	public NVideo() {
		super();
	}

	public NVideo(int programId, String fileName, String fileUrl,
			int createId, String imgUrl, boolean avaliable, String createdBy,
			Date createdAt, String changedBy, Date changedAt, short version,
			String descript) {
		super();
		this.programId = programId;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.createId = createId;
		this.imgUrl = imgUrl;
		this.avaliable = avaliable;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
		this.descript = descript;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public int getCreateId() {
		return createId;
	}

	public void setCreateId(int createId) {
		this.createId = createId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	 
}

