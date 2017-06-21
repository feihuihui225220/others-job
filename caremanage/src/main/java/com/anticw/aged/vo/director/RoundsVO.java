package com.anticw.aged.vo.director;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class RoundsVO {

	private BigInteger id;
	private BigDecimal ruhu;
	private BigDecimal phone;
	private String  groups;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigDecimal getRuhu() {
		return ruhu;
	}
	public void setRuhu(BigDecimal ruhu) {
		this.ruhu = ruhu;
	}
	public BigDecimal getPhone() {
		return phone;
	}
	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	
	
	
}
