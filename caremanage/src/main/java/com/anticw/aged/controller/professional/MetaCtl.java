package com.anticw.aged.controller.professional;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.professional.DeviceService;
import com.anticw.aged.service.professional.MetaService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.device.DeviceTypeVO;
import com.anticw.aged.vo.professional.meta.MetaVO;

/**
 * 元服务相关请求控制器
 * <P>File name : MetaService.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
@Controller
public class MetaCtl {

	/**
	 * 元服务业务逻辑处理类
	 */
	@Autowired
	private MetaService metaService;
	
	/**
	 * 设备类型业务逻辑处理类
	 */
	@Autowired
	private DeviceService deviceTypeSevice;
	
	/**
	 * 获取元服务列表
	 * MetaCtl.listForDeviceType()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/meta")
	public ModelAndView list(PageParamVO pageParamVo) throws Exception {
		Page<MMetaService> vo = metaService.list(pageParamVo);
		ModelAndView mv = new ModelAndView("professional/meta/meta");
		mv.addObject("page", vo);
		return mv;
	}
	
	/**
	 * 跳转至添加页面
	 * MetaCtl.goAddPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/meta/add")
	public ModelAndView goAddPage(PageParamVO pageParamVo) throws Exception {
		
		//设备类型集合
		List<DeviceTypeVO> deviceTypes = deviceTypeSevice.getDeviceTypes();
		
		ModelAndView mv = new ModelAndView("professional/meta/metaInput");
		mv.addObject("page", pageParamVo);
		mv.addObject("devices", deviceTypes);
		return mv;
	}
	
	/**
	 * 跳转至修改页面
	 * MetaCtl.goModifyPage()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/meta/modify")
	public ModelAndView goModifyPage(Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取评估量表信息
		MetaVO vo = metaService.get(id);
		
		//设备类型集合
		List<DeviceTypeVO> deviceTypes = deviceTypeSevice.getDeviceTypes();
		
		ModelAndView mv = new ModelAndView("professional/meta/metaInput");
		mv.addObject("meta", vo);
		mv.addObject("devices", deviceTypes);
		mv.addObject("page", pageParamVo);
		return mv;
	}
	
	/**
	 * 保存或修改元服务
	 * MetaCtl.saveOrUpdate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/meta/commit")
	public ModelAndView saveOrUpdate(HttpSession session, MetaVO vo, PageParamVO pageParamVo) throws Exception {
		
		//自检
		vo.selfValidate();
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		//增加或修改评估量表
		metaService.saveOrUpdate(vo, userName);
		
		return list(pageParamVo);
	}
	
	/**
	 * 删除元服务
	 * MetaCtl.remove()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-4 </P>
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/professional/meta/delete")
	public ModelAndView remove(HttpSession session, Integer id, PageParamVO pageParamVo) throws Exception {
		
		//获取用户信息
		String userName = ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		
		//删除评估量表
		metaService.delete(id, userName);
		
		return list(pageParamVo);
	}
}
