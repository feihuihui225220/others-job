package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NVolunteerTrainRecord;
import com.anticw.aged.dao.professional.activity.NVolunteerTrainRecordDao;
/**
 * 
 * @author dx 2015/10/15
 *
 */
@Service
public class NVolunteerTrainRecordService {
	@Autowired
	private NVolunteerTrainRecordDao nVolunteerTrainRecordDao;
	/**
	 * 添加签到志愿者
	 * @param nv
	 */
	public void addNVolunteerTrainRecord(NVolunteerTrainRecord nv){
		nVolunteerTrainRecordDao.addNVolunteerTrainRecord(nv);
	}
	/**
	 * 查询当前培训项目下的志愿者签到情况
	 * @param trainId
	 * @return
	 */
	public List<NVolunteerTrainRecord> getList(int trainId){
		return nVolunteerTrainRecordDao.getList(trainId);
	}
	public List<String> getListgetListvolunteer(int volunteerId){
		return nVolunteerTrainRecordDao.getListgetListvolunteer(volunteerId);
	}
	
	/**
	 * 根据ID删除志愿者签到信息
	 * @param id
	 */
	public void deleteNVolunteerTrainRecord(int id){
		nVolunteerTrainRecordDao.deleteNVolunteerTrainRecord(id);
	}
	public NVolunteerTrainRecord getNVolunteerTrainRecor(int volunteerId,int trainId){
		return nVolunteerTrainRecordDao.getNVolunteerTrainRecor(volunteerId, trainId);
		
	}
	public void delete(NVolunteerTrainRecord n){
		nVolunteerTrainRecordDao.delete(n);
	}
}
