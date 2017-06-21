package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * GGameT entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "g_game_t")
public class GGameT implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-8-29
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userId;
	private Integer gameId;
	private String t;
	private String sexT;
	private String ageT;
	private String eduT;
	private Date createTime;
	private String score;
	private String resultHtml;
	private Boolean available;

	// Constructors

	/** default constructor */
	public GGameT() {
	}

	/** minimal constructor */
	public GGameT(Integer gameId) {
		this.gameId = gameId;
	}

	/** full constructor */
	public GGameT(String userId, Integer gameId, String t, String sexT,
			String ageT, String eduT, Date createTime, String score) {
		this.userId = userId;
		this.gameId = gameId;
		this.t = t;
		this.sexT = sexT;
		this.ageT = ageT;
		this.eduT = eduT;
		this.createTime = createTime;
		this.score = score;
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

	@Column(name = "user_id", length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "game_id", nullable = false)
	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	@Column(name = "t", length = 20)
	public String getT() {
		return this.t;
	}

	public void setT(String t) {
		this.t = t;
	}

	@Column(name = "sex_t", length = 20)
	public String getSexT() {
		return this.sexT;
	}

	public void setSexT(String sexT) {
		this.sexT = sexT;
	}

	@Column(name = "age_t", length = 20)
	public String getAgeT() {
		return this.ageT;
	}

	public void setAgeT(String ageT) {
		this.ageT = ageT;
	}

	@Column(name = "edu_t", length = 20)
	public String getEduT() {
		return this.eduT;
	}

	public void setEduT(String eduT) {
		this.eduT = eduT;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "score", length = 20)
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Type(type="text")
	@Column(name = "result_html")
	public String getResultHtml() {
		return resultHtml;
	}

	public void setResultHtml(String resultHtml) {
		this.resultHtml = resultHtml;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}