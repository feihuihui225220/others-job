package com.anticw.aged.dao.professional.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.activity.VolunteerVO;

/**
 * Created by WSS on 2015/9/10.<br>
 */
@Repository
public class VolunteerDao extends HibernateEntityDao<NVolunteer> {

    /**
     *全部数据，没有分页
     */
	public List<NVolunteer> findListValue(){
		return super.find("from NVolunteer where avaliable=? order by changedAt desc",
				PropertyValueConstants.AVAILABLE);
	}
    public List<NVolunteer> findListValue(String venderId){
        return super.find("from NVolunteer where avaliable=? and createdBy=? order by changedAt desc",
                PropertyValueConstants.AVAILABLE,venderId);
    }
    
    /**
     * 获取社区下所有志愿者
     * @param comId
     * @return
     */
    public List<NVolunteer> getCommunity(Integer comId){
    	String hql="from NVolunteer where community=? and avaliable=?";
    	return super.find(hql, comId.toString(),PropertyValueConstants.AVAILABLE);
    }
    
    

    public List<NVolunteer> ListNVolunteer(String Ids){
    	return super.find("from NVolunteer where id in("+Ids+") order by changedAt desc",
    			PropertyValueConstants.AVAILABLE);
    }
    public List<NVolunteer> ListById(int id){
        return super.find("from NVolunteer where avaliable=? and id=? order by changedAt desc",
                PropertyValueConstants.AVAILABLE,id);
    }
    public Page<NVolunteer> list(int page, int num) {

        //查询条件
        Criterion[] criterions = new Criterion[]{
                Restrictions.eq("available", PropertyValueConstants.AVAILABLE)//分类数据
                //分页查询
        };
        return super.pagedQuery(NVolunteer.class,page, num, criterions);
    }
    //分页 专业服务商
    public Page<NVolunteer> seeNVolunteer(int pageIndex,int pagesize,String createdBy,Integer site){
    	StringBuffer hql=new StringBuffer("from NVolunteer n where n.createdBy=? and n.avaliable=true ");
    	
    	if(site!=null&&site!=0){
    		hql.append(" and n.siteId=").append(site);
    	}
    	hql.append(" order by n.createdAt desc");
    	return this.pagedQuery(hql.toString(), pageIndex, pagesize, createdBy);
	}
    //不分页
    public List<NVolunteer> seeNVolunteer(String createdBy,String communityIds,String siteIds){
    	
    	return this.find("from NVolunteer n where n.createdBy=? and n.avaliable=true and "
    			+ " n.community in("+communityIds+")  AND n.siteId in("+siteIds+") "
    			+ " order by n.createdAt desc",createdBy);
    }
    //未签
    public List<VolunteerVO> selectByTrainRecordId(Integer trainRecordId,String communitys,String siteIds){
    	StringBuffer sb=new StringBuffer("SELECT n.id,n.`name` as name1,n.sex,n.site_id,m.site_name,n.age,n.contact,n.community,o.`name` FROM n_volunteer n ,o_country o,m_vender_site m ");  
    	sb.append(" WHERE n.id  NOT IN  (select nv.volunteer_id from n_volunteer_train_record nv WHERE nv.train_id=").append(trainRecordId).append(" ) AND n.community in (").append(communitys).append(" ) AND n.avaliable=1 AND o.id=n.community AND m.id=n.site_id");
    	if(siteIds!=null&&siteIds!=""){
    		sb.append(" AND n.site_id IN (").append(siteIds).append(") ");
    	}
    	return getVolunteer(sb);
    }
    //已签
    public List<VolunteerVO> selectTrainRecordId(Integer trainRecordId,String communitys,String siteIds){
    	StringBuffer sb=new StringBuffer("SELECT n.id,n.`name` as name1,n.sex,n.site_id,m.site_name,n.age,n.contact,n.community,o.`name` FROM n_volunteer n ,o_country o,m_vender_site m ");  
    	sb.append(" WHERE n.id   IN  (select nv.volunteer_id from n_volunteer_train_record nv WHERE nv.train_id=").append(trainRecordId).append(" ) AND n.community in (").append(communitys).append(" ) AND n.avaliable=1 AND o.id=n.community AND m.id=n.site_id");
    	if(siteIds!=null&&siteIds!=""){
    		sb.append(" AND n.site_id IN (").append(siteIds).append(") ");
    	}
    	return getVolunteer(sb);
    }
	private List<VolunteerVO> getVolunteer(StringBuffer sb) {
		List<VolunteerVO> volunteerVOs=new ArrayList<VolunteerVO>();
    	List<Object[]> list = super.findBySQLQuery(sb.toString());
		for(Iterator<Object[]> iter = list.iterator(); iter.hasNext();) {
			Object[]  column= iter.next();
			VolunteerVO vo = new VolunteerVO();
			vo.setId((Integer)column[0]);
			vo.setName(column[1].toString());
			//vo.setUserId(Long.valueOf(result[2].toString()));
			vo.setSex(column[2].toString());
			vo.setSiteId(Integer.valueOf(column[3].toString()));
			vo.setSiteNmae(column[4].toString());
			vo.setAge((Integer)column[5]);
			vo.setContact(column[6].toString());
			vo.setCommunity(column[7].toString());
			vo.setCommunityNmae(column[8].toString());
			volunteerVOs.add(vo);
		}
    	return volunteerVOs;
	}
    
    //分页员工
    public Page<NVolunteer> seeNVolunteers(int pageIndex,int pagesize,String createdBy,String communityIds,Integer site){
    	StringBuffer hql=new StringBuffer("from NVolunteer n where n.createdBy=? and n.avaliable=true and ");
    	hql.append("n.community in(").append(communityIds).append(") ");
    	if(site!=null&&site!=0){
    		hql.append(" and n.siteId=").append(site);
    	}
    	hql.append(" order by n.createdAt desc");
    	return this.pagedQuery(hql.toString(), pageIndex, pagesize, createdBy);
    }
    //不分页员工
    public List<NVolunteer> seeNVolunteers(String createdBy,String communityIds,String siteIds){
    	return this.find("from NVolunteer n where n.createdBy=? and n.avaliable=true and "
    			+ "n.community in("+communityIds+")  AND n.siteId in("+siteIds+") "
    			+ "order by n.createdAt desc",createdBy);
    }
    
    public Page<NVolunteer> seeNVolunteers(int pageIndex,int pagesize,String createdBy,int communityId,Integer site){
    	StringBuffer hql=new StringBuffer("from NVolunteer n where n.createdBy=? and n.avaliable=true and n.community=? ");
    	if(site!=null&&site!=0){
    		hql.append(" and n.siteId=").append(site);
    	}
    	hql.append(" order by n.createdAt desc");
    	
    	String community=communityId+"";
    	return this.pagedQuery(hql.toString(), pageIndex, pagesize, createdBy,community);
    }

    public Page<NVolunteer> listByCategory(int page, int num,int category ) {
        //查询条件
        Criterion[] criterions = new Criterion[]{
                Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
                Restrictions.eq("categoryId", category)
        };
        //分页查询
        return super.pagedQuery(NVolunteer.class, page, num, criterions);
    }

    public Serializable addVolunteer(NVolunteer nVolunteer) {

        return super.save(nVolunteer);
    }

    public NVolunteer findVolunteerById(int id){
        return super.get(id);
    }

    /**
     * 修改志愿者信息
     * @param nVolunteer
     */
    public void updateById(NVolunteer nVolunteer) {
        super.update(nVolunteer);
    }

    public void delVolunteerById(int id){
        super.removeById(id);
    }
    public void delKnowledgeById(int id){
        String hql = String.format("update NVolunteer set available=0  where id=%d", id);
        Query query = super.getSessionFactory().openSession().createQuery(hql);
        query.executeUpdate();
    }

    /**
     * 获取知识库所有的类型值
     * @return
     */
    public List<OCategoryItem> knowledgeType(){
        return super.find("from OCategoryItem where available=? and categoryId=? order by changedAt desc",
                PropertyValueConstants.AVAILABLE,6);

    }
    /**
     * 活动管理查询志愿者
     * @param ids
     * @return
     */
    public List<NVolunteer> findNVolunters(String ids){
        return super.find("from NVolunteer where id in("+ids+")");
    }
    
}
