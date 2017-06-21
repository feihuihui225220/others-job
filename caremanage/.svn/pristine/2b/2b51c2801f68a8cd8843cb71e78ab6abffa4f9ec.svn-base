package com.anticw.aged.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.HVisitCategory;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.CategoryRoundsServicec;

@RequestMapping(value = "/admin")
@Controller
public class CategoryRoundsController {

	  @Autowired
	  private CategoryRoundsServicec categoryRoundsServicec;
	  @Autowired
		private SpringDataPool springDataPool;
	  /*
	   * 所有分类 巡诊
	   */
	  @RequestMapping(value = "findCategoryRounds")
	  public ModelAndView list(int parentId){	
			List<HVisitCategory> lm = categoryRoundsServicec.list(0);
			if(parentId==0){
				parentId= 1;	
			}
			List<HVisitCategory> vo = categoryRoundsServicec.list(parentId);
			ModelAndView mv = new ModelAndView("admin/categoryitemrounds");
			mv.addObject("planCategory",lm);
			mv.addObject("planCategoryValue",vo);
			mv.addObject("parentId", parentId);
			return mv;
	  }
	  /**
	   * 添加巡诊分类
	   */
	  @RequestMapping(value="addHVisit")
	  public ModelAndView insertStatueCategoryValue(HVisitCategory stateCategory,int parentId,HttpServletRequest request){
			if(stateCategory.getChangedBy()==null){
				stateCategory.setChangedBy("");
			}
			categoryRoundsServicec.insertPlanCategoryValue(stateCategory,parentId);
			springDataPool.initOCategoryItemMap();
			request.setAttribute("parentId", parentId);
			ModelAndView mv = new ModelAndView("redirect:findCategoryRounds?parentId="+parentId);
			return mv;
		}
	  /** 
		 * 编辑类型值
		 * @param stateCategory
		 * @param request
		 * @return
		 */
	  @RequestMapping(value="editHVisitCategoryById")
	  public ModelAndView editPlanCategory(HVisitCategory stateCategory, Integer parentId,HttpServletRequest request){
		  categoryRoundsServicec.editPlanCategory(stateCategory);
			springDataPool.initOCategoryItemMap();
			ModelAndView mv = new ModelAndView("redirect:findCategoryRounds");
			mv.addObject("parentId", parentId);
			return mv;
		}
	/* 
	  @RequestMapping(value="editHVisitCategoryById")
	  public ModelAndView editHVisitCategoryById(Integer parentId,HVisitCategory hVisitCategory,HttpServletRequest request){
		  ModelAndView view=null; 
		  categoryRoundsServicec.editPlanCategory(hVisitCategory);
			springDataPool.initOCategoryItemMap();
			ModelAndView mv = new ModelAndView("redirect:findPlanCategory");
			mv.addObject("parentId", parentId);
		  return view;
	  }*/
	  
	  /*
	   * 所有分类 巡诊
	   */
	  @RequestMapping("getCategory/{parentId}")
	  public  @ResponseBody JSONObject  getCategoryByParentId(@PathVariable int parentId){	
	    List<HVisitCategory> vc = categoryRoundsServicec.list(parentId);
	    JSONObject json = new JSONObject();
	    json.put("category", vc);
	    return json; 
	  }
}
