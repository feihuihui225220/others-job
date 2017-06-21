package com.anticw.aged.dao.professional.recommand;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.MRecommand;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.vo.professional.recommand.RecQueryCondVO;

/**
 * 专业服务推荐持久化对象
 * <P>File name : RecommandDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Repository
public class RecommandDao extends HibernateEntityDao<MRecommand> {

	/**
	 * 获取专业服务列表
	 * RecommandDao.queryByPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param condVo
	 * @param page
	 * @param num
	 * @return
	 */
	public List<MRecommand> query(RecQueryCondVO condVo, String communityIds) {
		
		//基本HQL
		String hql = "from MRecommand m where m.status != ?";
		
		//社区
		if(!StringUtils.isEmpty(communityIds)) {
			hql += " and m.userId in (select r.id from RUser r where r.communityId in (" + communityIds + "))"; 
		}
		
		//拼接姓名条件
		if(!StringUtils.isEmpty(condVo.getName())) {
			hql += " and m.userName = '" + condVo.getName() + "'";
		}
		
		//拼接身份证条件
		if(!StringUtils.isEmpty(condVo.getIdCard())) {
			hql += " and m.idCard = '" + condVo.getIdCard() + "'";
		}
		
		//拼接分类Id查询条件
		if(condVo.getCatId() != -1) {
			hql += " and m.categoryId = " + condVo.getCatId();
		}
		
		//分页查询
		return super.find(hql, new Object[]{ProfessionalConstants.RECOMMAND_REJECT});
	}
	
	/**
	 * 根据CM用户查询服务关系
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午3:33:48
	 */
	public List<Object[]> venderServiceByCM(String cmName){
		StringBuffer bf = new StringBuffer();
		bf.append("select v.id ,vs.service_id, v.category_id");
		bf.append(" from m_vender v, m_vender_service vs");
		bf.append(" where v.id=vs.vender_id and v.cm_name=?");
		return this.findBySQLQuery(bf.toString(), cmName);
	}
	
	/**
	 * 根据服务商ID与服务ID获取订购数
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午5:20:45
	 * @param userId		老年人ID
	 * @param venderId		服务商ID
	 * @param serviceIds	服务ID列表
	 * @return
	 */
	public long venderOrderByService(Long userId, int venderId, List<Integer> serviceIdList){
		String serviceIds = serviceIdList.toString().replace("[", "").replace("]", "");
		return this.getCount("from m_order where user_id=?, status=? and vender_id=? and service_id in(?)", userId, ProfessionalConstants.ORDER_STATUS_OPENED, venderId, serviceIds);
	}
	
	/**
	 * 指定社区可推荐服务的用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午6:55:15
	 * @param communityIds
	 * @param venderId
	 * @param serviceId
	 * @return
	 */
	public List<Object[]> venderRecUser(String communityIds, Integer venderId, Integer serviceId, Integer categoryId){
		StringBuffer bf = new StringBuffer();
		// 1.查指定社区范围内的 用户ID,用户名,身份证号
		bf.append("select u.id,u.name,u.id_card_no");
		bf.append(" from r_user u where community_id in(?)");
		// 2.排除已办理用户(由于单用户不允许被多个服务商管理，故不限制已订购用户)
		//bf.append(" and id not in (");
		//bf.append(" select user_id from m_order o where status=? and o.vender_id=? and o.service_id=?");
		//bf.append(" )");
		// ProfessionalConstants.ORDER_STATUS_OPENED, venderId, serviceId, 
		// 3.排除已推荐用户
		bf.append(" and id not in (");
		bf.append(" select user_id from m_recommand m where m.service_id=? and m.category_id=?)");
		return this.findBySQLQuery(bf.toString(), communityIds, serviceId, categoryId);
	}
}
