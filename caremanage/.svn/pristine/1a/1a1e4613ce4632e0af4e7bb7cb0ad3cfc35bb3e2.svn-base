/*package com.anticw.aged.service.community.policy;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.PPolicy;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.dao.community.policy.PolicyAttDao;
import com.anticw.aged.dao.community.policy.PolicyDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.vo.community.UserPolicyCertVo;
@Service
public class PolicyService {
	
	
	@Autowired
	private PolicyDao policyDao;
	@Autowired
	private SpringDataPool pool;
	*//**
	 * 添加政策
	 * 李飞
	 * 2014-10-1 12:10:26
	 *//*
	public void savePolicy(PPolicy policy,String opUser,MultipartFile[] files){
		Date date = new Date();
		if(policy.getId()==null){
			policy.setCreatedAt(date);
			policy.setCreatedBy(opUser);
			policy.setVersion(CommunityConstants.DEFAULT_VERSION);
		}
		if(policy.getReceive()==null){
			policy.setReceive(CommunityConstants.NO);
		}
		if(policy.getApprove()==null){
			policy.setApprove(CommunityConstants.NO);
		}
		policy.setAvailable(CommunityConstants.AVAILABLE);
		policy.setChangedAt(date);
		policy.setChangedBy(opUser);
		policyDao.saveOrUpdate(policy);
		if(files!=null&&files.length>0){
			for(MultipartFile file:files){
				if(!file.isEmpty()){
					String[] directory = attchmentHandle.upload(CommunityConstants.POLICYATTTYPE, new MultipartFile[]{file});
					PPolicyAtt policyAtt = new PPolicyAtt(directory[0], policy.getId());
					policyAtt.setFileName(file.getOriginalFilename());
					policyAttDao.save(policyAtt);
				}
			}
		}
	}
	*//**
	 * 编辑政策
	 * 李飞
	 * 2014-10-6
	 *//*
	public void editPolicy(PPolicy p,String opUser,MultipartFile[] files){
		Date date = new Date();
		PPolicy orgPolicy = policyDao.getById(p.getId());
		orgPolicy.setTitle(p.getTitle());
		orgPolicy.setUnit(p.getUnit());
		orgPolicy.setNumber(p.getNumber());
		orgPolicy.setAccept(p.getAccept());
		orgPolicy.setContent(p.getContent());
		orgPolicy.setConditions(p.getConditions());
		orgPolicy.setConditionsPro(p.getConditionsPro());
		orgPolicy.setCategoryId(p.getCategoryId());
		orgPolicy.setApprove(p.getApprove()==null?CommunityConstants.NO:p.getApprove());
		orgPolicy.setReceive(p.getReceive()==null?CommunityConstants.NO:p.getReceive());
		orgPolicy.setCertificate(p.getCertificate());
		orgPolicy.setHandleCond(p.getHandleCond());
		orgPolicy.setChangedAt(date);
		orgPolicy.setChangedBy(opUser);
		policyDao.saveOrUpdate(orgPolicy);
		if(files!=null&&files.length>0){
			for(MultipartFile file:files){
				if(!file.isEmpty()){
					String[] directory = attchmentHandle.upload(CommunityConstants.POLICYATTTYPE, new MultipartFile[]{file});
					PPolicyAtt policyAtt = new PPolicyAtt(directory[0], orgPolicy.getId());
					policyAtt.setFileName(file.getOriginalFilename());
					policyAttDao.save(policyAtt);
				}
			}
		}
	}
	*//**
	 * 逻辑删除政策
	 * 李飞
	 * 2014-10-1 12:31:21
	 *//*
	public void deletePolicy(int id,String opUser){
		policyDao.removePolicy(id,opUser);
	}
	*//**
	 * 根据id获取
	 * 李飞
	 * 2014-10-1 12:33:02
	 *//*
	public PPolicy getById(int id){
		return policyDao.getById(id);
	}
	
	*//**
	 * 按分类获取社区所有政策
	 * 李飞
	 * 2014-10-7
	 *//*
	public Map<String,List<PPolicy>> getCommPolicyMap(String communityId){
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> catgory = pool.getOCategory();
		Map<Integer, OCategoryItem> catMap = catgory.get(CategoryEnum.POLICY.getIndex());
		Map<String,List<PPolicy>> plistMap = new HashMap<String, List<PPolicy>>();
		for(Entry<Integer, OCategoryItem> i:catMap.entrySet()){
			List<PPolicy> catelist = policyDao.getCommPolicy(communityId, i.getValue().getId());
			plistMap.put(i.getValue().getId()+"", catelist);
		}
		return plistMap;
	}
	*//**
	 * 分页获取所有政策
	 * 李飞
	 * 2014-10-1 16:15:28
	 *//*
	public Page<PPolicy> getPolicyByPage(int page,int size){
		return policyDao.getByPage(page, size);
	}
	*//**
	 * 分页获取社区下政策
	 * 李飞
	 * 2014-10-1 16:17:40
	 *//*
	public Page<PPolicy> getCommunityPolicyByPage(int page,int size,int communityId){
		return policyDao.getCommByPage(page, size, communityId);
	}
	*//**
	 * 发布政策到社区
	 * 李飞
	 * 2014-10-1 16:21:33
	 * @param country_id 以,分隔
	 *//*
	public void publishPolicy(int id,String countryId,String opUser){
		policyDao.publish(id, countryId, opUser);
	}
	*//**
	 * 删除政策附件
	 * 李飞
	 * 2014-10-1 16:40:34
	 *//*
	public void deletePolicyAtt(int id){
		attchmentHandle.remove(policyAttDao.get(id).getDirectory());
		policyAttDao.deletePolicyAtt(id);
	}
	*//**
	 * 获取政策附件
	 * @param policyId
	 * @return
	 *//*
	public List<PPolicyAtt> getPolicyAtts(int policyId){
		return policyAttDao.list(policyId);
	}
	*//**
	 * 获取政策所需的证明
	 * 李飞
	 *//*
	public List<UserPolicyCertVo> getPolicyCertifactes(int policyId,Long userId){
		return policyDao.getCertifactes(policyId,userId);
	}

}
*/