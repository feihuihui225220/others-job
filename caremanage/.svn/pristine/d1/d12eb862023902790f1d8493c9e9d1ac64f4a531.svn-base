package com.anticw.aged.dao.professional.activity;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @date 2015/9/25 
 * @author dx
 *
 */
@Repository
public class NVolunteerServiceRecordDao extends HibernateEntityDao<NVolunteerServiceRecord>{
	//添加
	public void addNVolunteerServiceRecord(NVolunteerServiceRecord nVolunteerServiceRecord){
		super.save(nVolunteerServiceRecord);
	}
	//查询
	public List<NVolunteerServiceRecord> setListNVolunteerServiceRecord(int activityId,Date pubdate){
		String hql="from NVolunteerServiceRecord  where activityId=? and createdAt=?";
		return super.find(hql, activityId,pubdate);
		
	}
	/**
	 * 查询条数/志愿者
	 * @param activityId
	 * @param pubdate
	 * @return
	 */
	public int getNVolunteerServiceRecordCount(int activityId,Date pubdate){
		int count=0;
		Session session=this.currentSession();
		String hql="select count(n) from NVolunteerServiceRecord n where n.activityId="+activityId+" and createdAt='"+pubdate+"'";
		Query query=session.createQuery(hql);
		Object cnt = query.uniqueResult();  
		if(cnt != null){  
			count = Integer.parseInt(cnt.toString());  
		}  
		return count;
	} 
	/**
	 * 查询当权月份下志愿者签到的活动
	 * @param volunteerId
	 * @param start
	 * @param end
	 * @return
	 */
	public List<NVolunteerServiceRecord>  getListNVolunteerServiceRecords(int volunteerId,Date start,Date end){
		String hql="from NVolunteerServiceRecord n where volunteerId=? and createdAt between ? and ?";
		return super.find(hql, volunteerId,start,end);
		
	}
	public List<Integer>  getListNVolunteerServiceRecords(int activityId){
		String hql="select volunteerId from NVolunteerServiceRecord n where activityId=?";
		return super.find(hql, activityId);
		
	}
	public List<Integer>  getListNVolunteerService(int volunteerId){
		String hql="select activityId from NVolunteerServiceRecord n where volunteerId=?";
		return super.find(hql, volunteerId);
		
	}
	//查询 根据时间  志愿者Id查询一条记录
	public NVolunteerServiceRecord nVolunteerServiceRecord(int volunteerId,Date createdAt){
		String hql="from NVolunteerServiceRecord n where n.volunteerId=? and n.createdAt=?";
		List<NVolunteerServiceRecord> nVolunteerServiceRecord=this.find(hql, volunteerId,createdAt);
		return nVolunteerServiceRecord.get(0);
	}
	public void update(NVolunteerServiceRecord nVolunteerServiceRecord){
		super.update(nVolunteerServiceRecord);
	}
	
	
}
