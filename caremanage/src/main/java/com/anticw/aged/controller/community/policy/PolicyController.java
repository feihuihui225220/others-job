/*package com.anticw.aged.controller.community.policy;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.PPolicy;
import com.anticw.aged.bean.PPolicyAtt;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.policy.PolicyService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

*//**
 * 政策控制类
 * @author L
 *
 *//*
@RequestMapping(value="/admin/policy")
@Controller
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	@Autowired
	private SpringDataPool pool;
	@Autowired
	private OCountryService countryService;
	@Autowired
	private AttchmentHandle attchmentHandle;
	*//**
	 * 所有政策
	 * 2014-10-1
	 * @param pageVO
	 * @return
	 *//*
	@RequestMapping(value="/list")
	public String allPolicy(PageParamVO pageVO,HttpServletRequest request){
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> clMap = category.get(CategoryEnum.CERFI.getIndex());
		Page<PPolicy> page = policyService.getPolicyByPage(pageVO.getPage(), pageVO.getNum());
		request.setAttribute("clMap", clMap);
		request.setAttribute("page", page);
		return "community/policy/all";
	}
	*//**
	 * 社区下所有政策
	 * @param pageVO
	 * @return
	 *//*
	@RequestMapping(value="/list.json")
	public @ResponseBody String communityPolicy(PageParamVO pageVO,int communityId,String callback){ 
		Page<PPolicy> page = policyService.getCommunityPolicyByPage(pageVO.getPage(), pageVO.getNum(),communityId);
		return PublicService.returnPageJSONP(ExceptionCode.SUCCESS, page,callback);
	}
	*//**
	 * 政策添加页
	 * 李飞
	 * 2014-10-6
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value="toAdd")
	public String toAdd(HttpServletRequest request){
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> clMap = category.get(CategoryEnum.CERFI.getIndex());
		Map<Integer, OCategoryItem> catMap = category.get(CategoryEnum.POLICY.getIndex());
		request.setAttribute("catMap", catMap);
		request.setAttribute("clMap", clMap);
		return "community/policy/addpolicy";
	}
	*//**
	 * 编辑政策
	 * @param id
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value="toEdit")
	public String toEdit(int id,HttpServletRequest request){
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> clMap = category.get(CategoryEnum.CERFI.getIndex());
		Map<Integer, OCategoryItem> catMap = category.get(CategoryEnum.POLICY.getIndex());
		request.setAttribute("catMap", catMap);
		request.setAttribute("clMap", clMap);
		PPolicy policy = policyService.getById(id);
		List<PPolicyAtt> list = policyService.getPolicyAtts(id);
		request.setAttribute("policy", policy);
		request.setAttribute("atts", list);
		return "community/policy/editpolicy";
	}
	
	@RequestMapping("/toPublish")
	public String toPublish(int id,HttpServletRequest request){
		PPolicy policy = policyService.getById(id);
		request.setAttribute("policy", policy);
		request.setAttribute("id", id);
		return "community/policy/publish";
	}
	*//**
	 * 添加政策
	 * 2014-10-1
	 * @param policy
	 * @param files
	 * @throws Exception 
	 *//*
	@RequestMapping(value="/add")
	public void addPolicy(PPolicy policy,@RequestParam(value = "file", required = false) MultipartFile[] file,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		*//**
		 * 获取所需材料，拼成字符串
		 *//*
		
		String[] clarr = request.getParameterValues("cailiao");
		if(clarr!=null){
			StringBuilder sb = new StringBuilder();
			for(String str:clarr){
				sb.append(str);
				sb.append(",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			policy.setCertificate(sb.toString());
		}
		
		
		try {
			policyService.savePolicy(policy,opUser,file);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping(value="/edit")
	public void editPolicy(PPolicy policy,@RequestParam(value = "file", required = false) MultipartFile[] file,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		*//**
		 * 获取所需材料，拼成字符串
		 *//*
		
		String[] clarr = request.getParameterValues("cailiao");
		if(clarr!=null){
			StringBuilder sb = new StringBuilder();
			for(String str:clarr){
				sb.append(str);
				sb.append(",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			policy.setCertificate(sb.toString());
		}
		try {
			policyService.editPolicy(policy,opUser,file);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw e;
		}
	}
	*//**
	 * 删除政策
	 * 2014-10-1
	 * @param id
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping(value="delete")
	public void deletePolicy(int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		try {
			policyService.deletePolicy(id, opUser);
			response.getWriter().print("<script type='text/javascript'>window.location.href=document.referrer</script>");
		} catch (Exception e) {
			throw e;
		}
	}
	*//**
	 * 删除政策附件
	 * 2014-10-1
	 * @param id
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping(value="/Att/delete")
	public void deletePolicyAtt(int id,HttpServletResponse response) throws Exception{
		try{
			policyService.deletePolicyAtt(id);
			response.getWriter().print("done");
		}catch(Exception e){
			throw e;
		}
	}
	*//**
	 * 发布政策
	 * @param id
	 * @param countryId
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping(value="/publish")
	public String publishPolicy(int id,HttpServletRequest request) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		*//**
		 * 获取点选社区，拼成字符串
		 *//*
		String communityId = "";
		String[] clarr = request.getParameterValues("shequId");
		if(clarr!=null){
			StringBuilder sb = new StringBuilder();
			for(String str:clarr){
				sb.append(str);
				sb.append(",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			communityId = sb.toString();
		}
		policyService.publishPolicy(id,communityId,opUser);
		return "redirect:/admin/policy/list";	
	}
	*//**
	 * 政策详细信息
	 * @param id
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value="/detail")
	public String detail(int id,HttpServletRequest request){
		
		PPolicy policy = policyService.getById(id);
		
		List<PPolicyAtt> list = policyService.getPolicyAtts(id);
		request.setAttribute("policy", policy);
		request.setAttribute("atts", list);
		return "community/policy/policydetial";
	}
}
*/