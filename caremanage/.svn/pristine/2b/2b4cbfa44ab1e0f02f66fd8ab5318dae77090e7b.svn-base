package com.anticw.aged.service.professional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MDataModule;
import com.anticw.aged.bean.MDataModuleItem;
import com.anticw.aged.bean.MDeviceType;
import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.professional.meta.MetaDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.meta.DataModuleItemVO;
import com.anticw.aged.vo.professional.meta.DataModuleVO;
import com.anticw.aged.vo.professional.meta.MetaVO;

/**
 * 元服务业务逻辑处理类
 * <P>File name : MetaService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Service
public class MetaService {
	
	/**
	 * 元服务持久化对象
	 */
	@Autowired
	private MetaDao metaDao;
	
	/**
	 * 设备类型逻辑处理类
	 */
	@Autowired
	private DeviceService deviceTypeService;
	
	/**
	 * 获取元服务列表
	 * MetaService.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws BusinessException
	 */
	public Page<MMetaService> list(PageParamVO...pageParamVo) throws BusinessException {
		if(pageParamVo == null) {
			pageParamVo = new PageParamVO[]{new PageParamVO()};
		}
		return metaDao.list(pageParamVo[0].getPage(), pageParamVo[0].getNum());
	}
	public List<MMetaService> listAll() {
		return metaDao.listAll();
	}
	
	/**
	 * 获取元服务
	 * MetaService.get()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MetaVO get(Integer id) throws BusinessException {
		
		//查询元服务信息
		MMetaService meta = metaDao.get(id);
		if(meta == null || meta.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.META_NOT_FOUND);
		}
		
		//基本信息赋值
		MetaVO metaVo = new MetaVO();
		metaVo.setId(meta.getId());
		metaVo.setPrice(meta.getPrice());
		metaVo.setDeviceTypeId(meta.getDeviceType().getId());
		metaVo.setName(meta.getName());
		
		//数据模块
		MDataModule dataModule = meta.getDataModule();
		
		//根据数据模块的数据信息构建vo对象 
		DataModuleVO dataModuleVo = createDataModuleVO(dataModule);
		metaVo.setDataModule(dataModuleVo);
		
		return metaVo;
	}
	
	/**
	 * 保存或更新元服务
	 * MetaService.saveOrUpdate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param vo
	 * @param userName
	 * @throws BusinessException
	 */
	public void saveOrUpdate(MetaVO vo, String userName) throws BusinessException {
		
		//获取设备类型信息
		MDeviceType deviceType = deviceTypeService.getDeviceType(vo.getDeviceTypeId());
		
		if(vo.getId() == null || vo.getId() == 0) {//新添加数据
			
			//创建元服务
			MMetaService meta = new MMetaService();
			
			//基本属性赋值
			meta.setName(vo.getName());
			meta.setPrice(vo.getPrice());
			meta.setDeviceType(deviceType);
			meta.setAvailable(ProfessionalConstants.AVAILABLE);
			meta.setCreatedAt(new Date());
			meta.setCreatedBy(userName);
			meta.setChangedAt(new Date());
			meta.setChangedBy(userName);
			meta.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			//获取数据模块信息
			DataModuleVO dataModuleVo = vo.getDataModule();
			
			//设置元服务的数据模块属性
			MDataModule dataModule = new MDataModule();
			meta.setDataModule(dataModule);
			
			//设置数据模块属性
			dataModule.setName(dataModuleVo.getName());
			dataModule.setTableName(dataModuleVo.getTableName());
			dataModule.setAvailable(ProfessionalConstants.AVAILABLE);
			dataModule.setCreatedAt(new Date());
			dataModule.setCreatedBy(userName);
			dataModule.setChangedAt(new Date());
			dataModule.setChangedBy(userName);
			dataModule.setVersion(ProfessionalConstants.DEFAULT_VERSION);
			
			//获取数据模块子项
			List<DataModuleItemVO> itemVos = dataModuleVo.getItems();
				
			//数据模块持久化对象的模块项属性
			Set<MDataModuleItem> dataModuleItems = new LinkedHashSet<MDataModuleItem>();
			
			//设置数据模块持久化对象的模块项属性
			dataModule.setDataModuleItems(dataModuleItems);
			
			//遍历数据模块项逐一构造持久化对象
			for(Iterator<DataModuleItemVO> iter = itemVos.iterator(); iter.hasNext();) {
				
				//数据模块项信息
				DataModuleItemVO itemVo = iter.next();
				
				//设置数据模块项的属性信息
				MDataModuleItem item = new MDataModuleItem();
				item.setItemName(itemVo.getName());
				item.setItemDesc(itemVo.getDesc());
				item.setIsShow(itemVo.getIsShow() == null ? false : itemVo.getIsShow());
				//item.setIsAlarm(itemVo.getIsAlarm() == null ? false : itemVo.getIsAlarm());
				//item.setAlarmLower(-1);
				//item.setAlarmUpper(-1);
				item.setAvailable(ProfessionalConstants.AVAILABLE);
				item.setCreatedAt(new Date());
				item.setCreatedBy(userName);
				item.setChangedAt(new Date());
				item.setChangedBy(userName);
				item.setVersion(ProfessionalConstants.DEFAULT_VERSION);
				item.setDataModule(dataModule);//绑定数据模块
				dataModuleItems.add(item);
			}
			
			//数据持久化
			metaDao.save(meta);
			
		} else {//修改数据
			
			//查询元服务信息
			MMetaService meta = metaDao.get(vo.getId());
			if(meta == null || meta.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
				throw new BusinessException(ExceptionCode.META_NOT_FOUND);
			}
			
			//基本属性赋值
			meta.setName(vo.getName());
			meta.setDeviceType(deviceType);
			meta.setChangedAt(new Date());
			meta.setChangedBy(userName);
			meta.setPrice(vo.getPrice());
			//获取数据模块信息
			DataModuleVO dataModuleVo = vo.getDataModule();
			
			//设置元服务的数据模块属性
			MDataModule dataModule = meta.getDataModule();
			
			//设置数据模块属性
			dataModule.setName(dataModuleVo.getName());
			dataModule.setTableName(dataModuleVo.getTableName());
			dataModule.setChangedAt(new Date());
			dataModule.setChangedBy(userName);
			
			//获取数据模块子项
			List<DataModuleItemVO> itemVos = dataModuleVo.getItems();
				
			//数据模块持久化对象的模块项属性
			Set<MDataModuleItem> items = dataModule.getDataModuleItems();
			
			/*
			  	需要处理的情况：
			  	1、更新的数据项
			  	2、新增的数据项
			  	3、删除的数据项
			  	该处代码可优化.....
			*/
			
			//遍历从前台传来的数据项列表然后判断数据的新增、修改，及删除
	        A:for(Iterator<DataModuleItemVO> iter = itemVos.iterator(); iter.hasNext();) {
				
				//可能发生变化或新增的项
				DataModuleItemVO item = iter.next();
				
				//新增的数据
				if(item.getId() == null || item.getId() == 0) {
					MDataModuleItem newItem = new MDataModuleItem();
					newItem.setItemName(item.getName());
					newItem.setItemDesc(item.getDesc());
					newItem.setIsShow(item.getIsShow() == null ? false : item.getIsShow());
					//newItem.setIsAlarm(item.getIsAlarm() == null ? false : item.getIsAlarm());
					//newItem.setAlarmLower(-1);
					//newItem.setAlarmUpper(-1);
					newItem.setAvailable(ProfessionalConstants.AVAILABLE);
					newItem.setCreatedAt(new Date());
					newItem.setCreatedBy(userName);
					newItem.setChangedAt(new Date());
					newItem.setChangedBy(userName);
					newItem.setVersion(ProfessionalConstants.DEFAULT_VERSION);
					newItem.setDataModule(dataModule);//绑定数据模块
					items.add(newItem);
					continue;
				}
				
				//遍历原有数据, 来确定从前台传来的数据是修改还是删除
				for(Iterator<MDataModuleItem> _iter = items.iterator(); _iter.hasNext();) {
					
					//原数据
					MDataModuleItem _item = _iter.next();
					
					//发生变化的数据,需要排除上面新增的项
					if(_item.getId() != null && _item.getId() != 0 && _item.getId().equals(item.getId())) {
						
						//更新属性
						_item.setItemName(item.getName());
						_item.setItemDesc(item.getDesc());
						_item.setIsShow(item.getIsShow() == null ? false : item.getIsShow());
						//_item.setIsAlarm(item.getIsAlarm() == null ? false : item.getIsAlarm());
						//_item.setAlarmLower(item.getAlarmLower());
						//_item.setAlarmUpper(item.getAlarmUpper());
						_item.setChangedAt(new Date());
						_item.setChangedBy(userName);
						_item.setDataModule(dataModule);//绑定数据模块
						continue A;
					}
				}
			}
			
			//遍历元数据集合和新数据集合处理已删除数据
			A:for(Iterator<MDataModuleItem> iter = items.iterator(); iter.hasNext();) {
				
				//原数据
				MDataModuleItem item = iter.next();
				
				//遍历从前台传来的数据集合
				for(Iterator<DataModuleItemVO> _iter = itemVos.iterator(); _iter.hasNext();) {
				
					//可能发生变化或新增的项
					DataModuleItemVO _item = _iter.next();
					
					//如果是新插入的数据 或者 找到相同的数据直接continue
					if((item.getId() == null || item.getId() == 0) || (item.getId() != null && item.getId() != 0 && item.getId().equals(_item.getId()))) {
						continue A;
					}
				}
				
				//能够执行到此处的数据是删除的数据
				item.setAvailable(ProfessionalConstants.UNAVAILABLE);
				item.setChangedAt(new Date());
				item.setChangedBy(userName);
				item.setDataModule(dataModule);//绑定数据模块
			}
			
			//更新数据
			metaDao.saveOrUpdate(meta);
		}
	}
	
	/**
	 * 删除元服务
	 * MetaService.delete()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param userName
	 * @throws BusinessException
	 */
	public void delete(Integer id, String userName) throws BusinessException {
		
		//查询元服务信息
		MMetaService meta = metaDao.get(id);
		if(meta == null || meta.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.META_NOT_FOUND);
		}
		
		//逻辑删除元服务
		meta.setAvailable(ProfessionalConstants.UNAVAILABLE);
		meta.setChangedAt(new Date());
		meta.setChangedBy(userName);
		
		//逻辑删除数据模块
		MDataModule dataModule = meta.getDataModule();
		dataModule.setAvailable(ProfessionalConstants.UNAVAILABLE);
		dataModule.setChangedAt(new Date());
		dataModule.setChangedBy(userName);
		
		//逻辑删除数据模块项
		Set<MDataModuleItem> items = dataModule.getDataModuleItems();
		for(Iterator<MDataModuleItem> iter = items.iterator(); iter.hasNext();) {
			MDataModuleItem item = iter.next();
			item.setAvailable(ProfessionalConstants.UNAVAILABLE);
			item.setChangedAt(new Date());
			item.setChangedBy(userName);
			item.setDataModule(dataModule);
		}
	}
	
	/**
	 * 获取元服务数据
	 * MetaService.getAllMeta()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 * @throws BusinessException
	 */
	/*public List<MetaVO> getAllMeta() throws BusinessException {
		
		//返回值
		List<MetaVO> vos = new ArrayList<MetaVO>();
		
		//获取元服务列表
		List<MMetaService> metaServices = metaDao.listAll();
		if(metaServices == null || metaServices.isEmpty()) {
			return vos;
		}
		
		//构造元服务数据
		for(Iterator<MMetaService> iter = metaServices.iterator(); iter.hasNext();) {
			MMetaService meta = iter.next();
			MetaVO vo = new MetaVO();
			vo.setId(meta.getId());
			vo.setName(meta.getName());
			vos.add(vo);
		}
		
		return vos;
	}*/
	
	@Autowired
	protected SpecService specService;
	/**
	 * 获取数据模块VO
	 * MetaService.getDataModules()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param metaServiceIds
	 * @return
	 * @throws BusinessException
	 */
	public List<DataModuleVO> getDataModules(Long userId) throws BusinessException {
		
		//返回值
		List<MOrder> order = specService.getOrderByUSID(userId);
		List<DataModuleVO> vos = new ArrayList<DataModuleVO>();
		List<MMetaService> mmeta=new ArrayList<MMetaService>();
		//元服务Id数组
		for(MOrder m:order){
			mmeta.add(m.getmMetaService());
		}
		
		//获取每个元服务的数据模块并构建vo然后加入集合
		for(MMetaService m : mmeta) {
			
			//查询元服务信息
			if(m == null || m.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
				continue;
			}
			
			//获取数据模块信息
			MDataModule dataModule = m.getDataModule();
			
			//根据数据模块的数据信息构建vo对象
			DataModuleVO dataModuleVo = createDataModuleVO(dataModule);
			
			//设置元服务Id
			dataModuleVo.setMetaServiceId(m.getId());
			
			//置入集合
			vos.add(dataModuleVo);
		}
		
		return vos;
	}
	
	/**
	 * 获取元服务信息
	 * @param metaId
	 * @return
	 * @throws BusinessException
	 */
	public DataModuleVO getDataModule(Integer metaId) throws BusinessException {
		
		//查询元服务信息
		MMetaService metaService = metaDao.get(metaId);
		if(metaService == null || metaService.getAvailable() == ProfessionalConstants.UNAVAILABLE) {
			throw new BusinessException(ExceptionCode.META_NOT_FOUND);
		}
		//获取数据模块信息
		MDataModule dataModule = metaService.getDataModule();
		
		//根据数据模块的数据信息构建vo对象
		DataModuleVO dataModuleVo = createDataModuleVO(dataModule);
		
		//设置元服务Id
		dataModuleVo.setMetaServiceId(metaService.getId());
		return dataModuleVo;
	}
	
	/**
	 * 获取指定元服务下的设备类型Id
	 * MetaService.getDeviceTypeIds()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-7 </P>
	 * @param metaServiceIds
	 * @return 元服务Id -- 设备类型Id
	 * @throws BusinessException
	 */
	public Map<Integer, Integer> getDeviceTypeIds(int metaServiceiId) throws BusinessException {
		
		//设备类型Id集合
		Map<Integer, Integer> deviceTypeIds = new HashMap<Integer, Integer>();
		
		//查询元服务信息
		MMetaService metaService = this.metaDao.getMMetaServices(metaServiceiId);
		if(metaService == null) {
			return deviceTypeIds;
		}
		//设备类型Id
		Integer deviceTypeId = deviceTypeIds.get(metaService.getId());
		
		//加入集合
		if(deviceTypeId == null) {
			deviceTypeIds.put(metaService.getId(), metaService.getDeviceType().getId());
		}
		return deviceTypeIds;
	}
	
	/**
	 * 根据数据模块的数据信息构建vo对象
	 * MetaService.createDataModuleVO()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param dataModule
	 * @return
	 */
	private DataModuleVO createDataModuleVO(MDataModule dataModule) {
		
		//赋值数据模块 
		DataModuleVO dataModuleVo = new DataModuleVO();
		
		//数据模块基本信息赋值
		dataModuleVo.setId(dataModule.getId());
		dataModuleVo.setName(dataModule.getName());
		dataModuleVo.setTableName(dataModule.getTableName());
		
		//数据模块项
		Set<MDataModuleItem> dataModuleItems = dataModule.getDataModuleItems();
		
		//如果存在数据模块项则开始对vo进行填充
		if(dataModuleItems != null && !dataModuleItems.isEmpty()) {
			
			//赋值数据模块项
			List<DataModuleItemVO> moduleItemVos = new ArrayList<DataModuleItemVO>();
			dataModuleVo.setItems(moduleItemVos);
			
			//遍历数据模块项集合逐一构建临时对象
			for(Iterator<MDataModuleItem> iter = dataModuleItems.iterator(); iter.hasNext();) {
				
				//数据模块项
				MDataModuleItem dataModuleItem = iter.next();
				
				//构建vo并加入集合
				DataModuleItemVO dataModuleItemVo = new DataModuleItemVO();
				dataModuleItemVo.setId(dataModuleItem.getId());
				dataModuleItemVo.setName(dataModuleItem.getItemName());
				dataModuleItemVo.setDesc(dataModuleItem.getItemDesc());
				dataModuleItemVo.setIsShow(dataModuleItem.getIsShow());
				dataModuleItemVo.setItemType(dataModuleItem.getItemType());
				//dataModuleItemVo.setIsAlarm(dataModuleItem.getIsAlarm());
				//dataModuleItemVo.setAlarmLower(dataModuleItem.getAlarmLower());
				//dataModuleItemVo.setAlarmUpper(dataModuleItem.getAlarmUpper());
				moduleItemVos.add(dataModuleItemVo);
			}
		}
		
		return dataModuleVo;
	}
	/**
	 * 根据元Ids获取元服务信息
	 */
	public MMetaService getMMetaServices(int id){
		return metaDao.getMMetaServices(id);
	}
}
