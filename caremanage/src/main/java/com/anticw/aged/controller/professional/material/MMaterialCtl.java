package com.anticw.aged.controller.professional.material;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MMaterial;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.professional.material.MMaterialService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author DX  2016/6/19
 *
 */
@Controller
public class MMaterialCtl {
	
	@Autowired
	private MMaterialService mMaterialService;
	
	@Autowired
	private FileHandle fileHandle;
	
	@RequestMapping("/professional/material/select")
	public ModelAndView selcetList(HttpSession session,MMaterial mMaterial,PageParamVO pageVO){
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<MMaterial> page=mMaterialService.list(userVo.getVenderId(), pageVO.getPage(), pageVO.getNum(),mMaterial);
		ModelAndView mv=new ModelAndView("/professional/material/materials");
		mv.addObject("page", page);
		mv.addObject("mMaterial", mMaterial);
		return mv;
		
	}
	
	@RequestMapping("/professional/material/add")
	public ModelAndView addMaterial(HttpSession session,MMaterial mMaterial,@RequestParam(value = "pic", required = false)MultipartFile pic) throws IOException{
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String fileUrl = fileHandle.uploadfileUrl(pic,"file/mMaterial/");
		mMaterial.setImgUrl(fileUrl);
		mMaterialService.save(mMaterial,userVo);
		return new  ModelAndView(new RedirectView("/professional/material/select"));
	}
	
	@RequestMapping("/professional/material/update")
	public ModelAndView updateMaterial(HttpSession session,MMaterial mMaterial,@RequestParam(value = "pic", required = false)MultipartFile pic) throws IOException{
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if(pic!=null){
			String fileUrl = fileHandle.uploadfileUrl(pic,"file/mMaterial/");
			mMaterial.setImgUrl(fileUrl);
		}
		mMaterial.setChangedBy(userVo.getName());
		mMaterialService.updateMMaterial(mMaterial);
		return new  ModelAndView(new RedirectView("/professional/material/select"));
	}
	
	@RequestMapping("/professional/material/remove")
	public @ResponseBody String removeMaterial(MMaterial mMaterial) throws IOException{
		MMaterial m=mMaterialService.selectById(mMaterial.getId());
		fileHandle.removePic(m.getImgUrl(),"file/mMaterial/");
		mMaterialService.removeById(m.getId());
		return "success";
	}
	@RequestMapping("/professional/material/List")
	public @ResponseBody List<MMaterial> Listmaterial(HttpSession session,String name){
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		
		List<MMaterial> mMaterial=mMaterialService.getList(name,userVo.getVenderId());
		return mMaterial;
	}
	
}
