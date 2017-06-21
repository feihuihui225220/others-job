package com.anticw.aged.controller.icare.customer;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RNuser;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.DirectorUserVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.vender.state.StateQueryResultVO;

@Controller
public class CustomerCtl {

	@Autowired
	private RUserService rUserService;
	/**
	 * @author wxs 2016-11-28
	 * @param page
	 * @param user
	 * @param startTime
	 * @param endTime
	 * @param vo
	 * @return
	 */
	@RequestMapping("/customer/list")
	public ModelAndView listAllCustome(PageParamVO page, RUser user,
			String startTime, String endTime, PageParamVO vo,HttpSession session) {
		ModelAndView mv =null;
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		if(userVO.getName().equals("admin")){
			mv = new ModelAndView("/ICare/customer/list");
			mv.addObject("page",
					rUserService.listAllCustomer(vo, user, startTime, endTime));
			mv.addObject("user", user);
			mv.addObject("startTime", startTime);
			mv.addObject("endTime", endTime);
		}
		return mv;
	}
	/**
	 *	逻辑删除 
	 * @param cId
	 * @param session
	 * @return
	 */
	 @RequestMapping("/customer/delete")
	 public ModelAndView deleteCustomer(Integer cId,HttpSession session){
		 UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		 rUserService.deleteCustomer((long)cId, userVo.getName());
		 ModelAndView mv = new ModelAndView("redirect:/customer/list");
		 return mv;
	 }
	 @Autowired
	private MVenderSiteService mVenderSiteService;
	 @Autowired
		private MUserVenderService mUserVenderService;
	 @Autowired
		private RUserService userService;
	 @Autowired
		private SpringDataPool springDataPool;
	 @Autowired
		private VenderService venderService;
	 
	 /**
	  * 查看客户详情
	  * @param session
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/customer/customer")
	 public ModelAndView customerHtml(HttpSession session,Long id)
				throws Exception {
		 ModelAndView mv=new ModelAndView("/ICare/customer/customer");
		 RUser user = venderService.getUser(id);
		 DirectorUserVO ICUser = new DirectorUserVO();
		 BeanUtils.copyProperties(ICUser, user);
		 session.setAttribute("ICUser", ICUser);
			OCountry ocountry = venderService.getCountry(user.getCommunityId());

			// 查询状态信息
			StateQueryResultVO resultVo = venderService.query(new DateParamVO(),
					id, new PageParamVO(0, 1));
			List<String[]> status = resultVo.getResults().getResult();
			mv.addObject("user", user);
			mv.addObject("ocountry", ocountry);
			mv.addObject("categoryItems", springDataPool.getOCategoryItem());
			mv.addObject("status", status.isEmpty() ? status : status.get(0));
			return mv;
	 }
	 /**
	  * 进入编辑页面
	  * @param session
	  * @param r
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/customer/modifyHtml")
		public ModelAndView getModelAndView(HttpSession session, RUser r)
				throws Exception {
			UserVO userVO = (UserVO) session
					.getAttribute(PropertyValueConstants.SESSION_USER);
			ModelAndView mv = new ModelAndView("/ICare/customer/modifyHtml");
			if (userVO.getCateEnum() == UserCategoryEnum.PRO) {
				List<MVenderSite> mVenderSiteList = mVenderSiteService
						.fingByVenderId(userVO.getVenderId());
				mv.addObject("mVenderSiteList", mVenderSiteList);
				if (r.getId() != null) {
					MUserVender m = mUserVenderService.getMUserVender(r.getId(),
							userVO.getVenderId());
					mv.addObject("mUserVender", m);
				}
			}
			if (r.getId() != null) {
				RUser user = userService.findById(r.getId());
				mv.addObject("user", user);
			}
			mv.addObject("categorys", springDataPool.getOCategory());
			
			return mv;
		}
	 /**
	  * 修改客户信息/添加
	  * @param session
	  * @param ruser
	  * @param rNuser
	  * @param headFile
	  * @param siteId
	  * @return
	  * @throws BusinessException
	  */
	 @RequestMapping("/customer/save")
		public ModelAndView save(HttpSession session, RUser ruser,RNuser rNuser, @RequestParam(value="headFile", required=false)MultipartFile headFile,Long siteId,String rCName,String rCPhone) throws BusinessException{
			UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			// 参数校验
			if(ruser.getId()==null && (ruser.getIdCardNo()==null||"".equals(ruser.getIdCardNo()))){
				throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_NULL);
			}
			if(ruser.getName()==null||"".equals(ruser.getName())){
				throw new BusinessException(ExceptionCode.USER_NAME_NULL);		
			}
			long userId=this.userService.saveUser(ruser,ruser.getCommunityId()+"", userVO.getName(), headFile,rCName,rCPhone);
			//long userId=this.userService.saveUser(ruser,ruser.getCommunityId()+"", userVO.getName(), headFile);
			if(ruser.getId()==null){
				rNuser.setUserId(userId);
				rNuser.setCareateAt(new Date());
				rNuser.setCareateBy(userVO.getName());
				userService.saveRNuser(rNuser);
			}
			if(userVO.getCateEnum()==UserCategoryEnum.PRO){
			MUserVender mu=null;
			if(mUserVenderService.getMUserVender(userId, userVO.getVenderId())!=null){
				 mu=mUserVenderService.getMUserVender(userId, userVO.getVenderId());
				 mu.setUserId(userId);
					mu.setUserIdCard(ruser.getIdCardNo());
					mu.setUserName(ruser.getName());
					mu.setUserSex(ruser.getGender().shortValue());
					mu.setCommunityName(springDataPool.getCountry(ruser.getCommunityId()).getName());
					mu.setVenderId(userVO.getVenderId());
					mu.setCreatedAt(new Date());
					mu.setCreatedBy(userVO.getName());
					mu.setChangedAt(new Date());
					mu.setChangedBy(userVO.getName());
					mu.setAllocation(0);
					mu.setAvailable(true);
					mu.setSiteId(siteId);
					mUserVenderService.update(mu);
					return new ModelAndView(new RedirectView("/customer/customer?id="+userId));
			}else{
				mu=new MUserVender();
				mu.setUserId(userId);
				mu.setUserIdCard(ruser.getIdCardNo());
				mu.setUserName(ruser.getName());
				mu.setUserSex(ruser.getGender().shortValue());
				mu.setCommunityName(springDataPool.getCountry(ruser.getCommunityId()).getName());
				mu.setVenderId(userVO.getVenderId());
				mu.setCreatedAt(new Date());
				mu.setCreatedBy(userVO.getName());
				mu.setChangedAt(new Date());
				mu.setChangedBy(userVO.getName());
				mu.setAllocation(0);
				mu.setAvailable(true);
				mu.setSiteId(siteId);
				mUserVenderService.save(mu);
				}
				return new ModelAndView(new RedirectView("/customer/list"));
			}else{
				return new ModelAndView(new RedirectView("/customer/customer?id="+userId));
			}
		}
}
