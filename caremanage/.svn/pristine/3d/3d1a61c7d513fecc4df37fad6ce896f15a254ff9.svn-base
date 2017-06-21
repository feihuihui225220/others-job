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

/**
 * MDataModuleItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_data_module_item", catalog = "")
public class MDataModuleItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	//private Integer moduleId;
	private String itemName;
	private String itemDesc;
	private Boolean isShow;
	//private Boolean isAlarm;
	//private Integer alarmLower;
	//private Integer alarmUpper;
	/**
	 * 数据类型0：数值，1：字符串，2：其他
	 */
	private Integer itemType;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	private MDataModule dataModule;

	// Constructors

	/** default constructor */
	public MDataModuleItem() {
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

	@Version
	@Column(name = "version", nullable = false)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

//	@Column(name = "module_id", nullable = false)
//	public Integer getModuleId() {
//		return this.moduleId;
//	}
//
//	public void setModuleId(Integer moduleId) {
//		this.moduleId = moduleId;
//	}

	@Column(name = "item_name", nullable = false, length = 20)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_desc", nullable = false)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "is_show", nullable = false)
	public Boolean getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

//	@Column(name = "is_alarm", nullable = false)
//	public Boolean getIsAlarm() {
//		return this.isAlarm;
//	}
//
//	public void setIsAlarm(Boolean isAlarm) {
//		this.isAlarm = isAlarm;
//	}
	
	

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
	}

	/**
	 * @return the itemType
	 */
	@Column(name = "item_type")
	public Integer getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = false, length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = false, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = false, length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

//	/**
//	 * @return Integer 取得域 alarmLower 的方法。
//	 */
//	@Column(name = "alarm_lower")
//	public Integer getAlarmLower() {
//		return alarmLower;
//	}
//
//	/**
//	 * @param alarmLower 对域 alarmLower 的设置方法.
//	 */
//	public void setAlarmLower(Integer alarmLower) {
//		this.alarmLower = alarmLower;
//	}

//	/**
//	 * @return Integer 取得域 alarmUpper 的方法。
//	 */
//	@Column(name = "alarm_upper")
//	public Integer getAlarmUpper() {
//		return alarmUpper;
//	}
//
//	/**
//	 * @param alarmUpper 对域 alarmUpper 的设置方法.
//	 */
//	public void setAlarmUpper(Integer alarmUpper) {
//		this.alarmUpper = alarmUpper;
//	}

	/**
	 * @return MDataModule 取得域 dataModule 的方法。
	 */
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
	public MDataModule getDataModule() {
		return dataModule;
	}

	/**
	 * @param dataModule 对域 dataModule 的设置方法.
	 */
	public void setDataModule(MDataModule dataModule) {
		this.dataModule = dataModule;
	}
}