package com.anticw.aged;

import java.util.Date;

public class assessVO {
	private Long id;
	/**  
	 * 评估结果id
	 */
	private Long recordId;
	
	/**  
	 * 评估详情
	 */
	private String recordDetail;
	
	private Date createdAt;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRecordId() {
		return recordId;
	}
	
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	

	public String getRecordDetail() {
		return recordDetail;
	}
	
	public void setRecordDetail(String recordDetail) {
		this.recordDetail = recordDetail;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}

