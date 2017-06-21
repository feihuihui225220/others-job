package com.anticw.aged.bean;



import javax.xml.bind.annotation.XmlRootElement;


/**
 * 对应于简版患者就诊数据。
 * WEB SERVICES 接口相关文件。
 */
@XmlRootElement(name = "simcase")
public class SimCase 
{
	private Measure		measure;		//实测值
	private boolean	hbp;			//是否为高血压
	private boolean	dm;				//是否为糖尿病
	private boolean 	dsLip;			//是否为血脂异常
	private boolean	chd;			//是否为冠心病
	private float  	yearsAcs;		//心梗年数
	private float  	yearsCaRc;		//冠脉重建年数
	private boolean	stroke;			//是否为卒中	
	private float  	yearsStroke;	//卒中年数
	private boolean	strokeHm;		//是否脑出血
	private boolean	strokeIs;		//是否脑梗死
	private float  	yearsStrokeLoc;	//腔隙性梗塞史年数
	private boolean	tia;			//是否短暂性脑缺血
	private boolean	smoke;			//是否吸烟
	private float  	drink;			//饮酒(杯数)/日
	private Family		family;			//家族病情况
	
	public	Measure		getMeasure() 		{ return measure;	}
	public	boolean		isHbp() 			{ return hbp;	}
	public	boolean		isDm() 				{ return dm;	}
	public	boolean		isDsLip() 			{ return dsLip;	}
	public	boolean		isChd() 			{ return chd;	}
	public	float 		getYearsAcs() 		{ return yearsAcs;	}
	public	float 		getYearsCaRc() 		{ return yearsCaRc;	}
	public	boolean		isStroke() 			{ return stroke;	}
	public	float 		getYearsStroke() 	{ return yearsStroke;	}
	public	boolean		isStrokeHm() 		{ return strokeHm;	}
	public	boolean		isStrokeIs() 		{ return strokeIs;	}
	public	float 		getYearsStrokeLoc() { return yearsStrokeLoc;	}
	public	boolean		isTia() 			{ return tia;	}
	public	boolean 	isSmoke() 			{ return smoke; }
	public	float 		getDrink() 			{ return drink; }
	public	Family		getFamily()			{ return family;	}
		
	public 	void 		setMeasure(Measure o) 		{ measure = o;	}
	public 	void 		setHbp(boolean b) 			{ hbp = b;	}
	public 	void 		setDm(boolean b) 			{ dm = b;	}
	public 	void 		setDsLip(boolean b) 		{ dsLip = b;	}
	public 	void 		setChd(boolean b) 			{ chd = b;		}
	public	void 		setYearsAcs(float f) 		{ yearsAcs = f;	}
	public	void 		setYearsCaRc(float f) 		{ yearsCaRc = f;	}
	public	void 		setStroke(boolean b) 		{ stroke = b;	}
	public	void 		setYearsStroke(float f) 	{ yearsStroke = f;	}
	public	void 		setStrokeHm(boolean b) 		{ strokeHm = b;	}
	public	void 		setStrokeIs(boolean b) 		{ strokeIs = b;	}
	public	void 		setYearsStrokeLoc(float f) 	{ yearsStrokeLoc = f;	}
	public	void 		setTia(boolean b) 			{ tia = b;	}
	public	void 		setSmoke(boolean b) 		{ smoke = b; }
	public	void 		setDrink(float f) 			{ drink = f; }
	public 	void 		setFamily(Family o)			{ family = o;	}

	
	/**
	 * 体检数据
	 */
	public static class Measure 
	{
		private short 	weight;		//体重
		private short 	height;		//身高(cm)
		private short 	pulse;		//脉搏，Pulse还是HR？
		private short 	sbp;		//收缩压
		private short 	dbp;		//舒张压
		private float 	fpg;		//空腹血糖
		private float 	tc;			//总胆固醇
		private float 	ldlc;		//低密度脂蛋白
		private float 	hdlc;		//高密度脂蛋白
		private float 	tg;			//甘油三脂
	
		public	short 	getHeight() { return height; 	}
		public 	short 	getWeight() { return weight; 	}
		public	short 	getPulse() 	{ return pulse; 	}
		public 	short 	getSbp() 	{ return sbp; 		}
		public 	short 	getDbp() 	{ return dbp; 		}
		public 	float 	getFpg() 	{ return fpg; 		}
		public 	float 	getTc() 	{ return tc; 		}
		public 	float 	getLdlc() 	{ return ldlc; 		}
		public 	float 	getHdlc() 	{ return hdlc; 		}
		public 	float 	getTg() 	{ return tg; 		}
		
		public	void 	setHeight(short n) 	{ height = n;}
		public 	void 	setWeight(short n) 	{ weight = n; }
		public	void 	setPulse(short n) 	{ pulse = n; }
		public 	void 	setSbp(short n) 	{ sbp = n; 	}
		public 	void 	setDbp(short n) 	{ dbp = n; 	}
		public 	void 	setFpg(float f) 	{ fpg = f; 	}
		public 	void 	setTc(float f) 		{ tc = f; 	}
		public 	void 	setLdlc(float f)	{ ldlc = f; }
		public 	void 	setHdlc(float f) 	{ hdlc = f; }
		public 	void 	setTg(float f) 		{ tg = f; 	}	    
	}
	
	/**
	 * 家族病
	 */
	public static class Family
	{
		private	boolean		hbp;		//高血压
		private	boolean		dm;			//糖尿病
		private	boolean		dsLip;		//高血脂
		private	boolean		acs;		//<55/65岁心梗
		private	boolean		stroke;		//<55/65岁脑卒中
		
		public	boolean 	isHbp() 	{ return hbp; }
		public	boolean 	isDm() 		{ return dm; }
		public	boolean 	isDsLip() 	{ return dsLip; }
		public	boolean 	isAcs() 	{ return acs; }
		public	boolean 	isStroke() 	{ return stroke; }

		public void 		setHbp(boolean b)		{ hbp = b; }
		public void 		setDm(boolean b)		{ dm = b; }
		public void 		setDsLip(boolean b)		{ dsLip = b; }
		public void 		setAcs(boolean b)		{ acs = b; }
		public void 		setStroke(boolean b)	{ stroke = b; }
	}

}
