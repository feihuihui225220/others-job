package com.anticw.aged.dao.professional.assess;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MVenderIntervene;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.vo.professional.assess.MVenderInterveneVO;
/**
 * 
 * @author DX
 *
 */
@Component
public class MVenderInterveneDao extends HibernateEntityDao<MVenderIntervene>{
	
	public void save(MVenderIntervene r){
		super.save(r);
		super.currentSession().flush();
	}
	/**
	 * 获取生成展示收据（仅限单体T检验时生成）
	 * @return
	 */
	public List<MVenderInterveneVO> getMVenderInterveneVO(){
		String sql="SELECT m.* FROM (SELECT MAX(id) AS id FROM m_vender_intervene m  WHERE average IS NOT NULL  GROUP BY  m.`itemize_id` ) t LEFT JOIN m_vender_intervene m ON t.id=m.id";
		
		List<MVenderIntervene> mv = getmvenderinterve(sql);
		List<MVenderInterveneVO> vos=new ArrayList<MVenderInterveneVO>();
		MVenderInterveneVO vo=null;
		for(MVenderIntervene m:mv){
			vo=new MVenderInterveneVO();
			try {
				BeanUtils.copyProperties(vo, m);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String hql1="from MVenderIntervene where id=(SELECT MAX(id) FROM MVenderIntervene WHERE verifyMode=1 AND itemizeId="+m.getItemizeId()+")";
			String hql2="from MVenderIntervene where id=(SELECT MAX(id) FROM MVenderIntervene WHERE verifyMode=2 AND itemizeId="+m.getItemizeId()+")";
			
			List<MVenderIntervene> m1=super.find(hql1);
			List<MVenderIntervene> m2=super.find(hql2);
			if(m1.size()!=0){
				vo.setKf(m1.get(0).getTestValue1());
			}
			if(m2.size()!=0){
				vo.setF(m2.get(0).getTestValue1());
			}
			vos.add(vo);
		}
		
		return vos;
	}
	private List<MVenderIntervene> getmvenderinterve(String sql) {
		List<Object[]> list = super.findBySQLQuery(sql);
		Iterator<Object[]> iter = list.iterator(); 
			//一条记录
		List<MVenderIntervene> mv=new ArrayList<MVenderIntervene>(); 
		MVenderIntervene nv1=null;
		while (iter.hasNext()) {
			Object[] column = iter.next();
			nv1=new MVenderIntervene();
			nv1.setId(((BigInteger) column[0]).longValue());
			nv1.setGroup1((Integer)column[1]);
			if(column[2]!=null){
				nv1.setGroup2((Integer)column[2]);
			}
			if(column[3]!=null){
				nv1.setItemizeId((Integer)column[3]);
			}
			if(column[4]!=null){
				nv1.setTwoFactor((Integer)column[4]);
			}
			if(column[5]!=null){
				nv1.setAValue((Double)column[5]);
			}
			 
			if(column[7]!=null){
				nv1.setVerifyMode((Integer)column[7]);
			}
			if(column[8]!=null){
				nv1.setAverage((Double)column[8]);
			}
			if(column[9]!=null){
				nv1.setTestValue1((Double)column[9]);
			}
			if(column[10]!=null){
				nv1.setTestValue2((Double)column[10]);
			}
			if(column[11]!=null){
				nv1.setTestValue3((Double)column[11]);
			}
			if(column[12]!=null){
				nv1.setCriticalValue1((Double)column[12]);
			}
			if(column[13]!=null){
				nv1.setCriticalValue2((Double)column[13]);
			}
			if(column[14]!=null){
				nv1.setCriticalValue3((Double)column[14]);
			}
			mv.add(nv1);
		}
		return mv;
	}
	
	/**
	 * 获取当前选择组 最新一条单因素数据
	 * @param itemizeId
	 * @return
	 */
	public List<MVenderIntervene> getList(int itemizeId){
		String sql="SELECT * FROM m_vender_intervene WHERE itemize_id="+itemizeId+" AND two_factor IS NULL GROUP BY verify_mode";
		return getmvenderinterve(sql);
	}
	/**
	 * 获取当前选择组 最新一条双因素数据
	 * @param itemizeId
	 * @return
	 */
	public List<MVenderIntervene> getListTwo(int itemizeId){
		String sql="SELECT * FROM m_vender_intervene WHERE itemize_id="+itemizeId+" AND two_factor IS NOT NULL GROUP BY verify_mode";
		return getmvenderinterve(sql);
	} 
	
}
