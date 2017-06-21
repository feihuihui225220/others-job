package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Where;

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * ARole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_role")
public class ARole implements java.io.Serializable {

	private static final long serialVersionUID = -8859228066828935120L;
	// Fields
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "user_category")
	private Short userCategory;
	@Column(name = "descr", length = 30)
	private String descr;
	@Column(name = "available", columnDefinition = "BIT")
	private Boolean available;
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

	@OrderBy("id")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<AUser> users;
	
	@OrderBy("id")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@ManyToMany
	@JoinTable(name="a_role_resource",
	joinColumns={@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)}, 
	inverseJoinColumns={@JoinColumn(name = "res_id", referencedColumnName = "id", nullable = false)})
	@Where(clause = "available=1")
	private Set<AResource> resources;

	/**
	 * 初始化角色信息
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:42:33
	 * @param opUser
	 * @return
	 */
	public ARole initRole(String opUser){
		this.setAvailable(PropertyValueConstants.AVAILABLE);
		Date date = new Date();
		this.setCreatedBy(opUser);
		this.setCreatedAt(date);
		this.setChangedBy(opUser);
		this.setChangedAt(date);
		return this;
	}
	
	// Constructors

	/** default constructor */
	public ARole() {
	}

	/** full constructor */
	public ARole(String name, Short userCategory, String descr, String createdBy) {
		this.name = name;
		this.userCategory = userCategory;
		this.descr = descr;
		this.available = PropertyValueConstants.AVAILABLE;
		Date date = new Date();
		this.createdBy = createdBy;
		this.createdAt = date;
		this.changedBy = createdBy;
		this.changedAt = date;
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

	public Short getUserCategory() {
		return this.userCategory;
	}

	public void setUserCategory(Short userCategory) {
		this.userCategory = userCategory;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
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
	 * @return the users
	 */
	public Set<AUser> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<AUser> users) {
		this.users = users;
	}

	/**
	 * @return the resources
	 */
	public Set<AResource> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<AResource> resources) {
		this.resources = resources;
	}

}