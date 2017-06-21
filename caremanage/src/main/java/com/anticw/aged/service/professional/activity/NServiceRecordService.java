package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NServiceRecord;
import com.anticw.aged.dao.professional.activity.NServiceRecordDao;

@Service
public class NServiceRecordService {
	@Autowired
	private NServiceRecordDao nServiceRecordDao;
	/**
	 * 添加服务记录
	 * @param nServiceRecord
	 */
	public void addNServiceRecord(NServiceRecord nServiceRecord){
		nServiceRecordDao.addNServiceRecord(nServiceRecord);
	}
	/**
	 * 查询同一个节目下的所有服务记录
	 * @param activityId
	 * @return
	 */
	public List<NServiceRecord> findListNServiceRecord(int activityId){
		return nServiceRecordDao.findListNServiceRecord(activityId);
	}
	/**
	 * 删除记录
	 * @param id
	 */
	public void deleteNServiceRecord(int id){
		nServiceRecordDao.deleteNServiceRecord(id);
	}
	/**
	 * 根据id查询一个记录
	 * @param id
	 * @return
	 */
	public NServiceRecord findNServiceRecord(int id){
		return nServiceRecordDao.findNServiceRecord(id);
	}
}
