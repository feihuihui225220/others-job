package com.anticw.aged.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MUserIntervene entity. @author dx
 * 用户进行分析时，获取的归一化数据
 */
@Entity
@Table(name = "m_user_intervene")
public class MUserIntervene implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7072543605389160756L;
	private Long personId;
	private Double interveneGo;//干预前
	private Double interveneLa;//干预后
	private Long userId;
	private Integer packetTypes;//分组
	private Integer testCategory;//选项{肌力，血压等}
	private String createdBy;
	private Date createdAt;

	// Constructors

	/** default constructor */
	public MUserIntervene() {
	}

	/** full constructor */
	public MUserIntervene(Double interveneGo, Double interveneLa, Long userId,
			Integer packetTypes, Integer testCategory, String createdBy,
			Date createdAt) {
		this.interveneGo = interveneGo;
		this.interveneLa = interveneLa;
		this.userId = userId;
		this.packetTypes = packetTypes;
		this.testCategory = testCategory;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "person_id", unique = true, nullable = false)
	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@Column(name = "intervene_go", precision = 22, scale = 0)
	public Double getInterveneGo() {
		return this.interveneGo;
	}

	public void setInterveneGo(Double interveneGo) {
		this.interveneGo = interveneGo;
	}

	@Column(name = "intervene_la", precision = 22, scale = 0)
	public Double getInterveneLa() {
		return this.interveneLa;
	}

	public void setInterveneLa(Double interveneLa) {
		this.interveneLa = interveneLa;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "packet_types")
	public Integer getPacketTypes() {
		return this.packetTypes;
	}

	public void setPacketTypes(Integer packetTypes) {
		this.packetTypes = packetTypes;
	}

	@Column(name = "test_category")
	public Integer getTestCategory() {
		return this.testCategory;
	}

	public void setTestCategory(Integer testCategory) {
		this.testCategory = testCategory;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date date) {
		this.createdAt = date;
	}

}