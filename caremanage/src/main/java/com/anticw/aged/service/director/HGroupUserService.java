package com.anticw.aged.service.director;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.HGroupUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.director.HGroupUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 巡诊组患者管理
 * @author DX 2016-09-18
 *
 */
@Service
public class HGroupUserService {

	@Autowired
	private HGroupUserDao hGroupUserDao;
	
	@Autowired
	private RUserService rUserService;
	
	@Autowired
	private GroupService groupService;
	/**
	 * 添加
	 * @param session
	 * @param hGroupUser
	 */
	public void save(HttpSession session,Long userId){
		HGroupUser hGroupUser=new HGroupUser();
		UserVO user=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		
		hGroupUser.setCreateBy(user.getName());
		hGroupUser.setChangeBy(user.getName());
		hGroupUser.setUser(rUserService.findById(userId));
		Date date= new Date();
		hGroupUser.setChangeTime(date);
		hGroupUser.setChangeBy(user.getName());
		hGroupUser.setCreateTime(date);
		hGroupUser.setCreateBy(user.getName()); 
		hGroupUser.setAvailable(true);
		
		//根据id获取巡诊组医生和护士，添加到h_group_user中
		HGroup group=groupService.findByUserId((int)user.getId()).get(0);
		hGroupUser.setGroupDoctor(group.getDoctor());
		hGroupUser.setGroupNurse(group.getNurse());
		hGroupUser.setGroupId(Long.valueOf(group.getUserId()));
		hGroupUserDao.save(hGroupUser);
	}
	
	public void save(HttpSession session,HGroupUser hUser,Long userId){
		HGroupUser hGroupUser=new HGroupUser();
		UserVO user=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		
		hGroupUser.setCreateBy(user.getName());
		hGroupUser.setChangeBy(user.getName());
		hGroupUser.setUser(rUserService.findById(userId));
		Date date= new Date();
		hGroupUser.setChangeTime(date);
		hGroupUser.setChangeBy(user.getName());
		hGroupUser.setCreateTime(date);
		hGroupUser.setCreateBy(user.getName()); 
		hGroupUser.setAvailable(true);
		hGroupUser.setGroupId(hUser.getGroupId());
		//根据id获取巡诊组医生和护士，添加到h_group_user中
		HGroup group=groupService.findByUserId(hUser.getGroupId().intValue()).get(0);
		hGroupUser.setGroupDoctor(group.getDoctor());
		hGroupUser.setGroupNurse(group.getNurse());
		hGroupUserDao.save(hGroupUser);
	}
	/**
	 * 修改
	 * @param session
	 * @param hGroupUser
	 * @param userId
	 */
	public  void update(HttpSession session,HGroupUser hGroupUser,Long userId){
		HGroupUser h=hGroupUserDao.get(hGroupUser.getId());
		UserVO user=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		h.setUser(rUserService.findById(userId));
		if(hGroupUser.getDoctor()!=null){
			h.setDoctor(hGroupUser.getDoctor());
		}
		if(hGroupUser.getGroupDoctor()!=null){
			h.setGroupDoctor(hGroupUser.getGroupDoctor());
		}
		if(hGroupUser.getGroupId()!=null){
			h.setGroupId(hGroupUser.getGroupId());
		}
		if(hGroupUser.getGroupNurse()!=null){
			h.setGroupNurse(hGroupUser.getGroupNurse());
		}
		h.setAvailable(true);
		Date date= new Date();
		h.setChangeTime(date);
		h.setChangeBy(user.getName());
		hGroupUserDao.update(hGroupUser);
	}
	
	public void delete(Integer id){
		hGroupUserDao.removeById(id);
	}
	
	/**
	 * 分页查看
	 * @param page
	 * @param groupId
	 * @return
	 */
	public Page<HGroupUser>  getUser(PageParamVO page,Integer groupId,
			Integer states,Integer age,String idCardNo,String communityId,Date changedAt,Integer choose,String name,Date createdDate){
		if(createdDate==null){
			createdDate=new Date();
		}
		DateParamVO dateCond=DateUtil.getDate(createdDate);
		return hGroupUserDao.getUser(page, groupId, states, age, idCardNo, communityId, changedAt, choose, name,dateCond);
	}
	/**
	 * 员工 分页查看
	 * @param page
	 * @param groupId
	 * @return
	 */
	public Page<HGroupUser>  getUserlist(PageParamVO page,Long careteName,Integer status,String start,String end,String userName){	
		return hGroupUserDao.getUserlist(page,careteName,status,start,end,userName);
	}
}
