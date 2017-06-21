package com.anticw.aged.vo.professional.assess;
/**
 * 
 * @author DX
 * 量表统计分析中条件
 */
public class QueryPropertiesVO {

	private Integer group1;//人员分组 头脑体操干预组、体适能训练干预组，以及混合组和对照组
	private Integer group2;//同上
	private Integer ModelingCategory;//建模类别 0 T单项服务 1不同特征的群体独立样本t检验 2卡方独立性检验 3卡方统一性检验4.单因素方差分析 5双因素方差分析
	private Integer choice;//建模选项{包括血压等}
	private Integer TimeFactor; //次因素 0 性别、1婚姻状况、2文化程度、3从业状况、4宗教、5失能与否、6经济来源、7过去职业、8年龄、
	private Double a;//自由度 0.01 0.05 0.10
	private Integer ageds;//年龄区间
	
	public Integer getGroup1() {
		return group1;
	}
	public void setGroup1(Integer group1) {
		this.group1 = group1;
	}
	public Integer getGroup2() {
		return group2;
	}
	public void setGroup2(Integer group2) {
		this.group2 = group2;
	}
	public Integer getChoice() {
		return choice;
	}
	public void setChoice(Integer choice) {
		this.choice = choice;
	}
	public Integer getTimeFactor() {
		return TimeFactor;
	}
	public void setTimeFactor(Integer timeFactor) {
		TimeFactor = timeFactor;
	}
	public Double getA() {
		return a;
	}
	public void setA(Double a) {
		this.a = a;
	}
	public Integer getModelingCategory() {
		return ModelingCategory;
	}
	public void setModelingCategory(Integer modelingCategory) {
		ModelingCategory = modelingCategory;
	}
	public Integer getAgeds() {
		return ageds;
	}
	public void setAgeds(Integer ageds) {
		this.ageds = ageds;
	}
	
	
}
