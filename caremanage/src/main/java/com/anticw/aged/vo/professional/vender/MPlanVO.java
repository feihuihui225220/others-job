/**
 * 
 */
package com.anticw.aged.vo.professional.vender;


/**
 * 计划任务VO
 * @author li
 *
 */
public class MPlanVO {

	private Long id;
	private Long userId;
	private Integer mVenderId;
	private Long  ordreId; 
	private String serviceTime;
	private Integer serviceType;
	private Integer serviceContent;
	private String remark;
	private Integer categoryId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getmVenderId() {
		return mVenderId;
	}
	public void setmVenderId(Integer mVenderId) {
		this.mVenderId = mVenderId;
	}
	public Long getOrdreId() {
		return ordreId;
	}
	public void setOrdreId(Long ordreId) {
		this.ordreId = ordreId;
	}
	 
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public Integer getServiceContent() {
		return serviceContent;
	}
	public void setServiceContent(Integer serviceContent) {
		this.serviceContent = serviceContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
