package com.anticw.aged.controller.icare.vip;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZWxUser;
import com.anticw.aged.service.icare.vip.WXUserService;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：TODO	
 */
@Controller
@RequestMapping("/icare/user/")
public class WXUserCtl {

	@Autowired
	private WXUserService wxUserService;
	
	/**
	 * 查询一条微信用户TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("/get/{id}")
	public ZWxUser getUserById(@PathParam("id")int id,HttpServletRequest request,HttpServletResponse response){
		return wxUserService.getUserById(id);
	}
	/**
	 * 添加微信用户
	 *@param wxUser
	 *@return
	 */
	@RequestMapping("add")
	public Integer addUser(ZWxUser wxUser,HttpServletRequest request,HttpServletResponse response){
		wxUser.setCreateTime(new Date());
		wxUser.setAvailable(true);
		return (Integer) wxUserService.addUser(wxUser);
	}
	/**
	 * 删除微信用户
	 *@param ZWxUser
	 *@return
	 */
	@RequestMapping("remove/{id}")
	public void removeUser(@PathParam("id")Integer id,HttpServletRequest request,HttpServletResponse response){
		wxUserService.removeUser(id);
	}
	/**
	 * 修改微信用户TODO
	 *@param ZWxUser
	 */
	@RequestMapping("modify")
	public void modifyUser(ZWxUser wxUser,HttpServletRequest request,HttpServletResponse response){
		wxUserService.modifyUser(wxUser);
	}
	
}
