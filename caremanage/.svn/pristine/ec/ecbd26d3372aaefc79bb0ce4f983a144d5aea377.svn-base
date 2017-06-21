package com.anticw.aged.dao.director;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HGroup;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;
/**
 * 作者：bsd
 * 日期：2016-9-16
 * 功能：巡诊组
 */
@Component
public class GroupDao extends  HibernateEntityDao<HGroup>{
	
	public int addGroup(HGroup hGroup){
		return (Integer) super.save(hGroup);
	}
	
	public void editGroup(HGroup hGroup){
		 super.update(hGroup);
	}
	
	public Page<HGroup> findGroupAll(PageParamVO page){
		String hqlStr="from HGroup where available=1";		
		return super.pagedQuery(hqlStr,page.getPage(), page.getNum());
		//return super.find("from HGroup where available=?",PropertyValueConstants.AVAILABLE);
	}
	
	public HGroup findGroupById(int id){
		return super.get(id);
	}
	
	//逻辑删除知识库
	public void delGroupById(int id) {
		String hql = "update HGroup set available=0  where id=" + id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
	}

	// 物理删除知识库
	public void delGroupBy(int id) {
		super.removeById(id);
	}
	public List<HGroup> findByUserId(Integer userid) {
		return super.find("from HGroup where available=? and userId=?",PropertyValueConstants.AVAILABLE,userid);
	}
	

}
