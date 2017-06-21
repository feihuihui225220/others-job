package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Fat;

/**
 * 脂肪管理服务数据获取服务类
 * <P>File name : BloodFatService.java </P>
 * <P>Author : bsd </P> 
 * <P>Date : 2015-03-23 </P>
 */
@Service
public class FatService extends AbstractDataService<Fat>{

	@Override
	public Class<Fat> getEntityClass() {
		// TODO Auto-generated method stub
		return Fat.class;
	}

	@Override
	protected String getCollectionName() {
		// TODO Auto-generated method stub
		return Constants.COLLECTION_FAT;
	}

}
