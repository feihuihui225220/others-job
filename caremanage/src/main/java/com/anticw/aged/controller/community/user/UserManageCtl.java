package com.anticw.aged.controller.community.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RNuser;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.utils.ExportExcelUtil;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.community.RUserSearchVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.vender.state.StateQueryResultVO;
import com.anticw.aged.vo.user.CountParamVO;
import com.anticw.aged.vo.user.CountUserVO;
import com.anticw.aged.vo.user.RUserVO;
import com.bjast.obuilding.bean.OBuilding;
import com.bjast.obuilding.service.OBuildingService;

/**
 * 用户管理
 * @author guoyongxiang
 * Date: 2014-10-4
 */
@RequestMapping("/community/user")
@Controller
public class UserManageCtl {

	private static Logger logger = LoggerFactory.getLogger(UserManageCtl.class);
	@Autowired
	private RUserService userService;
	@Autowired
	private OCountryService ocountryService;
	@Autowired
	private SpringDataPool springDataPool;
	@Autowired
	private VenderService venderService;
	@Autowired
	private OBuildingService buildingService;
	
	/**
	 * 列表页
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午12:36:18
	 * @param pageVO
	 * @param user
	 * @return
	 */
	/*@RequestMapping("/list")
	public ModelAndView list(HttpSession session, PageParamVO pageVO, RUserSearchVO user) {
		logger.debug("into method list.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = user.getCommunityId()==null||"".equals(user.getCommunityId())?userVO.getCommunityId():user.getCommunityId();
		Page<RUser> vo = userService.list(pageVO.getPage(), pageVO.getNum(), user, communityIds);
		
		ModelAndView mv = new ModelAndView("community/user/list");
		mv.addObject("page", vo);
		mv.addObject("user", user);
		//判断用户类型
		if(userVO.getCateEnum().equals(UserCategoryEnum.STREET)){
			// 查询当前用户社区列表
			List<OCountry> communitys = this.ocountryService.getCountryByIds(userVO.getCommunityId());
			mv.addObject("communitys",communitys);
		}
		mv.addObject("categorys", springDataPool.getOCategory());
		return mv;
	}*/
	
	/**
	 * 人口统计
	 * 2015-6-5 14:21:24
	 * @author L
	 * @param session
	 * @return
	 */
	@RequestMapping("/count")
	public ModelAndView count(HttpSession session,CountParamVO param){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(param.getCommunityId()==null||"".equals(param.getCommunityId()))
			param.setCommunityId(userVO.getCommunityId());
		ModelAndView mv = new ModelAndView("community/user/count");
		if(param.getItems()!=null){
			List<CountUserVO> result = userService.countUser(param);
			mv.addObject("result", result);
		}
		//查询社区信息
		List<OCountry> communitys = this.ocountryService.getCountryByIds(userVO.getCommunityId());
		mv.addObject("communitys",communitys);
		mv.addObject("categorys", springDataPool.getOCategory());
		mv.addObject("param", param);
		return mv;
	}
	
	/**
	 * 统计信息导出
	 * @param request
	 * @param response
	 * @param user
	 * @param columns
	 * @throws Exception
	 */
	@RequestMapping("/count/export")
	public void exportCount(HttpSession session,HttpServletResponse response,CountParamVO param) throws Exception{
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(param.getCommunityId()==null||"".equals(param.getCommunityId()))
			param.setCommunityId(userVO.getCommunityId());
		List<CountUserVO> result = null;
		if(param.getItems()!=null)
			result = userService.countUser(param);
		if(!(result == null||result.isEmpty())){
			userService.exportCount(result, response);
		}
			
	}
	
	/**
	 * 居民Excel信息导出
	 * @author guoyongxiang
	 * Date: 2014-12-5 下午4:38:14
	 * @param request
	 * @param response
	 * @param user
	 * @param columns
	 * @throws Exception
	 */
	@RequestMapping("export")
	public void exportUsers(HttpServletRequest request, HttpServletResponse response, RUserSearchVO user, String[] columns) throws Exception{
		logger.debug("into method export.");
		UserVO userVO = (UserVO) request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		List<RUser> users = userService.list(user, userVO.getCommunityId());
		List<String> titleList = new ArrayList<String>();
		List<String> fieldNameList = new ArrayList<String>();
		for(String column : columns){
			titleList.add(request.getParameter(column));
			fieldNameList.add(column.substring(4));
		}
		String[] titles = titleList.toArray(new String[titleList.size()]);
		String[] fieldNames = fieldNameList.toArray(new String[fieldNameList.size()]);
		ExportExcelUtil.exportExcel(users, "居民信息", titles, fieldNames, response);
	}
	
	/**
	 * 居民Excel信息导入
	 * @author guoyongxiang
	 * Date: 2014-12-5 下午2:21:21
	 * @param request
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping("import")
	public ModelAndView importUsers(HttpServletRequest request, @RequestParam(value="file", required=false)MultipartFile file) throws Exception{
		logger.debug("into method export.");
		UserVO userVO = (UserVO) request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		this.userService.readExcel(file, userVO.getCommunityId(), userVO.getName());
		return new ModelAndView(new RedirectView("/community/user/list"));
	}
	
	@Autowired
	private MUserVenderService mUserVenderService;
	/**
	 * 保存页
	 * @author guoyongxiang
	 * Date: 2014-9-28 下午3:55:57
	 * @param user
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("save")
	public ModelAndView save(HttpSession session, RUser ruser,RNuser rNuser, @RequestParam(value="headFile", required=false)MultipartFile headFile,Long siteId,String rCName,String rCPhone) throws BusinessException{
		logger.debug("into method save.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 参数校验
		
		
		if(ruser.getId()==null && (ruser.getIdCardNo()==null||"".equals(ruser.getIdCardNo()))){
			throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_NULL);
		}
		if(ruser.getName()==null||"".equals(ruser.getName())){
			throw new BusinessException(ExceptionCode.USER_NAME_NULL);		
		}
		
		//long userId=this.userService.saveUser(ruser,ruser.getCommunityId()+"", userVO.getName(), headFile);
		long userId=this.userService.saveUser(ruser,ruser.getCommunityId()+"", userVO.getName(), headFile,rCName,rCPhone);
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
				return new ModelAndView(new RedirectView("/professional/vender/user/detail/"+userId));
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
			return new ModelAndView(new RedirectView("/professional/vender/sevUsers"));
		}else{
			return new ModelAndView(new RedirectView("/professional/vender/user/detail/"+userId));
		}
	}
	
	/**
	 * 详情页(修改)
	 * @author guoyongxiang
	 * Date: 2014-9-28 下午3:55:42
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("detail/{id}")
	public ModelAndView detail(@PathVariable Long id) throws BusinessException{
		// 参数校验
		RUser user = this.userService.findById(id);
		OCountry ocountry = ocountryService.getCountryById(user.getCommunityId());
		// 查询状态信息
		StateQueryResultVO resultVo = venderService.query(new DateParamVO(), id, new PageParamVO(0, 1));
		List<String[]> status = resultVo.getResults().getResult();
		
		ModelAndView mv = new ModelAndView("community/user/detail");
		mv.addObject("user", user);
		mv.addObject("ocountry", ocountry);
		mv.addObject("categoryItems", springDataPool.getOCategoryItem());
		mv.addObject("status", status.isEmpty()?status:status.get(0));
		return mv;
	}
	
	/**
	 * 详情页
	 * @author guoyongxiang
	 * Date: 2014-9-28 下午3:55:42
	 * @param id
	 * @return
	 */
	@RequestMapping("mobile/detail/{id}")
	public @ResponseBody String detailMobile(@PathVariable Long id, String callback){
		logger.debug("into method detailMobile.");
		RUserVO vo = null;
		try {
			vo = new RUserVO();
			RUser user = this.userService.findById(id);
			/***************************此处目前只获取了一个紧急联系啊人*************************************/
			List<RContact> listCon = user.getrContact();
			for (int i = 0; i < listCon.size(); i++) {
				RContact contacts = listCon.get(i);
				vo.setContactUserName(contacts.getName());
				vo.setContactUserMP(contacts.getMobilePhone());
			}
			BeanUtils.copyProperties(user, vo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户详情失败", e);
			PublicService.returnJSONP(ExceptionCode.FAILED, callback);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, vo, callback);
	}
	
	/**
	 * 添加页
	 * @author guoyongxiang
	 * Date: 2014-9-28 下午3:54:34
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(HttpSession session){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("community/user/modify");
		List<OBuilding> buildings = buildingService.getByCountryId(new Integer(userVO.getCommunityId()));
		mv.addObject("categorys", springDataPool.getOCategory());
		mv.addObject("buildings", buildings);
		return mv;
	}
	
	/**
	 * 编辑页
	 * @author guoyongxiang
	 * Date: 2014-9-28 下午3:54:34
	 * @return
	 */
	@RequestMapping("modify/{id}")
	public ModelAndView modify(HttpSession session, @PathVariable Long id){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		RUser user = null;
		ModelAndView mv = new ModelAndView("community/user/modify");
		List<OBuilding> buildings = buildingService.getByCountryId(new Integer(userVO.getCommunityId()));
		mv.addObject("buildings", buildings);
		if(id!=null){
			user = this.userService.findById(id);
			//OCountry ocountry = ocountryService.getCountryById(user.getCommunityId());
			//mv.addObject("ocountry", ocountry);
		}
		mv.addObject("categorys", springDataPool.getOCategory());
		mv.addObject("user", user);
		return mv;
	}
	
	/**
	 * 根据ID物理删除用户
	 * @author guoyongxiang
	 * Date: 2014-10-8 上午10:28:47
	 * @param id
	 * @return
	 */
	@RequestMapping("remove/{id}")
	public ModelAndView remove(@PathVariable Long id){
		this.userService.remove(id);
		return new ModelAndView(new RedirectView("/community/user/list"));
	}
	
	/**
	 * 添加联系人
	 * @author guoyongxiang
	 * Date: 2014-10-6 下午7:03:07
	 * @param id
	 * @return
	 */
	@RequestMapping("addContact/{id}")
	public ModelAndView addContact(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/community/user/addContact");
		mv.addObject("id", id);
		mv.addObject("categorys", springDataPool.getOCategory().get(CategoryEnum.RELATION.getIndex()));
		return mv;
	}
	
	/**
	 * 保存联系人信息
	 * @author guoyongxiang
	 * Date: 2014-10-6 下午7:27:47
	 * @param session
	 * @param id
	 * @param contact
	 * @return
	 */
	@RequestMapping("saveContact")
	public ModelAndView saveContact(HttpSession session, Long id, RContact contact){
		UserVO user = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		this.userService.saveCoutact(id, contact, user.getName());
		return new ModelAndView(new RedirectView("/community/user/detail/"+id+"#4"));
	}
	
	/**
	 * 上传证据
	 * @author guoyongxiang
	 * Date: 2014-10-6 下午7:03:07
	 * @param id
	 * @return
	 */
	@RequestMapping("addCert/{id}")
	public ModelAndView addCert(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/community/user/addCert");
		mv.addObject("id", id);
		mv.addObject("categorys", springDataPool.getOCategory().get(CategoryEnum.CERFI.getIndex()));
		return mv;
	}
	
	/**
	 * 保存证据
	 * @author guoyongxiang
	 * Date: 2014-10-6 下午7:27:47
	 * @param session
	 * @param id
	 * @param contact
	 * @return
	 * @throws BusinessException 
	 */
	/*@RequestMapping("uploadCert/{id}")
	public ModelAndView uploadCert(HttpSession session,@PathVariable Long id, RCert cert, @RequestParam(value="files", required=false) MultipartFile[] files) throws BusinessException{
		UserVO user = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(cert.getNumber().isEmpty()){
			logger.warn("证件编号为空:id "+id);
			throw new BusinessException(ExceptionCode.USER_CERT_NO_EMPTY);
		}else if(files==null || files.length<=0){
			logger.warn("证件文件为空:id "+id);
			throw new BusinessException(ExceptionCode.USER_CERT_FILE_EMPTY);
		}
		this.userService.uploadCert(id, cert, user.getCommunityId(), user.getName(), files);
		return new ModelAndView(new RedirectView("/community/user/detail/"+id+"#5"));
	}*/

	/**
	 * 删除证据信息
	 * @author guoyongxiang
	 * Date: 2014-10-8 上午11:05:09
	 * @param id
	 * @return 
	 * @return
	 */
	/*@RequestMapping("removeCert/{id}")
	public @ResponseBody String removeCert(@PathVariable Long id){
		this.userService.removeCert(id);
		//return new ModelAndView(new RedirectView("/community/user/detail/"+id));
		return "success";
	}*/
	
	@RequestMapping("verifyIdCard/{idCard}")
	public @ResponseBody String verifyIdCard(@PathVariable String idCard){
		try {
			RUser user = this.userService.findByIdCardNo(idCard);
			if(user==null){
				return PublicService.returnValue(ExceptionCode.SUCCESS);
			}
		} catch (BusinessException e) {
			if(e.getCode() == ExceptionCode.USER_ID_CARD_NO_NULL){
				return PublicService.returnValue(ExceptionCode.SUCCESS);
			}else{
				return PublicService.returnValue(ExceptionCode.FAILED, e.getMessage());
			}
		}
		return PublicService.returnValue(ExceptionCode.FAILED, "身份证号已存在");
	}
	@RequestMapping("verifymobilePhone/{mobilePhone}")
	public @ResponseBody String verifymobilePhone(@PathVariable String mobilePhone){
		try {
			RUser user = this.userService.findBymobilePhone(mobilePhone);
			if(user==null){
				return PublicService.returnValue(ExceptionCode.SUCCESS);
			}
		} catch (BusinessException e) {
			if(e.getCode() == ExceptionCode.USER_ID_CARD_NO_INVALID){
				return PublicService.returnValue(ExceptionCode.SUCCESS);
			}else{
				return PublicService.returnValue(ExceptionCode.FAILED, e.getMessage());
			}
		}
		return PublicService.returnValue(ExceptionCode.FAILED, "手机号已存在");
	}
	
	@RequestMapping("initCate")
	public @ResponseBody String initCate(){
		this.springDataPool.initOCategoryItemMap();
		return "{\"msg\":\"init finished\"}";
	}
}
