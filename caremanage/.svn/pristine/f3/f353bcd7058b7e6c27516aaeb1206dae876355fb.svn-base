package com.anticw.aged.dao.icare.combo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZFitnessConclusion;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**体适能套餐  
 * @author DX-1992413
 *
 */
@Component
public class ZFitnessConclusionDao extends HibernateEntityDao<ZFitnessConclusion>{
	
	/**
	 * 根据选项获取所有的Id
	 * @param fitnessId
	 * @return
	 */
	public List<ZFitnessConclusion> getList(int fitnessId){
		String hql="from ZFitnessConclusion where fitnessId=?";
		return super.find(hql, fitnessId);
	}
	
	public List<ZFitnessConclusion> getList(){
		String hql="from ZFitnessConclusion";
		return super.find(hql);
	
	}
}
