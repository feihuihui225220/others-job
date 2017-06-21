package com.anticw.aged.dao.professional.activity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NVolunteerTrainRecord;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @author dx 2015/10/15
 *
 */
@Component
public class NVolunteerTrainRecordDao extends HibernateEntityDao<NVolunteerTrainRecord>{
	//添加培训记录
	public void addNVolunteerTrainRecord(NVolunteerTrainRecord nv){
		super.save(nv);
	}
	//根据培训记录id查询当前培训签到人员情况
	public List<NVolunteerTrainRecord> getList(int trainId){
		String hql="from NVolunteerTrainRecord n where n.trainId=? and n.avaliable=true order by n.createdAt desc";
		return super.find(hql, trainId);
	}
	public List<String> getListgetListvolunteer(int volunteerId){
		String hql="select n.trainId from NVolunteerTrainRecord n where n.volunteerId=? and n.avaliable=true order by n.createdAt desc";
		return super.find(hql, volunteerId);
	}
	//删除签到
	public void delete(NVolunteerTrainRecord n){
		super.remove(n);
	}
	//删除一个培训签到者
	public void deleteNVolunteerTrainRecord(int id){
		super.removeById(id);
	}
	//查询一个
	public NVolunteerTrainRecord getNVolunteerTrainRecor(int volunteerId,int trainId){
		String hql="from NVolunteerTrainRecord n where n.volunteerId=? and n.trainId=? and n.avaliable=true";
		List<NVolunteerTrainRecord> li=super.find(hql, volunteerId,trainId);
		return li.get(0); 
	}
	//获取当前志愿者月所有的签到情况
	public List<NVolunteerTrainRecord> getListVolunteer(String createdBy,Date start,Date end,int volunteerId){
		String hql="from NVolunteerTrainRecord n where n.createdBy=? and n.volunteerId=? and createdAt between ? and ?";
		return super.find(hql,createdBy,volunteerId,start,end);
		
	}
	
}
