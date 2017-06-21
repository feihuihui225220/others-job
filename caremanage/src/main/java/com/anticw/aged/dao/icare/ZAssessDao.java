package com.anticw.aged.dao.icare;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZAssess;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd 日期：2016-10-19 功能：TODO
 */
@Component
public class ZAssessDao extends HibernateEntityDao<ZAssess> {
	/**
	 * 查询所有有效的评估问卷
	 * 
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<ZAssess> getAssessList(int page, int num) {
		// 查询条件
		Criterion[] criterions = new Criterion[] { Restrictions.eq("available", PropertyValueConstants.AVAILABLE) // 分类数据
				// 分页查询
		};
		return this.pagedQuery(ZAssess.class, page, num, criterions);
	}

	/**
	 * 获取对应的Id 在ocategoryitem中获取对应的量表类型时 同步将id加上
	 * 
	 * @param title
	 * @return
	 */
	public Integer getZAssess(Integer title) {
		String hql = "from ZAssess where title=? and available=?";
		List<ZAssess> z = super.find(hql, title, PropertyValueConstants.AVAILABLE);
		if (z.size() != 0) {
			return z.get(0).getId();
		}
		return 0;
	}

	public ZAssess getZAssess_(Integer title) {
		String hql = "from ZAssess where title=? and available=?";
		List<ZAssess> z = super.find(hql, title, PropertyValueConstants.AVAILABLE);
		if (z.size() != 0) {
			return z.get(0);
		}
		return null;
	}

	/**
	 * 获取所有的有效的类型
	 * 
	 * @return
	 */
	public List<ZAssess> getList() {
		String hql = "from ZAssess where  available=?";
		return super.find(hql, PropertyValueConstants.AVAILABLE);
	}

}
