package com.anticw.aged.vo.professional.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author dx 2016/7/18 活动中专业老师和专业课程标签
 *
 */
public class NProgtemVOThree {

	private List<String>  keyword=new ArrayList<String>();
	
	private Map<String, String>  teacher=new HashMap<String,String>();

	public List<String> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

	public Map<String, String> getTeacher() {
		return teacher;
	}

	public void setTeacher(Map<String, String> teacher) {
		this.teacher = teacher;
	}

	
	
}
