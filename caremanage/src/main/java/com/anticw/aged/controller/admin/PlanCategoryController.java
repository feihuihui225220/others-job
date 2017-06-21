package com.anticw.aged.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MPlanCategory;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.PlanCategoryService;

/**
 * 计划相关请求控制器
 * <P>File name : StatueCategoryController.java </P>
 * <P>Author : bsd </P> 
 * <P>Date : 2014-10-02 </P>
 */
@RequestMapping(value="/admin")
@Controller
public class PlanCategoryController {
	
	@Autowired
	private PlanCategoryService  planCategoryService;	
	@Autowired
	private SpringDataPool springDataPool;
	
	/**
	 * 获取计划选项列表
	 */
	@RequestMapping(value="findPlanCategory")
	public ModelAndView list(int parentId){	
		List<MPlanCategory> lm = planCategoryService.list(0);
		if(parentId==0){
		 parentId= 1;	
		}
		List<MPlanCategory> vo = planCategoryService.list(parentId);
		ModelAndView mv = new ModelAndView("admin/categoryitemplan");
		mv.addObject("planCategory",lm);
		mv.addObject("planCategoryValue",vo);
		mv.addObject("parentId", parentId);
		return mv;
	}
	
	/**
	 *  添加计划选项值
	 * @param stateCategory
	 * @param id
	 * @param request
	 * @return
	 */

	@RequestMapping(value="addPlanType")
	public ModelAndView insertStatueCategoryValue(MPlanCategory stateCategory,int parentId,HttpServletRequest request){
		if(stateCategory.getChangedBy()==null){
			stateCategory.setChangedBy("");
		}else if(stateCategory.getParentPlanCategory()==null){
			stateCategory.setParentPlanCategory(this.planCategoryService.getMPlanCategoryById(0));
		}
		planCategoryService.insertPlanCategoryValue(stateCategory,parentId);
		springDataPool.initOCategoryItemMap();
		request.setAttribute("parentId", parentId);
		ModelAndView mv = new ModelAndView("redirect:findPlanCategory?parentId="+parentId);
		return mv;
	}
	
	/**
	 * 根据Id删除计划类型
	 * @param id
	 * @param request
	 * @return
	 */
	 
	@RequestMapping(value="delPlanCategoryById")
	public String delStatueCategory(int id,HttpServletRequest request){
		planCategoryService.delPlanCategoryById(id);
		return "/admin/delPlanCategoryById";
	}
	
	/** 
	 * 编辑类型值
	 * @param stateCategory
	 * @param request
	 * @return
	 */
	@RequestMapping(value="editPlanCategoryById")
	public ModelAndView editPlanCategory(MPlanCategory stateCategory, Integer parentId,HttpServletRequest request){
		planCategoryService.editPlanCategory(stateCategory);
		springDataPool.initOCategoryItemMap();
		ModelAndView mv = new ModelAndView("redirect:findPlanCategory");
		mv.addObject("parentId", parentId);
		return mv;
	}
	
}
