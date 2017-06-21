package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**   
 * 评估详情
 * @ClassName: MAssessRecordDetail     
 * @author zhoupeipei
 * @Date 2014年12月8日 下午4:09:14      
 */   
@Entity
@Table(name = "m_assess_record_detail")
public class MAssessRecordDetail implements Serializable {

	/**  
	 * 
	 */
	private static final long serialVersionUID = -8390572725382240885L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**  
	 * 评估结果id
	 */
	@Column(name = "record_id")
	private Long recordId;
	
	/**  
	 * 评估详情
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "text")
	@Column(name = "record_detail", length = 65535)
	private String recordDetail;
	
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
	
}
