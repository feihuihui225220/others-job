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

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * RContact entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "r_contact")
public class RContact implements java.io.Serializable {

	private static final long serialVersionUID = 7850874580942841657L;
	// Fields
	private Long id;
	private String idCardNo;
	private String name;
	private Integer relation;
	private String mobilePhone;
	private Integer gender;
	private Date birthday;
	private String addr;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Short version;

	/** 用户信息 */
	private RUser user;

	// Constructors

	/** default constructor */
	public RContact() {
	}

	/**
	 * @param idCardNo
	 * @param name
	 * @param relation
	 * @param mobilePhone
	 * @param gender
	 * @param birthday
	 * @param addr
	 * @param opUser
	 * @param user
	 */
	public RContact(String idCardNo, String name, Integer relation, String mobilePhone, Integer gender, Date birthday, String addr,
			String opUser, RUser user) {
		super();
		this.idCardNo = idCardNo;
		this.name = name;
		this.relation = relation;
		this.mobilePhone = mobilePhone;
		this.gender = gender;
		this.birthday = birthday;
		this.addr = addr;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date date = new Date();
		this.createdAt = date;
		this.changedBy = opUser;
		this.changedAt = date;
		this.version = 0;
		this.user = user;
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

	@Column(name = "id_card_no", length = 20)
	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "relation")
	public Integer getRelation() {
		return this.relation;
	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}

	@Column(name = "mobile_phone", length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "birthday", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "addr")
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at")
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "changed_by", length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "changed_at", length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	/**
	 * @return the user
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id")
	public RUser getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(RUser user) {
		this.user = user;
	}

}