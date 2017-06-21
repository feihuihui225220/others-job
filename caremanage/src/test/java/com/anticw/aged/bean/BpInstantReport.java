package com.anticw.aged.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * WEB SERVICES 接口相关文件。
 * 自测血压监控即时分析报告接口。
 */
@XmlRootElement(name = "bpinstantreport")
public class BpInstantReport extends BpReport
{
	private short	days;	//这是自测血压监控开始的第几天
	private Data		sbp;		//本次SBP值及范围
	private Data		dbp;		//本次DBP值及范围
	
	public 	short	getDays() 							{ return days; }
	@XmlElement(name="sbp")		public Data 	getSbp() 	{ return sbp; }
	@XmlElement(name="dbp")		public Data 	getDbp() 	{ return dbp; }
	
	public void		setDays(short n)	{ days = n; }
	public void		setSbp(Data o)	{ sbp = o; }
	public void		setDbp(Data o)	{ dbp = o; }

	public static class Data {
		private short	value; 		//血压实测值
		private short	max; 		//上限（强化干预）
		private short	maxideal; 	//目标上限
		private short	minideal; 	//目标下限
		private short	min; 		//下限（最低容忍）

		public short getValue() 	{ return value; }
		@XmlAttribute	public short 	getMax() 		{ return max; }
		@XmlAttribute	public short 	getMaxideal()	{ return maxideal; }
		@XmlAttribute	public short 	getMinideal()	{ return minideal; }
		@XmlAttribute	public short 	getMin()			{ return min; }

		public void		setValue(short n) 		{ value = n; }
		public void		setMax(short n) 			{ max = n; }
		public void		setMaxideal(short n)		{ maxideal = n; }
		public void		setMinideal(short n)		{ minideal = n; }
		public void		setMin(short n)			{ min = n; }
	}

	@Override
	public String toString() {
		return "BpInstantReport [days=" + days + ", sbp=" + sbp + ", dbp="
				+ dbp + "]";
	}
	
	
}