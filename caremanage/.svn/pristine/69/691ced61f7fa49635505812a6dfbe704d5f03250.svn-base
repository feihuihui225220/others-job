package com.anticw.aged.service.icare.vip;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZVipOrder;
import com.anticw.aged.bean.ZVipPaymentRecord;
import com.anticw.aged.dao.icare.vip.VipAmountDao;
import com.anticw.aged.dao.icare.vip.VipOrderDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class VipOrderService{
	
	@Autowired
	private VipOrderDao vipOrderDao;
	@Autowired 
	private VipPaymentOrderService vipPaymentOrderService;
	@Autowired
	private VipAmountDao vipAmountDao;
 
/**
 * TODO随机生成验证码
 *@return
 */
	public  String createRandomVcode(){
	    //验证码
	    String vcode = "";
	    for (int i = 0; i < 4; i++) {
	        vcode = vcode + (int)(Math.random() * 9);
	    }
	    return vcode;
	}
	/**
	 * 添加
	 */
	public Integer add(ZVipOrder order){
		double price = vipAmountDao.get(1).getPrice();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderId = dateFormat.format(date)+this.createRandomVcode();
		order.setPrice(price);
		order.setOrderId(orderId);
		order.setCreateTime(new Date());
		order.setChangeTime(new Date());
		order.setAvailable(true);
		if (order.getDays() == null) {
			order.setDays(0);	
		}
		vipOrderDao.save(order);
		if (order.getId() > 0) {
			ZVipPaymentRecord vipPay = new ZVipPaymentRecord();
			vipPay.setOrderId(order.getId());
			vipPay.setSumMoney(price*order.getMonthNum());
			vipPaymentOrderService.add(vipPay);
		}
		return order.getId();
	}
	/**
	 * 逻辑删除
	 */
	public void remove(Integer id){
		ZVipOrder order = vipOrderDao.get(id);
		order.setChangeTime(new Date());
		order.setAvailable(false);
		vipOrderDao.update(order);
	}
	/**
	 * 修改
	 */
	public void modify(ZVipOrder vipOrder){
		double price = vipAmountDao.get(1).getPrice();
		ZVipOrder order = vipOrderDao.get(vipOrder.getId());
		order.setChangeTime(new Date());
		if (vipOrder.getOpeningDate() != null) {
			order.setOpeningDate(vipOrder.getOpeningDate());
		}
		if (vipOrder.getMonthNum() != null) {
			order.setMonthNum(vipOrder.getMonthNum());
		}
		if (vipOrder.getDays() != null) {
			order.setDays(order.getDays()+ vipOrder.getDays());
		}
		order.setAvailable(vipOrder.getAvailable());
		vipOrderDao.update(order);
		if (order.getId() > 0) {
			ZVipPaymentRecord vipPay = new ZVipPaymentRecord();
			vipPay.setOrderId(order.getId());
			vipPay.setSumMoney(price*order.getMonthNum());
			vipPaymentOrderService.add(vipPay);
		}
	}

	/**
	 * 查询一条
	 */
	public ZVipOrder getById(int id){
		return vipOrderDao.get(id);
	}
	/**
	 * 分页查询所有
	 */
	public Page<ZVipOrder> getList(int page, int num) {
		return vipOrderDao.getOrderList(page, num);
	}
	/**
	 * 批量更改会员信息
	 */
	public void modifyAllOrder() {
		List<ZVipOrder> vipOrder = vipOrderDao.getAllOrder();
		for (int i = 0; i < vipOrder.size(); i++) {
			ZVipOrder order = vipOrder.get(i);
			Integer days = order.getDays();
			if (days > 0) {
				order.setDays(order.getDays()-1);
				if (days == 1) {
					order.setExpired(false);
				}
				vipOrderDao.update(order);
			}
			
		}
	}
	
	public ZVipOrder getVip(String  phone){
		List<ZVipOrder> vip = vipOrderDao.getVip(phone);
		if (vip.size() > 0) {
			return vip.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取会员价格
	 * @param id
	 * @return
	 */
	public double getPrice(Integer id){
		double price = 0.0;
		if (vipAmountDao.get(id) == null) {
			if (vipAmountDao.get(1) == null) {
				price = 300.00;
			}else{
				price = vipAmountDao.get(1).getPrice();
			}
		}else{
			price = vipAmountDao.get(1).getPrice();
		}
		return price;
	}
}
