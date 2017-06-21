/*package com.anticw.aged.service.community.policy;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emay.sdk.service.SMSService;

import com.anticw.aged.bean.PPolicy;
import com.anticw.aged.bean.PPolicyRecommend;
import com.anticw.aged.bean.PUserPolicy;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.dao.community.policy.PolicyDao;
import com.anticw.aged.dao.community.policy.PolicyRecommendedDao;
import com.anticw.aged.service.community.user.RUserService;

@Service
public class PolicyRecommendTask {
	@Autowired
	private PolicyDao policyDao;
	@Autowired
	private PolicyRecommendedDao recommendDao;
	@Autowired
	private RUserService rUserService;
	@Autowired
	private UserPolicyService upolicyService;
	@Autowired
	private SMSService sMSService;
	
	private static Logger logger = LoggerFactory.getLogger(PolicyRecommendTask.class);
	
	//公共服务推荐方法
	public void recommend(){
		logger.debug("Execute Policy Recommend Task");
		List<PPolicy> policys = policyDao.listAll();
		for(PPolicy policy:policys){
			recommendPolicy(policy);
		}
		
	}
	//发送服务推荐短信
	public void sendSms(){
		List<PPolicyRecommend> list = recommendDao.listByMsgSent(CommunityConstants.RECOMMENDMSG0);
		for(PPolicyRecommend recommend:list){
			try {
				RUser ruser = rUserService.findById(recommend.getUserId());
				PPolicy policy = recommend.getPolicy();
				String phone = ruser.getMobilePhone();
				if(phone==null||"".equals(phone)){
					recommend.setMsgSent(CommunityConstants.RECOMMENDMSG2);
					recommendDao.update(recommend);
					continue;
				}
				sMSService.sendSms(phone, policy);
				recommend.setMsgSent(CommunityConstants.RECOMMENDMSG1);
				recommendDao.update(recommend);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;
			}
		}
	}
	private void recommendPolicy(PPolicy policy){
		//判断发布,条件不为空
		if(policy.getCountryId()!=null&&!"".equals(policy.getCountryId())
				&&policy.getConditionsPro()!=null&&!"".equals(policy.getConditionsPro().trim())){
			int count;
			try {
				count = recommendDao.recommendPolicy(policy.getConditionsPro(), policy.getId(), policy.getCountryId(),CommunityConstants.POLICYRECOMMENDSTATE2);
				logger.info("Time:"+new Date()+" Recommend count:"+count+" Policy ID:"+policy.getId());
			} catch (Exception e) {
				logger.error("Time:"+new Date()+" WrongSQL:"+recommendDao.validateSql(policy.getConditionsPro(), policy.getId(), policy.getCountryId(),CommunityConstants.POLICYRECOMMENDSTATE2)+"==policyID:"+policy.getId());
			}
		}
		if(policy.getCountryId()!=null&&!"".equals(policy.getCountryId())
				&&policy.getConditions()!=null&&!"".equals(policy.getConditions().trim())){
			int count;
			try {
				count = recommendDao.recommendPolicy(policy.getConditions(), policy.getId(), policy.getCountryId(),CommunityConstants.POLICYRECOMMENDSTATE0);
				logger.info("Time:"+new Date()+" Recommend count:"+count+" Policy ID:"+policy.getId());
			} catch (Exception e) {
				logger.error("Time:"+new Date()+" WrongSQL:"+recommendDao.validateSql(policy.getConditions(), policy.getId(), policy.getCountryId(),CommunityConstants.POLICYRECOMMENDSTATE2)+"==policyID:"+policy.getId());
			}
		}
	}
	*//**
	 * 查询所有系统推荐的默认已处理公共服务，插入UserPolicy表
	 *//*
	private void saveUserPolicyBySys(){
		List<PPolicyRecommend> list = recommendDao.listByStatus(CommunityConstants.POLICYRECOMMENDSTATE2);
		for(PPolicyRecommend recommend:list){
			RUser ruser = rUserService.findById(recommend.getUserId());
			PUserPolicy up = new PUserPolicy();
			up.setUserId(recommend.getUserId().intValue());
			up.setPolicyId(recommend.getPolicyId());
			upolicyService.saveUserPolicy(up, CommunityConstants.USERPOLICYSTATE6, "system", ruser.getCommunityId());
		}
	}
}
*/