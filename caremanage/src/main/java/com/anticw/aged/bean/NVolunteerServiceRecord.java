package  com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


   /**
    * n_volunteer_service_record 志愿者服务记录
    * Mon Sep 07 09:40:46 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_volunteer_service_record")
public class NVolunteerServiceRecord{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "activity_id", nullable = true)
	private int activityId;
	
	@Column(name = "volunteer_id", nullable = true)
	private int volunteerId;
	
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
	
	@Column(name = "service_item", nullable = true)
	private String serviceItem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
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

	public String getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(String serviceItem) {
		this.serviceItem = serviceItem;
	}

	 
}

