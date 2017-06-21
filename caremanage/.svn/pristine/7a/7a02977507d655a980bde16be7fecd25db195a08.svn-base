package com.anticw.aged.bean.mongo;



import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 心电数据管理
 * @author bsd
 */
@Document(collection="h_electrocardio")
public class Electrocardio  extends MetaData{

	
	/**
	 * 示上传数据的用户标识。int类型，表示32位有符号整数。
	 */
	private int userid;
	/**
	 * Stisnormal：表示这段数据的ST段是否正常，string类型，值包括ST段正常， ST段抬高， ST段压低三个状态。
	 * @return
	 */
	private String stisnormal;
	/**
	 * isarrhythmia：表示心律是否失常，string类型，值包括没有发现心律失常，心律失常两个状态。
	 * @return
	 */
	private String isarrhythmia;
	/**
	 * Waveform：表示波形质量是否正常，string类型，值包括波形质量正常，波形质量过差两个状态。
	 * @return
	 */
	private String waveform;
	/**
	 * Heartrate：表示心率是否正常，string类型，值包括心率正常，心率过慢，心率稍快，心率过快，导连脱落五个状态
	 * @return
	 */
	private String heartrate;
	/**
	 * wholewave：表示整体波形是否正常，string类型，值包括整体波形正常和整体波形异常两个状态。
	 * @return
	 */
	private String wholewave;
	/**
	 * Howmanyrwave：这个数组表中有多少个R波被检测到，从1开始计数。int类型，表示32位有符号整数。
	 * @return
	 */
	private int howmanywave;
	/**
	 * Howmanysuccess：表示多少个R波形成功分析，从1开始计数。int类型，表示32位有符号整数。
	 * @return
	 */
	private int howmanysuccess;
	/**
	 * avr_heartrate：此次心电记录的心率信息。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_heartrate;
	/**
	 * avr_pr：此次检测全局的pR间期，int类型，表示32位有符号整数。
	 * @return
	 */
	private int avr_pr;
	/**
	 * avr_qt：此次检测的平均QT间期，int类型，表示32位有符号整数。
	 * @return
	 */
	private int avr_qt;
	/**
	 * avr_rvolt：此次检测的平均R波电压。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_rvolt;
	/**
	 * avr_pvolt：此次检测的平均p波电压。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_pvolt;
	/**
	 * avr_tvolt：此次检测的平均t波 电压。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_tvolt;
	/**
	 * avr_stvolt：ST段平均电压。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_stvolt;
	/**
	 * avr_rr：此次检测全局rr间期。Float类型，表示单精度浮点的数值。
	 * @return
	 */
	private float avr_rr;
	/**
	 * avr_qtc：此次检测全局qtc间期。Float类型，表示单精度浮点的数值。
	 */
	private float avr_qtc;
	 

	/**
	 * 表示输出各种数据，解析器输出的数据类型唯一标识。string类型
	 */
	private String apptype;
	/**
	 * 数据识别码，
	 */
	private String datakey;
	/**
	 * 表示文件产生时间，即测量时间。string类型，格式为“yyyy-MM-dd HH:mm:ss”。 
	 */
	private String collectdate;
	/**
	 * 表示接收到文件的时间，string类型，格式为“yyyy-MM-dd HH:mm:ss”。
	 */
	private String adddate;
	/**
	 * 标记数据是否已经同步。bool类型，初始值为false即企业用户未同步数据，若数据自动推送成功则会把此标记置为true，
	 * 若数据未推送成功，当用户主动读取数据时可选择把此标记置true或者不修改。注意此标记一旦置为true不可更改。
	 */
	private Boolean synced;
	/**
	 * 数据所属的企业ID， string类型。
	 */
	private String EntAccount;
	/**
	 * 每条数据的唯一标识，string类型。
	 */
	private String DataId;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getStisnormal() {
		return stisnormal;
	}
	public void setStisnormal(String stisnormal) {
		this.stisnormal = stisnormal;
	}
	public String getIsarrhythmia() {
		return isarrhythmia;
	}
	public void setIsarrhythmia(String isarrhythmia) {
		this.isarrhythmia = isarrhythmia;
	}
	public String getWaveform() {
		return waveform;
	}
	public void setWaveform(String waveform) {
		this.waveform = waveform;
	}
	public String getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}
	public String getWholewave() {
		return wholewave;
	}
	public void setWholewave(String wholewave) {
		this.wholewave = wholewave;
	}
	public int getHowmanywave() {
		return howmanywave;
	}
	public void setHowmanywave(int howmanywave) {
		this.howmanywave = howmanywave;
	}
	public int getHowmanysuccess() {
		return howmanysuccess;
	}
	public void setHowmanysuccess(int howmanysuccess) {
		this.howmanysuccess = howmanysuccess;
	}
	public float getAvr_heartrate() {
		return avr_heartrate;
	}
	public void setAvr_heartrate(float avr_heartrate) {
		this.avr_heartrate = avr_heartrate;
	}
	public int getAvr_pr() {
		return avr_pr;
	}
	public void setAvr_pr(int avr_pr) {
		this.avr_pr = avr_pr;
	}
	public int getAvr_qt() {
		return avr_qt;
	}
	public void setAvr_qt(int avr_qt) {
		this.avr_qt = avr_qt;
	}
	public float getAvr_rvolt() {
		return avr_rvolt;
	}
	public void setAvr_rvolt(float avr_rvolt) {
		this.avr_rvolt = avr_rvolt;
	}
	public float getAvr_pvolt() {
		return avr_pvolt;
	}
	public void setAvr_pvolt(float avr_pvolt) {
		this.avr_pvolt = avr_pvolt;
	}
	public float getAvr_tvolt() {
		return avr_tvolt;
	}
	public void setAvr_tvolt(float avr_tvolt) {
		this.avr_tvolt = avr_tvolt;
	}
	public float getAvr_stvolt() {
		return avr_stvolt;
	}
	public void setAvr_stvolt(float avr_stvolt) {
		this.avr_stvolt = avr_stvolt;
	}
	public float getAvr_rr() {
		return avr_rr;
	}
	public void setAvr_rr(float avr_rr) {
		this.avr_rr = avr_rr;
	}
	public String getApptype() {
		return apptype;
	}
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	public String getDatakey() {
		return datakey;
	}
	public void setDatakey(String datakey) {
		this.datakey = datakey;
	}
	public String getCollectdate() {
		return collectdate;
	}
	public void setCollectdate(String collectdate) {
		this.collectdate = collectdate;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public Boolean getSynced() {
		return synced;
	}
	public void setSynced(Boolean synced) {
		this.synced = synced;
	}
	public String getEntAccount() {
		return EntAccount;
	}
	public void setEntAccount(String entAccount) {
		EntAccount = entAccount;
	}
	public String getDataId() {
		return DataId;
	}
	public void setDataId(String dataId) {
		DataId = dataId;
	}
	public float getAvr_qtc() {
		return avr_qtc;
	}
	public void setAvr_qtc(float avr_qtc) {
		this.avr_qtc = avr_qtc;
	}
	
	
}