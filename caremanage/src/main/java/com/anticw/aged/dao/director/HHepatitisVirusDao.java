package com.anticw.aged.dao.director;

import java.util.List;

import org.springframework.stereotype.Component;
import com.anticw.aged.bean.HHepatitisVirus;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 
 * @author DX-2016-9-12  
 * <a>生化指标-->肝炎病毒</a>
 *
 */
@Component
public class HHepatitisVirusDao extends  HibernateEntityDao<HHepatitisVirus>{

	/**
	 * 根据UserId查询
	 * @param userId
	 * @return
	 */
	/*public HHepatitisVirus getHHepatitisVirus(Long userId){
		List<Object> o=super.find("FROM HHepatitisVirus WHERE userId=?", userId);
		if(o.size()!=0){
			return (HHepatitisVirus) o.get(0);
		}
		return new HHepatitisVirus("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
	}*/
	
	public HHepatitisVirus getHHepatitisVirus(Long userId){
		String hql = "from HHepatitisVirus where user_id="+userId+ "order by id desc";
		List<HHepatitisVirus> result  = super.find(hql);
		if(result.size()!=0){
			return (HHepatitisVirus)result.get(0);
		}
		return new HHepatitisVirus("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
	}
	public List<HHepatitisVirus> getList(Long userId) {
		String hql = "from HHepatitisVirus where user_id="+userId+ "order by id desc";
		List<HHepatitisVirus> result  = super.find(hql);
		return result;
	}
	public HHepatitisVirus selectById(Integer id) {
		
		return super.get(id);
	}
	public void edit(HHepatitisVirus h) {
		super.update(h);
		
	}
}
