/**
 * 
 */
package com.anticw.aged.dao.user;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.DateYear;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.HGroupUserVO;
import com.anticw.aged.vo.professional.assess.ConclusionScreenVO;
import com.anticw.aged.vo.user.AssessUserVO;
import com.anticw.aged.vo.user.CountColumnEnum;
import com.anticw.aged.vo.user.CountParamItemVO;
import com.anticw.aged.vo.user.CountUserItemVO;

/**
 * 用户信息DAO
 * @author guoyongxiang
 * Date: 2014-9-21
 */
@Repository
@Component
public class RUserDao extends HibernateEntityDao<RUser> {
	
	private static Logger logger = LoggerFactory.getLogger(RUserDao.class);
	
	/**
	 * 根据条件查找列表
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:35:22
	 * @param pageNo
	 * @param pageSize
	 * @param criterions
	 * @return
	 */
	public Page<RUser> findByPage(int pageNo, int pageSize, String hql){
		
		//查询条件
		String hqlStr = "from RUser where available=? ";
		if(hql!=null&&!"".equals(hql)){
			hqlStr += hql;
		}
		//分页查询
		return super.pagedQuery(hqlStr, pageNo, pageSize, PropertyValueConstants.AVAILABLE);
	}
	
	
	public Page<RUser> getUserlist(PageParamVO page,RUser user){
		//查询条件
		String hqlStr = "from RUser where available=?";
		if(user.getState()==null||user.getState()==99){
			hqlStr+=" and state in(0,1,2,3,4)";
		}else{
			hqlStr+=" and state="+user.getState();
		}
		if(user.getName()!=null&&user.getName()!=""){
			hqlStr+=" and name like '%"+user.getName()+"%'";
			
		}
		if(user.getMobilePhone()!=null&&user.getMobilePhone()!=""){
			hqlStr+=" and mobilePhone like '%"+user.getMobilePhone()+"%'";
			
		}
		if(user.getCreatedBy()!=null&&user.getCreatedBy()!=""){
			hqlStr+=" and createdBy like '%"+user.getCreatedBy()+"%'";
			
		}
		if(user.getGender()!=null&&user.getGender()!=99){
			hqlStr+=" and gender like '%"+user.getGender()+"%'";
			
		}
		hqlStr+=" order by createdAt desc";
		
		//分页查询
		return super.pagedQuery(hqlStr, page.getPage(), page.getNum(), PropertyValueConstants.AVAILABLE);
	}
	public Page<HGroupUserVO> getUserlist(Integer avaible,PageParamVO pagevo){
		//查询条件SELECT * FROM r_user r LEFT JOIN h_group_user h ON h.`user_id`=r.`id` 
		String sqlStr = "SELECT r.id,r.name,r.gender,r.created_at,h.group_id,h.id as hid from r_user r LEFT JOIN h_group_user h ON h.`user_id`=r.`id` WHERE  r.available=1  and r.state in(0,1,2,3,4) order by h.group_id";
		if(avaible==0){
			//已分配
			sqlStr="SELECT r.id,r.name,r.gender,r.created_at,h.group_id,h.id as hid FROM  r_user r,h_group_user h WHERE r.id=h.user_id AND h.available=1 AND r.available=1  AND r.`state` IN(0,1,2,3,4)";
		}else if(avaible==1){
			sqlStr="SELECT r.id,r.name,r.gender,r.created_at FROM  r_user r WHERE r.id NOT IN (SELECT h.`user_id` FROM h_group_user h WHERE h.available=1) AND r.`state` IN(0,1,2,3,4)  AND r.available=1";
		}
		//分页查询
		List<Object[]> all = super.findBySQLQuery(sqlStr);
		//总记录数
		int totalCount = all.size();
		int pageIndex=(pagevo.getPage()-1)*pagevo.getNum();
		//分页
		String sql1=(pagevo.getPage() == 1 ? 0 : pageIndex) + "," +  pagevo.getNum();
		StringBuffer sb=new StringBuffer(sqlStr);
		sb.append(" LIMIT  ").append(sql1);
		//返回值
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sb.toString());
		List<HGroupUserVO > results = new ArrayList<HGroupUserVO>();
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			HGroupUserVO as=new HGroupUserVO();
			Object[] column = iter.next();
			as.setId(((BigInteger)column[0]).longValue());
			as.setName((String)column[1]);
			as.setGender((int)column[2]);
			Object o=column[3];
			as.setCreatedAt((Date)o);
			if(column.length>4){
				Object o1=column[4];
				if(o1!=null){
					as.setGroupId(((BigInteger)column[4]).longValue());
				}
				if(column[5]!=null){
					as.sethId((int)column[5]);
				}
			}
			
			/*as.setName((String) column[0]);
			as.setGender((Integer) column[1]);
			if(column[2]!=null){
				as.setAge((Integer) column[2]);
			}
			as.setCommunityId((Integer) column[3]);
			as.setId(((BigInteger) column[4]).longValue());
			as.setCommunityName((String)column[5]);*/
			results.add(as);
		}
		//构建分页对象
		Page<HGroupUserVO> page = new Page<HGroupUserVO>();
		page.setPageNo(pagevo.getPage());
		page.setPageSize( pagevo.getNum());
		page.setTotalCount(totalCount);
		page.setResult(results);
		
		return page;
	}
	/**
	 * 根据条件查找列表
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:35:22
	 * @param pageNo
	 * @param pageSize
	 * @param criterions
	 * @return
	 */
	public List<RUser> list(String hql){
		
		//查询条件
		String hqlStr = "from RUser where available=? ";
		if(hql!=null&&!"".equals(hql)){
			hqlStr += hql;
		}
		//分页查询
		return super.find(hqlStr, PropertyValueConstants.AVAILABLE);
	}
	/**
	 * 节目签到查询
	 * @param Ids
	 * @return
	 */
	public List<RUser> getlist(String Ids){
		String hql="from RUser where id in("+Ids+")";
		 return	super.find(hql);
	}
	
	public Page<RUser>	getPage(String Ids,PageParamVO pageVO){
		String hql="from RUser where id in("+Ids+")";
		
		return super.pagedQuery(hql, pageVO.getPage(), pageVO.getNum());
	}
	/**
	 * 根据ID查找
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:35:11
	 * @param id
	 * @return
	 */
	//目前用到
	public RUser findById(Long id){
		return super.get(id);
	}
	
	/**
	 * 根据身份证号查找
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:35:11
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	public RUser findByIdCardNo(String idCardNo) throws BusinessException{
		List<RUser> users= null;
			users = this.find("from RUser where idCardNo=? and available=? order by changedAt desc", idCardNo, PropertyValueConstants.AVAILABLE);
			if(users.size()>0){
				return users.get(0);
			}
			return null;
	}
	public RUser findBymobilePhone(String mobilePhone) throws BusinessException{
		List<RUser> users= null;
		
		try {
			users = this.find("from RUser where mobilePhone=? and available=? order by changedAt desc", mobilePhone, PropertyValueConstants.AVAILABLE);
			return users.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public RUser findByIdmobilePhone(String mobilePhone) throws BusinessException{
		List<RUser> users= null;
		
		users = this.find("from RUser where mobilePhone=? and available=? order by changedAt desc", mobilePhone, PropertyValueConstants.AVAILABLE);
		if(users == null || users.isEmpty()){
			logger.warn("用户名为空 {}", mobilePhone);
			throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_INVALID);
		}
		return users.get(0);
	}
	/**
	 * 根据身份证或者姓名查询
	 * @param idCardNo
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<RUser> findByIdAndName(String idCardNo) throws BusinessException{
		Pattern pattern = Pattern.compile("[0-9]*");
		List<RUser> users= null;
		if(pattern.matcher(idCardNo).matches() || idCardNo.contains("X") || idCardNo.contains("x")){
			 String sql = "select id_card_no as idCardNo,contact_phone as contactPhone,mobile_phone as mobilePhone,name as name,age as age,gender as gender,addr as addr,hr_addr as hrAddr from r_user where (id_card_no like '%"+idCardNo+"%' ) and available="+PropertyValueConstants.AVAILABLE;
			 users = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
			if(users == null || users.isEmpty()){
				throw new BusinessException(ExceptionCode.USER_NUMBER_NO_INVALID);
			}
			if(users == null || users.isEmpty()){
				logger.warn("身份证号无效idCardNo {}", idCardNo);
				throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_INVALID);
			}
		}else{
			 String sql = "select id_card_no as idCardNo,contact_phone as contactPhone,mobile_phone as mobilePhone,name as name,age as age,gender as gender,addr as addr,hr_addr as hrAddr from r_user where (name like '%"+idCardNo+"%' ) and available="+PropertyValueConstants.AVAILABLE;
			 users = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
			 if(users == null || users.isEmpty()){
				logger.warn("没有此用户", idCardNo);
				throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_INVALID);
			}
		}
		
		return users;
	}
	/**
	 * 根据电话号码查询
	 * @author L
	 * 2014年11月11日20:55:38
	 * @param number
	 * @return
	 * @throws BusinessException
	 */
	public List<RUser> findByIdNumber(String number) throws BusinessException{
		String sql = "select id_card_no as idCardNo,name as name,age as age,gender as gender,addr as addr,hr_addr as hrAddr from r_user where (mobile_phone="+number+" or contact_phone="+number+") and available="+PropertyValueConstants.AVAILABLE;
		@SuppressWarnings("unchecked")
		List<RUser> users = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
		if(users == null || users.isEmpty()){
			throw new BusinessException(ExceptionCode.USER_NUMBER_NO_INVALID);
		}
		return users;
	} 
	
	public void update(RUser user){
		int age = DateUtil.getAgeByYear(user.getBirthday());
		user.setAge(age);
		super.update(user);
	}
	public void update_shenhe(RUser user){
		super.update(user);
	}
	
	public long save(RUser user){
		if(user.getBirthday()!=null){
		int age = DateUtil.getAgeByYear(user.getBirthday());
		user.setAge(age);
		}
		super.save(user);
		return user.getId();
	}
	
	/**
	 * 保存
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:35:03
	 * @param user
	 */
	public void saveOrUpdate(RUser user){
		if (user.getBirthday() != null) {
			int age = DateUtil.getAgeByYear(user.getBirthday());
			user.setAge(age);
		}
		super.saveOrUpdate(user);
		super.flushSession();
	}
	public void updates(RUser user){
		int age = DateUtil.getAgeByYear(user.getBirthday());
		user.setAge(age);
		super.update(user);
	}
	public void remove(long id){
		super.removeById(id);
	}
	/**
	 * 逻辑删除用户信息
	 * @author guoyongxiang
	 * Date: 2014-9-27 下午6:34:50
	 * @param id
	 * @param opUser
	 */
	public void delete(Long id, String opUser){
		RUser user = this.findById(id);
		Date date = new Date();
		user.setAvailable(!PropertyValueConstants.AVAILABLE);
		user.setChangedAt(date);
		user.setChangedBy(opUser);
		user.getSpecia().setAvailable(!PropertyValueConstants.AVAILABLE);
		user.getSpecia().setChangedAt(date);
		user.getSpecia().setChangedBy(opUser);
		//RContact con = user.getrContact();
		List<RContact> listCon = user.getrContact();
		for (int i = 0; i < listCon.size(); i++) {
			RContact con = listCon.get(i);
			con.setAvailable(!PropertyValueConstants.AVAILABLE);
			con.setChangedAt(date);
			con.setChangedBy(opUser);
		}
		/*con.setAvailable(!PropertyValueConstants.AVAILABLE);
		con.setChangedAt(date);
		con.setChangedBy(opUser);*/
		this.update(user);
	}
	
	/**
	 * 更新当天生日的用户年龄
	 * @author guoyongxiang
	 * Date: 2014-11-7 上午11:58:01
	 */
	public void updateAge(){
		StringBuffer bf = new StringBuffer();
		bf.append("update r_user");
		bf.append(" set age=year(now())-year(birthday)");
		bf.append(" where 1=1");
		bf.append(" and month(birthday)=month(now())");
		bf.append(" and day(birthday)=day(now());");
		super.executeSQL(bf.toString(), new Object[]{});
	}

	@SuppressWarnings("unchecked")
	/**
	 * 根据各项条件统计社区用户数量
	 * @author L
	 * 2015-6-8 14:09:58
	 * @param item
	 * @param communityId
	 * @return
	 */
	public List<CountUserItemVO> count(CountParamItemVO item, String communityId) {
		String sql = item.getIsSpec()?getCountSpecSql(item, communityId):getCountSql(item, communityId);
		Query query = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(CountUserItemVO.class));
		return query.list();
	}
	/**
	 * 获取统计项sql语句
	 * @param item
	 * @param communityId
	 * @return
	 */
	private String getCountSql(CountParamItemVO item, String communityId){
		String column = CountColumnEnum.getColumn(item.getTitle()).getColumn(); 
		StringBuilder sb = new StringBuilder("select community.name as communityName,community.id as communityId,count(user.id) as count from o_country community "
				+ "left join r_user user on user.community_id = community.id");
		if(CountColumnEnum.getColumn(item.getTitle())!=CountColumnEnum.年龄){
			sb.append(" and user."+column).append("=").append(item.getValue());
		}else{
			if(!("".equals(item.getValue())||item.getValue()==null))
				sb.append(" and user."+column).append(">=").append(item.getValue());
			if(!("".equals(item.getValue2())||item.getValue2()==null))
				sb.append(" and user."+column).append("<=").append(item.getValue2());
		}
		sb.append(" where find_in_set(community.id,'").append(communityId).append("') group by community.id order by community.id asc");
		logger.debug(sb.toString());
		return sb.toString();
	}
	/**
	 * 获取特殊项的统计sql语句
	 * @param item
	 * @param communityId
	 * @return
	 */
	private String getCountSpecSql(CountParamItemVO item, String communityId){
		String column = CountColumnEnum.getColumn(item.getTitle()).getColumn(); 
		StringBuilder sb = new StringBuilder("select community.name as communityName,community.id as communityId,count(specia.id) as count from (o_country community "
				+ "left join r_user user on user.community_id = community.id) "
				+ "left join r_specia specia on specia.user_id=user.id and specia."
				).append(column).append("<>0 and specia.")
				 .append(column).append(" not in (select id from o_category_item where item_name='否')");
				
		sb.append(" where find_in_set(community.id,'").append(communityId).append("') group by community.id order by community.id asc");
		logger.debug(sb.toString());
		return sb.toString();
	}
	
	public Page<AssessUserVO> getdemand(ConclusionScreenVO vo, DateParamVO dateCond,PageParamVO pagevo,String creatBy){
		StringBuffer sb = getAssessSql(vo, dateCond, creatBy);
		
		if(Integer.parseInt(vo.getCommunity())!=0){
			sb.append(" AND  r_user.community_id=").append(Integer.parseInt(vo.getCommunity()));
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
			as.setCommunityName((String)column[5]);
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
	public List<AssessUserVO> demandList(ConclusionScreenVO vo, DateParamVO dateCond,String creatBy){
		StringBuffer sb = getAssessSql(vo, dateCond, creatBy);
		
		if(Integer.parseInt(vo.getCommunity())!=0){
			sb.append(" AND  r_user.community_id=").append(Integer.parseInt(vo.getCommunity()));
		}
		List<Object[]> list = super.findBySQLQuery(sb.toString());
		
		//总记录数
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
			as.setCommunityName((String)column[5]);
			as.setRecordDetail((String)column[6]);
			Object o=column[7];
			as.setCreatedAt((Date) o);
			Object o1=column[8];
			as.setType((Short)o1);
			as.setIdCardNo((String)column[9]);
			results.add(as);
		}
		
		return results;
	}

	public StringBuffer getAssessSql(ConclusionScreenVO vo,
			DateParamVO dateCond, String creatBy) {
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT  r_user.name,r_user.gender,r_user.age,r_user.community_id,r_user.id,o_country.`name` as oCountryName ,m_assess_record_detail.record_detail,m_assess_record.created_at,m_assess_table.type,r_user.id_card_no ");
		sb.append("FROM m_assess_record_detail, m_assess_record,r_user,o_country,m_assess_table  ");
		sb.append("WHERE r_user.community_id=o_country.id AND m_assess_record.id=m_assess_record_detail.record_id ").append(" AND m_assess_table.id=m_assess_record.assess_id ");;
		sb.append("AND r_user.id=m_assess_record.user_id ");
		sb.append("	AND m_assess_record.assess_id=").append(vo.getScaleId());
		sb.append("	AND m_assess_record.con_id=").append(vo.getConclusion());
		sb.append("	AND m_assess_record.created_at  BETWEEN '").append(DateYear.formatDate(dateCond.getStart())).append("' AND '").append(DateYear.formatDate(dateCond.getEnd())).append("'");
		sb.append(" AND r_user.created_by IN(").append(creatBy).append(")");
		return sb;
	}


	
	/**
	 * 在线管家、、查询所有ruser表信息
	 * @param page
	 * @param user
	 * @param startTime
	 * @param endTime
	 * @return
	 */
		public Page<RUser> listAllCustomer(PageParamVO page,RUser user,String startTime,String endTime){
			String hqlStr = "from RUser where  available=?";
			//模糊查询姓名
			if(user.getName()!=null){
				hqlStr+="and name like '%"+user.getName()+"%'";
			}
			//模糊查询手机号
			if(user.getMobilePhone()!=null){
				hqlStr+="and mobilePhone like '%"+user.getMobilePhone()+"%'";
			}
			//模糊查询身份证号
			if(user.getIdCardNo()!=null||("").equals(user.getIdCardNo())){
				hqlStr+="and idCardNo like '%"+user.getIdCardNo()+"%'";
			}
			//查询是否分配
			if(user.getActive()!=null){
				//0是查询所有
				if(user.getActive()==99){
					hqlStr+="and active in(0,1,2)";
				}else{
					hqlStr+="and active ='"+user.getActive()+"'";
				}
			}
			//根据时间查询
			if(startTime!=null&&endTime!=null){
				hqlStr+="and createdAt BETWEEN '"+startTime+"' And '"+endTime+"'";
			}
			if(startTime!=null&&endTime==null){
				hqlStr+="and createdAt >'"+startTime+"' ";
			}
			if(startTime==null&&endTime!=null){
				hqlStr+="and createdAt <'"+endTime+"' ";
			}
			hqlStr+="order by createdAt desc";
			return super.pagedQuery(hqlStr, page.getPage(), page.getPageSize(), PropertyValueConstants.AVAILABLE);
		}
		
		public void deleteCustomer(long cId,String createBy){
			RUser user = this.findById(cId);
			Date date = new Date();
			user.setAvailable(!PropertyValueConstants.AVAILABLE);
			user.setChangedAt(date);
			user.setChangedBy(createBy);
			super.update(user);
		}
		
		/**
		 * 查询所有的用户
		 * @return
		 */
		public List<RUser> getUser(Integer page,Integer num){
			String hql=" from RUser  where  communityId is not null order by id";
			Page<RUser> ruser= super.pagedQuery(hql, page, num);
			return ruser.getResult();
		}
		public int getUser(){
			String hql="from RUser  where communityId is not null";
			return super.find(hql).size();
		}
		public List<RUser> countUser() {
			String hql="SELECT COUNT(r.id),o.name FROM RUser r ,OCountry o WHERE r.communityId=o.id  and r.state in(0,1,2,3,4)  GROUP BY r.communityId";
			return super.find(hql);
		}

		public List<RUser> countUsers(){
			String hql="SELECT COUNT(r.id),o.name FROM RUser r,OCountry o WHERE r.communityId=o.id AND DATE_FORMAT( r.createdAt, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and r.state in(0,1,2,3,4)  GROUP BY r.communityId";
			return super.find(hql);
		}
		
		public Long sumUser() {
			String hql=" FROM RUser  WHERE state IN(0,1,2,3,4)";
			return super.getCount(hql);
		}


		public Long sumUser2() {
			String hql=" FROM RUser  WHERE state IN(0,1,2,3,4) AND DATE_FORMAT(createdAt, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
			return super.getCount(hql);
		}
}
