package com.anticw.aged.vo.admin;

import java.util.Date;

public class OCategoryItemVO {

	private Integer id;
	private Integer categoryId;
	private Short version;
	private String itemName;
	private String itemValue;
	private Boolean available;
	private String createdBy;
	private Date changedAt;
	private String changedBy;
	private Date createdAt;
	private Integer itemId;
	
	public OCategoryItemVO(){
		
	}
	
	public OCategoryItemVO(Integer categoryId, Short version, String itemName,
			String itemValue, Boolean available, String createdBy,
			Date changedAt, String changedBy, Date createdAt, Integer itemId) {
		super();
		this.categoryId = categoryId;
		this.version = version;
		this.itemName = itemName;
		this.itemValue = itemValue;
		this.available = available;
		this.createdBy = createdBy;
		this.changedAt = changedAt;
		this.changedBy = changedBy;
		this.createdAt = createdAt;
		this.itemId = itemId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Short getVersion() {
		return version;
	}
	public void setVersion(Short version) {
		this.version = version;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
}
