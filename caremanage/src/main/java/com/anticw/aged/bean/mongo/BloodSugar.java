package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 血糖数据管理
 * @author bsd
 *
 */
@Document(collection="h_bloodsugar")
public class BloodSugar extends MetaData{
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
	
	
	/**
	 * 血糖为xxx类型为float，表示一个单精度浮点数字，单位为mmol(1mmol=18mg/dl)。
	 */
	private float bloodsugar;
	 
	public float getBloodsugar() {
		return bloodsugar;
	}
	public void setBloodsugar(float bloodsugar) {
		this.bloodsugar = bloodsugar;
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
