package com.anticw.aged.dao.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Generics的util类
 * <P>File name : GenericsUtils.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-18 </P>
 */
@SuppressWarnings({"rawtypes"}) 
public class GenericsUtils {

	private GenericsUtils() {
		
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的泛型参数的类型.
	 * 如public BookManager extends GenricManager<Book>
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的泛型参数的类型.
	 * 如public BookManager extends GenricManager<Book>
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		
		return (Class) params[index];
	}
}
