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
 * HRenalFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_renal_function")
public class HRenalFunction implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：肾功能
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String bun;
	private String cr;
	private String uricAcid;
	private String bloodSugar;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HRenalFunction() {
	}

	public HRenalFunction(String bun, String cr, String uricAcid,
			String bloodSugar) {
		super();
		this.bun = bun;
		this.cr = cr;
		this.uricAcid = uricAcid;
		this.bloodSugar = bloodSugar;
	}
	/** full constructor */
	public HRenalFunction(long userId, String bun, String cr, String uricAcid,
			String bloodSugar, Date createTime, String createBy,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.bun = bun;
		this.cr = cr;
		this.uricAcid = uricAcid;
		this.bloodSugar = bloodSugar;
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

	@Column(name = "bun", length = 32)
	public String getBun() {
		return this.bun;
	}

	public void setBun(String bun) {
		this.bun = bun;
	}

	@Column(name = "cr", length = 32)
	public String getCr() {
		return this.cr;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	@Column(name = "uric_acid", length = 32)
	public String getUricAcid() {
		return this.uricAcid;
	}

	public void setUricAcid(String uricAcid) {
		this.uricAcid = uricAcid;
	}

	@Column(name = "blood_sugar", length = 32)
	public String getBloodSugar() {
		return this.bloodSugar;
	}

	public void setBloodSugar(String bloodSugar) {
		this.bloodSugar = bloodSugar;
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