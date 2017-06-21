/**   

 * @Title: CComplaintVO.java 
 * @Package com.anticw.aged.vo.care 
 * @Description: TODO
 * @author ltw   
 * @date 2014年10月6日 下午8:15:21 
 * @version V1.0   
 */
package com.anticw.aged.vo.care;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 投诉实体VO
 * 
 * @ClassName: CComplaintVO
 * @Description: TODO
 * @author ltw
 * @date 2014年10月6日 下午8:15:21
 * 
 */
public class CComplaintVO implements BaseVO{
	private Long id;
	private Long userId;
	private Long orderId;
	//private Integer communityId;
	private Short status;
	private String content;
	private String conclusion;
	private String callback;
	private Boolean available;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		if ("".equals(content)) {
			this.content = null;
		} else {

			this.content = content;
		}

	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		if ("".equals(conclusion)) {
			this.conclusion = null;
		} else {

			this.conclusion = conclusion;
		}
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		if ("".equals(callback)) {
			this.callback = null;
		} else {

			this.callback = callback;
		}
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public boolean selfValidate() throws BusinessException {
		if(userId==null||orderId==null){
			return false;
		}
		    return true;
	}

	
}
