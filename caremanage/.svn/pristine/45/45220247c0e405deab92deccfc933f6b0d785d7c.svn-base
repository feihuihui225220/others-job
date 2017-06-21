package com.anticw.aged.controller.weixin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.ZFeedback;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.icare.ZFeedBackService;
import com.anticw.aged.vo.user.RUserVO;
import com.anticw.aged.vo.user.RegisterVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：给微信提供接口
 */
@RequestMapping("/weixin/")
@Controller
public class WeiXinCtl {
	
	@Autowired
	private RUserService userService;
	@Autowired
	private ZFeedBackService zFeedbackService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAddPage")
	public String  toAddPage(){
		return "";
	}
 
	/**
	 * 添加反馈
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("add")
	public String addFeedback(ZFeedback zFeedback){
		zFeedbackService.addFeedback(zFeedback);
		return "";
	}
 
	/**
	 * 验证某个手机号是否注册过，注册过返回1，否则返回0 
	 *@param phone
	 *@return
	 */
	@RequestMapping("checkPhone")
	@ResponseBody
	public RUserVO checkPhone(String phone,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		RUser user = null;
		RUserVO uservo = new RUserVO();
		try {
			user = userService.findBymobilePhone(phone);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			uservo.setId(user.getId());
			uservo.setMobilePhone(user.getMobilePhone());
			uservo.setName(user.getName());
		}
		return uservo;
	}
	
	@RequestMapping("addUser")
	@ResponseBody 
	public  boolean addUser(RegisterVO regVO,HttpServletResponse response) throws Exception{
		userService.register(regVO);
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		return true;
	}
}
