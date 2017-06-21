package com.anticw.aged.service.professional.vender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MVenderSite;
import com.anticw.aged.dao.professional.vender.MVenderSiteDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
/**
 * 
 * @author dx  2016/3/4
 *
 */
@Service
public class MVenderSiteService {

	@Autowired
	private MVenderSiteDao mVenderSiteDao;
	
	/**
	 * 查询服务商下所有站点
	 * @param venderId
	 * @return
	 */
	public List<MVenderSite> fingByVenderId(int venderId){
		return mVenderSiteDao.fingByVenderId(venderId);
	}
	public List<MVenderSite> fingByNames(String names){
		return mVenderSiteDao.fingByNames(names);
	}
	/*public com.anticw.aged.dao.utils.Page<Object> pageByVenderId(int venderId,PageParamVO pageVO){
		return mVenderSiteDao.pageByVenderId(venderId,pageVO);
	}*/
	public List<MVenderSite> findByIds(String Ids){
		return mVenderSiteDao.fingByIds(Ids);
	}
	public List<String> fingByCommity(Integer communityId ){
		return mVenderSiteDao.fingByCommity(communityId );
	}
	public void save(MVenderSite mVenderSite){
		mVenderSiteDao.save(mVenderSite);
	}
	
	public void update(MVenderSite mVenderSite){
		mVenderSiteDao.update(mVenderSite);
	}
	
	public void delete(long id){
		mVenderSiteDao.removeById(id);
	}
	
	public MVenderSite fingById(long id){
		return mVenderSiteDao.get(id);
	}
	
	public Page<MVenderSite> getPage(int venderId,PageParamVO page,MVenderSite m,DateParamVO date){
		return mVenderSiteDao.getPage(venderId, page, m, date);
	}
}
