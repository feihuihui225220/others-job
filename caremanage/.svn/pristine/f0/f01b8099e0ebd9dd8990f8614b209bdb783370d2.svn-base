package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

/**
 * ONotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "o_notice")
public class ONotice implements java.io.Serializable {

	private static final long serialVersionUID = -6769546797275375880L;
	// Fields
	private Integer id;
	private Short version;
	private String title;
	private String publisher;
	private String content;
	private String keyword;
	private String directory;
	private Integer categoryId;
	private Integer communityId;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	private OCategoryItem category;

	// Constructors

	/** default constructor */
	public ONotice() {
	}

	/** minimal constructor */
	public ONotice(String title, String publisher, String directory, Integer categoryId, Integer communityId, Boolean available,
			String createdBy, Date createdAt, String changedBy, Date changedAt) {
		this.title = title;
		this.publisher = publisher;
		this.directory = directory;
		this.categoryId = categoryId;
		this.communityId = communityId;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
	}

	/** full constructor */
	public ONotice(String title, String publisher, String content, String keyword, String directory, Integer categoryId,
			Integer communityId, Boolean available, String createdBy, Date createdAt, String changedBy, Date changedAt) {
		this.title = title;
		this.publisher = publisher;
		this.content = content;
		this.keyword = keyword;
		this.directory = directory;
		this.categoryId = categoryId;
		this.communityId = communityId;
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

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "publisher", nullable = false, length = 50)
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

	@Column(name = "keyword", length = 50)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "directory", nullable = false, length = 255)
	public String getDirectory() {
		return this.directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	@Column(name = "category_id", nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "community_id", nullable = false)
	public Integer getCommunityId() {
		return this.communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
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

	@OneToOne
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	public OCategoryItem getCategory() {
		return category;
	}

	public void setCategory(OCategoryItem category) {
		this.category = category;
	}
	

}