package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CareAssess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "care_assess")
public class CareAssess implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-11-8
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer parentId;
	private String title;
	private String content;
	private String coverUrl;
	private String vedioUrl;
	private Integer assessId;
	private Integer pageview;
	private Integer assessCount;
	private Integer sort;
	private Date createTime;
	private String createUser;
	private Date changeTime;
	private String changeUser;
	private Boolean available;

	// Constructors

	/** default constructor */
	public CareAssess() {
	}

	/** full constructor */
	public CareAssess(Integer parentId, String title, String content,
			String coverUrl, String vedioUrl, Integer assessId,
			Integer pageview, Integer assessCount, Integer sort,
			Date createTime, String createUser, Date changeTime,
			String changeUser, Boolean available) {
		this.parentId = parentId;
		this.title = title;
		this.content = content;
		this.coverUrl = coverUrl;
		this.vedioUrl = vedioUrl;
		this.assessId = assessId;
		this.pageview = pageview;
		this.assessCount = assessCount;
		this.sort = sort;
		this.createTime = createTime;
		this.createUser = createUser;
		this.changeTime = changeTime;
		this.changeUser = changeUser;
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

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "title", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "cover_url", length = 1024)
	public String getCoverUrl() {
		return this.coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	@Column(name = "vedio_url", length = 1024)
	public String getVedioUrl() {
		return this.vedioUrl;
	}

	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	@Column(name = "assess_id")
	public Integer getAssessId() {
		return this.assessId;
	}

	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}

	@Column(name = "pageview")
	public Integer getPageview() {
		return this.pageview;
	}

	public void setPageview(Integer pageview) {
		this.pageview = pageview;
	}

	@Column(name = "assess_count")
	public Integer getAssessCount() {
		return this.assessCount;
	}

	public void setAssessCount(Integer assessCount) {
		this.assessCount = assessCount;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user", length = 32)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_user", length = 32)
	public String getChangeUser() {
		return this.changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}