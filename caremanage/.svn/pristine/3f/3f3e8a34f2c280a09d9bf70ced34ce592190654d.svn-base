package com.anticw.aged.dao.admin;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MPlanCategory;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;

@Component
public class PlanCategoryDao extends HibernateEntityDao<MPlanCategory>{
	
	/**
	 * 查询状态
	 * @param parentId
	 * @return
	 */
	public List<MPlanCategory> list(int parentId){
		return this.find("from MPlanCategory where available=? and parentPlanCategory.id=? order by changedAt desc", PropertyValueConstants.AVAILABLE,parentId);
	}
	
	
	/**
	 *  parentId=0 时添加计划分类
	 *  否则                           添加计划子项值
	 * 
	 * */
	
	public void insertPlanCategoryValue(MPlanCategory mPlanCategory,int parentId){
		Date date = new Date();
		mPlanCategory.setAvailable(PropertyValueConstants.AVAILABLE);
		mPlanCategory.setParentPlanCategory(super.get(parentId));
		//mPlanCategory.setParentId(parentId);
		mPlanCategory.setCreatedAt(date);
		mPlanCategory.setChangedAt(date);
		if(parentId==0){
		String sql="insert  into m_plan_category"
				+ "(available, changed_at, changed_by, created_at, created_by, name, parent_id, version) "
				+ " values (1, '"+DateUtil.parseDateToString(date, "yyyy-MM-dd HH:mm:ss")+"', 'admin', '"+DateUtil.parseDateToString(date, "yyyy-MM-dd HH:mm:ss")+"', 'admin', '"+mPlanCategory.getName()+"', 0, 0)";
			super.executeSQL(sql);
		}else{
			super.save(mPlanCategory);
		}
	}

	/**
	 * 查询单条数据
	 * 
	 * */
	public MPlanCategory findPlanCategory(int id){
		return super.get(id);
	}
	
	/**
	 * 编辑计划分类
	 * 
	 * */
	public void editPlanCategory(MPlanCategory mPlanCategory){
		Date  date = new Date();
		MPlanCategory oct =findPlanCategory(mPlanCategory.getId());
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
