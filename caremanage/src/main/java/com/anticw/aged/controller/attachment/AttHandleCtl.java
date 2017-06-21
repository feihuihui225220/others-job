package com.anticw.aged.controller.attachment;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 处理整个系统中附件的上传和下载的请求
 * <P>File name : AttHandleCtl.java </P>
 * <P>Author : leo </P> 
 * <P>Date : 2014-9-27 </P>
 */
public class AttHandleCtl {

	@RequestMapping(value="/attchment/upload", method=RequestMethod.POST)  
	@ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return null;
	}
	
	
}
