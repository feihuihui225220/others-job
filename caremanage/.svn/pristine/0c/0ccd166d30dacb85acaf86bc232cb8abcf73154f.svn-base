package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Heart;

/**
 * 心脏频谱服务数据获取服务类
 * <P>File name : HeartService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Service
public class HeartService extends AbstractDataService<Heart> {

	/**
	 * 重写获取class方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getEntityClass()
	 */
	public Class<Heart> getEntityClass() {
		return Heart.class;
	}
	
	/**
	 * 重写获取表名方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-12 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getCollectionName()
	 */
	protected String getCollectionName() {
		return Constants.COLLECTION_HEART;
	}
}
