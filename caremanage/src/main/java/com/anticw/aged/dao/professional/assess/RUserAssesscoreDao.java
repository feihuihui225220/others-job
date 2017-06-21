package com.anticw.aged.dao.professional.assess;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.RUserAssesscore;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class RUserAssesscoreDao extends HibernateEntityDao<RUserAssesscore> {

	public void save(RUserAssesscore r) {
		super.save(r);
		super.currentSession().flush();
		super.currentSession().clear();
	}

}
