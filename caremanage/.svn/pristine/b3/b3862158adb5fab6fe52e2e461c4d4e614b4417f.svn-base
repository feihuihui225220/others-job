package com.anticw.aged.controller.professional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 用户添加专业服务商
 * @author dx  date 2015/12/11
 *
 */
@Controller
public class AddVenderCtl {
	

	/**
	 * 专业服务商
	 */
	@Autowired
	private VenderService venderService;
	@Autowired
	private RUserService rUserService;
	@Autowired
	private MUserVenderService mUserVenderService;
	@Autowired
	private SpringDataPool springDataPool;
	@RequestMapping(value="/professional/facilitator")
	public ModelAndView getMVender(HttpSession session,  PageParamVO pageParamVo, long userId) throws Exception{
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv=new ModelAndView("professional/vender/cmadd/facilitator");
		Page<MVender> page=venderService.venders(userVo.getName(), pageParamVo.getPage(),pageParamVo.getNum());
		Map<Integer, String>  map=mUserVenderService.getListMUserVerder(userId);
		mv.addObject("page", page);
		mv.addObject("map", map);
		mv.addObject("userId", userId);
		return mv;
	}
	@RequestMapping(value="/professional/setup")
	public ModelAndView getsetup(HttpSession session,  PageParamVO pageParamVo, long userId) throws Exception{
		ModelAndView mv=new ModelAndView("professional/vender/cmadd/setup");
		mv.addObject("userId", userId);
		return mv;
	}
	@Autowired ActivityManagerService activityManagerService;
	@Autowired AssessService  assessService;
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/professional/checkin")
	public ModelAndView getcheckin(HttpSession session,  String year, long userId) throws Exception{
		ModelAndView mv=new ModelAndView("professional/vender/cmadd/checkin");
		//根据年和用户Id获取本年度签到情况
		mv.addObject("userId", userId);
		mv.addObject("year", year);
		List checkIn=activityManagerService.getList(userId, year);
		List checkInassess=assessService.getList(userId, year);
		mv.addObject("checkIn", checkIn);
		mv.addObject("checkInassess", checkInassess);
		return mv;
	}
	
	/**
	 * 
	 * @param session
	 * @param venderId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/facilitator/add")
	public ModelAndView addUserMVender(HttpSession session, int venderId, long userId) throws Exception{
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		RUser ruser=rUserService.findById(userId);
		ruser.setActive(2);
		MUserVender mu=new MUserVender();
		mu.setUserId(ruser.getId());
		mu.setUserIdCard(ruser.getIdCardNo());
		mu.setUserName(ruser.getName());
		mu.setUserSex(ruser.getGender().shortValue());
		mu.setCommunityName(springDataPool.getCountry(ruser.getCommunityId()).getName());
		mu.setVenderId(venderId);
		mu.setCreatedAt(new Date());
		mu.setCreatedBy(userVo.getName());
		mu.setChangedAt(new Date());
		mu.setChangedBy(userVo.getName());
		mu.setAvailable(true);
		mu.setAllocation(0);
		mUserVenderService.save(mu);
		venderService.update(ruser);
		return new ModelAndView(new RedirectView("/professional/facilitator?userId="+userId));
	}
	@RequestMapping(value="/professional/facilitator/delete")
	public ModelAndView deleteUserMVender(HttpSession session,long userId,int venderId) throws Exception{
		MUserVender  mUserVender =mUserVenderService.getMUserVender(userId, venderId);
		mUserVender.setAvailable(false);
		mUserVenderService.delete(mUserVender);
		return new ModelAndView(new RedirectView("/professional/facilitator?userId="+userId));
	}
	@RequestMapping(value="/professional/vender/delete")
	public ModelAndView deleteUser(HttpSession session,int id) throws Exception{
		MUserVender m=mUserVenderService.get(id);
		RUser r=venderService.getUser(m.getUserId());
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(r.getCreatedBy().equals(userVo.getName())){
			if(mUserVenderService.getListMUser(id)!=null){
				List<MUserVender> muserVender=mUserVenderService.getListMUser(m.getUserId());
				for(MUserVender ms:muserVender){
					mUserVenderService.delete(ms);
				}
			}
			rUserService.remove(r.getId());
		}else{
			mUserVenderService.deleteUser(id);
		}
		return new ModelAndView(new RedirectView("/professional/vender/sevUsers"));
	}
	
}
