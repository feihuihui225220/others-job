package com.anticw.aged.bean.gds;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "risktenyears")
public class Risktenyears 
{
	private Risktenyear[]	risktenyear;
	public Risktenyears() {
		risktenyear = new Risktenyear[10];
		for( int i=0; i<10; ++i ) risktenyear[i] = new Risktenyear();
	}
	public Risktenyear[] getRisktenyear() { return risktenyear; }
	public void setRisktenyear(Risktenyear[] os) { risktenyear = os; }
	
	@XmlRootElement(name = "risktenyear")
	public static class Risktenyear { 
		@XmlAttribute public String id;		//序号
		@XmlAttribute public String name;		//名称
		@XmlAttribute public float stdrisk;	//规范化治疗风险
		@XmlAttribute public float currisk;	//当前治疗风险
	}
}