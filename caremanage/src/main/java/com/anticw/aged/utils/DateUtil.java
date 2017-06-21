package com.anticw.aged.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.anticw.aged.vo.common.DateParamVO;

/**
 * 功能概述：<br>
 * 
 * 时间处理工具类
 * 
 * @author guoyongxiang
 */
public class DateUtil {

	/** The Constant YEAR. */
	public final static String YEAR = " year ";

	/** The Constant MONTH. */
	public final static String MONTH = " month ";

	/** The Constant DAY. */
	public final static String DAY = " day ";

	/** The Constant WEEK. */
	public final static String WEEK = " week ";

	/** The Constant HOUR. */
	public final static String HOUR = " hour ";

	/** The Constant MINUTE. */
	public final static String MINUTE = " minute ";

	/** The Constant SECOND. */
	public final static String SECOND = " second ";

	/**
	 * The Constant YEAR_MONTH_FORMAT.<br>
	 * yyyy-MM
	 */
	public static final String YEAR_MONTH_FORMAT = "yyyy-MM";

	/**
	 * The Constant YEAR_MONTH_FORMAT_CN.<br>
	 * yyyy年MM月
	 */
	public static final String YEAR_MONTH_FORMAT_CN = "yyyy年MM月";

	/**
	 * The Constant DATE_TIME_FORMAT.<br>
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * The Constant DATE_TIME_FORMAT.<br>
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_FORMAT_MM = "yyyy-MM-dd HH:mm";

	/**
	 * The Constant DATE_TIME_FORMAT_MIN.<br>
	 * yyyyMMddHHmmss
	 */
	public static final String DATE_TIME_FORMAT_MIN = "yyyyMMddHHmmss";

	/**
	 * The Constant DATE_FORMAT.<br>
	 * yyyy-MM-dd
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * The Constant DATE_WEEK_FORMAT.<br>
	 * MM-dd EEEE
	 */
	public static final String DATE_WEEK_FORMAT = "MM-dd EEEE";

	/**
	 * The Constant TIME_MIN_FORMAT.<br>
	 * HH:mm
	 */
	public static final String TIME_MIN_FORMAT = "HH:mm";

	/**
	 * The Constant MONTH_DAY_FORMAT.<br>
	 * MM-dd
	 */
	public static final String MONTH_DAY_FORMAT = "MM-dd";

	public static final String DAY_FORMAT = "dd";
	
	
	public static final String TIME_MIN_FORMAT_ = "HH";
	public static final String TIME_MM_FORMAT_ = "MM";

	/**
	 * 判断参数是否等于null或者空
	 * 
	 * @param param
	 * @return
	 */
	public static boolean checkParam(Object param) {
		if (null == param || "".equals(param)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 得到当前系统时间:毫秒数
	 * 
	 * @return
	 */
	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 得到当前系统时间:无任何格式化
	 * 
	 * @return 格林威治时间
	 */
	public static Date getCurrentDate() {
		return new Date(getCurrentTimeMillis());
	}

	/**
	 * 得到当前系统时间并转化为字符串：系统默认显示格式
	 * 
	 * @return 系统默认时间显示格式 19位字符串
	 */
	public static String getCurrentFormatDateTime() {
		Date date = getCurrentDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.DATE_TIME_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * 得到当前系统日期并转化为字符串：系统默认显示格式
	 * 
	 * @return 系统默认日期显示格式 10位字符串
	 */
	public static String getCurrentFormatDate() {
		Date date = new Date(getCurrentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * 得到日期并转化为字符串：系统默认显示格式 yyy-mm-dd
	 * 
	 * @return 系统默认日期显示格式 10位字符串
	 */
	public static String getCurrentFormatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT);
		return dateFormat.format(date);
	}
	public static String getDayFormatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DAY_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String getCurrentFormatDatem(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.DATE_TIME_FORMAT_MM);
		return dateFormat.format(date);
	}
	/**
	 * 返回 yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getDATETIMEFORMAT(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * 得到当前系统日期和星期并转化为字符串：系统默认显示格式
	 * 
	 * @return 系统默认日期和星期显示格式 15位字符串
	 */
	public static String getCurrentFormatDateWeek() {
		Date date = new Date(getCurrentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.DATE_WEEK_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * 得到当前系统时间并转化为字符串：指定显示格式
	 * 
	 * @param pattern
	 *            e.g.DATE_FORMAT_8 = "yyyyMMdd"; DATE_TIME_FORMAT_14 =
	 *            "yyyyMMddHHmmss"; 或者类似于二者的格式 <br>
	 *            e.g."yyyyMMddHH"，"yyyyMM"
	 * @return
	 */
	public static String getCurrentCustomizeFormatDate(String pattern) {
		if (checkParam(pattern)) {
			return "";
		}
		Date date = getCurrentDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 输入日期，按照指定格式返回
	 * 
	 * @param date
	 * @param pattern
	 *            e.g.DATE_FORMAT_8 = "yyyyMMdd"; DATE_TIME_FORMAT_14 =
	 *            "yyyyMMddHHmmss"; 或者类似于二者的格式 <br>
	 *            e.g."yyyyMMddHH"，"yyyyMM"
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		if (checkParam(pattern) || checkParam(date)) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		return dateFormat.format(date);
	}

	/**
	 * 输入日期，按照指定格式和地区标识符返回
	 * 
	 * @param date
	 * @param pattern
	 *            e.g.DATE_FORMAT_8 = "yyyyMMdd"; DATE_TIME_FORMAT_14 =
	 *            "yyyyMMddHHmmss"; 或者类似于二者的格式 <br>
	 *            e.g."yyyyMMddHH"，"yyyyMM"
	 * @param locale
	 *            国家地区， e.g.new Locale("zh","CN","") 中国 Locale.getDefault();
	 * @return
	 */
	public static String formatDate(Date date, String pattern, Locale locale) {
		if (checkParam(pattern) || checkParam(date)) {
			return "";
		}
		if (checkParam(locale)) {
			locale = Locale.getDefault();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		return dateFormat.format(date);
	}

	/**
	 * 将时间字符串按照默认格式DATE_FORMAT = "yyyy-MM-dd"，转换为Date
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseStrToDate(String dateStr) {
		if (checkParam(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT);
		return dateFormat.parse(dateStr, new ParsePosition(0));
	}

	/**
	 * 将时间字符串按照默认格式DATE_TIME_FORMAT ="yyyy-MM-dd HH:mm:ss",转换为Date
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseStrToDateTime(String dateStr) {
		if (checkParam(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.DATE_TIME_FORMAT);
		return dateFormat.parse(dateStr, new ParsePosition(0));
	}

	/**
	 * 将时间字符串按照默认格式DATE_TIME_FORMAT ="yyyy-MM-dd HH:mm",转换为Date
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseStrToDateTimem(String dateStr) {
		if (checkParam(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DateUtil.DATE_TIME_FORMAT_MM);
		return dateFormat.parse(dateStr, new ParsePosition(0));
	}

	/**
	 * 将时间字符串按照默认格式DATE_FORMAT = "yyyy-MM-dd"，转换为Calender
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Calendar parseStrToCalendar(String dateStr) {
		if (checkParam(dateStr)) {
			return null;
		}
		Date date = parseStrToDateTime(dateStr);
		Locale locale = Locale.getDefault();
		Calendar cal = new GregorianCalendar(locale);
		cal.setTime(date);
		return cal;
	}

	/**
	 * 将日期字符串转换成日期时间字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String parseDateStrToDateTimeStr(String dateStr) {
		if (checkParam(dateStr)) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return formatDate(date, DateUtil.DATE_TIME_FORMAT);
	}

	/**
	 * 将时间或者时间日期字符串按照指定格式转换为Date
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseStrToCustomPatternDate(String dateStr,
			String pattern) {
		if (checkParam(pattern) || checkParam(dateStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return date;
	}

	/**
	 * 将时间字符串从一种格式转换成另一种格式.
	 * 
	 * @param dateStr
	 *            e.g. String dateStr = "2006-10-12 16:23:06";
	 * @param patternFrom
	 *            e.g. DatePattern.DATE_TIME_FORMAT
	 * @param patternTo
	 *            e.g. DatePattern.DATE_TIME_FORMAT_14
	 * @return
	 */
	public static String convertDatePattern(String dateStr, String patternFrom,
			String patternTo) {
		if (checkParam(patternFrom) || checkParam(patternTo)
				|| checkParam(dateStr)) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(patternFrom);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return formatDate(date, patternTo);
	}

	/**
	 * 日期天数增加
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		if (checkParam(date)) {
			return null;
		}
		if (0 == days) {
			return date;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * 日期天数减少
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date minusDays(Date date, int days) {
		return addDays(date, (0 - days));
	}

	/**
	 * 日期小时增加
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Date addHours(Date date, int hours) {
		if (checkParam(date)) {
			return null;
		}
		if (0 == hours) {
			return date;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	/**
	 * 日期分钟增加
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinutes(Date date, int minute) {
		if (checkParam(date)) {
			return null;
		}
		if (0 == minute) {
			return date;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 日期秒增加
	 * 
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static Date addSeconds(Date date, int seconds) {
		if (checkParam(date)) {
			return null;
		}
		if (0 == seconds) {
			return date;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

	/**
	 * 按时间格式相加
	 * 
	 * @param dateStr
	 *            原来的时间
	 * @param pattern
	 *            时间格式
	 * @param type
	 *            "year"年、"month"月、"day"日、"week"周、 "hour"时、"minute"分、"second"秒
	 *            通过常量来设置,e.g.DayInfoUtil.YEAR
	 * @param count
	 *            相加数量
	 * @return
	 */
	public static String addDate(String dateStr, String pattern, String type,
			int count) {
		if (checkParam(dateStr) || checkParam(pattern) || checkParam(type)) {
			return "";
		}
		if (0 == count) {
			return dateStr;
		}
		Date date = parseStrToCustomPatternDate(dateStr, pattern);
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);

		if (DateUtil.YEAR.equals(type)) {
			calendar.add(Calendar.YEAR, count);
		} else if (DateUtil.MONTH.equals(type)) {
			calendar.add(Calendar.MONTH, count);
		} else if (DateUtil.DAY.equals(type)) {
			calendar.add(Calendar.DAY_OF_MONTH, count);
		} else if (DateUtil.WEEK.equals(type)) {
			calendar.add(Calendar.WEEK_OF_MONTH, count);
		} else if (DateUtil.HOUR.equals(type)) {
			calendar.add(Calendar.HOUR, count);
		} else if (DateUtil.MINUTE.equals(type)) {
			calendar.add(Calendar.MINUTE, count);
		} else if (DateUtil.SECOND.equals(type)) {
			calendar.add(Calendar.SECOND, count);
		} else {
			return "";
		}

		return formatDate(calendar.getTime(), pattern);
	}

	/**
	 * 那时间格式相减
	 * 
	 * @param dateStr
	 * @param pattern
	 * @param type
	 * @param count
	 * @return
	 */
	public static String minusDate(String dateStr, String pattern, String type,
			int count) {
		return addDate(dateStr, pattern, type, (0 - count));
	}

	/**
	 * 日期大小比较
	 * 
	 * @param dateStr1
	 * @param dateStr2
	 * @param pattern
	 * @return
	 */
	public static int compareDate(String dateStr1, String dateStr2,
			String pattern) {
		if (checkParam(dateStr1) || checkParam(dateStr2) || checkParam(pattern)) {
			return 999;
		}
		Date date1 = parseStrToCustomPatternDate(dateStr1, pattern);
		Date date2 = parseStrToCustomPatternDate(dateStr2, pattern);

		return date1.compareTo(date2);
	}

	/**
	 * 日期大小比较
	 * 
	 * @param dateOne
	 * @param dateOther
	 * @return
	 * 
	 *         int
	 * 
	 *         Created on Aug 15, 2007 12:41:30 AM
	 */
	public static long compareDate(Date dateOne, Date dateOther) {
		return dateOne.getTime() - dateOther.getTime();
	}

	/**
	 * 获取指定时间月份的第一天
	 * 
	 * @name DateUtil.getFirstDayInMonth()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午12:15:32
	 * @param date
	 * @return
	 */
	public static Date getFirstDayInMonth(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, firstDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();

	}

	/**
	 * 获取指定时间月份的最后一天
	 * 
	 * @name DateUtil.getLastDayInMonth()
	 * @author zhoupeipei
	 * @Date 2014-10-19 下午12:28:39
	 * @param date
	 * @return
	 */
	public static Date getLastDayInMonth(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 获取下个月最后一天
	 * @return
	 */
	public static Date getLastDayInMonth_() {
	   Date date=new Date();  
	   Calendar calendar = Calendar.getInstance();  
	   calendar.setTime(date);  
	   calendar.add(Calendar.MONTH, 2);  
	   calendar.set(Calendar.DATE, 0);  
	   return calendar.getTime();  
	}

	/**
	 * 获得这个月的第一天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getFirstDayInMonth(String dateStr) {
		if (checkParam(dateStr)) {
			return "";
		}
		Date date = parseStrToDate(dateStr);
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, firstDay);
		return formatDate(calendar.getTime(), DateUtil.DATE_FORMAT);
	}

	/**
	 * 获得这个月的最后一天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getLastDayInMonth(String dateStr) {
		if (checkParam(dateStr)) {
			return "";
		}
		Date date = parseStrToDate(dateStr);
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		return DateUtil.formatDate(calendar.getTime(), DateUtil.DATE_FORMAT);
	}

	/**
	 * 获取周的第一天,周日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayInWeek(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, firstDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取周的最后一天,周六
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayInWeek(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, lastDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得这周的周一
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMondayInWeek(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		calendar.add(Calendar.DATE, -day_of_week + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得这周的周日
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getSundayInWeek(Date date) {
		if (checkParam(date)) {
			return null;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		calendar.add(Calendar.DATE, -day_of_week + 7);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得这周的第一天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getFirstDayInWeek(String dateStr) {
		if (checkParam(dateStr)) {
			return "";
		}
		Date date = parseStrToDate(dateStr);
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, firstDay);
		return DateUtil.formatDate(calendar.getTime(),
				DateUtil.DATE_TIME_FORMAT);
	}

	/** */
	/**
	 * 获得这周的最后一天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getLastDayInWeek(String dateStr) {
		if (checkParam(dateStr)) {
			return "";
		}
		Date date = parseStrToDate(dateStr);
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, lastDay);

		return DateUtil.formatDate(calendar.getTime(), DateUtil.DATE_FORMAT);
	}

	/**
	 * 时间相加
	 * 
	 * @return
	 */
	public static Date addTimeHour(Date date, int minute) {
		if (checkParam(date)) {
			return null;
		}
		if (0 == minute) {
			return date;
		}
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 当前时间：以半小时为单位超过半小时按照一小时算
	 * 
	 * @return
	 */
	public static String currentTimeHour() {
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		Date date = getCurrentDate();
		calendar.setTime(date);
		if (calendar.get(Calendar.MINUTE) <= 30) {
			calendar.set(Calendar.MINUTE, 30);
		} else {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			calendar.set(Calendar.MINUTE, 00);
		}
		return formatDate(calendar.getTime(), DateUtil.TIME_MIN_FORMAT);
	}

	/**
	 * 指定起始时间：以半小时为单位超过半小时按照一小时算
	 * 
	 * @return
	 */
	public static String specifyTimeHour(String specifyTime) {
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		Date date = parseStrToDateTime(specifyTime);
		calendar.setTime(date);
		if (calendar.get(Calendar.MINUTE) <= 30) {
			calendar.set(Calendar.MINUTE, 30);
			calendar.set(Calendar.SECOND, 00);
		} else {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			calendar.set(Calendar.MINUTE, 00);
			calendar.set(Calendar.SECOND, 00);
		}
		return formatDate(calendar.getTime(), DateUtil.TIME_MIN_FORMAT);
	}

	/**
	 * 指定起始时间：以半小时为单位超过半小时按照一小时算
	 * 
	 * @return
	 */
	public static String specifyTimeHour(String specifyTime, String pattern) {
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		Date date = parseStrToDateTime(specifyTime);
		calendar.setTime(date);
		if (calendar.get(Calendar.MINUTE) <= 30) {
			calendar.set(Calendar.MINUTE, 30);
			calendar.set(Calendar.SECOND, 00);
		} else {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			calendar.set(Calendar.MINUTE, 00);
			calendar.set(Calendar.SECOND, 00);
		}
		return formatDate(calendar.getTime(), pattern);
	}

	/**
	 * 当前时间：以半小时为单位超过半小时按照一小时算
	 * 
	 * @return
	 */
	public static String currentTimeHour(String pattern) {
		Locale locale = Locale.getDefault();
		Calendar calendar = new GregorianCalendar(locale);
		Date date = getCurrentDate();
		calendar.setTime(date);
		if (calendar.get(Calendar.MINUTE) <= 30) {
			calendar.set(Calendar.MINUTE, 30);
		} else {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			calendar.set(Calendar.MINUTE, 00);
		}
		return formatDate(calendar.getTime(), pattern);
	}

	/**
	 * 按年计算年龄
	 * 
	 * @author guoyongxiang Date: 2014-11-7 上午11:17:46
	 * @param birthDay
	 * @return
	 */
	public static int getAgeByYear(Date birthDay) {
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		return yearNow - yearBirth;
	}

	/**
	 * 按日期计算年龄
	 * 
	 * @author guoyongxiang Date: 2014-11-7 上午11:17:30
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAgeByDay(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("出生时间大于当前时间!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;// 注意此处，如果不加1的话计算结果是错误的
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				} else {
					// do nothing
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		} else {
			// monthNow<monthBirth
			// donothing
		}
		return age;
	}

	/**
	 * 获得两个指定的时间差 单位为毫秒
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getTotalTime(String startTime, String endTime) {
		if (checkParam(startTime) || checkParam(endTime)) {
			return 0;
		}
		Calendar end = parseStrToCalendar(endTime);
		Calendar stard = parseStrToCalendar(startTime);

		return end.getTimeInMillis() - stard.getTimeInMillis();
	}

	/**
	 * 获得两个指定的时间差 单位为毫秒
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getTotalTime(Date startTime, Date endTime) {
		if (checkParam(startTime) || checkParam(endTime)) {
			return 0;
		}
		Locale locale = Locale.getDefault();
		Calendar start = new GregorianCalendar(locale);
		Calendar end = new GregorianCalendar(locale);
		start.setTime(startTime);
		end.setTime(endTime);
		return end.getTimeInMillis() - start.getTimeInMillis();
	}

	/**
	 * 获得两个指定的天数差 单位为天
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * 
	 */
	public static int getTotalDay(Date startDay, Date endDay) {
		if (checkParam(startDay) || checkParam(endDay)) {
			return 0;
		}
		Locale locale = Locale.getDefault();
		Calendar start = new GregorianCalendar(locale);
		Calendar end = new GregorianCalendar(locale);
		start.setTime(startDay);
		end.setTime(endDay);
		int y = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		if (y != 0)
			return end.get(Calendar.DAY_OF_YEAR)
					- start.get(Calendar.DAY_OF_YEAR) + 365 * y;
		else
			return end.get(Calendar.DAY_OF_YEAR)
					- start.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 根据开始日期和结束日期得到时间间隔列表
	 * 
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public static List<Date> getDateSlice(Date startDay, Date endDay) {
		int space = getTotalDay(startDay, endDay);
		List<Date> spaceList = new ArrayList<Date>();
		for (int i = 0; i <= space; i++) {
			Date dateSpace = addDays(startDay, i);
			spaceList.add(dateSpace);
		}
		return spaceList;
	}

	/**
	 * 根据开始日期和结束日期得到时间间隔列表
	 * 
	 * @param firstDay
	 * @param endDay
	 * @return
	 */
	public static List<String> getDaySlice(Date startDay, Date endDay) {
		int space = getTotalDay(startDay, endDay);
		List<String> spaceList = new ArrayList<String>();
		for (int i = 0; i <= space; i++) {
			Date dateSpace = addDays(startDay, i);
			spaceList.add(i, formatDate(dateSpace, DateUtil.DATE_FORMAT));
		}
		return spaceList;
	}

	/**
	 * 根据当前日期获取0点的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	public static Date dateTimeOffset(Date dateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateTime);
		if (calendar.get(Calendar.HOUR_OF_DAY) < 03) {
			if (calendar.get(Calendar.AM_PM) == 0) {
				calendar.setTime(addDays(calendar.getTime(), -1));
			}
		}
		calendar.set(Calendar.HOUR_OF_DAY, 03);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	/**
	 * 根据当前日期获取整点的时间
	 * 
	 * @param date
	 * @return
	 * 
	 *         Date
	 * 
	 */
	public static Date convertHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	/**
	 * Conversion offset.
	 * 
	 * 转化时间偏移格式
	 * 
	 * @param time
	 *            the time 单位(秒)
	 * 
	 * @return the string
	 * 
	 */
	public static String conversionOffset(Long time) {

		Long leg = time;
		Long hour = leg / 3600;
		Long min = (leg % 3600) / 60;
		Long sec = leg % 60;
		StringBuffer buf = new StringBuffer();
		if (hour < 10) {
			buf.append("0");
		}
		buf.append(leg / 3600);
		buf.append(":");
		if (min < 10) {
			buf.append("0");
		}
		buf.append((leg % 3600) / 60);
		buf.append(":");
		if (sec < 10) {
			buf.append("0");
		}
		buf.append(leg % 60);
		return buf.toString();
	}

	/**
	 * 把日期格式化成字符串
	 * 
	 * @param date
	 * @param fromat
	 * @return
	 */
	public static String parseDateToString(Date date, String fromat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(fromat);
		return dateFormat.format(date);
	}

	/**
	 * 根据小时字符串获取小时所在日期
	 * 
	 * @param hourStr
	 * @return
	 */
	public static Date getHourDate(String hourStr) {
		if (checkParam(hourStr)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_MIN_FORMAT);
		Date date = dateFormat.parse(hourStr, new ParsePosition(0));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	public static String getWeekDay(String date, String format, String language) {
		int weekDay = 0;
		if (date != null && !"".equals(date)) {
			SimpleDateFormat currF = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			try {
				Date df = currF.parse(date);
				c.setTime(df);
				int d = c.get(Calendar.DATE);
				c.set(Calendar.DATE, d - 1);
				weekDay = c.get(Calendar.DAY_OF_WEEK);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return getWeekDay(weekDay, language);
	}

	private static String getWeekDay(int w, String language) {
		String weekDay = "";
		if (w > 0) {
			if (language != null && "zh_CN".equals(language)) {
				switch (w) {
				case 1:
					weekDay = "星期一";
					break;
				case 2:
					weekDay = "星期二";
					break;
				case 3:
					weekDay = "星期三";
					break;
				case 4:
					weekDay = "星期四";
					break;
				case 5:
					weekDay = "星期五";
					break;
				case 6:
					weekDay = "星期六";
					break;
				case 7:
					weekDay = "星期日";
					break;
				}
			} else {
				switch (w) {
				case 1:
					weekDay = "Monday";
					break;
				case 2:
					weekDay = "Tuesday";
					break;
				case 3:
					weekDay = "Wednesday";
					break;
				case 4:
					weekDay = "Thursday";
					break;
				case 5:
					weekDay = "Friday";
					break;
				case 6:
					weekDay = "Saturday";
					break;
				case 7:
					weekDay = "Sunday";
					break;
				}
			}
		}
		return weekDay;
	}
	
	public static int getMonthCount(Date start, Date end) {

		if (start == null || end == null || start.compareTo(end) >= 0) {
			return -1;
		}

		// 时分秒清零
		Calendar c1 = Calendar.getInstance();
		c1.setTime(start);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);

		// 时分秒清零
		Calendar c2 = Calendar.getInstance();
		c2.setTime(end);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);

		// 间隔的月数
		int monthCount = 0;

		// 循环增加
		while (true) {

			monthCount++;

			// C1增加一个月
			c1.add(Calendar.MONTH, 1);

			// 相差整月直接返回月数
			if (c1.getTime().compareTo(c2.getTime()) == 0) {

				return monthCount;

				// 相差不是整月
			} else if (c1.getTime().compareTo(c2.getTime()) > 0) {

				return -1;

				// 继续循环
			} else {

				continue;

			}
		}
	}

	/**
	 * 前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	/**
	 * 后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}
	public static Date getEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	/**
	 * 获取当前时间段内共有多少个自然周
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getweek(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int count = 1;
		end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天

		while (start.before(end)) {
			if (start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
			start.add(Calendar.DAY_OF_YEAR, 1);
		}
		return count;
	}

	/**
	 * 根据起止时间获取本短时间内每周的起止时间 Map<Integer,List<String>> Intefer为周数 List<String>
	 * get(0)起始时间 get(1)终止时间
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static Map<Integer, List<String>> geda(Date startDate, Date endDate)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		Integer count = 1;

		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		while (start.before(end)) {
			List<String> li = new ArrayList<String>();
			if (count == 1) {
				li.add(format.format(startDate));
			}
			if (start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				// 周一
				String sDate1 = getSpecifiedDayAfter(format.format(start
						.getTime()));
				if (count != 1) {
					li.add(sDate1);
				}
				li.add(format.format(start.getTime()));
				map.put(count, li);
				count++;
			}

			start.add(Calendar.DAY_OF_YEAR, 1);
		}
		if (end.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			List<String> li = new ArrayList<String>();
			li.add(convertWeekByDate(endDate));
			li.add(format.format(end.getTime()));
			map.put(count, li);
		}
		return map;
	}

	private static String convertWeekByDate(Date time) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT); // 设置时间格式

		Calendar cal = Calendar.getInstance();

		cal.setTime(time);

		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

		String imptimeBegin = sdf.format(cal.getTime());

		return imptimeBegin;

	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DATE_FORMAT).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 6);

		String dayAfter = new SimpleDateFormat(DATE_FORMAT).format(c.getTime());
		return dayAfter;
	}

	/**
	 * 获取某一时间段特定星期几的日期
	 * 
	 * @param dateFrom
	 *            开始时间
	 * @param dateEnd
	 *            结束时间
	 * @param weekDays
	 *            星期
	 * @return 返回时间数组
	 */
	public static String[] getDates(String dateFrom, String dateEnd,
			String weekDays) {
		long time = 1l;
		long perDayMilSec = 24 * 60 * 60 * 1000;
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		// 需要查询的星期系数
		String strWeekNumber = weekForNum(weekDays);
		try {
			dateFrom = sdf.format(sdf.parse(dateFrom).getTime() - perDayMilSec);
			while (true) {
				time = sdf.parse(dateFrom).getTime();
				time = time + perDayMilSec;
				Date date = new Date(time);
				dateFrom = sdf.format(date);
				if (dateFrom.compareTo(dateEnd) <= 0) {
					// 查询的某一时间的星期系数
					Integer weekDay = dayForWeek(date);
					// 判断当期日期的星期系数是否是需要查询的
					if (strWeekNumber.indexOf(weekDay.toString()) != -1) {
						dateList.add(dateFrom);
					}
				} else {
					break;
				}
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String[] dateArray = new String[dateList.size()];
		dateList.toArray(dateArray);
		return dateArray;
	}

	// 等到当期时间的周系数。星期日：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
	public static Integer dayForWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 得到对应星期的系数 星期日：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
	 * 
	 * @param weekDays
	 *            星期格式 星期一|星期二
	 */
	public static String weekForNum(String weekDays) {
		// 返回结果为组合的星期系数
		String weekNumber = "";
		// 解析传入的星期
		if (weekDays.indexOf("|") != -1) {// 多个星期数
			String[] strWeeks = weekDays.split("\\|");
			for (int i = 0; i < strWeeks.length; i++) {
				weekNumber = weekNumber + ""
						+ getWeekNum(strWeeks[i]).toString();
			}
		} else {// 一个星期数
			weekNumber = getWeekNum(weekDays).toString();
		}

		return weekNumber;

	}

	// 将星期转换为对应的系数 星期日：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
	public static Integer getWeekNum(String strWeek) {
		Integer number = 1;// 默认为星期日
		if ("星期日".equals(strWeek)) {
			number = 1;
		} else if ("星期一".equals(strWeek)) {
			number = 2;
		} else if ("星期二".equals(strWeek)) {
			number = 3;
		} else if ("星期三".equals(strWeek)) {
			number = 4;
		} else if ("星期四".equals(strWeek)) {
			number = 5;
		} else if ("星期五".equals(strWeek)) {
			number = 6;
		} else if ("星期六".equals(strWeek)) {
			number = 7;
		} else {
			number = 1;
		}
		return number;
	}
	
	public static DateParamVO getDate(Date date){
		DateParamVO vo=new DateParamVO();    
		Calendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR,0);
	    calendar.set(Calendar.MINUTE,0);
	    calendar.set(Calendar.SECOND,0);
	    calendar.set(Calendar.MILLISECOND,0);
	    vo.setStart(calendar.getTime());
	    calendar.set(Calendar.HOUR,23);
	    calendar.set(Calendar.MINUTE,59);
	    calendar.set(Calendar.SECOND,59);
	    calendar.set(Calendar.MILLISECOND,999);
	    vo.setEnd(calendar.getTime());
	    return vo;
	}
	/**
	 * 获取当天的开始时间
	 */
	public static Date getStartDate(Date date){  
		Calendar today = new GregorianCalendar();
		today.setTime(date);
	    today.set(Calendar.HOUR_OF_DAY,0);  
	    today.set(Calendar.MINUTE, 0);    
	    today.set(Calendar.SECOND, 0);    
	    today.set(Calendar.MILLISECOND, 0);
	    return today.getTime();  
	}
	/**
	 * 获取当天的结束时间
	 */
	public static Date getEndDate(Date date){  
		Calendar endToday = new GregorianCalendar();
		endToday.setTime(date);
	    endToday.set(Calendar.HOUR_OF_DAY, 23);    
	    endToday.set(Calendar.MINUTE, 59);    
	    endToday.set(Calendar.SECOND, 59);    
	    endToday.set(Calendar.MILLISECOND, 59);    
	    return endToday.getTime();  
	}
	/**
	 * 获取当天起始时间和终止时间
	 * @param date
	 * @return
	 */
	public static DateParamVO getOneDay(Date date){
		DateParamVO vo=new DateParamVO();
		String date1=getCurrentFormatDate(date);
		String start1=date1+" 00:00:00";
		String end1=date1+" 23:59:59";
		vo.setStart(parseStrToDateTime(start1));
		vo.setEnd(parseStrToDateTime(end1));
		return vo;
	}
	
	public static List<Date>  getEveryDay(DateParamVO vo){
		List<Date> dates=new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(vo.getStart());
		while(cal.getTime().compareTo(vo.getEnd())<=0){
			dates.add(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH,1);
		}
		return dates;
	}
	
	public static String getWeeks(DateParamVO vo){
		List<Date> dates=getEveryDay(vo);
		String weeks="";
		for(Date date:dates){
			weeks+=dayForWeek(date);
			weeks+=",";
		}
		return weeks;
	} 
	
	public static String getLastDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(Calendar.YEAR, year);     
        cal.set(Calendar.MONTH, month);     
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
       return  new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());  
    } 
	/**
	 * 获取时间差
	 * @param endDate
	 * @param nowDate
	 * @return
	 */
	public static Long getDatePoor(Date endDate, Date nowDate) {
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	   // long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    long mins=hour * 60 + min;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return  mins;
	}
}
