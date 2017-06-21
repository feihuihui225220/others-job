package com.anticw.aged.controller.director;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.HTransfer;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.director.GroupService;
import com.anticw.aged.service.transfer.HTransferService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.DirectorUserVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
public class HTransferController {
	
	@Autowired
	private HTransferService transferService;
	
	/**
	 * 用户信息管理
	 */
	@Autowired
	private RUserService rUserService;
	
	@Autowired
	private GroupService groupService;
	/**
	 * 转诊查询
	 * @param request
	 * @param page
	 * @param start
	 * @param end
	 * @param state
	 * @param esc
	 * @param userId
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("/director/HTransfer")
	public String listHTransfer(HttpSession session,HttpServletRequest request,PageParamVO page,
			String start,String end,String state,Integer esc,String userId) throws IllegalAccessException, InvocationTargetException{
		Page<HTransfer> pageInfo=transferService.lsitHtransfer(page,start,end,state,esc,userId);
		
		if (userId != null) {
			RUser user = rUserService.findById(Long.valueOf(userId));
			DirectorUserVO dirUser = new DirectorUserVO();
			BeanUtils.copyProperties(dirUser, user);
			if(user.getrUserDefault()!=null){
				dirUser.setMedicalHistory(user.getrUserDefault()
						.getMedicalHistory());
				dirUser.setAllergy(user.getrUserDefault().getAllergy());
			}
			session.setAttribute("dirUser", dirUser);
		}
		request.setAttribute("page",pageInfo);
		request.setAttribute("start",start);
		request.setAttribute("end",end);
		request.setAttribute("state",state);
		request.setAttribute("esc",esc);
		
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(userVo.isSuper_()){
			if(userId!=null){
				return "/director/transfer/userHtransRecord";
			}else{
				return "/director/transfer/HTransfer";//主任
			}
		}else{
			return "/director/transfer/userHtransRecord";//巡诊组
		}
		
	}
	/**
	 * 巡诊组
	 * @param request
	 * @param uId
	 * @return
	 */
	@RequestMapping("/director/addHTransferhtml")
	public String addHTransferhtml(){
		return "director/transfer/addHtransRecord";
	}
	
	/**
	 * 巡诊组申请转诊
	 * @param session
	 * @param content
	 * @param uId
	 * @return
	 */
	@RequestMapping("/director/addHTransfer")
	@ResponseBody
	public String addHTransfer(HttpSession session,String content,String uId){
		String result="";
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		//根据uid查询ruser对象
		RUser rUser=rUserService.findById(Long.valueOf(uId));
		//根据当前登录的ID查询巡诊组
		HGroup group=groupService.findByUserId((int)userVo.getId()).get(0);
		HTransfer transfer=new HTransfer();
		transfer.setCreateTime(new Date());
		transfer.setContent(content);
		transfer.setCreateBy(userVo.getName());
		transfer.setrUser(rUser);
		transfer.sethGroup(group);
		transfer.setState("1");
		transfer.setApplyTime(new Date());
		try {
			transferService.addHTransfer(transfer);
			result="OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 主任查看转诊记录详情
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * 
	 */
	@RequestMapping("director/HTransfer/byId")
	public ModelAndView htransferById(HttpSession session,Integer htId,String userId) throws IllegalAccessException, InvocationTargetException{
		RUser user=rUserService.findById(Long.valueOf(userId));
		com.anticw.aged.vo.director.DirectorUserVO dirUser=new com.anticw.aged.vo.director.DirectorUserVO();
		BeanUtils.copyProperties(dirUser, user);
		dirUser.setMedicalHistory(user.getrUserDefault().getMedicalHistory());
		dirUser.setAllergy(user.getrUserDefault().getAllergy());
		session.setAttribute("dirUser", dirUser);
		ModelAndView view=new ModelAndView("director/transfer/HtransById");
		view.addObject("htransfer", transferService.htransferById(htId));
		return view;
	}
	/**
	 * 修改htransfer表
	 */
	@RequestMapping("director/HTransfer/ModifyHtransfer")
	public String modifyHtransfer(HTransfer transfer,HttpSession session,String applyTime){
		HTransfer hTransfer=transferService.htransferById(transfer.getId());
		hTransfer.setApplyTime(DateUtil.parseStrToDateTimem(applyTime));
		hTransfer.setOriginalHospital(transfer.getOriginalHospital());//原来医院
		hTransfer.setDoctor(transfer.getDoctor());
		hTransfer.setContent(transfer.getContent());
		hTransfer.setTargetHospital(transfer.getTargetHospital());//目标医院
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		hTransfer.setChangeBy(userVo.getName());
		hTransfer.setChangeTime(new Date());
		hTransfer.setState("2");
		hTransfer.setHandleResult(transfer.getHandleResult());
		try {
			transferService.modifyHTransfer(hTransfer);
			//修改r_user表的状态
			RUser user=rUserService.findById(hTransfer.getrUser().getId());
			user.setState(2);
			rUserService.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*return "redirect:/director/HTransfer/byId?htId="+hTransfer.getId()+"&userId="+hTransfer.getrUser().getId();*/
		return "redirect:/director/HTransfer?userId="+hTransfer.getrUser().getId();
	}
}
