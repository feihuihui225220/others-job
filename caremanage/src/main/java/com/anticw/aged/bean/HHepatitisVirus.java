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
 * HHepatitisVirus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_hepatitis_virus")
public class HHepatitisVirus implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String havIgm;
	private String hbsag;
	private String hbsab;
	private String hbcab;
	private String hbeag;
	private String hbeab;
	private String hbv;
	private String hbvDna;
	private String hcvRna;
	private String hcv;
	private String hdv;
	private String hdvag;
	private String hdvRna;
	private String hev;
	private String hevRna;
	private String rpr;
	private String tppa;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HHepatitisVirus() {
	}

	public HHepatitisVirus(String havIgm, String hbsag, String hbsab,
			String hbcab, String hbeag, String hbeab, String hbv,
			String hbvDna, String hcvRna, String hcv,String hdv,String hdvag,
			String hdvRna,String hev,String hevRna,String rpr,String tppa) {
		super();
		this.havIgm = havIgm;
		this.hbsag = hbsag;
		this.hbsab = hbsab;
		this.hbcab = hbcab;
		this.hbeag = hbeag;
		this.hbeab = hbeab;
		this.hbv = hbv;
		this.hbvDna = hbvDna;
		this.hcvRna = hcvRna;
		this.hcv = hcv;
		this.hdv = hdv;
		this.hdvag = hdvag;
		this.hdvRna = hdvRna;
		this.hev = hev;
		this.hevRna = hevRna;
		this.rpr = rpr;
		this.tppa = tppa;
	}
	/** full constructor */
	public HHepatitisVirus(long userId, String havIgm, String hbsag,
			String hbsab, String hbcab, String hbeag, String hbeab, String hbv,
			String hbvDna, String hcvRna, String hcv, String hdv, String hdvag,
			String hdvRna, String hev, String hevRna, String rpr, String tppa,
			Date createTime, String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.havIgm = havIgm;
		this.hbsag = hbsag;
		this.hbsab = hbsab;
		this.hbcab = hbcab;
		this.hbeag = hbeag;
		this.hbeab = hbeab;
		this.hbv = hbv;
		this.hbvDna = hbvDna;
		this.hcvRna = hcvRna;
		this.hcv = hcv;
		this.hdv = hdv;
		this.hdvag = hdvag;
		this.hdvRna = hdvRna;
		this.hev = hev;
		this.hevRna = hevRna;
		this.rpr = rpr;
		this.tppa = tppa;
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

	@Column(name = "hav_igm", length = 32)
	public String getHavIgm() {
		return this.havIgm;
	}

	public void setHavIgm(String havIgm) {
		this.havIgm = havIgm;
	}

	@Column(name = "hbsag", length = 32)
	public String getHbsag() {
		return this.hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}

	@Column(name = "hbsab", length = 32)
	public String getHbsab() {
		return this.hbsab;
	}

	public void setHbsab(String hbsab) {
		this.hbsab = hbsab;
	}

	@Column(name = "hbcab", length = 32)
	public String getHbcab() {
		return this.hbcab;
	}

	public void setHbcab(String hbcab) {
		this.hbcab = hbcab;
	}

	@Column(name = "hbeag", length = 32)
	public String getHbeag() {
		return this.hbeag;
	}

	public void setHbeag(String hbeag) {
		this.hbeag = hbeag;
	}

	@Column(name = "hbeab", length = 32)
	public String getHbeab() {
		return this.hbeab;
	}

	public void setHbeab(String hbeab) {
		this.hbeab = hbeab;
	}

	@Column(name = "hbv", length = 32)
	public String getHbv() {
		return this.hbv;
	}

	public void setHbv(String hbv) {
		this.hbv = hbv;
	}

	@Column(name = "hbv_dna", length = 32)
	public String getHbvDna() {
		return this.hbvDna;
	}

	public void setHbvDna(String hbvDna) {
		this.hbvDna = hbvDna;
	}

	@Column(name = "hcv_rna", length = 32)
	public String getHcvRna() {
		return this.hcvRna;
	}

	public void setHcvRna(String hcvRna) {
		this.hcvRna = hcvRna;
	}

	@Column(name = "hcv", length = 32)
	public String getHcv() {
		return this.hcv;
	}

	public void setHcv(String hcv) {
		this.hcv = hcv;
	}

	@Column(name = "hdv", length = 32)
	public String getHdv() {
		return this.hdv;
	}

	public void setHdv(String hdv) {
		this.hdv = hdv;
	}

	@Column(name = "hdvag", length = 32)
	public String getHdvag() {
		return this.hdvag;
	}

	public void setHdvag(String hdvag) {
		this.hdvag = hdvag;
	}

	@Column(name = "hdv_rna", length = 32)
	public String getHdvRna() {
		return this.hdvRna;
	}

	public void setHdvRna(String hdvRna) {
		this.hdvRna = hdvRna;
	}

	@Column(name = "hev", length = 32)
	public String getHev() {
		return this.hev;
	}

	public void setHev(String hev) {
		this.hev = hev;
	}

	@Column(name = "hev_rna", length = 32)
	public String getHevRna() {
		return this.hevRna;
	}

	public void setHevRna(String hevRna) {
		this.hevRna = hevRna;
	}

	@Column(name = "rpr", length = 32)
	public String getRpr() {
		return this.rpr;
	}

	public void setRpr(String rpr) {
		this.rpr = rpr;
	}

	@Column(name = "tppa", length = 32)
	public String getTppa() {
		return this.tppa;
	}

	public void setTppa(String tppa) {
		this.tppa = tppa;
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