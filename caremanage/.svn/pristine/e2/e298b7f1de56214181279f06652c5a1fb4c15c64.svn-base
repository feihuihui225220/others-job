package com.anticw.aged.dao.professional.assess;

import java.util.List;

import com.anticw.aged.vo.professional.assess.ConclusionVO;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessRecordDetail;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 评估答案持久化类
 * 2014-12-8 15:24:46
 * @author L
 *
 */
@Repository
public class AssessRecordDetailDao extends HibernateEntityDao<MAssessRecordDetail> {
	/**
	 * 根据recordId查询评估答案，若为空返回null
	 * @param recordId
	 * @return
	 */
	public MAssessRecordDetail getByRecordId(Long recordId) {
		List<MAssessRecordDetail> details = super.find("from MAssessRecordDetail where recordId=?", recordId);
		if(details.isEmpty()){
			return null;
		}else{
			return details.get(0);
		}
	}
	/**
	 * 根据recordIds查询评估答案
	 * @param Ids
	 * @return
	 */
	public List<MAssessRecordDetail> getRecord(String Ids){
		List<MAssessRecordDetail> objects=super.find("from MAssessRecordDetail m where m.recordId in ("+Ids+")");
		return objects;
	}
	
	/**
	 * 获取评估结果的选项的结论
	 */
	@SuppressWarnings("unchecked")
	public List<ConclusionVO> getConclusion() {
		String sql = "SELECT id as answerId , conclusion FROM m_assess_answer where id>0" ;

		Query query = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ConclusionVO.class));
		return query.list();
	}

	
	
}
