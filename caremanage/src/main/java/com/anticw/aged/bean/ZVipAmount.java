package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author bsd
 *
 */
@Entity
@Table(name = "z_vip_amount")
public class ZVipAmount {
	private Integer id;
	private double price; 
	private Date createTime;
	private Date changeTime;
	
	public ZVipAmount(){
		
	}
	
	public ZVipAmount(Integer id, double price, Date createTime, Date changeTime) {
		super();
		this.id = id;
		this.price = price;
		this.createTime = createTime;
		this.changeTime = changeTime;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	
}
