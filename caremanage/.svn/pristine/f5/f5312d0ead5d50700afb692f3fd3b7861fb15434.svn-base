package com.anticw.aged.dao.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.anticw.aged.dao.utils.MongoBaseDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 元数据持久化类
 * <P>File name : MetaDataDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
@Repository
public class MetaDataDao extends MongoBaseDao {

	/**
	 * 根据日期进行分页查询
	 * MetaDataDao.findByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-11 </P>
	 * @param entityClass
	 * @param collectionName
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public <T> Page<T> findByPage(Class<T> entityClass, String collectionName, String deviceBindId, Date start, Date end, int page, int num) {
		
		//分页结果对象
		Page<T> _page = new Page<T>();
		
		//查询总数量
		//Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceBindId);
		Criteria criteria = Criteria.where("deviceId").is(deviceBindId);
		Criteria datecriteria = Criteria.where("uploadTime").gte(start).lte(end);
		long totalCount = super.queryCount(Query.query(criteria).addCriteria(datecriteria), collectionName);
		_page.setTotalCount((int)totalCount);
		
		//查询结果
		if(totalCount > 0) {
			Query query = Query.query(criteria).skip((page-1)*num).limit(num).with(new Sort(new Sort.Order(Direction.DESC, "uploadTime")));
			query.addCriteria(datecriteria);
			List<T> datas = super.find(query, entityClass, collectionName);
			_page.setResult(datas);
		}
		
		//设置分页
		_page.setPageSize(page);
		_page.setPageSize(num);
		
		return _page;
	}
	
	/**
	 * 根据日期进行查询
	 * MetaDataDao.findByDate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-20 </P>
	 * @param entityClass
	 * @param collectionName
	 * @param start
	 * @param end
	 * @return
	 */
	public <T> List<T> findByDate(Class<T> entityClass, String collectionName, String deviceBindId, Date start, Date end) {
		Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceBindId);
		Query query = Query.query(criteria).limit(1);
		return super.find(query, entityClass, collectionName);
	}
	/**
	 * 无分页
	 * @param entityClass
	 * @param collectionName
	 * @param deviceBindId
	 * @param start
	 * @param end
	 * @return
	 */
	public <T> List<T> findDate(Class<T> entityClass, String collectionName, String deviceBindId, Date start, Date end) {
		Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceBindId);
		Query query = Query.query(criteria);
		return super.find(query, entityClass, collectionName);
	}
	
	/**
	 * 根据项目名称和日期进行查询
	 * @param entityClass
	 * @param collectionName
	 * @param deviceBindId
	 * @param itemName
	 * @param start
	 * @param end
	 * @return
	 */
	public <T> List<T> findByItemAndDate(Class<T> entityClass, String collectionName, String deviceBindId, String itemName, Date start, Date end) {
		Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceBindId);
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "uploadTime")));
		List<T> list = super.find(query, entityClass, collectionName);
		if(list != null && !list.isEmpty()) {
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 持久化到mongo数据库
	 * @author L
	 * @param <T>
	 * @param t
	 */
	public void save(Object t){
		super.save(t);
	}
}
