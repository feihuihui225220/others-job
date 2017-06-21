package com.anticw.aged.controller.assess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MUserIntervene;
import com.anticw.aged.service.assess.MUserInterveneService;
/**
 * 
 * @author DX 2016/11/19
 *
 */
@Controller
public class MUserInterveneCtl {

	@Autowired
	private MUserInterveneService mUserInterveneService;
	
	final String[]  assess={"assess1","assess2","assess3","assess4","assess5","assess6","assess7","assess8","assess9",
			"assess10","assess11","assess12","assess13","assess14","assess15","assess16","assess17","assess18"};

	/**
	 * 获取个人图表展示
	 * @param userId
	 * @return
	 */
	@RequestMapping("/muerIntervene/charts")
	public ModelAndView getList(Long userId){
		ModelAndView mv=new ModelAndView("professional/data/charts");
		List<MUserIntervene> list=mUserInterveneService.getList(userId);
		for(MUserIntervene m:list){
			mv.addObject(assess[m.getPacketTypes()-1], m);
		}
		mv.addObject("mu", list);
		return mv;
	}
}
