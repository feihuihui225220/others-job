/**
 * 
 */
package com.anticw.aged.dao.permission;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 权限-资源DAO
 * @author guoyongxiang
 * Date: 2014-9-29
 */
@Repository
public class ResourceDao extends HibernateEntityDao<AResource> {

	/**
	 * 查找所有资源
	 * @author guoyongxiang
	 * Date: 2014-10-2 上午10:13:22
	 * @return
	 */
	public List<AResource> findAll(){
		return this.find("from AResource where available=? order by changedAt desc", PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 权限分配-查询角色列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午12:45:59
	 * @param userCategory
	 * @return
	 */
	public List<AResource> findRes(Short userCategory, int[] exc){
		StringBuffer excbf = new StringBuffer();
		for(int id: exc){
			excbf.append(",").append(id);
		}
		StringBuffer bf = new StringBuffer();
		bf.append("from AResource where userCategory=? and id not in("+excbf.substring(1).toString()+") and available=?");
		return super.find(bf.toString(), userCategory, PropertyValueConstants.AVAILABLE);
	}
	public List<AResource> findRes(Short userCategory){
		
		StringBuffer bf = new StringBuffer();
		bf.append("SELECT id,name FROM a_resource WHERE  user_category=4 AND available=1");
		
		List<AResource> aResources=new ArrayList<AResource>();
    	List<Object[]> list = super.findBySQLQuery(bf.toString());
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			Object[]  column= iter.next();
			AResource vo = new AResource();
			vo.setId((Integer)column[0]);
			vo.setName(column[1].toString());
			aResources.add(vo);
		}
		
		
		return aResources;
	}
	
	/**
	 * 查询资源
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午6:26:00
	 * @param ids
	 * @return
	 */
	public Set<AResource> findResIn(int[] ids){
		StringBuffer bf = new StringBuffer();
		if(ids==null||ids.length<=0){
			return new HashSet<AResource>(0);
		}
		for(int id: ids){
			bf.append(",").append(id);
		}
		List<AResource> list = super.find("from AResource where id in("+bf.substring(1).toString()+") and available=?", PropertyValueConstants.AVAILABLE);
		Set<AResource> set = new HashSet<AResource>();
		set.addAll(list);
		return set;
	}
	
	/**
	 * 根据Id删除资源及关联关系
	 * @author guoyongxiang
	 * Date: 2014-10-10 下午3:27:34
	 * @param id
	 */
	public void remove(Integer id){
		AResource resource = super.get(id);
		// 从主控表删除被控表关联关系
		for(ARole role: resource.getRoles()){
			role.getResources().remove(resource);
		}
		super.remove(resource);
	}
}
