package com.anticw.aged.controller.director;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.controller.permission.PermissionCtl;
import com.anticw.aged.dao.director.GroupDao;
import com.anticw.aged.dao.director.HGroupUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.director.GroupService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.AUserVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-9-12
 * 功能：巡诊主任对角色和员工的管理
 */
@Controller
@RequestMapping("/director/")
public class RoleManage {
private static Logger logger = LoggerFactory.getLogger(PermissionCtl.class);
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private GroupService groupService;

	/**
	 * 获取用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:50:47
	 * @param session
	 * @return
	 */
	@RequestMapping("users")
	public ModelAndView getUsers(HttpSession session, PageParamVO pageVO,Integer id){
		logger.debug("into method getUsers.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv = new ModelAndView("director/users");
		Page<AUser> users = this.permissionService.getNormalUsers(userVO.getName(), (short)userVO.getCateEnum().getType(), userVO.isSuper_(), userVO.getVenderId(), pageVO.getPage(), pageVO.getNum());
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
			mv.addObject("resources", resources);
		}
		
		return mv;
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
		ModelAndView mv = new ModelAndView("/director/modifyUser");
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
		ModelAndView mv = new ModelAndView("director/modifyUser");
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
		Integer id=this.permissionService.saveUser(user, userVO.getCommunityId(), (short)userVO.getCateEnum().getType(), userVO.getName());
		if(id!=null){
			HGroup hGroup=new HGroup();
			hGroup.setUserId(id);
			hGroup.setUserName(user.getName());
			groupService.addGroup(hGroup);
		}
		return new ModelAndView(new RedirectView("/director/users"));
	}
	
	@Autowired
	private HGroupUserDao hGroupUserDao;
	@Autowired
	private GroupDao groupDao;
	/**
	 * 删除用户
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午5:40:02
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("removeUser/{id}")
	public @ResponseBody String removeUser(@PathVariable Integer id) throws Exception{
		logger.debug("into method removeUser.");
		if(hGroupUserDao.getList(id)>0){
			 return "巡诊组下还有分配的人员，不可删除！";//抛出异常 
		}
		groupDao.remove(groupDao.findByUserId(id).get(0));
		this.permissionService.removeUser(id);
		return "success";
	}
	/**
	 * 获取角色列表
	 * @author bsd
	 * @param session
	 * @return
	 */
	@RequestMapping("roles")
	public ModelAndView getRoles(HttpSession session, Integer id){
		logger.debug("进入查询角色方法");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 获取当前用户创建的角色列表
		List<ARole> roles = this.permissionService.getRoles(userVO.getName(), (short)userVO.getCateEnum().getType());
		// 获取当前用户拥有的资源列表(排除例外)
		List<AResource> resources = this.permissionService.getRolesResources(Integer.valueOf(userVO.getId()+""));
		// 获取当前用户创建的角色列表对应MAP
		Map<Integer, ARole> roleMap = this.permissionService.getRolesMap(roles);
		ModelAndView mv = new ModelAndView("/director/roles");
		id = id==null&&!roles.isEmpty()?roles.get(0).getId():id;
		mv.addObject("role", roleMap.get(id));
		mv.addObject("roles", roles);
		mv.addObject("resources", resources);
		return mv;
	}
	/**
	 * TODO删除角色
	 *@param id
	 *@return
	 */
	@RequestMapping("removeRole/{id}")
	public @ResponseBody String removeRole(@PathVariable Integer id){
		logger.debug("into method removeRole.");
		this.permissionService.removeRole(id);
		return "success";
	}
	/**
	 * 修改角色信息
	 * @param id
	 * @return
	 */
	@RequestMapping("modifyRole/{id}")
	public ModelAndView modifyRole(@PathVariable Integer id) {
		ARole role = this.permissionService.getRolesById(id);
		ModelAndView mv = new ModelAndView("/director/modifyRole");
		mv.addObject("role", role);
		return mv;
	}
	/**
	 * 保存角色
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
			return new ModelAndView(new RedirectView("/director/users"));
		}
		return new ModelAndView(new RedirectView("/director/roles"));
	}
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("addRole")
	public ModelAndView addRole() {
		ModelAndView mv = new ModelAndView("/director/modifyRole");
		return mv;
	}
	/**
	 * 绑定资源
	 * @param roleId
	 * @param resIds
	 * @return
	 */
	@RequestMapping("bindResources")
	public ModelAndView bindResources(Integer roleId, int[] resIds){
		logger.debug("into method bindResources.");
		this.permissionService.bindResources(roleId, resIds);
		// post提交
		ModelAndView mv = new ModelAndView(new RedirectView("/director/roles", true, false, true));
		mv.addObject("id", roleId);
		return mv;
	}
}
