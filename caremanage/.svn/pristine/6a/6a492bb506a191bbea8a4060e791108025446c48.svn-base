package com.anticw.aged.dao.professional.mdatamodule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MDataModuleItem;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @author DUANX 2016/1/21
 *
 */
@Repository
public class MDataModuleItemDao extends HibernateEntityDao<MDataModuleItem>{
	/**
	 * 根据itemName获取itemdesc
	 * @param itemName
	 * @return
	 */
	public MDataModuleItem getByNameAndMName(String itemName){
		String hql="from MDataModuleItem m where m.itemName=? and m.isShow=1";
		 List<MDataModuleItem> mDataModuleItem=super.find(hql, itemName);
		return mDataModuleItem.get(0);
	}
	
	public List<MDataModuleItem> getList(int mDataModuleId){
		String hql="from MDataModuleItem where dataModule.id=?";
		return super.find(hql, mDataModuleId);
	}
	
	
	/**
	 * 获取设备字段对应的解释
	 * @param itemName
	 * @return
	 */
	public String getByItemName(String itemName){
		String hql="from MDataModuleItem m where m.itemName=? and m.isShow=1 and available=1";
		 try {
			List<MDataModuleItem> mDataModuleItem=super.find(hql, itemName);
			 MDataModuleItem m= mDataModuleItem.get(0);
			 return m.getItemDesc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "未知";
		}
	}
}
