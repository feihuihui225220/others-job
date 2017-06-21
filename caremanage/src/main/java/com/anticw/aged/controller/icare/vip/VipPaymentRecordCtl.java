package com.anticw.aged.controller.icare.vip;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZVipPaymentRecord;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.icare.vip.VipPaymentOrderService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/payment/")
public class VipPaymentRecordCtl {
	@Autowired
	private VipPaymentOrderService vipPaymentRecordService;
 
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "/ICare/vip/picture";
	}
	/**
	 * 添加
	 *@param 
	 *@return
	 * @throws IOException 
	 */
	@RequestMapping("add")
	public String addVipOrder(ZVipPaymentRecord vipPaymentRecord){
		vipPaymentRecordService.add(vipPaymentRecord);
		return "redirect:getList";
	}	
	/**
	 * 删除
	 *
	 */
	@RequestMapping("remove/{id}")
	public String  removeVipOrder(@PathVariable("id")int id,String url){
		vipPaymentRecordService.remove(id);
		return "redirect:/VipOrder/getList";
	}
	/**
	 * 修改
	 */
	@RequestMapping("modify")
	public String modifyVipOrder(ZVipPaymentRecord vipPaymentRecord){
		vipPaymentRecordService.modify(vipPaymentRecord);
		return "redirect:/vipOrder/getList";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getVipOrderById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("VipOrder", vipPaymentRecordService.getById(id));
		return "";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("getList")
	public String getVipOrderList(PageParamVO page,HttpServletRequest request) {
		Page<ZVipPaymentRecord> pageInfo = vipPaymentRecordService.getList(page.getPage(), page.getNum());
		request.setAttribute("page",pageInfo);
		return "/ICare/vip/picture";
	}
	

}
