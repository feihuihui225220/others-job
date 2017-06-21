package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.HCellularImmunity;
import com.anticw.aged.dao.director.HCellularImmunityDao;

@Service
public class HCellularImmunityService {

	@Autowired
	private HCellularImmunityDao hCellularImmunityDao;
	/**
	 * 查询细胞免疫
	 * @param userId
	 * @return
	 */
	public HCellularImmunity getHCellularImmunity(Long userId){
		return hCellularImmunityDao.getHCellularImmunity(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HCellularImmunity t){
		hCellularImmunityDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hCellularImmunityDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HCellularImmunity t){
		hCellularImmunityDao.edit(t);
	}
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HCellularImmunity> getList(Long userId) {
		
		return hCellularImmunityDao.getList(userId);
	}
	public HCellularImmunity selectById(Integer id) {
		
		return hCellularImmunityDao.selectById(id);
	}

}
