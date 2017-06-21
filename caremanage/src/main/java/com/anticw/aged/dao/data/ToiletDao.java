package com.anticw.aged.dao.data;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.mongo.Toilet;
import com.anticw.aged.dao.utils.MongoBaseDao;

@Repository
public class ToiletDao extends MongoBaseDao {

	private static final String COLLECTION_NAME = "m_toilet";

	public List<Toilet> getAlarmss(String deviceId) {

		Criteria criteria = Criteria.where("status").is("out").and("deviceId").is(deviceId);
		Query query = Query.query(criteria).with(new Sort(new Sort.Order(Direction.DESC, "alarmTime")));
		return super.find(query, Toilet.class, COLLECTION_NAME);

	}
}
