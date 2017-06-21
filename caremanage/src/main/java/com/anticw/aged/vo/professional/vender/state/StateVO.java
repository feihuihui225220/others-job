package com.anticw.aged.vo.professional.vender.state;

import java.util.List;

/**
 * 状态vo
 * <P>File name : StateVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-5 </P>
 */
public class StateVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 状态明细
	 */
	private List<StateVO> states;
	
	/**
	 * 备注
	 */
	private String bakup;

	/**
	 * @return Integer 取得域 id 的方法。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return String 取得域 name 的方法。
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 对域 name 的设置方法.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return List<StateVO> 取得域 states 的方法。
	 */
	public List<StateVO> getStates() {
		return states;
	}

	/**
	 * @param states 对域 states 的设置方法.
	 */
	public void setStates(List<StateVO> states) {
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
