package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * MAssessAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_answer", catalog = "")
public class MAssessAnswer implements java.io.Serializable {

	/**
	 * 字段或域定义：<code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 8541635738764964463L;
	// Fields

	private Integer id;
	private Short version;
	//private Integer assessId;
	//private Integer assessQuestionId;
	private String code;
	private String content;
	private Short score;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private String aconclusion;
	
	private MAssessQuestion assessQuestion;

	// Constructors

	/** default constructor */
	public MAssessAnswer() {
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

//	@Column(name = "assess_id", nullable = false)
//	public Integer getAssessId() {
//		return this.assessId;
//	}
//
//	public void setAssessId(Integer assessId) {
//		this.assessId = assessId;
//	}

//	@Column(name = "assess_question_id", nullable = false)
//	public Integer getAssessQuestionId() {
//		return this.assessQuestionId;
//	}
//
//	public void setAssessQuestionId(Integer assessQuestionId) {
//		this.assessQuestionId = assessQuestionId;
//	}

	@Column(name = "code", nullable = false, length = 2)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "score", nullable = false)
	public Short getScore() {
		return this.score;
	}

	public void setScore(Short score) {
		this.score = score;
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

	@Column(name = "conclusion", nullable = true, length = 255)
	public String getConclusion() {
		return aconclusion;
	}

	public void setConclusion(String aconclusion) {
		this.aconclusion = aconclusion;
	}

	/**
	 * @return MAssessQuestion 取得域 assessQuestion 的方法。
	 */
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "assess_question_id")
	public MAssessQuestion getAssessQuestion() {
		return assessQuestion;
	}

	/**
	 * @param assessQuestion 对域 assessQuestion 的设置方法.
	 */
	public void setAssessQuestion(MAssessQuestion assessQuestion) {
		this.assessQuestion = assessQuestion;
	}

}