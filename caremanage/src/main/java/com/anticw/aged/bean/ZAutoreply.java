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
 * ZAutoreply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_autoreply")
public class ZAutoreply {

	private Integer id;
	private Integer version;
	private String msgType;
	private String content;
	private String event;
	private String keyword;
	private Date createTime;
	private String createUser;
	private Date changeTime;
	private String changeUser;
	private Boolean available;

	// Constructors

	/** default constructor */
	public ZAutoreply() {
	}

	/** full constructor */
	public ZAutoreply(String msgType, String content, String event,
			String keyword, Date createTime, String createUser,
			Date changeTime, String changeUser, Boolean available) {
		this.msgType = msgType;
		this.content = content;
		this.event = event;
		this.keyword = keyword;
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

	@Column(name = "msgType", length = 16)
	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "event", length = 8)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "keyword", length = 16)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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