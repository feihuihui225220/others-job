package com.anticw.aged.controller.icare.active;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.ZActive;
import com.anticw.aged.bean.ZPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.icare.active.activeService;
import com.anticw.aged.service.icare.photo.IcarePhotoService;
import com.anticw.aged.utils.file.SortByDate;
import com.anticw.aged.vo.icare.ActiveVO;

@Controller
@RequestMapping("/weixin/")
public class ICWeiXinCtl {

	@Autowired
	private activeService activeService;
	@Autowired
	private IcarePhotoService photoService;
	@Autowired
	private RUserService rUserService;
	/**********************************************************************************/

	/**
	 * 前台活动
	 */
	/**
	 * 活动列表浏览量最多的四条数据
	 */
	@RequestMapping("ListActive")
	@ResponseBody
	public JSONObject frontendListActive(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<ZActive> list = activeService.list();
		JSONObject json = new JSONObject();
		json.put("activeList", list);
		return json;
	}

	/**
	 * 查询一条活动详情
	 */
	@RequestMapping("ByIdActive")
	@ResponseBody
	public JSONObject frontendByIdActive(Integer id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ZActive acs = activeService.findActiveById((long) id);
		long red = Long.parseLong(acs.getActiverReadings());
		long read = red + 1;
		acs.setActiverReadings(String.valueOf(read));
		activeService.updateActive(acs);
		ZActive ac = activeService.findActiveById((long) id);
		JSONObject json = new JSONObject();
		json.put("active", ac);
		return json;
	}

	/**************************************************/
	/**
	 * 动态记录
	 * 
	 * @param rId
	 * @param dates
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("UserPhoto")
	@ResponseBody
	public JSONObject userPhoto(Integer rId, String dates, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		JSONObject json = new JSONObject();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);
		List<ZActive> list = activeService.listZActiveByIdAndDay((long) rId, date);
		List<ZPhoto> list2 = photoService.listPhotoByIdAndDay((long) rId, date);
		List<ActiveVO> listVO = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ActiveVO vo = new ActiveVO();
			vo.setId(list.get(i).getId());
			vo.setCreatedAt(list.get(i).getCreateAt());
			vo.setUrl(list.get(i).getActivePoster());
			// vo.setActiveDesc(list.get(i).getActiveDesc());
			vo.setActiveDesc(list.get(i).getActiveName());
			vo.setUserId(list.get(i).getUserId());
			listVO.add(vo);
		}
		for (int j = 0; j < list2.size(); j++) {
			ActiveVO vos = new ActiveVO();
			vos.setId(list2.get(j).getId());
			vos.setCreatedAt(list2.get(j).getCreatedAt());
			vos.setUrl(list2.get(j).getPhotoUrl());
			vos.setActiveDesc(list2.get(j).getPhotoName());
			vos.setUserId(list2.get(j).getUserId());
			listVO.add(vos);
		}
		json.put("active", listVO);
		return json;
	}

	/**
	 * 清空某天所有照片
	 * 
	 * @param dates
	 * @param id
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("deletAllPhoto")
	@ResponseBody
	public String deletAllPhoto(String dates, Integer id, HttpServletResponse response) throws ParseException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String result = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);
		List<ZActive> list = activeService.listZActiveByIdAndDay((long) id, date);
		List<ZPhoto> list2 = photoService.listPhotoByIdAndDay((long) id, date);
		try {
			for (int i = 0; i < list.size(); i++) {
				activeService.deleteActive(list.get(i).getId());
			}
			for (int j = 0; j < list2.size(); j++) {
				photoService.deletePhoto(list2.get(j));
			}
			result = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "error";
		}
		return result;
	}

	/**
	 * 单个删除
	 * 
	 * @param id
	 * @param url
	 * @return
	 */
	@RequestMapping("deleteUserPhoto")
	@ResponseBody
	public String deleteUserPhoto(Integer id, String url, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String result = null;
		List<String> list = new ArrayList<String>();
		int tru = url.indexOf("activePhoto");
		if (tru != -1) {
			// 活动照片删除
			ZActive active = activeService.findActiveById((long) id);
			String aoldUser = active.getActivePoster();
			String[] oldUrls = aoldUser.split(",");
			for (String str : oldUrls) { // 处理第一个数组,list里面的值为1,2,3,4
				if (!list.contains(str)) {
					list.add(str);
				}
			}
			// 如果第二个数组存在和第一个数组相同的值，就删除
			if (list.contains(url)) {
				// fileHandle.remove(url);
				list.remove(url);
			}
			String newUrl = StringUtils.join(list.toArray(), ",");
			int t = newUrl.indexOf(",,");
			if (t != -1) {
				newUrl.replace(",,", ",");
			}
			try {
				active.setActivePoster(newUrl);
				if (("").equals(newUrl)) {
					active.setAvaliable(PropertyValueConstants.UNAVAILABLE);
				}
				activeService.updateActive(active);
				result = "OK";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				result = "error";
			}
		} else {
			// 个人照片删除
			ZPhoto photo = photoService.findOnePhoto((long) id);
			String oldph = photo.getPhotoUrl();
			String[] oldUrls = oldph.split(",");
			for (String str : oldUrls) { // 处理第一个数组,list里面的值为1,2,3,4
				if (!list.contains(str)) {
					list.add(str);
				}
			}
			// 如果第二个数组存在和第一个数组相同的值，就删除
			if (list.contains(url)) {
				// fileHandle.remove(url);
				list.remove(url);
			}
			String newUrl = StringUtils.join(list.toArray(), ",");
			int t = newUrl.indexOf(",,");
			if (t != -1) {
				newUrl.replace(",,", ",");
			}
			try {
				photo.setPhotoUrl(newUrl);
				if (("").equals(newUrl)) {
					photo.setAvaliable(PropertyValueConstants.UNAVAILABLE);
				}
				photoService.editPhoto(photo);
				// 如果该条数据中没有图片，删除该
				result = "OK";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				result = "error";
			}
		}
		return result;
	}

	/**
	 * 用户上传记录
	 * 
	 * @param id
	 * @param desc
	 * @param pic
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 */
	@RequestMapping("addPhoto")
	@ResponseBody
	public String addPhoto(Integer id, String url, HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String result = null;
		RUser ruser = rUserService.findById((long) id);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String photoName = format.format(date);
		// long desc=date.getTime();
		ZPhoto photo = new ZPhoto();
		photo.setPhotoName(photoName);
		photo.setAvaliable(PropertyValueConstants.AVAILABLE);
		photo.setCreatedAt(date);
		photo.setPhotoUrl(url);
		photo.setVersion((short) 1);
		photo.setUserId((long) id);
		photo.setCreatedBy(ruser.getName());
		try {
			photoService.insertPhoto(photo);
			result = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "error";
		}
		return result;
	}

	/**
	 * 动态记录
	 * 
	 * @param rId
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("dongtai")
	@ResponseBody
	public JSONObject listUserPhoto(Integer rId, HttpServletResponse response) throws ParseException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		JSONObject json = new JSONObject();
		List<ZPhoto> list = photoService.listWX((long) rId);
		List<ZActive> list2 = activeService.listWX((long) rId);
		List<ActiveVO> listA = new ArrayList<ActiveVO>();
		for (int i = 0; i < list.size(); i++) {
			ActiveVO vo = new ActiveVO();
			vo.setId(list.get(i).getId());
			// vo.setActiveDesc(list.get(i).getPhotoDesc());
			vo.setActiveDesc(list.get(i).getPhotoName());
			vo.setCreatedAt(list.get(i).getCreatedAt());
			vo.setUserId(list.get(i).getUserId());
			vo.setUrl(list.get(i).getPhotoUrl());
			listA.add(vo);
		}
		for (int j = 0; j < list2.size(); j++) {
			ActiveVO vos = new ActiveVO();
			vos.setId(list2.get(j).getId());
			vos.setCreatedAt(list2.get(j).getCreateAt());
			vos.setActiveDesc(list2.get(j).getActiveName());
			vos.setCreatedAt(list2.get(j).getCreateAt());
			vos.setUserId(list2.get(j).getUserId());
			vos.setUrl(list2.get(j).getActivePoster());
			listA.add(vos);
		}
		Collections.sort(listA, new SortByDate());// 按时间排序
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int k = 0; k < listA.size(); k++) {// 去重复
			for (int h = 0; h < listA.size(); h++) {
				if (k != h) {
					String starts = sdf.format(listA.get(k).getCreatedAt());
					String ends = sdf.format(listA.get(h).getCreatedAt());
					long start = sdf.parse(starts).getTime();
					long end = sdf.parse(ends).getTime();
					long sum = start - end;
					if (sum == 0) {
						listA.remove(h);
					}
				}
			}
		}
		json.put("uph", listA);
		return json;
	}

	@RequestMapping("byPhoneRUser")
	@ResponseBody
	public JSONObject byPhoneRUser(HttpServletResponse response, String phone) throws BusinessException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		RUser user = rUserService.findBymobilePhone(phone);
		JSONObject js = new JSONObject();
		if (user == null) {
			js.put("rUser", null);
		} else {
			Long id = user.getId();
			String name = user.getName();
			String idName = id + "," + name;
			js.put("rUser", idName);
		}
		return js;
	}
}
