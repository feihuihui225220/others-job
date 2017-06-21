package com.anticw.aged.dao.director;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HGroupUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
/**
 * 巡诊组患者管理
 * @author DX 2016-09-18
 *
 */
@Component
public class HGroupUserDao extends HibernateEntityDao<HGroupUser>{
	/**
	 * 分页查看
	 * @param page
	 * @param groupId
	 * @return
	 */
	public Page<HGroupUser>  getUser(PageParamVO page,Integer groupId,
			Integer states,Integer age,String idCardNo,String communityId,Date changedAt,Integer choose,String name,DateParamVO dateCond){
		String hql="FROM HGroupUser h where groupId=? and available=? ";
		if(choose==0){
			hql+=" and HGroupUser.user.state="+states;
		}else if(choose==1){
			hql+=" and HGroupUser.user.age="+age;
		}else if(choose==2){
			hql+=" and HGroupUser.user.idCardNo like '%"+idCardNo+"%' ";
		}else if(choose==3){
			hql+=" and HGroupUser.user.communityId ="+communityId;
		}else if(choose==4){
			hql+=" and HGroupUser.user.changedAt ="+changedAt;
		}else if(choose==5){
			hql+=" and HGroupUser.user.name like '%"+name+"%' ";
		}else if(choose==6){
			hql+="and createdAt BETWEEN "+dateCond.getStart()+" and "+dateCond.getEnd();
		}
		return super.pagedQuery(hql, page.getPage(),page.getNum(),groupId,PropertyValueConstants.AVAILABLE);
	}
	
	
	public Page<HGroupUser>  getUserlist(PageParamVO page,Long careteName,Integer status,
			String start,String end,String userName){
		String hql="FROM HGroupUser a where groupId=? and available=?";
			if(userName==null||userName.isEmpty()){
				if(start!=null&& end !=null){
					hql+=" and createTime BETWEEN '"+start+"' AND '"+end+"'";
				}
				if(start==null&&end !=null){
					hql+="and createTime < '"+end+"'";
				}
				if(start!=null&&end ==null){
					hql+="and createTime > '"+start+"'";
				}
				if(status!=null){
					hql+=" and user IN (SELECT r.id FROM RUser r WHERE r.state='"+status+"')";
				}else{
					hql+=" and user IN (SELECT r.id FROM RUser r WHERE r.state in (0,1,2,3,4))";
					
				}
				/*hql+="order by a.createTime desc";
				return super.pagedQuery(hql, page.getPage(),page.getNum(),careteName,PropertyValueConstants.AVAILABLE);*/
			}else{
				hql+="and user IN (SELECT r.id FROM RUser r WHERE name like '%"+userName+"%')";/*
				return super.pagedQuery(hql, page.getPage(),page.getNum(),careteName,PropertyValueConstants.AVAILABLE);*/
			}
			hql+="order by a.createTime desc";
			return super.pagedQuery(hql, page.getPage(),page.getNum(),careteName,PropertyValueConstants.AVAILABLE);
	}
	
	public int getList(long userId){
		String hql="from HGroupUser where groupId=?";
		return super.find(hql, userId).size();
	}
}

