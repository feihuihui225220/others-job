/**
 * 
 */
package com.anticw.aged.controller.care;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 责任管理控制层
 * @author guoyongxiang
 * Date: 2014-10-11
 */
@RequestMapping("/care")
@Controller
public class DutyManageCtl {

	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private OCountryService ocuntryService;
	
	/**
	 * 查询责任管理用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-11 下午4:38:08
	 * @param session
	 * @param pageVO
	 * @return
	 */
	@RequestMapping("dutyUsers")
	public ModelAndView dutyUsers(HttpSession session, PageParamVO pageVO){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<AUser> user = this.permissionService.getNormalUsers(userVO.getName(), (short)userVO.getCateEnum().getType(), false, userVO.getVenderId(), pageVO.getPage(), pageVO.getNum());
		
		ModelAndView mv = new ModelAndView("/care/duty/users");
		mv.addObject("page", user);
		// TODO 使用缓存待修改
		// 当前管理员社区列表
		mv.addObject("ocountrys", this.ocuntryService.getCountryByIds(userVO.getCommunityId()));
		// 所创建普通用户社区列表
		mv.addObject("ocountryMap", this.getUserOCountryMap(user.getResult()));
		return mv;
	}
	
	/**
	 * 修改责任管理
	 * @author guoyongxiang
	 * Date: 2014-10-11 下午6:15:25
	 * @param id
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("modify/{id}")
	public @ResponseBody List<Integer> modify(@PathVariable Integer id) throws JsonProcessingException{
		AUser user = this.permissionService.getById(id);
		List<OCountry> countrys = this.ocuntryService.getCountryByIds(user.getCommunityIds());
		List<Integer> commtIds = new ArrayList<Integer>();
		for(OCountry o:countrys){
			commtIds.add(o.getId());
		}
		return commtIds;
	}
	
	/**
	 * 修改责任用户绑定的社区
	 * @author guoyongxiang
	 * Date: 2014-10-11 下午4:42:56
	 * @return
	 */
	@RequestMapping("modifyDutyCommunity/{id}")
	public @ResponseBody String modifyDutyCommunity(HttpSession session, @PathVariable Integer id, String[] communityIds){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		AUser user = this.permissionService.getById(id);
		user.setChangedAt(new Date());
		user.setChangedBy(userVO.getName());
		// 组装社区ID
		StringBuffer bf = new StringBuffer();
		for(String cmtId: communityIds){
			bf.append(",").append(cmtId);
		}
		if(communityIds.length>0){
			user.setCommunityIds(bf.substring(1));
		}else{
			user.setCommunityIds("");
		}
		this.permissionService.updateUser(user, false);
		return "success";
	}
	
	/**
	 * 根据用户列表查询对应社区信息
	 * @author guoyongxiang
	 * Date: 2014-10-11 下午4:36:56
	 * @param users
	 * @return
	 */
	private Map<Integer, List<OCountry>> getUserOCountryMap(List<AUser> users){
		Map<Integer, List<OCountry>> map = new HashMap<Integer, List<OCountry>>();
		for(AUser user: users){
			// TODO 使用缓存待修改
			List<OCountry> ocountrys = this.ocuntryService.getCountryByIds(user.getCommunityIds());
			map.put(user.getId(), ocountrys);
		}
		return map;
	}
}
