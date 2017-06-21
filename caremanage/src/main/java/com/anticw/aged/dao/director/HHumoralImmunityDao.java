package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HHumoralImmunity;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->体液免疫</a>
 *
 */
@Component
public class HHumoralImmunityDao extends  HibernateEntityDao<HHumoralImmunity>{
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HHumoralImmunity getHHumoralImmunity(Long userId){
		String hql = "from HHumoralImmunity where user_id="+userId+ "order by id desc";
		List<HHumoralImmunity> result  = super.find(hql);
		if(result.size()!=0){
			return (HHumoralImmunity) result.get(0);
		}
		return new HHumoralImmunity("0", "0", "0", "0", "0");
	}
	
	public List<HHumoralImmunity> getList(Long userId) {
		String hql = "from HHumoralImmunity where user_id="+userId+ "order by id desc";
		List<HHumoralImmunity> result  = super.find(hql);
		return result;
	}

	public HHumoralImmunity selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HHumoralImmunity h) {
		super.update(h);
		
	}
}
