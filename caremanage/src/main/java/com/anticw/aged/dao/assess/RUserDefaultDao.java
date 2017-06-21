package com.anticw.aged.dao.assess;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.RUserDefault;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class RUserDefaultDao extends HibernateEntityDao<RUserDefault>{
	
	/**
	 * @param userId
	 * 查询r_user_dafault
	 */
	public RUserDefault findRUserDefaultById(Integer id){
		return super.get(id);
	}
	public void update_shenhe(RUserDefault user){
		super.update(user);
	}
	/**
	 * 添加
	 */
	public void saveRUserDefault(RUserDefault user){
		super.save(user);
	}
}
