package com.anticw.aged.dao.director;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HTreatUser;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 
 * @author DX-2016/9/26
 *
 */
@Component
public class HTreatUserDao extends HibernateEntityDao<HTreatUser>{
	/**
	 * 获取当前用户所有治疗消息
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<HTreatUser> getPage(PageParamVO page,Long userId,DateParamVO dateCond){
		/*String hqlStr="from HTreatUser h where h.userId=? ";*/
		String hqlStr="SELECT a.id,b.name,c.userName,a.createAt,a.desired,a.createBy"+
		" FROM HTreatUser a,RUser b,HGroup c WHERE a.userId=b.id AND a.groupId=c.userId AND a.userId=? AND a.createAt between ? and ? ";
		return super.pagedQuery(hqlStr, page.getPage(), page.getNum(),userId,dateCond.getStart(),dateCond.getEnd());
	}
}
