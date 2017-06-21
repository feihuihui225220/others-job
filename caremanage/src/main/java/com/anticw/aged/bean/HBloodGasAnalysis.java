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
 * HBloodGasAnalysis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_blood_gas_analysis")
public class HBloodGasAnalysis implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：TODO血气分析
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String ph;
	private String po2;
	private String pco2;
	private String standardBicarbonate;
	private String bufferBase;
	private String residualAlkali;
	private String oxygenSaturation;
	private String hydrogenIonConcentration;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HBloodGasAnalysis() {
	}
	
	public HBloodGasAnalysis(String ph, String po2, String pco2,
			String standardBicarbonate, String bufferBase, String residualAlkali, String oxygenSaturation,
			String hydrogenIonConcentration) {
		super();
		this.ph = ph;
		this.po2 = po2;
		this.pco2 = pco2;
		this.standardBicarbonate = standardBicarbonate;
		this.bufferBase = bufferBase;
		this.residualAlkali = residualAlkali;
		this.oxygenSaturation = oxygenSaturation;
		this.hydrogenIonConcentration = hydrogenIonConcentration;
	}

	/** full constructor */
	public HBloodGasAnalysis(long userId, String ph, String po2, String pco2,
			String standardBicarbonate, String bufferBase,
			String residualAlkali, String oxygenSaturation,
			String hydrogenIonConcentration, Date createTime, String createBy,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.ph = ph;
		this.po2 = po2;
		this.pco2 = pco2;
		this.standardBicarbonate = standardBicarbonate;
		this.bufferBase = bufferBase;
		this.residualAlkali = residualAlkali;
		this.oxygenSaturation = oxygenSaturation;
		this.hydrogenIonConcentration = hydrogenIonConcentration;
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

	@Column(name = "ph", length = 32)
	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Column(name = "po2", length = 32)
	public String getPo2() {
		return this.po2;
	}

	public void setPo2(String po2) {
		this.po2 = po2;
	}

	@Column(name = "pco2", length = 32)
	public String getPco2() {
		return this.pco2;
	}

	public void setPco2(String pco2) {
		this.pco2 = pco2;
	}

	@Column(name = "standard_bicarbonate", length = 32)
	public String getStandardBicarbonate() {
		return this.standardBicarbonate;
	}

	public void setStandardBicarbonate(String standardBicarbonate) {
		this.standardBicarbonate = standardBicarbonate;
	}

	@Column(name = "buffer_base", length = 32)
	public String getBufferBase() {
		return this.bufferBase;
	}

	public void setBufferBase(String bufferBase) {
		this.bufferBase = bufferBase;
	}

	@Column(name = "residual_alkali", length = 32)
	public String getResidualAlkali() {
		return this.residualAlkali;
	}

	public void setResidualAlkali(String residualAlkali) {
		this.residualAlkali = residualAlkali;
	}

	@Column(name = "oxygen_saturation", length = 32)
	public String getOxygenSaturation() {
		return this.oxygenSaturation;
	}

	public void setOxygenSaturation(String oxygenSaturation) {
		this.oxygenSaturation = oxygenSaturation;
	}

	@Column(name = "hydrogen_ion_concentration", length = 32)
	public String getHydrogenIonConcentration() {
		return this.hydrogenIonConcentration;
	}

	public void setHydrogenIonConcentration(String hydrogenIonConcentration) {
		this.hydrogenIonConcentration = hydrogenIonConcentration;
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