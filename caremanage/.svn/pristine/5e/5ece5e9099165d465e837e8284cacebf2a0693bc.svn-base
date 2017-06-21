package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ZAssess entity. @author MyEclipse Persistence Tools
 * 评估量表管理
 */
@Entity
@Table(name = "z_assess")
public class ZAssess implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-11-23
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer version;
	private Integer title;//对应o_category_item中category_id=124的Id
	private String content;
	private String coverUrl;
	private String bgUrl;
	private String course;
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
	public ZAssess() {
	}

	/** full constructor */
	public ZAssess(Integer title, String content, String coverUrl, String bgUrl,
			String course, Integer assessId, Integer pageview,
			Integer assessCount, Integer sort, Date createTime,
			String createUser, Date changeTime, String changeUser,
			Boolean available) {
		this.title = title;
		this.content = content;
		this.coverUrl = coverUrl;
		this.bgUrl = bgUrl;
		this.course = course;
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

	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "title")
	public Integer getTitle() {
		return this.title;
	}

	public void setTitle(Integer title) {
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

	@Column(name = "bg_url", length = 1024)
	public String getBgUrl() {
		return this.bgUrl;
	}

	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}

	@Column(name = "course", length = 1024)
	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}