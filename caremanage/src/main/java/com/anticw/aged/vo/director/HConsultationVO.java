package com.anticw.aged.vo.director;

import java.util.Date;


/**
 * 
 * @author DX
 *
 */
public class HConsultationVO {

	private Integer id;
	/*private long userId;*/
	private String ultimateness;/*会诊结论*/
	private Integer groupId;
	private String groupName;/*申请医生*/
	private String department;//会诊需要参与的科室

	private String changeTime;
	private String content;
	private String chronicType;/*慢性病类型*/
	private String changeBy;
	//申请时间
	private Date createTime;
	//会诊时间
	private Date applyTime_;
	//会诊地址
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getApplyTime_() {
		return applyTime_;
	}
	public void setApplyTime_(Date applyTime_) {
		this.applyTime_ = applyTime_;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUltimateness() {
		return ultimateness;
	}
	public void setUltimateness(String ultimateness) {
		this.ultimateness = ultimateness;
	}
	public String getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getChronicType() {
		return chronicType;
	}
	public void setChronicType(String chronicType) {
		this.chronicType = chronicType;
	}
	public String getChangeBy() {
		return changeBy;
	}
	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}
	
	
	
	
}
