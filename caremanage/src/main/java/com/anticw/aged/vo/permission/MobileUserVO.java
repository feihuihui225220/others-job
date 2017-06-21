/**
 * 
 */
package com.anticw.aged.vo.permission;

import com.anticw.aged.bean.utils.UserCategoryEnum;

/**
 * 移动端用户VO
 * @author guoyongxiang
 * Date: 2014-10-15
 */
public class MobileUserVO {

	/** ID */
	protected long id;
	/** 用户名 */
	protected String name;
	/** 姓名 */
	protected String realName;
	/** 账户类型枚举 */
	protected UserCategoryEnum cateEnum;
	/** 父级用户名 */
	private String parentName;
	/** 服务商ID */
	protected Integer venderId;
	/** 社区ID */
	protected String communityId;
	/** 是否是管理员 */
	protected boolean super_;
	
	
	/**
	 * 
	 */
	public MobileUserVO() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param realName
	 * @param cateEnum
	 * @param venderId
	 * @param communityId
	 * @param super_
	 */
	public MobileUserVO(long id, String name, String realName, UserCategoryEnum cateEnum, String parentName, Integer venderId, String communityId,
			boolean super_) {
		super();
		this.id = id;
		this.name = name;
		this.realName = realName;
		this.cateEnum = cateEnum;
		this.parentName = parentName;
		this.venderId = venderId;
		this.communityId = communityId;
		this.super_ = super_;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getVenderId() {
		return venderId;
	}
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public UserCategoryEnum getCateEnum() {
		return cateEnum;
	}
	public void setCateEnum(UserCategoryEnum cateEnum) {
		this.cateEnum = cateEnum;
	}
	public String getCommunityId() {
		return communityId;
	}
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	public boolean isSuper_() {
		return super_;
	}
	public void setSuper_(boolean super_) {
		this.super_ = super_;
	}
}
