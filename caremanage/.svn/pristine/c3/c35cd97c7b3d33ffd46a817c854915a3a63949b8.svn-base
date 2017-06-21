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
 * ZVipIntroduce entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_vip_introduce")
public class ZVipIntroduce implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1337865438308739424L;
	private Integer id;
	private Integer version;
	private String url;
	private String serviceName;
	private String chargeInfo;
	private String serviceDetail;
	private Boolean available;
	private Date createTime;
	private String createUser;
	private Date changeTime;
	private String changeUser;

	// Constructors

	/** default constructor */
	public ZVipIntroduce() {
	}

	/** full constructor */
	public ZVipIntroduce(String url, String serviceName, String chargeInfo,
			String serviceDetail, Boolean available, Date createTime,
			String createUser, Date changeTime, String changeUser) {
		this.url = url;
		this.serviceName = serviceName;
		this.chargeInfo = chargeInfo;
		this.serviceDetail = serviceDetail;
		this.available = available;
		this.createTime = createTime;
		this.createUser = createUser;
		this.changeTime = changeTime;
		this.changeUser = changeUser;
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

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "service_name", length = 128)
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "charge_info", length = 128)
	public String getChargeInfo() {
		return this.chargeInfo;
	}

	public void setChargeInfo(String chargeInfo) {
		this.chargeInfo = chargeInfo;
	}

	@Column(name = "service_detail", length = 16)
	public String getServiceDetail() {
		return this.serviceDetail;
	}

	public void setServiceDetail(String serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user", length = 64)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_user", length = 64)
	public String getChangeUser() {
		return this.changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}

}