package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HBloodFat;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->血脂</a>
 *
 */
@Component
public class HBloodFatDao extends  HibernateEntityDao<HBloodFat>{
	/**
	 * 根据UserId查询血常规数据
	 * @param userId
	 * @return
	 */
	public HBloodFat getHBloodFat(Long userId){
		String hql = "from HBloodFat where user_id="+userId+ "order by id desc";
		List<HBloodFat> result  = super.find(hql);
		if(result.size()!=0){
			return (HBloodFat) result.get(0);
		}
		return new HBloodFat("0", "0", "0", "0", "0", "0", "0","0");
	}
	
	public List<HBloodFat> getList(Long userId) {
		String hql = "from HBloodFat where user_id="+userId+ "order by id desc";
		List<HBloodFat> result  = super.find(hql);
		return result;
	}

	public HBloodFat selectById(Integer id) {
		
		return super.get(id);
	}

	public void edit(HBloodFat h) {
		super.update(h);		
	}
}
