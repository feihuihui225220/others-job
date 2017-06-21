package com.anticw.aged.dao.icare.combo;

import java.util.List;
/**
 * 
 * @author DX-2016/12/15
 *
 */

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZFitness;
import com.anticw.aged.dao.utils.HibernateEntityDao;

@Component
public class ZFitnessDao extends HibernateEntityDao<ZFitness> {

	/**
	 * 获取所有分类
	 * 
	 * @return
	 */
	public List<ZFitness> getList() {
		String hql = "from ZFitness where available=1 and parentId=0";
		return super.find(hql);
	}

	/**
	 * 获取所有分类下内容
	 * 
	 * @param id
	 * @return
	 */
	public List<ZFitness> getChildList(int id) {
		String hql = "from ZFitness where available=1 and parentId=?";
		return super.find(hql, id);
	}

}
