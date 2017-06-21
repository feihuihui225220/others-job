package com.anticw.aged.dao.professional.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NactivityProgramOfEvents;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.activity.DateSumPlan;
import com.anticw.aged.vo.professional.activity.StatisticsVO;

/**
 * 
 * @author dx 2016/3/2
 *
 */
@Repository
public class NactivityProgramOfEventsDao extends
		HibernateEntityDao<NactivityProgramOfEvents> {
	/**
	 * 查询当前活动的节目
	 * 
	 * @param planId
	 * @return
	 */
	public List<NactivityProgramOfEvents> getList(int planId) {
		String hql = "from  NactivityProgramOfEvents where planId=?";
		return super.find(hql, planId);
	}

	public Page<NactivityProgramOfEvents> getPage(int teacherId, int page,
			int size) {
		String hql = "from  NactivityProgramOfEvents where teacherId=?";
		return super.pagedQuery(hql, page, size, teacherId);
	}

	public List<String> getList(int planId, int teacherId) {
		String hql = "select keyword from  NactivityProgramOfEvents"
				+ " where nActivityPlan in(from NActivityPlan where id=?) and teacherId=? and parentNode=0";
		return super.find(hql, planId, teacherId);
	}

	public List<Object[]> getLists(int planId, int teacherId) {
		String hql = "select keyword,progranId,duration from  NactivityProgramOfEvents where nActivityPlan in(from NActivityPlan where id=?) and teacherId=? and parentNode=0";
		return super.find(hql, planId, teacherId);
	}

	public int getCount(int progranId) {
		String hql = "from  NactivityProgramOfEvents where progranId=?";
		return super.find(hql, progranId).size();
	}

	public Long getTime(int planId, int teacherId) {
		String hql = "select sum(cast(duration as long)) from  NactivityProgramOfEvents where nActivityPlan in(from NActivityPlan where id=?) and teacherId=? and parentNode>0";
		List<Long> li = super.find(hql, planId, teacherId);
		if (li != null && li.get(0) != null) {
			return li.get(0);
		} else {
			return 0L;
		}
	}

	public List<StatisticsVO> getSum(int teacherId, DateParamVO dateParamVO) {
		String start = DateUtil.getCurrentFormatDate(dateParamVO.getStart());
		String end = DateUtil.getCurrentFormatDate(dateParamVO.getEnd());
		StringBuffer sb = new StringBuffer(
				"SELECT t1.site ,t1.sumw,t2.sumz,t2.sTime,t3.wPlan,t3.wTime,m.site_name FROM ");
		sb.append(" (SELECT COUNT(*) as sumw, n_activity_plan.siteIds as site ");
		sb.append(" FROM n_activity_plan,n_activity_programofevents WHERE  ");
		sb.append(
				" n_activity_plan.id in(SELECT plan_id FROM  n_activity_programofevents WHERE teacher_id=")
				.append(teacherId)
				.append(" AND parent_node=0) AND n_activity_plan.pubdate BETWEEN '")
				.append(start).append("' AND '").append(end + "'");
		sb.append(" AND n_activity_programofevents.plan_id=n_activity_plan.id ");
		sb.append(
				" AND n_activity_programofevents.plan_id NOT IN (SELECT plan_id FROM  n_activity_programofevents WHERE teacher_id=")
				.append(teacherId).append(" AND parent_node!=0) ");
		sb.append(
				" AND n_activity_programofevents.parent_node =0 AND n_activity_programofevents.teacher_id=")
				.append(teacherId).append(" GROUP BY siteIds) AS t1 ");
		sb.append(" LEFT JOIN (SELECT COUNT(*) as sumz, n_activity_plan.siteIds as site1,SUM(n_activity_programofevents.duration) AS sTime ");
		sb.append(" FROM n_activity_plan,n_activity_programofevents  WHERE ");
		sb.append(
				" n_activity_plan.id in(SELECT plan_id FROM  n_activity_programofevents WHERE teacher_id=")
				.append(teacherId)
				.append(" AND parent_node =0) AND n_activity_plan.pubdate BETWEEN '")
				.append(start).append("' AND '").append(end + "'");
		sb.append(
				" AND n_activity_programofevents.plan_id=n_activity_plan.id AND n_activity_programofevents.parent_node =0 AND n_activity_programofevents.teacher_id=")
				.append(teacherId)
				.append(" GROUP BY siteIds) as t2 ON t1.site=t2.site1 ");
		sb.append(" LEFT JOIN (SELECT COUNT(*) AS wPlan, n_activity_plan.siteIds as site2,SUM(n_activity_programofevents.duration) AS wTime FROM n_activity_plan,n_activity_programofevents ");
		sb.append(" WHERE n_activity_plan.id in(SELECT plan_id FROM  n_activity_programofevents WHERE ");
		sb.append(" teacher_id=")
				.append(teacherId)
				.append(" AND parent_node=0) AND n_activity_plan.pubdate BETWEEN '")
				.append(start)
				.append("' AND '")
				.append(end + "'")
				.append(" AND n_activity_programofevents.plan_id=n_activity_plan.id ");
		sb.append(" AND n_activity_programofevents.parent_node!=0 ");
		sb.append(" AND n_activity_programofevents.teacher_id=")
				.append(teacherId)
				.append(" GROUP BY siteIds) AS t3 ON t1.site=t3.site2 LEFT JOIN m_vender_site m ON m.id=t1.site");
		List<Object[]> all = super.findBySQLQuery(sb.toString());
		List<StatisticsVO> vos = new ArrayList<StatisticsVO>();
		for (Iterator<Object[]> iter = all.iterator(); iter.hasNext();) {
			StatisticsVO vo = new StatisticsVO();
			Object[] a = iter.next();
			vo.setSumw((String) (a[1] == null ? "0" : a[1].toString()));
			vo.setSiteId((String) (a[0] == null ? "0" : a[0].toString()));
			vo.setSumz((String) (a[2] == null ? "0" : a[2].toString()));
			vo.setSTime((String) (a[3] == null ? "0" : a[3].toString()));
			vo.setWPlan((String) (a[4] == null ? "0" : a[4].toString()));
			vo.setWTime((String) (a[5] == null ? "0" : a[5].toString()));
			vo.setSiteName((String) (a[6] == null ? "0" : a[6].toString()));
			vos.add(vo);
		}
		return vos;
	}

	public List<DateSumPlan> getDateSumPlan(int teacherId,
			DateParamVO dateParamVO) {
		String start = DateUtil.getCurrentFormatDate(dateParamVO.getStart());
		String end = DateUtil.getCurrentFormatDate(dateParamVO.getEnd());
		StringBuffer sb = new StringBuffer(
				"SELECT  t1.pubdate,t1.siteIds,t2.count,m.site_name from (");
		sb.append(" SELECT n.siteIds as siteIds,n.pubdate as pubdate,n.id AS planId FROM n_activity_plan AS n WHERE n.id IN ");
		sb.append(
				" (SELECT ap.plan_id from n_activity_programofevents  AS ap WHERE ap.teacher_id=")
				.append(teacherId)
				.append(" AND ap.parent_node!=0 GROUP BY ap.plan_id) ");
		sb.append(" AND n.pubdate BETWEEN '").append(start).append("' AND '")
				.append(end+"'");
		sb.append(") AS t1 LEFT JOIN (SELECT count(*) as count, ap.plan_id AS planId FROM  n_activity_programofevents  AS ap WHERE ");
		sb.append(" ap.teacher_id=").append(teacherId);
		sb.append(" AND ap.parent_node!=0 GROUP BY ap.plan_id ) AS t2 ON t1.planId=t2.planId LEFT JOIN m_vender_site m ON m.id=t1.siteIds ");
		List<Object[]> all = super.findBySQLQuery(sb.toString());
		List<DateSumPlan> vos = new ArrayList<DateSumPlan>();
		for(Iterator<Object[]> iter = all.iterator(); iter.hasNext();) {
			DateSumPlan vo = new DateSumPlan();
			//一条记录
			Object[] column = iter.next();
			Date date= (Date)column[0]; 
			vo.setPubdate(date);
			String s=(String)column[1];
			vo.setSiteId(Integer.parseInt(s));
			String s1=column[2].toString();
			vo.setSum(Integer.parseInt(s1));
			vo.setSiteName((String)column[3]);
			vos.add(vo);
		}
		return vos;

	}
}
