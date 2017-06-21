package com.anticw.aged.vo.professional.assess;

import java.util.List;

public class AssessRecordDetailVo {
	
	private String conclusion;
	
	private List<AssessRecordAnswerVo> result;
	
	private String assessName;

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public List<AssessRecordAnswerVo> getResult() {
		return result;
	}

	public void setResult(List<AssessRecordAnswerVo> result) {
		this.result = result;
	}

	public String getAssessName() {
		return assessName;
	}

	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}


	
	
}
