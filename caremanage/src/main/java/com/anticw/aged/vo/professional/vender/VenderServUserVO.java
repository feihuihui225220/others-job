package com.anticw.aged.vo.professional.vender;

/**
 * 服务商服务用户的vo
 * <P>File name : VenderServUserVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
public class VenderServUserVO {
	
	/**
	 * 对象标识
	 */
	private int id;
	
	/**
	 * 用户Id
	 */
	private Long userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	/**
	 * 性别
	 */
	private Integer gender;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 联系电话
	 */
	private String contactPhone;
	
	/**
	 * 紧急联系人
	 */
	private String emergency;
	
	/**
	 * 紧急联系电话
	 */
	private String emergencyPhone;
	
	/**
	 * 社区Id
	 */
	private Integer communityId;
	
	/**
	 * 社区名称
	 */
	private String communityName;
	
	/**
	 * 分配状态
	 */
	private short status;
	
	/**
	 * 站点名称
	 */
	private String siteName;
	
	/**
	 * 签到情况
	 */
	private Long SignInCase;
	
	
	/**
	 * @return int 取得域 id 的方法。
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return String 取得域 userName 的方法。
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName 对域 userName 的设置方法.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return String 取得域 idCard 的方法。
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard 对域 idCard 的设置方法.
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * @return Integer 取得域 gender 的方法。
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender 对域 gender 的设置方法.
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return Integer 取得域 age 的方法。
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age 对域 age 的设置方法.
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return String 取得域 contactPhone 的方法。
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * @param contactPhone 对域 contactPhone 的设置方法.
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * @return Integer 取得域 communityId 的方法。
	 */
	public Integer getCommunityId() {
		return communityId;
	}
	/**
	 * @param communityId 对域 communityId 的设置方法.
	 */
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	/**
	 * @return String 取得域 communityName 的方法。
	 */
	public String getCommunityName() {
		return communityName;
	}
	/**
	 * @param communityName 对域 communityName 的设置方法.
	 */
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	/**
	 * @return short 取得域 status 的方法。
	 */
	public short getStatus() {
		return status;
	}
	/**
	 * @param status 对域 status 的设置方法.
	 */
	public void setStatus(short status) {
		this.status = status;
	}
	/**
	 * @return String 取得域 emergency 的方法。
	 */
	public String getEmergency() {
		return emergency;
	}
	/**
	 * @param emergency 对域 emergency 的设置方法.
	 */
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	/**
	 * @return String 取得域 emergencyPhone 的方法。
	 */
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	/**
	 * @param emergencyPhone 对域 emergencyPhone 的设置方法.
	 */
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	
	public String getSiteName() {
		return siteName;
	}
	/**
	 * 
	 * @param siteName 对 siteId
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public Long getSignInCase() {
		return SignInCase;
	}
	public void setSignInCase(Long signInCase) {
		SignInCase = signInCase;
	}

	
	
}
