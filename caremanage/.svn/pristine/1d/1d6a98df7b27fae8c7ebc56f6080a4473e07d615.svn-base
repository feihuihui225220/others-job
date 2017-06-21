package com.anticw.aged.service.professional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MServiceShowtype;
import com.anticw.aged.dao.professional.service.SpecShowTypeDao;
/**
 * 专业服务展示类别持
 * @author L
 *
 */
@Service
public class SpecShowTypeService {
	
	@Autowired
	private SpecShowTypeDao spectypeDao;
	/**
	 * 添加展示分类
	 * @param serviceShowtype
	 */
	public void save(MServiceShowtype serviceShowtype){
		spectypeDao.save(serviceShowtype);
	}
	/**
	 * 查询所有分类
	 * @return
	 */
	public List<MServiceShowtype> list(){
		return spectypeDao.loadAll();
	}

}
