package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 握力原服务
 * @author L
 *
 */
@Document(collection="m_grip")
public class GripPower extends MetaData{
	
	private Float left;
	private Float right;
	/**
	 * @return the left
	 */
	public Float getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(Float left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public Float getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(Float right) {
		this.right = right;
	}
	
	
}
