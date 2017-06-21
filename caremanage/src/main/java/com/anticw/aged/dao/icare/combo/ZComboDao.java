package com.anticw.aged.dao.icare.combo;


import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZCombo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
/**
 * 
 * @author dx 2016/12/10
 * <p>管家套餐维护</p>
 *
 */
@Component
public class ZComboDao extends HibernateEntityDao<ZCombo>{
	/**
	 * 返回分页数据
	 * @param pageVO
	 * @param zName
	 * @param dateVO
	 * @return
	 */
	public Page<ZCombo> getPage(PageParamVO pageVO,String zName,DateParamVO dateVO){
		String hql="from ZCombo  where available=? and createAt between ? and ?";
		if(zName!=null&&!zName.replaceAll("\\s+","").equals("")){
			hql+=" and comboName  LIKE '%"+zName+"%'";
		}
		return super.pagedQuery(hql, pageVO.getPage(), pageVO.getNum(), PropertyValueConstants.AVAILABLE,dateVO.getStart(),dateVO.getEnd());
	}
	/**
	 * 更新数据
	 * @param z
	 */
	public void updateZCombo(ZCombo z){
		z.setVersion((short) (z.getVersion()+1));
		super.update(z);
	}
	/**
	 * 删除
	 * @param z
	 */
	public void remover(ZCombo z){
		 z.setAvailable(false);
		 super.update(z);
	}
	
	public List<ZCombo>  getZComboAll(){
		String hql="from ZCombo  where available=? ";
		return super.find(hql,PropertyValueConstants.AVAILABLE);
	}
	
	
	
}
