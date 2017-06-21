/*package com.anticw.aged.dao.community.policy;


import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.PPolicyRecommend;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.community.PolicyRecommendVo;

*//**
 * 
 * @author Lee
 *
 *//*
@Component
public class PolicyRecommendedDao  extends HibernateEntityDao<PPolicyRecommend> {
	

	*//** 
	 * 政策推荐
	 * @param page
	 * @param num
	 * @param statue 0:未办理  1:办理
	 * @return
	 *//*
	*//**
	 * 根据id获取政策推荐信息
	 * @param id
	 * @return
	 *//*
	public PPolicyRecommend findPolicyRecommendById(int id){
		return super.get(id);
	}
	
	
	
	*//**
	 * 获取社区下政策推荐信息
	 * @param page
	 * @param size
	 * @param communityId
	 * @param status
	 * @return
	 *//*
	@SuppressWarnings("unchecked")
	public List<PolicyRecommendVo> listByCommunityId(int page,int size,String communityIds,int status){
		String sql = "select pr.id as id,user.id as userId,user.name as userName,user.id_card_no as cardNo,user.mobile_phone as phone,count(*) as count "
				+ "from p_policy_recommend pr left join r_user user on user.id=pr.user_id join p_policy p on pr.policy_id=p.id and p.available=1 "
				+ "where user.community_id in ("+communityIds+") and pr.status="+status+" group by user.id";
		Query query = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(PolicyRecommendVo.class));
		Page pagevo = new Page();
		pagevo.setPageNo(page);
		pagevo.setPageSize(size);
		return query.setFirstResult(pagevo.getFirst()).setMaxResults(size).list();
	}
	*//**
	 * 获取政策推荐信息条数
	 * @param communityId
	 * @param status
	 * @return
	 *//*
	public int count(String communityIds,int status){
		String sql = "select count(distinct user.id) "
				+ "from p_policy_recommend pr left join r_user user on user.id=pr.user_id join p_policy p on pr.policy_id=p.id and p.available=1 "
				+ "where user.community_id in ("+communityIds+") and pr.status="+status;
		BigInteger count = (BigInteger) currentSession().createSQLQuery(sql).uniqueResult();
		return count.intValue();
	}
	
	*//**
	 * 根据状态获取所有推荐信息
	 * @param status
	 * @return
	 *//*
	public List<PPolicyRecommend> listByStatus(int status){
		String hql = "from PPolicyRecommend where status=?";
		return super.find(hql, status);
	}
	*//**
	 * 根据短信发送状态获取
	 * @param status
	 * @return
	 *//*
	public List<PPolicyRecommend> listByMsgSent(int status){
		String hql = "from PPolicyRecommend where msgSent=?";
		return super.find(hql, status);
	}
	*//**
	 * 根据用户id获取
	 * @param userId
	 * @return
	 *//*
	public List<PPolicyRecommend> getRecommendbyUserId(Long userId){
		List<PPolicyRecommend> list= currentSession().createCriteria(PPolicyRecommend.class).add(Restrictions.eq("userId", userId)).add(Restrictions.eq("status", CommunityConstants.POLICYRECOMMENDSTATE0)).list();
		return list;
	}
	
	*//**
	 * 根据用户id 分页查询
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 *//*
	public Page<PPolicyRecommend> getPageByUserId(Long userId,int pageNo,int pageSize){
		
		Page<PPolicyRecommend> page = pagedQuery(pageNo, pageSize, Restrictions.eq("userId", userId),Restrictions.eq("status", CommunityConstants.POLICYRECOMMENDSTATE0));
		return page;
	}
	
	public void setRecommendstatus(int id,int status){
		PPolicyRecommend recommend = findPolicyRecommendById(id);
		recommend.setStatus(status);
		super.update(recommend);
	}
	*//**
	 * 根据sql语句推荐政策
	 * @param sql
	 * @param policyId
	 * @param countryId
	 *//*
	public int recommendPolicy(String sql,Integer policyId,String countryId,int status){
		String sqlsentence = validateSql(sql.trim(), policyId, countryId,status);
		int count = currentSession().createSQLQuery(sqlsentence).executeUpdate();
		return count;
	}
	*//**
	 * 格式化sql语句
	 * @param sql
	 * @param policyId
	 * @param countryId
	 * @return
	 *//*
	public String validateSql(String sql,Integer policyId,String countryId,int status){
		sql = sql.trim();
		if(sql.contains("where")){
			sql = sql.replaceFirst("where", "where true and");
		}else{
			sql+=" where true";
		}
		String sqlsentence = sql.replaceFirst("from", ","+policyId+","+status+","+CommunityConstants.RECOMMENDMSG0+" from").replace(";", "");
		String result = "insert into p_policy_recommend(user_id,policy_id,status,msg_sent) "+sqlsentence+" and find_in_set(r_user.community_id,'"+countryId+"') and not exists(select pr.user_id from p_policy_recommend pr where pr.user_id=r_user.id and pr.policy_id="+policyId+") and r_user.available="+CommunityConstants.AVAILABLE;
		return result;
	}

}
*/