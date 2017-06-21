package com.anticw.aged.service.professional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.MService;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.professional.meta.MetaDao;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.dao.professional.service.SpecDao;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.device.DeviceVO;
import com.anticw.aged.vo.professional.meta.DataModuleVO;
import com.anticw.aged.vo.professional.service.OrderDeviceParamVO;
import com.anticw.aged.vo.professional.service.ServiceBriefVO;
import com.anticw.aged.vo.professional.service.ServiceCheckoutVO;
import com.anticw.aged.vo.professional.service.ServiceVO;

/**
 * 专业服务逻辑处理类
 * <P>File name : SpecService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Service
public class SpecService {
	
	/*****************************************************************专业服务维护***************************************************************************/
	/**
	 * 专业服务持久化对象
	 */
	@Autowired
	private SpecDao specDao;
	
 
	
	@Autowired
	private MetaDao metaDao;
	
	/**
	 * 分页获取数据
	 * SpecService.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	/*public Page<MService> list(PageParamVO pageParamVo) throws BusinessException {
		return specDao.list(pageParamVo.getPage(), pageParamVo.getNum());
	} 
	*/
	/**
	 * 获取专业服务列表
	 * SpecService.listAll()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public List<MService> listAll() throws BusinessException {
		return specDao.listAll();
	}
	
	/**
	 * 获取服务简报
	 * SpecService.getServiceBrief()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param serviceId
	 * @return
	 * @throws BusinessException
	 */
	public ServiceVO getServiceBrief(Integer serviceId) throws BusinessException {
		
		//查询元服务信息
		MService service = specDao.get(serviceId);
		if(service == null || service.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.META_NOT_FOUND);
		}
		
		//专业服务vo
		ServiceVO vo = new ServiceVO();
		vo.setId(service.getId());
		vo.setName(service.getName());
		vo.setCategoryId(service.getCategoryId());
		vo.setQualification(service.getQualification());
		vo.setStandard(service.getQualityStandard());
		vo.setContent(service.getServiceContent());
		vo.setPicture(service.getPicture());
		vo.setPrice(service.getPrice());
		
		return vo;
	}
 	
	/**
	 * 获取全部专业服务简报 
	 * 只包含专业服务的id 和 名称
	 * SpecService.getServicesBrief()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @return
	 * @throws BusinessException
	 */
	public List<ServiceVO> getServicesBrief() throws BusinessException {
		List<ServiceVO> _services = new ArrayList<ServiceVO>();
		List<MService> services = listAll();
		for(Iterator<MService> iter = services.iterator(); iter.hasNext();) {
			MService service = iter.next();
			ServiceVO vo = new ServiceVO();
			vo.setId(service.getId());
			vo.setName(service.getName());
			_services.add(vo);
		}
		return _services;
	}
	
	/**
	 * 获取全部专业服务简报 
	 * 只包含专业服务的id 和 名称
	 * SpecService.getServicesBrief()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-14 </P>
	 * @return
	 * @throws BusinessException
	 */
	public List<ServiceVO> getServicesBrief(Integer categoryId) throws BusinessException {
		List<ServiceVO> _services = new ArrayList<ServiceVO>();
		List<MService> services = specDao.findByCategoryId(categoryId);
		for(Iterator<MService> iter = services.iterator(); iter.hasNext();) {
			MService service = iter.next();
			ServiceVO vo = new ServiceVO();
			vo.setId(service.getId());
			vo.setName(service.getName());
			_services.add(vo);
		}
		return _services;
	}
	
	/**
	 * 获取专业服务信息
	 * SpecService.get()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ServiceVO get(Integer id) throws BusinessException { 
		
		MService service = specDao.get(id);
		//查询元服务信息
		if(service == null || service.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.SERVICE_NOT_FOUND);
		}
		
		//专业服务vo
		ServiceVO vo = new ServiceVO();
		vo.setId(service.getId());
		vo.setName(service.getName());
		vo.setCategoryId(service.getCategoryId());
		vo.setQualification(service.getQualification());
		vo.setStandard(service.getQualityStandard());
		vo.setContent(service.getServiceContent());
		vo.setPicture(service.getPicture());
		vo.setPrice(service.getPrice());
		vo.setPicture(service.getPicture());
		
		//元服务Id
		String _metaIds = service.getMetaServiceIds();
		List<Integer> metaIds = new ArrayList<Integer>();
		vo.setMetaIds(metaIds);
		for(String metaId : _metaIds.split(",")) {
			metaIds.add(Integer.valueOf(metaId));
		}
		
		//评估量表Id
		String _assessIds = service.getAssessTableIds();
		List<Integer> assessIds = new ArrayList<Integer>();
		vo.setAssessIds(assessIds);
		if(org.apache.commons.lang.StringUtils.isNotEmpty(_assessIds)){
			for(String assessId : _assessIds.split(",")) {
				assessIds.add(Integer.valueOf(assessId));
			}
		}
		
		return vo;
	}
	
	/**
	 * 保存或修改专业服务
	 * SpecService.saveOrUpdate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	/*public void saveOrUpdate(MultipartFile file, ServiceVO vo, String userName) throws BusinessException {
		
		//专业服务
		MService mService = null;
		
		//新增或修改对象
		if(vo.getId() == null || vo.getId() == 0) {//新增
			
			//设置基本信息
			mService = new MService();
			mService.setCreatedBy(userName);
			mService.setCreatedAt(new Date());
			mService.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			
		} else {//修改
			
			//获取服务信息
			mService = specDao.get(vo.getId());
			if(mService == null || mService.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
				throw new BusinessException(ExceptionCode.SERVICE_NOT_FOUND);
			}
		}
		
		//基本属性赋值
		mService.setName(vo.getName());
		mService.setPrice(vo.getPrice()*100);
		mService.setQualification(vo.getQualification());
		mService.setPicture("");
		mService.setCategoryId(vo.getCategoryId());
		mService.setServiceContent(vo.getContent());
		mService.setQualityStandard(vo.getStandard());
		mService.setAvailable(ProfessionalConstants.AVAILABLE);
		mService.setChangedBy(userName);
		mService.setChangedAt(new Date());
		
		//元服务
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0; i < vo.getMetaIds().size(); i++) {
			sb1.append(vo.getMetaIds().get(i));
			if(i < vo.getMetaIds().size() - 1) {
				sb1.append(",");
			}
		}
		mService.setMetaServiceIds(sb1.toString());
		
		if (vo.getAssessIds() != null && vo.getAssessIds().size() > 0) {
			// 评估量表
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < vo.getAssessIds().size(); i++) {
				sb2.append(vo.getAssessIds().get(i));
				if (i < vo.getAssessIds().size() - 1) {
					sb2.append(",");
				}
			}
			mService.setAssessTableIds(sb2.toString());
		}
		
		//上传文件
		String[] fileUrls = null;
		if(vo.getId() == null || vo.getId() == 0) {//新增专业服务必须上传图片
			if(file == null || file.isEmpty()) {
				throw new BusinessException(ExceptionCode.SERVICE_INFO_INCOMPLETE);
			}
		}else{//修改的时候要检测图片是否发生变化
			if(file == null || file.isEmpty()) {
				fileUrls = new String[]{vo.getPicture()};
			}
		}
		
		//上传图片
		if(fileUrls == null) {
			MultipartFile[] files = new MultipartFile[]{file};
			fileUrls = attachment.upload(2, files);
		}
		
		//如果执行上传操作后返回的内容为空，则表示文件上传失败，此处要给出异常提示
		if(fileUrls == null || fileUrls.length == 0) {
			throw new BusinessException(ExceptionCode.SERVICE_COVER_UPLOAD_FAILED);
		}
		
		//设置专业服务封面属性
		if(fileUrls != null && fileUrls.length > 0) {
			mService.setPicture(fileUrls[0]);
		}
		
		//持久化对象
		specDao.saveOrUpdate(mService);
	}
	*/
	/**
	 * 删除专业服务
	 * SpecService.delete()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param userName
	 * @throws BusinessException
	 *//*
	public void delete(Integer id, String userName) throws BusinessException { 
		
		//获取服务信息
		MService mService = specDao.get(id);
		if(mService == null || mService.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.SERVICE_NOT_FOUND);
		}
		
		mService.setAvailable(ProfessionalConstants.UNAVAILABLE);
		mService.setChangedBy(userName);
		mService.setChangedAt(new Date());
		
		//持久化对象
		specDao.saveOrUpdate(mService);
	}
	*/
	/*****************************************************************专业订购*********************************************************************************/
	
	/**
	 * 订单持久化对象
	 */
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 用户服务业务逻辑处理类
	 */
	@Autowired
	private RUserService userService;
	
	 
	
	/**
	 * 设备业务逻辑处理类
	 */
	@Autowired
	private DeviceService deviceService;
	
	 
	/**
	 * 获取指定用户指定状态的订单
	 * 在获取的过程中会将已过期但状态还是开通的订单修改为过期状态
	 * SpecService.getUserOrdersAndHandleExpire()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public Map<Integer, MOrder> getUserOrdersAndHandleExpire(long userId, short status) throws BusinessException {
		
		//返回值
		Map<Integer, MOrder> orderMap = new HashMap<Integer, MOrder>();
		
		//获取订单列表
		List<MOrder> orders = orderDao.findByUserAndStatus(userId, status);
		if(orders == null || orders.isEmpty()) {
			return orderMap;
		}
		
		//已经过期但状态还没有变的集合
		List<MOrder> expireOrders = new ArrayList<MOrder>();
		// 已过期服务提供商ids（不重复）
		//Set<Integer> expireVenderIds = new HashSet<Integer>();
		
		//当前时间
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		//填充至map
		for(Iterator<MOrder> iter = orders.iterator(); iter.hasNext();) {
			
			//订单信息
			MOrder order = iter.next();
			
			//对于已结束的订单要在此处加入过期集合后续处理状态的改变
			if(order.getEndTime().compareTo(c.getTime()) < 0 && order.getStatus() == ProfessionalConstants.ORDER_STATUS_OPENED) {
				expireOrders.add(order);
			} else {
				orderMap.put(order.getmMetaService().getId(), order);
			}
		}
		
		//对于已经过期的订单要进行状态的更改
		if(expireOrders != null && !expireOrders.isEmpty()) {
			// 如果指定专业服务商对该用户没有任何有效状态订单，删除用户在该专业服务商下的分配信息。只在参数status为ProfessionalConstants.ORDER_STATUS_OPENED，执行该逻辑
			// zhoupeipei @2014-11-09
			orderDao.updateOrdersStatus(expireOrders, ProfessionalConstants.ORDER_STATUS_EXPIRE);
		}
		
		return orderMap;
	}
	
	/**
	 * 获取指定用户指定状态的订单
	 * 在获取的过程中会将已过期但状态还是开通的订单修改为过期状态
	 * SpecService.getUserOrder()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @param serviceId
	 * @return
	 * @throws BusinessException
	 */
	public Map<Integer, MOrder> getUserOrder(long userId, Integer serviceId) throws BusinessException {
		
		//返回值
		Map<Integer, MOrder> orderMap = new HashMap<Integer, MOrder>();
		
		//获取订单列表
		MOrder order = orderDao.getOrderByUserAndServiceId(userId, metaDao.getMMetaServices(serviceId));
		if(order == null || order.getStatus() != ProfessionalConstants.ORDER_STATUS_OPENED) {
			return orderMap;
		}
		
		//填充至map
		orderMap.put(order.getmMetaService().getId(), order);
		
		return orderMap;
	}
	/**
	 * 根据用户、服务id获取订单
	 * @param userId
	 * @param serviceId
	 * @return
	 */
	public List<MOrder> getOrderByUSID(long userId){
		
		return orderDao.getListMOrder(userId);
	}
	public MOrder getOrderByUSID(long userId, Integer serviceId){
		return orderDao.getOrderByUserAndServiceId(userId, metaDao.getMMetaServices(serviceId));
	}
	/**
	 * 获取订单信息
	 * @param orderId
	 * @return
	 * @throws BusinessException
	 */
	public MOrder getServiceOrder(Long orderId) throws BusinessException {
		return orderDao.get(orderId);
	}
	
	/**
	 * 获取用户的订单信息
	 * 此处是将用户已开通的专业服务和全部的专业服务进行对比
	 * 列出全部的专业服务并设置状态用户专业服务的列表页显示
	 * SpecService.getCheckoutVO()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param serviceId
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public ServiceCheckoutVO getCheckoutVO(Integer serviceId, Long userId, Long orderId) throws BusinessException {
		
		//获取专业服务信息
		MMetaService  service=metaDao.getMMetaServices(serviceId);
		//获取用户信息
		RUser user = userService.findById(userId);
		if(user == null) {//用户不存在
			throw new BusinessException(ExceptionCode.USER_INFO_INVALID);
		}
		
		//获取开通所需的基本信息
		ServiceCheckoutVO checkoutVo = new ServiceCheckoutVO();
		checkoutVo.setOrderId((orderId != null && orderId != 0) ? orderId : null);
		checkoutVo.setServiceId(service.getId());
		checkoutVo.setServiceName(service.getName());
		checkoutVo.setPrice(service.getPrice());
		checkoutVo.setUserId(userId);
		checkoutVo.setUserName(user.getName());
		checkoutVo.setIdCard(user.getIdCardNo());
		
		//如果订单Id不为空，则表示在进行续用操作，此处需要给vo属性赋值用于页面的数据回显
		if(orderId != null && orderId != 0) {
			
			//获取订单信息
			MOrder order = orderDao.get(orderId);
			
			//订单不存在
			if(order == null) {
				throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
			}
			
			//订单已结束或订单被关闭
			Calendar c = Calendar.getInstance();
			c.setTime(order.getEndTime());
			c.set(Calendar.HOUR_OF_DAY, 23);
			c.set(Calendar.MINUTE, 59);
			c.set(Calendar.SECOND, 59);
			if(c.getTime().compareTo(new Date()) < 0 || order.getStatus() != ProfessionalConstants.ORDER_STATUS_OPENED) {
				throw new BusinessException(ExceptionCode.ORDER_CONTINUE_FAILED);
			}
			
			//开通时间，默认为上次开通结束时间的下一天
			DateParamVO dateCond = new DateParamVO();
			dateCond.setStart(order.getStartTime());
			dateCond.setEnd(order.getEndTime());
			
			//设置时间参数
			checkoutVo.setDateCond(dateCond);
			
			//订购的设备信息
			List<OrderDeviceParamVO> deviceParams = new ArrayList<OrderDeviceParamVO>();
			Set<MOrderDevice> orderDevices = order.getOrderDevices();
			for(Iterator<MOrderDevice> iter = orderDevices.iterator(); iter.hasNext();) {
				MOrderDevice orderDevice = iter.next();
				OrderDeviceParamVO deviceParam = new OrderDeviceParamVO();
				deviceParam.setDeviceTypeId(orderDevice.getDeviceTypeId());
				deviceParam.setDeviceTypeName(orderDevice.getDeviceTypeName());
				deviceParam.setDeviceId(orderDevice.getDeviceId());
				deviceParam.setMetaServiceId(orderDevice.getMetaServiceId());
				deviceParam.setDeviceBindId(orderDevice.getDeviceBindId());
				
				deviceParams.add(deviceParam);
			}
			
			//fix
			Collections.sort(deviceParams, new Comparator<OrderDeviceParamVO>(){
				public int compare(OrderDeviceParamVO o1, OrderDeviceParamVO o2) {
					return o1.getDeviceTypeId().compareTo(o2.getDeviceTypeId());
				}
			});
			
			checkoutVo.setDeviceParam(deviceParams);
			
			//服务商Id
			//checkoutVo.setVenderId(order.getVenderId());
		}
		
		//获取设备与设备类型列表(元服务Id -- 设备类型Id)
		//String[] metaServiceIds = service.getMetaServiceIds().split(",");
		Map<Integer, Integer> deviceTypeIds = this.metaService.getDeviceTypeIds(serviceId);
		if(deviceTypeIds == null || deviceTypeIds.isEmpty()) {
			throw new BusinessException(ExceptionCode.SERVICE_DEVICE_ERROR);
		}
		
		//获取设备分组信息
		checkoutVo.setDeviceGroups(deviceService.getDeviceGroups(deviceTypeIds));
		
		return checkoutVo;
	}
	
	/**
	 * 开通专业服务
	 * SpecService.openService()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param checkout
	 * @throws BusinessException
	 */
	public void openService(ServiceCheckoutVO checkout, String userName) throws BusinessException {
		
		//当前时间
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		//判断申请开通的日期是否符合规则
		if(checkout.getDateCond().getStart().compareTo(checkout.getDateCond().getEnd()) > 0 ||
		   //checkout.getDateCond().getStart().compareTo(c.getTime()) < 0 || 
		   checkout.getDateCond().getEnd().compareTo(c.getTime()) < 0  //|| 
		   //DateUtil.getMonthCount(checkout.getDateCond().getStart(), checkout.getDateCond().getEnd()) == -1
		   ) {
			throw new BusinessException(ExceptionCode.OPEN_DATE_ERROR);
		}
		
		//检测设备绑定参数
		List<OrderDeviceParamVO> _deviceParams = checkout.getDeviceParam();
		for(Iterator<OrderDeviceParamVO> iter = _deviceParams.iterator(); iter.hasNext();) {
			OrderDeviceParamVO paramVo = iter.next();
			if(StringUtils.isEmpty(paramVo.getDeviceBindId())) {
				throw new BusinessException(ExceptionCode.ORDER_BIND_ID_EMPTY);
			}
		}
		
		//获取用户信息
		RUser user = userService.findById(checkout.getUserId());
		if(user == null) {//用户不存在
			throw new BusinessException(ExceptionCode.USER_INFO_INVALID);
		}
		
		
		//开通专业服务
		if(checkout.getOrderId() == null || checkout.getOrderId() == 0) {
			
			//判断用户是否已订购了该服务
			if(orderDao.isOpened(checkout.getUserId(), metaDao.get(checkout.getServiceId()))) {
				throw new BusinessException(ExceptionCode.ORDER_HAS_OPENED);
			}
			
			//创建订单信息
			MOrder order = new MOrder();
			order.setUserId(user.getId());
			order.setUserName(user.getName());
			order.setIdCard(user.getIdCardNo());
			order.setStartTime(checkout.getDateCond().getStart());
			order.setEndTime(checkout.getDateCond().getEnd());
			//暂时srvice=======================================================
			MMetaService me=metaDao.get(checkout.getServiceId());
			order.setmMetaService(me);
			//me.setmOrder(order);
			order.setStatus(ProfessionalConstants.ORDER_STATUS_OPENED);
			order.setCreatedAt(new Date());
			order.setCreatedBy(userName);
			order.setChangedAt(new Date());
			order.setChangedBy(userName);
			order.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			//订购的设备类型
			Set<MOrderDevice> orderDevices = new HashSet<MOrderDevice>();
			order.setOrderDevices(orderDevices);
			
			//订购的设备信息参数
			List<OrderDeviceParamVO> deviceParams = checkout.getDeviceParam();
			
			//总价格
			
			//构建设备订购信息
			for(Iterator<OrderDeviceParamVO> iter = deviceParams.iterator(); iter.hasNext();) {
				
				//订购的设备参数
				OrderDeviceParamVO deviceParam = iter.next();
				
				//设备Id和设备绑定Id
				Integer deviceId = deviceParam.getDeviceId();
				String deviceBindId = deviceParam.getDeviceBindId();
				
				//获取设备信息
				DeviceVO device = this.deviceService.getDeviceVo(deviceId);
				if(device == null) {
					throw new BusinessException(ExceptionCode.ORDER_DEVICE_NOT_FOUND);
				}
				
				//创建设备订购信息对象
				MOrderDevice orderDevice = new MOrderDevice();
				orderDevice.setOrder(order);
				orderDevice.setMetaServiceId(deviceParam.getMetaServiceId());
				orderDevice.setDeviceTypeId(deviceParam.getDeviceTypeId());
				orderDevice.setDeviceTypeName(deviceParam.getDeviceTypeName());
				orderDevice.setDeviceId(deviceId);
				orderDevice.setDeviceName(device.getName());
				orderDevice.setDeviceBindId(deviceBindId);
				orderDevice.setPrice(device.getPrice());
				
				//加入集合
				orderDevices.add(orderDevice);
				
				//累计价格
			}
			
			//计算总价格 （总价格 ＝ 服务单价 ＊ 服务订购的天数 ＋ 设备总价）
			//int days = DateUtil.getTotalDay(checkout.getDateCond().getStart(), checkout.getDateCond().getEnd()) + 1;
			//int totalPay = service.getPrice() * days + costForDevice;
			//暂定   专业服务必须绑定价格
			
			//设置总价
			order.setTotalPay(checkout.getPrice());
			//保存订单信息
			orderDao.save(order);
			
		} else {//续用
			
			//获取订单信息
			MOrder order = orderDao.get(checkout.getOrderId());
			
			//订单不存在
			if(order == null) {
				throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
			}
			
			//订单已结束或订单被关闭
			Calendar cal = Calendar.getInstance();
			cal.setTime(order.getEndTime());
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			if(cal.getTime().compareTo(new Date()) < 0 || order.getStatus() != ProfessionalConstants.ORDER_STATUS_OPENED) {
				throw new BusinessException(ExceptionCode.ORDER_CONTINUE_FAILED);
			}
			
			//续用日期选择不正确
			if(checkout.getDateCond().getStart().compareTo(order.getStartTime()) != 0 || checkout.getDateCond().getEnd().compareTo(order.getEndTime()) <= 0) {
				throw new BusinessException(ExceptionCode.OPEN_DATE_ERROR);
			}
			
			//重新计算总价
			//int totalPay = service.getPrice() * days + costForDevice;
			//暂定   专业服务必须绑定价格
			int totalPay = 550;
			
			order.setEndTime(checkout.getDateCond().getEnd());
			order.setTotalPay(totalPay);
			order.setStatus(ProfessionalConstants.ORDER_STATUS_OPENED);
			order.setChangedAt(new Date());
			order.setChangedBy(userName);
			orderDao.update(order);
		}
	}
	
	/**
	 * 关闭服务
	 * SpecService.closeService()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-8 </P>
	 * @param orderId
	 * @throws BusinessException
	 */
	public void closeService(Long orderId, String userName) throws BusinessException {
		
		//获取订单信息
		MOrder order = this.orderDao.get(orderId);
		if(order == null) {
			throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
		}
		
		order.setStatus(ProfessionalConstants.ORDER_STATUS_CLOSED);
		order.setChangedBy(userName);
		order.setChangedAt(new Date());
		orderDao.update(order);
		// 用户开通状态订单
		//boolean deleteDistrData = true;
		 orderDao.findByUserAndStatus(order.getUserId(), ProfessionalConstants.ORDER_STATUS_OPENED);
	}
	
	/*****************************************************************提供给其他模块的方法**********************************************************************/
	
	/**
	 * 元服务业务逻辑处理类
	 */
	@Autowired
	private MetaService metaService;
	
	/**
	 * 获取指定服务的数据模块
	 * SpecService.getDataModules()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List<DataModuleVO> getDataModules(Long userId) throws BusinessException {
		return metaService.getDataModules(userId);
	}
	
	/**
	 * 获取指定状态的全部订单信息
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public List<MOrder> getAllOrderByStatus(Short status) throws BusinessException {
		return this.orderDao.getOrders(status);
	}
	/**
	 * 获取所有的元服务
	 * @return
	 */
	public List<MMetaService> getMMetaServiceList(){
		return metaDao.listAll();
	}
	/** 
	 * 获取用户专业服务列表
	 * @name SpecService.getSpecServiceList()
	 * @author zhoupeipei
	 * @Date 2014-11-7 下午5:14:47
	 * @param userId  用户id
	 * @param oped true：仅获取已开通服务；false:全部（含已开通）服务
	 * @return
	 * @throws BusinessException     
	 */
	public List<ServiceBriefVO> getSpecServiceList(Long userId, Boolean oped) throws BusinessException{
		//获取所有元服务
	//	List<MOrder>  oder=orderDao.getListMOrder(userId);
		List<MMetaService> mMetaService=metaDao.listAll();
		//根据userId先从订单中获取元服务记录
		//=========================================================	
		Set<MOrderDevice> orderDevices=null;
		//元服务列表
		List<ServiceBriefVO> vos = new ArrayList<ServiceBriefVO>();
		for(MMetaService mm:mMetaService){
				ServiceBriefVO vo = new ServiceBriefVO();
				MOrder m=orderDao.getOrderByUserAndServiceId(userId, mm);
					if(m!=null){
						//Set<MOrderDevice> orderDevices=m.getOrderDevices();
						String deviceBindId=null;
						if(m!=null){
							orderDevices = m.getOrderDevices();
						}
						if(orderDevices!=null){
							for(MOrderDevice mor:orderDevices){
								deviceBindId=mor.getDeviceBindId();
								break;
							}
						}
						vo.setDeviceBindId(deviceBindId);
						vo.setServiceId(m.getmMetaService().getId());
						vo.setStartTime(m.getStartTime());
						vo.setEndTime(m.getEndTime());
						vo.setServiceName(m.getmMetaService().getName());
						vo.setOrderId(m.getId());
						vo.setStatus(m.getStatus());
						//if(m.getmMetaService().getName().equals("安全床垫")){
							vo.setType(m.getmMetaService().getType());
						//}
								
				}else{
					vo.setServiceId(mm.getId());
					vo.setServiceName(mm.getName());
					if(mm.getType()!=null){
						vo.setType(mm.getType());
					}
				}
			vos.add(vo);
		}
		
		return vos;
				
	}
	
	/** 
	 * 验证用户已开通此服务
	 * @name SpecService.validateServiceHasBeanOpend()
	 * @author zhoupeipei
	 * @Date 2014年12月4日 下午2:02:16
	 * @param serviceId
	 * @param userId
	 * @return
	 * @throws BusinessException     
	 */
	public boolean validateServiceHasBeanOpend(int serviceId,long userId) throws BusinessException{
		//获取用户已经开通的专业服务
		Map<Integer, MOrder> orderMap = getUserOrdersAndHandleExpire(userId, ProfessionalConstants.ORDER_STATUS_OPENED);
		if(orderMap.get(serviceId)!=null){
			return true;
		}
		return false;
	}
	
}
