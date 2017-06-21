package com.anticw.aged.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PPolicyRecommend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_policy_recommend", catalog = "")
public class PPolicyRecommend implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long userId;
	private Integer policyId;
    private Integer status;
    //短信发送状态
    private Integer msgSent;
    
    private PPolicy policy;
	// Constructors
    
   
	/** default constructor */
    public PPolicyRecommend(Long userId, Integer policyId, Integer status) {
		this.userId = userId;
		this.policyId = policyId;
		this.status = status;
	}
    public PPolicyRecommend() {
		
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
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "policy_id")
	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@OneToOne
	@JoinColumn(name="policy_id",insertable=false,updatable=false)
	public PPolicy getPolicy() {
		return policy;
	}
	public void setPolicy(PPolicy policy) {
		this.policy = policy;
	}
	/**
	 * @return the msgSent
	 */
	@Column(name = "msg_sent")
	public Integer getMsgSent() {
		return msgSent;
	}
	/**
	 * @param msgSent the msgSent to set
	 */
	public void setMsgSent(Integer msgSent) {
		this.msgSent = msgSent;
	}
	
}