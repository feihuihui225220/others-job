package com.anticw.aged.service.attchment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.utils.PropertyValueConstants;

/**
 * 处理系统中的文件上传和下载的公共服务类
 * <P>File name : AttchmentHandle.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-28 </P>
 */
@Service
public class AttchmentHandle {
	
	private static Logger logger = LoggerFactory.getLogger(AttchmentHandle.class);
	
	@Autowired
	private AttchmentTypes attchmentType;
	private String path;
	
	public AttchmentHandle(){
		this.path = this.getClass().getClassLoader().getResource("/").toString().replace("/classes/", PropertyValueConstants.ATTCHMENT_POSITON).substring(6);
	}
	
	public String[] upload(int attType, MultipartFile[] files, String...parameters) throws IOException {
		String url = attchmentType.getAttURI(attType, parameters);
		logger.debug("url:"+url);
		List<String> paths = null;
		if(files!=null && files.length>0){
			paths = new ArrayList<String>();
			for(MultipartFile f:files){
				if(f != null&&!f.isEmpty()) {
					String finalName = String.valueOf(System.currentTimeMillis())+f.getOriginalFilename();
					File file = new File(this.path+url,finalName);
					FileUtils.copyInputStreamToFile(f.getInputStream(),file );
					//paths.add(PropertyValueConstants.ATTCHMENT_POSITON+url+finalName);
				}
			}
			return paths.isEmpty()?null:paths.toArray(new String[paths.size()]);
		}
		return null;
	}
	
	public void remove(String path){
		File file = this.getFile(path);
		file.delete();
	}
	
	public File getFile(String path){
		String p = this.path.substring(0, this.path.length()-PropertyValueConstants.ATTCHMENT_POSITON.length())+path;
		return new File(p);
	}
	
	public void download(String path,String rename,HttpServletResponse response){
		FileInputStream instm = null;  //输入流
		ServletOutputStream outstm = null;  //输出流
		try{
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-disposition", "attachment; filename="+new String(rename.getBytes("UTF-8"),"ISO8859-1"));
			instm = new  FileInputStream(this.getFile(path));
			outstm = response.getOutputStream();
			outstm.flush();
			int aRead = 0;
			while((aRead = instm.read()) != -1 & instm != null)
			{
			   outstm.write(aRead);
			}
			outstm.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				instm.close();
				outstm.close();
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
	}
}
