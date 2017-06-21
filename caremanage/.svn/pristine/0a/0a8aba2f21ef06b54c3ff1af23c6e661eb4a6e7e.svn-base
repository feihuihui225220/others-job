package com.anticw.aged.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义springMVC异常处理器
 * 实现异常的统一处理
 * <P>File name : AgedHandlerExceptionResolver.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-29 </P>
 */
public class AgedHandlerExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 异常解析
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-9-29 </P>
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		//model(exception info)
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
          
        //跳转至指定的异常页面
        if(ex instanceof BaseException) {//自定义异常
        	if(ex instanceof BusinessException) {  
        		return new ModelAndView("ex_business", model);  
        	} else {  
        		return new ModelAndView("", model);  
        	}
        } else {//其他未捕获异常
        	return new ModelAndView("", model);
        }
	}
}
