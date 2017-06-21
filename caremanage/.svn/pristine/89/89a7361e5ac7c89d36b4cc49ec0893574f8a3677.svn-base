package com.anticw.aged.vo.professional.meta;

import java.util.Iterator;
import java.util.List;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 数据模块vo
 * <P>File name : DataModuleVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
/**
 * <P>File name : DataModuleVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-13 </P>
 */
public class DataModuleVO implements BaseVO  {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 元服务Id
	 */
	private Integer metaServiceId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 表名称
	 */
	private String tableName;
	
	/**
	 * 设备绑定id
	 */
	private String deviceId;
	
	/**
	 * 数据模块项
	 */
	private List<DataModuleItemVO> items;

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
	 * @return List<DataModuleItemVO> 取得域 items 的方法。
	 */
	public List<DataModuleItemVO> getItems() {
		return items;
	}

	/**
	 * @param items 对域 items 的设置方法.
	 */
	public void setItems(List<DataModuleItemVO> items) {
		this.items = items;
	}
	
	/**
	 * @return String 取得域 tableName 的方法。
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName 对域 tableName 的设置方法.
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
		if(StringUtils.isEmpty(name) ) {
			throw new BusinessException(ExceptionCode.DATA_MODULE_INFO_INCOMPLETE);
		}
		
		//子项信息不完整
		for(Iterator<DataModuleItemVO> iter = items.iterator(); iter.hasNext();) {
			DataModuleItemVO item = iter.next();
			if(!item.selfValidate()) {
				throw new BusinessException(ExceptionCode.DATA_MODULE_INFO_INCOMPLETE);
			}
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "DataModuleVO [metaServiceId=" + metaServiceId + ", name="
				+ name + ", tableName=" + tableName + ", deviceId=" + deviceId
				+ ", items=" + items + "]";
	}
	
	
	
}
