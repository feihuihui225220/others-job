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
 * HDicCheck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_dic_check")
public class HDicCheck implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：DIC相关检查
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer version;
	private long userId;
	private String aptt;
	private String pt;
	private String tt;
	private String fg;
	private String fdps;
	@SuppressWarnings("unused")
	private String dimer;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HDicCheck() {
	}

	public HDicCheck(String aptt, String pt, String tt,
			String fg, String fdps, String dimer) {
		super();
		this.aptt = aptt;
		this.pt = pt;
		this.tt = tt;
		this.fg = fg;
		this.fdps =fdps;
		this.dimer = dimer;
		
	}
	/** full constructor */
	public HDicCheck(long userId, String aptt, String pt, String tt, String fg,String fdps,String dimer,
			Date createTime, String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.aptt = aptt;
		this.pt = pt;
		this.tt = tt;
		this.fg = fg;
		this.fdps = fdps;
		this.dimer = dimer;
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

	@Column(name = "aptt", length = 32)
	public String getAptt() {
		return this.aptt;
	}

	public void setAptt(String aptt) {
		this.aptt = aptt;
	}

	@Column(name = "pt", length = 32)
	public String getPt() {
		return this.pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	@Column(name = "tt", length = 32)
	public String getTt() {
		return this.tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	@Column(name = "fg", length = 32)
	public String getFg() {
		return this.fg;
	}

	public void setFg(String fg) {
		this.fg = fg;
	}
	
	@Column(name = "fdps", length = 32)
	public String getFdps() {
		return this.fdps;
	}

	public void setFdps(String fdps) {
		this.fdps = fdps;
	}
	
	@Column(name = "dimer", length = 32)
	public String getDimer() {
		return this.fg;
	}

	public void setDimer(String dimer) {
		this.dimer = dimer;
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