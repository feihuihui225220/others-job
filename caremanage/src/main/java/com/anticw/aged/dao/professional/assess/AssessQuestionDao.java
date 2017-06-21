package com.anticw.aged.dao.professional.assess;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessQuestion;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 评估量表问题持久化对象
 * <P>File name : AssessDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
@Repository
public class AssessQuestionDao extends HibernateEntityDao<MAssessQuestion> {
	
	/**
	 * 获取评估量表问题列表
	 * AssessQuestionDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-1 </P>
	 * @param assessId
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MAssessQuestion> list(int assessId, int page, int num) {
		return super.pagedQuery("from MAssessQuestion m where m.assessId = ? and m.available = ? order by m.createdAt asc", page, num, new Object[]{new Integer(assessId), Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取指定评估量表下的全部问题
	 * AssessQuestionDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param assessId
	 * @return
	 */
	public List<MAssessQuestion> list(int assessId) {
		return super.find("from MAssessQuestion m where m.assessId = ? and m.available = ?", new Object[]{new Integer(assessId), Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
}
