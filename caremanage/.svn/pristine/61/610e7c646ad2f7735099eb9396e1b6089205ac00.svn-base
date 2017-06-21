package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZVipPaymentRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_vip_payment_record")
public class ZVipPaymentRecord {

	// Fields

	private Integer id;
	private Integer orderId;
	private double sumMoney;
	private Date createTime;
	private String createUser;
	private boolean available;

	// Constructors

	/** default constructor */
	public ZVipPaymentRecord() {
	}

	/** full constructor */
	public ZVipPaymentRecord(Integer orderId, double sumMoney, Date createTime,
			String createUser, boolean available) {
		this.orderId = orderId;
		this.sumMoney = sumMoney;
		this.createTime = createTime;
		this.createUser = createUser;
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

	@Column(name = "order_id")
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "sum_money", precision = 22, scale = 0)
	public double getSumMoney() {
		return this.sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user", length = 20)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "available")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}