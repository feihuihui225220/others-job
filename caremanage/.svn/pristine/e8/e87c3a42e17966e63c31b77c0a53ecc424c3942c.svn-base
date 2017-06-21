package com.anticw.aged.dao.director;


import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HBloodRoutine;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->血常规</a>
 *
 */
@Component
public class HBloodRoutineDao extends  HibernateEntityDao<HBloodRoutine>{
	/**
	 * 根据UserId查询血常规数据
	 * @param id
	 * @param session 
	 * @return
	 */
	public HBloodRoutine getHBloodRoutine(long userId){
		String hql = "FROM HBloodRoutine WHERE user_id= "+userId+"order by id desc ";		
		List<HBloodRoutine> result  = super.find(hql);
		if(result.size()!=0){
			return (HBloodRoutine) result.get(0);
		}
		return new HBloodRoutine("0", "0", "0", "0", "0", "0", "0","0", "0","0");
		
	}

	public List<HBloodRoutine> getList(Long userId) {
		String hql = "from HBloodRoutine where user_id="+userId+ "order by id desc";
		List<HBloodRoutine> result  = super.find(hql);
		return result;
	}

	public HBloodRoutine selectById(Integer id) {
		return super.get(id);
	}

	
	public void edit(HBloodRoutine hrt) {
		 super.update(hrt);
	}
}
