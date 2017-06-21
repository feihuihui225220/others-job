package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HLiverFunction;
import com.anticw.aged.dao.director.HLiverFunctionDao;

@Service
public class HLiverFunctionService {

	@Autowired
	private HLiverFunctionDao hLiverFunctionDao;
	/**
	 * 查询肝功能
	 * @param userId
	 * @return
	 */
	public HLiverFunction getHLiverFunction(Long userId){
		return hLiverFunctionDao.getHLiverFunction(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HLiverFunction t){
		hLiverFunctionDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hLiverFunctionDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HLiverFunction t){
		hLiverFunctionDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HLiverFunction> getList(Long userId) {
		
		return hLiverFunctionDao.getList(userId);
	}
	
	public HLiverFunction selectById(Integer id) {
		
		return hLiverFunctionDao.selectById(id);
	}
}
