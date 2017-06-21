/**
 * 
 */
package com.anticw.aged.service.user;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ACommunityUser;
import com.anticw.aged.dao.user.ACommunityUserDao;
/**
 * @author ltw
 *
 */
@Service
public class ACommunityUserService {
	@Autowired
	private ACommunityUserDao aCommunityUserDao;
	
	public void deleteById(Serializable id){
		aCommunityUserDao.removeById(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ACommunityUser getACommunityUserById(Serializable id) {
		ACommunityUser aCommunityUser = aCommunityUserDao.get(id);
		return aCommunityUser;
	}
   /**
    * 
    * @param aCommunityUser
    */
	public void saveOrUpdate(ACommunityUser aCommunityUser) {
		 aCommunityUserDao.saveOrUpdate(aCommunityUser);
	}
	

}
