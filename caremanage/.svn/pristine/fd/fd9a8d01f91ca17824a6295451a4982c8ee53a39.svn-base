package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ZSleep entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_sleep")
public class ZSleep{

	// Fields

	private Long id;
	private Long userId;
	private Date bedtime;
	private Date wakeUpTime;
	private String duration;
	private String durationAnalysis;
	private String quality;
	private String qualityAnalysis;
	private Integer turnFrequency;
	private String turnFrequencyAnlysis;
	private Integer apnea;
	private String apneaAnalysis;
	private Integer breathingRate;
	private String breathingRateAnalysis;
	private Integer heartRate;
	private String heartRateAnalysis;
	private Integer outBed;
	private String outBedAnalysis;
	private String content;
	private Date dataTime;
	private Date createTime;
	private String createUser;
	private Boolean available;

	// Constructors

	/** default constructor */
	public ZSleep() {
	}

	/** full constructor */
	public ZSleep(Long userId, Date bedtime, Date wakeUpTime,
			String duration, String durationAnalysis, String quality,
			String qualityAnalysis, Integer turnFrequency,
			String turnFrequencyAnlysis, Integer apnea, String apneaAnalysis,
			Integer breathingRate, String breathingRateAnalysis,
			Integer heartRate, String heartRateAnalysis, Integer outBed,
			String outBedAnalysis, String content, Date dataTime,
			Date createTime, String createUser, Boolean available) {
		this.userId = userId;
		this.bedtime = bedtime;
		this.wakeUpTime = wakeUpTime;
		this.duration = duration;
		this.durationAnalysis = durationAnalysis;
		this.quality = quality;
		this.qualityAnalysis = qualityAnalysis;
		this.turnFrequency = turnFrequency;
		this.turnFrequencyAnlysis = turnFrequencyAnlysis;
		this.apnea = apnea;
		this.apneaAnalysis = apneaAnalysis;
		this.breathingRate = breathingRate;
		this.breathingRateAnalysis = breathingRateAnalysis;
		this.heartRate = heartRate;
		this.heartRateAnalysis = heartRateAnalysis;
		this.outBed = outBed;
		this.outBedAnalysis = outBedAnalysis;
		this.content = content;
		this.dataTime = dataTime;
		this.createTime = createTime;
		this.createUser = createUser;
		this.available = available;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "bedtime", length = 0)
	public Date getBedtime() {
		return this.bedtime;
	}

	public void setBedtime(Date bedtime) {
		this.bedtime = bedtime;
	}

	@Column(name = "wake_up_time", length = 0)
	public Date getWakeUpTime() {
		return this.wakeUpTime;
	}

	public void setWakeUpTime(Date wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
	}

	@Column(name = "duration", length = 8)
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(name = "duration_analysis")
	public String getDurationAnalysis() {
		return this.durationAnalysis;
	}

	public void setDurationAnalysis(String durationAnalysis) {
		this.durationAnalysis = durationAnalysis;
	}

	@Column(name = "quality", length = 8)
	public String getQuality() {
		return this.quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Column(name = "quality_analysis")
	public String getQualityAnalysis() {
		return this.qualityAnalysis;
	}

	public void setQualityAnalysis(String qualityAnalysis) {
		this.qualityAnalysis = qualityAnalysis;
	}

	@Column(name = "turn_frequency")
	public Integer getTurnFrequency() {
		return this.turnFrequency;
	}

	public void setTurnFrequency(Integer turnFrequency) {
		this.turnFrequency = turnFrequency;
	}

	@Column(name = "turn_frequency_anlysis")
	public String getTurnFrequencyAnlysis() {
		return this.turnFrequencyAnlysis;
	}

	public void setTurnFrequencyAnlysis(String turnFrequencyAnlysis) {
		this.turnFrequencyAnlysis = turnFrequencyAnlysis;
	}

	@Column(name = "apnea")
	public Integer getApnea() {
		return this.apnea;
	}

	public void setApnea(Integer apnea) {
		this.apnea = apnea;
	}

	@Column(name = "apnea_analysis")
	public String getApneaAnalysis() {
		return this.apneaAnalysis;
	}

	public void setApneaAnalysis(String apneaAnalysis) {
		this.apneaAnalysis = apneaAnalysis;
	}

	@Column(name = "breathing_rate")
	public Integer getBreathingRate() {
		return this.breathingRate;
	}

	public void setBreathingRate(Integer breathingRate) {
		this.breathingRate = breathingRate;
	}

	@Column(name = "breathing_rate_analysis")
	public String getBreathingRateAnalysis() {
		return this.breathingRateAnalysis;
	}

	public void setBreathingRateAnalysis(String breathingRateAnalysis) {
		this.breathingRateAnalysis = breathingRateAnalysis;
	}

	@Column(name = "heart_rate")
	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "heart_rate_analysis")
	public String getHeartRateAnalysis() {
		return this.heartRateAnalysis;
	}

	public void setHeartRateAnalysis(String heartRateAnalysis) {
		this.heartRateAnalysis = heartRateAnalysis;
	}

	@Column(name = "out_bed")
	public Integer getOutBed() {
		return this.outBed;
	}

	public void setOutBed(Integer outBed) {
		this.outBed = outBed;
	}

	@Column(name = "out_bed_analysis")
	public String getOutBedAnalysis() {
		return this.outBedAnalysis;
	}

	public void setOutBedAnalysis(String outBedAnalysis) {
		this.outBedAnalysis = outBedAnalysis;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_time", length = 0)
	public Date getDataTime() {
		return this.dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user", length = 16)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}