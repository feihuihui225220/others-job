package com.anticw.aged.dao.professional.vender;


import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.dao.utils.Page;
/**
 * 
 * @author dx  2016/3/4  服务商站点
 *
 */
@Component
public class MVenderSiteDao extends HibernateEntityDao<MVenderSite>  {
	
	public List<MVenderSite> fingByVenderId(int venderId){
		String hql="from MVenderSite m where m.venderId=?";
		return super.find(hql, venderId);
	}
	public List<MVenderSite> fingByIds(String Ids){
		String hql="from MVenderSite m where m.id in("+Ids+")";
		return super.find(hql);
	}
	/*public com.anticw.aged.dao.utils.Page<Object> pageByVenderId(int venderId,PageParamVO pageVO){
		String hql="from MVenderSite m where m.venderId=?";//(hql, pageVO.getPage(), pageVO.getNum(), venderId);
		return super.pagedQuery(hql,pageVO.getPage(),pageVO.getNum(),venderId);
	}*/
	
	public List<MVenderSite> fingByNames(String names){
		String hql="from MVenderSite m where m.siteName like '%"+names+"%'";
		return super.find(hql);
	}
	
	/**
	 * 根据社区Id获取对应的站点
	 * @param commitId
	 * @return
	 */
	public List<String> fingByCommity(Integer commitId){
		String hql="select m.id from MVenderSite m where m.communityIds like '%"+commitId+"%'";
		return super.find(hql);
	}
	
	/**
	 * 分页查询
	 * @param venderId
	 * @param page
	 * @return
	 */
	public Page<MVenderSite> getPage(int venderId,PageParamVO page,MVenderSite m,DateParamVO date){
		String hql="from MVenderSite m where m.venderId=?";
		if(m!=null&&m.getSiteName()!=null&&m.getSiteName().trim()!=""){
			hql+="  and siteName like '%"+m.getSiteName()+"%' ";
		}
		if(date!=null&&date.getStart()!=null&&date.getEnd()!=null){
			hql+="  and createdAt between  '"+DateUtil.getCurrentFormatDate(date.getStart())+"' and '"+DateUtil.getCurrentFormatDate(date.getStart())+"' ";
		}
		return this.pagedQuery(hql, page.getPage(), page.getNum(), venderId);
	}
	
}
