package com.anticw.aged.controller.professional.vender.subclass;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MAssessConclusion;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.policy.UserPolicyService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.service.professional.MUserVenderService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.assess.ConclusionScreenVO;
import com.anticw.aged.vo.user.AssessUserVO;
/**
 * 
 * @author dx
 * 量表结论筛选
 *
 */
@Controller
public class ScaleScreenCtl {
	
	@Autowired
	private AssessService assessService;
	
	@Autowired
	private MVenderSiteService mVenderSiteService;
	
	@Autowired
	private OCountryService oCountryService;

	@Autowired
	private MUserVenderService mUserVenderService;
	
	@Autowired
	private VenderService venderService;
	
	@Autowired
	private RUserService ruserService;
	
	@Autowired
	private UserPolicyService userPolicyService;
	
	
	/**
	 * 跳转结论筛选
	 * @param session
	 * @param dateCond
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/professional/scaleScreen")
	public ModelAndView getCountAndUserList(HttpSession session, DateParamVO dateCond) throws BusinessException{

		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(dateCond.getStart()==null&&dateCond.getEnd()==null){//加载默认时间
			Date start = DateUtil.getFirstDayInMonth(new Date());
			Date end = DateUtil.getLastDayInMonth(new Date());
			dateCond = new DateParamVO(start, end);
		}
		ModelAndView mv=new ModelAndView("/professional/data/scaleScreen");
		
		
		//服务商帐号 true 获取站点
		if(userVO.isSuper_()&&userVO.getCateEnum().equals(UserCategoryEnum.PRO)){
			mv=new ModelAndView("/professional/data/scaleScreenPRO");
			mv.addObject("mVenderSite", mVenderSiteService.fingByVenderId(userVO.getVenderId()));
		}
		List<OCountry> oCountry=oCountryService.getCountryByIds(userVO.getCommunityId());//获取所有的社区
		mv.addObject("listAssessVO", assessService.getAllAssess(null));
		mv.addObject("dateCond", dateCond);
		mv.addObject("oCountry", oCountry);
		return mv;
	}
	/**
	 * 获取指定量表的所有结论
	 * @param scale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/scaleScreen/scaleVerdict")
	public @ResponseBody JSONObject conclusion(Integer scale) throws Exception{
		List<MAssessConclusion> conclusion = assessService.list(scale);
		JSONObject json =new JSONObject();
		json.put("conclusion", conclusion);
		return json;
	}
	/**
	 * 根据条件查询评估信息条数及人员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/professional/scaleScreen/demand")
	public  ModelAndView demand(HttpSession session,ConclusionScreenVO vo, DateParamVO dateCond,PageParamVO pagevo,String array,String array1) throws Exception{
		vo.setSiteId(0);
		ModelAndView mv=new ModelAndView("/professional/data/scaleScreen");
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		//除内部外 还有综合查询根据  时间
		Page<AssessUserVO> page=null;
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
			mv=new ModelAndView("/professional/data/scaleScreenPRO");
			page= mUserVenderService.getdemand(userVO.getVenderId(),vo, dateCond,pagevo);
			session.setAttribute("demand", page);
			mv.addObject("mVenderSite", mVenderSiteService.fingByVenderId(userVO.getVenderId()));
			mv.addObject("array", array);
			mv.addObject("array1", array1);
		}else if(userVO.getCateEnum()==UserCategoryEnum.CM){
			//数据库表单有  老人RUser   结论表MAssessRecord  
			//主要问题是加载cm下所有的服务商获取cm范围允许查询的老人 
			StringBuffer creatBy = getCreateBy(userVO);
			page= ruserService.getdemand(vo, dateCond,pagevo,creatBy.toString());
			//查询  根据社区Id查询 社区
		}
		mv.addObject("vo", vo);
		mv.addObject("listAssessVO", assessService.getAllAssess(null));
		mv.addObject("page", page);
		mv.addObject("dateCond", dateCond);
		List<OCountry> oCountry=oCountryService.getCountryByIds(userVO.getCommunityId());//获取所有的社区
		mv.addObject("oCountry", oCountry);
		mv.addObject("UserName", vo.getUserName());
		return mv;
	}
	@RequestMapping("/professional/scaleScreen/ajax")
	public @ResponseBody JSONObject getpage(HttpSession session){
		@SuppressWarnings("unchecked")
		Page<AssessUserVO> page=(Page<AssessUserVO>) session.getAttribute("demand");
		JSONObject json=new JSONObject();
		json.put("page", page.getResult());
		return json;
	}
	
	public StringBuffer getCreateBy(UserVO userVO) {
		String cmName=userVO.getName();
		StringBuffer creatBy= new StringBuffer();
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
		return creatBy;
	}
	
	/**
	 * 导出excel
	 * @param request
	 * @param response
	 * @param session
	 * @param vo
	 * @param dateCond
	 * @throws Exception
	 */
	@RequestMapping("/professional/scaleScreen/export")
	public  void export(HttpSession session,HttpServletResponse response,String assessName,String assessConclusion,
			ConclusionScreenVO vo, DateParamVO dateCond,String userIds,String array1,HttpServletRequest request,String recordIdsUser) throws Exception{
		if(dateCond.getStart()==null&&dateCond.getEnd()==null){//加载默认时间
			Date start = DateUtil.getFirstDayInMonth(new Date());
			Date end = DateUtil.getLastDayInMonth(new Date());
			dateCond = new DateParamVO(start, end);
		}
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<AssessUserVO> vo1;
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String filename = formatter.format(new Date())+".xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment;filename="
				  + new String(filename.getBytes(), "iso-8859-1"));
		OutputStream os = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		if(userVO.getCateEnum()==UserCategoryEnum.PRO){
			vo1=mUserVenderService.demandList(vo, dateCond,userVO.getVenderId(),userIds,recordIdsUser);
			userPolicyService.assessExcel(session,workbook,vo1, dateCond,assessName,assessConclusion,array1);
		}else{
			StringBuffer creatBy = getCreateBy(userVO);
			vo1=ruserService.demandList(vo, dateCond,creatBy.toString());
			userPolicyService.assessExcel(session,workbook,vo1, dateCond,assessName,assessConclusion);
		}
		workbook.write();
		workbook.close();
	}
	
}
