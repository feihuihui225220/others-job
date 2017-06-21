package com.anticw.aged.dao.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public abstract class MongoBaseDao {

	/**
	 * mongodb template
	 */
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	/**
	 * 分页查询
	 * MongoBaseDao.find()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @param page
	 * @param num
	 * @return
	 */
	protected <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
		return mongoTemplate.find(query, entityClass, collectionName);
	}
	
	/**
	 * 查询总数量
	 * MongoBaseDao.queryCount()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @param query
	 * @param collectionName
	 * @return
	 */
	protected long queryCount(Query query, String collectionName) {
		return mongoTemplate.count(query, collectionName);
	}
	
	/**
	 * 保存
	 * MongoBaseDao.save()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param save
	 * @param collectionName
	 * @return
	 */
	protected void save(Object t) {
		mongoTemplate.save(t);
	}
	
	/**
	 * 查找全部
	 * MongoBaseDao.findAll()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param save
	 * @param collectionName
	 * @return
	 */
	protected <T> List<T> findAll(Class<T> entityClass, String collectionName) {
		return mongoTemplate.findAll(entityClass, collectionName);
	}
	
	/**
	 * 保存对象
	 * MongoBaseDao.update()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param update
	 * @param collectionName
	 * @return
	 */
	protected <T> void update(T o, T n) {
		mongoTemplate.remove(o);
		mongoTemplate.save(n);
	}
	
	/**
	 * 更新对象
	 * MongoBaseDao.update()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-12-20 </P>
	 * @param update
	 * @return
	 */
	protected <T> void update(Class<T> entityClass, String collectionName, Query query, Update update) {
		mongoTemplate.updateFirst(query, update, entityClass, collectionName);
	}
	
	/**
	 * 删除对象
	 * MongoBaseDao.remove()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-12-01 </P>
	 * @param t
	 * @param collectionName
	 * @return
	 */
	protected <T> void remove(T t, String collectionName) {
		this.mongoTemplate.remove(t, collectionName);
	}
}
