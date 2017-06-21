package com.anticw.aged.dao.utils;

import java.lang.reflect.Field;

import org.springframework.util.Assert;

/**
 * 扩展Apache Commons BeanUtils, 提供一些反射方面缺失的封装.
 * <P>File name : BeanUtils.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-18 </P>
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	private BeanUtils() {
	}

	/**
	 * 暴力获取当前类声明的private/protected变量
	 */
	static public Object getDeclaredProperty(Object object, String propertyName) throws IllegalAccessException, NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);
		Field field = object.getClass().getDeclaredField(propertyName);
		return getDeclaredProperty(object, field);
	}

	/**
	 * 暴力获取当前类声明的private/protected变量
	 */
	static public Object getDeclaredProperty(Object object, Field field) throws IllegalAccessException {
		Assert.notNull(object);
		Assert.notNull(field);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		Object result = field.get(object);
		field.setAccessible(accessible);
		return result;
	}

	/**
	 * 暴力设置当前类声明的private/protected变量
	 */
	static public void setDeclaredProperty(Object object, String propertyName, Object newValue) throws IllegalAccessException, NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = object.getClass().getDeclaredField(propertyName);
		setDeclaredProperty(object, field, newValue);
	}

	/**
	 * 暴力设置当前类声明的private/protected变量
	 */
	static public void setDeclaredProperty(Object object, Field field, Object newValue) throws IllegalAccessException {
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		field.set(object, newValue);
		field.setAccessible(accessible);
	}
}
