package com.anticw.aged.vo.common;

import com.anticw.aged.exception.BusinessException;

/**
 * 定义自检方法
 * <P>File name : BaseVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
public interface BaseVO {

	/**
	 * vo自检方法
	 * BaseVO.selfValidate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-1 </P>
	 * @return
	 * @throws BusinessException
	 */
	boolean selfValidate() throws BusinessException;
	
}
