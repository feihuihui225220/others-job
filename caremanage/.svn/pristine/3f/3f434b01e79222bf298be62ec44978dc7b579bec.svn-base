/**
 * 
 */
package com.anticw.aged.controller.professional;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;

/**
 * 客户管理
 * @author guoyongxiang
 * Date: 2014-10-12
 */
@RequestMapping("/professional/user")
@Controller
public class UserCtl {

	private static Logger logger = LoggerFactory.getLogger(UserCtl.class);
	
	@Autowired
	private RUserService ruserService;
	@Autowired
	private SpringDataPool springDataPool;
	@Autowired
	private OCountryService ocountryService;
	
	/**
	 * 查询用户详情
	 * @author guoyongxiang
	 * Date: 2014-10-12 下午7:01:51
	 * @param id
	 * @return
	 * @throws FileNotFoundException 
	 */
	@RequestMapping("detail/{id}")
	public ModelAndView getUserDetail(@PathVariable Long id){
		logger.debug("into mothed getUserDetail.");
		RUser user = this.ruserService.findById(id);
		OCountry ocountry = ocountryService.getCountryById(user.getCommunityId());
		ModelAndView mv = new ModelAndView("/professional/user/detail");
		mv.addObject("user", user);
		mv.addObject("ocountry", ocountry);
		mv.addObject("categoryItems", springDataPool.getOCategoryItem());
		return mv;
	}
	
	/**
	 * 读取项目外图片 {展示老人脑电图}
	 * @author dx
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("validatepng")
	public void validatepng(HttpServletRequest request,HttpServletResponse response,String id) throws IOException{
		 String url="C:\\Users\\Administrator\\Desktop\\img\\"+id+".png";
		 Image image = ImageIO.read(new File(url)); 
		 ImageIO.write((RenderedImage) image, "jpg", response.getOutputStream());
		}
	@RequestMapping("brainwave")
	public ModelAndView getbrainwave(HttpServletRequest request,HttpServletResponse response,Long userId) throws IOException{
		ModelAndView mv = new ModelAndView("/professional/vender/cm/brainwave");
		mv.addObject("userId", userId);
		return mv;
	}
	
}
