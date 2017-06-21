package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HBloodFat;
import com.anticw.aged.dao.director.HBloodFatDao;

@Service
public class HBloodFatService {

	@Autowired
	private HBloodFatDao hBloodFatDao;
	/**
	 * 查询血脂
	 * @param userId
	 * @return
	 */
	public HBloodFat getHBloodFat(Long userId){
		return hBloodFatDao.getHBloodFat(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HBloodFat t){
		hBloodFatDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hBloodFatDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HBloodFat t){
		hBloodFatDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HBloodFat> getList(Long userId) {
		
		return hBloodFatDao.getList(userId);
	}
	public HBloodFat selectById(Integer id) {
		
		return hBloodFatDao.selectById(id);
	}
}
