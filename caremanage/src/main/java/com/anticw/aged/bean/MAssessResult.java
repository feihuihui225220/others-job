package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MAssessResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_result", catalog = "")
public class MAssessResult implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Double logisDisable;
	private Double logisDementia;
	private Double fisherDisableYes;
	private Double fisherDisableNo;
	private Integer fisherDisable;
	private Double fisherDementiaYes;
	private Double fisherDementiaNo;
	private Integer fisherDementia;
	private Double treeDisability;
	private Double treeHealthy;
	private String treeResult;
	private Date createdAt;

	// Constructors

	/** default constructor */
	public MAssessResult() {
	}

	/** full constructor */
	public MAssessResult(Integer userId, Double logisDisable,
			Double logisDementia, Double fisherDisableYes,
			Double fisherDisableNo, Integer fisherDisable,
			Double fisherDementiaYes, Double fisherDementiaNo,
			Integer fisherDementia, Double treeDisability, Double treeHealthy,
			String treeResult, Date createdAt) {
		this.userId = userId;
		this.logisDisable = logisDisable;
		this.logisDementia = logisDementia;
		this.fisherDisableYes = fisherDisableYes;
		this.fisherDisableNo = fisherDisableNo;
		this.fisherDisable = fisherDisable;
		this.fisherDementiaYes = fisherDementiaYes;
		this.fisherDementiaNo = fisherDementiaNo;
		this.fisherDementia = fisherDementia;
		this.treeDisability = treeDisability;
		this.treeHealthy = treeHealthy;
		this.treeResult = treeResult;
		this.createdAt = createdAt;
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

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "logis_disable", precision = 22, scale = 0)
	public Double getLogisDisable() {
		return this.logisDisable;
	}

	public void setLogisDisable(Double logisDisable) {
		this.logisDisable = logisDisable;
	}

	@Column(name = "logis_dementia", precision = 22, scale = 0)
	public Double getLogisDementia() {
		return this.logisDementia;
	}

	public void setLogisDementia(Double logisDementia) {
		this.logisDementia = logisDementia;
	}

	@Column(name = "fisher_disable_yes", precision = 22, scale = 0)
	public Double getFisherDisableYes() {
		return this.fisherDisableYes;
	}

	public void setFisherDisableYes(Double fisherDisableYes) {
		this.fisherDisableYes = fisherDisableYes;
	}

	@Column(name = "fisher_disable_no", precision = 22, scale = 0)
	public Double getFisherDisableNo() {
		return this.fisherDisableNo;
	}

	public void setFisherDisableNo(Double fisherDisableNo) {
		this.fisherDisableNo = fisherDisableNo;
	}

	@Column(name = "fisher_disable")
	public Integer getFisherDisable() {
		return this.fisherDisable;
	}

	public void setFisherDisable(Integer fisherDisable) {
		this.fisherDisable = fisherDisable;
	}

	@Column(name = "fisher_dementia_yes", precision = 22, scale = 0)
	public Double getFisherDementiaYes() {
		return this.fisherDementiaYes;
	}

	public void setFisherDementiaYes(Double fisherDementiaYes) {
		this.fisherDementiaYes = fisherDementiaYes;
	}

	@Column(name = "fisher_dementia_no", precision = 22, scale = 0)
	public Double getFisherDementiaNo() {
		return this.fisherDementiaNo;
	}

	public void setFisherDementiaNo(Double fisherDementiaNo) {
		this.fisherDementiaNo = fisherDementiaNo;
	}

	@Column(name = "fisher_dementia")
	public Integer getFisherDementia() {
		return this.fisherDementia;
	}

	public void setFisherDementia(Integer fisherDementia) {
		this.fisherDementia = fisherDementia;
	}

	@Column(name = "tree_disability", precision = 22, scale = 0)
	public Double getTreeDisability() {
		return this.treeDisability;
	}

	public void setTreeDisability(Double treeDisability) {
		this.treeDisability = treeDisability;
	}

	@Column(name = "tree_healthy", precision = 22, scale = 0)
	public Double getTreeHealthy() {
		return this.treeHealthy;
	}

	public void setTreeHealthy(Double treeHealthy) {
		this.treeHealthy = treeHealthy;
	}

	@Column(name = "tree_result", length = 20)
	public String getTreeResult() {
		return this.treeResult;
	}

	public void setTreeResult(String treeResult) {
		this.treeResult = treeResult;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}