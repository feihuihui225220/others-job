package com.anticw.aged.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PPolicyAtt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_policy_att")
public class PPolicyAtt implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fileName;
	private String directory;
	private Integer policyId;

	// Constructors
	public PPolicyAtt(String directory, Integer policyId) {
		this.directory = directory;
		this.policyId = policyId;
	}
	public PPolicyAtt() {
		
	}
	

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "directory")
	public String getDirectory() {
		return this.directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	@Column(name = "policy_id")
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	@Column(name = "file_name")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}