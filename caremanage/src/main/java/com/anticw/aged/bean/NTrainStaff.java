package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="n_train_staff")
public class NTrainStaff implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "site_id")
	private Long siteId;
	@Column(name = "train_id")
	private Integer trainId;
	@Column(name = "create_at")
	private Date createAt;
	@Column(name = "create_by")
	private String createBy;
	
	public NTrainStaff() {
	
	}
	
	public NTrainStaff(Long siteId, Integer trainId, Date createAt,
			String createBy) {
		super();
		this.siteId = siteId;
		this.trainId = trainId;
		this.createAt = createAt;
		this.createBy = createBy;
	}

	public Long getId() {
		return id;
	}

	public Long getSiteId() {
		return siteId;
	}


	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public String getCreateBy() {
		return createBy;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	
	
	
}
