package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_order")
public class MOrder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
    private Long userId;
	
	@Column(name = "user_name", nullable = false, length = 40)
    private String userName;
	
	@Column(name = "start_time", nullable = false)
    private Date startTime;
    
	@Column(name = "end_time", nullable = false)
	private Date endTime;
	
	@Column(name = "total_pay", nullable = false)
    private Integer totalPay;
	
	@Column(name = "id_card", nullable = false, length = 20)
    private String idCard;
	
	//@Column(name = "meta_service_id", nullable = false)
   // private Integer metaServiceId;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order")
	//@Where(clause="available=1")
	//@OrderBy(value="code ASC")
	private Set<MOrderDevice> orderDevices=new HashSet<MOrderDevice>();
	
	//@Lob
	//@Basic(fetch = FetchType.LAZY)  
	//@Type(type="text")
	//@Column(name = "device_info", nullable = false, length = 65535)
    //private String deviceInfo;
	
	@Column(name = "status", nullable = false)
    private Short status;
	
	@Column(name = "created_at", nullable = false)
    private Date createdAt;
	
	@Column(name = "created_by", nullable = false, length = 40)
    private String createdBy;
    
    @Column(name = "changed_at", nullable = false)
    private Date changedAt;
    
    @Column(name = "changed_by", nullable = false, length = 40)
    private String changedBy;
    
    @Column(name = "version", nullable = false)
    private Short version;
    @ManyToOne
	@JoinColumn(name="meta_service_id",insertable=true)
    private MMetaService mMetaService;

	/** default constructor */
	public MOrder() {
	}

	/**
	 * @return Long 取得域 id 的方法。
	 */
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
	 * @return String 取得域 userName 的方法。
	 */
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
	 * @return Integer 取得域 totalPay 的方法。
	 */
	public Integer getTotalPay() {
		return totalPay;
	}

	/**
	 * @param totalPay 对域 totalPay 的设置方法.
	 */
	public void setTotalPay(Integer totalPay) {
		this.totalPay = totalPay;
	}

	/**
	 * @return String 取得域 idCard 的方法。
	 */
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
	 * @return String 取得域 deviceInfo 的方法。
	 */
	//public String getDeviceInfo() {
	//	return deviceInfo;
	//}

	/**
	 * @param deviceInfo 对域 deviceInfo 的设置方法.
	 */
	//public void setDeviceInfo(String deviceInfo) {
	//	this.deviceInfo = deviceInfo;
	//}

	/**
	 * @return Short 取得域 status 的方法。
	 */
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

	/**
	 * @return Date 取得域 changedAt 的方法。
	 */
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
	 * @return String 取得域 changedBy 的方法。
	 */
	public String getChangedBy() {
		return changedBy;
	}

	/**
	 * @param changedBy 对域 changedBy 的设置方法.
	 */
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * @return Short 取得域 version 的方法。
	 */
	public Short getVersion() {
		return version;
	}

	/**
	 * @param version 对域 version 的设置方法.
	 */
	public void setVersion(Short version) {
		this.version = version;
	}

	/**
	 * @return Set<MOrderDevice> 取得域 orderDevices 的方法。
	 */
	public Set<MOrderDevice> getOrderDevices() {
		return orderDevices;
	}

	/**
	 * @param orderDevices 对域 orderDevices 的设置方法.
	 */
	public void setOrderDevices(Set<MOrderDevice> orderDevices) {
		this.orderDevices = orderDevices;
	}


	public MMetaService getmMetaService() {
		return mMetaService;
	}

	public void setmMetaService(MMetaService mMetaService) {
		this.mMetaService = mMetaService;
	}

	@Override
	public String toString() {
		return "MOrder [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", totalPay=" + totalPay + ", idCard=" + idCard
				+ ", orderDevices=" + orderDevices + ", status=" + status
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", changedAt=" + changedAt + ", changedBy=" + changedBy
				+ ", version=" + version + ", mMetaService=" + mMetaService
				+ "]";
	}

	
	
}