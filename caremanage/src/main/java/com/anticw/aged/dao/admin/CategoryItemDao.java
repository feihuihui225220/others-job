package com.anticw.aged.dao.admin;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.OCategory;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class CategoryItemDao extends HibernateEntityDao<OCategoryItem>{
	

	/**
	 * 获取分类选项列表
	 * 
	 * */
	
	public List<OCategoryItem> findListValue(int categoryId){
		return super.find("from OCategoryItem where available=? and categoryId=? ORDER BY changedAt DESC", 
							PropertyValueConstants.AVAILABLE,categoryId);
	}
	
	/**
	 * 根据id获取分类名称
	 * @param id
	 * @return
	 */
	public List<OCategoryItem> findCategoryName(int id){
		return super.find("from OCategoryItem where available=? and id=? order by changedAt desc", 
							PropertyValueConstants.AVAILABLE,id);
	}
	/**
	 * 获取分类列表
	 * @return
	 */
	public List<OCategory> findCategoryList(){
		return super.find("from OCategory");
	}
	
		/**
		 * 分类所有的值
		 * @return
		 */
	public List<OCategoryItem> findAllList(){
		return super.find("from OCategoryItem where available=?",PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 添加数据老人状态类型
	 * @param oCategoryItem
	 * @param id
	 */
	
	public Integer insertCategoryItem(OCategoryItem oCategoryItem,int id,String name){
		Date date = new Date();
		oCategoryItem.setAvailable(PropertyValueConstants.AVAILABLE);
		oCategoryItem.setCreatedBy(name);
		oCategoryItem.setCreatedAt(date);
		oCategoryItem.setChangedAt(date);
		//oCategoryItem.setCategoryId(id);
		super.save(oCategoryItem);
		return oCategoryItem.getId();
		
	}
	
	public OCategoryItem findCategoryItem(int id){
		return super.get(id);
	}
	
	/**
	 * 编辑数据字典选项值
	 * @param oCategoryItem
	 */
	public void editCategoryItem(OCategoryItem oCategoryItem){
		Date  date = new Date();
		OCategoryItem oct =findCategoryItem(oCategoryItem.getId());
		oct.setItemName(oCategoryItem.getItemName());
		oct.setItemValue(oCategoryItem.getItemValue());
		oct.setChangedAt(date);
		oct.setChangedBy(oCategoryItem.getChangedBy());
		super.update(oct);
}
	
	/**
	 * 逻辑删除数据字典选项值
	 * @param id
	 */
	public void delCategoryItemById(int id){
		super.removeById(id);
	}
	

	
	/**
	 * 传入分类id 返回map
	 * @param categoryId
	 * @return
	 */
	public Map<Integer,String> findCategory(Integer categoryId){
		
		Map<Integer,String> dataMap=new HashMap<Integer, String>();
		
		String hql="from OCategoryItem t where t.categoryId=?";
		List<OCategoryItem> items=super.find(hql, categoryId);
		int lenght=items.size();
		
		for(int i=0;i<lenght;i++){
			OCategoryItem item=items.get(i);
			//key=id value=item name
			dataMap.put(item.getId(), item.getItemName());
		}
		
		return dataMap;
	}
	
	/**
	 * 传入分类id数组  返回map
	 * @return
	 */
	public Map<Integer,String> findCategoryList(int[] category){
		
		Map<Integer,String> dataMap=new HashMap<Integer, String>();
		
		for (int i = 0; i < category.length; i++) {
			String hql="from OCategoryItem t where t.categoryId=?";
			List<OCategoryItem> items=super.find(hql, category[i]);
			int lenght=items.size();
			
			for(int j=0;j<lenght;j++){
				OCategoryItem item=items.get(j);
				dataMap.put(item.getId(), item.getItemName());
				
			}	
		}
		return dataMap;
	}
	
}
