package com.anticw.aged.vo.professional.assess;

import org.apache.commons.lang.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;

/**
 * 评估量表答案vo
 * <P>File name : AssessAnswerVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
public class AssessAnswerVO extends AssessBaseVO {

	/**
	 * 答案Id
	 */
	private Integer id;
	
	/**
	 * 答案code
	 */
	private String code;
	
	/**
	 * 答案内容
	 */
	private String content;
	
	/**
	 * 分数
	 */
	private Short score;
	/**
	 * 答案建议
	 */
	private	String aconclusion;
	/**
	 * @return Integer 取得域 id 的方法。
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id 对域 id 的设置方法.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return String 取得域 code 的方法。
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code 对域 code 的设置方法.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return String 取得域 content 的方法。
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content 对域 content 的设置方法.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return Short 取得域 score 的方法。
	 */
	public Short getScore() {
		return score;
	}
	/**
	 * @param score 对域 score 的设置方法.
	 */
	public void setScore(Short score) {
		this.score = score;
	}
	/**
	 * 
	 * @return String 取得域 conclusion 的方法。
	 */
		public String getAconclusion() {
			return aconclusion;
		}
		
	/**
	 * 
	 * @param conclusion  对域 conclusion 的设置方法.
	 */
		public void setAconclusion(String aconclusion) {
			this.aconclusion = aconclusion;
		}
	
	/**
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-2 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		if(StringUtils.isEmpty(content) || StringUtils.isEmpty(code)){
			throw new BusinessException(ExceptionCode.ASSESS_QA_ERROR);
		}
		return true;
	}
	
}
