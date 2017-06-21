package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HHormone;
import com.anticw.aged.dao.director.HHormoneDao;

@Service
public class HHormoneService {

	@Autowired
	private HHormoneDao hHormoneDao;
	/**
	 * 查询激素
	 * @param userId
	 * @return
	 */
	public HHormone getHHormone(Long userId){
		return hHormoneDao.getHHormone(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HHormone t){
		hHormoneDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hHormoneDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HHormone t){
		hHormoneDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HHormone> getList(Long userId) {
		
		return hHormoneDao.getList(userId);
	}
	public HHormone selectById(Integer id) {
		
		return hHormoneDao.selectById(id);
	}
}
