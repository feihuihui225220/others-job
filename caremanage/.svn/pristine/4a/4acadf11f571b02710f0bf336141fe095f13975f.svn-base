package com.anticw.aged.service.huiZheng;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.dao.huiZheng.HConsultationDao;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.HConsultationVO;

@Service
public class HConsultationService {

	@Autowired
	private HConsultationDao hConsultationDao;
	
	@Autowired
	private UserDao userDao;
	
	public void insertTreat(HConsultation hConsultation)throws IllegalAccessException, InvocationTargetException {
		hConsultationDao.insertTreat(hConsultation);	
	}

	public List<HConsultation> listResult(Long userId) {
		return hConsultationDao.listResult(userId);
	}
	
	public void delete(Integer resultId) {
		hConsultationDao.delete(resultId);
		
	}

	public void edit(HConsultation hConsultation) {
		hConsultationDao.edit(hConsultation);
	}

	public HConsultation findById(Integer resultId) {		
		return hConsultationDao.findById(resultId);
	}
	
	public void update(HConsultation hConsultation){
		hConsultationDao.update(hConsultation);
	}
	/**
	 * 巡诊组查看会诊信息
	 * @param date
	 * @param groupId
	 * @return
	 */
	public List<HConsultation> getHConsultationByDateAndGroupId(Date date,long groupId){
		return hConsultationDao.getHConsultationByDateAndGroupId(date, groupId);
	}
	/**
	 * 会诊管理展示会诊信息
	 * @param dateCond
	 * @param groupId
	 * @param statas
	 * @param desc
	 * @param page
	 * @return
	 */
	public Page<HConsultation> pageHConsultation(DateParamVO dateCond,long groupId,Integer statas,Integer desc,PageParamVO page){
		return hConsultationDao.pageHConsultation(dateCond, groupId, statas, desc, page);
	}
	/**
	 * 根据Id获取会诊信息
	 * @param id
	 * @return
	 */
	public HConsultation getHConsultation(Integer id) {
		return hConsultationDao.findOneAvailData(id);
	}
	/**
	 * 查询用户会诊历史记录
	 * @param userId
	 * @param page
	 * @param dateCond
	 * @param desc
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Page<HConsultationVO> listResult(Long userId,PageParamVO page,DateParamVO dateCond,Integer desc) throws IllegalAccessException, InvocationTargetException{
		Page<HConsultation> pages= hConsultationDao.listResult(userId, page, dateCond, desc);
		List<HConsultation> hc=pages.getResult();
		List<HConsultationVO> vos =new ArrayList<HConsultationVO>();
		for(HConsultation h:hc){
			AUser  user=userDao.get(h.getGroupId());
			HConsultationVO hcv=new HConsultationVO();
			BeanUtils.copyProperties(hcv, h);
			if(h.getApplyTime()!=null){
				hcv.setApplyTime_(h.getApplyTime());
			}
			hcv.setGroupName(user.getName());
			vos.add(hcv);
		}
		Page<HConsultationVO> pagevo=new Page<HConsultationVO>();
		pagevo.setResult(vos);
		pagevo.setPageNo(pages.getPageNo());
		pagevo.setPageSize(pages.getPageSize());
		return pagevo;
	}
	/**
	 * 修改用户信息
	 */
	public void modifyHConsultation(HConsultation consultation){
		
		hConsultationDao.modifyHConsultation(consultation);
	}
    
	/**
	 * 会诊统计
	 */
	public List<HConsultation> countConsultation() {
		return hConsultationDao.countConsultation();
	}

	public Long sumConsul() {
		return hConsultationDao.sumConsul();
	}
}