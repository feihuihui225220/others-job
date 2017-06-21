package com.anticw.aged.controller.icare.vip;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZUserBind;
import com.anticw.aged.service.icare.vip.WXUserBindService;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：用户绑定微信
 */
@Controller
@RequestMapping("/icare/userbind/")
public class WXUserBindCtl {

	@Autowired
	private WXUserBindService wxUserBindService;
	
	/**
	 * 查询用户是否绑定
	 *@param id
	 *@return
	 */
	@RequestMapping("/get/{id}")
	public ZUserBind getUserBindById(@PathParam("id")int id,HttpServletRequest request,HttpServletResponse response){
		return wxUserBindService.getUserBindById(id);
	}
	/**
	 * 绑定用户
	 *@param ZUserBind
	 *@return
	 */
	@RequestMapping("add")
	public Integer addUserBind(ZUserBind ZUserBind,HttpServletRequest request,HttpServletResponse response){
		ZUserBind.setCreateTime(new Date());
		ZUserBind.setAvailable(true);
		return (Integer) wxUserBindService.addUserBind(ZUserBind);
	}
	/**
	 * 解除绑定
	 *@param ZUserBind
	 *@return
	 */
	@RequestMapping("remove/{id}")
	public void removeUserBind(@PathParam("id")Integer id,HttpServletRequest request,HttpServletResponse response){
		wxUserBindService.removeUserBind(id);
	}
	/**
	 * 修改微信用户绑定信息
	 *@param ZUserBind
	 */
	@RequestMapping("modify")
	public void modifyUserBind(ZUserBind ZUserBind,HttpServletRequest request,HttpServletResponse response){
		wxUserBindService.modifyUserBind(ZUserBind);
	}
}
