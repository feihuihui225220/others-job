package com.anticw.aged.dao.permission;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.RReport;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author dx
 *
 */
@Repository
public class RReportDao  extends HibernateEntityDao<RReport>{
	/**
	 * 添加报告记录
	 * @param rReport
	 */
	public void setRReport(RReport rReport){
		super.save(rReport);
	}
	/**
	 * 根据用户老年id查询下面所有的报告
	 */
	public List<RReport> listRReport(long userId){
		List<RReport> rReportL=super.find("from RReport r where r.rUserId=?  order by r.id desc", userId);
		return rReportL;
	}
	public List<RReport> listRReports(String principal){
		List<RReport> rReportL=super.find("from RReport r where r.principal=?  order by r.id desc", principal);
		return rReportL;
	}
	
	/**
	 * 根据deleTime查出一条
	 * @param deleTime
	 */
	public RReport rReport(String deleTime){
		List<RReport> rReportL=super.find("from RReport r where r.dateTime=?", deleTime);
		return rReportL.get(0);
	}
	public RReport rReport(long id){
		return super.get(id);
	}
	
	
	/**
	 * 删除一条
	 */
	public void delete(RReport rReport){
		super.remove(rReport);
	}
}
