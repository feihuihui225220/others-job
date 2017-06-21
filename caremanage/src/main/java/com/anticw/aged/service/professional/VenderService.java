package com.anticw.aged.service.professional;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MAlarmThreshold;
import com.anticw.aged.bean.MMessage;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.MReport;
import com.anticw.aged.bean.MStateCategory;
import com.anticw.aged.bean.MUserState;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.MVenderEvaluation;
import com.anticw.aged.bean.MVenderService;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.permission.UserDao;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.dao.professional.vender.AlarmThresholdDao;
import com.anticw.aged.dao.professional.vender.MsgDao;
import com.anticw.aged.dao.professional.vender.ReportDao;
import com.anticw.aged.dao.professional.vender.StateDao;
import com.anticw.aged.dao.professional.vender.UserStateDao;
import com.anticw.aged.dao.professional.vender.VenderDao;
import com.anticw.aged.dao.professional.vender.VenderEvaluationDao;
import com.anticw.aged.dao.professional.vender.VenderServiceDao;
import com.anticw.aged.dao.professional.vender.VenderUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.meta.DataModuleItemVO;
import com.anticw.aged.vo.professional.meta.DataModuleVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.professional.upload.SubjectTeacherVO;
import com.anticw.aged.vo.professional.vender.VenderDistrVO;
import com.anticw.aged.vo.professional.vender.VenderEvaVO;
import com.anticw.aged.vo.professional.vender.VenderServUserVO;
import com.anticw.aged.vo.professional.vender.VenderVO;
import com.anticw.aged.vo.professional.vender.alarm.AlarmSetVO;
import com.anticw.aged.vo.professional.vender.state.MobileStateVo;
import com.anticw.aged.vo.professional.vender.state.StateParamVO;
import com.anticw.aged.vo.professional.vender.state.StateQueryResultVO;
import com.anticw.aged.vo.professional.vender.state.StateVO;

/**
 * 专业服务商相关业务逻辑处理类
 * <P>File name : VenderService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
@Service
public class VenderService {
	
	/************************************************************************专业服务商管理*********************************************************************/
	
	/**
	 * 专业服务商持久化对象
	 */
	@Autowired
	private VenderDao venderDao;
	
	/**
	 * 服务商评价持久化对象
	 */
	@Autowired
	private VenderEvaluationDao venderEvaluationDao; 
	
	/**
	 * 服务商用户分配持久化对象
	 */
	@Autowired
	private VenderUserDao venderUserDao;
	
	/**
	 * 服务商服务类别持久化对象
	 */
	@Autowired
	private VenderServiceDao venderServiceDao;
	
	/**
	 * 权限业务逻辑处理类
	 */
	@Autowired
	private PermissionService permissionService;
	
	 
	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	private SpecService specService;
	
	@Autowired
	private OCountryService countryService;
	/** 数据缓存类 */
	@Autowired
	private SpringDataPool springDataPool;
	/** 查询用户*/
	@Autowired
	private UserDao userDao;
	/**
	 * 获取服务商服务的用户(已下单)列表（包含未分配）
	 * @author guoyongxiang
	 * Date: 2014-10-18 下午4:27:10
	 * @param communityIds	当前服务商社区ID集合
	 * @param venderId		当前服务商ID
	 * @param status		用户状态(-1全部，0未分配，1已分配)
	 * @param page
	 * @param num
	 * @return
	 */
	public  Page<VenderServUserVO> getVenderSevUsersPage(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status,int page,int num){
		 Page<VenderServUserVO>  vo = this.venderUserDao.getSevUsersPage(super_, adminId, name, idCard, communityIds, venderId, status,page, num);
		return vo;
	}
	/**
	 * 
	 * @param super_
	 * @param adminId
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @param page
	 * @param num
	 * @return
	 */
	public  Page<RUser> getUsersPage(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status,int page,int num){
		Page<RUser>  vo = this.venderUserDao.pageUser(name, idCard,page,num);
		return vo;
	}
	
	
	public AUser getAUser(Serializable id){
		return userDao.get(id);
	}
	public AUser getAUserByName(String name){
		return userDao.findByName(name);
	}
	
	/**
	 * 加上社区
	 * @param super_
	 * @param adminId
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @param page
	 * @param num
	 * @param communityId
	 * @return
	 */
	public  Page<VenderServUserVO> getVenderSevUsersPages(boolean super_, Integer adminId, String name, String idCard,Integer venderId, short status,int page,int num,int communityId,int planId,String userName,String siteId){
		OCountry country=new OCountry();
		if(communityId!=0){
			country = this.countryService.getCountryById(communityId);
		}else{
			country.setName("1");
		}
		Page<VenderServUserVO>  vo = this.venderUserDao.getSevUser(super_, adminId, name, idCard, venderId, status,page, num,country.getName(),planId,userName,siteId);
		return vo;
	}
	
	/**
	 * 查询服务的用户列表
	 * @author guoyongxiang
	 * Date: 2014-10-19 下午8:31:34
	 * @param name
	 * @param idCard
	 * @param communityIds
	 * @param venderId
	 * @param status
	 * @return
	 */
	public List<VenderServUserVO> getSevUsers(boolean super_, Integer adminId, String name, String idCard, String communityIds, Integer venderId, short status){
		List<VenderServUserVO> vo=venderUserDao.getSevUsers(super_, adminId, name, idCard, communityIds, venderId, status);
		for(VenderServUserVO user:vo){
			OCountry country = springDataPool.getCountry(user.getCommunityId());
			String communityName = country==null?"未知社区":country.getName();
			user.setCommunityName(communityName);
		}
		return vo;
	}
	/**
	 * 员工查询老人签到情况（全部人员展示）
	 * @param activityId
	 * @param userName
	 * @return
	 */
	public List<VenderServUserVO> getSevUser( Integer activityId,String userName,long adminId,Integer venderId){
		List<VenderServUserVO> vo=this.venderUserDao.getSevUser(activityId,userName,adminId,venderId);
		return vo;
	}
	
	/**
	 * 获取服务商列表
	 * VenderService.listVenders()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param cmName
	 * @param venderName
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<VenderVO> listVenders(String cmName, String venderName, PageParamVO pageCond) throws BusinessException {
		
		//获取服务商列表
		Page<MVender> page = venderDao.listVenders(cmName, venderName, pageCond.getPage(), pageCond.getNum());
		
		return getVenderVos(page);
	}
	/**
	 * 根据社区id获取服务行列表
	 * @param communityIds
	 * @param venderName
	 * @param pageCond
	 * @return
	 */
	public Page<VenderVO> listVendersByCommunityIds(String communityIds,String venderName,PageParamVO pageCond){
		Page<MVender> page = venderDao.listVendersByCommunityIds(communityIds, venderName, pageCond.getPage(), pageCond.getNum());
		return getVenderVos(page);
	}
	/**
	 * 根据创建者查询服务商
	 * @param createdBy
	 * @param venderName
	 * @param pageCond
	 * @return
	 */
	public Page<VenderVO> listVendersByCreatedBy(String createdBy,String venderName,PageParamVO pageCond){
		Page<MVender> page = venderDao.listVendersByCreatedBy(createdBy, venderName, pageCond.getPage(), pageCond.getNum());
		return getVenderVos(page);
	}
	/**
	 * 构建服务商信息简报
	 * @param page
	 * @author L
	 * @return
	 */
	private Page<VenderVO> getVenderVos(Page<MVender> page){
		//服务商集合
		List<VenderVO> venderVos = new ArrayList<VenderVO>();
		List<MVender> _venders = page.getResult();
				
		//遍历集合构建服务商信息简报
		for(Iterator<MVender> iter = _venders.iterator(); iter.hasNext();) {
			
			MVender vender = iter.next();
			
			VenderVO vo = new VenderVO();
			vo.setId(vender.getId());
			vo.setCmName(vender.getCmName());
			vo.setName(vender.getName());
			vo.setCategoryId(vender.getCategoryId());
			vo.setStar(vender.getStar());
			vo.setUserId(vender.getUserId());
			vo.setContactPhone(vender.getContactPhone());
			vo.setContactAddr(vender.getContactAddr());
			vo.setContact(vender.getContact());
			vo.setQualification(vender.getQualification());
			vo.setIntroduction(vender.getIntroduction());
			
			//获取管理员
			AUser user = permissionService.getById(vender.getUserId());
			vo.setUserName(user.getName());
			
			//设置分类名称
			//OCategoryItem item = categoryItemService.getOCategoryItemById(vender.getCategoryId());
			//vo.setCategoryName(item.getItemName());
			
			venderVos.add(vo);
		}
		
		Page<VenderVO> _page = new Page<VenderVO>();
		_page.setResult(venderVos);
		_page.setTotalCount(page.getTotalCount());
		_page.setPageNo(page.getPageNo());
		_page.setPageSize(page.getPageSize());
		
		return _page;
	}
	
	/**
	 * 增加服务商
	 * VenderService.addVender()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderVo
	 * @param userName
	 * @param communityIds
	 * @throws BusinessException
	 */
	public void addVender(String cmName, VenderVO venderVo, String userName, String communityIds) throws BusinessException {
		
		//新增
		MVender vender = new MVender();
		vender.setCmName(cmName);
		vender.setCategoryId(venderVo.getCategoryId());
		vender.setStar((short)0);
		vender.setQualification(venderVo.getQualification() == null ? "" : venderVo.getQualification());
		vender.setCreatedBy(userName);
		vender.setCreatedAt(new Date());
		vender.setChangedBy(userName);
		vender.setChangedAt(new Date());
		vender.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		vender.setCommunityIds(communityIds);
		vender.setLongitude(venderVo.getLongitude());
		vender.setLatitude(venderVo.getLatitude());
		
		//创建管理员
		AUser user = new AUser(venderVo.getUserName(), venderVo.getPassword(), null, (short)UserCategoryEnum.PRO.getType(), communityIds);
		user = permissionService.saveManager(user, userName);
		
		//设置用户Id
		vender.setUserId(user.getId());
		
		//设置联系人
		vender.setContact(user.getName());
		
		//更新属性
		vender.setName(venderVo.getName());
		vender.setContactPhone(venderVo.getContactPhone());
		vender.setContactAddr(venderVo.getContactAddr());
		vender.setIntroduction(venderVo.getIntroduction());
		
		//持久化
		venderDao.saveOrUpdate(vender);
		
		//专业服务上设置服务商id
		user.setVenderId(vender.getId());
		
		permissionService.updateUser(user, false);
	}
	
	/**
	 * 保存对服务商信息的修改
	 * VenderService.commitModify()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderVo
	 * @param userName
	 * @throws BusinessException
	 */
	public void commitModify(VenderVO venderVo, String userName) throws BusinessException {
		
		//查询服务商信息
		MVender vender = venderDao.get(venderVo.getId());
		
		//更新属性
		vender.setName(venderVo.getName());
		vender.setContactPhone(venderVo.getContactPhone());
		vender.setContactAddr(venderVo.getContactAddr());
		vender.setIntroduction(venderVo.getIntroduction());
		vender.setChangedAt(new Date());
		vender.setChangedBy(userName);
		vender.setLongitude(venderVo.getLongitude());
		vender.setLatitude(venderVo.getLatitude());
		
		//持久化
		venderDao.update(vender);
	}
	
	/**
	 * 获取服务商详情
	 * VenderService.getVenderVo()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public VenderVO getVenderVo(Integer id) throws BusinessException {
		
		//获取服务商信息
		MVender vender = venderDao.get(id);
		
		//获取管理员
		AUser user = permissionService.getById(vender.getUserId());
		
		VenderVO venderVo = new VenderVO();
		venderVo.setId(vender.getId());
		venderVo.setName(vender.getName());
		venderVo.setCategoryId(vender.getCategoryId());
		venderVo.setStar(vender.getStar());
		venderVo.setUserId(vender.getUserId());
		venderVo.setUserName(user.getName());
		venderVo.setContactPhone(vender.getContactPhone());
		venderVo.setContactAddr(vender.getContactAddr());
		venderVo.setContact(vender.getContact());
		venderVo.setQualification(vender.getQualification());
		venderVo.setIntroduction(vender.getIntroduction());
		venderVo.setLongitude(vender.getLongitude());
		venderVo.setLatitude(vender.getLatitude());
		
		//OCategoryItem item = categoryItemService.getOCategoryItemById(vender.getCategoryId());
		//venderVo.setCategoryName(item.getItemName());
		
		return venderVo;
	}



	/**
	 * 获取评价列表
	 * VenderService.queryVenderEvaluations()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param dateCond
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<MVenderEvaluation> queryVenderEvaluations(Integer venderId, DateParamVO dateCond, PageParamVO pageCond) throws BusinessException {
		return this.venderEvaluationDao.listByPageAndDate(venderId, dateCond.getStart(), dateCond.getEnd(), pageCond.getPage(), pageCond.getNum());
	}
	
	/**
	 * 获取评估详情
	 * VenderService.queryVenderEvaluation()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param evaId
	 * @return
	 * @throws BusinessException
	 */
	public MVenderEvaluation queryVenderEvaluation(Integer venderId, Integer evaId) throws BusinessException {
		MVenderEvaluation eva = venderEvaluationDao.getByVenderAndId(venderId, evaId);
		if(eva == null) {
			throw new BusinessException(ExceptionCode.VENDER_EVA_NOT_FOUND);
		}
		return eva;
	}
	
	/**
	 * 统计或者增加评价信息 
	 * VenderService.addVenderEva()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param vo
	 * @throws BusinessException
	 */
	public void calcOrAddVenderEva(Integer type, VenderEvaVO vo, String userName) throws BusinessException {
		
		if(type == 0) {//统计数据
			
			//统计的开始和结束时间
			Date startTime = vo.getStartTime();
			Date endTime = vo.getEndTime();
			
			//当前服务人数
			int curServCount = venderUserDao.getServCount(vo.getVenderId(), startTime, endTime);
			
			//获取同期时间
			Calendar c1 = Calendar.getInstance();
			c1.setTime(startTime);
			c1.roll(Calendar.MONTH, -1);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(endTime);
			c2.roll(Calendar.MONTH, -1);
			Date historyStartTime = c1.getTime(); 
			Date historyEndTime = c2.getTime();
			
			//历史数据
			int historyServCount = venderUserDao.getServCount(vo.getVenderId(), historyStartTime, historyEndTime);
			
			//变化的人数
			int chgServCount = curServCount - historyServCount;
			
			//设置变化的人数
			vo.setServerCount((short)curServCount);
			vo.setIncCount(chgServCount > 0 ? (short)chgServCount : 0);
			vo.setDincCount(chgServCount < 0 ? (short)chgServCount : 0);
			
		} else if(type == 1) {//提交
			
			//是否已经存在
			// boolean isExists =
			// venderEvaluationDao.hasEvalute(vo.getVenderId(),
			// vo.getStartTime(), vo.getEndTime());
			// if(isExists) {
			// throw new BusinessException(ExceptionCode.VENDER_HAS_EVALUTE);
			// }
			
			MVenderEvaluation eva = new MVenderEvaluation();
			eva.setVenderId(vo.getVenderId());
			eva.setStartTime(vo.getStartTime());
			eva.setEndTime(vo.getEndTime());
			eva.setServerCount(vo.getServerCount());
			eva.setIncCount(vo.getIncCount());
			eva.setDincCount(vo.getDincCount());
			eva.setQuestion(vo.getQuestion());
			eva.setEvaluation(vo.getEvaluation());
			eva.setStar(vo.getStar());
			eva.setCreatedAt(new Date());
			eva.setCreatedBy(userName);
			venderEvaluationDao.save(eva);
			
			//更新服务商的星级
			MVender vender = venderDao.get(eva.getVenderId());
			vender.setStar(eva.getStar());
			venderDao.update(vender);
		}
	}
	
	/**
	 * 获取服务商用户分配列表
	 * VenderService.queryVenderServerUsers()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param userName
	 * @param idCard
	 * @param status
	 * @param pageCond
	 * @return
	 * @throws BusinessException
	 */
	public Page<VenderServUserVO> queryVenderServerUsers(Integer venderId, PageParamVO pageCond) throws BusinessException {
		return venderUserDao.queryVenderServerUsers(venderId, pageCond.getPage(), pageCond.getNum());
	}
	
	/**
	 * 获取指定服务商员工已分配用户数量
	 * VenderService.getDistrUserCount()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @return
	 */
	public Map<Integer, Integer> getDistrUserCount(Integer venderId) {
		return venderUserDao.queryVenderServerUsers(venderId);
	}
	
	public void update(RUser r) {
		venderUserDao.update(r);
	}
	
	public List<VenderDistrVO> getVenderUsers(UserVO userVo) throws BusinessException{
		//返回值
		List<VenderDistrVO> vos = new ArrayList<VenderDistrVO>();
		//员工已分配用户数量
		Map<Integer, Integer> countMap = getDistrUserCount(userVo.getVenderId());
		//获取服务用户集合
		List<AUser> _users = permissionService.getVenderAdmins(userVo.getName());
		
		//创建人员分配信息
		for(Iterator<AUser> iter = _users.iterator(); iter.hasNext();) {
			
			//服务人员
			AUser user = iter.next();
			if(user.getVenderId()==null || user.getVenderId()!=userVo.getVenderId()){
				continue;
			}
			//服务商人员分配信息
			VenderDistrVO vo = new VenderDistrVO();
			vo.setAdminId(user.getId());
			vo.setAdminName(user.getName());
			vo.setCount(countMap.get(user.getId()) == null ? 0 : countMap.get(user.getId()));
			
			vos.add(vo);
		}
		
		return vos;
	}
	/**
	 * 获取已分配的用户数量
	 * VenderService.getDistrUsers()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param userId
	 * @param userName
	 * @return
	 * @throws BusinessException
	 */
	public List<VenderDistrVO> getDistrUsers(Integer venderId, Long userId, String userName) throws BusinessException {
		
		//返回值
		List<VenderDistrVO> vos = new ArrayList<VenderDistrVO>();
		
		//员工已分配用户数量
		Map<Integer, Integer> countMap = getDistrUserCount(venderId);
		
		//获取服务用户集合
		Page<AUser> users = permissionService.getNormalUsers(userName, (short)UserCategoryEnum.PRO.getType(), true, venderId, 1, 1000);
		List<AUser> _users = users.getResult();
		
		//创建人员分配信息
		for(Iterator<AUser> iter = _users.iterator(); iter.hasNext();) {
			
			//服务人员
			AUser user = iter.next();
			if(user.getVenderId()==null || user.getVenderId()!=venderId){
				continue;
			}
			//服务商人员分配信息
			VenderDistrVO vo = new VenderDistrVO();
			vo.setAdminId(user.getId());
			vo.setAdminName(user.getName());
			vo.setCount(countMap.get(user.getId()) == null ? 0 : countMap.get(user.getId()));
			
			vos.add(vo);
		}
		
		return vos;
	}
	
	/**
	 * 分配用户
	 * VenderService.distrUser()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param vo
	 * @throws BusinessException
	 */
	public void distrUser(VenderDistrVO vo,RUser r) throws BusinessException {
		this.venderUserDao.distrUser(vo,r);
	}
	
	/** 
	 * 专业服务商获取老年人分配信息
	 * @name VenderService.getVenderDistrVO()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午3:55:21
	 * @param userId
	 * @param venderId TODO
	 * @return
	 * @throws BusinessException     
	 */
	public VenderDistrVO getVenderDistrVO(Long userId, Integer venderId) throws BusinessException {
		return venderUserDao.getByUser(userId, venderId);
	}
	
	/**
	 * 获取服务商服务类别
	 * VenderService.getVenderServices()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @return
	 * @throws BusinessException
	 */
	public List<MVenderService> getVenderServices(Integer venderId) throws BusinessException {
		List<MVenderService> services = venderServiceDao.findAll(venderId);
		for(Iterator<MVenderService> iter = services.iterator(); iter.hasNext();) {
			MVenderService service = iter.next();
			ServiceVO vo = this.specService.getServiceBrief(service.getServiceId());
			service.setServiceName(vo.getName());
		}
		return services;
	}
	
	/**
	 * 删除服务信息
	 * VenderService.deleteVenderService()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param id
	 * @throws BusinessException
	 */
	public void deleteVenderService(Integer id) throws BusinessException {
		venderServiceDao.removeById(id);
	}
	
	/**
	 * 获取未选择的服务
	 * VenderService.getUnCheckServices()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @return
	 * @throws BusinessException
	 */
	public List<ServiceVO> getUnCheckServices(Integer venderId) throws BusinessException {
		
		//服务商
		MVender vender = this.venderDao.get(venderId);
		
		//已选择服务
		List<MVenderService> services = getVenderServices(venderId);
		
		//获取全部服务
		List<ServiceVO> _services = specService.getServicesBrief(vender.getCategoryId());
		
		//从全部服务中删除已选择的服务
		for(Iterator<MVenderService> iter = services.iterator(); iter.hasNext();) {
			MVenderService checkService = iter.next();
			for(Iterator<ServiceVO> _iter = _services.iterator(); _iter.hasNext();) {
				ServiceVO serviceVO = _iter.next();
					if(serviceVO.getId() == checkService.getServiceId()) {
						_iter.remove();
				}
			}
		}
		
		return _services;
	}
	
	/**
	 * 添加服务
	 * VenderService.addVenderService()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @param serviceId
	 * @throws BusinessException
	 */
	public void addServices(Integer venderId, String[] serviceIds) throws BusinessException {
		for(String serviceId : serviceIds) {
			MVenderService service = new MVenderService();
			service.setVenderId(venderId);
			service.setServiceId(Integer.parseInt(serviceId));
			this.venderServiceDao.save(service);
		}
	}
	
	/**
	 * 删除服务项目
	 * VenderService.removeServices()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param venderId
	 * @param serviceId
	 * @throws BusinessException
	 */
	public void removeServices(Integer venderId, Integer serviceId) throws BusinessException {
		venderServiceDao.remove(venderId, serviceId);
	}
	
	/**
	 * 获取提供指定服务的服务商信息
	 * VenderService.getVenders()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param serviceId
	 * @return
	 * @throws BusinessException
	 */
	public List<VenderVO> getVenders(Integer serviceId) throws BusinessException {
		
		//服务集合
		List<VenderVO> venders = new ArrayList<VenderVO>();
		
		//获取提供指定服务的服务信息
		List<MVenderService> venderServices = venderServiceDao.findByServiceId(serviceId);
		if(venderServices == null || venderServices.isEmpty()) {
			return venders;
		}
		
		//拼接in查询条件
		StringBuilder ids = new StringBuilder("");
		for(int i = 0; i < venderServices.size(); i++) {
			MVenderService service = venderServices.get(i);
			ids.append(service.getVenderId());
			if(i < venderServices.size() - 1) {
				ids.append(",");
			}
		}
		
		//获取服务商集合
		List<MVender> _venders = this.venderDao.getByIds(ids.toString());
		
		for(Iterator<MVender> iter = _venders.iterator(); iter.hasNext();) {
			MVender vender = iter.next();
			VenderVO vo = new VenderVO();
			vo.setId(vender.getId());
			vo.setName(vender.getName());
			venders.add(vo);
		}
		
		return venders;
	}
	
	/**
	 * 获取指定服务商信息
	 * VenderService.getVender()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @param venderId
	 * @return
	 */
	public MVender getVender(Integer venderId) {
		return this.venderDao.get(venderId);
	}
	
	/**
	 * 老年人信息服务类
	 */
	@Autowired
	private RUserService ruserService;
	
	/**
	 * 社区分级信息
	 */
	@Autowired
	private OCountryService ocountryService;
	
	/**
	 * 获取用户信息
	 * VenderService.getUser()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public RUser getUser(Long id) throws BusinessException {
		return this.ruserService.findById(id);
	}
	public void remove(long id){
		this.ruserService.remove(id);
	}
	/**
	 * 获取社区分级信息
	 * VenderService.getCountry()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public OCountry getCountry(Integer communityId) throws BusinessException {
		return ocountryService.getCountryById(communityId);
	}
	
	
	
	/************************************************************************状态维护****************************************************************************/
	
	/**
	 * 状态信息持久化对象
	 */
	@Autowired
	private StateDao stateDao;
	
	/**
	 * 用户状态持久化对象
	 */
	@Autowired
	private UserStateDao userStateDao;
	
	/**
	 * 获取全部状态信息
	 * VenderService.getAllStates()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @return
	 * @throws BusinessException
	 */
	public Collection<StateVO> getAllStates() throws BusinessException {
		
		//获取全部状态信息
		List<MStateCategory> stateCategories = stateDao.findAll();
		
		//临时map用于将相同分类下的状态信息进行汇总
		Map<Integer, StateVO> tmpMap = new LinkedHashMap<Integer, StateVO>();
		
		//遍历状态信息先处理全部的一级分类
		for(Iterator<MStateCategory> iter = stateCategories.iterator(); iter.hasNext();) {
			
			//状态信息
			MStateCategory stateCategory = iter.next();
			
			//状态VO
			StateVO state = null;
			
			//如果是一级分类则要加入map用于后续子项的汇总
			if(stateCategory.getParentId() == 0) {
				
				//从map中获取状态信息
				state = tmpMap.get(stateCategory.getId());
				
				//若不存在则加入
				if(state == null) {
					
					//创建状态信息
					state = new StateVO();
					state.setId(stateCategory.getId());
					state.setName(stateCategory.getName());
					List<StateVO> states = new ArrayList<StateVO>();//子项列表
					state.setStates(states);
					
					tmpMap.put(state.getId(), state);
				}
				
				//将全部的一级分类从列表中移除, 后续变可直接处理全部子项
				iter.remove();
			}
		}
		
		//再次遍历处理全部一级分类的子项
		for(Iterator<MStateCategory> iter = stateCategories.iterator(); iter.hasNext();) {
			
			//状态信息
			MStateCategory stateCategory = iter.next();
			
			//获取一级分类的vo
			StateVO state = tmpMap.get(stateCategory.getParentId());
			
			//创建子项
			StateVO _state = new StateVO();
			_state.setId(stateCategory.getId());
			_state.setName(stateCategory.getName());
			
			//加入集合
			state.getStates().add(_state);
		}
		
		return tmpMap.values();
	}

	/**
	 * 保存状态信息
	 * VenderService.saveState()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param states
	 * @param userId
	 * @param userName
	 * @throws BusinessException
	 */
	public void saveState(StateParamVO states, Long userId, Integer venderId, String userName) throws BusinessException {
		
		//没有录入数据不处理
		if(states == null || states.getStates() == null || states.getStates().isEmpty()) {
			return;
		}
		
		//拼接评估结果 格式1,2|3,4|......
		StringBuilder results = new StringBuilder();
		for(int i = 0; i < states.getStates().size(); i++) {
			results.append(states.getStates().get(i));
			if(i < states.getStates().size() - 1) {
				results.append("|");
			}
		}
		
		//用户状态数据
		MUserState userState = userStateDao.getTodayStates(userId);
		if(userState == null) {
			userState = new MUserState();
			userState.setVenderId(venderId);
			userState.setUserId(userId);
			userState.setCreatedAt(new Date());
			userState.setCreatedBy(userName);
			userState.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		}
		
		//如果存在数据只更新状态和备注属性
		userState.setResults(results.toString());
		userState.setRemarks(states.getBakup());
		
		//保存或更新数据
		userStateDao.saveOrUpdate(userState);
	}
	
	/**
	 * 查询状态信息
	 * VenderService.query()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param dateCond
	 * @param userId
	 * @param pageVo
	 * @return
	 * @throws BusinessException
	 */
	public StateQueryResultVO query(DateParamVO dateCond, Long userId, PageParamVO...pageVo) throws BusinessException {
		List<Integer> stuatus_m=new ArrayList<Integer>();
		//返回值
		StateQueryResultVO vo = new StateQueryResultVO();
		Map<Integer, Integer> status_mastate = new LinkedHashMap<Integer, Integer>();
		//报表的title
		List<String> titles = new ArrayList<String>();
		
		//评估结果
		List<String[]> results = new ArrayList<String[]>();
		
		//默认分页
		if(pageVo.length == 0) {
			pageVo[0] = new PageParamVO();
		}
		
		//查询指定时间段的状态数据
		Page<MUserState> mUserState = userStateDao.queryByPage(dateCond.getStart(), dateCond.getEnd(), userId, pageVo[0].getPage(), pageVo[0].getNum());
		
		//无记录直接返回
		if(mUserState.getTotalCount() == 0) {
			return vo;
		}
		
		//获取全部状态信息
		List<MStateCategory> stateCategories = stateDao.findAll();
		if(stateCategories == null || stateCategories.isEmpty()) {
			return vo;
		}
		
		//报表title对应的Id
		List<Integer> titleIds = new ArrayList<Integer>(); 
		
		//临时map用于后续根据状态Id获取状态描述
		Map<Integer, String> tmpMap = new LinkedHashMap<Integer, String>();
		
		
		//遍历状态分类构建报表title
		for(Iterator<MStateCategory> iter = stateCategories.iterator(); iter.hasNext();) {
			
			//状态分类数据
			MStateCategory stateCat = iter.next();
			
			//将一级分类(title)加入集合
			if(stateCat.getParentId() == 0) {
				titles.add(stateCat.getName());
				titleIds.add(stateCat.getId());
			}
			
			//将二级分类的数据也加入映射，方面后续的状态描述获取
			tmpMap.put(stateCat.getId(), stateCat.getName());
			status_mastate.put(stateCat.getId(), (Integer)stateCat.getStatus());
		}
		
		//title中追加固定的三列
		titles.add(0, "时间");
		titles.add("备注");
		titles.add("填报人员");
		
		//titleId中也追加三个标识用于后续匹配
		titleIds.add(0, -1);
		titleIds.add(-2);
		titleIds.add(-3);
		
		//用户状态信息
		List<MUserState> userStates = mUserState.getResult();
		
		//日期格式化
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		//遍历用户的状态信息，根据标题构造列表数据对象
		for(Iterator<MUserState> iter = userStates.iterator(); iter.hasNext();) {
			
			//用户状态信息
			MUserState userState = iter.next();
			
			//用于评估的结果值
			String[] data = new String[titleIds.size()];
			
			//遍历标题列表, 按照标题构造列表数据对象
			A:for(int i = 0; i < titleIds.size(); i++) {
				
				//时间
				if(titleIds.get(i) == -1) {
					data[i] = df.format(userState.getCreatedAt());
					continue;
				}
				
				//备注
				if(titleIds.get(i) == -2) {
					data[i] = userState.getRemarks();
					continue;
				}
				
				//填报人
				if(titleIds.get(i) == -3) {
					data[i] = userState.getCreatedBy();
					continue;
				}
				
				//用户的状态信息
				String[] _userStates = userState.getResults().split("\\|");
				
				//匹配用户的状态信息
				for(int j = 0; j < _userStates.length; j++) {
					
					//用户的一种状态
					String[] _states = _userStates[j].split(",");
					
					//找到相同项直接赋值
					if(Integer.valueOf(_states[0]).equals(titleIds.get(i))) {
						data[i] = tmpMap.get(Integer.valueOf(_states[1]));
						if(j<6){
							int aa=status_mastate.get(Integer.parseInt(_states[1]));
							stuatus_m.add(aa);
						}
						continue A;
					}
				}
				
				//没有找到数据赋值为空(此种情况可能是由于新添加了分类造成的)
				data[i] = "";
			}
			
			//加入集合
			results.add(data);
		}
		vo.setStatus_m(stuatus_m);
		//构造分页对象
		Page<String[]> page = new Page<String[]>();
		page.setTotalCount(results.size());
		page.setResult(results);
		page.setPageNo(pageVo[0].getPage());
		page.setPageSize(pageVo[0].getNum());
		
		//设置状态对应的结果内容
		vo.setResults(page);
		//返回值 -- 报表的title
		vo.setTitles(titles);
		return vo;
	}
	/**
	 * 查询状态信息
	 * VenderService.query()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param dateCond
	 * @param userId
	 * @param pageVo
	 * @return
	 * @throws BusinessException
	 */
	public List<List<MobileStateVo>> queryStateForMobile(Long userId) throws BusinessException {
		//返回
		List<List<MobileStateVo>> mobileStates = new ArrayList<List<MobileStateVo>>();
		//查询指定时间段的状态数据
		Page<MUserState> mUserState = userStateDao.queryByPage(null, null, userId, 1, 20);
		
		//无记录直接返回
		if(mUserState.getTotalCount() == 0) {
			return mobileStates;
		}
		
		//获取全部状态信息
		List<MStateCategory> stateCategories = stateDao.findAll();
		if(stateCategories == null || stateCategories.isEmpty()) {
			return mobileStates;
		}
		
		// 标题列表
		List<String> titles = new ArrayList<String>();
		//报表title对应的Id
		List<Integer> titleIds = new ArrayList<Integer>(); 
		
		//临时map用于后续根据状态Id获取状态描述
		Map<Integer, String> tmpMap = new LinkedHashMap<Integer, String>();
		
		//遍历状态分类构建报表title
		for(Iterator<MStateCategory> iter = stateCategories.iterator(); iter.hasNext();) {
			
			//状态分类数据
			MStateCategory stateCat = iter.next();
			
			//将一级分类(title)加入集合
			if(stateCat.getParentId() == 0) {
				titles.add(stateCat.getName());
				titleIds.add(stateCat.getId());
			}
			
			//将二级分类的数据也加入映射，方面后续的状态描述获取
			tmpMap.put(stateCat.getId(), stateCat.getName());
		}
		
		//用户状态信息
		List<MUserState> userStates = mUserState.getResult();
		
		//遍历用户的状态信息，根据标题构造列表数据对象
		for(Iterator<MUserState> iter = userStates.iterator(); iter.hasNext();) {
			List<MobileStateVo> states = new ArrayList<MobileStateVo>();
			//用户状态信息
			MUserState userState = iter.next();
			
			//遍历标题列表, 按照标题构造列表数据对象
			A:for(int i = 0; i < titleIds.size(); i++) {
				MobileStateVo stateVo = new MobileStateVo();
				stateVo.setTitle(titles.get(i));
				//用户的状态信息
				String[] _userStates = userState.getResults().split("\\|");
				states.add(stateVo);
				//匹配用户的状态信息
				for(int j = 0; j < _userStates.length; j++) {
					
					
					//用户的一种状态
					String[] _states = _userStates[j].split(",");
					
					//找到相同项直接赋值
					if(Integer.valueOf(_states[0]).equals(titleIds.get(i))) {
						stateVo.setValue(tmpMap.get(Integer.valueOf(_states[1])));
						continue A;
					}
				}
			}
			mobileStates.add(states);
		}
		
		return mobileStates;
	}
	/************************************************************************实时消息****************************************************************************/
	
	/**
	 * 实时消息持久化对象
	 */
	@Autowired
	private MsgDao msgDao;
	
	/** 
	 * 分页获取专业服务实时消息
	 * @name VenderService.getServiceMessages()
	 * @author zhoupeipei
	 * @Date 2014-10-18 下午12:53:43
	 * @param userId
	 * @param serviceId
	 * @param pageParamVo
	 * @return     
	 */
	public Page<MMessage> getServiceMessages(Long userId, Integer serviceId, PageParamVO...pageParamVo){
		return msgDao.queryByServicePage(userId, serviceId, pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	/**
	 * 分页获取实时消息
	 * VenderService.getMessages()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param pageParamVo
	 * @return
	 */
	public Page<MMessage> getMessages(Long userId, PageParamVO...pageParamVo) {
		return msgDao.queryByPage(userId, pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	
	/**
	 * 分页按照时间段获取消息
	 * VenderService.getMessages()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param DateCond
	 * @param pageParamVo
	 * @return
	 */
	public Page<MMessage> getMessages(Long userId, DateParamVO dateCond, PageParamVO...pageParamVo) {
		return msgDao.queryByPage(userId, dateCond.getStart(), dateCond.getEnd(), pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	
	/**
	 * 保存实时消息
	 * VenderService.saveMsg()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param venderId
	 * @param userId
	 * @param msg
	 * @param userName
	 */
	public void saveMsg(Integer venderId, Integer serviceId, String serviceName, Long userId, String msg, String userName) {
		
		//参数不合法不做任何操作
		if(userId == null || StringUtils.isEmpty(msg)) {
			return;
		}
		
		//构造消息对象
		MMessage message = new MMessage();
		message.setUserId(userId);
		message.setVendorId(venderId);
		message.setServiceId(serviceId);
		message.setServiceName(serviceName);
		message.setMessage(msg);
		message.setCreatedAt(new Date());
		message.setCreatedBy(userName);
		message.setVersion(ProfessionalConstants.DEFAULT_VERSION);
		
		//持久化对象
		msgDao.save(message);
	}
	
	/************************************************************************服务报告****************************************************************************/
	
	/**
	 * 实时消息持久化对象
	 */
	@Autowired
	private ReportDao reportDao;
	
	/**
	 * 分页按时间段获取服务报告
	 * VenderService.getReports()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param dateCond
	 * @param pageParamVo
	 * @return
	 */
	public Page<MReport> getReports(Long userId, DateParamVO dateCond, PageParamVO...pageParamVo) {
		return reportDao.queryByPage(userId, dateCond.getStart(), dateCond.getEnd(), pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	
	/** 
	 * 获取用户某专业服务服务报告列表
	 * @name VenderService.queryByService()
	 * @author zhoupeipei
	 * @Date 2014-10-17 上午5:52:00
	 * @param serviceId
	 * @param userId
	 * @param dateCond TODO
	 * @param pageVo TODO
	 * @return     
	 */
	public Page<MReport> queryByService(Integer serviceId,Long userId,  DateParamVO dateCond, PageParamVO pageVo) {
		return reportDao.queryByService(serviceId, userId, dateCond.getStart(),dateCond.getEnd(),pageVo.getPage(),pageVo.getNum());
	}
	
	/**
	 * 分页按照时间段获取消息
	 * VenderService.getMessages()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param DateCond
	 * @param pageParamVo
	 * @return
	 */
	public void saveReport(Integer venderId, Integer serviceId, String serviceName, Long userId, String content, String userName) {
		
		//参数不合法不做任何处理
		if(StringUtils.isEmpty(serviceName) || StringUtils.isEmpty(content)) {
			return;
		}
		
		//创建报告
		MReport report = new MReport();
		report.setUserId(userId);
		report.setVenderId(venderId);
		report.setServiceId(serviceId);
		report.setServiceName(serviceName);
		report.setContent(content);
		report.setCreatedAt(new Date());
		report.setCreatedBy(userName);
		report.setVersion(ProfessionalConstants.DEFAULT_VERSION);
	
		//保存对象
		reportDao.save(report);
	}
	
	/************************************************************************服务计划****************************************************************************/
	
	/************************************************************************警报阈值****************************************************************************/
	
	/**
	 * 用户警报阈值持久化对象
	 */
	@Autowired
	private AlarmThresholdDao alarmThresholdDao;
	
	/**
	 * 订单持久化对象
	 */
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 设置报警阈值
	 * VenderService.alarmSetup()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param venderId
	 * @param serviceId
	 * @param alarmSetVo
	 * @param userName
	 * @throws BusinessException
	 */
	public void alarmSetup(Long userId, Integer venderId, AlarmSetVO alarmSetVo, String userName) throws BusinessException {
		
		//全部报警项目
		List<DataModuleItemVO> dataModuleItems = alarmSetVo.getItems();
		
		//元服务Id -- 设备绑定Id
		
		
		List<MOrder> order = orderDao.getListMOrder(userId);
		
		Map<Integer, String> metaAndBindIdMap = new HashMap<Integer, String>();
		
		Set<MOrderDevice> orderDevices = new HashSet<MOrderDevice>();
		for(MOrder m:order){
			orderDevices.addAll(m.getOrderDevices());
		}
		for(Iterator<MOrderDevice> iter = orderDevices.iterator(); iter.hasNext();) {
			MOrderDevice orderDevice = iter.next();
			metaAndBindIdMap.put(orderDevice.getMetaServiceId(), orderDevice.getDeviceBindId());
		}
		
		//遍历开始逐一处理
		for(Iterator<DataModuleItemVO> iter = dataModuleItems.iterator(); iter.hasNext();) {
			//设置的报警项
			DataModuleItemVO itemVo = iter.next();
			//获取报警设置信息
			MAlarmThreshold alarmThreshold = alarmThresholdDao.get(userId, itemVo.getMetaServiceId(), itemVo.getName());
			if(alarmThreshold == null) {
				alarmThreshold = new MAlarmThreshold();
				alarmThreshold.setUserId(userId);
				alarmThreshold.setVenderId(venderId);
				alarmThreshold.setMetaServiceId(itemVo.getMetaServiceId());
				alarmThreshold.setItemName(itemVo.getName());
				alarmThreshold.setVersion(ProfessionalConstants.DEFAULT_VERSION);
				//增加设备绑定Id
				alarmThreshold.setDeviceBindId(metaAndBindIdMap.get(alarmThreshold.getMetaServiceId()));
			}
			alarmThreshold.setIsAlarm(itemVo.getIsAlarm());
			alarmThreshold.setAlarmLower(itemVo.getAlarmLower());
			alarmThreshold.setAlarmUpper(itemVo.getAlarmUpper());
			alarmThreshold.setCreatedAt(new Date());
			alarmThreshold.setCreatedBy(userName);
			//保存或更新
			alarmThresholdDao.save(alarmThreshold);
		}
	}
	
	/**
	 * 使用当前设置填充报警设置vo用于前台显示
	 * 目前采用的单次循环的方式从数据中获取
	 * 该方法有较大的优化空间
	 * VenderService.fillWithCurAlarmSet()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param serviceId
	 * @param userId
	 * @param dataModules
	 * @throws BusinessException
	 */
	public void fillWithCurAlarmSet(Integer serviceId, Long userId, List<DataModuleVO> dataModules) throws BusinessException {
		
		//遍历数据模块集合
		for(Iterator<DataModuleVO> iter = dataModules.iterator(); iter.hasNext();) {
			
			//数据模块
			DataModuleVO moduleVo = iter.next();
			
			//数据模块项集合
			List<DataModuleItemVO> itemVos = moduleVo.getItems();
			
			//遍历数据模块项集合逐一处理
			C1:for(Iterator<DataModuleItemVO> _iter = itemVos.iterator(); _iter.hasNext();) {
				
				//数据模块的设置VO
				DataModuleItemVO itemVo = _iter.next();
				
				//过滤不需要显示的项目名
				for(int i = 0; i < ProfessionalConstants.ALARM_EXCLUDE_ITEM_NAME.length; i++) {
					if(ProfessionalConstants.ALARM_EXCLUDE_ITEM_NAME[i].equals(itemVo.getName())) {
						_iter.remove();
						continue C1;
					}
				}
				
				//获取当前报警设置
				MAlarmThreshold alarmThreshold = alarmThresholdDao.get(userId, serviceId, itemVo.getName());
				if(alarmThreshold == null) {
					itemVo.setIsAlarm(false);
					itemVo.setAlarmLower(0f);
					itemVo.setAlarmUpper(0f);
				}else{
					itemVo.setIsAlarm(alarmThreshold.getIsAlarm());
					itemVo.setAlarmLower(alarmThreshold.getAlarmLower());
					itemVo.setAlarmUpper(alarmThreshold.getAlarmUpper());
				}
			}
		}
	}
	/**
	 * 根据管理员确定专业服务商信息
	 * @param contact
	 * @return
	 */
	public MVender getMVender(String contact){
		return	venderDao.getMVender(contact);
	}
	/**
	 * 根据添加者获取专业服务商（分页）
	 * @param cmName
	 * @param page
	 * @param num
	 * @return
	 */
	public Page<MVender> venders(String cmName,int page, int num) {
		return venderDao.venders(cmName, page, num);
	}
	/**
	 * 根据添加者获取专业服务商
	 * @author dx
	 * @param cmName
	 * @return
	 */
	public List<MVender> venders(String cmName) {
		return venderDao.venders(cmName);
	}
	public AUser getAUserID(String idCardNo){
		return  userDao.getAUserID(idCardNo);
	}
	public void save(MVender m){
		venderDao.save(m);
	}
	/**
	 * 员工查看老人签到情况
	 * @param activityId
	 * @param adminId
	 * @return
	 */
	public  List<RUser>  getStaff(int activityId,long adminId){
		return venderUserDao.getStaff(activityId, adminId);
	}
	
	public AUser findByName(String name,Integer venderId) throws UsernameNotFoundException {
		return userDao.findName(name,venderId);
	}
	
	public List<SubjectTeacherVO>  getListT(String username,String name){
		return userDao.getListT(username,name);
	}
	
	public List<AUser> getListT(String ids){
		return userDao.getAUser(ids);
	}
	public List<AUser>  getList(int  venderId){
		return userDao.getList(venderId);
	}
}
 