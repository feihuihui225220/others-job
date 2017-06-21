/**
 * 
 *//*
package com.anticw.aged.controller.care;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.CVendorEvaluation;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.care.COrderService;
import com.anticw.aged.service.care.CVendorEvaluationService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.care.CVendorEvaluationVO;
import com.anticw.aged.vo.permission.UserVO;

*//**
 * @author ltw 关爱服务商评价管理
 * 
 *//*
@Controller
@RequestMapping("/care/evaluation")
public class CVendorEvaluationCtl {
	@Autowired
	private CVendorEvaluationService cVendorEvaluationService;
	@Autowired
	private COrderService cOrderService;
	*//**
	 * 跳转关爱服务商添加评价页
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "goToAdd")
	public ModelAndView goToAdd(Integer vendorId){
		ModelAndView mv = new ModelAndView("care/evaluation/addEvaluation");
		mv.addObject("vendorId", vendorId);
		return mv;
	}
	*//**
	 * 跳转关爱服务商添加评价页
	 * @param vendorId
	 * @return
	 *//*
	@RequestMapping(value = "count")
	public ModelAndView count(Integer vendorId,Date star,Date end){
		int finishCount=cOrderService.getFinishOrderCountByVendoorId(vendorId, star, end);
		int commplaintCount=cComplaintService.getComplaintCountByVendorId(vendorId, star, end);
		ModelAndView mv = new ModelAndView("care/evaluation/addEvaluation");
		mv.addObject("vendorId", vendorId);
		mv.addObject("finishCount", finishCount);
		mv.addObject("commplaintCount", commplaintCount);
		return mv;
	}
    *//**
     * 关爱服务商评价（添加）
     * @param cVendorEvaluationVo
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     *//*
	@RequestMapping(value = "addOrUpdate")
	public ModelAndView saveOrUpdate(HttpSession session,CVendorEvaluationVO cVendorEvaluationVo)
			throws IllegalAccessException, InvocationTargetException {
		Integer id = cVendorEvaluationVo.getId();
		if(cVendorEvaluationVo.getServiceCount()==null){
			ModelAndView mv = new ModelAndView("care/evaluation/addEvaluation");
			if(cVendorEvaluationVo.getStarDate()==null||cVendorEvaluationVo.getEndDate()==null){
				return mv;
			}
			Integer vendorId=cVendorEvaluationVo.getVendorId();
			Date star=cVendorEvaluationVo.getStarDate();
			Date end=cVendorEvaluationVo.getEndDate();
			int finishCount=cOrderService.getFinishOrderCountByVendoorId(vendorId, star, end);
			int commplaintCount=cComplaintService.getComplaintCountByVendorId(vendorId, star, end);
			
			mv.addObject("vendorId", cVendorEvaluationVo.getVendorId());
			mv.addObject("finishCount", finishCount);
			mv.addObject("commplaintCount", commplaintCount);
			mv.addObject("star", DateUtil.formatDate(star, "yyyy-MM-dd"));
			mv.addObject("end", DateUtil.formatDate(end, "yyyy-MM-dd"));
			return mv;
		}
		CVendorEvaluation cVendorEvaluation = new CVendorEvaluation();
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		if (id == null) {
			cVendorEvaluation.setAvailable(true);
			cVendorEvaluation.setCreatedAt(new Date());
			cVendorEvaluation.setCreatedBy(userVo.getName());
			BeanUtils.copyProperties(cVendorEvaluation, cVendorEvaluationVo);
			cVendorEvaluationService.saveOrUpdate(cVendorEvaluation);
		} else {
			CVendorEvaluation old = cVendorEvaluationService
					.getVendorEvaluationById(id);
			old.setChangedAt(new Date());
			BeanUtils.copyProperties(old, cVendorEvaluationVo);
			cVendorEvaluationService.saveOrUpdate(old);
		} 
		return new ModelAndView(new RedirectView("/care/vendor/VendoreValuationList?vendorId="+cVendorEvaluationVo.getVendorId()));
	}
	*//**
	 * 
	 * @param id
	 *//*
	@RequestMapping(value = "details")
	public ModelAndView getVendorEvaluationById(Integer id) {
		CVendorEvaluation cVendorEvaluation = cVendorEvaluationService
				.getVendorEvaluationById(id);
		ModelAndView mv = new ModelAndView("care/evaluation/addOrUpdate");
		mv.addObject("cVendor", cVendorEvaluation);
		return mv;
	}
	*//**
	 * 获取关爱服务商评价列表
	 * @param starDate
	 * @param endDate
	 * @return
	 *//*
	@RequestMapping(value = "searchByDate")
	public ModelAndView searecVendorEvaluationByDate(CVendorEvaluationVO cVendorEvaluationVo) {
		Date start=cVendorEvaluationVo.getStarDate();
		Date end=cVendorEvaluationVo.getEndDate();
		Integer vendorId=cVendorEvaluationVo.getVendorId();
		List<CVendorEvaluation> result =cVendorEvaluationService.searecVendorEvaluationByDate(start,end,vendorId);
//		ModelAndView mv = new ModelAndView("care/evaluation/addOrUpdate");
//		mv.addObject("details", result);
		//ModelAndView mv =  new ModelAndView(new RedirectView("/care/vendor/VendoreValuationList?vendorId="+cVendorEvaluationVo.getVendorId()));
		ModelAndView mv =  new ModelAndView("/care/vendor/vendorEval");
		mv.addObject("vendorId", cVendorEvaluationVo.getVendorId());
		mv.addObject("searchKehy", cVendorEvaluationVo);
		mv.addObject("evaluationList", result);
		return mv;
		 
	}
	*//**
	 * 根据关爱服务商ID获取关爱服务商评价列表
	 * @param starDate
	 * @param endDate
	 * @return
	 *//*
	@RequestMapping(value = "list")
	public ModelAndView searecVendorEvaluationByDate(Integer vendorId) {
		List<CVendorEvaluation> result =cVendorEvaluationService.getVendorEvaluationByVendorId(vendorId);
		ModelAndView mv = new ModelAndView("cß");
		mv.addObject("details", result);
		return mv;
	}
	
	 
	
}
*/