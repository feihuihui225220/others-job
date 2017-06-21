package com.anticw.aged.controller.care;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.vo.permission.UserVO;

/**
 * @author ltw
 * 
 */
@Controller
@RequestMapping("/care/communityUser")
public class ACommunityUserCtl {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ACommunityUserCtl.class);
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private OCountryService oCountryService;
	/**
	 * 社区用户详情
	 * @param Id
	 * @return
	 */
	/*@RequestMapping(value = "details")
    public ModelAndView getCommunityUserById(Integer id,String countrys){
		AUser aUser=permissionService.getById(id);
		aUser.setoCountry(oCountryService.getParentByIds(aUser.getCommunityIds()));
		ModelAndView mv = new ModelAndView("care/careUser/cuserDetails");
		mv.addObject("careUser",aUser);
    	return mv;
    }*/
	/**
	 * 添加社区用户
	 * @param session
	 * @param aUserVO
	 * @return
	 * @throws BusinessException
	 */
	/*@RequestMapping(value = "saveOrUpdate")
	public @ResponseBody String saveOrUpdate(HttpSession session,AUserVO aUserVO) {
		
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		AUser aUser=null;
		ACommunityUserVo vo = null;
		try{
			if (aUserVO.getId() == null) {
				long count = permissionService.getAUserCount(UserCategoryEnum.CMT, aUserVO.getCommunityIds(), true);
				if(count>0){
					throw new BusinessException(ExceptionCode.COMMUNITYUSER_ADMIN_EXIST);
				}
			    aUser=new AUser();
			}else{
				aUser=permissionService.getById(aUserVO.getId());
				if(aUserVO.getAvailable()!=null&&aUserVO.getAvailable()==false){
					// 查询该用户下的账户数
					long userCount = this.permissionService.getAUserCount(aUserVO.getName());
					if(userCount<=0){
						permissionService.removeUser(aUser.getId());
						vo = new ACommunityUserVo();
						BeanUtils.copyProperties(aUser, vo);
						return PublicService.returnValue(ExceptionCode.SUCCESS, vo);
					}else{
						return PublicService.returnValue(ExceptionCode.FAILED, ExceptionCode.COMMUNITYUSER_HAS_CHILD_ACCOUNT);
					}
				}
			}
	
			String password=aUserVO.getPassword();
			aUser.setAddr(aUserVO.getAddr());
			aUser.setGender(aUserVO.getGender());
			aUser.setContactPhone(aUserVO.getContactPhone());
			aUser.setMobilePhone(aUserVO.getMobilePhone());
			aUser.setEmail(aUserVO.getMobilePhone());
			if (aUserVO.getId() == null) {
				aUser.setPassword(password);
				aUser.setUserCategory((short)UserCategoryEnum.CMT.getType());
				aUser.setName(aUserVO.getName());
				aUser.setCreatedAt(new Date());
				aUser.setCommunityIds(aUserVO.getCommunityIds());
				permissionService.saveManager(aUser, userVo.getName());
			} else {
				aUser.setChangedAt(new Date());
				aUser.setChangedBy(userVo.getName());
				boolean isChangePass=false;
				if(password!=null&&!"".equals(password)){
					aUser.setPassword(password);
					isChangePass=true;
				}
				permissionService.updateUser(aUser,isChangePass);
			}
			vo = new ACommunityUserVo();
			BeanUtils.copyProperties(aUser, vo);
		}catch (BusinessException e) {
			return PublicService.returnValue(e.getCode());
		}catch (Exception e) {
			logger.error("更新社区账户信息失败", e);
			return PublicService.returnValue(ExceptionCode.FAILED);
		}
		return PublicService.returnValue(ExceptionCode.SUCCESS);
	}
	*//**
	 * 根据社区ID查询当前社区管理员用户
	 * @param session
	 * @return
	 *//*
	@RequestMapping("communityUserList/{communityId}")
    public @ResponseBody String communityUserList(HttpSession session,@PathVariable String communityId,String callback){
		List<AUser> aUserList=permissionService.findByCommunityId(communityId);
		List<AUserVO> result=new ArrayList<AUserVO>();
		AUser aUser=null;
		AUserVO aUserVO=null;
		for(int a=0;a<aUserList.size();a++){
			aUserVO =new AUserVO();
			aUser=aUserList.get(a);
			aUserVO.setId(aUser.getId());
			aUserVO.setName(aUser.getName());
			aUserVO.setPassword("******");
			aUserVO.setAddr(aUser.getAddr());
			aUserVO.setGender(aUser.getGender());
			aUserVO.setMobilePhone(aUser.getMobilePhone());
			aUserVO.setContactPhone(aUser.getContactPhone());
			aUserVO.setEmail(aUser.getEmail());
			aUserVO.setAddr(aUser.getAddr());
			aUserVO.setSuper_(aUser.getSuper_());
			result.add(aUserVO);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, result, callback);
	}*/
	
	@RequestMapping(value = "list")
    public ModelAndView list(HttpSession session){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<AUser> aUserList=permissionService.getNormalUsers("",new Short("5") , true, userVO.getVenderId(), 0, 20);
		List<AUser> list=aUserList.getResult();
		for(int a=0;a<list.size();a++){
			AUser aUser=list.get(a);
			aUser.setoCountry(oCountryService.getParentByIds(aUser.getCommunityIds()));
		}
		ModelAndView mv = new ModelAndView("care/careUser/cuserList");
		mv.addObject("careUser",aUserList);
		return mv;
	}
	/**
	 * 跳转到添加careManager用户页面
	 * @return
	 */
	@RequestMapping(value = "goToAdd")
    public ModelAndView goToAdd(){
		@SuppressWarnings("unused")
		List<OCountry> result=oCountryService.getParentByIds("13");
		ModelAndView mv = new ModelAndView("care/careUser/cuserDetails");
		mv.addObject("communityUser","");
		return mv;
	}
	@RequestMapping(value = "goToIndex")
    public ModelAndView goToIndex(){
		//List<OCountry> result=oCountryService.getParentByIds("13");
		ModelAndView mv = new ModelAndView("/community/country/administrator");
		mv.addObject("communityUser","");
		return mv;
	}
}
