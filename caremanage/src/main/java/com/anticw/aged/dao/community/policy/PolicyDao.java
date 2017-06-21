/*package com.anticw.aged.dao.community.policy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.PPolicy;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component("policyDao")
public class PolicyDao extends HibernateEntityDao<PPolicy>{
	
	public PPolicy getById(int id){
		return super.get(id);
	}
	public void saveOrUpdate(PPolicy policy){
		super.saveOrUpdate(policy);
	}
	*//**
	 * 逻辑删除
	 *//*
	public void removePolicy(int id,String opUser){
		Date date = new Date();
		PPolicy policy = getById(id);
		policy.setAvailable(CommunityConstants.UNAVAILABLE);
		policy.setChangedAt(date);
		policy.setChangedBy(opUser);
		super.update(policy);
	}
	*//**
	 * 所有政策Page
	 *//*
	public Page<PPolicy> getByPage(int page,int size){
		String hql = "from PPolicy where available="+CommunityConstants.AVAILABLE+" order by changedAt desc";
		return super.pagedQuery(hql, page, size);
	}
	*//**
	 * 所有政策List
	 *//*
	@SuppressWarnings("unchecked")
	public List<PPolicy> listAll(){
		String hql = "from PPolicy where available="+CommunityConstants.AVAILABLE;
		return currentSession().createQuery(hql).list();
	}
	*//**
	 * hql查询本社区政策
	 *//*
	public Page<PPolicy> getCommByPage(int page,int size,int communityId){
		String hql = "from PPolicy p where  find_in_set('"+communityId+"',p.countryId)>0 and available="+CommunityConstants.AVAILABLE;
		return super.pagedQuery(hql, page, size);
	}
	*//**
	 * hql查询本社区政策，当前分类的政策
	 *//*
	@SuppressWarnings("unchecked")
	public List<PPolicy> getCommPolicy(String communityId,int categoryId){
		String hql = "from PPolicy p where  find_in_set('"+communityId+"',p.countryId)>0 and available="+CommunityConstants.AVAILABLE+" and p.categoryId="+categoryId;
		return currentSession().createQuery(hql).list();
	}
	*//**
	 * 发布政策
	 *//*
	public void publish(int id,String countryId,String opUser){
		Date date =new Date();
		PPolicy policy = getById(id);
		policy.setCountryId(countryId);
		policy.setChangedAt(date);
		policy.setChangedBy(opUser);
		super.update(policy);
	}
	*//**
	 * 获取政策证明材料情况
	 *//*
	@SuppressWarnings("unchecked")
	public List<UserPolicyCertVo> getCertifactes(int policyId,Long userId) {
		String sql="select cat.id as categoryId,cat.item_name as name,cat.item_value as remark,rc.id as status "
				+ "from o_category_item cat join p_policy p on find_in_set(cat.id,p.certificate) and "
				+ "cat.available="+CommunityConstants.AVAILABLE+
				" left join r_cert rc on find_in_set(rc.category_id,p.certificate) and "
				+ "rc.category_id=cat.id and rc.available="+CommunityConstants.AVAILABLE+" and rc.user_id="+userId+
				" where p.id="+policyId;
		return currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserPolicyCertVo.class)).list();
	}
	
	
}
*/