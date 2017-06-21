package com.anticw.aged.service.professional.data.base;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.mongo.GripPower;
@Service
public class GripPowerService extends AbstractDataService<GripPower> {

	@Override
	public Class<GripPower> getEntityClass() {
		// TODO Auto-generated method stub
		return GripPower.class;
	}

	@Override
	protected String getCollectionName() {
		// TODO Auto-generated method stub
		return Constants.COLLECTION_GRIP;
	}

}
