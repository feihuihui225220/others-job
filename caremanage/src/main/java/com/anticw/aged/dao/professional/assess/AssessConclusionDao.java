package com.anticw.aged.dao.professional.assess;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessConclusion;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 评估量表结论持久化对象
 * <P>File name : AssessConclusionDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
@Repository
public class AssessConclusionDao extends HibernateEntityDao<MAssessConclusion> {

	/**
	 * 获取指定评估量表的评估结论
	 * AssessConclusionDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-2 </P>
	 * @param assessId
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MAssessConclusion> list(int assessId, int page, int num) {
		return super.pagedQuery("from MAssessConclusion m where m.assessId = ? and m.available = ? order by m.createdAt desc", page, num, new Object[]{new Integer(assessId), Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取指定评估量表的全部结论数据
	 * AssessConclusionDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param assessId
	 * @return
	 */
	public List<MAssessConclusion> list(int assessId) {
		return super.find("from MAssessConclusion m where m.assessId = ? and m.available = ?", new Object[]{new Integer(assessId), Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
}
