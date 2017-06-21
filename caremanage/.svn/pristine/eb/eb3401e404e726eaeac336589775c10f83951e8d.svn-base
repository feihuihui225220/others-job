package com.anticw.aged.dao.professional.device;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.MDevice;
import com.anticw.aged.bean.MDeviceType;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 设备类型持久层对象
 * <P>File name : DeviceTypeDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Repository
public class DeviceTypeDao extends HibernateEntityDao<MDeviceType> {

	/**
	 * 查询设备信息
	 * DeviceTypeDao.queryForDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param deviceName
	 * @param deviceVender
	 * @param deviceType
	 * @param pageParamVo
	 * @return
	 */
	public Page<MDevice> queryForDevice(String deviceName, String deviceVender, Integer deviceType, int page, int num) {
		
		//HQL
		String hql = "from MDevice m where m.available = ?";
		
		//设备名称
		if(!StringUtils.isEmpty(deviceName)) {
			hql += " and m.name = '" + deviceName + "'";
		}
		
		//设备厂商
		if(!StringUtils.isEmpty(deviceVender)) {
			hql += " and m.vender = '" + deviceVender + "'";
		}
		
		//设备类型
		if(deviceType != null) {
			//hql += " and find_in_set('" + deviceType + "', m.deviceTypeIds)";
			hql += " and m.deviceTypeIds REGEXP '" + deviceType + "'";
		}
		
		//order by
		hql += " order by m.createdAt desc";
		
		//query
		return super.pagedQuery(hql, page, num, new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取设备类型列表
	 * DeviceTypeDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MDeviceType> list(int page, int num) {
		return super.pagedQuery("from MDeviceType m where m.available = ? order by m.createdAt desc", page, num, new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取全部可用的设备类型
	 * DeviceTypeDao.getAllDeviceTypes()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 */
	public List<MDeviceType> getAllDeviceTypes() {
		return super.find("from MDeviceType m where m.available = ?", new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
}
