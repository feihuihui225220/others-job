/**   

 * @Title: COrderService.java 
 * @Package com.anticw.aged.service.care 
 * @Description: TODO
 * @author ltw   
 * @date 2014年10月2日 下午8:56:56 
 * @version V1.0   
 *//*
package com.anticw.aged.service.care;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessRecord;
import com.anticw.aged.vo.care.COrderSeachKeyVO;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
*//**
 * 关爱服务商订单管理类
 * 
 * @ClassName: COrderService
 * @Description: TODO
 * @author ltw
 * @date 2014年10月2日 下午8:56:56
 * 
 *//*
@Service
public class COrderService {


	*//**
	 * 创建关爱服务商订单
	 * 
	 * @param cOrder
	 * @return
	 *//*
	public void createOrder(COrder cOrder) {
		try {
			cOrderDao.saveOrUpdate (cOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	*//**
	 * 根据关爱服务商ID获取已经完成的订单数
	 * 
	 * @param id
	 * @return
	 *//*
	public Integer getFinishOrderCountByVendoorId(Serializable vendorId,Date star,Date end) {
		Integer count = cOrderDao.getFinishOrderCountByVendoorId(vendorId,star,end);
		return count;
	}

	*//**
	 * 获取关爱服务商下订单列表
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> getOrderByVendorId(PageParamVO pageVO,Integer vendorId) {
		Page<COrder> result = cOrderDao.getOrderByVendorId(pageVO,vendorId);
		return result;
	}

	*//**
	 * 获取老年人关爱服务订单列表
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> getOrderByUserId(PageParamVO pageVO,Long userId) {
		Page<COrder> result = cOrderDao.getOrderByUserId(pageVO,userId);
		return result;
	}
	*//**
	 * 获取关爱服务商工作人员订单
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> getOrderByAuserId(PageParamVO pageVO,Long aUserId) {
		Page<COrder> result = cOrderDao.getOrderByAuserId(pageVO,aUserId);
		return result;
	}
	*//**
	 * 根据订单Id获取订单详情
	 * 
	 * @param id
	 * @return
	 *//*
	public COrder getOrderById(Long orderId) {
		COrder result = cOrderDao.getOrderById(orderId);
		return result;
	}

	*//**
	 * 根据筛选条件进行查询
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> searchOrderByKey(PageParamVO pageVO,COrderSeachKeyVO cOrderSeachKeyVo) {
		return cOrderDao.searchOrderByKey(pageVO,cOrderSeachKeyVo);
	}

	*//**
	 * 根据社区Id获取这些社区下订单列表
	 * 
	 * @param orderId
	 * @return
	 *//*
	public Page<COrder> getOrderByCommunityIds(PageParamVO pageVO,String communityIds) {
		return cOrderDao.getOrderByCommunityIds(pageVO,communityIds);
	}

	*//**
	 * 根据身份证查询订单
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> getOrderByUserIdcard(PageParamVO pageVO,String idcard) {
		return cOrderDao.getOrderByUserIdcard(pageVO,idcard);
	}
	*//**
	 * 根据老年人身份证和关爱服务商ID查询用户订单
	 * 
	 * @param id
	 * @return
	 *//*
	public Page<COrder> getCommplaintOrder(PageParamVO pageVO,String idcard,String communityIds) {
		return cOrderDao.getCommplaintOrder(pageVO,idcard, communityIds);
	}
	
	*//**
	 * 填写订单完成情况，改变订单状态
	 * @param orderId
	 * @param finish
	 * @param orderStatus
	 *//*
	public void backOrder(Long orderId,String finish,Integer orderStatus){
		COrder order = cOrderDao.get(orderId);
		order.setFinishStatus(finish);
		if(orderStatus!=null){
			order.setOrderStatus(orderStatus);
		}
		cOrderDao.update(order);
	}
	*//**
	 * 根据老人Id和时间获取订单信息
	 * @param userId
	 * @param dateCond
	 * @return
	 * @throws BusinessException
	 *//*
	public List<COrder> getCOrder(Long userId, DateParamVO dateCond)
			throws BusinessException {
		return cOrderDao.getCOrders(userId, dateCond.getStart(), dateCond.getEnd());
	}
}
*/