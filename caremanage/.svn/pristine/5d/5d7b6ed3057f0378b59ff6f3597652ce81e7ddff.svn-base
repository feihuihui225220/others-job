/*package com.anticw.aged.controller.community.policy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.PPolicyAtt;
import com.anticw.aged.bean.PPolicyRecommend;
import com.anticw.aged.bean.PUserPolicy;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.policy.PolicyRecommendTask;
import com.anticw.aged.service.community.policy.PolicyRecommendedService;
import com.anticw.aged.service.community.policy.PolicyService;
import com.anticw.aged.service.community.policy.UserPolicyService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.community.PolicyRecommendVo;
import com.anticw.aged.vo.community.UserPolicyCertVo;
import com.anticw.aged.vo.permission.UserVO;


*//**
 * 政策推荐控制类
 * @author L
 *
 *//*
@RequestMapping(value="/community/policyRecommend")
@Controller
public class PolicyRecommendController {
	
	@Autowired
	private RUserService rUserService;
	@Autowired
	private PolicyRecommendedService prs;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private UserPolicyService upolicyService;
	@Autowired
	private PolicyRecommendTask policyRecommendTask;
	@Autowired
	private OCountryService ocountryService;
	
	*//**
	 * 根据老人id获取推荐
	 * @param userId
	 * @param callback
	 * @return
	 *//*
	@RequestMapping("recommend.json")
	public @ResponseBody String recommendPolicyByUserId(Long userId,PageParamVO pageVo,String callback){
		
		Page<PPolicyRecommend> page = prs.findPageByUserId(userId, pageVo.getPage(), pageVo.getNum());
		
		return PublicService.returnPageJSONP(ExceptionCode.SUCCESS,page,callback);
	}
	
	*//**
	 * 社区下所有推荐的政策
	 * 2014-10-2
	 * @param pageVO
	 * @return
	 *//*
	@RequestMapping(value="/list")
	public String allRecommendPolicy(PageParamVO pageVO,HttpServletRequest request,String communityId){
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String communityIds = communityId==null||"".equals(communityId)?user.getCommunityId():communityId;
		Page<PolicyRecommendVo> page = prs.listPageByCommID(pageVO.getPage(), pageVO.getNum(), communityIds);
		request.setAttribute("page", page);
		//判断用户类型
		if(user.getCateEnum().equals(UserCategoryEnum.STREET)){
			// 查询当前用户社区列表
			List<OCountry> communitys = this.ocountryService.getCountryByIds(user.getCommunityId());
			request.setAttribute("communitys",communitys);
			request.setAttribute("communityId", communityId);
		}
		return "community/policy/recommendlist";
	}
	*//**
	 * 根据推荐，办理政策页面
	 * 李飞
	 *//*
	@RequestMapping("/toadd")
	public String toAddUserPolicy(int id,HttpServletRequest request){
		PPolicyRecommend recomend = prs.findPolicyRecommendById(id);
		request.setAttribute("recommend", recomend);
		List<PPolicyAtt> attlist = policyService.getPolicyAtts(recomend.getPolicy().getId());
		List<UserPolicyCertVo> catlist = policyService.getPolicyCertifactes(recomend.getPolicy().getId(),recomend.getUserId());
		request.setAttribute("attlist", attlist);
		request.setAttribute("catlist", catlist);
		
		return "community/policy/toaddupolicy";
	}
	@RequestMapping("/toaddiframe")
	public String toAddUserPolicyIframe(int id,HttpServletRequest request){
		PPolicyRecommend recomend = prs.findPolicyRecommendById(id);
		request.setAttribute("recommend", recomend);
		List<PPolicyAtt> attlist = policyService.getPolicyAtts(recomend.getPolicy().getId());
		List<UserPolicyCertVo> catlist = policyService.getPolicyCertifactes(recomend.getPolicy().getId(),recomend.getUserId());
		request.setAttribute("attlist", attlist);
		request.setAttribute("catlist", catlist);
		
		return "community/policy/toaddupolicyiframe";
	}
	*//**
	 * 办理政策
	 * 李飞
	 * @throws IOException 
	 *//*
	@RequestMapping("/add")
	public void addUserPolicy(int id,int status,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		//int communityId = Integer.parseInt(user.getCommunityId());
		String opUser = user.getName();
		try {
			PPolicyRecommend recommend = prs.findPolicyRecommendById(id);
			RUser ruser = rUserService.findById(recommend.getUserId());
			PUserPolicy up = new PUserPolicy();
			up.setUserId(recommend.getUserId().intValue());
			up.setPolicyId(recommend.getPolicyId());
			upolicyService.saveUserPolicy(up, status, opUser, ruser.getCommunityId());
			prs.setRecommendtoDone(id);
			response.getWriter().print("done");
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping("/iframe")
	public String UserPolicy(int userId,HttpServletRequest request){
		List<PPolicyRecommend> recomendlist = prs.findPolicyRecommendByUserId(userId);
		
		request.setAttribute("recomendlist", recomendlist);
		
		return "community/policy/urecommendiframe";
	}
	*//**
	 * 手动执行政策推荐url
	 * @return
	 *//*
	@RequestMapping("/recommendUrl")
	public @ResponseBody String recommendUrl(){
		try {
			policyRecommendTask.recommend();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		return "ok";
	}
	
}
*/