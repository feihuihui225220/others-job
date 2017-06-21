package com.anticw.aged.exception;

import com.alibaba.fastjson.JSON;

/**
 * 自定义异常基类
 * <P>File name : BaseException.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-29 </P>
 */
public abstract class BaseException extends Exception {

	/**
	 * 字段或域定义：<code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7094081888791936121L;
	
	/**
	 * 异常
	 */
	private ExceptionCode code;

	/**
	 * 构造函数
	 * @param msg
	 */
	public BaseException(String msg) {
		super(msg);
	}
	
	/**
	 * 构造函数
	 * @param code
	 */
	public BaseException(ExceptionCode code) {
		this(code.msg);
		this.code = code;
	}
	
	public ExceptionCode getCode() {
		return code;
	}

	/**
	 * tojson
	 * {"code":0, "msg":""}
	 * BaseException.toJson()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-9-29 </P>
	 * @return
	 */
	public String toJson() {
		return JSON.toJSONString(code);
	}
}
