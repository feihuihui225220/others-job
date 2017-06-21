package com.anticw.aged.vo.common;

import java.util.Arrays;
import java.util.List;

import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.utils.JacksonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 通用数据响应对象
 * 用于service向controller的请求响应
 * <P>File name : ResponseVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
public class ResponseVO {

	/**
	 * 状态码
	 * 0：表示正常
	 * 其余数值表示出现错误，该值对应ExceptionCode中定义的异常码
	 */
	private int code;
	
	/**
	 * 信息内容
	 */
	private String message;
	
	/**
	 * 数据信息
	 */
	private List<?> data;

	
	/**
	 * 
	 */
	public ResponseVO() {
		this.code = 0;
		this.message = "success";
	}

	/**
	 * 
	 * @param code
	 * @param data
	 */
	public ResponseVO(ExceptionCode code, List<?> data){
		this(code.code, code.msg, data);
	}
	
	/**
	 * 
	 * @param code
	 * @param data
	 */
	public ResponseVO(ExceptionCode code, Object data){
		this(code.code, code.msg, Arrays.asList(data));
	}
	
	/**
	 * @param code
	 * @param message
	 * @param data
	 */
	public ResponseVO(int code, String message, List<?> data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public String toString(){
		String json = null;
		try {
			json = JacksonMapper.toJson(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * @return String 取得域 message 的方法。
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message 对域 message 的设置方法.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return List<?> 取得域 data 的方法。
	 */
	public List<?> getData() {
		return data;
	}

	/**
	 * @param data 对域 data 的设置方法.
	 */
	public void setData(List<?> data) {
		this.data = data;
	}

	/**
	 * @return int 取得域 code 的方法。
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code 对域 code 的设置方法.
	 */
	public void setCode(int code) {
		this.code = code;
	}
}
