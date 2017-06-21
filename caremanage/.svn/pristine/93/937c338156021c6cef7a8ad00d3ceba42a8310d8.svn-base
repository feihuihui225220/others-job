/**
 * 
 */
package com.anticw.aged.controller.professional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MPlan;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.professional.MPlanService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.professional.vender.MPlanVO;

/**
 * 专业服务商
 * @author li
 *
 */
@Controller
@RequestMapping("/professional/plan")
public class MPlanCtl {
	@Autowired
    private MPlanService mPlanService;
	@Autowired
	private VenderService venderService;
	/**
	 * 用户专业服务订单添加服务计划
	 * @param session
	 * @param mPlanVO
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "saveOrUpdate")
	public ModelAndView saveOrUpdate(HttpSession session,MPlanVO mPlanVO)throws  BusinessException {
		MPlan mPlan = new MPlan();
		if (mPlanVO.getId() == null) {
			mPlan.setmVender(venderService.getVender(mPlanVO.getmVenderId()));
			//mPlan.setServiceTime(mPlanVO.getServiceTime());
			mPlan.setUserId(mPlanVO.getUserId());
			mPlan.setRemark(mPlanVO.getRemark());
			mPlanService.saveOrUpdate(mPlan);
		} 
		ModelAndView mv = new ModelAndView(new RedirectView("/care/communityUser/goToIndex"));
		mv.addObject("msg", "success");
		return mv;
	}
	@RequestMapping(value = "searchUserPlan")
	public ModelAndView searchUserPlan(HttpSession session,MPlanVO mPlanVO)throws  BusinessException {
	    //List<MPlan> mPlan=mPlanService.getUserPlan(mPlanVO.getServiceTime(), mPlanVO.getUserId(),mPlanVO.getOrdreId());
		ModelAndView mv = new ModelAndView(new RedirectView("/care/communityUser/goToIndex"));
		//mv.addObject("result", mPlan);
		return mv;
	}
}
