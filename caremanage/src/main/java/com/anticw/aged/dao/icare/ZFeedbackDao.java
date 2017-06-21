package com.anticw.aged.dao.icare;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import com.anticw.aged.bean.ZFeedback;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class ZFeedbackDao extends  HibernateEntityDao<ZFeedback>{
	/**
	 *列表查询
	 */
	public Page<ZFeedback> getFeedbackList(PageParamVO page,String userContact,
			String startTime,String endTime) {
		String hql="from ZFeedback where available=1";	
		if(userContact!=null){
			hql +="and userContact like'%"+userContact+"%'";
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
		String hql= "update ZFeedback set available=0  where id="+id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
		
	}

}
