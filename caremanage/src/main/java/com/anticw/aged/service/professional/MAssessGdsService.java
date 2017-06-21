package com.anticw.aged.service.professional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessGds;
import com.anticw.aged.dao.professional.assess.MAssessGdsDao;
/**
 * 
 * @author DX
 * 将GPS系统中返回html数据录入系统
 *
 */
@Service
public class MAssessGdsService {

	@Autowired
	private MAssessGdsDao mAssessGdsDao;
	
	public void save(MAssessGds gds){
		mAssessGdsDao.save(gds);
	}
	
	public MAssessGds getUserId(Long userId){
		return mAssessGdsDao.getUserId(userId);
	}
}
