package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="n_vender_material")
public class NVenderMaterial {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "material_id")
	private Integer materialId;
	@Column(name = "material_name")
	private String materialName;
	@Column(name = "material_amount")
	private Integer materialAmount;
	@Column(name = "material_standard")
	private String materialStandard;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "created_by")
	private String createdBy;
	@ManyToOne(optional=true)
	@JoinColumn(name="program_id")
	private NProgram nProgram;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Integer getMaterialAmount() {
		return materialAmount;
	}
	public void setMaterialAmount(Integer materialAmount) {
		this.materialAmount = materialAmount;
	}
	public String getMaterialStandard() {
		return materialStandard;
	}
	public void setMaterialStandard(String materialStandard) {
		this.materialStandard = materialStandard;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public NProgram getnProgram() {
		return nProgram;
	}
	public void setnProgram(NProgram nProgram) {
		this.nProgram = nProgram;
	}
	
	
}
