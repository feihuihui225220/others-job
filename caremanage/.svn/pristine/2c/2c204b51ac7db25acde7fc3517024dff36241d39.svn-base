package com.anticw.aged.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HBloodGasAnalysis;
import com.anticw.aged.dao.director.HBloodGasAnalysisDao;

@Service
public class HBloodGasAnalysisService {
	@Autowired
	private HBloodGasAnalysisDao hBloodGasAnalysisDao;
	/**
	 * 查询电解质
	 * @param userId
	 * @return
	 */
	public HBloodGasAnalysis getHBloodGasAnalysis(Long userId){
		return hBloodGasAnalysisDao.getHBloodGasAnalysis(userId);
	}
	/**
	 * 添加
	 * @param t
	 */
	public void save(HBloodGasAnalysis t){
		hBloodGasAnalysisDao.save(t);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void remover(int id){
		hBloodGasAnalysisDao.removeById(id);
	}
	/**
	 * 修改
	 * @param t
	 */
	public void edit(HBloodGasAnalysis t){
		hBloodGasAnalysisDao.edit(t);
	}
	
	/**
	 * 取用户最新一条评估记录
	 * @param t
	 */
	
	public List<HBloodGasAnalysis> getList(Long userId) {
		
		return hBloodGasAnalysisDao.getList(userId);
	}
	public HBloodGasAnalysis selectById(Integer id) {
		
		return hBloodGasAnalysisDao.selectById(id);
	}
}
