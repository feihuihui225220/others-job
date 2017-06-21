package com.anticw.aged.vo.professional.activity;

public class CourseVO {

	private String CourseType;//课程类别

	private String employeeId;//员工【专业老师】
	
	private String keyword;//关键字
	
	private String min;//关键字

	public String getCourseType() {
		return CourseType;
	}

	public void setCourseType(String courseType) {
		CourseType = courseType;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	
	

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "CourseVO [CourseType=" + CourseType + ", employeeId="
				+ employeeId + ", keyword=" + keyword + "]";
	}
	
	
}
