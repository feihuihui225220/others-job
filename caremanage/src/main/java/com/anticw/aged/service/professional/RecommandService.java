package com.anticw.aged.service.professional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MRecommand;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.professional.recommand.RecommandDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.recommand.RecQueryCondVO;
import com.anticw.aged.vo.professional.recommand.RecommandVO;

/**
 * 专业服务推荐业务逻辑处理类
 * <P>File name : RecommandService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Service
public class RecommandService {
	
	/**
	 * 专业服务推荐持久化对象
	 */
	@Autowired
	private RecommandDao recDao;
	
 
	
	 
	
	@Autowired
	private PermissionService permissionService;

	/**
	 * 获取专业服务的推荐列表
	 * 由于本期时间紧迫目前采用实时从推荐表中读取的方式 优化空间极大
	 * (1)、短期的优化：使用批量查询减低数据的访问次数，对查询结果进行缓存;
	 * (2)、长远的优化：从底层存储对推荐数据的存储进行sharding，采用NOSQL数据库、通过Hadoop进行静态数据分析、实现数据定向推送等;
	 * 
	 * RecommandService.getRecommand()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param condVo
	 * @param pageParamVo
	 * @return
	 */
	public Page<RecommandVO> getRecommand(RecQueryCondVO condVo, String communityIds, PageParamVO...pageParamVo) throws BusinessException {
		
		//默认分页
		if(pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		
		List<MRecommand> recommands = recDao.query(condVo, communityIds);
		
		//按用户进行汇总的专业服务推荐
		Map<Long, RecommandVO> recommandMap = new LinkedHashMap<Long, RecommandVO>();
		
		//遍历专业服务推荐获取相关信息
		for(Iterator<MRecommand> iter = recommands.iterator(); iter.hasNext();) {
			
		/*	//推荐Id
			MRecommand recommand = iter.next();*/
			//TODO: 如果已开通过滤
			
			//专业服务推荐VO
			//RecommandVO vo = recommandMap.get(recommand.getUserId());
			
			/*//如果推荐vo不在map中则新创建一个
			if(vo == null) {
				
				//创建新的推荐对象并加入map
				vo = new RecommandVO();
				List<ServiceExVO> vos = new ArrayList<ServiceExVO>();
				vo.setServices(vos);
				recommandMap.put(recommand.getUserId(), vo);
				
				//获取用户信息
				RUser user = userService.findById(recommand.getUserId());
				if(user == null) {
					continue;
				}
				
				//基本信息设置
				vo.setName(user.getName());
				vo.setIdCard(user.getIdCardNo());
				vo.setConcatPhone(user.getContactPhone());
			}*/
			
		/*	//专业服务信息
			try{
				ServiceVO	specVo = specService.get(recommand.getServiceId());
			}catch(Exception e) {
				continue;
			}*/
			
			// 推荐去重
			/*boolean exit = false;
			for(ServiceExVO seVO:vo.getServices()){
				if(seVO.getId() == specVo.getId()){
					exit = true;
				}
			}*/
			
			//过滤已开通的推荐服务
			/*if(specService.validateServiceHasBeanOpend(specVo.getId(),recommand.getUserId())){
				continue;
			}*/
			
			// 没有推荐过且没有开通过  加入推荐集合
			/*if (!exit) {
				// 创建新的serviceVO
				ServiceExVO serviceVo = new ServiceExVO();
				serviceVo.setRecommandId(recommand.getId());// 推荐Id
				serviceVo.setId(specVo.getId()); // 专业服务Id
				serviceVo.setName(specVo.getName()); // 专业服务名称
				serviceVo.setContent(specVo.getContent()); // 服务内容
				serviceVo.setStatus(recommand.getStatus()); // 推荐状态
				serviceVo.setPicture(specVo.getPicture());
				serviceVo.setStandard(specVo.getStandard());

				vo.getServices().add(serviceVo);
			}*/
		}
		
		//分页设置
		Page<RecommandVO> mRecommands = new Page<RecommandVO>();
		Collection<RecommandVO> results = recommandMap.values();
		int page = pageParamVo[0].getPage();
		int num = pageParamVo[0].getNum();
		mRecommands.setPageNo(page);
		mRecommands.setPageSize(num);
		mRecommands.setTotalCount(results.size());
		int statrOfPage = Page.getStartOfPage(page,num);
		List<RecommandVO> result = new ArrayList<RecommandVO>();
		int i = 0;
		for (RecommandVO rv : results) {
			i++;
			if (i < statrOfPage || i >= statrOfPage + num) {
				continue;
			}
			result.add(rv);
		}
		mRecommands.setResult(result);
		return mRecommands;
	}
	
	/**
	 * 更新推荐状态
	 * RecommandService.updateRecommandStatus()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param recommandId
	 * @param status
	 * @throws BusinessException
	 */
	public void updateRecommandStatus(Long recommandId, Short status) throws BusinessException {
		
		//获取推荐信息
		MRecommand mRecommand = recDao.get(recommandId);
		if(mRecommand == null) {
			throw new BusinessException(ExceptionCode.RECOMMAND_NOT_FOUND);
		}
		
		//设置推荐状态
		mRecommand.setStatus(status);
		
		//更新状态
		recDao.update(mRecommand);
	}
	
	/**
	 * 推荐服务
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午7:21:11
	 */
	public void recommandServer(){
		// 1.获取所有CM用户列表
		List<AUser> cms = this.permissionService.getUserByCategory(UserCategoryEnum.CM);
		// 2.循环获取cm的服务商ID列表
		for(AUser cm: cms){
			List<Object[]> venders = this.recDao.venderServiceByCM(cm.getName());
			for(Object[] arr: venders){
				int venderId = (Integer) arr[0];
				int serviceId = (Integer) arr[1];
				int categoryId = (Integer) arr[2];
				// 3.查询该服务可推荐的用户列表
				List<Object[]> users = this.recDao.venderRecUser(cm.getCommunityIds(), venderId, serviceId, categoryId);
				for(Object[] user:users){
					Long userId = ((BigInteger)user[0]).longValue();
					String userName = (String)user[1];
					String idCard = (String)user[2];
					// 3.保存推荐数据
					this.recDao.save(new MRecommand(userId, userName, idCard, categoryId, serviceId));
				}
			}
		}
	}
}
