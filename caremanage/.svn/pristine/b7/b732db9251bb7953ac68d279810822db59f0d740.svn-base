/*package com.anticw.aged.service.community.policy;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.PPolicyRecommend;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.dao.community.policy.PolicyRecommendedDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.community.PolicyRecommendVo;

@Service
public class PolicyRecommendedService {
	
	@Autowired
	private PolicyRecommendedDao  policyRecommendedDao;
	
	*//**
	 * 根据id获取政策推荐
	 * @param id
	 * @return
	 *//*
	public PPolicyRecommend  findPolicyRecommendById(int id){
		return policyRecommendedDao.findPolicyRecommendById(id);
	}
	*//**
	 * 根据userid获取
	 * @param userid
	 * @return
	 *//*
	public List<PPolicyRecommend> findPolicyRecommendByUserId(int userid){
		return policyRecommendedDao.getRecommendbyUserId(Long.valueOf(userid));
	}
	
	*//**
	 * 根据状态获取所有推荐信息
	 * @param status
	 * @return
	 *//*
	public List<PPolicyRecommend> listByStatus(int status){
		return policyRecommendedDao.listByStatus(status);
	}
	
	*//**
	 * 根据userId获取分页列表
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 *//*
	public Page<PPolicyRecommend> findPageByUserId(Long userId,int pageNo,int pageSize){
		return policyRecommendedDao.getPageByUserId(userId, pageNo, pageSize);
	}
	
	*//**
	 * 获取社区政策推荐
	 * @param page
	 * @param size
	 * @param communityId
	 * @return Page<PolicyRecommendVo>
	 *//*
	public Page<PolicyRecommendVo> listPageByCommID(int page,int size,String communityIds){
		List<PolicyRecommendVo> list = policyRecommendedDao.listByCommunityId(page, size, communityIds,CommunityConstants.POLICYRECOMMENDSTATE0);
		int count = policyRecommendedDao.count(communityIds, CommunityConstants.POLICYRECOMMENDSTATE0);
		for(PolicyRecommendVo policyRecommendVo:list){
			List<PPolicyRecommend> recommendList = policyRecommendedDao.getRecommendbyUserId(policyRecommendVo.getUserId().longValue());
			policyRecommendVo.setList(recommendList);
		}
		Page<PolicyRecommendVo> rpage = new Page<PolicyRecommendVo>();
		rpage.setResult(list);
		rpage.setTotalCount(count);
		rpage.setPageNo(page);
		rpage.setPageSize(size);
		return rpage;
	}
	*//**
	 * 处理状态置为1
	 * @param id
	 *//*
	public void setRecommendtoDone(int id){
		policyRecommendedDao.setRecommendstatus(id, CommunityConstants.POLICYRECOMMENDSTATE1);
	}

}
*/