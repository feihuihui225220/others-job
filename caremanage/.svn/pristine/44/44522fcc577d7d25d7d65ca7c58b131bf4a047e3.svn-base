/*package com.anticw.aged.controller.care;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.CServiceManager;
import com.anticw.aged.bean.CVendorMenuType;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CVendorMenuTypeService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.vo.care.CVendorMenuTypeVo;

@Controller
@RequestMapping(value="/care/menu/type")
public class CVendorMenuTypeCtl extends BaseCtl{
	@Autowired
	private CVendorMenuTypeService cVendorMenuTypeService;
	@Autowired
	private CServiceManagerService cServiceManagerService;
	@Autowired
	private CvendorService cvendorService;
	*//**
	 * 跳转到服务商菜单分类管理页面
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value="goToMenuTypeList")
	public ModelAndView goToMenuTypeList(Integer vendorId){
		List<CVendorMenuType> cMenuTypes=cVendorMenuTypeService.findMenuTypeByID(vendorId);
		ModelAndView mv=new ModelAndView("/care/menuType/vendorMenuType");
		mv.addObject("cMenuTypeList", cMenuTypes);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	
	*//**
	 * 跳转到添加服务商菜单分类页面
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value="goToAdd")
	public ModelAndView goToAdd(Integer vendorId){
		String types=cvendorService.getVendorById(vendorId).getCategoryIds();
		List<CServiceManager>  cServiceManager = cServiceManagerService.getServiceManagerByTypes(types);
		ModelAndView mv=new ModelAndView("/care/menuType/addMenuType");
		//mv.addObject("cServiceTypeList", cServiceManager);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 * 跳转到编辑服务商菜单分类页面
	 * @param id
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value="goToEdit")
	public ModelAndView goToEdit(Integer id,Integer vendorId){
		CVendorMenuType cVendorMenuType=null;
		cVendorMenuType=cVendorMenuTypeService.findMenuTypeInfo(id);
		String types=cvendorService.getVendorById(vendorId).getCategoryIds();
		List<CServiceManager>  cServiceManager = cServiceManagerService.getServiceManagerByTypes(types);
		ModelAndView mv=new ModelAndView("/care/menuType/updateMenuType");
		//mv.addObject("menuTypeInfo", cVendorMenuType);
		//mv.addObject("cServiceTypeList", cServiceManager);
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	
	*//**
	 * 添加或编辑菜单分类
	 * @param cVendorMenuTypeVo
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value="addOrUpdate")
	public ModelAndView addOrUpdate(CVendorMenuTypeVo cVendorMenuTypeVo,Integer vendorId){
		if(cVendorMenuTypeVo.getId()==null){
			CVendorMenuType addMenuType=new CVendorMenuType();
			addMenuType.setName(cVendorMenuTypeVo.getName());
			//CServiceManager service=cServiceManagerService.getServiceManagerById(cVendorMenuTypeVo.getServiceId());
			//addMenuType.setService(service);
			addMenuType.setVendorId(cVendorMenuTypeVo.getVendorId());
			cVendorMenuTypeService.saveMenuType(addMenuType);
			return goToMenuTypeList(vendorId);
		}else{
			CVendorMenuType editMenuType=new CVendorMenuType();
			editMenuType.setId(cVendorMenuTypeVo.getId());
			editMenuType.setName(cVendorMenuTypeVo.getName());
			//CServiceManager service=cServiceManagerService.getServiceManagerById(cVendorMenuTypeVo.getServiceId());
			//editMenuType.setService(service);
			editMenuType.setVendorId(cVendorMenuTypeVo.getVendorId());
			cVendorMenuTypeService.updateMenuType(editMenuType);
			return goToMenuTypeList(vendorId);
		}
	}
	
	*//**
	 * 删除菜单分类
	 * @param id
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value="deleteMenuType")
	public ModelAndView deleteMenuType(int id,Integer vendorId){
		try {
			cVendorMenuTypeService.deleteMenuType(id);
		} catch (Exception e) {
			//throw e;
		}
		return goToMenuTypeList(vendorId);
	}
}
*/