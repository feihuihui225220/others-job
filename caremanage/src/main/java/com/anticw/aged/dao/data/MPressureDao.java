package com.anticw.aged.dao.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.mongo.Pressure;
import com.anticw.aged.dao.utils.MongoBaseDao;
import com.anticw.aged.vo.professional.service.DeviceBindVO;
import com.anticw.aged.vo.professional.service.MPressureVO;

/**
 * 
 * @author DX
 *
 */
@Repository
@Component
public class MPressureDao extends MongoBaseDao{

	private static final String COLLECTION_NAME = "m_pressure";
	
	
	public List<MPressureVO> getAlarms( List<DeviceBindVO> deviceIds,Date start,Date end) {
		List<MPressureVO>  vos=new ArrayList<MPressureVO>();
		for(DeviceBindVO deviceId:deviceIds ){
			MPressureVO vo=new MPressureVO();
			Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceId.getDeviceBindId()).and("highPressure").ne("").ne(null).and("lowPressure").ne("").ne(null);
			Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
			List<Pressure> mpe= super.find(query, Pressure.class, COLLECTION_NAME);
			if(mpe.size()>=2){
				vo.setUserId(deviceId.getUserId());
				vo.setDeviceId(deviceId.getDeviceBindId());
				vo.setHighPressuree(mpe.get(mpe.size()-1).getHighPressure());
				vo.setLowPressuree(mpe.get(mpe.size()-1).getLowPressure());
				vo.setHighPressures(mpe.get(0).getHighPressure());
				vo.setLowPressures(mpe.get(0).getLowPressure());
				vos.add(vo);
			}
		}
		
		return vos;
	}
	public Map<Long,List<Pressure>> getAlarmss( List<DeviceBindVO> deviceIds,Date start,Date end) {
		Map<Long,List<Pressure>> map=new HashMap<Long, List<Pressure>>();
		for(DeviceBindVO deviceId:deviceIds ){
			Criteria criteria = Criteria.where("uploadTime").gte(start).lte(end).and("deviceId").is(deviceId.getDeviceBindId());
			Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
			List<Pressure> mpe= super.find(query, Pressure.class, COLLECTION_NAME);
			map.put(deviceId.getUserId(),mpe);
		}
		return map;
	}
	
	/**
	 * 倒叙排列返回最新一条信息
	 * @param deviceId
	 * @return
	 */
	public Pressure getPressure(String deviceId){
		Criteria criteria = Criteria.where("deviceId").is(deviceId);
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
		List<Pressure> pressure= super.find(query, Pressure.class, COLLECTION_NAME);
		if(pressure.size()!=0){
			return pressure.get(0);
		}
		return null;
	}
}
