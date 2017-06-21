package com.anticw.aged.dao.professional.assess;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MUserIntervene;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @author DX-2011/11/01
 *
 */
@Component
public class MUserInterveneDao extends HibernateEntityDao<MUserIntervene>{

	public void save(MUserIntervene r){
		super.save(r);
		super.currentSession().flush();
		super.currentSession().clear();
	}
	/**
	 * 获取个人展示数据
	 * @param userId
	 * @return
	 */
	public List<MUserIntervene> getList(Long userId){
		String sql="select m.`intervene_go`,m.`intervene_la`,m.`test_category`  from m_user_intervene m where user_id="+userId+" group by user_id";
		List<Object[]> list=super.findBySQLQuery(sql);
		Iterator<Object[]> iter= list.iterator();
		List<MUserIntervene> mu=new ArrayList<MUserIntervene>();
		MUserIntervene m=null;
		while(iter.hasNext()){
			m=new MUserIntervene();
			Object[] o=iter.next();
			m.setInterveneGo((Double)o[0]);
			m.setInterveneLa((Double)o[1]);
			m.setPacketTypes((Integer)o[2]);
			mu.add(m);
		}
		return mu;
	}
}
