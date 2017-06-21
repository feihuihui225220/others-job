package com.anticw.aged.service.professional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MDevice;
import com.anticw.aged.bean.MDeviceType;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.professional.device.DeviceDao;
import com.anticw.aged.dao.professional.device.DeviceTypeDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.device.DeviceGroupVO;
import com.anticw.aged.vo.professional.device.DeviceTypeVO;
import com.anticw.aged.vo.professional.device.DeviceVO;

/**
 * 设备类型业务逻辑处理类
 * <P>File name : DeviceTypeService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Service
public class DeviceService {

	/**
	 * 设备类型持久化对象
	 */
	@Autowired
	private DeviceTypeDao deviceTypeDao;
	
	/**
	 * 设备持久化对象
	 */
	@Autowired
	private DeviceDao deviceDao;
	
	/**********************************************************************设备类型维护************************************************************************/
	
	/**
	 * 获取设备类型列表
	 * DeviceTypeService.listForDeviceType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MDeviceType> listForDeviceType(PageParamVO...pageParamVo) throws BusinessException {
		if(pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		return deviceTypeDao.list(pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}

	/**
	 * 获取指定的设备类型信息
	 * DeviceTypeService.getDeviceTypeVo()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public DeviceTypeVO getDeviceTypeVo(Integer id) throws BusinessException {
		
		//获取设备类型
		MDeviceType deviceType = deviceTypeDao.get(id);
		if(deviceType == null || deviceType.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.DEVICE_TYPE_NOT_FOUND);
		}
		
		//构建页面显示所需属性
		DeviceTypeVO deviceTypeVo = new DeviceTypeVO();
		deviceTypeVo.setId(deviceType.getId());
		deviceTypeVo.setName(deviceType.getName());
		deviceTypeVo.setDescr(deviceType.getDescr());
		deviceTypeVo.setQualification(deviceType.getQualification());
	
		return deviceTypeVo;
	}
	
	/**
	 * 新增或修改设备类型信息
	 * DeviceTypeService.saveOrUpdateDeviceType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	public void saveOrUpdateDeviceType(DeviceTypeVO vo, String userName) throws BusinessException {
		
		//设备类型
		MDeviceType deviceType = null;
		
		if(vo.getId() == null || vo.getId() == 0) {//新增
			
			//创建新对象
			deviceType = new MDeviceType();
			
			//设置属性
			deviceType.setName(vo.getName());
			deviceType.setDescr(vo.getDescr());
			deviceType.setQualification(vo.getQualification());
			deviceType.setAvailable(ProfessionalConstants.AVAILABLE);
			deviceType.setCreatedAt(new Date());
			deviceType.setCreatedBy(userName);
			deviceType.setChangedAt(new Date());
			deviceType.setChangedBy(userName);
			deviceType.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			
		} else {//修改
			
			//构建评估量表对象
			deviceType = deviceTypeDao.get(vo.getId());
			if(deviceType == null) {
				throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
			}
			
			//修改属性设置
			deviceType.setName(vo.getName());
			deviceType.setDescr(vo.getDescr());
			deviceType.setQualification(vo.getQualification());
			deviceType.setChangedAt(new Date());
			deviceType.setChangedBy(userName);
		}
		
		deviceTypeDao.saveOrUpdate(deviceType);
	}

	/**
	 * 删除指定的设备类型
	 * DeviceTypeService.deleteDeviceType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param userName
	 * @throws BusinessException
	 */
	public void deleteDeviceType(Integer id, String userName) throws BusinessException {
		
		//构建评估量表对象
		MDeviceType deviceType = deviceTypeDao.get(id);
		if(deviceType == null) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}
		
		//逻辑删除
		deviceType.setAvailable(ProfessionalConstants.UNAVAILABLE);
		deviceType.setChangedBy(userName);
		deviceType.setChangedAt(new Date());
		
		deviceTypeDao.update(deviceType);
	}
	
	/**
	 * 获取设备类型
	 * DeviceTypeService.getDeviceTypes()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 * @throws BusinessException
	 */
	public List<DeviceTypeVO> getDeviceTypes() throws BusinessException {
		
		//返回值
		List<DeviceTypeVO> _types = new ArrayList<DeviceTypeVO>();
		
		//获取全部可用的设备类型
		List<MDeviceType> types = deviceTypeDao.getAllDeviceTypes();
		
		//为空直接返回集合
		if(types == null || types.isEmpty()) {
			return _types;
		}
		
		//遍历
		for(Iterator<MDeviceType> iter = types.iterator(); iter.hasNext();) {
			
			//设备类型信息
			MDeviceType type = iter.next();
			
			//构建vo
			DeviceTypeVO vo = new DeviceTypeVO();
			vo.setId(type.getId());
			vo.setName(type.getName());
			vo.setDescr(type.getDescr());
			vo.setQualification(type.getQualification());
			_types.add(vo);
		}
		
		return _types;
	}
	
	/**
	 * 获取设备类型对象
	 * DeviceTypeService.getDeviceType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @return
	 */
	public MDeviceType getDeviceType(Integer id) throws BusinessException  {
		MDeviceType deviceType = this.deviceTypeDao.get(id);
		if(deviceType == null || deviceType.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.DEVICE_TYPE_NOT_FOUND);
		}
		return deviceType;
	}
	
	/**********************************************************************设备维护************************************************************************/
	
	/**
	 * 查询设备信息
	 * DeviceService.queryForDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param deviceName
	 * @param deviceVender
	 * @param deviceType
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MDevice> queryForDevice(String deviceName, String deviceVender, Integer deviceType, PageParamVO pageParamVo) throws BusinessException {
		return deviceTypeDao.queryForDevice(deviceName, deviceVender, deviceType, pageParamVo.getPage(), pageParamVo.getNum());
	}
	
	/**
	 * 获取设备列表
	 * DeviceService.listForDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MDevice> listForDevice(PageParamVO...pageParamVo) throws BusinessException {
		if(pageParamVo.length == 0) {
			pageParamVo[0] = new PageParamVO();
		}
		return deviceDao.list(pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}

	/**
	 * 获取设备vo
	 * DeviceService.getDeviceVo()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public DeviceVO getDeviceVo(Integer id) throws BusinessException {
		
		//获取设备类型
		MDevice device = deviceDao.get(id);
		if(device == null || device.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.DEVICE_TYPE_NOT_FOUND);
		}
		
		//构建页面显示所需属性
		DeviceVO deviceVo = new DeviceVO();
		deviceVo.setId(id);
		deviceVo.setName(device.getName());
		deviceVo.setPrice(device.getPrice());
		deviceVo.setDeviceNo(device.getNumber());
		deviceVo.setUseDesc(device.getUseDesc());
		deviceVo.setFunctionDesc(device.getFunctionDesc());
		deviceVo.setVender(device.getVender());
		
		//设备类型Id集合
		String[] _deviceTypeIds = device.getDeviceTypeIds().split(","); 
		List<Integer> deviceTypeIds = new ArrayList<Integer>();
		deviceVo.setDeviceTypeIds(deviceTypeIds);
		for(int i = 0; i < _deviceTypeIds.length; i++) {
			deviceTypeIds.add(Integer.parseInt(_deviceTypeIds[i]));
		}
	
		return deviceVo;
	}
	
	/**
	 * 保存或修改设备信息
	 * DeviceService.saveOrUpdateDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	public void saveOrUpdateDevice(DeviceVO vo, String userName) throws BusinessException {
		
		//设备类型
		MDevice device = null;
		
		if(vo.getId() == null || vo.getId() == 0) {//新增
			
			//创建新对象
			device = new MDevice();
			
			//设置属性
			device.setAvailable(ProfessionalConstants.AVAILABLE);
			device.setCreatedAt(new Date());
			device.setCreatedBy(userName);
			device.setChangedAt(new Date());
			device.setChangedBy(userName);
			device.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			
		} else {//修改
			
			//构建设备对象
			device = deviceDao.get(vo.getId());
			if(device == null) {
				throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
			}
		}
		
		//修改属性设置
		device.setName(vo.getName());
		device.setPrice(vo.getPrice()*100);
		device.setNumber(vo.getDeviceNo());
		device.setUseDesc(vo.getUseDesc());
		device.setFunctionDesc(vo.getFunctionDesc());
		device.setVender(vo.getVender());
		device.setChangedAt(new Date());
		device.setChangedBy(userName);
		
		//设置设备类型属性
		List<Integer> deviceTypeIds = vo.getDeviceTypeIds();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < deviceTypeIds.size(); i++) {
			sb.append(deviceTypeIds.get(i));
			if(i < deviceTypeIds.size() - 1) {
				sb.append(",");
			}
		}
		device.setDeviceTypeIds(sb.toString());
		
		//保存或更新
		deviceDao.saveOrUpdate(device);
	}

	/**
	 * 删除设备
	 * DeviceService.deleteDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param id
	 * @param userName
	 * @throws BusinessException
	 */
	public void deleteDevice(Integer id, String userName) throws BusinessException {
		
		//构建评估量表对象
		MDevice device = deviceDao.get(id);
		if(device == null) {
			throw new BusinessException(ExceptionCode.ASSESS_NOT_FOUND);
		}
		
		//逻辑删除
		device.setAvailable(ProfessionalConstants.UNAVAILABLE);
		device.setChangedBy(userName);
		device.setChangedAt(new Date());
		
		deviceDao.update(device);
	}
	
	/**********************************************************************提供给其他模块的方法****************************************************************/
	
	/**
	 * 根据设备类型Id获取设备类型和其下设备分组信息
	 * 用于开通专业服务时使用
	 * 该方法有优化空间
	 * DeviceService.getDeviceGroups()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param deviceTypeIds
	 * @return
	 * @throws BusinessException
	 */
	public List<DeviceGroupVO> getDeviceGroups(Map<Integer, Integer> deviceTypeIds) throws BusinessException {
		
		//设备分组信息集合
		List<DeviceGroupVO> deviceGroups = new ArrayList<DeviceGroupVO>();
		
		//构建设备分组信息
		for(Iterator<Entry<Integer, Integer>> iter = deviceTypeIds.entrySet().iterator(); iter.hasNext();) {
			
			//map key & value
			Entry<Integer, Integer> entry = iter.next();
			Integer metaServiceId = entry.getKey();
			Integer deviceTypeId = entry.getValue();
			
			//设备分组信息
			DeviceGroupVO deviceGruopVo = new DeviceGroupVO();
			DeviceTypeVO deviceTypeVo = new DeviceTypeVO();
			List<DeviceVO> deviceVos = new ArrayList<DeviceVO>();
			deviceGruopVo.setMetaServiceId(metaServiceId);
			deviceGruopVo.setDeviceType(deviceTypeVo);
			deviceGruopVo.setDevices(deviceVos);
			deviceGroups.add(deviceGruopVo);
			
			//获取设备信息
			MDeviceType deviceType = getDeviceType(deviceTypeId);
			deviceTypeVo.setId(deviceType.getId());
			deviceTypeVo.setName(deviceType.getName());
			
			//获取设备类型下的全部设备
			deviceVos.addAll(getDeviceVos(deviceTypeId));
		}
		
		return deviceGroups;
	}
	
	/**
	 * 获取设备vo集合根据设备类型
	 * DeviceService.getDeviceVos()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param deviceTypeId
	 * @return
	 */
	private List<DeviceVO> getDeviceVos(Integer deviceTypeId) {
		
		//设备vo集合
		List<DeviceVO> deviceVos = new ArrayList<DeviceVO>();
		
		//获取全部设备
		List<MDevice> devices = deviceDao.listAll();
		
		//匹配指定设备
		for(Iterator<MDevice> iter = devices.iterator(); iter.hasNext();) {
			
			//设备信息
			MDevice device = iter.next();
			
			//判断设备是否属于该设备类型
			String[] deviceTypeIds = device.getDeviceTypeIds().split(",");
			for(String typeId : deviceTypeIds) {
				if(Integer.valueOf(typeId).equals(deviceTypeId)) {
					DeviceVO deviceVo = new DeviceVO();
					deviceVo.setId(device.getId());
					deviceVo.setName(device.getName());
					deviceVo.setPrice(device.getPrice());
					deviceVos.add(deviceVo);
				}
			}
		}
		
		return deviceVos;
	}
}