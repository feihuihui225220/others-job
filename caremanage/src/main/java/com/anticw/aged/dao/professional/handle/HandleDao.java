package com.anticw.aged.dao.professional.handle;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessHandleTree;
import com.anticw.aged.bean.MAssessHandled;
import com.anticw.aged.bean.MAssessResult;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class HandleDao extends HibernateEntityDao<MAssessHandle> {

	/**
	 * 插入问卷答题详情
	 * @param maHandle
	 */
	public void insertHandle(MAssessHandle maHandle){
		maHandle.setCreatedAt(new Date());
		super.save(maHandle);
	}
	/**
	 * 插入处理后的结果
	 * @param maHandle
	 */
	public void insertHandled(MAssessHandled maHandled){
		maHandled.setCreatedAt(new Date());
		super.save(maHandled);
	}
	/**
	 * 插入决策树预处理后的结果
	 * @param mTree
	 */
	public void insertHandleTree(MAssessHandleTree mTree){
		mTree.setCreatedAt(new Date());
		super.save(mTree);
	}
	/**
	 * 查询符合某条件人所占的比例
	 * @param sql
	 * @return
	 */
	public double selectTreePercent(StringBuffer sql){
		String hql = "from MAssessHandleTree where 1=1 "+ sql;
		List<MAssessHandleTree> assessTree = super.find(hql);
		String hqlAll = "from MAssessHandleTree";
		List<MAssessHandleTree> assessCountAll = super.find(hqlAll);
		int num = assessTree.size();
		int numAll = assessCountAll.size();
		double result  = (double)num/(double)numAll;
		return result;
		
	}
	
	public List<MAssessResult> selectResult(String userId){
		String hql = "from MAssessResult where userId="+userId;
		List<MAssessResult> assessResult  = super.find(hql);
		return assessResult;
	}
}
