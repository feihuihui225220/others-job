package com.anticw.aged.service.icare.fenpeiCM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.dao.icare.fenpeiCM.fenpeiCMDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Service
public class fenpeiCMService {
	@Autowired
	private fenpeiCMDao cmDao;
	
	public Page<ZManagerInfo> listAllManagerInfo(PageParamVO vo,String name){
		
		return cmDao.listAllZManagerInfo(vo, name);
	}
}
