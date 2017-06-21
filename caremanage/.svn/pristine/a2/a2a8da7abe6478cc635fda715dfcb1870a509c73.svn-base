package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HBloodGasAnalysis;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->血气分析</a>
 *
 */
@Component
public class HBloodGasAnalysisDao extends  HibernateEntityDao<HBloodGasAnalysis>{
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HBloodGasAnalysis getHBloodGasAnalysis(Long userId){
		String hql = "from HBloodGasAnalysis where user_id="+userId+ "order by id desc";
		List<HBloodGasAnalysis> result  = super.find(hql);
		if(result.size()!=0){
			return (HBloodGasAnalysis) result.get(0);
		}
		return new HBloodGasAnalysis("0", "0", "0", "0", "0", "0", "0","0");
	}
	
	public List<HBloodGasAnalysis> getList(Long userId) {
		String hql = "from HBloodGasAnalysis where user_id="+userId+ "order by id desc";
		List<HBloodGasAnalysis> result  = super.find(hql);
		return result;
	}

	public HBloodGasAnalysis selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HBloodGasAnalysis t) {
		super.update(t);
		
	}
}
