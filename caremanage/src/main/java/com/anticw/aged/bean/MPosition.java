package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MPosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_position")
public class MPosition implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 519834237374050178L;
	// Fields
	private Long id;
	private long userId;
	private String longitude;
	private String latitude;
	private Date createTime;
	private boolean available;
	private Integer type;

	// Constructors

	/** default constructor */
	public MPosition() {
	}

	/** full constructor */
	public MPosition(long userId, String longitude, String latitude,
			Date createTime, boolean available) {
		this.userId = userId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createTime = createTime;
		this.available = available;
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
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "longitude", length = 32)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", length = 32)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "available")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	

}