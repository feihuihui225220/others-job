package com.anticw.aged.dao.icare;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZNotice;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class ZNoticeDao extends  HibernateEntityDao<ZNotice>{
	/**
	 *查询全部
	 */
	public Page<ZNotice> getList(PageParamVO page, String userContact,
			Integer type, String startTime, String endTime) {
		String hql="from ZNotice where available=1";	
		if(userContact!=null){
			hql +="and userContact like'%"+userContact+"%'";
		}
		if(type!=null&&type!=9){
			hql +="and type like'%"+type+"%'";
		}
		if(startTime!=null&&endTime!=null){
			hql+="and createTime BETWEEN '"+startTime+"' And '"+endTime+"'";
		}
		if(startTime!=null&&endTime==null){
			hql+="and createTime >'"+startTime+"' ";
		}
		if(startTime==null&&endTime!=null){
			hql+="and createTime <'"+endTime+"' ";
		}
		hql+="order by createTime desc";
		return super.pagedQuery(hql,page.getPage(), page.getNum());
	}
	/**
	 * 删除
	 */
	public void delete(Integer id) {
		String hql= "update ZNotice set available=0  where id="+id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
		
	}
	//微信查询
	public List<ZNotice> getLists(String openId) {
		String hql="from ZNotice where  available=1 and userContact='"+openId+"' order by createTime ASC";
		return super.find(hql);
	}

}
