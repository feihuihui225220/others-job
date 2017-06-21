package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZWxUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_wx_user")
public class ZWxUser{

	// Fields

	private Integer id;
	private String openId;
	private String nickname;
	private String coutry;
	private String province;
	private String city;
	private String headImgUrl;
	private String sex;
	private Date createTime;
	private Boolean available;

	// Constructors

	/** default constructor */
	public ZWxUser() {
	}

	/** full constructor */
	public ZWxUser(String openId, String nickname, String coutry,
			String province, String city, String headImgUrl, String sex,
			Date createTime, Boolean available) {
		this.openId = openId;
		this.nickname = nickname;
		this.coutry = coutry;
		this.province = province;
		this.city = city;
		this.headImgUrl = headImgUrl;
		this.sex = sex;
		this.createTime = createTime;
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

	@Column(name = "openId", length = 64)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "nickname", length = 64)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "coutry", length = 32)
	public String getCoutry() {
		return this.coutry;
	}

	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}

	@Column(name = "province", length = 16)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 32)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "head_img_url", length = 128)
	public String getHeadImgUrl() {
		return this.headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	@Column(name = "sex", length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}