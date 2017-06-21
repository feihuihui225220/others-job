package com.anticw.aged.vo.professional.activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 志愿者培训记录表
 * @author dx
 *
 */
public class VolunteerTrainingRecordVo {
	private String volunteerName;
	private String sex;
	private int age;
	private int planNum;
	private String community;
	private Map<Date,String> signIn=new HashMap<Date,String>();
	private Map<Date,String> content=new HashMap<Date,String>();
	private Map<Date,String> title=new HashMap<Date,String>();
	private int countRecord;
	private Map<Date,String> planDel=new HashMap<Date,String>();
	private Map<Date,String> serviceItem=new HashMap<Date,String>();
	private Map<Date,Integer> volunteerAssessIds=new HashMap<Date,Integer>();
	 
	public String getVolunteerName() {
		return volunteerName;
	}
	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Map<Date, String> getServiceItem() {
		return serviceItem;
	}
	public void setServiceItem(Map<Date, String> serviceItem) {
		this.serviceItem = serviceItem;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public int getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(int countRecord) {
		this.countRecord = countRecord;
	}
	public Map<Date, String> getSignIn() {
		return signIn;
	}
	public void setSignIn(Map<Date, String> signIn) {
		this.signIn = signIn;
	}
	public Map<Date, String> getPlanDel() {
		return planDel;
	}
	public void setPlanDel(Map<Date, String> planDel) {
		this.planDel = planDel;
	}
	public Map<Date, String> getContent() {
		return content;
	}
	public void setContent(Map<Date, String> content) {
		this.content = content;
	}
	public Map<Date, String> getTitle() {
		return title;
	}
	public void setTitle(Map<Date, String> title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPlanNum() {
		return planNum;
	}
	public void setPlanNum(int planNum) {
		this.planNum = planNum;
	}
	public Map<Date, Integer> getVolunteerAssessIds() {
		return volunteerAssessIds;
	}
	public void setVolunteerAssessIds(Map<Date, Integer> volunteerAssessIds) {
		this.volunteerAssessIds = volunteerAssessIds;
	}
	
}
