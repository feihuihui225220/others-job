package com.anticw.aged.service.professional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.dao.professional.vender.MUserVenderDao;
import com.anticw.aged.dao.professional.vender.VenderUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.utils.DateYear;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.assess.ConclusionScreenVO;
import com.anticw.aged.vo.professional.vender.MVenderUsersVO;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.user.AssessUserVO;

@Service
public class MUserVenderService {
	@Autowired
	private MUserVenderDao mUserVenderDao;
	@Autowired
	private VenderUserDao VenderUserDao;
	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private SpringDataPool springDataPool;
	public void save(MUserVender mUserVender){
		mUserVenderDao.save(mUserVender);
	}
	public void delete(MUserVender mUserVender){
		mUserVenderDao.remove(mUserVender);;
	}
	public void deleteUser(int id){
		mUserVenderDao.removeById(id);
	}
	public MUserVender get(int id){
		return mUserVenderDao.get(id);
	}
	public void update(MUserVender mUserVender){
		mUserVenderDao.update(mUserVender);
		
	}
	public Page<VenderServUserVO> getNormalUsersByPage( int venderId, int pageNo, int pageSize,MUserVender mUserVender,String userName){
		Page<MUserVender> mu= mUserVenderDao.getMUserVenderPage(venderId, pageNo, pageSize,mUserVender);
		Page<VenderServUserVO> page=new Page<VenderServUserVO>();
		page.setOrderBy(mu.getOrderBy());
		page.setPageNo(mu.getPageNo());
		page.setPageSize(mu.getPageSize());
		page.setTotalCount(mu.getTotalCount());
		page.setResult(getByList(mu.getResult(),userName));
		return page;
	}
	public Page<VenderServUserVO> getMUserVenderPage( int venderId, int pageNo, int pageSize,MUserVender mUserVender,String userName,String siteIds){
		Page<MUserVender> mu= mUserVenderDao.getMUserVenderPage(venderId, pageNo, pageSize,mUserVender,siteIds);
		Page<VenderServUserVO> page=new Page<VenderServUserVO>();
		page.setOrderBy(mu.getOrderBy());
		page.setPageNo(mu.getPageNo());
		page.setPageSize(mu.getPageSize());
		page.setTotalCount(mu.getTotalCount());
		page.setResult(getByList(mu.getResult(),userName));
		return page;
	}
	public List<VenderServUserVO>  getByList(List<MUserVender> mu,String userName){
		List<VenderServUserVO> list=new ArrayList<VenderServUserVO>();
		String Ids="";
		if(mu.size()!=0){
			for(MUserVender m:mu){
				Ids+=m.getUserId();
				Ids+=",";
			}
			Ids=Ids.substring(0, Ids.length()-1);
		
		
		Map<Long, Long> map=this.getCount(Ids,userName);
		
		for(MUserVender m:mu){
			VenderServUserVO vender=new VenderServUserVO();
			String siteName=null;
			
			if(m.getSiteId()!=null&&mVenderSiteService.fingById(m.getSiteId())!=null){
				siteName=mVenderSiteService.fingById(m.getSiteId()).getSiteName();
			}else{
				siteName="暂未分配";
			}
			vender.setCommunityName(m.getCommunityName());
			vender.setIdCard(m.getUserIdCard());
			vender.setUserName(m.getUserName());
			vender.setGender((int)m.getUserSex());
			vender.setStatus((short)m.getAllocation());
			vender.setSiteName(siteName);
			vender.setUserId(m.getUserId());
			vender.setId(m.getId());
			vender.setSignInCase(map.get(m.getUserId()));
			list.add(vender);
		}
		}
		return list;
	}

	public Map<Long, Long>  getCount(String Ids,String userName){
		
		return mUserVenderDao.getCount(Ids, DateYear.getCurrYearFirst(), DateYear.getCurrYearLast(),userName);
	}
	public Page<MVenderUsersVO> getNormalUsersByPage(long adminId, int pageNo, int pageSize,MUserVender mUserVender,Long siteId){
		return VenderUserDao.getMUserVenderPage(adminId, pageNo, pageSize,mUserVender,siteId);
		
	}
	public List<VenderServUserVO> getNormalUser(long adminId,int venderId){
		return VenderUserDao.getMUserVenderList(adminId, venderId);
		
	}
	public Long getVenderUsersById(RUser rUser, Integer venderId){
		return VenderUserDao.getVenderUsersById(rUser, venderId);
	}
	public Map<Integer,String> getListMUserVerder(long userId){
		Map<Integer,String> map=new HashMap<Integer, String>();
		List<MUserVender>  mu=mUserVenderDao.getListMUserVerder(userId);
		if(mu.size()!=0){
		for(MUserVender m:mu){
			map.put(m.getVenderId(), "存在");
		}
		}
		return map;
	}
	public List<MUserVender>  getListMUser(long userId){
		return mUserVenderDao.getListMUserVerder(userId);
	}
	public MUserVender getMUserVender(long userId,int venderId){
		return mUserVenderDao.getMUserVender(userId, venderId);
	}
	/**
	 * 评估状态
	 * @param vo
	 * @param dateCond
	 * @param pagevo
	 * @return
	 */
	public  Page<AssessUserVO> getdemand(Integer venderId,ConclusionScreenVO vo, DateParamVO dateCond,PageParamVO pagevo){
		
		Page<AssessUserVO>  page=mUserVenderDao.getdemand(venderId,vo, dateCond,pagevo);
		List<AssessUserVO> list=new ArrayList<AssessUserVO>();
		for(AssessUserVO m:page.getResult()){
			String siteName=null;
			if(m.getSiteId()!=null&&mVenderSiteService.fingById(m.getSiteId())!=null){
				siteName=mVenderSiteService.fingById(m.getSiteId()).getSiteName();
			}else{
				siteName="暂未分配";
			}
			OCountry country = springDataPool.getCountry(m.getCommunityId());
			String communityName = country==null?"未知社区":country.getName();
			m.setSiteName(siteName);
			m.setCommunityName(communityName);
			list.add(m);
		}
		page.setResult(list);
		return page;
	}
	/**
	 * 导出评估信息
	 * @author dx
	 * @param vo
	 * @param dateCond
	 * @return
	 */
	@SuppressWarnings("unused")
	public  List<AssessUserVO> demandList(ConclusionScreenVO vo, DateParamVO dateCond,Integer venderId,String userIds,String recordIdsUser){
		List<AssessUserVO> page=mUserVenderDao.demandList(vo, dateCond,venderId,userIds,recordIdsUser);
		List<AssessUserVO> list=new ArrayList<AssessUserVO>();
		for(AssessUserVO m:page){
			AssessUserVO vender=new AssessUserVO();
			String siteName=null;
			if(m.getSiteId()!=null&&mVenderSiteService.fingById(m.getSiteId())!=null){
				siteName=mVenderSiteService.fingById(m.getSiteId()).getSiteName();
			}else{
				
				siteName="暂未分配";
			}
			OCountry country = springDataPool.getCountry(m.getCommunityId());
			String communityName = country==null?"未知社区":country.getName();
			m.setSiteName(siteName);
			m.setCommunityName(communityName);
			list.add(m);
		}
		return list;
	}
}
