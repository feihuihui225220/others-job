package com.anticw.aged.dao.professional.vender;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MReport;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 服务报告持久化对象
 * <P>File name : ReportDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
@Repository
public class ReportDao extends HibernateEntityDao<MReport> {

	/**
	 * 分页按时间段获取服务报告
	 * ReportDao.queryByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MReport> queryByPage(Long userId, Date start, Date end, int page, int num) {
		return this.pagedQuery("from MReport m where m.userId = ? and m.createdAt between ? and ? order by m.createdAt desc", page, num, new Object[]{new Long(userId), start, end});
	}
	
	/** 
	 * 获取用户某专业服务服务报告列表
	 * @name ReportDao.queryByService()
	 * @author zhoupeipei
	 * @Date 2014-10-17 上午5:49:36
	 * @param serviceId
	 * @param userId
	 * @param start
	 * @param end
	 * @param page
	 * @param num
	 * @return     
	 */
	public Page<MReport> queryByService(Integer serviceId, Long userId, Date start, Date end, int page, int num) {
		return this.pagedQuery("from MReport m where m.userId = ? and m.serviceId = ? and m.createdAt between ? and ? order by m.createdAt desc", page, num, new Object[]{new Long(userId), serviceId, start, end});
	}
}
