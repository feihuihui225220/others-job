package com.anticw.aged.controller.professional.site;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.utils.file.FileType;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author dx  2016/3/4
 *
 */
@Controller
public class MVenderSiteCtl {
	@Autowired
	private MVenderSiteService mVenderSiteService;

	@Autowired
	private FileHandle fileHandle;
	
	@Autowired
    private OCountryService oCountryService;
	
	@RequestMapping("/professional/site/sitemanage")
	private ModelAndView select(HttpSession session,PageParamVO page,DateParamVO date,MVenderSite m){
		ModelAndView mv = new ModelAndView("professional/vender/site/select_site");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		Page<MVenderSite> mVenderSiteList=mVenderSiteService.getPage(userVO.getVenderId(), page, m, date);
		mv.addObject("page", mVenderSiteList);
		return mv;
	}
	@RequestMapping("/professional/site/toSave")
	private ModelAndView toSave(HttpSession session){
		ModelAndView mv = new ModelAndView("professional/vender/site/save_site");
		return mv;
	}
	
	/**
	 * 添加服务商站点
	 * @param session
	 * @param mVenderSite
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/professional/site/save")
	public ModelAndView fingByVenderId(HttpSession session,MVenderSite mVenderSite,
			@RequestParam(value = "pic", required = false)MultipartFile[] pic) throws IOException{
		UserVO userVo=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<String> imgUrl = fileHandle.upload(FileType.pic,pic);
		String url=StringUtils.join(imgUrl.toArray(),",");
		mVenderSite.setImgUrl(url);
		int venderId=userVo.getVenderId();
		mVenderSite.setVenderId(venderId);
		mVenderSite.setAvailable(false);
		mVenderSite.setChangedAt(new Date());
		mVenderSite.setChangedBy(userVo.getName());
		mVenderSite.setCreatedAt(new Date());
		mVenderSite.setCreatedBy(userVo.getName());
		mVenderSite.setVersion(0);
		mVenderSiteService.save(mVenderSite);
		return new ModelAndView(new RedirectView("/professional/site/sitemanage"));
	}
	/*@RequestMapping("tosave")
	public ModelAndView toSave(HttpSession session,MVenderSite mVenderSite){
		ModelAndView mv = new ModelAndView("professional/vender/site/updateAndSaveSite");
		mv.addObject("isAdd", true);
		return mv;
	}*/
	/**
	 * 修改站点名称
	 * @param session
	 * @param mVenderSite
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/professional/site/update")
	public ModelAndView updateMvenderSite(HttpSession session,MVenderSite mVenderSite,@RequestParam(value = "pic", required = false)MultipartFile[] pic) throws IOException{
		MVenderSite m = mVenderSiteService.fingById(mVenderSite.getId());
		List<String> imgUrl = fileHandle.upload(FileType.pic, pic);
		if(m.getImgUrl()!=null&&imgUrl!=null&&imgUrl.size()!=0){
			fileHandle.removeSite(m.getImgUrl());
			String url=StringUtils.join(imgUrl.toArray(),",");
			m.setImgUrl(url);
		}
		m.setCommunityIds(mVenderSite.getCommunityIds());
		m.setChangedAt(new Date());
		m.setVersion(m.getVersion()+1);
		m.setSiteName(mVenderSite.getSiteName());
		m.setSiteArea(mVenderSite.getSiteArea());
		m.setsAddress(mVenderSite.getsAddress());
		m.setsFixture(mVenderSite.getsFixture());
		mVenderSiteService.update(m);
		return new ModelAndView(new RedirectView("/professional/site/sitemanage"));
	}
	@RequestMapping("/professional/site/toupdate")
	public ModelAndView toUpdate(HttpSession session,MVenderSite mVenderSite){
		ModelAndView mv=new ModelAndView("professional/vender/site/updateAndSaveSite");
		MVenderSite m =	mVenderSiteService.fingById(mVenderSite.getId());
		String communtiy=m.getCommunityIds();
		if(communtiy!=null&&communtiy!=""){
			communtiy=communtiy.substring(1, communtiy.length());
			List<OCountry>  oCountry=oCountryService.getCountryByIds(communtiy);
			mv.addObject("oCountry", oCountry);
		}
		mv.addObject("mVenderSite", m);
		mv.addObject("isAdd", false);
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/professional/site/delete")
	public ModelAndView delete(long id){
		try {
			fileHandle.removeSite(mVenderSiteService.fingById(id).getImgUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mVenderSiteService.delete(id);
		return new ModelAndView(new RedirectView("/professional/site/sitemanage"));
	}
	@RequestMapping("/professional/site/available")
	public @ResponseBody String available(long id){
		MVenderSite mVenderSite=mVenderSiteService.fingById(id);
			if(mVenderSite.isAvailable()==true){
				mVenderSite.setAvailable(false);
				mVenderSiteService.update(mVenderSite);
				return "false";
			}else{
				mVenderSite.setAvailable(true);
				mVenderSiteService.update(mVenderSite);
				return "true";
			}
		
		
	}
	
}
