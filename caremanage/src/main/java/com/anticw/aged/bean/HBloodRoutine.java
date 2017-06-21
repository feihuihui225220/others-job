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
 * HBloodRoutine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_blood_routine")
public class HBloodRoutine implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：血常规
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer version;
	private long userId;
	private String whiteBloodCell;
	private String neutrophilicGranulocyte;
	private String eosinophileGranulocyte;
	private String basophileGranulocyte;
	private String monocyte;
	private String lymphocyte;
	private String redBloodCell;
	private String hemoglobin;
	private String platelet;
	private String esr;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HBloodRoutine() {
	}
	
	public HBloodRoutine(String whiteBloodCell, String neutrophilicGranulocyte,
			String eosinophileGranulocyte, String basophileGranulocyte,
			String monocyte, String lymphocyte, String redBloodCell,
			String hemoglobin, String platelet, String esr) {
		super();
		this.whiteBloodCell = whiteBloodCell;
		this.neutrophilicGranulocyte = neutrophilicGranulocyte;
		this.eosinophileGranulocyte = eosinophileGranulocyte;
		this.basophileGranulocyte = basophileGranulocyte;
		this.monocyte = monocyte;
		this.lymphocyte = lymphocyte;
		this.redBloodCell = redBloodCell;
		this.hemoglobin = hemoglobin;
		this.platelet = platelet;
		this.esr = esr;
	}

	/** full constructor */
	public HBloodRoutine(long userId, String whiteBloodCell,
			String neutrophilicGranulocyte, String eosinophileGranulocyte,
			String basophileGranulocyte, String monocyte, String lymphocyte,
			String redBloodCell, String hemoglobin, String platelet,
			String esr, Date createTime, String createBy, Date changeTime,
			String changeBy) {
		this.userId = userId;
		this.whiteBloodCell = whiteBloodCell;
		this.neutrophilicGranulocyte = neutrophilicGranulocyte;
		this.eosinophileGranulocyte = eosinophileGranulocyte;
		this.basophileGranulocyte = basophileGranulocyte;
		this.monocyte = monocyte;
		this.lymphocyte = lymphocyte;
		this.redBloodCell = redBloodCell;
		this.hemoglobin = hemoglobin;
		this.platelet = platelet;
		this.esr = esr;
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

	@Column(name = "white_blood_cell", length = 32)
	public String getWhiteBloodCell() {
		return this.whiteBloodCell;
	}

	public void setWhiteBloodCell(String whiteBloodCell) {
		this.whiteBloodCell = whiteBloodCell;
	}

	@Column(name = "neutrophilic_granulocyte", length = 32)
	public String getNeutrophilicGranulocyte() {
		return this.neutrophilicGranulocyte;
	}

	public void setNeutrophilicGranulocyte(String neutrophilicGranulocyte) {
		this.neutrophilicGranulocyte = neutrophilicGranulocyte;
	}

	@Column(name = "eosinophile_granulocyte", length = 32)
	public String getEosinophileGranulocyte() {
		return this.eosinophileGranulocyte;
	}

	public void setEosinophileGranulocyte(String eosinophileGranulocyte) {
		this.eosinophileGranulocyte = eosinophileGranulocyte;
	}

	@Column(name = "basophile_granulocyte", length = 32)
	public String getBasophileGranulocyte() {
		return this.basophileGranulocyte;
	}

	public void setBasophileGranulocyte(String basophileGranulocyte) {
		this.basophileGranulocyte = basophileGranulocyte;
	}

	@Column(name = "monocyte", length = 32)
	public String getMonocyte() {
		return this.monocyte;
	}

	public void setMonocyte(String monocyte) {
		this.monocyte = monocyte;
	}

	@Column(name = "lymphocyte", length = 32)
	public String getLymphocyte() {
		return this.lymphocyte;
	}

	public void setLymphocyte(String lymphocyte) {
		this.lymphocyte = lymphocyte;
	}

	@Column(name = "red_blood_cell", length = 32)
	public String getRedBloodCell() {
		return this.redBloodCell;
	}

	public void setRedBloodCell(String redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	@Column(name = "hemoglobin", length = 32)
	public String getHemoglobin() {
		return this.hemoglobin;
	}

	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	@Column(name = "platelet", length = 32)
	public String getPlatelet() {
		return this.platelet;
	}

	public void setPlatelet(String platelet) {
		this.platelet = platelet;
	}

	@Column(name = "esr", length = 32)
	public String getEsr() {
		return this.esr;
	}

	public void setEsr(String esr) {
		this.esr = esr;
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