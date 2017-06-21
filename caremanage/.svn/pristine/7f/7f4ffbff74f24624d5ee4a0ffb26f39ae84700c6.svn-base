package com.anticw.aged.controller.user;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.notice.NoticeService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 个人用户公告知识库相关请求控制器
 * <P>
 * File name : NoticeAndPolicyUser.java
 * </P>
 * <P>
 * Author : baishuangdong
 * </P>
 * <P>
 * Date : 2014-10-13
 * </P>
 */
@RequestMapping("/user")
@Controller
public class NoticeAndPolicyUserCtl {
	@Autowired
	private NoticeService noticeService;
	/*
	 * @Autowired private PolicyService policyService;
	 */
	@Autowired
	private SpringDataPool pool;

	/**
	 * 获取社区下所有公告
	 * 
	 * @param pageVO
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("noticelist")
	public String getNoticeList(PageParamVO pageVO, HttpServletRequest request, HttpServletResponse response) {
		UserVO user = (UserVO) request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		request.setAttribute("page", noticeService.list(pageVO.getPage(), pageVO.getNum(), communityId));
		return "user/noticelist";
	}

	@RequestMapping("noticedetail")
	public String getNotice(int id, HttpServletRequest request, HttpServletResponse response) {
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> categoryMap = category.get(CommunityConstants.NOTICECATEGORYID);
		request.setAttribute("categoryMap", categoryMap);
		request.setAttribute("notice", noticeService.getNotice(id));
		return "user/noticedetail";
	}

	/**
	 * 政策列表
	 * 
	 * @param pageVO
	 * @param request
	 * @return
	 */
	/*
	 * @RequestMapping("policylist") public String allPolicy(PageParamVO
	 * pageVO,HttpServletRequest request){ UserVO user =
	 * (UserVO)request.getSession().getAttribute(PropertyValueConstants.
	 * SESSION_USER);
	 * 
	 * Page<PPolicy> policy =
	 * policyService.getCommunityPolicyByPage(pageVO.getPage(),
	 * pageVO.getNum(),Integer.parseInt(user.getCommunityId()) );
	 * request.setAttribute("policylist", policy); return "user/policylist"; }
	 */
	/**
	 * 政策详细信息
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

	/*
	 * @RequestMapping("policydetail") public String detail(int
	 * id,HttpServletRequest request){ UserVO user =
	 * (UserVO)request.getSession().getAttribute(PropertyValueConstants.
	 * SESSION_USER); long userId = user.getId(); PPolicy policy =
	 * policyService.getById(id); List<PPolicyAtt> list =
	 * policyService.getPolicyAtts(id); List<UserPolicyCertVo> catlist =
	 * policyService.getPolicyCertifactes(id, userId);
	 * request.setAttribute("catlist", catlist); request.setAttribute("policy",
	 * policy); request.setAttribute("atts", list); return "user/policydetail";
	 * }
	 */
}
