/*package com.anticw.aged.service.care;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.CVendor;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.dao.care.CvendorDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

*//**
 * 
 * @author ltw
 * 
 *//*
@Service
public class CvendorService {
	@Autowired
	private CvendorDao cvendorDao;

	*//**
	 * 
	 * @param id
	 * @return
	 *//*
	public CVendor getVendorById(Serializable id) {
		return cvendorDao.get(id);
	}

	*//**
	 * 
	 * @param adminName
	 * @return
	 *//*
	public boolean isRegister(String adminName) {
		return cvendorDao.isRegister(adminName);
	}
    *//**
     * 
     * @param cVendor
     *//*
	public void saveOrUpdate(CVendor cVendor) {
		cvendorDao.saveOrUpdate(cVendor);
	}
	*//**
	 * 根据服务类型获取关爱服务商列表,userCategoryId=6对应tag_ids=381</br>
	 * 其他对应见o_category_item表
	 * @param serviceType
	 * @return
	 *//*
	public List listVendorByServiceType(Short userCategoryId,Integer serviceType,String communityIds){
		int tag_id;
		switch (userCategoryId){
			case 6:
				tag_id=381;
				break;
			case 7:
				tag_id=382;
				break;
			default:
				tag_id=0;
				break;
		}
		return cvendorDao.listVendorByServiceType(tag_id,serviceType,communityIds);
	}
	*//**
	 * 根据服务商名称获取服务商列表
	 * @param name
	 * @param communityIds
	 * @return
	 *//*
	public List listVendorByName(String name,String communityIds){
		return cvendorDao.listVendorByName(name, communityIds);
	}
	*//**
	 * 获取关爱服务商列表
	 * @return
	 *//*
	public List<CVendor> findAll() {

		return cvendorDao.findAll();
	}
	*//**
	 * 获取关爱服务商列表
	 * @param cmName
	 * @param venderName
	 * @return
	 *//*
	public Page<CVendor> listVenders(PageParamVO pageVO,String cmName, String venderName) {
        
		return cvendorDao.listVenders(pageVO,cmName,venderName);
	}
	*//**
	 * 根据社区id获取服务商列表
	 * @param pageVO
	 * @param communityIds
	 * @param venderName
	 * @return
	 *//*
	public Page<CVendor> listVendersByCommunityIds(PageParamVO pageVO,String communityIds, String venderName) {
        
		return cvendorDao.listVendersByCommunityIds(pageVO, communityIds, venderName);
	}
}
*/