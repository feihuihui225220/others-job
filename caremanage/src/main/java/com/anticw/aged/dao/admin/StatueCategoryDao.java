package com.anticw.aged.dao.admin;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MStateCategory;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class StatueCategoryDao extends HibernateEntityDao<MStateCategory>{
	
	/**
	 * 查询状态
	 * @param parentId
	 * @return
	 */
	public List<MStateCategory> list(int parentId){
		return this.find("from MStateCategory where available=? and parentId=? order by changedAt desc", PropertyValueConstants.AVAILABLE,parentId);
	}
	
	
	/**
	 *  parentId=0 时添加状态分类
	 *  否则                           添加状态子项值
	 * 
	 * */
	
	public void insertStateCategoryValue(MStateCategory mStateCategory,int parentId){
		Date date = new Date();
		mStateCategory.setAvailable(PropertyValueConstants.AVAILABLE);
		mStateCategory.setParentId(parentId);
		mStateCategory.setCreatedAt(date);
		mStateCategory.setChangedAt(date);
		super.save(mStateCategory);
	}

	/**
	 * 查询单条数据
	 * 
	 * */
	public MStateCategory findStateCategory(int id){
		return super.get(id);
	}
	
	/**
	 * 编辑状态分类
	 * 
	 * */
	public void editStateCategory(MStateCategory mStateCategory){
		Date  date = new Date();
		MStateCategory oct =findStateCategory(mStateCategory.getId());
		oct.setName(mStateCategory.getName());
		oct.setChangedAt(date);
		super.update(oct);
}

	/**
	 * 逻辑删除状态分类
	 * 
	 * */
	
	public void delStateCategoryById(int id){
		super.removeById(id);
	}
	
}
