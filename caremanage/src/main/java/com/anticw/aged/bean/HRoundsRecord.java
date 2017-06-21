package com.anticw.aged.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HRoundsRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_rounds_record")
public class HRoundsRecord implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-17
	 * 功能：TODO 巡诊记录
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Long userId;
	private Date startTime;
	private Date endTime;
	private String content;
	private Integer groupId;
	private String type;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;
	
	//private HGroup group;
	// Constructors
	

	/** default constructor */
	public HRoundsRecord() {
	}

	/** full constructor */
	public HRoundsRecord(Long userId, Date startTime, Date endTime,Integer groupId,
			String content, String type, Date createTime,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.groupId = groupId;
		//this.group=group;
		this.type = type;
		this.createTime = createTime;
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

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	/*@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH },optional=true)
	@JoinColumn(name = "group_id")
	public HGroup getGroup() {
		return group;
	}

	public void setGroup(HGroup group) {
		this.group = group;
	}*/
	@Column(name="group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_by", length = 32)
	public String getCreateBy() {
		return createBy;
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

	@Column(name = "change_by", length = 32)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

}