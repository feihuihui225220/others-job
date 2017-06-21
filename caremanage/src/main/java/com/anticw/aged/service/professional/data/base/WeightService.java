package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Weight;

/**
 * 体重管理服务数据获取服务类
 * <P>File name : WeightService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Service
public class WeightService extends AbstractDataService<Weight> {

	/**
	 * 重写获取class方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getEntityClass()
	 */
	public Class<Weight> getEntityClass() {
		return Weight.class;
	}
	
	/**
	 * 重写获取表名方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-12 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getCollectionName()
	 */
	protected String getCollectionName() {
		return Constants.COLLECTION_WEIGHT;
	}
}
