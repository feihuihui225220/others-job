package com.anticw.aged.dao.data;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.mongo.MAlarm;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.MongoBaseDao;

/**
 * 警报持久化对象
 * <P>File name : AlarmDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-13 </P>
 */
@Repository
public class AlarmDao extends MongoBaseDao {

	/**
	 * 警报collectionName
	 */
	private static final String COLLECTION_NAME = "m_alarm";
	
	/** 
	 * 获取警报
	 * @name AlarmDao.getAlarm()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午6:11:39
	 * @param id
	 * @return     
	 */
	public MAlarm getAlarm(String id){
		//查询条件
		Criteria criteria = Criteria.where("id").is(id);
		//query
		Query query = Query.query(criteria);
		//获取集合
		List<MAlarm> alarms = find(query, MAlarm.class, COLLECTION_NAME);
		
		if(alarms != null && !alarms.isEmpty()) {
			return alarms.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 获取指定用户指定服务指定报警项目的警报数据
	 * @param userId
	 * @param serviceId
	 * @param itemName
	 * @return
	 */
	public MAlarm getAlarm(Long userId, Integer serviceId, String itemName) {
		
		//查询条件
		Criteria criteria = Criteria.where("userId").is(userId).
				            and("serviceId").is(serviceId).
				            and("dataItemName").is(itemName).
				            and("status").is(ProfessionalConstants.ALARM_STATUS_UNSOLVED);
		
		//query
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "uploadTime")));
		
		//获取集合
		List<MAlarm> alarms = find(query, MAlarm.class, COLLECTION_NAME);
		
		if(alarms != null && !alarms.isEmpty()) {
			return alarms.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取警报数据
	 * AlarmDao.getAlarmsCount()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @param serviceId
	 * @param status -1获取全部状态警报
	 * @param start
	 * @param end
	 * @return
	 */
	public long getAlarmsCount(List<Long> userIds, String userName, Integer serviceId, Short status, Date start, Date end) {
		
		//日期和用户查询条件
		Criteria criteria = Criteria.where("userId").in(userIds);//.orOperator(Criteria.where("responseTime").gte(start).lte(end)).and("userId").is(userId);
		
		if(start!=null&&end!=null){
			criteria.and("alarmTime").gte(start).lte(end);
		}
		//用户名称
		if(!StringUtils.isEmpty(userName)) {
			criteria.and("userName").is(userName);
		}
		
		//服务Id
		if(serviceId != null && serviceId != -1) {
			criteria.and("serviceId").is(serviceId);
		}
		
		//警报状态
		if(status != null && status != -1) {
			criteria.and("status").is(status);
		}
		
		//查询
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
		return super.queryCount(query, COLLECTION_NAME);
	}
	
	/**
	 * 获取警报数据
	 * AlarmDao.getAlarms()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param userId
	 * @param serviceId
	 * @param status -1获取全部状态警报
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public List<MAlarm> getAlarms(Long userIds, String userName, Integer serviceId, Short status, Date start, Date end, int page, int num) {
		
		//日期和用户查询条件
		Criteria criteria = Criteria.where("userId").is(userIds);//.orOperator(Criteria.where("responseTime").gte(start).lte(end)).and("userId").is(userId);
		
		if(start!=null&&end!=null){
			criteria.and("alarmTime").gte(start).lte(end);
		}
		
		//用户名称
		if(!StringUtils.isEmpty(userName)) {
			criteria.and("userName").is(userName);
		}
		
		//服务Id
		if(serviceId != null && serviceId != -1) {
			criteria.and("serviceId").is(serviceId);
		}
		
		//警报状态
		if(status != null && status != -1) {
			criteria.and("status").is(status);
		}
		
		//分页
		int skipNum = (page - 1) * num;
		Query query = Query.query(criteria).skip(skipNum).limit(num).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
		//查询
		return super.find(query, MAlarm.class, COLLECTION_NAME);
	}
	/**
	 * @author DX 2016/5/27
	 * @param venderId
	 * @param serviceId
	 * @param status
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public List<MAlarm> getAlarms(List<Integer> venderIds,Integer serviceId, Short status, Date start, Date end, int page, int num){
		Criteria criteria=Criteria.where("venderId").in(venderIds);
		if(start!=null&&end!=null){
			criteria.and("alarmTime").gte(start).lte(end);
		}
		if(status!=null&&status!=-1){
			criteria.and("status").is(status);
		}
		if(serviceId!=null&&serviceId!=-1){
			criteria.and("serviceId").is(serviceId);
		}
		//分页
		int skipNum = (page - 1) * num;
		Query query=Query.query(criteria).skip(skipNum).limit(num).with(new Sort(new Sort.Order(Direction.DESC,"alarmTime")));
		return super.find(query, MAlarm.class, COLLECTION_NAME);
	}
	
	/**
	 * @author DX  无分页
	 * @param venderIds
	 * @param serviceId
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 */
	public long getAlarmsCount(List<Integer> venderIds,Integer serviceId, Short status, Date start, Date end){
		Criteria criteria=Criteria.where("venderId").in(venderIds);
		if(start!=null&&end!=null){
			criteria.and("alarmTime").gte(start).lte(end);
		}
		if(status!=null&&status!=-1){
			criteria.and("status").is(status);
		}
		if(serviceId!=null&&serviceId!=-1){
			criteria.and("serviceId").is(serviceId);
		}
		//分页
		
		Query query=Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC,"alarmTime")));
		return super.queryCount(query, COLLECTION_NAME);
	}
	/**
	 * 保存对象
	 * @param alarm
	 */
	public void save(MAlarm alarm) {
		super.save(alarm);
		
	}
	
	/**
	 * 更新对象
	 * @param alarm
	 */
	public void update(MAlarm alarm) {
		
		//condition
		Criteria criteria = Criteria.where("id").is(alarm.getId());
		Query query = Query.query(criteria);
		
		Update update = new Update();
		update.set("status", alarm.getStatus());
		update.set("responseTime", alarm.getResponseTime());
		update.set("createdBy", alarm.getCreatedBy());
		update.set("suggestion", alarm.getSuggestion());
		
		super.update(MAlarm.class, COLLECTION_NAME, query, update);
	}
}
