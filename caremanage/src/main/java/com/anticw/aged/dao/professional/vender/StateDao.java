package com.anticw.aged.dao.professional.vender;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MStateCategory;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;

/**
 * 状态分类持久化对象
 * <P>File name : StateDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Repository
public class StateDao extends HibernateEntityDao<MStateCategory> {

	/**
	 * 获取全部状态信息
	 * StateDao.findAll()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @return
	 */
	public List<MStateCategory> findAll() {
		return this.find("from MStateCategory m where m.available = ?", new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
}
