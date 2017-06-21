package com.anticw.aged.dao.professional.assess;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MAssessTable;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;

/**
 * 评估量表持久化对象
 * <P>File name : AssessDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
@Repository
public class AssessDao extends HibernateEntityDao<MAssessTable> {

	/**
	 * 获取评估量表信息
	 * AssessDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-1 </P>
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MAssessTable> list(int page, int num) {
		return super.pagedQuery("from MAssessTable m where m.available = ? order by m.createdAt desc", page, num, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/** 
	 * 获取指定类型指定状态的评估量表
	 * @name AssessDao.list()
	 * @author zhoupeipei
	 * @Date 2014-10-20 下午10:02:59
	 * @param status
	 * @param type
	 * @return     
	 */
	public List<MAssessTable> list(boolean status, short type){
		String hql = "from MAssessTable m where m.publishStatus = ? and m.type=? and m.available = ? ";
		return find(hql,new Object[]{status,type,Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	/**
	 * 获取指定评估量表的信息
	 * AssessDao.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-3 </P>
	 * @param page
	 * @param num
	 * @param assessIds
	 * @return
	 */
	public Page<MAssessTable> list(int page, int num, String[] assessIds) {
		String hql = "from MAssessTable m where m.available = ? and m.id in " + getWhereInCond(assessIds) + " order by m.createdAt desc";
		return super.pagedQuery(hql, page, num, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/**
	 * 获取指定ip的评估量表。该方法改为获取指定ip的评估量表列表，分状态以及类型的获取改用list(boolean status,short type)  Amber
	 * AssessDao.getAssesses()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-3 </P>
	 * @param assessIds
	 * @return
	 */
	public List<MAssessTable> getAssesses(String[] assessIds) {
		String hql = "from MAssessTable m where m.available = ? and m.id in " + getWhereInCond(assessIds) + " order by m.createdAt desc";
		return find(hql, new Object[]{Boolean.valueOf(PropertyValueConstants.AVAILABLE)});
	}
	
	/**
	 * 获取指定状态的评估量表集合
	 * AssessDao.getAssessByType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param type
	 * @return
	 */
	public List<MAssessTable> getAssessByType(short type) {
		String hql = "from MAssessTable m where m.type = ? and m.available = ?";
		return find(hql, new Object[]{new Short(type), Boolean.valueOf(ProfessionalConstants.AVAILABLE)});
	}
	
	/**
	 * 获取全部评估量表
	 * AssessDao.getAssessByType()<BR>
	 * <P>Author : getAllAssess </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 */
	public List<MAssessTable> getAllAssess() {
		String hql = "from MAssessTable m where m.available = ? and m.publishStatus = ? and m.type not in(2)";
		return find(hql, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE), Boolean.valueOf(ProfessionalConstants.ASSESS_PUBLISH)});
	}
	public List<MAssessTable> getAllAssessType() {
		String hql = "from MAssessTable m where m.available = ? and m.publishStatus = ? and m.type=2";
		return find(hql, new Object[]{Boolean.valueOf(ProfessionalConstants.AVAILABLE), Boolean.valueOf(ProfessionalConstants.ASSESS_PUBLISH)});
	}
	
	/**
	 * 获取in查询条件
	 * AssessDao.getWhereInCond()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-3 </P>
	 * @param assessIds
	 * @return
	 */
	private String getWhereInCond(String[] assessIds) {
		//拼接in查询条件
		StringBuilder inCond = new StringBuilder("(");
		for(int i = 0; i < assessIds.length; i++) {
			if(!StringUtils.isEmpty(assessIds[i]) && StringUtils.isNumeric(assessIds[i])) {
				inCond.append(assessIds[i]).append(",");
			}
		}
		inCond.append("0)");
		return inCond.toString();
	}
	
	/**
	 * @author DX 
	 * <p>此处为条件查询分页</p>
	 * @param page
	 * @param num
	 * @param itemId
	 * @param name
	 * @return
	 */
	public Page<MAssessTable> list(int page,int num,Integer itemId,String name,DateParamVO daVo) {
		String hql="from MAssessTable m where m.available = ? ";
		if(itemId!=null&&itemId!=-1){
			hql+=" and itemId="+itemId;
		}
		if(name!=null&&!name.isEmpty()){
			hql+=" and name like '%"+name+"%'";
		}
		if(daVo.getStart()==null&&daVo.getEnd()!=null){
			daVo.setStart(DateUtil.parseStrToDate("2012-01-01"));
		}
		if(daVo.getStart()!=null&&daVo.getEnd()==null){
			daVo.setEnd(DateUtil.addDays(new Date(), 1));
		}
		if(daVo.getStart()==null&&daVo.getEnd()==null){
			daVo.setStart(DateUtil.parseStrToDate("2012-01-01"));
			daVo.setEnd(DateUtil.addDays(new Date(), 1));
		}
		hql+=" and m.createdAt between ? and ?  order by m.createdAt desc";
		return super.pagedQuery(hql, page, num, ProfessionalConstants.AVAILABLE,daVo.getStart(),daVo.getEnd());
	}
	
	/**
	 * @author DX  2016/12/20
	 * 获取量表类型下对应的所有量表{有效的，被推荐的}
	 * @param itemId
	 * @return
	 */
	public List<MAssessTable>  getList(Integer itemId){
		String hql="from MAssessTable m where m.available = ? and m.itemId=? and m.recommend=?";
		return super.find(hql, ProfessionalConstants.AVAILABLE,itemId,ProfessionalConstants.AVAILABLE);
	}
	/**
	 * 
	 */
	public MAssessTable getById(Integer id){
		String hql="from MAssessTable m where m.available =1 and m.id=?";
		MAssessTable ma = (MAssessTable) super.find(hql,id).get(0);
		return ma; 
	}
}
