package com.anticw.aged.vo.professional.vender;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;


/**
 * 服务商vo
 * <P>File name : VenderVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
public class VenderVO implements BaseVO {

	/**
	 * 服务商id
	 */
	private Integer id;
	
	/**
	 * 用于标识创建改careManager的用户
	 */
	private String cmName;
	
	/**
	 * 服务商名称
	 */
	private String name;
	
	/**
	 * 所属专业服务分类
	 */
	private Integer categoryId;
	
	/**
	 * 分类名称
	 */
	private String categoryName;
	
	/**
	 * 星级
	 */
	private Short star;
	
	/**
	 * 用户Id
	 */
	private Integer userId;
	
	/**
	 * 管理员id
	 */
	private String userName;
	
	/**
	 * 管理员密码
	 */
	private String password;
	
	/**
	 * 联系电话
	 */
	private String contactPhone;
	
	/**
	 * 联系地址
	 */
	private String contactAddr;
	
	/**
	 * 联系人
	 */
	private String contact;
	
	/**
	 * 资质
	 */
	private String qualification;
	
	/**
	 * 简介
	 */
	private String introduction;
	/**
	 * 经度
	 */
	private Float longitude;
	/**
	 * 维度
	 */
	private Float latitude;

	/**
	 * @return Integer 取得域 id 的方法。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return String 取得域 name 的方法。
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 对域 name 的设置方法.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Integer 取得域 categoryId 的方法。
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId 对域 categoryId 的设置方法.
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return Short 取得域 star 的方法。
	 */
	public Short getStar() {
		return star;
	}

	/**
	 * @param star 对域 star 的设置方法.
	 */
	public void setStar(Short star) {
		this.star = star;
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
	 * @return String 取得域 contactAddr 的方法。
	 */
	public String getContactAddr() {
		return contactAddr;
	}

	/**
	 * @param contactAddr 对域 contactAddr 的设置方法.
	 */
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	/**
	 * @return String 取得域 contact 的方法。
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact 对域 contact 的设置方法.
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return String 取得域 qualification 的方法。
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification 对域 qualification 的设置方法.
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return String 取得域 introduction 的方法。
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction 对域 introduction 的设置方法.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return String 取得域 password 的方法。
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 对域 password 的设置方法.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Integer 取得域 userId 的方法。
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId 对域 userId 的设置方法.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return String 取得域 categoryName 的方法。
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName 对域 categoryName 的设置方法.
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return String 取得域 cmName 的方法。
	 */
	public String getCmName() {
		return cmName;
	}

	/**
	 * @param cmName 对域 cmName 的设置方法.
	 */
	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	/**
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/**
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-14 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		if(StringUtils.isEmpty(name)  || StringUtils.isEmpty(password) || 
		   StringUtils.isEmpty(contactAddr) || StringUtils.isEmpty(contactPhone) || StringUtils.isEmpty(introduction)) {
			throw new BusinessException(ExceptionCode.VENDER_INFO_INCOMPLETE);
		}
		return true;
	}
}
