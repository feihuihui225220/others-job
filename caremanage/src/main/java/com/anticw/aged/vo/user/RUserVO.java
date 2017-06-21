/**
 * 
 */
package com.anticw.aged.vo.user;

import java.util.Date;


/**
 *
 * @author guoyongxiang
 * Date: 2014-11-11
 */
public class RUserVO {

	private Long id;
	private String idCardNo;
	private String name;
	private String mobilePhone;
	private String contactPhone;
	private Integer communityId;
	private String addr;
	private Integer age;
	private Integer gender;
	/** 用户联系人 */
	private String contactUserName;
	private String contactUserMP;
	private String comminityName;
	private Date visitTime;
	
	private Integer education;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getContactUserName() {
		return contactUserName;
	}
	public void setContactUserName(String contactUserName) {
		this.contactUserName = contactUserName;
	}
	public String getContactUserMP() {
		return contactUserMP;
	}
	public void setContactUserMP(String contactUserMP) {
		this.contactUserMP = contactUserMP;
	}
	public String getComminityName() {
		return comminityName;
	}
	public void setComminityName(String comminityName) {
		this.comminityName = comminityName;
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
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	
}
