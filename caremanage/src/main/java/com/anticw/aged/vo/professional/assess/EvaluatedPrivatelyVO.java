package com.anticw.aged.vo.professional.assess;

import org.springframework.stereotype.Component;

/**
 * 
 * @author DX  
 *
 */
@Component
public class EvaluatedPrivatelyVO {

	private Long id;
	private Long userId;
	private Integer assessId;
	private String recordDetail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAssessId() {
		return assessId;
	}
	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}
	public String getRecordDetail() {
		return recordDetail;
	}
	public void setRecordDetail(String recordDetail) {
		this.recordDetail = recordDetail;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
		
}
