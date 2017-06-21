package com.anticw.aged.dao.professional.vender;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.DateYear;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.assess.ConclusionScreenVO;
import com.anticw.aged.vo.user.AssessUserVO;
import com.anticw.aged.vo.user.FeatureUserVO;
import com.anticw.aged.vo.user.FeatureVO;
/**
 * 
 * @author dx
 *
 */
@Repository
public class MUserVenderDao extends  HibernateEntityDao<MUserVender>{

	/**
	 * 获取专业服务商分配的老人
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<MUserVender> getMUserVenderPage( int venderId, int pageNo, int pageSize,MUserVender mUserVender){
		String hql="from MUserVender m where m.venderId="+venderId+" and m.available="+PropertyValueConstants.AVAILABLE;
		StringBuilder sb = new StringBuilder(); 
		sb.append(hql);
		if(mUserVender.getUserIdCard()!=null&&mUserVender.getUserIdCard()!=""){
			sb.append(" and  m.userIdCard  like '%").append(mUserVender.getUserIdCard()).append("%'");
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getUserName()!=""){
			sb.append(" and  m.userName like '%").append(mUserVender.getUserName()).append("%'");
		}
		if(mUserVender.getCommunityName()!=null&&mUserVender.getCommunityName()!=""){
			sb.append(" and  m.communityName=").append("'").append(mUserVender.getCommunityName()).append("'");
		}
		if(mUserVender.getAllocation()==1| mUserVender.getAllocation()==0){
			sb.append(" and  m.allocation=").append(mUserVender.getAllocation());
		}
		if(mUserVender.getSiteId()!=null&&mUserVender.getSiteId()!=0){
			sb.append(" and  m.siteId=").append(mUserVender.getSiteId());
		}
		sb.append(" order by allocation ");
		return super.pagedQuery(sb.toString(), pageNo, pageSize);
	}
	/**
	 * 
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @param mUserVender
	 * @return
	 */
	public Page<MUserVender> getMUserVenderPage( int venderId, int pageNo, int pageSize,MUserVender mUserVender,String siteIds){
		String hql="from MUserVender m where m.venderId="+venderId+" and m.available="+PropertyValueConstants.AVAILABLE;
		StringBuilder sb = new StringBuilder(); 
		sb.append(hql);
		
		if(mUserVender.getUserIdCard()!=null&&mUserVender.getUserIdCard()!=""){
			sb.append(" and  m.userIdCard  like '%").append(mUserVender.getUserIdCard()).append("%'");
		}
		if(mUserVender.getUserName()!=null&&mUserVender.getUserName()!=""){
			sb.append(" and  m.userName like '%").append(mUserVender.getUserName()).append("%'");
		}
		if(mUserVender.getCommunityName()!=null&&mUserVender.getCommunityName()!=""){
			String[] com=mUserVender.getCommunityName().split(",");
			
			sb.append(" and  m.communityName in (");
			for(int i=0;i<com.length;i++){
				sb.append("'"+com[i]+"'");
				if(i!=com.length-1){
					sb.append(",");
				}
			}
			sb.append(") ");
		}
		if(mUserVender.getAllocation()==1| mUserVender.getAllocation()==0){
			sb.append(" and  m.allocation=").append(mUserVender.getAllocation());
		}
		if(siteIds!=""&&siteIds!=null){
			sb.append(" and  m.siteId in (").append(siteIds).append(")");
		}
		sb.append(" order by allocation ");
		return super.pagedQuery(sb.toString(), pageNo, pageSize);
	}
	
	
	public Map<Long, Long> getCount(String Ids,Date start,Date end,String userName){
		String sql="SELECT n.user_id,count(*) FROM n_check_list n WHERE  n.created_at >='"+DateYear.formatDate(start)+"' and n.created_at<='"+DateYear.formatDate(end)+"' AND n.user_id in("+Ids+") AND n.created_by='"+userName+"' group by n.user_id ";
		Map<Long, Long> map=new HashMap<Long, Long>();
		List<Object[]> list = super.findBySQLQuery(sql);
		while(list.iterator().hasNext()){
			for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
				Object[] column = iter.next();
				int con=((Integer)column[0]);
				map.put((long)con,((BigInteger)column[1]).longValue());
			}
		}
		return map;
	}
	
	/**
	 * 获取用户开通的所有专业服务
	 * @param ruser
	 * @return
	 */
	public List<MUserVender> getListMUserVerder(long userId){
		String hql="from MUserVender m where m.userId=? and available=?";
		return super.find(hql, userId,PropertyValueConstants.AVAILABLE);
	}
	/**
	 * 查询一条
	 * @param ruser
	 * @param venderId
	 * @return
	 */
	public MUserVender getMUserVender(long userId,int venderId){
		String hql="from MUserVender m where m.userId=? and m.venderId=? and available=?";
		 List<MUserVender> list=super.find(hql, userId,venderId,PropertyValueConstants.AVAILABLE);
		if(list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
		 
	}
	/**
	 * 特征状态信息
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @param mUserVender
	 * @param oCategoryItem
	 * @return
	 */
	public Page<FeatureUserVO> getVenderFeaturePage( int venderId, int pageNo, int pageSize,MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat){
		String oCategoryItemIds=null ;
		if(oCategoryItem!=null){
			oCategoryItemIds =getoCategoryItemId(oCategoryItem);
		}
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT m.user_id,m.user_idCard,m.user_name,m.user_sex,m.community_name,m.allocation,s.three,s.`disable`,s.no_security,s.lonely,s.less_income,s.empty_nest,");
		sb.append("  s.lost_only,s.special_care,s.life_lonely,m.site_id FROM m_user_venders m ,r_specia s WHERE s.user_id=m.user_id  AND  m.vender_id=").append(venderId);
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
	 * 导出excel
	 * @param venderId
	 * @param pageNo
	 * @param pageSize
	 * @param mUserVender
	 * @param oCategoryItem
	 * @param feat
	 * @return
	 */
	public List<FeatureUserVO> getVenderFeatureList( int venderId,MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat){
		String oCategoryItemIds=null ;
		if(oCategoryItem!=null){
			oCategoryItemIds =getoCategoryItemId(oCategoryItem);
		}
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT m.user_id,m.user_idCard,m.user_name,m.user_sex,m.community_name,m.allocation,s.three,s.`disable`,s.no_security,s.lonely,s.less_income,s.empty_nest,");
		sb.append("  s.lost_only,s.special_care,s.life_lonely,m.site_id FROM m_user_venders m ,r_specia s WHERE s.user_id=m.user_id  AND  m.vender_id=").append(venderId);
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
		
		//返回值
		List<Object[]> list = super.findBySQLQuery(sb1);
		//构建分页对象
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
			vo.setThree((Integer)column[6]);
			map.put("three", (Integer)column[6]);
			vo.setDisable((Integer)column[7]);
			if(column[7]!=null){
				map.put("disable", (Integer)column[7]);
			}else{
				map.put("disable", 0);
			}
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
	public HashMap<String,Long> getCount(int venderId,Map<Integer, String> oCategoryItem,FeatureVO feat){
		StringBuffer sql=new StringBuffer("SELECT  count(*) FROM m_user_venders m , r_specia s  WHERE s.user_id=m.user_id  AND  m.vender_id=");
		sql.append(venderId).append(" AND m.available=1");
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
	
	//专业服务商获取旗下老人评估情况
	public Page<AssessUserVO> getdemand(Integer venderId,ConclusionScreenVO vo, DateParamVO dateCond,PageParamVO pagevo){
		
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT  m_user_venders.user_name,r_user.gender,r_user.age,r_user.community_id,r_user.id,m_user_venders.site_id,r_user.id_card_no,m_assess_record.assess_name,m_assess_record.con_content,m_assess_record.created_at,m_assess_record.id as recordId ");
		sb.append("FROM m_user_venders, m_assess_record,r_user WHERE ");
		sb.append("  r_user.id=m_user_venders.user_id").append(" AND r_user.id=m_assess_record.user_id AND m_user_venders.vender_id=").append(venderId);
		if(vo.getScaleId()!=0){
		sb.append(" AND m_assess_record.assess_id=").append(vo.getScaleId());
		}
		if(vo.getConclusion()!=0){
			sb.append(" AND m_assess_record.con_id=").append(vo.getConclusion());
		}
		if(dateCond!=null&&dateCond.getStart()!=null&&dateCond.getEnd()!=null){
			sb.append(" AND m_assess_record.created_at  BETWEEN '").append(DateUtil.formatDate(dateCond.getStart(), DateUtil.DATE_FORMAT)).append("' AND '").append(DateUtil.formatDate(dateCond.getEnd(), DateUtil.DATE_FORMAT)).append("'");
		}
		if(dateCond!=null&&dateCond.getStart()==null&&dateCond.getEnd()!=null){
			sb.append(" AND m_assess_record.created_at<='").append(DateUtil.formatDate(dateCond.getEnd(), DateUtil.DATE_FORMAT)).append("'");
		}
		if(dateCond!=null&&dateCond.getStart()!=null&&dateCond.getEnd()==null){
			sb.append(" AND m_assess_record.created_at>='").append(DateUtil.formatDate(dateCond.getStart(), DateUtil.DATE_FORMAT)).append("'");
		}
		
		if(vo.getCommunity()!=null&&!vo.getCommunity().equals("0")){
			sb.append(" AND  r_user.community_id in(").append(vo.getCommunity()+") ");
		}
		if(vo.getSiteId()!=0){
			sb.append(" AND  m_user_venders.site_id=").append(vo.getSiteId());
		}
		if(vo.getUserName()!=""&&vo.getUserName()!=null){
			sb.append(" AND  r_user.name  like'%"+vo.getUserName()+"%' ");
		}
		List<Object[]> all = super.findBySQLQuery(sb.toString());
		//总记录数
		int totalCount = all.size();
		int pageIndex=(pagevo.getPage()-1)*pagevo.getNum();
		//分页
		String sql1=(pagevo.getPage() == 1 ? 0 : pageIndex) + "," +  pagevo.getNum();
		sb.append(" LIMIT  ").append(sql1);
		//返回值
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sb.toString());
		List<AssessUserVO > results = new ArrayList<AssessUserVO>();
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			AssessUserVO as=new AssessUserVO();
			Object[] column = iter.next();
			as.setName((String) column[0]);
			as.setGender((Integer) column[1]);
			if(column[2]!=null){
				as.setAge((Integer) column[2]);
			}
			as.setCommunityId((Integer) column[3]);
			as.setId(((BigInteger) column[4]).longValue());
			if(column[5]!=null){
				as.setSiteId(((BigInteger) column[5]).longValue());
			}
			as.setIdCardNo((String) column[6]);
			as.setAssessName((String) column[7]);
			as.setAssessConclusion((String) column[8]);
			Object o=column[9];
			as.setCreatAt((Date)o);
			as.setRecordId(((BigInteger) column[10]).longValue());
			results.add(as);
		}
		//构建分页对象
		Page<AssessUserVO> page = new Page<AssessUserVO>();
		page.setPageNo(pagevo.getPage());
		page.setPageSize( pagevo.getNum());
		page.setTotalCount(totalCount);
		page.setResult(results);
		
		return page;
	}
	
	public List<AssessUserVO> demandList(ConclusionScreenVO vo, DateParamVO dateCond,Integer venderId,String userIds,String recordIdsUser){
		
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT distinct r_user.id,  m_user_venders.user_name,r_user.gender,r_user.age,r_user.community_id,m_user_venders.site_id,m_assess_record_detail.record_detail,m_assess_record.created_at,m_assess_table.type,r_user.id_card_no,m_assess_record.con_content,m_assess_record.`assess_name` ");
		sb.append("FROM m_user_venders, m_assess_record,r_user,m_assess_record_detail,m_assess_table ");
		if(vo.getScaleId()!=0){
			sb.append("WHERE m_assess_record.assess_id=").append(vo.getScaleId()).append(" AND");	
		}else{
			sb.append("WHERE ");	
		}
		if(recordIdsUser!=null&&!recordIdsUser.isEmpty()){
			sb.append(" m_assess_record.id in (").append(recordIdsUser).append(") AND");	
		} 
		sb.append("  m_assess_table.id=m_assess_record.assess_id ");
		sb.append(" AND  r_user.id=m_user_venders.user_id").append(" AND r_user.id=m_assess_record.user_id AND m_assess_record_detail.record_id=m_assess_record.id ");
		sb.append(" AND m_user_venders.vender_id=").append(venderId);
		if(vo.getConclusion()!=0){
			sb.append(" AND m_assess_record.con_id=").append(vo.getConclusion());
		}
		sb.append(" AND m_assess_record.created_at  BETWEEN '").append(DateUtil.formatDate(dateCond.getStart(), DateUtil.DATE_FORMAT)).append("' AND '").append(DateUtil.formatDate(dateCond.getEnd(), DateUtil.DATE_FORMAT)).append("'");
		if(!vo.getCommunity().equals("0")&&null!=vo.getCommunity()&&!"null".equals(vo.getCommunity())){
			sb.append(" AND  r_user.community_id in(").append(vo.getCommunity()+") ");
		}
		if(vo.getSiteId()!=0&&null!=vo.getSiteId()){
			sb.append(" AND  m_user_venders.site_id=").append(vo.getSiteId());
		}
		
		if(userIds!=null&&userIds!=""){
			sb.append(" AND  r_user.id in("+userIds+")");
			}
			List<Object[]> list = super.findBySQLQuery(sb.toString());
			//分页
			//返回值
			//查询分页记录
			List<AssessUserVO > results = new ArrayList<AssessUserVO>();
			for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
				AssessUserVO as=new AssessUserVO();
				Object[] column = iter.next();
				as.setId(((BigInteger) column[0]).longValue());
				as.setName((String) column[1]);
				as.setGender((Integer) column[2]);
				if(column[2]!=null){
					as.setAge((Integer) column[3]);
				}
				as.setCommunityId((Integer) column[4]);
				
				if(column[5]!=null){
					as.setSiteId(((BigInteger) column[5]).longValue());
				}
				as.setRecordDetail((String)column[6]);
				Object o=column[7];
				as.setCreatedAt((Date) o);
				Object o1=column[8];
				as.setType((Short)o1);
				as.setIdCardNo(((String) column[9]));
				as.setConContent((String)column[10]);
				as.setAssessName((String)column[11]);
				results.add(as);
			}
		
		return results;
	}
	
}
