package com.anticw.aged.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZFitnessConclusion entity. @author dx 2016/12/19
 */
@Entity
@Table(name = "z_fitness_conclusion")
public class ZFitnessConclusion implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 737047872948313036L;
	private Integer id;
	private Integer fitnessId;
	private String fitnessConclusion;
	private Integer comboId;

	// Constructors

	/** default constructor */
	public ZFitnessConclusion() {
	}

	/** full constructor */
	public ZFitnessConclusion(Integer fitnessId, String fitnessConclusion,
			Integer comboId) {
		this.fitnessId = fitnessId;
		this.fitnessConclusion = fitnessConclusion;
		this.comboId = comboId;
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

	@Column(name = "fitness_id")
	public Integer getFitnessId() {
		return this.fitnessId;
	}

	public void setFitnessId(Integer fitnessId) {
		this.fitnessId = fitnessId;
	}

	@Column(name = "fitness_conclusion", length = 50)
	public String getFitnessConclusion() {
		return this.fitnessConclusion;
	}

	public void setFitnessConclusion(String fitnessConclusion) {
		this.fitnessConclusion = fitnessConclusion;
	}

	@Column(name = "combo_id")
	public Integer getComboId() {
		return this.comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

}