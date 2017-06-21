package com.anticw.aged.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.dao.user.OCategoryItemDao;
@Service
public class OCategoryItemService {
	@Autowired
	private OCategoryItemDao oCategoryItemDao;
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OCategoryItem getItemName(int id){
		return oCategoryItemDao.getItemName(id);
	}
}
