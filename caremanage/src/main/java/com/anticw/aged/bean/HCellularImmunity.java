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
 * HCellularImmunity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_cellular_immunity")
public class HCellularImmunity implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：细胞免疫
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String nk;
	private String lak;
	private String TCellSubsets;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HCellularImmunity() {
	}


	public HCellularImmunity(String nk, String lak, String TCellSubsets) {
		super();
		this.nk = nk;
		this.lak = lak;
		this.TCellSubsets = TCellSubsets;
	}
	
	/** full constructor */
	public HCellularImmunity(long userId, String nk, String lak,
			String TCellSubsets, Date createTime, String createBy,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.nk = nk;
		this.lak = lak;
		this.TCellSubsets = TCellSubsets;
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

	@Column(name = "nk", length = 32)
	public String getNk() {
		return this.nk;
	}

	public void setNk(String nk) {
		this.nk = nk;
	}

	@Column(name = "lak", length = 32)
	public String getLak() {
		return this.lak;
	}

	public void setLak(String lak) {
		this.lak = lak;
	}

	@Column(name = "t_cell_subsets", length = 32)
	public String getTCellSubsets() {
		return this.TCellSubsets;
	}

	public void setTCellSubsets(String TCellSubsets) {
		this.TCellSubsets = TCellSubsets;
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