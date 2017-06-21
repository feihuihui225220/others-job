package com.anticw.aged.service.icare;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZBanner;
import com.anticw.aged.dao.icare.ZBannerDao;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZBannerService {
	@Autowired
	private ZBannerDao zBannerDao;
	/**
	 * 查询所有
	 */
	public List<ZBanner> getBannerList() {
		return zBannerDao.selectAll();
	}
	/**
	 * 添加
	 */
	public void addBanner(ZBanner zBanner){
		zBannerDao.addBanner(zBanner);
	}
	/**
	 * 删除
	 */
	public void deleteById(int id){
		zBannerDao.deleteById(id);
	}
	/**
	 * 修改
	 */
	public void modifyBanner(ZBanner z){
		zBannerDao.modifyBanner(z);
	}

	/**
	 * 查询一条
	 */
	public ZBanner getBannerById(int id){
		return zBannerDao.get(id);
	}
	
	
}
