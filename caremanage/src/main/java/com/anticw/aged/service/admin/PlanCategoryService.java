package com.anticw.aged.service.admin;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.MPlanCategory;
import com.anticw.aged.dao.admin.PlanCategoryDao;

@Service
public class PlanCategoryService {
	
	@Autowired
	private PlanCategoryDao planCategoryDao;
	
	public List<MPlanCategory> list(int parentId){
		return planCategoryDao.list(parentId);
	}
	public MPlanCategory getMPlanCategoryById(Serializable id) {
		return planCategoryDao.get(id);
	}
	public void insertPlanCategoryValue(MPlanCategory planCategory ,int parentId){
		planCategoryDao.insertPlanCategoryValue(planCategory, parentId);
	}
	
	public void editPlanCategory(MPlanCategory categoryItem){
		this.planCategoryDao.editPlanCategory(categoryItem);
	}
	
	public void delPlanCategoryById(int id){
		 planCategoryDao.removeById(id);
	}
	
}
