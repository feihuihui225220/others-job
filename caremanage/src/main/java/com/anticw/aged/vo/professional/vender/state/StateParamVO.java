package com.anticw.aged.vo.professional.vender.state;

import java.util.List;

/**
 * 状态参数vo
 * <P>File name : StateParamVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
public class StateParamVO {
	
	/**
	 * 状态参数 
	 * 格式：一级分类,子项
	 */
	private List<String> states;
	
	/**
	 * 备注
	 */
	private String bakup;

	/**
	 * @return List<String> 取得域 states 的方法。
	 */
	public List<String> getStates() {
		return states;
	}

	/**
	 * @param states 对域 states 的设置方法.
	 */
	public void setStates(List<String> states) {
		this.states = states;
	}

	/**
	 * @return String 取得域 bakup 的方法。
	 */
	public String getBakup() {
		return bakup;
	}

	/**
	 * @param bakup 对域 bakup 的设置方法.
	 */
	public void setBakup(String bakup) {
		this.bakup = bakup;
	}
}
