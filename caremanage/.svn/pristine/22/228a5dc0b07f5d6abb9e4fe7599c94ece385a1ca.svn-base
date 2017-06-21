package com.anticw.aged.controller.director;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.bean.HTransfer;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.director.RoundsRecordService;
import com.anticw.aged.service.huiZheng.HConsultationService;
import com.anticw.aged.service.transfer.HTransferService;
import com.anticw.aged.vo.director.RoundsVO;

@Controller
@RequestMapping("/count/")
public class CountController {
	
	@Autowired
	private RUserService rUserService;
	@Autowired
	private RoundsRecordService roundsRecordService;
	@Autowired
	private HTransferService hTransferService;
	@Autowired
	private HConsultationService  hConsultationService;

	

	/**
	 * 分社区统计用户
	 * @throws BusinessException 
	 */
	@RequestMapping("countlist")
	public ModelAndView countUser(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("/director/countlist");
		List<RUser> list = rUserService.countUser();//分社区统计用户
		
		List<RUser> lists = rUserService.countUsers();//分社区统计一个月内新增用户
		
		List<RoundsVO> r = roundsRecordService.countRound();//巡诊统计
		
		List<HTransfer> t = hTransferService.countTransfer();//转诊统计
		
		List<HConsultation> c = hConsultationService.countConsultation();//会诊统计
		
		Long sum1= rUserService.sumUser();//计数和		
		Long sum2= rUserService.sumUser2();//计数和
		Long sum3= roundsRecordService.sumRound();//计数和
     	Long sum4= hTransferService.sumTransfer();//计数和
		Long sum5= hConsultationService.sumConsul();//计数和
		
		mv.addObject("user", list);
		mv.addObject("users", lists);
		mv.addObject("round", r);
		mv.addObject("transfer", t);
		mv.addObject("consul", c);
		mv.addObject("sum1", sum1);
		mv.addObject("sum2", sum2);
		mv.addObject("sum3", sum3);
		mv.addObject("sum4", sum4);
		mv.addObject("sum5", sum5);
		
        return mv;
	}
	
	
    
}
