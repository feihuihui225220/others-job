/**
 * 
 */
package com.anticw.aged.vo.community;



/**
 * 用户查询条件VO
 * @author guoyongxiang
 * Date: 2014-9-23
 */
public class RUserSearchVO {

	/** 用户ID */
	private Long id;
	/** 用户名 */
	private String name;
	/** 身份证号 */
	private String idCardNo;
	/** 年龄-开始 */
	private Integer ageStart;
	/** 年龄-截至 */
	private Integer ageEnd;
	/** 户口类型 */
	private Integer hrType;
	/** 居住情况 */
	private Integer lifeCond;
	/** 账户状态 */
	private Integer active;
	
	/** 三无 */
	private Integer three;
	/** 失能 */
	private Integer disable;
	/** 无保障 */
	private Integer noSecurity;
	/** 孤寡 */
	private Integer lonely;
	/** 低保 */
	private Integer lessIncome;
	/** 空巢 */
	private Integer emptyNest;
	/** 失独 */
	private Integer lostOnly;
	/** 优抚 */
	private Integer specialCare;
	/** 独居 */
	private Integer lifeLonely;
	
	
	/**社区id*/
	private String communityId;
	
	/**
	 * 参数校验组装查询条件
	 * @author guoyongxiang
	 * Date: 2014-10-1 下午4:51:58
	 * @param criterions
	 */
	public String verify(){
		StringBuffer bf = new StringBuffer();
		if(!"".equals(this.getName()) && this.getName()!=null){
			bf.append(" and name like '%").append(this.getName()).append("%'");
		}
		if(!"".equals(this.getIdCardNo()) && this.getIdCardNo()!=null){
			bf.append(" and idCardNo like '%").append(this.getIdCardNo()).append("%'");
		}
		if(!"".equals(this.getAgeStart()) && this.getAgeStart()!=null){
			bf.append(" and age>=").append(this.getAgeStart());
		}
		if(!"".equals(this.getAgeEnd()) && this.getAgeEnd()!=null){
			bf.append(" and age<=").append(this.getAgeEnd());
		}
		if(!"".equals(this.getHrType()) && this.getHrType()!=null && !this.getHrType().equals(-1)){
			bf.append(" and hrType=").append(this.getHrType());
		}
		if(!"".equals(this.getLifeCond()) && this.getLifeCond()!=null && !this.getLifeCond().equals(-1)){
			bf.append(" and lifeCond=").append(this.getLifeCond());
		}
		if(!"".equals(this.getActive()) && this.getActive()!=null && !this.getActive().equals(-1)){
			bf.append(" and active=").append(this.getActive());
		}
		// 特殊信息
		if(!"".equals(this.getThree()) && this.getThree()!=null && !this.getThree().equals(-1)){
			bf.append(" and specia.three=").append(this.getThree());
		}
		if(!"".equals(this.getDisable()) && this.getDisable()!=null && !this.getDisable().equals(-1)){
			bf.append(" and specia.disable=").append(this.getDisable());
		}
		if(!"".equals(this.getNoSecurity()) && this.getNoSecurity()!=null && !this.getNoSecurity().equals(-1)){
			bf.append(" and specia.noSecurity=").append(this.getNoSecurity());
		}
		if(!"".equals(this.getLonely()) && this.getLonely()!=null && !this.getLonely().equals(-1)){
			bf.append(" and specia.lonely=").append(this.getLonely());
		}
		if(!"".equals(this.getLessIncome()) && this.getLessIncome()!=null && !this.getLessIncome().equals(-1)){
			bf.append(" and specia.lessIncome=").append(this.getLessIncome());
		}
		if(!"".equals(this.getEmptyNest()) && this.getEmptyNest()!=null && !this.getEmptyNest().equals(-1)){
			bf.append(" and specia.emptyNest=").append(this.getEmptyNest());
		}
		if(!"".equals(this.getLostOnly()) && this.getLostOnly()!=null && !this.getLostOnly().equals(-1)){
			bf.append(" and specia.lostOnly=").append(this.getLostOnly());
		}
		if(!"".equals(this.getSpecialCare()) && this.getSpecialCare()!=null && !this.getSpecialCare().equals(-1)){
			bf.append(" and specia.specialCare=").append(this.getSpecialCare());
		}
		if(!"".equals(this.getLifeLonely()) && this.getLifeLonely()!=null && !this.getLifeLonely().equals(-1)){
			bf.append(" and specia.lifeLonely=").append(this.getLifeLonely());
		}
		return bf.toString();
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the idCardNo
	 */
	public String getIdCardNo() {
		return idCardNo;
	}
	/**
	 * @param idCardNo the idCardNo to set
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	/**
	 * @return the ageStart
	 */
	public Integer getAgeStart() {
		return ageStart;
	}
	/**
	 * @param ageStart the ageStart to set
	 */
	public void setAgeStart(Integer ageStart) {
		this.ageStart = ageStart;
	}
	/**
	 * @return the ageEnd
	 */
	public Integer getAgeEnd() {
		return ageEnd;
	}
	/**
	 * @param ageEnd the ageEnd to set
	 */
	public void setAgeEnd(Integer ageEnd) {
		this.ageEnd = ageEnd;
	}
	/**
	 * @return the hrType
	 */
	public Integer getHrType() {
		return hrType;
	}
	/**
	 * @param hrType the hrType to set
	 */
	public void setHrType(Integer hrType) {
		this.hrType = hrType;
	}
	/**
	 * @return the lifeCond
	 */
	public Integer getLifeCond() {
		return lifeCond;
	}
	/**
	 * @param lifeCond the lifeCond to set
	 */
	public void setLifeCond(Integer lifeCond) {
		this.lifeCond = lifeCond;
	}
	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}
	/**
	 * @return the three
	 */
	public Integer getThree() {
		return three;
	}
	/**
	 * @param three the three to set
	 */
	public void setThree(Integer three) {
		this.three = three;
	}
	/**
	 * @return the disable
	 */
	public Integer getDisable() {
		return disable;
	}
	/**
	 * @param disable the disable to set
	 */
	public void setDisable(Integer disable) {
		this.disable = disable;
	}
	/**
	 * @return the noSecurity
	 */
	public Integer getNoSecurity() {
		return noSecurity;
	}
	/**
	 * @param noSecurity the noSecurity to set
	 */
	public void setNoSecurity(Integer noSecurity) {
		this.noSecurity = noSecurity;
	}
	/**
	 * @return the lonely
	 */
	public Integer getLonely() {
		return lonely;
	}
	/**
	 * @param lonely the lonely to set
	 */
	public void setLonely(Integer lonely) {
		this.lonely = lonely;
	}
	/**
	 * @return the lessIncome
	 */
	public Integer getLessIncome() {
		return lessIncome;
	}
	/**
	 * @param lessIncome the lessIncome to set
	 */
	public void setLessIncome(Integer lessIncome) {
		this.lessIncome = lessIncome;
	}
	/**
	 * @return the emptyNest
	 */
	public Integer getEmptyNest() {
		return emptyNest;
	}
	/**
	 * @param emptyNest the emptyNest to set
	 */
	public void setEmptyNest(Integer emptyNest) {
		this.emptyNest = emptyNest;
	}
	/**
	 * @return the lostOnly
	 */
	public Integer getLostOnly() {
		return lostOnly;
	}
	/**
	 * @param lostOnly the lostOnly to set
	 */
	public void setLostOnly(Integer lostOnly) {
		this.lostOnly = lostOnly;
	}
	/**
	 * @return the specialCare
	 */
	public Integer getSpecialCare() {
		return specialCare;
	}
	/**
	 * @param specialCare the specialCare to set
	 */
	public void setSpecialCare(Integer specialCare) {
		this.specialCare = specialCare;
	}
	/**
	 * @return the lifeLonely
	 */
	public Integer getLifeLonely() {
		return lifeLonely;
	}
	/**
	 * @param lifeLonely the lifeLonely to set
	 */
	public void setLifeLonely(Integer lifeLonely) {
		this.lifeLonely = lifeLonely;
	}

	/**
	 * @return the communityId
	 */
	public String getCommunityId() {
		return communityId;
	}

	/**
	 * @param communityId the communityId to set
	 */
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	
}
