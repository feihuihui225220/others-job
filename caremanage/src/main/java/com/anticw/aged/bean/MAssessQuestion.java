package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

/**
 * MAssessQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_question")
public class MAssessQuestion implements java.io.Serializable {

	private static final long serialVersionUID = -41145098061640636L;
	
	// Fields
	private Integer id;
	private Short version;
	private Integer assessId;
	private String content;
	private String picture;
	private Boolean available;
	private Boolean assessType;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	private Set<MAssessAnswer> assessAnswers;

	// Constructors

	/** default constructor */
	public MAssessQuestion() {
	}

	/** minimal constructor */
	public MAssessQuestion(Integer assessId, String content, Boolean available, String createdBy, Date createdAt, String changedBy,
			Date changedAt) {
		this.assessId = assessId;
		this.content = content;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
	}

	@Column(name = "assessType", nullable = true)
	public Boolean getAssessType() {
		return assessType;
	}

	public void setAssessType(Boolean assessType) {
		this.assessType = assessType;
	}


	/** full constructor */
	public MAssessQuestion(Integer assessId, String content, String picture, Boolean available, String createdBy, Date createdAt,
			String changedBy, Date changedAt) {
		this.assessId = assessId;
		this.content = content;
		this.picture = picture;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
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

	@Column(name = "assess_id", nullable = false)
	public Integer getAssessId() {
		return this.assessId;
	}

	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}

	@Column(name = "content", nullable = false, length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "picture", length = 500)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	/**
	 * @return Set<MAssessAnswer> 取得域 assessAnswers 的方法。
	 */
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "assessQuestion")
	@Where(clause="available=1")
	@OrderBy(value="code ASC")
	public Set<MAssessAnswer> getAssessAnswers() {
		return assessAnswers;
	}

	/**
	 * @param assessAnswers 对域 assessAnswers 的设置方法.
	 */
	public void setAssessAnswers(Set<MAssessAnswer> assessAnswers) {
		this.assessAnswers = assessAnswers;
	}
}