package com.anticw.aged.dao.community.notice;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ONotice;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component
public class NoticeDao extends HibernateEntityDao<ONotice> {

	// 分页查询社区下所有
	public Page<ONotice> list(int pageNo, int pageSize, int communityId) {
		String hql = "from ONotice where available=? and communityId=? order by createdAt desc";
		/*
		 * //查询条件 Criterion[] criterions = new Criterion[]{
		 * Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
		 * //有效数据 Restrictions.eq("communityId", communityId)//本社区数据 };
		 */

		// 分页查询

		// return super.pagedQuery(pageNo,pageSize, criterions);
		return super.pagedQuery(hql, pageNo, pageSize, PropertyValueConstants.AVAILABLE, communityId);
	}

	// 根据条件查询
	public Page<ONotice> listByCriteria(int pageNo, int pageSize, List<Criterion> criterions) {

		return super.pagedQuery(pageNo, pageSize, criterions.toArray(new Criterion[criterions.size()]));

	}

	// 通过ID获取
	public ONotice getNotice(int id) {
		return super.get(id);
	}
	// 添加

	public void addNotice(ONotice oNotice) {
		super.save(oNotice);
	}

	// 编辑
	public void editNotice(ONotice oNotice) {
		super.update(oNotice);
	}

}
