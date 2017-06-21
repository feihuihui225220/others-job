/**
 * 
 *//*
package com.anticw.aged.service.care;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.CVendorMenu;
import com.anticw.aged.dao.care.CVendorMenuDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

*//**
 * @author ltw
 * 
 *//*
@Service
public class CVendorMenuService {
	@Autowired
	private CVendorMenuDao cVendorMenuDao;

	*//**
	 * 
	 * @param id
	 * @return
	 *//*
	public CVendorMenu getVendorMenuById(Serializable id) {
		return cVendorMenuDao.get(id);
	}

	*//**
	 * 
	 * @param cVendor
	 *//*
	public void saveOrUpdate(CVendorMenu cVendorMenu) {
		cVendorMenuDao.saveOrUpdate(cVendorMenu);
	}

	*//**
	 * 根据关爱服务商ID获取服务项
	 * @return
	 *//*
	public List<CVendorMenu> listByVendorId(Integer vendorId) {
		return cVendorMenuDao.listByVendorId(vendorId);
	}
	
	*//**
	 * 根据关爱服务商，分页获取
	 * @param vendorId
	 * @param pagevo
	 * @return
	 *//*
	public Page<CVendorMenu> pageByVendorId(Integer vendorId,PageParamVO pagevo) {
		return cVendorMenuDao.pageByVendorId(vendorId, pagevo);
	}
	*//**
	 * 根据关爱服务商ID和服务类型ID 获取服务项
	 * @param vendorId
	 * @return
	 *//*
	public List<CVendorMenu> listByServiceType(Integer serviceType,Integer vendorId) {
		return cVendorMenuDao.listByServiceType(serviceType,vendorId);
	}
	
	*//**
	 * 根据名称获取
	 * @param name
	 * @param communityIds
	 * @return
	 *//*
	public List<CVendorMenu> listByMenuName(String name,String communityIds){
		return cVendorMenuDao.listByMenuName(name, communityIds);
	}
	
	*//**
	 * 删除菜单项
	 * @param menuId
	 *//*
	public void deleteMenu(Integer menuId){
		cVendorMenuDao.deleteMenu(menuId);
	}

}
*/