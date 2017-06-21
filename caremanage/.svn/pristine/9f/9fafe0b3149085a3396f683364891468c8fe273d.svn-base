package com.anticw.aged.vo.professional.service;

import java.util.List;

import org.springframework.util.StringUtils;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 专业服务vo
 * <P>File name : ServiceVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-4 </P>
 */
public class ServiceVO implements BaseVO {

	/**
	 * 对象标识
	 */
	private Integer id;
	
	/**
	 * 服务名称
	 */
	private String name;
	
	/**
	 * 服务资质
	 */
	private String qualification;
	
	/**
	 * 价格(分)
	 */
	private Integer price;
	
	/**
	 * 服务分类
	 */
	private Integer categoryId;
	
	/**
	 * 封面
	 */
	private String picture;
	
	/**
	 * 元服务id
	 */
	private List<Integer> metaIds;
	
	/**
	 * 评估量表Id
	 */
	private List<Integer> assessIds;
	
	/**
	 * 服务内容
	 */
	private String content;
	
	/**
	 * 服务标准
	 */
	private String standard;

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
	 * @return String 取得域 qualification 的方法。
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification 对域 qualification 的设置方法.
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return Integer 取得域 price 的方法。
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price 对域 price 的设置方法.
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return Integer 取得域 categoryId 的方法。
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId 对域 categoryId 的设置方法.
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return String 取得域 picture 的方法。
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture 对域 picture 的设置方法.
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return List<Integer> 取得域 metaIds 的方法。
	 */
	public List<Integer> getMetaIds() {
		return metaIds;
	}

	/**
	 * @param metaIds 对域 metaIds 的设置方法.
	 */
	public void setMetaIds(List<Integer> metaIds) {
		this.metaIds = metaIds;
	}

	/**
	 * @return List<Integer> 取得域 assessIds 的方法。
	 */
	public List<Integer> getAssessIds() {
		return assessIds;
	}

	/**
	 * @param assessIds 对域 assessIds 的设置方法.
	 */
	public void setAssessIds(List<Integer> assessIds) {
		this.assessIds = assessIds;
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
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-4 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(qualification) || StringUtils.isEmpty(content) || StringUtils.isEmpty(standard) || price == null ||
		   (metaIds == null || metaIds.isEmpty())) {
			
			throw new BusinessException(ExceptionCode.SERVICE_INFO_INCOMPLETE);
		}
		
		return true;
	}
}
