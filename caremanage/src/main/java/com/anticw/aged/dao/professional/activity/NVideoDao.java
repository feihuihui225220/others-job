package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NVideo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @author dx  2016/4/12
 *
 */
@Repository
public class NVideoDao extends HibernateEntityDao<NVideo>{
	
	public NVideo fingByNPId(int programId){
		super.flushSession();
		String hql="from NVideo where programId=? and avaliable=?";
		List<NVideo> n=super.find(hql, programId,Boolean.valueOf(PropertyValueConstants.AVAILABLE));
		
		if(n.size()!=0){
			return n.get(0);
		}else{
			return null;
		}
	}
	
}
