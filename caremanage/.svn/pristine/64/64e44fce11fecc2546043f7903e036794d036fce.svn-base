package com.anticw.aged.controller.professional.activity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NVolunteerAssess;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.professional.activity.NActivityPlanService;
import com.anticw.aged.service.professional.activity.NVolunteerAssessService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("/nVolunteerAssess")
public class VolunteerAssessCtl {
	@Autowired
	private NVolunteerAssessService nVolunteerAssessService;
	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private NActivityPlanService nActivityPlanService;

	/**
	 * 添加志愿者量表
	 * 
	 * @param nVolunteerAssess
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView addNVolunteerAssess(HttpSession session,
			NVolunteerAssess nVolunteerAssess, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = null;
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if (userVo != null) {
			userVo.getId();
			nVolunteerAssess.setVolunteer((int) userVo.getId());
			nVolunteerAssess.setnSuper((short) 1);
			mv = new ModelAndView(new RedirectView(
					"/nVolunteerAssess/palvelutietue"));
		} else {
			mv = new ModelAndView("/professional/activity/volunteer/achieve");
			nVolunteerAssess.setnSuper((short) 0);
			mv.addObject("volunteer", nVolunteerAssess.getVolunteer());
		}
		nVolunteerAssessService.addNVolunteerAssess(nVolunteerAssess);
		return mv;
	}

	/**
	 * 修改志愿者量表
	 * 
	 * @param nVolunteerAssess
	 * @param request
	 * @param response
	 */
	@RequestMapping("/update")
	public String updateVolunteerAssess(NVolunteerAssess nVolunteerAssess,
			HttpServletRequest request, HttpServletResponse response) {
		nVolunteerAssessService.updateNVolunteerAssess(nVolunteerAssess);
		return "redirect:/nVolunteerAssess/palvelutietue";
	}

	/**
	 * 分页查看
	 * 
	 * @param session
	 * @param page
	 * @param name
	 * @param data
	 * @param siteId
	 * @return
	 */
	@RequestMapping("/palvelutietue")
	public ModelAndView palvelutietue(HttpSession session, PageParamVO page,
			String name, String data, Integer siteId) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/palvelutietue");
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<Object[]> pages = nVolunteerAssessService.getPage(name, data,
				siteId, page.getPage(), page.getNum());
		List<MVenderSite> sites = mVenderSiteService.fingByVenderId(userVo
				.getVenderId());
		mv.addObject("page", pages);
		mv.addObject("sites", sites);
		mv.addObject("siteId", siteId);
		mv.addObject("name", name);
		mv.addObject("data", data);
		return mv;
	}

	/**
	 * 查询一条信息
	 *  
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectById")
	public ModelAndView selectById(HttpSession session, Long id,String activity,String date) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/selectAssess");
		mv.addObject("nVolunteerAssess", nVolunteerAssessService.getById(id));
		mv.addObject("activity", activity);
		mv.addObject("date", date);
		return mv;
	}

	/**
	 * 去修改页
	 * 
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/ToUpdate")
	public ModelAndView ToUpdate(HttpSession session, Long id) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/updateAssess");
		NVolunteerAssess nassess = nVolunteerAssessService.getById(id);
		mv.addObject("nVolunteerAssess", nassess);
		NActivityPlan plan = nActivityPlanService.get(nassess.getActivityId());
		String siteId = plan.getSiteIds();
		NActivityPlan np = nActivityPlanService.getNext(
				nassess.getActivityId(), Integer.parseInt(siteId));
		mv.addObject("nextNActivityPlan", np);
		return mv;
	}

	/**
	 * 员工添加量表
	 * 
	 * @param planId
	 * @return
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(Integer planId) {
		ModelAndView mv = new ModelAndView(
				"/professional/activity/volunteer/addVassess");
		mv.addObject("planId", planId);
		String siteId = nActivityPlanService.get(planId).getSiteIds();
		NActivityPlan np = nActivityPlanService.getNext(planId,
				Integer.parseInt(siteId));
		mv.addObject("nextNActivityPlan", np);
		return mv;
	}

	/**
	 * 验证量表
	 * 
	 * @param date
	 * @param siteId
	 * @return
	 */
	@RequestMapping("toChecksum")
	public @ResponseBody Integer getChecksum(String date, Integer siteId) {
		NActivityPlan n = nActivityPlanService.getNActivityPlan(date, siteId);
		if (n == null) {
			return 0;// 表示活动不存在
		}
		int count = nVolunteerAssessService.getCound(n.getId());
		if (count > 0) {
			return -1;// 表示量表已经回答
		}
		return n.getId();
	}
	@RequestMapping("toChecksum_")
	public @ResponseBody Integer toChecksum_( Integer planId) {
		
		NActivityPlan np=nActivityPlanService.get(planId);
		NActivityPlan n = nActivityPlanService.getNActivityPlan(DateUtil.parseDateToString(np.getPubdate(), "yyyy-MM-dd"), Integer.parseInt(np.getSiteIds()));
		if (n == null) {
			return 0;// 表示活动不存在
		}
		int count = nVolunteerAssessService.getCound(n.getId());
		if (count > 0) {
			return -1;// 表示量表已经回答
		}
		return n.getId();
	}

}
