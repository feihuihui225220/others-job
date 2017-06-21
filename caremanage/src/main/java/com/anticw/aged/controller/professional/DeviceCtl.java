package com.anticw.aged.controller.professional;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MDevice;
import com.anticw.aged.bean.MDeviceType;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.professional.DeviceService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.device.DeviceTypeVO;
import com.anticw.aged.vo.professional.device.DeviceVO;

/**
 * 设备类型、设备维护相关请求控制器
 * <P>File name : DeviceCtl.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Controller
public class DeviceCtl {

	/**
	 * 设备类型业务逻辑处理类
	 */
	@Autowired
	private DeviceService deviceService;
	
	/**********************************************************************设备类型维护************************************************************************/
	
	/**
	 * 获取设备类型列表
	 * DeviceCtl.list()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/type")
	public ModelAndView listForDeviceType(PageParamVO pageParamVo) throws Exception {
		Page<MDeviceType> vo = deviceService.listForDeviceType(pageParamVo);
		ModelAndView mv = new ModelAndView("professional/device/deviceType");
		mv.addObject("page", vo);
		return mv;
	}
	
	/**
	 * 跳转至添加页面
	 * DeviceCtl.goAddPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/type/add")
	public ModelAndView goAddPage(PageParamVO pageParamVo) throws Exception {
		ModelAndView mv = new ModelAndView("professional/device/deviceTypeInput");
		mv.addObject("page", pageParamVo);
		return mv;
	}
	
	/**
	 * 跳转至修改页面
	 * DeviceCtl.goModifyPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/type/modify")
	public ModelAndView goModifyPage(Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取评估量表信息
		DeviceTypeVO vo = deviceService.getDeviceTypeVo(id);
		
		ModelAndView mv = new ModelAndView("professional/device/deviceTypeInput");
		mv.addObject("deviceType", vo);
		mv.addObject("page", pageParamVo);
		return mv;
	}
	
	/**
	 * 新增或修改设备类型
	 * DeviceCtl.saveOrUpdate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/type/commit")
	public ModelAndView saveOrUpdate(HttpSession session, DeviceTypeVO vo, PageParamVO pageParamVo) throws Exception {
		
		//自检
		vo.selfValidate();
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		
		//增加或修改评估量表
		deviceService.saveOrUpdateDeviceType(vo, userName);
		
		return listForDeviceType(pageParamVo);
	}
	
	/**
	 * 删除设备类型
	 * DeviceCtl.remove()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/type/delete")
	public ModelAndView remove(HttpSession session, Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		
		//删除评估量表
		deviceService.deleteDeviceType(id, userName);
		
		return listForDeviceType(pageParamVo);
	}
	
	/**********************************************************************设备维护************************************************************************/
	
	/**
	 * 设备查询
	 * DeviceCtl.deviceQuery()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-16 </P>
	 * @param deviceName
	 * @param deviceVender
	 * @param deviceType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/query")
	public ModelAndView deviceQuery(String deviceName, String deviceVender, Integer deviceType, PageParamVO pageParamVo) throws Exception {
		Page<MDevice> vo = deviceService.queryForDevice(deviceName, deviceVender, deviceType, pageParamVo);
		ModelAndView mv = new ModelAndView("professional/device/device");
		mv.addObject("page", vo);
		mv.addObject("deviceName", deviceName);
		mv.addObject("deviceVender", deviceVender);
		mv.addObject("deviceType", deviceType);
		return mv;
	}
	
	/**
	 * 获取设备列表
	 * DeviceCtl.listForDevice()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device")
	public ModelAndView listForDevice(PageParamVO pageParamVo) throws Exception {
		Page<MDevice> vo = deviceService.listForDevice(pageParamVo);
		ModelAndView mv = new ModelAndView("professional/device/device");
		mv.addObject("page", vo);
		return mv;
	}
	
	/**
	 * 跳转至添加页
	 * DeviceCtl._goAddPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/add")
	public ModelAndView _goAddPage(PageParamVO pageParamVo) throws Exception {
		
		//获取设备类型
		List<DeviceTypeVO> deviceTypes = deviceService.getDeviceTypes();
		
		ModelAndView mv = new ModelAndView("professional/device/deviceInput");
		mv.addObject("page", pageParamVo);
		mv.addObject("deviceTypes", deviceTypes);
		return mv;
	}
	
	/**
	 * 跳转至修改页
	 * DeviceCtl._goModifyPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/modify")
	public ModelAndView _goModifyPage(Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取评估量表信息
		DeviceVO vo = deviceService.getDeviceVo(id);
		
		//获取设备类型
		List<DeviceTypeVO> deviceTypes = deviceService.getDeviceTypes();
		
		ModelAndView mv = new ModelAndView("professional/device/deviceInput");
		mv.addObject("device", vo);
		mv.addObject("page", pageParamVo);
		mv.addObject("deviceTypes", deviceTypes);
		return mv;
	}
	
	/**
	 * 保存或更新设备信息
	 * DeviceCtl._saveOrUpdate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/commit")
	public ModelAndView _saveOrUpdate(HttpSession session, DeviceVO vo, PageParamVO pageParamVo) throws Exception {
		
		//自检
		vo.selfValidate();
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		
		//增加或修改设备
		deviceService.saveOrUpdateDevice(vo, userName);
		
		return listForDevice(pageParamVo);
	}
	
	/**
	 * 删除设备信息
	 * DeviceCtl._remove()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-5 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/device/delete")
	public ModelAndView _remove(HttpSession session, Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		
		//删除评估量表
		deviceService.deleteDevice(id, userName);
		
		return listForDevice(pageParamVo);
	}
}
