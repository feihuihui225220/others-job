package com.anticw.aged.service.icare.combo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZFitnessConclusion;
import com.anticw.aged.dao.icare.combo.ZFitnessConclusionDao;

@Service
public class ZFitnessConclusionService {

	@Autowired
	private ZFitnessConclusionDao zFitnessConclusionDao;
	
	/**
	 * 根据Id获取一条
	 * @param id
	 * @return
	 */
	public ZFitnessConclusion getById(int id){
		return  zFitnessConclusionDao.get(id);
	}
	
	public void update(ZFitnessConclusion z){
		ZFitnessConclusion z1=getById(z.getId());
		if(z.getComboId()!=null){
			z1.setComboId(z.getComboId());
		}
		zFitnessConclusionDao.save(z1);
	}
	
	/**
	 * 获取体适能对应的结论
	 * @param fitnessId
	 * @return
	 */
	public List<ZFitnessConclusion> getList(int fitnessId){
		return zFitnessConclusionDao.getList(fitnessId);
	}
	
	public List<ZFitnessConclusion> getList(){
		return zFitnessConclusionDao.getList();
		
	}
}
