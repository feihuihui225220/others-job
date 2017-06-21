package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 作者： bsd
 * 日期：  2016-10-19
 * 功能：音乐
 */
@Entity
@Table(name = "care_music")
public class CareMusic implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String musicUrl;
	private Integer category;
	private Integer listenCount;
	private Integer likeCount;
	private String createUser;
	private Date createTime;
	private String changeUser;
	private Date changeTime;
	private Boolean available;

	// Constructors

	/** default constructor */
	public CareMusic() {
	}

	/** full constructor */
	public CareMusic(String name, String musicUrl, Integer category,
			Integer listenCount, Integer likeCount, String createUser,
			Date createTime, String changeUser, Date changeTime,
			Boolean available) {
		this.name = name;
		this.musicUrl = musicUrl;
		this.category = category;
		this.listenCount = listenCount;
		this.likeCount = likeCount;
		this.createUser = createUser;
		this.createTime = createTime;
		this.changeUser = changeUser;
		this.changeTime = changeTime;
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

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "music_url", length = 128)
	public String getMusicUrl() {
		return this.musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	@Column(name = "category")
	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Column(name = "listen_count")
	public Integer getListenCount() {
		return this.listenCount;
	}

	public void setListenCount(Integer listenCount) {
		this.listenCount = listenCount;
	}

	@Column(name = "like_count")
	public Integer getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	@Column(name = "create_user", length = 32)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "change_user", length = 32)
	public String getChangeUser() {
		return this.changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}