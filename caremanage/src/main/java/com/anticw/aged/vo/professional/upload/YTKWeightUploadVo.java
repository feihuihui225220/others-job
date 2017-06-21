package com.anticw.aged.vo.professional.upload;


/**
 * 体重数据管理
 * @author bsd
 *
 */
public class YTKWeightUploadVo  extends PublicDataUploadVo {
	 
	/**
	 * 体重数据，类型为float，表示一个单精度浮点数字，单位为kg
	 */
	private float weight;
	 
	public float getBloodsugar() {
		return weight;
	}
	public void setBloodsugar(float weight) {
		this.weight = weight;
	}

}
