package com.anticw.aged.controller.position;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MPosition;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.position.PositionService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 位置相关控制器
 * <P>File name : PositionController.java </P>
 * <P>Author : liuyanpeng </P> 
 * <P>Date : 2017-2-9 </P>
 */
@RequestMapping("/position")
@Controller
public class PositionsController {

	@Autowired
	private PositionService positionService;
	/*
	 * 获取位置列表 guo
	 */
	@RequestMapping("Positionlist")
	@ResponseBody
	public Page<MPosition> list(int page, int num){
		return positionService.list(page, num);
	}
	
	/*
	 * 获取位置通过id 
	 */
	@RequestMapping("Positionfindbyid")
	@ResponseBody
	public MPosition list(Long id, PageParamVO pageVO, HttpServletRequest request){
		return positionService.findMPositionById(id);
	}
	/*
	 * 获取个人人员地理位置信息
	 */
	@RequestMapping("PositionfindByuserIdandTime")
	//@ResponseBody
	public ModelAndView personlist(long userId, Date createTime, HttpServletRequest request){
		List<MPosition> list=positionService.findByIdandTime(userId, createTime);
		int size=list.size()-1;
		ModelAndView mv=new ModelAndView("position/workPosition");
		mv.addObject("positionlist", list);
		mv.addObject("size", size);
		return mv;
	}
	/*
	 * 添加位置库 
	 */
	@RequestMapping("Positionadd")
	@ResponseBody
	public String insertposition(MPosition mposition, HttpServletRequest request ,HttpServletResponse response){
		String date=request.getParameter("createTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date creaTime;
		try {
			creaTime = sdf.parse(date);
			mposition.setCreateTime(creaTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mposition.setType(1);
		positionService.insertPosition(mposition);
		
		return "susss";
	}
	/*
	 * 修改位置信息
	 */
	@RequestMapping("Positionedit")
	@ResponseBody
	public void editMPosition(MPosition mPosition){
		positionService.editPosition(mPosition);
	}
	/*
	 * 物理删除直接删除 
	 */
	@RequestMapping("Positiondel")
	@ResponseBody
	public void deletePositionBy(Long id){
		positionService.delPositionBy(id);
	}
	/*
	 * 修改删除改变状态 
	 */
	@RequestMapping("PositiondelByid")
	@ResponseBody
	public void deletePositionById(Long id){
		positionService.delPositionById(id);
	}
}
