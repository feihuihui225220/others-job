package com.anticw.aged.service.director;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HTreatUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.director.HTreatUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

@Service
public class HTreatUserServer {
	@Autowired
	private HTreatUserDao hTreatUserDao; 
	/**
	 * 查询一个用户的所有记录
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<HTreatUser> getPage(PageParamVO page,Long userId,DateParamVO dateCond){
		return hTreatUserDao.getPage(page, userId,dateCond);
	}
	
	public void save(HTreatUser h,HttpSession session){
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		h.setGroupId((int)userVO.getId());
		h.setCreateAt(new Date());
		h.setCreateBy(userVO.getName());
		hTreatUserDao.save(h);
	}
	
	public void update(HTreatUser h){
		HTreatUser ht=hTreatUserDao.get(h.getId());
		ht.setConclusion(h.getConclusion());
		hTreatUserDao.update(ht);
	}
}
