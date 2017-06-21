package com.anticw.aged.dao.game;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.GGameLevel;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;

@Component
public class GameLevelDao extends HibernateEntityDao<GGameLevel>{
	
	/**
	 * TODO 查询一个用户的数据
	 *@param userId
	 *@return
	 */
	public List<GGameLevel> findGameLevelByUserId(String userId){
		return super.find("from GGameLevel where available=? and userId=? order by id desc",
				PropertyValueConstants.AVAILABLE,userId);
	}
	
	/**
	 * 根据游戏Id获取游戏数据
	 * @param id
	 * @return
	 */
	public List<GGameLevel> findGameLevelByGameId(int gameId){
		return super.find("from GGameLevel where available=? and gameId=? order by createTime desc", 
							PropertyValueConstants.AVAILABLE,gameId);
	}
	/**
	 * TODO 查询某个人某个游戏的历史数据
	 *@param gameId
	 *@param userId
	 *@return
	 */
	public List<GGameLevel> findGameLevelByGameIdAndUserId(int gameId,String userId){
		return super.find("from GGameLevel where available=? and gameId=? and userId=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId);
	}
	public List<GGameLevel> findGameLevelByGameIdAndUserIdAndDate(int gameId,String userId){
		String date = DateUtil.getCurrentFormatDate();
		return super.find("from GGameLevel where available=? and gameId=? and userId=? and createTime like '" + 
		date + "%' order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId);
	}
    /**
     * TODO 查询所有数据
     *@return
     */
	public List<GGameLevel> findGameLevelList(){
		return super.find("from GGameLevel where available=?",PropertyValueConstants.AVAILABLE);
	}
	/**
	 * TODO  查询历史最高关数
	 *@param gameId
	 *@param userId
	 *@return
	 */
	public List<Integer> findMaxLevelByUserIdAndGameId(int gameId,String userId){
		return super.find("SELECT MAX(level)  from GGameLevel where available=? and gameId=? and userId=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId);
	}
	/**
	 * TODO  查询历史最高分数
	 *@param gameId
	 *@param userId
	 *@return
	 */
	public List<Integer> findMaxScoreByUserIdAndGameIdAndlevel(int gameId,String userId,int level){
		return super.find("SELECT MAX(score)  from GGameLevel where available=? and gameId=? and userId=? and level=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId,level);
	}
	
	public List<Integer> findMaxScoreByUserIdAndGameId(int gameId,String userId){
		return super.find("SELECT MAX(score)  from GGameLevel where available=? and gameId=? and userId=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId);
	}
	
	/**
	 * TODO 添加游戏数据
	 *@param gameLevel
	 */
	public Integer insertGameLevel(GGameLevel gameLevel){
		if (gameLevel.getGameId() == 8) { //熊猫去哪儿
			List<Integer> list = findMaxScoreByUserIdAndGameId(
					gameLevel.getGameId(), gameLevel.getUserId());
			gameLevel.setDayScore(gameLevel.getScore());
			if (list.get(0) != null) {
				gameLevel.setScore(gameLevel.getScore() + list.get(0));
			} else {
				gameLevel.setScore(gameLevel.getScore());
			}
		}
		gameLevel.setCreateTime(new Date());
		gameLevel.setChangeTime(new Date());
		gameLevel.setAvailable(true);
		return (Integer) super.save(gameLevel);	
	}
	/**
	 * TODO 修改个人游戏信息
	 *@param gameLevel
	 */
	public void updateGameLevel(GGameLevel gameLevel,GGameLevel orginGameLevel){
		if (gameLevel.getGameId() == 8) {
			orginGameLevel.setScore(orginGameLevel.getScore()+gameLevel.getScore());//原始分+本次得分
			orginGameLevel.setDayScore(orginGameLevel.getDayScore()+gameLevel.getScore());//原始分+本次得分
		}
		orginGameLevel.setLevel(gameLevel.getLevel());
		orginGameLevel.setChangeTime(new Date());
		super.update(orginGameLevel);
	}
	
	/**
	 * TODO 查询一条游戏数据的详情
	 *@param id
	 *@return
	 */
	public GGameLevel findGameLevelById(int id){
		return super.get(id);
	}
	
	/**
	 * 删除一条数据
	 * @param id
	 */
	public void delGGameLevelById(int id){
		super.removeById(id);
	}
	/**
	 * TODO查询分糖果游戏等级
	 *@param gameLevel
	 *@return
	 */
	public List<Object> findMaxSugar(GGameLevel gameLevel){
		return super.find("from GGameLevel where available=? and gameId=? and userId=? and dayScore=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameLevel.getGameId(),gameLevel.getUserId(),gameLevel.getDayScore());
	}
	/**
	 * 我的成绩
	 * @param gameLevel
	 * @return
	 */
	public List<Object> findUserIdResults(int gameId,String userId){
		return super.find("select level from GGameLevel where available=? and gameId=? and userId=?",PropertyValueConstants.AVAILABLE,gameId,userId);
	}
	public List<Date> findUserIdResultsd(int gameId,String userId){
		return super.find("select changeTime from GGameLevel where available=? and gameId=? and userId=?",PropertyValueConstants.AVAILABLE,gameId,userId);
	}
}
