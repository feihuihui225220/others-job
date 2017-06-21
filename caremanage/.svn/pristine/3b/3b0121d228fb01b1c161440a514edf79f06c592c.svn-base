package com.anticw.aged.vo.professional.device;

import org.apache.commons.lang.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 设备类型vo
 * <P>File name : DeviceTypeVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
public class DeviceTypeVO implements BaseVO {
	
	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 设备类型名称
	 */
	private String name;
	
	/**
	 *	设备描述
	 */
	private String descr;
	
	/**
	 * 设备类型资质
	 */
	private String qualification;

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
	 * @return String 取得域 descr 的方法。
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr 对域 descr 的设置方法.
	 */
	public void setDescr(String descr) {
		this.descr = descr;
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
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		
		if(StringUtils.isEmpty(this.name) ||
		   StringUtils.isEmpty(this.descr) ||
		   StringUtils.isEmpty(this.qualification)){
			
			throw new BusinessException(ExceptionCode.DEVICE_TYPE_INFO_INCOMPLETE);
		}
		
		return false;
	}
}
