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
import javax.persistence.Version;

/**
 * HTransfer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_transfer")
public class HTransfer implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：TODO 转诊表
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	//private long userId;
	private Date applyTime;
	//private Integer groupId;
	private String content;
	private String state;
	private String handleResult;
	private Date handleTime;
	private String originalHospital;
	private String targetHospital;
	private Integer doctor;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;
	private RUser rUser;
	private HGroup hGroup;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="group_id")
	public HGroup gethGroup() {
		return hGroup;
	}

	public void sethGroup(HGroup hGroup) {
		this.hGroup = hGroup;
	}

	// Constructors
	@ManyToOne(optional=true)
	@JoinColumn(name="user_id")
	public RUser getrUser() {
		return rUser;
	}

	public void setrUser(RUser rUser) {
		this.rUser = rUser;
	}
	/** default constructor */
	public HTransfer() {
	}

	/** minimal constructor */
	public HTransfer(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public HTransfer(Integer id, RUser rUser, Date applyTime,HGroup hGroup,
			String content, String state, String handleResult, Date handleTime,
			String originalHospital, String targetHospital, Integer doctor,
			Date createTime, String createBy, Date changeTime, String changeBy) {
		this.id = id;
		//this.userId = userId;
		this.rUser=rUser;
		this.applyTime = applyTime;
		//this.groupId = groupId;
		this.hGroup=hGroup;
		this.content = content;
		this.state = state;
		this.handleResult = handleResult;
		this.handleTime = handleTime;
		this.originalHospital = originalHospital;
		this.targetHospital = targetHospital;
		this.doctor = doctor;
		this.createTime = createTime;
		this.createBy = createBy;
		this.changeTime = changeTime;
		this.changeBy = changeBy;
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
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/*@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}*/

	@Column(name = "apply_time", length = 0)
	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

/*	@Column(name = "group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}*/

	@Column(name = "content", length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "state", length = 16)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "handle_result", length = 2000)
	public String getHandleResult() {
		return this.handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	@Column(name = "handle_time", length = 0)
	public Date getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	@Column(name = "original_hospital", length = 64)
	public String getOriginalHospital() {
		return this.originalHospital;
	}

	public void setOriginalHospital(String originalHospital) {
		this.originalHospital = originalHospital;
	}

	@Column(name = "target_hospital", length = 64)
	public String getTargetHospital() {
		return this.targetHospital;
	}

	public void setTargetHospital(String targetHospital) {
		this.targetHospital = targetHospital;
	}

	@Column(name = "doctor")
	public Integer getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Integer doctor) {
		this.doctor = doctor;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_by", length = 16)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_by", length = 16)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

}