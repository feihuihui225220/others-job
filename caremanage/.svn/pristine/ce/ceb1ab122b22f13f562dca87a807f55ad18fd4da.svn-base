package com.anticw.aged.dao.professional.vender;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MVenderService;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 专业服务商服务分类持久化对象
 * <P>File name : VenderServiceDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
@Repository
public class VenderServiceDao extends HibernateEntityDao<MVenderService> {

	/**
	 * 获取全部分配信息
	 * VenderServiceDao.findAll()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @return
	 */
	public List<MVenderService> findAll(Integer venderId) {
		String hql = "from MVenderService m where m.venderId = ?";
		return super.find(hql, new Object[]{new Integer(venderId)});
	}
	
	/**
	 * 根据服务获取对象
	 * VenderServiceDao.findByServiceId()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param serviceId
	 * @return
	 */
	public List<MVenderService> findByServiceId(Integer serviceId) {
		String hql = "from MVenderService m where m.serviceId = ?";
		return super.find(hql, new Object[]{new Integer(serviceId)});
	}
	
	/**
	 * 删除服务项目
	 * VenderServiceDao.remove()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param serviceId
	 */
	public void remove(Integer venderId, Integer serviceId) {
		String hql = "from MVenderService m where m.venderId = ? and m.serviceId = ?";
		List<MVenderService> services = super.find(hql, venderId, serviceId);
		if(services != null && !services.isEmpty()) {
			for(MVenderService service : services) {
				super.remove(service);
			}
		}
	}
}
