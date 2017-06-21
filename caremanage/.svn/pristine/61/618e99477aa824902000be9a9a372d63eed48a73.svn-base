package  com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


   /**
    * n_check_list   签到表
    * Mon Sep 07 09:40:09 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_check_list")
public class NCheckList{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "activity_id", nullable = true)
	private int activityId;
	
	@Column(name = "user_id", nullable = true)
	private int userId;
	
	@Column(name = "pubdate", nullable = true)
	private Date pubdate;
	
	@Column(name = "avaliable", nullable = true)
	private boolean avaliable;
	
	@Column(name = "created_by", nullable = true, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = true)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = true, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = true)
	private Date changedAt;
	
	@Column(name = "version", nullable = true)
	private short version;

	
	public NCheckList() {
	}

	public NCheckList(int activityId, int userId, Date pubdate,
			boolean avaliable, String createdBy, Date createdAt,
			String changedBy, Date changedAt, short version) {
		this.activityId = activityId;
		this.userId = userId;
		this.pubdate = pubdate;
		this.avaliable = avaliable;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.changedBy = changedBy;
		this.changedAt = changedAt;
		this.version = version;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NCheckList [activityId=" + activityId + ", userId=" + userId
				+ ", pubdate=" + pubdate + ", avaliable=" + avaliable
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", version=" + version + "]";
	}
	 
}

