package com.anticw.aged.dao.admin;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.OKnowledge;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
@Component
public class KnowledgeDao extends HibernateEntityDao<OKnowledge> {
	
	
	 public Page<OKnowledge> list(int page, int num) {
		
		//查询条件
		Criterion[] criterions = new Criterion[]{
					Restrictions.eq("available", PropertyValueConstants.AVAILABLE)//分类数据
				//分页查询
			};
				return super.pagedQuery(OKnowledge.class,page, num, criterions);
		}

	public Page<OKnowledge> listByCategory(int page, int num,int category ) {
		//查询条件
		Criterion[] criterions = new Criterion[]{
				Restrictions.eq("available", PropertyValueConstants.AVAILABLE),
				Restrictions.eq("categoryId", category)
		};	
				//分页查询
		return super.pagedQuery(OKnowledge.class, page, num, criterions);
	}
	
	 /**
	  * 添加知识库
	  * @param oKnowledge
	  */
	public void insertKnowledge(OKnowledge oKnowledge) {
		Date date = new Date();
		oKnowledge.setAvailable(PropertyValueConstants.AVAILABLE);
		oKnowledge.setCreatedAt(date);
		oKnowledge.setChangedAt(date);
		super.save(oKnowledge);
	}
	
	// 按ID查询知识库
	
	public OKnowledge findKnowledgeById(int id){
		return super.get(id);
	}
	
	// 编辑知识库
	public void editKnowledge(OKnowledge oKnowledge){
		Date  date = new Date();
		OKnowledge knowledge =findKnowledgeById(oKnowledge.getId());
		knowledge.setTitle(oKnowledge.getTitle());
		knowledge.setKeyword(oKnowledge.getKeyword());
		knowledge.setCategoryId(oKnowledge.getCategoryId());
		knowledge.setContent(oKnowledge.getContent());
		knowledge.setChangedAt(date);
		knowledge.setChangedBy(oKnowledge.getChangedBy());
		knowledge.setPublisher(oKnowledge.getPublisher());
		super.update(knowledge);
	}
	
	// 物理删除知识库
	public void delKnowledgeBy(int id){
		super.removeById(id);
	}
	
	//物理删除知识库
	public void delKnowledgeById(int id){
		String hql = "update OKnowledge set available=0  where id="+id;
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
	
	
}




