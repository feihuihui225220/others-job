/**
 * 
 */
package com.anticw.aged.vo.user;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 注册VO
 * @author guoyongxiang
 * Date: 2014-10-1
 */
public class RegisterVO implements BaseVO {

	/** 姓名 */
	private String name;
	/** 性别(0:女,1:男) */
	private Integer gender;
	/** 密码 */
	private String password;
	/** 重复密码 */
	private String password2;
	/** 社区ID */
	private Integer communityId;
	/**
	 * 手机号码（账号）
	 */
	private String mobilePhone;
	
	
	
	public RegisterVO() {
	}
	/**
	 * 比较查询信息
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午4:33:11
	 * @param user
	 * @return
	 */
	
	/**
	 * @return the idCardNo
	 */
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}
	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the communityId
	 */
	public Integer getCommunityId() {
		return communityId;
	}

	/**
	 * @param communityId the communityId to set
	 */
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/* (non-Javadoc)
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	@Override
	public boolean selfValidate() throws BusinessException {
		if(mobilePhone==null||"".equals(mobilePhone)){
			throw new BusinessException(ExceptionCode.USER_MOBILEPHONE_NULL);
		}
		if(name==null||"".equals(name)){
			throw new BusinessException(ExceptionCode.USER_NAME_NULL);		
		}
		/*if(gender==null||"".equals(gender)){
			throw new BusinessException(ExceptionCode.USER_GENDER_NULL);
		}*/
		/*if(password==null||"".equals(password)){
			throw new BusinessException(ExceptionCode.USER_PASS_NULL);
		}
		if(password2==null||"".equals(password2)){
			throw new BusinessException(ExceptionCode.USER_PASS_NULL);
		}
		if(!password2.equals(password)){
			throw new BusinessException(ExceptionCode.USER_PASS_DIFF);
		}*/
		if(communityId==null||"".equals(communityId)){
			throw new BusinessException(ExceptionCode.USER_COMMUNITY_NULL);
		}
		return true;
	}

	@Override
	public String toString() {
		return "RegisterVO [name=" + name + ", gender=" + gender
				+ ", password=" + password + ", password2=" + password2
				+ ", communityId=" + communityId + ", mobilePhone="
				+ mobilePhone + "]";
	}
	
	
}
