package com.anticw.aged.service.professional.vender.venderfeatureservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.dao.professional.vender.MUserVenderDao;
import com.anticw.aged.dao.professional.vender.VenderUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.user.FeatureUserVO;
import com.anticw.aged.vo.user.FeatureVO;
/**
 * 
 * @author dx 
 *
 */
@Service
public class VenderFeatureService {
	@Autowired
	private VenderUserDao VenderUserDao;
	@Autowired
	private MUserVenderDao mUserVenderDao;
	/**
	 * 服务商  获取符合特征人员
	 * @param userId
	 * @param page
	 * @param pageNum
	 * @param mUserVender
	 * @param oCategoryItem
	 * @param feat
	 * @return
	 */
	public Page<FeatureUserVO> getgetCountAndUserList(int userId, int page, int pageNum,MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat){
		//mUserVenderDao
		return mUserVenderDao.getVenderFeaturePage(userId, page, pageNum, mUserVender, oCategoryItem,feat);
	}
	/**
	 * 服务商  获取符合特征条数
	 * @param venderId
	 * @param oCategoryItem
	 * @param feat
	 * @return
	 */
	public HashMap<String,Long> getCount(int venderId,Map<Integer, String> oCategoryItem,FeatureVO feat){
		return mUserVenderDao.getCount(venderId, oCategoryItem, feat);
	}
	/**
	 * 员工 获取符合特征人员
	 * @param userId
	 * @param page
	 * @param pageNum
	 * @param mUserVender
	 * @param oCategoryItem
	 * @param feat
	 * @param adminId
	 * @return
	 */
	public Page<FeatureUserVO> getUserList(int userId, int page, int pageNum,MUserVender mUserVender,Map<Integer, String> oCategoryItem,FeatureVO feat,int adminId){
		return VenderUserDao.getVenderFeaturePage(userId, page, pageNum, mUserVender, oCategoryItem, feat,adminId);
	}
	/**
	 * 员工 获取符合特征条数
	 * @param venderId
	 * @param oCategoryItem
	 * @param feat
	 * @param adminId
	 * @return
	 */
	public HashMap<String,Long> getStaffCount(int venderId,Map<Integer, String> oCategoryItem,FeatureVO feat,int adminId){
		return VenderUserDao.getCount(venderId, oCategoryItem, feat,adminId);
	}
}
