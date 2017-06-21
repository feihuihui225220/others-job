package com.anticw.aged.dao.professional.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NVolunteerTrain;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.activity.NVolunteerTrainVO;
/**
 * 
 * @author dx 2015.10.14
 *
 */
@Repository
public class NVolunteerTrainDao extends HibernateEntityDao<NVolunteerTrain>{
	//添加培训名单
	public Integer addNVolunteerTrain(NVolunteerTrain nVolunteerTrain){
		super.save(nVolunteerTrain);
	    return nVolunteerTrain.getId();
	}
	//查询所有的培训记录分页排序
	public Page<NVolunteerTrain> getList(int pageIndex,int pagesize,String createdBy,Integer communityId,Integer site){
		StringBuffer sb=new StringBuffer("from NVolunteerTrain n where n.createdBy=? and n.avaliable=true ");
		if(communityId!=null&&communityId!=0){
			sb.append(" and n.communityIds like '%"+communityId+"%'");
		}
		if(site!=null&&site!=0){
			sb.append(" and n.siteIds like '%"+site+"%'");
		}
		
		sb.append(" order by n.createdAt desc");
		return this.pagedQuery(sb.toString(), pageIndex, pagesize, createdBy);
	}
	public Page<NVolunteerTrainVO> getList(int pageNo,int pageSize,String createdBy,Integer communityId,String siteIds,Integer site){
		StringBuffer sb=new StringBuffer("SELECT nv.id,nv.theme, nv.train_place,nv.train_times,nv.community_ids,nv.end_time,nv.train_date  FROM n_volunteer_train nv WHERE id IN(SELECT nt.train_id FROM n_train_staff nt  ");
		sb.append("WHERE nt.site_id IN(").append(siteIds).append(")").append(" GROUP BY nt.train_id DESC) ").append(" AND nv.avaliable=1 ");
		//StringBuffer sb=new StringBuffer("from NVolunteerTrain n where n.createdBy=? and n.avaliable=true ");
		if(communityId!=null&&communityId!=0){
			sb.append("  AND nv.community_ids like '%"+communityId+"%'");
		}
		if(site!=null&&site!=0){
			sb.append("  AND nv.site_ids LIKE  '%"+site+"%'");
		}
		List<Object[]> all = super.findBySQLQuery(sb.toString());
		//总记录数
		int totalCount = all.size();
		int pageIndex=(pageNo-1)*pageSize;
		//分页
		String sql1=(pageNo == 1 ? 0 : pageIndex) + "," +  pageSize;
		sb.append(" LIMIT  ").append(sql1);
		//返回值
	
		//查询分页记录
		List<Object[]> list = super.findBySQLQuery(sb.toString());
		
		List<NVolunteerTrainVO> results = this.results(list);
		//构建分页对象
		Page<NVolunteerTrainVO> _page = new Page<NVolunteerTrainVO>();
		_page.setPageNo(pageNo);
		_page.setPageSize(pageSize);
		_page.setTotalCount(totalCount);
		_page.setResult(results);
		
		return _page;
		//sb.append(" order by n.createdAt desc");
		//return this.pagedQuery(sb.toString(), pageIndex, pageSize, createdBy);
	}
	
	public List<NVolunteerTrainVO> results(List<Object[]> list){
		List<NVolunteerTrainVO> results = new ArrayList<NVolunteerTrainVO>();
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			//一条记录
			NVolunteerTrainVO vo=new NVolunteerTrainVO();
			Object[] column = iter.next();
			vo.setId((Integer)column[0]);
			Object theme=column[1];
			vo.setTheme((String)theme);
			Object place=column[2];
			vo.setTrainPlace((String)place);
			Object times=column[3];
			if(times!=null){
				vo.setTrainTimes(times+"");
			}
			//Object communityIds=column[4];
			Object end=column[5];
			vo.setEndTime((Date)end);
			Object start=column[6];
			vo.setTrainDate((Date)start);
			results.add(vo);
			}
		return results;
	}
	
	
	//修改培训记录
	public void updateNVolunteerTrain(NVolunteerTrain nVolunteerTrain){
		super.update(nVolunteerTrain);
	}
	//删除培训记录
	public void deleteNVolunteerTrain(int id){
		super.removeById(id);
	}
	//查询的培训信息
	public List<NVolunteerTrain> getListNVolunteerTrain(String createdBy,Date start,Date end){
		String hql="from NVolunteerTrain n where n.createdBy=? and createdAt between ? and ?";
		return super.find(hql,createdBy,start,end);
	}
	public List<NVolunteerTrain> getListNVolunteerTrains(String ids,Date start,Date end){
		String hql="from NVolunteerTrain n where n.id in("+ids+") and createdAt between ? and ?";
		return super.find(hql,start,end);
	}
	//根据Id查询一条培训记录
	public NVolunteerTrain getNVolunteerTrain(int id){
		List<NVolunteerTrain> li= super.find("from NVolunteerTrain n where n.id=?",id);
		return li.get(0);
	}
}
