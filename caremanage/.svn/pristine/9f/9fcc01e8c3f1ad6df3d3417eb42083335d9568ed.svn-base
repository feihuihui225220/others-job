package com.anticw.aged.controller.icare;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZAssess;
import com.anticw.aged.service.icare.ZAssessService;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/icare/assess/")
public class ZAssessCtl {
	@Autowired
	private ZAssessService zAssessService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAddPage")
	public String  toAddPage(){
		return "";
	}
	
	/**
	 * 查询一个评估问卷详情TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getAssessById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("Assess", zAssessService.getAssessById(id) );
		return "";
	}
	/**
	 * 添加评估
	 *@param ZAssess
	 *@return
	 */
	@RequestMapping("add")
	public String addAssess(ZAssess ZAssess){
		zAssessService.addAssess(ZAssess);
		return "";
	}
	/**
	 * 删除评估
	 *@param ZAssess
	 *@return
	 */
	@RequestMapping("remove/{id}")
	public String  removeAssess(@PathVariable("id")int id){
		zAssessService.removeAssess(id);
		return "";
	}
	/**
	 * 修改评估TODO
	 *@param ZAssess
	 */
	@RequestMapping("modify")
	public String modifyAssess(ZAssess zAssess){
		zAssessService.modifyAssess(zAssess);
		return "";
	}
	/**
	 * 查询所有有效的评估
	 *@param page
	 *@param num
	 *@return
	 */
	@RequestMapping("getList")
	public String getAssessList(int page, int num,HttpServletRequest request) {
		request.setAttribute("assesss", zAssessService.getAssessList(page, num));
		return "";
	}
	
	/**
	 * 查询所有有效的评估
	 *@param page
	 *@param num
	 *@return
	 *//*
	@RequestMapping("getList/{parentId}")
	public String getAssessListByParentId(int page, int num,@PathVariable("parentId")Integer parentId,
			HttpServletRequest request) {
		//request.setAttribute("assesss", zAssessService.getAssessListByCategory(page, num,parentId));
		return "";
	}*/

}
