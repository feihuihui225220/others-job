package com.anticw.aged.service.admin;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HVisitCategory;
import com.anticw.aged.dao.admin.CategoryRoundsDao;

@Service
public class CategoryRoundsServicec {

	@Autowired
	private CategoryRoundsDao categoryRoundsDao;
	
	public List<HVisitCategory> list(int parentId){
		return categoryRoundsDao.list(parentId);
	}
	public HVisitCategory getMPlanCategoryById(Serializable id) {
		return categoryRoundsDao.get(id);
	}
	public void insertPlanCategoryValue(HVisitCategory planCategory ,int parentId){
		categoryRoundsDao.insertPlanCategoryValue(planCategory, parentId);
	}
	
	public void editPlanCategory(HVisitCategory categoryItem){
		this.categoryRoundsDao.editPlanCategory(categoryItem);
	}
	
	public void delPlanCategoryById(int id){
		categoryRoundsDao.removeById(id);
	}
	
}
