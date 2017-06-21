package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ZProductNorm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_product_norm")
public class ZProductNorm implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private short version;
	private Integer moduleId;
	private Integer itemId;
	private String units;
	private double ceiling;
	private double minimum;
	private String mExplain;
	private Date createAt;
	private String createBy;
	private Date changeAt;
	private String changeBy;
	private boolean available;

	// Constructors

	/** default constructor */
	public ZProductNorm() {
	}

	/** full constructor */
	public ZProductNorm(Integer moduleId, Integer itemId, String units,
			double ceiling, double minimum, String mExplain, Date createAt,
			String createBy, Date changeAt, String changeBy, boolean available) {
		this.moduleId = moduleId;
		this.itemId = itemId;
		this.units = units;
		this.ceiling = ceiling;
		this.minimum = minimum;
		this.mExplain = mExplain;
		this.createAt = createAt;
		this.createBy = createBy;
		this.changeAt = changeAt;
		this.changeBy = changeBy;
		this.available = available;
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

	@Version
	@Column(name = "version")
	public short getVersion() {
		return this.version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	@Column(name = "module_id")
	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name = "item_id")
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "units")
	public String getUnits() {
		return this.units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	@Column(name = "ceiling")
	public double getCeiling() {
		return this.ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

	@Column(name = "minimum")
	public double getMinimum() {
		return this.minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	@Column(name = "m_explain")
	public String getmExplain() {
		return mExplain;
	}

	public void setmExplain(String mExplain) {
		this.mExplain = mExplain;
	}

	@Column(name = "create_at")
	public Date getCreateAt() {
		return this.createAt;
	}

	

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "create_by")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_at")
	public Date getChangeAt() {
		return this.changeAt;
	}

	public void setChangeAt(Date changeAt) {
		this.changeAt = changeAt;
	}

	@Column(name = "change_by")
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "available")
	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}