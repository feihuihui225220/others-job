package com.anticw.aged.controller.game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.GGameLevel;
import com.anticw.aged.service.game.GameLevelService;

/**
 * 作者：bsd
 * 日期：2016-7-28
 * 功能：TODO	
 */
@Controller
@RequestMapping("/gamelevel/")
public class GameLevelController {
	@Autowired
	private GameLevelService gameLevelervice;
	
	@RequestMapping("findByUserId")
	@ResponseBody
	public List<GGameLevel> findGameLevelByUserId(String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameLevelervice.findGameLevelByUserId(userId);
	}
	
	@RequestMapping("findByGameId")
	@ResponseBody
	public List<GGameLevel> findGameLevelByGameId(int gameId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameLevelervice.findGameLevelByGameId(gameId);
	}
	
	@RequestMapping("findByUserIdAndGameId")
	@ResponseBody
	public List<GGameLevel> findGameLevelByUserIdAndGameId(String userId,int gameId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameLevelervice.findGameLevelByGameIdAndUserId(gameId, userId);
	}
	
	@RequestMapping("findByLevel")
	@ResponseBody
	public List<GGameLevel> findGameLevel(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameLevelervice.findGameLevelList();
	}
	
	@RequestMapping("findById")
	@ResponseBody
	public GGameLevel GameLevel(int id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		return gameLevelervice.findGameLevelById(id);
	}
	
	@RequestMapping("addGameLevel")
	@ResponseBody
	public void addGameLevel(GGameLevel gameLevel,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		gameLevelervice.insertGameLebel(gameLevel);
	}
	@RequestMapping("delbyId")
	@ResponseBody
	public void delGameLevelById(int id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		gameLevelervice.delGGameLevelById(id);
	}
	
	@RequestMapping("findMaxData")
	@ResponseBody
	public JSONObject findMaxData(int gameId,String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		JSONObject json = new JSONObject();
		json.put("level", gameLevelervice.findMaxLevelByUserIdAndGameId(gameId, userId));
		json.put("score", gameLevelervice.findMaxScoreByUserIdAndGameId(gameId, userId));
		return json;
	}
	@RequestMapping("findMaxSugar")
	@ResponseBody
	public  List<Object>  findMaxSugar(GGameLevel gameLevel){
		return gameLevelervice.findMaxSugar(gameLevel);
	}
	
	/**
	 * 我的成绩
	 * @param gameId
	 * @param userId
	 * @param response
	 * @return
	 */
	@RequestMapping("findUserIdResults")
	@ResponseBody
	public JSONObject findUserIdResults(int gameId,String userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		JSONObject json = new JSONObject();
		json.put("level", gameLevelervice.findUserIdResults(gameId,userId));
		List<Date> list=gameLevelervice.findUserIdResultsd(gameId, userId);
		List<String> lists=new ArrayList<String>();
 		for (int i = 0; i < list.size(); i++) {
			SimpleDateFormat  sdf=new SimpleDateFormat ("yyyy-MM-dd");
			lists.add(sdf.format(list.get(i)));
		}
 		json.put("date", lists);
		return json;
	}
}
