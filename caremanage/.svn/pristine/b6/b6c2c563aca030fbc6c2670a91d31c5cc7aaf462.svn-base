package com.anticw.aged.controller.director;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.director.GroupService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-9-16
 * 功能：巡诊组管理控制层
 */
@Controller
@RequestMapping("/group/")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	@Autowired
	private VenderService  venderService; 
	@Autowired
	private OCountryService oCountryService; 
	
	/**
	 * 跳转到添加巡诊组页面
	 *@return
	 */
	@RequestMapping("toAdd")
	public String toAddGroup(HttpSession session,HttpServletRequest request){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		AUser user=venderService.getAUser((int)userVO.getId());
		List<OCountry> oCountry=oCountryService.getCountryByIds(user.getCommunityIds());
		request.setAttribute("oCountry", oCountry);
		return "/director/group/add";
	}
	/**
	 * 添加巡诊组TODO
	 *@param hGroup
	 *@return
	 */
	@RequestMapping("add")
	public ModelAndView  addGroup(HttpSession session,HGroup hGroup){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		hGroup.setUserId((int)userVO.getId());
		hGroup.setCreateBy(userVO.getName());
		hGroup.setChangeBy(userVO.getName());
		groupService.addGroup(hGroup);
		return new ModelAndView(new RedirectView("/group/findAll"));
	}
	/**
	 * 跳转到编辑巡诊组页面
	 *@param hGroup
	 *@return
	 */
	@RequestMapping("toEdit")
	public String toEditGroup(){
		return "/director/group/edit";
	}
	/**
	 * 编辑巡诊组TODO
	 *@param hGroup
	 *@return
	 */
	@RequestMapping("edit")
	public ModelAndView editGroup(HttpSession session,HGroup hGroup){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(hGroup.getCommunity()!=null){
			String i=hGroup.getCommunity().substring(0, 1);
			if(i.equals(",")){
				String com=hGroup.getCommunity();
				hGroup.setCommunity(com.substring(1, com.length()));
			}
		}
		hGroup.setCreateBy(userVO.getName());
		hGroup.setChangeBy(userVO.getName());
		groupService.editGroup(hGroup);
		return new ModelAndView(new RedirectView("/group/findAll"));
	}
	/**
	 * 查询所有巡诊组TODO
	 *@param request
	 *@return
	 */
	@RequestMapping("findAll")
	public String findGroup(HttpSession session,HttpServletRequest request,PageParamVO page){
		
		request.setAttribute("page", groupService.findGroupAll(page));
		
		return "/director/group/listAll";
	}
	/**
	 * TODO根据id查询一个巡诊组内容
	 *@param id
	 *@param request
	 *@return
	 */
	@RequestMapping("findById")
	public String findGroupById(HttpSession session,int id ,HttpServletRequest request){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		AUser user=venderService.getAUser((int)userVO.getId());
		List<OCountry> oCountry=oCountryService.getCountryByIds(user.getCommunityIds());
		request.setAttribute("group", groupService.findGroupById(id));
		request.setAttribute("oCountry", oCountry);
		return "/director/group/edit";
	}
	/**
	 * 物理删除知识库TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("delById")
	public ModelAndView delGroupById(int id) {
		groupService.delGroupBy(id);
		return new ModelAndView(new RedirectView("/group/findAll"));
	}

	/**
	 * 物理删除知识库TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("del")
	public String delGroupBy(int id) {
		groupService.delGroupById(id);
		return "";
	}
	/**
	 * 根据用户ID查询巡诊组名称
	 */
	@RequestMapping("findByUserId")
	@ResponseBody
	public String findByUserId(Integer userId) {
		String result=groupService.findByUserId(userId).get(0).getUserName();
		return result;				
	}
}
