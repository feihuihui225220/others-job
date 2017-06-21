/**
 * 
 *//*
package com.anticw.aged.controller.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CVendorMenuService;
import com.anticw.aged.service.care.CVendorMenuTypeService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.service.community.user.RUserService;


*//**
 * @author ltw 关爱服务商服务项管理
 *//*
@Controller
@RequestMapping(value="/care/menu")
public class CVendorMenuCtl extends BaseCtl {
	@Autowired
	private CVendorMenuService cVendorMenuService;
	@Autowired
	private CServiceManagerService cServiceManagerService;
	@Autowired
	private CvendorService cvendorService;
	@Autowired
	private RUserService rUserService;
	@Autowired
	private AttchmentHandle attchmentHandle;
	@Autowired
	private CVendorMenuTypeService cMenuTypeService;
    *//**
     * 跳转到添加关爱服务商服务项
     * @param vendorId
     * @return
     *//*
	@RequestMapping(value = "goToAdd")
	public ModelAndView goToAdd(Integer vendorId) {
		//String types=cvendorService.getVendorById(vendorId).getCategoryIds();
		//List<CServiceManager>  cServiceManager = cServiceManagerService.getServiceManagerByTypes(types);
		ModelAndView mv = new ModelAndView("/care/menu/addMenu");
		//mv.addObject("serviceTypeList", cServiceManager);
		mv.addObject("vendorId",vendorId);
		return mv;
	}
	@RequestMapping(value = "addOrUpdate")
	public ModelAndView  saveOrUpdate(CVendorMenuVO cVendorMenuVo,@RequestParam(value = "picturepath", required = false) MultipartFile[] files) {
		Integer id = cVendorMenuVo.getId();
		CVendorMenu cVendorMenu = new CVendorMenu();
		//CServiceManager cServiceManager=cServiceManagerService.getServiceManagerById(cVendorMenuVo.getCategoryId());
		CVendorMenuType cVendorMenuType=cMenuTypeService.get(cVendorMenuVo.getTypeId());
		try{
		if (id == null) {		 
			BeanUtils.copyProperties(cVendorMenu, cVendorMenuVo);
			 
			cVendorMenu.setAvailable(true);
			cVendorMenu.setCreatedAt(new Date());
			//CVendor cvendo=cvendorService.getVendorById(cVendorMenuVo.getVendorId());
			//cVendorMenu.setcVendor(cvendo);
			cVendorMenu.setCreatedAt(new Date());
			//cVendorMenu.setcServiceManager(cServiceManager);
			cVendorMenu.setcMenuType(cVendorMenuType);
			
			if(files!=null&&files.length>0){
				for(MultipartFile file:files){
					if(!file.isEmpty()){
						String[] picturepath = attchmentHandle.upload(CareConstants.MENU_ATTR_PATH, new MultipartFile[]{file});
						
						cVendorMenu.setPicturepath(picturepath[0]);
					}
				}
			}
			cVendorMenuService.saveOrUpdate(cVendorMenu);
		} else {
			CVendorMenu old = cVendorMenuService.getVendorMenuById(id);
			old.setChangedAt(new Date());
			//old.setcServiceManager(cServiceManagerService.getServiceManagerById(cVendorMenuVo.getCategoryId()));
			old.setcMenuType(cMenuTypeService.get(cVendorMenuVo.getTypeId()));
			BeanUtils.copyProperties(old, cVendorMenuVo);
			//cVendorMenu.setcServiceManager(cServiceManager);
			if(files!=null&&files.length>0){
				for(MultipartFile file:files){
					if(!file.isEmpty()){
						String[] picturepath = attchmentHandle.upload(CareConstants.MENU_ATTR_PATH, new MultipartFile[]{file});
						
						old.setPicturepath(picturepath[0]);
					}
				}
			}
			cVendorMenuService.saveOrUpdate(old);
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		// ModelAndView mv = new ModelAndView("care/menu/addOrUpdate");
		// mv.addObject("msg", "success");
		return new ModelAndView(new RedirectView("/care/vendor/vendorMenuList?vendorId="+cVendorMenuVo.getVendorId()));
		 
	}

	@RequestMapping(value="/list.json")
	public @ResponseBody String selectMenuType(Integer vendorId,Integer serviceId,String callback){ 
		List<CVendorMenuType> cVendorMenuType = cMenuTypeService.selectByServiceID(vendorId, serviceId);
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, cVendorMenuType, callback);
	}
	
	*//**
	 * 
	 * @param id
	 *//*
	@RequestMapping(value = "menu/details")
	public ModelAndView getVendorEvaluationById(Integer id) {
		CVendorMenu cVendorMenu = cVendorMenuService.getVendorMenuById(id);
		String types=cvendorService.getVendorById(cVendorMenu.getcVendor().getId()).getCategoryIds();
		List<CServiceManager>  cServiceManager = cServiceManagerService.getServiceManagerByTypes(types);
		ModelAndView mv = new ModelAndView("care/menu/updateMenu");
		//mv.addObject("cVendor", cVendorMenu);
		//mv.addObject("serviceTypeList", cServiceManager);
		return mv;
	}

	*//**
	 * 根据关爱服务商ID获取关爱服务商评价列表
	 * @param starDate
	 * @param endDate
	 * @return
	 *//*
	@RequestMapping(value = "menu/list")
	public ModelAndView listByVendorId(Integer vendorId,Boolean isJson,String callback) {
		//CVendor cVendor=cvendorService.getVendorById(vendorId);
		//List<CVendorMenu> result = cVendorMenuService.listByVendorId(vendorId);
		ModelAndView mv = new ModelAndView("/care/addOrUpdate");
		//mv.addObject("details", result);
	//	mv.addObject("cVendor", cVendor);
		if(isJson!=null&&isJson){
		//	return returnJson( result, callback);
		}
		return mv;
	}
	*//**
	 * 根据服务类型获取服务项信息(购物车菜单详情页)
	 * @param serviceType
	 * @return
	 *//*
	@RequestMapping(value = "list")
	public ModelAndView list(HttpSession session,Integer serviceType,Integer vendorId,Long userId,Boolean isJson,String callback) {
		List<CVendorMenu> result = null;
		
		//	result = cVendorMenuService.listByVendorId(vendorId);
		
			//result = cVendorMenuService.listByServiceType(serviceType, vendorId);
		//CVendor cVendor=cvendorService.getVendorById(vendorId);

		if(userId==null){
		   UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		   userId=userVO.getId();
		}
		//判断是否普通用户
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(userId==null&&userVO!=null&&userVO.getCateEnum().getType()==1){
		   userId=userVO.getId();
		}
		
		ModelAndView mv = new ModelAndView("/care/cart");
		if(userId!=null){
			RUser rUser = rUserService.findById(userId);
			mv.addObject("rUser", rUser);
			if(isJson!=null&&isJson){
				MenulistVO menulistVO=new MenulistVO();
				menulistVO.setContactUser(rUser.getName());
				menulistVO.setAddr(rUser.getAddr());
				menulistVO.setContactPhone(rUser.getContactPhone());
				menulistVO.setMenuList(result);
				return returnJson(menulistVO, callback);
			}
		}
		mv.addObject("serviceType", serviceType);
		mv.addObject("vendorId", vendorId);
		mv.addObject("list", result);
		mv.addObject("userId", userId);
	//	mv.addObject("cVendor", cVendor);
		return mv;
	}
	
}
*/