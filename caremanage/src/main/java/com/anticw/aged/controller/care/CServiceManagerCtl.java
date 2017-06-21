/**
 * 
 *//*
package com.anticw.aged.controller.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.vo.common.PageParamVO;

*//**
 * 关爱服务商关爱服务类型管理Action
 * 
 * @author ltw
 * 
 *//*
@Controller
@RequestMapping("/care/serviceType/")
public class CServiceManagerCtl extends BaseCtl {
	@Autowired
	private CategoryItemService categoryItemService;

	public List<OCategoryItem> getServiceTypelist() {
		List<OCategoryItem> result = categoryItemService.findListValue(CategoryEnum.CARESER.getIndex());
		return result;
	}

	*//**
	 * 进入到关爱服务服务类型添加页
	 *//*
	
	 * @RequestMapping(value = "goToAddPage") public ModelAndView goToAddPage()
	 * { ModelAndView mv = new ModelAndView(
	 * "/care/serviceType/careServiceDetails"); mv.addObject("serviceTypelist",
	 * getServiceTypelist()); return mv; }
	 

	*//**
	 * 
	 * @param cServiceManagerVo
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 *//*
	
	 * @RequestMapping(value = "addOrUpdate") public ModelAndView
	 * saveOrUpdate(CServiceManagerVO cServiceManagerVo,@RequestParam(value =
	 * "file", required = false) MultipartFile[] file)throws
	 * IllegalAccessException, InvocationTargetException { ModelAndView mv = new
	 * ModelAndView("redirect:/care/serviceType/serviceList"); Integer id =
	 * cServiceManagerVo.getId(); OCategoryItem oCategoryItem =null; String
	 * path=this.uploadFile(5, file); if (id == null) { CServiceManager
	 * cServiceManager = new CServiceManager(); oCategoryItem =
	 * categoryItemService.getOCategoryItemById(cServiceManagerVo.getCategoryId(
	 * )); cServiceManager.setAvailable(true); cServiceManager.setCreatedAt(new
	 * Date()); cServiceManager.setoCategoryItem(oCategoryItem); if(path!=null)
	 * cServiceManager.setCoverPath(path);
	 * BeanUtils.copyProperties(cServiceManager, cServiceManagerVo);
	 * cServiceManagerService.saveOrUpdate(cServiceManager); } else {
	 * CServiceManager old = cServiceManagerService .getServiceManagerById(id);
	 * //逻辑删除数据 if(cServiceManagerVo.getOperateType().equals(2)){
	 * old.setAvailable(false); }else{ //判断是否修改了分类类型
	 * if(!old.getoCategoryItem().getId().equals(cServiceManagerVo.getId())){
	 * oCategoryItem =
	 * categoryItemService.getOCategoryItemById(cServiceManagerVo.getCategoryId(
	 * )); old.setoCategoryItem(oCategoryItem); } if(path!=null)
	 * old.setCoverPath(path); old.setChangedAt(new Date());
	 * BeanUtils.copyProperties(old, cServiceManagerVo); }
	 * cServiceManagerService.saveOrUpdate(old); } // mv.addObject("msg",
	 * "success");
	 * 
	 * return mv; }
	 

	*//**
	 * 获取关爱服务商服务类型详情
	 * 
	 * @param id
	 *            关爱服务商服务类型
	 * @param operateType
	 *            1:修改 2:删除
	 * @return
	 *//*
	
	 * @RequestMapping(value = "details") public ModelAndView
	 * getVendorEvaluationById(Integer id,Integer operateType) { CServiceManager
	 * CServiceManager = cServiceManagerService .getServiceManagerById(id);
	 * ModelAndView mv = new ModelAndView(
	 * "/care/serviceType/careServiceDetails"); mv.addObject("details",
	 * CServiceManager); mv.addObject("serviceTypelist", getServiceTypelist());
	 * mv.addObject("operateType", operateType); return mv; }
	 

	*//**
	 * 获取关爱服务商 服务类型
	 * 
	 * @param type
	 *            1:进入服务商服务类型列表 2:进入到订购服务列表也 默认进入服务类型管理页
	 * @param userId
	 *            callCenter 用户下单时候纪录被下单用ID
	 * @return
	 *//*
	@RequestMapping(value = "serviceList")
	public ModelAndView listServiceType(PageParamVO pageVO, Integer type, Long userId, Boolean isJson,
			String callback) {
		// Page<CServiceManager> result =
		// cServiceManagerService.getAllServiceManager(pageVO);
		ModelAndView mv = null;
		String url = "/care/serviceType/orderServiceTypeList";

		mv = new ModelAndView(url);
		// mv.addObject("page", result);
		mv.addObject("userId", userId);
		mv.addObject("type", type);
		return mv;
	}

	@RequestMapping(value = "service")
	public ModelAndView serviceType(PageParamVO pageVO, Long userId) {
		// Page<CServiceManager> result =
		// cServiceManagerService.getAllServiceManager(pageVO);
		ModelAndView mv = new ModelAndView("/care/serviceType/orderServiceTypeList");
		// mv.addObject("page", result);
		mv.addObject("userId", userId);
		return mv;
	}

}
*/