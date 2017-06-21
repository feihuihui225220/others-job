package com.anticw.aged.bean;

import java.util.Date;

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
 * PPolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_policy")
public class PPolicy implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String title;
	private String number;
	private String content;
	private Integer categoryId;
	private String certificate;
	private String conditions;
	private String conditionsPro;
	private String unit;
	private String accept;
	private Short approve;
	private Short receive;
	private String handleCond;
	private String countryId;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	/*政策类别*/
	private OCategoryItem category;
	
	// Constructors
	
	public PPolicy(Short version, String title, String number, String content,
			Integer categoryId, String certificate, String conditions,
			String unit, String accept, Short approve, Short receive,
			String handleCond, String countryId, Boolean available,
			String createdBy, Date createdAt, String changedBy, Date changedAt) {
		this.version = version;
		this.title = title;
		this.number = number;
		this.content = content;
		this.categoryId = categoryId;
		this.certificate = certificate;
		this.conditions = conditions;
		this.unit = unit;
		this.accept = accept;
		this.approve = approve;
		this.receive = receive;
		this.handleCond = handleCond;
		this.countryId = countryId;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
	}

	public PPolicy() {
		
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
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "title", nullable = false, length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "number", nullable = false, length = 20)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "category_id", nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "certificate", length = 20)
	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Column(name = "conditions", nullable = false)
	public String getConditions() {
		return this.conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the conditionsPro
	 */
	@Column(name = "conditions_pro")
	public String getConditionsPro() {
		return conditionsPro;
	}

	/**
	 * @param conditionsPro the conditionsPro to set
	 */
	public void setConditionsPro(String conditionsPro) {
		this.conditionsPro = conditionsPro;
	}

	@Column(name = "unit", nullable = false, length = 20)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "accept", nullable = false, length = 20)
	public String getAccept() {
		return this.accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	@Column(name = "handle_cond", nullable = false)
	public String getHandleCond() {
		return this.handleCond;
	}

	public void setHandleCond(String handleCond) {
		this.handleCond = handleCond;
	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = false, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = false, length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}
	@Column(name = "country_id")
	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Column(name = "approve")
	public Short getApprove() {
		return approve;
	}


	public void setApprove(Short approve) {
		this.approve = approve;
	}

	@Column(name = "receive")
	public Short getReceive() {
		return receive;
	}


	public void setReceive(Short receive) {
		this.receive = receive;
	}

	@OneToOne
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	public OCategoryItem getCategory() {
		return category;
	}

	public void setCategory(OCategoryItem category) {
		this.category = category;
	}
	

}