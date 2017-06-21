package com.anticw.aged.dao.icare.active;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZActive;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class activeDao extends HibernateEntityDao<ZActive> {

	/**
	 * 查询所有的活动
	 * 
	 * @param activeName
	 * @param startTime
	 * @param endTime
	 * @param vo
	 * @return
	 */
	public Page<ZActive> listAllAcitve(String activeName, Integer state, String startTime, String endTime,
			PageParamVO vo, Integer rId) {
		String hql = "from ZActive where avaliable=?";
		if (activeName != null) {
			hql += "and activeName like '%" + activeName + "%'";
		}
		if (startTime != null && endTime != null) {
			hql += "and createAt BETWEEN '" + startTime + "' And '" + endTime + "'";
		}
		if (startTime != null && endTime == null) {
			hql += "and createAt >'" + startTime + "' ";
		}
		if (startTime == null && endTime != null) {
			hql += "and createAt <'" + endTime + "' ";
		}
		if (state != null) {
			hql += "and state=" + state;
		}
		if (rId != null) {
			hql += "and userId=" + rId;
		}
		hql += "order by createAt desc";

		return super.pagedQuery(hql, vo.getPage(), vo.getPageSize(), PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 根据ID查询NActivityPlan
	 * 
	 * @param id
	 * @return
	 */
	public ZActive findActiveById(Long id) {
		String hql = "from ZActive where avaliable=? and id=?";
		return (ZActive) super.find(hql, PropertyValueConstants.AVAILABLE, id).get(0);
	}

	/**
	 * 添加
	 * 
	 * @param active
	 */
	public void saveActive(ZActive active) {
		super.save(active);
	}

	/**
	 * 修改
	 * 
	 * @param active
	 */
	public void updateActive(ZActive active) {
		super.update(active);
	}

	/**
	 * 删除
	 */
	public void deleteActive(Long id) {
		super.removeById(id);
	}

	/**
	 * 前台活动
	 */
	/**
	 * 活动列表浏览量最多的四条数据
	 */
	@SuppressWarnings("unchecked")
	public List<ZActive> list() {
		Session session = currentSession();
		String hql = "from ZActive where avaliable=1 and state=0 order by createAt desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		return query.list();
	}

	/**
	 * 查询用户当前的活动记录
	 */
	public List<ZActive> listZActiveByIdAndDay(Long rId, Date date) {
		String hql = "from ZActive where avaliable=? and state=? and userId=?";
		Date start = DateUtil.getStartDate(date);
		Date end = DateUtil.getEndDate(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sta = format.format(start);
		String en = format.format(end);
		hql += "and createAt BETWEEN'" + sta + "'AND'" + en + "'";
		return super.find(hql, PropertyValueConstants.AVAILABLE, 1, rId);
	}

	@SuppressWarnings("unchecked")
	public List<ZActive> listWX(Long rId) {
		String hql = "FROM ZActive WHERE  userId=?" + rId
				+ " AND avaliable=1  GROUP BY DATE_FORMAT(createAt,'%Y%m%d') ORDER BY createAt DESC";
		Session session = currentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		return query.list();
	}

}
