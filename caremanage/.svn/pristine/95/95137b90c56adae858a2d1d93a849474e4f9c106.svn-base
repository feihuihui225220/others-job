package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZSubscriber entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_subscriber")
public class ZSubscriber implements java.io.Serializable {

	// Fields

	/**
	 * @author DX
	 * 用户订阅的套餐
	 */
	private static final long serialVersionUID = 6658116602123128090L;
	private Integer id;
	private long userId;
	private Integer learnFate;
	private Integer restFate;
	private Integer comboId;
	private Date createAt;
	private boolean availabe;
	private Integer watch;
	private String programIds;

	// Constructors

	/** default constructor */
	public ZSubscriber() {
	}

	/** full constructor */
	public ZSubscriber(long userId, Integer learnFate, Integer restFate,
			Integer comboId, Date createAt, boolean availabe, Integer watch,
			String programIds) {
		this.userId = userId;
		this.learnFate = learnFate;
		this.restFate = restFate;
		this.comboId = comboId;
		this.createAt = createAt;
		this.availabe = availabe;
		this.watch = watch;
		this.programIds = programIds;
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
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "learn_fate")
	public Integer getLearnFate() {
		return this.learnFate;
	}

	public void setLearnFate(Integer learnFate) {
		this.learnFate = learnFate;
	}

	@Column(name = "rest_fate")
	public Integer getRestFate() {
		return this.restFate;
	}

	public void setRestFate(Integer restFate) {
		this.restFate = restFate;
	}

	@Column(name = "combo_id")
	public Integer getComboId() {
		return this.comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

	@Column(name = "create_at", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "availabe")
	public boolean getAvailabe() {
		return this.availabe;
	}

	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}

	@Column(name = "watch")
	public Integer getWatch() {
		return this.watch;
	}

	public void setWatch(Integer watch) {
		this.watch = watch;
	}

	@Column(name = "program_ids", length = 50)
	public String getProgramIds() {
		return this.programIds;
	}

	public void setProgramIds(String programIds) {
		this.programIds = programIds;
	}

}