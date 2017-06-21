package com.anticw.aged.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "measure")
public class Bp
{
	private	String	measuretime;		//测量时间，格式"yyyy-MM-dd HH:MM"
	private	short	sbp;				//收缩压（高压）
	private	short	dbp;				//舒张压（低压）
	private	short	pulse;			//脉搏

	@XmlAttribute	public	String 	getMeasuretime()	{ return measuretime; }
	@XmlAttribute	public	short 	getSbp()			{ return sbp; }
	@XmlAttribute	public	short 	getDbp()			{ return dbp; }
	@XmlAttribute	public	short 	getPulse() 		{ return pulse; }
	
	public	void		setMeasuretime(String s)		{ measuretime = s; }
	public	void		setSbp(short n) 				{ sbp = n; }
	public	void		setDbp(short n) 				{ dbp = n; }
	public	void		setPulse(short n) 			{ pulse = n; }
}