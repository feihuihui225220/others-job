package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author DX 2016-3-2 活动节目
 *
 */
@Entity
@Table(name = "n_activity_programOfEvents")
public class NactivityProgramOfEvents implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@ManyToOne(optional = true)
	@JoinColumn(name = "plan_id")
	private NActivityPlan nActivityPlan;// 活动Id
	@Column(name = "activeTime")
	private String activeTime;// 活动时间
	@Column(name = "duration")
	private String duration;// 时长
	@Column(name = "teacher_id")
	private Integer teacherId;
	
	@Column(name = "parent_node")
	private Integer parentNode;
	
	@Column(name="progran_id")
	private Integer progranId;
	
	@Column(name = "progran_name")
	private String progranName;
	@Column(name = "keyword")
	private String keyword;
	@Column(name = "activitySuppliesMusic")
	private String activitySuppliesMusic;// 活动用品和音乐

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public NActivityPlan getnActivityPlan() {
		return nActivityPlan;
	}


	public void setnActivityPlan(NActivityPlan nActivityPlan) {
		this.nActivityPlan = nActivityPlan;
	}


	public String getActiveTime() {
		return activeTime;
	}


	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public Integer getParentNode() {
		return parentNode;
	}


	public void setParentNode(Integer parentNode) {
		this.parentNode = parentNode;
	}


	public Integer getProgranId() {
		return progranId;
	}


	public void setProgranId(Integer progranId) {
		this.progranId = progranId;
	}


	public String getProgranName() {
		return progranName;
	}


	public void setProgranName(String progranName) {
		this.progranName = progranName;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getActivitySuppliesMusic() {
		return activitySuppliesMusic;
	}


	public void setActivitySuppliesMusic(String activitySuppliesMusic) {
		this.activitySuppliesMusic = activitySuppliesMusic;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "NactivityProgramOfEvents [id=" + id + ", nActivityPlan="
				+ nActivityPlan + ", activeTime=" + activeTime + ", duration="
				+ duration + ", teacherId=" + teacherId + ", parentNode="
				+ parentNode + ", progranId=" + progranId + ", progranName="
				+ progranName + ", keyword=" + keyword
				+ ", activitySuppliesMusic=" + activitySuppliesMusic + "]";
	}

	
}
