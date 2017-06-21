package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


   /**
    * n_volunteer  志愿者
    * Mon Sep 07 09:39:51 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_volunteer")
public class NVolunteer{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = true)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "sex", nullable = false)
	private String sex;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "site_id")
	private Integer siteId;
	
	@Column(name = "contact", nullable = false)
	private String contact;
	
	@Column(name = "community", nullable = false)
	private String community;
	
	@Column(name = "avaliable", nullable = false)
	private Boolean avaliable;
	
	@Column(name = "created_by", nullable = true, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = true)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = true, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = true)
	private Date changedAt;
	
	@Column(name = "version", nullable = true)
	private short version;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	   public Boolean getAvaliable() {
		   return avaliable;
	   }

	   public void setAvaliable(Boolean avaliable) {
		   this.avaliable = avaliable;
	   }

	   public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "NVolunteer [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", siteId=" + siteId + ", contact="
				+ contact + ", community=" + community + ", avaliable="
				+ avaliable + ", createdBy=" + createdBy + ", createdAt="
				+ createdAt + ", changedBy=" + changedBy + ", changedAt="
				+ changedAt + ", version=" + version + "]---------------------------------";
	}
	
	 
}

