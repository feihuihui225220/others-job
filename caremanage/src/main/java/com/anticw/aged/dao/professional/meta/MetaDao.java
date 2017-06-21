package com.anticw.aged.dao.professional.meta;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 元服务持久化对象
 * <P>File name : MetaDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Repository
public class MetaDao extends HibernateEntityDao<MMetaService> {

	/**
	 * 获取元服务列表
	 * MetaDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MMetaService> list(int page, int num) {
		return pagedQuery("from MMetaService m where m.available = ?", page, num, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/**
	 * 获取全部元服务数据
	 * MetaDao.listAll()<BR>
	 * <P>Author : zhouyanxin </P>
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 */
	public List<MMetaService> listAll() {
		return super.find("from MMetaService m where m.available = ?", new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/**
	 * 查询指定Id的元服务信息
	 * MetaDao.queryForListByMetaIds()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param metaIds
	 * @return
	 */
	public List<MMetaService> queryForListByMetaIds(String[] metaIds) {
		
		//拼接in查询条件
		StringBuilder sb = new StringBuilder("(");
		for(int i = 0; i < metaIds.length; i++) {
			sb.append(metaIds[i]);
			if(i < metaIds.length - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		//HQL
		String hql = "from MMetaService m where m.available = ? and m.id in " + sb.toString();
		
		//查询数据
		return find(hql, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	/**
	 * 根据Ids获取元服务
	 */
	public MMetaService getMMetaServices(int id){
		
		 List<MMetaService> mMetaService=super.find("from MMetaService m where m.id=?",id);
		 return mMetaService.get(0);
	}
}
