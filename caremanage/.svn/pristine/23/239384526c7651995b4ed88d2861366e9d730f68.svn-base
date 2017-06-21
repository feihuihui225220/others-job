package com.anticw.aged.dao.position;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.ZStepCount;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author dx
 * @date 2017/05/22
 * @text 计步
 *
 */
@Repository
public class ZStepCountDao extends HibernateEntityDao<ZStepCount>{

	public ZStepCount getByUserId(Long userId){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date createTime = calendar.getTime();
		String hql="from ZStepCount where userId=? and createTime=?";
		List<ZStepCount> lists=super.find(hql, userId,createTime);
		if(lists.size()>0){
			return lists.get(0);
		}
		return null;
	}
}
