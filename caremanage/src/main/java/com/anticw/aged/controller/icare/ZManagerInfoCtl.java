package com.anticw.aged.controller.icare;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.icare.ZManagerInfoService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
public class ZManagerInfoCtl {
	@Autowired
	private ZManagerInfoService zManagerInfoService;
	@Autowired
	private FileHandle fileHandle;
	/**
	 * 添加
	 *@param careFeedback
	 *@return
	 */
	@RequestMapping("/icare/managerInfo/add")
	public String add(ZManagerInfo zManagerInfo,HttpSession session,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException{
		String url=fileHandle.uploadPicse("file/photo/",pic);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String user= userVo.getName();
		zManagerInfo.setHeadUrl(url);
		zManagerInfo.setCreateUser(user);
		Date date = new Date();
		zManagerInfo.setCreateTime(date);
		zManagerInfo.setAvailable(true);
		zManagerInfo.setVersion(1);
		zManagerInfoService.add(zManagerInfo);
		return "redirect:/icare/managerInfo/getList";
	}
	
	/**
	 * 删除
	 *
	 */
	@RequestMapping("/icare/managerInfo/delete")
	public String  delete(Integer id){
		zManagerInfoService.delete(id);
		return "redirect:/icare/managerInfo/getList";
	}
	/**
	 * 修改
	 */
	@RequestMapping("/icare/managerInfo/edit")
	public String  toEdit(Integer id,HttpServletRequest request){
		ZManagerInfo z= zManagerInfoService.getById(id);
		request.setAttribute("list",z);
		return "ICare/managerInfo/edit";
	}
	@RequestMapping("/icare/managerInfo/modify")
	public String modify(ZManagerInfo z,HttpSession session,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException{
		ZManagerInfo zm= zManagerInfoService.getById(z.getId());
		String oldUrl=zm.getHeadUrl();
		if(!pic.isEmpty()){
		String url=fileHandle.uploadPicse("file/photo/",pic);
		zm.setHeadUrl(url);
		fileHandle.remove(oldUrl);
		}
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String user= userVo.getName();
		zm.setName(z.getName());
		zm.setMotto(z.getMotto());
		zm.setSpeciality(z.getSpeciality());
		zm.setDetail(z.getDetail());
		zm.setChangeUser(user);
		Date date = new Date();
		zm.setChangeTime(date);
		zm.setAvailable(true);
		zm.setVersion(1);
		zManagerInfoService.modify(zm);
		return "redirect:/icare/managerInfo/getList";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/managerInfo/detail")
	public String  getById(Integer id,HttpServletRequest request){
		request.setAttribute("banner", zManagerInfoService.getById(id) );
		return "ICare/managerInfo/detail";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("/icare/managerInfo/getList")
	public String getList(PageParamVO page,HttpServletRequest request) {
		request.setAttribute("page", zManagerInfoService.getList(page));
		return "ICare/managerInfo/list";
	}
	

}
