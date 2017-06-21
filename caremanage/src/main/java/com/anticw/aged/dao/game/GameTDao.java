package com.anticw.aged.dao.game;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.GGameT;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.vo.common.DateParamVO;

@Component
public class GameTDao extends HibernateEntityDao<GGameT>{
	
	/**
	 * TODO 查询一个用户的数据
	 *@param userId
	 *@return
	 */
	public List<GGameT> findGameTByUserId(String userId){
		return super.find("from GGameT where available=? and userId=? order by id desc",
				PropertyValueConstants.AVAILABLE,userId);
	}
	
	/**
	 * 根据游戏Id获取游戏数据
	 * @param id
	 * @return
	 */
	public List<GGameT> findGameTByGameId(int gameId){
		return super.find("from GGameT where available=? and gameId=? order by createTime desc", 
							PropertyValueConstants.AVAILABLE,gameId);
	}
	/**
	 * TODO 查询某个人某个游戏的历史数据
	 *@param gameId
	 *@param userId
	 *@return
	 */
	public List<GGameT> findGameTByGameIdAndUserId(int gameId,String userId){
		return super.find("from GGameT where available=? and gameId=? and userId=? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId);
	}
 
    /**
     * TODO 查询所有数据
     *@return
     */
	public List<GGameT> findGameTList(){
		return super.find("from GGameT where available=?",PropertyValueConstants.AVAILABLE);
	}
 
	
	/**
	 * TODO 添加T分数数据
	 *@param gameT
	 */
	public Integer insertGameT(GGameT gameT){
		gameT.setCreateTime(new Date());
		gameT.setAvailable(true);
		return (Integer) super.save(gameT);	
	}
	/**
	 * TODO 修改个人游戏信息
	 *@param GameT
	 */
	public void updateGameT(GGameT gameT){
		super.update(gameT);
	}
	
	/**
	 * TODO 查询一条游戏数据的详情
	 *@param id
	 *@return
	 */
	public GGameT findGameTById(int id){
		return super.get(id);
	}
	
	/**
	 * 删除一条数据
	 * @param id
	 */
	public void delGGameTById(int id){
		super.removeById(id);
	}
	
	public List<GGameT> findGameTByDate(int gameId,Date sDate,Date eDate){
		return super.find("from GGameT where available=? and gameId=? and createTime BETWEEN ? and ? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,sDate,eDate);
	}
	
	/**
	 * 获取一段时间之内 个人历史记录数据
	 * @param gameId
	 * @param userId
	 * @param paramVO
	 * @return
	 */
	public List<GGameT> findGameTByGameIdAndUserId(int gameId,String userId,DateParamVO paramVO){
		return super.find("from GGameT where available=? and gameId=? and userId=? and createTime between ? and ? order by createTime desc", 
				PropertyValueConstants.AVAILABLE,gameId,userId,paramVO.getStart(),paramVO.getEnd());
	}
 

}
