package com.anticw.aged.controller.icare.news;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.user.RegisterVO;
/**
 * @version2.0
 * @author wxs
 *	2017-3-3
 */
@Controller
@RequestMapping("/rContact/")
public class RuserContactCtl {

	@Autowired
	private RUserService rUserService;
	 
	/**
	 * 根据ID查询rContact表中的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("rContactsById")
	@ResponseBody
	public String rContactsById(Long id){
		String result=null;
		RUser user=this.rUserService.findById(id);
		RContact rContact=this.rUserService.rContactsByIds(user);
		if(rContact!=null){
			result="OK";
		}else{
			StringBuffer buffer=new StringBuffer();
			buffer.append(user.getName());
			result=buffer.toString();
		}
		return result;
	}
	
	 @RequestMapping("saveRContacts")
	public ModelAndView saveRContacts(Long id,String urgentName,String urgentPhone,String phone,String serviceId,HttpSession session){
		UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
	 
			//判断绑定手机号是否注册
			 
			//将id（用户ID）,紧急联系人名字，紧急联系电话添加到r_contacts表中
			RUser user=this.rUserService.findById(id);
			String[] strName = urgentName.split(",");
			String[] strPhone = urgentPhone.split(",");
			
			for (int i = 0; i < strName.length; i++) {
				rUserService.saveRContacts(strName[i],strPhone[i],user,userVo.getName());
			}
			
			/*if(boolean1==true&&ruser!=null){
				friendShipDaoService.saveZFriendShip(id,ruser.getId(),userVo.getName());
				//result="OK";添加紧急联系人、绑定账号成功！
				
			}else if(boolean1==true&&ruser==null){
				//如果该手机号未注册，注册该手机号，密码为手机号后六位
				RegisterVO regVO =new RegisterVO();
				regVO.setMobilePhone(phone);
				try {
					Long newUserId=rUserService.register(regVO);
					friendShipDaoService.saveZFriendShip(id,newUserId,userVo.getName());
					//result="mOK";添加绑定账号成功！
					//return "redirect:/professional/service/checkout?serviceId="+serviceId+"&userId="+id;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					//result="Merror";//添加紧急联系人成功，绑定账号失败！
				}*/
			//}
		 
		return new ModelAndView(new RedirectView("/professional/service/checkout?serviceId="+serviceId+"&userId="+id));
	}
	/*//**
	 * 生成二维码
	 * @param requset
	 * @param response
	 * @throws Exception
	 *//*
	@Autowired
	private EncoderHandler encoderHandler;
	@RequestMapping("encoderHandler")
	public void encoderHandler()throws Exception {  
			String content="https://www.baidu.com/weixin/addFriendShip?id=";
			Long id=(long)122;
			StringBuffer buffer=new StringBuffer();
			buffer.append(content);
			buffer.append(id);
		   encoderHandler.encoderQRCoder(buffer.toString(),id); 
	}
	*//**
	 * 解析二维码
	 *//*
	@RequestMapping("decoderQRCode")
	@ResponseBody
	public String decoderQRCode(){
		Long id =(long) 122;
		 //二维码存储路径
		return encoderHandler.decoderQRCode(id);
	}*/
	
}
