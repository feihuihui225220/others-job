package cn.emay.sdk.service;


import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import cn.emay.sdk.api.*;

public class Client {
	
	static ResourceBundle bundle=PropertyResourceBundle.getBundle("config/config");
	SDKService service = new SDKService();
	private static SDKClient sDKClientSOAImpl= null;
	private static Client client=null;
	String softwareSerialNo="";
	String key="";

	public Client(String softwareSerialNo, String key) {
		this.softwareSerialNo = softwareSerialNo;
		this.key = key;
		sDKClientSOAImpl=service.getSDKService();
	}
	public synchronized static Client getInstance(String softwareSerialNo, String key){
		if(client==null){
			client=new Client(softwareSerialNo,key);
		}
		return client;
		
	}
	//通过配置文件进行初始化
	public synchronized static Client getInstance(){
		
		if(client==null){
			client=new Client(bundle.getString("softwareSerialNo"),bundle.getString("key"));
		}
		return client;
		
	}

	public int chargeUp(String cardNo, String cardPass) {
		return sDKClientSOAImpl.chargeUp(softwareSerialNo, key, cardNo,
				cardPass);
	}

	public double getBalance() {
		return sDKClientSOAImpl.getBalance(softwareSerialNo, key);
	}

	public double getEachFee() {
		return sDKClientSOAImpl.getEachFee(softwareSerialNo, key);
	}

	public List<Mo> getMO() {
		return sDKClientSOAImpl.getMO(softwareSerialNo, key);
	}

	public String getVersion() {
		return sDKClientSOAImpl.getVersion();
	}

	public int logout() {
		return sDKClientSOAImpl.logout(softwareSerialNo, key);
	}

	public int registDetailInfo(String eName, String linkMan, String phoneNum,
			String mobile, String email, String fax, String address,
			String postcode) {
		return sDKClientSOAImpl.registDetailInfo(softwareSerialNo, key, eName,
				linkMan, phoneNum, mobile, email, fax, address, postcode);
	}

	public int registEx(String serialpass) {
		return sDKClientSOAImpl.registEx(softwareSerialNo, key, serialpass);
	}
	/**
	 * 发送短信、可以发送定时和即时短信
	 * sendSMS(String sendTime, String[] mobiles, String smsContent,String addSerial, String srcCharset, int smsPriority)
	 * 1、mobiles 手机数组长度不能超过1000
	 * 2、sendTime 如果该参数不会空"",那么该条短信会在sendTime所指定的时间发送
	 * 3、smsContent 最多500个汉字或1000个纯英文、请客户不要自行拆分短信内容以免造成混乱、亿美短信平台会根据实际通道自动拆分、计费以实际拆分条数为准、亿美推荐短信长度70字以内 
	 * 4、addSerial 附加码(长度小于15的字符串) 用户可通过附加码自定义短信类别,或添加自定义主叫号码( 联系亿美索取主叫号码列表)
	 * 5、srcCharset 字符编码，默认为"GBK"
	 * 6、优先级范围1~5，数值越高优先级越高(相对于同一序列号)
	 */
	public int sendSMS(String sendTime, String[] mobiles, String smsContent,
			String addSerial, String srcCharset, int smsPriority) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < mobiles.length; i++) {
			list.add(mobiles[i]);
		}
		return sDKClientSOAImpl.sendSMS(softwareSerialNo, key, sendTime, list,
				smsContent, addSerial, srcCharset, smsPriority);
	}

	public int serialPwdUpd(String serialPwd, String serialPwdNew) {
		return sDKClientSOAImpl.serialPwdUpd(softwareSerialNo, key, serialPwd,
				serialPwdNew);
	}

	public int setMOForward(String forwardMobile) {
		return sDKClientSOAImpl.setMOForward(softwareSerialNo, key,
				forwardMobile);
	}

	public int setMOForwardEx(String[] forwardMobile) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < forwardMobile.length; i++) {
			list.add(forwardMobile[i]);
		}
		return sDKClientSOAImpl.setMOForwardEx(softwareSerialNo, key, list);
	}
	
	public int cancelMOForward() {
		return sDKClientSOAImpl.cancelMOForward(softwareSerialNo, key);
	}

}
