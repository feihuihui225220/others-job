package com.anticw.aged.dao.icare.vip;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZVipPaymentRecord;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component
public class VipPaymentRecordDao extends HibernateEntityDao<ZVipPaymentRecord> {
	
	public Page<ZVipPaymentRecord> getOrderList(int page, int num){
		Criterion[] criterions = new Criterion[] {
			Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
		};
		return this.pagedQuery(ZVipPaymentRecord.class, page, num, criterions);
	}
}
