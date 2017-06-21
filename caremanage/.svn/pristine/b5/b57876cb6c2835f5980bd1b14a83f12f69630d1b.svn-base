/**   

* @Title: CComplaintService.java 
* @Package com.anticw.aged.service.care 
* @Description: TODO
* @author ltw   
* @date 2014年10月6日 下午7:19:08 
* @version V1.0   
*//*
package com.anticw.aged.service.care;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.CComplaint;
import com.anticw.aged.dao.care.CComplaintDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.care.CComplaintSearchVO;
import com.anticw.aged.vo.common.PageParamVO;

*//** 
 * 投诉管理Service
 * @ClassName: CComplaintService 
 * @Description: TODO 
 * @author ltw
 * @date 2014年10月6日 下午7:19:08 
 *  
 *//*
@Service
public class CComplaintService {

	@Autowired
	private CComplaintDao cComplaintDao;
	*//**
	 * 新增/修改/逻辑删除 投诉信息
	 * @param cComplaint
	 *//*
	public void saveOrUpdate(CComplaint cComplaint) {
		cComplaintDao.saveOrUpdate(cComplaint);

	}
	*//**
	 * 投诉信息详情
	 * @param cComplaint
	 *//*
	 
	public CComplaint getComplaintById(Serializable id) {
		return cComplaintDao.get(id);
	}
	*//**
	 * 获取关爱服务商某一个时间段内的投诉条数
	 * @param communityId
	 * @return
	 *//*
	public int getComplaintCountByVendorId(Integer vendorId,Date star,Date end){
		return cComplaintDao.getComplaintCountByVendorId(vendorId, star, end);
	}

	*//**
	 * 获取投诉列表
	 * @return
	 *//*
	public List<CComplaint> getAllComplaint() {
		return cComplaintDao.loadAll();
	}
	*//**
	 * 根据社区ID获取关爱服务商投诉订单列表
	 * @param communityId
	 * @return
	 *//*
	public Page<CComplaint> getComplaintListBycommunityId(PageParamVO pageVO,String communityId){	 
		return cComplaintDao.getComplaintListBycommunityId(pageVO,communityId);
	}
	*//**
	 * 根据创建人获取务商投诉订单列表
	 * @param communityId
	 * @return
	 *//*
	public Page<CComplaint> getComplaintListByCreate(PageParamVO pageVO,String create){	 
		return cComplaintDao.getComplaintListByCreate(pageVO,create);
	}
	*//**
	 * 根据关爱服务商ID获取投诉订单列表
	 * @param communityId
	 * @return
	 *//*
	public List<CComplaint> getComplaintListByVendorId(Integer vendorId){	 
		return cComplaintDao.getComplaintListByVendorId(vendorId);
	}
	*//**
	 * 根据创建人获取投诉列表
	 * @param communityId
	 * @return
	 *//*
	public List<CComplaint> getListByCreate(String createBy){	 
		return cComplaintDao.getListByCreate(createBy);
	}
	*//**
	 * 根据关键字查询
	 * @param cComplaintSearchVO
	 * @return
	 *//*
	public Page<CComplaint> searchComplaintBykey (PageParamVO pageVO,CComplaintSearchVO cComplaintSearchVO){
		return cComplaintDao.searchComplaintBykey(pageVO,cComplaintSearchVO);
	}
}
*/