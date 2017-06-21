package com.anticw.aged.vo.professional.meta;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 元服务vo
 * <P>File name : MetaVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
public class MetaVO implements BaseVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 设备类型Id
	 */
	private Integer deviceTypeId;
	/**
	 * 服务费用
	 */
	private  Integer price;
	/**
	 * 数据模块
	 */
	private DataModuleVO dataModule;

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
	 * @return Integer 取得域 deviceTypeId 的方法。
	 */
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	/**
	 * @param deviceTypeId 对域 deviceTypeId 的设置方法.
	 */
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	/**
	 * @return DataModuleVO 取得域 dataModule 的方法。
	 */
	public DataModuleVO getDataModule() {
		return dataModule;
	}

	/**
	 * @param dataModule 对域 dataModule 的设置方法.
	 */
	public void setDataModule(DataModuleVO dataModule) {
		this.dataModule = dataModule;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
		
		//信息不完整
		if(StringUtils.isEmpty(name) || !dataModule.selfValidate()) {
			throw new BusinessException(ExceptionCode.DATA_MODULE_INFO_INCOMPLETE);
		}
		
		return true;
	}
}
