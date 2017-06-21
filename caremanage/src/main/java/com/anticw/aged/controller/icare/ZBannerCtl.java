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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.ZBanner;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.icare.ZBannerService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.permission.UserVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
public class ZBannerCtl {
	@Autowired
	private ZBannerService zBannerService;
	@Autowired
	 private FileHandle fileHandle;
	/**
	 * 查询所有
	 */
	@RequestMapping("/icare/banner/getList")
	public String getBannerList(HttpServletRequest request) {
		List<ZBanner> list= zBannerService.getBannerList();
		request.setAttribute("list",list);
		return "ICare/banner/list";
	}

	/**
	 * 添加
	 *@param 
	 *@return
	 */
	@RequestMapping("/icare/banner/add")
	public String addBanner(ZBanner zBanner,HttpSession session,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException {
		String url=fileHandle.uploadPicse("file/photo/",pic);
		UserVO userVo = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		String createsBy = userVo.getName();
		zBanner.setUrl(url);
		zBanner.setType(1);
		zBanner.setAvailable(1);
		Date date = new Date();
		zBanner.setCreatedAt(date);
		zBanner.setCreatesBy(createsBy);
		zBannerService.addBanner(zBanner);
		return "redirect:/icare/banner/getList";
	}	
	/**
	 * 修改
	 */
	@RequestMapping("/icare/banner/edit")
	public String modifyBanner(int id,HttpServletRequest request){
		ZBanner z= zBannerService.getBannerById(id);
		request.setAttribute("list",z);
		return "ICare/banner/edit";
	}
	@RequestMapping("/icare/banner/modify")
	public String modifyBanner(ZBanner zBanner,
			@RequestParam(value="pic", required=false)MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException {
		ZBanner z = zBannerService.getBannerById(zBanner.getId());
		String oldUrl=z.getUrl();
		if(!pic.isEmpty()){
		String url=fileHandle.uploadPicse("file/photo/",pic);		
		z.setUrl(url);
		fileHandle.remove(oldUrl);
		}		
        z.setName(zBanner.getName());        
        z.setType(zBanner.getType());
        z.setLinkUrl(zBanner.getLinkUrl());       
		zBannerService.modifyBanner(z);
		return "redirect:/icare/banner/getList";
	}
	/**
	 * 删除
	 *
	 */
	@RequestMapping("/icare/banner/delete")
	public String  deleteById(int id){
		zBannerService.deleteById(id);
		return "redirect:/icare/banner/getList";
	}
	
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("/icare/banner/get/{id}")
	public String  getBannerById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("banner", zBannerService.getBannerById(id) );
		return "";
	}

	

}
