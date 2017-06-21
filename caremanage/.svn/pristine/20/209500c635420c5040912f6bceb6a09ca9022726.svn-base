package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

/**
 * MUserState entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_user_state", catalog = "")
public class MUserState implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer venderId;
	private Long userId;
	private String results;
	private String remarks;
	private Date createdAt;
	private String createdBy;
	private Short version;

	// Constructors

	/** default constructor */
	public MUserState() {
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

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "remarks", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return String 取得域 results 的方法。
	 */
	@Column(name = "results", nullable = false, length = 254)
	public String getResults() {
		return results;
	}

	/**
	 * @param results 对域 results 的设置方法.
	 */
	public void setResults(String results) {
		this.results = results;
	}

	/**
	 * @return Integer 取得域 venderId 的方法。
	 */
	@Column(name = "vender_id", nullable = false)
	public Integer getVenderId() {
		return venderId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}
}