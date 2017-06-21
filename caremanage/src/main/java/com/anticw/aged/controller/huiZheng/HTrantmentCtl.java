package com.anticw.aged.controller.huiZheng;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.HTreatment;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.huiZheng.HTreatmentService;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("trant")
public class HTrantmentCtl {

	@Autowired
	private HTreatmentService hTreatmentService;
	@Autowired
	private RUserService rUserService;
	/**
	 * 评估页面
	 * 
	 */
	@RequestMapping("trant")
	public String trant(Long userId, HttpServletRequest request) {
		RUser user = rUserService.findById(userId);
		request.setAttribute("user", user);
		return "/huiZheng/list";
	}
	/**
	 * 添加
	 * 
	 */
	@RequestMapping("added")
	public String insertHTreatment(HttpSession session, HTreatment hTreatment,
			Long userId, HttpServletRequest request)throws IllegalAccessException, InvocationTargetException {
		request.setAttribute("userId", userId);
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		hTreatment.setCreateBy(userVO.getName());
		hTreatment.setStartTime(Date.valueOf(request
				.getParameter("start_time")));
		hTreatment.setEndTime(Date.valueOf(request
				.getParameter("end_time")));
		RUser user = rUserService.findById(userId);
		hTreatment.setUser(user);
		hTreatmentService.insertTreat(hTreatment);
		return "redirect:/trant/trant" ;// 添加后跳转入添加页面
	}
//   ==========查询所有==================================================	
	@RequestMapping("list")
	public ModelAndView listResult(Long userId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/huiZheng/list");
		/*List<HTreatment> result = hTreatmentService.listResult(userId);
		mav.addObject("list", result);*/
		return mav;
	}
//  ============删除======================================================
	@RequestMapping("delete")
	public ModelAndView delete(Integer resultId) {
		ModelAndView mav = new ModelAndView("professional/health/treatlist");
		hTreatmentService.delete(resultId);
		return mav;
	}
//  ============更新======================================================
	/**
	 * 评估页面
	 * 
	 */
	@RequestMapping("edit")
	public String edits(Integer resultId, HttpServletRequest request) {
		List<HTreatment> t= hTreatmentService.findById(resultId);
		HTreatment h = t.get(0);
		request.setAttribute("h", h);
		return "professional/health/edit";
	}
	@RequestMapping("update")	
	public String edit(HttpSession session, HTreatment hTreatment, HttpServletRequest request){
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String userId = userVo.getParentName();
		hTreatment.setChangeBy(userId);
		hTreatmentService.edit(hTreatment);
		return "redirect:/trant/list" ;// 添加后跳转入添加页面
	}
}
