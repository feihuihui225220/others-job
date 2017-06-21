package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HCellularImmunity;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->细胞免疫</a>
 *
 */
@Component
public class HCellularImmunityDao extends  HibernateEntityDao<HCellularImmunity>{

	/**
	 * 根据UserId查询细胞免疫
	 * @param userId
	 * @return
	 */
	public HCellularImmunity getHCellularImmunity(Long userId){
		String hql = "from HCellularImmunity where user_id="+userId+ "order by id desc";
		List<HCellularImmunity> result  = super.find(hql);
		if(result.size()!=0){
			return (HCellularImmunity) result.get(0);
		}
		return new HCellularImmunity("0", "0", "0");
	}
	
	public List<HCellularImmunity> getList(Long userId) {
		String hql = "from HCellularImmunity where user_id="+userId+ "order by id desc";
		List<HCellularImmunity> result  = super.find(hql);
		return result;
	}

	public HCellularImmunity selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HCellularImmunity h) {
		super.update(h);
		
	}
}
