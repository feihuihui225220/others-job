package  com.anticw.aged.bean;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

   /**
    * n_activity_scheme 实体类 活动方案
    * Mon Sep 07 09:39:30 CST 2015  baishuangdong
    */ 

@Entity
@Table(name = "n_activity_scheme")
public class NActivityScheme{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "program_id", nullable = false)
	private int program_id;
	
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@Column(name = "volunteer_id", nullable = false)
	private int volunteerId;
	
	@Column(name = "pubdate", nullable = false)
	private Date pubdate;
	
	@Column(name = "avaliable", nullable = false)
	private boolean avaliable;
	
	@Column(name = "created_by", nullable = false, length = 40)
	private String createdBy;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "changed_by", nullable = false, length = 40)
	private String changedBy;
	
	@Column(name = "changed_at", nullable = false)
	private Date changedAt;
	
	@Column(name = "version", nullable = false)
	private short version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
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
	 
	
}

