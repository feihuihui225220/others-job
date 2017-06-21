package com.anticw.aged.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MStateCategory;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.StatueCategoryService;

/**
 * 状态相关请求控制器
 * <P>File name : StatueCategoryController.java </P>
 * <P>Author : bsd </P> 
 * <P>Date : 2014-10-02 </P>
 */
@RequestMapping(value="/admin")
@Controller
public class StatueCategoryController {
	
	@Autowired
	private StatueCategoryService  statueCategoryService;	
	@Autowired
	private SpringDataPool springDataPool;
	
	/**
	 * 获取状态选项列表
	 */
	@RequestMapping(value="findStatueCategory")
	public ModelAndView list(int parentId){	
		List<MStateCategory> lm = statueCategoryService.list(0);
		if(parentId==0){
		 parentId= 1;	
		}
		List<MStateCategory> vo = statueCategoryService.list(parentId);
		ModelAndView mv = new ModelAndView("admin/categoryitemstate");
		mv.addObject("statueCategory",lm);
		mv.addObject("statueCategoryValue",vo);
		mv.addObject("parentId", parentId);
		return mv;
	}
	
	/**
	 *  添加状态选项值
	 * @param stateCategory
	 * @param id
	 * @param request
	 * @return
	 */

	@RequestMapping(value="addStatueType")
	public ModelAndView insertStatueCategoryValue(MStateCategory stateCategory,int parentId,HttpServletRequest request){
		if(stateCategory.getChangedBy()==null){
			stateCategory.setChangedBy("");
		}else if(stateCategory.getParentId()==null){
			stateCategory.setParentId(0);
		}
		statueCategoryService.insertStatueCategoryValue(stateCategory,parentId);
		springDataPool.initOCategoryItemMap();
		request.setAttribute("parentId", parentId);
		ModelAndView mv = new ModelAndView("redirect:findStatueCategory?parentId="+parentId);
		return mv;
	}
	
	/**
	 * 根据Id删除知识库详细内容
	 * @param id
	 * @param request
	 * @return
	 */
	 
	@RequestMapping(value="delStatueCategoryById")
	public String delStatueCategory(int id,HttpServletRequest request){
		statueCategoryService.delStatueCategoryById(id);
		return "/admin/delStatueCategoryById";
	}
	
	/** 
	 * 编辑类型值
	 * @param stateCategory
	 * @param request
	 * @return
	 */
	@RequestMapping(value="editStatueCategoryById")
	public ModelAndView editStatueCategory(MStateCategory stateCategory, Integer parentId,HttpServletRequest request){
		statueCategoryService.editStatueCategory(stateCategory);
		springDataPool.initOCategoryItemMap();
		ModelAndView mv = new ModelAndView("redirect:findStatueCategory");
		mv.addObject("parentId", parentId);
		mv.addObject("msg","修改成功");
		return mv;
	}
	
}
