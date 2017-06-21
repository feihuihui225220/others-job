package com.anticw.aged.dao.professional.assess;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessRecord;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.assess.EvaluatedPrivatelyVO;
import com.anticw.aged.vo.professional.vender.RecordMOVO;
import com.anticw.aged.vo.professional.vender.RecordVO;

/**
 * 评估结果持久层对象
 * <P>File name : AssessRecordDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
@Component
@Repository
public class AssessRecordDao extends HibernateEntityDao<MAssessRecord> {

	/**
	 * 分页获取评估数据
	 * AssessRecordDao.gets()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 * @throws BusinessException
	 */
	public Page<MAssessRecord> gets(Long userId, Date start, Date end, int page, int num) throws BusinessException {
		String hql = "from MAssessRecord m where m.userId = ? and m.createdAt between ? and ? order by createdAt desc";
		return this.pagedQuery(hql, page, num, new Object[]{userId, start, end});
	}
	/**
	 * 根据老年人Id和时间段获取评估信息
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 * @throws BusinessException
	 */
	public List<MAssessRecord> get(Long userId, Date start, Date end) throws BusinessException {
		String hql = "from MAssessRecord m where m.userId = ? and m.createdAt between ? and ? order by createdAt desc";
		return this.find(hql, new Object[]{userId, start, end});
	}
	
	@SuppressWarnings("unchecked")
	public List<?> getList(long userId,String year){
		//userId=98;
		//year="2015";
		StringBuffer sql=new StringBuffer("SELECT SUM(CASE WHEN MONTH(created_at) =1 THEN ");
		sql.append( "user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =2 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =3 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =4 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =5 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =6 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =7 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =8 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =9 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =10 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =11 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(created_at) =12 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ");
		sql.append("FROM m_assess_record WHERE YEAR(created_at)=").append(year).append(" AND assess_id=78").append(" GROUP BY YEAR(created_at)");
		
		List<Object[]> query=currentSession().createSQLQuery(sql.toString()).list();
		Iterator<Object[]> iter = query.iterator(); 
			//一条记录
		List<Integer> checkedIn=new ArrayList<Integer>(); 
		while (iter.hasNext()) {
		Object[] column = iter.next();
		for(int i=0;i<12;i++){
			String num=column[i].toString();
			checkedIn.add(Integer.parseInt(num));
		}
		}
		return checkedIn;
	} 
	
	/**
	 * 获取（财经）项目中所需要的人员（须做六张量表{包括体适能测评在内}）
	 * @param date
	 * @return
	 */
	public List<Long> getUserIds(Date date){
		
		String s= DateUtil.getCurrentFormatDate( DateUtil.getFirstDayInMonth(date));
		String e=DateUtil.getCurrentFormatDate( DateUtil.getLastDayInMonth(date));
		//DateYear.formatDate(dateCond.getStart())
		StringBuffer sb=new StringBuffer("SELECT  a1.id1 as Ids FROM ");
		sb.append(" (SELECT m_assess_record.user_id AS id1 FROM m_assess_record WHERE assess_id=78  AND con_id=93 AND created_at ").append(" BETWEEN '").append(s).append("' and '").append(e).append("' ) AS a1   JOIN  ");
		sb.append(" (SELECT m_assess_record.user_id AS id2 FROM m_assess_record WHERE assess_id=110 AND created_at").append(" BETWEEN '").append(s).append("' and '").append(e).append("'  ) AS a2 ON a1.id1=a2.id2  JOIN ");
		sb.append(" (SELECT m_assess_record.user_id AS id3 FROM m_assess_record WHERE assess_id=79 AND created_at").append(" BETWEEN '").append(s).append("' and '").append(e).append("'  ) AS a3 ON a1.id1=a3.id3  JOIN ");
		sb.append(" (SELECT m_assess_record.user_id AS id4 FROM m_assess_record WHERE assess_id=61 AND created_at").append(" BETWEEN '").append(s).append("' and '").append(e).append("'  ) AS a4  ON a1.id1=a4.id4  JOIN ");
		sb.append(" (SELECT  m_assess_record.user_id AS id5 FROM m_assess_record WHERE assess_id=97 AND created_at").append(" BETWEEN '").append(s).append("' and '").append(e).append("'  ) AS a5  ON a1.id1=a5.id5  JOIN ");
		sb.append(" (SELECT  m.user_id as id6 FROM m_assess_fitness m WHERE m.create_time").append(" BETWEEN '").append(s).append("' and '").append(e).append("'  ) AS a6 ON a1.id1=a6.id6 GROUP BY a1.id1");
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<Long> lo=new ArrayList<Long>();
		for(int i=0;i<query.size();i++) {
			
			try {
				Object  column= query.get(i);
				lo.add(((BigInteger)column ).longValue());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return lo;
	}
	/**
	 * 当无mmse和moca 综合数据时 使用此方法采集数据
	 * @param dParamVO
	 * @param cal
	 * @return
	 */
	public Map<Integer,List<RecordVO>> getUserIds(DateParamVO dParamVO,Integer cal){
		String s=  DateUtil.getCurrentFormatDate(dParamVO.getStart());
		String e= DateUtil.getCurrentFormatDate(dParamVO.getEnd());
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT h.user_id AS h_user,h.record_detail AS h_re,h1.record_detail AS h1_re FROM (SELECT t.id,d1.record_detail,s.user_id FROM (SELECT MIN(id) AS id FROM m_assess_record  WHERE  created_at BETWEEN '").append(s).append("' and '").append(e).append("' ");
		if(cal==1){sb.append("  AND assess_id=78 "); //ADL
		}else if(cal==2){sb.append("  AND assess_id=61 ");//IADL
		//}else if(cal==13){sb.append("  AND assess_id=110 ");//MoCA
		}else if(cal==17){sb.append("  AND assess_id=97 ");//GDS
		}
		sb.append(" GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS s ON t.id=s.id LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id  ) h,(SELECT t.id,d1.record_detail,m.user_id FROM (SELECT MAX(id) AS id FROM m_assess_record  WHERE  created_at BETWEEN '").append(s).append("' and '").append(e).append("' ");;
		if(cal==1){sb.append("  AND assess_id=78 "); //ADL
		}else if(cal==2){sb.append("  AND assess_id=61 ");//IADL
		//}else if(cal==13){sb.append("  AND assess_id=110 ");//MoCA
		}else if(cal==17){sb.append("  AND assess_id=97 ");//GDS
		}
		sb.append(" GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS m ON t.id=m.id LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id ) h1 WHERE h.user_id=h1.user_id AND h.id!=h1.id AND h.record_detail IS NOT NULL AND h1.record_detail IS NOT NULL");
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<RecordVO> m_s=new ArrayList<RecordVO>();//第一次录入的数据
		List<RecordVO> m_e=new ArrayList<RecordVO>();//第二次录入的数据
		for(int i=0;i<query.size();i++) {
			RecordVO vo=new RecordVO();
			RecordVO vo1=new RecordVO();
			try {
				Object[]  column= query.get(i);
				vo.setUserId(((BigInteger)column[0] ).longValue());
				vo.setDetail(column[1].toString());
				vo1.setUserId(((BigInteger)column[0] ).longValue());
				vo1.setDetail(column[2].toString());
				m_s.add(vo);
				m_e.add(vo1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		Map<Integer,List<RecordVO>> map=new HashMap<Integer, List<RecordVO>>();
		map.put(0, m_s);
		map.put(1, m_e);
		return map;
	}
	public static void main(String[] args) {
		new AssessRecordDao().getUserIds(new DateParamVO(DateUtil.parseStrToDate("2015-10-10"), DateUtil.parseStrToDate("2016-10-10")), 2);
	}
	/**
	 * mmse(78)和moca(110) 采集数据时 使用此方法采集数据
	 * @param dParamVO
	 * @param cal
	 * @return
	 */
	public Map<Integer,List<RecordMOVO>> getIds(DateParamVO dParamVO ){
		String s=  DateUtil.getCurrentFormatDate(dParamVO.getStart());
		String e= DateUtil.getCurrentFormatDate(dParamVO.getEnd());
		StringBuffer sb=new StringBuffer();
		sb.append("	SELECT h.user_id,h.record_detail as h_re,h1.record_detail as h1_re,h2.record_detail as h2_re,h3.record_detail as h3_re FROM (SELECT t.id,s.user_id,d1.record_detail FROM (SELECT MIN(id) AS id FROM m_assess_record  WHERE  created_at ");
		sb.append(" BETWEEN '").append(s).append("' AND '").append(e).append("' ");
		sb.append("	AND assess_id=78  GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS s ON t.id=s.id LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id  ) h,(SELECT t.id,m.user_id,d1.record_detail FROM (SELECT MAX(id) AS id FROM m_assess_record  WHERE  created_at ");
		sb.append(" BETWEEN '").append(s).append("' AND '").append(e).append("' ");
		sb.append(" AND assess_id=78  GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS m ON t.id=m.id  LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id ) h1 ,(SELECT t.id,m.user_id,d1.record_detail FROM (SELECT MAX(id) AS id FROM m_assess_record  WHERE  created_at ");
		sb.append(" BETWEEN '").append(s).append("' AND '").append(e).append("' ");
		sb.append(" AND assess_id=110 GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS m ON t.id=m.id  LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id ) h2,(SELECT t.id,m.user_id,d1.record_detail FROM (SELECT MAX(id) AS id FROM m_assess_record  WHERE  created_at ");
		sb.append(" BETWEEN '").append(s).append("' AND '").append(e).append("' ");
		sb.append(" AND assess_id=110 GROUP BY `user_id`) t LEFT JOIN `m_assess_record` AS m ON t.id=m.id LEFT JOIN m_assess_record_detail d1 ON t.id=d1.record_id ) h3 ");
		sb.append("	WHERE h.user_id=h1.user_id AND h.user_id=h2.user_id AND h.user_id=h3.user_id AND h1.id!=h.id AND h2.id!=h3.id AND h.record_detail IS NOT NULL  ");
		sb.append("	AND h1.record_detail IS NOT NULL AND h2.record_detail IS NOT NULL AND h3.record_detail IS NOT NULL");
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<RecordMOVO> m_s=new ArrayList<RecordMOVO>();//第一次录入的数据
		List<RecordMOVO> m_e=new ArrayList<RecordMOVO>();//第二次录入的数据
		for(int i=0;i<query.size();i++) {
			RecordMOVO vo1=new RecordMOVO();
			RecordMOVO vo2=new RecordMOVO();
			try {
				Object[]  column= query.get(i);
				vo1.setUserId(((BigInteger)column[0]).longValue());
				vo1.setDetailMMSE(column[2].toString());
				vo1.setDetailMOCA(column[4].toString());
				vo2.setUserId(((BigInteger)column[0]).longValue());
				vo2.setDetailMMSE(column[3].toString());
				vo2.setDetailMOCA(column[5].toString());
				m_s.add(vo1);
				m_e.add(vo2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		Map<Integer,List<RecordMOVO>> map=new HashMap<Integer, List<RecordMOVO>>();
		map.put(0, m_s);
		map.put(1, m_e);
		return map;
	}
	
	/**
	 * 获取头脑小组的本月的量表评估
	 * @param Ids
	 * @return
	 */
	public List<EvaluatedPrivatelyVO>  getListMAssessRecordDetail(String Ids,Date d){
		String hql="select m.id as id,m.userId as userId,m.assessId as assessId,d.recordDetail as recordDetail from MAssessRecord m,MAssessRecordDetail d where m.id=d.recordId and m.userId in("+Ids+") and m.createdAt BETWEEN ? and ? group by  m.userId,m.assessId";
		List<Object[]> li=super.find(hql,DateUtil.getFirstDayInMonth(d),DateUtil.getLastDayInMonth(d));
		List<EvaluatedPrivatelyVO>  evaluatedPrivatelyVO=new ArrayList<EvaluatedPrivatelyVO>();
		Iterator<Object[]> in= li.iterator();
		while(in.hasNext()){
			EvaluatedPrivatelyVO e=new EvaluatedPrivatelyVO();
			Object[] o=in.next();
			e.setId((long)o[0]);
			e.setUserId((long)o[1]);
			e.setAssessId((int)o[2]);
			e.setRecordDetail((String)o[3]);
			evaluatedPrivatelyVO.add(e);
		}
		return evaluatedPrivatelyVO;
	}
	
	public List<Object[]> getList(Long userId){
		String hql="select m.id,m.recordId,m.recordDetail,m1.createdAt from MAssessRecord m1,MAssessRecordDetail m where m1.id=m.recordId and m1.assessId=132 and m1.userId=?";
		return super.find(hql, userId);
		
	}
	
	
	
}
