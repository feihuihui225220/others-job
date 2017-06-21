package com.anticw.aged.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bjast.obuilding.bean.OBuilding;
import com.bjast.obuilding.bean.Page;
import com.bjast.obuilding.vo.PageVO;
import com.bjast.obuilding.vo.QueryBuildingVO;
@Service
public class OBuildingService implements  com.bjast.obuilding.service.OBuildingService{

	@Override
	public List<OBuilding> getByCountryId(Integer countryId) {
		return null;
	}

	@Override
	public OBuilding getById(Integer buildingId) {
		return null;
	}

	@Override
	public int save(OBuilding record) {
		return 0;
	}

	@Override
	public int deleteById(Integer buildingId) {
		return 0;
	}

	@Override
	public int update(OBuilding record) {
		return 0;
	}

	@Override
	public Page<OBuilding> getByPage(PageVO pagevo, QueryBuildingVO queryVo) {
		return null;
	}
	
	

}
