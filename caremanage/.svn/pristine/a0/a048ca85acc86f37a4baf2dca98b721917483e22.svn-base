package com.anticw.aged.controller.director;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.HRoundsRecord;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.director.RoundsRecordService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-9-16
 * 功能：巡诊记录控制层
 */
@Controller
@RequestMapping("/rounds/record/")
public class RoundsRecordController {
	
	@Autowired
	private RoundsRecordService roundsRecordService;
	/**
	 * 添加巡诊记录
	 *@param roundsRecord
	 *@return
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("add")
	public ModelAndView  addGroup(HttpSession session,HRoundsRecord roundsRecord,String startTimes,String endTimes) throws ParseException{
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date date = sdf.parse(startTimes);
		roundsRecord.setStartTime(date);
		Date dates = sdf.parse(endTimes);
		roundsRecord.setEndTime(dates);
		roundsRecord.setGroupId((int)userVO.getId());
		roundsRecord.setCreateBy(userVO.getName());
		roundsRecord.setChangeBy(userVO.getName());
		roundsRecordService.addRoundsRecord(roundsRecord);
//		return new ModelAndView(new RedirectView("/group/findAll"));
		return new ModelAndView(new RedirectView("/rounds/record/findAll?userId="+roundsRecord.getUserId()+"&esc=0"));
	}
	 
	/**
	/**
	 * 查询所有寻访记录
	 *@param request
	 *@return
	 */
	@RequestMapping("findAll")
	public String findGroup(HttpSession session,HttpServletRequest request,Integer userId,Integer esc
			,PageParamVO page,String startTime,String endTime){
		/*List<Object> list=roundsRecordService.findRoundsRecordAll(Long.valueOf(userId),esc);
		if(list.size()!=0){
			
		}
		request.setAttribute("rounds", list);
		request.setAttribute("userId", userId);
		request.setAttribute("esc", esc);*/
		Page<HRoundsRecord> pageInfo=roundsRecordService.listRound(page,startTime,endTime,esc,Long.valueOf(userId));
		request.setAttribute("page",pageInfo);
		request.setAttribute("start",startTime);
		request.setAttribute("end",endTime);
		request.setAttribute("esc",esc);
		request.setAttribute("userId",userId);
		return "/director/round/round_record";
	}
	/**
	 * TODO根据id查询一个寻访记录
	 *@param id
	 *@param request
	 *@return
	 */
	@RequestMapping("findById")
	public String findRoundsById(HttpSession session,int id ,HttpServletRequest request){
		request.setAttribute("group", roundsRecordService.findRoundsRecordById(id));
		return "/director/group/edit";
	}
	/**
	 * 物理删除 
	 *@param id
	 *@return
	 */
	@RequestMapping("delById")
	public ModelAndView delRoundsById(int id) {
		roundsRecordService.delRoundsRecordBy(id);
		return new ModelAndView(new RedirectView("/group/findAll"));
	}

	/**
	 * 物理删除 
	 *@param id
	 *@return
	 */
	@RequestMapping("del")
	public ModelAndView delGroupBy(int id) {
		roundsRecordService.delRoundsRecordById(id);
		return new ModelAndView("redirect:/rounds/record/findAll");
	}
}
