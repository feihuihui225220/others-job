/**
 * 
 */
package com.anticw.aged.vo.permission;

/**
 * 添加管理用户VO
 * @author guoyongxiang
 * Date: 2014-10-8
 */
public class AUserVO {

	/** 主键 */
	private Integer id;
	/** 用户名 */
	private String name;
	/** 密码 */
	private String password;
	/** 服务商ID */
	private Integer venderId;
	/** 联系电话 */
	private String contactPhone;
	/** 角色ID列表 */
	private int[] roleIds;
	
	private String sites;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getVenderId() {
		return venderId;
	}
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public int[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
	public void setSites(String sites) {
		this.sites = sites;
	}
	public String getSites() {
		return sites;
	}
	
	
}
