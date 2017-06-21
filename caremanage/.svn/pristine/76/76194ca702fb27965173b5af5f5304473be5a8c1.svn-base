package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * HHumoralImmunity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_humoral_immunity")
public class HHumoralImmunity implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能： 体液免疫
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String g;
	private String a;
	private String m;
	private String d;
	private String e;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HHumoralImmunity() {
	}

	public HHumoralImmunity(String g, String a, String m,
			String d, String e) {
		super();
		this.g = g;
		this.a = a;
		this.m = m;
		this.d = d;
		this.e = e;
	}
	
	/** full constructor */
	public HHumoralImmunity(long userId, String g, String a, String m,
			String d, String e, Date createTime, String createBy,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.g = g;
		this.a = a;
		this.m = m;
		this.d = d;
		this.e = e;
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

	@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "g", length = 32)
	public String getG() {
		return this.g;
	}

	public void setG(String g) {
		this.g = g;
	}

	@Column(name = "a", length = 32)
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Column(name = "m", length = 32)
	public String getM() {
		return this.m;
	}

	public void setM(String m) {
		this.m = m;
	}

	@Column(name = "d", length = 32)
	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	@Column(name = "e", length = 32)
	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
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