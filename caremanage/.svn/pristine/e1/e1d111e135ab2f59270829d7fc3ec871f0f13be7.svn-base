package com.anticw.aged.vo.professional.meta;



import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 数据模块项vo
 * <P>File name : DataModuleItemVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
public class DataModuleItemVO implements BaseVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 元服务id
	 */
	private Integer metaServiceId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String desc;
	
	/**
	 * 是否显示
	 */
	private Boolean isShow;
	
	/**
	 * 数据类型
	 */
	private Integer itemType;
	
	/**
	 * 页面输入参数
	 */
	private String inputParam;
	
	/**
	 * 是否报警
	 */
	private Boolean isAlarm;
	
	/**
	 * 报警下限
	 */
	private Float alarmLower;
	
	/**
	 * 报警上限
	 */
	private Float alarmUpper;
	
	
	
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
	 * @return String 取得域 desc 的方法。
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc 对域 desc 的设置方法.
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return Boolean 取得域 isShow 的方法。
	 */
	public Boolean getIsShow() {
		return isShow;
	}

	/**
	 * @param isShow 对域 isShow 的设置方法.
	 */
	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	/**
	 * @return the itemType
	 */
	public Integer getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return Boolean 取得域 isAlarm 的方法。
	 */
	public Boolean getIsAlarm() {
		return isAlarm;
	}

	/**
	 * @param isAlarm 对域 isAlarm 的设置方法.
	 */
	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	/**
	 * @return Float 取得域 alarmLower 的方法。
	 */
	public Float getAlarmLower() {
		return alarmLower;
	}

	/**
	 * @param alarmLower 对域 alarmLower 的设置方法.
	 */
	public void setAlarmLower(Float alarmLower) {
		this.alarmLower = alarmLower;
	}

	/**
	 * @return Float 取得域 alarmUpper 的方法。
	 */
	public Float getAlarmUpper() {
		return alarmUpper;
	}

	/**
	 * @param alarmUpper 对域 alarmUpper 的设置方法.
	 */
	public void setAlarmUpper(Float alarmUpper) {
		this.alarmUpper = alarmUpper;
	}
	
	/**
	 * @return Integer 取得域 metaServiceId 的方法。
	 */
	public Integer getMetaServiceId() {
		return metaServiceId;
	}

	/**
	 * @param metaServiceId 对域 metaServiceId 的设置方法.
	 */
	public void setMetaServiceId(Integer metaServiceId) {
		this.metaServiceId = metaServiceId;
	}

	/**
	 * @return the inputParam
	 */
	public String getInputParam() {
		return inputParam;
	}

	/**
	 * @param inputParam the inputParam to set
	 */
	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
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
		
		//数据模块信息不完整
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(desc)) {
			throw new BusinessException(ExceptionCode.DATA_MODULE_INFO_INCOMPLETE);
		}
		
		return true;
	}

	
}
