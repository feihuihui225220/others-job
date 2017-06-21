package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * RUserDefault entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "r_user_default")
public class RUserDefault implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private RUser rUser;
	private String doctor;
	private String nurse;
	private String weight;
	private String height;
	private String costType;
	private String positionHospital;
	private String smoking;
	private String drinking;
	private String eating;
	private String allergy;
	private String trouble;
	private String medicalHistory;
	private String family;
	private String disease;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public RUserDefault() {
	}

	/** full constructor */
	

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public RUserDefault(Integer version, RUser rUser, String doctor,
			String nurse, String weight, String height, String costType,
			String positionHospital, String smoking, String drinking,
			String eating, String allergy, String trouble,
			String medicalHistory, String family, Date createTime,
			String createBy, Date changeTime, String changeBy) {
		super();
		this.version = version;
		this.rUser = rUser;
		this.doctor = doctor;
		this.nurse = nurse;
		this.weight = weight;
		this.height = height;
		this.costType = costType;
		this.positionHospital = positionHospital;
		this.smoking = smoking;
		this.drinking = drinking;
		this.eating = eating;
		this.allergy = allergy;
		this.trouble = trouble;
		this.medicalHistory = medicalHistory;
		this.family = family;
		this.createTime = createTime;
		this.createBy = createBy;
		this.changeTime = changeTime;
		this.changeBy = changeBy;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public RUser getrUser() {
		return rUser;
	}

	public void setrUser(RUser rUser) {
		this.rUser = rUser;
	}

	@Column(name = "doctor", length = 16)
	public String getDoctor() {
		return this.doctor;
	}


	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Column(name = "nurse", length = 16)
	public String getNurse() {
		return this.nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	@Column(name = "weight", length = 8)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "height", length = 8)
	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "cost_type", length = 20)
	public String getCostType() {
		return this.costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	@Column(name = "position_hospital", length = 16)
	public String getPositionHospital() {
		return this.positionHospital;
	}

	public void setPositionHospital(String positionHospital) {
		this.positionHospital = positionHospital;
	}

	@Column(name = "smoking", length = 16)
	public String getSmoking() {
		return this.smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	@Column(name = "drinking", length = 16)
	public String getDrinking() {
		return this.drinking;
	}

	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	@Column(name = "eating", length = 16)
	public String getEating() {
		return this.eating;
	}

	public void setEating(String eating) {
		this.eating = eating;
	}

	@Column(name = "allergy", length = 16)
	public String getAllergy() {
		return this.allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	@Column(name = "trouble", length = 16)
	public String getTrouble() {
		return this.trouble;
	}

	public void setTrouble(String trouble) {
		this.trouble = trouble;
	}

	@Column(name = "medical_history", length = 16)
	public String getMedicalHistory() {
		return this.medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	@Column(name = "family", length = 32)
	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}
	@Column(name = "disease", length = 255)
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
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