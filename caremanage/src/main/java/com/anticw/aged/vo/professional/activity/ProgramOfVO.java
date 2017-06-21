package com.anticw.aged.vo.professional.activity;

public class ProgramOfVO {

	private long id;
	private String activeTime;// 活动时间
	private String duration;// 时长
	private Integer teacherId;// 专业老师
	private String teacher;// 专业老师
	private Integer progranId;// 课程类别
	private String progranName;
	private String keyword;// 关键字
	private String activitySuppliesMusic;// 音乐
	private String courseContent;// 课程内容
	private Integer parentNode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getProgranId() {
		return progranId;
	}

	public void setProgranId(Integer progranId) {
		this.progranId = progranId;
	}

	public String getProgranName() {
		return progranName;
	}

	public void setProgranName(String progranName) {
		this.progranName = progranName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getActivitySuppliesMusic() {
		return activitySuppliesMusic;
	}

	public void setActivitySuppliesMusic(String activitySuppliesMusic) {
		this.activitySuppliesMusic = activitySuppliesMusic;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public Integer getParentNode() {
		return parentNode;
	}

	public void setParentNode(Integer parentNode) {
		this.parentNode = parentNode;
	}

}
