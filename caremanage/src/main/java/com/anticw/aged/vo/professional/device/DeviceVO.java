package com.anticw.aged.vo.professional.device;

import java.util.List;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 设备vo
 * <P>File name : DeviceVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
public class DeviceVO implements BaseVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 设备名称
	 */
	private String name;
	
	/**
	 * 设备厂商
	 */
	private String vender; 
	
	/**
	 * 设备编号
	 */
	private String deviceNo;
	
	/**
	 * 使用说明
	 */
	private String useDesc;
	
	/**
	 * 功能说明
	 */
	private String functionDesc;
	
	/**
	 * 价格
	 */
	private Integer price;
	
	/**
	 * 设备类型Id集合
	 */
	private List<Integer> deviceTypeIds;

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
	 * @return String 取得域 vender 的方法。
	 */
	public String getVender() {
		return vender;
	}

	/**
	 * @param vender 对域 vender 的设置方法.
	 */
	public void setVender(String vender) {
		this.vender = vender;
	}

	/**
	 * @return String 取得域 deviceNo 的方法。
	 */
	public String getDeviceNo() {
		return deviceNo;
	}

	/**
	 * @param deviceNo 对域 deviceNo 的设置方法.
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	/**
	 * @return String 取得域 useDesc 的方法。
	 */
	public String getUseDesc() {
		return useDesc;
	}

	/**
	 * @param useDesc 对域 useDesc 的设置方法.
	 */
	public void setUseDesc(String useDesc) {
		this.useDesc = useDesc;
	}

	/**
	 * @return String 取得域 functionDesc 的方法。
	 */
	public String getFunctionDesc() {
		return functionDesc;
	}

	/**
	 * @param functionDesc 对域 functionDesc 的设置方法.
	 */
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	/**
	 * @return Short 取得域 price 的方法。
	 */
	public Integer getPrice() {
		return price;
	}
	
	/**
	 * @param price 对域 price 的设置方法.
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return List<Integer> 取得域 deviceTypeIds 的方法。
	 */
	public List<Integer> getDeviceTypeIds() {
		return deviceTypeIds;
	}

	/**
	 * @param deviceTypeIds 对域 deviceTypeIds 的设置方法.
	 */
	public void setDeviceTypeIds(List<Integer> deviceTypeIds) {
		this.deviceTypeIds = deviceTypeIds;
	}

	/**
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-5 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		
		//检测信息是否完整
		if(StringUtils.isEmpty(name) || 
		   StringUtils.isEmpty(vender) || 
		   StringUtils.isEmpty(deviceNo) || 
		   StringUtils.isEmpty(useDesc) || 
		   StringUtils.isEmpty(functionDesc) ||
		   price == null || 
		   deviceTypeIds == null ||
		   deviceTypeIds.isEmpty()) {
			
			throw new BusinessException(ExceptionCode.DEVICE_INFO_NOT_INCOMPLETE);
		}
		
		return false;
	}
}
