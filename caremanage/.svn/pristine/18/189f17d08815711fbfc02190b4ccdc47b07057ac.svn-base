package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RUserAssesscore entity. @author dx  
 * 用户进行分析时，获取的分析初始数据
 */
@Entity
@Table(name = "r_user_assesscore")
public class RUserAssesscore implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5165999532700058275L;
	private Long id;
	private Long userId;
	private Short sex;
	private Double totingPointss;
	private Double totingPointse;
	private Integer itemize;
	private Date createdAt;
	private String createdBy;

	// Constructors

	/** default constructor */
	public RUserAssesscore() {
	}

	/** full constructor */
	public RUserAssesscore(Long userId, Short sex, Double totingPointss,
			Double totingPointse, Integer itemize, Date createdAt,
			String createdBy) {
		this.userId = userId;
		this.sex = sex;
		this.totingPointss = totingPointss;
		this.totingPointse = totingPointse;
		this.itemize = itemize;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "sex")
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "toting_pointss", precision = 22, scale = 0)
	public Double getTotingPointss() {
		return this.totingPointss;
	}

	public void setTotingPointss(Double totingPointss) {
		this.totingPointss = totingPointss;
	}

	@Column(name = "toting_pointse", precision = 22, scale = 0)
	public Double getTotingPointse() {
		return this.totingPointse;
	}

	public void setTotingPointse(Double totingPointse) {
		this.totingPointse = totingPointse;
	}

	@Column(name = "itemize")
	public Integer getItemize() {
		return this.itemize;
	}

	public void setItemize(Integer itemize) {
		this.itemize = itemize;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_by", length = 25)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}