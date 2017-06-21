package com.anticw.aged.controller.icare.vip;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.ZGuidePhoto;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.icare.vip.GuidePhotoService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/guidePhoto/")
public class GuidePhotoCtl {
	@Autowired
	private GuidePhotoService guidePhoneService;
	@Autowired
	private FileHandle fileHandle;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "/ICare/vip/picture";
	}
	/**
	 * 添加
	 *@param 
	 *@return
	 * @throws IOException 
	 */
	@RequestMapping("add")
	public String addGuidePhone(ZGuidePhoto guidePhone,@RequestParam(value="pic", required=false)MultipartFile pic)
			throws BusinessException, IOException{
		String url = fileHandle.uploadPic(pic);
		guidePhone.setPhotoUrl(url);
		guidePhoneService.add(guidePhone);
		return "redirect:getList";
	}	
	/**
	 * 删除
	 *
	 */
	@RequestMapping("remove/{id}")
	public String  removeGuidePhone(@PathVariable("id")int id,String url){
		fileHandle.remove(url);
		guidePhoneService.remove(id);
		return "redirect:/guidePhoto/getList";
	}
	/**
	 * 修改
	 */
	@RequestMapping("modify")
	public String modifyGuidePhone(ZGuidePhoto guidePhone,String type)
			throws BusinessException{
		if ("0".equals(type)) {
			guidePhone.setAvailable(false);
		}else{
			guidePhone.setAvailable(true);
		}
		guidePhoneService.modify(guidePhone);
		return "redirect:/guidePhoto/getList";
	}
	/**
	 * 查询一条记录
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getGuidePhoneById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("guidePhone", guidePhoneService.getById(id));
		return "";
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("getList")
	public String getGuidePhoneList(PageParamVO page,HttpServletRequest request) {
		Page<ZGuidePhoto> pageInfo = guidePhoneService.getList(page.getPage(), page.getNum());
		request.setAttribute("page",pageInfo);
		return "/ICare/vip/picture";
	}
	

}
