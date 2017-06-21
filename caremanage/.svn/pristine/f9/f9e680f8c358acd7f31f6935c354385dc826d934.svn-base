/**
 * 
 */
package com.anticw.aged.controller.permission;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.utils.ValidateCode;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.AUserVO;
import com.anticw.aged.vo.permission.MVenderSiteVOS;
import com.anticw.aged.vo.permission.MobileUserVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.vender.AResourceVO;
import com.anticw.aged.vo.professional.vender.ARoleVO;

/**
 * 权限控制层
 * @author guoyongxiang
 * Date: 2014-10-2
 */
@RequestMapping("/permission")
@Controller
public class PermissionCtl {

	private static Logger logger = LoggerFactory.getLogger(PermissionCtl.class);
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private ValidateCode code;
	@Autowired
	private MVenderSiteService mVenderSiteService;

	public ValidateCode getCode() {
		return code;
	}

	public void setCode(ValidateCode code) {
		this.code = code;
	}

	/**
	 * 到注册
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午4:57:31
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toReg")
	public String toReg() throws Exception{
		logger.debug("into method toReg.");
		return "common/regist";
	}
	
	/**
	 * 到登录
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午5:24:04
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toLogin")
	public ModelAndView toLogin(HttpServletRequest request) throws Exception{
		logger.debug("into method toLogin.");
		ModelAndView mv = new ModelAndView("/common/login");
		if(request.getParameter("username")!=null){
			mv.addObject("userName", "用户名或密码错误");
		}
		mv.addObject("userCategorys", UserCategoryEnum.values());
		return mv;
	}
	/**
	 * 获取验证码
	 * @throws IOException 
	 */
	@RequestMapping("validateCode")
	public void validateCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        code.getRdCode(request, response);
	}
	
	/**
	 * 登录
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午3:35:49
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("login")
	public ModelAndView login(HttpSession session, String name, String password) throws BusinessException{
		logger.debug("into method login.");
		UserVO vo = null;
		UserCategoryEnum u=permissionService.getType(name);
		//String validate = (String)session.getAttribute("validateCode");
		//boolean val = validate.equalsIgnoreCase(validateCode);\
		Map<String, String> map= new HashMap<String, String>();
		if(!"".equals(name)&&!"".equals(password) ){
			try{
				vo = this.permissionService.loginVerify(name, password, u);
				session.setAttribute(PropertyValueConstants.SESSION_USER, vo);
				return new ModelAndView(new RedirectView("/permission/jumpPage"));
			}catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		map.put("username", "用户名或密码错误！");
		return new ModelAndView(new RedirectView("/permission/toLogin"),map);
	}
	/**
	 * 移动端登录
	 * @author guoyongxiang
	 * Date: 2014-10-15 下午1:50:21
	 * @param session
	 * @param name
	 * @param password
	 * @param userCategory
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("mobileLogin")
	public @ResponseBody String mobileLogin(HttpSession session, String name,
			String password,String callback,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		logger.debug("into method mobileLogin.");
		request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
		MobileUserVO vo = new MobileUserVO();
		UserCategoryEnum u=permissionService.getType(name);
		if(!"".equals(name)&&!"".equals(password)){
			try{
				UserVO user = permissionService.loginVerify(name, password, u);
				session.setAttribute(PropertyValueConstants.SESSION_USER, user);
				BeanUtils.copyProperties(user, vo);
			}catch (UsernameNotFoundException e){
				logger.warn("用户不存在 name="+name, e.getMessage());
				return PublicService.returnJSONP(ExceptionCode.USER_INFO_INVALID, Arrays.asList(vo), callback);
			}catch (BusinessException e) {
				logger.warn("登录失败 name "+name, e.getMessage());
				return PublicService.returnJSONP(e.getCode(), Arrays.asList(vo), callback);
			}catch (Exception e) {
				logger.error("登录异常 name "+name, e);
				return PublicService.returnJSONP(ExceptionCode.FAILED, Arrays.asList(vo), callback);
			}
		}else{
			logger.warn("登录失败 ,用户名密码为空 "+name);
			return PublicService.returnJSONP(ExceptionCode.PERMISSION_NAME_NULL, Arrays.asList(vo), callback);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, Arrays.asList(vo), callback);
	}
	
	/**
	 * 登出
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午3:35:49
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session){
		session.removeAttribute(PropertyValueConstants.SESSION_USER);
		session.invalidate();
		return new ModelAndView(new RedirectView("/permission/toLogin"));
	}
	
	/**
	 * 登录主页跳转
	 * @author guoyongxiang
	 * Date: 2014-10-2 下午2:36:35
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jumpPage")
	public ModelAndView jumpPage(HttpSession session) throws Exception{
		logger.debug("into method jumpPage.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(userVO!=null){
			if(userVO.getResources()==null || userVO.getResources().isEmpty()){
				
				logger.warn("无可用资源 name "+userVO.getName());
				throw new BusinessException(ExceptionCode.PERMISSION_RESOURCE_EMPYT);
			}
			
			return new ModelAndView(new RedirectView(userVO.getResources().get(0).getUrl()));
		}
		return new ModelAndView(new RedirectView("/permission/logout"));
	}
	
	/**
	 * 到重置密码
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午5:24:04
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toReset")
	public String toReset(HttpServletRequest request) throws Exception{
		logger.debug("into method toReset.");
		String msg = request.getParameter("msg");
		request.setAttribute("msg", msg);
		return "permission/modifyPass";
	}
	
	
	/**
	 * 修改密码
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午11:39:58
	 * @param session
	 * @param oldPass
	 * @param newPass
	 * @param newPass2
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("resetPass")
	public ModelAndView resetPass(HttpSession session, String oldPass, String newPass, String newPass2) throws BusinessException{
		logger.debug("into method resetPass.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		try {
			if(!newPass.equals(newPass2)){
				logger.warn("两次密码不同");
				throw new BusinessException(ExceptionCode.USER_PASS_DIFF);
			}
			this.permissionService.resetPass(userVO.getName(), userVO.getCateEnum(), oldPass, newPass);
		} catch (BusinessException e) {
			ModelAndView mv = new ModelAndView(new RedirectView("/permission/toReset"));
			mv.addObject("msg", e.getMessage());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(new RedirectView("/permission/logout"));
	}
	/**
	 * 微信端找回密码
	 * @param session
	 * @param newPass
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("modifyPassword")
	@ResponseBody
	public String modifyPassword(HttpServletResponse response,String newPass, String mobilePhone) throws BusinessException{
		logger.debug("into method resetPass.");
		response.addHeader("Access-Control-Allow-Origin", "*");//跨域
		String result = this.permissionService.modifyPassword(mobilePhone,newPass);
		return result;
	}
	/**
	 * 获取用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:50:47
	 * @param session
	 * @return
	 */
	@RequestMapping("users")
	public ModelAndView getUsers(HttpSession session, PageParamVO pageVO,Integer id,String userName){
		logger.debug("into method getUsers.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("permission/users");
		Page<AUser> users = this.permissionService.getNormalUsers(userVO.getName(), (short)userVO.getCateEnum().getType(), userVO.isSuper_(), userVO.getVenderId(), pageVO.getPage(), pageVO.getNum(),userName);
		mv.addObject("page", users);
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
			session.isNew();
			List<MVenderSite> mVenderSiteList=mVenderSiteService.fingByVenderId(userVO.getVenderId());
			// 获取当前用户创建的角色列表
			List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
			// 获取当前用户拥有的资源列表(排除例外)
			List<AResource> resources = this.permissionService.findRes((short)4);
			// 获取当前用户创建的角色列表对应MAP
			//Map<Integer, ARole> roleMap = this.permissionService.getRolesMap(roles);
			//id = id==null&&!roles.isEmpty()?roles.get(0).getId():id;
			mv.addObject("mVenderSiteList", mVenderSiteList);
			//mv.addObject("role", roleMap.get(id));
			mv.addObject("roles", roles);
			mv.addObject("userName", userName);
			mv.addObject("resources", resources);
		}
		
		return mv;
	}
	
	@RequestMapping("seesite")
	@ResponseBody
	public  JSONObject getsite(String name){
		 if(name!=null && !"".equals(name)) {      
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");      
	            Matcher m = p.matcher(name);      
	            String strNoBlank = m.replaceAll("");  
	            JSONObject json=new JSONObject();
	    		List<MVenderSite> mVenderSite = mVenderSiteService.fingByNames(strNoBlank);
	    		List<MVenderSiteVOS> vo=new ArrayList<MVenderSiteVOS>();
	    		if(mVenderSite.size()!=0){
	    			for(MVenderSite ms:mVenderSite){
	    				MVenderSiteVOS v=new MVenderSiteVOS();
	    				v.setId(ms.getId());
	    				v.setSiteName(ms.getSiteName());
	    				vo.add(v);
	    			}
	    			json.put("mVenderSite", vo);
	    		}
	    		
	    		
	    		return json;
	        }
	        return null;
	           
		
	}
	
	/**
	 * 由于hibernate 配置多对多造成的死循环简直不可忍....
	 */
	@Autowired
    private VenderService venderService;
	@RequestMapping("site/updateUser")
	public @ResponseBody JSONObject updateUser(int id){
		JSONObject json=new JSONObject();
		AUser auser = venderService.getAUser(id);
		List<ARoleVO> aRoleVO=new ArrayList<ARoleVO>();
		for(ARole a:auser.getRoles()){
			ARoleVO vo=new ARoleVO();
			vo.setId(a.getId());
			vo.setName(a.getName());
			aRoleVO.add(vo);
		}
		json.put("aRoleVO", aRoleVO);
		if(auser.getSiteIds()!=null&&auser.getSiteIds()!=""){
			List<MVenderSite> mVenderSite = mVenderSiteService.findByIds(auser.getSiteIds());
			List<MVenderSiteVOS> siteVO=new ArrayList<MVenderSiteVOS>();
			for(MVenderSite a:mVenderSite){
				MVenderSiteVOS vo1=new MVenderSiteVOS();
				vo1.setCommunityIds(a.getCommunityIds());
				vo1.setId(a.getId());
				vo1.setSiteName(a.getSiteName());
				vo1.setVenderId(a.getVenderId());
				siteVO.add(vo1);
			}
			
			json.put("mVenderSite", siteVO);
			
			
		}
		return json;
	}
	
	/**
	 * 添加用户
	 * @author guoyongxiang
	 * Date: 2014-10-8 下午6:50:31
	 * @param session
	 * @return
	 */
	@RequestMapping("addUser")
	public ModelAndView addUser(HttpSession session){
		logger.debug("into method addUser.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
		ModelAndView mv = new ModelAndView("permission/modifyUser");
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
			List<MVenderSite> mVenderSiteList=mVenderSiteService.fingByVenderId(userVO.getVenderId());
			mv.addObject("mVenderSiteList", mVenderSiteList);
		}
		mv.addObject("roles", roles);
		return mv;
	}
	
	/**
	 * 修改用户
	 * @author guoyongxiang
	 * Date: 2014-10-8 下午6:50:31
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("modifyUser/{id}")
	public ModelAndView modifyUser(HttpSession session, @PathVariable Integer id){
		logger.debug("into method modifyUser.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		AUser user = this.permissionService.getById(id);
		ModelAndView mv = new ModelAndView("permission/modifyUser");
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
				List<MVenderSite> mVenderSiteList=mVenderSiteService.fingByVenderId(userVO.getVenderId());
				mv.addObject("mVenderSiteList", mVenderSiteList);
				if(user.getSiteIds()!=null){
					String str[]= user.getSiteIds().split(",");
					Map<Long, Boolean> ms=new HashMap<Long, Boolean>();
						for(MVenderSite m:mVenderSiteList){
								for(String s:str){
										if(Long.parseLong(s)==m.getId()){
											ms.put(m.getId(), true);
										}
									
								}
						}
					mv.addObject("ms",ms);
					}
		}
		List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
		mv.addObject("user", user);
		mv.addObject("roles", roles);
		return mv;
	}
	
	/**
	 * 保存用户
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:34:48
	 * @param session
	 * @param user
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("saveUser")
	public ModelAndView saveUser(HttpSession session, AUserVO user) throws BusinessException{
		logger.debug("into method saveUser.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		user.setVenderId(userVO.getVenderId());
		user.setName(user.getName()==null?null:user.getName().trim());
		this.permissionService.saveUser(user, userVO.getCommunityId(), (short)userVO.getCateEnum().getType(), userVO.getName());
		return new ModelAndView(new RedirectView("/permission/users"));
	}
	
	/**
	 * 删除用户
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:40:02
	 * @param id
	 * @return
	 */
	@RequestMapping("removeUser/{id}")
	public @ResponseBody String removeUser(@PathVariable Integer id){
		logger.debug("into method removeUser.");
		this.permissionService.removeUser(id);
		return "success";
	}
	
	/**
	 * 获取角色列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:50:47
	 * @param session
	 * @return
	 */
	@RequestMapping("roles")
	public ModelAndView getRoles(HttpSession session, Integer id){
		logger.debug("into method roles.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 获取当前用户创建的角色列表
		List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
		// 获取当前用户拥有的资源列表(排除例外)
		List<AResource> resources = this.permissionService.getRolesResources(Integer.valueOf(userVO.getId()+""));
		// 获取当前用户创建的角色列表对应MAP
		Map<Integer, ARole> roleMap = this.permissionService.getRolesMap(roles);
		ModelAndView mv = new ModelAndView("/permission/roles");
		id = id==null&&!roles.isEmpty()?roles.get(0).getId():id;
		mv.addObject("role", roleMap.get(id));
		mv.addObject("roles", roles);
		mv.addObject("resources", resources);
		return mv;
	}
	
	@RequestMapping("rolesPro")
	public @ResponseBody List<AResourceVO> getRole(HttpSession session, Integer id){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
		Map<Integer, ARole> roleMap = this.permissionService.getRolesMap(roles);
		Set<AResource> aResource=roleMap.get(id).getResources();
		List<AResourceVO> aResourceVO=new ArrayList<AResourceVO>();
		if(aResource!=null){
			for(AResource a:aResource){
				AResourceVO vo=new AResourceVO();
				vo.setId(a.getId());
				vo.setName(a.getName());
				aResourceVO.add(vo);
			}
		}
		return aResourceVO;
	}
	
	/**
	 * 添加角色
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午1:13:13
	 * @return
	 */
	@RequestMapping("addRole")
	public ModelAndView addRole() {
		ModelAndView mv = new ModelAndView("permission/modifyRole");
		return mv;
	}
	
	/**
	 * 修改角色信息
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午1:13:01
	 * @param id
	 * @return
	 */
	@RequestMapping("modifyRole/{id}")
	public ModelAndView modifyRole(@PathVariable Integer id) {
		ARole role = this.permissionService.getRolesById(id);
		ModelAndView mv = new ModelAndView("permission/modifyRole");
		mv.addObject("role", role);
		return mv;
	}
	
	/**
	 * 保存角色
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:34:48
	 * @param session
	 * @return
	 */
	@RequestMapping("saveRoles")
	public ModelAndView saveRoles(HttpSession session, ARole role,int[] resIds){
		logger.debug("into method saveRoles.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		role.setUserCategory((short)userVO.getCateEnum().getType());
		Integer roleId=this.permissionService.saveRole(role, userVO.getName());
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
		 	this.permissionService.bindResources(roleId, resIds);
			return new ModelAndView(new RedirectView("/permission/users"));
		}
		return new ModelAndView(new RedirectView("/director/roles"));
	}
	
	/**
	 * 删除角色
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:40:02
	 * @param id
	 * @return
	 */
	@RequestMapping("removeRole/{id}")
	public @ResponseBody String removeRole(@PathVariable Integer id){
		logger.debug("into method removeRole.");
		this.permissionService.removeRole(id);
		return "success";
	}
	
	/**
	 * 获取资源列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:50:47
	 * @param session
	 * @return
	 */
	@RequestMapping("resources")
	public ModelAndView getResources(HttpSession session){
		logger.debug("into method resources.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<AResource> resources = this.permissionService.getResources((short)userVO.getCateEnum().getType());
		ModelAndView mv = new ModelAndView("/permission/resources");
		mv.addObject("resources", resources);
		return mv;
	}
	
	/**
	 * 创建资源
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午6:57:39
	 * @param session
	 * @return
	 */
	@RequestMapping("addResource")
	public String addResource(HttpSession session){
		logger.debug("into method addResource.");
		return "permission/modifyResource";
	}
	
	/**
	 * 根据Id修改资源
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午7:01:53
	 * @param id
	 * @return
	 */
	@RequestMapping("modifyResource/{id}")
	public ModelAndView modifyResource(@PathVariable Integer id){
		logger.debug("into method modifyResource.");
		AResource resource = this.permissionService.getResourceById(id);
		ModelAndView mv = new ModelAndView("/permission/modifyResource");
		mv.addObject("resource", resource);
		return mv;
	}
	
	/**
	 * 保存资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:34:48
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("saveResource")
	public ModelAndView saveResource(HttpSession session, AResource resource) throws BusinessException{
		logger.debug("into method saveResource.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		resource.setUserCategory((short)userVO.getCateEnum().getType());
		
		this.permissionService.saveResource(((ARole)userVO.getRoles().toArray()[0]).getId(), resource, userVO.getName());
		return new ModelAndView(new RedirectView("/permission/resources"));
	}
	
	/**
	 * 删除资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:40:02
	 * @param id
	 * @return
	 */
	@RequestMapping("removeResource/{id}")
	public @ResponseBody String removeResource(@PathVariable Integer id){
		logger.debug("into method removeResource.");
		this.permissionService.removeResources(id);
		return "success";
	}
	
	/**
	 * 授权/取消授权
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午7:16:36
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("grantAuth")
	public ModelAndView grantAuth(Integer userId, int[] roleIds){
		logger.debug("into method grantAuth.");
		Set<ARole> roles = this.permissionService.grantAuth(userId, roleIds);
		ModelAndView mv = new ModelAndView(new RedirectView("/permission/users"));
		mv.addObject("roles", roles);
		return mv;
	}
	
	/**
	 * 绑定资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午7:16:22
	 * @param roleId
	 * @param resIds
	 * @return
	 */
	@RequestMapping("bindResources")
	public ModelAndView bindResources(Integer roleId, int[] resIds){
		logger.debug("into method bindResources.");
		this.permissionService.bindResources(roleId, resIds);
		// post提交
		ModelAndView mv = new ModelAndView(new RedirectView("/permission/roles", true, false, true));
		mv.addObject("id", roleId);
		return mv;
	}
	
	@RequestMapping("test")
	public ModelAndView test(){
		//this.permissionService.saveManager(new AUser("test1", "", "test1", true, Short.valueOf(3+""), "1,2", "12345", "test@qq.com", "123456", "123456", 0, new Date(), "test1", "test1", null));
		this.permissionService.grantAuth(15, new int[]{1,3});
		//this.permissionService.removeUser(16);
		return new ModelAndView("user/detail");
	}
	
}
