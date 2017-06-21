package com.anticw.aged.vo.professional.assess;
/**
 * 
 * 量表结论筛选vo
 * @author dx  2016-3-23
 *
 */
public class ConclusionScreenVO {

	private Long  userId;
	private Integer  scaleId;
	private Integer  conclusion;
	private String  community;
	private Integer  siteId;
	private String  userName;
	
	public Integer getScaleId() {
		return scaleId;
	}
	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}
	public Integer getConclusion() {
		return conclusion;
	}
	public void setConclusion(Integer conclusion) {
		this.conclusion = conclusion;
	}
	
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
