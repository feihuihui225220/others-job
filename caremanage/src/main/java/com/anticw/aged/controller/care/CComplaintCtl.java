/**   

 * @Title: CComplaintCtl.java 
 * @Package com.anticw.aged.controller.care 
 * @Description: TODO
 * @author ltw   
 * @date 2014年10月6日 下午7:31:25 
 * @version V1.0   
 *//*
package com.anticw.aged.controller.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.service.care.COrderService;
import com.anticw.aged.service.community.user.RUserService;

*//**
 * 投诉管理Ctl
 * 
 * @ClassName: CComplaintCtl
 * @Description: TODO
 * @author ltw
 * @date 2014年10月6日 下午7:31:25
 * 
 *//*
@Controller
@RequestMapping("/care/complaint")
public class CComplaintCtl extends BaseCtl{
    @Autowired
    private COrderService cOrderService;
    @Autowired
	private RUserService rUserService;
	*//**
	 * 创建投诉数据
	 * 
	 * @param CComplaintVO
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws BusinessException 
	 *//*
	@RequestMapping(value = "addOrUpdate")
	public ModelAndView saveOrUpdate(HttpSession session,CComplaintVO cComplaintVO)
			throws IllegalAccessException, InvocationTargetException, BusinessException {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Long id = cComplaintVO.getId();
		
		if(cComplaintVO.selfValidate()==false){
			return new ModelAndView(new RedirectView("/care/complaint/goToAdd"));
		}
		CComplaint cComplaint = new CComplaint();
		if (id == null) {
			cComplaint.setAvailable(true);
			cComplaint.setCreatedAt(new Date());
			Long uid=cComplaintVO.getUserId();
			Long orderId=cComplaintVO.getOrderId();
		//	COrder cOrder=cOrderService.getOrderById(orderId);
			RUser rUser=rUserService.findById(uid);
			Integer communityId=rUser.getCommunityId();
			cComplaint.setCommunityId(communityId);
			cComplaint.setrUser(rUser);
			cComplaint.setCreatedBy(userVO.getName());
			cComplaint.setCreatedAt(new Date());
			//cComplaint.setcOrder(cOrder);
			cComplaint.setVendorId(userVO.getVenderId());
			BeanUtils.copyProperties(cComplaint, cComplaintVO);
			cComplaint.setStatus((short) 0);
			cComplaintService.saveOrUpdate(cComplaint);
		} else {
			
			CComplaint old = cComplaintService.getComplaintById(id);
			old.setChangedAt(new Date());
			String conclusion = cComplaintVO.getConclusion();
			Short status=cComplaintVO.getStatus();
			if(conclusion!=null&&status==0){
				old.setConclusion(conclusion);
				 status=(short) (cComplaintVO.getStatus()+1);
				old.setStatus(status);
			}
			String callBack = cComplaintVO.getCallback();
			if(callBack!=null&&status==1){
				old.setCallback(callBack);
				status=(short) (cComplaintVO.getStatus()+1);
				old.setStatus(status);
			}
			old.setChangedAt(new Date());
			old.setChangedBy(userVO.getName());
			cComplaint=old;
			//BeanUtils.copyProperties(old, cComplaintVO);
			cComplaintService.saveOrUpdate(old);
		}
		ModelAndView mv = new ModelAndView(new RedirectView("/care/complaint/listByCommunityId?communityId=" + cComplaint.getCommunityId()));
		return mv;
	}

	*//**
	 * 获取投诉详情
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "details")
	public ModelAndView getComplaintById(Long id) {
		CComplaint cComplaint = cComplaintService.getComplaintById(id);
		ModelAndView mv = new ModelAndView("/care/complaint/complaintAdd");
		mv.addObject("resultComplaint", cComplaint);
		mv.addObject("result",cComplaint.getcOrder());
		return mv;
	}

	*//**
	 * 投诉信息列表
	 * @return
	 *//*
	@RequestMapping(value = "list")
	public ModelAndView getComplaintList() {
		List<CComplaint> result = cComplaintService.getAllComplaint();
		ModelAndView mv = new ModelAndView("care/complaint/complaintList");
		mv.addObject("result", result);
		return mv;
	}
	*//**
	 * 根据社区ID获取投诉信息列表
	 * @return
	 *//*
	@RequestMapping(value = "listByCommunityId")
	public ModelAndView getComplaintListBycommunityId(HttpSession session,PageParamVO pageVO,String communityId) {
		Page<CComplaint> result =null;
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		//if(userVO.getCateEnum().getType()==6){
		//	result = cComplaintService.getComplaintListByCreate(userVO.getName());
		//}else{
			 result = cComplaintService.getComplaintListBycommunityId(pageVO,userVO.getCommunityId());
		//}
		
		ModelAndView mv = new ModelAndView("care/complaint/complaintList");
		mv.addObject("page", result);
		return mv;
	}
	*//**
	 * 根据社区ID获取投诉信息列表
	 * @return
	 *//*
	@RequestMapping(value = "listByVendorId")
	public ModelAndView getComplaintListByVendorId(HttpSession session,PageParamVO pageVO,String vendorId) {
		Page<CComplaint> result =null;
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(vendorId==null){
			
			result = cComplaintService.getComplaintListByCreate(pageVO,userVO.getName());
		}else{
			 result = cComplaintService.getComplaintListBycommunityId(pageVO,vendorId);
		}
		
		ModelAndView mv = new ModelAndView("care/complaint/complaintList");
		mv.addObject("result", result);
		return mv;
	}
	*//**
	 * 根据创建人获取投诉列表
	 * @return
	 *//*
	@RequestMapping(value = "listByCreate")
	public ModelAndView getListByCreate(HttpSession session,String createBy) {
		if(createBy==null){
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			createBy=userVO.getName();
		} 
		List<CComplaint> result = cComplaintService.getListByCreate(createBy);
		ModelAndView mv = new ModelAndView("care/complaint/complaintList");
		mv.addObject("result", result);
		return mv;
	}
	*//**
	 * 关键字查询投诉信息列表
	 * @return
	 *//*
	@RequestMapping(value = "searchByKey")
	public ModelAndView seareComplaintByKey() {
		List<CComplaint> result = cComplaintService.getAllComplaint();
		ModelAndView mv = new ModelAndView("/care/complaintList");
		mv.addObject("details", result);
		return mv;
	}
	*//**
	 * 进入到投诉添加页面
	 * @return
	 *//*
	@RequestMapping(value = "goToAdd")
	public ModelAndView goToAdd(Integer communityId) {
		ModelAndView mv = new ModelAndView("care/complaint/complaintAdd");
		mv.addObject("communityId", communityId);
		return mv;
	}
	*//**
	 * 进入到投诉添加页面
	 * @return
	 *//*
	@RequestMapping(value = "goBackToAdd")
	public ModelAndView goBackToAdd(Long orderId) {
		COrder cOrder=cOrderService.getOrderById(orderId);
		ModelAndView mv = new ModelAndView("care/complaint/complaintAdd");
		mv.addObject("result", cOrder);
		return mv;
	}
	*//**
	 * 根据关键字查询
	 * @param cComplaintSearchVO
	 * @return
	 *//*
	@RequestMapping(value = "searchComplaintBykey")
	public ModelAndView searchComplaintBykey (HttpSession session,PageParamVO pageVO,CComplaintSearchVO cComplaintSearchVO){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		cComplaintSearchVO.setCommunityId(userVO.getCommunityId());
		Page<CComplaint> result = cComplaintService.searchComplaintBykey(pageVO,cComplaintSearchVO);
		ModelAndView mv = new ModelAndView("care/complaint/complaintList");
		mv.addObject("searchKey", cComplaintSearchVO);
		mv.addObject("page", result);
		return mv;
	}
	 
}
*/