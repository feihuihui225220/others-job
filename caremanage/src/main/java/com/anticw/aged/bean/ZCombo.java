package com.anticw.aged.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ZCombo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_combo")
public class ZCombo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6924946152145293254L;
	private Integer comboId;
	private String comboName;
	private String effect;
	private Double price;
	private Double originalPrice;
	private Double attendClass;//attend_class
	private Double finishClass;//finish_class
	private String nprogramIds;
	private Boolean available;
	private Boolean putaway;
	private String forAge;
	private String imgUrl;
	private Date createAt;
	private String createBy;
	private Date changeAt;
	private String changeBy;
	private Short version;
	private Integer pageView;

	// Constructors

	/** default constructor */
	public ZCombo() {
	}

	/** full constructor */
	public ZCombo(Double price, Double originalPrice, String nprogramIds,
			Boolean available, String forAge, Timestamp createAt,
			String createBy, Timestamp changeAt, String changeBy, Short version) {
		this.price = price;
		this.originalPrice = originalPrice;
		this.nprogramIds = nprogramIds;
		this.available = available;
		this.forAge = forAge;
		this.createAt = createAt;
		this.createBy = createBy;
		this.changeAt = changeAt;
		this.changeBy = changeBy;
		this.version = version;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "combo_id", unique = true, nullable = false)
	public Integer getComboId() {
		return this.comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "original_price", precision = 22, scale = 0)
	public Double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Column(name = "nprogram_ids")
	public String getNprogramIds() {
		return this.nprogramIds;
	}

	public void setNprogramIds(String nprogramIds) {
		this.nprogramIds = nprogramIds;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "for_age", length = 25)
	public String getForAge() {
		return this.forAge;
	}

	public void setForAge(String forAge) {
		this.forAge = forAge;
	}

	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "create_by", length = 25)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "change_at", length = 19)
	public Date getChangeAt() {
		return this.changeAt;
	}

	public void setChangeAt(Date changeAt) {
		this.changeAt = changeAt;
	}

	@Column(name = "change_by", length = 25)
	public String getChangeBy() {
		return this.changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	@Column(name = "version")
	public Short getVersion() {
		return this.version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}
	@Column(name = "combo_name")
	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	@Column(name = "attend_class")
	public Double getAttendClass() {
		return attendClass;
	}

	public void setAttendClass(Double attendClass) {
		this.attendClass = attendClass;
	}
	@Column(name = "finish_class")
	public Double getFinishClass() {
		return finishClass;
	}

	public void setFinishClass(Double finishClass) {
		this.finishClass = finishClass;
	}

	@Column(name = "effect")
	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	@Column(name = "putaway")
	public Boolean getPutaway() {
		return putaway;
	}

	public void setPutaway(Boolean putaway) {
		this.putaway = putaway;
	}

	@Column(name="img_url")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Column(name = "page_view")
	public Integer getPageView() {
		return pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

}