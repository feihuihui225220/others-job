package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * n_program 节目 Mon Sep 07 09:39:01 CST 2015 baishuangdong
 */

@Entity
@Table(name = "n_program")
public class NProgram {

	private Integer id;
	private String programName;
	private String programDesc;
	private boolean avaliable;
	private Boolean type;
	private Double price;
	private String aviUrl;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private short version;
	private Integer parentId;
	private String subjectTeacher;
	private Set<NVenderMaterial> nVenderMaterial;
	private String programTime;
	private String coverUrl;

	private String keyword;

	private String programContent;

	private String programExperience;
	
	private Integer pageView;
	
	private String thumbs;

	public NProgram() {
		super();
	}

	public NProgram(String programName, String programDesc, boolean avaliable,
			String aviUrl, String createdBy, Date createdAt, String changedBy,
			Date changedAt, short version, Integer parentId,
			String subjectTeacher) {
		super();
		this.programName = programName;
		this.programDesc = programDesc;
		this.avaliable = avaliable;
		this.aviUrl = aviUrl;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
		this.parentId = parentId;
		this.subjectTeacher = subjectTeacher;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "program_name", nullable = true)
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Column(name = "program_desc", columnDefinition = "longtext")
	public String getProgramDesc() {
		return programDesc;
	}

	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}

	@Column(name = "avaliable", nullable = false)
	public boolean getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Column(name = "created_by", nullable = true, length = 40)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = true)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = true, length = 40)
	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = true)
	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "version", nullable = true)
	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	@Column(name = "avi_url")
	public String getAviUrl() {
		return aviUrl;
	}

	public void setAviUrl(String aviUrl) {
		this.aviUrl = aviUrl;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "subject_teacher")
	public String getSubjectTeacher() {
		return subjectTeacher;
	}

	public void setSubjectTeacher(String subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}

	@Column(name = "program_time")
	public String getProgramTime() {
		return programTime;
	}

	@OneToMany(mappedBy = "nProgram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<NVenderMaterial> getnVenderMaterial() {
		return nVenderMaterial;
	}

	public void setnVenderMaterial(Set<NVenderMaterial> nVenderMaterial) {
		this.nVenderMaterial = nVenderMaterial;
	}

	public void setProgramTime(String programTime) {
		this.programTime = programTime;
	}

	@Column(name = "keyword")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "program_content")
	public String getProgramContent() {
		return programContent;
	}

	public void setProgramContent(String programContent) {
		this.programContent = programContent;
	}

	@Column(name = "program_experience")
	public String getProgramExperience() {
		return programExperience;
	}

	public void setProgramExperience(String programExperience) {
		this.programExperience = programExperience;
	}
	@Column(name = "type")
	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}
	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name = "page_view")
	public Integer getPageView() {
		return pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}
	
	@Column(name = "thumbs")
	public String getThumbs() {
		return thumbs;
	}

	public void setThumbs(String thumbs) {
		this.thumbs = thumbs;
	}

	@Column(name = "cover_url")
	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	
	
}
