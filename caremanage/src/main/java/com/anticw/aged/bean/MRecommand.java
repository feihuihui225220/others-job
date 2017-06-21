package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.anticw.aged.bean.utils.ProfessionalConstants;

/**
 * MRecommand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_recommand", catalog = "")
public class MRecommand {

	private Long id;
	
	private Long userId;
	
	private String userName;
	
	private String idCard;
	
	private Integer categoryId;
	
	private Integer serviceId;
	
	private Short status;
	
	private Date createdAt;
	
	private Date changedAt;
	
	public MRecommand(){
		
	}

	
	
	/**
	 * 生成推荐
	 * @param userId
	 * @param userName
	 * @param idCard
	 * @param categoryId
	 * @param serviceId
	 */
	public MRecommand(Long userId, String userName, String idCard, Integer categoryId, Integer serviceId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.idCard = idCard;
		this.categoryId = categoryId;
		this.serviceId = serviceId;
		this.status = ProfessionalConstants.RECOMMAND_NOHANDLE;
		Date date = new Date();
		this.createdAt = date;
		this.changedAt = date;
	}



	/**
	 * @return Long 取得域 id 的方法。
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Long 取得域 userId 的方法。
	 */
	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return Integer 取得域 serviceId 的方法。
	 */
	@Column(name = "service_id", nullable = false)
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId 对域 serviceId 的设置方法.
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return Short 取得域 status 的方法。
	 */
	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return status;
	}

	/**
	 * @param status 对域 status 的设置方法.
	 */
	public void setStatus(Short status) {
		this.status = status;
	}

	/**
	 * @return Date 取得域 createdAt 的方法。
	 */
	@Column(name = "created_at", nullable = false)
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
	 * @return Date 取得域 changedAt 的方法。
	 */
	@Column(name = "changed_at", nullable = false)
	public Date getChangedAt() {
		return changedAt;
	}

	/**
	 * @param changedAt 对域 changedAt 的设置方法.
	 */
	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @return String 取得域 userName 的方法。
	 */
	@Column(name = "user_name", nullable = false, length = 40)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 对域 userName 的设置方法.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return String 取得域 idCard 的方法。
	 */
	@Column(name = "id_card", nullable = false, length = 20)
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard 对域 idCard 的设置方法.
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return Integer 取得域 categoryId 的方法。
	 */
	@Column(name = "category_id", nullable = false)
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId 对域 categoryId 的设置方法.
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
