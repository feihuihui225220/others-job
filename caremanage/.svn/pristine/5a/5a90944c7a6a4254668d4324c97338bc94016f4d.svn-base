package com.anticw.aged.dao.icare.combo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZSubscriber;
import com.anticw.aged.dao.utils.HibernateEntityDao;
@Component
public class ZSubscriberDao extends HibernateEntityDao<ZSubscriber>{

	public List<ZSubscriber> getList(){
		String hql="from ZSubscriber where ZSubscriber=1";
		return super.find(hql);
	}
	
	public List<ZSubscriber> getList(Long userId){
		String hql="from ZSubscriber where availabe=1 and userId=?";
		return super.find(hql,userId);
	}
	
	public ZSubscriber getZSubscriber(Long userId,Integer combo){
		String hql="from ZSubscriber where availabe=1 and userId=? and comboId=?";
		List<ZSubscriber> list=super.find(hql,userId,combo);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
}
