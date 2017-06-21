package com.anticw.aged.dao.icare;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZBanner;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Component
public class ZBannerDao extends HibernateEntityDao<ZBanner>{
	
   //查询全部
	public List<ZBanner> selectAll() {
		String hqlStr = "from ZBanner where available=1 order by createdAt desc";
		return super.find(hqlStr);
	}
   //添加
	public void addBanner(ZBanner zBanner) {
		super.save(zBanner);
		super.currentSession().clear();
		
	}
	//删除
	public void deleteById(int id) {
		String hql = "update ZBanner set available=0  where id=" + id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
		
	}
	//修改
	public void modifyBanner(ZBanner z) {
		super.update(z);
		
	}


}
