package com.anticw.aged.vo.professional.assess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;

/**
 * 评估量表VO
 * <P>File name : AssessVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-1 </P>
 */
public class AssessVO extends AssessBaseVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 评估量表名称
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String descr;
	
	/**
	 * 量表类型｛微信端对应｝
	 */
	private Integer itemId;
	
	/**  
	 * 问题及答案
	 */
	private List<AssessQuestionVO> qaList = new ArrayList<AssessQuestionVO>();
	/**  
	 * 结论
	 */
	private List<AssessCluVO> cluList = new ArrayList<AssessCluVO>();
	
	/**  
	 * 组合型评估量表下的分数评估量表列表
	 */
	private List<AssessVO> assessVOs = new ArrayList<AssessVO>();
	
	/**  
	 * return List<AssessVO> 获取域assessVOs的方法。
	 */
	public List<AssessVO> getAssessVOs() {
		return assessVOs;
	}
	
	/**  
	 * param List<AssessVO> 设置域assessVOs的方法。  
	 */
	public void setAssessVOs(List<AssessVO> assessVOs) {
		this.assessVOs = assessVOs;
	}
	
	/**  
	 * return List<AssessQuestionVO> 获取域qaList的方法。
	 */
	public List<AssessQuestionVO> getQaList() {
		return qaList;
	}
	
	/**  
	 * param List<AssessQuestionVO> 设置域qaList的方法。  
	 */
	public void setQaList(List<AssessQuestionVO> qaList) {
		this.qaList = qaList;
	}
	/**  
	 * return List<AssessCluVO> 获取域cluList的方法。
	 */
	public List<AssessCluVO> getCluList() {
		return cluList;
	}
	/**  
	 * param List<AssessCluVO> 设置域cluList的方法。  
	 */
	public void setCluList(List<AssessCluVO> cluList) {
		this.cluList = cluList;
	}
	
	/**
	 * 属性检测
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-1 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException{
		
		//判断类型是否合法
		super.selfValidate();
		
		//判断名称和描述是否为空
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(descr)) {
			throw new BusinessException(ExceptionCode.ASSESS_INFO_INCOMPLETE);
		}
		
		return true;
	}
	
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
	 * @return String 取得域 name 的方法。
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 对域 name 的设置方法.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String 取得域 descr 的方法。
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr 对域 descr 的设置方法.
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	
	
}
