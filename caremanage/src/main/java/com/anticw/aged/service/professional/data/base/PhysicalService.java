package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.Physical;
@Service
public class PhysicalService extends AbstractDataService<Physical> {

	@Override
	public Class<Physical> getEntityClass() {
		// TODO Auto-generated method stub
		return Physical.class;
	}

	@Override
	protected String getCollectionName() {
		// TODO Auto-generated method stub
		return Constants.COLLECTION_PHYSICAL;
	}

}
