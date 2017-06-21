/*package com.anticw.aged.controller.cc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.CServiceManager;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CareConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.care.COrderService;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CVendorMenuService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.care.COrderSeachKeyVO;
import com.anticw.aged.vo.care.CartItemVO;
import com.anticw.aged.vo.care.CartVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/callCenter")
public class CallCenterCtl {

	@Autowired
	private COrderService cOrderService;
	@Autowired
	private CvendorService cvendorService;
	@Autowired
	private CVendorMenuService cVendorMenuService;
	@Autowired
	private RUserService rUserService;
	@Autowired
	private CServiceManagerService cServiceManagerService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private OCountryService oCountryService;
	
	*//**
	 * 
	 * @param idcard
	 * @return
	 *//*
	@RequestMapping(value = "index")
	public ModelAndView index(HttpSession session) {
		
		UserVO user = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = user.getCommunityId();
		Map<String, String> countryMap = oCountryService.getCountryMapByIds(communityIds);
		session.setAttribute("countryMap", countryMap);
		
		ModelAndView mv = new ModelAndView("redirect:/care/serviceType/serviceList?type=2");
		return mv;
	}
	@RequestMapping(value = "searchUser")
	public @ResponseBody JSONObject searchUser(String idcard,HttpSession session) {
		session.setAttribute("idcard", idcard);
		List<RUser> rUser =null;
		if(idcard!=null&&!"".equals(idcard)){
			try {
				rUser = rUserService.findByIdAndName(idcard);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		session.setAttribute("searchUserVo", rUser);
		JSONObject json  = new JSONObject();
		json.put("userlist", rUser);
		return json;
	}
	
	@RequestMapping(value = "searchUserById")
	public  ModelAndView searchUserById(String idcard,HttpSession session) {
		session.setAttribute("idcard", idcard);
		RUser rUser =null;
		Long userId=null;
		if(idcard!=null&&!"".equals(idcard)){
			try {
				rUser = rUserService.findByIdCardNo(idcard);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rUser!=null){
			userId=rUser.getId();
		}
		session.setAttribute("searchUserVo", rUser);
		
		ModelAndView mv = new ModelAndView("redirect:/care/serviceType/serviceList?type=2");
		mv.addObject("userId",userId);
		return mv;
	}
	
	
	@RequestMapping(value = "searchUserByNumber.json")
	public @ResponseBody String searchUserJsonBy(String number,HttpSession session) {
		List<RUser> users =null;
	
		if(number!=null&&!"".equals(number)){
			session.setAttribute("lastNum", number);
			try {
				users = rUserService.findByNumber(number);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return PublicService.returnValue(ExceptionCode.USER_NUMBER_NO_INVALID);
			}
			
		}
		
		return PublicService.returnValue(ExceptionCode.SUCCESS, users);
	}

	*//**
	 * 创建关爱服务商订单
	 * 
	 * @param cartVo
	 *//*
	@RequestMapping(value = "create")
	public ModelAndView createOrder(HttpSession session, CartVO cartVo) {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		//CVendor cvendor = cvendorService.getVendorById(cartVo.getVendorId());
		COrder cOrder = new COrder();
		cOrder.setCreatedAt(new Date());
		cOrder.setServiceTime(DateUtil.parseStrToCustomPatternDate(cartVo.getServiceTime(),"yyyy-MM-dd HH:mm"));
		cOrder.setOrderStatus(CareConstants.ORDER_NEW);
		RUser rUser = rUserService.findById(userVO.getId());
		cOrder.setrUser(rUser);
		// cOrder.setUserId(cartVo.getUserId());
	//	cOrder.setcVendor(cvendor);
		cOrder.setContactUser(cartVo.getContactUser());
		cOrder.setContactPhone(cartVo.getContactPhone());
		cOrder.setAddr(cartVo.getAddr());
		List<COrderItem> cOrderItemList = new ArrayList<COrderItem>();
		List<CartItemVO> cartItemVoList = cartVo.getCartItemList();
		int cartItemVoListSize = cartItemVoList.size();
		COrderItem cOrderItem = null;
		CartItemVO cartItemVo = null;
		CVendorMenu cVendorMenu = null;
		Float totalPrice = new Float(0.00);
		for (int a = 0; a < cartItemVoListSize; a++) {
			cartItemVo = cartItemVoList.get(a);
			Integer productId = cartItemVo.getProductId();
			cVendorMenu = cVendorMenuService.getVendorMenuById(productId);
			cOrderItem = new COrderItem();
			cOrderItem.setcOrder(cOrder);
			cOrderItem.setcVendorMenu(cVendorMenu);
			cOrderItem.setQuantity(cartItemVo.getQuantity());
			Float price = cVendorMenu.getPrice();
			cOrderItem.setPrice(price);
			cOrderItem.setName(cVendorMenu.getName());
			cOrderItemList.add(cOrderItem);
			totalPrice += price;
		}
		cOrder.setTotalPrice(totalPrice);
		cOrder.setcOrderItem(cOrderItemList);
		Integer categoryId=cartVo.getCategoryId();
		//CServiceManager cServiceManager=cServiceManagerService.getServiceManagerById(categoryId);
		//cOrder.setcServiceManager(cServiceManager);
		cOrderService.createOrder(cOrder);
		Integer type=userVO.getCateEnum().getType();
		if(type==1){
			return new ModelAndView(new RedirectView("/care/order/userOrderList"));
		}
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("createSuccess", "Success");
		return mv;
	}
	*//**
	 * 修改订单状态
	 * @param session
	 * @param orderId
	 * @param userId
	 * @return
	 *//*
	@RequestMapping(value = "updateOrderStatus")
	public ModelAndView updateOrderStatus(HttpSession session,Long orderId,Integer userId) {
		COrder cOrder=cOrderService.getOrderById(orderId);
		cOrder.setaUser(permissionService.getById(userId));
		cOrder.setOrderStatus(1);
		cOrder.setResponseTime(new Date());
		cOrderService.createOrder(cOrder);
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		return new ModelAndView(new RedirectView("/care/order/listOrderByvendorId"));

	}
	*//**
	 * 根据关爱服务商Id获取订单列表
	 * 
	 * @param vendorId
	 *//*
	@RequestMapping(value = "listOrderByvendorId")
	public ModelAndView getOrderListByVendorId(HttpSession session,PageParamVO pageVO,Integer vendorId) {
		if(vendorId==null){
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			vendorId=userVO.getVenderId();
		} 
		
		Page<COrder> result = cOrderService.getOrderByVendorId(pageVO,vendorId);
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("orderList", result);
		
		return mv;

	}

	*//**
	 * 获取老年人关爱服务订单列表
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "userOrderList")
	public ModelAndView getOrderByUserId(HttpSession session,PageParamVO pageVO,Long userId) {
		ModelAndView mv =null;
		if(userId==null){
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			userId=userVO.getId();
			mv = new ModelAndView("care/order/userOrderList");
		}else{
			mv = new ModelAndView("care/order/cmUserorderList");
		}
		Page<COrder> result = cOrderService.getOrderByUserId(pageVO,userId);	
		mv.addObject("orderList", result);
		return mv;
	}

	*//**
	 * 根据筛选条件进行查询
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "searchOrderlist")
	public ModelAndView searchOrderByKey(PageParamVO pageVO,COrderSeachKeyVO cOrderSeachKeyVo) {
		Page<COrder> result = cOrderService.searchOrderByKey(pageVO,cOrderSeachKeyVo);
		
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("orderList", result);
		return mv;

	}

	*//**
	 * 根据订单Id获取订单详情
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "details")
	public ModelAndView getOrderById(Long orderId,Integer type) {
		COrder result = cOrderService.getOrderById(orderId);
		ModelAndView mv =null;
		if(type!=null&&type==2){
			mv = new ModelAndView("/care/order/orderDetails");
		}else{
			mv = new ModelAndView("/care/vendor/orderDetails");
		}
		List<AUser> list=permissionService.getNormalUsers("", new Short("5"), true);
		mv.addObject("aUser", list);
		mv.addObject("orderDetails", result);
		return mv;
	}

	*//**
	 * 社区用户获取此社区下所有订单
	 * 根据社区Id获取这些社区下订单列表
	 * @param orderId
	 * @return
	 *//*
	@RequestMapping(value = "communityOrderList")
	public ModelAndView getOrderByCommunityIds(PageParamVO pageVO,String communityIds) {
		Page<COrder> result = cOrderService.getOrderByCommunityIds(pageVO,communityIds);
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("orderList", result);
		return mv;

	}
	*//**
	 * 根据身份证查询订单
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException 
	 *//*
	@RequestMapping(value = "userOrderListByIdcard")
	public ModelAndView getOrderByUserIdcard(PageParamVO pageVO,String idcard) throws JsonProcessingException {
		Page<COrder> result = cOrderService.getOrderByUserIdcard(pageVO,idcard);
		//String jsonString = JacksonMapper.toJson(result);
		ModelAndView mv = new ModelAndView("/care/complaint/complaintOrderInfo");
		mv.addObject("result", result);
		mv.addObject("idcard", idcard);
		return mv;
	}
 
	@RequestMapping("pubServer/{id}")
	public ModelAndView pubServer(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/callCenter/pubServer");
		mv.addObject("id", id);
		return mv;
	}
	@RequestMapping("proServer/{id}/{idcard}")
	public ModelAndView proServer(@PathVariable Long id, @PathVariable String idcard){
		ModelAndView mv = new ModelAndView("/callCenter/proServer");
		mv.addObject("id", id);
		mv.addObject("idcard", idcard);
		return mv;
	}
	*//**
	 * 添加临时用户
	 * @return
	 *//*
	@RequestMapping("addTempUser")
	public ModelAndView addTempUser(RUser user,HttpSession session){
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		rUserService.saveTempUser(user, userVo.getName());
		ModelAndView mv = new ModelAndView("redirect:/care/serviceType/serviceList?type=2");
		return mv;
	}
}
*/