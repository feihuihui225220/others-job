package com.anticw.aged.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCategory;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.dao.admin.CategoryItemDao;

@Service
public class CategoryItemService {
	
	@Autowired
	private CategoryItemDao categoryItemDao;
	/**
	 * 根据分类ID获取分类
	 * @param id
	 * @return
	 */
	/*public OCategoryItem getOCategoryItemById(Serializable id){
		return categoryItemDao.get(id);
	}*/
	
	public List<OCategoryItem> findListValue(int categoryId){

		return categoryItemDao.findListValue(categoryId);

	}
	
	public List<OCategory> findCategoryList(){
		return categoryItemDao.findCategoryList();
	}
	
	public List<OCategoryItem> findAllList(){
		return this.categoryItemDao.findAllList();
	}
	public List<OCategoryItem> findCategoryName(int id){
		return this.categoryItemDao.findCategoryName(id);
		
	}
	
	public Integer insertCategoryItem(OCategoryItem categoryItem ,int id,String name){
		return categoryItemDao.insertCategoryItem(categoryItem, id,name);
	}
	
	public void editCategoryItem(OCategoryItem oCategoryItem){
		this.categoryItemDao.editCategoryItem(oCategoryItem);
	}
	
	public void delCategoryItem(int id){
		this.categoryItemDao.delCategoryItemById(id);
	}
	
	public Map<Integer,String> findCategory(Integer categoryId){
		return this.categoryItemDao.findCategory(categoryId);
	}
	
	public Map<Integer,Map<Integer,String>> findCategoryList(int[] category){
		Map<Integer,Map<Integer,String>> result= new HashMap<Integer, Map<Integer,String>>();
		for(int i:category){
			Map<Integer, String> map = categoryItemDao.findCategory(i);
			result.put(i, map);
		}
		return result;
	}

}
