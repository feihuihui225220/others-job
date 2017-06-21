package com.anticw.aged.dao.user;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Repository
public class OCategoryItemDao extends HibernateEntityDao<OCategoryItem>{
	//根据id查询itemname
	public OCategoryItem getItemName(int id){
		return super.get(id);
	}
}
