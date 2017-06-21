package com.anticw.aged.service.professional.activity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.professional.activity.VolunteerDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.vo.professional.activity.VolunteerVO;
import com.anticw.aged.vo.professional.activity.VolunteerVOTwo;

/**
 * Created by WSS on 2015/9/10.<br>
 * 志愿者
 */
@Service
public class VolunteerService {
	@Autowired
	VolunteerDao volunteerDao;

	@Autowired
	private MVenderSiteService mVenderSiteService;

	@Autowired
	private OCountryService oCountryService;

	/**
	 * 添加志愿者
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Serializable addVolunteer(VolunteerVO volunteerVO, long userId)
			throws IllegalAccessException, InvocationTargetException {
		Date date = new Date();
		NVolunteer nVolunteer = new NVolunteer();
		BeanUtils.copyProperties(nVolunteer, volunteerVO);
		nVolunteer.setAvaliable(PropertyValueConstants.AVAILABLE);
		nVolunteer.setCreatedBy(Long.toString(userId));
		nVolunteer.setCreatedAt(date);
		nVolunteer.setChangedAt(date);
		try {
			return volunteerDao.addVolunteer(nVolunteer);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Page<VolunteerVO> seeNVolunteer(int page, int num, String createdBy,
			Integer site) {
		Page<NVolunteer> nVolunteer = volunteerDao.seeNVolunteer(page, num,
				createdBy, site);
		if(nVolunteer.getResult()==null){
			return null;
		}
		List<VolunteerVO> list = getList(nVolunteer.getResult());
		Page<VolunteerVO> volunteerVO = new Page<VolunteerVO>();
		volunteerVO.setPageNo(nVolunteer.getPageNo());
		volunteerVO.setPageSize(nVolunteer.getPageSize());
		volunteerVO.setResult(list);
		volunteerVO.setTotalCount(nVolunteer.getTotalCount());
		return volunteerVO;
	}

	public Page<VolunteerVO> seeNVolunteers(int page, int num,
			String createdBy, String communityIds, Integer site) {
		Page<NVolunteer> nVolunteer = volunteerDao.seeNVolunteers(page, num,
				createdBy, communityIds, site);
		List<VolunteerVO> list = getList(nVolunteer.getResult());
		Page<VolunteerVO> volunteerVO = new Page<VolunteerVO>();
		volunteerVO.setPageNo(nVolunteer.getPageNo());
		volunteerVO.setPageSize(nVolunteer.getPageSize());
		volunteerVO.setResult(list);
		volunteerVO.setTotalCount(nVolunteer.getTotalCount());
		return volunteerVO;
	}

	public Page<VolunteerVO> seeNVolunteers(int page, int num,
			String createdBy, int communityId, Integer site) {
		Page<NVolunteer> nVolunteer = volunteerDao.seeNVolunteers(page, num,
				createdBy, communityId, site);
		List<VolunteerVO> list = getList(nVolunteer.getResult());
		Page<VolunteerVO> volunteerVO = new Page<VolunteerVO>();
		volunteerVO.setPageNo(nVolunteer.getPageNo());
		volunteerVO.setPageSize(nVolunteer.getPageSize());
		volunteerVO.setResult(list);
		volunteerVO.setTotalCount(nVolunteer.getTotalCount());
		return volunteerVO;
	}

	public List<VolunteerVO> getList(List<NVolunteer> nVolunteer) {
		List<VolunteerVO> vos = new ArrayList<VolunteerVO>();
		try {
			for (NVolunteer n : nVolunteer) {
				VolunteerVO vo = new VolunteerVO();
				BeanUtils.copyProperties(vo, n);
				if (n.getSiteId() != null) {
					vo.setSiteId(n.getSiteId());
					vo.setSiteNmae(mVenderSiteService.fingById(n.getSiteId())
							.getSiteName());
				}
				if (n.getCommunity() != null) {
					vo.setCommunity(n.getCommunity());
					String name = oCountryService.getCountryById(
							Integer.parseInt(n.getCommunity())).getName();
					vo.setCommunityNmae(name);
				}
				vos.add(vo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vos;
	}

	/**
	 * 查询全部的志愿者，没有分页
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public List<VolunteerVO> AllListVolunteer(String venderId)
			throws IllegalAccessException, InvocationTargetException {
		List<NVolunteer> list = volunteerDao.findListValue(venderId);
		List<VolunteerVO> list_vo = new ArrayList<VolunteerVO>();
		for (NVolunteer bean : list) {
			VolunteerVO vo = new VolunteerVO();
			BeanUtils.copyProperties(vo, bean);
			list_vo.add(vo);
		}
		return list_vo;
	}

	/**
	 * 返回对应社区下所有的志愿者{有效的}
	 * @param comId
	 * @return
	 */
	public List<VolunteerVO> getCommunity(int comId){
		List<NVolunteer> list = volunteerDao.getCommunity(comId);
		List<VolunteerVO> list_vo = new ArrayList<VolunteerVO>();
		for (NVolunteer bean : list) {
			VolunteerVO vo = new VolunteerVO();
			try {
				BeanUtils.copyProperties(vo, bean);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list_vo.add(vo);
		}
		return list_vo;
    }
	
	
	public List<NVolunteer> seeNVolunteer(String createdBy,
			String communityIds, String siteIds) {
		return volunteerDao.seeNVolunteer(createdBy, communityIds, siteIds);
	}

	public List<NVolunteer> seeNVolunteers(String createdBy,
			String communityIds, String siteIds) {
		return volunteerDao.seeNVolunteers(createdBy, communityIds, siteIds);
	}

	/**
	 * 查志愿者信息 by id
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public List<VolunteerVO> ListById(int id) throws IllegalAccessException,
			InvocationTargetException {
		List<NVolunteer> list = volunteerDao.ListById(id);
		List<VolunteerVO> list_vo = new ArrayList<VolunteerVO>();
		for (NVolunteer bean : list) {
			VolunteerVO vo = new VolunteerVO();
			BeanUtils.copyProperties(vo, bean);
			list_vo.add(vo);
		}
		return list_vo;
	}

	/**
	 * 修改志愿者信息 by id
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void updateById(VolunteerVOTwo volunteerVO, long userId)
			throws IllegalAccessException, InvocationTargetException {
		Date date = new Date();
		NVolunteer nVolunteer = volunteerDao.findVolunteerById(volunteerVO
				.getIds());
		//BeanUtils.copyProperties(volunteerVO ,nVolunteer );
		nVolunteer.setName(volunteerVO.getNamess());
		nVolunteer.setCommunity(volunteerVO.getCommunityids());
		nVolunteer.setAge(volunteerVO.getAges());
		nVolunteer.setSex(volunteerVO.getSexs());
		nVolunteer.setSiteId(volunteerVO.getSiteids());
		nVolunteer.setVersion((short)(nVolunteer.getVersion()+1));
		nVolunteer.setContact(volunteerVO.getContacts());
		nVolunteer.setAvaliable(PropertyValueConstants.AVAILABLE);
		nVolunteer.setChangedBy(Long.toString(userId));
		nVolunteer.setChangedAt(date);
		try {
			volunteerDao.updateById(nVolunteer);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 删除 by id
	 */
	public void deleteById(int volunnteerId, long userId) {
		NVolunteer nVolunteer = volunteerDao.findVolunteerById(volunnteerId);
		nVolunteer.setAvaliable(false);
		nVolunteer.setChangedBy(Long.toString(userId));
		volunteerDao.updateById(nVolunteer);
	}

	/**
	 * 查寻志愿者，根据Ids
	 */
	public List<NVolunteer> findNVolunters(String ids) {
		return volunteerDao.findNVolunters(ids);
	}

	/**
	 * 查寻志愿者
	 * 
	 * @param id
	 * @return
	 */
	public NVolunteer findById(Integer id) {
		return volunteerDao.findVolunteerById(id);
	}

	public List<VolunteerVO> selectByTrainRecordId(Integer trainRecordId,
			String communitys, String siteIds) {
		return volunteerDao.selectByTrainRecordId(trainRecordId, communitys,
				siteIds);

	}

	public List<VolunteerVO> selectTrainRecordId(Integer trainRecordId,
			String communitys, String siteIds) {
		return volunteerDao.selectTrainRecordId(trainRecordId, communitys,
				siteIds);
	}

}
