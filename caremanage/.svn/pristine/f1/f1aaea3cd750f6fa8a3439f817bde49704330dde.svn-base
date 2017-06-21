package com.anticw.aged.controller.icare.vip;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZAutoreply;
import com.anticw.aged.service.icare.vip.WXAutoreplyService;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：TODO	
 */
@Controller
@RequestMapping("/icare/autoreply/")
public class WXAutoreplyCtl {
	@Autowired
	private WXAutoreplyService wxAutoreplyService;
	
	/**
	 * 查询自动回复内容
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getAutoreplyById(@PathParam("id")int id,HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("autoreply", wxAutoreplyService.getAutoreplyById(id));
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		return "";
	}
	/**
	 * 添加自动回复内容
	 *@param autoreply
	 *@return
	 */
	@RequestMapping("add")
	public Integer addAutoreply(ZAutoreply autoreply,HttpServletRequest request){
		autoreply.setCreateTime(new Date());
		autoreply.setAvailable(true);
		return (Integer) wxAutoreplyService.addAutoreply(autoreply);
	}
	/**
	 * 删除自动回复的内容
	 *@param ZAutoreply
	 *@return
	 */
	@RequestMapping("remove/{id}")
	public void removeAutoreply(Integer id,HttpServletRequest request,HttpServletResponse response){
		wxAutoreplyService.removeAutoreply(id);
	}
	/**
	 * 修改自动回复内容
	 *@param ZAutoreply
	 */
	@RequestMapping("modify")
	public void modifyAutoreply(ZAutoreply autoreply,HttpServletRequest request,HttpServletResponse response){
		wxAutoreplyService.modifyAutoreply(autoreply);
	}
}
