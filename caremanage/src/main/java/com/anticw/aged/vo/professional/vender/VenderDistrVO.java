package com.anticw.aged.vo.professional.vender;


/**
 * 服务商人员分配vo
 * <P>File name : VenderDistrVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
public class VenderDistrVO {

	/**
	 * 对象标识
	 */
	private Integer venderId;
	
	/**
	 * 用户Id
	 */
	private Long userId;
	
	/**
	 * 管理员Id
	 */
	private long adminId;
	
	/**
	 * 管理员名称
	 */
	private String adminName;
	
	/**
	 * 分配数量
	 */
	private Integer count;
	
	/**  
	 * 分配人
	 */
	private String distrBy;
	
	/**  
	 * return String 获取域distrBy的方法。
	 */
	public String getDistrBy() {
		return distrBy;
	}
	
	/**  
	 * param String 设置域distrBy的方法。  
	 */
	public void setDistrBy(String distrBy) {
		this.distrBy = distrBy;
	}

	/**
	 * @return Long 取得域 userId 的方法。
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return Integer 取得域 adminId 的方法。
	 */
	public long getAdminId() {
		return adminId;
	}

	/**
	 * @param result 对域 adminId 的设置方法.
	 */
	public void setAdminId(long result) {
		this.adminId = result;
	}

	/**
	 * @return String 取得域 adminName 的方法。
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName 对域 adminName 的设置方法.
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return Integer 取得域 count 的方法。
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count 对域 count 的设置方法.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return Integer 取得域 venderId 的方法。
	 */
	public Integer getVenderId() {
		return venderId;
	}

	/**
	 * @param venderId 对域 venderId 的设置方法.
	 */
	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}
}
