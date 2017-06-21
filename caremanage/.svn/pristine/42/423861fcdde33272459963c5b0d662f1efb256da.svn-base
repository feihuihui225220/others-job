package com.anticw.aged.dao.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZProductNorm;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 
 * @author DX-2017/03/06
 *
 */
@Component
public class ZProductNormDao extends HibernateEntityDao<ZProductNorm>{

	/**
	 * 分页查询字段取值范围及对应的说明
	 * @param page
	 * @param moduleId
	 * @param itemId
	 * @return
	 */
	public Page<ZProductNorm>  getPage(PageParamVO page,Integer moduleId,Integer itemId){
		String hql="from ZProductNorm where moduleId=? and itemId=? and available=?";
		return super.pagedQuery(hql, page.getPage(), page.getNum(), moduleId,itemId,PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 获取智能设备下所有字段对应的正常值
	 * @param moduleId
	 * @return
	 */
	public List<ZProductNorm> getZProductNorm(Integer moduleId){
		String hql="from ZProductNorm where moduleId=?  and available=?";
		return super.find(hql, moduleId,PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 获取某一字段下对应的正常范围值
	 * @param itemId
	 * @return
	 */
	public List<ZProductNorm> getZProductNormItemId(Integer itemId){
		String hql="from ZProductNorm where moduleId=?  and available=?";
		return super.find(hql, itemId,PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 获取公共警报变量{目前有用 m_pressure}
	 * @return
	 */
	public List<Object[]>  getPressure(String tableName){
		String sql="select m_data_module_item.`item_name`,z_product_norm.`minimum`,z_product_norm.`ceiling`,m_meta_service.id  from m_data_module,z_product_norm,m_data_module_item,m_meta_service where m_data_module.`table_name`='"+tableName+"' and m_data_module.`available`=1 and z_product_norm.`module_id`=m_data_module.id and z_product_norm.`available`=1 and m_data_module_item.id=z_product_norm.`item_id`  and m_meta_service.data_module_id=m_data_module.id";
		return super.findBySQLQuery(sql);
	}
}
