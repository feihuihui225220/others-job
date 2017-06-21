package com.anticw.aged.bean.gds;



import javax.xml.bind.annotation.XmlRootElement;


/**
 * 对应于患者就诊数据。
 * WEB SERVICES 接口相关文件。
 */
@XmlRootElement(name = "case")
public class Case 
{
	private 	Measure		measure;		//实测值
	private 	boolean	hbp;			//是否为高血压
	private 	Hbp			hbpData;		//高血压相关数据
	private 	boolean	dm;				//是否为糖尿病
	private 	Dm			dmData;			//糖尿病
	private 	boolean 	dsLip;			//是否为血脂异常
	private 	DsLip 		dsLipData;		//血脂异常
	private 	boolean	chd;			//是否为冠心病
	private 	Chd	 		chdData;		//冠心病
	private 	boolean	stroke;			//是否为卒中	
	private 	Stroke		strokeData;		//卒中	
	private 	boolean	posLbp;			//是否为体位性低血压
	private 	PosLbp		posLbpData;		//体位性低血压
	private 	Family		family;			//家族病
	private 	Related		related;		//其他相关情况
	
	public 		Measure 	getMeasure() 	{ return measure;	}
	public 		boolean	isHbp() 		{ return hbp;	}
	public 		Hbp 		getHbpData() 	{ return hbpData;	}
	public 		boolean	isDm() 			{ return dm;	}
	public 		Dm 			getDmData() 	{ return dmData;	}
	public 		boolean	isDsLip() 		{ return dsLip;	}
	public 		DsLip 		getDsLipData() 	{ return dsLipData;	}
	public 		boolean	isChd() 		{ return chd;	}
	public 		Chd 		getChdData() 	{ return chdData;	}
	public 		boolean	isStroke() 		{ return stroke;	}
	public 		Stroke 		getStrokeData() { return strokeData;	}
	public 		boolean	isPosLbp() 		{ return posLbp;	}
	public 		PosLbp		getPosLbpData()	{ return posLbpData;	}
	public 		Related		getRelated()	{ return related;	}
	public 		Family		getFamily()		{ return family;	}
		
	public 		void 	setMeasure(Measure o) 	{ measure = o;	}
	public 		void 	setHbp(boolean b) 		{ hbp = b;	}
	public 		void 	setHbpData(Hbp o) 		{ hbpData = o;	}
	public 		void 	setDm(boolean b) 		{ dm = b;	}
	public 		void 	setDmData(Dm o) 		{ dmData = o;	}
	public 		void 	setDsLip(boolean b) 	{ dsLip = b;	}
	public 		void 	setDsLipData(DsLip o) 	{ dsLipData = o;	}
	public 		void 	setChd(boolean b) 		{ chd = b;		}
	public 		void 	setChdData(Chd o) 		{ chdData = o;		}
	public 		void 	setStroke(boolean b) 	{ stroke = b;	}
	public 		void 	setStrokeData(Stroke o) { strokeData = o;	}
	public 		void 	setPosLbp(boolean b)	{ posLbp = b;	}
	public 		void 	setPosLbpData(PosLbp o)	{ posLbpData = o;	}
	public 		void 	setRelated(Related o)	{ related = o;	}
	public 		void 	setFamily(Family o)		{ family = o;	}

	
	/**
	 * 体检数据
	 */
	public static class Measure 
	{
		private short 	waist;		//腰围
		private short 	hip;		//臀围
		private short 	weight;		//体重
		private short 	height;		//身高(cm)
		private short 	pulse;		//脉搏，Pulse还是HR？
		private short 	sbp;		//收缩压
		private short 	dbp;		//舒张压
		private float 	hbA1c;		//糖化血红蛋白
		private float 	fpg;		//空腹血糖
		private float 	ogtt;		//餐后血糖
		private float 	tc;			//总胆固醇
		private float 	ldlc;		//低密度脂蛋白
		private float 	hdlc;		//高密度脂蛋白
		private float 	tg;			//甘油三脂
	
		public	short 	getHip() 	{ return hip; 		}
		public	short 	getHeight() { return height; 	}
		public	short 	getPulse() 	{ return pulse; 	}
		public 	short 	getSbp() 	{ return sbp; 		}
		public 	short 	getDbp() 	{ return dbp; 		}
		public 	float 	getHbA1c() 	{ return hbA1c; 	}
		public 	float 	getFpg() 	{ return fpg; 		}
		public 	float 	getOgtt() 	{ return ogtt; 		}
		public 	float 	getTc() 	{ return tc; 		}
		public 	float 	getLdlc() 	{ return ldlc; 		}
		public 	float 	getHdlc() 	{ return hdlc; 		}
		public 	float 	getTg() 	{ return tg; 		}
		public 	short 	getWeight() { return weight; 	}
		public 	short 	getWaist() 	{ return waist; 	}
		
		public 	void 	setHip(short n) 	{ hip = n; 	}
		public	void 	setHeight(short n) 	{ height = n;}
		public	void 	setPulse(short n) 	{ pulse = n; }
		public 	void 	setSbp(short n) 	{ sbp = n; 	}
		public 	void 	setDbp(short n) 	{ dbp = n; 	}
		public 	void 	setHbA1c(float f) 	{ hbA1c = f; }
		public 	void 	setFpg(float f) 	{ fpg = f; 	}
		public 	void 	setOgtt(float f)	{ ogtt = f; }
		public 	void 	setTc(float f) 		{ tc = f; 	}
		public 	void 	setLdlc(float f)	{ ldlc = f; }
		public 	void 	setHdlc(float f) 	{ hdlc = f; }
		public 	void 	setTg(float f) 		{ tg = f; 	}
		public 	void 	setWeight(short n) 	{ weight = n; 	}
		public 	void 	setWaist(short n) 	{ waist = n; 	}
	    
	}
	
	/**
	 * 高血压
	 */
	public static class Hbp 
	{
		private float  	years;		//高血压年数
		private short  	maxSbp;		//历史最高：高压
		private short  	maxDbp;		//历史最高：低压
		private boolean	acei;		//是否服用药物：普利
		private boolean	arb;		//是否服用药物：沙坦
		private boolean	bb;			//是否服用药物：β阻
		private boolean	ccb;		//是否服用药物：Ca拮
		private boolean	diuritic;	//是否服用药物：利尿
		private boolean	other;		//是否服用药物：其它

		public 	float		getYears() 		{ return years;	}
		public 	boolean	isAcei() 		{ return acei;	}
		public 	boolean	isArb() 		{ return arb;	}
		public 	boolean	isBb() 			{ return bb;	}
		public 	boolean	isCcb() 		{ return ccb;	}
		public 	boolean	isDiuritic()	{ return diuritic;	}
		public 	boolean	isOther() 		{ return other;	}
		public 	short 		getMaxSbp() 	{ return maxSbp; }
		public 	short 		getMaxDbp() 	{ return maxDbp; }

		public 	void 		setYears(float f) 		{ years = f;	}
		public 	void 		setMaxSbp(short n) 		{ maxSbp = n; }
		public 	void 		setMaxDbp(short n) 		{ maxDbp = n; }
		public 	void 		setAcei(boolean b) 	{ acei = b; }
		public 	void 		setArb(boolean b) 		{ arb = b; }
		public 	void 		setBb(boolean b) 		{ bb = b; }
		public 	void 		setCcb(boolean b) 		{ ccb = b; }
		public 	void 		setDiuritic(boolean b) { diuritic = b; }
		public 	void 		setOther(boolean b) 	{ other = b;	}
	}

	/**
	 * 糖尿病
	 */
	public static class Dm 
	{
		private float  	years;		//糖尿病年数
		private boolean	glueBorder;	//血糖稍高
		private boolean	dmTriplex;	//三多一少：多食、多饮、多尿及体重下降
		private boolean	biguanide;	//是否服用药物：双胍
		private boolean	sulfnUr;	//是否服用药物：磺脲
		private boolean	alphaGluEI;	//是否服用药物：α糖酶
		private boolean	tzd;		//是否服用药物：噻唑烷
		private boolean	ins;		//是否服用药物：胰岛素
		private boolean	other;		//是否服用药物：其它

		public 	float		getYears() 		{ return years;	}
		public 	boolean	isGlueBorder() 	{ return glueBorder;	}
		public 	boolean	isDmTriplex() 	{ return dmTriplex;	}
		public 	boolean	isBiguanide() 	{ return biguanide;	}
		public 	boolean	isSulfnUr() 	{ return sulfnUr;	}
		public 	boolean	isAlphaGluEI() 	{ return alphaGluEI;	}
		public 	boolean	isTzd() 		{ return tzd;	}
		public 	boolean	isIns() 		{ return ins;	}
		public 	boolean	isOther() 		{ return other;	}

		public 	void 		setYears(float f) 			{ years = f;	}
		public 	void 		setGlueBorder(boolean b)	{ glueBorder = b;	}
		public 	void 		setDmTriplex(boolean b) 	{ dmTriplex = b;	}
		public 	void 		setBiguanide(boolean b) 	{ biguanide = b;	}
		public 	void 		setSulfnUr(boolean b) 		{ sulfnUr = b;	}
		public 	void 		setAlphaGluEI(boolean b)	{ alphaGluEI = b;	}
		public 	void 		setTzd(boolean b) 			{ tzd = b;	}
		public 	void 		setIns(boolean b) 			{ ins = b;	}
		public 	void 		setOther(boolean b) 		{ other = b;	}
	}
	
	/**
	 * 血脂异常
	 */
	public static class DsLip 
	{
		private float  	years;		//血脂异常年数
		private boolean	highTc;		//TC高
		private boolean	highLdl;	//LDL高
		private boolean	lowHdl;		//HDL低
		private boolean	highTg;		//TG高
		private boolean	statin;		//是否服用药物：他汀
		private boolean	fibrate;	//是否服用药物：贝特
		private boolean	niacin;		//是否服用药物：烟酸
		private boolean	other;		//是否服用药物：其它

		public 	float 		getYears() 	{ return years;	}
		public 	boolean	isHighLdl() { return highLdl;	}
		public 	boolean	isHighTc() 	{ return highTc;	}
		public 	boolean	isHighTg() 	{ return highTg;	}
		public 	boolean	isLowHdl() 	{ return lowHdl;	}
		public 	boolean	isStatin() 	{ return statin;	}
		public 	boolean	isFibrate() { return fibrate;	}
		public 	boolean	isNiacin() 	{ return niacin;	}
		public 	boolean	isOther() 	{ return other;	}

		public 	void 		setYears(float f) 		{ years = f;	}
		public 	void 		setHighLDL(boolean b) 	{ highLdl = b;	}
		public 	void 		setHighTC(boolean b) 	{ highTc = b;	}
		public 	void 		setHighTG(boolean b) 	{ highTg = b;	}
		public 	void 		setLowHDL(boolean b) 	{ lowHdl = b;	}
		public 	void 		setStatin(boolean b) 	{ statin = b;	}
		public 	void 		setFibrate(boolean b)	{ fibrate = b;	}
		public 	void 		setNiacin(boolean b)	{ niacin = b;	}
		public 	void 		setOther(boolean b)	{ other = b;	}
	}
	
	/**
	 * 冠心病
	 */
	public static class Chd
	{
		private float  	years;				//冠心病年数
		private float  	yearsAcs;			//心梗年数
		private float  	yearsCaRc;			//冠脉重建年数，原yrsGuanMai
		private boolean 	chestPain;			//胸闷、痛
		private boolean 	radiatePain;		//放射痛
		private boolean 	labEmoEvoked;		//劳力/情绪诱发
		private short 		nitroYX;			//硝酸酯有效
		private boolean 	ekg;				//EKG(心电图)或运动试验阳性
		private boolean 	recentAttack;		//近期发作加重、频繁>2次/日
		private boolean 	asp;				//是否服用药物：阿斯匹林
		private boolean 	nitro;				//是否服用药物：硝酸酯

		public float 		getYears() 			{ return years;	}
		public float 		getYearsAcs() 		{ return yearsAcs;	}
		public float 		getYearsCaRc() 		{ return yearsCaRc;	}
		public boolean		isChestPain() 		{ return chestPain;	}
		public boolean		isRadiatePain() 	{ return radiatePain;	}
		public boolean		isLabEmoEvoked() 	{ return labEmoEvoked;	}
		public short 		getNitroYX() 		{ return nitroYX;	}
		public boolean		isEkg() 			{ return ekg;	}
		public boolean		isRecentAttack() 	{ return recentAttack;	}
		public boolean		isAsp() 			{ return asp;	}
		public boolean		isNitro() 			{ return nitro;	}

		public void 		setYears(float f) 			{ years = f;	}
		public void 		setYearsAcs(float f) 		{ yearsAcs = f;	}
		public void 		setYearsCaRc(float f) 		{ yearsCaRc = f;	}
		public void 		setChestPain(boolean b) 	{ chestPain = b;	}
		public void 		setRadiatePain(boolean b) 	{ radiatePain = b;	}
		public void 		setLabEmoEvoked(boolean b) { labEmoEvoked = b;	}
		public void 		setNitroYX(short n) 		{ nitroYX = n;	}
		public void 		setEkg(boolean b) 			{ ekg = b;	}
		public void 		setRecentAttack(boolean b) { recentAttack = b;	}
		public void 		setAsp(boolean b) 			{ asp = b;	}
		public void 		setNitro(boolean b) 		{ nitro = b;	}
	}
	
	public static class Stroke 
	{
		private float  	years;				//卒中年数
		private boolean	strokeHm;			//脑出血
		private boolean	strokeIs;			//脑梗死
		private boolean	tia;				//短暂性脑缺血
		private float  	yearsTia;			//短暂性脑缺血年数
		private boolean	numb;				//偏侧麻木/无力
		private boolean	amaurosis;			//语言障碍/黑蒙
		private float  	hrsPerAttack;		//每次发作(小时)
		private boolean	attackRepeated;		//反复发作
		private boolean	attackRecently;		//近日有无发作
		private float  	monsLastAttack;		//上次发作距现在几个月
		private float  	yearsStrokeLoc;		//腔隙性梗塞史年数

		public float 		getYears() 			{ return years;	}
		public boolean		isStrokeHm() 		{ return strokeHm;	}
		public boolean		isStrokeIs() 		{ return strokeIs;	}
		public boolean		isTia() 			{ return tia;	}
		public float 		getYearsTia() 		{ return yearsTia;	}
		public boolean		isNumb() 			{ return numb;	}
		public boolean		isAmaurosis() 		{ return amaurosis;	}
		public float		getHrsPerAttack() 	{ return hrsPerAttack;	}
		public boolean		isAttackRepeated() 	{ return attackRepeated;	}
		public boolean		isAttackRecently() 	{ return attackRecently;	}
		public float 		getMonsLastAttack() { return monsLastAttack;	}
		public float 		getYearsStrokeLoc() { return yearsStrokeLoc;	}

		public void 		setYears(float f) 				{ years = f;	}
		public void 		setStrokeHm(boolean b) 		{ strokeHm = b;	}
		public void 		setStrokeIs(boolean b) 		{ strokeIs = b;	}
		public void 		setTia(boolean b) 				{ tia = b;	}
		public void 		setYearsTia(float f) 			{ yearsTia = f;	}
		public void 		setNumb(boolean b) 			{ numb = b;	}
		public void 		setAmaurosis(boolean b) 		{ amaurosis = b;	}
		public void 		setHrsPerAttack(float f) 		{ hrsPerAttack = f;	}
		public void 		setAttackRepeated(boolean b)	{ attackRepeated = b;	}
		public void 		setAttackRecently(boolean b)	{ attackRecently = b;	}
		public void 		setMonsLastAttack(float f) 		{ monsLastAttack = f;	}
		public void 		setYearsStrokeLoc(float f) 		{ yearsStrokeLoc = f;	}
	}
	
	// 体位性低血压
	public static class PosLbp 
	{
		private short  	supSbp;			//卧位血压-高压
		private short  	supDbp;			//卧位血压-低压
		private short  	standSbp1;		//立位1分钟血压-高压
		private short  	standDbp1;		//立位1分钟血压-低压
		private short  	standSbp2;		//立位5分钟血压-高压
		private short  	standDbp2;		//立位1分钟血压-低压

		public short 	getSupSbp() 	{ return supSbp;	}
		public short 	getSupDbp() 	{ return supDbp;	}
		public short 	getStandSbp1() 	{ return standSbp1;	}
		public short 	getStandDbp1() 	{ return standDbp1;	} 
		public short 	getStandSbp2() 	{ return standSbp2;	}
		public short 	getStandDbp2() 	{ return standDbp2;	}

		public void 	setSupSbp(short n) 		{ supSbp = n;	}
		public void 	setSupDbp(short n) 		{ supDbp = n;	}
		public void 	setStandSbp1(short n)	{ standSbp1 = n;	}
		public void 	setStandDbp1(short n)	{ standDbp1 = n;	}
		public void 	setStandSbp2(short n)	{ standSbp2 = n;	}
		public void 	setStandDbp2(short n)	{ standDbp2 = n;	}
	}


	/**
	 * 家族病及相关情况
	 */
	public static class Family
	{
		private boolean	hbp;		//高血压
		private boolean	dm;			//糖尿病
		private boolean	dsLip;		//高血脂
		private boolean	acs;		//<55/65岁心梗
		private boolean	stroke;		//<55/65岁脑卒中
		
		public boolean 	isHbp() 	{ return hbp; }
		public boolean 	isDm() 		{ return dm; }
		public boolean 	isDsLip() 	{ return dsLip; }
		public boolean 	isAcs() 	{ return acs; }
		public boolean 	isStroke() 	{ return stroke; }

		public void 	setHbp(boolean b) 	{ hbp = b; }
		public void 	setDm(boolean b) 	{ dm = b; }
		public void 	setDsLip(boolean b) { dsLip = b; }
		public void 	setAcs(boolean b) 	{ acs = b; }
		public void 	setStroke(boolean b){ stroke = b; }
	}

	/**
	 * 家族病及相关情况
	 */
	public static class Related
	{
		private boolean	pastLiver;		//肝脏病史
		private boolean	nowLiver;		//现患肝病
		private boolean	nowKidney;		//现患肾脏病
		private boolean	pastAsthma;		//哮喘史
		private boolean	otherAs;		//其他动脉硬化
		private boolean	smoke;			//吸烟
		private float  	drink;			//饮酒(杯数)/日
		private boolean	heartFail;		//心衰
		private short  	carotASt;		//颈A狭窄>69%
		private boolean	softPlaque;		//不稳定斑块
		private boolean	fibnGnInc;		//纤维蛋白原升高
		private boolean	crpInc;			//C反应蛋白升高
		private boolean	soreMuscle;		//肌肉酸痛、无力
		private boolean	walkDiscomfort;	//快走时下肢不适
		private boolean	restDiscomfort;	//静息时下肢不适
		private boolean	imt;			//动脉壁增厚、斑块
		private boolean	lvh;			//左室肥厚
		private boolean	avb;			//房室传导阻滞
		private boolean	af;				//房颤
		private boolean	stt;			//ST-T缺血改变
		private float  	mau;			//微量/白蛋白尿
		private float  	cr;				//血肌酐
		private float  	alt;			//肝功
		private float  	ck;				//肌酸激酶
		
		public boolean 	isPastLiver() 		{ return pastLiver; }
		public boolean 	isNowLiver() 		{ return nowLiver; }
		public boolean 	isNowKidney() 		{ return nowKidney; }
		public boolean 	isPastAsthma() 		{ return pastAsthma; }
		public boolean 	isOtherAs() 		{ return otherAs; }
		public boolean 	isSmoke() 			{ return smoke; }
		public float 		getDrink() 			{ return drink; }
		public boolean 	isHeartFail() 		{ return heartFail; }
		public short 		getCarotASt() 		{ return carotASt; }
		public boolean 	isSoftPlaque() 		{ return softPlaque; }
		public boolean 	isFibnGnInc() 		{ return fibnGnInc; }
		public boolean 	isCrpInc() 			{ return crpInc; }
		public boolean 	isSoreMuscle() 		{ return soreMuscle; }
		public boolean 	isWalkDiscomfort() 	{ return walkDiscomfort; }
		public boolean 	isRestDiscomfort() 	{ return restDiscomfort; }
		public boolean 	isImt() 			{ return imt; }
		public boolean 	isLvh() 			{ return lvh; }
		public boolean 	isAvb() 			{ return avb; }
		public boolean 	isAf() 				{ return af; }
		public boolean 	isStt() 			{ return stt; }
		public float 		getMau() 			{ return mau; }
		public float 		getCr() 			{ return cr; }
		public float 		getAlt() 			{ return alt; }
		public float 		getCk() 			{ return ck; }

		public void 	setPastLiver(boolean b) 		{ pastLiver = b; }
		public void 	setNowLiver(boolean b) 		{ nowLiver = b; }
		public void 	setNowKidney(boolean b) 		{ nowKidney = b; }
		public void 	setPastAsthma(boolean b) 		{ pastAsthma = b; }
		public void 	setOtherAs(boolean b) 			{ otherAs = b; }
		public void 	setSmoke(boolean b) 			{ smoke = b; }
		public void 	setDrink(float f) 				{ drink = f; }
		public void 	setHeartFail(boolean b) 		{ heartFail = b; }
		public void 	setCarotASt(short n) 			{ carotASt = n; }
		public void 	setSoftPlaque(boolean b) 		{ softPlaque = b; }
		public void 	setFibnGnInc(boolean b) 		{ fibnGnInc = b; }
		public void 	setCrpInc(boolean b) 			{ crpInc = b; }
		public void 	setSoreMuscle(boolean b) 		{ soreMuscle = b; }
		public void 	setWalkDiscomfort(boolean b)	{ walkDiscomfort = b; }
		public void 	setRestDiscomfort(boolean b)	{ restDiscomfort = b; }
		public void 	setImt(boolean b) 				{ imt = b; }
		public void 	setLvh(boolean b) 				{ lvh = b; }
		public void 	setAvb(boolean b) 				{ avb = b; }
		public void 	setAf(boolean b) 				{ af = b; }
		public void 	setStt(boolean b) 				{ stt = b; }
		public void 	setMau(float n) 				{ mau = n; }
		public void 	setCr(float n) 					{ cr = n; }
		public void 	setAlt(float n) 				{ alt = n; }
		public void 	setCk(float f) 					{ ck = f; }
	}
}
