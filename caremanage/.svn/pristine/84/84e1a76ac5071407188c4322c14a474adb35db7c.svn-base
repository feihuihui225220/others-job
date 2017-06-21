package com.anticw.aged.dao.professional.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NCheckList;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 *
 * @author dx 2015/9/24
 *
 */
@Component
public class NCherkListDao extends  HibernateEntityDao<NCheckList>{
	
	//添加老年人签到
	public void addNCherk(NCheckList nCherkList){
		try {
			super.save(nCherkList);
			this.currentSession().clear();
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
		}
	}
	//查询以签到的老人
	public List<NCheckList> getListNCheckList(int activityId,Date pubdate){
		String hql="from NCheckList n where n.activityId=? and pubdate=?";
		return super.find(hql,activityId,pubdate);
	}
	public List<NCheckList> getListN(int activityId){
		String hql="from NCheckList n where n.activityId=?";
		return super.find(hql,activityId);
	}
	public List<Integer> getListUerId(int activityId){
		String hql="select userId from NCheckList n where n.activityId=?";
		return super.find(hql,activityId);
	}
	public int getCount(int activityId,Date pubdate){
		int count=0;
		Session session=this.currentSession();
		String hql="select count(n) from NCheckList n where n.activityId="+activityId+" and pubdate='"+pubdate+"'";
		Query query=session.createQuery(hql);
		Object cnt = query.uniqueResult();  
		if(cnt != null){  
			count = Integer.parseInt(cnt.toString());  
		}  
		return count;
	} 
	
	public List<?> getList(long userId,String year){
		//userId=98;
		//year="2015";
		StringBuffer sql=new StringBuffer("SELECT SUM(CASE WHEN MONTH(pubdate) =1 THEN ");
		sql.append( "user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =2 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =3 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =4 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =5 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =6 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =7 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =8 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =9 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =10 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =11 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ,");
		sql.append("SUM(CASE WHEN MONTH(pubdate) =12 THEN ").append("user_id=").append(userId).append(" ELSE 0 END) ");
		sql.append("FROM n_check_list WHERE YEAR(pubdate)=").append(year).append(" GROUP BY YEAR(pubdate)");

		@SuppressWarnings("unchecked")
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
	//根据老人id查看签到情况，获取参加活动的id
	public List<NCheckList> getListNCheckList(int userId){
		String hql="from NCheckList n where n.userId=?";
		return super.find(hql,userId);
	}
	
	//查询以签到的老人
		public NCheckList getListNCheckList(int activityId,int userId){
			String hql="from NCheckList n where n.activityId=? and userId=?";
			List<NCheckList> cks= super.find(hql,activityId,userId);
			if(cks.size()!=0){
				return cks.get(0);
			}
			return null;
		}
	
}
