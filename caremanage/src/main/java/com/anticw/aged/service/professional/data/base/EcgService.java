package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Ecg;

/**
 * 心电管理服务数据获取服务类
 * <P>File name : EcgService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
@Service
public class EcgService extends AbstractDataService<Ecg> {

	/**
	 * 重写获取class方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-11 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getEntityClass()
	 */
	public Class<Ecg> getEntityClass() {
		return Ecg.class;
	}
	
	/**
	 * 重写获取表名方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-12 </P>
	 * @return
	 * @see com.anticw.aged.service.professional.data.AbstractDataService#getCollectionName()
	 */
	protected String getCollectionName() {
		return Constants.COLLECTION_ECG;
	}
}
