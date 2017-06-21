package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.BloodSugar;

/**
 * 血糖管理服务数据获取服务类
 * <P>File name : BloodSugarService.java </P>
 * <P>Author : bsd </P> 
 * <P>Date : 2015-03-23 </P>
 */
@Service
public class BloodSugarService extends AbstractDataService<BloodSugar>{

	@Override
	public Class<BloodSugar> getEntityClass() {
		// TODO Auto-generated method stub
		return BloodSugar.class;
	}

	@Override
	protected String getCollectionName() {
		// TODO Auto-generated method stub
		return Constants.COLLECTION_BLOODSUGAR;
	}

}
