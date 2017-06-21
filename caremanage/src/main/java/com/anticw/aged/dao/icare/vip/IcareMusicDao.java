package com.anticw.aged.dao.icare.vip;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.CareMusic;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Component
public class IcareMusicDao extends HibernateEntityDao<CareMusic>{
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<CareMusic> getMusicList(int page, int num) {
		// 查询条件
		Criterion[] criterions = new Criterion[] { 
				Restrictions.eq("available",PropertyValueConstants.AVAILABLE) // 分类数据
		// 分页查询
		};
		return super.pagedQuery(CareMusic.class, page, num, criterions);
	}
	
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<CareMusic> getMusicListByCategory(int page, int num,Integer category) {
		// 查询条件
		Criterion[] criterions = new Criterion[] {
				Restrictions.eq("available",PropertyValueConstants.AVAILABLE), // 有效条件
				Restrictions.eq("category",category) // 分类数据
				// 分页查询
		};
		return super.pagedQuery(CareMusic.class, page, num, criterions);
	}
}
