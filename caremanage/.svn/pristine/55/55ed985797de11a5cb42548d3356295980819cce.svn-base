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
 * HElectrolyte entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_electrolyte")
public class HElectrolyte implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：电解质
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer version;
	private long userId;
	private String potassium;
	private String sodium;
	private String chlorine;
	private String calcium;
	private String phosphorus;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HElectrolyte() {
	}

	public HElectrolyte(String potassium, String sodium, String chlorine,
			String calcium, String phosphorus) {
		super();
		this.potassium = potassium;
		this.sodium = sodium;
		this.chlorine = chlorine;
		this.calcium = calcium;
		this.phosphorus = phosphorus;
		
	}
	/** full constructor */
	public HElectrolyte(long userId, String potassium, String sodium,
			String chlorine, String calcium, String phosphorus,
			Date createTime, String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.potassium = potassium;
		this.sodium = sodium;
		this.chlorine = chlorine;
		this.calcium = calcium;
		this.phosphorus = phosphorus;
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

	@Column(name = "potassium", length = 32)
	public String getPotassium() {
		return this.potassium;
	}

	public void setPotassium(String potassium) {
		this.potassium = potassium;
	}

	@Column(name = "sodium", length = 32)
	public String getSodium() {
		return this.sodium;
	}

	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	@Column(name = "chlorine", length = 32)
	public String getChlorine() {
		return this.chlorine;
	}

	public void setChlorine(String chlorine) {
		this.chlorine = chlorine;
	}

	@Column(name = "calcium", length = 32)
	public String getCalcium() {
		return this.calcium;
	}

	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}

	@Column(name = "phosphorus", length = 32)
	public String getPhosphorus() {
		return this.phosphorus;
	}

	public void setPhosphorus(String phosphorus) {
		this.phosphorus = phosphorus;
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