package com.anticw.aged.utils.file;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
@Component
public class FileHandle {
	public FileHandle(){
		this.path =this.getClass().getClassLoader().getResource("/").toString().replace("/classes/", "/").substring(6);
		/*this.path ="D:/";*/
	}
	
	private String path;
	/**
	 * 批量上传文件
	 * @param fileType
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public  List<String> upload(FileType fileType,MultipartFile[] files) throws IOException{
		List<String> dirs = null;
		if(files!=null&&files.length>0){
			dirs = new ArrayList<String>();
			for(MultipartFile f:files){
				if(f != null&&!f.isEmpty()) {
					String finalName = String.valueOf(System.currentTimeMillis())+f.getOriginalFilename();
					File file = new File(this.path+fileType.getDir(),finalName);
					FileUtils.copyInputStreamToFile(f.getInputStream(),file);
					dirs.add(fileType.getDir()+finalName);
				}
			}
		}
		return dirs;
	}
	/**
	 * 多个图片上传
	 * @param fileType
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public  List<String> uploadImg(String url,MultipartFile[] files) throws IOException{
		String pa="D:/";
		List<String> dirs = null;
		if(files!=null&&files.length>0){
			dirs = new ArrayList<String>();
			for(MultipartFile f:files){
				if(f != null&&!f.isEmpty()) {
					String str=f.getOriginalFilename();
					String fileType=str.substring(str.lastIndexOf("."),str.length());
					String finalName = String.valueOf(System.currentTimeMillis())+fileType;
					File file = new File(pa+url,finalName);
					FileUtils.copyInputStreamToFile(f.getInputStream(),file);
					dirs.add(url+finalName);
				}
			}
			return dirs;
		}
		return null;
	}
	
	/**
	 * 上传单个文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadPic(MultipartFile file) throws IOException{
		String picname = String.valueOf(System.currentTimeMillis()+file.getOriginalFilename());
		File files = new File(this.path+"file/pictures/", picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return "file/pictures/"+picname;
		
	}
	/**
	 * 量表类型封面/背景
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String zassess(MultipartFile file) throws IOException{
		String picname = String.valueOf(System.currentTimeMillis()+file.getOriginalFilename());
		File files = new File(this.path+"file/zassess/", picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return "file/zassess/"+picname;
	}
	/**
	 * 更改上传的文件名
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadPics(MultipartFile file) throws IOException{
		String wo=file.getOriginalFilename()+"";
		String s=wo.substring(wo.lastIndexOf("."),wo.length());
		String picname = System.currentTimeMillis()+s;
		File files = new File(this.path+"file/pictures/", picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return "file/pictures/"+picname;
		
	}
	
	/**
	 * 图片上传
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadPicse(String pa,MultipartFile file) throws IOException{
		String wo=file.getOriginalFilename()+"";
		String s=wo.substring(wo.lastIndexOf("."),wo.length());
		String picname = System.currentTimeMillis()+s;
		File files = new File(this.path+pa, picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		String pas=pa+picname;
		return pas;
		
	}
	
	public String uploadSite(MultipartFile file) throws IOException{
		String picname = String.valueOf(System.currentTimeMillis()+file.getOriginalFilename());
		File files = new File(this.path+"file/site/", picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return "file/pictures/"+picname;
		
	}
	
	public String updateAVI(){
		return null;
	}
	
	
	/**
	 * 上传单个文件  服务记录
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadWord(MultipartFile file) throws IOException{
		String picname = String.valueOf(System.currentTimeMillis()+file.getOriginalFilename());
		File files = new File(this.path+"file/word/", picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return picname;
		
	}
	/**
	 * 
	 * @param file
	 * @param fileUrl
	 * @return
	 * @throws IOException
	 */
	public String uploadfileUrl(MultipartFile file,String fileUrl) throws IOException{
		String picname = String.valueOf(System.currentTimeMillis()+file.getOriginalFilename());
		File files = new File(this.path+fileUrl, picname);
		FileUtils.copyInputStreamToFile(file.getInputStream(), files);
		return picname;
		
	}
	/**
	 * 删除文件
	 * @param picname
	 */
	public void removeImg(String picname,String fileUrl){
		File pic = new File(fileUrl+picname);
		pic.delete();
	}
	public void removePic(String picname){
		File pic = new File(this.path+"file/pictures/"+picname);
		pic.delete();
	}
	public void removePic(String picname,String fileUrl){
		File pic = new File(this.path+fileUrl+picname);
		pic.delete();
	}
	public void removeSite(String picname){
		File pic = new File(this.path+"file/site/"+picname);
		pic.delete();
	}
	
	public void removeVideo(String picname){
		File pic = new File(this.path+"file/"+picname);
		pic.delete();
	}
	/**
	 * 删除文件 服务记录
	 * @param picname
	 */
	public void removeWord(String picname){
		File pic = new File(this.path+"file/word/"+picname);
		pic.delete();
	}
	
	public void remove(String dir){
		File file = new File(this.path+dir);
		file.delete();
	}
	/**
	 * 一次删除多个图片
	 */
	public void removeList(String urls){
		String[] url=urls.split(",");
		for (int i = 0; i < url.length; i++) {
			File file=new File(url[i]);
			file.delete();
		}
	}
}
