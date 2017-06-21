package com.anticw.aged.vo.professional.assess;

import java.util.List;

public class AssesssRecordDetailVo {
	private String conclusion;
	private String assessName;
	private Long recordId;
	private List<AssesssRecordAnswerVo> result;
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public List<AssesssRecordAnswerVo> getResult() {
		return result;
	}
	public void setResult(List<AssesssRecordAnswerVo> result) {
		this.result = result;
	}
	public String getAssessName() {
		return assessName;
	}
	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}
	
	
}
