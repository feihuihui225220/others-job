package com.anticw.aged.service.icare;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZFeedback;
import com.anticw.aged.dao.icare.ZFeedbackDao;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZFeedBackService extends HibernateEntityDao<ZFeedback> {
	@Autowired
	private ZFeedbackDao zFeedbackDao;
	/**
	 * 查询
	 *@param id
	 *@return
	 */
	public ZFeedback getFeedbackById(int id){
		return super.get(id);
	}
	
	/**
	 * 查询
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<ZFeedback> getFeedbackList(PageParamVO page,String userContact,
			String startTime,String endTime) {
		if(("").equals(startTime)){
			startTime=null;
		}
		if(("").equals(endTime)){
			endTime=null;
		}
		return zFeedbackDao.getFeedbackList(page,userContact,startTime,endTime);
	}
	/**
	 * 添加
	 *@param careFeedback
	 *@return
	 */
	public void addFeedback(ZFeedback zFeedback){
		zFeedback.setCreateTime(new Date());
		zFeedback.setAvailable(true);
		zFeedbackDao.save(zFeedback);
	}
	/**
	 * 删除
	 *@param careFeedback
	 *@return
	 */
	public void delete(Integer id){
		zFeedbackDao.delete(id);
	}
	/**
	 * 编辑
	 *@param careFeedback
	 *@return
	 */
	public void modifyFeedback(ZFeedback zFeedback){
//		zFeedback.setResponseTime(new Date());
		super.update(zFeedback);
	}
	
	//微信添加
	public void addFeedbacks(String contact, String content) {
		ZFeedback zFeedback = new ZFeedback();
		zFeedback.setContent(content);
		zFeedback.setUserContact(contact);
		zFeedback.setStatus(2);
		zFeedback.setAvailable(true);
		Date createTime = new Date();
		zFeedback.setCreateTime(createTime);
		zFeedbackDao.save(zFeedback);
	}

}
