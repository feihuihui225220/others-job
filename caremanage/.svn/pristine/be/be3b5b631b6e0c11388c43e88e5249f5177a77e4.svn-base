/**
 * 
 */
package com.anticw.aged.service.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PermissionConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.permission.ResourceDao;
import com.anticw.aged.dao.permission.RoleDao;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.vo.permission.AUserVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 权限-用户业务层
 * @author guoyongxiang
 * Date: 2014-10-2
 */
@Service
public class PermissionService {

	private static Logger logger = LoggerFactory.getLogger(PermissionService.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RUserService ruserService;
	
	/**
	 * 登录校验
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午4:23:48
	 * @param name
	 * @param password
	 * @param cate
	 * @return
	 * @throws BusinessException
	 */
	public UserVO loginVerify(String name, String password, UserCategoryEnum cate) throws BusinessException{
		Set<ARole> roles = new HashSet<ARole>();
		// 处理老年人账户
		if(cate.getType()==UserCategoryEnum.USER.getType()){
			RUser ruser = this.ruserService.login(name, password);
			ARole role = this.roleDao.get(UserCategoryEnum.USER.getDefSysRoleId());
			roles.add(role);
			UserVO vo =	 new UserVO(ruser.getId(), name, null, null, ruser.getName(), UserCategoryEnum.USER, ruser.getCommunityId()+"", false, roles);
			vo.setIdCardNo(ruser.getIdCardNo()); 
			return vo;
		}else{
			// 校验普通平台账户
			AUser user = this.userDao.findByName(name);
			String pass = encryptPass(password, name);
			if(user!=null && user.getUserCategory()==cate.getType()){
				if(!pass.equals(user.getPassword())){
					logger.warn("用户密码不匹配: name {} ,password {}", name, password);
					throw new BusinessException(ExceptionCode.PERMISSION_PASSWORD_ERROR);
				}
			}else{
				logger.warn("用户不存在: name {}", name);
				throw new BusinessException(ExceptionCode.PERMISSION_INFO_INVALID);
			}
			// 父级用户，超级用户显示自己
			String parentName = user.getSuper_()==true?user.getName():user.getCreatedBy();
			return new UserVO((long)user.getId(), name, parentName, user.getVenderId(), user.getNickname(), cate, user.getCommunityIds(), user.getSuper_(), user.getRoles());
		}
	}
	/**
	 * 获取登陆账号信息  样式（cm  sys 等）
	 * @param name
	 * @return
	 */
	public UserCategoryEnum getType(String name){
		
		int type=userDao.getType(name);
		if(type==0){
			return UserCategoryEnum.SYS;
		}else if(type==1){
			return UserCategoryEnum.USER;
		}else if(type==2){
			return UserCategoryEnum.CMT;
		}else if(type==3){
			return UserCategoryEnum.CM;
		}else if(type==4){
			return UserCategoryEnum.PRO;
		}else if(type==5){
			return UserCategoryEnum.CARE;
		}else if(type==6){
			return UserCategoryEnum.CC;
		}else if(type==7){
			return UserCategoryEnum.STREET;
		}else{
			return null;
		}
		
	}
	
	
	/**
	 * 创建管理账户
	 * userCategory为要创建的类型,不是当前角色类型
	 * @author guoyongxiang
	 * Date: 2014-10-2 下午11:14:49
	 * @param user
	 * @throws BusinessException 
	 */
	public AUser saveManager(AUser user, String opUser) throws BusinessException{
		// 获取明文原密码,带加密处理
		//String sourcePass = user.getPassword();
		user.initUser(true, opUser);
		
		// 2.创建默认角色
		Set<ARole> roles = new HashSet<ARole>();
		UserCategoryEnum[] cats = UserCategoryEnum.values();
		for(UserCategoryEnum cat:cats){
			if(cat.getType()==user.getUserCategory()){
				ARole role = this.roleDao.get(cat.getDefSysRoleId());
				roles.add(role);
				break;
			}
		}
		user.setRoles(roles);
		try{
			this.userDao.save(user);
		}catch (Exception e) {
			e.printStackTrace();
			logger.warn("创建管理员失败 name "+user.getName(), e.getMessage());
			throw new BusinessException(ExceptionCode.USER_NAME_ALREADY_USE);
		}
		
		// 3.关爱服务管理自动连带创建呼叫中心管理账户
		/*if(UserCategoryEnum.CM.getType()==user.getUserCategory()){
			roles = new HashSet<ARole>();
			ARole role = this.roleDao.get(UserCategoryEnum.CC.getDefSysRoleId());
			roles.add(role);
			String ccName = user.getName()+PermissionConstants.CC_USERNAME_SUFFIX;
			String ccPassword = encryptPass(sourcePass, ccName);
			Short ccCategory = Short.valueOf(UserCategoryEnum.CC.getType()+"");
			AUser ccUser = new AUser(ccName, ccPassword, user.getDescr(), user.getSuper_(), ccCategory, user.getCommunityIds(), user.getIdCardNo(), user.getEmail(), user.getMobilePhone(), user.getContactPhone(), user.getGender(), user.getBirthday(), user.getAddr(), user.getCreatedBy(), roles);
			this.userDao.save(ccUser);
		}*/
		return user;
	}
	
	/**
	 * 修改密码
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午11:37:26
	 * @param name
	 * @param cate
	 * @param oldPass
	 * @param newPass
	 * @throws BusinessException
	 */
	public void resetPass(String name, UserCategoryEnum cate, String oldPass, String newPass) throws BusinessException{
		String md5old = encryptPass(oldPass, name);
		String md5new = encryptPass(newPass, name);
		// 普通用户
		if(UserCategoryEnum.USER.equals(cate)){
			RUser ruser = this.ruserService.findByIdCardNo(name);
			if(ruser!=null){
				if(md5old.equals(ruser.getPassword())){
					ruser.setPassword(md5new);
					this.ruserService.update(ruser, name, false);
				}else{
					logger.warn("用户密码不匹配: name {} ,password {}", name, oldPass);
					throw new BusinessException(ExceptionCode.USER_PASSWORD_ERROR);
				}
			}else{
				logger.warn("用户不存在name {}", name);
				throw new BusinessException(ExceptionCode.USER_INFO_INVALID);
			}
		}else{
			AUser auser = this.userDao.findByName(name);
			if(auser!=null){
				if(md5old.equals(auser.getPassword())){
					auser.setPassword(md5new);
					auser.setChangedAt(new Date());
					auser.setChangedBy(name);
					this.userDao.saveOrUpdate(auser);
				}else{
					logger.warn("用户密码不匹配: name {} ,password {}", name, oldPass);
					throw new BusinessException(ExceptionCode.PERMISSION_PASSWORD_ERROR);
				}
			}else{
				logger.warn("用户不存在name {}", name);
				throw new BusinessException(ExceptionCode.PERMISSION_INFO_INVALID);
			}
		}
	}
	/**
	 * 找回密码
	 * @param name
	 * @param cate
	 * @param oldPass
	 * @param newPass
	 * @throws BusinessException
	 */
	public String modifyPassword(String mobilePhone,String newPass) throws BusinessException{
		String md5new = encryptPass(newPass, mobilePhone);
		// 普通用户
			RUser ruser = this.ruserService.findBymobilePhone(mobilePhone);
			if(ruser!=null){
				ruser.setPassword(md5new);
				this.ruserService.update(ruser, mobilePhone, false);
				return "success";
			}else{
				logger.warn("用户不存在手机号 {}", mobilePhone);
				return "用户不存在!";
			}
	}
	
	/**
	 * 根据Id查询用户信息
	 * @author guoyongxiang
	 * Date: 2014-10-8 下午6:58:41
	 * @param id
	 * @return
	 */
	public AUser getById(int id){
		return this.userDao.get(id);
	}
	
	/**
	 * 查询指定平台查询用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:32:54
	 * @param name
	 * @param userCategory
	 * @param super_
	 * @return
	 */
	public Page<AUser> getNormalUsers(String name, Short userCategory, boolean super_, Integer venderId, int pageNo, int pageSize){
		return this.userDao.getNormalUsersByPage(name, userCategory, super_, venderId, pageNo, pageSize);
	}
	/**
	 * 查询所有服务商下的用户
	 * @param venderId
	 * @return
	 */
	public List<AUser> getNormalUsers(Integer venderId){
		return userDao.getNormalUsers(venderId);
	}
	/** 
	 * 获取专业服务商职员列表
	 * @name PermissionService.getVenderAdmins()
	 * @author zhoupeipei
	 * @Date 2014年11月28日 下午11:29:57
	 * @param createdBy
	 * @return     
	 */
	public List<AUser> getVenderAdmins(String createdBy){
		return this.userDao.getVenderAdmins(createdBy);
	}
	
	/**
	 * 查询指定平台查询用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:32:54
	 * @param name
	 * @param userCategory
	 * @param super_
	 * @return
	 */
	public List<AUser> getNormalUsers(String name, Short userCategory, boolean super_){
		return this.userDao.getNormalUsers(name, userCategory, super_);
	}
	
	/**
	 * 加密
	 * @author guoyongxiang
	 * Date: 2014-10-30 上午11:32:28
	 * @param pass
	 * @param salt
	 * @return
	 */
	public static String encryptPass(String pass, String salt){
		return new Md5PasswordEncoder().encodePassword(pass, salt);
	}
	
	/**
	 * 修改用户信息
	 * @author guoyongxiang
	 * Date: 2014-10-11 下午4:56:58
	 * @param user
	 * @param encryptPass 是否需要对密码进行加密处理
	 */
	public void updateUser(AUser user, boolean encryptPass){
		if(encryptPass){
			if(user.getPassword()!=null && !"".equals(user.getPassword())){
				user.setPassword(encryptPass(user.getPassword(), user.getName()));
			}
		}
		try{
			this.userDao.update(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 保存用户
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:51:41
	 * @param user
	 * @return 
	 * @throws BusinessException 
	 */
	public int saveUser(AUserVO user, String communityIds, Short userCategory, String opUser) throws BusinessException{
		// 获取角色列表
		Set<ARole> roles = this.roleDao.findRolesIn(user.getRoleIds());
		// 创建用户
		String siteId="";
		if(user.getSites()!=null&&!"".equals(user.getSites())){
			String site=user.getSites();
			siteId=site.substring(0,site.length()-1);
		}
		
		
		if(user.getId()==null||"".equals(user.getId())){
			if(user.getName()==null||"".equals(user.getName())){
				logger.warn("用户名不能为空");
				throw new BusinessException(ExceptionCode.PERMISSION_NAME_NULL);
			}
			// 创建管理用户
			String password = encryptPass(user.getPassword(), user.getName());
			AUser auser = new AUser(user.getName(), password, false, userCategory, communityIds, user.getContactPhone(), opUser, roles);
			auser.setVenderId(user.getVenderId());
			auser.setSiteIds(siteId);
			try{
				 userDao.save(auser);
				 return auser.getId();
			}catch(DataIntegrityViolationException e){
				logger.warn("用户名已存在name "+user.getName());
				throw new BusinessException(ExceptionCode.USER_NAME_ALREADY_USE);
			}
		}else{
			// 修改用户
			AUser dbUser = this.userDao.get(user.getId());
			if(user.getPassword()!=null && !"".equals(user.getPassword())){
				String password = encryptPass(user.getPassword(), dbUser.getName());
				dbUser.setPassword(password);
			}
			dbUser.setContactPhone(user.getContactPhone());
			dbUser.setChangedBy(opUser);
			dbUser.setChangedAt(new Date());
			dbUser.setRoles(roles);
			dbUser.setSiteIds(siteId);
			 this.userDao.update(dbUser);
			 return dbUser.getId();
		}
	}
	
	/**
	 * 删除用户
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午2:02:05
	 * @param id
	 */
	public void removeUser(Integer id){
		this.userDao.removeById(id);
	}
	
	/**
	 * 根据账户类型查找用户
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午7:26:44
	 * @param cate
	 * @return
	 */
	public List<AUser> getUserByCategory(UserCategoryEnum cate){
		return this.userDao.getUserByCategory(cate);
	}
	
	/**
	 * 保存角色
	 * @author guoyongxiang
	 * @param role
	 * Date: 2014-10-3 下午2:10:39
	 */
	public Integer saveRole(ARole role, String opUser){
		if(role.getId()==null){
			role.initRole(opUser);
			this.roleDao.save(role);
		}else{
			ARole dbrole = this.getRolesById(role.getId());
			dbrole.setName(role.getName());
			dbrole.setDescr(role.getDescr());
			dbrole.setChangedBy(opUser);
			dbrole.setChangedAt(new Date());
			this.roleDao.update(dbrole);
			
		}
		return role.getId();
	}
	
	/**
	 * 根据角色ID查角色信息
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午1:11:58
	 * @param id
	 * @return
	 */
	public ARole getRolesById(Integer id){
		return this.roleDao.get(id);
	}
	
	/**
	 * 查询指定平台当前用户创建的角色列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:34:26
	 * @param name
	 * @param userCategory
	 * @return
	 */
	public List<ARole> getRoles(String name, Short userCategory){
		List<ARole> roles = this.roleDao.findRoles(name, userCategory);
		// 过滤例外
		for(ARole role:roles){
			Set<AResource> resources = new HashSet<AResource>();
			for(AResource res:role.getResources()){
				if(Arrays.binarySearch(PermissionConstants.EXCLUDE_RES_ID, res.getId())<0){
					resources.add(res);
				}
			}
			role.setResources(resources);
		}
		return roles;
	}
	
	/**
	 * 获取角色MAP
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午2:00:58
	 * @param roles
	 * @return
	 */
	public Map<Integer, ARole> getRolesMap(List<ARole> roles){
		Map<Integer, ARole> map = new HashMap<Integer, ARole>();
		for(ARole role: roles){
			map.put(role.getId(), role);
		}
		return map;
	}
	
	/**
	 * 获取角色中的资源列表(排除例外)
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午2:23:56
	 * @param id	用户ID
	 * @return
	 */
	public List<AResource> getRolesResources(Integer id){
		Set<ARole> roles = this.userDao.get(id).getRoles();
		List<AResource> resources = new ArrayList<AResource>();
		for(ARole role:roles){
			for(AResource res: role.getResources()){
				if(Arrays.binarySearch(PermissionConstants.EXCLUDE_RES_ID, res.getId())<0 && !resources.contains(res)){
					resources.add(res);
				}
			}
		}
		return resources;
	}
	
	/**
	 * 删除角色
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午2:02:05
	 * @param id
	 */
	public void removeRole(Integer id){
		this.roleDao.remove(id);
	}
	
	/**
	 * 查询指定平台资源列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午1:37:32
	 * @param userCategory
	 * @return
	 */
	public List<AResource> getResources(Short userCategory){
		return this.resourceDao.findRes(userCategory, PermissionConstants.EXCLUDE_RES_ID);
	}
	
	public List<AResource> findRes(Short userCategory){
		return this.resourceDao.findRes(userCategory);
	}
	/**
	 * 根据Id查询资源
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午7:00:59
	 * @param id
	 * @return
	 */
	public AResource getResourceById(Integer id){
		return this.resourceDao.get(id);
	}
	
	/**
	 * 保存资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午2:10:39
	 * @param roleId 当前超管的角色ID
	 * @param resource
	 * @param opUser
	 */
	public void saveResource(Integer roleId, AResource resource, String opUser){
		if(resource.getId()==null){
			resource.initResource(opUser);
			this.resourceDao.save(resource);
			// 为当前超管角色绑定该资源
			ARole role = this.roleDao.get(roleId);
			role.getResources().add(resource);
			this.roleDao.update(role);
		}else{
			AResource dbRes = this.getResourceById(resource.getId());
			dbRes.setName(resource.getName());
			dbRes.setUrl(resource.getUrl());
			dbRes.setChangedBy(opUser);
			dbRes.setChangedAt(new Date());
			this.resourceDao.update(dbRes);
		}
	}
	
	/**
	 * 删除资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午2:02:05
	 * @param id
	 */
	public void removeResources(Integer id){
		this.resourceDao.remove(id);
	}
	
	/**
	 * 授权/取消授权
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午6:27:44
	 * @param userId
	 * @param roleIds
	 */
	public Set<ARole> grantAuth(Integer userId, int[] roleIds){
		AUser user = this.userDao.get(userId);
		Set<ARole> roles = this.roleDao.findRolesIn(roleIds);
		user.setRoles(roles);
		this.userDao.saveOrUpdate(user);
		return roles;
	}
	
	/**
	 * 绑定/取消绑定资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午6:37:21
	 * @param roleId
	 * @param resIds
	 */
	public Set<AResource> bindResources(Integer roleId, int[] resIds){
		ARole role = this.roleDao.get(roleId);
		Set<AResource> resources = this.resourceDao.findResIn(resIds);
		role.setResources(resources);
		this.roleDao.saveOrUpdate(role);
		return resources;
	}
	/**
	 * 根据社区ID查询此社区下所有社区用户
	 * @param communityId
	 * @return
	 */
	public List<AUser> findByCommunityId(String communityId) {
		return userDao.findByCommunityId(communityId);
	}
	
	/**
	 * 根据帐号类型与社区ID列表查询用户数
	 * @author guoyongxiang
	 * Date: 2014-11-8 下午5:23:17
	 * @param cate
	 * @param communityIds
	 * @param super_
	 * @return
	 */
	public long getAUserCount(UserCategoryEnum cate, String communityIds, boolean super_){
		return userDao.getAUserCount(cate, communityIds, super_);
	}
	
	/**
	 * 根据帐号创建人查询用户数
	 * @author guoyongxiang
	 * Date: 2014-11-8 下午5:23:17
	 * @param createdBy
	 * @return
	 */
	public long getAUserCount(String createdBy){
		return userDao.getAUserCount(createdBy);
	}
	/**
	 * username 模糊查询
	 * @param name
	 * @param userCategory
	 * @param super_
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<AUser> getNormalUsers(String name, Short userCategory, boolean super_, Integer venderId, int pageNo, int pageSize,String userNmae){
		return this.userDao.getNormalUsersByPage(name, userCategory, super_, venderId, pageNo, pageSize,userNmae);
	}
}
