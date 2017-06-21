package com.anticw.aged.dao.community.country;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 省 市 区 管理 Dao
 * @ClassName: OCountryDao
 * @Description: TODO
 * @author ltw
 * @date 2014年10月2日 下午8:52:20
 * 
 */
@Repository
@Component
public class OCountryDao extends HibernateEntityDao<OCountry> {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OCountry getCountryById(Serializable id) {
		 return super.get(id);
	}
	/**
	 * 根据type获取列表（类型:0:全国 1:省 2;市 3:区 4:街道 5:社区）
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountryByType(Serializable id) {
		 String hql="from OCountry where type=?";
		 return super.find(hql, id);
	}
	/**
	 * 根据社区Id列表获取社区列表（社区ID逗号分割）
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountryByIds(String ids) {
		 String hql="from OCountry where  id in("+ids+")";
		 return super.find(hql);
	}
	public OCountry getOCountry(int id){
		this.currentSession().clear();
		String hql="from OCountry where  id =?";
		List<OCountry> oc=super.find(hql,id);
		OCountry o=new OCountry();
		if(oc.size()==0){
			o.setName("未知社区");
			return o;
		}else{
			return oc.get(0);
		}
	}

	/**
	 * 根据用户社区ID查询此用户所在社区的街道信息
	 * @param id
	 * @return
	 */
	public List<OCountry> getParentByIds(String ids) {
		 String hql="from OCountry where id in (select parentId from OCountry where  id in("+ids+"))";
		 return super.find(hql);
	}
	public List<OCountry> getParentById(String ids) {
		String hql="from OCountry where id in ("+ids+")";
		return super.find(hql);
	}
	/**
	 * 根据用户社区ID查询此用户某区下未注册的街道
	 * @param parentId 某街道父ID
	 * @param ids 用户当前社区ID
	 * @return
	 */
	public List<OCountry> getNotInParentByIds(String parentId, String ids) {
		 String hql;
		 if(ids==null||!"".equals(ids)||ids.length()==0){
			 hql="from OCountry where parentId="+parentId;
		 }else{
		    hql="from OCountry where parentId="+parentId+" and id not in (select parentId from OCountry where  id in("+ids+"))"; 
		 }
		
		 return super.find(hql);
	}
	
	/**
	 * 根据PID查询子列表
	 * @author guoyongxiang
	 * Date: 2014-10-14 下午6:30:04
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountrysByPid(Serializable id){
		String hql ="from OCountry where parentId=?";
		return super.find(hql, id);
	}
	/**
	 * 查询所有
	 */
	public List<OCountry> getCountryAll(){
		String hql ="from OCountry";
		return super.find(hql);
	}
	
	/**
	 * 获取志愿者对应的站点
	 * @return
	 */
	public List<OCountry> getCounNVolunteer(){
		String hql="from  OCountry where id in(select n.community from NVolunteer n WHERE n.avaliable=1 group by n.community)";
		return super.find(hql);
	}
 
}
