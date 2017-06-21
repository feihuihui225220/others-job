package com.anticw.aged.controller.professional;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MAssessGds;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.GdsUtil;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.MAssessGdsService;
/**
 * 
 * @author DX
 * 对GDS系统进行操作
 *
 */
@Controller
public class MAssessGdsCtl {

	@Autowired
	private  MAssessGdsService mAssessGdsService;
	
	@Autowired
	private RUserService userService;
	/**
	 * 添加GDS所需要参数
	 * @param r
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/assessgds")
	public ModelAndView gethtml(Long userId) throws Exception{
		ModelAndView mv=new ModelAndView("professional/vender/assessgds");
		mv.addObject("userId", userId);
		return mv;
	}
	/**
	 * 将页面获取参数传入GDS系统得到结论加入数据库返回页面展示
	 * @param r
	 * @param gds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/assessgds/gds")
	public ModelAndView gethtml(Long userId,MAssessGds gds) throws Exception{
		ModelAndView mv=new ModelAndView("professional/vender/gds");
		//mAssessGdsService
		RUser  r=userService.findById(userId);
		Map<String, String> html=GdsUtil.getHtml(r, gds);
		gds.setAssessHtml(html.get("gdsText"));
		gds.setBrief(html.get("brief"));
		mAssessGdsService.save(gds);
		mv.addObject("gds", html.get("gdsText"));
		return mv;
	}
}
