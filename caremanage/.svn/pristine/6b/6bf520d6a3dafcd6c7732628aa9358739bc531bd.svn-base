package com.anticw.aged.dao.game;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.GGamedata;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;

@Component
public class GamedataDao extends HibernateEntityDao<GGamedata> {

	/**
	 * TODO 查询一个用户的数据
	 *
	 * @param userId
	 * @return
	 */
	public List<GGamedata> findGamedataByUserId(String userId) {
		return super.find("from GGamedata where available=? and userId=? order by id desc",
				PropertyValueConstants.AVAILABLE, userId);
	}

	/**
	 * 根据游戏Id获取游戏数据
	 * 
	 * @param id
	 * @return
	 */
	public List<GGamedata> findGamedataByGameId(int gameId) {
		return super.find("from GGamedata where available=? and gameId=? order by createTime desc",
				PropertyValueConstants.AVAILABLE, gameId);
	}

	/**
	 * TODO 查询
	 *
	 * @param gameId
	 * @param userId
	 * @return
	 */
	public List<GGamedata> findGamedataByGameIdAndUserId(int gameId, String userId) {
		return super.find("from GGamedata where available=? and gameId=? and userId=? order by createTime asc",
				PropertyValueConstants.AVAILABLE, gameId, userId);
	}

	/**
	 * TODO 查询所有数据
	 *
	 * @return
	 */
	public List<GGamedata> findGamedataList() {
		List<GGamedata> gameData = super.find("from GGamedata where available=?", PropertyValueConstants.AVAILABLE);
		return gameData;
	}

	/**
	 * TODO 添加游戏数据
	 *
	 * @param gGamedata
	 */
	public Long insertGameData(GGamedata gGamedata) {
		gGamedata.setAvailable(PropertyValueConstants.AVAILABLE);
		gGamedata.setCreateTime(new Date());
		return (Long) super.save(gGamedata);

	}

	/**
	 * TODO 修改游戏数据
	 *
	 * @param gGamedata
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void editGameData(GGamedata gGamedata) throws Exception, InvocationTargetException {
		GGamedata data = this.findGamedataById(gGamedata.getId());
		gGamedata.setCreateTime(data.getCreateTime());
		gGamedata.setAvailable(true);
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		BeanUtils.copyProperties(data, gGamedata);
		super.update(data);

	}

	/**
	 * TODO 查询一条游戏数据的详情
	 *
	 * @param id
	 * @return
	 */
	public GGamedata findGamedataById(Long id) {
		return super.get(id);
	}

	/**
	 * TODO 查询第一条数据
	 *
	 * @param id
	 * @return
	 */
	public List<GGamedata> handleResultByUserIdAndGameId(String userId, int gameId) {
		String date = DateUtil.getCurrentFormatDate();
		return super.find("from GGamedata where available=? and gameId=? and userId=? and createTime like '" + date
				+ "%' order by createTime asc", PropertyValueConstants.AVAILABLE, gameId, userId);
	}

	/**
	 * TODO 查询每天最大关卡数
	 *
	 * @param id
	 * @return
	 */
	/*
	 * public List<GGamedata> findMaxLevel(String userId,int gameId){ String
	 * date = DateUtil.getCurrentFormatDate(); return super.find(
	 * "SELECT MAX(cast(A1) as int)  from GGamedata where available=? and gameId=? and userId=?and createTime like '"
	 * + date + "%'  order by createTime desc",
	 * PropertyValueConstants.AVAILABLE,gameId,userId); }
	 */

	/**
	 * 删除一条数据
	 * 
	 * @param id
	 */
	public void delGGamedataById(int id) {
		super.removeById(id);
	}

	/**
	 * 统计某游戏的失败次数TODO 数一数游戏统计失败次数gameId = 1
	 *
	 * @param gameId
	 * @param userId
	 * @return
	 */
	public List<Object> countfailed(int gameId, String userId) {
		List<Object> result = null;
		result = super.find("SELECT COUNT(*) FROM  g_gamedata WHERE available=? and gameId=? and userId=?  AND a15=1",
				PropertyValueConstants.AVAILABLE, gameId, userId);
		return result;
	}

	/**
	 ** 分糖果（gameid=2）统计每个大关卡是否全部通关
	 *
	 * @param gameId
	 * @param userId
	 * @return
	 */
	public List<Object> gamePass(GGamedata gamedata) {
		List<Object> result = null;
		String sql = "";
		if ("1".equals(gamedata.getA1())) {
			sql = "a13 =0 OR a13=1  OR a13 =2 OR a13 =3 OR a13 =4 OR a13 =5";
		} else if ("2".equals(gamedata.getA1())) {
			sql = "a13 =6 OR a13=7  OR a13 =8 OR a13 =9 ";
		} else if ("3".equals(gamedata.getA1())) {
			sql = "a13 =10 ";
		}
		result = super.find(
				"SELECT COUNT(*) FROM (SELECT DISTINCT a13 FROM GGamedata WHERE "
						+ "available=? and gameId=? and userId=? and (" + sql + ") AND a14 =1 and a1=?) AS t",
				PropertyValueConstants.AVAILABLE, gamedata.getGameId(), gamedata.getUserId(), gamedata.getA1());
		return result;
	}

	/**
	 * 进入之后 首先查询最大关卡数 （1）查询最大管卡最后一条数据的a15值是否为0 是 全部最大关卡为a15==0
	 * （2）如果最大管卡最后一条数据a15==1 并且 最大管卡失败次数大于等于3（查询最新一条数据 a15==0） 那么 a15==0
	 * 最大管卡失败次数不大于3 那么返回最大管卡失败次数
	 */

	public int getCount(GGamedata gamedata) {
		// 获取最大关卡数最新一条数据
		String sql = "SELECT t.a15,t.a5 FROM (SELECT MAX(a5),MAX(id) AS id  FROM g_gamedata g WHERE g.game_id="
				+ gamedata.getGameId() + " AND g.user_id=" + gamedata.getUserId()
				+ " GROUP BY g.a5  DESC) g LEFT JOIN g_gamedata t ON t.id=g.id";
		if (gamedata.getGameId() == 2) {
			sql = "SELECT t.a15,t.a1 FROM (SELECT MAX(a5),MAX(id) AS id  FROM g_gamedata g WHERE g.game_id="
					+ gamedata.getGameId() + " AND g.user_id=" + gamedata.getUserId()
					+ " GROUP BY g.a5  DESC) g LEFT JOIN g_gamedata t ON t.id=g.id";
		}
		List<Object[]> o = super.findBySQLQuery(sql);
		if (o.size() == 0) {
			return 0;
		}
		if (o.get(0)[0] == null || o.get(0)[1] == null) {
			return -1;
		}
		if (o.get(0)[0].toString().equals("1")) {
			String a5 = o.get(0)[1].toString();
			String sql1 = " SELECT COUNT(*) as count   FROM g_gamedata g WHERE g.game_id= ? AND g.a15=1 AND g.user_id=?  AND g.a5=?";
			if (gamedata.getGameId() == 2) {
				sql1 = " SELECT COUNT(*) as count   FROM g_gamedata g WHERE g.game_id=? AND g.a15=1 AND g.user_id=?  AND g.a1=?";
			}
			List<Object[]> o1 = super.findBySQLQuery(sql1, gamedata.getGameId(), gamedata.getUserId(), a5);
			Object os = o1.get(0);// 获取失败总条数
			if (Integer.parseInt(os.toString()) >= 3) {
				List<Object[]> o2 = super.findBySQLQuery(
						"SELECT a15 FROM (SELECT MAX(id) AS id FROM g_gamedata g WHERE g.game_id=? AND g.user_id=?  ORDER BY   g.`create_time` DESC) g LEFT JOIN g_gamedata t ON t.id=g.id",
						gamedata.getGameId(), gamedata.getUserId());
				Object os1 = o2.get(0);
				if (os1.toString().equals("1")) {// 最新一条为失败
					return Integer.parseInt(os.toString());
				}
				// 最新一条成功
				String hql = "from GGamedata g where g.gameId=? AND g.a15='1' AND g.userId=?";
				List<GGamedata> o3 = this.find(hql, gamedata.getGameId(), gamedata.getUserId());
				for (GGamedata c : o3) {
					c.setA15("0");
					super.update(c);
				}
				return 0;
			}
			return Integer.parseInt(os.toString());
		}

		String hql = "from GGamedata g where g.gameId=?  AND g.a15='1' AND g.userId=?";
		List<GGamedata> o3 = this.find(hql, gamedata.getGameId(), gamedata.getUserId());
		for (GGamedata c : o3) {
			c.setA15("0");
			super.update(c);
		}
		return 0;
	}

	/**
	 * game_id==2 是否升级
	 * 
	 * @param gamedata
	 * @return
	 */
	public int getUpgrade(GGamedata gamedata) {
		String sql = "SELECT * FROM g_gamedata g WHERE g.`game_id`=2   AND g.`user_id`=? AND g.`a15`='0'  ";
		if (gamedata.getA13().equals("1")) {
			sql += "AND g.`a13`='1' AND g.`a14` IN(0,1,2,3,4,5) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());
			if (o2.size() == 6) {
				return 1;
			}
		} else if (gamedata.getA13().equals("2")) {
			sql += "AND g.`a13`='2' AND g.`a14` IN(6,7,8,9) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());
			if (o2.size() == 4) {
				return 1;
			}
		} else if (gamedata.getA13().equals("3")) {
			sql += "AND g.`a13`='3' AND g.`a14` IN(10) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());
			if (o2.size() == 1) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 返回笑脸（a11）和拇指(a12)
	 * 
	 * @param gamedata
	 * @return
	 */
	public Object[] smilingFace(GGamedata gamedata) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT s.`a11`,s.`a12`FROM g_gamedata s,");
		sb.append("(SELECT  MAX(a11*1) AS a111 FROM g_gamedata g ");
		sb.append("WHERE g.`game_id`=2   AND g.`user_id`=").append(gamedata.getUserId()).append(" AND g.`a13`=")
				.append(gamedata.getA13());
		sb.append(" ORDER BY  MAX(a11*1) DESC) t WHERE s.a11=t.a111 ORDER BY `a12`*1 DESC");
		List<Object[]> result = super.findBySQLQuery(sb.toString());
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public String gameById(int gameId, String userId) {
		String hql = "SELECT a1 FROM GGamedata WHERE gameId=? AND userId=?  AND available=? and a15=0 AND a3 =2 order by a1*1";
		List<Object> list = super.find(hql, gameId, userId, PropertyValueConstants.AVAILABLE);
		if (list.size() > 0) {
			String code = list.get(0).toString();
			if (code != null && code.trim() != "" && Integer.parseInt(code) > 1700) {
				return null;
			}
			return code;
		} else {
			return null;
		}
	}

	public String gameByIds(int gameId, String userId) {
		String hql = "SELECT a1 FROM GGamedata WHERE gameId=? AND userId=?  AND available=? and a15=0 AND a3 =3 order by a1*1";
		List<Object> list = super.find(hql, gameId, userId, PropertyValueConstants.AVAILABLE);
		if (list.size() > 0) {
			String code = list.get(0).toString();
			if (code != null && code.trim() != "" && Integer.parseInt(code) > 1700) {
				return null;
			}
			return code;
		} else {
			return null;
		}

	}

	public String gameByIdResult(int gameId, String userId) {
		String hql = "SELECT a15 FROM GGamedata WHERE gameId=? AND userId=? AND available=? ORDER BY createTime DESC";
		List<Object> list = super.find(hql, gameId, userId, PropertyValueConstants.AVAILABLE);
		if (list.size() > 0) {
			return list.get(0).toString();
		} else {
			return null;
		}
	}

	/**
	 * 返回当天最新一条数据
	 * 
	 * @param gamedata
	 * @return
	 */
	public String getNewA10(GGamedata gamedata) {
		String start = DateUtil.getCurrentFormatDate() + " 00:00:00";
		String end = DateUtil.getCurrentFormatDate() + " 23:59:59";
		String hql = "SELECT a10 FROM GGamedata WHERE gameId=? AND userId=? AND available=?  AND a10 IS NOT NULL AND createTime BETWEEN ? AND ? ORDER BY ID DESC";
		List<String> s = super.find(hql, gamedata.getGameId(), gamedata.getUserId(), PropertyValueConstants.AVAILABLE,
				DateUtil.parseStrToDateTime(start), DateUtil.parseStrToDateTime(end));
		if (s.size() != 0 && s.get(0) != null) {
			return s.get(0);
		}
		return "0";
	}

	public List<Object[]> getUpgradeList(GGamedata gamedata) {
		String sql = "SELECT g.`a14` FROM g_gamedata g WHERE g.`game_id`=2   AND g.`user_id`=? AND g.`a6`='0'  ";
		if (gamedata.getA13().equals("1")) {
			sql += "AND g.`a13`='1' AND g.`a14` IN(0,1,2,3,4,5) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());

			return o2;

		} else if (gamedata.getA13().equals("2")) {
			sql += "AND g.`a13`='2' AND g.`a14` IN(6,7,8,9) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());

			return o2;

		} else if (gamedata.getA13().equals("3")) {
			sql += "AND g.`a13`='3' AND g.`a14` IN(10) GROUP BY g.`a14`";
			List<Object[]> o2 = super.findBySQLQuery(sql, gamedata.getUserId());

			return o2;

		}
		return null;
	}

	/**
	 * gameid=3 a5=0 a1的最大值
	 * 
	 * @param userId
	 * @return
	 */
	public GGamedata findGamedataByGameId3(String userId) {
		List<GGamedata> gs = super.find(
				"from GGamedata where available=? and gameId=3 and a5=0 and userId=? order by a1*1 desc",
				PropertyValueConstants.AVAILABLE, userId);
		if (gs.size() != 0) {
			return gs.get(0);
		}
		return null;
	}

	/**
	 * gameid=5 a4=0 a1的最大值
	 * 
	 * @param userId
	 * @return
	 */
	public GGamedata findGamedataByGameId5(String userId) {
		List<GGamedata> gs = super.find(
				"from GGamedata where available=? and gameId=5 and a4=0 and userId=? order by a1*1 desc",
				PropertyValueConstants.AVAILABLE, userId);
		if (gs.size() != 0) {
			return gs.get(0);
		}
		return null;
	}

	/**
	 * gameid=6 a3=0 a1的最大值
	 * 
	 * @param userId
	 * @return
	 */
	public GGamedata findGamedataByGameId6(String userId) {
		List<GGamedata> gs = super.find(
				"from GGamedata where available=? and gameId=6 and a3=0 and userId=? order by a1*1 desc",
				PropertyValueConstants.AVAILABLE, userId);
		if (gs.size() != 0) {
			return gs.get(0);
		}
		return null;
	}

	/**
	 * a3的和
	 * 
	 * @param userId
	 * @return
	 */
	public JSONObject findGamedataSumA3(String userId) {
		List<Object[]> list = super.findBySQLQuery(
				"SELECT g_gamedata.a3 AS sumA3  FROM g_gamedata WHERE g_gamedata.`user_id`=?  AND  g_gamedata.`game_id`=5 AND g_gamedata.a4=0  ORDER BY g_gamedata.`create_time` DESC  LIMIT 0,15",
				userId);
		List<Integer> in = new ArrayList<Integer>();
		for (Object o : list) {
			if (o != null) {
				in.add(Integer.valueOf(o.toString()));
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", in);
		return jsonObject;
	}

	/**
	 * a6的和
	 * 
	 * @param userId
	 * @return
	 */
	public JSONObject findGamedataSumA6(String userId) {
		List<Object[]> list = super.findBySQLQuery(
				"SELECT SUM(g_gamedata.a6 ) AS sumA6 FROM g_gamedata WHERE g_gamedata.`user_id`=?  AND   g_gamedata.`game_id`=3 AND g_gamedata.a5=0   ",
				userId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", list);
		return jsonObject;
	}

}
