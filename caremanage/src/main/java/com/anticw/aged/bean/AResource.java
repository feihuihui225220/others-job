package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * AResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_resource")
public class AResource implements java.io.Serializable {

	private static final long serialVersionUID = 5584550695478551570L;
	// Fields
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "parent_id")
	private Integer parentId;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "type")
	private Integer type;
	@Column(name = "url")
	private String url;
	@Column(name = "user_category")
	private Short userCategory;
	@Column(name = "descr")
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
	@Column(name="img_url")
	private String imgUrl;
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@ManyToMany(mappedBy = "resources", fetch = FetchType.LAZY)
	private Set<ARole> roles;

	
	/**
	 * 初始化资源信息
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:42:33
	 * @param opUser
	 * @return
	 */
	public AResource initResource(String opUser){
		this.setAvailable(PropertyValueConstants.AVAILABLE);
		Date date = new Date();
		this.setParentId(0);
		this.setType(0);
		this.setCreatedBy(opUser);
		this.setCreatedAt(date);
		this.setChangedBy(opUser);
		this.setChangedAt(date);
		return this;
	}
	
	// Constructors

	/** default constructor */
	public AResource() {
	}

	/** full constructor */
	public AResource(String name, Integer type, String url, Short userCategory, String descr,			String createdBy) {
		this.parentId = 0;
		this.name = name;
		this.type = 0;
		this.url = url;
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

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

}
