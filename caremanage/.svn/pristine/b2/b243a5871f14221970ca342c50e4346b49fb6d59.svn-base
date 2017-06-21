package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HConsultation entity. @author MyEclipse Persistence Tools
 * 会诊
 */
@Entity
@Table(name = "h_consultation")
public class HConsultation{

	// Fields

	private Integer id;
	/*private long userId;*/
	private Date startTime;
	private Date endTime;
	private String content;
	private String ultimateness;/*会诊结论*/
	private String chronicType;/*慢性病类型*/
	private String department;//会诊需要参与的科室
	private Integer groupId;
	private String state;
	private String address;
	private Date createTime;
	private Date changeTime;
	private String changeBy;
	private Date applyTime;
	private RUser user;
	private String createBy;
	// Constructors
	@Column(name="create_by")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/** default constructor */
	public HConsultation() {
	}

	/** minimal constructor */
	public HConsultation(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public HConsultation(Integer id, long userId, Date startTime, Date endTime,RUser user,
			String content,String department, Integer groupId, String state, String address, Date createTime,String createBy) {
		this.id = id;
		this.user = user;
		/*this.userId = userId;*/
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.department = department;
		this.groupId = groupId;
		this.state = state;
		this.address = address;
		this.createTime = createTime;
		this.createBy=createBy;
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

	/*@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
*/
	@Column(name = "start_time", length = 0)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", length = 0)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "content", length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "department", length = 256)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "state", length = 8)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "address", length = 128)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	@Column(name="apply_time")
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	
	@Column(name="change_time")
	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	@Column(name="change_by")
	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name="ultimateness")
	public String getUltimateness() {
		return ultimateness;
	}

	public void setUltimateness(String ultimateness) {
		this.ultimateness = ultimateness;
	}
	@Column(name="chronic_type")
	public String getChronicType() {
		return chronicType;
	}

	public void setChronicType(String chronicType) {
		this.chronicType = chronicType;
	}

	//  ------------------用户信息表-----------------
	/**
	 * @return the user
	 */
	
	@ManyToOne(optional=true)
	@JoinColumn(name="user_id")
	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.user = user;
	}
}