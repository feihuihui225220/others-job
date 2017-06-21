package com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * OCountry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "o_country")
@Where(clause="available=1")
@JsonInclude(Include.NON_EMPTY)
public class OCountry implements java.io.Serializable {

	private static final long serialVersionUID = -2960973007747565494L;
	// Fields
	private Integer id;
	private String name;
	private String fullName;
	/** 类型:0:全国 1:省 2;市 3:区 4:街道 5:社区 */
	@JsonIgnore
	private List<String> fullNames;
	private String type;
	@JsonIgnore
	private Boolean available;
	@JsonIgnore
	private String createdBy;
	@JsonIgnore
	private Date createdAt;
	@JsonIgnore
	private String changedBy;
	@JsonIgnore
	private Date changedAt;	
	private Integer parentId;
	@JsonIgnore
	private List<OCountry> subOCountry;
	
	public OCountry() {
	}
	
	/**
	 * @param name
	 * @param fullName
	 * @param type
	 * @param available
	 * @param opUser
	 * @param parentId
	 */
	public OCountry(String name, String fullName, String type, String opUser, Integer parentId) {
		this.name = name;
		this.fullName = fullName;
		this.type = type;
		this.available = PropertyValueConstants.AVAILABLE;
		this.createdBy = opUser;
		Date data = new Date();
		this.createdAt = data;
		this.changedBy = opUser;
		this.changedAt = data;
		this.parentId = parentId;
	}

	public OCountry(String name, String fullName, String type,
			Boolean available, String createdBy, Date createdAt,
			String changedBy, Date changedAt, Integer parentId, List<OCountry> subOCountry) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.type = type;
		this.available = available;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.parentId = parentId;
		this.subOCountry = subOCountry;
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

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "available" )
	
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

	@OneToMany(targetEntity = OCountry.class, cascade = { CascadeType.ALL}, mappedBy = "parentId", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	public List<OCountry> getSubOCountry() {
		return subOCountry;
	}

	public void setSubOCountry(List<OCountry> subOCountry) {
		this.subOCountry = subOCountry;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullNames= Arrays.asList(fullName.split(","));
		this.fullName = fullName;
	}
	@Transient
	public List<String> getFullNames() {
		return fullNames;
	}
	public void setFullNames(List<String> fullNames) {
		this.fullNames = fullNames;
	}
	

}