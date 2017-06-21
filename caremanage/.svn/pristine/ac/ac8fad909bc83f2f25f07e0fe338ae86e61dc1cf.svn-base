/**
 * 
 */
package com.anticw.aged.bean.utils;

/**
 * 管理帐号类型枚举
 * @author guoyongxiang
 * Date: 2014-10-1
 */
public enum UserCategoryEnum {

	SYS(0,"系统超管", 1),
	USER(1,"用户", 2),
	CMT(2,"社区", 3),
	STREET(7,"街道", 8),
	CM(3,"关爱管理", 4),
	PRO(4,"专业服务商", 5),
	CARE(5,"执行主任", 6),
	CC(6,"呼叫中心", 7)
	;
	
	/** 默认首页 */
	private static final String DEF_INDEX = "/index.jsp";
	/**
	 * @param type
	 * @param name
	 */
	private UserCategoryEnum(int type, String name) {
		this.type = type;
		this.name = name;
		this.index = DEF_INDEX;
	}
	
	/**
	 * @param type  登录帐号类型
	 * @param name  帐号名称
	 * @param index 首页
	 */
	private UserCategoryEnum(int type, String name, String index) {
		this.type = type;
		this.name = name;
		this.index = index==null||"".equals(index)?DEF_INDEX:index;
	}
	
	/**
	 * @param type
	 * @param name
	 * @param index
	 * @param defSysRoleId
	 */
	private UserCategoryEnum(int type, String name, String index, int defSysRoleId) {
		this.type = type;
		this.name = name;
		this.index = index;
		this.defSysRoleId = defSysRoleId;
	}

	/**
	 * @param type  登录帐号类型
	 * @param name  帐号名称
	 * @param defSysRoleId 默认系统角色ID
	 */
	private UserCategoryEnum(int type, String name, int defSysRoleId) {
		this.type = type;
		this.name = name;
		this.index = index==null||"".equals(index)?DEF_INDEX:index;
		this.defSysRoleId = defSysRoleId;
	}
	
	private int type;
	private String name;
	private String index;
	private int defSysRoleId;
	
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getIndex() {
		return index;
	}

	public int getDefSysRoleId() {
		return defSysRoleId;
	}
	
}
