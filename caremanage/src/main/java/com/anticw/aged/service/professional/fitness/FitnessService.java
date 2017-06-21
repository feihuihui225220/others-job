package com.anticw.aged.service.professional.fitness;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessFitness;
import com.anticw.aged.dao.professional.fitness.FitnessDao;
@Service
public class FitnessService {
	@Autowired
	private FitnessDao fitnessDao;
	
	public MAssessFitness insertFitness(MAssessFitness maFitness)throws IllegalAccessException, InvocationTargetException {
		return fitnessDao.insertFitness(maFitness);	
	}

	public List<MAssessFitness> selectResult(Long userId) {
		return fitnessDao.selectResult(userId);
		
	}
//---------------------评估结果历史--------------------

	public List<MAssessFitness> listResult(Long userId) {
		return fitnessDao.listResult(userId);
	}

	public List<MAssessFitness> getResultDetailByTime(Integer resultId) {		
		return fitnessDao.getResultDetailByTime(resultId);
	}

	public void delete(Integer resultId) {
		fitnessDao.delete(resultId);
		
	}

	
}
