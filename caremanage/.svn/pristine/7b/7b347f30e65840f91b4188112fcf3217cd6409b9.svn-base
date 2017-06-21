package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HVisitPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_visit_plan")
public class HVisitPlan implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-13
	 * 功能：TODO巡诊计划表
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	/*private long userId;*/
	private Date visitTime;
	private long groupId;
	private String code;
	private Date createTime;
	private String createBy;
	private RUser user;
	// Constructors

	/** default constructor */
	public HVisitPlan() {
	}

	/** full constructor */
	public HVisitPlan(long userId, Date visitTime, long groupId, String code,RUser user,
			Date createTime, String createBy) {
		/*this.userId = userId;*/
		this.user = user;
		this.visitTime = visitTime;
		this.groupId = groupId;
		this.code = code;
		this.createTime = createTime;
		this.createBy = createBy;
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
	}*/

	@Column(name = "visit_time", length = 0)
	public Date getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	@Column(name = "group_id")
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "code", length = 128)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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