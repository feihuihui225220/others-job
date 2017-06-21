package com.anticw.aged.dao.icare.vip;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZGuidePhoto;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：TODO	
 */
@Component
public class GuidePhotoDao extends HibernateEntityDao<ZGuidePhoto> {
	
	public Page<ZGuidePhoto> getGuidePhone(int page, int num) {
		// 查询条件
		Criterion[] criterions = new Criterion[] {
		};
		return this.pagedQuery(ZGuidePhoto.class, page, num, criterions);
	}
}
