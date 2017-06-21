package com.anticw.aged.service.huiZheng;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HTreatment;
import com.anticw.aged.dao.huiZheng.HTreatmentDao;

@Service
public class HTreatmentService {

	@Autowired
	private HTreatmentDao hTreatmentDao;
	
	
	public void insertTreat(HTreatment hTreatment)throws IllegalAccessException, InvocationTargetException {
		hTreatmentDao.insertTreat(hTreatment);	
	}

	public List<HTreatment> listResult(Long userId) {
		return hTreatmentDao.listResult(userId);
	}
	
	public void delete(Integer resultId) {
		hTreatmentDao.delete(resultId);
		
	}

	public void edit(HTreatment hTreatment) {
		hTreatmentDao.edit(hTreatment);
	}

	public List<HTreatment> findById(Integer resultId) {		
		return hTreatmentDao.findById(resultId);
	}
}