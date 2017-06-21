package com.anticw.aged.controller.icare;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.ZVipIntroduce;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.icare.ZVipIntroduceService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
public class ZVipIntroduceCtl {
	@Autowired
	private ZVipIntroduceService zVipIntroduceService;
	@Autowired
	private FileHandle fileHandle;
	
	/**
	 * 添加
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("/icare/vip/add")
	public String add(ZVipIntroduce z,HttpSession session,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException{
		String url=fileHandle.uploadPicse("file/photo/",pic);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String user= userVo.getName();
		z.setCreateUser(user);
		z.setUrl(url);
		Date date = new Date();
		z.setCreateTime(date);
		z.setAvailable(true);
		z.setVersion(1);
		zVipIntroduceService.add(z);
		return "redirect:/icare/vip/getList";
	}
	
	/**
	 * 删除
	 *
	 */
	@RequestMapping("/icare/vip/delete")
	public String  delete(Integer id){
		zVipIntroduceService.delete(id);
		return "redirect:/icare/vip/getList";
	}
	/**
	 * 修改
	 */
	@RequestMapping("/icare/vip/edit")
	public String  edit(Integer id,HttpServletRequest request){
		ZVipIntroduce z = zVipIntroduceService.getById(id);
		request.setAttribute("list",z);
		return "ICare/vip/infoedit";
	}
	@RequestMapping("/icare/vip/modify")
	public String modify(ZVipIntroduce z,HttpSession session,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException{
		ZVipIntroduce vip =zVipIntroduceService.getById(z.getId());
		String oldUrl= vip.getUrl();
		if(!pic.isEmpty()){
			String url=fileHandle.uploadPicse("file/photo/",pic);
			vip.setUrl(url);
			fileHandle.remove(oldUrl);
		}		
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String user= userVo.getName();		
		vip.setChangeUser(user);
		vip.setServiceName(z.getServiceName());
		vip.setChargeInfo(z.getChargeInfo());
		vip.setServiceDetail(z.getServiceDetail());
		Date date= new Date();
		vip.setChangeTime(date);
		zVipIntroduceService.modify(vip);
		return "redirect:/icare/vip/getList";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/vip/get")
	public String  getById(Integer id,HttpServletRequest request){
		request.setAttribute("vip", zVipIntroduceService.getById(id) );
		return "ICare/vip/detail";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("/icare/vip/getList")
	public String getList(HttpServletRequest request) {
		List<ZVipIntroduce> list = zVipIntroduceService.getList();
		request.setAttribute("vip", list);
		return "ICare/vip/infolist";
	}
	

}
