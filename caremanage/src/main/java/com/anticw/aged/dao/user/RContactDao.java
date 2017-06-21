/**
 * 
 */
package com.anticw.aged.dao.user;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 用户联系人
 * @author guoyongxiang
 * Date: 2014-9-21
 */
@Repository
public class RContactDao extends HibernateEntityDao<RContact> {

	public RContact getByUser(RUser r){
		String sql="SELECT id FROM r_contact WHERE user_id="+r.getId();
		List<Object[]> list = super.findBySQLQuery(sql);
		
		if(list.size()!=0){
			Object column= list.get(0);
			RContact vo = new RContact();
		 	vo.setId(((BigInteger)column).longValue());
		 	return vo;
		}else{
			return null;
		}
	}
	public RContact rContactsById(Long id){
		return (RContact)super.find("from RContact where id=?", id).get(0);
	}
	public void modifyRcontacts(RContact contact){
		super.update(contact);
	}
	
	/**
	 * 根据user_id查询r_contacts表中的信息
	 * @param user
	 * @return
	 */
	public RContact rContactsByIds(RUser user){
		RContact contact=null;
		try {
			contact=(RContact)super.find("from RContact where user=?", user).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			contact=null;
		}
		return contact;
	}
	/**
	 * 添加r_contacts
	 * @param rContact
	 */
	public Boolean saveRContacts(RContact rContact){
		Boolean boolean1=false;
		try {
			super.save(rContact);
			boolean1=true;
		} catch (Exception e) {
			// TODO: handle exception
			boolean1=false;
		}
		return boolean1;
	}
	/**
	 * 
	* @date 2017年5月22日 上午10:47:35
	* @Title: getRContact
	* @Description: 根据user查询rcontact的集合
	* @author wxs
	* @return List<RContact>    返回类型
	* @throws
	 */
	public List<RContact> getRContact(RUser user){
		String hql = "from RContact where user=?";
		return super.find(hql, user);
	}
}
