package com.anticw.aged.dao.professional.device;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MDevice;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 设备持久化对象
 * <P>File name : DeviceDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Repository
public class DeviceDao extends HibernateEntityDao<MDevice> {

	/**
	 * 获取设备类型列表
	 * DeviceTypeDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MDevice> list(int page, int num) {
		return super.pagedQuery("from MDevice m where m.available = ? order by m.createdAt desc", page, num, new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取全部设备
	 * DeviceDao.listAll()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @return
	 */
	public List<MDevice> listAll() {
		return super.find("from MDevice m where m.available = ?", new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
}
