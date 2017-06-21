package com.anticw.aged.controller.game;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.GGameT;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.game.GameTService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.file.ZipUtils;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.user.RUserVO;

/**
 * 作者：bsd
 * 日期：2016-8-29
 * 功能：TODO	
 */
@Controller
@RequestMapping("gamet")
public class GameTController {
	@Autowired
	private GameTService gameTService;
	
	@Autowired
	private RUserService userService;
	@Autowired
	private OCountryService countryService;
	
	/**
	 * 查询T分数，用户基本信息，TODO
	 *@param userId
	 *@param response
	 *@return
	 */
	@RequestMapping("findInfo")
	@ResponseBody
	public JSONObject findInfo(String userId,int gameId,String date,HttpServletResponse response){
		String dates=date+" 00:00:00";
		String datee=date+" 23:59:59";
		DateParamVO paramVO=new DateParamVO(DateUtil.parseStrToDateTime(dates), DateUtil.parseStrToDateTime(datee));
		response.setHeader("Access-Control-Allow-Origin","*");
		RUser user = this.userService.findById(Long.valueOf(userId));
		RUserVO vo = new RUserVO();
		vo.setName(user.getName());
		vo.setMobilePhone(user.getMobilePhone());
		vo.setIdCardNo(user.getIdCardNo());
		vo.setAge(user.getAge());
		vo.setGender(user.getGender());
		vo.setEducation(user.getEducation());
		OCountry country = countryService.getCountryById(user.getCommunityId());
		vo.setComminityName(country.getName());
		JSONObject json = new JSONObject();
		json.put("user", vo);
		json.put("country", country);
		json.put("gamet",  gameTService.findGameTByGameIdAndUserId(gameId, userId,paramVO));
		return json;
	}
	@RequestMapping("findGameTByUserId")
	@ResponseBody
	public List<GGameT> findGameTByUserId(String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.findGameTByUserId(userId);
	}
	
	@RequestMapping("findGameTByGameId")
	@ResponseBody
	public List<GGameT> findGameTByGameId(int gameId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.findGameTByGameId(gameId);
	}
	@RequestMapping("findGameTByGameIdAndUserId")
	@ResponseBody
	public List<GGameT> findGameTByGameIdAndUserId(int gameId,String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.findGameTByGameIdAndUserId(gameId, userId);
	}
 
	@RequestMapping("findGameTList")
	@ResponseBody
	public List<GGameT> findGameTList(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.findGameTList();
	}
 
	@RequestMapping("insertGameT")
	@ResponseBody
	public Integer insertGameT(GGameT gameT,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.insertGameT(gameT);	
	}
	/*@RequestMapping("updateGameT")
	@ResponseBody
	public void updateGameT(GGameT gameT,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		 gameTService.updateGameT(gameT);	
	}*/
	
	@RequestMapping("findGameTById")
	@ResponseBody
	public GGameT findGameTById(int id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameTService.findGameTById(id);
	}
	@RequestMapping("delGGameTById")
	@ResponseBody
	public void delGGameTById(int id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		gameTService.delGGameTById(id);
	}
	@RequestMapping("/assessgds/togame")
	public ModelAndView getWord(){
		Date end=new Date();
		Date start=DateUtil.getFirstDayInMonth(end);
		ModelAndView mv=new ModelAndView("/professional/game/gameassess");
		mv.addObject("start", start);
		mv.addObject("end", end);
		return mv;
	}
	@RequestMapping("/assessgds/game")
	public void getWord(HttpServletResponse response,int gameId,DateParamVO vo) throws Exception{
		 List<String> str=	gameTService.htmlToWord2(gameId, vo.getStart(), vo.getEnd());
		 String zipName =new String("游戏评估结果".getBytes("GBK"), "ISO-8859-1") ;
	        response.setContentType("APPLICATION/OCTET-STREAM");  
	        response.setHeader("Content-Disposition","attachment; filename="+zipName+".zip");
	        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
	        try {
	            for(Iterator<String> s1 = str.iterator();s1.hasNext();){
	            	String file1 = s1.next();
	                ZipUtils.zipFile(file1, out);
	                response.flushBuffer();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            out.close();
	        }
		
	}
	
}
