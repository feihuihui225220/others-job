/**
 * 
 */
package com.anticw.aged.dao.permission;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 角色DAO
 * 
 * @author guoyongxiang Date: 2014-9-29
 */
@Repository
public class RoleDao extends HibernateEntityDao<ARole> {

	// private static Logger logger = LoggerFactory.getLogger(RoleDao.class);

	/**
	 * 权限分配-查询角色列表
	 * 
	 * @author guoyongxiang Date: 2014-10-3 下午12:45:59
	 * @param name
	 * @param userCategory
	 * @return
	 */
	public List<ARole> findRoles(String name, Short userCategory) {
		StringBuffer bf = new StringBuffer();
		bf.append("from ARole where userCategory=? and createdBy=? and available=?");
		return super.find(bf.toString(), userCategory, name, PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 查询角色
	 * 
	 * @author guoyongxiang Date: 2014-10-3 下午6:26:00
	 * @param ids
	 * @return
	 */
	public Set<ARole> findRolesIn(int[] ids) {
		StringBuffer bf = new StringBuffer();
		if (ids == null || ids.length <= 0) {
			return new HashSet<ARole>(0);
		}
		for (int id : ids) {
			bf.append(",").append(id);
		}
		List<ARole> list = super.find("from ARole where id in(" + bf.substring(1).toString() + ") and available=?",
				PropertyValueConstants.AVAILABLE);
		Set<ARole> set = new HashSet<ARole>();
		set.addAll(list);
		return set;
	}

	/**
	 * 根据Id删除角色及关联关系
	 * 
	 * @author guoyongxiang Date: 2014-10-10 下午3:27:34
	 * @param id
	 */
	public void remove(Integer id) {
		ARole role = super.get(id);
		// 从主控表删除被控表关联关系
		for (AUser user : role.getUsers()) {
			user.getRoles().remove(role);
		}
		super.remove(role);
	}
}
