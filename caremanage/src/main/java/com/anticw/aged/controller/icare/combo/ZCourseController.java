package com.anticw.aged.controller.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.ZCourse;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.icare.combo.ZCourseService;
import com.anticw.aged.service.professional.activity.NProgramService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.professional.activity.NProgramVO;

@Controller
@RequestMapping("/ICareCourse")
public class ZCourseController {

	@Autowired
	private ZCourseService zCourseService;
	
	@Autowired
	private NProgramService nProgramService;
	@RequestMapping("/zCourse/list")
	public ModelAndView getList(Date date,Long userId) throws IllegalAccessException, InvocationTargetException{
		ModelAndView mv=new ModelAndView("/ICare/zCourse/list");
		if(date==null){
			date=new Date();
		}
		mv.addObject("npr", nProgramService.ListNProgramsz());
		mv.addObject("list", zCourseService.getDate(date, userId));
		mv.addObject("userId", userId);
		mv.addObject("date", DateUtil.getCurrentFormatDate(date));
		return mv;
	}
	
	@RequestMapping("/zCourse/getNProgram")
	public @ResponseBody List<NProgramVO> getList(int id) throws IllegalAccessException, InvocationTargetException{
		List<NProgram> nProgram=nProgramService.ListNPrograms(id);
		NProgramVO vo;
		List<NProgramVO> vos=new ArrayList<NProgramVO>();
		for(NProgram n:nProgram){
			vo=new NProgramVO();
			BeanUtils.copyProperties(vo, n);
			vos.add(vo);
		}
		return vos;
	}
	
	@RequestMapping("/zCourse/insert")
	public ModelAndView insert(String date,HttpSession session,Long userId,String nprIds) throws IllegalAccessException, InvocationTargetException{
		ZCourse z;
		String[] ids=nprIds.split(",");
		for(String id:ids){
			z=new ZCourse();
			z.setUserId(userId);
			z.setProgramId(Integer.parseInt(id));
			z.setCustomAt(DateUtil.parseStrToDate(date));
			zCourseService.insert(z, session);
		}
		ModelAndView mv=new ModelAndView(new RedirectView("/ICareCourse/zCourse/list?userId="+userId+"&date="+date));
		return mv;//getList(DateUtil.parseStrToDate(date), userId);
	}
	
	@RequestMapping("/zCourse/remove")
	public ModelAndView removeById(int id,Long userId) throws IllegalAccessException, InvocationTargetException{
		Date d=zCourseService.getZCourse(id).getCustomAt();
		zCourseService.removerById(id);
		return getList(d, userId);
	}
}
