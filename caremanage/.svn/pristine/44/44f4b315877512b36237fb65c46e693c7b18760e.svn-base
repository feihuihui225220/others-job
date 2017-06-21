package com.anticw.aged.controller.icare.fenpeiCM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.ZManagerInfo;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.icare.fenpeiCM.fenpeiCMService;
import com.anticw.aged.vo.common.PageParamVO;

@Controller
@RequestMapping("/ICare/fenpeiCM")
public class fenpeiCMCtl {
	
	@Autowired
	private fenpeiCMService cmService;
	
	@RequestMapping("/list")
	public ModelAndView listAllManagerInfo(PageParamVO vo,String name){
		ModelAndView view=new ModelAndView("/ICare/fenpeiCM/list");
		if(("").equals(name)){
			name=null;
		}
		Page<ZManagerInfo> page=cmService.listAllManagerInfo(vo, name);
		view.addObject("page", page);
		return view;
	}
	
	
}
