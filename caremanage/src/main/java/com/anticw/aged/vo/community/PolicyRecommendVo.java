package com.anticw.aged.vo.community;

import java.math.BigInteger;
import java.util.List;

import com.anticw.aged.bean.PPolicyRecommend;

public class PolicyRecommendVo {
	
	private int id;
	
	private BigInteger userId;
	
	private String userName;

	private String cardNo;

	private String phone;

	private BigInteger count;
	
	private List<PPolicyRecommend> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public List<PPolicyRecommend> getList() {
		return list;
	}

	public void setList(List<PPolicyRecommend> list) {
		this.list = list;
	}

}
