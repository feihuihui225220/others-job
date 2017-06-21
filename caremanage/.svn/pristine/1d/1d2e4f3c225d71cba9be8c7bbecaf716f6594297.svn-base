package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HElectrolyte;
import com.anticw.aged.dao.director.HElectrolyteDao;

@Service
public class HElectrolyteService {

	@Autowired
	private HElectrolyteDao hElectrolyteDao;
	/**
	 * 查询血常规
	 * @param userId
	 * @return
	 */
	public HElectrolyte getHElectrolyte(Long userId){
		return hElectrolyteDao.getHElectrolyte(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HElectrolyte t){
		hElectrolyteDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hElectrolyteDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HElectrolyte t){
		hElectrolyteDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HElectrolyte> getList(Long userId) {
		
		return hElectrolyteDao.getList(userId);
	}
	public HElectrolyte selectById(Integer id) {
		
		return hElectrolyteDao.selectById(id);
	}
}
