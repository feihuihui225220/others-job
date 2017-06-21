package com.anticw.aged.dao.utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.util.Assert;


/**
 * 负责为单个Entity对象提供CRUD操作的Hibernate DAO基类
 * 子类只要在类定义时指定所管理Entity的Class, 即拥有对单个Entity对象的CRUD操作
 * <P>File name : HibernateEntityDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-18 </P>
 */
public class HibernateEntityDao<T> extends HibernateGenericDao {
	
	/**
	 * DAO所管理的Entity类型.
	 */
	protected Class<T> entityClass;

	/**
	 * 取得entityClass.
	 * JDK1.4不支持泛型的子类可以抛开Class<T> entityClass,重载此函数达到相同效果。
	 */
	protected Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * 在构造函数中将泛型T.class赋给entityClass
	 */
	@SuppressWarnings("unchecked")
	public HibernateEntityDao() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}
	
	/**
	 * 根据Id加载对象 
	 */
	public T load(Serializable id) {
		return super.load(entityClass, id);
	}

	/**
	 * 获取Id获取对象 
	 */
	public T get(Serializable id) {
		return super.get(entityClass, id);
	}
	
	/**
	 * 加载全部对象 
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	/**
	 * 根据Id删除对象
	 */
	public void removeById(Serializable id) {
		super.removeById(entityClass, id);
	}
	
	/**
	 * 创建Query对象. 指定类型
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以返回Query后自行设置.
	 * 留意可以连续设置,如 dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 */
	public Query getSQLQuery(String sql, Object... values){
		Assert.hasText(sql);
		Query query = currentSession().createSQLQuery(sql).addEntity(entityClass);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	/**
	 * 创建Criteria对象
	 */
	public Criteria getCriteria(Criterion... criterion) {
		return super.getCriteria(entityClass, criterion);
	}

	/**
	 * 分页查询函数，使用Criteria.
	 */
	public Page<T> pagedQuery(int pageNo, int pageSize, Criterion... criterion) {
		return super.pagedQuery(entityClass, pageNo, pageSize, criterion);	
	}
	
	/**
	 * 查询数量
	 * HibernateGenericDao.get()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param hql
	 * @param values
	 * @return
	 */
	public Long getCount(String hql, Object...values) {
		return super.getCount(hql, values);
	}
	
	/**
	 * sql查询多条list ids
	 * HibernateEntityDao.findBySQLQuery()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param sql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySQLQuery(String sql, Object...values) {
		return super.getSQLQuery(sql, values).list();
	}
	
	/**
	 * 执行SQL
	 * HibernateEntityDao.executeSQL()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param sql
	 * @param values
	 */
	public void executeSQL(String sql, Object...values) {
		super.executeSQL(sql, values);
	}


	public Page<Object[]> pageBySQLQuery(String sql,int pageNo,int pageSize) {
		List<Object[]> all = this.findBySQLQuery(sql);
		//总记录数
		int totalCount = all.size();
		System.out.println(totalCount);
		int pageIndex=(pageNo-1)*pageSize;
		//分页
		String sql1=(pageNo == 1 ? 0 : pageIndex) + "," +  pageSize;
		sql+=" LIMIT  "+sql1;
		//查询分页记录
		System.out.println(sql);
		List<Object[]> list = this.findBySQLQuery(sql);
		//构建分页对象
		Page<Object[]> _page = new Page<Object[]>();
		_page.setPageNo(pageNo);
		_page.setPageSize(pageSize);
		_page.setTotalCount(totalCount);
		_page.setResult(list);
		return _page;
	}
	
}
