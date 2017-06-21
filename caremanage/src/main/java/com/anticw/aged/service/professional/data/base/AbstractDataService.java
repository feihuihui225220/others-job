package com.anticw.aged.service.professional.data.base;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.anticw.aged.dao.data.MetaDataDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;

/**
 * 专业服务数据服务抽象类
 * <P>File name : DataService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
public abstract class AbstractDataService<T> {

	/**
	 * 原服务数据持久化对象
	 */
	@Autowired
	protected MetaDataDao metaDataDao;
	
	/**
	 * 获取实体名称
	 * AbstractDataService.getEntityClass()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 */
	public abstract Class<T> getEntityClass();
	
	/**
	 * 获取集合名称
	 * AbstractDataService.getCollectionName()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 */
	protected abstract String getCollectionName();
	
	/**
	 * 分页查询
	 * AbstractDataService.query()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @param serviceId
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	public Page<T> query(String deviceBindId, Date start, Date end, int page, int num) throws BusinessException {
		return metaDataDao.findByPage(getEntityClass(), getCollectionName(), deviceBindId, start, end, page, num);
	}
	
	/**
	 * 分页查询
	 * AbstractDataService.query()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param serviceId
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @returnquerySel
	 * @throws BusinessException
	 * @throws Exception
	 */
	public List<T> query(String deviceBindId, Date start, Date end) {
		return metaDataDao.findByDate(getEntityClass(), getCollectionName(), deviceBindId, start, end);
	}
	/**
	 * 专业查询(报告)
	 * AbstractDataService.query()<BR>
	 * @author dx 
	 * @param serviceId
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	public List<T> querySel(String deviceBindId, Date start, Date end) {
		return metaDataDao.findDate(getEntityClass(), getCollectionName(), deviceBindId, start, end);
	}
	
	/**
	 * 根据项目名称和日期进行查询
	 * @param deviceBindId
	 * @param itemName
	 * @param start
	 * @param end
	 * @return
	 */
	public List<T> query(String deviceBindId, String itemName, Date start, Date end) {
		return metaDataDao.findByItemAndDate(getEntityClass(), getCollectionName(), deviceBindId, itemName, start, end);
	}
	
	/**
	 * 保存数据
	 * @param t
	 */
	public void save(Object t){
		metaDataDao.save(t);
	}
}
