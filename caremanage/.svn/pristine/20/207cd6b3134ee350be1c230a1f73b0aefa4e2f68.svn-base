package com.anticw.aged.controller.icare.active;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.ZActive;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.icare.active.activeService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("/active/")
public class ActiveCtl {

	@Autowired
	private activeService activeService;
	@Autowired
	private FileHandle fileHandle;

	/**
	 * 查询所有的活动
	 * 
	 * @author lenovo
	 */
	@RequestMapping("listAllActive")
	public ModelAndView listAllAcitve(String activeName, String startTime, String endTime, PageParamVO vo,
			Integer rId) {
		ModelAndView view = new ModelAndView("/ICare/active/listAllActive");
		Integer state = 0;
		view.addObject("page", activeService.listAllAcitve(activeName, state, startTime, endTime, vo, rId));
		view.addObject("activeName", activeName);
		view.addObject("startTime", startTime);
		view.addObject("endTime", endTime);
		return view;
	}

	/**
	 * 根据ID查询NActivityPlan
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("findActive")
	public ModelAndView findActive(Integer id) {
		if (id != null) {
			ModelAndView view = new ModelAndView("/ICare/active/modifyActive");
			view.addObject("active", activeService.findActiveById((long) id));
			return view;
		}
		return new ModelAndView("/ICare/active/saveActive");
	}

	@RequestMapping("saveActive")
	public ModelAndView saveActive(ZActive active, String stTime, String endTime,
			@RequestParam(value = "pics", required = false) MultipartFile pics, HttpSession session)
					throws IOException, ParseException {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 添加ZActive
		ZActive za = new ZActive();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datest = format.parse(stTime);
		Date dateen = format.parse(endTime);
		String url = fileHandle.uploadPicse("file/active/", pics);
		za.setActivePoster(url);
		za.setActiverReadings(active.getActiverReadings());
		za.setActiveDesc(active.getActiveDesc());
		za.setActiveLxr(active.getActiveLxr());
		za.setActiveName(active.getActiveName());
		za.setActivePhone(active.getActivePhone());
		za.setActiveTime(active.getActiveTime());
		za.setCreateAt(new Date());
		za.setCreateBy(userVo.getName());
		za.setState(0);
		za.setAvaliable(PropertyValueConstants.AVAILABLE);
		za.setStartTime(datest);
		za.setEndTime(dateen);
		try {
			activeService.saveActive(za);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ModelAndView(new RedirectView("/active/listAllActive"));
	}

	/**
	 * 修改活动
	 * 
	 * @param cId
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("modifyActive")
	public ModelAndView modifyActive(ZActive active, String stTime, String endTime,
			@RequestParam(value = "pic", required = false) MultipartFile pic, HttpSession session)
					throws IOException, ParseException {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 修改ZActive
		ZActive ac = activeService.findActiveById(active.getId());
		String oldUrl = ac.getActivePoster();
		if (!pic.isEmpty()) {
			String url = fileHandle.uploadPicse("file/active/", pic);
			ac.setActivePoster(url);
			fileHandle.remove(oldUrl);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datest = format.parse(stTime);
		Date dateen = format.parse(endTime);
		ac.setStartTime(datest);
		ac.setEndTime(dateen);
		ac.setActiveDesc(active.getActiveDesc());
		ac.setActiveLxr(active.getActiveLxr());
		ac.setActiveName(active.getActiveName());
		ac.setActivePhone(active.getActivePhone());
		ac.setActiveTime(active.getActiveTime());
		ac.setCreateAt(new Date());
		ac.setCreateBy(userVo.getName());
		ac.setAvaliable(PropertyValueConstants.AVAILABLE);
		activeService.updateActive(ac);
		return new ModelAndView(new RedirectView("/active/listAllActive"));
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer cId) {
		String result = null;
		try {
			String url = activeService.findActiveById((long) cId).getActivePoster();
			if (url != null) {
				fileHandle.remove(url);
			}
			activeService.deleteActive((long) cId);
			result = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			result = "error";
			e.printStackTrace();
		}
		return result;
	}

	/**********************************************************************************/
	/**
	 * 用户活动照片上传
	 */
	@RequestMapping("CMUserPhotoList")
	public ModelAndView CMUserPhotoList(String activeName, String startTime, String endTime, PageParamVO vo,
			Integer rId) {
		ModelAndView view = new ModelAndView("/ICare/activePhoto/list");
		Integer state = 1;
		view.addObject("page", activeService.listAllAcitve(activeName, state, startTime, endTime, vo, rId));
		view.addObject("activeName", activeName);
		view.addObject("startTime", startTime);
		view.addObject("endTime", endTime);
		return view;
	}

	@RequestMapping("CMUserAddPhotoHtml")
	public ModelAndView CMUserAddPhotoHtml(Integer aId) {
		if (aId != null) {
			// 修改
			ModelAndView mv = new ModelAndView("/ICare/activePhoto/modifyActive");
			mv.addObject("active", activeService.findActiveById((long) aId));
			return mv;
		}
		return new ModelAndView("/ICare/activePhoto/saveActive");
	}

	@RequestMapping("CMUserAddPhoto")
	public ModelAndView CMUserAddPhoto(ZActive active, String startTime, String endTime,
			@RequestParam(value = "pic", required = false) MultipartFile[] pic, HttpSession session)
					throws IOException, ParseException {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		if (pic != null) {
			String path = "file/activePhoto/" + active.getUserId() + "/";
			List<String> imgUrl = fileHandle.uploadImg(path, pic);
			String url = StringUtils.join(imgUrl.toArray(), ",");
			active.setActivePoster(url);
		}
		active.setCreateBy(userVo.getName());
		active.setCreateAt(new Date());
		active.setState(1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = format.parse(startTime);
		Date date2 = format.parse(endTime);
		active.setStartTime(date);
		active.setEndTime(date2);
		active.setAvaliable(PropertyValueConstants.AVAILABLE);
		try {
			activeService.saveActive(active);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView(new RedirectView("/active/CMUserPhotoList?rId=" + active.getUserId()));
	}

	@RequestMapping("CMUserModifyPhoto")
	public ModelAndView CMUserModifyPhoto(ZActive active, String deleteUrl, String startTime, String endTime,
			@RequestParam(value = "pic", required = false) MultipartFile[] pic) throws IOException, ParseException {
		ZActive zActive = activeService.findActiveById(active.getId());
		zActive.setActiveDesc(active.getActiveDesc());
		zActive.setActiveLxr(active.getActiveLxr());
		zActive.setActiveName(active.getActiveName());
		zActive.setActivePhone(active.getActivePhone());
		String oldUrl = null;
		String path = "file/activePhoto/" + zActive.getUserId() + "/";
		// 线下活动图片集
		if (pic != null) {
			oldUrl = zActive.getActivePoster();
			List<String> imgUrl = fileHandle.uploadImg(path, pic);
			String url = StringUtils.join(imgUrl.toArray(), ",");
			// 获取已经被删除的图片路径
			if (deleteUrl == null || ("").equals(deleteUrl)) {
				String[] nUrls = { oldUrl, url };
				zActive.setActivePoster(StringUtils.join(nUrls, ","));
			} else {
				String[] deurls = deleteUrl.split(",");
				String[] oldUrls = zActive.getActivePoster().split(",");
				List<String> list = new ArrayList<String>();
				for (String str : oldUrls) { // 处理第一个数组,list里面的值为1,2,3,4
					if (!list.contains(str)) {
						list.add(str);
					}
				}
				for (String str : deurls) { // 如果第二个数组存在和第一个数组相同的值，就删除
					if (list.contains(str)) {
						fileHandle.removeImg(str, "D:/");
						list.remove(str);
					}
				}
				// List to Array
				String newUrl = StringUtils.join(list.toArray(), ",");
				if (("").equals(newUrl)) {
					zActive.setActivePoster(url);
				} else {
					String[] nUrl = { newUrl, url };
					zActive.setActivePoster(StringUtils.join(nUrl, ","));
				}
			}
		} /*
			 * else{ zActive.setActivePoster(active.getActivePoster()); }
			 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = format.parse(startTime);
		Date date2 = format.parse(endTime);
		zActive.setStartTime(date);
		zActive.setEndTime(date2);
		zActive.setActiverReadings(active.getActiverReadings());
		zActive.setActiveTime(active.getActiveTime());
		activeService.updateActive(zActive);
		return new ModelAndView(new RedirectView("/active/CMUserPhotoList?rId=" + active.getUserId()));
	}

	/**
	 * 删除图片
	 * 
	 * @param id
	 * @param url
	 * @param request
	 * @return
	 */
	@RequestMapping("CMdelete")
	@ResponseBody
	public String CMdelete(Integer id, String url, HttpServletRequest request) {
		String result = null;
		ZActive zActive = activeService.findActiveById((long) id);
		try {
			String[] urls = url.split(",");
			String[] oldUrls = zActive.getActivePoster().split(",");
			List<String> list = new ArrayList<String>();
			for (String str : oldUrls) { // 处理第一个数组,list里面的值为1,2,3,4
				if (!list.contains(str)) {
					list.add(str);
				}
			}
			for (String str : urls) { // 如果第二个数组存在和第一个数组相同的值，就删除
				if (list.contains(str)) {
					fileHandle.removeImg(str, "D:/");
					list.remove(str);
				}
			}
			// List to Array
			String newUrl = StringUtils.join(list.toArray(), ",");
			zActive.setActivePoster(newUrl);
			activeService.updateActive(zActive);
			result = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "error";
		}
		return result;
	}

	/**
	 * 删除活动记录
	 */
	@RequestMapping("CMdele")
	@ResponseBody
	public String CMdelete(Integer id) {
		String result = null;
		try {
			String urls = activeService.findActiveById((long) id).getActivePoster();
			if (urls != null) {
				String[] url = urls.split(",");
				for (int i = 0; i < url.length; i++) {
					/* fileHandle.remove(url[i]); */
					fileHandle.removeImg(url[i], "D:/");
				}
			}
			activeService.deleteActive((long) id);
			result = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "error";
		}
		return result;
	}

}
