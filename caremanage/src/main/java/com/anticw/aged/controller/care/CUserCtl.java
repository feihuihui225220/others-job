package com.anticw.aged.controller.care;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.care.CareManagerUserVo;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.community.RUserSearchVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 关爱服务商用户管理
 * @ClassName: CUserCtl
 * @Description: TODO
 * @author ltw
 * @date 2014年10月2日 下午5:28:00
 * 
 */
@Controller
@RequestMapping("/care/user")
public class CUserCtl {
	private static Logger logger = LoggerFactory.getLogger(CUserCtl.class);
	@Autowired
	private RUserService ruserService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private OCountryService oCountryService;

	/**
	 * 社区用户增加更新
	 * @param aCommunityUserVo
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "saveOrUpdate")
	public ModelAndView saveOrUpdate(HttpSession session,CareManagerUserVo careManagerUserVo)throws IllegalAccessException, InvocationTargetException {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if (careManagerUserVo.getId() == null) {
			AUser aUser=new AUser();
			aUser.setCreatedAt(new Date());
			aUser.setCreatedBy(userVO.getName());
			//aUser.setSuper_(userVO.isSuper_());
			BeanUtils.copyProperties(aUser, careManagerUserVo);
			try {
				aUser.setUserCategory((short)UserCategoryEnum.CM.getType());
				aUser.setCommunityIds(userVO.getCommunityId());
				permissionService.saveManager(aUser, userVO.getName());
			} catch (BusinessException e) {
				 
				e.printStackTrace();
			}
		} else {
			AUser aUser=permissionService.getById(careManagerUserVo.getId());
			aUser.setNickname(careManagerUserVo.getNickname());
			aUser.setDescr(careManagerUserVo.getDescr()); 
			String password=careManagerUserVo.getPassword();
			boolean isChangePass=false;
			if(password!=null&&!"".equals(password)){
				aUser.setPassword(careManagerUserVo.getPassword());
				isChangePass=true;
			}
			permissionService.updateUser(aUser, isChangePass);
			 
		}
		ModelAndView mv = new ModelAndView(new RedirectView("/care/user/careUserList"));
		mv.addObject("msg", "success");
		return mv;
	}
	/**
	 * 
	 * @param session
	 * @param careManagerUserVo
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "delete")
	public ModelAndView deleteCareUser(Integer uid){
		permissionService.removeUser(uid);
		ModelAndView mv = new ModelAndView(new RedirectView("/care/user/careUserList"));
		mv.addObject("msg", "success");
		return mv;
	}
	/**
	 * 解除街道绑定
	 * @param Id
	 * @return
	 */
	@RequestMapping(value = "removeCountry")
    public ModelAndView removeCountry(Integer id,String countrys){
		AUser aUser=permissionService.getById(id);
		String typeIds = aUser.getCommunityIds();
		//String tmpServiceType = countrys + ",";
		int length=countrys.length();
		if (countrys.endsWith(",")) {
			countrys = countrys.substring(0, length - 1);
		}
		typeIds=typeIds.replaceAll(countrys, "");
//		List types = new ArrayList(Arrays.asList(typeIds.split(",")));
//		int size = types.size();
//		if (size > 1) {
//			StringBuffer sb = new StringBuffer();
//			Iterator it = types.iterator();
//			while (it.hasNext()) {
//				String value = (String) it.next();
//				if (countrys.equals(value)) {
//					it.remove();
//				} else {
//					sb.append(value + ",");
//				}
//			}
//			typeIds = sb.toString();
//			if (typeIds.endsWith(",")) {
//				typeIds = typeIds.substring(0, typeIds.length() - 1);
//			}
//		} else {
//			typeIds = "";
//		}
		if(typeIds!=null&&!"".equals(typeIds)){
			if(typeIds.startsWith(",")){
			   typeIds = typeIds.substring(1, length - 1);
			}
			if (typeIds.endsWith(",")) {
				typeIds = typeIds.substring(0, length - 1);
			}
			aUser.setCommunityIds(typeIds);
		}else{
			aUser.setCommunityIds(null);
		}
			
		permissionService.updateUser(aUser,false);
		ModelAndView mv = new ModelAndView(new RedirectView("/care/user/details?id="+id));
		mv.addObject("careUser",aUser);
    	return mv;
    }
	/**
	 * careManager用户街道绑定
	 * 
	 * @param cVendorVo
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "addCountry")
	public ModelAndView addCountry(Integer uid, String countryId) {
		AUser aUser=permissionService.getById(uid);
		if(countryId!=null&&!"".equals(countryId)){
			String communityIds = aUser.getCommunityIds();
			if (countryId.endsWith(",")) {
				countryId = countryId.substring(0, countryId.length() - 1);
			}
			if (communityIds != null && !"".equals(communityIds)) {
				aUser.setCommunityIds (communityIds + "," + countryId);
			} else {
				aUser.setCommunityIds (countryId);
			}
		}
		this.permissionService.updateUser(aUser,false);
		ModelAndView mv = new ModelAndView(new RedirectView("/care/user/details?id="+uid));
		return mv;
	}
	/**
	 * careManager查询用户社区可以绑定的街道
	 * @param uid
	 * @param countryId
	 * @return
	 */
	@RequestMapping(value = "searchStreet")
    public ModelAndView searchStreet(Integer uid,String countryId){
		ModelAndView mv = new ModelAndView(new RedirectView("/care/user/goToAdd"));
		if("-1".equals(countryId)){
			
			return mv;
		}
		//List<OCountry> countrys=searchUserStreet(uid, countryId);
		
		 if(uid!=null){
			mv = new ModelAndView(new RedirectView("/care/user/details?id="+uid+"&countrys="+countryId));
		 }
		mv.addObject("uid",uid);
		//mv.addObject("country",countrys);
    	return mv;
    }
	public List<OCountry> searchUserStreet(Integer uid,String countryId){
		List<OCountry> countrys=new ArrayList<OCountry>();
		if(uid==null){
			  countrys=oCountryService.getCountrysByPid(countryId);
		}else if(countryId!=null){
			AUser aUser=permissionService.getById(uid);
			String typeIds = aUser.getCommunityIds();
			countrys=oCountryService.getNotInParentByIds (countryId,typeIds);
		} 
		return countrys;
	}
	/**
	 * 社区用户详情
	 * @param Id
	 * @return
	 */
	@RequestMapping(value = "details")
    public ModelAndView getCommunityUserById(Integer id,String countrys){
		AUser aUser=null;
		List<OCountry> countryList=null;
		if(id!=null){
			aUser=permissionService.getById(id);
			aUser.setoCountry(oCountryService.getParentByIds(aUser.getCommunityIds()));
		if(countrys!=null){
			countryList=searchUserStreet(id, countrys);
		}
		}
		ModelAndView mv = new ModelAndView("/care/careUser/cuserDetails");
		mv.addObject("careUser",aUser);
		mv.addObject("country",countryList);
    	return mv;
    }
	/**
	 * 获取关爱服务商服务类型
	 * 
	 * @param starDate
	 * @param endDate
	 * @return
	 */
	// @RequestMapping(value = "list")
	public ModelAndView seareCUserByDate() {
		// List<CUser> result = cUserService.getAllCuser();
		ModelAndView mv = new ModelAndView("care/user/cuserList");
		mv.addObject("details", "");
		return mv;
	}
	@Autowired
	private VenderService venderService;
	/**
	 * 查询社区用户列表
	 * 
	 * @author guoyongxiang Date: 2014-10-12 下午11:04:48
	 * @param session
	 * @param pageVO
	 * @param user
	 * @param communityId
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView userList(HttpSession session, PageParamVO pageVO,
			RUserSearchVO user, String communityId) {
		logger.debug("into method userList.");
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		// 全选则根据当天用户社区查询
		String commtId = communityId;
		if ("-1".equals(commtId) || commtId == null) {
			commtId = "-1";
		}
		//根据session获取旗下所有的服务商
		String cmName=userVO.getName();
		StringBuffer creatBy= new StringBuffer();
		List<AUser> user1=venderService.getList(1);
		creatBy.append("'").append(cmName).append("'");
		if(venderService.venders(cmName).size()!=0){
			creatBy.append(",");
			List<MVender> mVenders=venderService.venders(cmName);
			for(int i=0;i<mVenders.size();i++){
				creatBy.append("'").append(mVenders.get(i).getContact()).append("'");
				if(i!=mVenders.size()-1){
					creatBy.append(",");
				}
			}
		}
		if(user1.size()!=0){
			for(int i=0;i<user1.size();i++){
				creatBy.append(",'").append(user1.get(i).getName()).append("'");
				
			}
			
		}
		// 查询用户列表
		if(user.getActive()==null){
			user.setActive(-1);
		}
		Page<RUser> vo = this.ruserService.list(pageVO.getPage(),
				pageVO.getNum(), user, creatBy.toString(),commtId,user.getActive());
		// 查询当前用户社区列表
		List<OCountry> communitys = this.oCountryService.getCountryByIds(userVO
				.getCommunityId());
		ModelAndView mv = new ModelAndView("care/user/list");
		mv.addObject("active", user.getActive());
		mv.addObject("page", vo);
		mv.addObject("user", user);
		mv.addObject("communityId", communityId);
		mv.addObject("communitys", communitys);
		return mv;
	}
    /**
     * 
     * @return
     */
	@RequestMapping(value = "careUserList")
	public ModelAndView list(HttpSession session,PageParamVO pageVO) {
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<AUser> aUserList = permissionService.getNormalUsers(userVo.getName(), new Short("3"), userVo.isSuper_(), userVo.getVenderId(), pageVO.getPage(), pageVO.getNum());
		List<AUser> list = aUserList.getResult();
		for (int a = 0; a < list.size(); a++) {
			AUser aUser = list.get(a);
			aUser.setoCountry(oCountryService.getParentByIds(aUser.getCommunityIds()));
		}
		ModelAndView mv = new ModelAndView("care/careUser/cuserList");
		mv.addObject("page", aUserList);
		return mv;
	}
	/**
	 * 跳转到添加careManager用户页面
	 * @return
	 */
	@RequestMapping(value = "goToAdd")
    public ModelAndView goToAdd(){
		//List<OCountry> result=oCountryService.getParentByIds("13");
		ModelAndView mv = new ModelAndView("care/careUser/cuserDetails");
		mv.addObject("communityUser","");
		return mv;
	}
}
