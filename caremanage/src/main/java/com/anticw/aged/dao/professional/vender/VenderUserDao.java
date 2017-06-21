package com.anticw.aged.dao.professional.vender;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.MVenderUsers;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.vender.MVenderUsersVO;
import com.anticw.aged.vo.professional.vender.VenderDistrVO;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.user.FeatureUserVO;
import com.anticw.aged.vo.user.FeatureVO;

/**
 * 服务商用户分配持久化类
 * <P>File name : VenderUserDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
@Repository
public class VenderUserDao extends HibernateEntityDao<MVenderUsers> {

	/**
	 * 获取服务商分配的用户信息
	 * VenderUserDao.queryVenderServerUsers()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param userName
	 * @param idCard
	 * @param status
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<VenderServUserVO> queryVenderServerUsers(Integer venderId, int page, int num) {
		
		//sql
		String sql = "select DISTINCT r.id user_id, r.name user_name, r.id_card_no, r.gender, r.age, r.contact_phone, r.community_id, o.name community_name " +
				     "from  " +
				     //and m.vender_id = ? m_order m, and m.status = ?and m.user_id = r.id 
				     "r_user r, o_country o  " +
				     "where " +
				     "r.community_id = o.id  and o.type = ?";
		
		//查询全部
		List<Object[]> all = super.findBySQLQuery(sql, "5");
		
		//总记录数
		int totalCount = all.size();
		int pageIndex=(page-1)*num;
		//分页
		sql+=" limit " + (page == 1 ? 0 : pageIndex) + "," +  num;
		
		//返回值
		List<VenderServUserVO> results = new ArrayList<VenderServUserVO>();
	
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sql, "5");
		
		//遍历列表初始化对象
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
		
			//一条记录
			Object[] column = iter.next();
			
			VenderServUserVO vo = new VenderServUserVO();
			vo.setUserId(((BigInteger)column[0]).longValue());
			vo.setUserName((String)column[1]);
			vo.setIdCard((String)column[2]);
			vo.setGender((Integer)column[3]);
			vo.setAge((Integer)column[4]);
			vo.setContactPhone((String)column[5]);
			vo.setCommunityId((Integer)column[6]);
			vo.setCommunityName((String)column[7]);
			vo.setStatus(ProfessionalConstants.VENDER_USER_DISTRIBUTION);
			results.add(vo);
		}
		
		//构建分页对象
		Page<VenderServUserVO> _page = new Page<VenderServUserVO>();
		_page.setPageNo(page);
		_page.setPageSize(num);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		
		return _page;
	}
	
	/**
	 * 根据状态查询服务上服务用户列表(包含未分配的用户)
	 * @author guoyongxiang
	 * Date: 2014-10-18 下午4:17:07
	 * @param communityIds	当前服务商社区ID集合
	 * @param venderId		当前服务商ID
	 * @param status		用户状态(-1全部，0未分配，1已分配)
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<VenderServUserVO> getSevUsersPage(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status, int page, int num){
		// 非管理默认查询已分配
		if(!super_){
			status = ProfessionalConstants.VENDER_USER_DISTRIBUTION;
		}
		if(communityIds == null || "".equals(communityIds) || venderId == null){
			return new Page<VenderServUserVO>();
		}
		// 获取记录数
		String countSql = this.getVenderUsersSQL(super_, adminId, true, venderId, communityIds, name, idCard, status);
		Object count = super.findBySQLQuery(countSql).get(0);
		int totalCount = ((BigInteger)count).intValue();
		//分页
		int pageIndex=(page-1)*num;
		String sql  = getVenderUsersSQL(super_, adminId, false, venderId, communityIds, name, idCard, status);
		sql+=" limit " + (page == 1 ? 0 : pageIndex) + "," +  num;
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sql);
		
		//返回值
		List<VenderServUserVO> results = this.buildVenderServUserVO(list, status);
		
		//构建分页对象
		Page<VenderServUserVO> _page = new Page<VenderServUserVO>();
		_page.setPageNo(page);
		_page.setPageSize(num);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		
		return _page;
	}
	/**
	 * 带社区
	 * @param super_
	 * @param adminId
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<VenderServUserVO> getSevUsersPages(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status, int page, int num,int communityId){
		// 非管理默认查询已分配
		if(!super_){
			status = ProfessionalConstants.VENDER_USER_DISTRIBUTION;
		}
		if(communityIds == null || "".equals(communityIds) || venderId == null){
			return new Page<VenderServUserVO>();
		}
		int totalCount =0;
		// 获取记录数
		String sql="";
		if(communityId==0){
			String countSql = this.getVenderUsersSQL(super_, adminId, true, venderId, communityIds, name, idCard, status);
			Object count = super.findBySQLQuery(countSql).get(0);
			totalCount = ((BigInteger)count).intValue();
			//分页
			int pageIndex=(page-1)*num;
			sql  = getVenderUsersSQL(super_, adminId, false, venderId, communityIds, name, idCard, status);
			sql+=" limit " + (page == 1 ? 0 : pageIndex) + "," +  num;
		}else{
			String countSql = this.getVenderUsersSQL(super_, adminId, true, venderId, communityId+"", name, idCard, status);
			Object count = super.findBySQLQuery(countSql).get(0);
			totalCount = ((BigInteger)count).intValue();
			//分页
			int pageIndex=(page-1)*num;
			sql  = getVenderUsersSQL(super_, adminId, false, venderId, communityId+"", name, idCard, status);
			sql+=" limit " + (page == 1 ? 0 : pageIndex) + "," +  num;
		}
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sql);
		
		//返回值
		List<VenderServUserVO> results = this.buildVenderServUserVO(list, status);
		
		//构建分页对象
		Page<VenderServUserVO> _page = new Page<VenderServUserVO>();
		_page.setPageNo(page);
		_page.setPageSize(num);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		return _page;
	}
	/**
	 * 员工查询
	 * @param super_
	 * @param adminId
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @param page
	 * @param num
	 * @return
	 */
	public List<VenderServUserVO> getSevUsers(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status){
		// 非管理默认查询已分配
		if(!super_){
			status = ProfessionalConstants.VENDER_USER_DISTRIBUTION;
		}
		String sql = getVenderUsersSQL(super_, adminId, false, venderId, communityIds, name, idCard, status);
		//查询记录
		
		List<Object[]> list = super.findBySQLQuery(sql);
		return this.buildVenderServUserVO(list, status);
	}
	/**
	 * 老人签到查询
	 * @param super_
	 * @param adminId
	 * @param name
	 * @param idCard
	 * @param venderId
	 * @param status
	 * @param page
	 * @param num
	 * @param communityName
	 * @param planId
	 * @param userName
	 * @return
	 */
	public Page<VenderServUserVO> getSevUser(boolean super_, Integer adminId, String name, String idCard, Integer venderId, short status, int page, int num,String communityName,int planId,String userName,String siteId){
		String sql="";
		String sqlPage="";
		if(super_){
			 sql = "select count(*) from m_user_venders where m_user_venders.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+name+"' AND activity_id="+planId+")";
			 sqlPage = "select user_id, user_name, user_idCard, user_sex, community_name from m_user_venders where m_user_venders.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+name+"' AND activity_id="+planId+")";
		}else{
			sql="SELECT  count(*)  FROM  r_user u ,m_vender_users m,"
					+ "m_user_venders mu where m.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+name+"' AND activity_id="+planId+") AND u.id=m.user_id AND u.id=mu.user_id AND m.admin_id="+adminId;
			sqlPage="SELECT  u.id,u.`name`,u.id_card_no,mu.user_sex,mu.community_name  FROM  r_user u ,m_vender_users m,m_user_venders mu where m.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+name+"' AND activity_id="+planId+") AND u.id=m.user_id AND u.id=mu.user_id AND m.admin_id="+adminId;
		}
		
		if(!communityName.equals("1")){
			sql+="  AND community_name='"+communityName+"'";
			sqlPage+="  AND community_name='"+communityName+"'";
		}
		if(userName!=null&&userName!=""){
			sql+="  AND user_name='"+userName+"'";
			sqlPage+="  AND user_name='"+userName+"'";
		}
		sql+="  AND site_id in ("+siteId+")";
		sqlPage+="  AND site_id in ("+siteId+")";
		Object count = super.findBySQLQuery(sql).get(0);
		int totalCount = ((BigInteger)count).intValue();
		//分页
		int pageIndex=(page-1)*num;
		sqlPage+=" limit " + (page == 1 ? 0 : pageIndex) + "," +  num;
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sqlPage);
		
		//返回值
		List<VenderServUserVO> results = this.servUserVO(list, status);
		
		//构建分页对象
		Page<VenderServUserVO> _page = new Page<VenderServUserVO>();
		_page.setPageNo(page);
		_page.setPageSize(num);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		return _page;
	}
	
	/**
	 * 返回不带分页用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-19 下午8:28:54
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @return
	 */
	public List<VenderServUserVO> getSevUser(Integer activityId,String userName,long adminId,Integer venderId){
		// 非管理默认查询已分配
		short status = ProfessionalConstants.VENDER_USER_DISTRIBUTION;
		String sql ="SELECT  u.id,u.`name`,u.id_card_no,mu.user_sex,mu.community_name  FROM  r_user u ,m_vender_users m,m_user_venders mu where m.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+userName+"' AND activity_id="+activityId+") AND u.id=m.user_id AND u.id=mu.user_id AND m.admin_id="+adminId+" AND mu.vender_id="+venderId;
		//String sql = "select user_id, user_name, user_idCard, user_sex, community_name from m_user_venders where m_user_venders.user_id not in (select n_check_list.user_id from n_check_list WHERE created_by='"+userName+"' AND activity_id="++")";
		//查询记录
		List<Object[]> list = super.findBySQLQuery(sql);
		return this.servUserVO(list, status);
	}
	
	/**
	 * 构建VenderServUserVO列表(警报调用)
	 * @author guoyongxiang
	 * Date: 2014-10-19 下午8:27:37
	 * @param list
	 * @param status
	 * @return
	 */
	private List<VenderServUserVO> buildVenderServUserVO(List<Object[]> list, short status){
		List<VenderServUserVO> results = new ArrayList<VenderServUserVO>();
		//遍历列表初始化对象
		for(Object[] column : list) {
			VenderServUserVO vo = new VenderServUserVO();
			vo.setUserId(((BigInteger)column[0]).longValue());
			vo.setUserName((String)column[1]);
			vo.setIdCard((String)column[2]);
			vo.setGender((Integer)column[3]);
			vo.setAge((Integer)column[4]);
			vo.setContactPhone((String)column[5]);
			vo.setCommunityId((Integer)column[6]);
			if(status!=7){
				int type = ((BigInteger)column[7]).intValue();
				if(type == 0) {
					vo.setStatus(ProfessionalConstants.VENDER_USER_UNDISTRIBUTION);
				}else{
					vo.setStatus(ProfessionalConstants.VENDER_USER_DISTRIBUTION);
				}
				
			}
			// 如果查询所有状态则根据分配表ID判断是否为已分配
//			if(ProfessionalConstants.VENDER_USER_DIS_ALL == status){
//				BigInteger venderId = (BigInteger)column[7];
//				Long unionId = null;
//				if(venderId!=null){
//					unionId = venderId.longValue();
//				}
//				// 未查到则为未分配
//				if(unionId == null){
//					vo.setStatus(ProfessionalConstants.VENDER_USER_UNDISTRIBUTION);
//				}else{
//					vo.setStatus(ProfessionalConstants.VENDER_USER_DISTRIBUTION);
//				}
//			}else{
//				vo.setStatus(status);
//			}
			results.add(vo);
		}
		return results;
	}
	/**
	 * 查询服务商签到情况
	 * dx
	 * @param list
	 * @param status
	 * @return
	 */
	private List<VenderServUserVO> servUserVO(List<Object[]> list, short status){
		List<VenderServUserVO> results = new ArrayList<VenderServUserVO>();
		//遍历列表初始化对象
		for(Object[] column : list) {
			VenderServUserVO vo = new VenderServUserVO();
			 long userId=((BigInteger)column[0]).longValue();
			vo.setUserId(userId);
			vo.setUserName((String)column[1]);
			vo.setIdCard((String)column[2]);
			int aged=(Short)column[3];
			vo.setAge(aged);
			vo.setCommunityName((String)column[4]);
			results.add(vo);
		}
		return results;
	}
	
	/**
	 * 组装查询服务商服务的用户
	 * @author guoyongxiang
	 * Date: 2014-10-18 下午3:52:24
	 * @param super_	是否是管理
	 * @param adminId	管理ID
	 * @param isCount	是否查询记录数
	 * @param venderId	服务商ID
	 * @param name		用户名
	 * @param idCard	身份证号
	 * @param status	查询类别(-1全部,0已分配,1未分配)
	 * @return
	 */
	private String getVenderUsersSQL(boolean super_, Integer adminId, boolean isCount, Integer venderId, String communityIds, String name, String idCard, short status){
		
		//查询数量
		String countProjection = "select count(id)";
		
		//查询记录
		String recordProjection = "select id, name, id_card_no, gender, age, contact_phone, community_id, type";
		
		//拼接SQL
		StringBuilder sb = new StringBuilder(); 
		sb.append(" from ( ");
		sb.append("select id, name, id_card_no, gender, age, contact_phone, community_id, 0 as type ");
		sb.append("from r_user where community_id in (").append(communityIds).append(") and ");
		sb.append("id in (select user_id from m_order where status = 1 and end_time > sysdate()").append(") ");
		sb.append("and id not in (select user_id from m_vender_users where vender_id = ").append(venderId).append(")");
		sb.append(" union all ");
		sb.append("select id, name, id_card_no, gender, age, contact_phone, community_id, 1 as type ");
		sb.append("from r_user where community_id in (").append(communityIds).append(") and ");
		sb.append("id in (select user_id from m_vender_users where vender_id = ").append(venderId);
		if(!super_) {
			sb.append(" and admin_id = ").append(adminId);
		}
		sb.append(")) t where 1 = 1");
		sb.append(" order by  convert(name USING gbk) COLLATE gbk_chinese_ci asc ");
		//最终查询使用的SQL
		String finalSql = "";
		
		//判断是查询数据还是获取记录数(分页用)
		if(!isCount){
			finalSql = recordProjection + sb.toString();
		}else{
			finalSql = countProjection + sb.toString();
		}
		
		//新用户
		if(ProfessionalConstants.VENDER_USER_UNDISTRIBUTION == status) {
			finalSql += " and type = 0";
		}
		
		//已分配用户
		if(ProfessionalConstants.VENDER_USER_DISTRIBUTION == status) {
			finalSql += " and type = 1";
		}
		
		//姓名
		if(!StringUtils.isEmpty(name)) {
			finalSql += " and name like '%" + name + "%'";
		}
		
		//身份证号
		if(!StringUtils.isEmpty(idCard)) {
			finalSql += " and id_card_no like '%" + idCard + "%'";
		}
		
		return finalSql;
	}
	
	/**
	 * 获取已分配数量
	 * VenderUserDao.queryVenderServerUsers()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param userId
	 * @return
	 */
	public Map<Integer, Integer> queryVenderServerUsers(Integer venderId) {
		
		//获取已分配数量
		String sql = "select admin_id, count(*) count from m_vender_users where vender_id = ? group by admin_id";
		List<Object[]> list = super.findBySQLQuery(sql, venderId);
		Map<Integer, Integer> countMap = new HashMap<Integer,  Integer>();
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			//一条记录
			Object[] column = iter.next();
			countMap.put(((BigInteger)column[0]).intValue(), ((BigInteger)column[1]).intValue());
		}
		return countMap;
	}
	
	/**
	 * 分配用户
	 * VenderUserDao.distrUser()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param vo
	 */
	public void distrUser(VenderDistrVO vo,RUser r) {
		
		//查询
		deleteDistrData(vo.getVenderId(), r);
		if(deleteDistrData(vo.getVenderId(), r).size()==0){
		//保存新的记录
		MVenderUsers user = new MVenderUsers();
		user.setVenderId(vo.getVenderId());
		user.setAdminId(vo.getAdminId());
		//========================================================================
		user.setrUser(r);
		user.setChangedAt(new Date());
		user.setCreatedAt(new Date());
		user.setChangedBy(vo.getDistrBy());
		user.setCreatedBy(vo.getDistrBy());
		user.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		this.save(user);
		}else{
			MVenderUsers user = deleteDistrData(vo.getVenderId(), r).get(0);
			user.setVenderId(vo.getVenderId());
			user.setAdminId(vo.getAdminId());
			//========================================================================
			user.setrUser(r);
			user.setChangedAt(new Date());
			user.setCreatedAt(new Date());
			user.setChangedBy(vo.getDistrBy());
			user.setCreatedBy(vo.getDistrBy());
			user.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			this.update(user);
		}
	}
	
	/** 
	 * 删除分配记录
	 * @name VenderUserDao.deleteDistrData()
	 * @author zhoupeipei
	 * @Date 2014-11-9 下午9:03:53
	 * @param venderId
	 * @param userId     
	 */
	public List<MVenderUsers>  deleteDistrData(int venderId, RUser rUser){
		String hql = "from MVenderUsers where venderId = ? and rUser = ?";
		List<MVenderUsers> mVenderUsers= super.find(hql, new Object[]{venderId, rUser});
		
		return mVenderUsers;
	}
	
	
	public Long getVenderUsersById(RUser rUser,Integer venderId){
		String hql="from MVenderUsers where rUser=? and venderId=?";
		List<MVenderUsers> mv=this.find(hql, rUser,venderId);
		return mv.get(0).getAdminId();
	}
	/** 
	 * 获取指定老人服务商人员分配vo
	 * @name VenderUserDao.getByUser()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午3:04:16
	 * @param userId 非空
	 * @param venderId 非空
	 * @return     
	 */
	public VenderDistrVO getByUser(Long userId, Integer venderId){
		String hql = "select m.venderId, m.adminId, m.userId, a.name from MVenderUsers m, AUser a where m.userId = ? and m.venderId=? and a.id = m.adminId";
		List<Object[]> list = this.find(hql, userId, venderId);
		if(list!=null&&list.size()>0){
			Object[] result = list.get(0);
			VenderDistrVO vo = new VenderDistrVO();
			vo.setVenderId((Integer)result[0]);
			vo.setAdminId((Integer)result[1]);
			vo.setUserId(Long.valueOf(result[2].toString()));
			vo.setAdminName(result[3].toString());
			return vo;
		}
		return null;
	}
	/**
	 * 获取当前服务人数
	 * VenderUserDao.getCurServCount()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int getServCount(Integer venderId, Date startTime, Date endTime) {
		String hql = "select m.id from MOrder m where m.venderId = ? and m.createdAt >= ? and m.createdAt <= ? and status=1";
		Long count = super.getCount(hql, venderId, startTime, endTime);
		return count == null ? 0 : count.intValue();
	}
	public Page<RUser> pageUser(String name,String idCardNo,int page, int num) {
		//hql
		StringBuilder sb = new StringBuilder(); 
		sb.append("from RUser r where ");
		if(name!=null&&name!=""&&idCardNo!=null&&idCardNo!=""){
			sb.append("r.name=").append("'").append(name).append("'").append(" and r.idCardNo=").append("'").append(idCardNo).append("'");
		}else if(idCardNo!=null&&idCardNo!=""){
			sb.append(" r.idCardNo=").append("'").append(idCardNo).append("'");
		}else if(name!=null&&name!=""){
			sb.append(" r.name=").append("'").append(name).append("'");
		}
		return super.pagedQuery(sb.toString(), page, num);
	}
	
	
	public Page<MVenderUsersVO> getMUserVenderPage( long adminId, int page, int pageSize,MUserVender mUserVender,Long siteId){
			StringBuffer sb= new StringBuffer();
			
			String sql="SELECT m_vender_users.admin_id, r_user.`name`,r_user.id_card_no,r_user.gender,r_user.community_id,r_user.id,r_user.created_by";
					sb.append(sql);
			if(siteId!=null&&siteId!=0)	{
				sb.append(",m_vender_site.site_name");
			}
			sb.append(" FROM");
			if(siteId!=null&&siteId!=0)	{
				sb.append(" m_vender_site,");
			}		
			sb.append(" m_vender_users LEFT JOIN r_user ON r_user.id=m_vender_users.user_id ");	
			if(siteId!=null&&siteId!=0){
				sb.append(" LEFT JOIN m_user_venders ON m_vender_users.user_id=m_user_venders.user_id ");
			}
			sb.append(" WHERE  m_vender_users.admin_id="+adminId);
			if(siteId!=null&&siteId!=0){
				sb.append(" AND m_vender_site.id=m_user_venders.site_id ");
			}
			if(mUserVender.getUserIdCard()!=null&&mUserVender.getUserIdCard()!=""){
				sb.append(" AND r_user.id_card_no LIKE ").append("'%").append(mUserVender.getUserIdCard()).append("%'");
			}
			if(mUserVender.getUserName()!=null&&mUserVender.getUserName()!=""){
				sb.append(" AND r_user.name LIKE  ").append("'%").append(mUserVender.getUserName()).append("%'");
			}
			if(mUserVender.getCommunityName()!=null&&mUserVender.getCommunityName()!=""){
				sb.append(" AND r_user.community_id=").append(Integer.parseInt(mUserVender.getCommunityName()));
			}
			if(siteId!=null&&siteId!=0){
				sb.append(" AND m_user_venders.site_id=").append(siteId);
			}
			//查询全部
			List<Object[]> all = super.findBySQLQuery(sb.toString());
			
			//总记录数
			int totalCount = all.size();
			int pageIndex=(page-1)*pageSize;
			//分页
			String sql1=(page == 1 ? 0 : pageIndex) + "," +  pageSize;
			sb.append(" LIMIT  ").append(sql1);
			//返回值
			List<MVenderUsersVO> results = new ArrayList<MVenderUsersVO>();
		
			//查询分页记录
			List<Object[]> list = super.findBySQLQuery(sb.toString());
			
			//遍历列表初始化对象
			for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			
				//一条记录
				Object[] column = iter.next();
				MVenderUsersVO vo = new MVenderUsersVO();
				RUser r= new RUser();
				vo.setAdminId(((BigInteger)column[0]).longValue());
				r.setName((String)column[1]);
				r.setIdCardNo((String)column[2]);
				if(column[3]!=null){
					r.setGender((Integer)column[3]);
				}
				r.setCommunityId((Integer)column[4]);
				r.setId(((BigInteger) column[5]).longValue());
				r.setCreatedBy((String)column[6]);
				vo.setrUser(r);
				if(siteId!=null&&siteId!=0){
					vo.setSiteName((String)column[7]);
				}
				results.add(vo);
			}
			
			//构建分页对象
			Page<MVenderUsersVO> _page = new Page<MVenderUsersVO>();
			_page.setPageNo(page);
			_page.setPageSize(pageSize);
			_page.setTotalCount(totalCount);
			_page.setResult(results);
			//
			return _page;
	}
	/**
	 * 导出excel
	 * @param venderId
	 * @param mUserVender
	 * @param oCategoryItem
	 * @param feat
	 * @param adminId
	 * @return
	 */
	public List<FeatureUserVO> getVenderFeatureList( int venderId, MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat,int adminId){
		String oCategoryItemIds=null ;
		if(oCategoryItem!=null){
			oCategoryItemIds =getoCategoryItemId(oCategoryItem);
		}
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT m.user_id,m.user_idCard,m.user_name,m.user_sex,m.community_name,m.allocation,s.three,s.`disable`,s.no_security,s.lonely,s.less_income,s.empty_nest,");
		sb.append("  s.lost_only,s.special_care,s.life_lonely,m.site_id FROM m_user_venders m ,r_specia s,m_vender_users v  WHERE s.user_id=m.user_id  AND m.user_id=v.user_id AND  m.vender_id=").append(venderId).append(" AND v.admin_id=").append(adminId);
		sb.append(" and m.available=1");
		if(!"'independent'".equals(feat.getExhibition())){
			sb.append(" AND s.").append(feat.getExhibition()).append(" IN (").append(oCategoryItemIds).append(")");
		}else{
			sb.append(" AND s.three=225 AND s.`disable`=372 AND s.no_security=229 AND s.lonely=231 AND s.less_income=233 AND s.empty_nest=298 AND s.lost_only=237 AND s.special_care=239 AND s.life_lonely=299");
			
		}
		if(mUserVender.getUserIdCard()!=null&&mUserVender.getUserIdCard()!=""){
			sb.append(" and  m.user_idCard=").append("'").append(mUserVender.getUserIdCard()).append("'");
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getUserName()!=""){
			sb.append(" and  m.user_name=").append("'").append(mUserVender.getUserName()).append("'");
		}
		if(mUserVender.getCommunityName()!=null&&mUserVender.getCommunityName()!=""){
			sb.append(" and  m.community_name=").append("'").append(mUserVender.getCommunityName()).append("'");
		}
		if(mUserVender.getAllocation()==1| mUserVender.getAllocation()==0){
			sb.append(" and  m.allocation=").append(mUserVender.getAllocation());
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getSiteId()!=0){
			sb.append(" and  m.site_id=").append(mUserVender.getSiteId());
		}
		String sb1=sb.toString().replace("'",""); 
		
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sb1);
		
		
		return this.results(list, feat);
	}
	
	public List<FeatureUserVO> results(List<Object[]> list,FeatureVO feat){
		List<FeatureUserVO> results = new ArrayList<FeatureUserVO>();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			//一条记录
			FeatureUserVO vo=new FeatureUserVO();
			Object[] column = iter.next();
			vo.setUserId(((BigInteger)column[0]).longValue());
			vo.setUserIdCard((String)column[1]);
			vo.setUserName((String)column[2]);
			Short s=(Short)column[3];
			vo.setUserSex((int)s);
			vo.setCommunityName((String)column[4]);
			vo.setAllocation((Integer)column[5]);
			map.put("three", (Integer)column[6]);
			if(column[7]!=null){
				map.put("disable", (Integer)column[7]);
			}else{
				map.put("disable", 0);
			}
			map.put("disable", (Integer)column[7]);
			vo.setNoSecurity((Integer)column[8]);
			map.put("noSecurity", (Integer)column[8]);
			vo.setLonely((Integer)column[9]);
			map.put("lonely", (Integer)column[9]);
			vo.setLessIncome((Integer)column[10]);
			map.put("lessIncome", (Integer)column[10]);
			vo.setEmptyNest((Integer)column[11]);
			map.put("emptyNest", (Integer)column[11]);
			vo.setLostOnly((Integer)column[12]);
			map.put("lostOnly", (Integer)column[12]);
			vo.setSpecialCare((Integer)column[13]);
			map.put("specialCare", (Integer)column[13]);
			vo.setLifeLonely((Integer)column[14]);
			map.put("lifeLonely", (Integer)column[14]);
			if(column[15]!=null){
				vo.setSiteId(((BigInteger) column[15]).longValue());
			}
			vo.setRest(feat.getExhibition());
			vo.setMap(map);
			results.add(vo);
			}
		return results;
	}
	
	
	
	
	
	public List<VenderServUserVO> getMUserVenderList( long adminId,int  venderId){
		String sql="select	id,	name,id_card_no,gender,age,contact_phone,community_id from r_user 	where id in (	select	user_id from m_vender_users where vender_id = "+venderId+" and admin_id = "+adminId+")";
		List<Object[]> list = super.findBySQLQuery(sql);
		return this.buildVenderServUserVO(list, (short)7);
	}
	public List<VenderServUserVO> getMUserVenderList1( long adminId,int  venderId){
		String sql="select	id,	name,id_card_no,gender,age,contact_phone,community_id from r_user 	where id in (	select	user_id from m_vender_users where vender_id = "+venderId+" and admin_id = "+adminId+")";
		List<Object[]> list = super.findBySQLQuery(sql);
		return this.buildVenderServUserVO(list, (short)7);
	}
	public  List<RUser>  getStaff(int activityId,long adminId){
		String sql="SELECT distinct  r.*,r_user.mobile_phone,r_user.age FROM m_vender_users m,n_check_list n,m_user_venders r,r_user WHERE m.user_id=n.user_id AND m.user_id=r.user_id AND m.user_id=r_user.id AND n.activity_id="+activityId+" AND m.admin_id="+adminId;
		List<Object[]> object=super.findBySQLQuery(sql);
		List<RUser> ruser=new ArrayList<RUser>();
		for(Object[] com:object){
			RUser r= new RUser();
			r.setId(((BigInteger)com[1]).longValue());
			int sex=(Short)com[2];
			r.setIdCardNo((String)com[3]);
			r.setName((String)com[5]);
			r.setGender(sex);
			if(com[13]!=null){
				r.setMobilePhone((String)com[13]);
			}
			r.setAge((Integer)com[14]);
			ruser.add(r);
		}
		
		return ruser;
	}
	
	
	//****************************************************特征信息***********************************************************
	/**
	 * 特征状态信息
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @param mUserVender
	 * @param oCategoryItem
	 * @return
	 */
	public Page<FeatureUserVO> getVenderFeaturePage( int venderId, int pageNo, int pageSize,MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat,int adminId){
		String oCategoryItemIds=null ;
		if(oCategoryItem!=null){
			oCategoryItemIds =getoCategoryItemId(oCategoryItem);
		}
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT m.user_id,m.user_idCard,m.user_name,m.user_sex,m.community_name,m.allocation,s.three,s.`disable`,s.no_security,s.lonely,s.less_income,s.empty_nest,");
		sb.append("  s.lost_only,s.special_care,s.life_lonely,m.site_id FROM m_user_venders m ,r_specia s,m_vender_users v  WHERE s.user_id=m.user_id  AND m.user_id=v.user_id AND  m.vender_id=").append(venderId).append(" AND v.admin_id=").append(adminId);
		sb.append(" and m.available=1");
		if(!"'independent'".equals(feat.getExhibition())){
			sb.append(" AND s.").append(feat.getExhibition()).append(" IN (").append(oCategoryItemIds).append(")");
		}else{
			sb.append(" AND s.three=225 AND s.`disable`=372 AND s.no_security=229 AND s.lonely=231 AND s.less_income=233 AND s.empty_nest=298 AND s.lost_only=237 AND s.special_care=239 AND s.life_lonely=299");
			
		}
		if(mUserVender.getUserIdCard()!=null&&mUserVender.getUserIdCard()!=""){
			sb.append(" and  m.user_idCard=").append("'").append(mUserVender.getUserIdCard()).append("'");
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getUserName()!=""){
			sb.append(" and  m.user_name=").append("'").append(mUserVender.getUserName()).append("'");
		}
		if(mUserVender.getCommunityName()!=null&&mUserVender.getCommunityName()!=""){
			sb.append(" and  m.community_name=").append("'").append(mUserVender.getCommunityName()).append("'");
		}
		if(mUserVender.getAllocation()==1| mUserVender.getAllocation()==0){
			sb.append(" and  m.allocation=").append(mUserVender.getAllocation());
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getSiteId()!=0){
			sb.append(" and  m.site_id=").append(mUserVender.getSiteId());
		}
		String sb1=sb.toString().replace("'",""); 
		List<Object[]> all = super.findBySQLQuery(sb1);
		
		//总记录数
		int totalCount = all.size();
		int pageIndex=(pageNo-1)*pageSize;
		//分页
		String sql1=(pageNo == 1 ? 0 : pageIndex) + "," +  pageSize;
		sb.append(" LIMIT  ").append(sql1);
		sb1=sb.toString().replace("'",""); 
		//返回值
	
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sb1);
		
		List<FeatureUserVO> results = this.results(list, feat);
		//构建分页对象
		Page<FeatureUserVO> _page = new Page<FeatureUserVO>();
		_page.setPageNo(pageNo);
		_page.setPageSize(pageSize);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		
		return _page;
	}
	/**
	 * 获取符合所选特征状态的值
	 * @param oCategoryItem
	 * @return
	 */
	public String  getoCategoryItemId(Map<Integer, String> oCategoryItem){
		String oCategoryItemIds="";
		for(int key:oCategoryItem.keySet()){
			if(!oCategoryItem.get(key).equals("否")){
				oCategoryItemIds+=key;
				oCategoryItemIds+=",";
			}
		}
		return oCategoryItemIds.substring(0, oCategoryItemIds.length()-1);
	}
	/**
	 * 获取特殊信息的各个状态人数
	 * @param venderId
	 * @param oCategoryItem
	 * @param feat
	 * @return
	 */
	public HashMap<String,Long> getCount(int venderId,Map<Integer, String> oCategoryItem,FeatureVO feat,int adminId){
		StringBuffer sql=new StringBuffer("SELECT  count(*) FROM m_user_venders m , r_specia s,m_vender_users v   WHERE s.user_id=m.user_id AND m.user_id=v.user_id  AND  m.vender_id=");
		sql.append(venderId).append(" AND v.admin_id=").append(adminId).append(" AND m.available=1");
		HashMap<String,Long> hash=new HashMap<String, Long>();
		if(!"'independent'".equals(feat.getExhibition())){
			sql.append(" AND s.").append(feat.getExhibition()).append("=");
			String sb1=sql.toString().replace("'",""); 
			for(int key:oCategoryItem.keySet()){
				org.hibernate.Session session = super.getSessionFactory().openSession(); 
				@SuppressWarnings("unchecked")
				List<BigInteger> l = session.createSQLQuery(sb1+key).list(); 
				Long t = l.get(0).longValue();
				hash.put(oCategoryItem.get(key), t);
				if(session!=null){
					session.close();
				}
			}
		}else{
			String sql1=sql.toString()+" AND s.three!=225 AND s.`disable`!=372 AND s.no_security!=229 AND s.lonely!=231 AND s.less_income!=233 AND s.empty_nest!=298  AND s.lost_only!=237 AND s.special_care!=239  AND s.life_lonely!=299";
			String sql2=sql.toString()+" AND s.three=225 AND s.`disable`=372 AND s.no_security=229 AND s.lonely=231 AND s.less_income=233 AND s.empty_nest=298  AND s.lost_only=237 AND s.special_care=239  AND s.life_lonely=299";
			List<String> li=new ArrayList<String>();li.add(sql1);li.add(sql2);
			for(int a=0;a<li.size();a++){
				org.hibernate.Session session = super.getSessionFactory().openSession(); 
				@SuppressWarnings("unchecked")
				List<BigInteger> l = session.createSQLQuery(li.get(a)).list(); 
				if(a==0){
					hash.put("非自理", l.get(0).longValue());
				}else{
					hash.put("自理", l.get(0).longValue());
					
				}
				if(session!=null){
					session.close();
				}
			}
			
			
		}
		
		return hash;
	}
	
}
