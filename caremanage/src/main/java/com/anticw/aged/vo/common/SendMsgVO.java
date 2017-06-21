package com.anticw.aged.vo.common;

import java.util.List;

public class SendMsgVO {
	
	public static String SIGNATURE = "【北科养老】";
	/**
	 * 构造方法
	 * @param mobiles
	 * @param smsContent
	 */
	public SendMsgVO(List<String> mobiles,String smsContent){
		this.mobiles = mobiles;
		this.smsContent = smsContent;
	}
	
	/**
	 * @param sendTime
	 * @param mobiles
	 * @param smsContent
	 * @param addSerial
	 * @param srcCharset
	 * @param smsPriority
	 */
	public SendMsgVO(String sendTime, List<String> mobiles, String smsContent,
			String addSerial, String srcCharset, int smsPriority) {
		super();
		this.sendTime = sendTime;
		this.mobiles = mobiles;
		this.smsContent = smsContent;
		this.addSerial = addSerial;
		this.srcCharset = srcCharset;
		this.smsPriority = smsPriority;
	}
	/**
	 *mobiles 手机数组长度不能超过1000
	 */
	private String  sendTime = "";
	/**
	 * sendTime 如果该参数不会空"",那么该条短信会在sendTime所指定的时间发送
	 */
	private List<String> mobiles;
	/**
	 * smsContent 最多500个汉字或1000个纯英文、请客户不要自行拆分短信内容以免造成混乱、亿美短信平台会根据实际通道自动拆分、计费以实际拆分条数为准、亿美推荐短信长度70字以内
	 */
	private String smsContent;
	/**
	 * addSerial 附加码(长度小于15的字符串) 用户可通过附加码自定义短信类别,或添加自定义主叫号码( 联系亿美索取主叫号码列表)
	 */
	private String addSerial = "";
	/**
	 * srcCharset 字符编码，默认为"GBK"
	 */
	private String srcCharset ="GBK";
	/**
	 * 优先级范围1~5，数值越高优先级越高(相对于同一序列号)
	 */
	private int smsPriority = 5;
	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * @return the mobiles
	 */
	public List<String> getMobiles() {
		return mobiles;
	}
	/**
	 * @param mobiles the mobiles to set
	 */
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	/**
	 * @return the smsContent
	 */
	public String getSmsContent() {
		return smsContent;
	}
	/**
	 * @param smsContent the smsContent to set
	 */
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	/**
	 * @return the addSerial
	 */
	public String getAddSerial() {
		return addSerial;
	}
	/**
	 * @param addSerial the addSerial to set
	 */
	public void setAddSerial(String addSerial) {
		this.addSerial = addSerial;
	}
	/**
	 * @return the srcCharset
	 */
	public String getSrcCharset() {
		return srcCharset;
	}
	/**
	 * @param srcCharset the srcCharset to set
	 */
	public void setSrcCharset(String srcCharset) {
		this.srcCharset = srcCharset;
	}
	/**
	 * @return the smsPriority
	 */
	public int getSmsPriority() {
		return smsPriority;
	}
	/**
	 * @param smsPriority the smsPriority to set
	 */
	public void setSmsPriority(int smsPriority) {
		this.smsPriority = smsPriority;
	}
	
	
}
