package com.anticw.aged.service.professional.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NVideo;
import com.anticw.aged.dao.professional.activity.NVideoDao;
/**
 * 
 * @author dx 2016/4/12
 *
 */
@Service
public class NVideoService {
	@Autowired
	private  NVideoDao  nVideoDao;
	/**
	 * 添加视频信息
	 * @param n
	 */
	public void save(NVideo n){
		nVideoDao.save(n);
	}
}
