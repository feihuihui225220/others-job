package com.anticw.aged.service.icare.active;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZActive;
import com.anticw.aged.dao.icare.active.activeDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Service
public class activeService {
	
	@Autowired
	private activeDao activeDao;
	
	public Page<ZActive> listAllAcitve(String activeName,Integer state,String startTime,String endTime,PageParamVO vo,Integer rId){
		if(("").equals(startTime)){
			startTime=null;
		}
		if(("").equals(endTime)){
			endTime=null;
		}
		return activeDao.listAllAcitve(activeName,state,startTime, endTime, vo,rId);
	}
	/**
	 * 根据ID查询NActivityPlan
	 * @param id
	 * @return
	 */
	public ZActive findActiveById(Long id){
		return activeDao.findActiveById(id);
	}
	/**
	 * 添加
	 * @param active
	 */
	
	public void saveActive(ZActive active){
		activeDao.saveActive(active);
	}
	/**
	 * 修改
	 * @param active
	 */
	public void updateActive(ZActive active){
		activeDao.updateActive(active);
	}
	public void deleteActive(Long id){
		activeDao.deleteActive(id);
	}
	
	public List<ZActive> list(){
		return activeDao.list();
	}
	/**
	 * 
	 */
	public List<ZActive> listZActiveByIdAndDay(Long rId,Date date){
		return activeDao.listZActiveByIdAndDay(rId,date);
	}
	public List<ZActive> listWX(Long rId){
		return activeDao.listWX(rId);
	}
}
