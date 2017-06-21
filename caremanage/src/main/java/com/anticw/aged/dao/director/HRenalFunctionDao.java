package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HRenalFunction;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->肾功能</a>
 *
 */
@Component
public class HRenalFunctionDao extends  HibernateEntityDao<HRenalFunction>{
	/**
	 * 根据UserId查询肾功能
	 * @param userId
	 * @return
	 */
	public HRenalFunction getHRenalFunction(Long userId){
		String hql = "from HRenalFunction where user_id="+userId+ "order by id desc";
		List<HRenalFunction> result  = super.find(hql);
		if(result.size()!=0){
			return (HRenalFunction) result.get(0);
		}
		return new HRenalFunction("0", "0", "0", "0");
	}
	
	public List<HRenalFunction> getList(Long userId) {
		String hql = "from HRenalFunction where user_id="+userId+ "order by id desc";
		List<HRenalFunction> result  = super.find(hql);
		return result;
	}

	public HRenalFunction selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HRenalFunction h) {
		super.update(h);
		
	}
}
