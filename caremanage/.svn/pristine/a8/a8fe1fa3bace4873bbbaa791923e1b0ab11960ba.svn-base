/*package com.anticw.aged.dao.community.policy;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.PUserPolicy;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.community.UserPolicySearchVo;
import com.anticw.aged.vo.community.UserPolicyVo;

@Component("userPolicyDao")
public class UserPolicyDao extends HibernateEntityDao<PUserPolicy>{
	*//**
	 * 根据社区获取用户政策
	 * 李飞
	 * @param page
	 * @param size
	 * @param communityId
	 * @return
	 *//*
	public Page<PUserPolicy> listPage(int page,int size,String communityId){
		String hql = "from PUserPolicy where communityId in ("+communityId+") order by handleTime desc";
		return super.pagedQuery(hql, page, size);
		//return super.pagedQuery(page, size, Restrictions.eq("communityId", communityId));
	}
	*//**
	 * 根据用户ID获取用户政策
	 * 李飞
	 * @param page
	 * @param size
	 * @param userId
	 * @return
	 *//*
	@SuppressWarnings("unchecked")
	public Page<UserPolicyVo> listPageByUserId(int page,int size,int userId){

		String sql = "select up.id as id, pr.user_id as userId, pr.policy_id as policyId, p.title as ptitle,p.number as pnumber,up.state as pstate "
				+ "from p_policy_recommend pr left join p_user_policy up on "
				+ "pr.user_id=up.user_id and pr.policy_id=up.policy_id join p_policy p on pr.policy_id=p.id and p.available=1 "
				+ "where pr.user_id="+userId;
		List<UserPolicyVo> list = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserPolicyVo.class)).list();
		Page<UserPolicyVo> returnpage = new Page<UserPolicyVo>();
		returnpage.setResult(list);
		return returnpage;
	}
	*//**
	 * 查询用户政策
	 * 李飞
	 *//*
	public Page<PUserPolicy> queryPage(int page,int size,int communityId,List<Criterion> criterions){
		if(criterions==null){
			criterions = new ArrayList<Criterion>();
		}
		criterions.add(Restrictions.eq("communityId", communityId));
		return super.pagedQuery(page, size, criterions.toArray(new Criterion[criterions.size()]));
	}
	*//**
	 * hql查询用户政策
	 * 李飞
	 *//*
	public Page<PUserPolicy> queryUp(UserPolicySearchVo searchVo,int page,int size,String communityId){
		String hql="from PUserPolicy up where up.communityId in ("+communityId+")";
		StringBuilder sb=new StringBuilder(hql);
		if(searchVo.getCategotyId()!=0){
			sb.append(" and up.policy.categoryId="+searchVo.getCategotyId());
		}
		if(searchVo.getPolicyId()!=0){
			sb.append(" and up.policy.id="+searchVo.getPolicyId());
		}
		if(searchVo.getUsername()!=null&&!"".equals(searchVo.getUsername())){
			sb.append(" and up.user.name like '%"+searchVo.getUsername()+"%'");
		}
		if(searchVo.getCardnum()!=null&&!"".equals(searchVo.getCardnum())){
			sb.append(" and up.user.idCardNo ='"+searchVo.getCardnum()+"'");
		}
		if(searchVo.getState()!=0&&searchVo.getState()!=null){
			sb.append(" and up.state="+searchVo.getState());
		}
		if(searchVo.getStart()!=null&&searchVo.getEnd()!=null&&!"".equals(searchVo.getStart())&&!"".equals(searchVo.getEnd())){
			sb.append(" and up.handleTime between '"+searchVo.getStart()+"' and '"
					+searchVo.getEnd()+"'");
		}
		sb.append(" order by handleTime desc");
		return super.pagedQuery(sb.toString(), page, size);
	}
	*//**
	 * 获取所有用户政策(execel导出用)
	 * @param searchVo
	 * @param page
	 * @param size
	 * @param communityId
	 * @return
	 *//*
	@SuppressWarnings("unchecked")
	public List<PUserPolicy> queryAllUp(UserPolicySearchVo searchVo,int communityId){
		String hql="from PUserPolicy up where up.communityId="+communityId;
		StringBuilder sb=new StringBuilder(hql);
		if(searchVo.getCategotyId()!=0){
			sb.append(" and up.policy.categoryId="+searchVo.getCategotyId());
		}
		if(searchVo.getPolicyId()!=0){
			sb.append(" and up.policy.id="+searchVo.getPolicyId());
		}
		if(searchVo.getUsername()!=null&&!"".equals(searchVo.getUsername())){
			sb.append(" and up.user.name like '%"+searchVo.getUsername()+"%'");
		}
		if(searchVo.getCardnum()!=null&&!"".equals(searchVo.getCardnum())){
			sb.append(" and up.user.idCardNo ='"+searchVo.getCardnum()+"'");
		}
		if(searchVo.getState()!=0&&searchVo.getState()!=null){
			sb.append(" and up.state="+searchVo.getState());
		}
		if(searchVo.getStart()!=null&&searchVo.getEnd()!=null&&!"".equals(searchVo.getStart())&&!"".equals(searchVo.getEnd())){
			sb.append(" and up.handleTime between '"+searchVo.getStart()+"' and '"
					+searchVo.getEnd()+"'");
		}
		
		return currentSession().createQuery(sb.toString()).list();
	}
	*//**
	 * 添加或修改PUserPolicy
	 * 李飞
	 * 2014-10-2
	 * @param pUserPolicy
	 *//*
	public void saveOrUpdateUserPolicy(PUserPolicy pUserPolicy){
		super.saveOrUpdate(pUserPolicy);
	}
	*//**
	 * 根据id获取PUserPolicy
	 * 李飞
	 * 2014-10-2
	 * @param pUserPolicy
	 *//*
	public PUserPolicy getPUserPolicy(int id){
		return super.get(id);
	}
}
*/