/**
 * 
 */
package com.anticw.aged.vo.community;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 社区用户VO
 * @author li
 *
 */
public class AUserVO {	
	private Integer id;	
	private String name;
	@JsonIgnore
	private String password;	
	private String descr;
	private Boolean super_;
	@JsonIgnore
	private Short userCategory;
	private String communityIds;
	private String email;
	private String mobilePhone;
	private String contactPhone;
	private Integer gender;	
	private String addr;
	@JsonIgnore
	private Boolean available;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Boolean getSuper_() {
		return super_;
	}
	public void setSuper_(Boolean super_) {
		this.super_ = super_;
	}
	public Short getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(Short userCategory) {
		this.userCategory = userCategory;
	}
	public String getCommunityIds() {
		return communityIds;
	}
	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	

}
