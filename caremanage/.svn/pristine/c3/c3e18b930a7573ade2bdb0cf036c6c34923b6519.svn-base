/*package com.anticw.aged.controller.community.policy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.policy.PolicyRecommendedService;
import com.anticw.aged.service.community.policy.PolicyService;
import com.anticw.aged.service.community.policy.UserPolicyService;

@RequestMapping("/community/userpolicy")
@Controller
public class UserPolicyController {
	@Autowired
	private UserPolicyService userPolicyService;
	@Autowired
	private SpringDataPool pool;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private PolicyRecommendedService prs;
	@Autowired
	private OCountryService ocountryService;
	
	@RequestMapping("/save")
	public String savePolicy(PUserPolicy userPolicy,int state,HttpServletRequest request){
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		String opUser = user.getName();
		userPolicyService.saveUserPolicy(userPolicy, state, opUser, communityId);
		return "community/policy";
	}
	@RequestMapping("/policyofuser")
	public String listUserPolicyByUid(PageParamVO pageVO,int userId,HttpServletRequest request){
		Page<UserPolicyVo> page = userPolicyService.listByUser(pageVO.getPage(), pageVO.getNum(), userId);
		request.setAttribute("page", page);
		request.setAttribute("statearr", CommunityConstants.USERPOLICYSTATEMAP);
		return "community/policy/policyofuser";
	}
	
	*//**
	 * 政策推荐选项卡iframe
	 * @author guoyongxiang
	 * Date: 2014-10-13 下午3:27:20
	 * @param pageVO
	 * @param userId
	 * @return
	 *//*
	@RequestMapping("iframe/{userId}")
	public ModelAndView UserPolicyIframe(PageParamVO pageVO, @PathVariable int userId){
		Page<UserPolicyVo> upolicy = userPolicyService.listByUser(pageVO.getPage(), pageVO.getNum(), userId);
		ModelAndView mv = new ModelAndView("community/policy/iframe");
		mv.addObject("upolicy",upolicy);
		mv.addObject("statearr", CommunityConstants.USERPOLICYSTATEMAP);
		return mv;
	}
	@RequestMapping("handleiframe/{id}")
	public ModelAndView handleIframe(@PathVariable int id){
		ModelAndView mv = new ModelAndView("community/policy/handleiframe");
		PPolicyRecommend recomend = prs.findPolicyRecommendById(id);
		mv.addObject("recommend", recomend);
		List<PPolicyAtt> attlist = policyService.getPolicyAtts(recomend.getPolicy().getId());
		List<UserPolicyCertVo> catlist = policyService.getPolicyCertifactes(recomend.getPolicy().getId(),recomend.getUserId());
		mv.addObject("attlist", attlist);
		mv.addObject("catlist", catlist);
		return mv;
	}
	
	*//**
	 * 汇总页
	 * @param pageVO
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/list")
	public String listUserPolicy(PageParamVO pageVO,HttpServletRequest request,String communityId){
		//用户信息
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = communityId==null||"".equals(communityId)?user.getCommunityId():communityId;
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> catMap = category.get(CategoryEnum.POLICY.getIndex());
		Map<String, List<PPolicy>> policyMap = policyService.getCommPolicyMap(communityIds);
		Page<PUserPolicy> page = userPolicyService.list(pageVO.getPage(), pageVO.getNum(), communityIds);
		request.setAttribute("catMap", catMap);
		request.setAttribute("policyMap", policyMap);
		request.setAttribute("statearr", CommunityConstants.USERPOLICYSTATEMAP);
		request.setAttribute("page", page);
		//判断用户类型
		if(user.getCateEnum().equals(UserCategoryEnum.STREET)){
			// 查询当前用户社区列表
			List<OCountry> communitys = this.ocountryService.getCountryByIds(user.getCommunityId());
			request.setAttribute("communitys",communitys);
			request.setAttribute("communityId", communityId);
		}
		return "community/policy/gatherlist";
	}
	@RequestMapping("/search")
	public String searchUpolicy(UserPolicySearchVo searchVo,PageParamVO pageVO,HttpServletRequest request,String communityId){
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = communityId==null||"".equals(communityId)?user.getCommunityId():communityId;
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> catMap = category.get(CategoryEnum.POLICY.getIndex());
		Map<String, List<PPolicy>> policyMap = policyService.getCommPolicyMap(communityIds);
		Page<PUserPolicy> page = userPolicyService.queryPage(searchVo, pageVO.getPage(), pageVO.getNum(), communityIds);
		request.setAttribute("catMap", catMap);
		request.setAttribute("policyMap", policyMap);
		request.setAttribute("statearr", CommunityConstants.USERPOLICYSTATEMAP);
		request.setAttribute("searchVo", searchVo);
		request.setAttribute("page", page);
		//判断用户类型
		if(user.getCateEnum().equals(UserCategoryEnum.STREET)){
			// 查询当前用户社区列表
			List<OCountry> communitys = this.ocountryService.getCountryByIds(user.getCommunityId());
			request.setAttribute("communitys",communitys);
			request.setAttribute("communityId", communityId);
		}
		return "community/policy/gatherlist";
	}
	*//**
	 * 办理页
	 * @param id
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/toHandle")
	public String toHandle(int id,HttpServletRequest request){
		PUserPolicy userPolicy = userPolicyService.getById(id);
		List<UserPolicyCertVo> cllist = policyService.getPolicyCertifactes(userPolicy.getPolicyId(), Long.parseLong(userPolicy.getUserId().toString()));
		List<PPolicyAtt> attlist = policyService.getPolicyAtts(userPolicy.getPolicy().getId());
		request.setAttribute("catlist", cllist);
		request.setAttribute("attlist", attlist);
		request.setAttribute("recommend", userPolicy);
		return "community/policy/handle";
	}
	@RequestMapping("/toHandleIframe")
	public String toHandleIframe(int id,HttpServletRequest request){
		PUserPolicy userPolicy = userPolicyService.getById(id);
		List<UserPolicyCertVo> cllist = policyService.getPolicyCertifactes(userPolicy.getPolicyId(), Long.parseLong(userPolicy.getUserId().toString()));
		List<PPolicyAtt> attlist = policyService.getPolicyAtts(userPolicy.getPolicy().getId());
		request.setAttribute("catlist", cllist);
		request.setAttribute("attlist", attlist);
		request.setAttribute("recommend", userPolicy);
		return "community/policy/handleiframe";
	}
	*//**
	 * 领取已办理政策
	 * @param id
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping("/receive")
	public void receivePolicy(int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		try {
			userPolicyService.receiveUpolicy(id, opUser);
			response.getWriter().print("done");
		} catch (Exception e) {
			throw e;
		}
	}
	*//**
	 * 办理确认过的政策
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping("/handle")
	public void handlePolicy(int id,HttpServletRequest request,HttpServletResponse reponse) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		try {
			userPolicyService.changeUPState(id,opUser, CommunityConstants.USERPOLICYSTATE4);
			reponse.getWriter().print("done");
		} catch (Exception e) {
			throw e;
		}
	}
	*//**
	 * 导出excel
	 * @param searchVo
	 * @param request
	 * @param response
	 * @throws Exception
	 *//*
	@RequestMapping("/export")
	public void exportExcel(UserPolicySearchVo searchVo,UPolicyExprotPropVo prop,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String filename = formatter.format(new Date())+".xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment;filename="
				  + new String(filename.getBytes(), "iso-8859-1"));
		OutputStream os = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		userPolicyService.exportExcel(searchVo,prop,communityId, workbook);
		workbook.write();
		workbook.close();
	}
}
*/