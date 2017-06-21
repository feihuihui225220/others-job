/**
 * 
 */
package com.anticw.aged.vo.permission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.mchange.v1.db.sql.UnsupportedTypeException;

/**
 * 登录账户信息SessionVO
 * @author guoyongxiang
 * Date: 2014-10-3
 */
public class UserVO extends MobileUserVO {
	
	/** 角色列表 */
	private Set<ARole> roles;
	/** 资源列表 */
	private List<AResource> resources;
	
	private String idCardNo;
	/**
	 * 
	 */
	public UserVO() {
		super();
	}
	/**
	 * @param name
	 * @param cateName
	 * @param communityId
	 */
	public UserVO(long id, String name, String parentName, Integer venderId, String realName, UserCategoryEnum cate, String communityId, boolean super_, Set<ARole> roles) {
		super(id, name, realName, cate, parentName, venderId, communityId, super_);
		this.roles = roles;
		List<AResource> resources = new ArrayList<AResource>();
		AResource resource=null;
		boolean reverse=false;
		for(ARole role:roles){
			for(AResource res:role.getResources()){
				if(!resources.contains(res)){
					if(res.getName().equals("我的任务")){
						resource=res;
						reverse=true;
					}
					resources.add(res);
				}
			}
		}
		if(cate.equals(UserCategoryEnum.PRO)&&super_){
			resources.remove(resource);
		}
		if(cate.equals(UserCategoryEnum.PRO)&&!super_&&reverse==true){
			Collections.reverse(resources);
		}
		this.resources = resources;
	}
	/**
	 * @param name
	 * @param cateName
	 * @param communityId
	 */
	public UserVO(long id, String name, String realName, String cateName, String communityId, boolean super_, Set<ARole> roles) {
		super();
		this.name = name;
		this.realName = realName;
		this.cateEnum = UserCategoryEnum.valueOf(cateName);
		this.communityId = communityId;
		this.super_ = super_;
		this.roles = roles;
		List<AResource> resources = new ArrayList<AResource>();
		for(ARole role:roles){
			for(AResource res:role.getResources()){
				if(!resources.contains(res)){
					resources.add(res);
				}
			}
		}
		this.resources = resources;
	}
	/**
	 * @param name
	 * @param cateName
	 * @param communityId
	 * @throws UnsupportedTypeException 
	 */
	public UserVO(long id, String name, String realName, int cateId, String communityId, boolean super_, Set<ARole> roles) throws UnsupportedTypeException {
		super();
		UserCategoryEnum cateEnum = null;
		UserCategoryEnum[] cates = UserCategoryEnum.values();
		for(UserCategoryEnum cate:cates){
			if(cate.getType()==cateId){
				cateEnum = cate;
				break;
			}
		}
		if(cateEnum==null){
			throw new UnsupportedTypeException("不支持的账户分类ID:"+cateId);
		}
		this.realName = realName;
		this.name = name;
		this.cateEnum = cateEnum;
		this.super_ = super_;
		this.communityId = communityId;
		this.roles = roles;
		List<AResource> resources = new ArrayList<AResource>();
		for(ARole role:roles){
			for(AResource res:role.getResources()){
				if(!resources.contains(res)){
					resources.add(res);
				}
			}
		}
		this.resources = resources;
	}
	public UserVO(long id, String name, String realName, int cateId, String communityId, boolean super_, Set<ARole> roles,String idCardNo) throws UnsupportedTypeException {
		super();
		UserCategoryEnum cateEnum = null;
		UserCategoryEnum[] cates = UserCategoryEnum.values();
		for(UserCategoryEnum cate:cates){
			if(cate.getType()==cateId){
				cateEnum = cate;
				break;
			}
		}
		if(cateEnum==null){
			throw new UnsupportedTypeException("不支持的账户分类ID:"+cateId);
		}
		this.realName = realName;
		this.name = name;
		this.cateEnum = cateEnum;
		this.super_ = super_;
		this.communityId = communityId;
		this.roles = roles;
		List<AResource> resources = new ArrayList<AResource>();
		for(ARole role:roles){
			for(AResource res:role.getResources()){
				if(!resources.contains(res)){
					resources.add(res);
				}
			}
		}
		this.resources = resources;
		this.idCardNo = idCardNo;
	}
	
	
	
	public Set<ARole> getRoles() {
		return roles;
	}
	public void setRoles(Set<ARole> roles) {
		this.roles = roles;
	}
	public List<AResource> getResources() {
		return resources;
	}
	public void setResources(List<AResource> resources) {
		this.resources = resources;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	
	
}
