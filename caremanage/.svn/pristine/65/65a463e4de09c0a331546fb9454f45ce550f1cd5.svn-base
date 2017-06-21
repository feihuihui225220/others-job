/**
 * 
 */
package com.anticw.aged.controller.professional;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 责任管理控制层
 * @author guoyongxiang
 * Date: 2014-10-11
 */
@RequestMapping("/professional")
@Controller
public class ProDutyManageCtl {

	private Logger logger = LoggerFactory.getLogger(ProDutyManageCtl.class);
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private VenderService venderService;
	
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
		logger.debug("into method dutyUsers.");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<AUser> user = this.permissionService.getNormalUsers(userVO.getName(), (short)userVO.getCateEnum().getType(), false, userVO.getVenderId(), pageVO.getPage(), pageVO.getNum());
		// 查询服务商服务用户数
		Map<Integer, Integer> sevCount = venderService.getDistrUserCount(userVO.getVenderId());
		ModelAndView mv = new ModelAndView("/professional/duty/users");
		mv.addObject("page", user);
		mv.addObject("sevCount", sevCount);
		return mv;
	}
	
}
