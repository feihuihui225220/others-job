package com.anticw.aged.vo.professional.vender;

import java.util.Date;

public class RUserVo {
	private String idCardNo;
	private String name;
	private String mobilePhone;
	private Integer age;
	private Date birthday;
	private Integer gender;
	public RUserVo(){
		
	}
	public RUserVo(String idCardNo, String name, String mobilePhone,
			Integer age, Date birthday, Integer gender) {
		super();
		this.idCardNo = idCardNo;
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.age = age;
		this.birthday = birthday;
		this.gender = gender;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
}
