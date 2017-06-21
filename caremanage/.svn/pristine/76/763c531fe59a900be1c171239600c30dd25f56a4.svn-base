package com.anticw.aged.exception;

/**
 * 异常状态码和异常信息
 * <P>File name : ExceptionCode.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-29 </P>
 */
public enum ExceptionCode {

	FAILED(-1, "系统错误"),
	/**
	 * (0-99)通用
	 */
	SUCCESS(0, "成功"),
	USER_NOT_LOGIN(1, "用户未登录!"),
	FILE_UPLOAD_LOST(2, "文件上传失败"),
	
	/**
	 * (100-199)用户相关
	 */
	USER_NAME_ALREADY_USE(100, "用户名已存在"),
	USER_ID_CARD_NO_NULL(101, "身份证号不能为空!"),
	USER_ID_CARD_NO_INVALID(102, "手机号无效!"),
	USER_NAME_NULL(103, "姓名不能为空!"),
	USER_GENDER_NULL(104, "性别不能为空!"),
	USER_PASS_NULL(105, "密码不能为空!"),
	USER_PASS_DIFF(106, "两次密码不同!"),
	USER_COMMUNITY_NULL(107, "街道不能为空!"),
	USER_PASSWORD_ERROR(108, "用户名或密码错误"),
	USER_INFO_INVALID(110, "用户不存在!"),
	USER_INFO_UNACTIVE(111, "账户未激活"),
	USER_INFO_LOCK(112, "账户已锁定"),
	USER_CERT_FILE_EMPTY(113, "证件为空"),
	USER_CERT_NO_EMPTY(114, "证件编号为空"),
	USER_ACCOUNT_ERR(115, "账户状态不正确,帐号可能已激活或被冻结"),
	USER_INFO_DIFF(116, "用户信息不匹配!"),
	COMMUNITYUSER_ADMIN_EXIST(117, "此社区已经存在管理员!"),
	COMMUNITYUSER_HAS_CHILD_ACCOUNT(118, "账户存在子用户"),
	USER_NUMBER_NO_INVALID(119,"用户电话无效！"),
	USER_MOBILEPHONE_NULL(120,"账号为空！"),
	
	/**
	 * (200-299)公共
	 */
	
	
	
	/**
	 * (300-399)专业
	 */
	ASSESS_TYPE_INVALID(300, "评估量表类型不合法！"),
	ASSESS_INFO_INCOMPLETE(301, "评估量表信息不完整!"),
	ASSESS_NOT_FOUND(302, "评估量表不存在！"),
	ASSESS_QA_ERROR(303, "评估量表问题答案有误!"),
	ASSESS_QA_NOT_FOUND(304, "评估量表问题及答案不存在！"),
	ASSESS_CLU_NOT_FOUND(305, "评估量表结论不存在！"),
	ASSESS_TYPE_UNABLE_MODIFY(306, "不能修改评估量表的类型！"),
	ASSESS_CLU_INVALID(307, "结论信息录入有误!"),
	ASSESS_NOT_PUBLISH(308, "评估量表还未发布!"),
	DEVICE_TYPE_INFO_INCOMPLETE(309, "设备类型信息不完整！"),
	DEVICE_TYPE_NOT_FOUND(310, "设备类型信息不存在！"),
	DATA_MODULE_INFO_INCOMPLETE(311, "数据模块信息不完整！"),
	META_NOT_FOUND(312, "元服务不存在！"),
	SERVICE_INFO_INCOMPLETE(313, "专业服务信息不完整!"),
	SERVICE_NOT_FOUND(314, "专业服务信息不存在！"),
	DEVICE_INFO_NOT_INCOMPLETE(315, "设备信息不完整!"),
	RECOMMAND_NOT_FOUND(316, "没有检索到推荐信息!"),
	ALARM_SETUP_ERROR(317, "报警设置不正确！"),
	SERVICE_DEVICE_ERROR(318, "专业服务下的设备类型存在异常!"),
	VENDER_NOT_FOUND(319, "没有检索到服务商信息"),
	ORDER_HAS_OPENED(320, "您已经开通了该服务！"),
	OPEN_DATE_ERROR(321, "您选择的开通时间有误，应为月的整数倍！"),
	ORDER_DEVICE_NOT_FOUND(322, "您订购的设备不存在！"),
	ORDER_NOT_FOUND(323, "没有检索到您的订购信息！"),
	ORDER_OPEN_INFO_ERROR(324, "您填写的开通信息有误！"),
	META_DATA_CONFIG_NOT_FOUND(325, "元服务数据配置不存在！"),
	VENDER_INFO_INCOMPLETE(326, "服务商信息不完整！"),
	VENDER_EVA_NOT_FOUND(327, "评估信息不存在！"),
	VENDER_HAS_EVALUTE(328, "改时间段内已存在评估记录！"),
	ASSESS_CAN_NOT_PUBLISHED_NO_QA(329, "不允许发布评估量表，请补充试题。"),
	ASSESS_CAN_NOT_PUBLISHED_NO_CLU(330,"不允许发布评估量表，请补充结论。"),
	SERVICE_COVER_UPLOAD_FAILED(340, "专业服务封面上传失败！"),
	ORDER_CONTINUE_FAILED(341, "续用失败，订单已过期或已被关闭！"),
	ORDER_BIND_ID_EMPTY(342, "设备绑定Id不能为空！"),
	PERMISSION_NOT(343," 当前用户没有操作权限"),
	MSERVICESHOWTYPEERROR(344,"专业服务展示类型配置有误！"),
	
	/**
	 * (400-499)关爱
	 */
	 CART_IS_NOT_NULL(400,"提交订单错误，购物车不能为空!"),
	
	/**
	 * (500-699)权限
	 */
	PERMISSION_PASSWORD_ERROR(501, "用户名或密码错误"),
	PERMISSION_INFO_INVALID(502, "用户信息无效!"),
	PERMISSION_NAME_NULL(503, "用户名不能为空"),
	PERMISSION_RESOURCE_EMPYT(504, "无可用资源"),
	
	
	
	
	/**
	 * (700-899)专业服务商 
	 */
	ADD_REPORT_PERMIT_NOT(701, "不允许添加服务报告，请核实权限以及专业服务信息"),
	ADD_MSG_PERMIT_NOT(702, "不允许添加实时消息，请核实权限以及专业服务信息"),
	
	
	
	;
	
	
	/**
	 * 异常代码
	 */
	public final int code;
	
	/**
	 * 异常消息
	 */
	public final String msg;
	
	/**
	 * 构造函数
	 * @param _code
	 * @param _msg
	 */
	private ExceptionCode(){
		code = 0;
		msg = "success";
	}
	
	/**
	 * 构造函数
	 * @param _code
	 * @param _msg
	 */
	private ExceptionCode(int _code, String _msg){
		code = _code;
		msg = _msg;
	}
	
	/**
	 * 获取异常信息
	 * ExceptionCode.msg()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-9-29 </P>
	 * @return
	 */
	public String msg(){
		return msg;
	}
	
	/**
	 * 获取异常状态码
	 * ExceptionCode.code()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-9-29 </P>
	 * @return
	 */
	public int code(){
		return code;
	}
}
