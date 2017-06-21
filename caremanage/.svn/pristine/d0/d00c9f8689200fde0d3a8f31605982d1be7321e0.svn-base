/**
 * 
 */
package com.anticw.aged.service.community.country;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.dao.community.country.OCountryDao;

/**
 * @author ltw
 * 
 */
@Service
@Component
public class OCountryService {
	@Autowired
	private OCountryDao oCountryDao;

	/**
	 * 根据countryId删除此省份及其关联信息
	 * 
	 * @param id
	 */
	public void deleteById(Serializable id) {
		oCountryDao.removeById(id);
	}

	/**
	 * 根据countryID 获取省份信息
	 * 
	 * @param id
	 * @return
	 */
	public OCountry getCountryById(Serializable id) {
		OCountry oCountry = oCountryDao.getCountryById(id);
		return oCountry;
	}

	/**
	 * 保存省份信息
	 * 
	 * @param id
	 * @return
	 */
	public void saveOrUpdate(OCountry oCountry) {
		oCountryDao.saveOrUpdate(oCountry);
	}

	/**
	 * 根据type获取列表（类型:0:全国 1:省 2;市 3:区 4:街道 5:社区）
	 * 
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountryByType(Serializable id) {

		return oCountryDao.getCountryByType(id);
	}
	/**
	 * 根据社区Id列表获取社区列表（社区ID逗号分割）
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountryByIds(String ids) {
		List<OCountry> result=new ArrayList<OCountry>();
		if(ids==null||"".equals(ids)){
			return result;
		}
		return oCountryDao.getCountryByIds(ids);
	}
 
	/**
	 * 根据社区子社区ID获取父类信息
	 * @param id
	 * @return
	 */
	public List<OCountry> getParentByIds(String ids) {
		List<OCountry> result=new ArrayList<OCountry>();
		if(ids==null||"".equals(ids)){
			return result;
		}
		 return oCountryDao.getParentByIds(ids);
	}
	public List<OCountry> getParentById(String ids) {
		List<OCountry> result=new ArrayList<OCountry>();
		if(ids==null||"".equals(ids)){
			return result;
		}
		return oCountryDao.getParentById(ids);
	}
 
	
	/**
	 * 根据用户社区ID查询此用户所在社区的街道信息
	 * @author guoyongxiang
	 * Date: 2014-10-14 下午6:31:55
	 * @param id
	 * @return
	 */
	public List<OCountry> getCountrysByPid(Serializable pid){
		return this.oCountryDao.getCountrysByPid(pid);
	}
	/**
	 * 根据用户社区ID查询此用户某区下未注册的街道
	 * @param id
	 * @return
	 */
	public List<OCountry> getNotInParentByIds(String parentId, String ids){
		return oCountryDao.getNotInParentByIds(parentId, ids) ;
	}
	/**
	 * 根据用户communityids返回Map<社区id，社区名称>
	 * @param Ids
	 * @return
	 */
	public Map<String,String> getCountryMapByIds(String Ids){
		Map<String,String> countryMap = new HashMap<String,String>();
		String[] idsArr = Ids.split(",");
		if(idsArr!=null){
			for(String id:idsArr){
				OCountry country = this.getCountryById(Integer.parseInt(id));
				if(country!=null){
					countryMap.put(id, country.getName());
				}
			}
			
		}
		return countryMap;
	}
	
	public List<OCountry> getCountryAll(){
		return oCountryDao.getCountryAll();
	}
	public OCountry getOCountry(int id){
		return oCountryDao.getOCountry(id);
	}
	/**
	 * 获取志愿者对应的社区
	 * @return
	 */
	public List<OCountry> getCounNVolunteer(){
		return oCountryDao.getCounNVolunteer();
	}
}
