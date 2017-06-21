package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * MAssessRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_record", catalog = "")
public class MAssessRecord implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "assess_id", nullable = false)
	private Integer assessId;
	
	@Column(name = "assess_name", nullable = false, length = 60)
	private String assessName;
	
	@Column(name = "con_id", nullable = false)
	private Integer conId;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "con_content", nullable = false, length = 65535)
	private String conContent;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "created_by", nullable = false, length = 40)
	private String createdBy;
	
	// Constructors

	/** default constructor */
	public MAssessRecord() {
	}

	/**
	 * @return Long 取得域 id 的方法。
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Long 取得域 userId 的方法。
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return Integer 取得域 assessId 的方法。
	 */
	public Integer getAssessId() {
		return assessId;
	}

	/**
	 * @param assessId 对域 assessId 的设置方法.
	 */
	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}

	/**
	 * @return String 取得域 assessName 的方法。
	 */
	public String getAssessName() {
		return assessName;
	}

	/**
	 * @param assessName 对域 assessName 的设置方法.
	 */
	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}

	/**
	 * @return Integer 取得域 conId 的方法。
	 */
	public Integer getConId() {
		return conId;
	}

	/**
	 * @param conId 对域 conId 的设置方法.
	 */
	public void setConId(Integer conId) {
		this.conId = conId;
	}

	/**
	 * @return String 取得域 conContent 的方法。
	 */
	public String getConContent() {
		return conContent;
	}

	/**
	 * @param conContent 对域 conContent 的设置方法.
	 */
	public void setConContent(String conContent) {
		this.conContent = conContent;
	}

	/**
	 * @return Date 取得域 createdAt 的方法。
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt 对域 createdAt 的设置方法.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return String 取得域 createdBy 的方法。
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy 对域 createdBy 的设置方法.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}