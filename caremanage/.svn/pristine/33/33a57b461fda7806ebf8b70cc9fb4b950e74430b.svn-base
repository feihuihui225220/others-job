/**   

* @Title: UploadFile.java 
* @Package com.anticw.aged.controller.care 
* @Description: TODO
* @author ltw   
* @date 2014年10月20日 下午7:00:59 
* @version V1.0   
*/
package com.anticw.aged.controller.care;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.service.attchment.AttchmentHandle;

/** 
 * @ClassName: UploadFile 
 * @Description: TODO 
 * @author ltw
 * @date 2014年10月20日 下午7:00:59 
 *  
 */
public class UploadFile {
	@Autowired
	private AttchmentHandle attchmentHandle;
	public  String uploadFile(int attType,MultipartFile[] files) throws IOException{
		String filePath="";

		if(files!=null&&files.length>0){
			for(MultipartFile file:files){
				if(!file.isEmpty()){
					attchmentHandle.upload(attType, new MultipartFile[]{file});
					filePath= file.getOriginalFilename();
				}
			}
		}
	return filePath;
	}
}
