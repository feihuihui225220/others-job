package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZUserBind;
import com.anticw.aged.dao.icare.vip.WXUserBindDao;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：TODO	
 */
@Service
public class WXUserBindService {

	@Autowired
	private WXUserBindDao wxUserBindDao;
	
	/**
	 * 查询用户是否绑定
	 *@param id
	 *@return
	 */
	public ZUserBind getUserBindById(int id){
		return wxUserBindDao.get(id);
	}
	/**
	 * 绑定用户
	 *@param ZUserBind
	 *@return
	 */
	public Integer addUserBind(ZUserBind ZUserBind){
		ZUserBind.setCreateTime(new Date());
		ZUserBind.setAvailable(true);
		return (Integer) wxUserBindDao.save(ZUserBind);
	}
	/**
	 * 解除绑定
	 *@param ZUserBind
	 *@return
	 */
	public void removeUserBind(Integer id){
		wxUserBindDao.removeById(id);
	}
	/**
	 * 修改微信用户绑定信息
	 *@param ZUserBind
	 */
	public void modifyUserBind(ZUserBind ZUserBind){
		wxUserBindDao.update(ZUserBind);
	}
}
