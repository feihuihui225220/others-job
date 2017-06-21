package com.anticw.aged.service.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.GGamedata;
import com.anticw.aged.dao.game.GamedataDao;
import com.anticw.aged.utils.DateUtil;

/**
 * 作者：bsd
 * 日期：2016-7-28
 * 功能：TODO	
 */
@Service
public class GamedataService {
	@Autowired
	private GamedataDao gamedataDao;
	
	public List<GGamedata> findGamedataByUserId(String userId){
		return gamedataDao.findGamedataByUserId(userId);
	}
	
	public List<GGamedata> findGamedataByGameId(int gameId){
		return gamedataDao.findGamedataByGameId(gameId);
	}
 
	public List<GGamedata> findGamedataByGameIdAndUserId(int gameId,String userId){
		return gamedataDao.findGamedataByGameIdAndUserId(gameId, userId);
	}
   
	public List<GGamedata> findGamedataList(){
		return gamedataDao.findGamedataList();
	}
	
	public Long insertGameData(GGamedata gGamedata){
		return gamedataDao.insertGameData(gGamedata);
	}
	public void editGameData(GGamedata gGamedata) throws Exception, Exception{
		gamedataDao.editGameData(gGamedata);
	}
	
	public GGamedata findGamedataById(Long id){
		return gamedataDao.findGamedataById(id);
	}

	public void delGGamedataById(int id){
		gamedataDao.delGGamedataById(id);
	}
	
	/**
	 * 查询展示的数据
	 *@param userId
	 *@param gameId
	 */
	public JSONObject handleResultByUserIdAndGameId(String userId,int gameId){
		Integer totalSecond =0;
		Integer rightClick =0;
		Integer everdayRightClick =0;
		Integer maxLevel =0;
		JSONObject json = new JSONObject();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<GGamedata> listData= this.findGamedataByGameIdAndUserId(gameId, userId);
		List<GGamedata> dayright = gamedataDao.handleResultByUserIdAndGameId(userId,gameId);
		if (dayright.size() != 0) {
			for (int i = 0; i < dayright.size(); i++) {
				GGamedata dataIndex = dayright.get(i);
				if (dataIndex.getA3() != null) {
					everdayRightClick += Integer.parseInt(dataIndex.getA3());
				}
				if (dataIndex.getA1() != null) {
					Integer a1 = Integer.parseInt(dataIndex.getA1());
					if (a1 > maxLevel) {
						maxLevel = a1;
					}
				}
			}
		}
		if (listData.size() != 0) {
			json.put("firstTime",DateUtil.getCurrentFormatDate(listData.get(0).getCreateTime()));
			for (int i = 0; i < listData.size(); i++) {
				GGamedata dataIndex = listData.get(i);
				if (dataIndex.getA6() != null) {
					totalSecond += Integer.parseInt(dataIndex.getA6());
				}
				if (dataIndex.getA3() != null) {
					rightClick += Integer.parseInt(dataIndex.getA3());
				}
				if (dataIndex.getA5() != null) {
					String[] animalStr = dataIndex.getA5().split(",");
					for (int j = 0; j < animalStr.length; j++) {
						Integer num = map.get(j);
						if (num == null) {
							num = 0;
						}
						map.put(j, num + Integer.parseInt(animalStr[j]));
					}
				}

			}
		}
		
		json.put("maxLevel", maxLevel);
		json.put("totalSecond", totalSecond);
		json.put("rightClick", rightClick);
		json.put("everdayRightClick", everdayRightClick);
		json.put("everyAnimal", map);
		return json;
	}

	public List<Object> countfailed(int gameId,String userId){
		return gamedataDao.countfailed(gameId,userId);
	}
	
	public List<Object> gamePass(GGamedata gamedata){
		return gamedataDao.gamePass(gamedata);
	}
	
	public int getCount(GGamedata gamedata){
		return gamedataDao.getCount(gamedata);
	}
	
	public int getUpgrade(GGamedata gamedata){
		return gamedataDao.getUpgrade(gamedata);
	}
	public Object[] smilingFace(GGamedata gamedata){
		return gamedataDao.smilingFace(gamedata);
	}
	public String gameById(int gameId,String userId){
		return gamedataDao.gameById(gameId, userId);
	}
	public String gameByIds(int gameId,String userId){
		return gamedataDao.gameByIds(gameId, userId);
	}
	public String gameByIdResult(int gameId,String userId){
		return gamedataDao.gameByIdResult(gameId, userId);
	}
	
	public String getNewA10(GGamedata gamedata){
		return gamedataDao.getNewA10(gamedata);
	}
	
	public List<Object[]> getUpgradeList(GGamedata gamedata) {
		return gamedataDao.getUpgradeList(gamedata);
	}
	public GGamedata findGamedataByGameId3(String userId) {
		return gamedataDao.findGamedataByGameId3(userId);
	}
	public GGamedata findGamedataByGameId5(String userId) {
		return gamedataDao.findGamedataByGameId5(userId);
	}
	public GGamedata findGamedataByGameId6(String userId) {
		return gamedataDao.findGamedataByGameId6(userId);
	}
	/**
	 * a3的和
	 * @param userId
	 * @return
	 */
	public JSONObject findGamedataSumA3(String userId) {
		 
		return gamedataDao.findGamedataSumA3(userId);
	}
	
	/**
	 * a6的和
	 * @param userId
	 * @return
	 */
	public JSONObject findGamedataSumA6(String userId) {
		return gamedataDao.findGamedataSumA6(userId);
	}
}
