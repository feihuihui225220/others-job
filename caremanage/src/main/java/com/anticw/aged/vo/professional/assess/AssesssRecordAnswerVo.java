package com.anticw.aged.vo.professional.assess;
/**
 * 添加报告使用同AssessRecordAnswerVo比较多个字段conclusion(建议)
 * @author dx
 *
 */
public class AssesssRecordAnswerVo {
	private Integer questionId;
	private String questionName;
	private String answerName;
	private String answerId;
	private String aConclusion;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	private String code;
	private Integer score;
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getaConclusion() {
		return aConclusion;
	}
	public void setaConclusion(String aConclusion) {
		this.aConclusion = aConclusion;
	}
	
	
}
