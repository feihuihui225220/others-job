package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HDicCheck;
import com.anticw.aged.dao.director.HDicCheckDao;

@Service
public class HDicCheckService {

	@Autowired
	private HDicCheckDao hDicCheckDao;
	/**
	 * 查询尿常规
	 * @param userId
	 * @return
	 */
	public HDicCheck getHDicCheck(Long userId){
		return hDicCheckDao.getHDicCheck(userId);
	}
	/**
	 * 添加
	 * @param hr
	 */
	public void save(HDicCheck hr){
		hDicCheckDao.save(hr);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hDicCheckDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HDicCheck t){
		hDicCheckDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HDicCheck> getList(Long userId) {
		
		return hDicCheckDao.getList(userId);
	}
	public HDicCheck selectById(Integer id) {
		
		return hDicCheckDao.selectById(id);
	}

}
