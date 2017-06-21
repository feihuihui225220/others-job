package com.anticw.aged.controller.icare.photo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.ZPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.icare.photo.IcarePhotoService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
public class IcarePhotoCtl {
	@Autowired
	private IcarePhotoService photoService;
	
	/**
	 * 跳转首页
	 * @param id
	 * @return
	 */
	@RequestMapping("/ICares/")
	public ModelAndView ICare(){
		return new ModelAndView("/ICare/ICindex");
	}
	
	@RequestMapping("/userPhoto/addPhotHtml")
	public ModelAndView addPhotHtml(Integer id){
		if(id!=null){
			ModelAndView mv=new ModelAndView("/ICare/userPhoto/modifyphoto");
			ZPhoto photo = photoService.findOnePhoto((long)id);
			mv.addObject("Photo", photo);
			return mv;
		}else{
			return new ModelAndView("/ICare/userPhoto/addPhoto");
		}
	}
	/**
	 * 添加一个相册
	 * 
	 * @param Photo
	 * @param session
	 * @param request
	 * @throws IOException
	 *             ,HttpSession session,
	 * @RequestParam(value = "pic", required = false)MultipartFile[] pic,
	 *                     HttpServletRequest request,int albumId
	 */
	 @Autowired
	 private FileHandle fileHandle;
	 @Autowired
		private RUserService rUserService;
	 
	@RequestMapping("/userPhoto/addPhoto")
	public String insertPhoto(ZPhoto photo,
			@RequestParam(value = "pic", required = false)MultipartFile[] pic,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, FileUploadException {
		
		RUser ruser=rUserService.findById(photo.getUserId());
		String path="file/userPhoto/"+photo.getUserId()+"/";
		List<String> imgUrl=fileHandle.uploadImg(path,pic);
		String url=StringUtils.join(imgUrl.toArray(),",");
		Date date = new Date();
		photo.setAvaliable(PropertyValueConstants.AVAILABLE);
		photo.setCreatedAt(date);
		photo.setPhotoUrl(url);
		photo.setVersion((short) 1);
		photo.setUserId(photo.getUserId());
		photo.setCreatedBy(ruser.getName());
		try {
			photoService.insertPhoto(photo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/userPhoto/list?rId="+photo.getUserId();
	}

	/**
	 * 删除一个相册
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/userPhoto/delete")
	@ResponseBody
	public String deletePhoto(Integer id,String url,HttpServletRequest request){
		String result=null;
		ZPhoto photo1 = photoService.findOnePhoto((long)id);
		try {
			String[] urls=url.split(",");
			String[] oldUrls=photo1.getPhotoUrl().split(",");
			List<String> list = new ArrayList<String>();
	        for (String str : oldUrls) {                //处理第一个数组,list里面的值为1,2,3,4
	            if (!list.contains(str)) {
	                list.add(str);
	            }
	        }
	        for (String str : urls) {      //如果第二个数组存在和第一个数组相同的值，就删除
	            if(list.contains(str)){
	            	/*fileHandle.remove(str);*/
	            	fileHandle.removeImg("D:/", str);
	                list.remove(str);
	            }
	        }
	         //List to Array
	        String newUrl=StringUtils.join(list.toArray(),",");
			photo1.setPhotoUrl(newUrl);
			photoService.editPhoto(photo1);
			result="OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="error";
		}
		return result;
	}

	/**
	 * 查询一个相册
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/userPhoto/findOnePhoto")
	public String findOnePhoto(Integer id, HttpServletRequest request) {
		ZPhoto photo = photoService.findOnePhoto((long)id);
		request.setAttribute("Photo", photo);
		return "/ICare/userPhoto/modifyphoto";
	}
	/**
	 * 编辑照片
	 * 
	 * @param Photo
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/userPhoto/editPhoto")
	public String editPhoto(HttpSession session, ZPhoto photo,String deleteUrl,
			@RequestParam(value = "pic", required = false)MultipartFile[] pic,
			HttpServletRequest request) throws IOException {
		Date date = new Date();
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String changedBy = userVo.getName();
		ZPhoto photo1 = photoService.findOnePhoto(photo.getId());
		String oldUrl=null;
		String path="file/userPhoto/"+photo.getUserId()+"/";
		if(pic!=null){
			oldUrl=photo1.getPhotoUrl();
			List<String> imgUrl=fileHandle.uploadImg(path,pic);
			String url=StringUtils.join(imgUrl.toArray(),",");
			//获取已经被删除的图片路径
			if(deleteUrl==null||("").equals(deleteUrl)){
				String[] nUrls={oldUrl,url};
				photo1.setPhotoUrl(StringUtils.join(nUrls,","));
			}else{
				String[] deurls=deleteUrl.split(",");
				String[] oldUrls=photo1.getPhotoUrl().split(",");
				List<String> list = new ArrayList<String>();
		        for (String str : oldUrls) {                //处理第一个数组,list里面的值为1,2,3,4
		            if (!list.contains(str)) {
		                list.add(str);
		            }
		        }
		        for (String str : deurls) {      //如果第二个数组存在和第一个数组相同的值，就删除
		            if(list.contains(str)){
		            	//fileHandle.remove(str);
		            	fileHandle.removeImg("D:/", str);
		            	list.remove(str);
		            }
		        }
		         //List to Array
		        String newUrl=StringUtils.join(list.toArray(),",");
		        if(("").equals(newUrl)){
		        	photo1.setPhotoUrl(url);
		        }else{
			        String[] nUrl={newUrl,url};
					photo1.setPhotoUrl(StringUtils.join(nUrl,","));
		        }
			}
		}
		photo1.setChangedBy(changedBy);
		photo1.setChangedAt(date);
		photo1.setPhotoName(photo.getPhotoName());
		photoService.editPhoto(photo1);
		return "redirect:/userPhoto/list?rId="+photo.getUserId();
	}

	/**
	 * 按创建者查询所有相册
	 * 
	 * @param createBy
	 *            ：创建人账号
	 * @return
	 */
	@RequestMapping("/userPhoto/list")
	public ModelAndView findAllPhoto(HttpServletRequest request,Integer rId,
			PageParamVO vo, String startTime, String endTime) {
		ModelAndView view = new ModelAndView("/ICare/userPhoto/list");
		Page<ZPhoto> listPhoto = photoService.findAllPhoto(vo, startTime,
				endTime,(long)rId);
		view.addObject("page", listPhoto);
		return view;
	}
	/**
	 * 删除
	 */
	@RequestMapping("/userPhoto/Udelete")
	@ResponseBody
	public String Udelete(Integer id){
		String result=null;
		//删除照片
		ZPhoto photo=photoService.findOnePhoto((long)id);
		String urls=photo.getPhotoUrl();
		try {
			if(urls!=null){
				String[] url=urls.split(",");
				for (int i = 0; i < url.length; i++) {
					//fileHandle.remove(url[i]);
					fileHandle.removeImg(url[i],"D:/");
				}
			}
			photoService.deletePhoto(photo);
			result="OK";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="error";
		}
		return result;
	}
}
