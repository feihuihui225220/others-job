package com.anticw.aged.vo.professional.assess;

import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 评估量表基类vo
 * <P>File name : AssessBaseVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
public abstract class AssessBaseVO implements BaseVO {

	/**
	 * 评估量表类型
	 */
	private Short type;
	
	/**
	 * 自检方法
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-2 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		
		//判断类型是否合法
		if(type == null || (type != ProfessionalConstants.ASSESS_TYPE_SCORE && type != ProfessionalConstants.ASSESS_TYPE_COMB && type != ProfessionalConstants.ASSESS_TYPE_SITE)) {
			throw new BusinessException(ExceptionCode.ASSESS_TYPE_INVALID);
		}
		
		return true;
	}

	/**
	 * @return Integer 取得域 type 的方法。
	 */
	public Short getType() {
		return type;
	}

	/**
	 * @param type 对域 type 的设置方法.
	 */
	public void setType(Short type) {
		this.type = type;
	}
}
