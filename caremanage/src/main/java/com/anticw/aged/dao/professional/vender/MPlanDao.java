/**
 * 
 */
package com.anticw.aged.dao.professional.vender;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MPlan;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * @author li
 *
 */
@Repository
public class MPlanDao extends HibernateEntityDao<MPlan> {

   /**
    * 查询用户服务计划
    * @param serviceTime
    * @param uid
    * @param orderId
    * @return
    */
	public List<MPlan> getUserPlan(Date serviceTime ,Long uid,Long orderId){
		String hql="from MPlan where serviceTime=? and userId=? and order_id＝?";
		return super.find(hql, serviceTime,uid,orderId);
	}
	/**
	 * 根据用户Id获取专业服务
	 * @param uid
	 * @return
	 */
	public List<MPlan> getUserPlan(Long uid){
		String hql="from MPlan where userId=? ";
		return super.find(hql, uid);
	}
	public List<MPlan> getUserPlanByDate(Long uid,String date){ 
		String start=date+" 00:00:00";
		String end=date+" 23:59:59";
		String hql="from MPlan where userId=? and serviceTime between '"+start+"' and '"+end+"'";
		List<MPlan> resutl=super.find(hql, uid);
		return resutl;
	}
	public List<MPlan> getByDate(Long uid,String start,String end){ 
		String hql="from MPlan where userId=? and serviceTime between '"+start+"' and '"+end+"'";
		List<MPlan> resutl=super.find(hql, uid);
		return resutl;
	}
}
