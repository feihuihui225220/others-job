package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MVenderIntervene entity. @author dx
 * 用户进行分析时，获取的最终计算值
 */
@Entity
@Table(name = "m_vender_intervene")
public class MVenderIntervene implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2590391178177505879L;
	private Long id;
	private Integer group1;
	private Integer group2;
	private Integer itemizeId;
	private Integer twoFactor;
	private Integer minorTerm;
	private Double AValue;
	private Double average;
	private Integer verifyMode;
	private Double testValue1;
	private Double testValue2;
	private Double testValue3;
	private Double criticalValue1;
	private Double criticalValue2;
	private Double criticalValue3;
	private Date createdAt;
	private String createdBy;

	// Constructors

	/** default constructor */
	public MVenderIntervene() {
	}

	/** full constructor */
	public MVenderIntervene(Integer group1, Integer group2, Integer itemizeId,
			Integer twoFactor, Double aValue, Double average,
			Integer verifyMode, Double testValue1, Double testValue2,
			Double testValue3, Double criticalValue1, Double criticalValue2,
			Double criticalValue3, Date createdAt, String createdBy) {
		super();
		this.group1 = group1;
		this.group2 = group2;
		this.itemizeId = itemizeId;
		this.twoFactor = twoFactor;
		AValue = aValue;
		this.average = average;
		this.verifyMode = verifyMode;
		this.testValue1 = testValue1;
		this.testValue2 = testValue2;
		this.testValue3 = testValue3;
		this.criticalValue1 = criticalValue1;
		this.criticalValue2 = criticalValue2;
		this.criticalValue3 = criticalValue3;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "group_1")
	public Integer getGroup1() {
		return this.group1;
	}

	public void setGroup1(Integer group1) {
		this.group1 = group1;
	}

	@Column(name = "group_2")
	public Integer getGroup2() {
		return this.group2;
	}

	public void setGroup2(Integer group2) {
		this.group2 = group2;
	}

	@Column(name = "itemize_id")
	public Integer getItemizeId() {
		return this.itemizeId;
	}

	public void setItemizeId(Integer itemizeId) {
		this.itemizeId = itemizeId;
	}

	@Column(name = "two_factor")
	public Integer getTwoFactor() {
		return this.twoFactor;
	}

	public void setTwoFactor(Integer twoFactor) {
		this.twoFactor = twoFactor;
	}

	@Column(name = "a_value", precision = 22, scale = 0)
	public Double getAValue() {
		return this.AValue;
	}

	public void setAValue(Double AValue) {
		this.AValue = AValue;
	}

	@Column(name = "verify_mode")
	public Integer getVerifyMode() {
		return this.verifyMode;
	}

	public void setVerifyMode(Integer verifyMode) {
		this.verifyMode = verifyMode;
	}

	@Column(name = "test_value1", precision = 22, scale = 0)
	public Double getTestValue1() {
		return this.testValue1;
	}

	public void setTestValue1(Double testValue1) {
		this.testValue1 = testValue1;
	}

	@Column(name = "test_value2", precision = 22, scale = 0)
	public Double getTestValue2() {
		return this.testValue2;
	}

	public void setTestValue2(Double testValue2) {
		this.testValue2 = testValue2;
	}

	@Column(name = "test_value3", precision = 22, scale = 0)
	public Double getTestValue3() {
		return this.testValue3;
	}

	public void setTestValue3(Double testValue3) {
		this.testValue3 = testValue3;
	}

	@Column(name = "critical_value1", precision = 22, scale = 0)
	public Double getCriticalValue1() {
		return this.criticalValue1;
	}

	public void setCriticalValue1(Double criticalValue1) {
		this.criticalValue1 = criticalValue1;
	}

	@Column(name = "critical_value2", precision = 22, scale = 0)
	public Double getCriticalValue2() {
		return this.criticalValue2;
	}

	public void setCriticalValue2(Double criticalValue2) {
		this.criticalValue2 = criticalValue2;
	}

	@Column(name = "critical_value3", precision = 22, scale = 0)
	public Double getCriticalValue3() {
		return this.criticalValue3;
	}

	public void setCriticalValue3(Double criticalValue3) {
		this.criticalValue3 = criticalValue3;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", length = 25)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "average")
	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
	
	@Column(name="minor_term")
	public Integer getMinorTerm() {
		return minorTerm;
	}

	public void setMinorTerm(Integer minorTerm) {
		this.minorTerm = minorTerm;
	}
	
	

}