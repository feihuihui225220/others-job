package com.anticw.aged.controller.director.childclass;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HGroupUser;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.director.HGroupUserService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.HGroupUserVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author DX-2016-09-18
 *
 */
@Controller
public class HGroupUserCtl {

	@Autowired
	private HGroupUserService hGroupUserService;
	
	@Autowired
	private RUserService rUserService;
	@Autowired
	private VenderService venderService;
	
	
	@RequestMapping("/director/hgroupUser/toAllocation")
	public ModelAndView toAllocation(HttpSession session,PageParamVO page,RUser user,Integer avaible){
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(avaible==null){
			avaible=2;
		}
		Page<HGroupUserVO> users=rUserService.getUserlist(avaible,page);
		List<AUser> ausers=venderService.getList(userVO.getVenderId());
		ModelAndView mv=new ModelAndView("/director/allocation");
		mv.addObject("page", users);
		mv.addObject("ausers", ausers);
		mv.addObject("avaible", avaible);
		return mv;
	}
	@RequestMapping("/director/hgroupUser/addGrouIdUser")
	public ModelAndView toAdd(HttpSession session,HGroupUser user,Long userId){
		ModelAndView mv=new ModelAndView(new RedirectView("/director/hgroupUser/toAllocation"));
		if(user.getId()!=null){
			//重新添加
			hGroupUserService.delete(user.getId());
		}
		
		hGroupUserService.save(session, user, userId);
		
		return mv;
	}
	
}
