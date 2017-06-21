package com.anticw.aged.service.professional.activity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NTrainStaff;
import com.anticw.aged.bean.NVolunteerTrain;
import com.anticw.aged.dao.professional.activity.NTrainStaffDao;
import com.anticw.aged.dao.professional.activity.NVolunteerTrainDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.activity.NVolunteerTrainVO;

@Service
public class NVolunteerTrainService {
	@Autowired
	private NVolunteerTrainDao nVolunteerTrainDao;
	
	@Autowired
	private NTrainStaffDao nTrainStaffDao;
	
	public void addnTrainStaff(NTrainStaff s){
		nTrainStaffDao.save(s);
		//nTrainStaffDao.getSessionFactory().openSession().flush();
	}
	
	public List<NTrainStaff> getTrainStaff(int trainId){
		return nTrainStaffDao.getNTrainStaff(trainId);
	}
	
	public void deletenTrainStaff(List<NTrainStaff> n){
		for(NTrainStaff ns:n){
			nTrainStaffDao.remove(ns);
		}
	}
	public Integer addNVolunteerTrain(NVolunteerTrain nVolunteerTrain){
		return nVolunteerTrainDao.addNVolunteerTrain(nVolunteerTrain);
	}
	//查询所有的培训记录分页排序
	public Page<NVolunteerTrain> getList(int pageIndex,int pagesize,String createdBy,Integer communityId,Integer site){
		return nVolunteerTrainDao.getList(pageIndex, pagesize, createdBy,communityId,site);
	}
	//员工查看
	public Page<NVolunteerTrainVO> getList(int pageIndex,int pagesize,String createdBy,Integer communityId,String siteIds,Integer site){
		return  nVolunteerTrainDao.getList(pageIndex, pagesize, createdBy, communityId, siteIds, site);
	}
	//修改培训记录
	public void updateNVolunteerTrain(NVolunteerTrain nVolunteerTrain){
		nVolunteerTrainDao.updateNVolunteerTrain(nVolunteerTrain);
	}
	//删除培训记录
	public void deleteNVolunteerTrain(int id){
		nVolunteerTrainDao.deleteNVolunteerTrain(id);
	}
	//根据Id查询单个培训记录
	public NVolunteerTrain getNVolunteerTrain(int id){
		return nVolunteerTrainDao.getNVolunteerTrain(id);
	}
	public List<NVolunteerTrain> getListNVolunteerTrains(String ids,Date start,Date end){
		return nVolunteerTrainDao.getListNVolunteerTrains(ids, start, end);
	}
}
