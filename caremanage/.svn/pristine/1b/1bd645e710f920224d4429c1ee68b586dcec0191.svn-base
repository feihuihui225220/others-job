package com.anticw.aged.vo.professional.service;

import java.util.List;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.device.DeviceGroupVO;

/**
 * 该vo具有两个作用：
 * 1、作为开通专业服务结算页的信息显示；
 * 2、作为请求开通操作的参数载体
 * <P>File name : ServiceOpenVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
public class ServiceCheckoutVO implements BaseVO {
	
	/**
	 * 对象标识
	 */
	private Long orderId;

	/******************************************************************用于结算页面数据显示的属性**************************************************************/
	
	/**
	 * 专业服务名称
	 */
	private String serviceName;
	
	/**
	 * 单价
	 */
	private Integer price;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 身份证号码
	 */
	private String idCard;
	
	
	/**
	 * 设备类型分组信息
	 */
	private List<DeviceGroupVO> deviceGroups; 
	
	/********************************************************************确认开通提交的参数信息******************************************************************/
	
	/**
	 * 开通时间
	 */
	private DateParamVO dateCond;
	
	/**
	 * 设备订购参数
	 */
	private List<OrderDeviceParamVO> deviceParam;
	
	
	/****************************************************************即用于结算页面数据显示也用于参数提交的属性**************************************************/
	
	/**
	 * 专业服务Id
	 */
	private Integer serviceId;
	
	/**
	 * 用户Id
	 */
	private Long userId;
	

	
	
	

	/**
	 * @return Integer 取得域 serviceId 的方法。
	 */
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId 对域 serviceId 的设置方法.
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return String 取得域 serviceName 的方法。
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName 对域 serviceName 的设置方法.
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return Integer 取得域 price 的方法。
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
	 * @return DateParamVO 取得域 dateParam 的方法。
	 */
	public DateParamVO getDateCond() {
		return dateCond;
	}

	/**
	 * @param dateParam 对域 dateParam 的设置方法.
	 */
	public void setDateCond(DateParamVO dateCond) {
		this.dateCond = dateCond;
	}



	/**
	 * @return List<DeviceGroupVO> 取得域 deviceGroups 的方法。
	 */
	public List<DeviceGroupVO> getDeviceGroups() {
		return deviceGroups;
	}

	/**
	 * @param deviceGroups 对域 deviceGroups 的设置方法.
	 */
	public void setDeviceGroups(List<DeviceGroupVO> deviceGroups) {
		this.deviceGroups = deviceGroups;
	}

	/**
	 * @return List<OrderDeviceParamVO> 取得域 deviceParam 的方法。
	 */
	public List<OrderDeviceParamVO> getDeviceParam() {
		return deviceParam;
	}

	/**
	 * @param deviceParam 对域 deviceParam 的设置方法.
	 */
	public void setDeviceParam(List<OrderDeviceParamVO> deviceParam) {
		this.deviceParam = deviceParam;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 自检
	 * ServiceCheckoutVO.selfValidate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-9 </P>
	 * @return
	 * @throws BusinessException
	 */
	public boolean selfValidate() throws BusinessException {
		if(dateCond == null || dateCond.getStart() == null || dateCond.getEnd() == null || 
		   serviceId == null || userId == null || deviceParam == null || deviceParam.isEmpty()) {
			throw new BusinessException(ExceptionCode.ORDER_OPEN_INFO_ERROR);
		}
		return true;
	}
}
