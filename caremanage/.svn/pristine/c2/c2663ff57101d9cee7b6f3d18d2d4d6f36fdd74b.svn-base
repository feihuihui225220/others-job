package com.anticw.aged.dao.professional.vender;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.MVender;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 服务商持久化对象
 * <P>File name : VenderDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-14 </P>
 */
@Repository
public class VenderDao extends HibernateEntityDao<MVender> {

	/**
	 * 获取服务商集合
	 * VenderDao.getByIds()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param ids
	 * @return
	 */
	public List<MVender> getByIds(String ids) {
		return super.find("from MVender m where m.id in (" + ids + ")");
	}
	
	/**
	 * 获取服务商列表by 社区id
	 * @param communityIds
	 * @param venderName
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVender> listVendersByCommunityIds(String communityIds,String venderName,int page,int num){
		String hql = "from MVender m where m.communityIds in ( ? )";
		//拼接venderName
		if(!StringUtils.isEmpty(venderName)) {
			hql += " and m.name = '" + venderName + "'";
		}
		return super.pagedQuery(hql, page, num, communityIds);
	}
	/**
	 * 根据添加人展示专业服务商
	 * @author dx
	 * @param createdBy
	 * @param venderName
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVender> listVendersByCreatedBy(String createdBy,String venderName,int page,int num){
		String hql = "from MVender m where m.createdBy = ? ";
		//拼接venderName
		if(!StringUtils.isEmpty(venderName)) {
			hql += " and m.name = '" + venderName + "'";
		}
		return super.pagedQuery(hql, page, num, createdBy);
	}
	
	/**
	 * 获取服务商列表
	 * VenderDao.listVenders()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param cmName
	 * @param venderName
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVender> listVenders(String cmName, String venderName, int page, int num) {
		
		//hql
		String hql = "from MVender m where m.cmName = ?";
		
		//拼接venderName
		if(!StringUtils.isEmpty(venderName)) {
			hql += " and m.name = '" + venderName + "'";
		}
		
		return super.pagedQuery(hql, page, num, new Object[]{new String(cmName)});
	}
	/**
	 * 获取cm下所有专业服务商
	 * @param cmName
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVender> venders(String cmName,int page, int num) {
		//hql
		String hql = "from MVender m where m.cmName = ?";
		
		return super.pagedQuery(hql, page, num, cmName);
	}
	/**
	 * 获取一个cm下的所有服务商
	 * @param cmName
	 * @param page
	 * @param num
	 * @return
	 */
	public List<MVender> venders(String cmName) {
		//hql
		String hql = "from MVender m where m.cmName = ?";
		
		return super.find(hql,cmName);
	}
	/**
	 * @author dx
	 * 报告中获取服务商名称
	 * @param contact
	 * @return
	 */
	public MVender getMVender(String contact){
		List<MVender> m;
		try {
			m = super.find("from MVender m where m.contact=?", contact);
			return m.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	/**
	 * @author dx  
	 * 根据服务商id获取a_user中用户id
	 * @param id
	 * @return
	 */
	public MVender getMvender(int id){
		String hql="from MVender m where m.id=?";
		List<MVender> m=super.find(hql,id);
		return m.get(0);
	}
}
