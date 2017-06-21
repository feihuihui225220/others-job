package com.anticw.aged.dao.professional.vender;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MMessage;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 实时消息持久化对象
 * <P>File name : MsgDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
@Repository
public class MsgDao extends HibernateEntityDao<MMessage> {

	/**
	 * 分页查询
	 * MsgDao.queryByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MMessage> queryByPage(long userId, int page, int num) {
		return this.pagedQuery("from MMessage m where m.userId = ? order by m.createdAt desc", page, num, new Object[]{new Long(userId)});
	}
	
	/**
	 * 分页查询按时间段
	 * MsgDao.queryByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MMessage> queryByPage(long userId, Date start, Date end, int page, int num) {
		if(start == null && end == null){
			return this.pagedQuery("from MMessage m where m.userId = ?", page, num, new Object[]{new Long(userId)});
		}else{
		     return this.pagedQuery("from MMessage m where m.userId = ? and m.createdAt between ? and ?", page, num, new Object[]{new Long(userId), start, end});
		}
	}
	
	/** 
	 * 获取专业服务实时消息
	 * @name MsgDao.queryByServicePage()
	 * @author zhoupeipei
	 * @Date 2014-10-18 下午12:51:11
	 * @param userId
	 * @param serviceId
	 * @param page
	 * @param num
	 * @return     
	 */
	public Page<MMessage> queryByServicePage(long userId,int serviceId, int page, int num){
		return this.pagedQuery("from MMessage m where m.userId = ? and m.serviceId = ? order by m.createdAt desc", page, num, new Object[]{new Long(userId), serviceId});
	}
}
