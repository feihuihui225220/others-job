package com.anticw.aged.vo.professional.activity;

public class ProgramOfEventsVO {
	
	private String activeTime;//活动时间
	private String  duration;//时长
	private String   activityTheme;//活动主题
	private String   activeContent;//活动内容
	private String activitySuppliesMusic;//活动用品和音乐
	private String activitiesDivision;//活动分工
	
	public ProgramOfEventsVO(){
		
	}
	
	public ProgramOfEventsVO(String activeTime, String duration,
			String activityTheme, String activeContent,
			String activitySuppliesMusic, String activitiesDivision) {
		super();
		this.activeTime = activeTime;
		this.duration = duration;
		this.activityTheme = activityTheme;
		this.activeContent = activeContent;
		this.activitySuppliesMusic = activitySuppliesMusic;
		this.activitiesDivision = activitiesDivision;
	}


	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getActiveContent() {
		return activeContent;
	}

	public void setActiveContent(String activeContent) {
		this.activeContent = activeContent;
	}

	public String getActivitySuppliesMusic() {
		return activitySuppliesMusic;
	}

	public void setActivitySuppliesMusic(String activitySuppliesMusic) {
		this.activitySuppliesMusic = activitySuppliesMusic;
	}

	public String getActivitiesDivision() {
		return activitiesDivision;
	}

	public void setActivitiesDivision(String activitiesDivision) {
		this.activitiesDivision = activitiesDivision;
	}


	public String getActivityTheme() {
		return activityTheme;
	}


	public void setActivityTheme(String activityTheme) {
		this.activityTheme = activityTheme;
	}


	@Override
	public String toString() {
		return "ProgramOfEventsVO [activeTime=" + activeTime + ", duration="
				+ duration + ", activityTheme=" + activityTheme
				+ ", activeContent=" + activeContent
				+ ", activitySuppliesMusic=" + activitySuppliesMusic
				+ ", activitiesDivision=" + activitiesDivision + "]";
	}
	
	
}
