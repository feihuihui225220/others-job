package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 血氧数据管理
 * @author bsd
 *
 */
@Document(collection="h_bloodoxygen")
public class BloodOxygen  extends PublicData {
	 
	/**
	 * Pulse 脉率为xxx，int类型。
	 */
	private int pulse;
	/**
	 * 血氧值xxx，int类型。
	 */
	private int oxygen;
	
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public int getOxygen() {
		return oxygen;
	}
	public void setOxygen(int oxygen) {
		this.oxygen = oxygen;
	}
	 

}
