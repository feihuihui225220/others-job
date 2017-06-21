package com.anticw.aged.dao.director;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HRoundsRecord;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.director.RoundsVO;

/**
 * 作者：bsd
 * 日期：2016-9-17
 * 功能：巡诊记录
 */
@Component
public class RoundsRecordDao extends  HibernateEntityDao<HRoundsRecord>{
	
	public int addRoundsRecord(HRoundsRecord HRoundsRecord){
		return (Integer) super.save(HRoundsRecord);
	}
	
	public void editRoundsRecord(HRoundsRecord HRoundsRecord){
		 super.update(HRoundsRecord);
	}
	
	public List<Object> findRoundsRecordAll(Long userId,Integer esc){
		String hql="select a.id,a.createTime,a.type,a.startTime,a.endTime,a.createBy,a.content,b.userName from HRoundsRecord a,HGroup b where a.groupId=b.userId and 1=1";
		if(userId!=null){
			hql+="and a.userId='"+userId+"'";
		}
		if (esc == null) {
			esc =1;
		}
		if(esc==0){
			hql+="order by a.createTime desc";
		}else{
			hql+="order by a.createTime";
		}
		return super.find(hql);
	}
	
	public HRoundsRecord findRoundsRecordById(int id){
		return super.get(id);
	}
	
	//逻辑删除知识库
	public void delRoundsRecordById(int id) {
		String hql = "update HRoundsRecord set available=0  where id=" + id;
		Query query = super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
	}

	// 物理删除知识库
	public void delRoundsRecordBy(int id) {
		super.removeById(id);
	}
	//条件查询
		public Page<HRoundsRecord> listHTransfer(PageParamVO page,
				String startTime, String endTime, Integer esc, Long userId) {
			
			//查询条件
					String hqlStr = "from HRoundsRecord where 1=1";
					if(userId!=null){
						hqlStr+="and userId="+userId;
					}
					if(startTime!=null&&endTime!=null){
						hqlStr+="and startTime BETWEEN '"+startTime+"'AND'"+endTime+"'and endTime BETWEEN'"+startTime+"'and'"+endTime+"'" ;
					}
					if(startTime!=null&&endTime==null){
						hqlStr+="and startTime > '"+startTime+"'";
					}
					if(startTime==null&&endTime!=null){
						hqlStr+="and endTime <'"+endTime+"'";
					}
					if(esc==1){
						hqlStr+="order by createTime";
					}else{
						hqlStr+="order by createTime desc";
					}//分页查询
					return super.pagedQuery(hqlStr, page.getPage(), page.getNum());
		}

		@SuppressWarnings("unchecked")
		public List<RoundsVO> countRound() {	
			String sql="SELECT COUNT(h.id) id ,SUM(h.TYPE='入户巡诊') ruhu, SUM(h.TYPE='电话巡诊') phone ,g.user_name AS groups  FROM h_rounds_record h,h_group g WHERE h.group_id= g.user_id GROUP BY group_id";
			Query query = currentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RoundsVO.class));
			@SuppressWarnings("rawtypes")
			Page pagevo = new Page();
			pagevo.setPageNo(1);
			pagevo.setPageSize(1000);
			return query.setFirstResult(pagevo.getFirst()).setMaxResults(1000).list();
			//return super.findBySQLQuery(sql);
		}

       //求和
		public Long sumRound() {
			String  hql="FROM HRoundsRecord";
			return super.getCount(hql);
		}
}
