package com.anticw.aged.dao.icare.combo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZCourse;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.vo.common.DateParamVO;
@Component
public class ZCourseDao extends HibernateEntityDao<ZCourse>{


	public List<ZCourse> getTimeList(DateParamVO vo,Long userId){
		String hql="from ZCourse where customAt between ? and ? and available=? and userId=?";
		return super.find(hql, vo.getStart(),vo.getEnd(),PropertyValueConstants.AVAILABLE,userId);
	}
}
