package cn.emay.sdk.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.PPolicy;
import com.anticw.aged.vo.common.SendMsgVO;

@Service
@Component
public class SMSService {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SMSService.class);
	/**
	 * 发送短信
	 * @return
	 */
	public int sendSms(SendMsgVO sendMsgVo){
		String[] mobiles = new String[sendMsgVo.getMobiles().size()];
		return Client.getInstance().sendSMS(sendMsgVo.getSendTime(), sendMsgVo.getMobiles().toArray(mobiles),sendMsgVo.getSmsContent(),
				sendMsgVo.getAddSerial(),sendMsgVo.getSrcCharset(), sendMsgVo.getSmsPriority());
	}
	/**
	 * 向服务商发送订单信息
	 * @param cOrder
	 * @return
	 */
	/*public int sendSms(COrder cOrder){
		List<String> contacts = new ArrayList<String>();
		//分隔多个电话号码
		String[] contactsArray = cOrder.getcVendor().getContactPhone().split("\\D");
		contacts.add(contactsArray.length>0?contactsArray[0]:"");
		//拼接信息内容
		StringBuilder sb = new StringBuilder();
		sb.append(cOrder.getContactUser()).append("订购了：");
		for(COrderItem item:cOrder.getcOrderItem()){
			sb.append(item.getName()).append("(").append(item.getQuantity()).append(")、");
		}
		sb.deleteCharAt(sb.lastIndexOf("、"));
		sb.append(",总消费：").append(cOrder.getTotalPrice())
			.append(",服务需求时间：").append(DateUtil.formatDate(cOrder.getServiceTime(), "yyyy-MM-dd HH:mm"))
			.append("。联系电话：").append(cOrder.getContactPhone())
			.append(",地址：").append(cOrder.getAddr())
			.append(",备注：").append(cOrder.getRemark()).append("。")
			.append(SendMsgVO.SIGNATURE);
		String msg = sb.toString();
		SendMsgVO sendMsgVo = new SendMsgVO(contacts, msg);
		int status = this.sendSms(sendMsgVo);
		logger.debug(status+"/"+contacts+"/"+msg);
		return status;
	}*/
	/**
	 * 发送公共服务推荐信息
	 * @param phone
	 * @param policy
	 * @return
	 */
	public int sendSms(String phone,PPolicy policy){
		StringBuilder sb = new StringBuilder("您有服务可以办理：");
		sb.append(policy.getTitle()).append("。")
			.append("内容：").append(policy.getContent()).append("；")
			.append("受理单位：").append(policy.getAccept()).append("。")
			.append(SendMsgVO.SIGNATURE);
		String msg = sb.toString();
		SendMsgVO msgvo = new SendMsgVO(Arrays.asList(phone), msg);
		return sendSms(msgvo);
	}
	
	
	public int sendSmartDevice(String phone,String userName,String desc){
		StringBuilder sb = new StringBuilder(SendMsgVO.SIGNATURE);
		sb.append("“智能小北”发现:");
		sb.append(userName).append("先生或女士，").
		append(desc);
		String msg = sb.toString();
		SendMsgVO msgvo = new SendMsgVO(Arrays.asList(phone), msg);
		return sendSms(msgvo);
	}
	
}
