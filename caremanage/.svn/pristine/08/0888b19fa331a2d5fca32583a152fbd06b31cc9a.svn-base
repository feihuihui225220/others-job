/**
 * 
 */
package com.anticw.aged.service.professional;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MPlan;
import com.anticw.aged.dao.professional.vender.MPlanDao;

/**
 * 
 * @author li
 *
 */
@Service
public class MPlanService {
	@Autowired
	private MPlanDao mPlanDao; 
	/**
	 * 服务计划添加
	 * @param mPlan
	 */
	public void saveOrUpdate(MPlan mPlan){
		mPlanDao.saveOrUpdate(mPlan);
	}
	/**
	 * 查询用户服务计划
	 * @param serviceTime
	 * @param uid
	 * @return
	 */
	public List<MPlan> getUserPlan(Date serviceTime ,Long uid,Long orderId){
		return mPlanDao.getUserPlan(serviceTime, uid,orderId);
	} 
	/**
	 * 根据用户Id获取专业服务
	 * @param uid
	 * @return
	 */
	public List<MPlan> getUserPlan(Long uid){
		return mPlanDao.getUserPlan(uid);
	}
	/**
	 * 根据时间获取用户专业服务计划
	 * @param uid
	 * @return
	 */
	public List<MPlan> getUserPlanByDate(Long uid,String date){
		return mPlanDao.getUserPlanByDate(uid,date);
	}
	/**
	 * 打印报告时用
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	public List<MPlan> getByDate(long id,String start,String end){
		return mPlanDao.getByDate(id,start,end);
	}
}
