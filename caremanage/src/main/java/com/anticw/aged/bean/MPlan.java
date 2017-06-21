package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * MPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_plan")
public class MPlan implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Short version;
	private Long userId;
	@JsonIgnore
	private MVender mVender;
	/**
	 * 计划内容
	 */
	private MPlanCategory mPlanCategory;
	private Long orderId;
	//private MService mService;//服务计划对应的专业服务
	private Date serviceTime;
	private Integer serviceType;
	private Integer serviceContent;
	private String remark;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;

	// Constructors

	/** default constructor */
	public MPlan() {
	}
	public MPlan(Short version, Long userId, MVender mVender,
			MPlanCategory mPlanCategory, Long orderId, Date serviceTime,
			Integer serviceType, Integer serviceContent, String remark,
			String createdBy, Date createdAt, String changedBy, Date changedAt) {
		super();
		this.version = version;
		this.userId = userId;
		this.mVender = mVender;
		this.mPlanCategory = mPlanCategory;
		this.orderId = orderId;
		this.serviceTime = serviceTime;
		this.serviceType = serviceType;
		this.serviceContent = serviceContent;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
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

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@ManyToOne(cascade = {CascadeType.ALL },fetch=FetchType.LAZY,targetEntity=MVender.class)
	@JoinColumn(name = "vendor_id")
	public MVender getmVender() {
		return mVender;
	}
	public void setmVender(MVender mVender) {
		this.mVender = mVender;
	}

	@Column(name = "service_time")
	public Date getServiceTime() {
		return this.serviceTime;
	}


	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	@Column(name = "service_type")
	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "service_content")
	public Integer getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(Integer serviceContent) {
		this.serviceContent = serviceContent;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at")
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by")
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at")
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}
	@Column(name = "order_id")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL },fetch=FetchType.LAZY,targetEntity=MPlanCategory.class)
	@JoinColumn(name = "category_id")
	public MPlanCategory getmPlanCategory() {
		return mPlanCategory;
	}
	public void setmPlanCategory(MPlanCategory mPlanCategory) {
		this.mPlanCategory = mPlanCategory;
	}
}