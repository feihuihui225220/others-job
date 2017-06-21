package com.anticw.aged.controller.icare.vip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZAgreement;
import com.anticw.aged.service.icare.vip.AgreementService;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/agreement/")
public class AgreementCtl {
	@Autowired
	private AgreementService agreementService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "/ICare/vip/agreement";
	}
	/**
	 * 添加
	 *@param 
	 *@return
	 */
/*	@RequestMapping("add")
	public String addAgreement(ZAgreement agreement)
			throws BusinessException{
		agreementService.add(agreement);
		return "";
	}*/	
	/**
	 * 删除
	 *
	 */
	/*@RequestMapping("remove/{id}")
	public String  removeAgreement(@PathVariable("id")int id){
		agreementService.remove(id);
		return "";
	}*/
	/**
	 * 修改
	 */
	@RequestMapping("modify")
	public String modifyAgreement(ZAgreement agreement){
		agreementService.modify(agreement);
		return "redirect:get/"+agreement.getId();
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getAgreementById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("agreement", agreementService.getById(id));
		return "/ICare/vip/agreement";
	}
 
}
