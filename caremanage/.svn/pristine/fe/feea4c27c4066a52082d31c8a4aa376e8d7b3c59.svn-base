package com.anticw.aged.service.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.ZCourse;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.icare.combo.ZCourseDao;
import com.anticw.aged.dao.professional.activity.NProgramDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.icare.ZCourserVO;
import com.anticw.aged.vo.permission.UserVO;

@Service
public class ZCourseService {

	@Autowired
	private ZCourseDao zCourseDao;
	
	@Autowired
	private NProgramDao nProgramDao;
	public List<ZCourserVO> getDate(Date s,Long userId) throws IllegalAccessException, InvocationTargetException{
		DateParamVO vo=DateUtil.getOneDay(s);
		List<ZCourse> z=zCourseDao.getTimeList(vo,userId);
		ZCourserVO vo1;
		NProgram n;
		List<ZCourserVO> vos=new ArrayList<ZCourserVO>();
		for(ZCourse z1:z){
			vo1=new ZCourserVO();
			BeanUtils.copyProperties(vo1, z1);
			n=nProgramDao.get(z1.getProgramId());
			if(n!=null&&n.getPageView()!=null){
				vo1.setPageView(n.getPageView());
			}if(n!=null&&n.getThumbs()!=null){
				if(!n.getThumbs().split(",")[0].equals("")){
					vo1.setThumbs(n.getThumbs().split(",").length+"");
				}else{
					vo1.setThumbs(0+"");
				}
			}
			if(n!=null&&n.getPrice()!=null){
				vo1.setPrice(n.getPrice());
			}
			if(n!=null&&n.getProgramName()!=null){
			vo1.setProgramName(n.getProgramName());
			}
			if(n!=null&&n.getProgramTime()!=null){
			vo1.setProgramTime(n.getProgramTime());
			}
			if(n!=null&&n.getAviUrl()!=null){
				vo1.setAviUrl(n.getAviUrl());
			}
			if(n!=null&&n.getProgramDesc()!=null){
				vo1.setProgramDesc(n.getProgramDesc());
			}
				vos.add(vo1);
		}
		return vos;
	}
	
	public  List<ZCourserVO> getList(Date s,Long userId){
		List<ZCourserVO> vos=new ArrayList<ZCourserVO>();
		for(int i=0;i<15;i++){
			try {
				vos.addAll(getDate(DateUtil.addDays(s, i), userId));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vos;
	}
	
	public ZCourse getZCourse(Integer id){
		return zCourseDao.get(id);
	}
	
	public void insert(ZCourse z,HttpSession session){
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		Date date=new Date();
		z.setAvailable(true);
		z.setCreateAt(date);
		z.setChangeAt(date);
		z.setChangeBy(userVO.getName());
		z.setCreateBy(userVO.getName());
		zCourseDao.save(z);
	}
	
	/*public void update(ZCourse z,HttpSession session){
		UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
		
	}*/
	
	public void removerById(Integer id){
		ZCourse z=getZCourse(id);
		z.setAvailable(false);
		zCourseDao.save(z);
	}
	
	
}
