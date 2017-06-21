package com.anticw.aged.controller.director;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.HTreatUser;
import com.anticw.aged.service.director.HTreatUserServer;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 
 * @author DX-2016/6/26
 *
 */
@Controller
public class HTreatUserCtl {
	
	@Autowired
	private  HTreatUserServer hTreatUserServer;
	
	@RequestMapping("/director/htreatuser/page")
	public  ModelAndView getPage(PageParamVO page,Long userId,DateParamVO dateCond){
		ModelAndView mv=new ModelAndView("director/htreadtUser/listAll");
		if(dateCond.getEnd()==null||dateCond.getStart()==null){
			Date date=new Date();
			dateCond.setStart(DateUtil.getFirstDayInMonth(date));	
			dateCond.setEnd(DateUtil.getLastDayInMonth(date)); 
		}
		mv.addObject("page",  hTreatUserServer.getPage(page, userId,dateCond));
		mv.addObject("userId", userId);
		mv.addObject("dateCond",dateCond);
		return mv;
	}
	@RequestMapping("/director/htreatuser/save")
	public ModelAndView save(HttpSession session,HTreatUser ht){
		hTreatUserServer.save(ht, session);
		return new ModelAndView(new RedirectView("/director/htreatuser/page?userId="+ht.getUserId()));
	}

	@RequestMapping("/director/htreatuser/savehtml")
	public ModelAndView savehtml(Integer userId){
		ModelAndView mv=new ModelAndView("director/htreadtUser/edit");
		mv.addObject("userId", userId);
		return mv;
	}
}
