package com.anticw.aged.service.professional.activity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.dao.professional.activity.NVolunteerServiceRecordDao;
@Service
public class NVolunteerServiceRecordService {
	@Autowired
	private NVolunteerServiceRecordDao nVolunteerServiceRecordDao;
	public NVolunteerServiceRecord nVolunteerServiceRecord(int volunteerId,Date createdAt){
		return nVolunteerServiceRecordDao.nVolunteerServiceRecord(volunteerId, createdAt);
	}
	public void update(NVolunteerServiceRecord nVolunteerServiceRecord){
		nVolunteerServiceRecordDao.update(nVolunteerServiceRecord);
	}
	public List<Integer> getList(int activityId){
		return nVolunteerServiceRecordDao.getListNVolunteerServiceRecords(activityId);
	}
	public List<Integer> getListNVolunteerService(int activityId){
		return nVolunteerServiceRecordDao.getListNVolunteerService(activityId);
	}
	
}
