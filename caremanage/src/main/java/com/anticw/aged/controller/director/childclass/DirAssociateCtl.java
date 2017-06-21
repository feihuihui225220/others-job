package com.anticw.aged.controller.director.childclass;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.bean.HGroupUser;
import com.anticw.aged.bean.HVisitPlan;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.director.HGroupUserService;
import com.anticw.aged.service.director.VisitPlanService;
import com.anticw.aged.service.huiZheng.HConsultationService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author DX-2016-09-14f
 * ｛执行主任｝员工操作用户信息
 */
@Controller
public class DirAssociateCtl {
	
	@Autowired
	private VisitPlanService visitPlanService;
	
	@Autowired
	private VenderService venderService;
	
	@Autowired
	private HConsultationService hConsultationService;
	
	@Autowired
	private HGroupUserService hGroupUserService; 
	/**
	 * 巡诊组查看今日计划
	 * @return
	 */
	@RequestMapping("director/dirAssociate/plan")
	public ModelAndView getPlan(HttpSession session,Integer status,Date createdDate, PageParamVO page){
		
		UserVO userVO = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv=new ModelAndView("director/dirAssociate/plan");
		if(createdDate==null){
			createdDate=new Date();
		}
		Date dateGet=new Date();
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +2);//+1今天的时间加一天
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        dateGet = calendar.getTime();
        String str=sdf.format(date);
        String strs=sdf.format(dateGet);
		AUser user=null;
		//缺少员工类  缺少巡视组与患者交互类  暂时不用
		user=venderService.getAUser((int)userVO.getId());
		Page<HVisitPlan> pages=visitPlanService.getHVisitPlanByDateAndGroupId(str,strs,user.getId(),status,page);
		List<HConsultation> hConsultations=hConsultationService.getHConsultationByDateAndGroupId(createdDate,user.getId());
		mv.addObject("page", pages);
		if(status==null){
			status=99;
		}
		mv.addObject("status", status);
		mv.addObject("createdDate", createdDate);
		mv.addObject("hConsultations", hConsultations);
		return mv;
	}
	
	/*@RequestMapping("/director/dirAssociate/users")
	public ModelAndView getUserlist(HttpSession session,PageParamVO page,Integer groupId,
			Integer states,Integer age,String idCardNo,String communityId,Date changedAt,Integer choose,String name,Date createdDate){
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv=null;
		if(choose==null){
			choose=-1;
		}
		Page<HGroupUser> ruser=hGroupUserService.getUser(page, groupId, states,age, idCardNo, communityId, changedAt, choose, name,createdDate);		
		 mv=new ModelAndView("/director/dirAssociate/userlist");
		mv.addObject("page", ruser);
		mv.addObject("createdDate", createdDate);
		mv.addObject("states", states);
		return mv;
	}*/
	@RequestMapping("/director/dirAssociate/users")	
	public ModelAndView getUserlist(HttpSession session,PageParamVO page,Integer status,String start,String end,String userName){	
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv=new ModelAndView("/director/dirAssociate/userlist");
		if(!userVo.isSuper_()){
			if(userName==null||userName.length()<=0){
				if(("").equals(start)){
					start=null;					
				}
				if(("").equals(end)){
					end=null;					
				}
			}
			Page<HGroupUser> ruser=hGroupUserService.getUserlist(page,userVo.getId(),status,start,end,userName);		
			mv.addObject("page", ruser);
			if(status==null){
				status=99;
			}
			mv.addObject("status", status);
			mv.addObject("start",start);
			mv.addObject("end",end);
			mv.addObject("userName",userName);
		}
		return mv;
	}
	
}
