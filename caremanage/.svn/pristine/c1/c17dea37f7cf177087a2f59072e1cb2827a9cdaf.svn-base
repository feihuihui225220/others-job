package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZBanner entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_banner")
public class ZBanner implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798239525081642443L;
	private Integer id;
	private String name;
	private String url;
	private String linkUrl;
	private Integer type;
	private Date createdAt;
	private String createsBy;
	private Integer available;

	// Constructors

	/** default constructor */
	public ZBanner() {
	}

	/** full constructor */
	public ZBanner(String name, String url, String linkUrl,
			Date createdAt, String createsBy, Integer available) {
		this.name = name;
		this.url = url;
		this.linkUrl = linkUrl;
		this.createdAt = createdAt;
		this.createsBy = createsBy;
		this.available = available;
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

	@Column(name = "name", length = 25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "link_url", length = 256)
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "created_at", length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "creates_by", length = 25)
	public String getCreatesBy() {
		return this.createsBy;
	}

	public void setCreatesBy(String createsBy) {
		this.createsBy = createsBy;
	}

	@Column(name = "available")
	public Integer getAvailable() {
		return this.available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

}