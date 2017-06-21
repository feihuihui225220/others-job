package com.anticw.aged.dao.director;

import java.util.List;
import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HElectrolyte;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->电解质</a>
 *
 */
@Component
public class HElectrolyteDao extends  HibernateEntityDao<HElectrolyte>{

	/**
	 * 根据UserId查询电解质
	 * @param userId
	 * @return
	 */
	public HElectrolyte getHElectrolyte(Long userId){
		String hql = "from HElectrolyte where user_id="+userId+ "order by id desc";
		List<HElectrolyte> result  = super.find(hql);
		if(result.size()!=0){
			return (HElectrolyte) result.get(0);
		}
		return new HElectrolyte("0", "0", "0", "0", "0");
	}
	
	public List<HElectrolyte> getList(Long userId) {
		String hql = "from HElectrolyte where user_id="+userId+ "order by id desc";
		List<HElectrolyte> result  = super.find(hql);
		return result;
	}

	public HElectrolyte selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HElectrolyte h) {
		super.update(h);
		
	}
}
