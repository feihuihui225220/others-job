package com.anticw.aged.dao.professional.vender;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MVenderEvaluation;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 服务商评价持久化类
 * <P>File name : VenderEvaluationDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
@Repository
public class VenderEvaluationDao extends HibernateEntityDao<MVenderEvaluation> {

	/**
	 * 获取指定时间指定分页的评价数据
	 * VenderEvaluationDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVenderEvaluation> listByPageAndDate(Integer venderId, Date start, Date end , int page, int num) {
		String hql = "from MVenderEvaluation m where m.venderId = ? and m.startTime >= ? and m.endTime <= ?";
		return pagedQuery(hql, page, num, new Object[]{venderId, start, end});
	}
	
	/**
	 * 查询评价对象
	 * VenderEvaluationDao.getByVenderAndId()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param evaId
	 * @return
	 */
	public MVenderEvaluation getByVenderAndId(Integer venderId, Integer evaId) {
		String hql = "from MVenderEvaluation m where m.venderId = ? and m.id = ?";
		List<MVenderEvaluation> evas = find(hql, new Object[]{venderId, evaId});
		if(evas != null && !evas.isEmpty()) {
			return evas.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 是否已经评价过了
	 * VenderEvaluationDao.hasEvalute()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean hasEvalute(Integer venderId, Date start, Date end){
		String hql = "from MVenderEvaluation m where m.venderId = ? and m.createdAt between ? and ?";
		List<MVenderEvaluation> evas = find(hql, venderId, start, end);
		return evas != null && !evas.isEmpty();
	}
}
