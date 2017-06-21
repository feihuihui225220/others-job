package com.anticw.aged.dao.data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.anticw.aged.bean.mongo.IntelligentMattress;
import com.anticw.aged.dao.utils.MongoBaseDao;
@Component
public class IntelligentMattressDao extends MongoBaseDao {
 

 
	private static final String M_INTELLIGENT_MATTRESS = "m_Intelligent_mattress";
 
	//查询离床次数
	public List<IntelligentMattress> getIntelligentMattresswxs(String snId){
		Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date start=c.getTime();
		c.set(Calendar.HOUR_OF_DAY, -2);
		Date end=c.getTime();
		//查询条件
		Criteria criteria = Criteria.where("sn").is(snId);
		if(start!=null&&end!=null){
			criteria.and("uploadTime").gte(end).lte(start);
		}
		//query
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.ASC, "uploadTime")));
		//获取集合
		List<IntelligentMattress> list=find(query,IntelligentMattress.class, M_INTELLIGENT_MATTRESS);		
		return list;
	}
 
	public List<IntelligentMattress> getIntelligentMattress(String deviceId) {
		Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date end=c.getTime();
		c.set(Calendar.HOUR_OF_DAY, -6);
		Date start=c.getTime();
		//查询条件
		Criteria criteria = Criteria.where("deviceId").is(deviceId).
				            and("uploadTime").gte(start).lte(end);
		//query
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.ASC, "uploadTime")));
		//获取集合
		List<IntelligentMattress> lists = find(query, IntelligentMattress.class, M_INTELLIGENT_MATTRESS);
		return lists;
	}
	
	
	
	public List<IntelligentMattress> getIntelligentMattressdeviceId(String deviceId) {
		//查询条件
		Criteria criteria = Criteria.where("deviceId").is(deviceId);
				           
		//query
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.ASC, "uploadTime")));
		//获取集合
		List<IntelligentMattress> lists = find(query, IntelligentMattress.class, M_INTELLIGENT_MATTRESS);
		return lists;
	}
	 
}
