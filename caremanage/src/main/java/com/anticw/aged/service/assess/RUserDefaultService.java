package com.anticw.aged.service.assess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.RUserDefault;
import com.anticw.aged.dao.assess.RUserDefaultDao;


@Service
public class RUserDefaultService {

	@Autowired
	private  RUserDefaultDao rUserDefaultDao;
	
	public RUserDefault findRUserDefalutById(Integer id){
		return rUserDefaultDao.findRUserDefaultById(id);
	}
	public void update_shenhe(RUserDefault user){
		rUserDefaultDao.update_shenhe(user);
	}
	public void saveRUserDefault(RUserDefault user){
		rUserDefaultDao.saveRUserDefault(user);
	}
	
}
