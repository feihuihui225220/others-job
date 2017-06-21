package com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 * MStateCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_plan_category", catalog = "")
public class MPlanCategory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short version;
	private String name;
	//private Integer parentId;
	private Boolean available;
	private String createdBy;
	private Date changedAt;
	private String changedBy;
	private Date createdAt;
    private MPlanCategory parentPlanCategory;
    private Set<MPlanCategory> mPlanCategory=new HashSet<MPlanCategory>(0);
	// Constructors

	/** default constructor */
	public MPlanCategory() {
	}

	/** full constructor */
	public MPlanCategory(Short version, String name, Boolean available,
			String createdBy, Date changedAt, String changedBy, Date createdAt,
			MPlanCategory parentPlanCategory) {
		super();
		this.version = version;
		this.name = name;
		this.available = available;
		this.createdBy = createdBy;
		this.changedAt = changedAt;
		this.changedBy = changedBy;
		this.createdAt = createdAt;
		this.parentPlanCategory = parentPlanCategory;
	}
	

	public MPlanCategory(Integer id) {
		super();
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
	public Integer getId() {
		return this.id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "changed_at", length = 19)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "changed_by", length = 20)
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@ManyToOne
    @JoinColumn(name = "parent_id")
	@NotFound(action=NotFoundAction.IGNORE) 
	public MPlanCategory getParentPlanCategory() {
		return parentPlanCategory;
	}

	public void setParentPlanCategory(MPlanCategory parentPlanCategory) {
		this.parentPlanCategory = parentPlanCategory;
	}
	@OneToMany(mappedBy="parentPlanCategory",targetEntity=MPlanCategory.class,cascade=CascadeType.ALL)
	public Set<MPlanCategory> getmPlanCategory() {
		return mPlanCategory;
	}

	public void setmPlanCategory(Set<MPlanCategory> mPlanCategory) {
		this.mPlanCategory = mPlanCategory;
	}

	
}