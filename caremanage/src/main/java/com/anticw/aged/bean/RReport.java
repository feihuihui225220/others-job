package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_report")
public class RReport implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 984052832691337507L;
	private Long id;
	private Long rUserId;
	private String dateTime;
	private	String reportName;
	private String reportType;
	private String reportSource;
	private	String principal;
	private	String scale;
	private	String chief;
	private	String number;
	private	Short operate;
	private	String url;
	public RReport() {
	}


	

	public RReport(Long rUserId, String dateTime, String reportName,
			String reportType, String reportSource, String principal,
			String scale, String chief, String number, Short operate, String url) {
		super();
		this.rUserId = rUserId;
		this.dateTime = dateTime;
		this.reportName = reportName;
		this.reportType = reportType;
		this.reportSource = reportSource;
		this.principal = principal;
		this.scale = scale;
		this.chief = chief;
		this.number = number;
		this.operate = operate;
		this.url = url;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Column(name="number")
	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="r_user_id")
	public Long getrUserId() {
		return rUserId;
	}
	public void setrUserId(Long rUserId) {
		this.rUserId = rUserId;
	}
	@Column(name="date_time")
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Column(name="report_name")
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	@Column(name="report_type")
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	@Column(name="report_source" )
	public String getReportSource() {
		return reportSource;
	}
	public void setReportSource(String reportSource) {
		this.reportSource = reportSource;
	}
	@Column(name="principal")
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	@Column(name="scale")
	public String getScale() {
		return scale;
	}
	
	public void setScale(String scale) {
		this.scale = scale;
	}
	@Column(name="chief")
	public String getChief() {
		return chief;
	}
	
	public void setChief(String chief) {
		this.chief = chief;
	}
	@Column(name="operate")
	public Short getOperate() {
		return operate;
	}

	public void setOperate(Short operate) {
		this.operate = operate;
	}
	
	
	
}
