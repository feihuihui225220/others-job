package com.anticw.aged.dao.professional.assess;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAssessGds;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Component
public class MAssessGdsDao extends HibernateEntityDao<MAssessGds>{

	public MAssessGds getUserId(Long userId){
		List<MAssessGds> gds=super.find("from MAssessGds where userId=? order by id desc", userId);
		if(gds.size()!=0){
			return gds.get(0);
		}
		return null;
	}
}
