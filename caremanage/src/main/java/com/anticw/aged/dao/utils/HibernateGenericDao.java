package com.anticw.aged.dao.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.Assert;

/**
 * 扩展hibernateDaoSupport，封装数据操作工具类，并对返回结果进行泛型处理
 * <P>File name : HibernateGenericDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-18 </P>
 */
public class HibernateGenericDao extends HibernateDaoSupport {
	
	/**
	 * 自动绑定sessionFactory
	 */
	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory){   
		super.setSessionFactory(sessionFactory);   
	}  
	
	/**
	 * 根据Id加载对象 
	 */
	protected <T> T load(Class<T> entityClass, Serializable id) {
		return (T)getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 获取Id获取对象 
	 */
	protected <T> T get(Class<T> entityClass, Serializable id) {
		return (T)getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 加载全部对象 
	 */
	protected <T> List<T> loadAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 保存对象
	 */
	public <T> Serializable save(T t) {
		//getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().save(t);
	}
	
	/**
	 * 根据对象
	 */
	public <T> void update(T t){
		getHibernateTemplate().update(t);
	}
	
	/**
	 * 保存或更新对象
	 */
	public <T> void saveOrUpdate(T t){
		getHibernateTemplate().saveOrUpdate(t);
	}

	/**
	 * 删除对象
	 */
	public <T> void remove(T t) {
		getHibernateTemplate().delete(t);
	}

	/**
	 * 根据Id删除对象
	 */
	protected <T> void removeById(Class<T> entityClass, Serializable id) {
		remove(get(entityClass, id));
	}
	
	/**
	 * 创建Query对象.
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以返回Query后自行设置.
	 * 留意可以连续设置,如 dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 */
	public Query getQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = currentSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	/**
	 * 创建Query对象. 指定类型
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以返回Query后自行设置.
	 * 留意可以连续设置,如 dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 */
	protected <T> Query getSQLQuery(Class<T> clazz, String sql, Object... values){
		Assert.hasText(sql);
		Query query = currentSession().createSQLQuery(sql).addEntity(clazz);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	/**
	 * 创建Query对象. 指定类型
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以返回Query后自行设置.
	 * 留意可以连续设置,如 dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 */
	protected <T> Query getSQLQuery(String sql, Object... values){
		this.flushSession();
		Assert.hasText(sql);
		Query query = currentSession().createSQLQuery(sql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	/**
	 * 创建Criteria对象
	 */
	protected <T> Criteria getCriteria(Class<T> entityClass, Criterion... criterion) {
		Criteria criteria = currentSession().createCriteria(entityClass);
		for (Criterion c : criterion) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * HQL查询
	 * HibernateGenericDao.find()<BR>
	 * <p>Author : leo </P>
	 * <P>Date : 2014-9-8 </P>
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql, Object... values) {
		//Assert.hasText(hql);
		return (List<T>)getHibernateTemplate().find(hql, values);
	}

	/**
	 * 分页查询函数，使用Criteria.
	 */
	@SuppressWarnings("unchecked")
	protected <T> Page<T> pagedQuery(Class<T> entityClass, int pageNo, int pageSize, Criterion... criterion) {
		
		//页码必须大于等于0
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		
		//criteria
		Criteria criteria = getCriteria(entityClass, criterion);
		
		//conv to criteria impl
		CriteriaImpl impl = (CriteriaImpl)criteria;

		//先把Projection和OrderBy条件取出来,清空两者来执行Count操作
		Projection projection = impl.getProjection();
		List<CriteriaImpl.OrderEntry> orderEntries;
		try {
			orderEntries = (List<CriteriaImpl.OrderEntry>)BeanUtils.getDeclaredProperty(impl, "orderEntries");
			BeanUtils.setDeclaredProperty(impl, "orderEntries", new ArrayList<T>());
		}catch (Exception e) {
			logger.error("Runtime Exception impossibility throw ");
			return new Page<T>();
		}

		//查询总记录数
		long totalCount = Long.valueOf(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());

		//将之前的Projection和OrderBy条件重新设回去
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		
		try {
			BeanUtils.setDeclaredProperty(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			logger.error("Runtime Exception impossibility throw ");
			return new Page<T>();
		}

		//返回分页对象
		if (totalCount < 1) {
			return new Page<T>();
		}
		
		//计算分页起始位置
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		
		//查询列表
		List<T> list = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();

		Page<T> page = new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setResult(list);
		page.setTotalCount((int)totalCount);
		
		return page;
	}

	/**
	 * 分页查询函数，使用hql.
	 */
	@SuppressWarnings("unchecked")
	public <T> Page<T> pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
		
		//页码必须大于等于0
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		
		//sql必须合法
		Assert.hasText(hql);
		
		//Count查询
		String countQueryString = " select count(*) " + removeSelect(removeOrders(hql));
		List<T> countlist = (List<T>)find(countQueryString, values);
		if(countlist.size()==0){
			return null;
		}
		long totalCount = (Long) countlist.get(0);

		//无结果返回空列表
		if (totalCount < 1) {
			return new Page<T>();
		}
		
		//计算总页数
		long totalPage = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			totalPage++;
		}
		
		//如果获取的分页范围大于总页数则默认最后一页
		if(totalPage < pageNo) {
			pageNo = (int)totalPage;
		}
		
		//实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		Query query = getQuery(hql, values);
		List<T> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

		Page<T> page = new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setResult(list);
		page.setTotalCount((int)totalCount);
		
		return page;
	}
	
	/**
	 * 执行sql查询
	 * HibernateGenericDao.executeSQL()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param sql
	 * @param values
	 */
	public void executeSQL(String sql, Object...values) {
		this.getSQLQuery(sql, values).executeUpdate();
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
	@SuppressWarnings("rawtypes")
	public Long getCount(String hql, Object...values){
		List countlist = (List)find(hql, values);
		return  (long)countlist.size();
	}
	
	/**
	 * 开启事务
	 * HibernateGenericDao.txBegin()<BR>
	 * <p>Author : leo </P>
	 * <P>Date : 2014-9-8 </P>
	 * @return
	 */
	protected Transaction txBegin(){
		return currentSession().beginTransaction(); 
	}
	
	/**
	 * 提交事务
	 * HibernateGenericDao.txCommit()<BR>
	 * <p>Author : leo </P>
	 * <P>Date : 2014-9-8 </P>
	 */
	protected void txCommit(){
		currentSession().getTransaction().commit();
	}
	
	/**
	 * 回滚事务
	 * HibernateGenericDao.txRollBack()<BR>
	 * <p>Author : leo </P>
	 * <P>Date : 2014-9-8 </P>
	 */
	protected void txRollBack(){
		currentSession().getTransaction().rollback();
	}
	
	/**
	 * 刷新session
	 * HibernateGenericDao.flushSession()<BR>
	 * <p>Author : leo </P>
	 * <P>Date : 2014-9-8 </P>
	 */
	protected void flushSession(){
		currentSession().flush();
	}
	
	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	/**
	 * 去除hql的orderby子句，用于pagedQuery.
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
