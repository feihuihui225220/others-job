package com.anticw.aged.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.OKnowledge;
import com.anticw.aged.dao.admin.KnowledgeDao;
import com.anticw.aged.dao.utils.Page;


@Service
public class KnowledgeService {
	
	@Autowired
	private KnowledgeDao knowledgedao;
	public Page<OKnowledge> list(int page,int num){
		return knowledgedao.list(page,num);
	}
	
	public Page<OKnowledge> listCategory(int page,int num,int category){
		return knowledgedao.listByCategory(page,num,category);
	}
	
	public void insertKnowledge(OKnowledge oknowledge){
		knowledgedao.insertKnowledge(oknowledge);
	}
	
	public OKnowledge findKnowledgeById(int id){
		return knowledgedao.findKnowledgeById(id);
	}

	public void editKnowledge(OKnowledge oknowledge){
		this.knowledgedao.editKnowledge(oknowledge);
	}
	
	public void delKnowledgeById(int id){
		this.knowledgedao.delKnowledgeById(id);
	}
	
	public void delKnowledgeBy(int id){
		this.knowledgedao.delKnowledgeBy(id);
	}
	
	public List<OCategoryItem> knowledgeType(){
		return knowledgedao.knowledgeType();
	}
}
