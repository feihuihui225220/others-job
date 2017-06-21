package com.anticw.aged.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "risk")
public class Risk 
{
	private float		beforeTreat;		//治疗前10年风险（ICVD）
	private float		lifeSpan;		//终身风险
	private float		minRisk;			//同龄人最低风险

	private YearRisk		minpeer;			//同龄人最低风险
	private YearRisk 	stdrisk ;		//规范化治疗风险
	private YearRisk 	ownrisk ;		//不治疗风险

	private Risktenyear[] risktenyear;

	public Risk() {
		risktenyear = new Risktenyear[10];
		for (int i = 0; i < 10; ++i) risktenyear[i] = new Risktenyear();
	}
	
	@XmlElementWrapper(name="risktenyears")
	public Risktenyear[] getRisktenyear() { return risktenyear; }
	
	public void setRisktenyear(Risktenyear[] os) { risktenyear = os; }

	public YearRisk getMinpeer() { return minpeer; }
	public YearRisk getStdrisk() { return stdrisk; }
	public YearRisk getOwnrisk() { return ownrisk; }

	public void	setMinpeer(YearRisk o) { minpeer = o; }
	public void	setStdrisk(YearRisk o) { stdrisk = o; }
	public void	setOwnrisk(YearRisk o) { ownrisk = o; }

	@XmlAttribute(name="beforetreat")
	public float	getBeforeTreat() 		{ return beforeTreat; }
	@XmlAttribute(name="lifespan")
	public float	getLifeSpan() 			{ return lifeSpan; }
	@XmlAttribute(name="minrisk")
	public float	getMinRisk() 			{ return minRisk; }
	
	public void	setBeforeTreat(float f)	{ beforeTreat = f; }
	public void	setLifeSpan(float f) 	{ lifeSpan = f; }
	public void	setMinRisk(float f)		{ minRisk = f; }

	public static class YearRisk { 
		 private float fiveyear;		//5年
		 private float tenyear;		//10年
		 private float lifetime;		//终生
		 @XmlAttribute	public float	getFiveyear()	{ return fiveyear; }
		 @XmlAttribute	public float	getTenyear() 	{ return tenyear; }
		 @XmlAttribute	public float	getLifetime()	{ return lifetime; }
		 public void	setFiveyear(float f) { fiveyear = f; }
		 public void	setTenyear(float f) 	{ tenyear = f; }
		 public void	setLifetime(float f) { lifetime = f; }
	}

	public static class Risktenyear {
		private String id; 		//序号
		private String name; 	//名称
		private float stdrisk; 	//规范化治疗风险
		private float currisk; 	//当前治疗风险
		@XmlAttribute public String getId() 		{ return id; }
		@XmlAttribute public String getName() 	{ return name; }
		@XmlAttribute public float getStdrisk() 	{ return stdrisk; }
		@XmlAttribute public float getCurrisk() 	{ return currisk; }
		public void setId(String s) 				{ id = s; }
		public void setName(String s) 			{ name = s; }
		public void setStdrisk(float f) 			{ stdrisk = f; }
		public void setCurrisk(float f) 			{ currisk = f; }
	}

}