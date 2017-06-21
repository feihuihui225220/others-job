package com.anticw.aged.service.professional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.RReport;
import com.anticw.aged.dao.permission.RReportDao;

@Service
public class RReportSrevice {
	@Autowired
	private RReportDao rReportDao;
	
	public void setRReport(RReport rReport){
		rReportDao.setRReport(rReport);
	}
	public List<RReport> listRReport(long userId){
		return	rReportDao.listRReport(userId);
	}
	public List<RReport> listRReport(String principal){
		return	rReportDao.listRReports(principal);
	}
	public RReport rReport(long userId){
		return rReportDao.rReport(userId);
	}
	public RReport rReport(String deleTime){
		return rReportDao.rReport(deleTime);
	}
	public void delete(RReport rReport){
		rReportDao.delete(rReport);
	}
}
