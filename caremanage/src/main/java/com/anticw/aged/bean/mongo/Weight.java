package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 体重管理服务数据表
 * <P>File name : Weight.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
@Document(collection="m_weight")
public class Weight extends MetaData {

	/**
	 * 身高
	 */
	private Float height;
	
	/**
	 * 体重
	 */
	private Float weight;
	
	/**
	 * BMI
	 */
	private Float bmi;

	/**
	 * @return Float 取得域 height 的方法。
	 */
	public Float getHeight() {
		return height;
	}

	/**
	 * @param height 对域 height 的设置方法.
	 */
	public void setHeight(Float height) {
		this.height = height;
	}

	/**
	 * @return Float 取得域 weight 的方法。
	 */
	public Float getWeight() {
		return weight;
	}

	/**
	 * @param weight 对域 weight 的设置方法.
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
	}

	/**
	 * @return Float 取得域 bmi 的方法。
	 */
	public Float getBmi() {
		return bmi;
	}

	/**
	 * @param bmi 对域 bmi 的设置方法.
	 */
	public void setBmi(Float bmi) {
		this.bmi = bmi;
	}
}
