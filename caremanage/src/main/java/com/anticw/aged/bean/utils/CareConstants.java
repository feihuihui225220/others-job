package com.anticw.aged.bean.utils;

/**
 * 关爱服务属性常量文件
 * <P>
 * File name : CareConstants.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-10-1
 * </P>
 */
public class CareConstants extends PropertyValueConstants {
	/** 关爱服务商订单-新订单 */
	public static final int ORDER_NEW = 1;
	/** 关爱服务商订单-已响应 */
	public static final int ORDER_RESPONSE = 2;
	/** 关爱服务商订单-已完成  */
	public static final int ORDER_FINISHED = 3;
	/** 关爱服务商订单-管理员退单 */
	public static final int ORDER_BACKED_BYADMIN = 6;
	/** 关爱服务商订单-服务商退单 */
	public static final int ORDER_BACKED_BYVENDOR = 7;
	/**菜单图片路径配置*/
	public static final int MENU_ATTR_PATH = 61;
	
	/**统计订单*/
	public static final int TYPE_COUNTORDER = 1;
	/**统计投诉*/
	public static final int TYPE_COUNTCOMPLAINT = 2;
}
