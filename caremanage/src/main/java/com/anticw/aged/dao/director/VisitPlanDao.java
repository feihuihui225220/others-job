package com.anticw.aged.dao.director;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HVisitPlan;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-9-13
 * 功能：巡诊计划
 */
@Component
public class VisitPlanDao extends  HibernateEntityDao<HVisitPlan>{
	/**
	 * 根据UserId查询查询所有计划
	 * @param userId
	 * @return
	 */
	public List<HVisitPlan> getHVisitPlanByUserId(Long userId){
		List<HVisitPlan> plan = super.find("FROM HVisitPlan a  WHERE a.user.id in " +
				"(select a.user.id from HVisitPlan where a.user.id in ?)", userId);
			return plan;
	}
	/**
	 * 根据groupId查询所有计划
	 * @param userId
	 * @return
	 */
	public List<HVisitPlan> getHVisitPlanByGroupId(Long groupId){
		List<HVisitPlan> plan = super.find("FROM HVisitPlan WHERE groupId in " +
				"(select groupId from HVisitPlan where groupId in ?)", groupId);
			return plan;
	}
	/**
	 * TODO添加计划
	 *@param hVisitPlan
	 *@return
	 */
	public int addHVisitPlan(HVisitPlan hVisitPlan){
		return (Integer) super.save(hVisitPlan);
	}
	
	/**
	 * 查询所有计划
	 * @param userId
	 * @return
	 */
	public List<Object[]> getHVisitPlan(){
		List<Object[]> planList = super.find("SELECT YEAR(r.visitTime) AS YEAR," +
				"MONTH(r.visitTime)AS MONTH,DAY(r.visitTime) AS DAY,COUNT(r.id) AS COUNT " +
				"FROM HVisitPlan AS r GROUP BY YEAR(r.visitTime),MONTH(r.visitTime),DAY(r.visitTime)");
		return planList;
	}
	/**
	 * 根据日期查询所有计划
	 * @param userId
	 * @return
	 */
	public List<HVisitPlan> getHVisitPlanByDate(long date){
		//String d = DateUtil.getCurrentFormatDate(new Date(date));
		DateParamVO dateCond=DateUtil.getDate(new Date(date));
		List<HVisitPlan> planList = super.find("SELECT a FROM HVisitPlan as a  " +
				"where  a.visitTime BETWEEN  ? and ? order by a.visitTime ",dateCond.getStart(),dateCond.getEnd());
		return planList;
	}
	public Page<HVisitPlan> getHVisitPlanByDateAndGroupId(String str,String strs,long groupId,Integer status,PageParamVO vo){

		String hql="SELECT a FROM HVisitPlan as a, RUser as b " +
				"where a.user.id=b.id  and a.groupId="+groupId+" and a.visitTime BETWEEN'"+str+"' And '"+strs+"'";
		if(status!=null){
			hql+="  and b.state="+status;
		}
		hql+=" order by a.visitTime asc ";
		Page<HVisitPlan> planList = super.pagedQuery(hql, vo.getPage(), vo.getNum());
		return planList;
	}
	/**
	 * 根据日期查询用户巡访详情
	 * @param userId
	 * @param date
	 * @return
	 */
	public HVisitPlan getPlanByDateAndUserId(Integer id){
		String hql = "SELECT a FROM HVisitPlan as a where a.id =?";
		List<HVisitPlan> planList = super.find(hql,id);
		return planList.get(0);
	}
	
}
