package com.anticw.aged.dao.position;



import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.MPosition;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
@Component
public class MPositionsDao extends HibernateEntityDao<MPosition>{

	public Page<MPosition> list(int page,int num){
		//查询条件
		Criterion [] criterions=new Criterion[]{
				Restrictions.eq("available", PropertyValueConstants.AVAILABLE)//分类数据
				//分页查询
		};
		return super.pagedQuery(MPosition.class,page, num, criterions);
	}
	public Page<MPosition> listByCategory(int page, int num,int category ) {
		//查询条件
		Criterion[] criterions = new Criterion[]{
				Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
				Restrictions.eq("categoryId", category)
		};	
				//分页查询
		return super.pagedQuery(MPosition.class,page, num, criterions);
	}
	/**
	 * 添加位置信息
	 * @param mPosition
	 * @return 
	 */
	public void insertPosition(MPosition mPosition){
		
		mPosition.setAvailable(PropertyValueConstants.AVAILABLE);
		super.save(mPosition);
	}
	
	//按id查询位置
	public MPosition findMPositionById(Long id){
		return super.get(id);
	}
	//按时间与userid查询位置信息
	public List<MPosition> findByIdandTime(long userId,Date createTime){
		return this.find(" select longitude,latitude from MPosition where userId=?"
				+ " and (datediff(createTime,?)=0)",userId,createTime);
		
	}
	//编辑位置信息
	public void editMPosition(MPosition mPosition){
		
		MPosition position=findMPositionById(mPosition.getId());
		position.setAvailable(mPosition.getAvailable());
		position.setCreateTime(mPosition.getCreateTime());
		position.setId(mPosition.getId());
		position.setLatitude(mPosition.getLatitude());
		position.setLongitude(mPosition.getLongitude());
		position.setUserId(mPosition.getUserId());
		super.update(position);
	} 
	//物理删除数据
	public void deletePositionBy(Long id){
		super.removeById(id);
	}
	//物理删除数据
	public void deletePositionById(Long id){
		String hql="update MPosition set available=0 where id="+id;
		Query query=super.getSessionFactory().openSession().createQuery(hql);
		query.executeUpdate();
	}
	//
	
}
