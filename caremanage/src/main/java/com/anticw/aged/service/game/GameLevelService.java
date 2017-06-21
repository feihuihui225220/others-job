package com.anticw.aged.service.game;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.GGameLevel;
import com.anticw.aged.dao.game.GameLevelDao;

/**
 * 作者：bsd
 * 日期：2016-7-28
 * 功能：TODO	
 */
@Service
public class GameLevelService {
	@Autowired
	private GameLevelDao gameLevelDao;
	
	public List<GGameLevel> findGameLevelByUserId(String userId){
		return gameLevelDao.findGameLevelByUserId(userId);
	}
	
	public List<GGameLevel> findGameLevelByGameId(int gameId){
		return gameLevelDao.findGameLevelByGameId(gameId);
	}
 
	public List<GGameLevel> findGameLevelByGameIdAndUserId(int gameId,String userId){
		return gameLevelDao.findGameLevelByGameIdAndUserId(gameId, userId);
	}
   
	public List<GGameLevel> findGameLevelList(){
		return gameLevelDao.findGameLevelList();
	}
	
	public void insertGameLebel(GGameLevel gameLevel){
		List<GGameLevel> orginGameLevel = gameLevelDao.findGameLevelByGameIdAndUserIdAndDate(gameLevel.getGameId(),gameLevel.getUserId());
		if (orginGameLevel.size() != 0) {
			gameLevelDao.updateGameLevel(gameLevel,orginGameLevel.get(0));
		}else{
			gameLevelDao.insertGameLevel(gameLevel);
		}
	}
	
	public GGameLevel findGameLevelById(int id){
		return gameLevelDao.findGameLevelById(id);
	}

	public void delGGameLevelById(int id){
		gameLevelDao.delGGameLevelById(id);
	}

	public List<Integer> findMaxLevelByUserIdAndGameId(int gameId,String userId){
		return gameLevelDao.findMaxLevelByUserIdAndGameId(gameId, userId);
	}
	
	public List<Integer> findMaxScoreByUserIdAndGameIdAndlevel(int gameId,String userId,int level){
		return gameLevelDao.findMaxScoreByUserIdAndGameIdAndlevel(gameId, userId,level);
	}
	
	public  List<Integer>  findMaxScoreByUserIdAndGameId(int gameId,String userId){
		return gameLevelDao.findMaxScoreByUserIdAndGameId(gameId, userId);
	}
 
	public  List<Object>  findMaxSugar(GGameLevel gameLevel){
		return gameLevelDao.findMaxSugar(gameLevel);
	}
	
	public List<Object> findUserIdResults(int gameId,String userId){
		return gameLevelDao.findUserIdResults(gameId,userId);
	}
	public List<Date> findUserIdResultsd(int gameId,String userId){
		return gameLevelDao.findUserIdResultsd(gameId,userId);
	}
}
