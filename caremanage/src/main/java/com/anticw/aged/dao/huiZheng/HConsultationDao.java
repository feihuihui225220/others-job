package com.anticw.aged.dao.huiZheng;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HConsultation;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class HConsultationDao extends HibernateEntityDao<HConsultation> {
	/**
	 *添加
	 * @param maFitness
	 */
	public void insertTreat(HConsultation hConsultation) {
		super.save(hConsultation);
	}
	/**
	 *查询列表
	 * @param maFitness
	 */
	public List<HConsultation> listResult(Long userId) {
		String hql = "from HConsultation where user_id="+userId+ "order by id desc";
		List<HConsultation> result  = super.find(hql);
		return result;
	}
	/**
	 *删除
	 * @param maFitness
	 */
	public void delete(Integer resultId) {
		super.removeById(resultId);
	}
	/**
	 *编辑
	 * @param maFitness
	 */
	public void edit(HConsultation hConsultation){
		HConsultation nap =findOneAvailData(hConsultation.getId());
		nap.setContent(hConsultation.getContent());
		nap.setStartTime(hConsultation.getStartTime());
		nap.setEndTime(hConsultation.getEndTime());
		nap.setState(hConsultation.getState());
		nap.setGroupId(hConsultation.getGroupId());
		super.update(nap);
}
	/**
	 *查询一条
	 * @param maFitness
	 */
	public HConsultation findOneAvailData(int id){
		return super.get(id);
	}
	
	public HConsultation findById(Integer resultId) {
		String hql = "from HConsultation where id="+resultId;
		List<HConsultation> result  = super.find(hql);
		
		if(result.size()!=0){
			return result.get(0);
		}
		return null;
	}
	/**
	 * 巡诊组首页展示当日有关会诊信息
	 * @param date
	 * @param groupId
	 * @return
	 */
	public List<HConsultation> getHConsultationByDateAndGroupId(Date date,long groupId){
		DateParamVO dateCond=DateUtil.getDate(date);
		try {
			List<HConsultation> planList = super.find("SELECT a FROM HConsultation as a, RUser as b " +
					"where a.user.id=b.id and a.applyTime BETWEEN  ? and ? and a.groupId=? AND a.state=? order by a.applyTime",dateCond.getStart(),dateCond.getEnd(),(int)groupId,"1");
			return planList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 会诊管理展示会诊信息
	 * @param dateCond
	 * @param groupId
	 * @param statas
	 * @param desc
	 * @param page
	 * @return
	 */
	public Page<HConsultation> pageHConsultation(DateParamVO dateCond,long groupId,Integer statas,Integer desc,PageParamVO page){
		String hql="SELECT a FROM HConsultation as a, RUser as b " +
					"where a.user.id=b.id and a.createTime BETWEEN  ? and ? ";
		if(statas!=null){
			hql+=" and a.state="+statas;
		}else{
			hql+=" and a.state in(0,1,2)";
		}
		if(desc!=null&&desc==1){
			hql+="  order by a.createTime";
		}else{
			hql+="  order by a.createTime DESC";
		}
	
		try {
			return super.pagedQuery(hql, page.getPage(), page.getNum(), dateCond.getStart(),dateCond.getEnd());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 分页查看用户会诊信息
	 * @param userId
	 * @param page
	 * @return
	 */
	public Page<HConsultation> listResult(Long userId,PageParamVO page,DateParamVO dateCond,Integer desc){
		String hql = "from HConsultation where user_id="+userId+ " and createTime BETWEEN  ? and ? ";
		if(desc!=null&&desc==1){
			hql+="  order by applyTime";
		}else{
			hql+="  order by applyTime DESC";
		}
		Page<HConsultation> result  = super.pagedQuery(hql, page.getPage(), page.getNum(), dateCond.getStart(),dateCond.getEnd());
		return result;
	}
	/**
	 * 修改用户信息
	 */
	public void modifyHConsultation(HConsultation consultation){
		super.update(consultation);
	}
	/**
	 * 会诊统计
	 * @return 
	 */
	public List<HConsultation> countConsultation() {
		//String hql="SELECT count(h.id) ,h.id, g.userName FROM HConsultation h,HGroup g where h.groupId=g.id GROUP BY h.groupId";
		String  hql = "select count(h.id),g.userName from HConsultation h,HGroup g where h.groupId= g.userId group by h.groupId";
		return super.find(hql);
		
	}
	public Long sumConsul() {
		String hql=" from HConsultation";
		return super.getCount(hql);
	}
}
