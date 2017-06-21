/**   

 * @Title: CartVo.java 
 * @Package com.anticw.aged.service.care 
 * @Description: TODO
 * @author ltw   
 * @date 2014年10月3日 下午2:18:57 
 * @version V1.0   
 */
package com.anticw.aged.vo.care;

import java.util.List;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.vo.common.BaseVO;

/**
 * 关爱服务购物车列表Vo
 * 
 * @ClassName: CartVo
 * @Description: TODO
 * @author ltw
 * @date 2014年10月3日 下午2:18:57
 * 
 */
public class CartVO  implements BaseVO{
	/**
	 * 下单用户ID
	 */
	private Long userId;
	/**
	 * 订单所属分类ID
	 */
	private Integer categoryId;
	/**
	 * 提供服务服务商ID
	 */
	private Integer vendorId;

	/**
	 * 订单联系人信息
	 */
	private String contactUser;
	/**
	 * 订单联系人电话
	 */
	private String contactPhone;
	/**
	 * 订单收货人地址
	 */
	private String addr;
	/**
	 * 服务时间
	 */
	private String serviceTime;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 社区id
	 */
	private Long communityId;
	/**
	 * 购买商品集合
	 */
	private List<CartItemVO> cartItemList;
	

	public CartVO() {
		 
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

  

	public List<CartItemVO> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItemVO> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the communityId
	 */
	public Long getCommunityId() {
		return communityId;
	}

	/**
	 * @param communityId the communityId to set
	 */
	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	@Override
	public boolean selfValidate() throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

}
