package com.anticw.aged.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author dx 2016/4/5 修改spring文件，在上传文件过程中spring不对request进行更改
 *
 */
public class CommonsMultipartResolver extends org.springframework.web.multipart.commons.CommonsMultipartResolver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.web.multipart.commons.CommonsMultipartResolver#isMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		String url = request.getRequestURI();
		// "/professional/photo/add".equals(url)|
		if (("/professional/fete/savevoid").equals(url) | ("/ICareFitness/zfitness/operation").equals(url)
				| ("/ICareFitness/zfitness/imgs").equals(url)) {
			return false;
		} else {
			return super.isMultipart(request);

		}
	}
}