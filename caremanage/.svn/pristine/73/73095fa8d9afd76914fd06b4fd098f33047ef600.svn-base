package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * AUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_user")
public class AUser implements java.io.Serializable {

	private static final long serialVersionUID = -9058128754208186433L;
	// Fields
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "password", length = 128)
	private String password;
	@Column(name = "nickname", length = 20)
	private String nickname;
	@Column(name = "descr", length = 30)
	private String descr;
	@Column(name = "super")
	private Boolean super_;
	@Column(name = "user_category")
	private Short userCategory;
	@Column(name = "community_ids", length = 255)
	private String communityIds;
	@Column(name = "site_ids", length = 255)
	private String siteIds;
	@Transient
	private List<OCountry> oCountry;
	@Column(name = "vender_id")
	private Integer venderId;
	@Column(name = "id_card_no", length = 20)
	private String idCardNo;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "mobile_phone", length = 20)
	private String mobilePhone;
	@Column(name = "contact_phone", length = 20)
	private String contactPhone;
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "birthday", length = 19)
	private Date birthday;
	@Column(name = "addr", length = 255)
	private String addr;
	@Column(name = "available", columnDefinition = "BIT")
	private Boolean available;
	@OrderBy("created_by")
	@Column(name = "created_by", length = 20)
	private String createdBy;
	@Column(name = "created_at", length = 19)
	private Date createdAt;
	@Column(name = "changed_by", length = 20)
	private String changedBy;
	@Column(name = "changed_at", length = 19)
	private Date changedAt;
	@Version
	@Column(name = "version")
	private Short version;
	
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="a_user_role",
	joinColumns={@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)}, 
	inverseJoinColumns={@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)})
	private Set<ARole> roles;

	/**
	 * 初始化用户信息
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:42:33
	 * @param sourcePass
	 * @param user
	 * @return
	 */
	public AUser initUser(boolean super_, String opUser){
		// 1.设置管理账户默认值
		this.setSuper_(super_);
		this.setAvailable(PropertyValueConstants.AVAILABLE);
		Date date = new Date();
		this.setCreatedBy(opUser);
		this.setCreatedAt(date);
		this.setChangedBy(opUser);
		this.setChangedAt(date);
		// 密码MD5加盐
		this.setPassword(new Md5PasswordEncoder().encodePassword(this.password, this.name));
		return this;
	}
	
	/**
	 * 
	 */
	public AUser() {
		super();
	}

	/**
	 * 添加管理员账户
	 * @param name
	 * @param password
	 * @param userCategory
	 * @param communityIds
	 */
	public AUser(String name, String password, Integer venderId, Short userCategory, String communityIds) {
		super();
		this.name = name;
		this.password = password;
		this.venderId = venderId;
		this.userCategory = userCategory;
		this.communityIds = communityIds;
		this.available = PropertyValueConstants.AVAILABLE;
		this.version = 0;
	}
	
	/**
	 * 添加管理员账户
	 * @param name
	 * @param password
	 * @param userCategory
	 * @param communityIds
	 */
	public AUser(String name, String password, String nickname, Integer venderId, Short userCategory, String communityIds) {
		super();
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.venderId = venderId;
		this.userCategory = userCategory;
		this.communityIds = communityIds;
		this.available = PropertyValueConstants.AVAILABLE;
		this.version = 0;
	}
	
	/**
	 * @param name
	 * @param password
	 * @param super_
	 * @param userCategory
	 * @param communityIds
	 * @param contactPhone
	 * @param opUser
	 * @param roles
	 */
	public AUser(String name, String password, Boolean super_, Short userCategory, String communityIds, String contactPhone,
			String opUser, Set<ARole> roles) {
		super();
		this.name = name;
		this.password = password;
		this.super_ = super_;
		this.userCategory = userCategory;
		this.communityIds = communityIds;
		this.contactPhone = contactPhone;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date date = new Date();
		this.createdAt = date;
		this.changedBy = opUser;
		this.changedAt = date;
		this.version = 0;
		this.roles = roles;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param nickname
	 * @param descr
	 * @param super_
	 * @param userCategory
	 * @param communityIds
	 * @param siteIds
	 * @param oCountry
	 * @param venderId
	 * @param idCardNo
	 * @param email
	 * @param mobilePhone
	 * @param contactPhone
	 * @param gender
	 * @param birthday
	 * @param addr
	 * @param available
	 * @param createdBy
	 * @param createdAt
	 * @param changedBy
	 * @param changedAt
	 * @param version
	 * @param roles
	 */
	public AUser(String name, String password, String nickname, String descr,
			Boolean super_, Short userCategory, String communityIds,
			String siteIds, List<OCountry> oCountry, Integer venderId,
			String idCardNo, String email, String mobilePhone,
			String contactPhone, Integer gender, Date birthday, String addr,
			Boolean available, String createdBy, Date createdAt,
			String changedBy, Date changedAt, Short version, Set<ARole> roles) {
		super();
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.descr = descr;
		this.super_ = super_;
		this.userCategory = userCategory;
		this.communityIds = communityIds;
		this.siteIds = siteIds;
		this.oCountry = oCountry;
		this.venderId = venderId;
		this.idCardNo = idCardNo;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.contactPhone = contactPhone;
		this.gender = gender;
		this.birthday = birthday;
		this.addr = addr;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
		this.roles = roles;
	}
	
	// Property accessors
	public Integer getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Boolean getSuper_() {
		return this.super_;
	}

	public void setSuper_(Boolean super_) {
		this.super_ = super_;
	}

	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	public Short getUserCategory() {
		return this.userCategory;
	}

	public void setUserCategory(Short userCategory) {
		this.userCategory = userCategory;
	}

	public String getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	/**
	 * @return the roles
	 */
	public Set<ARole> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<ARole> roles) {
		this.roles = roles;
	}

	public List<OCountry> getoCountry() {
		return oCountry;
	}

	public void setoCountry(List<OCountry> oCountry) {
		this.oCountry = oCountry;
	}

	public String getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(String siteIds) {
		this.siteIds = siteIds;
	}
	
	
}
