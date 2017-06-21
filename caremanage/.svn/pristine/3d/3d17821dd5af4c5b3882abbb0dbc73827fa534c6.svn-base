/**
 * 
 */
package com.anticw.aged.service.professional.data.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Toilet;
import com.anticw.aged.dao.data.ToiletDao;
import com.anticw.aged.dao.professional.service.OrderDao;

/**
 * 台湾马桶数据
 * 
 * @author bsd
 *
 */
@Service
public class ToiletService extends AbstractDataService<Toilet> {

	@Autowired
	private ToiletDao toiletDao;
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Class<Toilet> getEntityClass() {
		return Toilet.class;
	}

	@Override
	protected String getCollectionName() {
		return Constants.COLLECTION_TOILET;
	}

	/**
	 * 获取所有的离开状态
	 * @param deviceId
	 * @return
	 */
	public List<Toilet> getAlarmss(String deviceId) {
		return toiletDao.getAlarmss(deviceId);
	}
	
	public Object[] getUserId_(String  deviceBindId){
		return orderDao.getUserId_(deviceBindId);
	}
	
	
	

}
