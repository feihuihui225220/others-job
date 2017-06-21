package com.anticw.aged.dao.huiZheng;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HTreatment;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class HTreatmentDao extends HibernateEntityDao<HTreatment> {
	/**
	 *添加
	 * @param maFitness
	 */
	public void insertTreat(HTreatment hTreatment) {
		super.save(hTreatment);
	}
	/**
	 *查询列表
	 * @param maFitness
	 */
	public List<HTreatment> listResult(Long userId) {
		String hql = "from HTreatment where user_id="+userId+ "order by id desc";
		List<HTreatment> result  = super.find(hql);
		return result;
	}
	/**
	 *删除
	 * @param maFitness
	 */
	public void delete(Integer resultId) {
		super.removeById(resultId);
	}
	/**
	 *编辑
	 * @param maFitness
	 */
	public void edit(HTreatment hTreatment){
		Date  date = new Date();
		HTreatment nap =findOneAvailData(hTreatment.getId());
		nap.setContent(hTreatment.getContent());
		nap.setStartTime(hTreatment.getStartTime());
		nap.setEndTime(hTreatment.getEndTime());
		nap.setChangeTime(date);
		nap.setChangeBy(hTreatment.getChangeBy());
		super.update(nap);
}
	/**
	 *查询一条
	 * @param maFitness
	 */
	public HTreatment findOneAvailData(int id){
		return super.get(id);
	}
	
	public List<HTreatment> findById(Integer resultId) {
		String hql = "from HTreatment where id="+resultId;
		List<HTreatment> result  = super.find(hql);
		return result;
	}
}
