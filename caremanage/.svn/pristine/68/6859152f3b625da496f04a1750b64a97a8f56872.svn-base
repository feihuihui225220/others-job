package com.anticw.aged.vo.user;

public enum CountColumnEnum {
	户口类型("hr_type"),
	年龄("age"),
	居住情况("life_cond"),
	从业情况("job_cond"),
	经济来源("income"),
	性别("gender"),
	政治面貌("political"),
	文化程度("education"),
	民族("nation"),
	医疗保障("medical"),
	婚姻状况("marry"),
	////特殊信息
	
	三无("three"),
	无保障("no_security"),
	失独("lost_only"),
	优抚("special_care"),
	失能("disable"),
	孤寡("lonely"),
	低保("less_income"),
	空巢("empty_nest"),
	独居("life_lonely")
	;
	private String column;
	CountColumnEnum(String column){
		this.column = column;
	}
	
	public String getColumn(){
		return this.column;
	}
	
	public static CountColumnEnum getColumn(String title){
		return CountColumnEnum.valueOf(title);
	}
}
