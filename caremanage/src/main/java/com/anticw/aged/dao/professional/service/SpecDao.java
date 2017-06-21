package com.anticw.aged.dao.professional.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MService;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 专业服务持久化对象
 * <P>File name : SpecDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Repository
public class SpecDao extends HibernateEntityDao<MService> {
	
	/**
	 * 分页查询数据
	 * SpecDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param page
	 * @param num
	 * @return
	 */
	/*public Page<MService> list(int page, int num) {
		return this.pagedQuery("from MService m where m.available = ?", page, num, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}*/
	
	/**
	 * 获取专业服务列表
	 * SpecDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 */
	public List<MService> listAll() {
		return this.find("from MService m where m.available = ?", new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/**
	 * 获取制定分类下的专业服务
	 * SpecDao.findByCategoryId()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param categoryId
	 * @return
	 */
	public List<MService> findByCategoryId(Integer categoryId) {
		return this.find("from MService m where m.available = ? and m.categoryId = ?", new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE), new Integer(categoryId)});
	}
}
