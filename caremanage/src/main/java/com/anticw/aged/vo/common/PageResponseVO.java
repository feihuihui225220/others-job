package com.anticw.aged.vo.common;

import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.ExceptionCode;

/**
 * 通用数据响应对象
 * 用于service向controller的请求响应
 * <P>Author : L </P> 
 */
public class PageResponseVO extends ResponseVO{

	/**
	 * 状态码
	 * 0：表示正常
	 * 其余数值表示出现错误，该值对应ExceptionCode中定义的异常码
	 */
	
	/**
	 * 总记录数
	 */
	private int totalCount = 0;
	
	/**
	 * 页码
	 */
	private int pageNo;
	
	/**
	 * 每页记录数
	 */
	private int pageSize;
	
	

	/**
	 * 
	 * @param code
	 * @param data
	 */
	public PageResponseVO(ExceptionCode code, Page<?> page){
		super(code, page.getResult());
		this.setPageNo(page.getPageNo());
		this.setPageSize(page.getPageSize());
		this.setTotalCount(page.getTotalCount());
	}

	
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 根据pageSize与totalCount计算总页数,默认值为-1.
	 */
	public int getTotalPages() {
		if (totalCount < 0)
			return -1;

		int count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 取得下页的页号,序号从1开始.
	 */
	public int getNextPage() {
		if (isHasNext())
			return pageNo + 1;
		else
			return pageNo;
	}

	/**
	 * 是否还有上一页. 
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页号,序号从1开始.
	 */
	public int getPrePage() {
		if (isHasPre())
			return pageNo - 1;
		else
			return pageNo;
	}
	
}
