package com.anticw.aged.controller.professional.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NAlbum;
import com.anticw.aged.bean.NCheckList;
import com.anticw.aged.bean.NPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.service.professional.activity.AlbumService;
import com.anticw.aged.service.professional.activity.PhotoService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("professional/album")
public class AlbumCtl{

	@Autowired
	private AlbumService albumService;
	@Autowired
	private FileHandle fileHandle;
	@Autowired
	private PhotoService photoService;
   @Autowired
    private ActivityManagerService activityManagerService;
	
   
   @RequestMapping("/seeprogram")
    public @ResponseBody JSONObject getactivity(HttpSession session,Date start,Date end){
    	UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
    	String name=userVo.getName();
    	int venderId=userVo.getVenderId();
    	List<NActivityPlan> nActivityPlan= new ArrayList<NActivityPlan>();
    	if(userVo.getVenderId()!=null){
    		AUser aUser=activityManagerService.findName(name,venderId);
    		if(aUser.getSuper_()==true){
    			//说明不是员工查询所有
    			 List<AUser> li=activityManagerService.getVenderAdmins(name);
    			 li.add(aUser);
    			 //根据创建者查询所有的节目（可用的）
    			 for(AUser a:li){
    				 List<NActivityPlan> lis=activityManagerService.getNActivityPlan(a.getName(),start,end);
    				 nActivityPlan.addAll(lis);
    			 }
    		}else{
    			nActivityPlan.addAll(activityManagerService.getNActivityPlan(name,start,end));
    		}
    	}
    	
    	JSONObject list=new JSONObject();
    	list.put("nActivityPlan", nActivityPlan);
    	return list;
    }
	
	/**
	 * 添加一个相册
	 * @param album
	 * @param session
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/add")
	public String insertAlbum(NAlbum album,HttpSession session,HttpServletRequest request,
			@RequestParam(value = "pic", required = false)MultipartFile pic) throws IOException {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String createdBy = userVo.getName();
		album.setCreatedBy(createdBy);
		album.setChangedBy(createdBy);
		String albumName = fileHandle.uploadPic(pic);
		album.setAlbumUrl(albumName);
		albumService.insertAlbum(album);
		return "redirect:/professional/album/findAllAlbum";
	}
	/**
	 * 跳转到相册添加页面
	 * @return
	 */
	@RequestMapping("/toaddalbum")
	public String toAddAlbum(){
		return "/professional/activity/album/albumadd";
	}
	/**
	 * 删除一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteAlbum(Integer id,HttpServletRequest request) {
		
		albumService.deleteAlbum(albumService.findOneAlbum(id));
		photoService.deleteAlbum(photoService.findsPhoto(id));
		return "redirect:/professional/album/findAllAlbum";

	}

	/**
	 * 查询一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/findOneAlbum")
	public ModelAndView findOneAlbum(Integer id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/professional/activity/album/look_album");
		if(photoService.findAllPhoto(id)!=null){
			List<NPhoto> listPhoto = photoService.findAllPhoto(id);
			mv.addObject("listPhoto", listPhoto);
		}
		
		mv.addObject("photoId", id);
		return mv;
	}
	@RequestMapping("/findOneAlbum/toAdd")
	public ModelAndView addPhoto(Integer id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/professional/activity/album/addPhoto");
		mv.addObject("photoId", id);
		return mv;
	}
	
	
	/**
	 * 查询一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/findOneAlbumWeixin")
	public @ResponseBody JSONObject findOneAlbumWeixin(Integer id,PageParamVO pageVO,HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if(photoService.findAllPhoto(id)!=null){
			List<NPhoto> listPhoto = photoService.findAllPhoto(id);
			json.put("listPhoto", listPhoto);
		}
		return json;
	}
	
	/**
	 * 查询一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/myOneAlbum")
	public ModelAndView myOneAlbum(Integer id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/professional/activity/album/my_photo");
		if(photoService.findAllPhoto(id)!=null){
			List<NPhoto> listPhoto = photoService.findAllPhoto(id);
			mv.addObject("listPhoto", listPhoto);
		}
		mv.addObject("photoId", id);
		return mv;
	}

	/**
	 * 编辑相册
	 * @param album
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/editAlbum")
	public String editAlbum(NAlbum album,HttpSession session,HttpServletRequest request,
			@RequestParam(value = "pic", required = false)MultipartFile pic) throws IOException {
		Date date = new Date();
		NAlbum album1=albumService.findOneAlbum(album.getId());
		int i=0;
		try {
			Integer.parseInt(album1.getAlbumName());
		} catch (NumberFormatException e) {
			i=1;
		}
		if(pic!=null){
			if(i!=0){
			fileHandle.removePic(album1.getAlbumName());
			}
			String  albumName= fileHandle.uploadPic(pic);
			album1.setAlbumUrl(albumName);
		}
		album1.setAlbumDesc(album.getAlbumDesc());
		album1.setAlbumName(album.getAlbumName());
		album1.setChangedAt(date);
		album1.setChangedBy(album1.getCreatedBy());
		albumService.editAlbum(album);
		return "redirect:/professional/album/findAllAlbum";

	}

	/**
	 * 按创建者查询所有相册
	 * @param createBy：创建人账号
	 * @return 
	 */
	@RequestMapping("/findAllAlbum")
	public String findAllAlbum(HttpSession session,String createBy,HttpServletRequest request) {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String createdBy = userVo.getName();
		List<NAlbum> listAlbum = albumService.findAllAlbum(createdBy);
		request.setAttribute("listAlbum", listAlbum);
		return "/professional/activity/album/albumlist";
	}
	
	/**
	 * 按创建者查询所有相册
	 * @param createBy：创建人账号
	 * @return 
	 */
	@RequestMapping("/findAllAlbumWeixin")
	public @ResponseBody JSONObject findAllAlbumWeixin(PageParamVO page) {
		JSONObject json = new JSONObject();
		Page<NAlbum> list = albumService.findAllAlbumWeixin(page.getPage(),page.getNum());
		json.put("listAlbum", list);
		return json;
	}
	
	@RequestMapping("/myalbum")
	public String findMyalbum(HttpSession session,String createBy,HttpServletRequest request) {
		//获取老人id查看活动中签到情况
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		//要改数据库字段，目前老人是int
		List<NCheckList> nCheckList=activityManagerService.getListNCheckList((int)userVo.getId());
		List<NAlbum> listAlbum = new ArrayList<NAlbum>();
		//根据所有的活动获取相册
		for(NCheckList n:nCheckList){
			listAlbum.addAll(albumService.findAllAlbum(n.getActivityId()));
		}
		request.setAttribute("listAlbum", listAlbum);
		/*String createdBy = userVo.getName();
		List<NAlbum> listAlbum = albumService.findAllAlbum(createdBy);
		*/
		return "/professional/activity/album/myalbum";
	}  

}
