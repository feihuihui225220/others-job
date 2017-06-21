package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HRenalFunction;
import com.anticw.aged.dao.director.HRenalFunctionDao;

@Service
public class HRenalFunctionService {

	@Autowired
	private HRenalFunctionDao hRenalFunctionDao;
	
	/**
	 * 查询血常规
	 * @param userId
	 * @return
	 */
	public HRenalFunction getHRenalFunction(Long userId){
		return hRenalFunctionDao.getHRenalFunction(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HRenalFunction t){
		hRenalFunctionDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hRenalFunctionDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HRenalFunction t){
		hRenalFunctionDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HRenalFunction> getList(Long userId) {
		
		return hRenalFunctionDao.getList(userId);
	}
	public HRenalFunction selectById(Integer id) {
		
		return hRenalFunctionDao.selectById(id);
	}

}
