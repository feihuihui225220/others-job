package com.anticw.aged.utils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 字符串转换工具
 * @author L
 * 2015-4-23 16:16:42
 */
public class StringConvertUtil {
	
	private static final String METHOD_PRE_NAME = "stringTo";
	@SuppressWarnings("unchecked")
	public static <T> T convert(Class<T> clazz,String str){
		try {
			Method _method = StringConvertUtil.class.getMethod(METHOD_PRE_NAME+clazz.getSimpleName(), String.class);
			Object object = _method.invoke(null, str);
			return (T)object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String stringToString(String str){
		return str;
	}
	public static int stringToint(String str){
		return Integer.parseInt(str);
	}
	public static float stringTofloat(String str){
		return Float.parseFloat(str);
	}
	public static long stringTolong(String str){
		return Long.parseLong(str);
	}
	public static short stringToshort(String str){
		return Short.valueOf(str);
	}
	/**
	 * 字符串转整形
	 * @param str
	 * @return
	 */
	public static Integer stringToInteger(String str){
		return Integer.valueOf(str);
	}
	
	/**
	 * 字符串转长整形
	 * @param str
	 * @return
	 */
	public static Long stringToLong(String str){
		return Long.valueOf(str);
	}
	
	/**
	 * Short
	 * @param str
	 * @return
	 */
	public static Short stringToShort(String str){
		return Short.valueOf(str);
	}
	
	/**
	 * 浮点型
	 * @param str
	 * @return
	 */
	public static Float stringToFloat(String str){
		return Float.valueOf(str);
	}
	
	/**
	 * 双精度
	 * @param str
	 * @return
	 */
	public static Double stringToDouble(String str){
		return Double.valueOf(str);
	}
	
	/**
	 * date
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str){
		return DateUtil.parseStrToDateTime(str);
	}
	
}
