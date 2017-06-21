package com.anticw.aged.vo.user;

import java.util.Date;

/**
 * 
 * @author DX 2016-3-24
 *
 */
public class AssessUserVO {

	private Long id;
	private String idCardNo;
	private Date creatAt;
	private String assessName;
	private String assessConclusion;
	private String name;
	private Integer age;
	private Integer gender;
	private Integer communityId;
	private Long siteId;
	private String communityName;
	private String siteName;
	private String recordDetail;
	private Date createdAt;
	private Short type;
	private String conContent;
	private Long recordId;
	public AssessUserVO() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getRecordDetail() {
		return recordDetail;
	}
	public void setRecordDetail(String recordDetail) {
		this.recordDetail = recordDetail;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	public String getAssessName() {
		return assessName;
	}
	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}
	public String getAssessConclusion() {
		return assessConclusion;
	}
	public void setAssessConclusion(String assessConclusion) {
		this.assessConclusion = assessConclusion;
	}
	public String getConContent() {
		return conContent;
	}
	public void setConContent(String conContent) {
		this.conContent = conContent;
	}
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	@Override
	public String toString() {
		return "AssessUserVO [id=" + id + ", idCardNo=" + idCardNo
				+ ", creatAt=" + creatAt + ", assessName=" + assessName
				+ ", assessConclusion=" + assessConclusion + ", name=" + name
				+ ", age=" + age + ", gender=" + gender + ", communityId="
				+ communityId + ", siteId=" + siteId + ", communityName="
				+ communityName + ", siteName=" + siteName + ", recordDetail="
				+ recordDetail + ", createdAt=" + createdAt + ", type=" + type
				+ ", conContent=" + conContent + "]";
	}
	
}
