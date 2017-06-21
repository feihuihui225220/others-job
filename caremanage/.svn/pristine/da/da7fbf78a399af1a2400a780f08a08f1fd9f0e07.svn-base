package com.anticw.aged.dao.icare;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class ZManagerInfoDao extends HibernateEntityDao<ZManagerInfo>{
	
	/**
	 * 修改
	 */
	public void update(ZManagerInfo zManagerInfo) {
		super.update(zManagerInfo);		
	}
	
	/**
	 * 删除
	 */
	public void delete(Integer id) {		
		String hql = "update ZManagerInfo set available=0  where id=" + id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
	}
	/**
	 * 添加
	 */
	public void add(ZManagerInfo zManagerInfo) {
		super.save(zManagerInfo);
		super.currentSession().clear();		
	}
	/**
	 * 查一条数据
	 */
	public ZManagerInfo getById(Integer id) {
		return super.get(id);
	}
	
	/**
	 * 查询所有
	 * @return 
	 */
	public Page<ZManagerInfo> getList(PageParamVO page) {
		String hql="from ZManagerInfo where available=1";
		return super.pagedQuery(hql,page.getPage(), page.getNum());
	}
	public List<ZManagerInfo> getLists() {
		String hql="from ZManagerInfo where available=1 order by createTime desc";
		return super.find(hql);
	}

}
