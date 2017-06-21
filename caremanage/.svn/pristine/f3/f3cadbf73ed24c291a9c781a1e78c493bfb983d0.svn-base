package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HHormone;
import com.anticw.aged.dao.utils.HibernateEntityDao;


/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->激素</a>
 *
 */
@Component
public class HHormoneDao extends  HibernateEntityDao<HHormone>{
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HHormone getHHormone(Long userId){
		String hql = "from HHormone where user_id="+userId+ "order by id desc";
		List<HHormone> result  = super.find(hql);
		if(result.size()!=0){
			return (HHormone) result.get(0);
		}
		return new HHormone("0", "0", "0", "0", "0", "0", "0","0", "0","0");
	}
	
	public List<HHormone> getList(Long userId) {
		String hql = "from HHormone where user_id="+userId+ "order by id desc";
		List<HHormone> result  = super.find(hql);
		return result;
	}

	public HHormone selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HHormone h) {
		super.update(h);
		
	}
}
