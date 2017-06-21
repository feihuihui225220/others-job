package com.anticw.aged.controller.game;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.GGamedata;
import com.anticw.aged.service.game.GamedataService;

/**
 * 作者：bsd 日期：2016-7-28 功能：TODO
 */
@Controller
@RequestMapping("/gamedata/")
public class GamedataController {
	@Autowired
	private GamedataService gamedataService;

	@RequestMapping("findByUserId")
	@ResponseBody
	public List<GGamedata> findGamedataByUserId(String userId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataByUserId(userId);
	}

	@RequestMapping("findByGameId")
	@ResponseBody
	public List<GGamedata> findGamedataByGameId(int gameId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataByGameId(gameId);
	}

	@RequestMapping("findByUserIdAndGameId")
	@ResponseBody
	public List<GGamedata> findGamedataByUserIdAndGameId(String userId,
			int gameId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataByGameIdAndUserId(gameId, userId);
	}

	@RequestMapping("finddata")
	@ResponseBody
	public List<GGamedata> findGamedata(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataList();
	}

	@RequestMapping("findById")
	@ResponseBody
	public GGamedata Gamedata(Long id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataById(id);
	}

	@RequestMapping("addGamedata")
	@ResponseBody
	public Long addGamedata(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Long result = gamedataService.insertGameData(gamedata);
		return result;
	}

	/**
	 * TODO 祖玛游戏填充数据
	 *
	 * @param gamedata
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("editGamedata")
	@ResponseBody
	public void editGamedata(GGamedata gamedata, HttpServletResponse response)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		gamedataService.editGameData(gamedata);
	}

	@RequestMapping("delbyId")
	@ResponseBody
	public void delGamedataById(int id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		gamedataService.delGGamedataById(id);
	}

	@RequestMapping("handleResultByUserIdAndGameId")
	@ResponseBody
	public JSONObject handleResultByUserIdAndGameId(String userId, int gameId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.handleResultByUserIdAndGameId(userId, gameId);
	}

	@RequestMapping("countfailed")
	@ResponseBody
	public List<Object> countFailed(int gameId, String userId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.countfailed(gameId, userId);
	}

	@RequestMapping("gamePass")
	@ResponseBody
	public List<Object> gamePass(GGamedata gamedata) {
		return gamedataService.gamePass(gamedata);
	}

	/**
	 * 查询失败条数（最大关卡）1----7正常失败条数 -1 异常状态 查询结果集为null
	 * 
	 * @return
	 */
	@RequestMapping("selectCount")
	@ResponseBody
	public int getCount(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.getCount(gamedata);
	}

	/**
	 * 是否升级
	 * 
	 * @param gamedata
	 * @param response
	 * @return
	 */
	@RequestMapping("upgrade")
	@ResponseBody
	public int getUpgrade(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.getUpgrade(gamedata);
	}

	/**
	 * 返回笑脸（a11）和拇指(a12)
	 * 
	 * @param gamedata
	 * @param response
	 * @return
	 */
	@RequestMapping("smilingFace")
	@ResponseBody
	public Object[] smilingFace(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (gamedataService.smilingFace(gamedata) == null) {
			return new Object[] { 0 };
		}
		return gamedataService.smilingFace(gamedata);
	}

	/**
	 * 
	 * @param gameId
	 * @param userId
	 * @param response
	 * @return
	 */
	@RequestMapping("gameById")
	@ResponseBody
	public List<Object> gameById(int gameId, String userId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Object> list = new ArrayList<>();
		// a3等于2和a15为0，返回a1最小值，
		String result = gamedataService.gameById(gameId, userId);
		// a3等于3和a15为0，返回a1最小值，
		String results = gamedataService.gameByIds(gameId, userId);
		list.add(result);
		list.add(results);
		return list;
	}

	/**
	 * 
	 * @param gameId
	 * @param userId
	 * @param response
	 * @return
	 */
	@RequestMapping("newsGameById")
	@ResponseBody
	public String newsGameById(int gameId, String userId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String result = gamedataService.gameByIdResult(gameId, userId);
		return result;
	}

	@RequestMapping("getNew")
	@ResponseBody
	public String getNewA10(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.getNewA10(gamedata);
	}
	
	
	@RequestMapping("getUpgradeList")
	@ResponseBody
	public List<Object[]> getUpgradeList(GGamedata gamedata, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.getUpgradeList(gamedata);
	}
	@RequestMapping("findGamedataByGameId3")
	@ResponseBody
	public String findGamedataByGameId3(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		GGamedata g=gamedataService.findGamedataByGameId3(userId);
		if(g!=null){
			return g.getA1();
		}
		return null;
	}
	@RequestMapping("findGamedataByGameId5")
	@ResponseBody
	public String findGamedataByGameId5(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		GGamedata g= gamedataService.findGamedataByGameId5(userId);
		if(g!=null){
			return g.getA1();
		}
		return null;
	}
	@RequestMapping("findGamedataByGameId6")
	@ResponseBody
	public String findGamedataByGameId6(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		GGamedata g= gamedataService.findGamedataByGameId6(userId);
		if(g!=null){
			return g.getA1();
		}
		return null;
	}
	
	
	/**
	 * a3的和
	 * @param userId
	 * @return
	 */
	@RequestMapping("findGamedataSumA3")
	@ResponseBody
	public JSONObject findGamedataSumA3(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataSumA3(userId);
	}
	
	/**
	 * a6的和
	 * @param userId
	 * @return
	 */
	@RequestMapping("findGamedataSumA6")
	@ResponseBody
	public JSONObject findGamedataSumA6(String userId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return gamedataService.findGamedataSumA6(userId);
	}
}
