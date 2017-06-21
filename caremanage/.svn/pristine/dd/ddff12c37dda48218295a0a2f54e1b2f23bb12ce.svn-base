package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NTrainStaff;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Repository
public class NTrainStaffDao extends HibernateEntityDao<NTrainStaff>{

	public List<NTrainStaff> getNTrainStaff(int trainId){
		String hql="from NTrainStaff n where trainId=? ";
		return super.find(hql, trainId);
	}
	
}
