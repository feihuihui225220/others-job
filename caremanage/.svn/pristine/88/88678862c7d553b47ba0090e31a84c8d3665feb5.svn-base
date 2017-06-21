package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZNotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_notice")
public class ZNotice implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8595141047341875972L;
	private Integer id;
	private String content;
	private Integer type;
	private String userContact;
	private Boolean available;
	private Date createTime;
	private Date changeTime;
	private Boolean isvalidity;
	// Constructors

	/** default constructor */
	public ZNotice() {
	}

	/** full constructor */
	public ZNotice(String content, Integer type, String userContact,
			Boolean available, Date createTime, Date changeTime) {
		this.content = content;
		this.type = type;
		this.userContact = userContact;
		this.available = available;
		this.createTime = createTime;
		this.changeTime = changeTime;
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

	@Column(name = "content", length = 256)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "user_contact", length = 16)
	public String getUserContact() {
		return this.userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	@Column(name = "is_validity")
	public Boolean getIsvalidity() {
		return isvalidity;
	}

	public void setIsvalidity(Boolean isvalidity) {
		this.isvalidity = isvalidity;
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

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

}