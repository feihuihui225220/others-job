package com.anticw.aged.dao.icare.vip;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZVipOrder;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component
public class VipOrderDao extends HibernateEntityDao<ZVipOrder> {

	public Page<ZVipOrder> getOrderList(int page, int num){
		Criterion[] criterions = new Criterion[] {
			Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
		};
		return this.pagedQuery(ZVipOrder.class, page, num, criterions);
	}
	/**
	 * 查询所有会员数据
	 * @return
	 */
	public List<ZVipOrder> getAllOrder(){
		return super.find("from ZVipOrder where available=? and expired=?",PropertyValueConstants.AVAILABLE,PropertyValueConstants.AVAILABLE);
	}
	/**
	 * 查询用户是否还是vip
	 * @param userId
	 * @return
	 */
	public List<ZVipOrder> getVip(String  phone){
		return super.find("from ZVipOrder where phone=? and available=? and expired=?",phone,PropertyValueConstants.AVAILABLE,PropertyValueConstants.AVAILABLE);
	}
}
