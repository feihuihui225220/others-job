/**
 * 
 */
package com.anticw.aged.controller.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anticw.aged.service.attchment.AttchmentHandle;

/**
 * 公共控制层
 * @author guoyongxiang
 * Date: 2014-10-19
 */
@RequestMapping("/common")
@Controller
public class CommonCtl {
	
	private static Logger logger = LoggerFactory.getLogger(CommonCtl.class);

	@Autowired
	private AttchmentHandle attchmentHandle;
	
	@RequestMapping("404")
	public String to404(){
		return "/common/404";
	}
	
	@RequestMapping("download")
	public void download(String path, HttpServletResponse response) throws IOException{
		//访问非法路径
		if(!path.contains("/attchment/"))
			response.sendError(404, "对不起,您访问的资源不存在或已删除！");
		// path是指欲下载的文件的路径。
		File file = attchmentHandle.getFile(path);
		if(!file.exists()){
			System.out.println("资源不存在 path "+ file.getPath());
			logger.error("资源不存在 path "+ file.getPath());
			response.sendError(404, "对不起,您访问的资源不存在或已删除！");
			return;
		}
		
		// 取得文件名。
		String filename = file.getName();
		// 以流的形式下载文件。
		InputStream fis = new BufferedInputStream(new FileInputStream(file));
		OutputStream toClient;
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		// 清空response
		response.reset();
		// 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
		response.addHeader("Content-Length", "" + file.length());
		toClient = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		try {
			toClient.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			toClient.flush();
			toClient.close();
		}
	}
}
