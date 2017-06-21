package com.anticw.aged.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MStateCategory;
import com.anticw.aged.dao.admin.StatueCategoryDao;

@Service
public class StatueCategoryService {
	
	@Autowired
	private StatueCategoryDao statueCategoryDao;
	
	public List<MStateCategory> list(int parentId){
		return statueCategoryDao.list(parentId);
	}
	
	public void insertStatueCategoryValue(MStateCategory stateCategory ,int parentId){
		statueCategoryDao.insertStateCategoryValue(stateCategory, parentId);
	}
	
	public void editStatueCategory(MStateCategory categoryItem){
		this.statueCategoryDao.editStateCategory(categoryItem);
	}
	
	public void delStatueCategoryById(int id){
		 statueCategoryDao.removeById(id);
	}
	
}
