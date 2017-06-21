package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 脂肪数据管理
 * @author bsd
 *
 */
@Document(collection="h_fat")
public class Fat  extends MetaData{
	 
	/**
	 * Usernumber：表示用户编号，范围1-9，int类型。
	 */
	private int userNumber;
	/**
	 * Height：身高，int类型，单位为cm。
	 */
	private int height;
	/**
	 * Weight：体重， float类型，表示单精度浮点数字，单位为kg。
	 * @return
	 */
	private float weight;
	/**
	 * Age：年龄，int类型，单位为岁。
	 * @return
	 */
	private int age;
	/**
	 * Sex：性别，string类型，值为男性或女性。
	 * @return
	 */
	private String sex;
	/**
	 * fat content：脂肪含量， float类型，表示单精度浮点数字
	 */
	private float fatcontent;
	 /**
	  * Bmi：body mass index，体质指数， float类型，表示单精度浮点数字。
	  */
	private float bmi;
	/**
	 * Bmr：basal metabolic rate，基础代谢值，int类型。
	 */
	private int bmr;
	/**
	 * Bmiresult：body mass index result，体质指数判断结果，
	 * string类型，值包括偏低，标准，偏高，高四个状态。
	 */
	private String bmiresult;
	/**
	 * Bt：body type，体型类型，string类型，值包括消瘦，标准，隐性肥胖，健壮，肥胖五个状态。
	 */
	private String bt;
	
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
	
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getFatcontent() {
		return fatcontent;
	}
	public void setFatcontent(float fatcontent) {
		this.fatcontent = fatcontent;
	}
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	public int getBmr() {
		return bmr;
	}
	public void setBmr(int bmr) {
		this.bmr = bmr;
	}
	public String getBmiresult() {
		return bmiresult;
	}
	public void setBmiresult(String bmiresult) {
		this.bmiresult = bmiresult;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
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
	

}
