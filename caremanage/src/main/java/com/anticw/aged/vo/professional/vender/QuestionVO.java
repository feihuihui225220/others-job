package com.anticw.aged.vo.professional.vender;

public class QuestionVO {
	private String question_id;
	private String question_name;
	private String answer_id;
	private String answer_name;
	private String code;
	private String score;
	private String conclusion;

	public QuestionVO() {
	
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer_name() {
		return answer_name;
	}
	public void setAnswer_name(String answer_name) {
		this.answer_name = answer_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "QuestionVO [question_id=" + question_id + ", question_name="
				+ question_name + ", answer_id=" + answer_id + ", answer_name="
				+ answer_name + ", code=" + code + ", score=" + score + "]";
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	
	
}
