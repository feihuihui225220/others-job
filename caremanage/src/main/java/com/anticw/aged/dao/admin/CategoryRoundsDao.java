package com.anticw.aged.dao.admin;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HVisitCategory;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class CategoryRoundsDao extends HibernateEntityDao<HVisitCategory>{

	/**
	 * 查询状态
	 * @param parentId
	 * @return
	 */
	public List<HVisitCategory> list(int parentId){
		return this.find("from HVisitCategory where available=? and parentId=? order by changedAt desc", PropertyValueConstants.AVAILABLE,parentId);
	}
	/**
	 *  parentId=0 时添加计划分类
	 *  否则                           添加计划子项值
	 * 
	 * */
	
	public void insertPlanCategoryValue(HVisitCategory mPlanCategory,int parentId){
		Date date = new Date();
		mPlanCategory.setAvailable(PropertyValueConstants.AVAILABLE);
		mPlanCategory.setParentId(parentId);
		mPlanCategory.setCreatedAt(date);
		mPlanCategory.setChangedAt(date);
		 
		super.save(mPlanCategory);
	}

	/**
	 * 查询单条数据
	 * 
	 * */
	public HVisitCategory findPlanCategory(int id){
		return super.get(id);
	}
	
	/**
	 * 编辑计划分类
	 * 
	 * */
	public void editPlanCategory(HVisitCategory mPlanCategory){
		Date  date = new Date();
		HVisitCategory oct =findPlanCategory(mPlanCategory.getId());
		oct.setName(mPlanCategory.getName());
		oct.setChangedAt(date);
		super.update(oct);
}

	/**
	 * 逻辑删除计划分类
	 * 
	 * */
	
	public void delStateCategoryById(int id){
		super.removeById(id);
	}
	
}
