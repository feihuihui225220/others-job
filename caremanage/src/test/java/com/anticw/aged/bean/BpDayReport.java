package com.anticw.aged.bean;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * WEB SERVICES 接口相关文件。
 * 自测的血压监控日报接口。
 */
@XmlRootElement(name = "bpdayreport")
public class BpDayReport extends BpReport
{
	private String	day;		//今天是哪一天，格式为“yyyy-MM-dd”
	private short 	times;	//今天血压测量次数
	private Data		sbp;		//今天SBP统计值及范围
	private Data		dbp;		//今天DBP统计值及范围
	
	public String	getDay() 	{ return day; }
	public short		getTimes() 	{ return times; }
	public Data		getSbp()		{ return sbp; }
	public Data		getDbp()		{ return dbp; }

	public void		setDay(String s) 	{ day = s; }
	public void		setTimes(short n)	{ times = n; }
	public void		setSbp(Data o)		{ sbp = o; }
	public void		setDbp(Data o)		{ dbp = o; }

	public static class Data 
	{
		private short	even; 		//日测量均值
		private short	morning; 	//日早晨测量均值
		private short	noon; 		//日白天测量均值
		private short	evening; 	//日晚间测量均值
		private short	max; 		//上限（强化干预）
		private short	maxideal; 	//理想上限
		private short	minideal; 	//理想下限
		private short	min; 		//下限（最低容忍）

		@XmlAttribute	public short getMax() 		{ return max; }
		@XmlAttribute	public short getMaxideal()	{ return maxideal; }
		@XmlAttribute	public short getMinideal()	{ return minideal; }
		@XmlAttribute	public short getMin()		{ return min; }
		public short		getEven() 	{ return even; }
		public short		getMorning(){ return morning; }
		public short		getNoon() 	{ return noon; }
		public short		getEvening(){ return evening; }

		public void		setEven(short n) 	{ even = n; }
		public void		setMorning(short n) 	{ morning = n; }
		public void		setNoon(short n) 	{ noon = n; }
		public void		setEvening(short n) 	{ evening = n; }
		public void		setMax(short n) 		{ max = n; }
		public void		setMaxideal(short n)	{ maxideal = n; }
		public void		setMinideal(short n)	{ minideal = n; }
		public void		setMin(short n)		{ min = n; }
	}

	@Override
	public String toString() {
		return "BpDayReport [day=" + day + ", times=" + times + ", sbp=" + sbp
				+ ", dbp=" + dbp + "]";
	}
	
	
}