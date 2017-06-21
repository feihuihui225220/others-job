package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZAutoreply;
import com.anticw.aged.dao.icare.vip.WXAutoreplyDao;

/**
 * 作者：bsd
 * 日期：2016-11-27
 * 功能：微信自动回复
 */
@Service
public class WXAutoreplyService {
	
	@Autowired
	private WXAutoreplyDao wxAutoreplyDao;
	
	/**
	 * 查询自动回复内容
	 *@param id
	 *@return
	 */
	public ZAutoreply getAutoreplyById(int id){
		return wxAutoreplyDao.get(id);
	}
	/**
	 * 添加自动回复内容
	 *@param autoreply
	 *@return
	 */
	public Integer addAutoreply(ZAutoreply autoreply){
		autoreply.setCreateTime(new Date());
		autoreply.setAvailable(true);
		return (Integer) wxAutoreplyDao.save(autoreply);
	}
	/**
	 * 删除自动回复的内容
	 *@param ZAutoreply
	 *@return
	 */
	public void removeAutoreply(Integer id){
		wxAutoreplyDao.removeById(id);
	}
	/**
	 * 修改自动回复内容
	 *@param ZAutoreply
	 */
	public void modifyAutoreply(ZAutoreply autoreply){
		wxAutoreplyDao.update(autoreply);
	}
}
