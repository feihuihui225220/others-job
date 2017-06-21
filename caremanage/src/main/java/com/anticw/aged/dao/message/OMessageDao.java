package com.anticw.aged.dao.message;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.OMessage;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

@Component
public class OMessageDao extends HibernateEntityDao<OMessage>{

	/*
	 * 查询表
	 */
	public Page<OMessage> list(int page,int num){
		return super.pagedQuery(page, num);
	}
	
	/*
	 * 添加信息
	 */
	public void insertMessage(OMessage oMessage){
		super.save(oMessage);
		
	}
	/*
	 * 按id查询信息
	 */
	public OMessage findMessageById(Integer id){
		return super.get(id);
	}
	/*
	 * 按手机号查询信息
	 */
	public List<OMessage> findMessageByPhone(String phone){
		return super.find("from OMessage where phone=?",phone);
	}  
	/*
	 * 按来源查询信息
	 */
	public List<OMessage> findMessageByComeFrom(Integer comefrom){
		return super.find("from OMessage where comeFrom=?",comefrom);
		
	}
	/*
	 * 编辑信息
	 */
	public void editMessage(OMessage oMessage){
		OMessage Message=findMessageById(oMessage.getId());
		Message.setComeFrom(oMessage.getComeFrom());
		Message.setContent(oMessage.getContent());
		Message.setCreatedTime(oMessage.getCreatedTime());
		Message.setPhone(oMessage.getPhone());
		Message.setId(oMessage.getId());
		super.update(Message);
		
	}
	/*
	 * 物理删除信息
	 */
	public void deleteMessageById(Integer id){
		super.removeById(id);
		
	}
	/*
	 * 逻辑删除信息
	 */
	public String editMessageById(){
		return "删除成功!!!!";
	}
}
