package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZFitness entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_fitness")
public class ZFitness implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146481992341355540L;
	
	private Integer FId;
	private String FName;
	private Integer parentId;
	private String imgUrl;
	private String videoUrl;
	private String monad;
	private String createBy;
	private Date createAt;
	private String changeBy;
	private Date changeAt;
	private short available;

	// Constructors

	/** default constructor */
	public ZFitness() {
	}

	/** full constructor */
	public ZFitness(String FName, Integer parentId, String imgUrl,
			String videoUrl, String monad, String createBy, Date createAt,
			String changeBy, Date changeAt, short available) {
		this.FName = FName;
		this.parentId = parentId;
		this.imgUrl = imgUrl;
		this.videoUrl = videoUrl;
		this.monad = monad;
		this.createBy = createBy;
		this.createAt = createAt;
		this.changeBy = changeBy;
		this.changeAt = changeAt;
		this.available = available;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "f_id", unique = true, nullable = false)
	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	@Column(name = "f_name", length = 50)
	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "img_url", length = 500)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "video_url", length = 100)
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Column(name = "monad", length = 50)
	public String getMonad() {
		return this.monad;
	}

	public void setMonad(String monad) {
		this.monad = monad;
	}

	@Column(name = "create_by", length = 20)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "change_by", length = 20)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "change_at", length = 19)
	public Date getChangeAt() {
		return this.changeAt;
	}

	public void setChangeAt(Date changeAt) {
		this.changeAt = changeAt;
	}

	@Column(name = "available")
	public short getAvailable() {
		return this.available;
	}

	public void setAvailable(short available) {
		this.available = available;
	}

}