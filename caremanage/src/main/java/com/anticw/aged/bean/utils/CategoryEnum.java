package com.anticw.aged.bean.utils;


public enum CategoryEnum {
	
	POLICY("政策",1),
	NOTICT("公告",2),
	CERFI("证件",3),
	PROSER("专业服务",4),
	CARESER("关爱服务",5),
	KNOWLEDGE("知识库",6),

	ASSMENTTYPE("评估量表类型",19),
	
	/**********************居民信息项分类**********************/
	HRTYPE("户口类型",101),
	MARRY("婚姻情况",102),
	POLITICAL("政治面貌",103),
	EDUCATION("文化程度",104),
	LIFECOND("居住情况",105),
	JOBCOND("从业情况",106),
	MEDICAL("医疗保障",107),
	RELIGION("宗教信仰",108),
	NATION("民族",109),
	INCOME("经济来源",110),
	THREE("三无",111),
	DISABLE("失能",112),
	NOSECURITY("无保障",113),
	LONELY("孤寡",114),
	LESSINCOME("低保",115),
	EMPTYNEST("空巢",116),
	LOSTONLY("失独",117),
	SPECIALCARE("优抚",118),
	LIFELONELY("独居",119),
	RELATION("与用户关系",120),
	PROPLAN("专业服务计划",121),
	CARETAG("服务标签",122)
	;

	private CategoryEnum(String name,int index){
		this.name=name;
		this.index=index;
	}
	
	public static String getName(int index) {  
        for (CategoryEnum ce : CategoryEnum.values()) {  
            if (ce.getIndex() == index) {  
                return ce.name;  
            }  
        }  
        return null;  
    } 
	
	private String name;  
	private int index;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	} 
	

}
