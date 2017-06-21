package com.anticw.aged.controller.icare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.ZNotice;
import com.anticw.aged.service.icare.ZNoticeService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
public class ZNoticeCtl {
	@Autowired
	private ZNoticeService zNoticeService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/notice/toAddPage")
	public String  toAddPage(int id,HttpServletRequest request){
		ZNotice z= zNoticeService.getById(id);
		request.setAttribute("list",z);
		return "ICare/notice/add";
	}
	/**
	 * 添加
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("/icare/notice/add")
	public String add(ZNotice zNotice){
		zNotice.setAvailable(true);
		zNotice.setType(2);
		Date date= new Date();
		zNotice.setCreateTime(date);
		zNoticeService.add(zNotice);
		return "redirect:/icare/notice/getList";
	}
	
	/**
	 * 删除
	 *
	 */
	@RequestMapping("/icare/notice/remove/")
	public String  delete(Integer id){
		zNoticeService.delete(id);
		return "";
	}
	/**
	 * 修改
	 */
	@RequestMapping("/icare/notice/modify")
	public String modify(ZNotice zNotice){
		zNoticeService.modify(zNotice);
		return "";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/notice/get")
	public String  getById(Integer id,HttpServletRequest request){
		request.setAttribute("detail", zNoticeService.getById(id));
		return "ICare/notice/detail";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("/icare/notice/getList")
	public String getList(PageParamVO page,HttpServletRequest request
			,String userContact,Integer type,String startTime,String endTime) {
		request.setAttribute("page", zNoticeService.getList(page, userContact,type,startTime,endTime));
		request.setAttribute("userContact", userContact);
		request.setAttribute("type", type);
		request.setAttribute("startTime", startTime);
		request.setAttribute("startTime", startTime);
		return "ICare/notice/list";
	}
	
	/**
	 * @author dx
	 * 智能腕表警报获取
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/icare/notice/addSmartWatch")
	public @ResponseBody String addSmartWatch(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("警报信息=====---------");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 将资料解码
		String smartWatch = sb.toString();
		System.out.println("警报信息=====---------"+smartWatch);
		smartWatch = URLDecoder.decode(smartWatch, "UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		JSONObject json=JSONObject.parseObject(smartWatch);
		String content=json.getString("content");
		String userContact=json.getString("userContact");
		ZNotice zNotice=new ZNotice();
		zNotice.setAvailable(true);
		zNotice.setIsvalidity(false);
		zNotice.setType(2);
		zNotice.setUserContact(userContact);
		zNotice.setContent(content);
		zNotice.setCreateTime(new Date());
		zNoticeService.add(zNotice);
		return "success";
	}
	
}
