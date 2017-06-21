package com.anticw.aged.service.assess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MUserIntervene;
import com.anticw.aged.dao.professional.assess.MUserInterveneDao;
/**
 * 
 * @author DX-2016/11/19
 *
 */
@Service
public class MUserInterveneService {

	@Autowired
	private MUserInterveneDao mUserInterveneDao;
	
	public List<MUserIntervene> getList(Long userId){
		return mUserInterveneDao.getList(userId);
	}
}
