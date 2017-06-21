package com.anticw.aged.service.professional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MOrder;
import com.anticw.aged.dao.professional.service.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public MOrder getById(Long id){
		return orderDao.get(id);
	}
	
	public String getByUserId(Long userId) {
		return orderDao.getByUserId(userId);
	}
}
