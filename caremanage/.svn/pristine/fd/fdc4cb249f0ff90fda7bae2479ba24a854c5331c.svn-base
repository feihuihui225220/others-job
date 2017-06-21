package com.anticw.aged.controller.professional.data;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.service.professional.data.base.IntelligentMattressService;

@Controller
@RequestMapping("/test/")
public class IntelligentMattressCtl {
	
	@Autowired
	public IntelligentMattressService mattressService;
	
	 @RequestMapping("list")
	 @ResponseBody
	public JSONObject lilst() throws ParseException{
		 String[] list=mattressService.getIntelligentMattress("Z52004");
	     JSONObject json =new JSONObject();
		 json.put("离床次数是：",list);
		 return json;
	 }
}
