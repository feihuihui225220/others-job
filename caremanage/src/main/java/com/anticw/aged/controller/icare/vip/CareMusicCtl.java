package com.anticw.aged.controller.icare.vip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.CareMusic;
import com.anticw.aged.service.icare.vip.CareMusicService;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Controller
@RequestMapping("/music/")
public class CareMusicCtl {
	@Autowired
	private CareMusicService careMusicService;
	
	/**
	 * 跳转到添加页面
	 *@param id
	 *@return
	 */
	@RequestMapping("toAddPage")
	public String  toAddPage(){
		return "";
	}
	
	/**
	 * 查询一首音乐TODO
	 *@param id
	 *@return
	 */
	@RequestMapping("get/{id}")
	public String  getMusicById(@PathVariable("id")int id,HttpServletRequest request){
		request.setAttribute("music", careMusicService.getMusicById(id) );
		return "";
	}
	/**
	 * 添加音乐
	 *@param careMusic
	 *@return
	 */
	@RequestMapping("add")
	public String addMusic(CareMusic careMusic){
		careMusicService.addMusic(careMusic);
		return "";
	}
	/**
	 * 删除音乐
	 *@param careMusic
	 *@return
	 */
	@RequestMapping("remove/{id}")
	public String  removeMusic(@PathVariable("id")int id){
		careMusicService.removeMusic(id);
		return "";
	}
	/**
	 * 修改音乐TODO
	 *@param careMusic
	 */
	@RequestMapping("modify")
	public String modifyMusic(CareMusic careMusic){
		careMusicService.modifyMusic(careMusic);
		return "";
	}
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	@RequestMapping("getList")
	public String getMusicList(int page, int num,HttpServletRequest request) {
		request.setAttribute("musics", careMusicService.getMusicList(page, num));
		return "";
	}
	
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	@RequestMapping("getList/{parentId}")
	public String getMusicListByCategory(int page, int num,Integer category,HttpServletRequest request) {
		request.setAttribute("musics", careMusicService.getMusicListByCategory(page, num,category));
		return "";
	}

}
