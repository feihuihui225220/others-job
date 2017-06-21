package com.anticw.aged.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OMessage;
import com.anticw.aged.dao.message.OMessageDao;
import com.anticw.aged.dao.utils.Page;

@Service
public class OMessageService {

	@Autowired
	private OMessageDao oMessageDao;
	//分页查新
	public Page<OMessage> list(int page,int num){
		return oMessageDao.list(page, num);
	}
	//插入信息
	public void insertOMessage(OMessage oMessage){
		oMessageDao.insertMessage(oMessage);
	}
	//通过id查找信息
	public OMessage findMessageById(Integer id){
		return oMessageDao.findMessageById(id);
	}
	//通过电话号查找信息
	public List<OMessage> findMessageByPhone(String phone){
		return oMessageDao.findMessageByPhone(phone);
	}
	//通过来源查找信息
	public List<OMessage> findMessageByComeFrom(Integer comefrom){
		return oMessageDao.findMessageByComeFrom(comefrom);
	}
	//修改信息
	public void editMessage(OMessage oMessage){
		oMessageDao.editMessage(oMessage);
	}
	//删除信息
	public void deleteMessageById(Integer id){
		oMessageDao.deleteMessageById(id);
	}
}
