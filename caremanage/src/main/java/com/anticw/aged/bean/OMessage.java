package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "o_message")
public class OMessage{

	// Fields

	private Integer id;
	private String phone;
	private String content;
	private Integer comeFrom;
	private Date createdTime;

	// Constructors

	/** default constructor */
	public OMessage() {
	}

	/** full constructor */
	public OMessage(String phone, String content, Integer comeFrom,
			Date createdTime) {
		this.phone = phone;
		this.content = content;
		this.comeFrom = comeFrom;
		this.createdTime = createdTime;
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

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "content", length = 200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "come_from")
	public Integer getComeFrom() {
		return this.comeFrom;
	}

	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}

	@Column(name = "created_time", length = 0)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}