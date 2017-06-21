package com.anticw.aged.vo.user;

import java.util.List;

/**
 * 人口统计项VO
 * @author L
 *
 */
public class CountUserVO {
	private String title;
	private List<CountUserItemVO> itemList;
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the itemList
	 */
	public List<CountUserItemVO> getItemList() {
		return itemList;
	}
	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<CountUserItemVO> itemList) {
		this.itemList = itemList;
	}
	
	
}
