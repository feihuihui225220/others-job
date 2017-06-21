/**
 * 
 */
package com.anticw.aged.service.care;

import org.springframework.stereotype.Service;

/**
 * 关爱服务商关爱服务类型管理
 * 
 * @author ltw
 * 
 */
@Service
public class CServiceManagerService {

	/**
	 * 增/修/逻辑删除
	 * 
	 * @param cVendor
	 */
	/*
	 * public void saveOrUpdate(CServiceManager cServiceManager) {
	 * cServiceManagerDao.saveOrUpdate(cServiceManager);
	 * 
	 * }
	 */

	/**
	 * 根据ID获取服务分类信息
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * public CServiceManager getServiceManagerById(Serializable id) { return
	 * cServiceManagerDao.get(id); }
	 */
	/**
	 * 获取关爱服务商服务类型
	 * 
	 * @return
	 */
	/*
	 * public Page<CServiceManager> getAllServiceManager(PageParamVO pageVO) {
	 * return cServiceManagerDao.getAllServiceManager(pageVO); }
	 */
	/**
	 * 获取所有关爱服务类型
	 * 
	 * @return
	 */
	/*
	 * public List<CServiceManager> loadAllServiceManager() { return
	 * cServiceManagerDao.loadAll(); }
	 *//**
		 * 获取所有关爱服务类型
		 * 
		 * @return
		 *//*
		 * public List<CServiceManager> getServiceManagerByTypes(String types) {
		 * return cServiceManagerDao.getServiceManagerByTypes(types); }
		 */
	/**
	 * 
	 * @param ids
	 * @param type
	 *            1:根据ids查询关爱服务分类，2:查询IDS之外分类
	 * @return
	 */
	/*
	 * public List<CServiceManager> getServiceManagerByIds(String ids,String
	 * type) { List<CServiceManager> result=new ArrayList<CServiceManager>();
	 * if("1".equals(type)&&(ids==null||"".equals(ids))){ return result; }
	 * return cServiceManagerDao.getServiceManagerByIds(ids, type); }
	 */
	/**
	 * 统计街道便民服务商数量
	 * 
	 * @param communityIds
	 * @return
	 */
	/*
	 * public List<CountVendorVO> countVendor(String communityIds) { // TODO
	 * Auto-generated method stub
	 * 
	 * return cServiceManagerDao.countVendor(communityIds); }
	 * 
	 */
	/**
	 * 地图-获得全部服务商的地址
	 */
	/*
	 * public List<CVenderAddress> getAllCVendorAddress(String communityIds) {
	 * return cServiceManagerDao.getAllCVendorAddress(communityIds); }
	 */
	/**
	 * 地图-搜索
	 */
	/*
	 * public List<ServiceCategoryVO> serviceCategory() { return
	 * cServiceManagerDao.serviceCategory(); }
	 */
	/**
	 * 地图-搜索
	 */
	/*
	 * public List<CVenderAddress> mapSeacrh(String communityIds,String word) {
	 * return cServiceManagerDao.mapSearch(communityIds, word); }
	 */

	/**
	 * 统计订单及投诉数量
	 * 
	 * @param communityIds
	 * @param dateVo
	 * @param type
	 * @return
	 */
	/*
	 * public List<CountOrderVo> countOrder(String communityIds, DateParamVO
	 * dateVo,Integer type) { // TODO Auto-generated method stub return
	 * cServiceManagerDao.countOrder(communityIds,dateVo,type); }
	 */

	/**
	 * 按服务商分类，统计服务商下的订单及投诉数量
	 * 
	 * @param communityIds
	 * @param dateVo
	 * @param type
	 * @param serviceTypeId
	 * @return
	 */
	/*
	 * public List<CountOrderVo> countOrder(String communityIds, DateParamVO
	 * dateVo, Integer type, Integer serviceTypeId) { // TODO Auto-generated
	 * method stub return
	 * cServiceManagerDao.countOrder(communityIds,dateVo,type,serviceTypeId); }
	 */

}
