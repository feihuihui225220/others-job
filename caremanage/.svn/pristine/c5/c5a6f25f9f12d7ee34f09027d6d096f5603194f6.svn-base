package com.anticw.aged.dao.assess;



import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAnalysisStudy;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Component
public class MAnalysisStudyDao  extends HibernateEntityDao<MAnalysisStudy>{

	public void select(MAnalysisStudy m,Date sDate,Date eDate,Date da){
		m.setCreatedAt(da);
		m.setCreatedBy("admin");
		m.setStart(sDate);
		m.setEnd(eDate);
		super.save(m);
	}
	
	public List<MAnalysisStudy> getList(){
		String hql="from  MAnalysisStudy where createdAt=(select max(createdAt) from MAnalysisStudy) ";
		return super.find(hql);
	}
}
