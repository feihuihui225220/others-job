package com.anticw.aged.vo.care;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class ReportVo {
	//计划时间
	private Date serviceTime;
	//计划内容
	private String content;
	//计划分类
	private String name;
	//备注
	private String remark;
	public ReportVo() {
	}
	public ReportVo(Date serviceTime, String content, String name, String remark) {
		this.serviceTime = serviceTime;
		this.content = content;
		this.name = name;
		this.remark = remark;
	}
	public Date getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
