package com.anticw.aged.controller.huiZheng;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.huiZheng.HConsultationService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.DirectorUserVO;
import com.anticw.aged.vo.director.HConsultationVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("consu")
public class HConsultationCtl {

	@Autowired
	private HConsultationService hConsultationService;
	@Autowired
	private RUserService rUserService;
	@Autowired
	private VenderService venderService; 
	/**
	 * 评估页面
	 * 
	 */
	@RequestMapping("consu")
	public String goToPage(Long userId, HttpServletRequest request) {
		RUser user = rUserService.findById(userId);
		request.setAttribute("user", user);
		return "huiZheng/add";
	}
	
	@RequestMapping("toedit")
	public String gettoedit(int userId, HttpServletRequest request){
		request.setAttribute("userId", userId);
		return "/director/consu/edit";
	}
	
	@RequestMapping("addhConsu")
	public ModelAndView save(HttpSession session, HConsultation hConsultation,Long userId) throws IllegalAccessException, InvocationTargetException{
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
			RUser user = rUserService.findById(userId);
			hConsultation.setState("0");
			hConsultation.setUser(user);
			if(userVO.isSuper_()){
				List<AUser> ausers=venderService.getList(userVO.getVenderId());
				if(ausers.size()!=0){
					hConsultation.setGroupId((int)ausers.get(0).getId());
				}
			}else{
				hConsultation.setGroupId((int)userVO.getId());
			}
			hConsultation.setCreateTime(new java.util.Date());
			hConsultation.setCreateBy(userVO.getName());
			hConsultationService.insertTreat(hConsultation);
			//申请会诊，改变r_user表中的状态
			user.setState(4);
			try {
				rUserService.update(user);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return new ModelAndView(new RedirectView("/consu/pageResult?userId="+hConsultation.getUser().getId()));
	
		
	}
	/**
	 * 用户修改会诊信息
	 * @throws ParseException 
	 */
	@RequestMapping("modifyHConsulation")
	public ModelAndView modifyHConsulation( HConsultation hConsultation,String applyTimes) throws ParseException{
			HConsultation hc=hConsultationService.getHConsultation(hConsultation.getId());
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			hc.setApplyTime(dateFormat.parse(applyTimes));
			hc.setDepartment(hConsultation.getDepartment());
			hc.setAddress(hConsultation.getAddress());
			hConsultationService.modifyHConsultation(hc);
			return new ModelAndView(new RedirectView("/director/user?userId="+hc.getUser().getId()));
	}
	/**
	 * 用户查看会诊信息
	 * @param userId
	 * @param page
	 * @param dateCond
	 * @param desc
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("pageResult")
	public ModelAndView pageResult(HttpSession session,Long userId,PageParamVO page,DateParamVO dateCond,Integer desc) throws IllegalAccessException, InvocationTargetException{
		
		ModelAndView mv=new ModelAndView("/director/consu/consuUser");
		if(dateCond.getEnd()==null||dateCond.getStart()==null){
			java.util.Date date=new  java.util.Date();
			dateCond.setStart(DateUtil.getFirstDayInMonth(date));	
			dateCond.setEnd(DateUtil.getLastDayInMonth(date)); 
		}
		RUser user = rUserService.findById(Long.valueOf(userId));
		DirectorUserVO dirUser = new DirectorUserVO();
		BeanUtils.copyProperties(dirUser, user);
		dirUser.setMedicalHistory(user.getrUserDefault().getMedicalHistory());
		dirUser.setAllergy(user.getrUserDefault().getAllergy());
		session.setAttribute("dirUser", dirUser);
		Page<HConsultationVO> vos=hConsultationService.listResult(userId, page, dateCond, desc);
		mv.addObject("page", vos);
		mv.addObject("dateCond", dateCond);
		mv.addObject("desc", desc);
		return mv;
		
	}
	/**
	 * 添加会诊结果
	 * @param id
	 * @param ultimateness
	 * @return
	 */
	@RequestMapping("/addHConsultation")
	public String addHConsultation(Integer id,String ultimateness){
		//根据ID 查询HCconsultation
		HConsultation consultation=hConsultationService.findById(id);
		consultation.setUltimateness(ultimateness);
		consultation.setState("2");
		try {
			hConsultationService.update(consultation);
			RUser user = rUserService.findById(consultation.getUser().getId());
			user.setState(1);
			rUserService.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/consu/pageResult?userId="+consultation.getUser().getId();
	}
	/**
	 * 添加
	 * 
	 */
	@RequestMapping("added")
	public String insertHTreatment(HttpSession session, HConsultation hConsultation,
			Long userId, HttpServletRequest request)throws IllegalAccessException, InvocationTargetException {
		request.setAttribute("userId", userId);
		/*UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		hConsultation.setCreateBy(userVO.getName());*/
		hConsultation.setStartTime(Date.valueOf(request
				.getParameter("start_time")));
		hConsultation.setEndTime(Date.valueOf(request
				.getParameter("end_time")));
		RUser user = rUserService.findById(userId);
		hConsultation.setUser(user);
		hConsultationService.insertTreat(hConsultation);
		return "redirect:/trant/trant" ;// 添加后跳转入添加页面
	}
//   ==========查询所有==================================================	
	@RequestMapping("list")
	public ModelAndView listResult(Long userId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("huiZheng/list");
		List<HConsultation> result = hConsultationService.listResult(userId);
		mav.addObject("list", result);
		return mav;
	}
//  ============删除======================================================
	@RequestMapping("delete")
	public ModelAndView delete(Integer resultId) {
		ModelAndView mav = new ModelAndView("professional/health/treatlist");
		hConsultationService.delete(resultId);
		return mav;
	}
//  ============更新======================================================
	/**
	 * 评估页面
	 * 
	 */
	@RequestMapping("edit")
	public String edits(Integer resultId, HttpServletRequest request) {
		HConsultation h= hConsultationService.findById(resultId);
		request.setAttribute("h", h);
		return "professional/health/edit";
	}
	@RequestMapping("update")	
	public String edit(HttpSession session, HConsultation hConsultation, HttpServletRequest request){
		/*UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String userId = userVo.getParentName();
		hConsultation.setChangeBy(userId);*/
		hConsultationService.edit(hConsultation);
		return "redirect:/trant/list" ;// 添加后跳转入添加页面
	}
}
