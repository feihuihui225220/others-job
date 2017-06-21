package com.anticw.aged.dao.icare.fenpeiCM;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;
@Component
public class fenpeiCMDao extends HibernateEntityDao<ZManagerInfo>{

	/**
	 * 查询所有的cm信息
	 * @param vo
	 * @param name
	 * @return
	 */
	public Page<ZManagerInfo> listAllZManagerInfo(PageParamVO vo,String name){
		String hql="from ZManagerInfo where available=?";
		if(name!=null){
			hql+="name like '%"+name+"%'";
		}
		return super.pagedQuery(hql,vo.getPage(), vo.getPageSize(),PropertyValueConstants.AVAILABLE);
	}
}
