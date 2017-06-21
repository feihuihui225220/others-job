/**   

* @Title: BaseResponseVo.java 
* @Package com.anticw.aged.vo.care 
* @Description: TODO
* @author ltw   
* @date 2014年10月22日 下午5:24:45 
* @version V1.0   
*/
package com.anticw.aged.vo.care;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.utils.PublicService;

/** 
 * @ClassName: BaseResponseVo 
 * @Description: TODO 
 * @author ltw
 * @date 2014年10月22日 下午5:24:45 
 *  
 */
public class BaseResponseVo {
	private Boolean isJson;
	private String callback;
	
	public Boolean isReturnJson(){
		return isJson;
	}
	public String returnJson(Object result){
		return 	 PublicService.returnJSONP(ExceptionCode.SUCCESS, result, callback);
	}
	
	public Boolean getIsJson() {
		return isJson;
	}
	public void setIsJson(Boolean isJson) {
		this.isJson = isJson;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	
 
}
