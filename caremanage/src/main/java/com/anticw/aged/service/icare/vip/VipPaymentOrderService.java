package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZVipPaymentRecord;
import com.anticw.aged.dao.icare.vip.VipPaymentRecordDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class VipPaymentOrderService{
	@Autowired
	private VipPaymentRecordDao vipPaymentRecordDao;
	/**
	 * 添加
	 */
	public Integer add(ZVipPaymentRecord paymentRecord){
		paymentRecord.setCreateTime(new Date());
		paymentRecord.setAvailable(true);
		return (Integer) vipPaymentRecordDao.save(paymentRecord);
	}
	/**
	 * 删除
	 */
	public void remove(Integer id){
		vipPaymentRecordDao.removeById(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZVipPaymentRecord VipOrder){
		ZVipPaymentRecord order = vipPaymentRecordDao.get(VipOrder.getId());
		order.setAvailable(VipOrder.getAvailable());
		vipPaymentRecordDao.update(order);
	}

	/**
	 * 查询一条
	 */
	public ZVipPaymentRecord getById(int id){
		return vipPaymentRecordDao.get(id);
	}
	/**
	 * 分页查询所有
	 */
	public Page<ZVipPaymentRecord> getList(int page, int num) {
		return vipPaymentRecordDao.getOrderList(page, num);
	}
	
}
