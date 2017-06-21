package com.anticw.aged.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

/**
 * AbstractMAssessGds entity provides the base persistence definition of the
 * MAssessGds entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractMAssessGds implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1032084346750433625L;
	private Integer gdsId;
	private Short sbp;
	private Short dbp;
	private Short pulse;
	private Short height;
	private Short weight;
	private Float fpg;
	private Float tc;
	private Float ldlc;
	private Float hdlc;
	private Float tg;
	private Boolean hbp;
	private Boolean dm;
	private Boolean dsLip;
	private Boolean qmi;
	private Boolean stroke;
	private Boolean smoke;
	private Short drink;
	
	private Long userId;
	private String assessHtml;
	private String brief;

	// Constructors

	/** default constructor */
	public AbstractMAssessGds() {
	}

	/** full constructor */
	public AbstractMAssessGds(Short sbp, Short dbp, Short pulse, Short height,
			Short weight, Float fpg, Float tc, Float ldlc, Float hdlc,
			Float tg, Boolean hbp, Boolean dm, Boolean dsLip, Boolean qmi,
			Boolean stroke, Boolean smoke, Short drink, Long userId,
			String assessHtml, String brief) {
		this.sbp = sbp;
		this.dbp = dbp;
		this.pulse = pulse;
		this.height = height;
		this.weight = weight;
		this.fpg = fpg;
		this.tc = tc;
		this.ldlc = ldlc;
		this.hdlc = hdlc;
		this.tg = tg;
		this.hbp = hbp;
		this.dm = dm;
		this.dsLip = dsLip;
		this.qmi = qmi;
		this.stroke = stroke;
		this.smoke = smoke;
		this.drink = drink;
		this.userId = userId;
		this.assessHtml = assessHtml;
		this.brief = brief;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gds_id", unique = true, nullable = false)
	public Integer getGdsId() {
		return this.gdsId;
	}

	public void setGdsId(Integer gdsId) {
		this.gdsId = gdsId;
	}

	@Column(name = "sbp")
	public Short getSbp() {
		return this.sbp;
	}

	public void setSbp(Short sbp) {
		this.sbp = sbp;
	}

	@Column(name = "dbp")
	public Short getDbp() {
		return this.dbp;
	}

	public void setDbp(Short dbp) {
		this.dbp = dbp;
	}

	@Column(name = "pulse")
	public Short getPulse() {
		return this.pulse;
	}

	public void setPulse(Short pulse) {
		this.pulse = pulse;
	}

	@Column(name = "height")
	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	@Column(name = "weight")
	public Short getWeight() {
		return this.weight;
	}

	public void setWeight(Short weight) {
		this.weight = weight;
	}

	@Column(name = "fpg", precision = 12, scale = 0)
	public Float getFpg() {
		return this.fpg;
	}

	public void setFpg(Float fpg) {
		this.fpg = fpg;
	}

	@Column(name = "tc", precision = 12, scale = 0)
	public Float getTc() {
		return this.tc;
	}

	public void setTc(Float tc) {
		this.tc = tc;
	}

	@Column(name = "ldlc", precision = 12, scale = 0)
	public Float getLdlc() {
		return this.ldlc;
	}

	public void setLdlc(Float ldlc) {
		this.ldlc = ldlc;
	}

	@Column(name = "hdlc", precision = 12, scale = 0)
	public Float getHdlc() {
		return this.hdlc;
	}

	public void setHdlc(Float hdlc) {
		this.hdlc = hdlc;
	}

	@Column(name = "tg", precision = 12, scale = 0)
	public Float getTg() {
		return this.tg;
	}

	public void setTg(Float tg) {
		this.tg = tg;
	}

	@Column(name = "hbp")
	public Boolean getHbp() {
		return this.hbp;
	}

	public void setHbp(Boolean hbp) {
		this.hbp = hbp;
	}

	@Column(name = "dm")
	public Boolean getDm() {
		return this.dm;
	}

	public void setDm(Boolean dm) {
		this.dm = dm;
	}

	@Column(name = "dsLip")
	public Boolean getDsLip() {
		return this.dsLip;
	}

	public void setDsLip(Boolean dsLip) {
		this.dsLip = dsLip;
	}

	@Column(name = "qmi")
	public Boolean getQmi() {
		return qmi;
	}

	public void setQmi(Boolean qmi) {
		this.qmi = qmi;
	}
	@Column(name = "stroke")
	public Boolean getStroke() {
		return stroke;
	}

	public void setStroke(Boolean stroke) {
		this.stroke = stroke;
	}
	
	public Boolean getSmoke() {
		return smoke;
	} 

	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}
	@Column(name = "drink")
	public Short getDrink() {
		return drink;
	}

	public void setDrink(Short drink) {
		this.drink = drink;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY)   
	@Type(type = "text")
	@Column(name = "assess_html", nullable=true)   
	public String getAssessHtml() {
		return this.assessHtml;
	}

	public void setAssessHtml(String assessHtml) {
		this.assessHtml = assessHtml;
	}
	
	@Column(name = "brief")   
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	
}