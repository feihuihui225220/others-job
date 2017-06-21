package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZWxUser;
import com.anticw.aged.dao.icare.vip.WXUserDao;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：TODO	
 */
@Service
public class WXUserService {

	@Autowired
	private WXUserDao wxUserDao;
	
	/**
	 * 查询一条微信用户TODO
	 *@param id
	 *@return
	 */
	public ZWxUser getUserById(int id){
		return wxUserDao.get(id);
	}
	/**
	 * 添加微信用户
	 *@param ZWxUser
	 *@return
	 */
	public Integer addUser(ZWxUser ZWxUser){
		ZWxUser.setCreateTime(new Date());
		ZWxUser.setAvailable(true);
		return (Integer) wxUserDao.save(ZWxUser);
	}
	/**
	 * 删除微信用户
	 *@param ZWxUser
	 *@return
	 */
	public void removeUser(Integer id){
		wxUserDao.removeById(id);
	}
	/**
	 * 修改微信用户TODO
	 *@param ZWxUser
	 */
	public void modifyUser(ZWxUser ZWxUser){
		wxUserDao.update(ZWxUser);
	}
	
	
}
