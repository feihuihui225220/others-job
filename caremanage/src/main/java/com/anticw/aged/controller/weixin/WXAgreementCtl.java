package com.anticw.aged.controller.weixin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.ZAgreement;
import com.anticw.aged.bean.ZGuidePhoto;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.icare.vip.AgreementService;
import com.anticw.aged.service.icare.vip.GuidePhotoService;

@Controller
@RequestMapping("/wx/")
public class WXAgreementCtl {
	
	@Autowired
	private AgreementService agreementService;
	
	@Autowired
	private GuidePhotoService guidePhoneService;
	
	@RequestMapping("agreement")
	@ResponseBody
	public ZAgreement getAgreement(HttpServletResponse response){
		 
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		return agreementService.getById(1);
	}
	
	@RequestMapping("guide")
	@ResponseBody
	public Page<ZGuidePhoto> getGuide(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		return guidePhoneService.getList(1, 10);
	}
	
}
