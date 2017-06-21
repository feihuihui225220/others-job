package com.anticw.aged.service.icare;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.ZAssess;
import com.anticw.aged.dao.icare.ZAssessDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.user.OCategoryItemService;
import com.anticw.aged.vo.icare.ZAssessVO;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class ZAssessService{
	@Autowired
	private ZAssessDao zAssessDao;

	/**
	 * 查询一首评估问卷TODO
	 *@param id
	 *@return
	 */
	public ZAssess getAssessById(int id){
		return this.zAssessDao.get(id);
	}
	/**
	 * 添加问卷类型
	 *@param zAssess
	 *@return
	 */
	public Integer addAssess(ZAssess zAssess){
		zAssess.setCreateTime(new Date());
		zAssess.setChangeTime(new Date());
		zAssess.setAvailable(true);
		return (Integer) this.zAssessDao.save(zAssess);
	}
	/**
	 * 删除评估问卷
	 *@param zAssess
	 *@return
	 */
	public void removeAssess(Integer id){
		 this.zAssessDao.removeById(id);
	}
	/**
	 * 修改评估问卷TODO
	 *@param zAssess
	 */
	public void modifyAssess(ZAssess zAssess){
		zAssess.setChangeTime(new Date());
		this.zAssessDao.update(zAssess);
	}
	/**
	 * 查询所有有效的评估问卷
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<ZAssess> getAssessList(int page, int num) {
		return this.zAssessDao.getAssessList(page, num);
	}
	
	@Autowired
	private OCategoryItemService oCategoryItemService;
	
	public List<ZAssessVO> getList(){
		List<ZAssess> z= zAssessDao.getList();
		List<ZAssessVO> vos=new ArrayList<ZAssessVO>();
		ZAssessVO vo=null;
		OCategoryItem o=null;
		for(ZAssess z1:z){
			vo=new ZAssessVO();
			try {
				BeanUtils.copyProperties(vo, z1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			o=oCategoryItemService.getItemName(z1.getTitle());
			if(o!=null){
				vo.setItemName(o.getItemName());
			}
			vos.add(vo);
		}
		return vos;
	}
	/**
	 * TODO
	 *@param page
	 *@param num
	 *@param parentId
	 *@return
	 *//*
	public Page<ZAssess> getAssessListByCategory(int page, int num,Integer parentId) {
		return this.zAssessDao.getAssessListByCategory( page, num, parentId);
	}*/
	
	
	
	/**
	 * 返回对应的Id
	 * @param title
	 * @return
	 */
	public Integer getZAssess(Integer title){
		return this.zAssessDao.getZAssess(title);
		
	}
}
