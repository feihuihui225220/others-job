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
 * 功能：用户反馈
 */
@Entity
@Table(name = "care_feedback")
public class CareFeedback implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private String content;
	private String answer;
	private Integer state;
	private String answerUser;
	private Date responseTime;
	private Date createTime;
	private Boolean available;

	// Constructors

	/** default constructor */
	public CareFeedback() {
	}

	/** full constructor */
	public CareFeedback(Integer userId, String content, String answer,
			Integer state, String answerUser, Date responseTime,
			Date createTime, Boolean available) {
		this.userId = userId;
		this.content = content;
		this.answer = answer;
		this.state = state;
		this.answerUser = answerUser;
		this.responseTime = responseTime;
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

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "content", length = 512)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "answer", length = 512)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "answer_user", length = 32)
	public String getAnswerUser() {
		return this.answerUser;
	}

	public void setAnswerUser(String answerUser) {
		this.answerUser = answerUser;
	}

	@Column(name = "response_time", length = 0)
	public Date getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	@Column(name = "create_time", precision = 10, scale = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}