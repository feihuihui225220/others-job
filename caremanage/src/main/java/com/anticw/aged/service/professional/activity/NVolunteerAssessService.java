package com.anticw.aged.service.professional.activity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NVolunteerAssess;
import com.anticw.aged.dao.professional.activity.NVolunteerAssessDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 
 * @author marenba 2017/02/13
 *
 */
@Service
public class NVolunteerAssessService {

	@Autowired
	private NVolunteerAssessDao nVolunteerAssessDao;

	/**
	 * 添加志愿者量表
	 * 
	 * @param nVolunteerAssess
	 */
	public void addNVolunteerAssess(NVolunteerAssess nVolunteerAssess) {
		nVolunteerAssess.setAvailable(true);
		nVolunteerAssess.setCreateTime(new Date());
		nVolunteerAssessDao.save(nVolunteerAssess);
	}
	/**
	 * 修改志愿者量表
	 * 
	 * @param nVolunteerAssess
	 */
	public void updateNVolunteerAssess(NVolunteerAssess nVolunteerAssess) {
		nVolunteerAssessDao.updateNVolunteerAssess(nVolunteerAssess);
	}

	/**
	 * 根据Id获取量表信息
	 * 
	 * @param id
	 * @return
	 */
	public NVolunteerAssess getById(long id) {
		return nVolunteerAssessDao.get(id);
	}
	/**
	 * 分页查询量表信息
	 * @param planName
	 * @param date
	 * @param siteId
	 * @return
	 */
	public Page<Object[]> getPage(String planName, String date, Integer siteId,
			int pageNo, int pageSize) {
		return nVolunteerAssessDao.getPage(planName, date, siteId, pageNo,
				pageSize);
	}

	public int getCound(int planId) {
		return nVolunteerAssessDao.getNVolunteerAssess(planId);
	}

	public int getNVolunteerAssessId(Integer planId) {
		return nVolunteerAssessDao.getNVolunteerAssessId(planId);
	}

}
