package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 血压管理服务数据表
 * <P>File name : Pressure.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-11 </P>
 */
@Document(collection="m_pressure")
public class Pressure extends MetaData {

	/**
	 * 舒张压（高压）

	 */
	private Float highPressure;
	
	/**
	 * 收缩压（低压）
	 */
	private Float lowPressure;
	
	/**
	 * 脉搏
	 */
	private Float pulse;
	
	/**
	 * 平均压
	 */
	@Field(value="AVG_PRESSURE")
	private Float avgPressure;
	
	/**
	 * 脉压差
	 */
	@Field(value="DVALUE_PRESSURE")
	private Float dvaluePressure;
	
	/**
	 *  機器上I1 心率雜訊
	 */
	@Field(value="I1")
	private Float I1;
	/**
	 *  機器上I2 辦膜
	 */
	@Field(value="I2")
	private Float I2;
	
	/**
	 *  機器上I3 冠狀動脈
	 */
	@Field(value="I3")
	private Float I3;
	
	private String user_id;
	
	@Field(value="VN")
	private String vn;
	
	@Field(value="KEY")
	private String key;
	
	@Field(value="BPM")
	private String BPM;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return Float 取得域 highPressure 的方法。
	 */
	public Float getHighPressure() {
		return highPressure;
	}

	/**
	 * @param highPressure 对域 highPressure 的设置方法.
	 */
	public void setHighPressure(Float highPressure) {
		this.highPressure = highPressure;
	}

	/**
	 * @return Float 取得域 lowPressure 的方法。
	 */
	public Float getLowPressure() {
		return lowPressure;
	}

	/**
	 * @param lowPressure 对域 lowPressure 的设置方法.
	 */
	public void setLowPressure(Float lowPressure) {
		this.lowPressure = lowPressure;
	}

	/**
	 * @return Float 取得域 pulse 的方法。
	 */
	public Float getPulse() {
		return pulse;
	}

	/**
	 * @param pulse 对域 pulse 的设置方法.
	 */
	public void setPulse(Float pulse) {
		this.pulse = pulse;
	}

	/**
	 * @return Float 取得域 avgPressure 的方法。
	 */
	public Float getAvgPressure() {
		return avgPressure;
	}

	/**
	 * @param avgPressure 对域 avgPressure 的设置方法.
	 */
	public void setAvgPressure(Float avgPressure) {
		this.avgPressure = avgPressure;
	}

	/**
	 * @return Float 取得域 dvaluePressure 的方法。
	 */
	public Float getDvaluePressure() {
		return dvaluePressure;
	}

	/**
	 * @param dvaluePressure 对域 dvaluePressure 的设置方法.
	 */
	public void setDvaluePressure(Float dvaluePressure) {
		this.dvaluePressure = dvaluePressure;
	}


	public Float getI1() {
		return I1;
	}

	public void setI1(Float i1) {
		I1 = i1;
	}

	public Float getI2() {
		return I2;
	}

	public void setI2(Float i2) {
		I2 = i2;
	}

	public Float getI3() {
		return I3;
	}

	public void setI3(Float i3) {
		I3 = i3;
	}

	public String getVn() {
		return vn;
	}

	public void setVn(String vn) {
		this.vn = vn;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBPM() {
		return BPM;
	}

	public void setBPM(String bPM) {
		BPM = bPM;
	}
	
}
