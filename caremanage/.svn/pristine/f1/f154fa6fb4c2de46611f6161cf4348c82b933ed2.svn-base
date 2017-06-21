package com.anticw.aged.service.icare;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZNotice;
import com.anticw.aged.dao.icare.ZNoticeDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZNoticeService{
	@Autowired
	private ZNoticeDao zNoticeDao;
	
	/**
	 * 添加
	 * @return 
	 */
	public void add(ZNotice zNotice){
		zNoticeDao.save(zNotice);
	}
	/**
	 * 删除
	 */
	public void delete(Integer id){
		zNoticeDao.delete(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZNotice zNotice){
		zNoticeDao.update(zNotice);
	}

	/**
	 * 查询一条
	 */
	public ZNotice getById(Integer id){
		return zNoticeDao.get(id);
	}
	/**
	 * 查询所有
	 */
	public Page<ZNotice> getList(PageParamVO page,String userContact,Integer type,
			String startTime,String endTime) {
		if(("").equals(startTime)){
			startTime=null;
		}
		if(("").equals(endTime)){
			endTime=null;
		}
		return zNoticeDao.getList(page, userContact,type,startTime,endTime);
	}
	
	//微信查询
	public List<ZNotice> getLists(String openId) {
		
		return zNoticeDao.getLists(openId);
	}
	
	//微信添加
	public void adds(String openId, String content) {
		ZNotice zNotice= new ZNotice();
		zNotice.setUserContact(openId);
		zNotice.setContent(content);
		zNotice.setType(1);
		zNotice.setAvailable(true);
		Date date= new Date();
		zNotice.setCreateTime(date);
		zNoticeDao.save(zNotice);		
	}
	
}
