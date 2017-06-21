package com.anticw.aged.vo.common;

/**
 * 通用的分页参数
 * <P>File name : PageParamVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
public class PageParamVO {
	
	/**
	 * 默认每页记录数
	 */
	private static final int DEFAULT_PAGE_SIZE = 10;
	private static final int DEFAULT_PAGE_NUM = 15;
	/**
	 * 页码
	 */
	private int page = 1;
	
	/**
	 * 每页记录数
	 */
	private int num = DEFAULT_PAGE_SIZE;
	private int pageSize=DEFAULT_PAGE_NUM;
	
	/**
	 * 构造函数
	 */
	public PageParamVO() {
		
	}
	
	/**
	 * 构造函数
	 */
	public PageParamVO(int page, int num) {
		this.page = page;
		this.num = num;
	}
	public PageParamVO(int page,int pageSize,int A){
		this.page = page;
		this.pageSize=pageSize;
	}

	/**
	 * @return int 取得域 page 的方法。
	 */
	public int getPage() {
		//return page <= 0 ? 1 : page;
		return page;
	}

	/**
	 * @param page 对域 page 的设置方法.
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return int 取得域 num 的方法。
	 */
	public int getNum() {
		return num <= 0 ? DEFAULT_PAGE_SIZE : num;
	}

	/**
	 * @param num 对域 num 的设置方法.
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public int getPageSize() {
		return pageSize <= 0 ? DEFAULT_PAGE_NUM : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}

