package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * RSpecia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "r_specia")
public class RSpecia implements java.io.Serializable {

	private static final long serialVersionUID = -4504312420372502308L;
	// Fields
	private Long id;
	private Short version;
	private Integer three;
	private Integer disable;
	private Integer noSecurity;
	private Integer lonely;
	private Integer lessIncome;
	private Integer emptyNest;
	private Integer lostOnly;
	private Integer specialCare;
	private Integer lifeLonely;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	
	private RUser user;

	// Constructors

	/** default constructor */
	public RSpecia() {
	}

	/** full constructor */
	public RSpecia(Integer three, Integer disable, Integer noSecurity, Integer lonely, Integer lessIncome, Integer emptyNest,
			Integer lostOnly, Integer specialCare, Integer lifeLonely, String opUser, RUser user) {
		this.three = three;
		this.disable = disable;
		this.noSecurity = noSecurity;
		this.lonely = lonely;
		this.lessIncome = lessIncome;
		this.emptyNest = emptyNest;
		this.lostOnly = lostOnly;
		this.specialCare = specialCare;
		this.lifeLonely = lifeLonely;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date date = new Date();
		this.createdAt = date;
		this.changedBy = opUser;
		this.changedAt = date;
		this.user = user;
		this.version = 0;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = true)
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "three", nullable = true)
	public Integer getThree() {
		return this.three;
	}

	public void setThree(Integer three) {
		this.three = three;
	}

	@Column(name = "disable", nullable = true)
	public Integer getDisable() {
		return this.disable;
	}

	public void setDisable(Integer disable) {
		this.disable = disable;
	}

	@Column(name = "no_security", nullable = true)
	public Integer getNoSecurity() {
		return this.noSecurity;
	}

	public void setNoSecurity(Integer noSecurity) {
		this.noSecurity = noSecurity;
	}

	@Column(name = "lonely", nullable = true)
	public Integer getLonely() {
		return this.lonely;
	}

	public void setLonely(Integer lonely) {
		this.lonely = lonely;
	}

	@Column(name = "less_income", nullable = true)
	public Integer getLessIncome() {
		return this.lessIncome;
	}

	public void setLessIncome(Integer lessIncome) {
		this.lessIncome = lessIncome;
	}

	@Column(name = "empty_nest", nullable = true)
	public Integer getEmptyNest() {
		return this.emptyNest;
	}

	public void setEmptyNest(Integer emptyNest) {
		this.emptyNest = emptyNest;
	}

	@Column(name = "lost_only", nullable = true)
	public Integer getLostOnly() {
		return this.lostOnly;
	}

	public void setLostOnly(Integer lostOnly) {
		this.lostOnly = lostOnly;
	}

	@Column(name = "special_care", nullable = true)
	public Integer getSpecialCare() {
		return this.specialCare;
	}

	public void setSpecialCare(Integer specialCare) {
		this.specialCare = specialCare;
	}

	@Column(name = "life_lonely", nullable = true)
	public Integer getLifeLonely() {
		return this.lifeLonely;
	}

	public void setLifeLonely(Integer lifeLonely) {
		this.lifeLonely = lifeLonely;
	}

	@Column(name = "available", nullable = true)
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", nullable = false, length = 20,updatable=false)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", nullable = false, length = 19,updatable=false)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", nullable = false, length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", nullable = false, length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @return the user
	 */
	@OneToOne
	@JoinColumn(name="user_id", unique=true)
	public RUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(RUser user) {
		this.user = user;
	}

}