package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserConstants;

/**
 * RUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "r_user")
public class RUser implements java.io.Serializable {

	private static final long serialVersionUID = 5080228936760451087L;
	// Fields
	private Long id;
	private String idCardNo;
	private String password;
	private String head;
	private String name;
	private String mobilePhone;
	private String contactPhone;
	private Integer age;
	private Integer gender;
	private Date birthday;
	private Integer hrType;
	private String hrAddr;
	private Integer marry;
	private Integer political;
	private Integer education;
	private Integer communityId;
	private String addr;
	private Integer lifeCond;
	private Integer jobCond;
	private Integer medical;
	private Integer religion;
	private Integer nation;
	private Integer active;//是否审核/是否分配（0，审核中，1未分配，2已分配）
	private Integer income;
	private Boolean available;
	private String createdBy;
	private Date createdAt;
	private String changedBy;
	private Date changedAt;
	private Short version;
	
	private Integer buildingId;
	private Integer state;
	
	
	
	private MVenderUsers mVenderUsers;
	/** 用户体适能信息 */
	private Set<MAssessFitness>  mAssessFitness;
	 
	private RUserDefault rUserDefault;
	/** 用户特殊信息 */
	private RSpecia specia;
	
	/** 用户联系人 */
	private List<RContact> rContact;
	
	// Constructors

	/** default constructor */
	public RUser() {
	}

	

	/**
	 * @param idCardNo
	 * @param head
	 * @param name
	 * @param mobilePhone
	 * @param contactPhone
	 * @param age
	 * @param gender
	 * @param birthday
	 * @param hrType
	 * @param hrAddr
	 * @param marry
	 * @param political
	 * @param education
	 * @param communityId
	 * @param addr
	 * @param lifeCond
	 * @param jobCond
	 * @param medical
	 * @param religion
	 * @param nation
	 * @param active
	 * @param income
	 * @param opUser
	 */
	public RUser(String idCardNo, String head, String name, String mobilePhone, String contactPhone, Integer age,
			Integer gender, Date birthday, Integer hrType, String hrAddr, Integer marry, Integer political, Integer education,
			Integer communityId, String addr, Integer lifeCond, Integer jobCond, Integer medical, Integer religion, Integer nation,
			Integer active, Integer income, String opUser) {
		super();
		this.idCardNo = idCardNo;
		int lastCount = UserConstants.USER_DEF_PASS_LAST_COUNT;
		lastCount = mobilePhone.length()>lastCount?lastCount:mobilePhone.length();
		String last =mobilePhone.substring(mobilePhone.length()-lastCount, mobilePhone.length());
		this.password = new Md5PasswordEncoder().encodePassword(last, mobilePhone);
		this.head = head;
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.contactPhone = contactPhone;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.hrType = hrType;
		this.hrAddr = hrAddr;
		this.marry = marry;
		this.political = political;
		this.education = education;
		this.communityId = communityId;
		this.addr = addr;
		this.lifeCond = lifeCond;
		this.jobCond = jobCond;
		this.medical = medical;
		this.religion = religion;
		this.nation = nation;
		this.active = active;
		this.income = income;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date date = new Date();
		this.createdAt = date;
		this.changedBy = opUser;
		this.changedAt = date;
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

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "head", length = 255)
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Column(name = "id_card_no", length = 20)
	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	@Column(name = "mobile_phone", length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "contact_phone", length = 20)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return gender;
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

	@Column(name = "hr_type")
	public Integer getHrType() {
		return this.hrType;
	}

	public void setHrType(Integer hrType) {
		this.hrType = hrType;
	}

	@Column(name = "hr_addr")
	public String getHrAddr() {
		return this.hrAddr;
	}

	public void setHrAddr(String hrAddr) {
		this.hrAddr = hrAddr;
	}

	@Column(name = "marry")
	public Integer getMarry() {
		return this.marry;
	}

	public void setMarry(Integer marry) {
		this.marry = marry;
	}

	@Column(name = "political")
	public Integer getPolitical() {
		return this.political;
	}

	public void setPolitical(Integer political) {
		this.political = political;
	}

	@Column(name = "education")
	public Integer getEducation() {
		return this.education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	@Column(name = "community_id")
	public Integer getCommunityId() {
		return this.communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	@Column(name = "addr")
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "life_cond")
	public Integer getLifeCond() {
		return this.lifeCond;
	}

	public void setLifeCond(Integer lifeCond) {
		this.lifeCond = lifeCond;
	}

	@Column(name = "job_cond")
	public Integer getJobCond() {
		return this.jobCond;
	}

	public void setJobCond(Integer jobCond) {
		this.jobCond = jobCond;
	}

	@Column(name = "medical")
	public Integer getMedical() {
		return this.medical;
	}

	public void setMedical(Integer medical) {
		this.medical = medical;
	}

	@Column(name = "religion")
	public Integer getReligion() {
		return this.religion;
	}

	public void setReligion(Integer religion) {
		this.religion = religion;
	}

	@Column(name = "nation")
	public Integer getNation() {
		return this.nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	@Column(name = "active")
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Column(name = "income")
	public Integer getIncome() {
		return this.income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "created_by", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_at", length = 19)
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
	 * @return the buildingId
	 */
	@Column(name="building_id")
	public Integer getBuildingId() {
		return buildingId;
	}

	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
	@Column(name="state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the specia
	 */
	@OneToOne(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	public RSpecia getSpecia() {
		return specia;
	}

	/**
	 * @param specia the specia to set
	 */
	public void setSpecia(RSpecia specia) {
		this.specia = specia;
	}


	@OneToOne(mappedBy="rUser",fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	public MVenderUsers getmVenderUsers() {
		return mVenderUsers;
	}

	public void setmVenderUsers(MVenderUsers mVenderUsers) {
		this.mVenderUsers = mVenderUsers;
	}
	
	@OneToOne(mappedBy="rUser",fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	public RUserDefault getrUserDefault() {
		return rUserDefault;
	}

	public void setrUserDefault(RUserDefault rUserDefault) {
		this.rUserDefault = rUserDefault;
	}

	
	//------------------------------------------------------------
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Set<MAssessFitness> getmAssessFitness() {
		return mAssessFitness;
	}

	public void setmAssessFitness(Set<MAssessFitness> mAssessFitness) {
		this.mAssessFitness = mAssessFitness;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public List<RContact> getrContact() {
		return rContact;
	}
	public void setrContact(List<RContact> rContact) {
		this.rContact = rContact;
	}

}