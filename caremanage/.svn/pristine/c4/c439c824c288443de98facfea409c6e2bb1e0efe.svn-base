package com.anticw.aged.controller.director;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.HVisitPlan;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.admin.CategoryRoundsServicec;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.director.VisitPlanService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.director.DirectorUserVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.user.RUserVO;

/**
 * 作者：bsd
 * 日期：2016-9-13
 * 功能：用户计划管理
 */
@Controller
@RequestMapping("/visit/")
public class VisitPlanController {
	@Autowired
	private VisitPlanService visitPlanService;
	@Autowired
	private CategoryRoundsServicec categoryRoundsServicec;
	/**
	 * 用户信息管理
	 */
	@Autowired
	private RUserService rUserService;
	/**
	 * TODO巡诊组查询所有人的计划
	 *@param session
	 *@param request
	 *@return
	 */
	@RequestMapping("planByGroupId")
	public String visitPlanByGroupId(HttpSession session,HttpServletRequest request){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		request.setAttribute("plan", visitPlanService.getHVisitPlanByGroupId(userVO.getId()));
		return "/director/visitplan/visit_plan";
	}
	/**
	 * TODO巡诊组查询一个人的计划
	 *@param session
	 *@param request
	 *@return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("planByUserId")
	public String visitPlanByUserId(HttpSession session,long userId,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException{
		RUser user = rUserService.findById(userId);
		DirectorUserVO dirUser = new DirectorUserVO();
		BeanUtils.copyProperties(dirUser, user);
		dirUser.setMedicalHistory(user.getrUserDefault().getMedicalHistory());
		dirUser.setAllergy(user.getrUserDefault().getAllergy());
		session.setAttribute("dirUser", dirUser);
		request.setAttribute("userId", userId);
		request.setAttribute("plan", visitPlanService.getHVisitPlanByUserId(userId));
		return "/director/visitplan/visit_plan";
	}
	/**
	 * TODO巡诊组查询一个人的计划
	 *@param session
	 *@param request
	 *@return
	 */
	@RequestMapping("planByUserIdHis")
	public String planByUserIdHis(long userId,HttpServletRequest request){
		request.setAttribute("userId", userId);
		request.setAttribute("plan", visitPlanService.getHVisitPlanByUserId(userId));
		return "/director/visitplan/visit_history";
	}
	
	@RequestMapping("plan/add")
	public String toAddVisitPlan(HttpSession session,HttpServletRequest request){
		//查询上门服务的分类
		request.setAttribute("catetory", categoryRoundsServicec.list(0));
		String userId =  request.getParameter("userId");
		request.setAttribute("userId", userId);
		return "/director/visitplan/visit_add";
	}
	/**
	 * TODO添加服务计划
	 *@param session
	 *@param request
	 *@param hVisitPlan
	 *@param visitTime
	 *@return
	 */
	@RequestMapping("plan/added")
	public String addVisitPlan(HttpSession session,HttpServletRequest request,
			HVisitPlan hVisitPlan,String time,long userId){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		hVisitPlan.setCreateBy(userVO.getName());
		hVisitPlan.setGroupId(userVO.getId());
		RUser user = new RUser();
		user.setId(userId);
		hVisitPlan.setUser(user);
		hVisitPlan.setVisitTime(DateUtil.parseStrToDateTimem(time));
		visitPlanService.addHVisitPlan(hVisitPlan);
		//查询上门服务的分类
		request.setAttribute("catetory", categoryRoundsServicec.list(0));
		return "redirect:/visit/planByUserId?userId="+ userId;
	}
	/**
	 * 主任对该巡诊组下所有人计划管理
	 *@param session
	 *@param request
	 *@return
	 */
	@RequestMapping("planlist")
	public String visitPlanList(HttpServletRequest request){
		Map<Date,String> list = visitPlanService.getHVisitPlan();
		request.setAttribute("plan",list);
		return "/director/visitplan/visit_manage";
	}
	/**
	 * TODO根据日期查询用户
	 *@param request
	 *@param date
	 *@return
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("planlistDay")
	@ResponseBody
	public List<RUserVO> visitPlanListBydate(HttpServletRequest request, long date) throws IllegalAccessException, Exception{
		List<RUserVO> list = visitPlanService.getHVisitPlanByDate(date);
		return list;
	}
	
	@RequestMapping("getuserPlan")
	public String getPlanByDateAndUserId(HttpServletRequest request,Integer id){
		Map<String,HVisitPlan> list = visitPlanService.getPlanByDateAndUserId(id);
		request.setAttribute("plan", list);
		return "/director/visitplan/visit_plan_detail";
	}
}
