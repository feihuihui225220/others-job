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
 * HUrineRoutine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "h_urine_routine")
public class HUrineRoutine implements java.io.Serializable {

	// Fields

	/**
	 * 作者： bsd
	 * 日期：  2016-9-12
	 * 功能：尿常规
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version;
	private long userId;
	private String urineSpecificGravity;
	private String ph;
	private String redBloodCell;
	private String whiteBloodCell;
	private String nitrite;
	private String protein;
	private String glucose;
	private String ketone;
	private String urinaryBladder;
	private String urineBilirubin;
	private Date createTime;
	private String createBy;
	private Date changeTime;
	private String changeBy;

	// Constructors

	/** default constructor */
	public HUrineRoutine() {
	}

	public HUrineRoutine(String urineSpecificGravity, String ph, String redBloodCell,
			String whiteBloodCell, String nitrite, String protein, String glucose,
			String ketone, String urinaryBladder, String urineBilirubin) {
		super();
		this.urineSpecificGravity = urineSpecificGravity;
		this.ph = ph;
		this.redBloodCell = redBloodCell;
		this.whiteBloodCell = whiteBloodCell;
		this.nitrite = nitrite;
		this.protein = protein;
		this.glucose = glucose;
		this.ketone = ketone;
		this.urinaryBladder = urinaryBladder;
		this.urineBilirubin = urineBilirubin;
		
	}
	/** full constructor */
	public HUrineRoutine(long userId, String urineSpecificGravity, String ph,
			String redBloodCell, String whiteBloodCell, String nitrite,
			String protein, String glucose, String ketone,
			String urinaryBladder, String urineBilirubin, Date createTime,
			String createBy, Date changeTime, String changeBy) {
		this.userId = userId;
		this.urineSpecificGravity = urineSpecificGravity;
		this.ph = ph;
		this.redBloodCell = redBloodCell;
		this.whiteBloodCell = whiteBloodCell;
		this.nitrite = nitrite;
		this.protein = protein;
		this.glucose = glucose;
		this.ketone = ketone;
		this.urinaryBladder = urinaryBladder;
		this.urineBilirubin = urineBilirubin;
		this.createTime = createTime;
		this.createBy = createBy;
		this.changeTime = changeTime;
		this.changeBy = changeBy;
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
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "user_id")
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "urine_specific_gravity", length = 32)
	public String getUrineSpecificGravity() {
		return this.urineSpecificGravity;
	}

	public void setUrineSpecificGravity(String urineSpecificGravity) {
		this.urineSpecificGravity = urineSpecificGravity;
	}

	@Column(name = "ph", length = 32)
	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Column(name = "red_blood_cell", length = 32)
	public String getRedBloodCell() {
		return this.redBloodCell;
	}

	public void setRedBloodCell(String redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	@Column(name = "white_blood_cell", length = 32)
	public String getWhiteBloodCell() {
		return this.whiteBloodCell;
	}

	public void setWhiteBloodCell(String whiteBloodCell) {
		this.whiteBloodCell = whiteBloodCell;
	}

	@Column(name = "nitrite", length = 32)
	public String getNitrite() {
		return this.nitrite;
	}

	public void setNitrite(String nitrite) {
		this.nitrite = nitrite;
	}

	@Column(name = "protein", length = 32)
	public String getProtein() {
		return this.protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	@Column(name = "glucose", length = 32)
	public String getGlucose() {
		return this.glucose;
	}

	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}

	@Column(name = "ketone", length = 32)
	public String getKetone() {
		return this.ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}

	@Column(name = "urinary_bladder", length = 32)
	public String getUrinaryBladder() {
		return this.urinaryBladder;
	}

	public void setUrinaryBladder(String urinaryBladder) {
		this.urinaryBladder = urinaryBladder;
	}

	@Column(name = "urine_bilirubin", length = 32)
	public String getUrineBilirubin() {
		return this.urineBilirubin;
	}

	public void setUrineBilirubin(String urineBilirubin) {
		this.urineBilirubin = urineBilirubin;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_by", length = 16)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_time", length = 0)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_by", length = 16)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

}