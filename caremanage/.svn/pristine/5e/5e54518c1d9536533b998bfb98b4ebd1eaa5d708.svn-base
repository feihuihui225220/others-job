package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MOrderAllocate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_order_allocate", catalog = "")
public class MOrderAllocate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long orderId;
	private Long userId;
	private String userName;
	private Date allocateTime;

	// Constructors

	/** default constructor */
	public MOrderAllocate() {
	}

	/** minimal constructor */
	public MOrderAllocate(Long id, Long orderId, Long userId, String userName) {
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
	}

	/** full constructor */
	public MOrderAllocate(Long id, Long orderId, Long userId, String userName, Date allocateTime) {
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.allocateTime = allocateTime;
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

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "allocate_time", length = 19)
	public Date getAllocateTime() {
		return this.allocateTime;
	}

	public void setAllocateTime(Date allocateTime) {
		this.allocateTime = allocateTime;
	}

}