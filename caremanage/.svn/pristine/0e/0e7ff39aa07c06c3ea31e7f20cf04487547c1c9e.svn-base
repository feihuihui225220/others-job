package com.anticw.aged.controller.icare.vip;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZVipOrder;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.icare.vip.VipOrderService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/vipOrder/")
public class VipOrderCtl {
	@Autowired
	private VipOrderService vipOrderService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAdd/{id}")
	public String toAdd(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("order", vipOrderService.getById(id));
		request.setAttribute("price",  vipOrderService.getPrice(id));
		request.setAttribute("id", id);
		return "/ICare/vip/order_add";
	}
	/**
	 * 添加
	 *@param 
	 *@return
	 * @throws IOException 
	 */
	@RequestMapping("add")
	public String addVipOrder(ZVipOrder VipOrder){
		vipOrderService.add(VipOrder);
		return "redirect:/vipOrder/getList";
	}
	/**
	 * 删除
	 *
	 */
	@RequestMapping("remove/{id}")
	public String  removeVipOrder(@PathVariable("id")int id,String url){
		vipOrderService.remove(id);
		return "redirect:/vipOrder/getList";
	}
	/**
	 * 修改
	 */
	@RequestMapping("modify")
	public String modifyVipOrder(ZVipOrder vipOrder){
		vipOrder.setAvailable(true);
		vipOrderService.modify(vipOrder);
		return "redirect:/vipOrder/getList";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getVipOrderById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("order", vipOrderService.getById(id));
		return "/ICare/vip/order_detail";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("toModify/{id}")
	public String  toModify(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("order", vipOrderService.getById(id));
		return "/ICare/vip/order_add";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("getList")
	public String getVipOrderList(PageParamVO page,HttpServletRequest request) {
		Page<ZVipOrder> pageInfo = vipOrderService.getList(page.getPage(), page.getNum());
		request.setAttribute("page",pageInfo);
		return "/ICare/vip/order";
	}
	

}
