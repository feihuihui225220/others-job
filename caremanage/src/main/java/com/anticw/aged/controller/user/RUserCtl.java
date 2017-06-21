/**
 * 
 */
package com.anticw.aged.controller.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.vender.state.StateQueryResultVO;
import com.anticw.aged.vo.user.RegisterVO;

/**
 * 用户信息控制层
 * @author guoyongxiang
 * Date: 2014-9-25
 */
@Controller
@RequestMapping("/user")
public class RUserCtl {
	
	private static Logger logger = LoggerFactory.getLogger(RUserCtl.class);
	
	@Autowired
	private RUserService userService;
	@Autowired
	private OCountryService ocountryService;
	@Autowired
	private SpringDataPool springDataPool;
	@Autowired
	private VenderService venderService;
	
	/**
	 * 用户(老年人)登录(废弃)
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午4:57:31
	 * @param regVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login")
	public ModelAndView login(HttpSession session, String name, String password) throws Exception{
		logger.debug("into method login.");
		
		// 1.登录逻辑
		RUser user = this.userService.login(name, password);
		// 设置session
		session.setAttribute(PropertyValueConstants.SESSION_USER, user);
		return new ModelAndView(new RedirectView("../user/info"));
	}

	/**
	 * 用户注册
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午4:57:31
	 * @param regVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("regist")
	public ModelAndView regist(RegisterVO regVO) throws Exception{
		logger.debug("into method regist.");
		// 1.参数验证
		regVO.selfValidate();
		// 2.登录逻辑
		this.userService.register(regVO);
		return new ModelAndView(new RedirectView("/permission/toLogin"));
	}
	/**
	 * 老人信息
	 * @author guoyongxiang
	 * Date: 2014-10-12 下午11:36:33
	 * @param session
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("detail")
	public ModelAndView detail(HttpSession session) throws BusinessException{
		logger.debug("into method detail.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		RUser user = this.userService.findById(userVO.getId());
		OCountry ocountry = ocountryService.getCountryById(user.getCommunityId());
		// 查询状态信息
		StateQueryResultVO resultVo = venderService.query(new DateParamVO(), userVO.getId(), new PageParamVO(0, 1));
		List<String[]> status = resultVo.getResults().getResult();
		
		ModelAndView mv = new ModelAndView("/user/detail");
		mv.addObject("status", status.isEmpty()?status:status.get(0));
		mv.addObject("statearr", CommunityConstants.USERPOLICYSTATEMAP);
		mv.addObject("user", user);
		mv.addObject("stauts_m", resultVo.getStatus_m());
		mv.addObject("ocountry", ocountry);
		mv.addObject("resultVo", resultVo);
		mv.addObject("categoryItems", springDataPool.getOCategoryItem());
		return mv;
	}
	@RequestMapping("professional/datum")
	public ModelAndView leaveforil(HttpSession session,RUser r){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		RUser user = null;
		if(userVO.getCateEnum()==UserCategoryEnum.USER){
			user = this.userService.findById(userVO.getId());
		}else{
			user = this.userService.findById(r.getId());
		}
		ModelAndView mv = new ModelAndView("/user/datum");
		mv.addObject("categorys", springDataPool.getOCategory());
		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping("shenhe")
	public ModelAndView update(HttpSession session,long id){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		RUser user = this.userService.findById(id);
		user.setCreatedBy(userVO.getName());
		user.setCreatedAt(new Date());
		user.setActive(1);
		userService.update_shenhe(user);
		return new ModelAndView(new RedirectView("../care/user/list"));
	}
	@RequestMapping("update/too")
	public ModelAndView leaveforil(HttpSession session, RUser ruser, @RequestParam(value="headFile", required=false)MultipartFile headFile) throws Exception{
		if(ruser.getId()==null && (ruser.getIdCardNo()==null||"".equals(ruser.getIdCardNo()))){
			throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_NULL);
		}
		if(ruser.getName()==null||"".equals(ruser.getName())){
			throw new BusinessException(ExceptionCode.USER_NAME_NULL);		
		}
		//this.userService.saveUser(ruser, ruser.getCommunityId()+"", ruser.getName(), headFile);
		this.userService.saveUser(ruser, ruser.getCommunityId()+"", ruser.getName(), headFile,null,null);
		return new ModelAndView("/user/logout");
	}
	
	
}
