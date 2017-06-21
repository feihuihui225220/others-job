/**
 * 
 */
package com.anticw.aged.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.vo.permission.UserVO;

/**
 *
 * @author guoyongxiang
 * Date: 2014-10-3
 */
public class CommonInterceptor implements HandlerInterceptor {

	/** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//阻止跨站点脚本   有bug
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()){
			String value = request.getParameter(keys.nextElement());
			if(value!=null){
				if(value.contains("<script>")||
						value.contains("<javascript>")){
					response.sendError(404, "对不起,您的访问有误！");
					return false;
				}
			}
			//"[\\\"\\\'][\\s]*((?i)javascript):(.*)[\\\"\\\']"
			//"((?i)script)"
		}
		String path = request.getRequestURI().toString().replace(request.getContextPath(), "");
		UserVO user = (UserVO) request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String[] url = {
				"/assets/",
				"/common/",
				//附件
				"/attchment/l/",
				"/attchment/p/",
				// PC
				"/permission/toLogin",
				"/permission/modifyPassword",
				"/permission/login",
				"/permission/toReg",
				"/user/regist",
				"/community/getCountrys",
				"/community/user/mobilePhone",
				"/validateCode",
				"/WeiXin",
				//设备上传信息
				"/data/receive/",
				// 移动端
				"/permission/mobileLogin",
				"/UpReport/service/refer",
				"/professional/activity/listjson",
				"/professional/activity/activityPlanjson",
				"/professional/service/report",
				"/professional/service/showservice",
				"/professional/listjson",
				"/professional/album/findAllAlbumWeixin",
				"/professional/album/findOneAlbumWeixin",
				"/professional/assess/waibu/commit",
				"/professional/assess/recordInfo",
				"/professional/volunteer/nVolunteerAssess",
				"/professional/volunteer/findById",
				"/professional/volunteer/toLogin",
				"/professional/volunteer/tonVolunteerAssess",
				"/nVolunteerAssess/",
				"/file",
				"/gamedata",
				"/gamelevel",
				"/gamet",
				"/ueditor",
				"/weixin",
				"/ICare/zfitness/assess",
				"/professional/volunteer/tonext",
				"/professional/service/realtimedata",
				"/wx",
				"/icare",
				"/wxbanner",
				"/position",
				"/message",
                
		};
		for(String u:url){
			if(path.contains(u)){
				return true;
			}
		}
		if(user==null){
			//response.sendRedirect("/timeout.jsp");
			response.sendRedirect("/permission/toLogin");
		    //request.getRequestDispatcher("/timeout.jsp").forward(request, response);
		    return false;
		}

		return true;
	}


	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
     *
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
