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
 * HHormone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_hormone")
public class HHormone implements java.io.Serializable {

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：激素
	 */
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	private Integer version;
	private long userId;
	private String t3;
	private String t4;
	private String ft3;
	private String ft4;
	private String tsh;
	private String tgab;
	private String tpoab;
	private String pth;
	private String serumInsulin;
	private String calciumReducingHormone;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HHormone() {
	}


	public HHormone(String t3, String t4, String ft3,
			String ft4, String tsh, String tgab, String tpoab,
			String pth, String serumInsulin, String calciumReducingHormone) {
		super();
		this.t3 = t3;
		this.t4 = t4;
		this.ft3 = ft3;
		this.ft4 = ft4;
		this.tsh = tsh;
		this.tgab = tgab;
		this.tpoab = tpoab;
		this.pth = pth;
		this.serumInsulin = serumInsulin;
		this.calciumReducingHormone = calciumReducingHormone;
	}
	
	/** full constructor */
	public HHormone(long userId, String t3, String t4, String ft3, String ft4,
			String tsh, String tgab, String tpoab, String pth,
			String serumInsulin, String calciumReducingHormone,
			Date createTime, String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.t3 = t3;
		this.t4 = t4;
		this.ft3 = ft3;
		this.ft4 = ft4;
		this.tsh = tsh;
		this.tgab = tgab;
		this.tpoab = tpoab;
		this.pth = pth;
		this.serumInsulin = serumInsulin;
		this.calciumReducingHormone = calciumReducingHormone;
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

	@Column(name = "t3", length = 32)
	public String getT3() {
		return this.t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	@Column(name = "t4", length = 32)
	public String getT4() {
		return this.t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	@Column(name = "ft3", length = 32)
	public String getFt3() {
		return this.ft3;
	}

	public void setFt3(String ft3) {
		this.ft3 = ft3;
	}

	@Column(name = "ft4", length = 32)
	public String getFt4() {
		return this.ft4;
	}

	public void setFt4(String ft4) {
		this.ft4 = ft4;
	}

	@Column(name = "tsh", length = 32)
	public String getTsh() {
		return this.tsh;
	}

	public void setTsh(String tsh) {
		this.tsh = tsh;
	}

	@Column(name = "tgab", length = 32)
	public String getTgab() {
		return this.tgab;
	}

	public void setTgab(String tgab) {
		this.tgab = tgab;
	}

	@Column(name = "tpoab", length = 32)
	public String getTpoab() {
		return this.tpoab;
	}

	public void setTpoab(String tpoab) {
		this.tpoab = tpoab;
	}

	@Column(name = "pth", length = 32)
	public String getPth() {
		return this.pth;
	}

	public void setPth(String pth) {
		this.pth = pth;
	}

	@Column(name = "serum_insulin", length = 32)
	public String getSerumInsulin() {
		return this.serumInsulin;
	}

	public void setSerumInsulin(String serumInsulin) {
		this.serumInsulin = serumInsulin;
	}

	@Column(name = "calcium_reducing_hormone", length = 32)
	public String getCalciumReducingHormone() {
		return this.calciumReducingHormone;
	}

	public void setCalciumReducingHormone(String calciumReducingHormone) {
		this.calciumReducingHormone = calciumReducingHormone;
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