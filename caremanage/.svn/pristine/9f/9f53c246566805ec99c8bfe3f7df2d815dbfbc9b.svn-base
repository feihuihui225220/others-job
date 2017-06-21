package com.anticw.aged.vo.professional.assess;


import org.apache.commons.lang.StringUtils;

import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;

/**
 * 评估量表评估结果vo
 * <P>File name : AssessCluVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-2 </P>
 */
public class AssessCluVO extends AssessBaseVO {

	/**
	 * 评估结果Id
	 */
	private Integer id;
	
	/**
	 * 评估量表Id
	 */
	private Integer assessId;
	
	/**
	 * 评估标准 -- 分数表分上限
	 */
	private Integer upperLimit;
	
	/**
	 * 评估标准 -- 分数表分下限
	 */
	private Integer lowerLimit;
	
	/**
	 * 评估标准
	 */
	private String standard;
	
	/**
	 * 评估内容
	 */
	private String content;
	
	
	private Integer comboId;
	
	/**
	 * 推荐课程
	 *//*
	private List<NProgramVO>  nprList;*/
	

	private String  comboName;
	
	
	
	private String  comboImgUrl;
	
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
	 * @return Integer 取得域 assessId 的方法。
	 */
	public Integer getAssessId() {
		return assessId;
	}
	/**
	 * @param assessId 对域 assessId 的设置方法.
	 */
	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}
	/**
	 * @return String 取得域 standard 的方法。
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard 对域 standard 的设置方法.
	 */
	public void setStandard(String standard) {
		this.standard = standard;
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
	 * @return Integer 取得域 upperLimit 的方法。
	 */
	public Integer getUpperLimit() {
		return upperLimit;
	}
	/**
	 * @param upperLimit 对域 upperLimit 的设置方法.
	 */
	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}
	/**
	 * @return Integer 取得域 lowerLimit 的方法。
	 */
	public Integer getLowerLimit() {
		return lowerLimit;
	}
	/**
	 * @param lowerLimit 对域 lowerLimit 的设置方法.
	 */
	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	
	/**
	 * 自检
	 * AssessCluVO.selfValidate()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-2 </P>
	 * @return
	 * @throws BusinessException
	 */
	public boolean selfValidate() throws BusinessException {
		
		//父类检测
		super.selfValidate();
		
		//必要参数检测
		if(assessId == null || StringUtils.isEmpty(standard) || StringUtils.isEmpty(content)) {
			throw new BusinessException(ExceptionCode.ASSESS_CLU_INVALID);
		}
		
		//如果是分数表对应的结论页面则standard必须是“数字-数字”的格式
		if(getType() == ProfessionalConstants.ASSESS_TYPE_SCORE||getType() == ProfessionalConstants.ASSESS_TYPE_SITE) {
			if(!this.standard.matches("^\\d*\\-\\d*$")) {
				throw new BusinessException(ExceptionCode.ASSESS_CLU_INVALID);
			}else{
				String[] stardards = standard.split("-");
				if(Integer.valueOf(stardards[0]) > Integer.valueOf(stardards[1])) {
					throw new BusinessException(ExceptionCode.ASSESS_CLU_INVALID);
				}
			}
		}
		
		return true;
	}
	public Integer getComboId() {
		return comboId;
	}
	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getComboImgUrl() {
		return comboImgUrl;
	}
	public void setComboImgUrl(String comboImgUrl) {
		this.comboImgUrl = comboImgUrl;
	}
	 
	
}
