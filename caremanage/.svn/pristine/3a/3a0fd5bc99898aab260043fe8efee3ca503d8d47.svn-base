package com.anticw.aged.controller.icare;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.ZFeedback;
import com.anticw.aged.service.icare.ZFeedBackService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
public class ZFeedBackCtl {
	@Autowired
	private ZFeedBackService zFeedbackService;

	/**
	 * 查询所有有效的反馈
	 *@param page
	 *@param num
	 *@return
	 */
	@RequestMapping("/icare/feedback/getList")
	public String getFeedbackList(PageParamVO page,HttpServletRequest request
			,String userContact,String startTime,String endTime) {
		request.setAttribute("page", zFeedbackService.getFeedbackList(page,userContact,startTime,endTime));
		request.setAttribute("userContact",userContact);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		return "ICare/feedback/feedlist";
	}
	
	
	/**
	 * 查询一首反馈TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/feedback/detail")
	public String  getFeedbackById(int id,HttpServletRequest request){
		request.setAttribute("feed", zFeedbackService.getFeedbackById(id) );
		return "ICare/feedback/feeddetail";
	}
	
	
      /**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/feedback/toAddPage")
	public String  toAddPage(){
		return "ICare/feedback/feedadd";
	}
	/**
	 * 添加反馈
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("/icare/feedback/add")
	public String addFeedback(ZFeedback zFeedback){
		zFeedbackService.addFeedback(zFeedback);
		return "";
	}
	/**
	 * 删除反馈
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("/icare/feedback/remove/{id}")
	public String  delete(int id){
		zFeedbackService.delete(id);
		return "";
	}
	/**
	 * 修改反馈TODO
	 *@param careFeedback
	 */
	@RequestMapping("/icare/feedback/modify")
	public String modifyFeedback(ZFeedback zFeedback){
		zFeedbackService.modifyFeedback(zFeedback);
		return "";
	}
	

}
