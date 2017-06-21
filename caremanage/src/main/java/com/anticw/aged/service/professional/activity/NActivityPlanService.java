package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.dao.professional.activity.NActivityPlanDao;
import com.anticw.aged.vo.common.DateParamVO;
 
@Service
public class NActivityPlanService {
	@Autowired
	private NActivityPlanDao  nActivityPlanDao;
	
	public  NActivityPlan  findrByVolunteerId(String  volunteerId) {
		return  nActivityPlanDao.findByVolunteerId(volunteerId);
	}
	/**
	 * 查询活动是否存在
	 * @param data
	 * @param siteId
	 * @return
	 */
	public NActivityPlan  getNActivityPlan(String data,Integer siteId){
		return nActivityPlanDao.getNActivityPlan(data,siteId);
	}
	
	/**
	 * 查询当前站点的下一次活动
	 * @param id
	 * @param siteId
	 * @return
	 */
	public NActivityPlan  getNext(int id,Integer siteId){
		return nActivityPlanDao.getNext(id, siteId);
	}
	/**
	 * 查询一次活动
	 * @param id
	 * @return
	 */
	public NActivityPlan  get(int id){
		return nActivityPlanDao.get(id);
	}
	
	public List<NActivityPlan>  getNActivityPlan(DateParamVO date,Integer volunteerId){
		 return nActivityPlanDao.getNActivityPlan(date, volunteerId);
	}
	
}
