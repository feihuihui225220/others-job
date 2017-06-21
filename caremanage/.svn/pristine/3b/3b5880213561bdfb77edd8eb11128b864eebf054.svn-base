package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * HBloodFat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_blood_fat")
public class HBloodFat implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：血脂
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer version;
	private long userId;
	private String triglyceride;
	private String cholesterol;
	private String freeFattyAcids;
	private String bileAcid;
	private String hdl;
	private String ldl;
	private String ketone;
	private String phospholipid;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HBloodFat() {
	}
	
	public HBloodFat(String triglyceride, String cholesterol, String freeFattyAcids,
			String bileAcid, String hdl, String ldl, String ketone,
			String phospholipid) {
		super();
		this.triglyceride = triglyceride;
		this.cholesterol = cholesterol;
		this.freeFattyAcids = freeFattyAcids;
		this.bileAcid = bileAcid;
		this.hdl = hdl;
		this.ldl = ldl;
		this.ketone = ketone;
		this.phospholipid = phospholipid;
	}


	/** full constructor */
	public HBloodFat(long userId, String triglyceride, String cholesterol,
			String freeFattyAcids, String bileAcid, String hdl, String ldl,
			String ketone, String phospholipid, Date createTime,
			String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.triglyceride = triglyceride;
		this.cholesterol = cholesterol;
		this.freeFattyAcids = freeFattyAcids;
		this.bileAcid = bileAcid;
		this.hdl = hdl;
		this.ldl = ldl;
		this.ketone = ketone;
		this.phospholipid = phospholipid;
		this.createTime = createTime;
		this.createBy = createBy;
		this.changeTime = changeTime;
		this.changeBy = changeBy;
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

	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "triglyceride", length = 32)
	public String getTriglyceride() {
		return this.triglyceride;
	}

	public void setTriglyceride(String triglyceride) {
		this.triglyceride = triglyceride;
	}

	@Column(name = "cholesterol", length = 32)
	public String getCholesterol() {
		return this.cholesterol;
	}

	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}

	@Column(name = "free_fatty_acids", length = 32)
	public String getFreeFattyAcids() {
		return this.freeFattyAcids;
	}

	public void setFreeFattyAcids(String freeFattyAcids) {
		this.freeFattyAcids = freeFattyAcids;
	}

	@Column(name = "bile_acid", length = 32)
	public String getBileAcid() {
		return this.bileAcid;
	}

	public void setBileAcid(String bileAcid) {
		this.bileAcid = bileAcid;
	}

	@Column(name = "hdl", length = 32)
	public String getHdl() {
		return this.hdl;
	}

	public void setHdl(String hdl) {
		this.hdl = hdl;
	}

	@Column(name = "ldl", length = 32)
	public String getLdl() {
		return this.ldl;
	}

	public void setLdl(String ldl) {
		this.ldl = ldl;
	}

	@Column(name = "ketone", length = 32)
	public String getKetone() {
		return this.ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}

	@Column(name = "phospholipid", length = 32)
	public String getPhospholipid() {
		return this.phospholipid;
	}

	public void setPhospholipid(String phospholipid) {
		this.phospholipid = phospholipid;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_by", length = 16)
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

	@Column(name = "change_by", length = 16)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

}