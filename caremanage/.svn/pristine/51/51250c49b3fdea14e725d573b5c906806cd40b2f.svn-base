package com.anticw.aged.service.director;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HVisitPlan;
import com.anticw.aged.dao.director.VisitPlanDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.admin.CategoryRoundsServicec;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.user.RUserVO;

@Service
public class VisitPlanService {
	@Autowired
	private VisitPlanDao visitPlanDao;
	@Autowired
	private CategoryRoundsServicec categoryRoundsServicec;

	/**
	 * 根据UserId查询查询所有计划
	 * @param userId
	 * @return
	 */
	public List<HVisitPlan> getHVisitPlanByUserId(Long userId){
			return visitPlanDao.getHVisitPlanByUserId(userId);
	}
	/**
	 * TODO添加计划
	 *@param hVisitPlan
	 *@return
	 */
	public int addHVisitPlan(HVisitPlan hVisitPlan){
		hVisitPlan.setCreateTime(new Date());
		return visitPlanDao.addHVisitPlan(hVisitPlan);
	}
	/**
	 * 根据groupId查询所有计划
	 * @param userId
	 * @return
	 */
	public List<HVisitPlan> getHVisitPlanByGroupId(long groupId){
			return visitPlanDao.getHVisitPlanByGroupId(groupId);
	}
	/**
	 * 查询所有计划
	 * @param userId
	 * @return
	 */
	public Map<Date,String> getHVisitPlan(){
		 List<Object[]> list = visitPlanDao.getHVisitPlan();
		 Map<Date,String> map = new HashMap<Date,String>();
		 for (int i = 0; i < list.size(); i++) {
			 String dateStr = list.get(i)[0]+"-"+list.get(i)[1]+"-"+list.get(i)[2];
			DateUtil.parseStrToDate(dateStr);
			map.put(DateUtil.parseStrToDate(dateStr),list.get(i)[3].toString());
		}
		return map;
	}
	/**
	 * 按日期查询所有计划
	 * @param userId
	 * @return
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 */
	public List<RUserVO> getHVisitPlanByDate(long date) throws IllegalAccessException, Exception{
		List<HVisitPlan> visit = visitPlanDao.getHVisitPlanByDate(date);
		List<RUserVO> list = new ArrayList<>();
		RUserVO rv = null;
		for(HVisitPlan r : visit){
			rv = new RUserVO();
			BeanUtils.copyProperties(rv, r.getUser());
			rv.setVisitTime(r.getVisitTime());
			list.add(rv);
		}
		return list;
	}
	/**
	 * 按日期查询所有计划
	 * @param userId
	 * @return
	 */
	public Page<HVisitPlan> getHVisitPlanByDateAndGroupId(String str,String strs,long groupId,Integer status,PageParamVO paVo){
		return visitPlanDao.getHVisitPlanByDateAndGroupId(str,strs,groupId,status,paVo);
	}
	/**
	 * 查询服务计划详细内容
	 * @param userId
	 * @param date
	 * @return
	 */
	public Map<String,HVisitPlan> getPlanByDateAndUserId(Integer id){
		Map<String,HVisitPlan> map = new HashMap<String,HVisitPlan>();
		HVisitPlan vplist = visitPlanDao.getPlanByDateAndUserId(id);
		 
			String category = vplist.getCode();
			String[] categorys = {};
			String serviceName = "";
			if (category !=null) {
				categorys = category.split(",");
				for (int j = 0; j < categorys.length; j++) {
					serviceName += categoryRoundsServicec.getMPlanCategoryById(Integer.valueOf(categorys[j])).getName()
							+"            ";
				}
			}
			map.put(serviceName, vplist);
		return map;
	}
}
