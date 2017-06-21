/**
 * 
 */
package com.anticw.aged.dao.permission;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.utils.PermissionConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.upload.SubjectTeacherVO;

/**
 * 权限-用户DAO
 * @author guoyongxiang
 * Date: 2014-9-29
 */
@Repository
public class UserDao extends HibernateEntityDao<AUser> {

	private static Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	/**
	 * 根据用户名查找用户
	 * @author guoyongxiang
	 * Date: 2014-10-2 上午10:12:57
	 * @param name
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public AUser findByName(String name) throws UsernameNotFoundException {
		return this.findByName(name, null);
	}
	public int getType(String name){
		String hql="from AUser where name=? ";
		List<AUser> a= this.find(hql,name);
		if(a.size()!=0){
			return a.get(0).getUserCategory();
		}else{
			return 1;
		}
	}
	/**
	 * 根据社区ID查询此社区下所有社区用户
	 * @param communityId
	 * @return
	 */
	public List<AUser> findByCommunityId(String communityId) {
		
		String hql="from AUser where userCategory= "+(short)UserCategoryEnum.CMT.getType() +" and "+communityId +" in (communityIds)";
		return super.find(hql);
	}
	/**
	 * 查询专业服务商
	 * @param name
	 * @param venderId
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public AUser findName(String name,int venderId) throws UsernameNotFoundException {
		String hql="from AUser where  name=? and venderId=?";
		List<AUser> li=super.find(hql,name,venderId);
		return li.get(0);
	}
	/**
	 * 根据用户名 与 用户类型查询用户信息
	 * @author guoyongxiang
	 * Date: 2014-10-2 上午9:49:49
	 * @param name
	 * @param userCategory
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public AUser findByName(String name, Short userCategory) throws UsernameNotFoundException {
		StringBuffer bf = new StringBuffer();
		bf.append("from AUser where name=?");
		if(userCategory!=null){
			bf.append(" and userCategory='").append(userCategory).append("'");
		}
		bf.append(" and available=? order by changedAt desc");
		List<AUser> users = this.find(bf.toString(), name, PropertyValueConstants.AVAILABLE);
		if(users == null || users.isEmpty()){
			logger.warn("用户不存在name {}, userCategory {}", name, userCategory);
			throw new UsernameNotFoundException("用户不存在："+name+", userCategory:"+userCategory);
		}
		return users.get(0);
	}
	
	/**
	 * 查询普通用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午12:26:56
	 * @param name
	 * @param userCategory
	 * @param _super
	 * @return
	 */
	public Page<AUser> getNormalUsersByPage(String name, Short userCategory, boolean super_, Integer venderId, int pageNo, int pageSize){
		super.getSessionFactory().getCurrentSession().flush();
		StringBuffer bf = new StringBuffer();
		bf.append("from AUser where name<>?  and userCategory=? and available=?");
		if(!super_){
			bf.append(" and createdBy='").append(name).append("'");
		}else{
		bf.append(" and (createdBy='").append(name).append("'");
			bf.append(" or ").append("super_=").append(0).append(")");
		}
		if(venderId!=null){
			bf.append(" and venderId=").append(venderId);
		}
		return super.pagedQuery(bf.toString(), pageNo, pageSize, name, userCategory, PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 查询普通所有用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午12:26:56
	 * @param name
	 * @param userCategory
	 * @param _super
	 * @return
	 */
	public List<AUser> getNormalUsers(Integer venderId){
		StringBuffer bf = new StringBuffer();
		bf.append("from AUser where  available=?");
		if(venderId!=null){
			bf.append(" and venderId=").append(venderId);
		}
		return super.find(bf.toString(),  PropertyValueConstants.AVAILABLE);
	}
	
	/** 
	 * 获取专业服务商职员列表
	 * @name UserDao.getVenderAdmins()
	 * @author zhoupeipei
	 * @Date 2014年11月28日 下午11:22:54
	 * @param createBy
	 * @return     
	 */
	public List<AUser> getVenderAdmins(String createBy){
		String sql = "from AUser where createdBy=?";
		return super.find(sql, createBy);
	}
	
	/**
	 * 查询普通用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-3 下午12:26:56
	 * @param name
	 * @param userCategory
	 * @param _super
	 * @return
	 */
	public List<AUser> getNormalUsers(String name, Short userCategory, boolean super_){
		StringBuffer bf = new StringBuffer();
		bf.append("from AUser where name<>?  and userCategory=? and available=?");
		if(!super_){
			bf.append(" and createdBy='").append(name).append("'");
			 
		}else{
			bf.append(" and (createdBy='").append(name).append("'");
			bf.append(" or ").append("super_=").append(0).append(")");
		}
		return super.find(bf.toString(), name, userCategory, PropertyValueConstants.AVAILABLE);
	}
	 
	/**
	 * 根据账户类型查找用户
	 * @author guoyongxiang
	 * Date: 2014-10-18 上午11:20:44
	 * @param cate
	 * @return
	 */
	public List<AUser> getUserByCategory(UserCategoryEnum cate){
		return super.find("from AUser where userCategory=? and available=?", (short)cate.getType(), PropertyValueConstants.AVAILABLE);
	}
	
	public List<AUser> getUser(String name,int venderId){
		return super.find("select id,name from AUser where name like '%"+name+"%' and  venderId=? and available=?", venderId, PropertyValueConstants.AVAILABLE);
	}
	
	public List<AUser> getUser(String Ids){
		return super.find("select id,name from AUser where  id in("+Ids+")");
	}
	
	public List<String> getUserName(String Ids){
		return super.find("select  name from AUser where  id in("+Ids+")");
	}
	
	/**
	 * 根据帐号类型与社区ID列表查询用户数
	 * @author guoyongxiang
	 * Date: 2014-11-8 下午5:21:24
	 * @param cate
	 * @param communityIds
	 * @param super_
	 * @return
	 */
	public long getAUserCount(UserCategoryEnum cate, String communityIds, boolean super_){
		String sql = "from AUser where userCategory=? and available=? and super_=?";
		long result=0;
		try{
			if(communityIds!=null && !"".equals(communityIds)){
				sql += " and communityIds='"+communityIds+"'";
			}
			result=super.getCount(sql, (short)cate.getType(), PropertyValueConstants.AVAILABLE, super_);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据帐号创建人列表查询用户数
	 * @author guoyongxiang
	 * Date: 2014-11-8 下午5:21:24
	 * @param createdBy
	 * @return
	 */
	public long getAUserCount(String createdBy){
		String sql = "from AUser where createdBy=? and available=?";
		return super.getCount(sql, createdBy, PropertyValueConstants.AVAILABLE);
	}
	/**
	 * 活动管理查询员工
	 * @author dx
	 * @param ids
	 * @return
	 */
	public List<AUser>  getAUser(String ids){
		  return super.find("from AUser where id in("+ids+")");
	}
	public List<AUser>  getList(int  venderId){
		return super.find("from AUser where venderId=?",venderId);
	}
	/**
	 * 专业服务商唯一标识符查询服务商是否存在
	 * @author dx
	 * @param idCardNo
	 * @return
	 */
	public AUser getAUserID(String idCardNo){
		String hql="from AUser where idCardNo=? and available=?";
		List<AUser> auser=super.find(hql, idCardNo, PropertyValueConstants.AVAILABLE);
		if(auser.size()!=0){
			return auser.get(0);
		}else{
			return null;
		}
	}
	
	public List<SubjectTeacherVO> getListT(String username,String name){
		String sql="SELECT a_user.id,a_user.`name` FROM a_user,a_user_role,a_role WHERE  a_user_role.user_id=a_user.id AND a_user.created_by='"+username+"'  AND a_user_role.role_id=a_role.id AND  a_role.`name`='"+PermissionConstants.USER_ROLE+"' AND  a_user.name  LIKE '%"+name+"%'";
		List<SubjectTeacherVO> subjectTeacherVO=new ArrayList<SubjectTeacherVO>();
    	List<Object[]> list = super.findBySQLQuery(sql);
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			Object[]  column= iter.next();
			SubjectTeacherVO vo = new SubjectTeacherVO();
			vo.setId((Integer)column[0]);
			vo.setName(column[1].toString());
			subjectTeacherVO.add(vo);
		}
		
		return subjectTeacherVO;
	}
	
	public Page<AUser> getNormalUsersByPage(String name, Short userCategory, boolean super_, Integer venderId, int pageNo, int pageSize,String userName){
		super.getSessionFactory().getCurrentSession().flush();
		StringBuffer bf = new StringBuffer();
		bf.append("from AUser where name<>?  and userCategory=? and available=?");
		if(!super_){
			bf.append(" and createdBy='").append(name).append("'");
		}else{
		bf.append(" and (createdBy='").append(name).append("'");
			bf.append(" or ").append("super_=").append(0).append(")");
		}
		if(venderId!=null){
			bf.append(" and venderId=").append(venderId);
		}
		if(userName!=null&&userName.trim()!=""){
			bf.append(" and  name like '%").append(userName).append("%'");
			
		}
		return super.pagedQuery(bf.toString(), pageNo, pageSize, name, userCategory, PropertyValueConstants.AVAILABLE);
	}
	
	
}
