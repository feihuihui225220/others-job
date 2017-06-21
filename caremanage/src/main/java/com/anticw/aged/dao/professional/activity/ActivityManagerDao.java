package com.anticw.aged.dao.professional.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.activity.ActivityPlanSchemeVo;

@Component
public class ActivityManagerDao extends HibernateEntityDao<NActivityPlan> {

	/**
	 * 添加活动计划
	 * 
	 * @param activityPlan
	 * @return
	 */
	public int insertActivityPlan(NActivityPlan activityPlan) {
		Date date = new Date();
		activityPlan.setAvaliable(PropertyValueConstants.AVAILABLE);
		activityPlan.setCreatedAt(date);
		activityPlan.setChangedAt(date);
		return (Integer) super.save(activityPlan);
	}

	public NActivityPlan insert(NActivityPlan activityPlan) {
		int id = (Integer) super.save(activityPlan);
		activityPlan.setId(id);
		return activityPlan;
	}

	/**
	 * 查询所有计划
	 */

	public List<NActivityPlan> findListValue() {
		// String hql = "from NActivityPlan where avaliable=? and createdBy=?
		// order by createdAt desc";
		String hql = "from NActivityPlan where avaliable=?  order by createdAt desc";
		return super.find(hql, PropertyValueConstants.AVAILABLE);
	}

	public List<NActivityPlan> findListValue(String name) {
		String hql = "from NActivityPlan where avaliable=? and created_by=? order by createdAt desc";
		return super.find(hql, PropertyValueConstants.AVAILABLE, name);
	}

	public List<NActivityPlan> findListValue(String createby, Date start1, Date end1) {
		String hql = "from NActivityPlan where avaliable=? and createdBy=? and createdAt between ? and ?";
		return super.find(hql, PropertyValueConstants.AVAILABLE, createby, start1, end1);
	}

	public Page<NActivityPlan> findNActivityPlan(int pageNo, int pageSize, DateParamVO dateCond, String hql) {

		if (dateCond.getStart() == null && dateCond.getEnd() == null) {
			String hqlStr = "from NActivityPlan where avaliable=? ";
			if (hql != null && !"".equals(hql)) {
				hqlStr += hql;
			}
			hqlStr += " order by pubdate desc";
			return super.pagedQuery(hqlStr, pageNo, pageSize, PropertyValueConstants.AVAILABLE);
		} else if (dateCond.getStart() != null && dateCond.getEnd() == null) {
			String hqlStr = "from NActivityPlan where avaliable=? and  pubdate>=?";
			if (hql != null && !"".equals(hql)) {
				hqlStr += hql;
			}
			hqlStr += " order by pubdate desc";
			return super.pagedQuery(hqlStr, pageNo, pageSize, PropertyValueConstants.AVAILABLE, dateCond.getStart());

		} else if (dateCond.getStart() == null && dateCond.getEnd() != null) {
			String hqlStr = "from NActivityPlan where avaliable=? and  pubdate<=?";
			if (hql != null && !"".equals(hql)) {
				hqlStr += hql;
			}
			hqlStr += " order by pubdate desc";
			return super.pagedQuery(hqlStr, pageNo, pageSize, PropertyValueConstants.AVAILABLE, dateCond.getEnd());
		} else {
			String hqlStr = "from NActivityPlan where avaliable=? and  pubdate between ? and ? ";
			if (hql != null && !"".equals(hql)) {
				hqlStr += hql;
			}
			hqlStr += " order by pubdate desc";
			return super.pagedQuery(hqlStr, pageNo, pageSize, PropertyValueConstants.AVAILABLE, dateCond.getStart(),
					dateCond.getEnd());

		}

		// 分页查询

	}

	public List<NActivityPlan> findNActivityPlan(int venderId, Date pubdate) {

		String hqlStr = "from NActivityPlan where avaliable=? and venderId=? and pubdate=?";

		return super.find(hqlStr, PropertyValueConstants.AVAILABLE, venderId, pubdate);
	}

	public List<Float> findNActivityPlan(String activityIds, Date sDate, Date eDate) {

		String hqlStr = "select n.planMin from NActivityPlan n where n.id in (" + activityIds
				+ ") and avaliable=? and  n.pubdate between ? and ?";

		return super.find(hqlStr, PropertyValueConstants.AVAILABLE, sDate, eDate);
	}

	/**
	 * 查询某一天的计划
	 * 
	 * @return
	 */
	public List<NActivityPlan> findOneDateData() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String day = df.format(new Date());// new Date()为获取当前系统时间
		String start = day + " 00:00:00";
		String end = day + " 23:59:59";
		String hql = "from NActivityPlan where avaliable=? and pubdate >= '" + start + "' and pubdate <='" + end + "'";
		return super.find(hql, PropertyValueConstants.AVAILABLE);
	}

	public List<NActivityPlan> findSite(String sites) {
		if (sites == null || sites.trim() == "") {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String day = df.format(new Date());// new Date()为获取当前系统时间
		String start = day + " 00:00:00";
		String end = day + " 23:59:59";
		String hql = "from NActivityPlan where avaliable=? and siteIds in(" + sites + ")  and  pubdate >= '" + start
				+ "' and pubdate <='" + end + "' ";
		@SuppressWarnings("unused")
		List<NActivityPlan> p = super.find(hql, PropertyValueConstants.AVAILABLE);
		return super.find(hql, PropertyValueConstants.AVAILABLE);
	}

	public List<NActivityPlan> findSite(String sites, String day) {
		String start = day + " 00:00:00";
		String end = day + " 23:59:59";
		String hql = "from NActivityPlan where avaliable=? and siteIds in(" + sites + ")  and  pubdate >= '" + start
				+ "' and pubdate <='" + end + "' ";
		return super.find(hql, PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 查询一个计划
	 * 
	 * @param id
	 * @return
	 */

	public NActivityPlan findOneAvailData(int id) {
		return super.get(id);
	}

	/**
	 * 编辑计划
	 * 
	 * @param NActivityPlan
	 */
	public void editActivityPlan(NActivityPlan NActivityPlan) {
		Date date = new Date();
		NActivityPlan nap = findOneAvailData(NActivityPlan.getId());
		nap.setPlanName(NActivityPlan.getPlanName());
		nap.setPlanDesc(NActivityPlan.getPlanDesc());
		nap.setChangedAt(date);
		nap.setChangedBy(NActivityPlan.getChangedBy());
		super.update(nap);
	}

	/**
	 * 逻辑删除计划
	 * 
	 * @param id
	 */
	public void delActivityPlanById(Integer id) {
		super.removeById(id);
	}

	/**
	 * 查询一个计划的 活动方案
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ActivityPlanSchemeVo> listScheme(Integer id) {
		String sql = "SELECT a.id,a.pubdate,b.name as volunteerName,c.program_name,d.name as employeeName "
				+ "FROM n_activity_scheme a,n_volunteer b,n_program c,a_user d "
				+ "WHERE a.volunteer_id=b.id AND a.program_id=c.id AND a.employee_id=d.id AND a.id=" + id;
		Query query = currentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(ActivityPlanSchemeVo.class));
		return query.list();
	}

}
