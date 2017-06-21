package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HUrineRoutine;
import com.anticw.aged.dao.director.HUrineRoutineDao;

@Service
public class HUrineRoutineService {


	@Autowired
	private HUrineRoutineDao hUrineRoutineDao;
	/**
	 * 查询尿常规
	 * @param userId
	 * @return
	 */
	public HUrineRoutine getHUrineRoutine(Long userId){
		return hUrineRoutineDao.getHUrineRoutine(userId);
	}
	/**
	 * 添加
	 * @param hr
	 */
	public void save(HUrineRoutine h){
		hUrineRoutineDao.save(h);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hUrineRoutineDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HUrineRoutine t){
		hUrineRoutineDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HUrineRoutine> getList(Long userId) {
		
		return hUrineRoutineDao.getList(userId);
	}
	public HUrineRoutine selectById(Integer id) {
		
		return hUrineRoutineDao.selectById(id);
	}
}
