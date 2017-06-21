package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "m_vender_evaluation")
public class MVenderEvaluation {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "vender_id", nullable = false)
	private Integer venderId;
	
	@Column(name = "start_time", nullable = false)
	private Date startTime;
	
	@Column(name = "end_time", nullable = false)
	private Date endTime;
	
	@Column(name = "server_count", nullable = false)
	private Short serverCount;
	
	@Column(name = "inc_count", nullable = false)
	private Short incCount;
	
	@Column(name = "dinc_count", nullable = false)
	private Short dincCount;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "question", length = 65535)
	private String question;
	
	@Column(name = "star", nullable = false)
	private Short star;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)  
	@Type(type="text")
	@Column(name = "evaluation", length = 65535)
	private String evaluation;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "created_by", nullable = false, length = 40)
	private String createdBy;

	/**
	 * @return Long 取得域 id 的方法。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Integer 取得域 venderId 的方法。
	 */
	public Integer getVenderId() {
		return venderId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	/**
	 * @return Date 取得域 startTime 的方法。
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime 对域 startTime 的设置方法.
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return Date 取得域 endTime 的方法。
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime 对域 endTime 的设置方法.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return Short 取得域 serverCount 的方法。
	 */
	public Short getServerCount() {
		return serverCount;
	}

	/**
	 * @param serverCount 对域 serverCount 的设置方法.
	 */
	public void setServerCount(Short serverCount) {
		this.serverCount = serverCount;
	}

	/**
	 * @return Short 取得域 incCount 的方法。
	 */
	public Short getIncCount() {
		return incCount;
	}

	/**
	 * @param incCount 对域 incCount 的设置方法.
	 */
	public void setIncCount(Short incCount) {
		this.incCount = incCount;
	}

	/**
	 * @return Short 取得域 dincCount 的方法。
	 */
	public Short getDincCount() {
		return dincCount;
	}

	/**
	 * @param dincCount 对域 dincCount 的设置方法.
	 */
	public void setDincCount(Short dincCount) {
		this.dincCount = dincCount;
	}

	/**
	 * @return String 取得域 question 的方法。
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question 对域 question 的设置方法.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return Short 取得域 star 的方法。
	 */
	public Short getStar() {
		return star;
	}

	/**
	 * @param star 对域 star 的设置方法.
	 */
	public void setStar(Short star) {
		this.star = star;
	}

	/**
	 * @return String 取得域 evaluation 的方法。
	 */
	public String getEvaluation() {
		return evaluation;
	}

	/**
	 * @param evaluation 对域 evaluation 的设置方法.
	 */
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @return Date 取得域 createdAt 的方法。
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt 对域 createdAt 的设置方法.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return String 取得域 createdBy 的方法。
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy 对域 createdBy 的设置方法.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
