package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

/**
 * MDataModule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_data_module", catalog = "")
public class MDataModule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String name;
	private String tableName;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	private Set<MDataModuleItem> dataModuleItems;

	// Constructors

	/** default constructor */
	public MDataModule() {
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

	@Column(name = "name", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "available", nullable = false)
	public Boolean getAvailable() {
		return this.available;
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

	/**
	 * @return Set<MDataModuleItem> 取得域 dataModuleItems 的方法。
	 */
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "dataModule")
	@Where(clause="available=1")
	@OrderBy(value="id ASC")
	public Set<MDataModuleItem> getDataModuleItems() {
		return dataModuleItems;
	}

	/**
	 * @param dataModuleItems 对域 dataModuleItems 的设置方法.
	 */
	public void setDataModuleItems(Set<MDataModuleItem> dataModuleItems) {
		this.dataModuleItems = dataModuleItems;
	}

	/**
	 * @return String 取得域 tableName 的方法。
	 */
	@Column(name = "table_name", nullable = false, length = 60)
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName 对域 tableName 的设置方法.
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}