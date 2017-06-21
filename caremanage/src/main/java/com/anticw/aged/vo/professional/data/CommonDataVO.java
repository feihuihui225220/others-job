package com.anticw.aged.vo.professional.data;

import java.util.List;

/**
 * 通用报表数据结构
 * <P>File name : CommonDataVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
public class CommonDataVO {

	/**
	 * 默认值最小值 -- 每页记录数
	 */
	public static final int MIN_PAGESIZE = 20;
	
	/**
	 * 默认值最大值 -- 每页记录数
	 */
	public static final int MAX_PAGESIZE = 200;
	
	/**
	 * 页码
	 */
	private int pageNo = 1;
	
	/**
	 * 每页记录数
	 */
	private int pageSize = MIN_PAGESIZE;
	
	/**
	 * 总记录数
	 */
	private int totalCount = 0;
	
	/**
	 * 数据模块名称
	 */
	private String name;
	
	/**
	 * 报表的标题项
	 */
	private List<String> titles;
	
	/**
	 * 行记录集合
	 */
	private List<List<Object>> values;
	
	
	/**
	 * 构造函数
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param name
	 * @param titles
	 * @param values
	 */
	public CommonDataVO(int pageNo, int pageSize, int totalCount, String name,
			List<String> titles, List<List<Object>> values) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.name = name;
		this.titles = titles;
		this.values = values;
	}

	/**
	 * 构造函数
	 */
	public CommonDataVO(int page, int num, int totalCount, List<String> titles, List<List<Object>> values) {
		this.pageNo = page;
		this.pageSize = num;
		this.totalCount = totalCount;
		this.titles = titles;
		this.values = values;
	}
	
	/**
	 * 构造函数
	 */
	public CommonDataVO(int page, int num) {
		this.pageNo = page;
		this.pageSize = num;
	}
	
	/**
	 * 获得当前页的页号,序号从1开始,默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
	 */
	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;
		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * 获得每页的记录数量,默认为10.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量,超出MIN_PAGESIZE与MAX_PAGESIZE范围时会自动调整.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;
		if (pageSize > MAX_PAGESIZE) {
			this.pageSize = MAX_PAGESIZE;
		}
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

	/**
	 * @return List<String> 取得域 titles 的方法。
	 */
	public List<String> getTitles() {
		return titles;
	}

	/**
	 * @param titles 对域 titles 的设置方法.
	 */
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	/**
	 * @return List<List<Object>> 取得域 values 的方法。
	 */
	public List<List<Object>> getValues() {
		return values;
	}

	/**
	 * @param values 对域 values 的设置方法.
	 */
	public void setValues(List<List<Object>> values) {
		this.values = values;
	}

	/**
	 * @return int 取得域 totalCount 的方法。
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 对域 totalCount 的设置方法.
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
