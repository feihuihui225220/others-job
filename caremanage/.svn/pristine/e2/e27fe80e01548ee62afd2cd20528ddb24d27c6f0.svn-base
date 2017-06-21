package com.anticw.aged.controller.professional.activity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.bean.NPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.professional.activity.PhotoService;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("professional/photo")
public class PhotoCtl{

	@Autowired
	private PhotoService photoService;
	 
	
	/**
	 * 添加一个相册
	 * @param Photo
	 * @param session
	 * @param request
	 * @throws IOException 
	 * ,HttpSession session,
			@RequestParam(value = "pic", required = false)MultipartFile[] pic,
			HttpServletRequest request,int albumId
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/add")  
	public void insertPhoto(HttpSession session,NPhoto photo,HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException {
		    
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		
		String createdBy = userVo.getName();
		
		photo.setCreatedBy(createdBy);
		 request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html; charset=UTF-8");  
	        PrintWriter out = response.getWriter();  
	        //文件保存目录路径  
	        String path = this.getClass().getClassLoader().getResource("/").toString().replace("/classes/", "/").substring(6);
	        
	        String dirTemp = path+"file/pictures/";  
	        //创建文件夹  
	          
	        DiskFileItemFactory  factory = new DiskFileItemFactory();  
	        factory.setSizeThreshold(20 * 1024 * 1024); //设定使用内存超过5M时，将产生临时文件并存储于临时目录中。     
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setHeaderEncoding("UTF-8");  
	        List items;
	        try {
            items = upload.parseRequest(request);
			Iterator itr = items.iterator();  
				while (itr.hasNext()){  
	                FileItem item = (FileItem) itr.next();  
	                String fileName = item.getName();  
	                if (!item.isFormField()) {  
	                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();  
	                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
	                    String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;  
	                    try{  
	                        File uploadedFile = new File(path+"file/pictures/", newFileName);  
	                        FileUtils.copyInputStreamToFile(item.getInputStream(),uploadedFile);
	                        Date date = new Date();
	                        photo.setAvaliable(PropertyValueConstants.AVAILABLE);
	        				photo.setCreatedAt(date);
	        				photo.setCreatedBy(createdBy);
	        				photo.setPhotoUrl("file/pictures/"+newFileName);
	        				photo.setVersion((short) 1);
	        				photoService.insertPhoto(photo);
	                        out.print(dirTemp+"/"+newFileName);  
	                    }catch(Exception e){  
	                        e.printStackTrace();  
	                    }  
	                }            
				}   
              
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        out.flush();  
        out.close(); 
		
	}

	

	/**
	 * 删除一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String deletePhoto(Integer id,int albumId,HttpServletRequest request) {
		
		photoService.deletePhoto(photoService.findOnePhoto(id));
		return "redirect:/professional/album/findOneAlbum?id="+albumId;
	}

	/**
	 * 查询一个相册
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/findOnePhoto")
	public String findOnePhoto(Integer id,HttpServletRequest request) {
		NPhoto photo = photoService.findOnePhoto(id);
		request.setAttribute("Photo", photo);
		return "";
	}

	/**
	 * 编辑照片
	 * @param Photo
	 * @param request
	 * @return
	 */
	@RequestMapping("/editPhoto")
	public String editPhoto(HttpSession session,NPhoto photo,HttpServletRequest request) {
		Date date = new Date();
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String changedBy = userVo.getName();
		NPhoto photo1 = photoService.findOnePhoto(photo.getId());
		photo1.setPhotoName(photo.getPhotoName());
		photo1.setPhotoDesc(photo.getPhotoDesc());
		photo1.setChangedBy(changedBy);
		photo1.setChangedAt(date);
		photoService.editPhoto(photo1);
		return "redirect:/professional/album/findOneAlbum?id="+photo1.getAlbumId();

	}

	/**
	 * 按创建者查询所有相册
	 * @param createBy：创建人账号
	 * @return
	 */
	@RequestMapping("/findAllPhoto")
	public String findAllPhoto(String createBy,HttpServletRequest request) {
		//List<NPhoto> listPhoto = photoService.findAllPhoto(createBy);
		//request.setAttribute("listPhoto", listPhoto);
		return null;
	}

}
