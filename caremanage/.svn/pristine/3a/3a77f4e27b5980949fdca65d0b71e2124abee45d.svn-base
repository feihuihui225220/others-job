package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

/**
 * OKnowledge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "o_knowledge", catalog = "")
public class OKnowledge implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String title;
	private String keyword;
	private Integer categoryId;
	private String publisher;
	private String content;
	private Boolean available;
	private Date changedAt;
	private String changedBy;
	private Date createdAt;
	private String createdBy;
	
	private OCategoryItem categoryItem;
	

	

	/** default constructor */
	public OKnowledge() {
	}

	/** minimal constructor */
	public OKnowledge(Boolean available) {
		this.available = available;
	}

	/** full constructor */
	public OKnowledge(String title, String keyword, Integer categoryId, String publisher, String content, Boolean available,
			 Date changedAt, String changedBy, Date createdAt, String createdBy) {
		this.title = title;
		this.keyword = keyword;
		this.categoryId = categoryId;
		this.publisher = publisher;
		this.content = content;
		this.available = available;
		this.changedAt = changedAt;
		this.changedBy = changedBy;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
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
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "title", length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "keyword", length = 20)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "publisher", length = 50)
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

	@Column(name = "changed_at", length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "changed_by", length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@OneToOne
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	public OCategoryItem getCategoryItem() {
		return categoryItem;
	}

	public void setCategoryItem(OCategoryItem categoryItem) {
		this.categoryItem = categoryItem;
	}
}