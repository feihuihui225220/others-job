package com.anticw.aged.dao.icare;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZVipIntroduce;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Component
public class ZVipIntroduceDao extends HibernateEntityDao<ZVipIntroduce> {

	/**
	 * 添加
	 */
	public void add(ZVipIntroduce z) {
		super.save(z);
		super.currentSession().clear();
	}
	/**
	 * 删除
	 */
	public void delete(Integer id) {
        String hql="update ZVipIntroduce set available=0  where id="+id;
        Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();		
	}
	/**
	 * 查询全部
	 */
	public List<ZVipIntroduce> getList() {
		String hql="from ZVipIntroduce where available=1 ";
		return super.find(hql);
	}
	

}
