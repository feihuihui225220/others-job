package com.anticw.aged.dao.professional.activity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;

/**
 * 
 * @author dx
 *
 */
@Component
public class NActivityPlanDao extends HibernateEntityDao<NActivityPlan> {
	/**
	 * 查询出所需月份的所有活动
	 * 
	 * @param createdBy
	 * @param createdAt
	 * @return
	 */
	public List<NActivityPlan> getList(String createdBy, Date start, Date end) {
		String hql = "from NActivityPlan n where n.createdBy=? and createdAt between ? and ?";
		return super.find(hql, createdBy, start, end);
	}

	public int getNum(String siteId) {
		String hql = "from NActivityPlan n where siteIds=?";
		return super.find(hql, siteId).size();
	}

	public NActivityPlan findByVolunteerId(String volunteerId){
		List<NActivityPlan> list = super.find(
				"from NActivityPlan where id in(" + volunteerId + ")order by changedAt desc");
		if (list.size() != 0) {
			return list.get(0);

		} else {
			return null;
		}
	}
	
	public NActivityPlan  getNActivityPlan(String data,Integer siteId){
		List<NActivityPlan> list = super.find(
				"from NActivityPlan where pubdate='"+data+"' and siteIds="+siteId);
		if (list.size() != 0) {
			return list.get(0);

		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public NActivityPlan  getNext(int id,Integer siteId){
		NActivityPlan na=super.get(id);
		String sql="SELECT * FROM n_activity_plan WHERE id = (SELECT MIN(id) FROM n_activity_plan WHERE pubdate > '"+DateUtil.getCurrentFormatDate(na.getPubdate())+"' AND siteIds="+siteId+")  ";
		 List<NActivityPlan> list= super.getSQLQuery(NActivityPlan.class, sql).list();
		 if(list.size()>0){
			 return list.get(0);
		 }
		 return  null; 
	}
	/**
	 * 获取时间段之内所有的活动(有问题)
	 * @param date
	 * @return
	 */
	public List<NActivityPlan>  getNActivityPlan(DateParamVO date,Integer volunteerId){
		 return  super.find("from NActivityPlan where pubdate between ? and ? and volunteerId like '%"+volunteerId+"%'",date.getStart(),date.getEnd());
	}
}
