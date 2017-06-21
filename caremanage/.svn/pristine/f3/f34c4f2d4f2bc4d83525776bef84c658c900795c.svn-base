package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HLiverFunction;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->肝功能</a>
 *
 */
@Component
public class HLiverFunctionDao extends  HibernateEntityDao<HLiverFunction>{
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HLiverFunction getHLiverFunction(Long userId){
		String hql = "from HLiverFunction where user_id="+userId+ "order by id desc";
		List<HLiverFunction> result  = super.find(hql);
		if(result.size()!=0){
			return (HLiverFunction) result.get(0);
		}
		return new HLiverFunction("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
	}
	
	public List<HLiverFunction> getList(Long userId) {
		String hql = "from HLiverFunction where user_id="+userId+ "order by id desc";
		List<HLiverFunction> result  = super.find(hql);
		return result;
	}

	public HLiverFunction selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HLiverFunction h) {
		super.update(h);
		
	}
}
