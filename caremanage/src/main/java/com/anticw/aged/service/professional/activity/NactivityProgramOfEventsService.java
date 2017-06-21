package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.anticw.aged.bean.NactivityProgramOfEvents;
import com.anticw.aged.dao.professional.activity.NactivityProgramOfEventsDao;
/**
 * 
 * @author dx  2016/3/2
 *
 */
@org.springframework.stereotype.Service
public class NactivityProgramOfEventsService {

	@Autowired
	private NactivityProgramOfEventsDao nactivityProgramOfEventsDao;
	
	public void saveNactivityProgramOfEvents(NactivityProgramOfEvents n){
		nactivityProgramOfEventsDao.save(n);
	}
	
	public List<NactivityProgramOfEvents>  getList(int planId){
		return nactivityProgramOfEventsDao.getList(planId);
	}
	
	public void remove(long id){
		nactivityProgramOfEventsDao.removeById(id);
	}
	
	/*public Page<NactivityProgramOfEvents> getPage(PageParamVO page,int teacherId){
		Page<NactivityProgramOfEvents>  pages=nactivityProgramOfEventsDao.getPage(teacherId, page.getPage(), page.getNum());
		return null;
	}*/
}
