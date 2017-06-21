/**   

* @Title: BaseCtl.java 
* @Package com.anticw.aged.controller.care 
* @Description: TODO
* @author ltw   
* @date 2014年10月20日 下午7:44:37 
* @version V1.0   
*/
package com.anticw.aged.controller.care;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.utils.PublicService;

/** 
 * @ClassName: BaseCtl 
 * @Description: TODO 
 * @author ltw
 * @date 2014年10月20日 下午7:44:37 
 *  
 */
public abstract class BaseCtl {
	@Autowired
	private AttchmentHandle attchmentHandle;
	static {
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		ConvertUtils.register(new BooleanConverter(true), Boolean.class);
		ConvertUtils.register(new StringConverter(null), String.class);
	}

	public  String uploadFile(int attType,MultipartFile[] files) throws IOException{
		String filePath=null;

		if(files!=null&&files.length>0){
			for(MultipartFile file:files){
				if(!file.isEmpty()){
					String[] directory = attchmentHandle.upload(attType, new MultipartFile[]{file});
					filePath=directory[0];
				}
			}
		}
	return filePath;
	}
	public ModelAndView returnJson(Object result,String callback){
		 
	    	String jsonResult = PublicService.returnJSONP(ExceptionCode.SUCCESS, result, callback);
	    	ModelAndView mv=new ModelAndView();
	    	mv = new ModelAndView("/care/json");
			mv.addObject("json", jsonResult);
			return mv;
		 
	}
	
}
