package com.anticw.aged.service.director;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HGroup;
import com.anticw.aged.dao.director.GroupDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-9-16
 * 功能：TODO	
 */
@Service
public class GroupService {
	@Autowired
	private GroupDao groupDao;
	
	public int addGroup(HGroup hGroup){
		hGroup.setAvailable(true);
		hGroup.setCreateTime(new Date());
		hGroup.setChangeTime(new Date());
		return groupDao.addGroup(hGroup);
	}
	
	public void editGroup(HGroup hGroup){
		HGroup oldGRoup = this.findGroupById(hGroup.getId());
		oldGRoup.setDoctor(hGroup.getDoctor());
		oldGRoup.setNurse(hGroup.getNurse());
		oldGRoup.setCommunity(hGroup.getCommunity());
		oldGRoup.setChangeTime(new Date());
		oldGRoup.setUserName(hGroup.getUserName());
		groupDao.editGroup(oldGRoup);
	}
	
	public Page<HGroup> findGroupAll(PageParamVO page){
		return groupDao.findGroupAll(page);
	}
	public HGroup findGroupById(int id){
		return groupDao.get(id);
	}
	//物理删除知识库
	public void delGroupById(int id) {
		groupDao.delGroupBy(id);
	}

	// 物理删除知识库
	public void delGroupBy(int id) {
		groupDao.delGroupById(id);
	}
	//根据id查询巡诊组名称
	public List<HGroup> findByUserId(Integer userid) {
		return groupDao.findByUserId(userid);
	}
	
}
