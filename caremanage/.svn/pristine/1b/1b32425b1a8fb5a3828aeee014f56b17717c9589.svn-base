package com.anticw.aged.service.director;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HRoundsRecord;
import com.anticw.aged.dao.director.RoundsRecordDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.RoundsVO;

/**
 * 作者：bsd
 * 日期：2016-9-16
 * 功能：TODO	
 */
@Service
public class RoundsRecordService {
	@Autowired
	private RoundsRecordDao roundsRecordDao;
	
	public int addRoundsRecord(HRoundsRecord roundsRecord){
		roundsRecord.setCreateTime(new Date());
		roundsRecord.setChangeTime(new Date());
		return roundsRecordDao.addRoundsRecord(roundsRecord);
	}
	
	public List<Object> findRoundsRecordAll(Long userId,Integer esc){
		return roundsRecordDao.findRoundsRecordAll(userId,esc);
	}
	public HRoundsRecord findRoundsRecordById(int id){
		return roundsRecordDao.get(id);
	}
	//物理删除知识库
	public void delRoundsRecordById(int id) {
		roundsRecordDao.delRoundsRecordBy(id);
	}

	// 物理删除知识库
	public void delRoundsRecordBy(int id) {
		roundsRecordDao.delRoundsRecordById(id);
	}

	//条件查询
	public Page<HRoundsRecord> listRound(PageParamVO page, String startTime,
			String endTime, Integer esc, Long userId) {
		
		if(("").equals(startTime)){
			startTime=null;
		}
		if(("").equals(endTime)){
			endTime=null;
		}
		if(esc==null){
			esc=0;
		}
		if(("").equals(userId)){
			userId=null;
		}
		return roundsRecordDao.listHTransfer(page,startTime,endTime,esc,userId);
	}
   
	//统计
	public List<RoundsVO> countRound() {		
		return roundsRecordDao.countRound();
	}
    //求和
	public Long sumRound() {
		return roundsRecordDao.sumRound();
	}
	
}
