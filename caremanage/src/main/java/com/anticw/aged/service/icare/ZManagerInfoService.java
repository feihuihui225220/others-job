package com.anticw.aged.service.icare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.dao.icare.ZManagerInfoDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZManagerInfoService{
	@Autowired
	private ZManagerInfoDao zManagerInfoDao;
	/**
	 * 添加
	 */
	public void add(ZManagerInfo zManagerInfo){
		zManagerInfoDao.add(zManagerInfo);
	}
	/**
	 * 删除
	 */
	public void delete(Integer id){
		zManagerInfoDao.delete(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZManagerInfo zManagerInfo){
		zManagerInfoDao.update(zManagerInfo);
	}

	/**
	 * 查询一条
	 */
	public ZManagerInfo getById(Integer id) {
		return zManagerInfoDao.getById(id);
	}
	/**
	 * 查询所有(后台、微信端)
	 */
	public Page<ZManagerInfo> getList(PageParamVO page) {
	    return zManagerInfoDao.getList(page);
	}
	
	public List<ZManagerInfo> getLists() {		
		return zManagerInfoDao.getLists();
	}
	
	
}
