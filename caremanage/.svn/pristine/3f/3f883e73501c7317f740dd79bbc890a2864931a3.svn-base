package com.anticw.aged.dao.professional.vender;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MUserState;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 用户状态持久化对象
 * <P>File name : UserStateDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Repository
public class UserStateDao extends HibernateEntityDao<MUserState> {

	/**
	 * 获取指定用户今日的状态数据
	 * UserStateDao.getTodayStates()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param userId
	 * @return
	 */
	public MUserState getTodayStates(Long userId) {
		
		//开始时间
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		
		//结束时间
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.HOUR_OF_DAY, 23);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		
		//查询今日状态数据
		List<MUserState> userStates = this.find("from MUserState m where m.userId = ? and m.createdAt between ? and ?", new Object[]{Long.valueOf(userId), c1.getTime(), c2.getTime()});
		
		//返回数据
		if(userStates != null && !userStates.isEmpty()) {
			return userStates.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取状态数据
	 * UserStateDao.queryByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param start
	 * @param end
	 * @param userId
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MUserState> queryByPage(Date start, Date end, Long userId, int page, int num) {
		if(start==null && end==null){
			return this.pagedQuery("from MUserState m where m.userId = ? order by m.createdAt desc", page, num, new Object[]{Long.valueOf(userId)});
		} else if(start == null){
			return this.pagedQuery("from MUserState m where m.userId = ? and m.createdAt < ? order by m.createdAt desc", page, num, new Object[]{Long.valueOf(userId), end});
		} else if(end == null){
			return this.pagedQuery("from MUserState m where m.userId = ? and m.createdAt > ? order by m.createdAt desc", page, num, new Object[]{Long.valueOf(userId), start});
		} else {
			return this.pagedQuery("from MUserState m where m.userId = ? and m.createdAt between ? and ? order by m.createdAt desc", page, num, new Object[]{Long.valueOf(userId), start, end});
		}
	}
}
