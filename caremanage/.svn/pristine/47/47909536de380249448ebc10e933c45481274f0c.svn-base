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
 * HLiverFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_liver_function")
public class HLiverFunction implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能： 肝功能
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String preAlbumin;
	private String totalProtein;
	private String albumin;
	private String albuminRatio;
	private String atl;
	private String ast;
	private String akp;
	private String gt;
	private String serumAmylase;
	private String totalBilirubin;
	private String directBilirubin;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HLiverFunction() {
	}

	public HLiverFunction(String preAlbumin, String totalProtein, String albumin,
			String albuminRatio, String atl, String ast, String akp,
			String gt, String serumAmylase, String totalBilirubin, String directBilirubin) {
		super();
		this.preAlbumin = preAlbumin;
		this.totalProtein = totalProtein;
		this.albumin = albumin;
		this.albuminRatio = albuminRatio;
		this.atl = atl;
		this.ast = ast;
		this.akp = akp;
		this.gt = gt;
		this.serumAmylase = serumAmylase;
		this.totalBilirubin = totalBilirubin;
		this.directBilirubin = directBilirubin;
	}

	/** full constructor */
	public HLiverFunction(long userId, String preAlbumin, String totalProtein,
			String albumin, String albuminRatio, String atl, String ast,
			String akp, String gt, String serumAmylase, String totalBilirubin,
			String directBilirubin, Date createTime, String createBy,
			Date changeTime, String changeBy) {
		this.userId = userId;
		this.preAlbumin = preAlbumin;
		this.totalProtein = totalProtein;
		this.albumin = albumin;
		this.albuminRatio = albuminRatio;
		this.atl = atl;
		this.ast = ast;
		this.akp = akp;
		this.gt = gt;
		this.serumAmylase = serumAmylase;
		this.totalBilirubin = totalBilirubin;
		this.directBilirubin = directBilirubin;
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

	@Column(name = "pre_albumin", length = 32)
	public String getPreAlbumin() {
		return this.preAlbumin;
	}

	public void setPreAlbumin(String preAlbumin) {
		this.preAlbumin = preAlbumin;
	}

	@Column(name = "total_protein", length = 32)
	public String getTotalProtein() {
		return this.totalProtein;
	}

	public void setTotalProtein(String totalProtein) {
		this.totalProtein = totalProtein;
	}

	@Column(name = "albumin", length = 32)
	public String getAlbumin() {
		return this.albumin;
	}

	public void setAlbumin(String albumin) {
		this.albumin = albumin;
	}

	@Column(name = "albumin_ratio", length = 32)
	public String getAlbuminRatio() {
		return this.albuminRatio;
	}

	public void setAlbuminRatio(String albuminRatio) {
		this.albuminRatio = albuminRatio;
	}

	@Column(name = "atl", length = 32)
	public String getAtl() {
		return this.atl;
	}

	public void setAtl(String atl) {
		this.atl = atl;
	}

	@Column(name = "ast", length = 32)
	public String getAst() {
		return this.ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	@Column(name = "akp", length = 32)
	public String getAkp() {
		return this.akp;
	}

	public void setAkp(String akp) {
		this.akp = akp;
	}

	@Column(name = "gt", length = 32)
	public String getGt() {
		return this.gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	@Column(name = "serum_amylase", length = 32)
	public String getSerumAmylase() {
		return this.serumAmylase;
	}

	public void setSerumAmylase(String serumAmylase) {
		this.serumAmylase = serumAmylase;
	}

	@Column(name = "total_bilirubin", length = 32)
	public String getTotalBilirubin() {
		return this.totalBilirubin;
	}

	public void setTotalBilirubin(String totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}

	@Column(name = "direct_bilirubin", length = 32)
	public String getDirectBilirubin() {
		return this.directBilirubin;
	}

	public void setDirectBilirubin(String directBilirubin) {
		this.directBilirubin = directBilirubin;
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