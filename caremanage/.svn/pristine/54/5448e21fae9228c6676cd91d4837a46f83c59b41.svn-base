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
 * HTreatment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_treatment", catalog = "")
public class HTreatment implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：治疗管理
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	/*private long userId;*/
	private Date startTime;
	private Date endTime;
	private String content;
	private Integer groupId;
	private String state;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;
	private RUser user;

	// Constructors

	/** default constructor */
	public HTreatment() {
	}

	/** minimal constructor */
	/*public HTreatment(Integer id) {
		this.id = id;
	}
*/
	/** full constructor */
	public HTreatment(Integer id, /*long userId,*/ Date startTime, Date endTime,RUser user,
			String content, Integer groupId, String state, Date createTime,
			String createBy, Date changeTime, String changeBy) {
		this.id = id;
		this.user = user;
		/*this.userId = userId;*/
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.groupId = groupId;
		this.state = state;
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

	@Column(name = "group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "state", length = 16)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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