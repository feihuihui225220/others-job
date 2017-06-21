/**
 * 
 *//*
package com.anticw.aged.controller.care;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.emay.sdk.service.SMSService;

import com.anticw.aged.bean.utils.CareConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.care.COrderService;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CVendorMenuService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.care.CartVO;
import com.anticw.aged.vo.permission.UserVO;

*//**
 * 关爱服务商订单管理
 * 
 * @ClassName: COrderCtl
 * @Description: TODO
 * @author ltw
 * @date 2014年10月2日 下午9:58:30
 * 
 *//*
@Controller
@RequestMapping("/care/order")
public class COrderCtl {
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
	private SMSService smsService;
	public void cartList() {

	}

	*//**
	 * 创建关爱服务商订单
	 * 
	 * @param cartVo
	 * @throws BusinessException 
	 *//*
	@RequestMapping(value = "create")
	public ModelAndView createOrder(HttpSession session,HttpServletResponse response, CartVO cartVo,Boolean isJson,String callback) throws BusinessException {
		if(cartVo.getCartItemList()==null){
			throw new BusinessException(ExceptionCode.CART_IS_NOT_NULL);
		}
		//callCenter用户下单
		Long rUserId=cartVo.getUserId();
		//Integer type=-1;//跳转类型
		//如果rUserId为空表示老年人用户自己下单
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(rUserId==null){
			rUserId=userVO.getId();
		}
		Integer type=userVO.getCateEnum().getType();
		//CVendor cvendor = cvendorService.getVendorById(cartVo.getVendorId());
		COrder cOrder = new COrder();
		cOrder.setCreatedAt(new Date());
		String time=cartVo.getServiceTime();
		if(!StringUtils.isEmpty(time)){
			cOrder.setServiceTime(DateUtil.parseStrToCustomPatternDate(time,"yyyy-MM-dd HH:mm"));
		}else{
			Long serviceTime=new Date().getTime()+1800000;
			cOrder.setServiceTime(new Date(serviceTime));
		}
		cOrder.setOrderStatus(CareConstants.ORDER_NEW);
		RUser rUser = rUserService.findById(rUserId);
		cOrder.setrUser(rUser);
		// cOrder.setUserId(cartVo.getUserId());
		//cOrder.setcVendor(cvendor);
		if(cartVo.getContactUser()==null){
			cOrder.setContactUser(rUser.getName());
		}else{
			cOrder.setContactUser(cartVo.getContactUser());
		}
		if(cartVo.getContactPhone()==null){
			cOrder.setContactPhone(rUser.getContactPhone());
		}else{
			cOrder.setContactPhone(cartVo.getContactPhone());
		}
		if(cartVo.getAddr()==null){
			cOrder.setAddr(rUser.getAddr());
		}else{
			cOrder.setAddr(cartVo.getAddr());
		}
		cOrder.setRemark(cartVo.getRemark());
		cOrder.setCommunityId(cartVo.getCommunityId());
		List<COrderItem> cOrderItemList = new ArrayList<COrderItem>();
		List<CartItemVO> cartItemVoList = cartVo.getCartItemList();
		int cartItemVoListSize = cartItemVoList.size();
		COrderItem cOrderItem = null;
		CartItemVO cartItemVo = null;
		CVendorMenu cVendorMenu = null;
		Float totalPrice = new Float(0.00) ;
		for (int a = 0; a < cartItemVoListSize; a++) {
			cartItemVo = cartItemVoList.get(a);
			Integer productId = cartItemVo.getProductId();
			int quantity=cartItemVo.getQuantity();
			cVendorMenu = cVendorMenuService.getVendorMenuById(productId);
			cOrderItem = new COrderItem();
			cOrderItem.setcOrder(cOrder);
			cOrderItem.setcVendorMenu(cVendorMenu);
			cOrderItem.setQuantity(quantity);
			Float price = cVendorMenu.getPrice();
			cOrderItem.setPrice(price);
			cOrderItem.setName(cVendorMenu.getName());
			cOrderItemList.add(cOrderItem);
			totalPrice += price>0?price*quantity:0;
		}
		cOrder.setTotalPrice(totalPrice);
		cOrder.setcOrderItem(cOrderItemList);
		Integer categoryId=cartVo.getCategoryId();
		if(categoryId!=null){
			//CServiceManager cServiceManager=cServiceManagerService.getServiceManagerById(categoryId);
			//cOrder.setcServiceManager(cServiceManager);
		}
		cOrderService.createOrder(cOrder);
		//Integer type=userVO.getCateEnum().getType();
		//发送短信
		//smsService.sendSms(cOrder);
		//清除购物车cookie
		Cookie cookie= new Cookie("cart", null);
		cookie.setMaxAge(0);
		cookie.setPath("/care/menu");
		response.addCookie(cookie);
		
		ModelAndView mv =null;
		if(isJson!=null&&isJson){
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, "success", callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
			return mv;
		}
		//if(type==1){
			//return new ModelAndView(new RedirectView("/care/order/userOrderList"));
		//}else if(type==6){
		///	return new ModelAndView(new RedirectView("/care/order/communityOrderList"));
	//	}
		mv = new ModelAndView("/care/vendor/orderList");
	//	mv.addObject("createSuccess", "Success");
		return mv;
	}
	*//**
	 * 修改订单状态
	 * @param session
	 * @param orderId
	 * @param userId 配送人员ID
	 * @param auserId 老年人ID
	 * @return
	 *//*
	@RequestMapping(value = "updateOrderStatus")
	public ModelAndView updateOrderStatus(HttpSession session,Integer type,Long orderId,Integer userId,String finishStatus,Integer orderStatus,Integer stars,Boolean isJson,String callback,String orderCallBack) {
		COrder cOrder=cOrderService.getOrderById(orderId);
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Date time=new Date();
		if(finishStatus!=null){
			cOrder.setFinishStatus(finishStatus);
		}
		if(orderStatus==1){
			cOrder.setaUser(permissionService.getById(userId));
			cOrder.setOrderStatus(orderStatus+1);
			cOrder.setResponseTime(time);
			 
		}else if(orderStatus==2){
			cOrder.setOrderStatus(orderStatus+1);
			cOrder.setFinishTime(time);
		}else if(orderStatus==3){
			cOrder.setOrderStatus(orderStatus+1);
			cOrder.setStar(stars);
		}else if(orderStatus==4){
			cOrder.setOrderStatus(orderStatus+1);
			cOrder.setCallback(orderCallBack);
		}
		cOrderService.createOrder(cOrder);
		int userType=userVO.getCateEnum().getType();
		ModelAndView mv =null;
		String goToUrl="";
		if(userType==3 && type==2){
			goToUrl="/care/order/userOrderList?userId="+cOrder.getrUser().getId();
			mv=new ModelAndView(new RedirectView(goToUrl));
			mv.addObject("userId",userId);
		}else if(userType==1){
			goToUrl="/care/order/userOrderList";
			mv=new ModelAndView(new RedirectView(goToUrl));
		}else if(userType==3||userType==6){
			mv=new ModelAndView(new RedirectView("/care/order/communityOrderList"));
		}else{
			mv=new ModelAndView(new RedirectView("/care/order/listOrderByvendorId"));
		}
		if(isJson!=null&&isJson){
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, "success", callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
		}
	  // mv = new ModelAndView("/care/vendor/orderList");
	   return mv;

	}
	*//**
	 * 根据关爱服务商Id获取订单列表
	 * 
	 * @param vendorId
	 *//*
	@RequestMapping(value = "listOrderByvendorId")
	public ModelAndView getOrderListByVendorId(HttpSession session,PageParamVO pageVO,Integer vendorId) {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		boolean isSuper = userVO.isSuper_();
		if(vendorId==null){
			vendorId=userVO.getVenderId();
		} 
		Page<COrder> result =null;
		if(isSuper){
			result = cOrderService.getOrderByVendorId(pageVO,vendorId);
		}else{
			result = cOrderService.getOrderByAuserId(pageVO,userVO.getId());
		}
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("page", result);
		mv.addObject("vendorId", vendorId);
		
		return mv;

	}

	*//**
	 * 获取老年人关爱服务订单列表
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "userOrderList")
	public ModelAndView getOrderByUserId(HttpSession session,PageParamVO pageVO,Long userId,Boolean isJson,String callback) {
		ModelAndView mv =null;
		if(userId==null){
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			userId=userVO.getId();
			mv = new ModelAndView("care/order/userOrderList");
		}else{
			mv = new ModelAndView("care/order/cmUserorderList");
		}
		Page<COrder> result = cOrderService.getOrderByUserId(pageVO,userId);
	    if(isJson!=null&&isJson){
	    	List<OrderResVo> res=new ArrayList<OrderResVo>();
	    	OrderResVo orderResVo=null;
	    	for(COrder tmp:result.getResult()){
	    		orderResVo=new OrderResVo();
			    orderResVo.setId(tmp.getId());
			    orderResVo.setContactPhone(tmp.getContactPhone());
			    orderResVo.setContactUser(tmp.getContactUser());
			    orderResVo.setcOrderItem(tmp.getcOrderItem());
			    orderResVo.setCreatedAt(tmp.getCreatedAt());
			    orderResVo.setTotalPrice(tmp.getTotalPrice());
			    orderResVo.setServiceTime(tmp.getServiceTime());
			    orderResVo.setFinishTime(tmp.getFinishTime());
			    orderResVo.setStar(tmp.getStar());
			    orderResVo.setVenderName(tmp.getcVendor().getName());
			    orderResVo.setOrderStatus(tmp.getOrderStatus());
			    orderResVo.setCategoryName(tmp.getcServiceManager().getoCategoryItem().getItemName());
			    res.add(orderResVo);
	    	}
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, res, callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
	    }else{
			mv.addObject("page", result);
			mv.addObject("userId",userId);
	    }
		
		return mv;
	}

	*//**
	 * 根据筛选条件进行查询
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "searchOrderlist")
	public ModelAndView searchOrderByKey(HttpSession session,PageParamVO pageVO,COrderSeachKeyVO cOrderSeachKeyVo,Boolean isJson,String callback) {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<COrder> result = cOrderService.searchOrderByKey(pageVO,cOrderSeachKeyVo);
		int userType=userVO.getCateEnum().getType();
		ModelAndView mv =null;
		String goToUrl="";
		//cm管理员
		if(userType==3 && cOrderSeachKeyVo.getUserId()!=null){
			//goToUrl="care/order/cmUserorderList";
			//goToUrl="/care/vendor/vendorOrder";
			mv=new ModelAndView(goToUrl);
		//用户
		}else if(userType==1){
			//goToUrl="care/order/userOrderList";
			mv=new ModelAndView(goToUrl);
		}else{
			//mv = new ModelAndView("/care/vendor/orderList");
		}
		
		if(isJson!=null&&isJson){
			Page<OrderResVo> page = new Page<OrderResVo>();
			List<OrderResVo> res=new ArrayList<OrderResVo>();
			page.setResult(res);
			page.setPageNo(result.getPageNo());
			page.setPageSize(result.getPageSize());
			page.setTotalCount(result.getTotalCount());
	    	OrderResVo orderResVo=null;
	    	for(COrder tmp:result.getResult()){
	    		orderResVo=new OrderResVo();
			    orderResVo.setId(tmp.getId());
			    orderResVo.setContactPhone(tmp.getContactPhone());
			    orderResVo.setContactUser(tmp.getContactUser());
			    orderResVo.setAddr(tmp.getAddr());
			   //orderResVo.setcOrderItem(tmp.getcOrderItem());
			    orderResVo.setCreatedAt(tmp.getCreatedAt());
			    orderResVo.setTotalPrice(tmp.getTotalPrice());
			    orderResVo.setServiceTime(tmp.getServiceTime());
			    orderResVo.setFinishTime(tmp.getFinishTime());
			    orderResVo.setStar(tmp.getStar());
			    orderResVo.setVenderName(tmp.getcVendor().getName());
			    orderResVo.setOrderStatus(tmp.getOrderStatus());
			    orderResVo.setCategoryName(tmp.getcServiceManager()==null?null:tmp.getcServiceManager().getoCategoryItem().getItemName());
			    res.add(orderResVo);
	    	}
	    	String jsonResult = PublicService.returnPageJSONP(ExceptionCode.SUCCESS, page, callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
		}
		
		mv.addObject("page", result);
		mv.addObject("seachKey", cOrderSeachKeyVo);
		mv.addObject("vendorId", cOrderSeachKeyVo.getVendorId());
		mv.addObject("userId",cOrderSeachKeyVo.getUserId());
		return mv;

	}
	

	*//**
	 * 根据订单Id获取订单详情
	 * 
	 * @param id
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 *//*
	@RequestMapping(value = "details")
	public ModelAndView getOrderById(HttpSession session,Long orderId,Integer type,Boolean isJson,String callback) throws IllegalAccessException, InvocationTargetException {
		
		COrder result = cOrderService.getOrderById(orderId);
		ModelAndView mv =null;
		if(type!=null&&type==2){
		//	mv = new ModelAndView("/care/order/orderDetails");
		}else{
			//mv = new ModelAndView("/care/vendor/orderDetails");
		}
		
		List<AUser> list=permissionService.getNormalUsers(result.getcVendor().getAdminName(), new Short("5"), false);
		if(isJson!=null&&isJson){
			    OrderResVo orderResVo=new OrderResVo();
			    List<DeliveryUser> deliveryUserList=new ArrayList<DeliveryUser>();
			    if(result.getOrderStatus()==1){
			    	DeliveryUser deliveryUser=null;
					    for(int a=0;a<list.size();a++){
					    	AUser tmp=list.get(a);
					    	deliveryUser =new DeliveryUser();
					    	deliveryUser.setId(tmp.getId());
					    	deliveryUser.setName(tmp.getName());
					    	deliveryUser.setPhone(tmp.getMobilePhone());
					    	deliveryUserList.add(deliveryUser);
					    }
			    }else{
			    	AUser aUser=result.getaUser();
			    	DeliveryUser deliveryUser=new DeliveryUser();
			    	deliveryUser.setId(aUser.getId());
			    	deliveryUser.setName(aUser.getName());
			    	deliveryUser.setPhone(aUser.getMobilePhone());
			    	deliveryUserList.add(deliveryUser);
			    }
			    orderResVo.setId(result.getId());
			    orderResVo.setContactPhone(result.getContactPhone());
			    orderResVo.setContactUser(result.getContactUser());
			    orderResVo.setAddr(result.getAddr());
			    orderResVo.setcOrderItem(result.getcOrderItem());
			    orderResVo.setDeliveryUser(deliveryUserList);
			    //BeanUtils.copyProperties(orderResVo, result);
			    orderResVo.setCreatedAt(result.getCreatedAt());
			    orderResVo.setTotalPrice(result.getTotalPrice());
			    orderResVo.setServiceTime(result.getServiceTime());
			    orderResVo.setFinishTime(result.getFinishTime());
			    orderResVo.setStar(result.getStar());
			    orderResVo.setVenderName(result.getcVendor().getName());
			    orderResVo.setOrderStatus(result.getOrderStatus());
		    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, orderResVo, callback);
				mv = new ModelAndView("/care/json");
				mv.addObject("json", jsonResult);
		    }else{		   
				
				mv.addObject("aUser", list);
				mv.addObject("type", type);
				mv.addObject("auserId",result.getrUser()==null?null:result.getrUser().getId());
				mv.addObject("orderDetails", result);
		    }
		return mv;
	}

	*//**
	 * 社区用户获取此社区下所有订单
	 * 根据社区Id获取这些社区下订单列表
	 * @param orderId
	 * @return
	 *//*
	@RequestMapping(value = "communityOrderList")
	public ModelAndView getOrderByCommunityIds(HttpSession session,PageParamVO pageVO,String communityIds) {
		if(communityIds==null){
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			communityIds=userVO.getCommunityId();
		}
		Page<COrder> result = cOrderService.getOrderByCommunityIds(pageVO,communityIds);
		ModelAndView mv = new ModelAndView("/care/vendor/orderList");
		mv.addObject("page", result);
		return mv;

	}
	*//**
	 * 根据身份证查询订单
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException 
	 * @RequestMapping(value = "userOrderListByIdcard")
	 *//*
	public ModelAndView getOrderByUserIdcard(PageParamVO pageVO,String idcard) throws JsonProcessingException {
		Page<COrder> result = cOrderService.getOrderByUserIdcard(pageVO,idcard);
		//String jsonString = JacksonMapper.toJson(result);
		ModelAndView mv = new ModelAndView("/care/complaint/complaintOrderInfo");
		mv.addObject("page", result);
		mv.addObject("idcard", idcard);
		return mv;
	}
	
	*//**
	 * 根据身份证查询关爱服务商订单
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException 
	 *//*
	@RequestMapping(value = "userOrderListByIdcard")
	public ModelAndView getOrderByUserIdcard(HttpSession session,PageParamVO pageVO,String idcard) {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<COrder> result = cOrderService.getCommplaintOrder(pageVO,idcard, userVO.getCommunityId());
		ModelAndView mv = new ModelAndView("/care/complaint/complaintOrderInfo");
		mv.addObject("page", result);
		mv.addObject("idcard", idcard);
		mv.addObject("type", 3);//cm用户
		mv.addObject("idcard", idcard);
		return mv;
	}
	*//**
	 * 撤回订单
	 * @param session
	 * @param orderId
	 * @param finishStatus
	 * @param isJson
	 * @param callback
	 * @return
	 *//*
	@RequestMapping("backOrder")
	public ModelAndView backOrder(HttpSession session,Long orderId,String finishStatus,Boolean isJson,String callback){
		ModelAndView mv = null;
		Integer orderStatus;
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		//设置订单状态
		if(userVO.getCateEnum().equals(UserCategoryEnum.CARE)){
			orderStatus = CareConstants.ORDER_BACKED_BYVENDOR;
			mv = new ModelAndView(new RedirectView("/care/order/listOrderByvendorId"));
		}else{
			orderStatus = CareConstants.ORDER_BACKED_BYADMIN;
		}
		cOrderService.backOrder(orderId, finishStatus, orderStatus);
		if(isJson!=null&&isJson){
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, "success", callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
		}else{
			
		}
		return mv;
	}
	*//**
	 * 回复订单完成情况
	 * @param session
	 * @param orderId
	 * @param finishStatus
	 * @param isJson
	 * @param callback
	 * @return
	 *//*
	@RequestMapping("replyOrder")
	public ModelAndView finishStatus(HttpSession session,Long orderId,String finishStatus,Boolean isJson,String callback){
		ModelAndView mv = null;
		cOrderService.backOrder(orderId, finishStatus, null);
		if(isJson!=null&&isJson){
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, "success", callback);
			mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
		}else{
			
		}
		return mv;
	}

}
*/