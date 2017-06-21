package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author DX 2016/5/10
 *
 */
@Document(collection="m_Intelligent_mattress")
public class IntelligentMattress extends MetaData {
	 /**
	  * 固件版本
	  */
	private Integer fv;
	/**
	 * 设备制造商
	 */
	private String ma;
	/**
	 * 设备型号
	 */
	private String mo;
	 /**
	  * 协议版本号
	  */
	private Integer v;
	/**
	 * 设备唯一序列号
	 */
	private String sn;
	/**
	 * 体征状态枚举：on=在床,off=离床,mov=体动,call=呼叫
	 */
	private String state;
	 /**
	  * 心跳频率
	  */
	private Integer heartbeat;
	 /**
	  * 呼吸频率
	  */
	private Integer breath;
	 /**
	  * 尿湿：true 0xc3为尿湿false0xc2 为非尿湿
	  */
	private Integer wet;
	 /**
	  * 气味：-1 表示没有安装设备 
	  */
	private Integer odor;
	 /**
	  * 重量:-1表示没有安装设备
	  */
	private Integer weight;
	
	/**
	 * 身体位置，例如[6,9]
	 */
	private String position;
	
	
	private String dp;

	public IntelligentMattress() {
		super();
	}

	public IntelligentMattress(Integer fv, String ma, String mo, Integer v,
			String sn, String state, Integer heartbeat, Integer breath,
			Integer wet, Integer odor, Integer weight, String position,
			String dp) {
		super();
		this.fv = fv;
		this.ma = ma;
		this.mo = mo;
		this.v = v;
		this.sn = sn;
		this.state = state;
		this.heartbeat = heartbeat;
		this.breath = breath;
		this.wet = wet;
		this.odor = odor;
		this.weight = weight;
		this.position = position;
		this.dp = dp;
	}

	public Integer getFv() {
		return fv;
	}

	public void setFv(Integer fv) {
		this.fv = fv;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(Integer heartbeat) {
		this.heartbeat = heartbeat;
	}

	public Integer getBreath() {
		return breath;
	}

	public void setBreath(Integer breath) {
		this.breath = breath;
	}

	

	public Integer getWet() {
		return wet;
	}

	public void setWet(Integer wet) {
		this.wet = wet;
	}

	public Integer getOdor() {
		return odor;
	}

	public void setOdor(Integer odor) {
		this.odor = odor;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	@Override
	public String toString() {
		return "IntelligentMattress [fv=" + fv + ", ma=" + ma + ", mo=" + mo
				+ ", v=" + v + ", sn=" + sn + ", state=" + state
				+ ", heartbeat=" + heartbeat + ", breath=" + breath + ", wet="
				+ wet + ", odor=" + odor + ", weight=" + weight + ", position="
				+ position + ", dp=" + dp + "]";
	}

	
	
	
}
