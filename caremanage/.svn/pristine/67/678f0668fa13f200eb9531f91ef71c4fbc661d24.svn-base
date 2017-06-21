package com.anticw.aged.controller.weixin;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.ZVipOrder;
import com.anticw.aged.service.icare.vip.VipOrderService;

@Controller
@RequestMapping("/wx/")
public class WXOrderCtl {
	@Autowired
	private VipOrderService vipOrderService;

	@RequestMapping("selectOrderDetail")
	@ResponseBody
	public ZVipOrder selectOrderDetail(int id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		return vipOrderService.getById(id);
	}

	@RequestMapping("updatePayState")
	@ResponseBody
	public JSONObject updatePayState(int id, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		ZVipOrder vorder = new ZVipOrder();
		vorder.setId(id);
		vorder.setAvailable(false);
		vipOrderService.modify(vorder);
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		return json;
	}

	/**
	 * 预约下单
	 * 
	 * @param response
	 * @param vipOrder
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("payAddOrder")
	@ResponseBody
	public Integer payAddOrder(HttpServletResponse response, ZVipOrder vipOrder, HttpServletRequest request)
			throws UnsupportedEncodingException {
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		request.setCharacterEncoding("utf-8");
		return vipOrderService.add(vipOrder);
	}

	/**
	 * 通过json添加订单
	 * 
	 * @param response
	 * @param vipOrder
	 * @return
	 */
	/*
	 * @RequestMapping("payAddOrder")
	 * 
	 * @ResponseBody public Integer payAddOrder(HttpServletResponse
	 * response,@RequestBody JSONObject json){ ZVipOrder order =
	 * JSONObject.toJavaObject(json, ZVipOrder.class);
	 * response.addHeader("Access-Control-Allow-Origin", "*");//跨域 return
	 * vipOrderService.add(order); }
	 */

	@RequestMapping("getPrice")
	@ResponseBody
	public double getPrice(Integer id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		if (id == null) {
			id = 1;
		}
		return vipOrderService.getPrice(id);
	}

	/**
	 * 获取会员信息
	 * 
	 * @param phone
	 * @param response
	 * @return
	 */
	@RequestMapping("getVip")
	@ResponseBody
	public ZVipOrder getVip(String phone, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");// 跨域
		if (phone != null) {
			return vipOrderService.getVip(phone);
		} else {
			return null;
		}
	}

}
