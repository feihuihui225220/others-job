package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HHumoralImmunity;
import com.anticw.aged.dao.director.HHumoralImmunityDao;

@Service
public class HHumoralImmunityService {

	@Autowired
	private HHumoralImmunityDao hHumoralImmunityDao;
	/**
	 * 查询体液免疫
	 * @param userId
	 * @return
	 */
	public HHumoralImmunity getHHumoralImmunity(Long userId){
		return hHumoralImmunityDao.getHHumoralImmunity(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HHumoralImmunity t){
		hHumoralImmunityDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hHumoralImmunityDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HHumoralImmunity t){
		hHumoralImmunityDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HHumoralImmunity> getList(Long userId) {
		
		return hHumoralImmunityDao.getList(userId);
	}
	public HHumoralImmunity selectById(Integer id) {
		
		return hHumoralImmunityDao.selectById(id);
	}
}
