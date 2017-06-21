package com.anticw.aged.vo.common;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 日期请求参数vo
 * <P>File name : DateParamVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
public class DateParamVO {

	/**
	 * 开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start;
	
	/**
	 * 结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end;
	
	/**
	 * 构造函数
	 */
	public DateParamVO(){
		
	}
	
	/**
	 * 构造函数
	 */
	public DateParamVO(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * @return Date 取得域 start 的方法。
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start 对域 start 的设置方法.
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return Date 取得域 end 的方法。
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end 对域 end 的设置方法.
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
}
