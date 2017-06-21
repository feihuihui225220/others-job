package com.anticw.aged.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.PageResponseVO;
import com.anticw.aged.vo.common.ResponseVO;

public class PublicService {

	private static final Logger log = LoggerFactory.getLogger(PublicService.class);

	/**
	 * 封装返回值
	 * 
	 * @param response
	 *            响应
	 * @param result
	 *            数据
	 * @throws IOException
	 */
	public static void returnValue(HttpServletResponse response, String result) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.close();
	}

	/**
	 * 封装返回值
	 * 
	 * @param response
	 *            响应
	 * @param result
	 *            数据
	 * @throws IOException
	 */
	public static void returnValue(HttpServletResponse response, String result, String callback) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.write(callback + "(" + result + ")");
		pw.close();
	}

	/**
	 * 装载returnValue
	 * 
	 * @param code
	 * @return
	 */
	public static String returnValue(ExceptionCode code) {
		ResponseVO vo = null;
		vo = new ResponseVO(code, null);
		String json = vo.toString();
		if (!code.equals(ExceptionCode.SUCCESS)) {
			log.error(json);
		}
		return json;
	}

	/**
	 * 装载returnValue
	 * 
	 * @param code
	 * @return
	 */
	public static String returnValue(ExceptionCode code, Object data) {
		ResponseVO vo = null;
		vo = new ResponseVO(code, data);
		String json = vo.toString();
		if (!code.equals(ExceptionCode.SUCCESS)) {
			log.error(json);
		}
		return json;
	}

	/**
	 * 装载returnValue
	 * 
	 * @param code
	 * @return
	 */
	public static String returnPageValue(ExceptionCode code, Page<?> data) {
		ResponseVO vo = null;
		vo = new PageResponseVO(code, data);
		String json = vo.toString();
		if (!code.equals(ExceptionCode.SUCCESS)) {
			log.error(json);
		}
		return json;
	}

	/**
	 * 装载returnValue
	 * 
	 * @param code
	 * @return
	 */
	public static String returnValue(ExceptionCode code, List<?> data) {
		ResponseVO vo = null;
		vo = new ResponseVO(code, data);
		String json = vo.toString();
		if (!code.equals(ExceptionCode.SUCCESS)) {
			log.error(json);
		}
		return json;
	}

	/**
	 * 装载returnValue
	 * 
	 * @param code
	 * @return
	 */
	public static String returnValue(ExceptionCode code, String msg, Object data) {
		ResponseVO vo = null;
		vo = new ResponseVO(code.code, msg, null);
		String json = vo.toString();
		if (!code.equals(ExceptionCode.SUCCESS)) {
			log.error(json);
		}
		return json;
	}

	/**
	 * 获取结果VO
	 * 
	 * @param code
	 * @return
	 */
	public static ResponseVO returnResponseVO(ExceptionCode code) {
		return new ResponseVO(code, null);
	}

	/**
	 * 获取结果VO
	 * 
	 * @param code
	 * @param data
	 * @return
	 */
	public static ResponseVO returnResponseVO(ExceptionCode code, Object data) {
		return new ResponseVO(code, Arrays.asList(data));
	}

	public static String returnJSONP(ExceptionCode code, String callback) {
		if (callback != null) {
			return callback + "(" + returnValue(code) + ")";
		} else {
			return returnValue(code);
		}
	}

	public static String returnJSONP(ExceptionCode code, Object data, String callback) {
		if (callback != null) {
			return callback + "(" + returnValue(code, data) + ")";
		} else {
			return returnValue(code, data);
		}
	}

	public static String returnPageJSONP(ExceptionCode code, Page<?> data, String callback) {
		if (callback != null) {
			return callback + "(" + returnPageValue(code, data) + ")";
		} else {
			return returnPageValue(code, data);
		}
	}

	public static String returnJSONP(ExceptionCode code, List<?> data, String callback) {
		if (callback != null) {
			return callback + "(" + returnValue(code, data) + ")";
		} else {
			return returnValue(code, data);
		}
	}

	/**
	 * 封装返回值
	 * 
	 * @param response
	 *            响应
	 * @param status
	 *            状态
	 * @param data
	 *            数据
	 * @throws IOException
	 */
	public static String jumpPage(HttpServletRequest request, String pageUrl, String key, Object value)
			throws IOException {
		request.setAttribute(key, value);
		return pageUrl;
	}

	/**
	 * 
	 * 方法: getRequestBody <br>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getRequestBody(HttpServletRequest request) throws IOException {
		InputStream in = request.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		StringBuffer buffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	/**
	 * 判断参数是否为null
	 * 
	 * @param params
	 * @return
	 */
	public static boolean paramsHasNull(String... params) {
		if (params != null && params.length != 0) {
			for (int i = 0; i < params.length; i++) {
				String str = params[i];
				if (StringUtils.isEmpty(str)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * 判断参数是否为true
	 * 
	 * @param params
	 * @return
	 */
	public static boolean paramsHasTrue(boolean... params) {
		if (params != null && params.length != 0) {
			for (int i = 0; i < params.length; i++) {
				boolean param = params[i];
				if (!param) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static boolean paramVerify(String val, int len, boolean must) {
		return paramVerify(val, len, null, must);
	}

	public static boolean paramVerify(String val, int len, String regEx, boolean must) {
		boolean isEmpty = StringUtils.isEmpty(val);
		if (isEmpty && must) {
			return false;
		} else if (!isEmpty && val.length() > len) {
			return false;
		} else if (!isEmpty && regEx != null) {
			return regExVerify(val, regEx);
		} else {
			return true;
		}
	}

	/**
	 * 正则验证
	 * 
	 * @param val
	 *            需验证的值
	 * @param regEx
	 *            正则表达式
	 * @return
	 */
	public static boolean regExVerify(String val, String regEx) {
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(val);
		return mat.matches();
	}

}
