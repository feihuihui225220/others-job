package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.HBloodRoutine;
import com.anticw.aged.dao.director.HBloodRoutineDao;

@Service
public class HBloodRoutineService {

	@Autowired
	private HBloodRoutineDao hBloodRoutineDao;
	/**
	 * 查询血常规
	 * @param userId
	 * @return
	 */
	public HBloodRoutine getHBloodRoutine(long userId){
		return hBloodRoutineDao.getHBloodRoutine(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HBloodRoutine t){
		hBloodRoutineDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hBloodRoutineDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HBloodRoutine t){
		hBloodRoutineDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HBloodRoutine> getList(Long userId) {
		
		return hBloodRoutineDao.getList(userId);
	}
	
	/**
	 * 根据id查询
	 * @param t
	 */
	
	public HBloodRoutine selectById(Integer id) {
		
		return hBloodRoutineDao.selectById(id);
	}
	

	
}
