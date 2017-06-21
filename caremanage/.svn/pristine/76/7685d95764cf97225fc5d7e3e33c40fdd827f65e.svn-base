package com.anticw.aged.dao.professional.handle;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAssessResult;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component
public class MAccessResultDao extends HibernateEntityDao<MAssessResult> {

	/**
	 * 插入模型计算结果
	 * @param mResult
	 */
	public void insertResult(MAssessResult mResult){
		super.save(mResult);
	}
	public Page<MAssessResult> listResult(int page,int size,Integer userId){
		String hql = "from MAssessResult";
		return super.pagedQuery(hql, page, size);
		
	}
}
