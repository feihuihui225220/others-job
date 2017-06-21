package com.anticw.aged.service.position;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZStepCount;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.position.ZStepCountDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.utils.DateUtil;

/**
 * 
 * @author dx
 * @date 2017/05/22
 * @text 计步
 *
 */
@Service
public class ZStepCountService {

	@Autowired
	private ZStepCountDao zStepCountDao;
	
	@Autowired
	private RUserDao userDao;
	
	/**
	 * 添加计步记录
	 * @param zStepCount
	 * @return
	 */
	public Long save(ZStepCount zStepCount){
        zStepCount.setCreateTime( DateUtil.getStartDate(new Date()));
		zStepCountDao.save(zStepCount);
		return zStepCount.getId();
	}
	
	/**
	 * 根据用户id获取今日添加记录 无添加返回null
	 * @param userId
	 * @return
	 */
	public ZStepCount getByUserId(Long userId){
		return zStepCountDao.getByUserId(userId);
	}
	
	/**
	 * 添加当天计步数据  有则修改无则添加
	 * @param zStepCount
	 * @return
	 */
	public Long update(ZStepCount zStepCount){
		ZStepCount z=getByUserId(zStepCount.getUserId());
		if(z!=null){
			int count=z.getCount()+zStepCount.getCount();
			z.setCount(count);
			zStepCountDao.update(z);
		}else{
			save(zStepCount);
		}
		return z.getUserId();
	}
	
	public String getById(Long userId){
		return userDao.get(userId).getMobilePhone();
	}
}
