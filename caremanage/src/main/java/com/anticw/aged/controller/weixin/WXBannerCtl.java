package com.anticw.aged.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.ZBanner;
import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.bean.ZNotice;
import com.anticw.aged.bean.ZVipIntroduce;
import com.anticw.aged.service.icare.ZBannerService;
import com.anticw.aged.service.icare.ZFeedBackService;
import com.anticw.aged.service.icare.ZManagerInfoService;
import com.anticw.aged.service.icare.ZNoticeService;
import com.anticw.aged.service.icare.ZVipIntroduceService;

@Controller
@RequestMapping("/wxbanner/")
public class WXBannerCtl {
	@Autowired
	private ZBannerService zBannerService;
	@Autowired
	private ZManagerInfoService zManagerInfoService;
	@Autowired
	private ZVipIntroduceService zVipIntroduceService;
	@Autowired
	private ZFeedBackService zFeedbackService;
	@Autowired
	private ZNoticeService zNoticeService;

	/**
	 * 首页banner展示
	 */
	@RequestMapping("bannerList")
	@ResponseBody
	public JSONObject getBannerList(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<ZBanner> banner = zBannerService.getBannerList();
		JSONObject json = new JSONObject();
		json.put("list", banner);
		return json;
	}

	/**
	 * 首页管家展示
	 */
	@RequestMapping("managerList")
	@ResponseBody
	public JSONObject getmangerList(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<ZManagerInfo> m = zManagerInfoService.getLists();
		JSONObject json = new JSONObject();
		json.put("list", m);
		return json;
	}

	// 管家详情
	@RequestMapping("managerDetail")
	@ResponseBody
	public JSONObject getById(Integer id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ZManagerInfo detail = zManagerInfoService.getById(id);
		JSONObject json = new JSONObject();
		json.put("detail", detail);
		return json;
	}

	/**
	 * vip说明页面
	 */
	@RequestMapping("vipIntroList")
	@ResponseBody
	public JSONObject getList(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<ZVipIntroduce> vip = zVipIntroduceService.getList();
		JSONObject json = new JSONObject();
		json.put("vip", vip);
		return json;
	}

	/**
	 * 用户反馈
	 */
	@RequestMapping("addFeedBack")
	@ResponseBody
	public String addFeedBack(String openId, String content, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		zFeedbackService.addFeedbacks(openId, content);
		return "sucess";
	}

	/**
	 * 用户发送消息/列表
	 */
	@RequestMapping("addNotice")
	@ResponseBody
	public String addNotice(HttpServletResponse response, String openId, String content) {
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		zNoticeService.adds(openId, content);
		return "sucess";
	}

	@RequestMapping("noticeList")
	@ResponseBody
	public JSONObject getNoticeList(String openId, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		List<ZNotice> list = zNoticeService.getLists(openId);
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json;
	}

}
