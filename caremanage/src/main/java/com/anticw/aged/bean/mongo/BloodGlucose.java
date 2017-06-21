package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 血糖管理服务数据表
 * <P>File name : BloodGlucose.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
@Document(collection="m_bloodGlucose")
public class BloodGlucose extends MetaData {

	/**
	 * 血糖
	 */
	private Float bloodGlucose;
	
	/**
	 * 采集点
	 */
	private String acqPoint;

	/**
	 * @return Integer 取得域 bloodGlucose 的方法。
	 */
	public Float getBloodGlucose() {
		return bloodGlucose;
	}

	/**
	 * @param bloodGlucose 对域 bloodGlucose 的设置方法.
	 */
	public void setBloodGlucose(Float bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	/**
	 * @return String 取得域 acqPoint 的方法。
	 */
	public String getAcqPoint() {
		return acqPoint;
	}

	/**
	 * @param acqPoint 对域 acqPoint 的设置方法.
	 */
	public void setAcqPoint(String acqPoint) {
		this.acqPoint = acqPoint;
	}
}
