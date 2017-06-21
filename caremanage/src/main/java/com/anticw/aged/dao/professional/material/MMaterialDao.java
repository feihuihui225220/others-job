package com.anticw.aged.dao.professional.material;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MMaterial;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 
 * @author DX 2016/6/19
 *
 */
@Repository
public class MMaterialDao extends HibernateEntityDao<MMaterial>{
	/**
	 * 
	 * @param venderId
	 * @param page
	 * @param num
	 * @param mMaterial
	 * @return
	 */
	public Page<MMaterial> list(Integer venderId, int page, int num,MMaterial mMaterial) {
		if(venderId!=null){
			StringBuffer sb=new StringBuffer("from MMaterial m where m.venderId =").append(venderId);
			if(mMaterial.getMaterialNature()!=null&&!"".equals(mMaterial.getMaterialNature().trim())&&!"请选择".equals(mMaterial.getMaterialNature().trim())){
				sb.append(" and  m.materialNature='").append(mMaterial.getMaterialNature()).append("'");
			}
			if(mMaterial.getMaterialName()!=null&&!"".equals(mMaterial.getMaterialName())){
				sb.append(" and  m.materialName  like '%").append(mMaterial.getMaterialName()).append("%'");
			}
			return super.pagedQuery(sb.toString(), page, num );
			
		}
		return null;
	}
	
	public List<MMaterial> getList(String name,Integer venderId){
		String materialNature="课程物料";
		if(name!=null&&name!=""){
			String hql="from MMaterial m where m.materialName  like '%"+name+"%'  and  m.materialNature=? and  m.venderId =?";
			return super.find(hql,materialNature,venderId);
			
		}
		
		return null;
	}
	
	public List<MMaterial> getList(String Ids){
		return super.find("from MMaterial where id in ("+Ids+")");
	}
}
