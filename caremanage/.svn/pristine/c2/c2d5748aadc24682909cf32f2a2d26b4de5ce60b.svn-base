package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HHepatitisVirus;
import com.anticw.aged.dao.director.HHepatitisVirusDao;

@Service
public class HHepatitisVirusService {

	@Autowired
	private HHepatitisVirusDao hHepatitisVirusDao;
	/**
	 * 查询肝炎病毒
	 * @param userId
	 * @return
	 */
	public HHepatitisVirus getHHepatitisVirus(Long userId){
		return hHepatitisVirusDao.getHHepatitisVirus(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HHepatitisVirus t){
		hHepatitisVirusDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hHepatitisVirusDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HHepatitisVirus t){
		hHepatitisVirusDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HHepatitisVirus> getList(Long userId) {
		
		return hHepatitisVirusDao.getList(userId);
	}
	public HHepatitisVirus selectById(Integer id) {
		
		return hHepatitisVirusDao.selectById(id);
	}
}
