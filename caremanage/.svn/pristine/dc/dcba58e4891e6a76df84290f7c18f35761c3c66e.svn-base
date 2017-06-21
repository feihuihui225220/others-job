/**
 * 
 *//*
package com.anticw.aged.controller.care;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.anticw.aged.bean.*;
import com.anticw.aged.pool.SpringDataPool;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.care.COrderService;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CVendorEvaluationService;
import com.anticw.aged.service.care.CVendorMenuService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.care.CVendorVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.common.PageVO;
import com.anticw.aged.vo.permission.UserVO;

*//**
 * 关爱服务商管理
 * 
 * @ClassName: CvendorCtl
 * @Description: TODO
 * @author ltw
 * @date 2014年10月2日 下午10:35:25
 * 
 *//*
@Controller
@RequestMapping("/care/vendor")
public class CvendorCtl extends BaseCtl{
	@Autowired
	private CvendorService cvendorService;
	@Autowired
	private COrderService cOrderService;
	@Autowired
	private CVendorEvaluationService cVendorEvaluationService;
	@Autowired
	private CVendorMenuService cVendorMenuService;
	@Autowired
	private CServiceManagerService cServiceManagerService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private SpringDataPool springDataPool;
	*//**
	 * 关爱服务商增加更新
	 * 
	 * @param cVendorVo
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws BusinessException 
	 *//*
	//删除（暂定）
	@RequestMapping(value = "addOrUpdate")
	public ModelAndView saveOrUpdate(HttpSession session,CVendorVO cVendorVo,@RequestParam(value = "file", required = false) MultipartFile[] file)throws IllegalAccessException, InvocationTargetException, BusinessException {
		ModelAndView mv =null;
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		String cmName = null;
		if(userVo.isSuper_()) {
			cmName = userVo.getName();
		}else{
			//TODO:该处需要获取父级Id
			cmName = userVo.getName();
		}
		//if (cvendorService.isRegister(cVendorVo.getAdminName())) {
		String path=this.uploadFile(5, file);
			CVendor cVendor = new CVendor();
			if (cVendorVo.getId() == null) {
				cVendor.setCmName(cmName);
				cVendor.setCategoryIds(cVendorVo.getCategoryIds());
				cVendor.setTagIds(cVendorVo.getTagIds());
		        cVendor.setCreatedBy(userVo.getName());
		        cVendor.setCommunityIds(userVo.getCommunityId());
				cVendor.setAvailable(true);
				cVendor.setCreatedAt(new Date());
				cVendor.setCreatedBy(userVo.getName());
				cVendor.setScope(cVendorVo.getScope());
				cVendor.setShoptime(cVendorVo.getShoptime());
				cVendor.setStaprice(cVendorVo.getStaprice());
				if(path!=null)
					cVendor.setCoverPath(path);
				BeanUtils.copyProperties(cVendor, cVendorVo);
                AUser aUser=new AUser(cVendorVo.getAdminName(), cVendorVo.getPassword(), cVendor.getId(), (short)5, cVendor.getCommunityIds());
                aUser.setNickname(cVendorVo.getName());
                aUser.setCreatedAt(new Date());
                aUser.setAddr(cVendorVo.getAddress());
                AUser rAuser =null;
                rAuser =permissionService.saveManager(aUser, cmName);
                cvendorService.saveOrUpdate(cVendor);
                aUser.setVenderId(cVendor.getId());
                permissionService.updateUser(aUser, false);
				//mv = new ModelAndView(new RedirectView("/care/careManager/list"));
			} else {
				//CVendor old = cvendorService.getVendorById(cVendorVo.getId());
				old.setChangedAt(new Date());
				old.setName(cVendorVo.getName());
				old.setContactPhone(cVendorVo.getContactPhone());
				old.setTagIds(cVendorVo.getTagIds());
				old.setAddress(cVendorVo.getAddress());
				old.setContact(cVendorVo.getContact());
				old.setChangedAt(new Date());
				old.setChangedBy(userVo.getName());
				old.setScope(cVendorVo.getScope());
				old.setShoptime(cVendorVo.getShoptime());
				old.setStaprice(cVendorVo.getStaprice());
				old.setDescr(cVendorVo.getDescr());
				old.setLatitude(cVendorVo.getLatitude());
				old.setLongitude(cVendorVo.getLongitude());
				if(path!=null)
					old.setCoverPath(path);
				//BeanUtils.copyProperties(old, cVendorVo);
				cvendorService.saveOrUpdate(old);
				 mv = new ModelAndView(new RedirectView("/care/vendor/infoDetails?id="+cVendorVo.getId()+"&type=2"));
			}
			
			mv.addObject("msg", "success");
		    return mv;
	}
	*//**
	 * 跳转到关爱服务商修改页面
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "goToAddUpdate")
	public ModelAndView goToAddUpdate(Integer vendorId) {
		ModelAndView mv = new ModelAndView("/care/vendor/vendorEditor");
		///CVendor cVendor = cvendorService.getVendorById(vendorId);
		//String serviceType = cVendor.getCategoryIds();
		//List<CServiceManager> serviceTypeList = cServiceManagerService.getServiceManagerByIds(serviceType, "1");
		Map<Integer,Map<Integer,OCategoryItem>> map = springDataPool.getOCategory();
		//mv.addObject("serviceTypeList", serviceTypeList);
		int star=cVendorEvaluationService.getVendorStar(vendorId);
		//cVendor.setStar(star);
		//mv.addObject("cVendor", cVendor);
		mv.addObject("map", map);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 *
	 *//*
	@RequestMapping(value = "goToAddServiceType")
	public ModelAndView goToAddServiceType(Integer vendorId) {
		CVendor cVendor = cvendorService.getVendorById(vendorId);
		String typeIds = cVendor.getCategoryIds();
		List<CServiceManager> result = cServiceManagerService
				.getServiceManagerByIds(typeIds, "2");
		ModelAndView mv = new ModelAndView("/care/vendorServiceTpe");
	//	mv.addObject("serviceTypeList", result);
		mv.addObject("vendorId", vendorId);
		return mv;
	}

	*//**
	 * 关爱服务商增加更新
	 *//*
	@RequestMapping(value = "updateVendorServiceType")
	public ModelAndView updateServiceType(Integer vendorId, String typeId) {

		CVendor cVendor = cvendorService.getVendorById(vendorId);
		String typeIds = cVendor.getCategoryIds();
		String tmpServiceType = typeId + ",";

		List types = new ArrayList(Arrays.asList(typeIds.split(",")));
		int size = types.size();
		if (size > 1) {
			StringBuffer sb = new StringBuffer();
			Iterator it = types.iterator();
			while (it.hasNext()) {
				String value = (String) it.next();
				if (typeId.equals(value)) {
					it.remove();
				} else {
					sb.append(value + ",");
				}
			}
			typeIds = sb.toString();
			if (typeIds.endsWith(",")) {
				typeIds = typeIds.substring(0, typeIds.length() - 1);
			}
		} else {
			typeIds = "";
		}
		if(typeIds!=null)
		cVendor.setCategoryIds(typeIds);
		cvendorService.saveOrUpdate(cVendor);
		ModelAndView mv = new ModelAndView(new RedirectView("/care/vendor/vendorServiceList?vendorId="+vendorId));
		return mv;
	}

	*//**
	 * 添加关爱服务商服务类型
	 *//*
	@RequestMapping(value = "addVendorServiceType")
	public ModelAndView addServiceType(Integer vendorId, String serviceId) {
     //if(serviceId!=null){
			
		
		CVendor cVendor = cvendorService.getVendorById(vendorId);
		String serviceType = cVendor.getCategoryIds();
		if (serviceType != null && !"".equals(serviceType)) {
			cVendor.setCategoryIds(serviceType + "," + serviceId);
		} else {
			cVendor.setCategoryIds(serviceId);
		}
		cvendorService.saveOrUpdate(cVendor);
     }
		// cVendor.setCategoryIds(typeIds);
		
		ModelAndView mv = new ModelAndView(new RedirectView("/care/vendor/vendorServiceList?vendorId=" + vendorId));
		return mv;
	}

	*//**
	 * 
	 * @param id
	 * @param type 1:跳转到关爱服务商首页 2:跳转到ifram内嵌页
	 * @return
	 *//*
	@RequestMapping(value = "infoDetails")
	public ModelAndView getVendorById(Integer id,String type) {
		CVendor cVendor = null;
		cVendor = cvendorService.getVendorById(id);
		Map<Integer,Map<Integer,OCategoryItem>> map_all = springDataPool.getOCategory();
		String tagIds = cVendor.getTagIds();
		Map<Integer,OCategoryItem> map_tag = map_all.get(122);
		ModelAndView mv = null;
		if("1".equals(type)){
			mv = new ModelAndView("/care/vendor");
		}else if("2".equals(type)){
			//mv = new ModelAndView("/care/vendor/vendorLnfo");
		}
		String serviceType = cVendor.getCategoryIds();
		List<CServiceManager> serviceTypeList =    cServiceManagerService.getServiceManagerByIds(serviceType, "1");
		int star=cVendorEvaluationService.getVendorStar(id);
		if(star==0)
			star = 4;
		cVendor.setStar(star);
		mv.addObject("serviceTypeList", serviceTypeList);
		if(tagIds!=null){
			String[] tags = tagIds.split(",");
			List<OCategoryItem> list = new ArrayList<OCategoryItem>();
			for(String t:tags){
				list.add(map_tag.get(Integer.parseInt(t)));
			}
			mv.addObject("map", list);
		}
		mv.addObject("vendor", cVendor);
		mv.addObject("vendorId", id);
		return mv;
	}


	*//**
	 * 根据服务商ID获取订单
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "vendorOrderList")
	public ModelAndView getVendorOrderListById(PageParamVO pageVO,Integer vendorId) {
		Page<COrder> orderList = cOrderService.getOrderByVendorId(pageVO,vendorId);
		ModelAndView mv = new ModelAndView("/care/vendor/vendorOrder");
		mv.addObject("page", orderList);	
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 * 根据服务商ID获取评价列表
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "VendoreValuationList")
	public ModelAndView getVendoreValuationListById(Integer vendorId) {
		List<CVendorEvaluation> evaluationList = cVendorEvaluationService.getVendorEvaluationByVendorId(vendorId);
		ModelAndView mv = new ModelAndView("/care/vendor/vendorEval");
		mv.addObject("evaluationList", evaluationList);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 * 根据服务商ID获取服务项目列表
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "vendorMenuList")
	public ModelAndView getVendorenuListById(HttpSession session,Integer vendorId,PageParamVO pagevo) {
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("care/vendor/vendorMenu");
		if(vendorId==null||vendorId==userVo.getVenderId()){
			vendorId = userVo.getVenderId();
			mv.setViewName("care/vendor/myVendor");
		}
		Page<CVendorMenu> menuList = cVendorMenuService.pageByVendorId(vendorId,pagevo);
		mv.addObject("page", menuList);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	@RequestMapping(value = "vendorServiceList")
	public ModelAndView getvendorServiceListById(Integer vendorId) {
		CVendor cVendor = cvendorService.getVendorById(vendorId);
		List<CServiceManager> serviceManagerList = cServiceManagerService.getServiceManagerByIds(cVendor.getCategoryIds(), "1");
		
		String serviceType = cVendor.getCategoryIds();
		List<CServiceManager> serviceTypeList =    cServiceManagerService.getServiceManagerByIds(serviceType, "1");
		ModelAndView mv = new ModelAndView("/care/vendor/vendorServiceType");
		//mv.addObject("serviceManagerList", serviceManagerList);
		//mv.addObject("serviceTypeList", serviceTypeList);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 * 根据服务类型获取关爱服务商 此类型服务列表
	 * 默认为月坛的数据，否则需要选择省市县社区
	 * @param serviceType
	 * @return
	 *//*
	@RequestMapping(value = "serviceList")
	public ModelAndView listVendorByServiceType(HttpSession session,Integer serviceType,Long userId,Boolean isJson,String callback) {

		//UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds =userVO==null?"3270,3271,3272,3270,3271,3272,3277,3278,3279,3280,3281,3282,3283,3284,3285,3286,3287,3288,3289,3290,3291,3292,3293,3294,3295,3296,3297,3298,3299,3300,3301,3302,3303,3304,3305,3306,3307,3308,3309,3310,3322": 
			userVO.getCommunityId();
		ARole role =(ARole)userVO.getRoles().toArray()[0];
		Short userCategoryId = role.getUserCategory();//6呼叫中心，7街道
		//List<CVendor> result = cvendorService.listVendorByServiceType(userCategoryId,serviceType,communityIds);
		ModelAndView mv = new ModelAndView("/care/serviceType/orderServiceVendorList");
		 if(isJson!=null&&isJson){
		    //	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, result, callback);
				mv = new ModelAndView("/care/json");
			//	mv.addObject("json", jsonResult);
				return mv;
			}
		//mv.addObject("serviceType", serviceType);
		//mv.addObject("serviceList", result);
		mv.addObject("userId", userId);
		return mv;
	}
	
	*//**
	 * search by vendor's name
	 * @param session
	 * @param name
	 * @return
	 *//*
	@RequestMapping(value = "search")
	public ModelAndView listVendorByName(HttpSession session,String name,Long userId){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = userVO==null?"3270,3271,3272,3270,3271,3272,3277,3278,3279,3280,3281,3282,3283,3284,3285,3286,3287,3288,3289,3290,3291,3292,3293,3294,3295,3296,3297,3298,3299,3300,3301,3302,3303,3304,3305,3306,3307,3308,3309,3310,3322": 
			userVO.getCommunityId();
		List<CVendor> result = cvendorService.listVendorByName(name, communityIds);
		ModelAndView mv = new ModelAndView("/care/serviceType/orderServiceVendorList");
		mv.addObject("serviceList",result);
		mv.addObject("userId", userId);
		return mv;
	}
	
	*//**
	 * search by menu's name
	 * @param session
	 * @param name
	 * @param userId
	 * @return
	 *//*
	@RequestMapping("searchMenu")
	public ModelAndView listVendorByMenu(HttpSession session,String name,Long userId){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = userVO==null?"3270,3271,3272,3270,3271,3272,3277,3278,3279,3280,3281,3282,3283,3284,3285,3286,3287,3288,3289,3290,3291,3292,3293,3294,3295,3296,3297,3298,3299,3300,3301,3302,3303,3304,3305,3306,3307,3308,3309,3310,3322": 
			userVO.getCommunityId();
		List<CVendorMenu> menus = cVendorMenuService.listByMenuName(name, communityIds);
		ModelAndView mv = new ModelAndView("/care/serviceType/orderMenuVendorList");
		mv.addObject("menus",menus );
		mv.addObject("userId",userId);
		return mv;
	}

	
}
*/