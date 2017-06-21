package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NServiceRecord;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
/**
 * 
 * @author dx 2015/10/08
 *
 */
@Repository
public class NServiceRecordDao extends HibernateEntityDao<NServiceRecord>{
	/**
	 * 添加服务记录
	 * @param nServiceRecord
	 */
	public void addNServiceRecord(NServiceRecord nServiceRecord){
		super.save(nServiceRecord);
	}
	/**
	 * 查询当前节目下所有的服务记录报告(有效的)
	 * @return
	 */
	public List<NServiceRecord> findListNServiceRecord(int activityId){
		String hql="from NServiceRecord n where activityId=? and avaliable=?";
		return super.find(hql,activityId,PropertyValueConstants.AVAILABLE);
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteNServiceRecord(int id){
		super.removeById(id);
	}
	/**
	 * 根据id查询一个记录
	 * @param id
	 * @return
	 */
	public NServiceRecord findNServiceRecord(int id){
		String hql="from NServiceRecord n where id=? and avaliable=?";
		List<NServiceRecord> nServiceRecord=super.find(hql,id,PropertyValueConstants.AVAILABLE);
		return nServiceRecord.get(0);
	}
}
