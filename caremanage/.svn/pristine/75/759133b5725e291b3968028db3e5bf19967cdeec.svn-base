package com.anticw.aged.controller.icare.combo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.ZCombo;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.icare.combo.ComboService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.professional.activity.NProgrqamVO1;

/**
 * 
 * @author DX
 * @<p>套餐管理</p>
 *
 */
@Controller
@RequestMapping("/ICareCombo")
public class ComboController {

	@Autowired
	private ComboService comboService;
	@Autowired
	private SpringDataPool springDataPool;
	@Autowired
	private FileHandle fileHandle;

	/**
	 * 列表展示
	 * 
	 * @param pageVO
	 * @param zName
	 * @param dateVO
	 * @return
	 */
	@RequestMapping("/combo/list")
	public ModelAndView getPage(PageParamVO pageVO, String zName,
			DateParamVO dateVO) {
		if (dateVO.getStart() == null) {
			dateVO.setStart(DateUtil.parseStrToDate("2016-12-10"));
		}
		if (dateVO.getEnd() == null) {
			dateVO.setEnd(DateUtil.getLastDayInMonth(new Date()));
		}
		Page<ZCombo> page = comboService.getPage(pageVO, zName, dateVO);
		ModelAndView mv = new ModelAndView("/ICare/combo/comboList");
		mv.addObject("zName", zName);
		mv.addObject("dateVO", dateVO);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 去修改页面
	 * 
	 * @param id
	 * @param session
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/combo/toOperate")
	public ModelAndView updateAndaAdd(Integer id, HttpSession session)
			throws IllegalAccessException, InvocationTargetException {
		ModelAndView mv = new ModelAndView("/ICare/combo/operate");
		List<NProgram> list = springDataPool.getParent();
		if (list.size() != 0) {
			List<NProgrqamVO1> childrenlist = springDataPool.getNProgram(list
					.get(0).getId());
			mv.addObject("childrenlist", childrenlist);
			mv.addObject("prentId", list.get(0).getId());
		}
		mv.addObject("nprop", list);
		mv.addObject("id", id);

		if (id != null) {
			ZCombo zb = comboService.getById(id);
			List<NProgram> nProgram = comboService.ListNPrograms(zb
					.getNprogramIds());
			mv.addObject("zCombo", zb);
			mv.addObject("nProgram", nProgram);
		}
		return mv;
	}

	/**
	 * 获取课程详情
	 * 
	 * @param parentId
	 * @param response
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/combo/nprop")
	@ResponseBody
	public List<NProgrqamVO1> getNprop(int parentId,
			HttpServletResponse response) throws IllegalAccessException,
			InvocationTargetException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<NProgrqamVO1> npr = springDataPool.getNProgram(parentId);
		/*
		 * JSONObject json=new JSONObject(); json.put("npr", npr);
		 */
		return npr;
	}

	/**
	 * 上架/下架
	 * 
	 * @param id
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/combo/putaway")
	@ResponseBody
	public String getPutaway(int id) throws IllegalAccessException,
			InvocationTargetException {
		try {
			comboService.getPutaway(id);
			return "成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "未成功，请重新点击";
		}
	}

	/**
	 * 添加和修改
	 * 
	 * @param z
	 * @param session
	 * @return
	 */
	@RequestMapping("/combo/operate")
	public ModelAndView updateAndaAdd(ZCombo z, HttpSession session,@RequestParam(value = "pic", required = false)MultipartFile pic) {
		List<NProgram> np = comboService.ListNPrograms(z.getNprogramIds());
		double originalPrice = 0.0;
		for (NProgram n : np) {
			if (n.getPrice() != null) {
				originalPrice += n.getPrice();
			}
		}
		try {
			if(pic!=null){
				String imgUrl = fileHandle.uploadPic(pic);
				z.setImgUrl(imgUrl);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		z.setOriginalPrice(originalPrice);
		if (z.getComboId() != null) {
			comboService.update(z, session);
		} else {
			comboService.add(z, session);
		}
		ModelAndView mv = new ModelAndView(
				new RedirectView("/ICareCombo/combo/list"));
		return mv;
	}

	/**
	 * 删除一个套餐
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/combo/remove")
	public ModelAndView remove(int id) {
		ModelAndView mv = new ModelAndView(
				new RedirectView("/ICareCombo/combo/list"));
		comboService.remove(id);
		return mv;
	}
	
}
