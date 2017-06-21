package com.anticw.aged.dao.professional.assess;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessAnswer;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 评估量表答案持久化对象
 * <P>File name : AssessAnswerDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
@Repository
public class AssessAnswerDao extends HibernateEntityDao<MAssessAnswer> {
	public MAssessAnswer getAssessAnswer(int id){
		 List<MAssessAnswer> mAssessAnswer=super.find("from MAssessAnswer m where m.id=?",id);
		 MAssessAnswer m=mAssessAnswer.get(0);
		 return m;
	}
}
