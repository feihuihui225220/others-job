package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ARoleResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "a_role_resource")
public class ARoleResource implements java.io.Serializable {

	private static final long serialVersionUID = 254701874539709325L;
	// Fields
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "role_id")
	private Integer roleId;
	@Column(name = "res_id")
	private Integer resId;

	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getResId() {
		return this.resId;
	}
	public void setResId(Integer resId) {
		this.resId = resId;
	}
}