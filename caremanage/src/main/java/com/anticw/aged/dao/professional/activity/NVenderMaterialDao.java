package com.anticw.aged.dao.professional.activity;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.NVenderMaterial;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
/**
 * 
 * @author DX 2016-7-12
 *
 */
@Repository
public class NVenderMaterialDao extends HibernateEntityDao<NVenderMaterial>{

		public void delete(NProgram nProgram ){
			String sql="DELETE FROM  n_vender_material WHERE n_vender_material.program_id="+nProgram.getId(); 
			super.executeSQL(sql);
		}
		
		public List<NProgram> selectList(String materialName){
			String hql="from NVenderMaterial.nProgram where materialName like '%"+materialName+"%' group by nProgram.id";
		 	List<NProgram> nVenderMaterial=super.find(hql);
			/*List<NProgram> npr=new ArrayList<NProgram>();
			Iterator<NVenderMaterial> itre=	nVenderMaterial.iterator();
			while (itre.hasNext()){
				npr.add(itre.next().getnProgram());
			}
			HashSet<NProgram> h = new HashSet<NProgram>(npr);  
			npr.clear();  
			npr.addAll(h);  */
		 	return	nVenderMaterial;
		}
		public Page<NProgram> selectPage(String materialName,Integer pageInddex,Integer number){
			String hql="select n.nProgram from NVenderMaterial n ";
			if(materialName!=null&&materialName.trim()!=""){
				hql+=" where n.materialName like '%"+materialName+"%' ";
				
			}
			hql+=" group by n.nProgram.id";
			return super.pagedQuery(hql, pageInddex, number);
		//	List<NProgram> nVenderMaterial=super.find(hql);
			/*List<NProgram> npr=new ArrayList<NProgram>();
			Iterator<NVenderMaterial> itre=	nVenderMaterial.iterator();
			while (itre.hasNext()){
				npr.add(itre.next().getnProgram());
			}
			HashSet<NProgram> h = new HashSet<NProgram>(npr);  
			npr.clear();  
			npr.addAll(h);  */
		// 	return	nVenderMaterial;
		}
	
}
