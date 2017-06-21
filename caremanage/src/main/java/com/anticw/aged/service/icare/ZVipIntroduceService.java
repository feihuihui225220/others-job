package com.anticw.aged.service.icare;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticw.aged.bean.ZVipIntroduce;
import com.anticw.aged.dao.icare.ZVipIntroduceDao;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZVipIntroduceService {
	@Autowired
	private ZVipIntroduceDao zVipIntroduceDao;
	/**
	 * 添加
	 */
	public void add(ZVipIntroduce z){
		zVipIntroduceDao.add(z);
	}
	/**
	 * 删除
	 */
	public void delete(Integer id){
		zVipIntroduceDao.delete(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZVipIntroduce z){
		zVipIntroduceDao.update(z);
	}

	/**
	 * 查询一条
	 */
	public ZVipIntroduce getById(Integer id){
		return zVipIntroduceDao.get(id);
	}
	/**
	 * 查询所有
	 */
	public List<ZVipIntroduce> getList() {
		return zVipIntroduceDao.getList();
	}
	
	
}
