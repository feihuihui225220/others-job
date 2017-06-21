package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 其他身体指标
 * @author L
 *
 */
@Document(collection="m_physical")
public class Physical {
	/**
	 * 2.44米折返跑      ms
	 */
	private Float roundRun244m;
	/**
	 * 睁眼单腿站立        s
	 */
	private Float standOneLeg;
	/**
	 * 30s坐站   次
	 */
	private Integer sitStand30s;
	/**
	 * 原地踏步120s  次
	 */
	private Integer piaffe120s;
	/**
	 * @return the roundRun244m
	 */
	public Float getRoundRun244m() {
		return roundRun244m;
	}
	/**
	 * @param roundRun244m the roundRun244m to set
	 */
	public void setRoundRun244m(Float roundRun244m) {
		this.roundRun244m = roundRun244m;
	}
	/**
	 * @return the standOneLeg
	 */
	public Float getStandOneLeg() {
		return standOneLeg;
	}
	/**
	 * @param standOneLeg the standOneLeg to set
	 */
	public void setStandOneLeg(Float standOneLeg) {
		this.standOneLeg = standOneLeg;
	}
	/**
	 * @return the sitStand30s
	 */
	public Integer getSitStand30s() {
		return sitStand30s;
	}
	/**
	 * @param sitStand30s the sitStand30s to set
	 */
	public void setSitStand30s(Integer sitStand30s) {
		this.sitStand30s = sitStand30s;
	}
	/**
	 * @return the piaffe120s
	 */
	public Integer getPiaffe120s() {
		return piaffe120s;
	}
	/**
	 * @param piaffe120s the piaffe120s to set
	 */
	public void setPiaffe120s(Integer piaffe120s) {
		this.piaffe120s = piaffe120s;
	}
	
}
