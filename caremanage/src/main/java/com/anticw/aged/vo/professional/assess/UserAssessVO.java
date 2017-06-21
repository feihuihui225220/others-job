package com.anticw.aged.vo.professional.assess;

public class UserAssessVO {
	private long userId;
	private Double scores;
	private Double scoree;
	private int group; //分组
	public UserAssessVO( ) {
		// TODO Auto-generated constructor stub
	}
	public UserAssessVO(Double scores, Double scoree) {
		super();
		this.scores = scores;
		this.scoree = scoree;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Double getScores() {
		return scores;
	}
	public void setScores(Double scores) {
		this.scores = scores;
	}
	public Double getScoree() {
		return scoree;
	}
	public void setScoree(Double scoree) {
		this.scoree = scoree;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	
	
}
