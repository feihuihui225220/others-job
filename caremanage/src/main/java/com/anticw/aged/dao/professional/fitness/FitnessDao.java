package com.anticw.aged.dao.professional.fitness;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MAssessFitness;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.vender.FitnessVO1;
import com.anticw.aged.vo.professional.vender.FitnessVO2;

@Component
public class FitnessDao extends HibernateEntityDao<MAssessFitness> {
	/**
	 * 插入问卷答题详情
	 * @param maFitness
	 */
	public MAssessFitness insertFitness(MAssessFitness maFitness) {
//		maFitness.setCreateTime(new Date());
		if(maFitness.getUser()!=null&&maFitness.getUser().getId()!=null){
			super.save(maFitness);
		}
		return maFitness;
	}

	public List<MAssessFitness> selectResult(Long userId) {
//		String hql = "from MAssessFitness m where m.userId=? order by create_time desc";
//		return super.find(hql,userId,PropertyValueConstants.AVAILABLE);
		String hql = "from MAssessFitness  where user_id ="+userId+ "order by id desc";
		List<MAssessFitness> result  = super.find(hql);
		return result;
	}
//------------评估结果历史列表----------

	public List<MAssessFitness> listResult(Long userId) {
		String hql = "from MAssessFitness where user_id="+userId+ "order by id desc";
		List<MAssessFitness> result  = super.find(hql);
		return result;
	}

	public List<MAssessFitness> getResultDetailByTime(Integer resultId) {
		String hql = "from MAssessFitness where id="+resultId;
		List<MAssessFitness> result  = super.find(hql);
		return result;
	}

	public void delete(Integer resultId) {
		super.removeById(resultId);
	}
	/**
	 * 干预中获取本月的体适能成绩
	 * @param Ids
	 * @param d
	 * @return
	 */
	public List<MAssessFitness> list (String Ids,Date d) {
		String hql = "from MAssessFitness where user_id  in("+Ids+") and  create_time   BETWEEN ? and ? GROUP BY user_id";
		List<MAssessFitness> result  = super.find(hql,DateUtil.getFirstDayInMonth(d),DateUtil.getLastDayInMonth(d));
		return result;
	}

	/*
	Integer result2 = maFitness.getResultTwo();	// ----------------两分钟抬腿  5---------------------
	Double result3 = maFitness.getResultThree();// ----------------双手背后相扣  柔软度  6---------------------
	Double result4 = maFitness.getResultFour();// ----------------2.44米折返跑坐  7---------------------
	Double result8 = maFitness.getResultEight();// ---------------------------座椅体前屈------------------------------
*/	/**
	 * 获取财经项目在体适能中获取的数据
	 * @param cal 

	 * @param dateVO
	 * @return
	 */
	public List<FitnessVO1> list (int cal,DateParamVO dateVO) {
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT  h.user_id,h.sex,h.age");
		if(cal==5){
			sb.append(",h.result_2 as r2,h1.result_2 ");
		}else if(cal==6){
			sb.append(",h.result_3 as r3,h1.result_3 ");
		}else if(cal==7){
			sb.append(",h.result_4 as r4,h1.result_4 ");
		}
		sb.append(" FROM (SELECT s.* FROM (SELECT MIN(id) AS id FROM m_assess_fitness  WHERE  create_time BETWEEN '").append(DateUtil.getCurrentFormatDate(dateVO.getStart())).append("' AND '").append(DateUtil.getCurrentFormatDate(dateVO.getEnd())+"' ");
		sb.append(" GROUP BY `user_id`) t LEFT JOIN `m_assess_fitness` AS s ON t.id=s.id ) h,(SELECT m.* FROM (SELECT MAX(id) AS id FROM m_assess_fitness  WHERE  create_time BETWEEN '");
		sb.append(DateUtil.getCurrentFormatDate(dateVO.getStart())).append("' AND '").append(DateUtil.getCurrentFormatDate(dateVO.getEnd())+"' ");
		sb.append("GROUP BY `user_id`) t LEFT JOIN `m_assess_fitness` AS m ON t.id=m.id) h1 WHERE h.user_id=h1.user_id AND h.id!=h1.id ");
		if(cal==5){
			sb.append(" AND h.result_2 IS NOT NULL AND h1.result_2 IS NOT NULL");
		}else if(cal==6){
			sb.append(" AND h.result_3 IS NOT NULL AND h1.result_3 IS NOT NULL");
		}else if(cal==7){
			sb.append(" AND h.result_4 IS NOT NULL AND h1.result_4 IS NOT NULL");
		}
		
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<FitnessVO1> fit=new ArrayList<FitnessVO1>();//第一次录入的数据
		for(int i=0;i<query.size();i++) {
			FitnessVO1 vo1=new FitnessVO1();
			try {
				Object[]  column= query.get(i);
				vo1.setUserId(((BigInteger)column[0]).longValue());
				vo1.setSex((Integer)column[1]);
				vo1.setAge((Integer)column[2]);
				String o3=column[3].toString();
				String o4=column[4].toString();
				vo1.setResultS(Double.parseDouble(o3));
				vo1.setResultE((Double.parseDouble(o4)));
				fit.add(vo1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return fit;
	}
	/**
	 * 
	 * @param cal
	 * @param dateVO
	 * @return
	 */
	public List<FitnessVO2> list_(int cal,DateParamVO dateVO) {
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT  h.user_id,h.sex,h.age");
		if(cal==3){
			sb.append(",h.result_6 as r6,h1.result_6,h.result_7 as r7,h1.result_7 ");
		}else if(cal==4){
			sb.append(",h.result_1 as r1,h1.result_1,h.result_5 as r5,h1.result_5 ");
		}
		sb.append(" FROM (SELECT s.* FROM (SELECT MIN(id) AS id FROM m_assess_fitness  WHERE  create_time BETWEEN '").append(DateUtil.getCurrentFormatDate(dateVO.getStart())).append("' AND '").append(DateUtil.getCurrentFormatDate(dateVO.getEnd())+"' ");
		sb.append(" GROUP BY `user_id`) t LEFT JOIN `m_assess_fitness` AS s ON t.id=s.id ) h,(SELECT m.* FROM (SELECT MAX(id) AS id FROM m_assess_fitness  WHERE  create_time BETWEEN '");
		sb.append(DateUtil.getCurrentFormatDate(dateVO.getStart())).append("' AND '").append(DateUtil.getCurrentFormatDate(dateVO.getEnd())+"' ");
		sb.append("GROUP BY `user_id`) t LEFT JOIN `m_assess_fitness` AS m ON t.id=m.id) h1 WHERE h.user_id=h1.user_id AND h.id!=h1.id ");
		if(cal==3){
			sb.append(" AND h.result_6 IS NOT NULL AND h1.result_6 IS NOT NULL  AND h.result_7 IS NOT NULL AND h1.result_7 IS NOT NULL");
		}else if(cal==4){
			sb.append("AND h.result_1 IS NOT NULL AND h1.result_1 IS NOT NULL  AND h.result_5 IS NOT NULL AND h1.result_5 IS NOT NULL");
		}
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<FitnessVO2> fit=new ArrayList<FitnessVO2>();//第一次录入的数据
		for(int i=0;i<query.size();i++) {
			FitnessVO2 vo1=new FitnessVO2();
			try {
				Object[]  column= query.get(i);
				vo1.setUserId(((BigInteger)column[0]).longValue());
				vo1.setSex((Integer)column[1]);
				vo1.setAge((Integer)column[2]);
				String o3=column[3].toString();
				String o4=column[4].toString();
				String o5=column[5].toString();
				String o6=column[6].toString();
				vo1.setResultS1(Double.parseDouble(o3));
				vo1.setResultE1(Double.parseDouble(o4));
				vo1.setResultS2(Double.parseDouble(o5));
				vo1.setResultE2(Double.parseDouble(o6));
				fit.add(vo1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return fit;
	}
	public static void main(String[] args) {
		new FitnessDao().list(5, new DateParamVO(DateUtil.parseStrToDate("2015-10-10"), DateUtil.parseStrToDate("2016-10-10")));
		
	}
	
	public List<MAssessFitness> getList_(){
		String hql="from MAssessFitness order by user.id desc";
		return super.find(hql);
	}
}
