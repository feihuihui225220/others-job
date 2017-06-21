package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HUrineRoutine;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->尿常规</a>
 *
 */
@Component
public class HUrineRoutineDao extends  HibernateEntityDao<HUrineRoutine> {
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HUrineRoutine getHUrineRoutine(Long userId){
		String hql = "from HUrineRoutine where user_id="+userId+ "order by id desc";
		List<HUrineRoutine> result  = super.find(hql);
		if(result.size()!=0){
			return (HUrineRoutine) result.get(0);
		}
		return new HUrineRoutine("0", "0", "0", "0", "0", "0", "0","0", "0","0");
	}
	
	public List<HUrineRoutine> getList(Long userId) {
		String hql = "from HUrineRoutine where user_id="+userId+ "order by id desc";
		List<HUrineRoutine> result  = super.find(hql);
		return result;
	}

	public HUrineRoutine selectById(Integer id) {
		
		return  super.get(id);
	}

	public void edit(HUrineRoutine huri) {
		super.update(huri);
		
	}
}
