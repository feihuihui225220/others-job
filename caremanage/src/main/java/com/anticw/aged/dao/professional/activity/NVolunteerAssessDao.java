package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NVolunteerAssess;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 
 * @author marenbao 2017/02/13
 * 
 */
@Component
public class NVolunteerAssessDao extends HibernateEntityDao<NVolunteerAssess> {

	/**
	 * 修改志愿者量表
	 * 
	 * @param nVolunteerAssess
	 */
	public void updateNVolunteerAssess(NVolunteerAssess nVolunteerAssess) {
		NVolunteerAssess nvas = super.get(nVolunteerAssess
				.getId());
		nvas.setDetail(nVolunteerAssess.getDetail());
		super.update(nvas);

	}
	
	/**
	 * 分页查询量表信息
	 * @param planName
	 * @param date
	 * @param siteId
	 * @return
	 */
	public Page<Object[]> getPage(String planName,String date,Integer siteId,int pageNo,int pageSize){
		StringBuffer sb=new StringBuffer("SELECT n.id,n.detail,a.`name`,p.`plan_name`,ms.site_name,p.pubdate FROM  `n_volunteer_assess` n ,`n_activity_plan` p,a_user a,m_vender_site ms  WHERE  n.`n_super`=1  AND ");
		sb.append(" n.`activity_id`=p.`id`  AND a.`id`=n.`volunteer`  AND ms.id=p.`siteIds` ");
		if(siteId!=null&&siteId!=0){
			sb.append("AND p.`siteIds`="+siteId);
		}
		if(date!=null&&date!=""){
			sb.append(" AND p.`pubdate`='"+date+"'");
		}
		if(planName!=null&&planName!=""){
			sb.append(" AND p.plan_name LIKE '%"+planName+"%'");
		}
		sb.append(" UNION  SELECT n.id,n.detail,nv.`name`,p.`plan_name`,ms.site_name,p.pubdate FROM  `n_volunteer_assess` n ,`n_activity_plan` p,`n_volunteer` nv,m_vender_site ms WHERE   n.`activity_id`=p.`id`  AND  n.`volunteer`=nv.`id`  AND ms.id=p.`siteIds` ");
		if(siteId!=null&&siteId!=0){
			sb.append("AND p.`siteIds`="+siteId);
		}
		if(date!=null&&date!=""){
			sb.append(" AND p.`pubdate`='"+date+"'");
		}
		if(planName!=null&&planName!=""){
			sb.append(" AND p.plan_name LIKE '%"+planName+"%'");
		}
		return super.pageBySQLQuery(sb.toString(), pageNo, pageSize);
	}
	
	public int getNVolunteerAssess(Integer planId) {
		 String hql="from NVolunteerAssess WHERE activityId="+planId;
		 return super.find(hql).size();
	}
	
	public int getNVolunteerAssessId(Integer planId) {
		 String hql="from NVolunteerAssess WHERE activityId="+planId;
		 List<NVolunteerAssess> list=super.find(hql);
		 if(list.size()!=0){
			 return (int)list.get(0).getId();
		}
		return 0;
	}

}
