/*package com.anticw.aged.dao.community.policy;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.PPolicyAtt;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component("policyAttDao")
public class PolicyAttDao extends HibernateEntityDao<PPolicyAtt> {
	
	*//**
	 * 添加政策附件
	 * @param policyAtt
	 *//*
	public void save(PPolicyAtt policyAtt){
		super.save(policyAtt);
	}
	*//**
	 * 删除政策附件
	 * @param id
	 *//*
	public void deletePolicyAtt(int id){
		super.removeById(id);
	}
	*//**
	 * 获取政策附件
	 * @param policyId
	 * @return
	 *//*
	@SuppressWarnings("unchecked")
	public List<PPolicyAtt> list(int policyId){
		return currentSession().createCriteria(PPolicyAtt.class).add(Restrictions.eq("policyId", policyId)).list();
	}
}
*/