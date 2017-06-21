package com.anticw.aged.controller.cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.emay.sdk.service.SMSService;

@Controller
public class domo {

	@Autowired
	private SMSService sMSService;
	
	@RequestMapping("domo/domo/domo")
	@ResponseBody
	public Integer gfet(){
		return sMSService.sendSmartDevice("17600249172", "测试", "测试数据");
	}
}
