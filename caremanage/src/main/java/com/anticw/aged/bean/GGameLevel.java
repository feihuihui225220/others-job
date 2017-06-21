package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AbstractGGameLevel entity provides the base persistence definition of the GGameLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="g_game_level")
public  class GGameLevel implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-7-28
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userId;
	private Integer gameId;
	private Integer level;
	private Integer dayScore;
	private Integer score;
	private Date createTime;
	private Date changeTime;
	private boolean available;

	// Constructors

	/** default constructor */
	public GGameLevel() {
	}

	/** full constructor */
	public GGameLevel(String userId, Integer gameId, Integer level,Integer dayScore,
			Integer score, Date createTime, Date changeTime, boolean available) {
		this.userId = userId;
		this.gameId = gameId;
		this.level = level;
		this.dayScore = dayScore;
		this.score = score;
		this.createTime = createTime;
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

	@Column(name = "user_id", length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "game_id")
	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	@Column(name = "day_score")
	public Integer getDayScore() {
		return dayScore;
	}

	public void setDayScore(Integer dayScore) {
		this.dayScore = dayScore;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "available", columnDefinition = "BIT")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}