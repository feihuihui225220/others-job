package com.anticw.aged.service.professional.material;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MMaterial;
import com.anticw.aged.dao.professional.material.MMaterialDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author DX-2016/6/19
 *
 */
@Service
public class MMaterialService {
	
	@Autowired
	private MMaterialDao mMaterialDao;
	
	public Integer save(MMaterial mMaterial,UserVO userVo){
		mMaterial.setCreatedAt(new Date());
		mMaterial.setChangedAt(new Date());
		mMaterial.setCreatedBy(userVo.getName());
		mMaterial.setChangedBy(userVo.getName());
		mMaterial.setVenderId(userVo.getVenderId());
		mMaterial.setVersion((short)1);
		mMaterialDao.save(mMaterial);
		return mMaterial.getId();
		
	}
	
	public MMaterial selectById(Integer id){
		return mMaterialDao.get(id);
	}
	
	
	public void updateMMaterial(MMaterial m){
		MMaterial mMaterial = mMaterialDao.get(m.getId());
		if(m.getImgUrl()!=null){
			mMaterial.setImgUrl(m.getImgUrl());
		}
		mMaterial.setMaterialAmount(m.getMaterialAmount());
		mMaterial.setMaterialColor(m.getMaterialColor());
		mMaterial.setMaterialFeature(m.getMaterialFeature());
		mMaterial.setMaterialHeight(m.getMaterialHeight());
		mMaterial.setMaterialLength(m.getMaterialLength());
		mMaterial.setChangedBy(m.getChangedBy());
		mMaterial.setChangedAt(new Date());
		mMaterial.setMaterialName(m.getMaterialName());
		mMaterial.setMaterialNature(m.getMaterialNature());
		mMaterial.setMaterialStandard(m.getMaterialStandard());
		mMaterial.setMaterialWight(m.getMaterialWight());
		mMaterial.setVersion((short)(mMaterial.getVersion()+1));
		mMaterialDao.save(m);
	}
	
	public void removeById(Integer id){
		mMaterialDao.removeById(id);
	}
	
	public Page<MMaterial> list(int venderId, int page, int num,MMaterial mMaterial) {
		return mMaterialDao.list(venderId, page, num,mMaterial);
	}
	
	public List<MMaterial> getList(String name,Integer venderId){
		return mMaterialDao.getList(name,venderId);
	}
	public List<MMaterial> getList(String Ids){
		return mMaterialDao.getList(Ids);
	}
	
	
}
