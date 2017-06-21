package com.anticw.aged.controller.message;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.OMessage;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.message.OMessageService;

/**
 * 位置相关控制器
 * <P>File name : PositionController.java </P>
 * <P>Author : liuyanpeng </P> 
 * <P>Date : 2017-2-9 </P>
 */
@RequestMapping("/message")
@Controller
public class OMessageController {
	@Autowired
	private OMessageService oMessageService;
	//获取信息列表
	@RequestMapping("messageList")
	@ResponseBody
	public Page<OMessage> list(int page,int num){
		return oMessageService.list(page, num);
	}
	//添加信息
	@RequestMapping("addMessage")
	@ResponseBody
	public String insertMessage(OMessage oMessage, HttpServletRequest request ,HttpServletResponse response){
//		String date=request.getParameter("createdTime");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date creaTime;
//		try {
//			creaTime = sdf.parse(date);
//			oMessage.setCreatedTime(creaTime);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		oMessage.setCreatedTime(new Date());
		oMessageService.insertOMessage(oMessage);
		return "添加成功!!!";
	}
	//通过id查找信息
	@RequestMapping("messageFindById")
	@ResponseBody
	public OMessage findMessageById(Integer id){
		return oMessageService.findMessageById(id);
	}
	//通过电话号查找信息
	@RequestMapping("messageFindByPhone")
	@ResponseBody
	public List<OMessage> findMessageByPhone(String phone){
		return oMessageService.findMessageByPhone(phone);
	}
	//通过信息来源查信息
	@RequestMapping("messageFindByComeFrom")
	@ResponseBody
	public List<OMessage> findMessageByComeFrom(Integer comefrom){
	
		return oMessageService.findMessageByComeFrom(comefrom);
	}
	//删除信息
	@RequestMapping("messageDeleteById")
	@ResponseBody
	public String deleteById(Integer id){
		oMessageService.deleteMessageById(id);
		return "删除成功!!!";
	}
	//编辑信息
	@RequestMapping("messageEdit")
	@ResponseBody
	public String editMessage(OMessage oMessage, HttpServletRequest request ,HttpServletResponse response){
		oMessageService.editMessage(oMessage);
		return "编辑成功!!!";
	}
}
