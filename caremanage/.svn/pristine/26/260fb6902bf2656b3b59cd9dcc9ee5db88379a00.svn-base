package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HDicCheck;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->DIC相关检查</a>
 *
 */
@Component
public class HDicCheckDao  extends  HibernateEntityDao<HDicCheck>{
	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	public HDicCheck getHDicCheck(Long userId){
		String hql = "from HDicCheck where user_id="+userId+ "order by id desc";
		List<HDicCheck> result  = super.find(hql);
		if(result.size()!=0){
			return (HDicCheck) result.get(0);
		}
		return new HDicCheck("0", "0", "0", "0", "0", "0");
		
	}
	
	public List<HDicCheck> getList(Long userId) {
		String hql = "from HDicCheck where user_id="+userId+ "order by id desc";
		List<HDicCheck> result  = super.find(hql);
		return result;
	}

	public HDicCheck selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HDicCheck h) {
		super.update(h);
		
	}
	
}
